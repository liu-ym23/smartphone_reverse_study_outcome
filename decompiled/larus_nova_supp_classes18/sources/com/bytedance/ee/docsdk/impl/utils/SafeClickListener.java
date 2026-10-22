package com.bytedance.ee.docsdk.impl.utils;

import android.view.View;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class SafeClickListener implements View.OnClickListener {
    private static final int DEFAULT_SAFE_TIME = 200;
    private static final String TAG = "SafeClickListener";
    private long lastProcessTime;
    private long saveTime;

    public abstract void onClicked(View r1);

    public SafeClickListener() {
        this.saveTime = 200;
    }

    public SafeClickListener(long r1) {
        this.saveTime = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.lastProcessTime;
        this.lastProcessTime = r0;
        if (r2 <= this.saveTime) goto L5;
        onClicked(r6);
        return;
    L5:
        Log.w(TAG, "So fast click , ignored !");
    }
}
