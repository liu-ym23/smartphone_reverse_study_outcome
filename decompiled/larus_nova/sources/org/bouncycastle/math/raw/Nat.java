package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Nat {
    private static final long M = 4294967295L;

    public Nat() {
    }

    public static int add(int r100, int[] r110, int[] r111, int[] r112) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = r101 + ((((long) r110[r102]) & 4294967295L) + (4294967295L & ((long) r111[r102])));
        r112[r102] = (int) r103;
        r101 = r103 >>> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int add33At(int r100, int r101, int[] r102, int r110) {
        int r103 = r110 + 0;
        long r104 = (((long) r102[r103]) & 4294967295L) + (((long) r101) & 4294967295L);
        r102[r103] = (int) r104;
        int r105 = r110 + 1;
        long r106 = (r104 >>> 32) + ((4294967295L & ((long) r102[r105])) + 1);
        r102[r105] = (int) r106;
        if ((r106 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r102, r110 + 2);
    }

    public static int add33At(int r100, int r101, int[] r102, int r110, int r111) {
        int r103 = r110 + r111;
        long r104 = (((long) r102[r103]) & 4294967295L) + (((long) r101) & 4294967295L);
        r102[r103] = (int) r104;
        int r105 = r103 + 1;
        long r106 = (r104 >>> 32) + ((4294967295L & ((long) r102[r105])) + 1);
        r102[r105] = (int) r106;
        if ((r106 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r102, r110, r111 + 2);
    }

    public static int add33To(int r100, int r101, int[] r110) {
        long r102 = (((long) r110[0]) & 4294967295L) + (((long) r101) & 4294967295L);
        r110[0] = (int) r102;
        long r103 = (r102 >>> 32) + ((4294967295L & ((long) r110[1])) + 1);
        r110[1] = (int) r103;
        if ((r103 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r110, 2);
    }

    public static int add33To(int r100, int r101, int[] r102, int r110) {
        int r103 = r110 + 0;
        long r104 = (((long) r102[r103]) & 4294967295L) + (((long) r101) & 4294967295L);
        r102[r103] = (int) r104;
        int r105 = r110 + 1;
        long r106 = (r104 >>> 32) + ((4294967295L & ((long) r102[r105])) + 1);
        r102[r105] = (int) r106;
        if ((r106 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r102, r110, 2);
    }

    public static int addBothTo(int r110, int[] r111, int r112, int[] r113, int r114, int[] r115, int r116) {
        long r100 = 0;
        int r101 = 0;
    L3:
        if (r101 >= r110) goto L6;
        long r102 = (((long) r111[r112 + r101]) & 4294967295L) + (((long) r113[r114 + r101]) & 4294967295L);
        int r103 = r116 + r101;
        long r104 = r100 + (r102 + (4294967295L & ((long) r115[r103])));
        r115[r103] = (int) r104;
        r100 = r104 >>> 32;
        r101 = r101 + 1;
        goto L3
    L6:
        return (int) r100;
    }

    public static int addBothTo(int r100, int[] r110, int[] r111, int[] r112) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = r101 + (((((long) r110[r102]) & 4294967295L) + (((long) r111[r102]) & 4294967295L)) + (4294967295L & ((long) r112[r102])));
        r112[r102] = (int) r103;
        r101 = r103 >>> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int addDWordAt(int r100, long r101, int[] r110, int r111) {
        int r102 = r111 + 0;
        long r103 = (((long) r110[r102]) & 4294967295L) + (r101 & 4294967295L);
        r110[r102] = (int) r103;
        int r104 = r111 + 1;
        long r105 = (r103 >>> 32) + ((4294967295L & ((long) r110[r104])) + (r101 >>> 32));
        r110[r104] = (int) r105;
        if ((r105 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r110, r111 + 2);
    }

    public static int addDWordAt(int r100, long r101, int[] r110, int r111, int r112) {
        int r102 = r111 + r112;
        long r103 = (((long) r110[r102]) & 4294967295L) + (r101 & 4294967295L);
        r110[r102] = (int) r103;
        int r104 = r102 + 1;
        long r105 = (r103 >>> 32) + ((4294967295L & ((long) r110[r104])) + (r101 >>> 32));
        r110[r104] = (int) r105;
        if ((r105 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r110, r111, r112 + 2);
    }

    public static int addDWordTo(int r100, long r110, int[] r111) {
        long r101 = (((long) r111[0]) & 4294967295L) + (r110 & 4294967295L);
        r111[0] = (int) r101;
        long r102 = (r101 >>> 32) + ((4294967295L & ((long) r111[1])) + (r110 >>> 32));
        r111[1] = (int) r102;
        if ((r102 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r111, 2);
    }

    public static int addDWordTo(int r100, long r101, int[] r110, int r111) {
        int r102 = r111 + 0;
        long r103 = (((long) r110[r102]) & 4294967295L) + (r101 & 4294967295L);
        r110[r102] = (int) r103;
        int r104 = r111 + 1;
        long r105 = (r103 >>> 32) + ((4294967295L & ((long) r110[r104])) + (r101 >>> 32));
        r110[r104] = (int) r105;
        if ((r105 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r110, r111, 2);
    }

    public static int addTo(int r110, int[] r111, int r112, int[] r113, int r114) {
        long r100 = 0;
        int r101 = 0;
    L3:
        if (r101 >= r110) goto L6;
        int r102 = r114 + r101;
        long r103 = r100 + ((((long) r111[r112 + r101]) & 4294967295L) + (4294967295L & ((long) r113[r102])));
        r113[r102] = (int) r103;
        r100 = r103 >>> 32;
        r101 = r101 + 1;
        goto L3
    L6:
        return (int) r100;
    }

    public static int addTo(int r100, int[] r110, int r111, int[] r112, int r113, int r114) {
        long r101 = ((long) r114) & 4294967295L;
        int r115 = 0;
    L3:
        if (r115 >= r100) goto L6;
        int r102 = r113 + r115;
        long r103 = r101 + ((((long) r110[r111 + r115]) & 4294967295L) + (((long) r112[r102]) & 4294967295L));
        r112[r102] = (int) r103;
        r101 = r103 >>> 32;
        r115 = r115 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int addTo(int r100, int[] r110, int[] r111) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = r101 + ((((long) r110[r102]) & 4294967295L) + (4294967295L & ((long) r111[r102])));
        r111[r102] = (int) r103;
        r101 = r103 >>> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int addToEachOther(int r110, int[] r111, int r112, int[] r113, int r114) {
        long r100 = 0;
        int r101 = 0;
    L3:
        if (r101 >= r110) goto L6;
        int r102 = r112 + r101;
        int r103 = r114 + r101;
        long r104 = r100 + ((((long) r111[r102]) & 4294967295L) + (4294967295L & ((long) r113[r103])));
        int r105 = (int) r104;
        r111[r102] = r105;
        r113[r103] = r105;
        r100 = r104 >>> 32;
        r101 = r101 + 1;
        goto L3
    L6:
        return (int) r100;
    }

    public static int addWordAt(int r100, int r101, int[] r102, int r103) {
        long r104 = (((long) r101) & 4294967295L) + (4294967295L & ((long) r102[r103]));
        r102[r103] = (int) r104;
        if ((r104 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r102, r103 + 1);
    }

    public static int addWordAt(int r100, int r101, int[] r102, int r103, int r110) {
        long r104 = ((long) r101) & 4294967295L;
        int r105 = r103 + r110;
        long r106 = r104 + (4294967295L & ((long) r102[r105]));
        r102[r105] = (int) r106;
        if ((r106 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r102, r103, r110 + 1);
    }

    public static int addWordTo(int r100, int r101, int[] r102) {
        long r103 = (((long) r101) & 4294967295L) + (4294967295L & ((long) r102[0]));
        r102[0] = (int) r103;
        if ((r103 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r102, 1);
    }

    public static int addWordTo(int r100, int r101, int[] r102, int r103) {
        long r104 = (((long) r101) & 4294967295L) + (4294967295L & ((long) r102[r103]));
        r102[r103] = (int) r104;
        if ((r104 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r100, r102, r103, 1);
    }

    public static int cadd(int r110, int r111, int[] r112, int[] r113, int[] r114) {
        long r100 = ((long) (-(r111 & 1))) & 4294967295L;
        long r101 = 0;
        int r115 = 0;
    L3:
        if (r115 >= r110) goto L6;
        long r102 = r101 + ((((long) r112[r115]) & 4294967295L) + (((long) r113[r115]) & r100));
        r114[r115] = (int) r102;
        r101 = r102 >>> 32;
        r115 = r115 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static void cmov(int r100, int r101, int[] r102, int r103, int[] r104, int r105) {
        int r106 = -(r101 & 1);
        int r107 = 0;
    L3:
        if (r107 >= r100) goto L5;
        int r108 = r105 + r107;
        int r109 = r104[r108];
        r104[r108] = r109 ^ ((r102[r103 + r107] ^ r109) & r106);
        r107 = r107 + 1;
        goto L3
    }

    public static int compare(int r100, int[] r101, int r102, int[] r103, int r104) {
        int r105 = r100 - 1;
    L3:
        if (r105 < 0) goto L11;
        int r106 = r101[r102 + r105] ^ Integer.MIN_VALUE;
        int r107 = Integer.MIN_VALUE ^ r103[r104 + r105];
        if (r106 < r107) goto L6;
        if (r106 > r107) goto L9;
        r105 = r105 - 1;
        goto L3
    L9:
        return 1;
    L6:
        return -1;
    L11:
        return 0;
    }

    public static int compare(int r100, int[] r101, int[] r102) {
        int r103 = r100 - 1;
    L3:
        if (r103 < 0) goto L11;
        int r104 = r101[r103] ^ Integer.MIN_VALUE;
        int r105 = Integer.MIN_VALUE ^ r102[r103];
        if (r104 < r105) goto L6;
        if (r104 > r105) goto L9;
        r103 = r103 - 1;
        goto L3
    L9:
        return 1;
    L6:
        return -1;
    L11:
        return 0;
    }

    public static void copy(int r100, int[] r101, int r102, int[] r103, int r104) {
        System.arraycopy(r101, r102, r103, r104, r100);
    }

    public static void copy(int r100, int[] r101, int[] r102) {
        System.arraycopy(r101, 0, r102, 0, r100);
    }

    public static int[] copy(int r100, int[] r101) {
        int[] r102 = new int[r100];
        System.arraycopy(r101, 0, r102, 0, r100);
        return r102;
    }

    public static void copy64(int r100, long[] r101, int r102, long[] r103, int r104) {
        System.arraycopy(r101, r102, r103, r104, r100);
    }

    public static void copy64(int r100, long[] r101, long[] r102) {
        System.arraycopy(r101, 0, r102, 0, r100);
    }

    public static long[] copy64(int r100, long[] r101) {
        long[] r102 = new long[r100];
        System.arraycopy(r101, 0, r102, 0, r100);
        return r102;
    }

    public static int[] create(int r100) {
        return new int[r100];
    }

    public static long[] create64(int r100) {
        return new long[r100];
    }

    public static int csub(int r110, int r111, int[] r112, int r113, int[] r114, int r115, int[] r116, int r117) {
        long r100 = ((long) (-(r111 & 1))) & 4294967295L;
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r110) goto L6;
        long r103 = r101 + ((((long) r112[r113 + r102]) & 4294967295L) - (((long) r114[r115 + r102]) & r100));
        r116[r117 + r102] = (int) r103;
        r101 = r103 >> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int csub(int r110, int r111, int[] r112, int[] r113, int[] r114) {
        long r100 = ((long) (-(r111 & 1))) & 4294967295L;
        long r101 = 0;
        int r115 = 0;
    L3:
        if (r115 >= r110) goto L6;
        long r102 = r101 + ((((long) r112[r115]) & 4294967295L) - (((long) r113[r115]) & r100));
        r114[r115] = (int) r102;
        r101 = r102 >> 32;
        r115 = r115 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int dec(int r100, int[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L9;
        int r103 = r101[r102] - 1;
        r101[r102] = r103;
        if (r103 != (-1)) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return 0;
    L9:
        return -1;
    }

    public static int dec(int r100, int[] r101, int[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= r100) goto L10;
        int r104 = r101[r103] - 1;
        r102[r103] = r104;
        r103 = r103 + 1;
        if (r104 == (-1)) goto L4;
    L7:
        if (r103 >= r100) goto L9;
        r102[r103] = r101[r103];
        r103 = r103 + 1;
        goto L7
    L9:
        return 0;
    L10:
        return -1;
    }

    public static int decAt(int r100, int[] r101, int r102) {
    L3:
        if (r102 >= r100) goto L9;
        int r103 = r101[r102] - 1;
        r101[r102] = r103;
        if (r103 != (-1)) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return 0;
    L9:
        return -1;
    }

    public static int decAt(int r100, int[] r101, int r102, int r103) {
    L3:
        if (r103 >= r100) goto L9;
        int r104 = r102 + r103;
        int r105 = r101[r104] - 1;
        r101[r104] = r105;
        if (r105 != (-1)) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return 0;
    L9:
        return -1;
    }

    public static boolean diff(int r100, int[] r101, int r110, int[] r111, int r112, int[] r113, int r114) {
        boolean r102 = gte(r100, r101, r110, r111, r112);
        if (r102 == false) goto L5;
        sub(r100, r101, r110, r111, r112, r113, r114);
    L6:
        return r102;
    L5:
        sub(r100, r111, r112, r101, r110, r113, r114);
        goto L6
    }

    public static boolean eq(int r100, int[] r101, int[] r102) {
        int r103 = r100 - 1;
    L3:
        if (r103 < 0) goto L9;
        if (r101[r103] != r102[r103]) goto L6;
        r103 = r103 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    public static int equalTo(int r100, int[] r101, int r102) {
        int r103 = r102 ^ r101[0];
        int r104 = 1;
    L3:
        if (r104 >= r100) goto L6;
        r103 = r103 | r101[r104];
        r104 = r104 + 1;
        goto L3
    L6:
        return (((r103 >>> 1) | (r103 & 1)) - 1) >> 31;
    }

    public static int equalTo(int r100, int[] r101, int r102, int r103) {
        int r104 = r103 ^ r101[r102];
        int r105 = 1;
    L3:
        if (r105 >= r100) goto L6;
        r104 = r104 | r101[r102 + r105];
        r105 = r105 + 1;
        goto L3
    L6:
        return (((r104 >>> 1) | (r104 & 1)) - 1) >> 31;
    }

    public static int equalTo(int r100, int[] r101, int r102, int[] r103, int r104) {
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= r100) goto L6;
        r106 = r106 | (r101[r102 + r105] ^ r103[r104 + r105]);
        r105 = r105 + 1;
        goto L3
    L6:
        return (((r106 >>> 1) | (r106 & 1)) - 1) >> 31;
    }

    public static int equalTo(int r100, int[] r101, int[] r102) {
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r100) goto L6;
        r104 = r104 | (r101[r103] ^ r102[r103]);
        r103 = r103 + 1;
        goto L3
    L6:
        return (((r104 >>> 1) | (r104 & 1)) - 1) >> 31;
    }

    public static int equalToZero(int r100, int[] r101) {
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r100) goto L6;
        r103 = r103 | r101[r102];
        r102 = r102 + 1;
        goto L3
    L6:
        return (((r103 >>> 1) | (r103 & 1)) - 1) >> 31;
    }

    public static int equalToZero(int r100, int[] r101, int r102) {
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r100) goto L6;
        r104 = r104 | r101[r102 + r103];
        r103 = r103 + 1;
        goto L3
    L6:
        return (((r104 >>> 1) | (r104 & 1)) - 1) >> 31;
    }

    public static int[] fromBigInteger(int r100, BigInteger r101) {
        if (r101.signum() < 0) goto L11;
        if (r101.bitLength() > r100) goto L11;
        int r102 = (r100 + 31) >> 5;
        int[] r103 = create(r102);
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L9;
        r103[r104] = r101.intValue();
        r101 = r101.shiftRight(32);
        r104 = r104 + 1;
        goto L7
    L9:
        return r103;
    L11:
        throw new IllegalArgumentException();
    }

    public static long[] fromBigInteger64(int r100, BigInteger r101) {
        if (r101.signum() < 0) goto L11;
        if (r101.bitLength() > r100) goto L11;
        int r102 = (r100 + 63) >> 6;
        long[] r103 = create64(r102);
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L9;
        r103[r104] = r101.longValue();
        r101 = r101.shiftRight(64);
        r104 = r104 + 1;
        goto L7
    L9:
        return r103;
    L11:
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
        if (r103 >= r100.length) goto L13;
        int r104 = r100[r103];
        r102 = r104 >>> (r101 & 31);
        goto L6
    }

    public static boolean gte(int r100, int[] r101, int r102, int[] r103, int r104) {
        int r105 = r100 - 1;
    L3:
        if (r105 < 0) goto L11;
        int r106 = r101[r102 + r105] ^ Integer.MIN_VALUE;
        int r107 = Integer.MIN_VALUE ^ r103[r104 + r105];
        if (r106 < r107) goto L6;
        if (r106 > r107) goto L9;
        r105 = r105 - 1;
        goto L3
    L9:
        return true;
    L6:
        return false;
    L11:
        return true;
    }

    public static boolean gte(int r100, int[] r101, int[] r102) {
        int r103 = r100 - 1;
    L3:
        if (r103 < 0) goto L11;
        int r104 = r101[r103] ^ Integer.MIN_VALUE;
        int r105 = Integer.MIN_VALUE ^ r102[r103];
        if (r104 < r105) goto L6;
        if (r104 > r105) goto L9;
        r103 = r103 - 1;
        goto L3
    L9:
        return true;
    L6:
        return false;
    L11:
        return true;
    }

    public static int inc(int r100, int[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L9;
        int r103 = r101[r102] + 1;
        r101[r102] = r103;
        if (r103 != 0) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return 0;
    L9:
        return 1;
    }

    public static int inc(int r100, int[] r101, int[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= r100) goto L10;
        int r104 = r101[r103] + 1;
        r102[r103] = r104;
        r103 = r103 + 1;
        if (r104 == 0) goto L4;
    L7:
        if (r103 >= r100) goto L9;
        r102[r103] = r101[r103];
        r103 = r103 + 1;
        goto L7
    L9:
        return 0;
    L10:
        return 1;
    }

    public static int incAt(int r100, int[] r101, int r102) {
    L3:
        if (r102 >= r100) goto L9;
        int r103 = r101[r102] + 1;
        r101[r102] = r103;
        if (r103 != 0) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return 0;
    L9:
        return 1;
    }

    public static int incAt(int r100, int[] r101, int r102, int r103) {
    L3:
        if (r103 >= r100) goto L9;
        int r104 = r102 + r103;
        int r105 = r101[r104] + 1;
        r101[r104] = r105;
        if (r105 != 0) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return 0;
    L9:
        return 1;
    }

    public static boolean isOne(int r100, int[] r101) {
        if (r101[0] == 1) goto L5;
        return false;
    L5:
        int r102 = 1;
    L6:
        if (r102 >= r100) goto L11;
        if (r101[r102] != 0) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static boolean isZero(int r100, int[] r101) {
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L8;
        if (r101[r102] != 0) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static int lessThan(int r100, int[] r110, int r111, int[] r112, int r113) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        r101 = (r101 + ((((long) r110[r111 + r102]) & 4294967295L) - (4294967295L & ((long) r112[r113 + r102])))) >> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int lessThan(int r100, int[] r110, int[] r111) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        r101 = (r101 + ((((long) r110[r102]) & 4294967295L) - (4294967295L & ((long) r111[r102])))) >> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static void mul(int r100, int[] r101, int r110, int[] r111, int r112, int[] r113, int r114) {
        r113[r114 + r100] = mulWord(r100, r101[r110], r111, r112, r113, r114);
        int r102 = 1;
    L3:
        if (r102 >= r100) goto L5;
        int r103 = r114 + r102;
        r113[r103 + r100] = mulWordAddTo(r100, r101[r110 + r102], r111, r112, r113, r103);
        r102 = r102 + 1;
        goto L3
    }

    public static void mul(int r100, int[] r101, int[] r110, int[] r111) {
        r111[r100] = mulWord(r100, r101[0], r110, r111);
        int r102 = 1;
    L3:
        if (r102 >= r100) goto L5;
        r111[r102 + r100] = mulWordAddTo(r100, r101[r102], r110, 0, r111, r102);
        r102 = r102 + 1;
        goto L3
    }

    public static void mul(int[] r100, int r101, int r110, int[] r111, int r112, int r113, int[] r114, int r115) {
        r114[r115 + r113] = mulWord(r113, r100[r101], r111, r112, r114, r115);
        int r102 = 1;
    L3:
        if (r102 >= r110) goto L5;
        int r103 = r115 + r102;
        r114[r103 + r113] = mulWordAddTo(r113, r100[r101 + r102], r111, r112, r114, r103);
        r102 = r102 + 1;
        goto L3
    }

    public static int mul31BothAdd(int r110, int r111, int[] r112, int r113, int[] r114, int[] r115, int r210) {
        long r100 = ((long) r111) & 4294967295L;
        long r101 = ((long) r113) & 4294967295L;
        long r102 = 0;
        int r103 = 0;
    L3:
        long r104 = ((((long) r112[r103]) & 4294967295L) * r100) + ((((long) r114[r103]) & 4294967295L) * r101);
        int r116 = r210 + r103;
        long r105 = r102 + (r104 + (((long) r115[r116]) & 4294967295L));
        r115[r116] = (int) r105;
        r102 = r105 >>> 32;
        r103 = r103 + 1;
        if (r103 < r110) goto L3;
        return (int) r102;
    }

    public static int mulAddTo(int r100, int[] r110, int r111, int[] r112, int r113, int[] r114, int r115) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = r101 + (((long) mulWordAddTo(r100, r110[r111 + r102], r112, r113, r114, r115)) & 4294967295L);
        int r104 = r115 + r100;
        long r105 = r103 + (((long) r114[r104]) & 4294967295L);
        r114[r104] = (int) r105;
        r101 = r105 >>> 32;
        r115 = r115 + 1;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int mulAddTo(int r100, int[] r110, int[] r111, int[] r112) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = r101 + (((long) mulWordAddTo(r100, r110[r102], r111, 0, r112, r102)) & 4294967295L);
        int r104 = r102 + r100;
        long r105 = r103 + (((long) r112[r104]) & 4294967295L);
        r112[r104] = (int) r105;
        r101 = r105 >>> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int mulWord(int r100, int r101, int[] r110, int r111, int[] r112, int r113) {
        long r102 = ((long) r101) & 4294967295L;
        long r103 = 0;
        int r104 = 0;
    L3:
        long r105 = r103 + ((((long) r110[r111 + r104]) & 4294967295L) * r102);
        r112[r113 + r104] = (int) r105;
        r103 = r105 >>> 32;
        r104 = r104 + 1;
        if (r104 < r100) goto L3;
        return (int) r103;
    }

    public static int mulWord(int r100, int r101, int[] r110, int[] r111) {
        long r102 = ((long) r101) & 4294967295L;
        long r103 = 0;
        int r104 = 0;
    L3:
        long r105 = r103 + ((((long) r110[r104]) & 4294967295L) * r102);
        r111[r104] = (int) r105;
        r103 = r105 >>> 32;
        r104 = r104 + 1;
        if (r104 < r100) goto L3;
        return (int) r103;
    }

    public static int mulWordAddTo(int r110, int r111, int[] r112, int r113, int[] r114, int r115) {
        long r100 = ((long) r111) & 4294967295L;
        long r101 = 0;
        int r102 = 0;
    L3:
        int r103 = r115 + r102;
        long r104 = r101 + (((((long) r112[r113 + r102]) & 4294967295L) * r100) + (((long) r114[r103]) & 4294967295L));
        r114[r103] = (int) r104;
        r101 = r104 >>> 32;
        r102 = r102 + 1;
        if (r102 < r110) goto L3;
        return (int) r101;
    }

    public static int mulWordDwordAddAt(int r110, int r111, long r112, int[] r113, int r114) {
        long r100 = ((long) r111) & 4294967295L;
        int r115 = r114 + 0;
        long r101 = (((r112 & 4294967295L) * r100) + (((long) r113[r115]) & 4294967295L)) + 0;
        r113[r115] = (int) r101;
        long r102 = r100 * (r112 >>> 32);
        int r116 = r114 + 1;
        long r103 = (r101 >>> 32) + (r102 + (((long) r113[r116]) & 4294967295L));
        r113[r116] = (int) r103;
        int r104 = r114 + 2;
        long r117 = (r103 >>> 32) + (((long) r113[r104]) & 4294967295L);
        r113[r104] = (int) r117;
        if ((r117 >>> 32) != 0) goto L6;
        return 0;
    L6:
        return incAt(r110, r113, r114 + 3);
    }

    public static int shiftDownBit(int r100, int[] r101, int r102) {
    L2:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        int r103 = r101[r100];
        r101[r100] = (r102 << 31) | (r103 >>> 1);
        r102 = r103;
        goto L2
    L6:
        return r102 << 31;
    }

    public static int shiftDownBit(int r100, int[] r101, int r102, int r103) {
    L2:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        int r104 = r102 + r100;
        int r105 = r101[r104];
        r101[r104] = (r103 << 31) | (r105 >>> 1);
        r103 = r105;
        goto L2
    L6:
        return r103 << 31;
    }

    public static int shiftDownBit(int r100, int[] r101, int r102, int r103, int[] r104, int r105) {
    L2:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        int r106 = r101[r102 + r100];
        r104[r105 + r100] = (r103 << 31) | (r106 >>> 1);
        r103 = r106;
        goto L2
    L6:
        return r103 << 31;
    }

    public static int shiftDownBit(int r100, int[] r101, int r102, int[] r103) {
    L2:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        int r104 = r101[r100];
        r103[r100] = (r102 << 31) | (r104 >>> 1);
        r102 = r104;
        goto L2
    L6:
        return r102 << 31;
    }

    public static int shiftDownBits(int r100, int[] r101, int r102, int r103) {
    L2:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        int r104 = r101[r100];
        r101[r100] = (r103 << (-r102)) | (r104 >>> r102);
        r103 = r104;
        goto L2
    L6:
        return r103 << (-r102);
    }

    public static int shiftDownBits(int r100, int[] r101, int r102, int r103, int r104) {
    L2:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        int r105 = r102 + r100;
        int r106 = r101[r105];
        r101[r105] = (r104 << (-r103)) | (r106 >>> r103);
        r104 = r106;
        goto L2
    L6:
        return r104 << (-r103);
    }

    public static int shiftDownBits(int r100, int[] r101, int r102, int r103, int r104, int[] r105, int r110) {
    L2:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        int r106 = r101[r102 + r100];
        r105[r110 + r100] = (r104 << (-r103)) | (r106 >>> r103);
        r104 = r106;
        goto L2
    L6:
        return r104 << (-r103);
    }

    public static int shiftDownBits(int r100, int[] r101, int r102, int r103, int[] r104) {
    L2:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        int r105 = r101[r100];
        r104[r100] = (r103 << (-r102)) | (r105 >>> r102);
        r103 = r105;
        goto L2
    L6:
        return r103 << (-r102);
    }

    public static int shiftDownWord(int r100, int[] r101, int r102) {
    L2:
        r100 = r100 - 1;
        if (r100 < 0) goto L5;
        int r103 = r101[r100];
        r101[r100] = r102;
        r102 = r103;
        goto L2
    L5:
        return r102;
    }

    public static int shiftUpBit(int r100, int[] r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L6;
        int r104 = r101[r103];
        int r105 = r102 >>> 31;
        r101[r103] = r105 | (r104 << 1);
        r103 = r103 + 1;
        r102 = r104;
        goto L3
    L6:
        return r102 >>> 31;
    }

    public static int shiftUpBit(int r100, int[] r101, int r102, int r103) {
        int r104 = 0;
    L3:
        if (r104 >= r100) goto L6;
        int r105 = r102 + r104;
        int r106 = r101[r105];
        int r107 = r103 >>> 31;
        r101[r105] = r107 | (r106 << 1);
        r104 = r104 + 1;
        r103 = r106;
        goto L3
    L6:
        return r103 >>> 31;
    }

    public static int shiftUpBit(int r100, int[] r101, int r102, int r103, int[] r104, int r105) {
        int r106 = 0;
    L3:
        if (r106 >= r100) goto L6;
        int r107 = r101[r102 + r106];
        int r108 = r103 >>> 31;
        r104[r105 + r106] = r108 | (r107 << 1);
        r106 = r106 + 1;
        r103 = r107;
        goto L3
    L6:
        return r103 >>> 31;
    }

    public static int shiftUpBit(int r100, int[] r101, int r102, int[] r103) {
        int r104 = 0;
    L3:
        if (r104 >= r100) goto L6;
        int r105 = r101[r104];
        int r106 = r102 >>> 31;
        r103[r104] = r106 | (r105 << 1);
        r104 = r104 + 1;
        r102 = r105;
        goto L3
    L6:
        return r102 >>> 31;
    }

    public static long shiftUpBit64(int r100, long[] r101, int r102, long r110, long[] r111, int r112) {
        int r103 = 0;
    L4:
        if (r103 >= r100) goto L7;
        long r104 = r101[r102 + r103];
        long r113 = r110 >>> 63;
        r111[r112 + r103] = r113 | (r104 << 1);
        r103 = r103 + 1;
        r110 = r104;
        goto L4
    L7:
        return r110 >>> 63;
    }

    public static int shiftUpBits(int r100, int[] r101, int r102, int r103) {
        int r104 = 0;
    L3:
        if (r104 >= r100) goto L6;
        int r105 = r101[r104];
        int r106 = r103 >>> (-r102);
        r101[r104] = r106 | (r105 << r102);
        r104 = r104 + 1;
        r103 = r105;
        goto L3
    L6:
        return r103 >>> (-r102);
    }

    public static int shiftUpBits(int r100, int[] r101, int r102, int r103, int r104) {
        int r105 = 0;
    L3:
        if (r105 >= r100) goto L6;
        int r106 = r102 + r105;
        int r107 = r101[r106];
        int r108 = r104 >>> (-r103);
        r101[r106] = r108 | (r107 << r103);
        r105 = r105 + 1;
        r104 = r107;
        goto L3
    L6:
        return r104 >>> (-r103);
    }

    public static int shiftUpBits(int r100, int[] r101, int r102, int r103, int r104, int[] r110, int r111) {
        int r105 = 0;
    L3:
        if (r105 >= r100) goto L6;
        int r106 = r101[r102 + r105];
        int r107 = r104 >>> (-r103);
        r110[r111 + r105] = r107 | (r106 << r103);
        r105 = r105 + 1;
        r104 = r106;
        goto L3
    L6:
        return r104 >>> (-r103);
    }

    public static int shiftUpBits(int r100, int[] r101, int r102, int r103, int[] r104) {
        int r105 = 0;
    L3:
        if (r105 >= r100) goto L6;
        int r106 = r101[r105];
        int r107 = r103 >>> (-r102);
        r104[r105] = r107 | (r106 << r102);
        r105 = r105 + 1;
        r103 = r106;
        goto L3
    L6:
        return r103 >>> (-r102);
    }

    public static long shiftUpBits64(int r100, long[] r101, int r102, int r110, long r111) {
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L6;
        int r104 = r102 + r103;
        long r105 = r101[r104];
        long r112 = r111 >>> (-r110);
        r101[r104] = r112 | (r105 << r110);
        r103 = r103 + 1;
        r111 = r105;
        goto L3
    L6:
        return r111 >>> (-r110);
    }

    public static long shiftUpBits64(int r100, long[] r101, int r102, int r110, long r111, long[] r112, int r113) {
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L6;
        long r104 = r101[r102 + r103];
        long r114 = r111 >>> (-r110);
        r112[r113 + r103] = r114 | (r104 << r110);
        r103 = r103 + 1;
        r111 = r104;
        goto L3
    L6:
        return r111 >>> (-r110);
    }

    public static void square(int r110, int[] r111, int r112, int[] r113, int r114) {
        int r100 = r110 << 1;
        int r101 = 0;
        int r102 = r110;
        int r103 = r100;
    L3:
        r102 = r102 - 1;
        long r104 = ((long) r111[r112 + r102]) & 4294967295L;
        long r105 = r104 * r104;
        int r106 = r103 - 1;
        r113[r114 + r106] = (r101 << 31) | ((int) (r105 >>> 33));
        r103 = r106 - 1;
        int r107 = 1;
        r113[r114 + r103] = (int) (r105 >>> 1);
        r101 = (int) r105;
        if (r102 > 0) goto L3;
        int r108 = r114 + 2;
        long r109 = 0;
    L6:
        if (r107 >= r110) goto L8;
        long r115 = (r109 + (((long) squareWordAddTo(r111, r112, r107, r113, r114)) & 4294967295L)) + (((long) r113[r108]) & 4294967295L);
        int r116 = r108 + 1;
        r113[r108] = (int) r115;
        long r117 = (r115 >>> 32) + (((long) r113[r116]) & 4294967295L);
        r113[r116] = (int) r117;
        r109 = r117 >>> 32;
        r107 = r107 + 1;
        r108 = r116 + 1;
        goto L6
    L8:
        shiftUpBit(r100, r113, r114, r111[r112] << 31);
    }

    public static void square(int r110, int[] r111, int[] r112) {
        int r100 = r110 << 1;
        int r101 = 0;
        int r102 = r110;
        int r103 = r100;
    L3:
        r102 = r102 - 1;
        long r104 = ((long) r111[r102]) & 4294967295L;
        long r105 = r104 * r104;
        int r106 = r103 - 1;
        r112[r106] = (r101 << 31) | ((int) (r105 >>> 33));
        r103 = r106 - 1;
        int r107 = 1;
        r112[r103] = (int) (r105 >>> 1);
        int r108 = (int) r105;
        if (r102 <= 0) goto L5;
        r101 = r108;
        goto L3
    L5:
        long r109 = 0;
        int r113 = 2;
    L6:
        if (r107 >= r110) goto L8;
        long r114 = (r109 + (((long) squareWordAddTo(r111, r107, r112)) & 4294967295L)) + (((long) r112[r113]) & 4294967295L);
        int r115 = r113 + 1;
        r112[r113] = (int) r114;
        long r116 = (r114 >>> 32) + (((long) r112[r115]) & 4294967295L);
        r112[r115] = (int) r116;
        r109 = r116 >>> 32;
        r107 = r107 + 1;
        r113 = r115 + 1;
        goto L6
    L8:
        shiftUpBit(r100, r112, r111[0] << 31);
    }

    public static int squareWordAdd(int[] r110, int r111, int r112, int[] r113, int r114) {
        long r100 = ((long) r110[r111 + r112]) & 4294967295L;
        long r101 = 0;
        int r102 = 0;
        int r103 = r114;
    L3:
        int r115 = r112 + r103;
        long r104 = r101 + (((((long) r110[r111 + r102]) & 4294967295L) * r100) + (((long) r113[r115]) & 4294967295L));
        r113[r115] = (int) r104;
        r101 = r104 >>> 32;
        r103 = r103 + 1;
        r102 = r102 + 1;
        if (r102 < r112) goto L3;
        return (int) r101;
    }

    public static int squareWordAdd(int[] r110, int r111, int[] r112) {
        long r100 = ((long) r110[r111]) & 4294967295L;
        long r101 = 0;
        int r102 = 0;
    L3:
        int r103 = r111 + r102;
        long r104 = r101 + (((((long) r110[r102]) & 4294967295L) * r100) + (((long) r112[r103]) & 4294967295L));
        r112[r103] = (int) r104;
        r101 = r104 >>> 32;
        r102 = r102 + 1;
        if (r102 < r111) goto L3;
        return (int) r101;
    }

    public static int squareWordAddTo(int[] r110, int r111, int r112, int[] r113, int r114) {
        long r100 = ((long) r110[r111 + r112]) & 4294967295L;
        long r101 = 0;
        int r102 = 0;
        int r103 = r114;
    L3:
        int r115 = r112 + r103;
        long r104 = r101 + (((((long) r110[r111 + r102]) & 4294967295L) * r100) + (((long) r113[r115]) & 4294967295L));
        r113[r115] = (int) r104;
        r101 = r104 >>> 32;
        r103 = r103 + 1;
        r102 = r102 + 1;
        if (r102 < r112) goto L3;
        return (int) r101;
    }

    public static int squareWordAddTo(int[] r110, int r111, int[] r112) {
        long r100 = ((long) r110[r111]) & 4294967295L;
        long r101 = 0;
        int r102 = 0;
    L3:
        int r103 = r111 + r102;
        long r104 = r101 + (((((long) r110[r102]) & 4294967295L) * r100) + (((long) r112[r103]) & 4294967295L));
        r112[r103] = (int) r104;
        r101 = r104 >>> 32;
        r102 = r102 + 1;
        if (r102 < r111) goto L3;
        return (int) r101;
    }

    public static int sub(int r100, int[] r110, int r111, int[] r112, int r113, int[] r114, int r115) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = r101 + ((((long) r110[r111 + r102]) & 4294967295L) - (4294967295L & ((long) r112[r113 + r102])));
        r114[r115 + r102] = (int) r103;
        r101 = r103 >> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int sub(int r100, int[] r110, int[] r111, int[] r112) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = r101 + ((((long) r110[r102]) & 4294967295L) - (4294967295L & ((long) r111[r102])));
        r112[r102] = (int) r103;
        r101 = r103 >> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int sub33At(int r100, int r101, int[] r102, int r110) {
        int r103 = r110 + 0;
        long r104 = (((long) r102[r103]) & 4294967295L) - (((long) r101) & 4294967295L);
        r102[r103] = (int) r104;
        int r105 = r110 + 1;
        long r106 = (r104 >> 32) + ((4294967295L & ((long) r102[r105])) - 1);
        r102[r105] = (int) r106;
        if ((r106 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r102, r110 + 2);
    }

    public static int sub33At(int r100, int r101, int[] r102, int r110, int r111) {
        int r103 = r110 + r111;
        long r104 = (((long) r102[r103]) & 4294967295L) - (((long) r101) & 4294967295L);
        r102[r103] = (int) r104;
        int r105 = r103 + 1;
        long r106 = (r104 >> 32) + ((4294967295L & ((long) r102[r105])) - 1);
        r102[r105] = (int) r106;
        if ((r106 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r102, r110, r111 + 2);
    }

    public static int sub33From(int r100, int r101, int[] r110) {
        long r102 = (((long) r110[0]) & 4294967295L) - (((long) r101) & 4294967295L);
        r110[0] = (int) r102;
        long r103 = (r102 >> 32) + ((4294967295L & ((long) r110[1])) - 1);
        r110[1] = (int) r103;
        if ((r103 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r110, 2);
    }

    public static int sub33From(int r100, int r101, int[] r102, int r110) {
        int r103 = r110 + 0;
        long r104 = (((long) r102[r103]) & 4294967295L) - (((long) r101) & 4294967295L);
        r102[r103] = (int) r104;
        int r105 = r110 + 1;
        long r106 = (r104 >> 32) + ((4294967295L & ((long) r102[r105])) - 1);
        r102[r105] = (int) r106;
        if ((r106 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r102, r110, 2);
    }

    public static int subBothFrom(int r110, int[] r111, int r112, int[] r113, int r114, int[] r115, int r116) {
        long r100 = 0;
        int r101 = 0;
    L3:
        if (r101 >= r110) goto L6;
        int r102 = r116 + r101;
        long r103 = r100 + (((((long) r115[r102]) & 4294967295L) - (((long) r111[r112 + r101]) & 4294967295L)) - (4294967295L & ((long) r113[r114 + r101])));
        r115[r102] = (int) r103;
        r100 = r103 >> 32;
        r101 = r101 + 1;
        goto L3
    L6:
        return (int) r100;
    }

    public static int subBothFrom(int r100, int[] r110, int[] r111, int[] r112) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = r101 + (((((long) r112[r102]) & 4294967295L) - (((long) r110[r102]) & 4294967295L)) - (4294967295L & ((long) r111[r102])));
        r112[r102] = (int) r103;
        r101 = r103 >> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int subDWordAt(int r100, long r101, int[] r110, int r111) {
        int r102 = r111 + 0;
        long r103 = (((long) r110[r102]) & 4294967295L) - (r101 & 4294967295L);
        r110[r102] = (int) r103;
        int r104 = r111 + 1;
        long r105 = (r103 >> 32) + ((4294967295L & ((long) r110[r104])) - (r101 >>> 32));
        r110[r104] = (int) r105;
        if ((r105 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r110, r111 + 2);
    }

    public static int subDWordAt(int r100, long r101, int[] r110, int r111, int r112) {
        int r102 = r111 + r112;
        long r103 = (((long) r110[r102]) & 4294967295L) - (r101 & 4294967295L);
        r110[r102] = (int) r103;
        int r104 = r102 + 1;
        long r105 = (r103 >> 32) + ((4294967295L & ((long) r110[r104])) - (r101 >>> 32));
        r110[r104] = (int) r105;
        if ((r105 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r110, r111, r112 + 2);
    }

    public static int subDWordFrom(int r100, long r110, int[] r111) {
        long r101 = (((long) r111[0]) & 4294967295L) - (r110 & 4294967295L);
        r111[0] = (int) r101;
        long r102 = (r101 >> 32) + ((4294967295L & ((long) r111[1])) - (r110 >>> 32));
        r111[1] = (int) r102;
        if ((r102 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r111, 2);
    }

    public static int subDWordFrom(int r100, long r101, int[] r110, int r111) {
        int r102 = r111 + 0;
        long r103 = (((long) r110[r102]) & 4294967295L) - (r101 & 4294967295L);
        r110[r102] = (int) r103;
        int r104 = r111 + 1;
        long r105 = (r103 >> 32) + ((4294967295L & ((long) r110[r104])) - (r101 >>> 32));
        r110[r104] = (int) r105;
        if ((r105 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r110, r111, 2);
    }

    public static int subFrom(int r110, int[] r111, int r112, int[] r113, int r114) {
        long r100 = 0;
        int r101 = 0;
    L3:
        if (r101 >= r110) goto L6;
        int r102 = r114 + r101;
        long r103 = r100 + ((((long) r113[r102]) & 4294967295L) - (4294967295L & ((long) r111[r112 + r101])));
        r113[r102] = (int) r103;
        r100 = r103 >> 32;
        r101 = r101 + 1;
        goto L3
    L6:
        return (int) r100;
    }

    public static int subFrom(int r100, int[] r110, int[] r111) {
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L6;
        long r103 = r101 + ((((long) r111[r102]) & 4294967295L) - (4294967295L & ((long) r110[r102])));
        r111[r102] = (int) r103;
        r101 = r103 >> 32;
        r102 = r102 + 1;
        goto L3
    L6:
        return (int) r101;
    }

    public static int subWordAt(int r100, int r101, int[] r102, int r103) {
        long r104 = (((long) r102[r103]) & 4294967295L) - (4294967295L & ((long) r101));
        r102[r103] = (int) r104;
        if ((r104 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r102, r103 + 1);
    }

    public static int subWordAt(int r100, int r101, int[] r102, int r110, int r111) {
        int r103 = r110 + r111;
        long r104 = (((long) r102[r103]) & 4294967295L) - (4294967295L & ((long) r101));
        r102[r103] = (int) r104;
        if ((r104 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r102, r110, r111 + 1);
    }

    public static int subWordFrom(int r100, int r101, int[] r102) {
        long r103 = (((long) r102[0]) & 4294967295L) - (4294967295L & ((long) r101));
        r102[0] = (int) r103;
        if ((r103 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r102, 1);
    }

    public static int subWordFrom(int r100, int r101, int[] r102, int r110) {
        int r103 = r110 + 0;
        long r104 = (((long) r102[r103]) & 4294967295L) - (4294967295L & ((long) r101));
        r102[r103] = (int) r104;
        if ((r104 >> 32) != 0) goto L6;
        return 0;
    L6:
        return decAt(r100, r102, r110, 1);
    }

    public static BigInteger toBigInteger(int r100, int[] r101) {
        byte[] r102 = new byte[r100 << 2];
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L9;
        int r104 = r101[r103];
        if (r104 == 0) goto L7;
        Pack.intToBigEndian(r104, r102, ((r100 - 1) - r103) << 2);
    L7:
        r103 = r103 + 1;
        goto L3
    L9:
        return new BigInteger(1, r102);
    }

    public static void zero(int r100, int[] r101) {
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = 0;
        r102 = r102 + 1;
        goto L3
    }

    public static void zero(int r100, int[] r101, int r102) {
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L5;
        r101[r102 + r103] = 0;
        r103 = r103 + 1;
        goto L3
    }

    public static void zero64(int r100, long[] r101) {
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = 0;
        r102 = r102 + 1;
        goto L3
    }
}
