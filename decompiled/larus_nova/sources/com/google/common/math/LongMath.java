package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class LongMath {

    public static abstract enum MillerRabinTester extends Enum<MillerRabinTester> {
        public static final MillerRabinTester LARGE = null;
        public static final MillerRabinTester SMALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MillerRabinTester[] f275622a = null;

        public MillerRabinTester() {
            throw null;
        }

        public abstract long mulMod(long r100, long r101, long r102);

        public abstract long squareMod(long r100, long r101);

        static {
            final String r100 = "SMALL";
            final int r101 = 0;
            MillerRabinTester r102 = new AnonymousClass1(r100, r101);
            SMALL = r102;
            final String r103 = "LARGE";
            final int r104 = 1;
            MillerRabinTester r105 = new AnonymousClass2(r103, r104);
            LARGE = r105;
            f275622a = new MillerRabinTester[]{r102, r105};
        }

        public static MillerRabinTester[] values() {
            return (MillerRabinTester[]) f275622a.clone();
        }

        public static MillerRabinTester valueOf(String r100) {
            return (MillerRabinTester) r27.a.a(MillerRabinTester.class, r100);
        }

        public static boolean test(long r210, long r211) {
            if (r211 > 3037000499L) goto L5;
            MillerRabinTester r100 = SMALL;
        L6:
            MillerRabinTester r101 = r100;
            r101.getClass();
            long r110 = 1;
            long r111 = r211 - 1;
            int r112 = Long.numberOfTrailingZeros(r111);
            long r102 = r111 >> r112;
            long r103 = r210 % r211;
            if (r103 == 0) goto L33;
            long r113 = r102;
            long r104 = r103;
            long r105 = 1;
        L11:
            if (r113 == 0) goto L18;
            if ((r113 & r110) == 0) goto L16;
            r105 = r101.mulMod(r105, r104, r211);
        L16:
            r104 = r101.squareMod(r104, r211);
            r113 = r113 >> 1;
            r110 = 1;
            goto L11
        L18:
            if (r105 == r110) goto L34;
            int r106 = 0;
        L22:
            if (r105 == r111) goto L35;
            r106 = r106 + 1;
            if (r106 == r112) goto L25;
            r105 = r101.squareMod(r105, r211);
            goto L22
        L25:
            return false;
        L35:
            return true;
        L34:
            return true;
        L33:
            return true;
        L5:
            r100 = LARGE;
            goto L6
        }

        public MillerRabinTester(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275623a = null;

        static {
            int[] r100 = new int[RoundingMode.values().length];
            f275623a = r100;
            r100[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f275623a[RoundingMode.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f275623a[RoundingMode.FLOOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f275623a[RoundingMode.UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f275623a[RoundingMode.CEILING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f275623a[RoundingMode.HALF_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f275623a[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f275623a[RoundingMode.HALF_EVEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    public static long a(long r110, long r111) {
        long r100 = r110 + r111;
        boolean r101 = true;
        if ((r110 ^ r111) >= 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r110 ^ r100) >= 0) goto L10;
        r101 = false;
    L10:
        e.b(r102 | r101, "checkedAdd", r110, r111);
        return r100;
    L5:
        r102 = false;
        goto L7
    }

    public static long b(long r110, long r111) {
        int r100 = ((Long.numberOfLeadingZeros(r110) + Long.numberOfLeadingZeros(~r110)) + Long.numberOfLeadingZeros(r111)) + Long.numberOfLeadingZeros(~r111);
        if (r100 <= 65) goto L7;
        return r110 * r111;
    L7:
        if (r100 < 64) goto L9;
        boolean r101 = true;
    L10:
        e.b(r101, "checkedMultiply", r110, r111);
        if (r110 < 0) goto L13;
        boolean r102 = true;
    L15:
        if (r111 == Long.MIN_VALUE) goto L17;
        boolean r103 = true;
    L18:
        e.b(r102 | r103, "checkedMultiply", r110, r111);
        long r112 = r110 * r111;
        if (r110 != 0) goto L21;
    L24:
        boolean r104 = true;
    L25:
        e.b(r104, "checkedMultiply", r110, r111);
        return r112;
    L21:
        if ((r112 / r110) == r111) goto L24;
        r104 = false;
        goto L25
    L17:
        r103 = false;
        goto L18
    L13:
        r102 = false;
        goto L15
    L9:
        r101 = false;
        goto L10
    }

    public static long c(long r110, long r111) {
        long r100 = r110 - r111;
        boolean r101 = true;
        if ((r110 ^ r111) < 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r110 ^ r100) >= 0) goto L10;
        r101 = false;
    L10:
        e.b(r102 | r101, "checkedSubtract", r110, r111);
        return r100;
    L5:
        r102 = false;
        goto L7
    }
}
