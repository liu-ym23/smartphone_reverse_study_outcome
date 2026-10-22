package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes42.dex */
public class RandUtils {
    public RandUtils() {
    }

    public static int nextInt(SecureRandom r100, int r101) {
        if (((-r101) & r101) == r101) goto L5;
    L6:
        int r102 = r100.nextInt() >>> 1;
        int r103 = r102 % r101;
        if (((r102 - r103) + (r101 - 1)) < 0) goto L6;
        return r103;
    L5:
        return (int) ((((long) r101) * ((long) (r100.nextInt() >>> 1))) >> 31);
    }
}
