package com.google.common.math;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class b {
    public static boolean a(double r100) {
        if (Math.getExponent(r100) > 1023) goto L5;
        return true;
    L5:
        return false;
    }
}
