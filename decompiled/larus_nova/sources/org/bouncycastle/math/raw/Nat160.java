package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Nat160 {
    private static final long M = 4294967295L;

    public Nat160() {
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
        return (int) (r104 >>> 32);
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
        return (int) (r104 >>> 32);
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
        long r116 = (r109 >>> 32) + ((((long) r100[r110 + 4]) & 4294967295L) + (4294967295L & ((long) r111[r115])));
        r111[r115] = (int) r116;
        return (int) (r116 >>> 32);
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
        long r104 = (r103 >>> 32) + ((((long) r110[4]) & 4294967295L) + (4294967295L & ((long) r111[4])));
        r111[4] = (int) r104;
        return (int) (r104 >>> 32);
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
        long r122 = (r118 >>> 32) + ((((long) r110[r120]) & 4294967295L) + (4294967295L & ((long) r112[r121])));
        int r123 = (int) r122;
        r110[r120] = r123;
        r112[r121] = r123;
        return (int) (r122 >>> 32);
    }

    public static void copy(int[] r100, int r101, int[] r102, int r103) {
        r102[r103 + 0] = r100[r101 + 0];
        r102[r103 + 1] = r100[r101 + 1];
        r102[r103 + 2] = r100[r101 + 2];
        r102[r103 + 3] = r100[r101 + 3];
        r102[r103 + 4] = r100[r101 + 4];
    }

    public static void copy(int[] r100, int[] r101) {
        r101[0] = r100[0];
        r101[1] = r100[1];
        r101[2] = r100[2];
        r101[3] = r100[3];
        r101[4] = r100[4];
    }

    public static int[] create() {
        return new int[5];
    }

    public static int[] createExt() {
        return new int[10];
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
        int r102 = 4;
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
        if (r100.bitLength() > 160) goto L12;
        int[] r101 = create();
        int r102 = 0;
    L8:
        if (r102 >= 5) goto L10;
        r101[r102] = r100.intValue();
        r100 = r100.shiftRight(32);
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
        if (r103 >= 5) goto L13;
        int r104 = r100[r103];
        r102 = r104 >>> (r101 & 31);
        goto L6
    }

    public static boolean gte(int[] r100, int r101, int[] r102, int r103) {
        int r104 = 4;
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
        int r102 = 4;
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
        if (r101 >= 5) goto L12;
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
        if (r101 >= 5) goto L9;
        if (r100[r101] != 0) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static void mul(int[] r210, int r211, int[] r212, int r310, int[] r311, int r312) {
        long r100 = ((long) r212[r310 + 0]) & 4294967295L;
        long r101 = ((long) r212[r310 + 1]) & 4294967295L;
        long r102 = ((long) r212[r310 + 2]) & 4294967295L;
        long r103 = ((long) r212[r310 + 3]) & 4294967295L;
        long r110 = ((long) r212[r310 + 4]) & 4294967295L;
        long r111 = ((long) r210[r211 + 0]) & 4294967295L;
        long r112 = (r111 * r100) + 0;
        r311[r312 + 0] = (int) r112;
        long r113 = (r112 >>> 32) + (r111 * r101);
        r311[r312 + 1] = (int) r113;
        long r104 = (r113 >>> 32) + (r111 * r102);
        r311[r312 + 2] = (int) r104;
        long r105 = (r104 >>> 32) + (r111 * r103);
        r311[r312 + 3] = (int) r105;
        long r106 = (r105 >>> 32) + (r111 * r110);
        r311[r312 + 4] = (int) r106;
        r311[r312 + 5] = (int) (r106 >>> 32);
        int r107 = 1;
        int r108 = r312;
        int r109 = 1;
    L4:
        if (r109 >= 5) goto L6;
        r108 = r108 + r107;
        long r114 = ((long) r210[r211 + r109]) & 4294967295L;
        int r213 = r108 + 0;
        long r115 = ((r114 * r100) + (((long) r311[r213]) & 4294967295L)) + 0;
        r311[r213] = (int) r115;
        int r116 = r108 + 1;
        long r214 = r100;
        long r117 = (r115 >>> 32) + ((r114 * r101) + (((long) r311[r116]) & 4294967295L));
        r311[r116] = (int) r117;
        int r118 = r108 + 2;
        long r215 = r102;
        long r119 = (r117 >>> 32) + ((r114 * r102) + (((long) r311[r118]) & 4294967295L));
        r311[r118] = (int) r119;
        int r120 = r108 + 3;
        long r121 = (r119 >>> 32) + ((r114 * r103) + (((long) r311[r120]) & 4294967295L));
        r311[r120] = (int) r121;
        int r122 = r108 + 4;
        long r123 = (r121 >>> 32) + ((r114 * r110) + (((long) r311[r122]) & 4294967295L));
        r311[r122] = (int) r123;
        r311[r108 + 5] = (int) (r123 >>> 32);
        r109 = r109 + 1;
        r102 = r215;
        r100 = r214;
        r107 = 1;
        goto L4
    }

    public static void mul(int[] r210, int[] r211, int[] r212) {
        long r100 = ((long) r211[0]) & 4294967295L;
        int r101 = 1;
        long r102 = ((long) r211[1]) & 4294967295L;
        long r103 = ((long) r211[2]) & 4294967295L;
        long r110 = ((long) r211[3]) & 4294967295L;
        long r111 = ((long) r211[4]) & 4294967295L;
        long r104 = ((long) r210[0]) & 4294967295L;
        long r112 = (r104 * r100) + 0;
        r212[0] = (int) r112;
        long r105 = (r112 >>> 32) + (r104 * r102);
        r212[1] = (int) r105;
        long r106 = (r105 >>> 32) + (r104 * r103);
        r212[2] = (int) r106;
        long r107 = (r106 >>> 32) + (r104 * r110);
        r212[3] = (int) r107;
        long r108 = (r107 >>> 32) + (r104 * r111);
        r212[4] = (int) r108;
        int r109 = (int) (r108 >>> 32);
        int r113 = 5;
        r212[5] = r109;
    L3:
        if (r101 >= r113) goto L5;
        long r114 = ((long) r210[r101]) & 4294967295L;
        int r115 = r101 + 0;
        long r213 = r100;
        long r116 = ((r114 * r100) + (((long) r212[r115]) & 4294967295L)) + 0;
        r212[r115] = (int) r116;
        int r117 = r101 + 1;
        long r214 = r102;
        long r118 = (r116 >>> 32) + ((r114 * r102) + (((long) r212[r117]) & 4294967295L));
        r212[r117] = (int) r118;
        int r119 = r101 + 2;
        long r120 = r111;
        long r121 = (r118 >>> 32) + ((r114 * r103) + (((long) r212[r119]) & 4294967295L));
        r212[r119] = (int) r121;
        int r122 = r101 + 3;
        long r123 = (r121 >>> 32) + ((r114 * r110) + (((long) r212[r122]) & 4294967295L));
        r212[r122] = (int) r123;
        int r124 = r101 + 4;
        long r125 = (r123 >>> 32) + ((r114 * r120) + (((long) r212[r124]) & 4294967295L));
        r212[r124] = (int) r125;
        r212[r101 + 5] = (int) (r125 >>> 32);
        r101 = r117;
        r111 = r120;
        r100 = r213;
        r102 = r214;
        r113 = 5;
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
        long r118 = (r109 >>> 32) + (((r100 * r117) + r108) + (4294967295L & ((long) r113[r114 + 4])));
        r115[r116 + 4] = (int) r118;
        return (r118 >>> 32) + r117;
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
        return Nat.incAt(5, r112, r113, 4);
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
        return Nat.incAt(5, r112, r113, 3);
    }

    public static int mulAddTo(int[] r210, int r310, int[] r311, int r312, int[] r313, int r314) {
        long r100 = 4294967295L;
        long r101 = ((long) r311[r312 + 0]) & 4294967295L;
        long r102 = ((long) r311[r312 + 1]) & 4294967295L;
        long r103 = ((long) r311[r312 + 2]) & 4294967295L;
        long r104 = ((long) r311[r312 + 3]) & 4294967295L;
        long r110 = ((long) r311[r312 + 4]) & 4294967295L;
        int r111 = r314;
        int r112 = 0;
        long r113 = 0;
    L4:
        if (r112 >= 5) goto L7;
        long r114 = ((long) r210[r310 + r112]) & r100;
        int r211 = r111 + 0;
        long r105 = ((r114 * r101) + (((long) r313[r211]) & r100)) + 0;
        r313[r211] = (int) r105;
        int r106 = r111 + 1;
        long r212 = r102;
        long r107 = (r105 >>> 32) + ((r114 * r102) + (((long) r313[r106]) & 4294967295L));
        r313[r106] = (int) r107;
        int r115 = r111 + 2;
        long r213 = r103;
        long r108 = (r107 >>> 32) + ((r114 * r103) + (((long) r313[r115]) & 4294967295L));
        r313[r115] = (int) r108;
        int r109 = r111 + 3;
        long r116 = (r108 >>> 32) + ((r114 * r104) + (((long) r313[r109]) & 4294967295L));
        r313[r109] = (int) r116;
        int r117 = r111 + 4;
        long r118 = (r116 >>> 32) + ((r114 * r110) + (((long) r313[r117]) & 4294967295L));
        r313[r117] = (int) r118;
        int r119 = r111 + 5;
        long r120 = ((r118 >>> 32) + (((long) r313[r119]) & 4294967295L)) + r113;
        r313[r119] = (int) r120;
        r113 = r120 >>> 32;
        r112 = r112 + 1;
        r111 = r106;
        r101 = r101;
        r100 = 4294967295L;
        r102 = r212;
        r103 = r213;
        goto L4
    L7:
        return (int) r113;
    }

    public static int mulAddTo(int[] r310, int[] r311, int[] r312) {
        int r100 = 0;
        long r101 = 4294967295L;
        long r102 = ((long) r311[0]) & 4294967295L;
        long r103 = ((long) r311[1]) & 4294967295L;
        long r104 = ((long) r311[2]) & 4294967295L;
        long r105 = ((long) r311[3]) & 4294967295L;
        long r110 = ((long) r311[4]) & 4294967295L;
        long r111 = 0;
    L4:
        if (r100 >= 5) goto L7;
        long r112 = ((long) r310[r100]) & r101;
        int r210 = r100 + 0;
        long r106 = ((r112 * r102) + (((long) r312[r210]) & r101)) + 0;
        r312[r210] = (int) r106;
        int r107 = r100 + 1;
        long r211 = r103;
        long r108 = (r106 >>> 32) + ((r112 * r103) + (((long) r312[r107]) & 4294967295L));
        r312[r107] = (int) r108;
        int r212 = r100 + 2;
        long r213 = r104;
        long r109 = (r108 >>> 32) + ((r112 * r104) + (((long) r312[r212]) & 4294967295L));
        r312[r212] = (int) r109;
        int r113 = r100 + 3;
        long r114 = (r109 >>> 32) + ((r112 * r105) + (((long) r312[r113]) & 4294967295L));
        r312[r113] = (int) r114;
        int r115 = r100 + 4;
        long r116 = (r114 >>> 32) + ((r112 * r110) + (((long) r312[r115]) & 4294967295L));
        r312[r115] = (int) r116;
        int r117 = r100 + 5;
        long r118 = ((r116 >>> 32) + (((long) r312[r117]) & 4294967295L)) + r111;
        r312[r117] = (int) r118;
        r111 = r118 >>> 32;
        r100 = r107;
        r101 = 4294967295L;
        r102 = r102;
        r104 = r213;
        r103 = r211;
        goto L4
    L7:
        return (int) r111;
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
        if (r104 < 5) goto L3;
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
        int r107 = r114 + 3;
        long r108 = (r106 >>> 32) + (((((long) r111[r112 + 3]) & 4294967295L) * r100) + (((long) r113[r107]) & 4294967295L));
        r113[r107] = (int) r108;
        int r116 = r114 + 4;
        long r109 = (r108 >>> 32) + ((r100 * (((long) r111[r112 + 4]) & 4294967295L)) + (((long) r113[r116]) & 4294967295L));
        r113[r116] = (int) r109;
        return (int) (r109 >>> 32);
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
        return Nat.incAt(5, r112, r113, 3);
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
        return Nat.incAt(5, r110, r111, 2);
    }

    public static void square(int[] r310, int r311, int[] r312, int r313) {
        long r100 = ((long) r310[r311 + 0]) & 4294967295L;
        int r101 = 0;
        int r102 = 10;
        int r103 = 4;
    L3:
        int r104 = r103 - 1;
        long r105 = ((long) r310[r311 + r103]) & 4294967295L;
        long r106 = r105 * r105;
        int r107 = r102 - 1;
        r312[r313 + r107] = (r101 << 31) | ((int) (r106 >>> 33));
        r102 = r107 - 1;
        r312[r313 + r102] = (int) (r106 >>> 1);
        r101 = (int) r106;
        if (r104 <= 0) goto L5;
        r103 = r104;
        goto L3
    L5:
        long r108 = r100 * r100;
        long r110 = (r108 >>> 33) | (((long) (r101 << 31)) & 4294967295L);
        r312[r313 + 0] = (int) r108;
        int r109 = ((int) (r108 >>> 32)) & 1;
        long r111 = ((long) r310[r311 + 1]) & 4294967295L;
        int r112 = r313 + 2;
        long r113 = ((long) r312[r112]) & 4294967295L;
        long r114 = r110 + (r111 * r100);
        int r115 = (int) r114;
        r312[r313 + 1] = (r115 << 1) | r109;
        int r116 = r115 >>> 31;
        long r117 = r113 + (r114 >>> 32);
        long r118 = ((long) r310[r311 + 2]) & 4294967295L;
        int r119 = r313 + 3;
        long r120 = ((long) r312[r119]) & 4294967295L;
        int r121 = r313 + 4;
        long r122 = ((long) r312[r121]) & 4294967295L;
        long r123 = r117 + (r118 * r100);
        int r124 = (int) r123;
        r312[r112] = (r124 << 1) | r116;
        long r125 = r120 + ((r123 >>> 32) + (r118 * r111));
        long r126 = r122 + (r125 >>> 32);
        long r127 = ((long) r310[r311 + 3]) & 4294967295L;
        int r210 = r313 + 5;
        long r128 = (((long) r312[r210]) & 4294967295L) + (r126 >>> 32);
        long r129 = r126 & 4294967295L;
        int r211 = r313 + 6;
        long r130 = (((long) r312[r211]) & 4294967295L) + (r128 >>> 32);
        long r131 = (r125 & 4294967295L) + (r127 * r100);
        int r132 = (int) r131;
        r312[r119] = (r132 << 1) | (r124 >>> 31);
        long r133 = r129 + ((r131 >>> 32) + (r127 * r111));
        long r134 = (r128 & 4294967295L) + ((r133 >>> 32) + (r127 * r118));
        long r135 = r130 + (r134 >>> 32);
        long r136 = r134 & 4294967295L;
        long r137 = ((long) r310[r311 + 4]) & 4294967295L;
        int r138 = r313 + 7;
        long r139 = (((long) r312[r138]) & 4294967295L) + (r135 >>> 32);
        int r140 = r313 + 8;
        long r141 = (((long) r312[r140]) & 4294967295L) + (r139 >>> 32);
        long r142 = (r133 & 4294967295L) + (r100 * r137);
        int r143 = (int) r142;
        r312[r121] = (r143 << 1) | (r132 >>> 31);
        long r144 = r136 + ((r142 >>> 32) + (r111 * r137));
        long r145 = (r135 & 4294967295L) + ((r144 >>> 32) + (r137 * r118));
        long r146 = (r139 & 4294967295L) + ((r145 >>> 32) + (r137 * r127));
        long r147 = r141 + (r146 >>> 32);
        int r148 = (int) r144;
        r312[r210] = (r143 >>> 31) | (r148 << 1);
        int r149 = (int) r145;
        r312[r211] = (r148 >>> 31) | (r149 << 1);
        int r150 = (int) r146;
        r312[r138] = (r149 >>> 31) | (r150 << 1);
        int r151 = r150 >>> 31;
        int r152 = (int) r147;
        r312[r140] = r151 | (r152 << 1);
        int r153 = r152 >>> 31;
        int r154 = r313 + 9;
        r312[r154] = r153 | ((r312[r154] + ((int) (r147 >>> 32))) << 1);
    }

    public static void square(int[] r310, int[] r311) {
        long r100 = ((long) r310[0]) & 4294967295L;
        int r101 = 10;
        int r102 = 4;
        int r103 = 0;
    L3:
        int r104 = r102 - 1;
        long r110 = ((long) r310[r102]) & 4294967295L;
        long r111 = r110 * r110;
        int r105 = r101 - 1;
        r311[r105] = (r103 << 31) | ((int) (r111 >>> 33));
        r101 = r105 - 1;
        r311[r101] = (int) (r111 >>> 1);
        int r112 = (int) r111;
        if (r104 <= 0) goto L5;
        r102 = r104;
        r103 = r112;
        goto L3
    L5:
        long r106 = r100 * r100;
        r311[0] = (int) r106;
        long r107 = ((long) r310[1]) & 4294967295L;
        long r113 = ((long) r311[2]) & 4294967295L;
        long r114 = ((((long) (r112 << 31)) & 4294967295L) | (r106 >>> 33)) + (r107 * r100);
        int r115 = (int) r114;
        r311[1] = (r115 << 1) | (((int) (r106 >>> 32)) & 1);
        long r116 = r113 + (r114 >>> 32);
        long r117 = ((long) r310[2]) & 4294967295L;
        long r108 = ((long) r311[3]) & 4294967295L;
        long r109 = ((long) r311[4]) & 4294967295L;
        long r118 = r116 + (r117 * r100);
        int r119 = (int) r118;
        r311[2] = (r119 << 1) | (r115 >>> 31);
        long r120 = r108 + ((r118 >>> 32) + (r117 * r107));
        long r121 = r109 + (r120 >>> 32);
        long r122 = ((long) r310[3]) & 4294967295L;
        long r123 = (((long) r311[5]) & 4294967295L) + (r121 >>> 32);
        long r124 = r121 & 4294967295L;
        long r125 = (((long) r311[6]) & 4294967295L) + (r123 >>> 32);
        long r126 = (r120 & 4294967295L) + (r122 * r100);
        int r127 = (int) r126;
        r311[3] = (r127 << 1) | (r119 >>> 31);
        int r128 = r127 >>> 31;
        long r129 = r124 + ((r126 >>> 32) + (r122 * r107));
        long r130 = (r123 & 4294967295L) + ((r129 >>> 32) + (r122 * r117));
        long r131 = r125 + (r130 >>> 32);
        long r132 = ((long) r310[4]) & 4294967295L;
        long r133 = (((long) r311[7]) & 4294967295L) + (r131 >>> 32);
        long r134 = r131 & 4294967295L;
        long r135 = (((long) r311[8]) & 4294967295L) + (r133 >>> 32);
        long r136 = 4294967295L & r133;
        long r137 = (r129 & 4294967295L) + (r132 * r100);
        int r138 = (int) r137;
        r311[4] = r128 | (r138 << 1);
        long r139 = (r130 & 4294967295L) + ((r137 >>> 32) + (r107 * r132));
        long r140 = r134 + ((r139 >>> 32) + (r132 * r117));
        long r141 = r136 + ((r140 >>> 32) + (r132 * r122));
        long r142 = r135 + (r141 >>> 32);
        int r143 = (int) r139;
        r311[5] = (r138 >>> 31) | (r143 << 1);
        int r144 = (int) r140;
        r311[6] = (r144 << 1) | (r143 >>> 31);
        int r145 = r144 >>> 31;
        int r146 = (int) r141;
        r311[7] = r145 | (r146 << 1);
        int r147 = r146 >>> 31;
        int r148 = (int) r142;
        r311[8] = r147 | (r148 << 1);
        r311[9] = (r148 >>> 31) | ((r311[9] + ((int) (r142 >>> 32))) << 1);
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
        return (int) (r105 >> 32);
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
        return (int) (r104 >> 32);
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
        return (int) (r104 >> 32);
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
        int r114 = r113 + 4;
        long r108 = (r107 >> 32) + ((((long) r112[r114]) & 4294967295L) - (((long) r110[r111 + 4]) & 4294967295L));
        r112[r114] = (int) r108;
        return (int) (r108 >> 32);
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
        long r104 = (r103 >> 32) + ((((long) r111[4]) & 4294967295L) - (4294967295L & ((long) r110[4])));
        r111[4] = (int) r104;
        return (int) (r104 >> 32);
    }

    public static BigInteger toBigInteger(int[] r100) {
        byte[] r101 = new byte[20];
        int r102 = 0;
    L4:
        if (r102 >= 5) goto L10;
        int r103 = r100[r102];
        if (r103 == 0) goto L8;
        Pack.intToBigEndian(r103, r101, (4 - r102) << 2);
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
    }
}
