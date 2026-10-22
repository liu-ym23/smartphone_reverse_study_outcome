package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.TweakableBlockCipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;
    private static final long C_240 = 2004413935125273122L;
    private static final int MAX_ROUNDS = 80;
    private static int[] MOD17 = null;
    private static int[] MOD3 = null;
    private static int[] MOD5 = null;
    private static int[] MOD9 = null;
    private static final int ROUNDS_1024 = 80;
    private static final int ROUNDS_256 = 72;
    private static final int ROUNDS_512 = 72;
    private static final int TWEAK_SIZE_BYTES = 16;
    private static final int TWEAK_SIZE_WORDS = 2;
    private int blocksizeBytes;
    private int blocksizeWords;
    private ThreefishCipher cipher;
    private long[] currentBlock;
    private boolean forEncryption;

    /* JADX INFO: renamed from: kw, reason: collision with root package name */
    private long[] f525202kw;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long[] f525203t;

    public static final class Threefish1024Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 24;
        private static final int ROTATION_0_1 = 13;
        private static final int ROTATION_0_2 = 8;
        private static final int ROTATION_0_3 = 47;
        private static final int ROTATION_0_4 = 8;
        private static final int ROTATION_0_5 = 17;
        private static final int ROTATION_0_6 = 22;
        private static final int ROTATION_0_7 = 37;
        private static final int ROTATION_1_0 = 38;
        private static final int ROTATION_1_1 = 19;
        private static final int ROTATION_1_2 = 10;
        private static final int ROTATION_1_3 = 55;
        private static final int ROTATION_1_4 = 49;
        private static final int ROTATION_1_5 = 18;
        private static final int ROTATION_1_6 = 23;
        private static final int ROTATION_1_7 = 52;
        private static final int ROTATION_2_0 = 33;
        private static final int ROTATION_2_1 = 4;
        private static final int ROTATION_2_2 = 51;
        private static final int ROTATION_2_3 = 13;
        private static final int ROTATION_2_4 = 34;
        private static final int ROTATION_2_5 = 41;
        private static final int ROTATION_2_6 = 59;
        private static final int ROTATION_2_7 = 17;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 20;
        private static final int ROTATION_3_2 = 48;
        private static final int ROTATION_3_3 = 41;
        private static final int ROTATION_3_4 = 47;
        private static final int ROTATION_3_5 = 28;
        private static final int ROTATION_3_6 = 16;
        private static final int ROTATION_3_7 = 25;
        private static final int ROTATION_4_0 = 41;
        private static final int ROTATION_4_1 = 9;
        private static final int ROTATION_4_2 = 37;
        private static final int ROTATION_4_3 = 31;
        private static final int ROTATION_4_4 = 12;
        private static final int ROTATION_4_5 = 47;
        private static final int ROTATION_4_6 = 44;
        private static final int ROTATION_4_7 = 30;
        private static final int ROTATION_5_0 = 16;
        private static final int ROTATION_5_1 = 34;
        private static final int ROTATION_5_2 = 56;
        private static final int ROTATION_5_3 = 51;
        private static final int ROTATION_5_4 = 4;
        private static final int ROTATION_5_5 = 53;
        private static final int ROTATION_5_6 = 42;
        private static final int ROTATION_5_7 = 41;
        private static final int ROTATION_6_0 = 31;
        private static final int ROTATION_6_1 = 44;
        private static final int ROTATION_6_2 = 47;
        private static final int ROTATION_6_3 = 46;
        private static final int ROTATION_6_4 = 19;
        private static final int ROTATION_6_5 = 42;
        private static final int ROTATION_6_6 = 44;
        private static final int ROTATION_6_7 = 25;
        private static final int ROTATION_7_0 = 9;
        private static final int ROTATION_7_1 = 48;
        private static final int ROTATION_7_2 = 35;
        private static final int ROTATION_7_3 = 52;
        private static final int ROTATION_7_4 = 23;
        private static final int ROTATION_7_5 = 31;
        private static final int ROTATION_7_6 = 37;
        private static final int ROTATION_7_7 = 20;

        public Threefish1024Cipher(long[] r100, long[] r101) {
            super(r100, r101);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] r710, long[] r711) {
            long[] r100 = this.f525204kw;
            long[] r101 = this.f525205t;
            int[] r102 = ThreefishEngine.access$300();
            int[] r103 = ThreefishEngine.access$100();
            if (r100.length != 33) goto L14;
            if (r101.length != 5) goto L12;
            long r104 = r710[0];
            int r105 = 1;
            long r110 = r710[1];
            long r111 = r710[2];
            long r112 = r710[3];
            long r113 = r710[4];
            long r210 = r710[5];
            long r211 = r710[6];
            long r212 = r710[7];
            long r213 = r710[8];
            long r310 = r710[9];
            long r311 = r710[10];
            long r312 = r710[11];
            long r313 = r710[12];
            long r314 = r710[13];
            long r410 = r710[14];
            long r411 = r710[15];
            int r114 = 19;
        L7:
            if (r114 < r105) goto L9;
            int r412 = r102[r114];
            int r413 = r103[r114];
            int r414 = r412 + 1;
            long r106 = r104 - r100[r414];
            int r510 = r412 + 2;
            long r115 = r110 - r100[r510];
            int r511 = r412 + 3;
            long r116 = r111 - r100[r511];
            int r512 = r412 + 4;
            long r107 = r112 - r100[r512];
            int r117 = r412 + 5;
            long r108 = r113 - r100[r117];
            int r118 = r412 + 6;
            int[] r513 = r102;
            int[] r514 = r103;
            long r109 = r210 - r100[r118];
            int r119 = r412 + 7;
            long r120 = r211 - r100[r119];
            int r121 = r412 + 8;
            long r122 = r212 - r100[r121];
            int r123 = r412 + 9;
            long r124 = r213 - r100[r123];
            int r214 = r412 + 10;
            long r125 = r310 - r100[r214];
            int r215 = r412 + 11;
            long r126 = r311 - r100[r215];
            int r216 = r412 + 12;
            long r127 = r312 - r100[r216];
            int r217 = r412 + 13;
            long r128 = r313 - r100[r217];
            int r315 = r412 + 14;
            int r316 = r413 + 1;
            long r129 = r314 - (r100[r315] + r101[r316]);
            int r317 = r412 + 15;
            long r130 = r410 - (r100[r317] + r101[r413 + 2]);
            long[] r610 = r100;
            long r131 = r114;
            long r132 = ThreefishEngine.xorRotr(r411 - ((r100[r412 + 16] + r131) + 1), 9, r106);
            long r133 = r106 - r132;
            long r134 = ThreefishEngine.xorRotr(r127, 48, r116);
            long r135 = r116 - r134;
            long r136 = ThreefishEngine.xorRotr(r129, 35, r120);
            long r137 = r120 - r136;
            long[] r611 = r101;
            long r138 = ThreefishEngine.xorRotr(r125, 52, r108);
            long r139 = r108 - r138;
            long r140 = ThreefishEngine.xorRotr(r115, 23, r130);
            long r141 = r130 - r140;
            long r142 = ThreefishEngine.xorRotr(r109, 31, r124);
            long r143 = r124 - r142;
            long r144 = ThreefishEngine.xorRotr(r107, 37, r126);
            long r145 = r126 - r144;
            long r146 = ThreefishEngine.xorRotr(r122, 20, r128);
            long r147 = r128 - r146;
            long r148 = ThreefishEngine.xorRotr(r146, 31, r133);
            long r149 = r133 - r148;
            long r150 = ThreefishEngine.xorRotr(r142, 44, r135);
            long r151 = r135 - r150;
            long r152 = ThreefishEngine.xorRotr(r144, 47, r139);
            long r153 = r139 - r152;
            long r154 = ThreefishEngine.xorRotr(r140, 46, r137);
            long r155 = r137 - r154;
            long r156 = ThreefishEngine.xorRotr(r132, 19, r147);
            long r157 = r147 - r156;
            long r158 = ThreefishEngine.xorRotr(r136, 42, r141);
            long r159 = r141 - r158;
            long r160 = ThreefishEngine.xorRotr(r134, 44, r143);
            long r161 = r143 - r160;
            long r162 = ThreefishEngine.xorRotr(r138, 25, r145);
            long r163 = r145 - r162;
            long r164 = ThreefishEngine.xorRotr(r162, 16, r149);
            long r165 = r149 - r164;
            long r166 = ThreefishEngine.xorRotr(r158, 34, r151);
            long r167 = r151 - r166;
            long r168 = ThreefishEngine.xorRotr(r160, 56, r155);
            long r169 = r155 - r168;
            long r170 = ThreefishEngine.xorRotr(r156, 51, r153);
            long r171 = r153 - r170;
            long r172 = ThreefishEngine.xorRotr(r148, 4, r163);
            long r173 = r163 - r172;
            long r174 = ThreefishEngine.xorRotr(r152, 53, r157);
            long r175 = r157 - r174;
            long r176 = ThreefishEngine.xorRotr(r150, 42, r159);
            long r177 = r159 - r176;
            long r178 = ThreefishEngine.xorRotr(r154, 41, r161);
            long r179 = r161 - r178;
            long r180 = ThreefishEngine.xorRotr(r178, 41, r165);
            long r181 = ThreefishEngine.xorRotr(r174, 9, r167);
            long r182 = ThreefishEngine.xorRotr(r176, 37, r171);
            long r183 = r171 - r182;
            long r184 = ThreefishEngine.xorRotr(r172, 31, r169);
            long r185 = r169 - r184;
            long r186 = ThreefishEngine.xorRotr(r164, 12, r179);
            long r187 = r179 - r186;
            long r188 = ThreefishEngine.xorRotr(r168, 47, r173);
            long r189 = r173 - r188;
            long r190 = ThreefishEngine.xorRotr(r166, 44, r175);
            long r191 = r175 - r190;
            long r192 = ThreefishEngine.xorRotr(r170, 30, r177);
            long r193 = r177 - r192;
            long r194 = (r165 - r180) - r610[r412];
            long r195 = r180 - r610[r414];
            long r196 = (r167 - r181) - r610[r510];
            long r197 = r181 - r610[r511];
            long r198 = r183 - r610[r512];
            long r199 = r182 - r610[r117];
            long r200 = r185 - r610[r118];
            long r201 = r184 - r610[r119];
            long r202 = r187 - r610[r121];
            long r203 = r186 - r610[r123];
            long r204 = r189 - r610[r214];
            long r205 = r188 - r610[r215];
            long r1100 = r191 - r610[r216];
            long r1101 = r190 - (r610[r217] + r611[r413]);
            long r206 = r193 - (r610[r315] + r611[r316]);
            long r207 = ThreefishEngine.xorRotr(r192 - (r610[r317] + r131), 5, r194);
            long r208 = r194 - r207;
            long r209 = ThreefishEngine.xorRotr(r205, 20, r196);
            long r1102 = r196 - r209;
            long r1103 = ThreefishEngine.xorRotr(r1101, 48, r200);
            long r218 = r200 - r1103;
            long r1104 = ThreefishEngine.xorRotr(r203, 41, r198);
            long r219 = r198 - r1104;
            long r1105 = ThreefishEngine.xorRotr(r195, 47, r206);
            long r220 = r206 - r1105;
            long r221 = ThreefishEngine.xorRotr(r199, 28, r202);
            long r222 = r202 - r221;
            long r223 = ThreefishEngine.xorRotr(r197, 16, r204);
            long r224 = r204 - r223;
            long r225 = ThreefishEngine.xorRotr(r201, 25, r1100);
            long r1106 = r1100 - r225;
            long r226 = ThreefishEngine.xorRotr(r225, 33, r208);
            long r227 = r208 - r226;
            long r228 = ThreefishEngine.xorRotr(r221, 4, r1102);
            long r1107 = r1102 - r228;
            long r229 = ThreefishEngine.xorRotr(r223, 51, r219);
            long r230 = r219 - r229;
            long r231 = ThreefishEngine.xorRotr(r1105, 13, r218);
            long r232 = r218 - r231;
            long r233 = ThreefishEngine.xorRotr(r207, 34, r1106);
            long r1108 = r1106 - r233;
            long r1109 = ThreefishEngine.xorRotr(r1103, 41, r220);
            long r234 = r220 - r1109;
            long r235 = ThreefishEngine.xorRotr(r209, 59, r222);
            long r236 = r222 - r235;
            long r237 = ThreefishEngine.xorRotr(r1104, 17, r224);
            long r238 = r224 - r237;
            long r239 = ThreefishEngine.xorRotr(r237, 38, r227);
            long r240 = r227 - r239;
            long r1110 = ThreefishEngine.xorRotr(r1109, 19, r1107);
            long r1111 = r1107 - r1110;
            long r241 = ThreefishEngine.xorRotr(r235, 10, r232);
            long r242 = r232 - r241;
            long r243 = ThreefishEngine.xorRotr(r233, 55, r230);
            long r1112 = r230 - r243;
            long r244 = ThreefishEngine.xorRotr(r226, 49, r238);
            long r245 = r238 - r244;
            long r246 = ThreefishEngine.xorRotr(r229, 18, r1108);
            long r247 = r1108 - r246;
            long r248 = ThreefishEngine.xorRotr(r228, 23, r234);
            long r249 = r234 - r248;
            long r250 = ThreefishEngine.xorRotr(r231, 52, r236);
            long r251 = r236 - r250;
            long r252 = ThreefishEngine.xorRotr(r250, 24, r240);
            long r253 = r240 - r252;
            long r254 = ThreefishEngine.xorRotr(r246, 13, r1111);
            r111 = r1111 - r254;
            long r255 = ThreefishEngine.xorRotr(r248, 8, r1112);
            long r1113 = r1112 - r255;
            long r256 = ThreefishEngine.xorRotr(r244, 47, r242);
            long r257 = r242 - r256;
            long r258 = ThreefishEngine.xorRotr(r239, 8, r251);
            long r259 = r251 - r258;
            long r260 = ThreefishEngine.xorRotr(r241, 17, r245);
            long r261 = r245 - r260;
            r314 = ThreefishEngine.xorRotr(r1110, 22, r247);
            r411 = ThreefishEngine.xorRotr(r243, 37, r249);
            r410 = r249 - r411;
            r312 = r260;
            r313 = r247 - r314;
            r102 = r513;
            r101 = r611;
            r100 = r610;
            r213 = r259;
            r310 = r258;
            r105 = 1;
            r113 = r1113;
            r110 = r252;
            r114 = r114 - 2;
            r112 = r254;
            r103 = r514;
            r212 = r256;
            r311 = r261;
            r210 = r255;
            r211 = r257;
            r104 = r253;
            goto L7
        L9:
            long[] r612 = r100;
            long[] r613 = r101;
            long r262 = r104 - r612[0];
            long r1114 = r110 - r612[1];
            long r1115 = r111 - r612[2];
            long r1116 = r112 - r612[3];
            long r1117 = r113 - r612[4];
            long r263 = r210 - r612[5];
            long r264 = r211 - r612[6];
            long r265 = r212 - r612[7];
            long r266 = r213 - r612[8];
            long r318 = r310 - r612[9];
            long r319 = r311 - r612[10];
            long r320 = r312 - r612[11];
            long r321 = r313 - r612[12];
            long r322 = r314 - (r612[13] + r613[0]);
            long r415 = r410 - (r612[14] + r613[1]);
            long r416 = r411 - r612[15];
            r711[0] = r262;
            r711[1] = r1114;
            r711[2] = r1115;
            r711[3] = r1116;
            r711[4] = r1117;
            r711[5] = r263;
            r711[6] = r264;
            r711[7] = r265;
            r711[8] = r266;
            r711[9] = r318;
            r711[10] = r319;
            r711[11] = r320;
            r711[12] = r321;
            r711[13] = r322;
            r711[14] = r415;
            r711[15] = r416;
            return;
        L12:
            throw new IllegalArgumentException();
        L14:
            throw new IllegalArgumentException();
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] r810, long[] r811) {
            long[] r100 = this.f525204kw;
            long[] r101 = this.f525205t;
            int[] r102 = ThreefishEngine.access$300();
            int[] r103 = ThreefishEngine.access$100();
            if (r100.length != 33) goto L15;
            if (r101.length != 5) goto L13;
            long r104 = r810[0];
            int r105 = 1;
            long r110 = r810[1];
            long r111 = r810[2];
            long r112 = r810[3];
            long r113 = r810[4];
            long r210 = r810[5];
            long r211 = r810[6];
            long r212 = r810[7];
            long r310 = r810[8];
            long r311 = r810[9];
            long r312 = r810[10];
            long r313 = r810[11];
            long r410 = r810[12];
            long r411 = r810[13];
            long r412 = r810[14];
            long r510 = r810[15];
            long r106 = r104 + r100[0];
            long r114 = r110 + r100[1];
            long r115 = r111 + r100[2];
            long r116 = r112 + r100[3];
            long r117 = r113 + r100[4];
            long r213 = r210 + r100[5];
            long r214 = r211 + r100[6];
            long r215 = r212 + r100[7];
            long r314 = r310 + r100[8];
            long r315 = r311 + r100[9];
            long r316 = r312 + r100[10];
            long r317 = r313 + r100[11];
            long r413 = r410 + r100[12];
            long r414 = r411 + (r100[13] + r101[0]);
            long r415 = r412 + (r100[14] + r101[1]);
            long r107 = r116;
            long r511 = r213;
            long r512 = r215;
            long r610 = r315;
            long r611 = r317;
            long r612 = r414;
            long r613 = r510 + r100[15];
        L8:
            if (r105 >= 20) goto L10;
            int r216 = r102[r105];
            int r217 = r103[r105];
            long r108 = r106 + r114;
            long r118 = ThreefishEngine.rotlXor(r114, 24, r108);
            long r119 = r115 + r107;
            long r109 = ThreefishEngine.rotlXor(r107, 13, r119);
            long[] r120 = r100;
            int[] r318 = r102;
            int[] r319 = r103;
            long r121 = r511;
            long r122 = r117 + r121;
            long r123 = ThreefishEngine.rotlXor(r121, 8, r122);
            int r416 = r105;
            long r124 = r512;
            long r125 = r214 + r124;
            long r126 = ThreefishEngine.rotlXor(r124, 47, r125);
            long[] r513 = r101;
            long r127 = r610;
            long r128 = r314 + r127;
            long r129 = ThreefishEngine.rotlXor(r127, 8, r128);
            long r130 = r611;
            long r131 = r316 + r130;
            long r132 = ThreefishEngine.rotlXor(r130, 17, r131);
            long r133 = r612;
            long r134 = r413 + r133;
            long r135 = ThreefishEngine.rotlXor(r133, 22, r134);
            long r136 = r613;
            long r137 = r415 + r136;
            long r138 = ThreefishEngine.rotlXor(r136, 37, r137);
            long r139 = r108 + r129;
            long r140 = ThreefishEngine.rotlXor(r129, 38, r139);
            long r141 = r119 + r135;
            long r142 = ThreefishEngine.rotlXor(r135, 19, r141);
            long r143 = r125 + r132;
            long r144 = ThreefishEngine.rotlXor(r132, 10, r143);
            long r145 = r122 + r138;
            long r146 = ThreefishEngine.rotlXor(r138, 55, r145);
            long r147 = r131 + r126;
            long r148 = ThreefishEngine.rotlXor(r126, 49, r147);
            long r149 = r134 + r109;
            long r150 = ThreefishEngine.rotlXor(r109, 18, r149);
            long r151 = r137 + r123;
            long r152 = ThreefishEngine.rotlXor(r123, 23, r151);
            long r153 = r128 + r118;
            long r154 = ThreefishEngine.rotlXor(r118, 52, r153);
            long r155 = r139 + r148;
            long r156 = ThreefishEngine.rotlXor(r148, 33, r155);
            long r157 = r141 + r152;
            long r158 = ThreefishEngine.rotlXor(r152, 4, r157);
            long r159 = r145 + r150;
            long r160 = ThreefishEngine.rotlXor(r150, 51, r159);
            long r161 = r143 + r154;
            long r162 = ThreefishEngine.rotlXor(r154, 13, r161);
            long r163 = r149 + r146;
            long r164 = ThreefishEngine.rotlXor(r146, 34, r163);
            long r165 = r151 + r142;
            long r166 = ThreefishEngine.rotlXor(r142, 41, r165);
            long r167 = r153 + r144;
            long r168 = ThreefishEngine.rotlXor(r144, 59, r167);
            long r169 = r147 + r140;
            long r170 = ThreefishEngine.rotlXor(r140, 17, r169);
            long r171 = r155 + r164;
            long r172 = ThreefishEngine.rotlXor(r164, 5, r171);
            long r173 = r157 + r168;
            long r174 = ThreefishEngine.rotlXor(r168, 20, r173);
            long r175 = r161 + r166;
            long r176 = ThreefishEngine.rotlXor(r166, 48, r175);
            long r177 = r159 + r170;
            long r178 = ThreefishEngine.rotlXor(r170, 41, r177);
            long r179 = r165 + r162;
            long r180 = ThreefishEngine.rotlXor(r162, 47, r179);
            long r181 = r167 + r158;
            long r182 = ThreefishEngine.rotlXor(r158, 28, r181);
            long r183 = r169 + r160;
            long r184 = ThreefishEngine.rotlXor(r160, 16, r183);
            long r185 = r163 + r156;
            long r186 = ThreefishEngine.rotlXor(r156, 25, r185);
            long r187 = r171 + r120[r216];
            int r188 = r216 + 1;
            long r189 = r180 + r120[r188];
            int r190 = r216 + 2;
            long r417 = r173 + r120[r190];
            int r218 = r216 + 3;
            long r191 = r184 + r120[r218];
            int r614 = r216 + 4;
            long r192 = r177 + r120[r614];
            int r615 = r216 + 5;
            long r193 = r182 + r120[r615];
            int r616 = r216 + 6;
            long r617 = r175 + r120[r616];
            int r618 = r216 + 7;
            long r194 = r186 + r120[r618];
            int r619 = r216 + 8;
            long r418 = r181 + r120[r619];
            int r620 = r216 + 9;
            long r195 = r178 + r120[r620];
            int r320 = r216 + 10;
            long r321 = r183 + r120[r320];
            int r322 = r216 + 11;
            long r196 = r174 + r120[r322];
            int r514 = r216 + 12;
            long r197 = r185 + r120[r514];
            int r515 = r216 + 13;
            long r198 = r176 + (r120[r515] + r513[r217]);
            int r516 = r216 + 14;
            int r517 = r217 + 1;
            long r518 = r179 + (r120[r516] + r513[r517]);
            int r621 = r216 + 15;
            long r199 = r416;
            long r1100 = r172 + (r120[r621] + r199);
            long r1101 = r187 + r189;
            long r200 = ThreefishEngine.rotlXor(r189, 41, r1101);
            long r201 = r417 + r191;
            long r202 = ThreefishEngine.rotlXor(r191, 9, r201);
            long r1102 = r192 + r193;
            long r203 = ThreefishEngine.rotlXor(r193, 37, r1102);
            long r204 = r617 + r194;
            long r205 = ThreefishEngine.rotlXor(r194, 31, r204);
            long r206 = r418 + r195;
            long r207 = ThreefishEngine.rotlXor(r195, 12, r206);
            long r208 = r321 + r196;
            long r209 = ThreefishEngine.rotlXor(r196, 47, r208);
            long r1103 = r197 + r198;
            long r219 = ThreefishEngine.rotlXor(r198, 44, r1103);
            long r220 = r518 + r1100;
            long r1104 = ThreefishEngine.rotlXor(r1100, 30, r220);
            long r1105 = r1101 + r207;
            long r221 = ThreefishEngine.rotlXor(r207, 16, r1105);
            long r222 = r201 + r219;
            long r223 = ThreefishEngine.rotlXor(r219, 34, r222);
            long r1106 = r204 + r209;
            long r224 = ThreefishEngine.rotlXor(r209, 56, r1106);
            long r225 = r1102 + r1104;
            long r226 = ThreefishEngine.rotlXor(r1104, 51, r225);
            long r1107 = r208 + r205;
            long r227 = ThreefishEngine.rotlXor(r205, 4, r1107);
            long r228 = r1103 + r202;
            long r1108 = ThreefishEngine.rotlXor(r202, 53, r228);
            long r229 = r220 + r203;
            long r230 = ThreefishEngine.rotlXor(r203, 42, r229);
            long r1109 = r206 + r200;
            long r231 = ThreefishEngine.rotlXor(r200, 41, r1109);
            long r1110 = r1105 + r227;
            long r232 = ThreefishEngine.rotlXor(r227, 31, r1110);
            long r233 = r222 + r230;
            long r234 = ThreefishEngine.rotlXor(r230, 44, r233);
            long r235 = r225 + r1108;
            long r236 = ThreefishEngine.rotlXor(r1108, 47, r235);
            long r1111 = r1106 + r231;
            long r237 = ThreefishEngine.rotlXor(r231, 46, r1111);
            long r238 = r228 + r226;
            long r239 = ThreefishEngine.rotlXor(r226, 19, r238);
            long r240 = r229 + r223;
            long r241 = ThreefishEngine.rotlXor(r223, 42, r240);
            long r1112 = r1109 + r224;
            long r242 = ThreefishEngine.rotlXor(r224, 44, r1112);
            long r243 = r1107 + r221;
            long r244 = ThreefishEngine.rotlXor(r221, 25, r243);
            long r1113 = r1110 + r239;
            long r245 = ThreefishEngine.rotlXor(r239, 9, r1113);
            long r246 = r233 + r242;
            long r247 = ThreefishEngine.rotlXor(r242, 48, r246);
            long r1114 = r1111 + r241;
            long r248 = ThreefishEngine.rotlXor(r241, 35, r1114);
            long r1115 = r235 + r244;
            long r249 = ThreefishEngine.rotlXor(r244, 52, r1115);
            long r250 = r240 + r237;
            long r251 = ThreefishEngine.rotlXor(r237, 23, r250);
            long r252 = r1112 + r234;
            long r253 = ThreefishEngine.rotlXor(r234, 31, r252);
            long r254 = r243 + r236;
            long r255 = ThreefishEngine.rotlXor(r236, 37, r254);
            long r1116 = r238 + r232;
            long r256 = ThreefishEngine.rotlXor(r232, 20, r1116);
            long r257 = r120[r188] + r1113;
            long r258 = r251 + r120[r190];
            long r259 = r246 + r120[r218];
            long r260 = r255 + r120[r614];
            long r1117 = r120[r615] + r1115;
            long r1118 = r253 + r120[r616];
            long r1119 = r1114 + r120[r618];
            r512 = r256 + r120[r619];
            long r261 = r252 + r120[r620];
            r610 = r249 + r120[r320];
            r316 = r254 + r120[r322];
            r611 = r247 + r120[r514];
            r413 = r1116 + r120[r515];
            r612 = r248 + (r120[r516] + r513[r517]);
            r415 = r250 + (r120[r621] + r513[r217 + 2]);
            r613 = r245 + ((r120[r216 + 16] + r199) + 1);
            r314 = r261;
            r511 = r1118;
            r214 = r1119;
            r103 = r319;
            r117 = r1117;
            r115 = r259;
            r105 = r416 + 2;
            r114 = r258;
            r106 = r257;
            r100 = r120;
            r107 = r260;
            r102 = r318;
            r101 = r513;
            goto L8
        L10:
            r811[0] = r106;
            r811[1] = r114;
            r811[2] = r115;
            r811[3] = r107;
            r811[4] = r117;
            r811[5] = r511;
            r811[6] = r214;
            r811[7] = r512;
            r811[8] = r314;
            r811[9] = r610;
            r811[10] = r316;
            r811[11] = r611;
            r811[12] = r413;
            r811[13] = r612;
            r811[14] = r415;
            r811[15] = r613;
            return;
        L13:
            throw new IllegalArgumentException();
        L15:
            throw new IllegalArgumentException();
        }
    }

    public static final class Threefish256Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 14;
        private static final int ROTATION_0_1 = 16;
        private static final int ROTATION_1_0 = 52;
        private static final int ROTATION_1_1 = 57;
        private static final int ROTATION_2_0 = 23;
        private static final int ROTATION_2_1 = 40;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 37;
        private static final int ROTATION_4_0 = 25;
        private static final int ROTATION_4_1 = 33;
        private static final int ROTATION_5_0 = 46;
        private static final int ROTATION_5_1 = 12;
        private static final int ROTATION_6_0 = 58;
        private static final int ROTATION_6_1 = 22;
        private static final int ROTATION_7_0 = 32;
        private static final int ROTATION_7_1 = 32;

        public Threefish256Cipher(long[] r100, long[] r101) {
            super(r100, r101);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] r310, long[] r311) {
            long[] r100 = this.f525204kw;
            long[] r101 = this.f525205t;
            int[] r102 = ThreefishEngine.access$000();
            int[] r103 = ThreefishEngine.access$100();
            if (r100.length != 9) goto L14;
            if (r101.length != 5) goto L12;
            long r104 = r310[0];
            int r105 = 1;
            long r110 = r310[1];
            long r111 = r310[2];
            long r112 = r310[3];
            int r113 = 17;
        L7:
            if (r113 < r105) goto L9;
            int r114 = r102[r113];
            int r210 = r103[r113];
            int r211 = r114 + 1;
            long r106 = r104 - r100[r211];
            int r212 = r114 + 2;
            int r213 = r210 + 1;
            long r115 = r110 - (r100[r212] + r101[r213]);
            int r214 = r114 + 3;
            long r116 = r111 - (r100[r214] + r101[r210 + 2]);
            long r107 = r113;
            long r108 = ThreefishEngine.xorRotr(r112 - ((r100[r114 + 4] + r107) + 1), 32, r106);
            long r109 = r106 - r108;
            int[] r215 = r102;
            long r117 = ThreefishEngine.xorRotr(r115, 32, r116);
            long r118 = r116 - r117;
            long r119 = ThreefishEngine.xorRotr(r117, 58, r109);
            long r120 = r109 - r119;
            long r121 = ThreefishEngine.xorRotr(r108, 22, r118);
            long r122 = r118 - r121;
            long r123 = ThreefishEngine.xorRotr(r121, 46, r120);
            long r124 = r120 - r123;
            long r125 = ThreefishEngine.xorRotr(r119, 12, r122);
            long r126 = r122 - r125;
            long r127 = ThreefishEngine.xorRotr(r125, 25, r124);
            long r128 = ThreefishEngine.xorRotr(r123, 33, r126);
            long r129 = (r124 - r127) - r100[r114];
            long r130 = r127 - (r100[r211] + r101[r210]);
            long r131 = (r126 - r128) - (r100[r212] + r101[r213]);
            long r132 = ThreefishEngine.xorRotr(r128 - (r100[r214] + r107), 5, r129);
            long r133 = r129 - r132;
            long r134 = ThreefishEngine.xorRotr(r130, 37, r131);
            long r135 = r131 - r134;
            long r136 = ThreefishEngine.xorRotr(r134, 23, r133);
            long r137 = r133 - r136;
            long r138 = ThreefishEngine.xorRotr(r132, 40, r135);
            long r139 = r135 - r138;
            long r140 = ThreefishEngine.xorRotr(r138, 52, r137);
            long r141 = r137 - r140;
            long r142 = ThreefishEngine.xorRotr(r136, 57, r139);
            long r143 = r139 - r142;
            long r144 = ThreefishEngine.xorRotr(r142, 14, r141);
            r104 = r141 - r144;
            r112 = ThreefishEngine.xorRotr(r140, 16, r143);
            r111 = r143 - r112;
            r113 = r113 - 2;
            r110 = r144;
            r102 = r215;
            r103 = r103;
            r105 = 1;
            goto L7
        L9:
            long r145 = r104 - r100[0];
            long r146 = r110 - (r100[1] + r101[0]);
            long r147 = r111 - (r100[2] + r101[1]);
            long r148 = r112 - r100[3];
            r311[0] = r145;
            r311[1] = r146;
            r311[2] = r147;
            r311[3] = r148;
            return;
        L12:
            throw new IllegalArgumentException();
        L14:
            throw new IllegalArgumentException();
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] r310, long[] r311) {
            long[] r100 = this.f525204kw;
            long[] r101 = this.f525205t;
            int[] r102 = ThreefishEngine.access$000();
            int[] r103 = ThreefishEngine.access$100();
            if (r100.length != 9) goto L15;
            if (r101.length != 5) goto L13;
            long r104 = r310[0];
            long r110 = r310[1];
            long r111 = r310[2];
            long r112 = r310[3];
            long r105 = r104 + r100[0];
            long r113 = r110 + (r100[1] + r101[0]);
            long r114 = r111 + (r100[2] + r101[1]);
            long r106 = r112 + r100[3];
            int r115 = 1;
        L8:
            if (r115 >= 18) goto L10;
            int r107 = r102[r115];
            int r210 = r103[r115];
            long r108 = r105 + r113;
            long r116 = ThreefishEngine.rotlXor(r113, 14, r108);
            long r117 = r114 + r106;
            long r109 = ThreefishEngine.rotlXor(r106, 16, r117);
            long r118 = r108 + r109;
            long r119 = ThreefishEngine.rotlXor(r109, 52, r118);
            long r120 = r117 + r116;
            long r121 = ThreefishEngine.rotlXor(r116, 57, r120);
            long r122 = r118 + r121;
            long r123 = ThreefishEngine.rotlXor(r121, 23, r122);
            long r124 = r120 + r119;
            long r125 = ThreefishEngine.rotlXor(r119, 40, r124);
            long r126 = r122 + r125;
            long r127 = ThreefishEngine.rotlXor(r125, 5, r126);
            long r128 = r124 + r123;
            long r129 = ThreefishEngine.rotlXor(r123, 37, r128);
            long r130 = r126 + r100[r107];
            int r131 = r107 + 1;
            long r132 = r129 + (r100[r131] + r101[r210]);
            int r211 = r107 + 2;
            int r212 = r210 + 1;
            long r133 = r128 + (r100[r211] + r101[r212]);
            int r213 = r107 + 3;
            int[] r214 = r102;
            long r134 = r115;
            long r135 = r127 + (r100[r213] + r134);
            long r136 = r130 + r132;
            long r137 = ThreefishEngine.rotlXor(r132, 25, r136);
            long r138 = r133 + r135;
            long r139 = ThreefishEngine.rotlXor(r135, 33, r138);
            long r140 = r136 + r139;
            long r141 = ThreefishEngine.rotlXor(r139, 46, r140);
            long r142 = r138 + r137;
            long r143 = ThreefishEngine.rotlXor(r137, 12, r142);
            long r144 = r140 + r143;
            long r145 = ThreefishEngine.rotlXor(r143, 58, r144);
            long r146 = r142 + r141;
            long r147 = ThreefishEngine.rotlXor(r141, 22, r146);
            long r148 = r144 + r147;
            long r149 = ThreefishEngine.rotlXor(r147, 32, r148);
            long r150 = r146 + r145;
            long r151 = ThreefishEngine.rotlXor(r145, 32, r150);
            r105 = r148 + r100[r131];
            r113 = r151 + (r100[r211] + r101[r212]);
            r114 = r150 + (r100[r213] + r101[r210 + 2]);
            r106 = r149 + ((r100[r107 + 4] + r134) + 1);
            r115 = r115 + 2;
            r102 = r214;
            r103 = r103;
            goto L8
        L10:
            r311[0] = r105;
            r311[1] = r113;
            r311[2] = r114;
            r311[3] = r106;
            return;
        L13:
            throw new IllegalArgumentException();
        L15:
            throw new IllegalArgumentException();
        }
    }

    public static final class Threefish512Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 46;
        private static final int ROTATION_0_1 = 36;
        private static final int ROTATION_0_2 = 19;
        private static final int ROTATION_0_3 = 37;
        private static final int ROTATION_1_0 = 33;
        private static final int ROTATION_1_1 = 27;
        private static final int ROTATION_1_2 = 14;
        private static final int ROTATION_1_3 = 42;
        private static final int ROTATION_2_0 = 17;
        private static final int ROTATION_2_1 = 49;
        private static final int ROTATION_2_2 = 36;
        private static final int ROTATION_2_3 = 39;
        private static final int ROTATION_3_0 = 44;
        private static final int ROTATION_3_1 = 9;
        private static final int ROTATION_3_2 = 54;
        private static final int ROTATION_3_3 = 56;
        private static final int ROTATION_4_0 = 39;
        private static final int ROTATION_4_1 = 30;
        private static final int ROTATION_4_2 = 34;
        private static final int ROTATION_4_3 = 24;
        private static final int ROTATION_5_0 = 13;
        private static final int ROTATION_5_1 = 50;
        private static final int ROTATION_5_2 = 10;
        private static final int ROTATION_5_3 = 17;
        private static final int ROTATION_6_0 = 25;
        private static final int ROTATION_6_1 = 29;
        private static final int ROTATION_6_2 = 39;
        private static final int ROTATION_6_3 = 43;
        private static final int ROTATION_7_0 = 8;
        private static final int ROTATION_7_1 = 35;
        private static final int ROTATION_7_2 = 56;
        private static final int ROTATION_7_3 = 22;

        public Threefish512Cipher(long[] r100, long[] r101) {
            super(r100, r101);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] r410, long[] r510) {
            long[] r100 = this.f525204kw;
            long[] r101 = this.f525205t;
            int[] r102 = ThreefishEngine.access$200();
            int[] r103 = ThreefishEngine.access$100();
            if (r100.length != 17) goto L14;
            if (r101.length != 5) goto L12;
            long r104 = r410[0];
            int r110 = 1;
            long r111 = r410[1];
            long r112 = r410[2];
            long r113 = r410[3];
            long r210 = r410[4];
            long r211 = r410[5];
            long r212 = r410[6];
            long r213 = r410[7];
            int r105 = 17;
        L7:
            if (r105 < r110) goto L9;
            int r310 = r102[r105];
            int r311 = r103[r105];
            int r312 = r310 + 1;
            long r106 = r104 - r100[r312];
            int r313 = r310 + 2;
            long r114 = r111 - r100[r313];
            int r314 = r310 + 3;
            long r115 = r112 - r100[r314];
            int r315 = r310 + 4;
            long r107 = r113 - r100[r315];
            int r116 = r310 + 5;
            long r117 = r210 - r100[r116];
            int r118 = r310 + 6;
            int r119 = r311 + 1;
            long r120 = r211 - (r100[r118] + r101[r119]);
            int r121 = r310 + 7;
            int[] r316 = r102;
            int[] r411 = r103;
            long r108 = r212 - (r100[r121] + r101[r311 + 2]);
            long[] r412 = r100;
            long r109 = r105;
            long r122 = r213 - ((r100[r310 + 8] + r109) + 1);
            int r413 = r105;
            long r123 = ThreefishEngine.xorRotr(r114, 8, r108);
            long r124 = r108 - r123;
            long r125 = ThreefishEngine.xorRotr(r122, 35, r106);
            long r126 = r106 - r125;
            long r127 = ThreefishEngine.xorRotr(r120, 56, r115);
            long r128 = r115 - r127;
            long r129 = ThreefishEngine.xorRotr(r107, 22, r117);
            long r130 = r117 - r129;
            long r131 = ThreefishEngine.xorRotr(r123, 25, r130);
            long r132 = r130 - r131;
            long r133 = ThreefishEngine.xorRotr(r129, 29, r124);
            long r134 = r124 - r133;
            long r135 = ThreefishEngine.xorRotr(r127, 39, r126);
            long r136 = r126 - r135;
            long r137 = ThreefishEngine.xorRotr(r125, 43, r128);
            long r138 = r128 - r137;
            long r139 = ThreefishEngine.xorRotr(r131, 13, r138);
            long r140 = r138 - r139;
            long r141 = ThreefishEngine.xorRotr(r137, 50, r132);
            long r142 = r132 - r141;
            long r143 = ThreefishEngine.xorRotr(r135, 10, r134);
            long r144 = r134 - r143;
            long r145 = ThreefishEngine.xorRotr(r133, 17, r136);
            long r146 = r136 - r145;
            long r147 = ThreefishEngine.xorRotr(r139, 39, r146);
            long r148 = ThreefishEngine.xorRotr(r145, 30, r140);
            long r149 = ThreefishEngine.xorRotr(r143, 34, r142);
            long r150 = r142 - r149;
            long r151 = ThreefishEngine.xorRotr(r141, 24, r144);
            long r152 = (r146 - r147) - r412[r310];
            long r153 = r147 - r412[r312];
            long r154 = (r140 - r148) - r412[r313];
            long r155 = r148 - r412[r314];
            long r156 = r150 - r412[r315];
            long r157 = r149 - (r412[r116] + r101[r311]);
            long r158 = (r144 - r151) - (r412[r118] + r101[r119]);
            long r159 = r151 - (r412[r121] + r109);
            long r160 = ThreefishEngine.xorRotr(r153, 44, r158);
            long r161 = r158 - r160;
            long r162 = ThreefishEngine.xorRotr(r159, 9, r152);
            long r163 = r152 - r162;
            long r164 = ThreefishEngine.xorRotr(r157, 54, r154);
            long r165 = r154 - r164;
            long r166 = ThreefishEngine.xorRotr(r155, 56, r156);
            long r167 = r156 - r166;
            long r168 = ThreefishEngine.xorRotr(r160, 17, r167);
            long r169 = r167 - r168;
            long r170 = ThreefishEngine.xorRotr(r166, 49, r161);
            long r171 = r161 - r170;
            long r172 = ThreefishEngine.xorRotr(r164, 36, r163);
            long r173 = r163 - r172;
            long r174 = ThreefishEngine.xorRotr(r162, 39, r165);
            long r175 = r165 - r174;
            long r176 = ThreefishEngine.xorRotr(r168, 33, r175);
            long r177 = r175 - r176;
            long r178 = ThreefishEngine.xorRotr(r174, 27, r169);
            long r179 = r169 - r178;
            long r180 = ThreefishEngine.xorRotr(r172, 14, r171);
            long r181 = r171 - r180;
            long[] r317 = r101;
            long r182 = ThreefishEngine.xorRotr(r170, 42, r173);
            long r183 = r173 - r182;
            long r184 = ThreefishEngine.xorRotr(r176, 46, r183);
            long r185 = r183 - r184;
            r113 = ThreefishEngine.xorRotr(r182, 36, r177);
            long r186 = ThreefishEngine.xorRotr(r180, 19, r179);
            r210 = r179 - r186;
            r213 = ThreefishEngine.xorRotr(r178, 37, r181);
            r212 = r181 - r213;
            r112 = r177 - r113;
            r111 = r184;
            r211 = r186;
            r105 = r413 - 2;
            r103 = r411;
            r100 = r412;
            r110 = 1;
            r104 = r185;
            r101 = r317;
            r102 = r316;
            goto L7
        L9:
            long[] r414 = r100;
            long[] r318 = r101;
            long r187 = r104 - r414[0];
            long r188 = r111 - r414[1];
            long r189 = r112 - r414[2];
            long r190 = r113 - r414[3];
            long r214 = r210 - r414[4];
            long r215 = r211 - (r414[5] + r318[0]);
            long r216 = r212 - (r414[6] + r318[1]);
            long r217 = r213 - r414[7];
            r510[0] = r187;
            r510[1] = r188;
            r510[2] = r189;
            r510[3] = r190;
            r510[4] = r214;
            r510[5] = r215;
            r510[6] = r216;
            r510[7] = r217;
            return;
        L12:
            throw new IllegalArgumentException();
        L14:
            throw new IllegalArgumentException();
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] r410, long[] r510) {
            long[] r100 = this.f525204kw;
            long[] r101 = this.f525205t;
            int[] r102 = ThreefishEngine.access$200();
            int[] r103 = ThreefishEngine.access$100();
            if (r100.length != 17) goto L15;
            if (r101.length != 5) goto L13;
            long r104 = r410[0];
            long r110 = r410[1];
            long r111 = r410[2];
            long r112 = r410[3];
            long r210 = r410[4];
            long r211 = r410[5];
            long r212 = r410[6];
            long r213 = r410[7];
            long r105 = r104 + r100[0];
            long r113 = r110 + r100[1];
            long r114 = r111 + r100[2];
            long r115 = r112 + r100[3];
            long r214 = r210 + r100[4];
            long r215 = r211 + (r100[5] + r101[0]);
            long r216 = r212 + (r100[6] + r101[1]);
            long r106 = r115;
            long r310 = r215;
            long r311 = r213 + r100[7];
            int r107 = 1;
        L8:
            if (r107 >= 18) goto L10;
            int r116 = r102[r107];
            int r217 = r103[r107];
            long r108 = r105 + r113;
            long r117 = ThreefishEngine.rotlXor(r113, 46, r108);
            long r118 = r114 + r106;
            long r109 = ThreefishEngine.rotlXor(r106, 36, r118);
            long r119 = r310;
            int[] r120 = r102;
            long r121 = r214 + r119;
            long r122 = ThreefishEngine.rotlXor(r119, 19, r121);
            long[] r312 = r100;
            long r123 = r311;
            long r124 = r216 + r123;
            long r125 = ThreefishEngine.rotlXor(r123, 37, r124);
            int r126 = r107;
            long r127 = r118 + r117;
            long r128 = ThreefishEngine.rotlXor(r117, 33, r127);
            long r129 = r121 + r125;
            long r130 = ThreefishEngine.rotlXor(r125, 27, r129);
            long r131 = r124 + r122;
            long r132 = ThreefishEngine.rotlXor(r122, 14, r131);
            long r133 = r108 + r109;
            long r134 = ThreefishEngine.rotlXor(r109, 42, r133);
            long r135 = r129 + r128;
            long r136 = ThreefishEngine.rotlXor(r128, 17, r135);
            long r137 = r131 + r134;
            long r138 = ThreefishEngine.rotlXor(r134, 49, r137);
            long r139 = r133 + r132;
            long r140 = ThreefishEngine.rotlXor(r132, 36, r139);
            long r141 = r127 + r130;
            long r142 = ThreefishEngine.rotlXor(r130, 39, r141);
            long r143 = r137 + r136;
            long r144 = ThreefishEngine.rotlXor(r136, 44, r143);
            long r145 = r139 + r142;
            long r146 = ThreefishEngine.rotlXor(r142, 9, r145);
            long r147 = r141 + r140;
            long r148 = ThreefishEngine.rotlXor(r140, 54, r147);
            long r149 = r135 + r138;
            long r150 = ThreefishEngine.rotlXor(r138, 56, r149);
            long r151 = r145 + r312[r116];
            int r218 = r116 + 1;
            long r152 = r144 + r312[r218];
            int r313 = r116 + 2;
            long r153 = r147 + r312[r313];
            int r314 = r116 + 3;
            long r154 = r150 + r312[r314];
            int r315 = r116 + 4;
            long r155 = r149 + r312[r315];
            int r316 = r116 + 5;
            long r156 = r148 + (r312[r316] + r101[r217]);
            int r317 = r116 + 6;
            int r411 = r217 + 1;
            long r157 = r143 + (r312[r317] + r101[r411]);
            int r318 = r116 + 7;
            long r158 = r126;
            long r159 = r146 + (r312[r318] + r158);
            long r160 = r151 + r152;
            long r161 = ThreefishEngine.rotlXor(r152, 39, r160);
            long r162 = r153 + r154;
            long r163 = ThreefishEngine.rotlXor(r154, 30, r162);
            long r164 = r155 + r156;
            long r165 = ThreefishEngine.rotlXor(r156, 34, r164);
            long r166 = r157 + r159;
            long r167 = ThreefishEngine.rotlXor(r159, 24, r166);
            long r168 = r162 + r161;
            long r169 = ThreefishEngine.rotlXor(r161, 13, r168);
            long r170 = r164 + r167;
            long r171 = ThreefishEngine.rotlXor(r167, 50, r170);
            long r172 = r166 + r165;
            long r173 = ThreefishEngine.rotlXor(r165, 10, r172);
            long r174 = r160 + r163;
            long r175 = ThreefishEngine.rotlXor(r163, 17, r174);
            long r176 = r170 + r169;
            long r177 = ThreefishEngine.rotlXor(r169, 25, r176);
            long r178 = r172 + r175;
            long r179 = ThreefishEngine.rotlXor(r175, 29, r178);
            long r180 = r174 + r173;
            long r181 = ThreefishEngine.rotlXor(r173, 39, r180);
            long r182 = r168 + r171;
            long[] r412 = r101;
            long r183 = ThreefishEngine.rotlXor(r171, 43, r182);
            long r184 = r178 + r177;
            long r185 = ThreefishEngine.rotlXor(r177, 8, r184);
            long r186 = r180 + r183;
            long r187 = ThreefishEngine.rotlXor(r183, 35, r186);
            long r188 = r182 + r181;
            long r189 = ThreefishEngine.rotlXor(r181, 56, r188);
            long r190 = r176 + r179;
            long r191 = ThreefishEngine.rotlXor(r179, 22, r190);
            long r192 = r186 + r312[r218];
            r113 = r185 + r312[r313];
            long r193 = r188 + r312[r314];
            r106 = r191 + r312[r315];
            long r194 = r190 + r312[r316];
            r310 = r189 + (r312[r317] + r412[r411]);
            r216 = r184 + (r312[r318] + r412[r217 + 2]);
            long r195 = r187 + ((r312[r116 + 8] + r158) + 1);
            r214 = r194;
            r114 = r193;
            r105 = r192;
            r102 = r120;
            r101 = r412;
            r311 = r195;
            r107 = r126 + 2;
            r103 = r103;
            r100 = r312;
            goto L8
        L10:
            r510[0] = r105;
            r510[1] = r113;
            r510[2] = r114;
            r510[3] = r106;
            r510[4] = r214;
            r510[5] = r310;
            r510[6] = r216;
            r510[7] = r311;
            return;
        L13:
            throw new IllegalArgumentException();
        L15:
            throw new IllegalArgumentException();
        }
    }

    public static abstract class ThreefishCipher {

        /* JADX INFO: renamed from: kw, reason: collision with root package name */
        protected final long[] f525204kw;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        protected final long[] f525205t;

        public ThreefishCipher(long[] r100, long[] r101) {
            this.f525204kw = r100;
            this.f525205t = r101;
        }

        public abstract void decryptBlock(long[] r100, long[] r101);

        public abstract void encryptBlock(long[] r100, long[] r101);
    }

    static {
        int[] r100 = new int[80];
        MOD9 = r100;
        MOD17 = new int[r100.length];
        MOD5 = new int[r100.length];
        MOD3 = new int[r100.length];
        int r101 = 0;
    L3:
        int[] r102 = MOD9;
        if (r101 >= r102.length) goto L6;
        MOD17[r101] = r101 % 17;
        r102[r101] = r101 % 9;
        MOD5[r101] = r101 % 5;
        MOD3[r101] = r101 % 3;
        r101 = r101 + 1;
        goto L3
    }

    public ThreefishEngine(int r100) {
        long[] r101 = new long[5];
        this.f525203t = r101;
        int r102 = r100 / 8;
        this.blocksizeBytes = r102;
        int r103 = r102 / 8;
        this.blocksizeWords = r103;
        this.currentBlock = new long[r103];
        long[] r104 = new long[(r103 * 2) + 1];
        this.f525202kw = r104;
        if (r100 != 256) goto L5;
        ThreefishCipher r105 = new Threefish256Cipher(r104, r101);
    L13:
        this.cipher = r105;
        return;
    L5:
        if (r100 != 512) goto L7;
        r105 = new Threefish512Cipher(r104, r101);
        goto L13
    L7:
        if (r100 != 1024) goto L10;
        r105 = new Threefish1024Cipher(r104, r101);
        goto L13
    L10:
        throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
    }

    public static /* synthetic */ int[] access$000() {
        return MOD5;
    }

    public static /* synthetic */ int[] access$100() {
        return MOD3;
    }

    public static /* synthetic */ int[] access$200() {
        return MOD9;
    }

    public static /* synthetic */ int[] access$300() {
        return MOD17;
    }

    public static long bytesToWord(byte[] r100, int r101) {
        if ((r101 + 8) > r100.length) goto L7;
        int r102 = r101 + 1;
        long r103 = ((long) r100[r101]) & 255;
        int r104 = r102 + 1;
        int r105 = r104 + 1;
        long r106 = (r103 | ((((long) r100[r102]) & 255) << 8)) | ((((long) r100[r104]) & 255) << 16);
        int r107 = r105 + 1;
        long r108 = r106 | ((((long) r100[r105]) & 255) << 24);
        int r109 = r107 + 1;
        long r110 = r108 | ((((long) r100[r107]) & 255) << 32);
        int r111 = r109 + 1;
        long r112 = r110 | ((((long) r100[r109]) & 255) << 40);
        int r113 = r111 + 1;
        long r114 = r112 | ((((long) r100[r111]) & 255) << 48);
        return ((((long) r100[r113]) & 255) << 56) | r114;
    L7:
        throw new IllegalArgumentException();
    }

    public static long rotlXor(long r100, int r101, long r102) {
        long r103 = r100 << r101;
        return ((r100 >>> (-r101)) | r103) ^ r102;
    }

    private void setKey(long[] r100) {
        if (r100.length != this.blocksizeWords) goto L11;
        long r101 = C_240;
        int r102 = 0;
    L5:
        int r103 = this.blocksizeWords;
        if (r102 >= r103) goto L8;
        long[] r104 = this.f525202kw;
        long r105 = r100[r102];
        r104[r102] = r105;
        r101 = r101 ^ r105;
        r102 = r102 + 1;
        goto L5
    L8:
        long[] r106 = this.f525202kw;
        r106[r103] = r101;
        System.arraycopy(r106, 0, r106, r103 + 1, r103);
        return;
    L11:
        throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeWords + " words)");
    }

    private void setTweak(long[] r110) {
        if (r110.length != 2) goto L7;
        long[] r100 = this.f525203t;
        long r101 = r110[0];
        r100[0] = r101;
        long r102 = r110[1];
        r100[1] = r102;
        r100[2] = r101 ^ r102;
        r100[3] = r101;
        r100[4] = r102;
        return;
    L7:
        throw new IllegalArgumentException("Tweak must be 2 words.");
    }

    public static void wordToBytes(long r100, byte[] r101, int r102) {
        if ((r102 + 8) > r101.length) goto L7;
        int r103 = r102 + 1;
        r101[r102] = (byte) r100;
        int r104 = r103 + 1;
        r101[r103] = (byte) (r100 >> 8);
        int r105 = r104 + 1;
        r101[r104] = (byte) (r100 >> 16);
        int r106 = r105 + 1;
        r101[r105] = (byte) (r100 >> 24);
        int r107 = r106 + 1;
        r101[r106] = (byte) (r100 >> 32);
        int r108 = r107 + 1;
        r101[r107] = (byte) (r100 >> 40);
        r101[r108] = (byte) (r100 >> 48);
        r101[r108 + 1] = (byte) (r100 >> 56);
        return;
    L7:
        throw new IllegalArgumentException();
    }

    public static long xorRotr(long r100, int r101, long r102) {
        long r103 = r100 ^ r102;
        long r104 = r103 >>> r101;
        return (r103 << (-r101)) | r104;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Threefish-" + (this.blocksizeBytes * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blocksizeBytes;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r110) throws IllegalArgumentException {
        long[] r101 = null;
        if ((r110 instanceof TweakableBlockCipherParameters) == false) goto L6;
        TweakableBlockCipherParameters r111 = (TweakableBlockCipherParameters) r110;
        byte[] r102 = r111.getKey().getKey();
        byte[] r112 = r111.getTweak();
    L9:
        if (r102 != null) goto L11;
        long[] r103 = null;
    L18:
        if (r112 != null) goto L20;
    L24:
        init(r100, r103, r101);
        return;
    L20:
        if (r112.length != 16) goto L23;
        r101 = new long[]{bytesToWord(r112, 0), bytesToWord(r112, 8)};
        goto L24
    L23:
        throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
    L11:
        if (r102.length != this.blocksizeBytes) goto L16;
        int r104 = this.blocksizeWords;
        r103 = new long[r104];
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L18;
        r103[r105] = bytesToWord(r102, r105 * 8);
        r105 = r105 + 1;
        goto L13
    L16:
        throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeBytes + " bytes)");
    L6:
        if ((r110 instanceof KeyParameter) == false) goto L27;
        r102 = ((KeyParameter) r110).getKey();
        r112 = null;
        goto L9
    L27:
        throw new IllegalArgumentException("Invalid parameter passed to Threefish init - ".concat(r110.getClass().getName()));
    }

    public void init(boolean r100, long[] r101, long[] r102) {
        this.forEncryption = r100;
        if (r101 == null) goto L5;
        setKey(r101);
    L5:
        if (r102 == null) goto L8;
        setTweak(r102);
        return;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r110) throws DataLengthException, IllegalStateException {
        int r103 = this.blocksizeBytes;
        if ((r101 + r103) > r100.length) goto L18;
        if ((r103 + r110) > r102.length) goto L16;
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r105 >= this.blocksizeBytes) goto L10;
        this.currentBlock[r105 >> 3] = bytesToWord(r100, r101 + r105);
        r105 = r105 + 8;
        goto L8
    L10:
        long[] r106 = this.currentBlock;
        processBlock(r106, r106);
    L11:
        int r107 = this.blocksizeBytes;
        if (r104 >= r107) goto L14;
        wordToBytes(this.currentBlock[r104 >> 3], r102, r110 + r104);
        r104 = r104 + 8;
        goto L11
    L14:
        return r107;
    L16:
        throw new OutputLengthException("Output buffer too short");
    L18:
        throw new DataLengthException("Input buffer too short");
    }

    public int processBlock(long[] r100, long[] r101) throws DataLengthException, IllegalStateException {
        long[] r102 = this.f525202kw;
        int r103 = this.blocksizeWords;
        if (r102[r103] == 0) goto L19;
        if (r100.length != r103) goto L17;
        if (r101.length != r103) goto L15;
        if (this.forEncryption == false) goto L11;
        this.cipher.encryptBlock(r100, r101);
    L13:
        return this.blocksizeWords;
    L11:
        this.cipher.decryptBlock(r100, r101);
        goto L13
    L15:
        throw new OutputLengthException("Output buffer too short");
    L17:
        throw new DataLengthException("Input buffer too short");
    L19:
        throw new IllegalStateException("Threefish engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
