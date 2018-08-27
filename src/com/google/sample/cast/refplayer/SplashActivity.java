package com.google.sample.cast.refplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.google.android.gms.cast.framework.CastContext;

public class SplashActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        findViewById(R.id.finish).setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(SplashActivity.this, VideoBrowserActivity.class));

                finish();
            }
        });

        //1. notification works correctly
        // CastContext.getSharedInstance(this);

        //2. notification would not show
        doNotCallTheMethodInOnCreateSync();
    }

    private void doNotCallTheMethodInOnCreateSync()
    {
        findViewById(R.id.init).setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                CastContext.getSharedInstance(SplashActivity.this);
            }
        });
    }
}
