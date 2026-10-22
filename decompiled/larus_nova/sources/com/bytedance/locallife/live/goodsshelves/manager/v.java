package com.bytedance.locallife.live.goodsshelves.manager;

/* JADX INFO: loaded from: classes21.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f259753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f259754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f259755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f259756d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f259757e = 0;

    public v() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        int r100 = f259755c + 1;     // Catch: Throwable -> L10
        f259755c = r100;     // Catch: Throwable -> L10
        if (f259754b == 0) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (r100 < f259756d) goto L8;
        f259754b = System.currentTimeMillis();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    static {
        f259753a = new v();
        jv6.h r100 = com.bytedance.locallife.live.settings.c.f();
        if (r100 == null) goto L5;
        int r101 = r100.q();
    L6:
        f259756d = r101;
        jv6.h r102 = com.bytedance.locallife.live.settings.c.f();
        if (r102 == null) goto L9;
        int r103 = r102.p();
    L10:
        f259757e = r103;
        return;
    L9:
        r103 = 20;
        goto L10
    L5:
        r101 = 10;
        goto L6
    }

    public final RetryMode b() {
        if (f259755c >= f259756d) goto L6;
        return RetryMode.NORMAL;
    L6:
        if ((System.currentTimeMillis() - f259754b) < (f259757e * 60000)) goto L20;
        monitor-enter(this);
        f259755c = 0;     // Catch: Throwable -> L14
        f259754b = 0;     // Catch: Throwable -> L14
        monitor-exit(this);
        return RetryMode.NORMAL;
    L14:
        th = move-exception;
        throw th;
    L20:
        return RetryMode.FUSE;
    }

    public final boolean c() {
        if (b() != RetryMode.FUSE) goto L5;
        return true;
    L5:
        return false;
    }
}
