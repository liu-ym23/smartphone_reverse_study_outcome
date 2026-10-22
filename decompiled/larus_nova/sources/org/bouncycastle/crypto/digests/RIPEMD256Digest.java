package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class RIPEMD256Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 32;
    private int H0;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int[] X;
    private int xOff;

    public RIPEMD256Digest() {
        this.X = new int[16];
        reset();
    }

    public RIPEMD256Digest(RIPEMD256Digest r100) {
        super(r100);
        this.X = new int[16];
        copyIn(r100);
    }

    private int F1(int r100, int r101, int r102, int r103, int r104, int r105) {
        return RL((r100 + f1(r101, r102, r103)) + r104, r105);
    }

    private int F2(int r100, int r101, int r102, int r103, int r104, int r105) {
        return RL(((r100 + f2(r101, r102, r103)) + r104) + 1518500249, r105);
    }

    private int F3(int r100, int r101, int r102, int r103, int r104, int r105) {
        return RL(((r100 + f3(r101, r102, r103)) + r104) + 1859775393, r105);
    }

    private int F4(int r100, int r101, int r102, int r103, int r104, int r105) {
        return RL(((r100 + f4(r101, r102, r103)) + r104) - 1894007588, r105);
    }

    private int FF1(int r100, int r101, int r102, int r103, int r104, int r105) {
        return RL((r100 + f1(r101, r102, r103)) + r104, r105);
    }

    private int FF2(int r100, int r101, int r102, int r103, int r104, int r105) {
        return RL(((r100 + f2(r101, r102, r103)) + r104) + 1836072691, r105);
    }

    private int FF3(int r100, int r101, int r102, int r103, int r104, int r105) {
        return RL(((r100 + f3(r101, r102, r103)) + r104) + 1548603684, r105);
    }

    private int FF4(int r100, int r101, int r102, int r103, int r104, int r105) {
        return RL(((r100 + f4(r101, r102, r103)) + r104) + 1352829926, r105);
    }

    private int RL(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (32 - r101)) | r102;
    }

    private void copyIn(RIPEMD256Digest r100) {
        super.copyIn(r100);
        this.H0 = r100.H0;
        this.H1 = r100.H1;
        this.H2 = r100.H2;
        this.H3 = r100.H3;
        this.H4 = r100.H4;
        this.H5 = r100.H5;
        this.H6 = r100.H6;
        this.H7 = r100.H7;
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

    private void unpackWord(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        r101[r102 + 1] = (byte) (r100 >>> 8);
        r101[r102 + 2] = (byte) (r100 >>> 16);
        r101[r102 + 3] = (byte) (r100 >>> 24);
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new RIPEMD256Digest(this);
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
        reset();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD256";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r100 = this.H0;
        int r101 = this.H1;
        int r102 = this.H2;
        int r110 = this.H3;
        int r111 = this.H4;
        int r112 = this.H5;
        int r113 = this.H6;
        int r114 = this.H7;
        int r115 = F1(r100, r101, r102, r110, this.X[0], 11);
        int r116 = F1(r110, r115, r101, r102, this.X[1], 14);
        int r103 = F1(r102, r116, r115, r101, this.X[2], 15);
        int r104 = F1(r101, r103, r116, r115, this.X[3], 12);
        int r117 = F1(r115, r104, r103, r116, this.X[4], 5);
        int r118 = F1(r116, r117, r104, r103, this.X[5], 8);
        int r105 = F1(r103, r118, r117, r104, this.X[6], 7);
        int r106 = F1(r104, r105, r118, r117, this.X[7], 9);
        int r119 = F1(r117, r106, r105, r118, this.X[8], 11);
        int r120 = F1(r118, r119, r106, r105, this.X[9], 13);
        int r107 = F1(r105, r120, r119, r106, this.X[10], 14);
        int r108 = F1(r106, r107, r120, r119, this.X[11], 15);
        int r121 = F1(r119, r108, r107, r120, this.X[12], 6);
        int r122 = F1(r120, r121, r108, r107, this.X[13], 7);
        int r109 = F1(r107, r122, r121, r108, this.X[14], 9);
        int r123 = F1(r108, r109, r122, r121, this.X[15], 8);
        int r124 = FF4(r111, r112, r113, r114, this.X[5], 8);
        int r125 = FF4(r114, r124, r112, r113, this.X[14], 9);
        int r126 = FF4(r113, r125, r124, r112, this.X[7], 9);
        int r127 = FF4(r112, r126, r125, r124, this.X[0], 11);
        int r128 = FF4(r124, r127, r126, r125, this.X[9], 13);
        int r129 = FF4(r125, r128, r127, r126, this.X[2], 15);
        int r130 = FF4(r126, r129, r128, r127, this.X[11], 15);
        int r131 = FF4(r127, r130, r129, r128, this.X[4], 5);
        int r132 = FF4(r128, r131, r130, r129, this.X[13], 7);
        int r133 = FF4(r129, r132, r131, r130, this.X[6], 7);
        int r134 = FF4(r130, r133, r132, r131, this.X[15], 8);
        int r135 = FF4(r131, r134, r133, r132, this.X[8], 11);
        int r136 = FF4(r132, r135, r134, r133, this.X[1], 14);
        int r137 = FF4(r133, r136, r135, r134, this.X[10], 14);
        int r138 = FF4(r134, r137, r136, r135, this.X[3], 12);
        int r139 = FF4(r135, r138, r137, r136, this.X[12], 6);
        int r140 = F2(r136, r123, r109, r122, this.X[7], 7);
        int r141 = F2(r122, r140, r123, r109, this.X[4], 6);
        int r142 = F2(r109, r141, r140, r123, this.X[13], 8);
        int r143 = F2(r123, r142, r141, r140, this.X[1], 13);
        int r144 = F2(r140, r143, r142, r141, this.X[10], 11);
        int r145 = F2(r141, r144, r143, r142, this.X[6], 9);
        int r146 = F2(r142, r145, r144, r143, this.X[15], 7);
        int r147 = F2(r143, r146, r145, r144, this.X[3], 15);
        int r148 = F2(r144, r147, r146, r145, this.X[12], 7);
        int r149 = F2(r145, r148, r147, r146, this.X[0], 12);
        int r150 = F2(r146, r149, r148, r147, this.X[9], 15);
        int r151 = F2(r147, r150, r149, r148, this.X[5], 9);
        int r152 = F2(r148, r151, r150, r149, this.X[2], 11);
        int r153 = F2(r149, r152, r151, r150, this.X[14], 7);
        int r154 = F2(r150, r153, r152, r151, this.X[11], 13);
        int r155 = F2(r151, r154, r153, r152, this.X[8], 12);
        int r156 = FF3(r121, r139, r138, r137, this.X[6], 9);
        int r157 = FF3(r137, r156, r139, r138, this.X[11], 13);
        int r158 = FF3(r138, r157, r156, r139, this.X[3], 15);
        int r159 = FF3(r139, r158, r157, r156, this.X[7], 7);
        int r160 = FF3(r156, r159, r158, r157, this.X[0], 12);
        int r161 = FF3(r157, r160, r159, r158, this.X[13], 8);
        int r162 = FF3(r158, r161, r160, r159, this.X[5], 9);
        int r163 = FF3(r159, r162, r161, r160, this.X[10], 11);
        int r164 = FF3(r160, r163, r162, r161, this.X[14], 7);
        int r165 = FF3(r161, r164, r163, r162, this.X[15], 7);
        int r166 = FF3(r162, r165, r164, r163, this.X[8], 12);
        int r167 = FF3(r163, r166, r165, r164, this.X[12], 7);
        int r168 = FF3(r164, r167, r166, r165, this.X[4], 6);
        int r169 = FF3(r165, r168, r167, r166, this.X[9], 15);
        int r170 = FF3(r166, r169, r168, r167, this.X[1], 13);
        int r171 = FF3(r167, r170, r169, r168, this.X[2], 11);
        int r172 = F3(r152, r171, r154, r153, this.X[3], 11);
        int r173 = F3(r153, r172, r171, r154, this.X[10], 13);
        int r174 = F3(r154, r173, r172, r171, this.X[14], 6);
        int r175 = F3(r171, r174, r173, r172, this.X[4], 7);
        int r176 = F3(r172, r175, r174, r173, this.X[9], 14);
        int r177 = F3(r173, r176, r175, r174, this.X[15], 9);
        int r178 = F3(r174, r177, r176, r175, this.X[8], 13);
        int r179 = F3(r175, r178, r177, r176, this.X[1], 15);
        int r180 = F3(r176, r179, r178, r177, this.X[2], 14);
        int r181 = F3(r177, r180, r179, r178, this.X[7], 8);
        int r182 = F3(r178, r181, r180, r179, this.X[0], 13);
        int r183 = F3(r179, r182, r181, r180, this.X[6], 6);
        int r184 = F3(r180, r183, r182, r181, this.X[13], 5);
        int r185 = F3(r181, r184, r183, r182, this.X[11], 12);
        int r186 = F3(r182, r185, r184, r183, this.X[5], 7);
        int r187 = F3(r183, r186, r185, r184, this.X[12], 5);
        int r188 = FF2(r168, r155, r170, r169, this.X[15], 9);
        int r189 = FF2(r169, r188, r155, r170, this.X[5], 7);
        int r190 = FF2(r170, r189, r188, r155, this.X[1], 15);
        int r191 = FF2(r155, r190, r189, r188, this.X[3], 11);
        int r192 = FF2(r188, r191, r190, r189, this.X[7], 8);
        int r193 = FF2(r189, r192, r191, r190, this.X[14], 6);
        int r194 = FF2(r190, r193, r192, r191, this.X[6], 6);
        int r195 = FF2(r191, r194, r193, r192, this.X[9], 14);
        int r196 = FF2(r192, r195, r194, r193, this.X[11], 12);
        int r197 = FF2(r193, r196, r195, r194, this.X[8], 13);
        int r198 = FF2(r194, r197, r196, r195, this.X[12], 5);
        int r199 = FF2(r195, r198, r197, r196, this.X[2], 14);
        int r1100 = FF2(r196, r199, r198, r197, this.X[10], 13);
        int r1101 = FF2(r197, r1100, r199, r198, this.X[0], 13);
        int r1102 = FF2(r198, r1101, r1100, r199, this.X[4], 7);
        int r200 = FF2(r199, r1102, r1101, r1100, this.X[13], 5);
        int r1103 = F4(r184, r187, r1102, r185, this.X[1], 11);
        int r1104 = F4(r185, r1103, r187, r1102, this.X[9], 12);
        int r1105 = F4(r1102, r1104, r1103, r187, this.X[11], 14);
        int r1106 = F4(r187, r1105, r1104, r1103, this.X[10], 15);
        int r1107 = F4(r1103, r1106, r1105, r1104, this.X[0], 14);
        int r1108 = F4(r1104, r1107, r1106, r1105, this.X[8], 15);
        int r1109 = F4(r1105, r1108, r1107, r1106, this.X[12], 9);
        int r1110 = F4(r1106, r1109, r1108, r1107, this.X[4], 8);
        int r1111 = F4(r1107, r1110, r1109, r1108, this.X[13], 9);
        int r1112 = F4(r1108, r1111, r1110, r1109, this.X[3], 14);
        int r1113 = F4(r1109, r1112, r1111, r1110, this.X[7], 5);
        int r1114 = F4(r1110, r1113, r1112, r1111, this.X[15], 6);
        int r1115 = F4(r1111, r1114, r1113, r1112, this.X[14], 8);
        int r1116 = F4(r1112, r1115, r1114, r1113, this.X[5], 6);
        int r1117 = F4(r1113, r1116, r1115, r1114, this.X[6], 5);
        int r1118 = F4(r1114, r1117, r1116, r1115, this.X[2], 12);
        int r1119 = FF1(r1100, r200, r186, r1101, this.X[8], 15);
        int r1120 = FF1(r1101, r1119, r200, r186, this.X[6], 5);
        int r201 = FF1(r186, r1120, r1119, r200, this.X[4], 8);
        int r202 = FF1(r200, r201, r1120, r1119, this.X[1], 11);
        int r1121 = FF1(r1119, r202, r201, r1120, this.X[3], 14);
        int r1122 = FF1(r1120, r1121, r202, r201, this.X[11], 14);
        int r203 = FF1(r201, r1122, r1121, r202, this.X[15], 6);
        int r204 = FF1(r202, r203, r1122, r1121, this.X[0], 14);
        int r1123 = FF1(r1121, r204, r203, r1122, this.X[5], 6);
        int r1124 = FF1(r1122, r1123, r204, r203, this.X[12], 9);
        int r205 = FF1(r203, r1124, r1123, r204, this.X[2], 12);
        int r206 = FF1(r204, r205, r1124, r1123, this.X[13], 9);
        int r1125 = FF1(r1123, r206, r205, r1124, this.X[9], 12);
        int r1126 = FF1(r1124, r1125, r206, r205, this.X[7], 5);
        int r207 = FF1(r205, r1126, r1125, r206, this.X[10], 15);
        int r208 = FF1(r206, r207, r1126, r1125, this.X[14], 8);
        this.H0 += r1115;
        this.H1 += r1118;
        this.H2 += r1117;
        this.H3 += r1126;
        this.H4 += r1125;
        this.H5 += r208;
        this.H6 += r207;
        this.H7 += r1116;
        this.xOff = 0;
        int r209 = 0;
    L3:
        int[] r210 = this.X;
        if (r209 == r210.length) goto L6;
        r210[r209] = 0;
        r209 = r209 + 1;
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
        this.H4 = 1985229328;
        this.H5 = -19088744;
        this.H6 = -1985229329;
        this.H7 = 19088743;
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
        copyIn((RIPEMD256Digest) r100);
    }
}
