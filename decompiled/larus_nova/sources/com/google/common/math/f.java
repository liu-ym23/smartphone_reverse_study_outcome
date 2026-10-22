package com.google.common.math;

import com.google.common.primitives.Doubles;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class f {
    public static double a(double r100, double r101) {
        if (Doubles.a(r100) == false) goto L6;
        return r101;
    L6:
        if (Doubles.a(r101) == false) goto L8;
        return r100;
    L8:
        if (r100 == r101) goto L13;
        return Double.NaN;
    L13:
        return r100;
    }
}
