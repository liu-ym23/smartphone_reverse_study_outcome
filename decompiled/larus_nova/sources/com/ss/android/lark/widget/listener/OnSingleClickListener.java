package com.ss.android.lark.widget.listener;

import android.os.SystemClock;
import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public abstract class OnSingleClickListener implements View.OnClickListener {
    public static final long LENGTH_LONG = 1000;
    public static final long LENGTH_SHORT = 500;
    private static final String TAG = "OnSingleClickListener";
    private long mLastClickTime;
    private long mMinClickInterval;

    public abstract void onSingleClick(View r100);

    public OnSingleClickListener() {
        this.mMinClickInterval = 500;
    }

    public OnSingleClickListener(long r100) {
        this.mMinClickInterval = r100;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        long r101 = SystemClock.uptimeMillis();
        long r102 = r101 - this.mLastClickTime;
        this.mLastClickTime = r101;
        if (r102 >= this.mMinClickInterval) goto L6;
        Log.i(TAG, "elapsedTime is short than LENGTH_SHORT");
        return;
    L6:
        onSingleClick(r100);
    }
}
