package com.larus.avlink.gallery;

/* JADX INFO: loaded from: classes25.dex */
public final class a {
    public static final double a(double r100) {
        double r101 = 1.0d;
        int r102 = 0;
    L4:
        if (r102 >= 2) goto L7;
        r101 = r101 * ((double) 10);
        r102 = r102 + 1;
        goto L4
    L7:
        return Math.rint(r100 * r101) / r101;
    }
}
