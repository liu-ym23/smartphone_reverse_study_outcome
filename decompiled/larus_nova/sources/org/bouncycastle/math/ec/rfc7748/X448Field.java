package org.bouncycastle.math.ec.rfc7748;

import kotlin.UByte;
import org.bouncycastle.math.raw.Mod;

/* JADX INFO: loaded from: classes42.dex */
public abstract class X448Field {
    private static final int M28 = 268435455;
    private static final int[] P32 = null;
    public static final int SIZE = 16;
    private static final long U32 = 4294967295L;

    static {
        P32 = new int[]{-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    }

    public X448Field() {
    }

    public static void add(int[] r100, int[] r101, int[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 16) goto L6;
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

    public static void carry(int[] r310) {
        int r100 = r310[0];
        int r101 = r310[1];
        int r102 = r310[2];
        int r103 = r310[3];
        int r104 = r310[4];
        int r110 = r310[5];
        int r111 = r310[6];
        int r112 = r310[7];
        int r113 = r310[8];
        int r114 = r310[9];
        int r210 = r310[10];
        int r211 = r310[11];
        int r212 = r310[12];
        int r213 = r310[13];
        int r214 = r310[14];
        int r311 = r310[15];
        int r105 = r101 + (r100 >>> 28);
        int r106 = r100 & M28;
        int r115 = r110 + (r104 >>> 28);
        int r107 = r104 & M28;
        int r116 = r114 + (r113 >>> 28);
        int r117 = r113 & M28;
        int r215 = r213 + (r212 >>> 28);
        int r216 = r212 & M28;
        int r108 = r102 + (r105 >>> 28);
        int r109 = r105 & M28;
        int r118 = r111 + (r115 >>> 28);
        int r119 = r115 & M28;
        int r217 = r210 + (r116 >>> 28);
        int r120 = r116 & M28;
        int r218 = r214 + (r215 >>> 28);
        int r219 = r215 & M28;
        int r121 = r103 + (r108 >>> 28);
        int r122 = r108 & M28;
        int r123 = r112 + (r118 >>> 28);
        int r124 = r118 & M28;
        int r220 = r211 + (r217 >>> 28);
        int r221 = r217 & M28;
        int r312 = r311 + (r218 >>> 28);
        int r222 = r218 & M28;
        int r313 = r312 >>> 28;
        int r314 = r312 & M28;
        int r125 = r106 + r313;
        int r126 = r117 + r313;
        int r127 = r107 + (r121 >>> 28);
        int r128 = r121 & M28;
        int r129 = r126 + (r123 >>> 28);
        int r130 = r123 & M28;
        int r223 = r216 + (r220 >>> 28);
        int r224 = r220 & M28;
        int r131 = r109 + (r125 >>> 28);
        int r132 = r125 & M28;
        int r133 = r119 + (r127 >>> 28);
        int r134 = r127 & M28;
        int r135 = r120 + (r129 >>> 28);
        int r136 = r129 & M28;
        int r225 = r219 + (r223 >>> 28);
        int r226 = r223 & M28;
        r310[0] = r132;
        r310[1] = r131;
        r310[2] = r122;
        r310[3] = r128;
        r310[4] = r134;
        r310[5] = r133;
        r310[6] = r124;
        r310[7] = r130;
        r310[8] = r136;
        r310[9] = r135;
        r310[10] = r221;
        r310[11] = r224;
        r310[12] = r226;
        r310[13] = r225;
        r310[14] = r222;
        r310[15] = r314;
    }

    public static void cmov(int r100, int[] r101, int r102, int[] r103, int r104) {
        int r105 = 0;
    L4:
        if (r105 >= 16) goto L6;
        int r106 = r104 + r105;
        int r107 = r103[r106];
        r103[r106] = r107 ^ ((r101[r102 + r105] ^ r107) & r100);
        r105 = r105 + 1;
        goto L4
    }

    public static void cnegate(int r100, int[] r101) {
        int[] r102 = create();
        sub(r102, r101, r102);
        cmov(-r100, r102, 0, r101, 0);
    }

    public static void copy(int[] r100, int r101, int[] r102, int r103) {
        int r104 = 0;
    L4:
        if (r104 >= 16) goto L6;
        r102[r103 + r104] = r100[r101 + r104];
        r104 = r104 + 1;
        goto L4
    }

    public static int[] create() {
        return new int[16];
    }

    public static int[] createTable(int r100) {
        return new int[r100 * 16];
    }

    public static void cswap(int r100, int[] r101, int[] r102) {
        int r103 = 0;
        int r104 = 0 - r100;
    L4:
        if (r103 >= 16) goto L6;
        int r105 = r101[r103];
        int r106 = r102[r103];
        int r107 = (r105 ^ r106) & r104;
        r101[r103] = r105 ^ r107;
        r102[r103] = r106 ^ r107;
        r103 = r103 + 1;
        goto L4
    }

    public static void decode(byte[] r100, int r101, int[] r102) {
        decode56(r100, r101, r102, 0);
        decode56(r100, r101 + 7, r102, 2);
        decode56(r100, r101 + 14, r102, 4);
        decode56(r100, r101 + 21, r102, 6);
        decode56(r100, r101 + 28, r102, 8);
        decode56(r100, r101 + 35, r102, 10);
        decode56(r100, r101 + 42, r102, 12);
        decode56(r100, r101 + 49, r102, 14);
    }

    public static void decode(int[] r100, int r101, int[] r102) {
        decode224(r100, r101, r102, 0);
        decode224(r100, r101 + 7, r102, 8);
    }

    private static void decode224(int[] r100, int r101, int[] r110, int r111) {
        int r102 = r100[r101 + 0];
        int r103 = r100[r101 + 1];
        int r104 = r100[r101 + 2];
        int r105 = r100[r101 + 3];
        int r106 = r100[r101 + 4];
        int r107 = r100[r101 + 5];
        int r108 = r100[r101 + 6];
        r110[r111 + 0] = r102 & M28;
        r110[r111 + 1] = ((r102 >>> 28) | (r103 << 4)) & M28;
        r110[r111 + 2] = ((r103 >>> 24) | (r104 << 8)) & M28;
        r110[r111 + 3] = ((r104 >>> 20) | (r105 << 12)) & M28;
        r110[r111 + 4] = ((r105 >>> 16) | (r106 << 16)) & M28;
        r110[r111 + 5] = ((r106 >>> 12) | (r107 << 20)) & M28;
        r110[r111 + 6] = ((r107 >>> 8) | (r108 << 24)) & M28;
        r110[r111 + 7] = r108 >>> 4;
    }

    private static int decode24(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 8);
        return ((r100[r103 + 1] & UByte.MAX_VALUE) << 16) | r104;
    }

    private static int decode32(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r105] & UByte.MAX_VALUE) << 16);
        return (r100[r105 + 1] << 24) | r106;
    }

    private static void decode56(byte[] r100, int r101, int[] r102, int r103) {
        int r104 = decode32(r100, r101);
        int r105 = decode24(r100, r101 + 4);
        r102[r103] = M28 & r104;
        int r106 = r105 << 4;
        r102[r103 + 1] = r106 | (r104 >>> 28);
    }

    public static void encode(int[] r100, byte[] r101, int r102) {
        encode56(r100, 0, r101, r102);
        encode56(r100, 2, r101, r102 + 7);
        encode56(r100, 4, r101, r102 + 14);
        encode56(r100, 6, r101, r102 + 21);
        encode56(r100, 8, r101, r102 + 28);
        encode56(r100, 10, r101, r102 + 35);
        encode56(r100, 12, r101, r102 + 42);
        encode56(r100, 14, r101, r102 + 49);
    }

    public static void encode(int[] r100, int[] r101, int r102) {
        encode224(r100, 0, r101, r102);
        encode224(r100, 8, r101, r102 + 7);
    }

    private static void encode224(int[] r100, int r101, int[] r110, int r111) {
        int r102 = r100[r101 + 0];
        int r103 = r100[r101 + 1];
        int r104 = r100[r101 + 2];
        int r105 = r100[r101 + 3];
        int r106 = r100[r101 + 4];
        int r107 = r100[r101 + 5];
        int r108 = r100[r101 + 6];
        int r109 = r100[r101 + 7];
        r110[r111 + 0] = r102 | (r103 << 28);
        r110[r111 + 1] = (r103 >>> 4) | (r104 << 24);
        r110[r111 + 2] = (r104 >>> 8) | (r105 << 20);
        r110[r111 + 3] = (r105 >>> 12) | (r106 << 16);
        r110[r111 + 4] = (r106 >>> 16) | (r107 << 12);
        r110[r111 + 5] = (r107 >>> 20) | (r108 << 8);
        int r112 = r109 << 4;
        r110[r111 + 6] = r112 | (r108 >>> 24);
    }

    private static void encode24(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        int r103 = r102 + 1;
        r101[r103] = (byte) (r100 >>> 8);
        r101[r103 + 1] = (byte) (r100 >>> 16);
    }

    private static void encode32(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        int r103 = r102 + 1;
        r101[r103] = (byte) (r100 >>> 8);
        int r104 = r103 + 1;
        r101[r104] = (byte) (r100 >>> 16);
        r101[r104 + 1] = (byte) (r100 >>> 24);
    }

    private static void encode56(int[] r100, int r101, byte[] r102, int r103) {
        int r104 = r100[r101];
        int r105 = r100[r101 + 1];
        encode32((r105 << 28) | r104, r102, r103);
        encode24(r105 >>> 4, r102, r103 + 4);
    }

    public static void inv(int[] r100, int[] r101) {
        int[] r102 = create();
        int[] r103 = new int[14];
        copy(r100, 0, r102, 0);
        normalize(r102);
        encode(r102, r103, 0);
        Mod.modOddInverse(P32, r103, r103);
        decode(r103, 0, r101);
    }

    public static void invVar(int[] r100, int[] r101) {
        int[] r102 = create();
        int[] r103 = new int[14];
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
        if (r101 >= 16) goto L7;
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

    public static void mul(int[] r310, int r311, int[] r312) {
        int r100 = r310[0];
        int r101 = r310[1];
        int r102 = r310[2];
        int r103 = r310[3];
        int r104 = r310[4];
        int r110 = r310[5];
        int r111 = r310[6];
        int r112 = r310[7];
        int r113 = r310[8];
        int r105 = r310[9];
        int r106 = r310[10];
        int r107 = r310[11];
        int r114 = r310[12];
        int r108 = r310[13];
        int r115 = r310[14];
        int r109 = r310[15];
        long r116 = r101;
        long r117 = r311;
        long r118 = r116 * r117;
        int r119 = ((int) r118) & M28;
        long r120 = ((long) r110) * r117;
        int r121 = ((int) r120) & M28;
        long r122 = ((long) r105) * r117;
        int r123 = ((int) r122) & M28;
        long r124 = ((long) r108) * r117;
        int r125 = ((int) r124) & M28;
        long r126 = (r118 >>> 28) + (((long) r102) * r117);
        r312[2] = ((int) r126) & M28;
        long r127 = r126 >>> 28;
        long r128 = (r120 >>> 28) + (((long) r111) * r117);
        r312[6] = ((int) r128) & M28;
        long r129 = (r122 >>> 28) + (((long) r106) * r117);
        r312[10] = ((int) r129) & M28;
        long r130 = (r124 >>> 28) + (((long) r115) * r117);
        r312[14] = ((int) r130) & M28;
        long r131 = r127 + (((long) r103) * r117);
        r312[3] = ((int) r131) & M28;
        long r132 = (r128 >>> 28) + (((long) r112) * r117);
        r312[7] = ((int) r132) & M28;
        long r133 = (r129 >>> 28) + (((long) r107) * r117);
        r312[11] = ((int) r133) & M28;
        long r134 = (r130 >>> 28) + (((long) r109) * r117);
        r312[15] = ((int) r134) & M28;
        long r135 = r134 >>> 28;
        long r136 = (r131 >>> 28) + (((long) r104) * r117);
        r312[4] = ((int) r136) & M28;
        long r137 = ((r132 >>> 28) + r135) + (((long) r113) * r117);
        r312[8] = ((int) r137) & M28;
        long r138 = (r133 >>> 28) + (((long) r114) * r117);
        r312[12] = ((int) r138) & M28;
        long r139 = r135 + (((long) r100) * r117);
        r312[0] = ((int) r139) & M28;
        r312[1] = r119 + ((int) (r139 >>> 28));
        r312[5] = r121 + ((int) (r136 >>> 28));
        r312[9] = r123 + ((int) (r137 >>> 28));
        r312[13] = r125 + ((int) (r138 >>> 28));
    }

    public static void mul(int[] r141, int[] r142, int[] r143) {
        int r100 = r141[0];
        int r101 = r141[1];
        int r102 = r141[2];
        int r103 = r141[3];
        int r104 = r141[4];
        int r110 = r141[5];
        int r111 = r141[6];
        int r112 = r141[7];
        int r113 = r141[8];
        int r114 = r141[9];
        int r115 = r141[10];
        int r105 = r141[11];
        int r106 = r141[12];
        int r107 = r141[13];
        int r108 = r141[14];
        int r116 = r141[15];
        int r117 = r142[0];
        int r109 = r142[1];
        int r118 = r142[2];
        int r119 = r142[3];
        int r120 = r142[4];
        int r121 = r142[5];
        int r122 = r142[6];
        int r123 = r142[7];
        int r124 = r142[8];
        int r125 = r142[9];
        int r126 = r142[10];
        int r127 = r142[11];
        int r128 = r142[12];
        int r129 = r142[13];
        int r130 = r142[14];
        int r131 = r142[15];
        int r132 = r100 + r113;
        int r133 = r102 + r115;
        int r134 = r103 + r105;
        int r135 = r104 + r106;
        int r136 = r110 + r107;
        int r137 = r111 + r108;
        int r138 = r117 + r124;
        int r139 = r109 + r125;
        int r140 = r118 + r126;
        int r144 = r119 + r127;
        int r145 = r120 + r128;
        int r146 = r121 + r129;
        int r147 = r122 + r130;
        int r148 = r123 + r131;
        long r149 = r100;
        long r150 = r117;
        long r610 = r149 * r150;
        long r151 = r112;
        long r152 = r109;
        long r611 = r151 * r152;
        long r153 = r111;
        long r154 = r118;
        long r612 = r611 + (r153 * r154);
        long r155 = r110;
        long r156 = r119;
        long r613 = r612 + (r155 * r156);
        long r157 = r104;
        long r158 = r120;
        long r614 = r613 + (r157 * r158);
        long r159 = r103;
        long r160 = r121;
        long r615 = r614 + (r159 * r160);
        long r161 = r102;
        long r162 = r122;
        long r616 = r615 + (r161 * r162);
        long r163 = r101;
        long r164 = r123;
        long r617 = r616 + (r163 * r164);
        long r165 = r113;
        long r166 = r124;
        long r910 = r165 * r166;
        long r167 = r116;
        long r168 = r125;
        long r911 = r167 * r168;
        long r169 = r108;
        long r170 = r126;
        long r912 = r911 + (r169 * r170);
        long r171 = r107;
        long r172 = r127;
        long r913 = r912 + (r171 * r172);
        long r173 = r106;
        long r174 = r128;
        long r914 = r913 + (r173 * r174);
        long r175 = r105;
        long r176 = r129;
        long r915 = r914 + (r175 * r176);
        long r177 = r115;
        long r178 = r130;
        long r916 = r915 + (r177 * r178);
        long r179 = r114;
        long r180 = r131;
        long r917 = r916 + (r179 * r180);
        long r181 = r132;
        long r182 = r138;
        long r1010 = r181 * r182;
        long r183 = r112 + r116;
        long r184 = r139;
        long r1110 = r183 * r184;
        long r185 = r137;
        long r186 = r140;
        long r1111 = r1110 + (r185 * r186);
        long r187 = r136;
        long r188 = r144;
        long r1112 = r1111 + (r187 * r188);
        long r189 = r135;
        long r190 = r145;
        long r1113 = r1112 + (r189 * r190);
        long r191 = r134;
        long r192 = r146;
        long r1114 = r1113 + (r191 * r192);
        long r193 = r133;
        long r194 = r147;
        long r1115 = r1114 + (r193 * r194);
        long r195 = r101 + r114;
        long r196 = r148;
        long r1116 = r1115 + (r195 * r196);
        long r197 = ((r610 + r910) + r1116) - r617;
        int r198 = ((int) r197) & M28;
        long r199 = r197 >>> 28;
        long r200 = ((r917 + r1010) - r610) + r1116;
        int r1100 = ((int) r200) & M28;
        long r618 = (r163 * r150) + (r149 * r152);
        long r1011 = (((((r167 * r170) + (r169 * r172)) + (r171 * r174)) + (r173 * r176)) + (r175 * r178)) + (r177 * r180);
        long r1210 = (r195 * r182) + (r181 * r184);
        long r1211 = (((((r183 * r186) + (r185 * r188)) + (r187 * r190)) + (r189 * r192)) + (r191 * r194)) + (r193 * r196);
        long r201 = r199 + (((r618 + ((r179 * r166) + (r165 * r168))) + r1211) - ((((((r151 * r154) + (r153 * r156)) + (r155 * r158)) + (r157 * r160)) + (r159 * r162)) + (r161 * r164)));
        int r1101 = ((int) r201) & M28;
        long r202 = (r200 >>> 28) + (((r1011 + r1210) - r618) + r1211);
        int r1102 = ((int) r202) & M28;
        long r619 = ((r161 * r150) + (r163 * r152)) + (r149 * r154);
        long r1012 = ((((r167 * r172) + (r169 * r174)) + (r171 * r176)) + (r173 * r178)) + (r175 * r180);
        long r1212 = ((r193 * r182) + (r195 * r184)) + (r181 * r186);
        long r1213 = ((((r183 * r188) + (r185 * r190)) + (r187 * r192)) + (r189 * r194)) + (r191 * r196);
        long r203 = (r201 >>> 28) + (((r619 + (((r177 * r166) + (r179 * r168)) + (r165 * r170))) + r1213) - (((((r151 * r156) + (r153 * r158)) + (r155 * r160)) + (r157 * r162)) + (r159 * r164)));
        int r1103 = ((int) r203) & M28;
        long r204 = (r202 >>> 28) + (((r1012 + r1212) - r619) + r1213);
        int r1104 = ((int) r204) & M28;
        long r918 = (((r159 * r150) + (r161 * r152)) + (r163 * r154)) + (r149 * r156);
        long r1214 = (((r167 * r174) + (r169 * r176)) + (r171 * r178)) + (r173 * r180);
        long r1310 = (((r191 * r182) + (r193 * r184)) + (r195 * r186)) + (r181 * r188);
        long r1311 = (((r183 * r190) + (r185 * r192)) + (r187 * r194)) + (r189 * r196);
        long r205 = (r203 >>> 28) + (((r918 + ((((r175 * r166) + (r177 * r168)) + (r179 * r170)) + (r165 * r172))) + r1311) - ((((r151 * r158) + (r153 * r160)) + (r155 * r162)) + (r157 * r164)));
        int r1105 = ((int) r205) & M28;
        long r206 = (r204 >>> 28) + (((r1214 + r1310) - r918) + r1311);
        int r1106 = ((int) r206) & M28;
        long r919 = ((((r157 * r150) + (r159 * r152)) + (r161 * r154)) + (r163 * r156)) + (r149 * r158);
        long r1215 = ((r167 * r176) + (r169 * r178)) + (r171 * r180);
        long r1312 = ((((r189 * r182) + (r191 * r184)) + (r193 * r186)) + (r195 * r188)) + (r181 * r190);
        long r1313 = ((r183 * r192) + (r185 * r194)) + (r187 * r196);
        long r207 = (r205 >>> 28) + (((r919 + (((((r173 * r166) + (r175 * r168)) + (r177 * r170)) + (r179 * r172)) + (r165 * r174))) + r1313) - (((r151 * r160) + (r153 * r162)) + (r155 * r164)));
        int r1107 = ((int) r207) & M28;
        long r208 = (r206 >>> 28) + (((r1215 + r1312) - r919) + r1313);
        int r1108 = ((int) r208) & M28;
        long r1216 = (((((r155 * r150) + (r157 * r152)) + (r159 * r154)) + (r161 * r156)) + (r163 * r158)) + (r149 * r160);
        long r1314 = (r167 * r178) + (r169 * r180);
        long r1315 = (((((r187 * r182) + (r189 * r184)) + (r191 * r186)) + (r193 * r188)) + (r195 * r190)) + (r181 * r192);
        long r1316 = (r183 * r194) + (r185 * r196);
        long r209 = (r207 >>> 28) + (((r1216 + ((((((r171 * r166) + (r173 * r168)) + (r175 * r170)) + (r177 * r172)) + (r179 * r174)) + (r165 * r176))) + r1316) - ((r151 * r162) + (r153 * r164)));
        int r1109 = ((int) r209) & M28;
        long r210 = (r208 >>> 28) + (((r1314 + r1315) - r1216) + r1316);
        int r1117 = ((int) r210) & M28;
        long r1217 = ((((((r153 * r150) + (r155 * r152)) + (r157 * r154)) + (r159 * r156)) + (r161 * r158)) + (r163 * r160)) + (r149 * r162);
        long r1317 = r167 * r180;
        long r1318 = ((((((r185 * r182) + (r187 * r184)) + (r189 * r186)) + (r191 * r188)) + (r193 * r190)) + (r195 * r192)) + (r181 * r194);
        long r1319 = r183 * r196;
        long r211 = (r209 >>> 28) + (((r1217 + (((((((r169 * r166) + (r171 * r168)) + (r173 * r170)) + (r175 * r172)) + (r177 * r174)) + (r179 * r176)) + (r165 * r178))) + r1319) - (r151 * r164));
        int r1118 = ((int) r211) & M28;
        long r212 = (r210 >>> 28) + (((r1317 + r1318) - r1217) + r1319);
        int r1119 = ((int) r212) & M28;
        long r620 = (((((((r150 * r151) + (r152 * r153)) + (r155 * r154)) + (r157 * r156)) + (r159 * r158)) + (r161 * r160)) + (r163 * r162)) + (r149 * r164);
        long r310 = (((((((r167 * r166) + (r168 * r169)) + (r171 * r170)) + (r173 * r172)) + (r175 * r174)) + (r177 * r176)) + (r179 * r178)) + (r165 * r180);
        long r213 = (((((((r183 * r182) + (r185 * r184)) + (r187 * r186)) + (r189 * r188)) + (r191 * r190)) + (r193 * r192)) + (r195 * r194)) + (r181 * r196);
        long r214 = (r211 >>> 28) + (r620 + r310);
        int r215 = ((int) r214) & M28;
        long r216 = (r212 >>> 28) + (r213 - r620);
        int r217 = ((int) r216) & M28;
        long r218 = r216 >>> 28;
        long r219 = ((r214 >>> 28) + r218) + ((long) r1100);
        int r220 = ((int) r219) & M28;
        long r221 = r218 + ((long) r198);
        r143[0] = ((int) r221) & M28;
        r143[1] = r1101 + ((int) (r221 >>> 28));
        r143[2] = r1103;
        r143[3] = r1105;
        r143[4] = r1107;
        r143[5] = r1109;
        r143[6] = r1118;
        r143[7] = r215;
        r143[8] = r220;
        r143[9] = r1102 + ((int) (r219 >>> 28));
        r143[10] = r1104;
        r143[11] = r1106;
        r143[12] = r1108;
        r143[13] = r1117;
        r143[14] = r1119;
        r143[15] = r217;
    }

    public static void negate(int[] r100, int[] r101) {
        sub(create(), r100, r101);
    }

    public static void normalize(int[] r100) {
        reduce(r100, 1);
        reduce(r100, -1);
    }

    public static void one(int[] r100) {
        int r101 = 1;
        r100[0] = 1;
    L4:
        if (r101 >= 16) goto L6;
        r100[r101] = 0;
        r101 = r101 + 1;
        goto L4
    }

    private static void powPm3d4(int[] r100, int[] r101) {
        int[] r102 = create();
        sqr(r100, r102);
        mul(r100, r102, r102);
        int[] r103 = create();
        sqr(r102, r103);
        mul(r100, r103, r103);
        int[] r104 = create();
        sqr(r103, 3, r104);
        mul(r103, r104, r104);
        int[] r105 = create();
        sqr(r104, 3, r105);
        mul(r103, r105, r105);
        int[] r106 = create();
        sqr(r105, 9, r106);
        mul(r105, r106, r106);
        int[] r107 = create();
        sqr(r106, r107);
        mul(r100, r107, r107);
        int[] r108 = create();
        sqr(r107, 18, r108);
        mul(r106, r108, r108);
        int[] r109 = create();
        sqr(r108, 37, r109);
        mul(r108, r109, r109);
        int[] r110 = create();
        sqr(r109, 37, r110);
        mul(r108, r110, r110);
        int[] r111 = create();
        sqr(r110, 111, r111);
        mul(r110, r111, r111);
        int[] r112 = create();
        sqr(r111, r112);
        mul(r100, r112, r112);
        int[] r113 = create();
        sqr(r112, 223, r113);
        mul(r113, r111, r101);
    }

    private static void reduce(int[] r110, int r111) {
        int r100 = r110[15];
        int r101 = r100 & M28;
        long r102 = (r100 >>> 28) + r111;
        int r112 = 0;
        long r103 = r102;
    L3:
        int r104 = 8;
        if (r112 >= 8) goto L6;
        long r105 = r103 + (4294967295L & ((long) r110[r112]));
        r110[r112] = ((int) r105) & M28;
        r103 = r105 >> 28;
        r112 = r112 + 1;
        goto L3
    L6:
        long r106 = r103 + r102;
    L7:
        if (r104 >= 15) goto L9;
        long r107 = r106 + (((long) r110[r104]) & 4294967295L);
        r110[r104] = ((int) r107) & M28;
        r106 = r107 >> 28;
        r104 = r104 + 1;
        goto L7
    L9:
        r110[15] = r101 + ((int) r106);
    }

    public static void sqr(int[] r100, int r101, int[] r102) {
        sqr(r100, r102);
    L3:
        r101 = r101 - 1;
        if (r101 <= 0) goto L6;
        sqr(r102, r102);
        goto L3
    }

    public static void sqr(int[] r110, int[] r111) {
        int r100 = r110[0];
        int r101 = r110[1];
        int r102 = r110[2];
        int r103 = r110[3];
        int r104 = r110[4];
        int r112 = r110[5];
        int r113 = r110[6];
        int r114 = r110[7];
        int r115 = r110[8];
        int r116 = r110[9];
        int r117 = r110[10];
        int r105 = r110[11];
        int r106 = r110[12];
        int r107 = r110[13];
        int r108 = r110[14];
        int r109 = r110[15];
        int r118 = r100 * 2;
        int r119 = r101 * 2;
        int r120 = r102 * 2;
        int r121 = r103 * 2;
        int r122 = r104 * 2;
        int r123 = r112 * 2;
        int r124 = r113 * 2;
        int r125 = r115 * 2;
        int r126 = r116 * 2;
        int r127 = r117 * 2;
        int r128 = r105 * 2;
        int r129 = r106 * 2;
        int r130 = r107 * 2;
        int r131 = r108 * 2;
        int r132 = r100 + r115;
        int r133 = r101 + r116;
        int r134 = r102 + r117;
        int r135 = r103 + r105;
        int r136 = r104 + r106;
        int r137 = r112 + r107;
        int r138 = r113 + r108;
        int r139 = r114 + r109;
        int r140 = r132 * 2;
        int r141 = r133 * 2;
        int r142 = r134 * 2;
        int r143 = r135 * 2;
        int r144 = r137 * 2;
        long r145 = r100;
        long r146 = r145 * r145;
        long r147 = r114;
        long r148 = r119;
        long r510 = r147 * r148;
        long r149 = r113;
        long r150 = r120;
        long r511 = r510 + (r149 * r150);
        long r151 = r112;
        long r152 = r121;
        long r153 = r104;
        long r512 = (r511 + (r151 * r152)) + (r153 * r153);
        long r154 = r115;
        long r155 = r109;
        long r156 = r126;
        long r710 = r155 * r156;
        long r157 = r108;
        long r158 = r127;
        long r711 = r710 + (r157 * r158);
        long r159 = r107;
        long r160 = r128;
        long r712 = r711 + (r159 * r160);
        long r161 = r106;
        long r162 = r132;
        long r163 = r139;
        long r164 = ((long) r141) & 4294967295L;
        long r810 = r163 * r164;
        long r165 = r138;
        long r166 = ((long) r142) & 4294967295L;
        long r811 = r810 + (r165 * r166);
        long r167 = r137;
        long r168 = ((long) r143) & 4294967295L;
        long r812 = r811 + (r167 * r168);
        long r169 = r136;
        long r813 = r812 + (r169 * r169);
        long r170 = ((r146 + (r154 * r154)) + r813) - r512;
        int r171 = ((int) r170) & M28;
        long r172 = (((r712 + (r161 * r161)) + (r162 * r162)) - r146) + r813;
        int r173 = ((int) r172) & M28;
        long r174 = r172 >>> 28;
        long r175 = r101;
        long r176 = r118;
        long r513 = r175 * r176;
        long r177 = r122;
        long r713 = ((r147 * r150) + (r149 * r152)) + (r151 * r177);
        long r178 = r116;
        long r179 = r125;
        long r910 = r178 * r179;
        long r911 = (r155 * r158) + (r157 * r160);
        long r180 = r129;
        long r912 = r911 + (r159 * r180);
        long r181 = r133;
        long r182 = ((long) r140) & 4294967295L;
        long r1010 = (r163 * r166) + (r165 * r168);
        long r183 = ((long) (r136 * 2)) & 4294967295L;
        long r1011 = r1010 + (r167 * r183);
        long r184 = (r170 >>> 28) + (((r513 + r910) + r1011) - r713);
        int r185 = ((int) r184) & M28;
        long r186 = r174 + (((r912 + (r181 * r182)) - r513) + r1011);
        int r187 = ((int) r186) & M28;
        long r188 = r186 >>> 28;
        long r189 = r102;
        long r714 = (r189 * r176) + (r175 * r175);
        long r814 = ((r147 * r152) + (r149 * r177)) + (r151 * r151);
        long r190 = r117;
        long r913 = (r190 * r179) + (r178 * r178);
        long r410 = ((r155 * r160) + (r157 * r180)) + (r159 * r159);
        long r191 = r134;
        long r1012 = (r191 * r182) + (r181 * r181);
        long r192 = ((r163 * r168) + (r165 * r183)) + (r167 * r167);
        long r193 = (r184 >>> 28) + (((r714 + r913) + r192) - r814);
        int r194 = ((int) r193) & M28;
        long r195 = r188 + (((r410 + r1012) - r714) + r192);
        int r196 = ((int) r195) & M28;
        long r197 = r103;
        long r198 = (r197 * r176) + (r189 * r148);
        long r199 = r123;
        long r514 = (r147 * r177) + (r149 * r199);
        long r1100 = r105;
        long r914 = (r1100 * r179) + (r190 * r156);
        long r1101 = r130;
        long r915 = (r155 * r180) + (r157 * r1101);
        long r1102 = r135;
        long r411 = (r1102 * r182) + (r191 * r164);
        long r200 = r183 * r163;
        long r201 = ((long) r144) & 4294967295L;
        long r202 = r200 + (r165 * r201);
        long r1103 = (r193 >>> 28) + (((r198 + r914) + r202) - r514);
        int r203 = ((int) r1103) & M28;
        long r204 = (r195 >>> 28) + (((r915 + r411) - r198) + r202);
        int r205 = ((int) r204) & M28;
        long r1104 = ((r153 * r176) + (r197 * r148)) + (r189 * r189);
        long r412 = ((r161 * r179) + (r1100 * r156)) + (r190 * r190);
        long r515 = ((r169 * r182) + (r1102 * r164)) + (r191 * r191);
        long r206 = (r163 * r201) + (r165 * r165);
        long r1105 = (r1103 >>> 28) + (((r1104 + r412) + r206) - ((r147 * r199) + (r149 * r149)));
        int r207 = ((int) r1105) & M28;
        long r208 = (r204 >>> 28) + (((((r155 * r1101) + (r157 * r157)) + r515) - r1104) + r206);
        int r209 = ((int) r208) & M28;
        long r1106 = ((r151 * r176) + (r153 * r148)) + (r197 * r150);
        long r310 = ((r159 * r179) + (r161 * r156)) + (r1100 * r158);
        long r413 = ((r167 * r182) + (r169 * r164)) + (r1102 * r166);
        long r1107 = (((long) (r138 * 2)) & 4294967295L) * r163;
        long r1108 = (r1105 >>> 28) + (((r1106 + r310) + r1107) - (((long) r124) * r147));
        int r210 = ((int) r1108) & M28;
        long r211 = (r208 >>> 28) + ((((((long) r131) * r155) + r413) - r1106) + r1107);
        int r212 = ((int) r211) & M28;
        long r1109 = (((r149 * r176) + (r151 * r148)) + (r153 * r150)) + (r197 * r197);
        long r414 = r163 * r163;
        long r213 = (r1108 >>> 28) + (((r1109 + ((((r157 * r179) + (r159 * r156)) + (r161 * r158)) + (r1100 * r1100))) + r414) - (r147 * r147));
        int r214 = ((int) r213) & M28;
        long r215 = (r211 >>> 28) + ((((r155 * r155) + ((((r165 * r182) + (r167 * r164)) + (r169 * r166)) + (r1102 * r1102))) - r1109) + r414);
        int r1110 = ((int) r215) & M28;
        long r1111 = (((r147 * r176) + (r149 * r148)) + (r151 * r150)) + (r153 * r152);
        long r216 = (r213 >>> 28) + (((((r179 * r155) + (r157 * r156)) + (r159 * r158)) + (r161 * r160)) + r1111);
        int r217 = ((int) r216) & M28;
        long r218 = (r215 >>> 28) + (((((r182 * r163) + (r165 * r164)) + (r167 * r166)) + (r169 * r168)) - r1111);
        int r219 = ((int) r218) & M28;
        long r220 = r218 >>> 28;
        long r221 = ((r216 >>> 28) + r220) + ((long) r173);
        int r222 = ((int) r221) & M28;
        long r223 = r220 + ((long) r171);
        r111[0] = ((int) r223) & M28;
        r111[1] = r185 + ((int) (r223 >>> 28));
        r111[2] = r194;
        r111[3] = r203;
        r111[4] = r207;
        r111[5] = r210;
        r111[6] = r214;
        r111[7] = r217;
        r111[8] = r222;
        r111[9] = r187 + ((int) (r221 >>> 28));
        r111[10] = r196;
        r111[11] = r205;
        r111[12] = r209;
        r111[13] = r212;
        r111[14] = r1110;
        r111[15] = r219;
    }

    public static boolean sqrtRatioVar(int[] r100, int[] r101, int[] r102) {
        int[] r103 = create();
        int[] r104 = create();
        sqr(r100, r103);
        mul(r103, r101, r103);
        sqr(r103, r104);
        mul(r103, r100, r103);
        mul(r104, r100, r104);
        mul(r104, r101, r104);
        int[] r105 = create();
        powPm3d4(r104, r105);
        mul(r105, r103, r105);
        int[] r106 = create();
        sqr(r105, r106);
        mul(r106, r101, r106);
        sub(r100, r106, r106);
        normalize(r106);
        if (isZeroVar(r106) == false) goto L6;
        copy(r105, 0, r102, 0);
        return true;
    L6:
        return false;
    }

    public static void sub(int[] r410, int[] r510, int[] r511) {
        int r100 = r410[0];
        int r101 = r410[1];
        int r102 = r410[2];
        int r103 = r410[3];
        int r104 = r410[4];
        int r110 = r410[5];
        int r111 = r410[6];
        int r112 = r410[7];
        int r113 = r410[8];
        int r114 = r410[9];
        int r210 = r410[10];
        int r211 = r410[11];
        int r212 = r410[12];
        int r213 = r410[13];
        int r214 = r410[14];
        int r310 = r410[15];
        int r311 = r510[0];
        int r312 = r510[1];
        int r313 = r510[2];
        int r314 = r510[3];
        int r315 = r510[4];
        int r316 = r510[5];
        int r317 = r510[6];
        int r318 = r510[7];
        int r411 = r510[8];
        int r412 = r510[9];
        int r413 = r510[10];
        int r414 = r510[11];
        int r415 = r510[12];
        int r416 = r510[13];
        int r417 = r510[14];
        int r105 = (r100 + 536870910) - r311;
        int r106 = (r101 + 536870910) - r312;
        int r115 = (r110 + 536870910) - r316;
        int r116 = (r114 + 536870910) - r412;
        int r215 = (r213 + 536870910) - r416;
        int r319 = r310 + 536870910;
        int r320 = r319 - r510[15];
        int r107 = ((r102 + 536870910) - r313) + (r106 >>> 28);
        int r108 = r106 & M28;
        int r117 = ((r111 + 536870910) - r317) + (r115 >>> 28);
        int r118 = r115 & M28;
        int r216 = ((r210 + 536870910) - r413) + (r116 >>> 28);
        int r119 = r116 & M28;
        int r217 = ((r214 + 536870910) - r417) + (r215 >>> 28);
        int r218 = r215 & M28;
        int r109 = ((r103 + 536870910) - r314) + (r107 >>> 28);
        int r120 = r107 & M28;
        int r121 = ((r112 + 536870910) - r318) + (r117 >>> 28);
        int r122 = r117 & M28;
        int r219 = ((r211 + 536870910) - r414) + (r216 >>> 28);
        int r220 = r216 & M28;
        int r321 = r320 + (r217 >>> 28);
        int r221 = r217 & M28;
        int r322 = r321 >>> 28;
        int r323 = r321 & M28;
        int r123 = r105 + r322;
        int r124 = ((r113 + 536870908) - r411) + r322;
        int r125 = ((r104 + 536870910) - r315) + (r109 >>> 28);
        int r126 = r109 & M28;
        int r127 = r124 + (r121 >>> 28);
        int r128 = r121 & M28;
        int r222 = ((r212 + 536870910) - r415) + (r219 >>> 28);
        int r223 = r219 & M28;
        int r129 = r108 + (r123 >>> 28);
        int r130 = r123 & M28;
        int r131 = r118 + (r125 >>> 28);
        int r132 = r125 & M28;
        int r133 = r119 + (r127 >>> 28);
        int r134 = r127 & M28;
        int r224 = r218 + (r222 >>> 28);
        int r225 = r222 & M28;
        r511[0] = r130;
        r511[1] = r129;
        r511[2] = r120;
        r511[3] = r126;
        r511[4] = r132;
        r511[5] = r131;
        r511[6] = r122;
        r511[7] = r128;
        r511[8] = r134;
        r511[9] = r133;
        r511[10] = r220;
        r511[11] = r223;
        r511[12] = r225;
        r511[13] = r224;
        r511[14] = r221;
        r511[15] = r323;
    }

    public static void subOne(int[] r100) {
        int[] r101 = create();
        r101[0] = 1;
        sub(r100, r101, r100);
    }

    public static void zero(int[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 16) goto L6;
        r100[r101] = 0;
        r101 = r101 + 1;
        goto L4
    }
}
