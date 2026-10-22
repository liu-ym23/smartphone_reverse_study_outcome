package com.larus.canvas.feature.component.logic.helper;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f323371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f323372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f323373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f323374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f323375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f323376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f323377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f323378h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile long f323379i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile long f323380j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f323381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f323382l;

    public h(long r100, long r110) {
        this.f323371a = r100;
        this.f323372b = r110;
        this.f323373c = 1577836800000L;
        this.f323374d = 200;
        this.f323375e = 4095;
        this.f323376f = 12;
        this.f323377g = 17;
        this.f323378h = 22;
        this.f323379i = -1;
        this.f323381k = System.currentTimeMillis();
        this.f323382l = SystemClock.elapsedRealtime();
        boolean r101 = true;
        if (0 <= r100) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L20;
        if (0 <= r110) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == false) goto L18;
        return;
    L18:
        throw new IllegalArgumentException("datacenterId out of range 0..31".toString());
    L12:
        if (r110 > 31) goto L14;
    L20:
        throw new IllegalArgumentException("workerId out of range 0..31".toString());
    L5:
        if (r100 > 31) goto L7;
        r102 = true;
        goto L8
    }
}
