package com.bytedance.ugc.ugcwidget;

import android.view.View;

/* JADX INFO: loaded from: classes22.dex */
public abstract class UGCOnClickListener implements View.OnClickListener {
    private static final long DEFAULT_INTERVAL = 500;
    private long interval;
    private long timeMillis;

    public abstract void doClick(View r100);

    public UGCOnClickListener() {
        this(500);
    }

    public long getInterval() {
        return this.interval;
    }

    public UGCOnClickListener(long r100) {
        this.interval = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = System.currentTimeMillis();
        if (this.timeMillis >= r101) goto L6;
        this.timeMillis = r101 + this.interval;
        doClick(r100);
        return;
    }

    public void setInterval(long r100) {
        this.interval = r100;
    }
}
