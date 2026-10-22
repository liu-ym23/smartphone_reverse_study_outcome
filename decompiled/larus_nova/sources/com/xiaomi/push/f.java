package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f463520a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f463521b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f463522c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f463523d = 0;

    static {
        f463520a = a(1, 3);
        f463521b = a(1, 4);
        f463522c = a(2, 0);
        f463523d = a(3, 2);
    }

    public static int a(int r100) {
        return r100 & 7;
    }

    public static int a(int r100, int r101) {
        return (r100 << 3) | r101;
    }

    public static int b(int r100) {
        return r100 >>> 3;
    }
}
