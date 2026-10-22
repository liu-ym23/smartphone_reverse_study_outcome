package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class o {
    public static void c(long r100) {
        if (r100 < 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("distance cannot be negative but was: " + r100);
    }

    public static void e(boolean r100) {
        com.google.common.base.m.p(r100, "no calls to next() since the last call to remove()");
    }

    public static void a(Object r100, Object r101) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L6;
        return;
    L6:
        throw new NullPointerException("null value in entry: " + r100 + "=null");
    L8:
        throw new NullPointerException("null key in entry: null=" + r101);
    }

    public static void b(int r100, String r101) {
        if (r100 < 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101 + " cannot be negative but was: " + r100);
    }

    public static void d(int r100, String r101) {
        if (r100 <= 0) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101 + " must be positive but was: " + r100);
    }
}
