package com.google.common.collect;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class u0 {
    public static int b(int r100) {
        return (int) (((long) Integer.rotateLeft((int) (((long) r100) * (-862048943)), 15)) * 461845907);
    }

    public static int c(@CheckForNull Object r100) {
        if (r100 != null) goto L4;
        int r101 = 0;
    L6:
        return b(r101);
    L4:
        r101 = r100.hashCode();
        goto L6
    }

    public static int a(int r100, double r101) {
        int r102 = Math.max(r100, 2);
        int r103 = Integer.highestOneBit(r102);
        if (r102 <= ((int) (r101 * ((double) r103)))) goto L9;
        int r104 = r103 << 1;
        if (r104 > 0) goto L10;
        return 1073741824;
    L10:
        return r104;
    L9:
        return r103;
    }
}
