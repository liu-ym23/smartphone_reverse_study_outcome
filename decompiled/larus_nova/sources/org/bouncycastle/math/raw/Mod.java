package org.bouncycastle.math.raw;

import java.util.Random;
import org.bouncycastle.util.Integers;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Mod {
    private static final int M30 = 1073741823;
    private static final long M32L = 4294967295L;

    public Mod() {
    }

    public static void add(int[] r100, int[] r101, int[] r102, int[] r103) {
        int r104 = r100.length;
        if (Nat.add(r104, r101, r102, r103) == 0) goto L6;
        Nat.subFrom(r104, r100, r103);
        return;
    }

    private static int add30(int r100, int[] r101, int[] r102) {
        int r103 = r100 - 1;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L5;
        int r106 = r105 + (r101[r104] + r102[r104]);
        r101[r104] = M30 & r106;
        r105 = r106 >> 30;
        r104 = r104 + 1;
        goto L3
    L5:
        int r107 = r105 + (r101[r103] + r102[r103]);
        r101[r103] = r107;
        return r107 >> 30;
    }

    public static void checkedModOddInverse(int[] r100, int[] r101, int[] r102) {
        if (modOddInverse(r100, r101, r102) == 0) goto L6;
        return;
    L6:
        throw new ArithmeticException("Inverse does not exist.");
    }

    public static void checkedModOddInverseVar(int[] r100, int[] r101, int[] r102) {
        if (modOddInverseVar(r100, r101, r102) == false) goto L6;
        return;
    L6:
        throw new ArithmeticException("Inverse does not exist.");
    }

    private static void cnegate30(int r100, int r101, int[] r102) {
        int r103 = r100 - 1;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L5;
        int r106 = r105 + ((r102[r104] ^ r101) - r101);
        r102[r104] = M30 & r106;
        r105 = r106 >> 30;
        r104 = r104 + 1;
        goto L3
    L5:
        r102[r103] = r105 + ((r102[r103] ^ r101) - r101);
    }

    private static void cnormalize30(int r100, int r101, int[] r102, int[] r110) {
        int r103 = r100 - 1;
        int r104 = r102[r103] >> 31;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L4:
        if (r106 >= r103) goto L6;
        int r108 = r107 + (((r102[r106] + (r110[r106] & r104)) ^ r101) - r101);
        r102[r106] = M30 & r108;
        r107 = r108 >> 30;
        r106 = r106 + 1;
        goto L4
    L6:
        int r109 = r107 + (((r102[r103] + (r104 & r110[r103])) ^ r101) - r101);
        r102[r103] = r109;
        int r111 = r109 >> 31;
        int r112 = 0;
    L7:
        if (r105 >= r103) goto L9;
        int r113 = r112 + (r102[r105] + (r110[r105] & r111));
        r102[r105] = r113 & M30;
        r112 = r113 >> 30;
        r105 = r105 + 1;
        goto L7
    L9:
        r102[r103] = r112 + (r102[r103] + (r111 & r110[r103]));
    }

    private static void decode30(int r100, int[] r101, int r102, int[] r103, int r110) {
        int r104 = 0;
        long r105 = 0;
    L3:
        if (r100 <= 0) goto L8;
    L5:
        if (r104 >= Math.min(32, r100)) goto L7;
        r105 = r105 | (((long) r101[r102]) << r104);
        r104 = r104 + 30;
        r102 = r102 + 1;
        goto L5
    L7:
        r103[r110] = (int) r105;
        r105 = r105 >>> 32;
        r104 = r104 - 32;
        r100 = r100 - 32;
        r110 = r110 + 1;
        goto L3
    }

    private static int divsteps30(int r110, int r111, int r112, int[] r113) {
        int r100 = 0;
        int r101 = 1;
        int r102 = 0;
        int r103 = 0;
        int r104 = 1;
    L4:
        if (r100 >= 30) goto L6;
        int r105 = r110 >> 31;
        int r106 = -(r112 & 1);
        int r114 = r112 + (((r111 ^ r105) - r105) & r106);
        r103 = r103 + (((r101 ^ r105) - r105) & r106);
        r104 = r104 + (((r102 ^ r105) - r105) & r106);
        int r107 = r105 & r106;
        r110 = (r110 ^ r107) - (r107 + 1);
        r111 = r111 + (r114 & r107);
        int r108 = r101 + (r103 & r107);
        r112 = r114 >> 1;
        r101 = r108 << 1;
        r102 = (r102 + (r107 & r104)) << 1;
        r100 = r100 + 1;
        goto L4
    L6:
        r113[0] = r101;
        r113[1] = r102;
        r113[2] = r103;
        r113[3] = r104;
        return r110;
    }

    private static int divsteps30Var(int r110, int r111, int r112, int[] r210) {
        int r100 = r110;
        int r101 = r111;
        int r102 = r112;
        int r103 = 30;
        int r104 = 1;
        int r105 = 0;
        int r106 = 0;
        int r107 = 1;
    L3:
        int r113 = Integers.numberOfTrailingZeros(((-1) << r103) | r102);
        int r108 = r102 >> r113;
        r104 = r104 << r113;
        r105 = r105 << r113;
        r100 = r100 - r113;
        r103 = r103 - r113;
        if (r103 <= 0) goto L5;
        if (r100 >= 0) goto L12;
        r100 = -r100;
        int r109 = -r101;
        int r114 = -r104;
        int r115 = -r105;
        int r116 = r100 + 1;
        if (r116 <= r103) goto L11;
        r116 = r103;
    L11:
        int r117 = (((-1) >>> (32 - r116)) & 63) & ((r108 * r109) * ((r108 * r108) - 2));
        r108 = r109;
        r101 = r108;
        int r118 = r106;
        r106 = r114;
        r104 = r118;
        int r119 = r107;
        r107 = r115;
        r105 = r119;
    L16:
        r102 = r108 + (r101 * r117);
        r106 = r106 + (r104 * r117);
        r107 = r107 + (r117 * r105);
        goto L3
    L12:
        int r120 = r100 + 1;
        if (r120 <= r103) goto L15;
        r120 = r103;
    L15:
        r117 = (((-1) >>> (32 - r120)) & 15) & ((-((((r101 + 1) & 4) << 1) + r101)) * r108);
        goto L16
    L5:
        r210[0] = r104;
        r210[1] = r105;
        r210[2] = r106;
        r210[3] = r107;
        return r100;
    }

    private static void encode30(int r100, int[] r110, int r111, int[] r112, int r113) {
        int r101 = 0;
        long r102 = 0;
    L3:
        if (r100 <= 0) goto L8;
        if (r101 >= Math.min(30, r100)) goto L7;
        r102 = r102 | ((((long) r110[r111]) & 4294967295L) << r101);
        r101 = r101 + 32;
        r111 = r111 + 1;
    L7:
        r112[r113] = ((int) r102) & M30;
        r102 = r102 >>> 30;
        r101 = r101 - 30;
        r100 = r100 - 30;
        r113 = r113 + 1;
        goto L3
    }

    private static int getMaximumDivsteps(int r100) {
        int r101 = r100 * 49;
        if (r100 >= 46) goto L5;
        int r102 = 80;
    L7:
        return (r101 + r102) / 17;
    L5:
        r102 = 47;
        goto L7
    }

    public static int inverse32(int r100) {
        int r101 = (2 - (r100 * r100)) * r100;
        int r102 = r101 * (2 - (r100 * r101));
        int r103 = r102 * (2 - (r100 * r102));
        return r103 * (2 - (r100 * r103));
    }

    public static void invert(int[] r100, int[] r101, int[] r102) {
        checkedModOddInverseVar(r100, r101, r102);
    }

    public static int modOddInverse(int[] r110, int[] r210, int[] r211) {
        int r100 = r110.length;
        int r101 = (r100 << 5) - Integers.numberOfLeadingZeros(r110[r100 - 1]);
        int r102 = (r101 + 29) / 30;
        int[] r111 = new int[4];
        int[] r112 = new int[r102];
        int[] r113 = new int[r102];
        int[] r114 = new int[r102];
        int[] r115 = new int[r102];
        int[] r116 = new int[r102];
        char r103 = 0;
        r113[0] = 1;
        encode30(r101, r210, 0, r115, 0);
        encode30(r101, r110, 0, r116, 0);
        System.arraycopy(r116, 0, r114, 0, r102);
        int r104 = inverse32(r116[0]);
        int r105 = getMaximumDivsteps(r101);
        int r106 = -1;
        int r107 = 0;
    L3:
        if (r107 >= r105) goto L5;
        int r117 = divsteps30(r106, r114[r103], r115[r103], r111);
        updateDE30(r102, r112, r113, r111, r104, r116);
        updateFG30(r102, r114, r115, r111);
        r107 = r107 + 30;
        r106 = r117;
        r105 = r105;
        r103 = 0;
        goto L3
    L5:
        int r108 = r114[r102 - 1] >> 31;
        cnegate30(r102, r108, r114);
        cnormalize30(r102, r108, r112, r116);
        decode30(r101, r112, 0, r211, 0);
        return Nat.equalTo(r102, r114, 1) & Nat.equalToZero(r102, r115);
    }

    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v3 */
    public static boolean modOddInverseVar(int[] r210, int[] r211, int[] r212) {
        int r100 = r210.length;
        int r101 = (r100 << 5) - Integers.numberOfLeadingZeros(r210[r100 - 1]);
        int r102 = (r101 + 29) / 30;
        int[] r110 = new int[4];
        int[] r111 = new int[r102];
        int[] r112 = new int[r102];
        int[] r113 = new int[r102];
        int[] r114 = new int[r102];
        int[] r115 = new int[r102];
        ?? r103 = 0;
        r112[0] = 1;
        encode30(r101, r211, 0, r114, 0);
        encode30(r101, r210, 0, r115, 0);
        System.arraycopy(r115, 0, r113, 0, r102);
        int r104 = r102 - 1;
        int r105 = (-1) - (Integers.numberOfLeadingZeros(r114[r104] | 1) - (((r102 * 30) + 2) - r101));
        int r116 = inverse32(r115[0]);
        int r106 = getMaximumDivsteps(r101);
        int r107 = r102;
        int r108 = 0;
    L4:
        if (Nat.isZero(r107, r114) == true) goto L12;
        if (r108 >= r106) goto L6;
        int r117 = r108 + 30;
        int r118 = divsteps30Var(r105, r113[r103], r114[r103], r110);
        int r109 = r107;
        int r119 = r106;
        int[] r213 = r112;
        updateDE30(r102, r111, r112, r110, r116, r115);
        updateFG30(r109, r113, r114, r110);
        int r120 = r109 - 1;
        int r121 = r113[r120];
        int r122 = r114[r120];
        int r123 = r109 - 2;
        if ((((r123 >> 31) | ((r121 >> 31) ^ r121)) | ((r122 >> 31) ^ r122)) != 0) goto L10;
        r113[r123] = (r121 << 30) | r113[r123];
        r114[r123] = r114[r123] | (r122 << 30);
        r107 = r109 - 1;
    L11:
        r108 = r117;
        r105 = r118;
        r106 = r119;
        r112 = r213;
        r103 = 0;
        goto L4
    L10:
        r107 = r109;
        goto L11
    L6:
        return r103;
    L12:
        int r124 = r107;
        int r125 = r113[r124 - 1] >> 31;
        int r126 = r111[r104] >> 31;
        if (r126 >= 0) goto L15;
        r126 = add30(r102, r111, r115);
    L15:
        if (r125 >= 0) goto L18;
        r126 = negate30(r102, r111);
        negate30(r124, r113);
    L18:
        if (Nat.isOne(r124, r113) == true) goto L20;
        return false;
    L20:
        if (r126 >= 0) goto L22;
        add30(r102, r111, r115);
    L22:
        decode30(r101, r111, 0, r212, 0);
        return true;
    }

    private static int negate30(int r100, int[] r101) {
        int r102 = r100 - 1;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L5;
        int r105 = r104 - r101[r103];
        r101[r103] = M30 & r105;
        r104 = r105 >> 30;
        r103 = r103 + 1;
        goto L3
    L5:
        int r106 = r104 - r101[r102];
        r101[r102] = r106;
        return r106 >> 30;
    }

    public static int[] random(int[] r100) {
        int r101 = r100.length;
        Random r102 = new Random();
        int[] r103 = Nat.create(r101);
        int r104 = r101 - 1;
        int r105 = r100[r104];
        int r106 = r105 | (r105 >>> 1);
        int r107 = r106 | (r106 >>> 2);
        int r108 = r107 | (r107 >>> 4);
        int r109 = r108 | (r108 >>> 8);
        int r110 = r109 | (r109 >>> 16);
    L3:
        int r111 = 0;
    L4:
        if (r111 == r101) goto L6;
        r103[r111] = r102.nextInt();
        r111 = r111 + 1;
        goto L4
    L6:
        r103[r104] = r103[r104] & r110;
        if (Nat.gte(r101, r103, r100) == true) goto L3;
        return r103;
    }

    public static void subtract(int[] r100, int[] r101, int[] r102, int[] r103) {
        int r104 = r100.length;
        if (Nat.sub(r104, r101, r102, r103) == 0) goto L6;
        Nat.addTo(r104, r100, r103);
        return;
    }

    private static void updateDE30(int r310, int[] r311, int[] r312, int[] r313, int r314, int[] r315) {
        int r100 = r310;
        int r101 = r313[0];
        int r102 = r313[1];
        int r103 = r313[2];
        int r104 = r313[3];
        int r105 = r100 - 1;
        int r106 = r311[r105] >> 31;
        int r107 = r312[r105] >> 31;
        int r110 = (r101 & r106) + (r102 & r107);
        int r108 = (r106 & r103) + (r107 & r104);
        int r109 = r315[0];
        long r111 = r101;
        long r112 = r311[0];
        long r113 = r102;
        long r114 = r312[0];
        long r115 = (r111 * r112) + (r113 * r114);
        long r116 = r103;
        long r117 = r104;
        long r118 = (r112 * r116) + (r114 * r117);
        long r119 = r109;
        long r120 = r110 - (((((int) r115) * r314) + r110) & M30);
        int r121 = r105;
        long r122 = r108 - (((((int) r118) * r314) + r108) & M30);
        long r123 = (r118 + (r119 * r122)) >> 30;
        long r124 = (r115 + (r119 * r120)) >> 30;
        int r125 = 1;
    L3:
        if (r125 >= r100) goto L5;
        int r126 = r315[r125];
        long r210 = r123;
        long r127 = r311[r125];
        int r128 = r125;
        long r129 = r312[r125];
        long r211 = r122;
        long r130 = r126;
        long r131 = r124 + (((r111 * r127) + (r113 * r129)) + (r130 * r120));
        long r132 = r210 + (((r127 * r116) + (r129 * r117)) + (r130 * r211));
        int r133 = r128 - 1;
        r311[r133] = ((int) r131) & M30;
        r124 = r131 >> 30;
        r312[r133] = ((int) r132) & M30;
        r123 = r132 >> 30;
        r125 = r128 + 1;
        r100 = r310;
        r121 = r121;
        r122 = r211;
        goto L3
    L5:
        int r134 = r121;
        r311[r134] = (int) r124;
        r312[r134] = (int) r123;
    }

    private static void updateFG30(int r210, int[] r211, int[] r212, int[] r213) {
        int r100 = r213[0];
        int r101 = r213[1];
        int r102 = r213[2];
        int r103 = r213[3];
        long r104 = r100;
        long r110 = r211[0];
        long r111 = r101;
        long r105 = r212[0];
        long r106 = r102;
        long r107 = r103;
        long r112 = ((r104 * r110) + (r111 * r105)) >> 30;
        long r113 = ((r110 * r106) + (r105 * r107)) >> 30;
        int r108 = 1;
    L3:
        if (r108 >= r210) goto L5;
        int r109 = r211[r108];
        int r114 = r212[r108];
        int r115 = r108;
        long r116 = r109;
        long r117 = r104 * r116;
        long r214 = r104;
        long r118 = r114;
        long r119 = r112 + (r117 + (r111 * r118));
        long r120 = r113 + ((r116 * r106) + (r118 * r107));
        int r121 = r115 - 1;
        r211[r121] = ((int) r119) & M30;
        r112 = r119 >> 30;
        r212[r121] = M30 & ((int) r120);
        r113 = r120 >> 30;
        r108 = r115 + 1;
        r104 = r214;
        goto L3
    L5:
        int r122 = r210 - 1;
        r211[r122] = (int) r112;
        r212[r122] = (int) r113;
    }
}
