package com.google.common.math;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class e {
    public static void a(boolean r100, String r101, int r102, int r103) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("overflow: " + r101 + "(" + r102 + ", " + r103 + ")");
    }

    public static void b(boolean r100, String r101, long r102, long r103) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("overflow: " + r101 + "(" + r102 + ", " + r103 + ")");
    }
}
