package com.bytedance.ee.bear.drive.view.preview.wps;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p {
    public Runnable a;
    public long b;
    public PointF c;
    public PointF d;
    public final o e;
    public final Handler f;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.drive.view.preview.wps.o] */
    public p() {
        this.f = new Handler(Looper.getMainLooper());
        this.e = new o(this);
    }
}
