package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class c {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275626a = null;

        static {
            int[] r100 = new int[RoundingMode.values().length];
            f275626a = r100;
            r100[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f275626a[RoundingMode.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f275626a[RoundingMode.FLOOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f275626a[RoundingMode.UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f275626a[RoundingMode.CEILING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f275626a[RoundingMode.HALF_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f275626a[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f275626a[RoundingMode.HALF_EVEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static int a(int r100, int r101) {
        long r102 = ((long) r100) + ((long) r101);
        int r103 = (int) r102;
        if (r102 != r103) goto L5;
        boolean r104 = true;
    L6:
        e.a(r104, "checkedAdd", r100, r101);
        return r103;
    L5:
        r104 = false;
        goto L6
    }

    public static int b(int r100, int r101) {
        long r102 = ((long) r100) - ((long) r101);
        int r103 = (int) r102;
        if (r102 != r103) goto L5;
        boolean r104 = true;
    L6:
        e.a(r104, "checkedSubtract", r100, r101);
        return r103;
    L5:
        r104 = false;
        goto L6
    }

    public static int d(int r100, RoundingMode r101) {
        if (r100 <= 0) goto L26;
        boolean r102 = true;
        switch(a.f275626a[r101.ordinal()]) {
            case 1: goto L12;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L10;
            case 5: goto L10;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L6;
        };
    L7:
        int r103 = Integer.numberOfLeadingZeros(r100);
        return (31 - r103) + ((~(~(((-1257966797) >>> r103) - r100))) >>> 31);
    L6:
        throw new AssertionError();
    L10:
        return 32 - Integer.numberOfLeadingZeros(r100 - 1);
    L12:
        if (r100 <= 0) goto L14;
        boolean r104 = true;
    L16:
        if (((r100 - 1) & r100) == 0) goto L20;
        r102 = false;
    L20:
        if ((r104 & r102) == true) goto L22;
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    L14:
        r104 = false;
    L22:
        return 31 - Integer.numberOfLeadingZeros(r100);
    L26:
        throw new IllegalArgumentException("x (" + r100 + ") must be > 0");
    }

    public static int c(int r100, int r101, RoundingMode r102) {
        r102.getClass();
        if (r101 == 0) goto L43;
        int r103 = r100 / r101;
        int r104 = r100 - (r101 * r103);
        if (r104 != 0) goto L7;
        return r103;
    L7:
        boolean r105 = true;
        int r106 = ((r100 ^ r101) >> 31) | 1;
        switch(a.f275626a[r102.ordinal()]) {
            case 1: goto L32;
            case 2: goto L36;
            case 3: goto L30;
            case 4: goto L37;
            case 5: goto L28;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        int r107 = Math.abs(r104);
        int r108 = r107 - (Math.abs(r101) - r107);
        if (r108 == 0) goto L14;
        if (r108 <= 0) goto L36;
    L14:
        if (r102 == RoundingMode.HALF_UP) goto L37;
        if (r102 != RoundingMode.HALF_EVEN) goto L18;
        boolean r109 = true;
    L20:
        if ((r103 & 1) == 0) goto L22;
        boolean r110 = true;
    L24:
        if ((r109 & r110) == false) goto L36;
    L22:
        r110 = false;
        goto L24
    L18:
        r109 = false;
        goto L20
    L28:
        if (r106 <= 0) goto L36;
    L30:
        if (r106 >= 0) goto L36;
    L32:
        if (r104 == 0) goto L35;
        r105 = false;
    L35:
        if (r105 == true) goto L36;
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    L36:
        r105 = false;
    L37:
        if (r105 == true) goto L39;
        return r103;
    L39:
        return r103 + r106;
    L10:
        throw new AssertionError();
    L43:
        throw new ArithmeticException("/ by zero");
    }
}
