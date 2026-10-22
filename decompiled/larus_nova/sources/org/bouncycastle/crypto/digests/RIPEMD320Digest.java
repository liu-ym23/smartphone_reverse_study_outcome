package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class RIPEMD320Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 40;
    private int H0;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int H8;
    private int H9;
    private int[] X;
    private int xOff;

    public RIPEMD320Digest() {
        this.X = new int[16];
        reset();
    }

    public RIPEMD320Digest(RIPEMD320Digest r100) {
        super(r100);
        this.X = new int[16];
        doCopy(r100);
    }

    private int RL(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (32 - r101)) | r102;
    }

    private void doCopy(RIPEMD320Digest r100) {
        super.copyIn(r100);
        this.H0 = r100.H0;
        this.H1 = r100.H1;
        this.H2 = r100.H2;
        this.H3 = r100.H3;
        this.H4 = r100.H4;
        this.H5 = r100.H5;
        this.H6 = r100.H6;
        this.H7 = r100.H7;
        this.H8 = r100.H8;
        this.H9 = r100.H9;
        int[] r101 = r100.X;
        System.arraycopy(r101, 0, this.X, 0, r101.length);
        this.xOff = r100.xOff;
    }

    private int f1(int r100, int r101, int r102) {
        return (r100 ^ r101) ^ r102;
    }

    private int f2(int r100, int r101, int r102) {
        int r103 = r101 & r100;
        return ((~r100) & r102) | r103;
    }

    private int f3(int r100, int r101, int r102) {
        return (r100 | (~r101)) ^ r102;
    }

    private int f4(int r100, int r101, int r102) {
        return (r100 & r102) | (r101 & (~r102));
    }

    private int f5(int r100, int r101, int r102) {
        return r100 ^ (r101 | (~r102));
    }

    private void unpackWord(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        r101[r102 + 1] = (byte) (r100 >>> 8);
        r101[r102 + 2] = (byte) (r100 >>> 16);
        r101[r102 + 3] = (byte) (r100 >>> 24);
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new RIPEMD320Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        unpackWord(this.H0, r100, r101);
        unpackWord(this.H1, r100, r101 + 4);
        unpackWord(this.H2, r100, r101 + 8);
        unpackWord(this.H3, r100, r101 + 12);
        unpackWord(this.H4, r100, r101 + 16);
        unpackWord(this.H5, r100, r101 + 20);
        unpackWord(this.H6, r100, r101 + 24);
        unpackWord(this.H7, r100, r101 + 28);
        unpackWord(this.H8, r100, r101 + 32);
        unpackWord(this.H9, r100, r101 + 36);
        reset();
        return 40;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD320";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 40;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r100 = this.H0;
        int r101 = this.H1;
        int r102 = this.H2;
        int r103 = this.H3;
        int r104 = this.H4;
        int r105 = this.H5;
        int r106 = this.H6;
        int r107 = this.H7;
        int r108 = this.H8;
        int r110 = this.H9;
        int r109 = RL((r100 + f1(r101, r102, r103)) + this.X[0], 11) + r104;
        int r111 = RL(r102, 10);
        int r112 = RL((r104 + f1(r109, r101, r111)) + this.X[1], 14) + r103;
        int r113 = RL(r101, 10);
        int r114 = RL((r103 + f1(r112, r109, r113)) + this.X[2], 15) + r111;
        int r115 = RL(r109, 10);
        int r116 = RL((r111 + f1(r114, r112, r115)) + this.X[3], 12) + r113;
        int r117 = RL(r112, 10);
        int r118 = RL((r113 + f1(r116, r114, r117)) + this.X[4], 5) + r115;
        int r119 = RL(r114, 10);
        int r120 = RL((r115 + f1(r118, r116, r119)) + this.X[5], 8) + r117;
        int r121 = RL(r116, 10);
        int r122 = RL((r117 + f1(r120, r118, r121)) + this.X[6], 7) + r119;
        int r123 = RL(r118, 10);
        int r124 = RL((r119 + f1(r122, r120, r123)) + this.X[7], 9) + r121;
        int r125 = RL(r120, 10);
        int r126 = RL((r121 + f1(r124, r122, r125)) + this.X[8], 11) + r123;
        int r127 = RL(r122, 10);
        int r128 = RL((r123 + f1(r126, r124, r127)) + this.X[9], 13) + r125;
        int r129 = RL(r124, 10);
        int r130 = RL((r125 + f1(r128, r126, r129)) + this.X[10], 14) + r127;
        int r131 = RL(r126, 10);
        int r132 = RL((r127 + f1(r130, r128, r131)) + this.X[11], 15) + r129;
        int r133 = RL(r128, 10);
        int r134 = RL((r129 + f1(r132, r130, r133)) + this.X[12], 6) + r131;
        int r135 = RL(r130, 10);
        int r136 = RL((r131 + f1(r134, r132, r135)) + this.X[13], 7) + r133;
        int r137 = RL(r132, 10);
        int r138 = RL((r133 + f1(r136, r134, r137)) + this.X[14], 9) + r135;
        int r139 = RL(r134, 10);
        int r140 = RL((r135 + f1(r138, r136, r139)) + this.X[15], 8) + r137;
        int r141 = RL(r136, 10);
        int r142 = RL(((r105 + f5(r106, r107, r108)) + this.X[5]) + 1352829926, 8) + r110;
        int r143 = RL(r107, 10);
        int r144 = RL(((r110 + f5(r142, r106, r143)) + this.X[14]) + 1352829926, 9) + r108;
        int r145 = RL(r106, 10);
        int r146 = RL(((r108 + f5(r144, r142, r145)) + this.X[7]) + 1352829926, 9) + r143;
        int r147 = RL(r142, 10);
        int r148 = RL(((r143 + f5(r146, r144, r147)) + this.X[0]) + 1352829926, 11) + r145;
        int r149 = RL(r144, 10);
        int r150 = RL(((r145 + f5(r148, r146, r149)) + this.X[9]) + 1352829926, 13) + r147;
        int r151 = RL(r146, 10);
        int r152 = RL(((r147 + f5(r150, r148, r151)) + this.X[2]) + 1352829926, 15) + r149;
        int r153 = RL(r148, 10);
        int r154 = RL(((r149 + f5(r152, r150, r153)) + this.X[11]) + 1352829926, 15) + r151;
        int r155 = RL(r150, 10);
        int r156 = RL(((r151 + f5(r154, r152, r155)) + this.X[4]) + 1352829926, 5) + r153;
        int r157 = RL(r152, 10);
        int r158 = RL(((r153 + f5(r156, r154, r157)) + this.X[13]) + 1352829926, 7) + r155;
        int r159 = RL(r154, 10);
        int r160 = RL(((r155 + f5(r158, r156, r159)) + this.X[6]) + 1352829926, 7) + r157;
        int r161 = RL(r156, 10);
        int r162 = RL(((r157 + f5(r160, r158, r161)) + this.X[15]) + 1352829926, 8) + r159;
        int r163 = RL(r158, 10);
        int r164 = RL(((r159 + f5(r162, r160, r163)) + this.X[8]) + 1352829926, 11) + r161;
        int r165 = RL(r160, 10);
        int r166 = RL(((r161 + f5(r164, r162, r165)) + this.X[1]) + 1352829926, 14) + r163;
        int r167 = RL(r162, 10);
        int r168 = RL(((r163 + f5(r166, r164, r167)) + this.X[10]) + 1352829926, 14) + r165;
        int r169 = RL(r164, 10);
        int r170 = RL(((r165 + f5(r168, r166, r169)) + this.X[3]) + 1352829926, 12) + r167;
        int r171 = RL(r166, 10);
        int r172 = RL(((r167 + f5(r170, r168, r171)) + this.X[12]) + 1352829926, 6) + r169;
        int r173 = RL(r168, 10);
        int r174 = RL(((r137 + f2(r172, r138, r141)) + this.X[7]) + 1518500249, 7) + r139;
        int r175 = RL(r138, 10);
        int r176 = RL(((r139 + f2(r174, r172, r175)) + this.X[4]) + 1518500249, 6) + r141;
        int r177 = RL(r172, 10);
        int r178 = RL(((r141 + f2(r176, r174, r177)) + this.X[13]) + 1518500249, 8) + r175;
        int r179 = RL(r174, 10);
        int r180 = RL(((r175 + f2(r178, r176, r179)) + this.X[1]) + 1518500249, 13) + r177;
        int r181 = RL(r176, 10);
        int r182 = RL(((r177 + f2(r180, r178, r181)) + this.X[10]) + 1518500249, 11) + r179;
        int r183 = RL(r178, 10);
        int r184 = RL(((r179 + f2(r182, r180, r183)) + this.X[6]) + 1518500249, 9) + r181;
        int r185 = RL(r180, 10);
        int r186 = RL(((r181 + f2(r184, r182, r185)) + this.X[15]) + 1518500249, 7) + r183;
        int r187 = RL(r182, 10);
        int r188 = RL(((r183 + f2(r186, r184, r187)) + this.X[3]) + 1518500249, 15) + r185;
        int r189 = RL(r184, 10);
        int r190 = RL(((r185 + f2(r188, r186, r189)) + this.X[12]) + 1518500249, 7) + r187;
        int r191 = RL(r186, 10);
        int r192 = RL(((r187 + f2(r190, r188, r191)) + this.X[0]) + 1518500249, 12) + r189;
        int r193 = RL(r188, 10);
        int r194 = RL(((r189 + f2(r192, r190, r193)) + this.X[9]) + 1518500249, 15) + r191;
        int r195 = RL(r190, 10);
        int r196 = RL(((r191 + f2(r194, r192, r195)) + this.X[5]) + 1518500249, 9) + r193;
        int r197 = RL(r192, 10);
        int r198 = RL(((r193 + f2(r196, r194, r197)) + this.X[2]) + 1518500249, 11) + r195;
        int r199 = RL(r194, 10);
        int r200 = RL(((r195 + f2(r198, r196, r199)) + this.X[14]) + 1518500249, 7) + r197;
        int r201 = RL(r196, 10);
        int r202 = RL(((r197 + f2(r200, r198, r201)) + this.X[11]) + 1518500249, 13) + r199;
        int r203 = RL(r198, 10);
        int r204 = RL(((r199 + f2(r202, r200, r203)) + this.X[8]) + 1518500249, 12) + r201;
        int r205 = RL(r200, 10);
        int r1100 = RL(((r169 + f4(r140, r170, r173)) + this.X[6]) + 1548603684, 9) + r171;
        int r206 = RL(r170, 10);
        int r207 = RL(((r171 + f4(r1100, r140, r206)) + this.X[11]) + 1548603684, 13) + r173;
        int r208 = RL(r140, 10);
        int r209 = RL(((r173 + f4(r207, r1100, r208)) + this.X[3]) + 1548603684, 15) + r206;
        int r1101 = RL(r1100, 10);
        int r210 = RL(((r206 + f4(r209, r207, r1101)) + this.X[7]) + 1548603684, 7) + r208;
        int r211 = RL(r207, 10);
        int r212 = RL(((r208 + f4(r210, r209, r211)) + this.X[0]) + 1548603684, 12) + r1101;
        int r213 = RL(r209, 10);
        int r1102 = RL(((r1101 + f4(r212, r210, r213)) + this.X[13]) + 1548603684, 8) + r211;
        int r214 = RL(r210, 10);
        int r215 = RL(((r211 + f4(r1102, r212, r214)) + this.X[5]) + 1548603684, 9) + r213;
        int r216 = RL(r212, 10);
        int r217 = RL(((r213 + f4(r215, r1102, r216)) + this.X[10]) + 1548603684, 11) + r214;
        int r1103 = RL(r1102, 10);
        int r218 = RL(((r214 + f4(r217, r215, r1103)) + this.X[14]) + 1548603684, 7) + r216;
        int r219 = RL(r215, 10);
        int r220 = RL(((r216 + f4(r218, r217, r219)) + this.X[15]) + 1548603684, 7) + r1103;
        int r221 = RL(r217, 10);
        int r1104 = RL(((r1103 + f4(r220, r218, r221)) + this.X[8]) + 1548603684, 12) + r219;
        int r222 = RL(r218, 10);
        int r223 = RL(((r219 + f4(r1104, r220, r222)) + this.X[12]) + 1548603684, 7) + r221;
        int r224 = RL(r220, 10);
        int r225 = RL(((r221 + f4(r223, r1104, r224)) + this.X[4]) + 1548603684, 6) + r222;
        int r1105 = RL(r1104, 10);
        int r226 = RL(((r222 + f4(r225, r223, r1105)) + this.X[9]) + 1548603684, 15) + r224;
        int r227 = RL(r223, 10);
        int r228 = RL(((r224 + f4(r226, r225, r227)) + this.X[1]) + 1548603684, 13) + r1105;
        int r229 = RL(r225, 10);
        int r1106 = RL(((r1105 + f4(r228, r226, r229)) + this.X[2]) + 1548603684, 11) + r227;
        int r230 = RL(r226, 10);
        int r231 = RL(((r201 + f3(r204, r202, r230)) + this.X[3]) + 1859775393, 11) + r203;
        int r232 = RL(r202, 10);
        int r233 = RL(((r203 + f3(r231, r204, r232)) + this.X[10]) + 1859775393, 13) + r230;
        int r234 = RL(r204, 10);
        int r235 = RL(((r230 + f3(r233, r231, r234)) + this.X[14]) + 1859775393, 6) + r232;
        int r236 = RL(r231, 10);
        int r237 = RL(((r232 + f3(r235, r233, r236)) + this.X[4]) + 1859775393, 7) + r234;
        int r238 = RL(r233, 10);
        int r239 = RL(((r234 + f3(r237, r235, r238)) + this.X[9]) + 1859775393, 14) + r236;
        int r240 = RL(r235, 10);
        int r241 = RL(((r236 + f3(r239, r237, r240)) + this.X[15]) + 1859775393, 9) + r238;
        int r242 = RL(r237, 10);
        int r243 = RL(((r238 + f3(r241, r239, r242)) + this.X[8]) + 1859775393, 13) + r240;
        int r244 = RL(r239, 10);
        int r245 = RL(((r240 + f3(r243, r241, r244)) + this.X[1]) + 1859775393, 15) + r242;
        int r246 = RL(r241, 10);
        int r247 = RL(((r242 + f3(r245, r243, r246)) + this.X[2]) + 1859775393, 14) + r244;
        int r248 = RL(r243, 10);
        int r249 = RL(((r244 + f3(r247, r245, r248)) + this.X[7]) + 1859775393, 8) + r246;
        int r250 = RL(r245, 10);
        int r251 = RL(((r246 + f3(r249, r247, r250)) + this.X[0]) + 1859775393, 13) + r248;
        int r252 = RL(r247, 10);
        int r253 = RL(((r248 + f3(r251, r249, r252)) + this.X[6]) + 1859775393, 6) + r250;
        int r254 = RL(r249, 10);
        int r255 = RL(((r250 + f3(r253, r251, r254)) + this.X[13]) + 1859775393, 5) + r252;
        int r256 = RL(r251, 10);
        int r257 = RL(((r252 + f3(r255, r253, r256)) + this.X[11]) + 1859775393, 12) + r254;
        int r258 = RL(r253, 10);
        int r259 = RL(((r254 + f3(r257, r255, r258)) + this.X[5]) + 1859775393, 7) + r256;
        int r260 = RL(r255, 10);
        int r261 = RL(((r256 + f3(r259, r257, r260)) + this.X[12]) + 1859775393, 5) + r258;
        int r262 = RL(r257, 10);
        int r263 = RL(((r227 + f3(r1106, r228, r205)) + this.X[15]) + 1836072691, 9) + r229;
        int r264 = RL(r228, 10);
        int r265 = RL(((r229 + f3(r263, r1106, r264)) + this.X[5]) + 1836072691, 7) + r205;
        int r1107 = RL(r1106, 10);
        int r266 = RL(((r205 + f3(r265, r263, r1107)) + this.X[1]) + 1836072691, 15) + r264;
        int r267 = RL(r263, 10);
        int r268 = RL(((r264 + f3(r266, r265, r267)) + this.X[3]) + 1836072691, 11) + r1107;
        int r269 = RL(r265, 10);
        int r1108 = RL(((r1107 + f3(r268, r266, r269)) + this.X[7]) + 1836072691, 8) + r267;
        int r270 = RL(r266, 10);
        int r271 = RL(((r267 + f3(r1108, r268, r270)) + this.X[14]) + 1836072691, 6) + r269;
        int r272 = RL(r268, 10);
        int r273 = RL(((r269 + f3(r271, r1108, r272)) + this.X[6]) + 1836072691, 6) + r270;
        int r1109 = RL(r1108, 10);
        int r274 = RL(((r270 + f3(r273, r271, r1109)) + this.X[9]) + 1836072691, 14) + r272;
        int r275 = RL(r271, 10);
        int r276 = RL(((r272 + f3(r274, r273, r275)) + this.X[11]) + 1836072691, 12) + r1109;
        int r277 = RL(r273, 10);
        int r1110 = RL(((r1109 + f3(r276, r274, r277)) + this.X[8]) + 1836072691, 13) + r275;
        int r278 = RL(r274, 10);
        int r279 = RL(((r275 + f3(r1110, r276, r278)) + this.X[12]) + 1836072691, 5) + r277;
        int r280 = RL(r276, 10);
        int r281 = RL(((r277 + f3(r279, r1110, r280)) + this.X[2]) + 1836072691, 14) + r278;
        int r1111 = RL(r1110, 10);
        int r282 = RL(((r278 + f3(r281, r279, r1111)) + this.X[10]) + 1836072691, 13) + r280;
        int r283 = RL(r279, 10);
        int r284 = RL(((r280 + f3(r282, r281, r283)) + this.X[0]) + 1836072691, 13) + r1111;
        int r285 = RL(r281, 10);
        int r1112 = RL(((r1111 + f3(r284, r282, r285)) + this.X[4]) + 1836072691, 7) + r283;
        int r286 = RL(r282, 10);
        int r287 = RL(((r283 + f3(r1112, r284, r286)) + this.X[13]) + 1836072691, 5) + r285;
        int r288 = RL(r284, 10);
        int r289 = RL(((r285 + f4(r261, r259, r262)) + this.X[1]) - 1894007588, 11) + r260;
        int r290 = RL(r259, 10);
        int r291 = RL(((r260 + f4(r289, r261, r290)) + this.X[9]) - 1894007588, 12) + r262;
        int r292 = RL(r261, 10);
        int r293 = RL(((r262 + f4(r291, r289, r292)) + this.X[11]) - 1894007588, 14) + r290;
        int r294 = RL(r289, 10);
        int r295 = RL(((r290 + f4(r293, r291, r294)) + this.X[10]) - 1894007588, 15) + r292;
        int r296 = RL(r291, 10);
        int r297 = RL(((r292 + f4(r295, r293, r296)) + this.X[0]) - 1894007588, 14) + r294;
        int r298 = RL(r293, 10);
        int r299 = RL(((r294 + f4(r297, r295, r298)) + this.X[8]) - 1894007588, 15) + r296;
        int r300 = RL(r295, 10);
        int r301 = RL(((r296 + f4(r299, r297, r300)) + this.X[12]) - 1894007588, 9) + r298;
        int r302 = RL(r297, 10);
        int r303 = RL(((r298 + f4(r301, r299, r302)) + this.X[4]) - 1894007588, 8) + r300;
        int r304 = RL(r299, 10);
        int r305 = RL(((r300 + f4(r303, r301, r304)) + this.X[13]) - 1894007588, 9) + r302;
        int r306 = RL(r301, 10);
        int r307 = RL(((r302 + f4(r305, r303, r306)) + this.X[3]) - 1894007588, 14) + r304;
        int r308 = RL(r303, 10);
        int r309 = RL(((r304 + f4(r307, r305, r308)) + this.X[7]) - 1894007588, 5) + r306;
        int r310 = RL(r305, 10);
        int r311 = RL(((r306 + f4(r309, r307, r310)) + this.X[15]) - 1894007588, 6) + r308;
        int r312 = RL(r307, 10);
        int r313 = RL(((r308 + f4(r311, r309, r312)) + this.X[14]) - 1894007588, 8) + r310;
        int r314 = RL(r309, 10);
        int r315 = RL(((r310 + f4(r313, r311, r314)) + this.X[5]) - 1894007588, 6) + r312;
        int r316 = RL(r311, 10);
        int r317 = RL(((r312 + f4(r315, r313, r316)) + this.X[6]) - 1894007588, 5) + r314;
        int r318 = RL(r313, 10);
        int r319 = RL(((r314 + f4(r317, r315, r318)) + this.X[2]) - 1894007588, 12) + r316;
        int r320 = RL(r315, 10);
        int r321 = RL(((r258 + f2(r287, r1112, r288)) + this.X[8]) + 2053994217, 15) + r286;
        int r1113 = RL(r1112, 10);
        int r322 = RL(((r286 + f2(r321, r287, r1113)) + this.X[6]) + 2053994217, 5) + r288;
        int r323 = RL(r287, 10);
        int r324 = RL(((r288 + f2(r322, r321, r323)) + this.X[4]) + 2053994217, 8) + r1113;
        int r325 = RL(r321, 10);
        int r1114 = RL(((r1113 + f2(r324, r322, r325)) + this.X[1]) + 2053994217, 11) + r323;
        int r326 = RL(r322, 10);
        int r327 = RL(((r323 + f2(r1114, r324, r326)) + this.X[3]) + 2053994217, 14) + r325;
        int r328 = RL(r324, 10);
        int r329 = RL(((r325 + f2(r327, r1114, r328)) + this.X[11]) + 2053994217, 14) + r326;
        int r1115 = RL(r1114, 10);
        int r330 = RL(((r326 + f2(r329, r327, r1115)) + this.X[15]) + 2053994217, 6) + r328;
        int r331 = RL(r327, 10);
        int r332 = RL(((r328 + f2(r330, r329, r331)) + this.X[0]) + 2053994217, 14) + r1115;
        int r333 = RL(r329, 10);
        int r1116 = RL(((r1115 + f2(r332, r330, r333)) + this.X[5]) + 2053994217, 6) + r331;
        int r334 = RL(r330, 10);
        int r335 = RL(((r331 + f2(r1116, r332, r334)) + this.X[12]) + 2053994217, 9) + r333;
        int r336 = RL(r332, 10);
        int r337 = RL(((r333 + f2(r335, r1116, r336)) + this.X[2]) + 2053994217, 12) + r334;
        int r1117 = RL(r1116, 10);
        int r338 = RL(((r334 + f2(r337, r335, r1117)) + this.X[13]) + 2053994217, 9) + r336;
        int r339 = RL(r335, 10);
        int r340 = RL(((r336 + f2(r338, r337, r339)) + this.X[9]) + 2053994217, 12) + r1117;
        int r341 = RL(r337, 10);
        int r1118 = RL(((r1117 + f2(r340, r338, r341)) + this.X[7]) + 2053994217, 5) + r339;
        int r342 = RL(r338, 10);
        int r343 = RL(((r339 + f2(r1118, r340, r342)) + this.X[10]) + 2053994217, 15) + r341;
        int r344 = RL(r340, 10);
        int r345 = RL(((r341 + f2(r343, r1118, r344)) + this.X[14]) + 2053994217, 8) + r342;
        int r1119 = RL(r1118, 10);
        int r346 = RL(((r316 + f5(r319, r343, r320)) + this.X[4]) - 1454113458, 9) + r318;
        int r347 = RL(r343, 10);
        int r348 = RL(((r318 + f5(r346, r319, r347)) + this.X[0]) - 1454113458, 15) + r320;
        int r349 = RL(r319, 10);
        int r350 = RL(((r320 + f5(r348, r346, r349)) + this.X[5]) - 1454113458, 5) + r347;
        int r351 = RL(r346, 10);
        int r352 = RL(((r347 + f5(r350, r348, r351)) + this.X[9]) - 1454113458, 11) + r349;
        int r353 = RL(r348, 10);
        int r354 = RL(((r349 + f5(r352, r350, r353)) + this.X[7]) - 1454113458, 6) + r351;
        int r355 = RL(r350, 10);
        int r356 = RL(((r351 + f5(r354, r352, r355)) + this.X[12]) - 1454113458, 8) + r353;
        int r357 = RL(r352, 10);
        int r358 = RL(((r353 + f5(r356, r354, r357)) + this.X[2]) - 1454113458, 13) + r355;
        int r359 = RL(r354, 10);
        int r360 = RL(((r355 + f5(r358, r356, r359)) + this.X[10]) - 1454113458, 12) + r357;
        int r361 = RL(r356, 10);
        int r362 = RL(((r357 + f5(r360, r358, r361)) + this.X[14]) - 1454113458, 5) + r359;
        int r363 = RL(r358, 10);
        int r364 = RL(((r359 + f5(r362, r360, r363)) + this.X[1]) - 1454113458, 12) + r361;
        int r365 = RL(r360, 10);
        int r366 = RL(((r361 + f5(r364, r362, r365)) + this.X[3]) - 1454113458, 13) + r363;
        int r367 = RL(r362, 10);
        int r368 = RL(((r363 + f5(r366, r364, r367)) + this.X[8]) - 1454113458, 14) + r365;
        int r369 = RL(r364, 10);
        int r370 = RL(((r365 + f5(r368, r366, r369)) + this.X[11]) - 1454113458, 11) + r367;
        int r371 = RL(r366, 10);
        int r372 = RL(((r367 + f5(r370, r368, r371)) + this.X[6]) - 1454113458, 8) + r369;
        int r373 = RL(r368, 10);
        int r374 = RL(((r369 + f5(r372, r370, r373)) + this.X[15]) - 1454113458, 5) + r371;
        int r375 = RL(r370, 10);
        int r376 = RL(((r371 + f5(r374, r372, r375)) + this.X[13]) - 1454113458, 6) + r373;
        int r377 = RL(r372, 10);
        int r378 = RL((r342 + f1(r345, r317, r1119)) + this.X[12], 8) + r344;
        int r379 = RL(r317, 10);
        int r380 = RL((r344 + f1(r378, r345, r379)) + this.X[15], 5) + r1119;
        int r381 = RL(r345, 10);
        int r1120 = RL((r1119 + f1(r380, r378, r381)) + this.X[10], 12) + r379;
        int r382 = RL(r378, 10);
        int r383 = RL((r379 + f1(r1120, r380, r382)) + this.X[4], 9) + r381;
        int r384 = RL(r380, 10);
        int r385 = RL((r381 + f1(r383, r1120, r384)) + this.X[1], 12) + r382;
        int r1121 = RL(r1120, 10);
        int r386 = RL((r382 + f1(r385, r383, r1121)) + this.X[5], 5) + r384;
        int r387 = RL(r383, 10);
        int r388 = RL((r384 + f1(r386, r385, r387)) + this.X[8], 14) + r1121;
        int r389 = RL(r385, 10);
        int r1122 = RL((r1121 + f1(r388, r386, r389)) + this.X[7], 6) + r387;
        int r390 = RL(r386, 10);
        int r391 = RL((r387 + f1(r1122, r388, r390)) + this.X[6], 8) + r389;
        int r392 = RL(r388, 10);
        int r393 = RL((r389 + f1(r391, r1122, r392)) + this.X[2], 13) + r390;
        int r1123 = RL(r1122, 10);
        int r394 = RL((r390 + f1(r393, r391, r1123)) + this.X[13], 6) + r392;
        int r395 = RL(r391, 10);
        int r396 = RL((r392 + f1(r394, r393, r395)) + this.X[14], 5) + r1123;
        int r397 = RL(r393, 10);
        int r1124 = RL((r1123 + f1(r396, r394, r397)) + this.X[0], 15) + r395;
        int r398 = RL(r394, 10);
        int r399 = RL((r395 + f1(r1124, r396, r398)) + this.X[3], 13) + r397;
        int r400 = RL(r396, 10);
        int r401 = RL((r397 + f1(r399, r1124, r400)) + this.X[9], 11) + r398;
        int r1125 = RL(r1124, 10);
        int r402 = RL((r398 + f1(r401, r399, r1125)) + this.X[11], 11) + r400;
        int r403 = RL(r399, 10);
        this.H0 += r373;
        this.H1 += r376;
        this.H2 += r374;
        this.H3 += r377;
        this.H4 += r1125;
        this.H5 += r400;
        this.H6 += r402;
        this.H7 += r401;
        this.H8 += r403;
        this.H9 += r375;
        this.xOff = 0;
        int r404 = 0;
    L3:
        int[] r405 = this.X;
        if (r404 == r405.length) goto L6;
        r405[r404] = 0;
        r404 = r404 + 1;
        goto L3
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long r100) {
        if (this.xOff <= 14) goto L5;
        processBlock();
    L5:
        int[] r101 = this.X;
        r101[14] = (int) ((-1) & r100);
        r101[15] = (int) (r100 >>> 32);
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] r100, int r101) {
        int[] r102 = this.X;
        int r103 = this.xOff;
        int r104 = r103 + 1;
        this.xOff = r104;
        int r105 = ((r100[r101] & UByte.MAX_VALUE) | ((r100[r101 + 1] & UByte.MAX_VALUE) << 8)) | ((r100[r101 + 2] & UByte.MAX_VALUE) << 16);
        r102[r103] = ((r100[r101 + 3] & UByte.MAX_VALUE) << 24) | r105;
        if (r104 != 16) goto L6;
        processBlock();
        return;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H0 = 1732584193;
        this.H1 = -271733879;
        this.H2 = -1732584194;
        this.H3 = 271733878;
        this.H4 = -1009589776;
        this.H5 = 1985229328;
        this.H6 = -19088744;
        this.H7 = -1985229329;
        this.H8 = 19088743;
        this.H9 = 1009589775;
        this.xOff = 0;
        int r100 = 0;
    L3:
        int[] r101 = this.X;
        if (r100 == r101.length) goto L6;
        r101[r100] = 0;
        r100 = r100 + 1;
        goto L3
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        doCopy((RIPEMD320Digest) r100);
    }
}
