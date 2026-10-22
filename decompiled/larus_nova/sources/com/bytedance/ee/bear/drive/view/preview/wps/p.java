package com.bytedance.ee.bear.drive.view.preview.wps;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes16.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f225693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f225694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f225695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PointF f225696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o f225697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f225698f;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.drive.view.preview.wps.o] */
    public p() {
        this.f225698f = new Handler(Looper.getMainLooper());
        this.f225697e = new o(this);
    }
}
