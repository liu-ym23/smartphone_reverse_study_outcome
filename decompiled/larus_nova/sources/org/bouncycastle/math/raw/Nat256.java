package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Nat256 {
    private static final long M = 4294967295L;

    public Nat256() {
    }

    public static int add(int[] r100, int r110, int[] r111, int r112, int[] r113, int r114) {
        long r101 = ((((long) r100[r110 + 0]) & 4294967295L) + (((long) r111[r112 + 0]) & 4294967295L)) + 0;
        r113[r114 + 0] = (int) r101;
        long r102 = (r101 >>> 32) + ((((long) r100[r110 + 1]) & 4294967295L) + (((long) r111[r112 + 1]) & 4294967295L));
        r113[r114 + 1] = (int) r102;
        long r103 = (r102 >>> 32) + ((((long) r100[r110 + 2]) & 4294967295L) + (((long) r111[r112 + 2]) & 4294967295L));
        r113[r114 + 2] = (int) r103;
        long r104 = (r103 >>> 32) + ((((long) r100[r110 + 3]) & 4294967295L) + (((long) r111[r112 + 3]) & 4294967295L));
        r113[r114 + 3] = (int) r104;
        long r105 = (r104 >>> 32) + ((((long) r100[r110 + 4]) & 4294967295L) + (((long) r111[r112 + 4]) & 4294967295L));
        r113[r114 + 4] = (int) r105;
        long r106 = (r105 >>> 32) + ((((long) r100[r110 + 5]) & 4294967295L) + (((long) r111[r112 + 5]) & 4294967295L));
        r113[r114 + 5] = (int) r106;
        long r107 = (r106 >>> 32) + ((((long) r100[r110 + 6]) & 4294967295L) + (((long) r111[r112 + 6]) & 4294967295L));
        r113[r114 + 6] = (int) r107;
        long r108 = (r107 >>> 32) + ((((long) r100[r110 + 7]) & 4294967295L) + (((long) r111[r112 + 7]) & 4294967295L));
        r113[r114 + 7] = (int) r108;
        return (int) (r108 >>> 32);
    }

    public static int add(int[] r110, int[] r111, int[] r112) {
        long r100 = ((((long) r110[0]) & 4294967295L) + (((long) r111[0]) & 4294967295L)) + 0;
        r112[0] = (int) r100;
        long r101 = (r100 >>> 32) + ((((long) r110[1]) & 4294967295L) + (((long) r111[1]) & 4294967295L));
        r112[1] = (int) r101;
        long r102 = (r101 >>> 32) + ((((long) r110[2]) & 4294967295L) + (((long) r111[2]) & 4294967295L));
        r112[2] = (int) r102;
        long r103 = (r102 >>> 32) + ((((long) r110[3]) & 4294967295L) + (((long) r111[3]) & 4294967295L));
        r112[3] = (int) r103;
        long r104 = (r103 >>> 32) + ((((long) r110[4]) & 4294967295L) + (((long) r111[4]) & 4294967295L));
        r112[4] = (int) r104;
        long r105 = (r104 >>> 32) + ((((long) r110[5]) & 4294967295L) + (((long) r111[5]) & 4294967295L));
        r112[5] = (int) r105;
        long r106 = (r105 >>> 32) + ((((long) r110[6]) & 4294967295L) + (((long) r111[6]) & 4294967295L));
        r112[6] = (int) r106;
        long r107 = (r106 >>> 32) + ((((long) r110[7]) & 4294967295L) + (((long) r111[7]) & 4294967295L));
        r112[7] = (int) r107;
        return (int) (r107 >>> 32);
    }

    public static int addBothTo(int[] r110, int r111, int[] r112, int r113, int[] r114, int r115) {
        long r100 = (((long) r110[r111 + 0]) & 4294967295L) + (((long) r112[r113 + 0]) & 4294967295L);
        int r101 = r115 + 0;
        long r102 = (r100 + (((long) r114[r101]) & 4294967295L)) + 0;
        r114[r101] = (int) r102;
        long r103 = (((long) r110[r111 + 1]) & 4294967295L) + (((long) r112[r113 + 1]) & 4294967295L);
        int r104 = r115 + 1;
        long r105 = (r102 >>> 32) + (r103 + (((long) r114[r104]) & 4294967295L));
        r114[r104] = (int) r105;
        long r106 = (((long) r110[r111 + 2]) & 4294967295L) + (((long) r112[r113 + 2]) & 4294967295L);
        int r107 = r115 + 2;
        long r108 = (r105 >>> 32) + (r106 + (((long) r114[r107]) & 4294967295L));
        r114[r107] = (int) r108;
        long r109 = (((long) r110[r111 + 3]) & 4294967295L) + (((long) r112[r113 + 3]) & 4294967295L);
        int r116 = r115 + 3;
        long r117 = (r108 >>> 32) + (r109 + (((long) r114[r116]) & 4294967295L));
        r114[r116] = (int) r117;
        long r118 = (((long) r110[r111 + 4]) & 4294967295L) + (((long) r112[r113 + 4]) & 4294967295L);
        int r119 = r115 + 4;
        long r120 = (r117 >>> 32) + (r118 + (((long) r114[r119]) & 4294967295L));
        r114[r119] = (int) r120;
        long r121 = (((long) r110[r111 + 5]) & 4294967295L) + (((long) r112[r113 + 5]) & 4294967295L);
        int r122 = r115 + 5;
        long r123 = (r120 >>> 32) + (r121 + (((long) r114[r122]) & 4294967295L));
        r114[r122] = (int) r123;
        long r124 = (((long) r110[r111 + 6]) & 4294967295L) + (((long) r112[r113 + 6]) & 4294967295L);
        int r125 = r115 + 6;
        long r126 = (r123 >>> 32) + (r124 + (((long) r114[r125]) & 4294967295L));
        r114[r125] = (int) r126;
        int r127 = r115 + 7;
        long r128 = (r126 >>> 32) + (((((long) r110[r111 + 7]) & 4294967295L) + (((long) r112[r113 + 7]) & 4294967295L)) + (((long) r114[r127]) & 4294967295L));
        r114[r127] = (int) r128;
        return (int) (r128 >>> 32);
    }

    public static int addBothTo(int[] r110, int[] r111, int[] r112) {
        long r100 = (((((long) r110[0]) & 4294967295L) + (((long) r111[0]) & 4294967295L)) + (((long) r112[0]) & 4294967295L)) + 0;
        r112[0] = (int) r100;
        long r101 = (r100 >>> 32) + (((((long) r110[1]) & 4294967295L) + (((long) r111[1]) & 4294967295L)) + (((long) r112[1]) & 4294967295L));
        r112[1] = (int) r101;
        long r102 = (r101 >>> 32) + (((((long) r110[2]) & 4294967295L) + (((long) r111[2]) & 4294967295L)) + (((long) r112[2]) & 4294967295L));
        r112[2] = (int) r102;
        long r103 = (r102 >>> 32) + (((((long) r110[3]) & 4294967295L) + (((long) r111[3]) & 4294967295L)) + (((long) r112[3]) & 4294967295L));
        r112[3] = (int) r103;
        long r104 = (r103 >>> 32) + (((((long) r110[4]) & 4294967295L) + (((long) r111[4]) & 4294967295L)) + (((long) r112[4]) & 4294967295L));
        r112[4] = (int) r104;
        long r105 = (r104 >>> 32) + (((((long) r110[5]) & 4294967295L) + (((long) r111[5]) & 4294967295L)) + (((long) r112[5]) & 4294967295L));
        r112[5] = (int) r105;
        long r106 = (r105 >>> 32) + (((((long) r110[6]) & 4294967295L) + (((long) r111[6]) & 4294967295L)) + (((long) r112[6]) & 4294967295L));
        r112[6] = (int) r106;
        long r107 = (r106 >>> 32) + (((((long) r110[7]) & 4294967295L) + (((long) r111[7]) & 4294967295L)) + (((long) r112[7]) & 4294967295L));
        r112[7] = (int) r107;
        return (int) (r107 >>> 32);
    }

    public static int addTo(int[] r100, int r110, int[] r111, int r112, int r113) {
        long r101 = ((long) r113) & 4294967295L;
        long r102 = ((long) r100[r110 + 0]) & 4294967295L;
        int r114 = r112 + 0;
        long r103 = r101 + (r102 + (((long) r111[r114]) & 4294967295L));
        r111[r114] = (int) r103;
        int r104 = r112 + 1;
        long r105 = (r103 >>> 32) + ((((long) r100[r110 + 1]) & 4294967295L) + (((long) r111[r104]) & 4294967295L));
        r111[r104] = (int) r105;
        int r106 = r112 + 2;
        long r107 = (r105 >>> 32) + ((((long) r100[r110 + 2]) & 4294967295L) + (((long) r111[r106]) & 4294967295L));
        r111[r106] = (int) r107;
        int r108 = r112 + 3;
        long r109 = (r107 >>> 32) + ((((long) r100[r110 + 3]) & 4294967295L) + (((long) r111[r108]) & 4294967295L));
        r111[r108] = (int) r109;
        int r115 = r112 + 4;
        long r116 = (r109 >>> 32) + ((((long) r100[r110 + 4]) & 4294967295L) + (((long) r111[r115]) & 4294967295L));
        r111[r115] = (int) r116;
        int r117 = r112 + 5;
        long r118 = (r116 >>> 32) + ((((long) r100[r110 + 5]) & 4294967295L) + (((long) r111[r117]) & 4294967295L));
        r111[r117] = (int) r118;
        int r119 = r112 + 6;
        long r120 = (r118 >>> 32) + ((((long) r100[r110 + 6]) & 4294967295L) + (((long) r111[r119]) & 4294967295L));
        r111[r119] = (int) r120;
        int r121 = r112 + 7;
        long r122 = (r120 >>> 32) + ((((long) r100[r110 + 7]) & 4294967295L) + (4294967295L & ((long) r111[r121])));
        r111[r121] = (int) r122;
        return (int) (r122 >>> 32);
    }

    public static int addTo(int[] r110, int[] r111) {
        long r100 = ((((long) r110[0]) & 4294967295L) + (((long) r111[0]) & 4294967295L)) + 0;
        r111[0] = (int) r100;
        long r101 = (r100 >>> 32) + ((((long) r110[1]) & 4294967295L) + (((long) r111[1]) & 4294967295L));
        r111[1] = (int) r101;
        long r102 = (r101 >>> 32) + ((((long) r110[2]) & 4294967295L) + (((long) r111[2]) & 4294967295L));
        r111[2] = (int) r102;
        long r103 = (r102 >>> 32) + ((((long) r110[3]) & 4294967295L) + (((long) r111[3]) & 4294967295L));
        r111[3] = (int) r103;
        long r104 = (r103 >>> 32) + ((((long) r110[4]) & 4294967295L) + (((long) r111[4]) & 4294967295L));
        r111[4] = (int) r104;
        long r105 = (r104 >>> 32) + ((((long) r110[5]) & 4294967295L) + (((long) r111[5]) & 4294967295L));
        r111[5] = (int) r105;
        long r106 = (r105 >>> 32) + ((((long) r110[6]) & 4294967295L) + (((long) r111[6]) & 4294967295L));
        r111[6] = (int) r106;
        long r107 = (r106 >>> 32) + ((((long) r110[7]) & 4294967295L) + (4294967295L & ((long) r111[7])));
        r111[7] = (int) r107;
        return (int) (r107 >>> 32);
    }

    public static int addToEachOther(int[] r110, int r111, int[] r112, int r113) {
        int r100 = r111 + 0;
        int r101 = r113 + 0;
        long r102 = ((((long) r110[r100]) & 4294967295L) + (((long) r112[r101]) & 4294967295L)) + 0;
        int r103 = (int) r102;
        r110[r100] = r103;
        r112[r101] = r103;
        int r104 = r111 + 1;
        int r105 = r113 + 1;
        long r106 = (r102 >>> 32) + ((((long) r110[r104]) & 4294967295L) + (((long) r112[r105]) & 4294967295L));
        int r107 = (int) r106;
        r110[r104] = r107;
        r112[r105] = r107;
        int r108 = r111 + 2;
        int r109 = r113 + 2;
        long r114 = (r106 >>> 32) + ((((long) r110[r108]) & 4294967295L) + (((long) r112[r109]) & 4294967295L));
        int r115 = (int) r114;
        r110[r108] = r115;
        r112[r109] = r115;
        int r116 = r111 + 3;
        int r117 = r113 + 3;
        long r118 = (r114 >>> 32) + ((((long) r110[r116]) & 4294967295L) + (((long) r112[r117]) & 4294967295L));
        int r119 = (int) r118;
        r110[r116] = r119;
        r112[r117] = r119;
        int r120 = r111 + 4;
        int r121 = r113 + 4;
        long r122 = (r118 >>> 32) + ((((long) r110[r120]) & 4294967295L) + (((long) r112[r121]) & 4294967295L));
        int r123 = (int) r122;
        r110[r120] = r123;
        r112[r121] = r123;
        int r124 = r111 + 5;
        int r125 = r113 + 5;
        long r126 = (r122 >>> 32) + ((((long) r110[r124]) & 4294967295L) + (((long) r112[r125]) & 4294967295L));
        int r127 = (int) r126;
        r110[r124] = r127;
        r112[r125] = r127;
        int r128 = r111 + 6;
        int r129 = r113 + 6;
        long r130 = (r126 >>> 32) + ((((long) r110[r128]) & 4294967295L) + (((long) r112[r129]) & 4294967295L));
        int r131 = (int) r130;
        r110[r128] = r131;
        r112[r129] = r131;
        int r132 = r111 + 7;
        int r133 = r113 + 7;
        long r134 = (r130 >>> 32) + ((((long) r110[r132]) & 4294967295L) + (4294967295L & ((long) r112[r133])));
        int r135 = (int) r134;
        r110[r132] = r135;
        r112[r133] = r135;
        return (int) (r134 >>> 32);
    }

    public static void copy(int[] r100, int r101, int[] r102, int r103) {
        r102[r103 + 0] = r100[r101 + 0];
        r102[r103 + 1] = r100[r101 + 1];
        r102[r103 + 2] = r100[r101 + 2];
        r102[r103 + 3] = r100[r101 + 3];
        r102[r103 + 4] = r100[r101 + 4];
        r102[r103 + 5] = r100[r101 + 5];
        r102[r103 + 6] = r100[r101 + 6];
        r102[r103 + 7] = r100[r101 + 7];
    }

    public static void copy(int[] r100, int[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
        r101[4] = r100[4];
        r101[5] = r100[5];
        r101[6] = r100[6];
        r101[7] = r100[7];
    }

    public static void copy64(long[] r100, int r101, long[] r102, int r103) {
        r102[r103 + 0] = r100[r101 + 0];
        r102[r103 + 1] = r100[r101 + 1];
        r102[r103 + 2] = r100[r101 + 2];
        r102[r103 + 3] = r100[r101 + 3];
    }

    public static void copy64(long[] r100, long[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
    }

    public static int[] create() {
        return new int[8];
    }

    public static long[] create64() {
        return new long[4];
    }

    public static int[] createExt() {
        return new int[16];
    }

    public static long[] createExt64() {
        return new long[8];
    }

    public static boolean diff(int[] r100, int r101, int[] r102, int r110, int[] r111, int r112) {
        boolean r103 = gte(r100, r101, r102, r110);
        if (r103 == false) goto L5;
        sub(r100, r101, r102, r110, r111, r112);
    L6:
        return r103;
    L5:
        sub(r102, r110, r100, r101, r111, r112);
        goto L6
    }

    public static boolean eq(int[] r100, int[] r101) {
        int r102 = 7;
    L3:
        if (r102 < 0) goto L9;
        if (r100[r102] != r101[r102]) goto L6;
        r102 = r102 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static boolean eq64(long[] r100, long[] r101) {
        int r102 = 3;
    L3:
        if (r102 < 0) goto L9;
        if (r100[r102] != r101[r102]) goto L6;
        r102 = r102 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static int[] fromBigInteger(BigInteger r100) {
        if (r100.signum() < 0) goto L12;
        if (r100.bitLength() > 256) goto L12;
        int[] r101 = create();
        int r102 = 0;
    L8:
        if (r102 >= 8) goto L10;
        r101[r102] = r100.intValue();
        r100 = r100.shiftRight(32);
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    L12:
        throw new IllegalArgumentException();
    }

    public static long[] fromBigInteger64(BigInteger r100) {
        if (r100.signum() < 0) goto L12;
        if (r100.bitLength() > 256) goto L12;
        long[] r101 = create64();
        int r102 = 0;
    L8:
        if (r102 >= 4) goto L10;
        r101[r102] = r100.longValue();
        r100 = r100.shiftRight(64);
        r102 = r102 + 1;
        goto L8
    L10:
        return r101;
    L12:
        throw new IllegalArgumentException();
    }

    public static int getBit(int[] r100, int r101) {
        if (r101 != 0) goto L8;
        int r102 = r100[0];
    L6:
        return r102 & 1;
    L8:
        if ((r101 & 255) == r101) goto L10;
        return 0;
    L10:
        int r103 = r101 >>> 5;
        int r104 = r100[r103];
        r102 = r104 >>> (r101 & 31);
        goto L6
    }

    public static boolean gte(int[] r100, int r101, int[] r102, int r103) {
        int r104 = 7;
    L4:
        if (r104 < 0) goto L12;
        int r105 = r100[r101 + r104] ^ Integer.MIN_VALUE;
        int r106 = Integer.MIN_VALUE ^ r102[r103 + r104];
        if (r105 < r106) goto L7;
        if (r105 > r106) goto L10;
        r104 = r104 - 1;
        goto L4
    L10:
        return true;
    L7:
        return false;
    L12:
        return true;
    }

    public static boolean gte(int[] r100, int[] r101) {
        int r102 = 7;
    L4:
        if (r102 < 0) goto L12;
        int r103 = r100[r102] ^ Integer.MIN_VALUE;
        int r104 = Integer.MIN_VALUE ^ r101[r102];
        if (r103 < r104) goto L7;
        if (r103 > r104) goto L10;
        r102 = r102 - 1;
        goto L4
    L10:
        return true;
    L7:
        return false;
    L12:
        return true;
    }

    public static boolean isOne(int[] r100) {
        if (r100[0] == 1) goto L5;
        return false;
    L5:
        int r101 = 1;
    L7:
        if (r101 >= 8) goto L12;
        if (r100[r101] != 0) goto L10;
        r101 = r101 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isOne64(long[] r100) {
        if (r100[0] == 1) goto L5;
        return false;
    L5:
        int r101 = 1;
    L7:
        if (r101 >= 4) goto L12;
        if (r100[r101] != 0) goto L10;
        r101 = r101 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isZero(int[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 8) goto L9;
        if (r100[r101] != 0) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static boolean isZero64(long[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 4) goto L9;
        if (r100[r101] != 0) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static void mul(int[] r310, int r311, int[] r312, int r313, int[] r314, int r315) {
        long r100 = ((long) r312[r313 + 0]) & 4294967295L;
        long r101 = ((long) r312[r313 + 1]) & 4294967295L;
        long r102 = ((long) r312[r313 + 2]) & 4294967295L;
        long r103 = ((long) r312[r313 + 3]) & 4294967295L;
        long r110 = ((long) r312[r313 + 4]) & 4294967295L;
        long r111 = ((long) r312[r313 + 5]) & 4294967295L;
        long r112 = ((long) r312[r313 + 6]) & 4294967295L;
        long r113 = ((long) r312[r313 + 7]) & 4294967295L;
        long r114 = ((long) r310[r311 + 0]) & 4294967295L;
        long r104 = (r114 * r100) + 0;
        r314[r315 + 0] = (int) r104;
        long r105 = (r104 >>> 32) + (r114 * r101);
        r314[r315 + 1] = (int) r105;
        long r106 = (r105 >>> 32) + (r114 * r102);
        r314[r315 + 2] = (int) r106;
        long r107 = (r106 >>> 32) + (r114 * r103);
        r314[r315 + 3] = (int) r107;
        long r108 = (r107 >>> 32) + (r114 * r110);
        r314[r315 + 4] = (int) r108;
        long r109 = (r108 >>> 32) + (r114 * r111);
        r314[r315 + 5] = (int) r109;
        long r115 = (r109 >>> 32) + (r114 * r112);
        r314[r315 + 6] = (int) r115;
        long r116 = r113;
        long r117 = (r115 >>> 32) + (r114 * r116);
        r314[r315 + 7] = (int) r117;
        r314[r315 + 8] = (int) (r117 >>> 32);
        int r118 = 1;
        int r119 = r315;
        int r120 = 1;
    L4:
        if (r120 >= 8) goto L6;
        r119 = r119 + r118;
        long r121 = ((long) r310[r311 + r120]) & 4294967295L;
        int r122 = r119 + 0;
        long r123 = ((r121 * r100) + (((long) r314[r122]) & 4294967295L)) + 0;
        int r210 = r120;
        r314[r122] = (int) r123;
        int r124 = r119 + 1;
        long r316 = r116;
        long r125 = (r123 >>> 32) + ((r121 * r101) + (((long) r314[r124]) & 4294967295L));
        r314[r124] = (int) r125;
        int r126 = r119 + 2;
        long r211 = r102;
        long r127 = (r125 >>> 32) + ((r121 * r102) + (((long) r314[r126]) & 4294967295L));
        r314[r126] = (int) r127;
        int r128 = r119 + 3;
        long r129 = (r127 >>> 32) + ((r121 * r103) + (((long) r314[r128]) & 4294967295L));
        r314[r128] = (int) r129;
        int r130 = r119 + 4;
        long r131 = (r129 >>> 32) + ((r121 * r110) + (((long) r314[r130]) & 4294967295L));
        r314[r130] = (int) r131;
        int r132 = r119 + 5;
        long r133 = (r131 >>> 32) + ((r121 * r111) + (((long) r314[r132]) & 4294967295L));
        r314[r132] = (int) r133;
        int r134 = r119 + 6;
        long r135 = (r133 >>> 32) + ((r121 * r112) + (((long) r314[r134]) & 4294967295L));
        r314[r134] = (int) r135;
        int r136 = r119 + 7;
        long r137 = (r135 >>> 32) + ((r121 * r316) + (((long) r314[r136]) & 4294967295L));
        r314[r136] = (int) r137;
        r314[r119 + 8] = (int) (r137 >>> 32);
        r120 = r210 + 1;
        r102 = r211;
        r116 = r316;
        r103 = r103;
        r118 = 1;
        goto L4
    }

    public static void mul(int[] r310, int[] r311, int[] r312) {
        long r100 = ((long) r311[0]) & 4294967295L;
        long r101 = ((long) r311[1]) & 4294967295L;
        long r102 = ((long) r311[2]) & 4294967295L;
        long r110 = ((long) r311[3]) & 4294967295L;
        long r111 = ((long) r311[4]) & 4294967295L;
        long r103 = ((long) r311[5]) & 4294967295L;
        long r112 = ((long) r311[6]) & 4294967295L;
        long r113 = ((long) r311[7]) & 4294967295L;
        long r114 = ((long) r310[0]) & 4294967295L;
        long r104 = (r114 * r100) + 0;
        r312[0] = (int) r104;
        long r105 = (r104 >>> 32) + (r114 * r101);
        r312[1] = (int) r105;
        long r106 = (r105 >>> 32) + (r114 * r102);
        r312[2] = (int) r106;
        long r107 = (r106 >>> 32) + (r114 * r110);
        r312[3] = (int) r107;
        long r108 = (r107 >>> 32) + (r114 * r111);
        r312[4] = (int) r108;
        long r109 = (r108 >>> 32) + (r114 * r103);
        r312[5] = (int) r109;
        long r115 = (r109 >>> 32) + (r114 * r112);
        r312[6] = (int) r115;
        long r116 = (r115 >>> 32) + (r114 * r113);
        r312[7] = (int) r116;
        int r117 = (int) (r116 >>> 32);
        int r118 = 8;
        r312[8] = r117;
        int r119 = 1;
    L3:
        if (r119 >= r118) goto L5;
        long r120 = ((long) r310[r119]) & 4294967295L;
        int r121 = r119 + 0;
        long r210 = r100;
        long r122 = ((r120 * r100) + (((long) r312[r121]) & 4294967295L)) + 0;
        r312[r121] = (int) r122;
        int r123 = r119 + 1;
        long r211 = r101;
        long r124 = (r122 >>> 32) + ((r120 * r101) + (((long) r312[r123]) & 4294967295L));
        r312[r123] = (int) r124;
        int r125 = r119 + 2;
        long r313 = r103;
        long r126 = (r124 >>> 32) + ((r120 * r102) + (((long) r312[r125]) & 4294967295L));
        r312[r125] = (int) r126;
        int r127 = r119 + 3;
        long r128 = (r126 >>> 32) + ((r120 * r110) + (((long) r312[r127]) & 4294967295L));
        r312[r127] = (int) r128;
        int r129 = r119 + 4;
        long r130 = (r128 >>> 32) + ((r120 * r111) + (((long) r312[r129]) & 4294967295L));
        r312[r129] = (int) r130;
        int r131 = r119 + 5;
        long r132 = (r130 >>> 32) + ((r120 * r313) + (((long) r312[r131]) & 4294967295L));
        r312[r131] = (int) r132;
        int r133 = r119 + 6;
        long r134 = (r132 >>> 32) + ((r120 * r112) + (((long) r312[r133]) & 4294967295L));
        r312[r133] = (int) r134;
        int r135 = r119 + 7;
        long r136 = (r134 >>> 32) + ((r120 * r113) + (((long) r312[r135]) & 4294967295L));
        r312[r135] = (int) r136;
        r312[r119 + 8] = (int) (r136 >>> 32);
        r119 = r123;
        r100 = r210;
        r101 = r211;
        r103 = r313;
        r118 = 8;
        goto L3
    }

    public static long mul33Add(int r110, int[] r111, int r112, int[] r113, int r114, int[] r115, int r116) {
        long r100 = ((long) r110) & 4294967295L;
        long r101 = ((long) r111[r112 + 0]) & 4294967295L;
        long r102 = ((r100 * r101) + (((long) r113[r114 + 0]) & 4294967295L)) + 0;
        r115[r116 + 0] = (int) r102;
        long r103 = ((long) r111[r112 + 1]) & 4294967295L;
        long r104 = (r102 >>> 32) + (((r100 * r103) + r101) + (((long) r113[r114 + 1]) & 4294967295L));
        r115[r116 + 1] = (int) r104;
        long r105 = r104 >>> 32;
        long r106 = ((long) r111[r112 + 2]) & 4294967295L;
        long r107 = r105 + (((r100 * r106) + r103) + (((long) r113[r114 + 2]) & 4294967295L));
        r115[r116 + 2] = (int) r107;
        long r108 = ((long) r111[r112 + 3]) & 4294967295L;
        long r109 = (r107 >>> 32) + (((r100 * r108) + r106) + (((long) r113[r114 + 3]) & 4294967295L));
        r115[r116 + 3] = (int) r109;
        long r117 = ((long) r111[r112 + 4]) & 4294967295L;
        long r118 = (r109 >>> 32) + (((r100 * r117) + r108) + (((long) r113[r114 + 4]) & 4294967295L));
        r115[r116 + 4] = (int) r118;
        long r119 = ((long) r111[r112 + 5]) & 4294967295L;
        long r120 = (r118 >>> 32) + (((r100 * r119) + r117) + (((long) r113[r114 + 5]) & 4294967295L));
        r115[r116 + 5] = (int) r120;
        long r121 = ((long) r111[r112 + 6]) & 4294967295L;
        long r122 = (r120 >>> 32) + (((r100 * r121) + r119) + (((long) r113[r114 + 6]) & 4294967295L));
        r115[r116 + 6] = (int) r122;
        long r123 = ((long) r111[r112 + 7]) & 4294967295L;
        long r124 = (r122 >>> 32) + (((r100 * r123) + r121) + (4294967295L & ((long) r113[r114 + 7])));
        r115[r116 + 7] = (int) r124;
        return (r124 >>> 32) + r123;
    }

    public static int mul33DWordAdd(int r110, long r111, int[] r112, int r113) {
        long r100 = ((long) r110) & 4294967295L;
        long r101 = r111 & 4294967295L;
        int r102 = r113 + 0;
        long r103 = ((r100 * r101) + (((long) r112[r102]) & 4294967295L)) + 0;
        r112[r102] = (int) r103;
        long r114 = r111 >>> 32;
        long r104 = (r100 * r114) + r101;
        int r105 = r113 + 1;
        long r106 = (r103 >>> 32) + (r104 + (((long) r112[r105]) & 4294967295L));
        r112[r105] = (int) r106;
        int r107 = r113 + 2;
        long r108 = (r106 >>> 32) + (r114 + (((long) r112[r107]) & 4294967295L));
        r112[r107] = (int) r108;
        int r109 = r113 + 3;
        long r115 = (r108 >>> 32) + (4294967295L & ((long) r112[r109]));
        r112[r109] = (int) r115;
        if ((r115 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return Nat.incAt(8, r112, r113, 4);
    }

    public static int mul33WordAdd(int r110, int r111, int[] r112, int r113) {
        long r100 = ((long) r110) & 4294967295L;
        long r114 = ((long) r111) & 4294967295L;
        int r101 = r113 + 0;
        long r102 = ((r100 * r114) + (((long) r112[r101]) & 4294967295L)) + 0;
        r112[r101] = (int) r102;
        int r103 = r113 + 1;
        long r104 = (r102 >>> 32) + (r114 + (((long) r112[r103]) & 4294967295L));
        r112[r103] = (int) r104;
        long r115 = r104 >>> 32;
        int r105 = r113 + 2;
        long r116 = r115 + (((long) r112[r105]) & 4294967295L);
        r112[r105] = (int) r116;
        if ((r116 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return Nat.incAt(8, r112, r113, 3);
    }

    public static int mulAddTo(int[] r310, int r311, int[] r312, int r313, int[] r314, int r410) {
        long r100 = ((long) r312[r313 + 0]) & 4294967295L;
        long r101 = ((long) r312[r313 + 1]) & 4294967295L;
        long r102 = ((long) r312[r313 + 2]) & 4294967295L;
        long r103 = ((long) r312[r313 + 3]) & 4294967295L;
        long r110 = ((long) r312[r313 + 4]) & 4294967295L;
        long r111 = ((long) r312[r313 + 5]) & 4294967295L;
        long r112 = ((long) r312[r313 + 6]) & 4294967295L;
        long r113 = ((long) r312[r313 + 7]) & 4294967295L;
        int r114 = r410;
        long r210 = 0;
        int r104 = 0;
    L4:
        if (r104 >= 8) goto L7;
        int r211 = r104;
        long r105 = ((long) r310[r311 + r104]) & 4294967295L;
        int r212 = r114 + 0;
        long r213 = r100;
        long r106 = ((r105 * r100) + (((long) r314[r212]) & 4294967295L)) + 0;
        long r214 = r113;
        r314[r212] = (int) r106;
        int r115 = r114 + 1;
        long r107 = (r106 >>> 32) + ((r105 * r101) + (((long) r314[r115]) & 4294967295L));
        r314[r115] = (int) r107;
        int r108 = r114 + 2;
        long r109 = (r107 >>> 32) + ((r105 * r102) + (((long) r314[r108]) & 4294967295L));
        r314[r108] = (int) r109;
        int r116 = r114 + 3;
        long r117 = (r109 >>> 32) + ((r105 * r103) + (((long) r314[r116]) & 4294967295L));
        r314[r116] = (int) r117;
        int r118 = r114 + 4;
        long r119 = (r117 >>> 32) + ((r105 * r110) + (((long) r314[r118]) & 4294967295L));
        r314[r118] = (int) r119;
        int r120 = r114 + 5;
        long r121 = (r119 >>> 32) + ((r105 * r111) + (((long) r314[r120]) & 4294967295L));
        r314[r120] = (int) r121;
        int r122 = r114 + 6;
        long r123 = (r121 >>> 32) + ((r105 * r112) + (((long) r314[r122]) & 4294967295L));
        r314[r122] = (int) r123;
        int r124 = r114 + 7;
        long r125 = (r123 >>> 32) + ((r105 * r214) + (((long) r314[r124]) & 4294967295L));
        r314[r124] = (int) r125;
        int r126 = r114 + 8;
        long r127 = ((r125 >>> 32) + (((long) r314[r126]) & 4294967295L)) + r210;
        r314[r126] = (int) r127;
        r210 = r127 >>> 32;
        r104 = r211 + 1;
        r114 = r115;
        r113 = r214;
        r100 = r213;
        r101 = r101;
        goto L4
    L7:
        return (int) r210;
    }

    public static int mulAddTo(int[] r310, int[] r311, int[] r312) {
        long r100 = ((long) r311[0]) & 4294967295L;
        long r101 = ((long) r311[1]) & 4294967295L;
        long r102 = ((long) r311[2]) & 4294967295L;
        long r103 = ((long) r311[3]) & 4294967295L;
        long r110 = ((long) r311[4]) & 4294967295L;
        long r111 = ((long) r311[5]) & 4294967295L;
        long r104 = ((long) r311[6]) & 4294967295L;
        long r105 = ((long) r311[7]) & 4294967295L;
        long r210 = 0;
        int r106 = 0;
    L4:
        if (r106 >= 8) goto L7;
        long r211 = r105;
        long r107 = ((long) r310[r106]) & 4294967295L;
        int r212 = r106 + 0;
        long r213 = r111;
        long r112 = ((r107 * r100) + (((long) r312[r212]) & 4294967295L)) + 0;
        r312[r212] = (int) r112;
        int r113 = r106 + 1;
        long r313 = r101;
        long r114 = (r112 >>> 32) + ((r107 * r101) + (((long) r312[r113]) & 4294967295L));
        r312[r113] = (int) r114;
        int r108 = r106 + 2;
        long r115 = (r114 >>> 32) + ((r107 * r102) + (((long) r312[r108]) & 4294967295L));
        r312[r108] = (int) r115;
        int r109 = r106 + 3;
        long r116 = (r115 >>> 32) + ((r107 * r103) + (((long) r312[r109]) & 4294967295L));
        r312[r109] = (int) r116;
        int r117 = r106 + 4;
        long r118 = (r116 >>> 32) + ((r107 * r110) + (((long) r312[r117]) & 4294967295L));
        r312[r117] = (int) r118;
        int r119 = r106 + 5;
        long r120 = (r118 >>> 32) + ((r107 * r213) + (((long) r312[r119]) & 4294967295L));
        r312[r119] = (int) r120;
        int r121 = r106 + 6;
        long r122 = (r120 >>> 32) + ((r107 * r104) + (((long) r312[r121]) & 4294967295L));
        r312[r121] = (int) r122;
        int r123 = r106 + 7;
        long r124 = (r122 >>> 32) + ((r107 * r211) + (((long) r312[r123]) & 4294967295L));
        r312[r123] = (int) r124;
        int r125 = r106 + 8;
        long r126 = ((r124 >>> 32) + (((long) r312[r125]) & 4294967295L)) + r210;
        r312[r125] = (int) r126;
        r210 = r126 >>> 32;
        r106 = r113;
        r105 = r211;
        r111 = r213;
        r101 = r313;
        goto L4
    L7:
        return (int) r210;
    }

    public static int mulByWord(int r100, int[] r110) {
        long r101 = ((long) r100) & 4294967295L;
        long r102 = ((((long) r110[0]) & 4294967295L) * r101) + 0;
        r110[0] = (int) r102;
        long r103 = (r102 >>> 32) + ((((long) r110[1]) & 4294967295L) * r101);
        r110[1] = (int) r103;
        long r104 = (r103 >>> 32) + ((((long) r110[2]) & 4294967295L) * r101);
        r110[2] = (int) r104;
        long r105 = (r104 >>> 32) + ((((long) r110[3]) & 4294967295L) * r101);
        r110[3] = (int) r105;
        long r106 = (r105 >>> 32) + ((((long) r110[4]) & 4294967295L) * r101);
        r110[4] = (int) r106;
        long r107 = (r106 >>> 32) + ((((long) r110[5]) & 4294967295L) * r101);
        r110[5] = (int) r107;
        long r108 = (r107 >>> 32) + ((((long) r110[6]) & 4294967295L) * r101);
        r110[6] = (int) r108;
        long r109 = (r108 >>> 32) + (r101 * (4294967295L & ((long) r110[7])));
        r110[7] = (int) r109;
        return (int) (r109 >>> 32);
    }

    public static int mulByWordAddTo(int r110, int[] r111, int[] r112) {
        long r100 = ((long) r110) & 4294967295L;
        long r101 = (((((long) r112[0]) & 4294967295L) * r100) + (((long) r111[0]) & 4294967295L)) + 0;
        r112[0] = (int) r101;
        long r102 = (r101 >>> 32) + (((((long) r112[1]) & 4294967295L) * r100) + (((long) r111[1]) & 4294967295L));
        r112[1] = (int) r102;
        long r103 = (r102 >>> 32) + (((((long) r112[2]) & 4294967295L) * r100) + (((long) r111[2]) & 4294967295L));
        r112[2] = (int) r103;
        long r104 = (r103 >>> 32) + (((((long) r112[3]) & 4294967295L) * r100) + (((long) r111[3]) & 4294967295L));
        r112[3] = (int) r104;
        long r105 = (r104 >>> 32) + (((((long) r112[4]) & 4294967295L) * r100) + (((long) r111[4]) & 4294967295L));
        r112[4] = (int) r105;
        long r106 = (r105 >>> 32) + (((((long) r112[5]) & 4294967295L) * r100) + (((long) r111[5]) & 4294967295L));
        r112[5] = (int) r106;
        long r107 = (r106 >>> 32) + (((((long) r112[6]) & 4294967295L) * r100) + (((long) r111[6]) & 4294967295L));
        r112[6] = (int) r107;
        long r108 = (r107 >>> 32) + ((r100 * (((long) r112[7]) & 4294967295L)) + (4294967295L & ((long) r111[7])));
        r112[7] = (int) r108;
        return (int) (r108 >>> 32);
    }

    public static int mulWord(int r100, int[] r101, int[] r110, int r111) {
        long r102 = ((long) r100) & 4294967295L;
        long r103 = 0;
        int r104 = 0;
    L3:
        long r105 = r103 + ((((long) r101[r104]) & 4294967295L) * r102);
        r110[r111 + r104] = (int) r105;
        r103 = r105 >>> 32;
        r104 = r104 + 1;
        if (r104 < 8) goto L3;
        return (int) r103;
    }

    public static int mulWordAddTo(int r110, int[] r111, int r112, int[] r113, int r114) {
        long r100 = ((long) r110) & 4294967295L;
        long r101 = (((long) r111[r112 + 0]) & 4294967295L) * r100;
        int r115 = r114 + 0;
        long r102 = (r101 + (((long) r113[r115]) & 4294967295L)) + 0;
        r113[r115] = (int) r102;
        int r103 = r114 + 1;
        long r104 = (r102 >>> 32) + (((((long) r111[r112 + 1]) & 4294967295L) * r100) + (((long) r113[r103]) & 4294967295L));
        r113[r103] = (int) r104;
        int r105 = r114 + 2;
        long r106 = (r104 >>> 32) + (((((long) r111[r112 + 2]) & 4294967295L) * r100) + (((long) r113[r105]) & 4294967295L));
        r113[r105] = (int) r106;
        int r107 = r114 + 3;
        long r108 = (r106 >>> 32) + (((((long) r111[r112 + 3]) & 4294967295L) * r100) + (((long) r113[r107]) & 4294967295L));
        r113[r107] = (int) r108;
        int r109 = r114 + 4;
        long r116 = (r108 >>> 32) + (((((long) r111[r112 + 4]) & 4294967295L) * r100) + (((long) r113[r109]) & 4294967295L));
        r113[r109] = (int) r116;
        int r117 = r114 + 5;
        long r118 = (r116 >>> 32) + (((((long) r111[r112 + 5]) & 4294967295L) * r100) + (((long) r113[r117]) & 4294967295L));
        r113[r117] = (int) r118;
        int r119 = r114 + 6;
        long r120 = (r118 >>> 32) + (((((long) r111[r112 + 6]) & 4294967295L) * r100) + (((long) r113[r119]) & 4294967295L));
        r113[r119] = (int) r120;
        int r121 = r114 + 7;
        long r122 = (r120 >>> 32) + ((r100 * (((long) r111[r112 + 7]) & 4294967295L)) + (((long) r113[r121]) & 4294967295L));
        r113[r121] = (int) r122;
        return (int) (r122 >>> 32);
    }

    public static int mulWordDwordAdd(int r110, long r111, int[] r112, int r113) {
        long r100 = ((long) r110) & 4294967295L;
        int r114 = r113 + 0;
        long r101 = (((r111 & 4294967295L) * r100) + (((long) r112[r114]) & 4294967295L)) + 0;
        r112[r114] = (int) r101;
        long r102 = r100 * (r111 >>> 32);
        int r115 = r113 + 1;
        long r103 = (r101 >>> 32) + (r102 + (((long) r112[r115]) & 4294967295L));
        r112[r115] = (int) r103;
        int r104 = r113 + 2;
        long r116 = (r103 >>> 32) + (((long) r112[r104]) & 4294967295L);
        r112[r104] = (int) r116;
        if ((r116 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return Nat.incAt(8, r112, r113, 3);
    }

    public static void square(int[] r410, int r411, int[] r510, int r511) {
        long r100 = ((long) r410[r411 + 0]) & 4294967295L;
        int r101 = 0;
        int r102 = 16;
        int r103 = 7;
    L3:
        int r104 = r103 - 1;
        long r105 = ((long) r410[r411 + r103]) & 4294967295L;
        long r106 = r105 * r105;
        int r107 = r102 - 1;
        r510[r511 + r107] = (r101 << 31) | ((int) (r106 >>> 33));
        r102 = r107 - 1;
        r510[r511 + r102] = (int) (r106 >>> 1);
        r101 = (int) r106;
        if (r104 <= 0) goto L5;
        r103 = r104;
        goto L3
    L5:
        long r108 = r100 * r100;
        long r110 = (r108 >>> 33) | (((long) (r101 << 31)) & 4294967295L);
        r510[r511 + 0] = (int) r108;
        int r109 = ((int) (r108 >>> 32)) & 1;
        long r111 = ((long) r410[r411 + 1]) & 4294967295L;
        int r112 = r511 + 2;
        long r113 = ((long) r510[r112]) & 4294967295L;
        long r114 = r110 + (r111 * r100);
        int r115 = (int) r114;
        r510[r511 + 1] = (r115 << 1) | r109;
        int r116 = r115 >>> 31;
        long r117 = r113 + (r114 >>> 32);
        long r118 = ((long) r410[r411 + 2]) & 4294967295L;
        int r119 = r511 + 3;
        long r120 = ((long) r510[r119]) & 4294967295L;
        int r121 = r511 + 4;
        long r122 = ((long) r510[r121]) & 4294967295L;
        long r123 = r117 + (r118 * r100);
        int r124 = (int) r123;
        r510[r112] = (r124 << 1) | r116;
        long r125 = r120 + ((r123 >>> 32) + (r118 * r111));
        long r126 = r122 + (r125 >>> 32);
        long r127 = ((long) r410[r411 + 3]) & 4294967295L;
        int r210 = r511 + 5;
        long r128 = (((long) r510[r210]) & 4294967295L) + (r126 >>> 32);
        long r129 = r126 & 4294967295L;
        int r211 = r511 + 6;
        long r130 = (((long) r510[r211]) & 4294967295L) + (r128 >>> 32);
        long r131 = (r125 & 4294967295L) + (r127 * r100);
        int r132 = (int) r131;
        r510[r119] = (r132 << 1) | (r124 >>> 31);
        long r133 = r129 + ((r131 >>> 32) + (r127 * r111));
        long r134 = (r128 & 4294967295L) + ((r133 >>> 32) + (r127 * r118));
        long r135 = r130 + (r134 >>> 32);
        long r136 = r134 & 4294967295L;
        long r137 = ((long) r410[r411 + 4]) & 4294967295L;
        int r138 = r511 + 7;
        long r139 = (((long) r510[r138]) & 4294967295L) + (r135 >>> 32);
        int r140 = r511 + 8;
        long r141 = (((long) r510[r140]) & 4294967295L) + (r139 >>> 32);
        long r142 = (r133 & 4294967295L) + (r137 * r100);
        int r143 = (int) r142;
        r510[r121] = (r143 << 1) | (r132 >>> 31);
        int r144 = r143 >>> 31;
        long r145 = r136 + ((r142 >>> 32) + (r137 * r111));
        long r146 = (r135 & 4294967295L) + ((r145 >>> 32) + (r137 * r118));
        long r147 = (r139 & 4294967295L) + ((r146 >>> 32) + (r137 * r127));
        long r148 = r141 + (r147 >>> 32);
        long r149 = r147 & 4294967295L;
        long r150 = ((long) r410[r411 + 5]) & 4294967295L;
        int r151 = r511 + 9;
        long r152 = (((long) r510[r151]) & 4294967295L) + (r148 >>> 32);
        long r153 = r148 & 4294967295L;
        int r212 = r511 + 10;
        long r154 = (((long) r510[r212]) & 4294967295L) + (r152 >>> 32);
        long r155 = (r145 & 4294967295L) + (r150 * r100);
        int r156 = (int) r155;
        r510[r210] = (r156 << 1) | r144;
        int r157 = r156 >>> 31;
        long r158 = (r146 & 4294967295L) + ((r155 >>> 32) + (r150 * r111));
        long r159 = r149 + ((r158 >>> 32) + (r150 * r118));
        long r213 = r153 + ((r159 >>> 32) + (r150 * r127));
        long r160 = (r152 & 4294967295L) + ((r213 >>> 32) + (r150 * r137));
        long r161 = r154 + (r160 >>> 32);
        long r162 = r160 & 4294967295L;
        long r163 = ((long) r410[r411 + 6]) & 4294967295L;
        int r164 = r511 + 11;
        long r165 = (((long) r510[r164]) & 4294967295L) + (r161 >>> 32);
        long r166 = r161 & 4294967295L;
        int r214 = r511 + 12;
        long r167 = (((long) r510[r214]) & 4294967295L) + (r165 >>> 32);
        long r168 = (r158 & 4294967295L) + (r163 * r100);
        int r169 = (int) r168;
        r510[r211] = (r169 << 1) | r157;
        int r170 = r169 >>> 31;
        long r171 = (r159 & 4294967295L) + ((r168 >>> 32) + (r163 * r111));
        long r310 = (r213 & 4294967295L) + ((r171 >>> 32) + (r163 * r118));
        long r215 = r162 + ((r310 >>> 32) + (r163 * r127));
        long r216 = r310 & 4294967295L;
        long r311 = r166 + ((r215 >>> 32) + (r163 * r137));
        long r172 = (r165 & 4294967295L) + ((r311 >>> 32) + (r163 * r150));
        long r173 = r167 + (r172 >>> 32);
        long r174 = r172 & 4294967295L;
        long r175 = ((long) r410[r411 + 7]) & 4294967295L;
        int r176 = r511 + 13;
        long r177 = (((long) r510[r176]) & 4294967295L) + (r173 >>> 32);
        long r178 = r173 & 4294967295L;
        int r217 = r511 + 14;
        long r179 = (((long) r510[r217]) & 4294967295L) + (r177 >>> 32);
        long r180 = 4294967295L & r177;
        long r181 = (r171 & 4294967295L) + (r100 * r175);
        int r182 = (int) r181;
        r510[r138] = (r182 << 1) | r170;
        long r183 = r216 + ((r181 >>> 32) + (r111 * r175));
        long r184 = (r215 & 4294967295L) + ((r183 >>> 32) + (r175 * r118));
        long r185 = (r311 & 4294967295L) + ((r184 >>> 32) + (r175 * r127));
        long r186 = r174 + ((r185 >>> 32) + (r175 * r137));
        long r187 = r178 + ((r186 >>> 32) + (r175 * r150));
        long r188 = r180 + ((r187 >>> 32) + (r175 * r163));
        long r189 = r179 + (r188 >>> 32);
        int r190 = (int) r183;
        r510[r140] = (r182 >>> 31) | (r190 << 1);
        int r191 = (int) r184;
        r510[r151] = (r190 >>> 31) | (r191 << 1);
        int r192 = r191 >>> 31;
        int r193 = (int) r185;
        r510[r212] = r192 | (r193 << 1);
        int r194 = (int) r186;
        r510[r164] = (r193 >>> 31) | (r194 << 1);
        int r195 = (int) r187;
        r510[r214] = (r194 >>> 31) | (r195 << 1);
        int r196 = r195 >>> 31;
        int r197 = (int) r188;
        r510[r176] = r196 | (r197 << 1);
        int r198 = r197 >>> 31;
        int r199 = (int) r189;
        r510[r217] = r198 | (r199 << 1);
        int r200 = r199 >>> 31;
        int r201 = r511 + 15;
        r510[r201] = r200 | ((r510[r201] + ((int) (r189 >>> 32))) << 1);
    }

    public static void square(int[] r410, int[] r411) {
        long r100 = ((long) r410[0]) & 4294967295L;
        int r101 = 16;
        int r102 = 7;
        int r103 = 0;
    L3:
        int r104 = r102 - 1;
        long r110 = ((long) r410[r102]) & 4294967295L;
        long r111 = r110 * r110;
        int r105 = r101 - 1;
        r411[r105] = (r103 << 31) | ((int) (r111 >>> 33));
        r101 = r105 - 1;
        r411[r101] = (int) (r111 >>> 1);
        int r112 = (int) r111;
        if (r104 <= 0) goto L5;
        r102 = r104;
        r103 = r112;
        goto L3
    L5:
        long r106 = r100 * r100;
        r411[0] = (int) r106;
        long r107 = ((long) r410[1]) & 4294967295L;
        long r113 = ((long) r411[2]) & 4294967295L;
        long r114 = ((((long) (r112 << 31)) & 4294967295L) | (r106 >>> 33)) + (r107 * r100);
        int r115 = (int) r114;
        r411[1] = (r115 << 1) | (((int) (r106 >>> 32)) & 1);
        int r108 = r115 >>> 31;
        long r116 = r113 + (r114 >>> 32);
        long r117 = ((long) r410[2]) & 4294967295L;
        long r109 = ((long) r411[3]) & 4294967295L;
        long r118 = ((long) r411[4]) & 4294967295L;
        long r119 = r116 + (r117 * r100);
        int r120 = (int) r119;
        r411[2] = (r120 << 1) | r108;
        long r121 = r109 + ((r119 >>> 32) + (r117 * r107));
        long r122 = r118 + (r121 >>> 32);
        long r123 = ((long) r410[3]) & 4294967295L;
        long r124 = (((long) r411[5]) & 4294967295L) + (r122 >>> 32);
        long r125 = r122 & 4294967295L;
        long r126 = (((long) r411[6]) & 4294967295L) + (r124 >>> 32);
        long r127 = (r121 & 4294967295L) + (r123 * r100);
        int r128 = (int) r127;
        r411[3] = (r128 << 1) | (r120 >>> 31);
        int r129 = r128 >>> 31;
        long r130 = r125 + ((r127 >>> 32) + (r123 * r107));
        long r131 = (r124 & 4294967295L) + ((r130 >>> 32) + (r123 * r117));
        long r132 = r126 + (r131 >>> 32);
        long r133 = ((long) r410[4]) & 4294967295L;
        long r134 = (((long) r411[7]) & 4294967295L) + (r132 >>> 32);
        long r135 = r132 & 4294967295L;
        long r136 = (((long) r411[8]) & 4294967295L) + (r134 >>> 32);
        long r137 = (r130 & 4294967295L) + (r133 * r100);
        int r138 = (int) r137;
        r411[4] = (r138 << 1) | r129;
        long r139 = (r131 & 4294967295L) + ((r137 >>> 32) + (r133 * r107));
        long r140 = r135 + ((r139 >>> 32) + (r133 * r117));
        long r141 = (r134 & 4294967295L) + ((r140 >>> 32) + (r133 * r123));
        long r142 = r136 + (r141 >>> 32);
        long r143 = r141 & 4294967295L;
        long r144 = ((long) r410[5]) & 4294967295L;
        long r145 = (((long) r411[9]) & 4294967295L) + (r142 >>> 32);
        long r146 = r142 & 4294967295L;
        long r147 = (((long) r411[10]) & 4294967295L) + (r145 >>> 32);
        long r148 = (r139 & 4294967295L) + (r144 * r100);
        int r149 = (int) r148;
        r411[5] = (r149 << 1) | (r138 >>> 31);
        long r150 = (r140 & 4294967295L) + ((r148 >>> 32) + (r144 * r107));
        long r151 = r143 + ((r150 >>> 32) + (r144 * r117));
        long r310 = r146 + ((r151 >>> 32) + (r144 * r123));
        long r152 = (r145 & 4294967295L) + ((r310 >>> 32) + (r144 * r133));
        long r153 = r147 + (r152 >>> 32);
        long r154 = r152 & 4294967295L;
        long r155 = ((long) r410[6]) & 4294967295L;
        long r156 = (((long) r411[11]) & 4294967295L) + (r153 >>> 32);
        long r157 = r153 & 4294967295L;
        long r158 = (((long) r411[12]) & 4294967295L) + (r156 >>> 32);
        long r159 = (r150 & 4294967295L) + (r155 * r100);
        int r160 = (int) r159;
        r411[6] = (r160 << 1) | (r149 >>> 31);
        long r161 = (r151 & 4294967295L) + ((r159 >>> 32) + (r155 * r107));
        long r311 = (r310 & 4294967295L) + ((r161 >>> 32) + (r155 * r117));
        long r162 = r161 & 4294967295L;
        long r163 = r154 + ((r311 >>> 32) + (r155 * r123));
        long r312 = r157 + ((r163 >>> 32) + (r155 * r133));
        long r164 = (r156 & 4294967295L) + ((r312 >>> 32) + (r155 * r144));
        long r165 = r158 + (r164 >>> 32);
        long r166 = r164 & 4294967295L;
        long r167 = ((long) r410[7]) & 4294967295L;
        long r168 = (((long) r411[13]) & 4294967295L) + (r165 >>> 32);
        long r169 = r165 & 4294967295L;
        long r170 = (((long) r411[14]) & 4294967295L) + (r168 >>> 32);
        long r171 = 4294967295L & r168;
        long r172 = r162 + (r100 * r167);
        int r173 = (int) r172;
        r411[7] = (r160 >>> 31) | (r173 << 1);
        int r174 = r173 >>> 31;
        long r175 = (r311 & 4294967295L) + ((r172 >>> 32) + (r167 * r107));
        long r176 = (r163 & 4294967295L) + ((r175 >>> 32) + (r167 * r117));
        long r177 = (r312 & 4294967295L) + ((r176 >>> 32) + (r167 * r123));
        long r178 = r166 + ((r177 >>> 32) + (r167 * r133));
        long r179 = r169 + ((r178 >>> 32) + (r167 * r144));
        long r180 = r171 + ((r179 >>> 32) + (r167 * r155));
        long r181 = r170 + (r180 >>> 32);
        int r182 = (int) r175;
        r411[8] = r174 | (r182 << 1);
        int r183 = (int) r176;
        r411[9] = (r182 >>> 31) | (r183 << 1);
        int r184 = r183 >>> 31;
        int r185 = (int) r177;
        r411[10] = r184 | (r185 << 1);
        int r186 = (int) r178;
        r411[11] = (r185 >>> 31) | (r186 << 1);
        int r187 = (int) r179;
        r411[12] = (r186 >>> 31) | (r187 << 1);
        int r188 = r187 >>> 31;
        int r189 = (int) r180;
        r411[13] = r188 | (r189 << 1);
        int r190 = r189 >>> 31;
        int r191 = (int) r181;
        r411[14] = r190 | (r191 << 1);
        r411[15] = (r191 >>> 31) | ((r411[15] + ((int) (r181 >>> 32))) << 1);
    }

    public static int sub(int[] r100, int r110, int[] r111, int r112, int[] r113, int r114) {
        long r101 = ((((long) r100[r110 + 0]) & 4294967295L) - (((long) r111[r112 + 0]) & 4294967295L)) + 0;
        r113[r114 + 0] = (int) r101;
        long r102 = (r101 >> 32) + ((((long) r100[r110 + 1]) & 4294967295L) - (((long) r111[r112 + 1]) & 4294967295L));
        r113[r114 + 1] = (int) r102;
        long r103 = (r102 >> 32) + ((((long) r100[r110 + 2]) & 4294967295L) - (((long) r111[r112 + 2]) & 4294967295L));
        r113[r114 + 2] = (int) r103;
        long r104 = (r103 >> 32) + ((((long) r100[r110 + 3]) & 4294967295L) - (((long) r111[r112 + 3]) & 4294967295L));
        r113[r114 + 3] = (int) r104;
        long r105 = (r104 >> 32) + ((((long) r100[r110 + 4]) & 4294967295L) - (((long) r111[r112 + 4]) & 4294967295L));
        r113[r114 + 4] = (int) r105;
        long r106 = (r105 >> 32) + ((((long) r100[r110 + 5]) & 4294967295L) - (((long) r111[r112 + 5]) & 4294967295L));
        r113[r114 + 5] = (int) r106;
        long r107 = (r106 >> 32) + ((((long) r100[r110 + 6]) & 4294967295L) - (((long) r111[r112 + 6]) & 4294967295L));
        r113[r114 + 6] = (int) r107;
        long r108 = (r107 >> 32) + ((((long) r100[r110 + 7]) & 4294967295L) - (((long) r111[r112 + 7]) & 4294967295L));
        r113[r114 + 7] = (int) r108;
        return (int) (r108 >> 32);
    }

    public static int sub(int[] r110, int[] r111, int[] r112) {
        long r100 = ((((long) r110[0]) & 4294967295L) - (((long) r111[0]) & 4294967295L)) + 0;
        r112[0] = (int) r100;
        long r101 = (r100 >> 32) + ((((long) r110[1]) & 4294967295L) - (((long) r111[1]) & 4294967295L));
        r112[1] = (int) r101;
        long r102 = (r101 >> 32) + ((((long) r110[2]) & 4294967295L) - (((long) r111[2]) & 4294967295L));
        r112[2] = (int) r102;
        long r103 = (r102 >> 32) + ((((long) r110[3]) & 4294967295L) - (((long) r111[3]) & 4294967295L));
        r112[3] = (int) r103;
        long r104 = (r103 >> 32) + ((((long) r110[4]) & 4294967295L) - (((long) r111[4]) & 4294967295L));
        r112[4] = (int) r104;
        long r105 = (r104 >> 32) + ((((long) r110[5]) & 4294967295L) - (((long) r111[5]) & 4294967295L));
        r112[5] = (int) r105;
        long r106 = (r105 >> 32) + ((((long) r110[6]) & 4294967295L) - (((long) r111[6]) & 4294967295L));
        r112[6] = (int) r106;
        long r107 = (r106 >> 32) + ((((long) r110[7]) & 4294967295L) - (((long) r111[7]) & 4294967295L));
        r112[7] = (int) r107;
        return (int) (r107 >> 32);
    }

    public static int subBothFrom(int[] r110, int[] r111, int[] r112) {
        long r100 = (((((long) r112[0]) & 4294967295L) - (((long) r110[0]) & 4294967295L)) - (((long) r111[0]) & 4294967295L)) + 0;
        r112[0] = (int) r100;
        long r101 = (r100 >> 32) + (((((long) r112[1]) & 4294967295L) - (((long) r110[1]) & 4294967295L)) - (((long) r111[1]) & 4294967295L));
        r112[1] = (int) r101;
        long r102 = (r101 >> 32) + (((((long) r112[2]) & 4294967295L) - (((long) r110[2]) & 4294967295L)) - (((long) r111[2]) & 4294967295L));
        r112[2] = (int) r102;
        long r103 = (r102 >> 32) + (((((long) r112[3]) & 4294967295L) - (((long) r110[3]) & 4294967295L)) - (((long) r111[3]) & 4294967295L));
        r112[3] = (int) r103;
        long r104 = (r103 >> 32) + (((((long) r112[4]) & 4294967295L) - (((long) r110[4]) & 4294967295L)) - (((long) r111[4]) & 4294967295L));
        r112[4] = (int) r104;
        long r105 = (r104 >> 32) + (((((long) r112[5]) & 4294967295L) - (((long) r110[5]) & 4294967295L)) - (((long) r111[5]) & 4294967295L));
        r112[5] = (int) r105;
        long r106 = (r105 >> 32) + (((((long) r112[6]) & 4294967295L) - (((long) r110[6]) & 4294967295L)) - (((long) r111[6]) & 4294967295L));
        r112[6] = (int) r106;
        long r107 = (r106 >> 32) + (((((long) r112[7]) & 4294967295L) - (((long) r110[7]) & 4294967295L)) - (((long) r111[7]) & 4294967295L));
        r112[7] = (int) r107;
        return (int) (r107 >> 32);
    }

    public static int subFrom(int[] r110, int r111, int[] r112, int r113) {
        int r100 = r113 + 0;
        long r101 = ((((long) r112[r100]) & 4294967295L) - (((long) r110[r111 + 0]) & 4294967295L)) + 0;
        r112[r100] = (int) r101;
        int r102 = r113 + 1;
        long r103 = (r101 >> 32) + ((((long) r112[r102]) & 4294967295L) - (((long) r110[r111 + 1]) & 4294967295L));
        r112[r102] = (int) r103;
        int r104 = r113 + 2;
        long r105 = (r103 >> 32) + ((((long) r112[r104]) & 4294967295L) - (((long) r110[r111 + 2]) & 4294967295L));
        r112[r104] = (int) r105;
        int r106 = r113 + 3;
        long r107 = (r105 >> 32) + ((((long) r112[r106]) & 4294967295L) - (((long) r110[r111 + 3]) & 4294967295L));
        r112[r106] = (int) r107;
        int r108 = r113 + 4;
        long r109 = (r107 >> 32) + ((((long) r112[r108]) & 4294967295L) - (((long) r110[r111 + 4]) & 4294967295L));
        r112[r108] = (int) r109;
        int r114 = r113 + 5;
        long r115 = (r109 >> 32) + ((((long) r112[r114]) & 4294967295L) - (((long) r110[r111 + 5]) & 4294967295L));
        r112[r114] = (int) r115;
        int r116 = r113 + 6;
        long r117 = (r115 >> 32) + ((((long) r112[r116]) & 4294967295L) - (((long) r110[r111 + 6]) & 4294967295L));
        r112[r116] = (int) r117;
        int r118 = r113 + 7;
        long r119 = (r117 >> 32) + ((((long) r112[r118]) & 4294967295L) - (((long) r110[r111 + 7]) & 4294967295L));
        r112[r118] = (int) r119;
        return (int) (r119 >> 32);
    }

    public static int subFrom(int[] r110, int[] r111) {
        long r100 = ((((long) r111[0]) & 4294967295L) - (((long) r110[0]) & 4294967295L)) + 0;
        r111[0] = (int) r100;
        long r101 = (r100 >> 32) + ((((long) r111[1]) & 4294967295L) - (((long) r110[1]) & 4294967295L));
        r111[1] = (int) r101;
        long r102 = (r101 >> 32) + ((((long) r111[2]) & 4294967295L) - (((long) r110[2]) & 4294967295L));
        r111[2] = (int) r102;
        long r103 = (r102 >> 32) + ((((long) r111[3]) & 4294967295L) - (((long) r110[3]) & 4294967295L));
        r111[3] = (int) r103;
        long r104 = (r103 >> 32) + ((((long) r111[4]) & 4294967295L) - (((long) r110[4]) & 4294967295L));
        r111[4] = (int) r104;
        long r105 = (r104 >> 32) + ((((long) r111[5]) & 4294967295L) - (((long) r110[5]) & 4294967295L));
        r111[5] = (int) r105;
        long r106 = (r105 >> 32) + ((((long) r111[6]) & 4294967295L) - (((long) r110[6]) & 4294967295L));
        r111[6] = (int) r106;
        long r107 = (r106 >> 32) + ((((long) r111[7]) & 4294967295L) - (4294967295L & ((long) r110[7])));
        r111[7] = (int) r107;
        return (int) (r107 >> 32);
    }

    public static BigInteger toBigInteger(int[] r100) {
        byte[] r101 = new byte[32];
        int r102 = 0;
    L4:
        if (r102 >= 8) goto L10;
        int r103 = r100[r102];
        if (r103 == 0) goto L8;
        Pack.intToBigEndian(r103, r101, (7 - r102) << 2);
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return new BigInteger(1, r101);
    }

    public static BigInteger toBigInteger64(long[] r100) {
        byte[] r101 = new byte[32];
        int r102 = 0;
    L4:
        if (r102 >= 4) goto L10;
        long r103 = r100[r102];
        if (r103 == 0) goto L8;
        Pack.longToBigEndian(r103, r101, (3 - r102) << 3);
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return new BigInteger(1, r101);
    }

    public static void zero(int[] r100) {
        r100[0] = 0;
        r100[1] = 0;
        r100[2] = 0;
        r100[3] = 0;
        r100[4] = 0;
        r100[5] = 0;
        r100[6] = 0;
        r100[7] = 0;
    }
}
