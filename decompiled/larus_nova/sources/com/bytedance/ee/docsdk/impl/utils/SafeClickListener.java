package com.bytedance.ee.docsdk.impl.utils;

import android.view.View;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: classes18.dex */
public abstract class SafeClickListener implements View.OnClickListener {
    private static final int DEFAULT_SAFE_TIME = 200;
    private static final String TAG = "SafeClickListener";
    private long lastProcessTime;
    private long saveTime;

    public abstract void onClicked(View r100);

    public SafeClickListener() {
        this.saveTime = 200;
    }

    public SafeClickListener(long r100) {
        this.saveTime = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = System.currentTimeMillis();
        long r102 = r101 - this.lastProcessTime;
        this.lastProcessTime = r101;
        if (r102 <= this.saveTime) goto L5;
        onClicked(r100);
        return;
    L5:
        Log.w(TAG, "So fast click , ignored !");
    }
}
