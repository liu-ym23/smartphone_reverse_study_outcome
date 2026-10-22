package zwc;

import androidx.collection.SieveCacheKt;

/* JADX INFO: loaded from: classes41.dex */
public final class d {
    public static int a(long r100, long r101) {
        if (r100 >= r101) goto L6;
        return -1;
    L6:
        if (r100 <= r101) goto L9;
        return 1;
    L9:
        return 0;
    }

    public static int l(long r100) {
        if (r100 > SieveCacheKt.NodeLinkMask) goto L9;
        if (r100 < SieveCacheKt.NodeMetaAndPreviousMask) goto L9;
        return (int) r100;
    L9:
        throw new ArithmeticException("Calculation overflows an int: " + r100);
    }

    public static boolean b(Object r100, Object r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L11;
        return true;
    L11:
        return false;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r100.equals(r101);
    }

    public static long c(long r100, long r101) {
        if (r100 < 0) goto L6;
        return r100 / r101;
    L6:
        return ((r100 + 1) / r101) - 1;
    }

    public static void d(Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r101.concat(" must not be null"));
    }

    public static int e(int r100, int r101) {
        int r102 = r100 + r101;
        if ((r100 ^ r102) < 0) goto L5;
    L9:
        return r102;
    L5:
        if ((r100 ^ r101) < 0) goto L9;
        throw new ArithmeticException("Addition overflows an int: " + r100 + " + " + r101);
    }

    public static long f(long r100, long r101) {
        long r102 = r100 + r101;
        if ((r100 ^ r102) < 0) goto L5;
    L9:
        return r102;
    L5:
        if ((r100 ^ r101) < 0) goto L9;
        throw new ArithmeticException("Addition overflows a long: " + r100 + " + " + r101);
    }

    public static int g(int r100, int r101) {
        long r102 = ((long) r100) * ((long) r101);
        if (r102 < SieveCacheKt.NodeMetaAndPreviousMask) goto L9;
        if (r102 > SieveCacheKt.NodeLinkMask) goto L9;
        return (int) r102;
    L9:
        throw new ArithmeticException("Multiplication overflows an int: " + r100 + " * " + r101);
    }

    public static long h(long r100, int r101) {
        if (r101 == (-1)) goto L16;
        if (r101 != 0) goto L6;
        return 0;
    L6:
        if (r101 == 1) goto L12;
        long r102 = r101;
        long r103 = r100 * r102;
        if ((r103 / r102) != r100) goto L11;
        return r103;
    L11:
        throw new ArithmeticException("Multiplication overflows a long: " + r100 + " * " + r101);
    L12:
        return r100;
    L16:
        if (r100 == Long.MIN_VALUE) goto L20;
        return -r100;
    L20:
        throw new ArithmeticException("Multiplication overflows a long: " + r100 + " * " + r101);
    }

    public static long i(long r100, long r101) {
        if (r101 != 1) goto L6;
        return r100;
    L6:
        if (r100 != 1) goto L9;
        return r101;
    L9:
        if (r100 != 0) goto L11;
    L26:
        return 0;
    L11:
        if (r101 == 0) goto L26;
        long r102 = r100 * r101;
        if ((r102 / r101) != r100) goto L25;
        if (r100 != Long.MIN_VALUE) goto L20;
        if (r101 == (-1)) goto L25;
    L20:
        if (r101 == Long.MIN_VALUE) goto L22;
    L23:
        return r102;
    L22:
        if (r100 != (-1)) goto L23;
    L25:
        throw new ArithmeticException("Multiplication overflows a long: " + r100 + " * " + r101);
    }

    public static int j(int r100, int r101) {
        int r102 = r100 - r101;
        if ((r100 ^ r102) < 0) goto L5;
    L9:
        return r102;
    L5:
        if ((r100 ^ r101) >= 0) goto L9;
        throw new ArithmeticException("Subtraction overflows an int: " + r100 + " - " + r101);
    }

    public static long k(long r100, long r101) {
        long r102 = r100 - r101;
        if ((r100 ^ r102) < 0) goto L5;
    L9:
        return r102;
    L5:
        if ((r100 ^ r101) >= 0) goto L9;
        throw new ArithmeticException("Subtraction overflows a long: " + r100 + " - " + r101);
    }
}
