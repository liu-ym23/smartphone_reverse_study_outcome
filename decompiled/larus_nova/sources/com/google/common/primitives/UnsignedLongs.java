package com.google.common.primitives;

import com.google.common.base.m;
import java.math.BigInteger;
import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedLongs {

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<long[]> {
        public static final LexicographicalComparator INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LexicographicalComparator[] f275656a = null;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        static {
            LexicographicalComparator r100 = new LexicographicalComparator();
            INSTANCE = r100;
            f275656a = new LexicographicalComparator[]{r100};
        }

        public LexicographicalComparator() {
            super("INSTANCE", 0);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) f275656a.clone();
        }

        public static LexicographicalComparator valueOf(String r100) {
            return (LexicographicalComparator) r27.a.a(LexicographicalComparator.class, r100);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(long[] r100, long[] r101) {
            int r102 = Math.min(r100.length, r101.length);
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L10;
            long r104 = r100[r103];
            long r105 = r101[r103];
            if (r104 != r105) goto L7;
            r103 = r103 + 1;
            goto L3
        L7:
            return UnsignedLongs.a(r104, r105);
        L10:
            return r100.length - r101.length;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(long[] r100, long[] r101) {
            return compare2(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long[] f275657a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int[] f275658b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int[] f275659c = null;

        static {
            f275657a = new long[37];
            f275658b = new int[37];
            f275659c = new int[37];
            BigInteger r100 = new BigInteger("10000000000000000", 16);
            int r101 = 2;
        L4:
            if (r101 > 36) goto L6;
            long r102 = r101;
            f275657a[r101] = UnsignedLongs.b(-1, r102);
            f275658b[r101] = (int) UnsignedLongs.c(-1, r102);
            f275659c[r101] = r100.toString(r101).length() - 1;
            r101 = r101 + 1;
            goto L4
        }
    }

    public static int a(long r100, long r101) {
        long r102 = r100 ^ Long.MIN_VALUE;
        long r103 = r101 ^ Long.MIN_VALUE;
        if (r102 >= r103) goto L5;
        return -1;
    L5:
        if (r102 <= r103) goto L7;
        return 1;
    L7:
        return 0;
    }

    public static long b(long r100, long r101) {
        if (r101 >= 0) goto L10;
        if (a(r100, r101) >= 0) goto L7;
        return 0;
    L7:
        return 1;
    L10:
        if (r100 >= 0) goto L12;
        int r102 = 1;
        long r103 = ((r100 >>> 1) / r101) << 1;
        if (a(r100 - (r103 * r101), r101) >= 0) goto L18;
        r102 = 0;
    L18:
        return r103 + ((long) r102);
    L12:
        return r100 / r101;
    }

    public static long c(long r100, long r101) {
        if (r101 >= 0) goto L10;
        if (a(r100, r101) >= 0) goto L8;
        return r100;
    L8:
        return r100 - r101;
    L10:
        if (r100 >= 0) goto L12;
        long r102 = r100 - ((((r100 >>> 1) / r101) << 1) * r101);
        if (a(r102, r101) >= 0) goto L18;
        r101 = 0;
    L18:
        return r102 - r101;
    L12:
        return r100 % r101;
    }

    public static String d(long r100, int r110) {
        if (r110 >= 2) goto L5;
    L7:
        boolean r101 = false;
    L8:
        m.d(r101, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", r110);
        if (r100 != 0) goto L12;
        return "0";
    L12:
        if (r100 > 0) goto L14;
        int r102 = 64;
        char[] r103 = new char[64];
        int r104 = r110 - 1;
        if ((r110 & r104) != 0) goto L22;
        int r105 = Integer.numberOfTrailingZeros(r110);
    L18:
        r102 = r102 - 1;
        r103[r102] = Character.forDigit(((int) r100) & r104, r110);
        r100 = r100 >>> r105;
        if (r100 != 0) goto L18;
    L31:
        return new String(r103, r102, 64 - r102);
    L22:
        if ((r110 & 1) != 0) goto L24;
        long r106 = (r100 >>> 1) / ((long) (r110 >>> 1));
    L25:
        long r107 = r110;
        int r111 = 63;
        r103[63] = Character.forDigit((int) (r100 - (r106 * r107)), r110);
    L27:
        if (r106 <= 0) goto L29;
        r111 = r111 - 1;
        r103[r111] = Character.forDigit((int) (r106 % r107), r110);
        r106 = r106 / r107;
        goto L27
    L29:
        r102 = r111;
        goto L31
    L24:
        r106 = b(r100, r110);
        goto L25
    L14:
        return Long.toString(r100, r110);
    L5:
        if (r110 > 36) goto L7;
        r101 = true;
        goto L8
    }
}
