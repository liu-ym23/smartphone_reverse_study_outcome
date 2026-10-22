package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Nat128 {
    private static final long M = 4294967295L;

    public Nat128() {
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
        return (int) (r103 >>> 32);
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
        return (int) (r103 >>> 32);
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
        int r115 = r112 + 3;
        long r108 = (r107 >>> 32) + ((((long) r100[r110 + 3]) & 4294967295L) + (4294967295L & ((long) r111[r115])));
        r111[r115] = (int) r108;
        return (int) (r108 >>> 32);
    }

    public static int addTo(int[] r110, int[] r111) {
        long r100 = ((((long) r110[0]) & 4294967295L) + (((long) r111[0]) & 4294967295L)) + 0;
        r111[0] = (int) r100;
        long r101 = (r100 >>> 32) + ((((long) r110[1]) & 4294967295L) + (((long) r111[1]) & 4294967295L));
        r111[1] = (int) r101;
        long r102 = (r101 >>> 32) + ((((long) r110[2]) & 4294967295L) + (((long) r111[2]) & 4294967295L));
        r111[2] = (int) r102;
        long r103 = (r102 >>> 32) + ((((long) r110[3]) & 4294967295L) + (4294967295L & ((long) r111[3])));
        r111[3] = (int) r103;
        return (int) (r103 >>> 32);
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
        long r118 = (r114 >>> 32) + ((((long) r110[r116]) & 4294967295L) + (4294967295L & ((long) r112[r117])));
        int r119 = (int) r118;
        r110[r116] = r119;
        r112[r117] = r119;
        return (int) (r118 >>> 32);
    }

    public static void copy(int[] r100, int r101, int[] r102, int r103) {
        r102[r103 + 0] = r100[r101 + 0];
        r102[r103 + 1] = r100[r101 + 1];
        r102[r103 + 2] = r100[r101 + 2];
        r102[r103 + 3] = r100[r101 + 3];
    }

    public static void copy(int[] r100, int[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
    }

    public static void copy64(long[] r100, int r101, long[] r102, int r103) {
        r102[r103 + 0] = r100[r101 + 0];
        r102[r103 + 1] = r100[r101 + 1];
    }

    public static void copy64(long[] r100, long[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
    }

    public static int[] create() {
        return new int[4];
    }

    public static long[] create64() {
        return new long[2];
    }

    public static int[] createExt() {
        return new int[8];
    }

    public static long[] createExt64() {
        return new long[4];
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

    public static boolean eq64(long[] r100, long[] r101) {
        int r102 = 1;
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
        if (r100.bitLength() > 128) goto L12;
        int[] r101 = create();
        int r102 = 0;
    L8:
        if (r102 >= 4) goto L10;
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
        if (r100.bitLength() > 128) goto L12;
        long[] r101 = create64();
        int r102 = 0;
    L8:
        if (r102 >= 2) goto L10;
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
        if (r101 != 0) goto L7;
        int r102 = r100[0];
    L6:
        return r102 & 1;
    L7:
        int r103 = r101 >> 5;
        if (r103 >= 0) goto L10;
    L13:
        return 0;
    L10:
        if (r103 >= 4) goto L13;
        int r104 = r100[r103];
        r102 = r104 >>> (r101 & 31);
        goto L6
    }

    public static boolean gte(int[] r100, int r101, int[] r102, int r103) {
        int r104 = 3;
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
        int r102 = 3;
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
        if (r101 >= 4) goto L12;
        if (r100[r101] != 0) goto L10;
        r101 = r101 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isOne64(long[] r100) {
        if (r100[0] == 1) goto L6;
        return false;
    L6:
        if (r100[1] == 0) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean isZero(int[] r100) {
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

    public static boolean isZero64(long[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 2) goto L9;
        if (r100[r101] != 0) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static void mul(int[] r210, int r211, int[] r212, int r213, int[] r214, int r215) {
        long r100 = ((long) r212[r213 + 0]) & 4294967295L;
        long r101 = ((long) r212[r213 + 1]) & 4294967295L;
        long r102 = ((long) r212[r213 + 2]) & 4294967295L;
        long r103 = ((long) r212[r213 + 3]) & 4294967295L;
        long r110 = ((long) r210[r211 + 0]) & 4294967295L;
        long r111 = (r110 * r100) + 0;
        r214[r215 + 0] = (int) r111;
        long r112 = (r111 >>> 32) + (r110 * r101);
        r214[r215 + 1] = (int) r112;
        long r104 = (r112 >>> 32) + (r110 * r102);
        r214[r215 + 2] = (int) r104;
        long r105 = (r104 >>> 32) + (r110 * r103);
        r214[r215 + 3] = (int) r105;
        r214[r215 + 4] = (int) (r105 >>> 32);
        int r106 = 1;
        int r107 = r215;
        int r113 = 1;
    L4:
        if (r113 >= 4) goto L6;
        r107 = r107 + r106;
        long r114 = ((long) r210[r211 + r113]) & 4294967295L;
        int r115 = r107 + 0;
        long r116 = r100;
        long r117 = ((r114 * r100) + (((long) r214[r115]) & 4294967295L)) + 0;
        r214[r115] = (int) r117;
        int r118 = r107 + 1;
        long r119 = (r117 >>> 32) + ((r114 * r101) + (((long) r214[r118]) & 4294967295L));
        r214[r118] = (int) r119;
        int r120 = r107 + 2;
        long r121 = r101;
        long r108 = (r119 >>> 32) + ((r114 * r102) + (((long) r214[r120]) & 4294967295L));
        r214[r120] = (int) r108;
        int r109 = r107 + 3;
        long r122 = (r108 >>> 32) + ((r114 * r103) + (((long) r214[r109]) & 4294967295L));
        r214[r109] = (int) r122;
        r214[r107 + 4] = (int) (r122 >>> 32);
        r113 = r113 + 1;
        r101 = r121;
        r100 = r116;
        r106 = 1;
        goto L4
    }

    public static void mul(int[] r210, int[] r211, int[] r212) {
        long r100 = ((long) r211[0]) & 4294967295L;
        int r101 = 1;
        long r102 = ((long) r211[1]) & 4294967295L;
        long r103 = ((long) r211[2]) & 4294967295L;
        long r110 = ((long) r211[3]) & 4294967295L;
        long r111 = ((long) r210[0]) & 4294967295L;
        long r104 = (r111 * r100) + 0;
        r212[0] = (int) r104;
        long r105 = (r104 >>> 32) + (r111 * r102);
        r212[1] = (int) r105;
        long r106 = (r105 >>> 32) + (r111 * r103);
        r212[2] = (int) r106;
        long r107 = (r106 >>> 32) + (r111 * r110);
        r212[3] = (int) r107;
        int r108 = (int) (r107 >>> 32);
        int r109 = 4;
        r212[4] = r108;
    L3:
        if (r101 >= r109) goto L5;
        long r112 = ((long) r210[r101]) & 4294967295L;
        int r113 = r101 + 0;
        long r213 = r100;
        long r114 = ((r112 * r100) + (((long) r212[r113]) & 4294967295L)) + 0;
        r212[r113] = (int) r114;
        int r115 = r101 + 1;
        long r116 = (r114 >>> 32) + ((r112 * r102) + (((long) r212[r115]) & 4294967295L));
        r212[r115] = (int) r116;
        int r117 = r101 + 2;
        long r118 = (r116 >>> 32) + ((r112 * r103) + (((long) r212[r117]) & 4294967295L));
        r212[r117] = (int) r118;
        int r119 = r101 + 3;
        long r120 = (r118 >>> 32) + ((r112 * r110) + (((long) r212[r119]) & 4294967295L));
        r212[r119] = (int) r120;
        r212[r101 + 4] = (int) (r120 >>> 32);
        r101 = r115;
        r100 = r213;
        r109 = 4;
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
        long r109 = (r107 >>> 32) + (((r100 * r108) + r106) + (4294967295L & ((long) r113[r114 + 3])));
        r115[r116 + 3] = (int) r109;
        return (r109 >>> 32) + r108;
    }

    public static int mul33DWordAdd(int r110, long r111, int[] r112, int r113) {
        long r100 = ((long) r110) & 4294967295L;
        long r101 = r111 & 4294967295L;
        int r114 = r113 + 0;
        long r102 = ((r100 * r101) + (((long) r112[r114]) & 4294967295L)) + 0;
        r112[r114] = (int) r102;
        long r115 = r111 >>> 32;
        long r103 = (r100 * r115) + r101;
        int r104 = r113 + 1;
        long r105 = (r102 >>> 32) + (r103 + (((long) r112[r104]) & 4294967295L));
        r112[r104] = (int) r105;
        int r106 = r113 + 2;
        long r107 = (r105 >>> 32) + (r115 + (((long) r112[r106]) & 4294967295L));
        r112[r106] = (int) r107;
        int r116 = r113 + 3;
        long r117 = (r107 >>> 32) + (((long) r112[r116]) & 4294967295L);
        r112[r116] = (int) r117;
        return (int) (r117 >>> 32);
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
        return Nat.incAt(4, r112, r113, 3);
    }

    public static int mulAddTo(int[] r210, int r211, int[] r212, int r310, int[] r311, int r312) {
        long r100 = 4294967295L;
        long r101 = ((long) r212[r310 + 0]) & 4294967295L;
        long r102 = ((long) r212[r310 + 1]) & 4294967295L;
        long r103 = ((long) r212[r310 + 2]) & 4294967295L;
        long r104 = ((long) r212[r310 + 3]) & 4294967295L;
        int r110 = r312;
        int r111 = 0;
        long r112 = 0;
    L4:
        if (r111 >= 4) goto L7;
        long r113 = ((long) r210[r211 + r111]) & r100;
        int r114 = r110 + 0;
        long r105 = ((r113 * r101) + (((long) r311[r114]) & r100)) + 0;
        r311[r114] = (int) r105;
        int r106 = r110 + 1;
        long r213 = r102;
        long r107 = (r105 >>> 32) + ((r113 * r102) + (((long) r311[r106]) & 4294967295L));
        r311[r106] = (int) r107;
        int r115 = r110 + 2;
        long r108 = (r107 >>> 32) + ((r113 * r103) + (((long) r311[r115]) & 4294967295L));
        r311[r115] = (int) r108;
        int r109 = r110 + 3;
        long r116 = (r108 >>> 32) + ((r113 * r104) + (((long) r311[r109]) & 4294967295L));
        r311[r109] = (int) r116;
        int r117 = r110 + 4;
        long r118 = r112 + ((r116 >>> 32) + (((long) r311[r117]) & 4294967295L));
        r311[r117] = (int) r118;
        r112 = r118 >>> 32;
        r111 = r111 + 1;
        r110 = r106;
        r101 = r101;
        r100 = 4294967295L;
        r102 = r213;
        r103 = r103;
        goto L4
    L7:
        return (int) r112;
    }

    public static int mulAddTo(int[] r210, int[] r211, int[] r212) {
        int r100 = 0;
        long r101 = 4294967295L;
        long r102 = ((long) r211[0]) & 4294967295L;
        long r103 = ((long) r211[1]) & 4294967295L;
        long r104 = ((long) r211[2]) & 4294967295L;
        long r105 = ((long) r211[3]) & 4294967295L;
        long r110 = 0;
    L4:
        if (r100 >= 4) goto L7;
        long r111 = ((long) r210[r100]) & r101;
        int r112 = r100 + 0;
        long r106 = ((r111 * r102) + (((long) r212[r112]) & r101)) + 0;
        r212[r112] = (int) r106;
        int r107 = r100 + 1;
        long r108 = (r106 >>> 32) + ((r111 * r103) + (((long) r212[r107]) & 4294967295L));
        r212[r107] = (int) r108;
        int r113 = r100 + 2;
        long r109 = (r108 >>> 32) + ((r111 * r104) + (((long) r212[r113]) & 4294967295L));
        r212[r113] = (int) r109;
        int r114 = r100 + 3;
        long r115 = (r109 >>> 32) + ((r111 * r105) + (((long) r212[r114]) & 4294967295L));
        r212[r114] = (int) r115;
        int r116 = r100 + 4;
        long r117 = r110 + ((r115 >>> 32) + (((long) r212[r116]) & 4294967295L));
        r212[r116] = (int) r117;
        r110 = r117 >>> 32;
        r100 = r107;
        r101 = 4294967295L;
        r102 = r102;
        r103 = r103;
        goto L4
    L7:
        return (int) r110;
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
        if (r104 < 4) goto L3;
        return (int) r103;
    }

    public static int mulWordAddExt(int r110, int[] r111, int r112, int[] r113, int r114) {
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
        int r116 = r114 + 3;
        long r107 = (r106 >>> 32) + ((r100 * (((long) r111[r112 + 3]) & 4294967295L)) + (((long) r113[r116]) & 4294967295L));
        r113[r116] = (int) r107;
        return (int) (r107 >>> 32);
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
        return Nat.incAt(4, r112, r113, 3);
    }

    public static int mulWordsAdd(int r100, int r101, int[] r110, int r111) {
        long r102 = ((long) r100) & 4294967295L;
        long r103 = (((long) r101) & 4294967295L) * r102;
        int r104 = r111 + 0;
        long r105 = (r103 + (((long) r110[r104]) & 4294967295L)) + 0;
        r110[r104] = (int) r105;
        int r106 = r111 + 1;
        long r107 = (r105 >>> 32) + (4294967295L & ((long) r110[r106]));
        r110[r106] = (int) r107;
        if ((r107 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return Nat.incAt(4, r110, r111, 2);
    }

    public static void square(int[] r210, int r211, int[] r212, int r213) {
        long r100 = ((long) r210[r211 + 0]) & 4294967295L;
        int r101 = 0;
        int r102 = 8;
        int r103 = 3;
    L3:
        int r104 = r103 - 1;
        long r105 = ((long) r210[r211 + r103]) & 4294967295L;
        long r106 = r105 * r105;
        int r107 = r102 - 1;
        r212[r213 + r107] = (r101 << 31) | ((int) (r106 >>> 33));
        r102 = r107 - 1;
        r212[r213 + r102] = (int) (r106 >>> 1);
        r101 = (int) r106;
        if (r104 <= 0) goto L5;
        r103 = r104;
        goto L3
    L5:
        long r108 = r100 * r100;
        long r110 = (r108 >>> 33) | (((long) (r101 << 31)) & 4294967295L);
        r212[r213 + 0] = (int) r108;
        int r109 = ((int) (r108 >>> 32)) & 1;
        long r111 = ((long) r210[r211 + 1]) & 4294967295L;
        int r112 = r213 + 2;
        long r113 = ((long) r212[r112]) & 4294967295L;
        long r114 = r110 + (r111 * r100);
        int r115 = (int) r114;
        r212[r213 + 1] = (r115 << 1) | r109;
        int r116 = r115 >>> 31;
        long r117 = r113 + (r114 >>> 32);
        long r118 = ((long) r210[r211 + 2]) & 4294967295L;
        int r119 = r213 + 3;
        long r120 = ((long) r212[r119]) & 4294967295L;
        int r121 = r213 + 4;
        long r122 = ((long) r212[r121]) & 4294967295L;
        long r123 = r117 + (r118 * r100);
        int r124 = (int) r123;
        r212[r112] = (r124 << 1) | r116;
        long r125 = r120 + ((r123 >>> 32) + (r118 * r111));
        long r126 = r122 + (r125 >>> 32);
        long r127 = ((long) r210[r211 + 3]) & 4294967295L;
        int r128 = r213 + 5;
        long r129 = (((long) r212[r128]) & 4294967295L) + (r126 >>> 32);
        long r130 = r126 & 4294967295L;
        int r214 = r213 + 6;
        long r131 = (((long) r212[r214]) & 4294967295L) + (r129 >>> 32);
        long r132 = (r125 & 4294967295L) + (r100 * r127);
        int r133 = (int) r132;
        r212[r119] = (r133 << 1) | (r124 >>> 31);
        long r134 = r130 + ((r132 >>> 32) + (r111 * r127));
        long r135 = (4294967295L & r129) + ((r134 >>> 32) + (r127 * r118));
        long r136 = r131 + (r135 >>> 32);
        int r137 = (int) r134;
        r212[r121] = (r133 >>> 31) | (r137 << 1);
        int r138 = r137 >>> 31;
        int r139 = (int) r135;
        r212[r128] = r138 | (r139 << 1);
        int r140 = r139 >>> 31;
        int r141 = (int) r136;
        r212[r214] = r140 | (r141 << 1);
        int r142 = r141 >>> 31;
        int r143 = r213 + 7;
        r212[r143] = r142 | ((r212[r143] + ((int) (r136 >>> 32))) << 1);
    }

    public static void square(int[] r210, int[] r211) {
        long r100 = ((long) r210[0]) & 4294967295L;
        int r101 = 8;
        int r102 = 3;
        int r103 = 0;
    L3:
        int r104 = r102 - 1;
        long r110 = ((long) r210[r102]) & 4294967295L;
        long r111 = r110 * r110;
        int r105 = r101 - 1;
        r211[r105] = (r103 << 31) | ((int) (r111 >>> 33));
        r101 = r105 - 1;
        r211[r101] = (int) (r111 >>> 1);
        int r112 = (int) r111;
        if (r104 <= 0) goto L5;
        r102 = r104;
        r103 = r112;
        goto L3
    L5:
        long r106 = r100 * r100;
        r211[0] = (int) r106;
        long r107 = ((long) r210[1]) & 4294967295L;
        long r113 = ((long) r211[2]) & 4294967295L;
        long r114 = ((((long) (r112 << 31)) & 4294967295L) | (r106 >>> 33)) + (r107 * r100);
        int r115 = (int) r114;
        r211[1] = (r115 << 1) | (((int) (r106 >>> 32)) & 1);
        int r108 = r115 >>> 31;
        long r116 = r113 + (r114 >>> 32);
        long r117 = ((long) r210[2]) & 4294967295L;
        long r109 = ((long) r211[3]) & 4294967295L;
        long r118 = ((long) r211[4]) & 4294967295L;
        long r119 = r116 + (r117 * r100);
        int r120 = (int) r119;
        r211[2] = (r120 << 1) | r108;
        long r121 = r109 + ((r119 >>> 32) + (r117 * r107));
        long r122 = r118 + (r121 >>> 32);
        long r123 = ((long) r210[3]) & 4294967295L;
        long r124 = (((long) r211[5]) & 4294967295L) + (r122 >>> 32);
        long r125 = (((long) r211[6]) & 4294967295L) + (r124 >>> 32);
        long r126 = (r121 & 4294967295L) + (r100 * r123);
        int r127 = (int) r126;
        r211[3] = (r127 << 1) | (r120 >>> 31);
        long r128 = (r122 & 4294967295L) + ((r126 >>> 32) + (r107 * r123));
        long r129 = (r124 & 4294967295L) + ((r128 >>> 32) + (r123 * r117));
        long r130 = r125 + (r129 >>> 32);
        int r131 = (int) r128;
        r211[4] = (r127 >>> 31) | (r131 << 1);
        int r132 = (int) (r129 & 4294967295L);
        r211[5] = (r131 >>> 31) | (r132 << 1);
        int r133 = (int) r130;
        r211[6] = (r132 >>> 31) | (r133 << 1);
        r211[7] = ((r211[7] + ((int) (r130 >>> 32))) << 1) | (r133 >>> 31);
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
        return (int) (r104 >> 32);
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
        return (int) (r103 >> 32);
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
        return (int) (r103 >> 32);
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
        int r114 = r113 + 3;
        long r106 = (r105 >> 32) + ((((long) r112[r114]) & 4294967295L) - (((long) r110[r111 + 3]) & 4294967295L));
        r112[r114] = (int) r106;
        return (int) (r106 >> 32);
    }

    public static int subFrom(int[] r110, int[] r111) {
        long r100 = ((((long) r111[0]) & 4294967295L) - (((long) r110[0]) & 4294967295L)) + 0;
        r111[0] = (int) r100;
        long r101 = (r100 >> 32) + ((((long) r111[1]) & 4294967295L) - (((long) r110[1]) & 4294967295L));
        r111[1] = (int) r101;
        long r102 = (r101 >> 32) + ((((long) r111[2]) & 4294967295L) - (((long) r110[2]) & 4294967295L));
        r111[2] = (int) r102;
        long r103 = (r102 >> 32) + ((((long) r111[3]) & 4294967295L) - (4294967295L & ((long) r110[3])));
        r111[3] = (int) r103;
        return (int) (r103 >> 32);
    }

    public static BigInteger toBigInteger(int[] r100) {
        byte[] r101 = new byte[16];
        int r102 = 0;
    L4:
        if (r102 >= 4) goto L10;
        int r103 = r100[r102];
        if (r103 == 0) goto L8;
        Pack.intToBigEndian(r103, r101, (3 - r102) << 2);
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return new BigInteger(1, r101);
    }

    public static BigInteger toBigInteger64(long[] r100) {
        byte[] r101 = new byte[16];
        int r102 = 0;
    L4:
        if (r102 >= 2) goto L10;
        long r103 = r100[r102];
        if (r103 == 0) goto L8;
        Pack.longToBigEndian(r103, r101, (1 - r102) << 3);
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
    }
}
