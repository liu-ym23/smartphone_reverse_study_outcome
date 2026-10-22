package com.larus.media;

/* JADX INFO: loaded from: classes30.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f359150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f359151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f359152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f359153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f359154e;

    public x(long r110, long r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r110 = System.currentTimeMillis();
    L5:
        long r100 = 0;
        if ((r112 & 2) == 0) goto L8;
        long r101 = -1;
    L10:
        if ((r112 & 4) == 0) goto L12;
        long r102 = -1;
    L14:
        if ((r112 & 8) == 0) goto L17;
        r100 = -1;
    L17:
        if ((r112 & 16) == 0) goto L19;
        r111 = -1;
    L19:
        this.f359150a = r110;
        this.f359151b = r101;
        this.f359152c = r102;
        this.f359153d = r100;
        this.f359154e = r111;
        return;
    L12:
        r102 = 0;
        goto L14
    L8:
        r101 = 0;
        goto L10
    }
}
