package com.google.common.collect;

import javax.annotation.CheckForNull;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class q {
    public static Object a(int r100) {
        if (r100 < 2) goto L19;
        if (r100 > 1073741824) goto L19;
        if (Integer.highestOneBit(r100) != r100) goto L19;
        if (r100 > 256) goto L13;
        return new byte[r100];
    L13:
        if (r100 > 65536) goto L17;
        return new short[r100];
    L17:
        return new int[r100];
    L19:
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + r100);
    }

    public static int e(int r100) {
        return Math.max(4, u0.a(r100 + 1, 1.0d));
    }

    public static int c(Object r100, int r101) {
        if ((r100 instanceof byte[]) == false) goto L7;
        return ((byte[]) r100)[r101] & UByte.MAX_VALUE;
    L7:
        if ((r100 instanceof short[]) == false) goto L11;
        return ((short[]) r100)[r101] & 65535;
    L11:
        return ((int[]) r100)[r101];
    }

    public static void d(Object r100, int r101, int r102) {
        if ((r100 instanceof byte[]) == false) goto L6;
        ((byte[]) r100)[r101] = (byte) r102;
        return;
    L6:
        if ((r100 instanceof short[]) == false) goto L8;
        ((short[]) r100)[r101] = (short) r102;
        return;
    L8:
        ((int[]) r100)[r101] = r102;
    }

    public static int b(@CheckForNull Object r100, @CheckForNull Object r110, int r111, Object r112, int[] r113, Object[] r114, @CheckForNull Object[] r115) {
        int r101 = u0.c(r100);
        int r102 = r101 & r111;
        int r103 = c(r112, r102);
        if (r103 != 0) goto L5;
        return -1;
    L5:
        int r104 = ~r111;
        int r105 = r101 & r104;
        int r106 = -1;
    L6:
        int r107 = r103 - 1;
        int r108 = r113[r107];
        if ((r108 & r104) == r105) goto L9;
    L18:
        int r109 = r108 & r111;
        if (r109 == 0) goto L20;
        r106 = r107;
        r103 = r109;
        goto L6
    L20:
        return -1;
    L9:
        if (com.google.common.base.k.a(r100, r114[r107]) == false) goto L18;
        if (r115 == null) goto L13;
        if (com.google.common.base.k.a(r110, r115[r107]) == false) goto L18;
    L13:
        int r116 = r108 & r111;
        if (r106 != (-1)) goto L16;
        d(r112, r102, r116);
    L17:
        return r107;
    L16:
        r113[r106] = (r116 & r111) | (r113[r106] & r104);
        goto L17
    }
}
