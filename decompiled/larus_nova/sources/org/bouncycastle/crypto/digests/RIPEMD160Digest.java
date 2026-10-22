package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class RIPEMD160Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 20;
    private int H0;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int[] X;
    private int xOff;

    public RIPEMD160Digest() {
        this.X = new int[16];
        reset();
    }

    public RIPEMD160Digest(RIPEMD160Digest r100) {
        super(r100);
        this.X = new int[16];
        copyIn(r100);
    }

    private int RL(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (32 - r101)) | r102;
    }

    private void copyIn(RIPEMD160Digest r100) {
        super.copyIn(r100);
        this.H0 = r100.H0;
        this.H1 = r100.H1;
        this.H2 = r100.H2;
        this.H3 = r100.H3;
        this.H4 = r100.H4;
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
        return new RIPEMD160Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        unpackWord(this.H0, r100, r101);
        unpackWord(this.H1, r100, r101 + 4);
        unpackWord(this.H2, r100, r101 + 8);
        unpackWord(this.H3, r100, r101 + 12);
        unpackWord(this.H4, r100, r101 + 16);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD160";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r100 = this.H0;
        int r101 = this.H1;
        int r102 = this.H2;
        int r103 = this.H3;
        int r104 = this.H4;
        int r105 = RL((f1(r101, r102, r103) + r100) + this.X[0], 11) + r104;
        int r110 = RL(r102, 10);
        int r111 = RL((f1(r105, r101, r110) + r104) + this.X[1], 14) + r103;
        int r112 = RL(r101, 10);
        int r113 = RL((f1(r111, r105, r112) + r103) + this.X[2], 15) + r110;
        int r106 = RL(r105, 10);
        int r114 = RL((r110 + f1(r113, r111, r106)) + this.X[3], 12) + r112;
        int r115 = RL(r111, 10);
        int r116 = RL((r112 + f1(r114, r113, r115)) + this.X[4], 5) + r106;
        int r117 = RL(r113, 10);
        int r107 = RL((r106 + f1(r116, r114, r117)) + this.X[5], 8) + r115;
        int r118 = RL(r114, 10);
        int r119 = RL((r115 + f1(r107, r116, r118)) + this.X[6], 7) + r117;
        int r120 = RL(r116, 10);
        int r121 = RL((r117 + f1(r119, r107, r120)) + this.X[7], 9) + r118;
        int r108 = RL(r107, 10);
        int r109 = RL((r118 + f1(r121, r119, r108)) + this.X[8], 11) + r120;
        int r122 = RL(r119, 10);
        int r123 = RL((r120 + f1(r109, r121, r122)) + this.X[9], 13) + r108;
        int r124 = RL(r121, 10);
        int r125 = RL((r108 + f1(r123, r109, r124)) + this.X[10], 14) + r122;
        int r126 = RL(r109, 10);
        int r127 = RL((r122 + f1(r125, r123, r126)) + this.X[11], 15) + r124;
        int r128 = RL(r123, 10);
        int r129 = RL((r124 + f1(r127, r125, r128)) + this.X[12], 6) + r126;
        int r130 = RL(r125, 10);
        int r131 = RL((r126 + f1(r129, r127, r130)) + this.X[13], 7) + r128;
        int r132 = RL(r127, 10);
        int r133 = RL((r128 + f1(r131, r129, r132)) + this.X[14], 9) + r130;
        int r134 = RL(r129, 10);
        int r135 = RL((r130 + f1(r133, r131, r134)) + this.X[15], 8) + r132;
        int r136 = RL(r131, 10);
        int r137 = RL(((r100 + f5(r101, r102, r103)) + this.X[5]) + 1352829926, 8) + r104;
        int r138 = RL(r102, 10);
        int r139 = RL(((r104 + f5(r137, r101, r138)) + this.X[14]) + 1352829926, 9) + r103;
        int r140 = RL(r101, 10);
        int r141 = RL(((r103 + f5(r139, r137, r140)) + this.X[7]) + 1352829926, 9) + r138;
        int r142 = RL(r137, 10);
        int r143 = RL(((r138 + f5(r141, r139, r142)) + this.X[0]) + 1352829926, 11) + r140;
        int r144 = RL(r139, 10);
        int r145 = RL(((r140 + f5(r143, r141, r144)) + this.X[9]) + 1352829926, 13) + r142;
        int r146 = RL(r141, 10);
        int r147 = RL(((r142 + f5(r145, r143, r146)) + this.X[2]) + 1352829926, 15) + r144;
        int r148 = RL(r143, 10);
        int r149 = RL(((r144 + f5(r147, r145, r148)) + this.X[11]) + 1352829926, 15) + r146;
        int r150 = RL(r145, 10);
        int r151 = RL(((r146 + f5(r149, r147, r150)) + this.X[4]) + 1352829926, 5) + r148;
        int r152 = RL(r147, 10);
        int r153 = RL(((r148 + f5(r151, r149, r152)) + this.X[13]) + 1352829926, 7) + r150;
        int r154 = RL(r149, 10);
        int r155 = RL(((r150 + f5(r153, r151, r154)) + this.X[6]) + 1352829926, 7) + r152;
        int r156 = RL(r151, 10);
        int r157 = RL(((r152 + f5(r155, r153, r156)) + this.X[15]) + 1352829926, 8) + r154;
        int r158 = RL(r153, 10);
        int r159 = RL(((r154 + f5(r157, r155, r158)) + this.X[8]) + 1352829926, 11) + r156;
        int r160 = RL(r155, 10);
        int r161 = RL(((r156 + f5(r159, r157, r160)) + this.X[1]) + 1352829926, 14) + r158;
        int r162 = RL(r157, 10);
        int r163 = RL(((r158 + f5(r161, r159, r162)) + this.X[10]) + 1352829926, 14) + r160;
        int r164 = RL(r159, 10);
        int r165 = RL(((r160 + f5(r163, r161, r164)) + this.X[3]) + 1352829926, 12) + r162;
        int r166 = RL(r161, 10);
        int r167 = RL(((r162 + f5(r165, r163, r166)) + this.X[12]) + 1352829926, 6) + r164;
        int r168 = RL(r163, 10);
        int r169 = RL(((r132 + f2(r135, r133, r136)) + this.X[7]) + 1518500249, 7) + r134;
        int r170 = RL(r133, 10);
        int r171 = RL(((r134 + f2(r169, r135, r170)) + this.X[4]) + 1518500249, 6) + r136;
        int r172 = RL(r135, 10);
        int r173 = RL(((r136 + f2(r171, r169, r172)) + this.X[13]) + 1518500249, 8) + r170;
        int r174 = RL(r169, 10);
        int r175 = RL(((r170 + f2(r173, r171, r174)) + this.X[1]) + 1518500249, 13) + r172;
        int r176 = RL(r171, 10);
        int r177 = RL(((r172 + f2(r175, r173, r176)) + this.X[10]) + 1518500249, 11) + r174;
        int r178 = RL(r173, 10);
        int r179 = RL(((r174 + f2(r177, r175, r178)) + this.X[6]) + 1518500249, 9) + r176;
        int r180 = RL(r175, 10);
        int r181 = RL(((r176 + f2(r179, r177, r180)) + this.X[15]) + 1518500249, 7) + r178;
        int r182 = RL(r177, 10);
        int r183 = RL(((r178 + f2(r181, r179, r182)) + this.X[3]) + 1518500249, 15) + r180;
        int r184 = RL(r179, 10);
        int r185 = RL(((r180 + f2(r183, r181, r184)) + this.X[12]) + 1518500249, 7) + r182;
        int r186 = RL(r181, 10);
        int r187 = RL(((r182 + f2(r185, r183, r186)) + this.X[0]) + 1518500249, 12) + r184;
        int r188 = RL(r183, 10);
        int r189 = RL(((r184 + f2(r187, r185, r188)) + this.X[9]) + 1518500249, 15) + r186;
        int r190 = RL(r185, 10);
        int r191 = RL(((r186 + f2(r189, r187, r190)) + this.X[5]) + 1518500249, 9) + r188;
        int r192 = RL(r187, 10);
        int r193 = RL(((r188 + f2(r191, r189, r192)) + this.X[2]) + 1518500249, 11) + r190;
        int r194 = RL(r189, 10);
        int r195 = RL(((r190 + f2(r193, r191, r194)) + this.X[14]) + 1518500249, 7) + r192;
        int r196 = RL(r191, 10);
        int r197 = RL(((r192 + f2(r195, r193, r196)) + this.X[11]) + 1518500249, 13) + r194;
        int r198 = RL(r193, 10);
        int r199 = RL(((r194 + f2(r197, r195, r198)) + this.X[8]) + 1518500249, 12) + r196;
        int r1100 = RL(r195, 10);
        int r200 = RL(((r164 + f4(r167, r165, r168)) + this.X[6]) + 1548603684, 9) + r166;
        int r201 = RL(r165, 10);
        int r202 = RL(((r166 + f4(r200, r167, r201)) + this.X[11]) + 1548603684, 13) + r168;
        int r203 = RL(r167, 10);
        int r204 = RL(((r168 + f4(r202, r200, r203)) + this.X[3]) + 1548603684, 15) + r201;
        int r205 = RL(r200, 10);
        int r206 = RL(((r201 + f4(r204, r202, r205)) + this.X[7]) + 1548603684, 7) + r203;
        int r207 = RL(r202, 10);
        int r208 = RL(((r203 + f4(r206, r204, r207)) + this.X[0]) + 1548603684, 12) + r205;
        int r209 = RL(r204, 10);
        int r210 = RL(((r205 + f4(r208, r206, r209)) + this.X[13]) + 1548603684, 8) + r207;
        int r211 = RL(r206, 10);
        int r212 = RL(((r207 + f4(r210, r208, r211)) + this.X[5]) + 1548603684, 9) + r209;
        int r213 = RL(r208, 10);
        int r214 = RL(((r209 + f4(r212, r210, r213)) + this.X[10]) + 1548603684, 11) + r211;
        int r215 = RL(r210, 10);
        int r216 = RL(((r211 + f4(r214, r212, r215)) + this.X[14]) + 1548603684, 7) + r213;
        int r217 = RL(r212, 10);
        int r218 = RL(((r213 + f4(r216, r214, r217)) + this.X[15]) + 1548603684, 7) + r215;
        int r219 = RL(r214, 10);
        int r220 = RL(((r215 + f4(r218, r216, r219)) + this.X[8]) + 1548603684, 12) + r217;
        int r221 = RL(r216, 10);
        int r222 = RL(((r217 + f4(r220, r218, r221)) + this.X[12]) + 1548603684, 7) + r219;
        int r223 = RL(r218, 10);
        int r224 = RL(((r219 + f4(r222, r220, r223)) + this.X[4]) + 1548603684, 6) + r221;
        int r225 = RL(r220, 10);
        int r226 = RL(((r221 + f4(r224, r222, r225)) + this.X[9]) + 1548603684, 15) + r223;
        int r227 = RL(r222, 10);
        int r228 = RL(((r223 + f4(r226, r224, r227)) + this.X[1]) + 1548603684, 13) + r225;
        int r229 = RL(r224, 10);
        int r230 = RL(((r225 + f4(r228, r226, r229)) + this.X[2]) + 1548603684, 11) + r227;
        int r231 = RL(r226, 10);
        int r1101 = RL(((r196 + f3(r199, r197, r1100)) + this.X[3]) + 1859775393, 11) + r198;
        int r232 = RL(r197, 10);
        int r233 = RL(((r198 + f3(r1101, r199, r232)) + this.X[10]) + 1859775393, 13) + r1100;
        int r1102 = RL(r199, 10);
        int r1103 = RL(((r1100 + f3(r233, r1101, r1102)) + this.X[14]) + 1859775393, 6) + r232;
        int r1104 = RL(r1101, 10);
        int r234 = RL(((r232 + f3(r1103, r233, r1104)) + this.X[4]) + 1859775393, 7) + r1102;
        int r235 = RL(r233, 10);
        int r1105 = RL(((r1102 + f3(r234, r1103, r235)) + this.X[9]) + 1859775393, 14) + r1104;
        int r1106 = RL(r1103, 10);
        int r1107 = RL(((r1104 + f3(r1105, r234, r1106)) + this.X[15]) + 1859775393, 9) + r235;
        int r236 = RL(r234, 10);
        int r237 = RL(((r235 + f3(r1107, r1105, r236)) + this.X[8]) + 1859775393, 13) + r1106;
        int r1108 = RL(r1105, 10);
        int r1109 = RL(((r1106 + f3(r237, r1107, r1108)) + this.X[1]) + 1859775393, 15) + r236;
        int r1110 = RL(r1107, 10);
        int r238 = RL(((r236 + f3(r1109, r237, r1110)) + this.X[2]) + 1859775393, 14) + r1108;
        int r239 = RL(r237, 10);
        int r1111 = RL(((r1108 + f3(r238, r1109, r239)) + this.X[7]) + 1859775393, 8) + r1110;
        int r1112 = RL(r1109, 10);
        int r1113 = RL(((r1110 + f3(r1111, r238, r1112)) + this.X[0]) + 1859775393, 13) + r239;
        int r240 = RL(r238, 10);
        int r241 = RL(((r239 + f3(r1113, r1111, r240)) + this.X[6]) + 1859775393, 6) + r1112;
        int r1114 = RL(r1111, 10);
        int r1115 = RL(((r1112 + f3(r241, r1113, r1114)) + this.X[13]) + 1859775393, 5) + r240;
        int r1116 = RL(r1113, 10);
        int r242 = RL(((r240 + f3(r1115, r241, r1116)) + this.X[11]) + 1859775393, 12) + r1114;
        int r243 = RL(r241, 10);
        int r1117 = RL(((r1114 + f3(r242, r1115, r243)) + this.X[5]) + 1859775393, 7) + r1116;
        int r1118 = RL(r1115, 10);
        int r1119 = RL(((r1116 + f3(r1117, r242, r1118)) + this.X[12]) + 1859775393, 5) + r243;
        int r244 = RL(r242, 10);
        int r245 = RL(((r227 + f3(r230, r228, r231)) + this.X[15]) + 1836072691, 9) + r229;
        int r246 = RL(r228, 10);
        int r247 = RL(((r229 + f3(r245, r230, r246)) + this.X[5]) + 1836072691, 7) + r231;
        int r248 = RL(r230, 10);
        int r249 = RL(((r231 + f3(r247, r245, r248)) + this.X[1]) + 1836072691, 15) + r246;
        int r250 = RL(r245, 10);
        int r251 = RL(((r246 + f3(r249, r247, r250)) + this.X[3]) + 1836072691, 11) + r248;
        int r252 = RL(r247, 10);
        int r253 = RL(((r248 + f3(r251, r249, r252)) + this.X[7]) + 1836072691, 8) + r250;
        int r254 = RL(r249, 10);
        int r255 = RL(((r250 + f3(r253, r251, r254)) + this.X[14]) + 1836072691, 6) + r252;
        int r256 = RL(r251, 10);
        int r257 = RL(((r252 + f3(r255, r253, r256)) + this.X[6]) + 1836072691, 6) + r254;
        int r258 = RL(r253, 10);
        int r259 = RL(((r254 + f3(r257, r255, r258)) + this.X[9]) + 1836072691, 14) + r256;
        int r260 = RL(r255, 10);
        int r261 = RL(((r256 + f3(r259, r257, r260)) + this.X[11]) + 1836072691, 12) + r258;
        int r262 = RL(r257, 10);
        int r263 = RL(((r258 + f3(r261, r259, r262)) + this.X[8]) + 1836072691, 13) + r260;
        int r264 = RL(r259, 10);
        int r265 = RL(((r260 + f3(r263, r261, r264)) + this.X[12]) + 1836072691, 5) + r262;
        int r266 = RL(r261, 10);
        int r267 = RL(((r262 + f3(r265, r263, r266)) + this.X[2]) + 1836072691, 14) + r264;
        int r268 = RL(r263, 10);
        int r269 = RL(((r264 + f3(r267, r265, r268)) + this.X[10]) + 1836072691, 13) + r266;
        int r270 = RL(r265, 10);
        int r271 = RL(((r266 + f3(r269, r267, r270)) + this.X[0]) + 1836072691, 13) + r268;
        int r272 = RL(r267, 10);
        int r273 = RL(((r268 + f3(r271, r269, r272)) + this.X[4]) + 1836072691, 7) + r270;
        int r274 = RL(r269, 10);
        int r275 = RL(((r270 + f3(r273, r271, r274)) + this.X[13]) + 1836072691, 5) + r272;
        int r276 = RL(r271, 10);
        int r277 = RL(((r243 + f4(r1119, r1117, r244)) + this.X[1]) - 1894007588, 11) + r1118;
        int r1120 = RL(r1117, 10);
        int r1121 = RL(((r1118 + f4(r277, r1119, r1120)) + this.X[9]) - 1894007588, 12) + r244;
        int r1122 = RL(r1119, 10);
        int r278 = RL(((r244 + f4(r1121, r277, r1122)) + this.X[11]) - 1894007588, 14) + r1120;
        int r279 = RL(r277, 10);
        int r1123 = RL(((r1120 + f4(r278, r1121, r279)) + this.X[10]) - 1894007588, 15) + r1122;
        int r1124 = RL(r1121, 10);
        int r1125 = RL(((r1122 + f4(r1123, r278, r1124)) + this.X[0]) - 1894007588, 14) + r279;
        int r280 = RL(r278, 10);
        int r281 = RL(((r279 + f4(r1125, r1123, r280)) + this.X[8]) - 1894007588, 15) + r1124;
        int r1126 = RL(r1123, 10);
        int r1127 = RL(((r1124 + f4(r281, r1125, r1126)) + this.X[12]) - 1894007588, 9) + r280;
        int r1128 = RL(r1125, 10);
        int r282 = RL(((r280 + f4(r1127, r281, r1128)) + this.X[4]) - 1894007588, 8) + r1126;
        int r283 = RL(r281, 10);
        int r1129 = RL(((r1126 + f4(r282, r1127, r283)) + this.X[13]) - 1894007588, 9) + r1128;
        int r1130 = RL(r1127, 10);
        int r1131 = RL(((r1128 + f4(r1129, r282, r1130)) + this.X[3]) - 1894007588, 14) + r283;
        int r284 = RL(r282, 10);
        int r285 = RL(((r283 + f4(r1131, r1129, r284)) + this.X[7]) - 1894007588, 5) + r1130;
        int r1132 = RL(r1129, 10);
        int r1133 = RL(((r1130 + f4(r285, r1131, r1132)) + this.X[15]) - 1894007588, 6) + r284;
        int r1134 = RL(r1131, 10);
        int r286 = RL(((r284 + f4(r1133, r285, r1134)) + this.X[14]) - 1894007588, 8) + r1132;
        int r287 = RL(r285, 10);
        int r1135 = RL(((r1132 + f4(r286, r1133, r287)) + this.X[5]) - 1894007588, 6) + r1134;
        int r1136 = RL(r1133, 10);
        int r1137 = RL(((r1134 + f4(r1135, r286, r1136)) + this.X[6]) - 1894007588, 5) + r287;
        int r288 = RL(r286, 10);
        int r289 = RL(((r287 + f4(r1137, r1135, r288)) + this.X[2]) - 1894007588, 12) + r1136;
        int r1138 = RL(r1135, 10);
        int r290 = RL(((r272 + f2(r275, r273, r276)) + this.X[8]) + 2053994217, 15) + r274;
        int r291 = RL(r273, 10);
        int r292 = RL(((r274 + f2(r290, r275, r291)) + this.X[6]) + 2053994217, 5) + r276;
        int r293 = RL(r275, 10);
        int r294 = RL(((r276 + f2(r292, r290, r293)) + this.X[4]) + 2053994217, 8) + r291;
        int r295 = RL(r290, 10);
        int r296 = RL(((r291 + f2(r294, r292, r295)) + this.X[1]) + 2053994217, 11) + r293;
        int r297 = RL(r292, 10);
        int r298 = RL(((r293 + f2(r296, r294, r297)) + this.X[3]) + 2053994217, 14) + r295;
        int r299 = RL(r294, 10);
        int r300 = RL(((r295 + f2(r298, r296, r299)) + this.X[11]) + 2053994217, 14) + r297;
        int r301 = RL(r296, 10);
        int r302 = RL(((r297 + f2(r300, r298, r301)) + this.X[15]) + 2053994217, 6) + r299;
        int r303 = RL(r298, 10);
        int r304 = RL(((r299 + f2(r302, r300, r303)) + this.X[0]) + 2053994217, 14) + r301;
        int r305 = RL(r300, 10);
        int r306 = RL(((r301 + f2(r304, r302, r305)) + this.X[5]) + 2053994217, 6) + r303;
        int r307 = RL(r302, 10);
        int r308 = RL(((r303 + f2(r306, r304, r307)) + this.X[12]) + 2053994217, 9) + r305;
        int r309 = RL(r304, 10);
        int r310 = RL(((r305 + f2(r308, r306, r309)) + this.X[2]) + 2053994217, 12) + r307;
        int r311 = RL(r306, 10);
        int r312 = RL(((r307 + f2(r310, r308, r311)) + this.X[13]) + 2053994217, 9) + r309;
        int r313 = RL(r308, 10);
        int r314 = RL(((r309 + f2(r312, r310, r313)) + this.X[9]) + 2053994217, 12) + r311;
        int r315 = RL(r310, 10);
        int r316 = RL(((r311 + f2(r314, r312, r315)) + this.X[7]) + 2053994217, 5) + r313;
        int r317 = RL(r312, 10);
        int r318 = RL(((r313 + f2(r316, r314, r317)) + this.X[10]) + 2053994217, 15) + r315;
        int r319 = RL(r314, 10);
        int r320 = RL(((r315 + f2(r318, r316, r319)) + this.X[14]) + 2053994217, 8) + r317;
        int r321 = RL(r316, 10);
        int r1139 = RL(((r1136 + f5(r289, r1137, r1138)) + this.X[4]) - 1454113458, 9) + r288;
        int r1140 = RL(r1137, 10);
        int r322 = RL(((r288 + f5(r1139, r289, r1140)) + this.X[0]) - 1454113458, 15) + r1138;
        int r323 = RL(r289, 10);
        int r1141 = RL(((r1138 + f5(r322, r1139, r323)) + this.X[5]) - 1454113458, 5) + r1140;
        int r1142 = RL(r1139, 10);
        int r1143 = RL(((r1140 + f5(r1141, r322, r1142)) + this.X[9]) - 1454113458, 11) + r323;
        int r324 = RL(r322, 10);
        int r325 = RL(((r323 + f5(r1143, r1141, r324)) + this.X[7]) - 1454113458, 6) + r1142;
        int r1144 = RL(r1141, 10);
        int r1145 = RL(((r1142 + f5(r325, r1143, r1144)) + this.X[12]) - 1454113458, 8) + r324;
        int r1146 = RL(r1143, 10);
        int r326 = RL(((r324 + f5(r1145, r325, r1146)) + this.X[2]) - 1454113458, 13) + r1144;
        int r327 = RL(r325, 10);
        int r1147 = RL(((r1144 + f5(r326, r1145, r327)) + this.X[10]) - 1454113458, 12) + r1146;
        int r1148 = RL(r1145, 10);
        int r1149 = RL(((r1146 + f5(r1147, r326, r1148)) + this.X[14]) - 1454113458, 5) + r327;
        int r328 = RL(r326, 10);
        int r329 = RL(((r327 + f5(r1149, r1147, r328)) + this.X[1]) - 1454113458, 12) + r1148;
        int r1150 = RL(r1147, 10);
        int r1151 = RL(((r1148 + f5(r329, r1149, r1150)) + this.X[3]) - 1454113458, 13) + r328;
        int r1152 = RL(r1149, 10);
        int r330 = RL(((r328 + f5(r1151, r329, r1152)) + this.X[8]) - 1454113458, 14) + r1150;
        int r331 = RL(r329, 10);
        int r1153 = RL(((r1150 + f5(r330, r1151, r331)) + this.X[11]) - 1454113458, 11) + r1152;
        int r1154 = RL(r1151, 10);
        int r1155 = RL(((r1152 + f5(r1153, r330, r1154)) + this.X[6]) - 1454113458, 8) + r331;
        int r332 = RL(r330, 10);
        int r333 = RL(((r331 + f5(r1155, r1153, r332)) + this.X[15]) - 1454113458, 5) + r1154;
        int r1156 = RL(r1153, 10);
        int r1157 = RL(((r1154 + f5(r333, r1155, r1156)) + this.X[13]) - 1454113458, 6) + r332;
        int r1158 = RL(r1155, 10);
        int r334 = RL((r317 + f1(r320, r318, r321)) + this.X[12], 8) + r319;
        int r335 = RL(r318, 10);
        int r336 = RL((r319 + f1(r334, r320, r335)) + this.X[15], 5) + r321;
        int r337 = RL(r320, 10);
        int r338 = RL((r321 + f1(r336, r334, r337)) + this.X[10], 12) + r335;
        int r339 = RL(r334, 10);
        int r340 = RL((r335 + f1(r338, r336, r339)) + this.X[4], 9) + r337;
        int r341 = RL(r336, 10);
        int r342 = RL((r337 + f1(r340, r338, r341)) + this.X[1], 12) + r339;
        int r343 = RL(r338, 10);
        int r344 = RL((r339 + f1(r342, r340, r343)) + this.X[5], 5) + r341;
        int r345 = RL(r340, 10);
        int r346 = RL((r341 + f1(r344, r342, r345)) + this.X[8], 14) + r343;
        int r347 = RL(r342, 10);
        int r348 = RL((r343 + f1(r346, r344, r347)) + this.X[7], 6) + r345;
        int r349 = RL(r344, 10);
        int r350 = RL((r345 + f1(r348, r346, r349)) + this.X[6], 8) + r347;
        int r351 = RL(r346, 10);
        int r352 = RL((r347 + f1(r350, r348, r351)) + this.X[2], 13) + r349;
        int r353 = RL(r348, 10);
        int r354 = RL((r349 + f1(r352, r350, r353)) + this.X[13], 6) + r351;
        int r355 = RL(r350, 10);
        int r356 = RL((r351 + f1(r354, r352, r355)) + this.X[14], 5) + r353;
        int r357 = RL(r352, 10);
        int r358 = RL((r353 + f1(r356, r354, r357)) + this.X[0], 15) + r355;
        int r359 = RL(r354, 10);
        int r360 = RL((r355 + f1(r358, r356, r359)) + this.X[3], 13) + r357;
        int r361 = RL(r356, 10);
        int r362 = RL((r357 + f1(r360, r358, r361)) + this.X[9], 11) + r359;
        int r363 = RL(r358, 10);
        int r364 = RL((r359 + f1(r362, r360, r363)) + this.X[11], 11) + r361;
        int r365 = RL(r360, 10) + (r333 + this.H1);
        this.H1 = (this.H2 + r1158) + r363;
        this.H2 = (this.H3 + r1156) + r361;
        this.H3 = (this.H4 + r332) + r364;
        this.H4 = (this.H0 + r1157) + r362;
        this.H0 = r365;
        this.xOff = 0;
        int r366 = 0;
    L3:
        int[] r367 = this.X;
        if (r366 == r367.length) goto L6;
        r367[r366] = 0;
        r366 = r366 + 1;
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
        copyIn((RIPEMD160Digest) r100);
    }
}
