package org.bouncycastle.math.ec.rfc7748;

import kotlin.UByte;
import org.bouncycastle.math.raw.Mod;

/* JADX INFO: loaded from: classes42.dex */
public abstract class X25519Field {
    private static final int M24 = 16777215;
    private static final int M25 = 33554431;
    private static final int M26 = 67108863;
    private static final int[] P32 = null;
    private static final int[] ROOT_NEG_ONE = null;
    public static final int SIZE = 10;

    static {
        P32 = new int[]{-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
        ROOT_NEG_ONE = new int[]{34513072, 59165138, 4688974, 3500415, 6194736, 33281959, 54535759, 32551604, 163342, 5703241};
    }

    public X25519Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 10) goto L6;
        r102[r103] = r100[r103] + r101[r103];
        r103 = r103 + 1;
        goto L4
    }

    public static void addOne(int[] r100) {
        r100[0] = r100[0] + 1;
    }

    public static void addOne(int[] r100, int r101) {
        r100[r101] = r100[r101] + 1;
    }

    public static void apm(int[] r100, int[] r101, int[] r102, int[] r103) {
        int r104 = 0;
    L4:
        if (r104 >= 10) goto L6;
        int r105 = r100[r104];
        int r106 = r101[r104];
        r102[r104] = r105 + r106;
        r103[r104] = r105 - r106;
        r104 = r104 + 1;
        goto L4
    }

    public static void carry(int[] r210) {
        int r100 = r210[0];
        int r101 = r210[1];
        int r102 = r210[2];
        int r103 = r210[3];
        int r104 = r210[4];
        int r110 = r210[5];
        int r111 = r210[6];
        int r112 = r210[7];
        int r113 = r210[8];
        int r105 = r102 + (r101 >> 26);
        int r106 = r104 + (r103 >> 26);
        int r114 = r112 + (r111 >> 26);
        int r115 = r210[9] + (r113 >> 26);
        int r107 = (r103 & 67108863) + (r105 >> 25);
        int r108 = r105 & M25;
        int r116 = r110 + (r106 >> 25);
        int r109 = r106 & M25;
        int r117 = (r113 & 67108863) + (r114 >> 25);
        int r118 = r114 & M25;
        int r119 = r100 + ((r115 >> 25) * 38);
        int r120 = (r101 & 67108863) + (r119 >> 26);
        int r121 = (r111 & 67108863) + (r116 >> 26);
        int r122 = r108 + (r120 >> 26);
        int r123 = r109 + (r107 >> 26);
        int r124 = r118 + (r121 >> 26);
        int r125 = (r115 & M25) + (r117 >> 26);
        r210[0] = r119 & 67108863;
        r210[1] = r120 & 67108863;
        r210[2] = r122;
        r210[3] = r107 & 67108863;
        r210[4] = r123;
        r210[5] = r116 & 67108863;
        r210[6] = r121 & 67108863;
        r210[7] = r124;
        r210[8] = r117 & 67108863;
        r210[9] = r125;
    }

    public static void cmov(int r100, int[] r101, int r102, int[] r103, int r104) {
        int r105 = 0;
    L4:
        if (r105 >= 10) goto L6;
        int r106 = r104 + r105;
        int r107 = r103[r106];
        r103[r106] = r107 ^ ((r101[r102 + r105] ^ r107) & r100);
        r105 = r105 + 1;
        goto L4
    }

    public static void cnegate(int r100, int[] r101) {
        int r102 = 0;
        int r103 = 0 - r100;
    L4:
        if (r102 >= 10) goto L6;
        r101[r102] = (r101[r102] ^ r103) - r103;
        r102 = r102 + 1;
        goto L4
    }

    public static void copy(int[] r100, int r101, int[] r102, int r103) {
        int r104 = 0;
    L4:
        if (r104 >= 10) goto L6;
        r102[r103 + r104] = r100[r101 + r104];
        r104 = r104 + 1;
        goto L4
    }

    public static int[] create() {
        return new int[10];
    }

    public static int[] createTable(int r100) {
        return new int[r100 * 10];
    }

    public static void cswap(int r100, int[] r101, int[] r102) {
        int r103 = 0;
        int r104 = 0 - r100;
    L4:
        if (r103 >= 10) goto L6;
        int r105 = r101[r103];
        int r106 = r102[r103];
        int r107 = (r105 ^ r106) & r104;
        r101[r103] = r105 ^ r107;
        r102[r103] = r106 ^ r107;
        r103 = r103 + 1;
        goto L4
    }

    public static void decode(byte[] r100, int r101, int[] r102) {
        decode128(r100, r101, r102, 0);
        decode128(r100, r101 + 16, r102, 5);
        r102[9] = r102[9] & 16777215;
    }

    public static void decode(int[] r100, int r101, int[] r102) {
        decode128(r100, r101, r102, 0);
        decode128(r100, r101 + 4, r102, 5);
        r102[9] = r102[9] & 16777215;
    }

    private static void decode128(byte[] r100, int r101, int[] r102, int r103) {
        int r104 = decode32(r100, r101 + 0);
        int r105 = decode32(r100, r101 + 4);
        int r106 = decode32(r100, r101 + 8);
        int r107 = decode32(r100, r101 + 12);
        r102[r103 + 0] = r104 & 67108863;
        int r108 = r104 >>> 26;
        r102[r103 + 1] = (r108 | (r105 << 6)) & 67108863;
        r102[r103 + 2] = ((r106 << 12) | (r105 >>> 20)) & M25;
        r102[r103 + 3] = ((r107 << 19) | (r106 >>> 13)) & 67108863;
        r102[r103 + 4] = r107 >>> 7;
    }

    private static void decode128(int[] r100, int r101, int[] r102, int r103) {
        int r104 = r100[r101 + 0];
        int r105 = r100[r101 + 1];
        int r106 = r100[r101 + 2];
        int r107 = r100[r101 + 3];
        r102[r103 + 0] = r104 & 67108863;
        int r108 = r104 >>> 26;
        r102[r103 + 1] = (r108 | (r105 << 6)) & 67108863;
        r102[r103 + 2] = ((r106 << 12) | (r105 >>> 20)) & M25;
        r102[r103 + 3] = ((r107 << 19) | (r106 >>> 13)) & 67108863;
        r102[r103 + 4] = r107 >>> 7;
    }

    private static int decode32(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r105] & UByte.MAX_VALUE) << 16);
        return (r100[r105 + 1] << 24) | r106;
    }

    public static void encode(int[] r100, byte[] r101, int r102) {
        encode128(r100, 0, r101, r102);
        encode128(r100, 5, r101, r102 + 16);
    }

    public static void encode(int[] r100, int[] r101, int r102) {
        encode128(r100, 0, r101, r102);
        encode128(r100, 5, r101, r102 + 4);
    }

    private static void encode128(int[] r100, int r101, byte[] r102, int r103) {
        int r104 = r100[r101 + 0];
        int r105 = r100[r101 + 1];
        int r106 = r100[r101 + 2];
        int r107 = r100[r101 + 3];
        int r108 = r100[r101 + 4];
        encode32((r105 << 26) | r104, r102, r103 + 0);
        encode32((r105 >>> 6) | (r106 << 20), r102, r103 + 4);
        encode32((r106 >>> 12) | (r107 << 13), r102, r103 + 8);
        int r109 = r108 << 7;
        encode32(r109 | (r107 >>> 19), r102, r103 + 12);
    }

    private static void encode128(int[] r100, int r101, int[] r102, int r103) {
        int r104 = r100[r101 + 0];
        int r105 = r100[r101 + 1];
        int r106 = r100[r101 + 2];
        int r107 = r100[r101 + 3];
        int r108 = r100[r101 + 4];
        r102[r103 + 0] = r104 | (r105 << 26);
        r102[r103 + 1] = (r105 >>> 6) | (r106 << 20);
        r102[r103 + 2] = (r106 >>> 12) | (r107 << 13);
        int r109 = r108 << 7;
        r102[r103 + 3] = r109 | (r107 >>> 19);
    }

    private static void encode32(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        int r103 = r102 + 1;
        r101[r103] = (byte) (r100 >>> 8);
        int r104 = r103 + 1;
        r101[r104] = (byte) (r100 >>> 16);
        r101[r104 + 1] = (byte) (r100 >>> 24);
    }

    public static void inv(int[] r100, int[] r101) {
        int[] r102 = create();
        int[] r103 = new int[8];
        copy(r100, 0, r102, 0);
        normalize(r102);
        encode(r102, r103, 0);
        Mod.modOddInverse(P32, r103, r103);
        decode(r103, 0, r101);
    }

    public static void invVar(int[] r100, int[] r101) {
        int[] r102 = create();
        int[] r103 = new int[8];
        copy(r100, 0, r102, 0);
        normalize(r102);
        encode(r102, r103, 0);
        Mod.modOddInverseVar(P32, r103, r103);
        decode(r103, 0, r101);
    }

    public static int isZero(int[] r100) {
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 10) goto L7;
        r102 = r102 | r100[r101];
        r101 = r101 + 1;
        goto L4
    L7:
        return (((r102 >>> 1) | (r102 & 1)) - 1) >> 31;
    }

    public static boolean isZeroVar(int[] r100) {
        if (isZero(r100) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void mul(int[] r210, int r211, int[] r212) {
        int r100 = r210[0];
        int r101 = r210[1];
        int r102 = r210[2];
        int r103 = r210[3];
        int r104 = r210[4];
        int r110 = r210[5];
        int r111 = r210[6];
        int r112 = r210[7];
        int r113 = r210[8];
        int r105 = r210[9];
        long r106 = r211;
        long r107 = ((long) r102) * r106;
        int r114 = ((int) r107) & M25;
        long r108 = ((long) r104) * r106;
        int r109 = ((int) r108) & M25;
        long r115 = ((long) r112) * r106;
        int r116 = ((int) r115) & M25;
        long r117 = ((long) r105) * r106;
        int r118 = ((int) r117) & M25;
        long r119 = ((r117 >> 25) * 38) + (((long) r100) * r106);
        r212[0] = ((int) r119) & 67108863;
        long r120 = (r108 >> 25) + (((long) r110) * r106);
        r212[5] = ((int) r120) & 67108863;
        long r121 = (r119 >> 26) + (((long) r101) * r106);
        r212[1] = ((int) r121) & 67108863;
        long r122 = (r107 >> 25) + (((long) r103) * r106);
        r212[3] = ((int) r122) & 67108863;
        long r123 = (r120 >> 26) + (((long) r111) * r106);
        r212[6] = ((int) r123) & 67108863;
        long r124 = (r115 >> 25) + (((long) r113) * r106);
        r212[8] = ((int) r124) & 67108863;
        r212[2] = r114 + ((int) (r121 >> 26));
        r212[4] = r109 + ((int) (r122 >> 26));
        r212[7] = r116 + ((int) (r123 >> 26));
        r212[9] = r118 + ((int) (r124 >> 26));
    }

    public static void mul(int[] r710, int[] r711, int[] r712) {
        int r100 = r710[0];
        int r101 = r711[0];
        int r102 = r710[1];
        int r103 = r711[1];
        int r104 = r710[2];
        int r105 = r711[2];
        int r110 = r710[3];
        int r111 = r711[3];
        int r112 = r710[4];
        int r113 = r711[4];
        int r114 = r710[5];
        int r106 = r711[5];
        int r115 = r710[6];
        int r107 = r711[6];
        int r108 = r710[7];
        int r109 = r711[7];
        int r116 = r710[8];
        int r117 = r711[8];
        int r118 = r710[9];
        int r119 = r711[9];
        long r120 = r100;
        long r121 = r101;
        long r210 = r120 * r121;
        long r122 = r103;
        long r123 = r102;
        long r310 = (r120 * r122) + (r123 * r121);
        long r124 = r105;
        long r125 = r104;
        long r311 = ((r120 * r124) + (r123 * r122)) + (r125 * r121);
        long r410 = ((r123 * r124) + (r125 * r122)) << 1;
        long r126 = r111;
        long r411 = r120 * r126;
        long r127 = r110;
        long r412 = r410 + (r411 + (r127 * r121));
        long r413 = (r125 * r124) << 1;
        long r128 = r113;
        long r129 = ((r120 * r128) + (r123 * r126)) + (r127 * r122);
        long r130 = r112;
        long r414 = r413 + (r129 + (r121 * r130));
        long r131 = ((((r123 * r128) + (r125 * r126)) + (r127 * r124)) + (r130 * r122)) << 1;
        long r132 = (((r125 * r128) + (r130 * r124)) << 1) + (r127 * r126);
        long r133 = (r127 * r128) + (r130 * r126);
        long r134 = (r130 * r128) << 1;
        long r135 = r114;
        long r136 = r106;
        long r415 = r135 * r136;
        long r137 = r107;
        long r138 = r115;
        long r510 = (r135 * r137) + (r138 * r136);
        long r139 = r109;
        long r140 = r108;
        long r511 = ((r135 * r139) + (r138 * r137)) + (r140 * r136);
        long r141 = r117;
        long r142 = r116;
        long r610 = (((r138 * r139) + (r140 * r137)) << 1) + ((r135 * r141) + (r142 * r136));
        long r611 = (r140 * r139) << 1;
        long r143 = r119;
        long r144 = ((r135 * r143) + (r138 * r141)) + (r142 * r137);
        long r145 = r118;
        long r612 = r611 + (r144 + (r136 * r145));
        long r146 = (((r138 * r143) + (r140 * r141)) + (r142 * r139)) + (r145 * r137);
        long r211 = r210 - (r146 * 76);
        long r312 = r310 - (((((r140 * r143) + (r145 * r139)) << 1) + (r142 * r141)) * 38);
        long r313 = r311 - (((r142 * r143) + (r141 * r145)) * 38);
        long r416 = r412 - ((r145 * r143) * 76);
        long r147 = r131 - r415;
        long r148 = r132 - r510;
        long r149 = r133 - r511;
        long r150 = r134 - r610;
        int r151 = r100 + r114;
        int r152 = r102 + r115;
        int r153 = r104 + r108;
        int r154 = r105 + r109;
        int r155 = r110 + r116;
        int r156 = r112 + r118;
        long r157 = r151;
        long r158 = r101 + r106;
        long r212 = r157 * r158;
        long r159 = r103 + r107;
        long r160 = r152;
        long r314 = (r157 * r159) + (r160 * r158);
        long r161 = r154;
        long r162 = r153;
        long r417 = ((r157 * r161) + (r160 * r159)) + (r162 * r158);
        long r418 = ((r160 * r161) + (r162 * r159)) << 1;
        long r163 = r111 + r117;
        long r164 = r155;
        long r419 = r418 + ((r157 * r163) + (r164 * r158));
        long r165 = r113 + r119;
        long r166 = r156;
        long r512 = ((r162 * r161) << 1) + ((((r157 * r165) + (r160 * r163)) + (r164 * r159)) + (r158 * r166));
        long r167 = ((((r160 * r165) + (r162 * r163)) + (r164 * r161)) + (r166 * r159)) << 1;
        long r168 = (((r162 * r165) + (r166 * r161)) << 1) + (r164 * r163);
        long r169 = r150 + (r419 - r416);
        int r170 = ((int) r169) & 67108863;
        long r171 = (r169 >> 26) + ((r512 - r414) - r612);
        int r172 = ((int) r171) & M25;
        long r173 = r211 + ((((r171 >> 25) + r167) - r147) * 38);
        r712[0] = ((int) r173) & 67108863;
        long r174 = (r173 >> 26) + (r312 + ((r168 - r148) * 38));
        r712[1] = ((int) r174) & 67108863;
        long r175 = (r174 >> 26) + (r313 + ((((r164 * r165) + (r166 * r163)) - r149) * 38));
        r712[2] = ((int) r175) & M25;
        long r176 = (r175 >> 25) + (r416 + ((((r166 * r165) << 1) - r150) * 38));
        r712[3] = ((int) r176) & 67108863;
        long r177 = (r176 >> 26) + (r414 + (r612 * 38));
        r712[4] = ((int) r177) & M25;
        long r178 = (r177 >> 25) + (r147 + (r212 - r211));
        r712[5] = ((int) r178) & 67108863;
        long r179 = (r178 >> 26) + (r148 + (r314 - r312));
        r712[6] = ((int) r179) & 67108863;
        long r180 = (r179 >> 26) + (r149 + (r417 - r313));
        r712[7] = ((int) r180) & M25;
        long r181 = (r180 >> 25) + ((long) r170);
        r712[8] = ((int) r181) & 67108863;
        r712[9] = r172 + ((int) (r181 >> 26));
    }

    public static void negate(int[] r100, int[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= 10) goto L6;
        r101[r102] = -r100[r102];
        r102 = r102 + 1;
        goto L4
    }

    public static void normalize(int[] r100) {
        int r101 = (r100[9] >>> 23) & 1;
        reduce(r100, r101);
        reduce(r100, -r101);
    }

    public static void one(int[] r100) {
        int r101 = 1;
        r100[0] = 1;
    L4:
        if (r101 >= 10) goto L6;
        r100[r101] = 0;
        r101 = r101 + 1;
        goto L4
    }

    private static void powPm5d8(int[] r100, int[] r101, int[] r102) {
        sqr(r100, r101);
        mul(r100, r101, r101);
        int[] r103 = create();
        sqr(r101, r103);
        mul(r100, r103, r103);
        sqr(r103, 2, r103);
        mul(r101, r103, r103);
        int[] r104 = create();
        sqr(r103, 5, r104);
        mul(r103, r104, r104);
        int[] r105 = create();
        sqr(r104, 5, r105);
        mul(r103, r105, r105);
        sqr(r105, 10, r103);
        mul(r104, r103, r103);
        sqr(r103, 25, r104);
        mul(r103, r104, r104);
        sqr(r104, 25, r105);
        mul(r103, r105, r105);
        sqr(r105, 50, r103);
        mul(r104, r103, r103);
        sqr(r103, 125, r104);
        mul(r103, r104, r104);
        sqr(r104, 2, r103);
        mul(r103, r100, r102);
    }

    private static void reduce(int[] r110, int r111) {
        int r100 = r110[9];
        int r101 = 16777215 & r100;
        long r102 = ((long) (((r100 >> 24) + r111) * 19)) + ((long) r110[0]);
        r110[0] = ((int) r102) & 67108863;
        long r103 = (r102 >> 26) + ((long) r110[1]);
        r110[1] = ((int) r103) & 67108863;
        long r104 = (r103 >> 26) + ((long) r110[2]);
        r110[2] = ((int) r104) & M25;
        long r105 = (r104 >> 25) + ((long) r110[3]);
        r110[3] = ((int) r105) & 67108863;
        long r106 = (r105 >> 26) + ((long) r110[4]);
        r110[4] = ((int) r106) & M25;
        long r107 = (r106 >> 25) + ((long) r110[5]);
        r110[5] = ((int) r107) & 67108863;
        long r108 = (r107 >> 26) + ((long) r110[6]);
        r110[6] = ((int) r108) & 67108863;
        long r109 = (r108 >> 26) + ((long) r110[7]);
        r110[7] = M25 & ((int) r109);
        long r112 = (r109 >> 25) + ((long) r110[8]);
        r110[8] = 67108863 & ((int) r112);
        r110[9] = r101 + ((int) (r112 >> 26));
    }

    public static void sqr(int[] r100, int r101, int[] r102) {
        sqr(r100, r102);
    L3:
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        sqr(r102, r102);
        goto L3
    }

    public static void sqr(int[] r510, int[] r511) {
        int r100 = r510[0];
        int r101 = r510[1];
        int r102 = r510[2];
        int r103 = r510[3];
        int r104 = r510[4];
        int r110 = r510[5];
        int r111 = r510[6];
        int r112 = r510[7];
        int r113 = r510[8];
        int r114 = r510[9];
        long r105 = r100;
        long r115 = r105 * r105;
        long r106 = r101 * 2;
        long r210 = r105 * r106;
        long r116 = r102 * 2;
        long r117 = r101;
        long r211 = (r105 * r116) + (r117 * r117);
        long r118 = r103 * 2;
        long r212 = (r106 * r116) + (r105 * r118);
        long r107 = r104 * 2;
        long r108 = ((((long) r102) * r116) + (r105 * r107)) + (r117 * r118);
        long r109 = (r106 * r107) + (r118 * r116);
        long r119 = r103;
        long r120 = (r116 * r107) + (r119 * r119);
        long r121 = r119 * r107;
        long r122 = ((long) r104) * r107;
        int r123 = r114 * 2;
        long r124 = r110;
        long r310 = r124 * r124;
        long r125 = r111 * 2;
        long r311 = r124 * r125;
        long r126 = r112 * 2;
        long r127 = r111;
        long r410 = (r124 * r126) + (r127 * r127);
        long r128 = r113 * 2;
        long r411 = (r125 * r126) + (r124 * r128);
        long r129 = r123;
        long r130 = ((((long) r112) * r126) + (r124 * r129)) + (r127 * r128);
        long r131 = (r125 * r129) + (r128 * r126);
        long r132 = r113;
        long r133 = r115 - (r131 * 38);
        long r213 = r210 - (((r126 * r129) + (r132 * r132)) * 38);
        long r214 = r211 - ((r132 * r129) * 38);
        long r215 = r212 - ((((long) r114) * r129) * 38);
        long r134 = r109 - r310;
        long r135 = r120 - r311;
        long r136 = r121 - r410;
        long r137 = r122 - r411;
        int r138 = r101 + r111;
        int r139 = r102 + r112;
        int r140 = r103 + r113;
        int r141 = r104 + r114;
        long r142 = r100 + r110;
        long r412 = r142 * r142;
        long r143 = r138 * 2;
        long r413 = r142 * r143;
        long r144 = r139 * 2;
        long r145 = r138;
        long r414 = (r142 * r144) + (r145 * r145);
        long r146 = r140 * 2;
        long r415 = (r143 * r144) + (r142 * r146);
        long r147 = r141 * 2;
        long r148 = ((((long) r139) * r144) + (r142 * r147)) + (r145 * r146);
        long r149 = (r143 * r147) + (r146 * r144);
        long r150 = r140;
        long r151 = (r144 * r147) + (r150 * r150);
        long r152 = r150 * r147;
        long r153 = ((long) r141) * r147;
        long r154 = r137 + (r415 - r215);
        int r155 = ((int) r154) & 67108863;
        long r156 = (r154 >> 26) + ((r148 - r108) - r130);
        int r157 = ((int) r156) & M25;
        long r158 = r133 + ((((r156 >> 25) + r149) - r134) * 38);
        r511[0] = ((int) r158) & 67108863;
        long r159 = (r158 >> 26) + (r213 + ((r151 - r135) * 38));
        r511[1] = ((int) r159) & 67108863;
        long r160 = (r159 >> 26) + (r214 + ((r152 - r136) * 38));
        r511[2] = ((int) r160) & M25;
        long r161 = (r160 >> 25) + (r215 + ((r153 - r137) * 38));
        r511[3] = ((int) r161) & 67108863;
        long r162 = (r161 >> 26) + (r108 + (38 * r130));
        r511[4] = ((int) r162) & M25;
        long r163 = (r162 >> 25) + (r134 + (r412 - r133));
        r511[5] = ((int) r163) & 67108863;
        long r164 = (r163 >> 26) + (r135 + (r413 - r213));
        r511[6] = ((int) r164) & 67108863;
        long r165 = (r164 >> 26) + (r136 + (r414 - r214));
        r511[7] = ((int) r165) & M25;
        long r166 = (r165 >> 25) + ((long) r155);
        r511[8] = ((int) r166) & 67108863;
        r511[9] = r157 + ((int) (r166 >> 26));
    }

    public static boolean sqrtRatioVar(int[] r100, int[] r101, int[] r102) {
        int[] r103 = create();
        int[] r104 = create();
        mul(r100, r101, r103);
        sqr(r101, r104);
        mul(r103, r104, r103);
        sqr(r104, r104);
        mul(r104, r103, r104);
        int[] r105 = create();
        int[] r106 = create();
        powPm5d8(r104, r105, r106);
        mul(r106, r103, r106);
        int[] r107 = create();
        sqr(r106, r107);
        mul(r107, r101, r107);
        sub(r107, r100, r105);
        normalize(r105);
        if (isZeroVar(r105) == false) goto L6;
        copy(r106, 0, r102, 0);
        return true;
    L6:
        add(r107, r100, r105);
        normalize(r105);
        if (isZeroVar(r105) == false) goto L10;
        mul(r106, ROOT_NEG_ONE, r102);
        return true;
    L10:
        return false;
    }

    public static void sub(int[] r100, int[] r101, int[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 10) goto L6;
        r102[r103] = r100[r103] - r101[r103];
        r103 = r103 + 1;
        goto L4
    }

    public static void subOne(int[] r100) {
        r100[0] = r100[0] - 1;
    }

    public static void zero(int[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 10) goto L6;
        r100[r101] = 0;
        r101 = r101 + 1;
        goto L4
    }
}
