package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class RIPEMD128Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 16;
    private int H0;
    private int H1;
    private int H2;
    private int H3;
    private int[] X;
    private int xOff;

    public RIPEMD128Digest() {
        this.X = new int[16];
        reset();
    }

    public RIPEMD128Digest(RIPEMD128Digest r100) {
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

    private void copyIn(RIPEMD128Digest r100) {
        super.copyIn(r100);
        this.H0 = r100.H0;
        this.H1 = r100.H1;
        this.H2 = r100.H2;
        this.H3 = r100.H3;
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
        return new RIPEMD128Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        unpackWord(this.H0, r100, r101);
        unpackWord(this.H1, r100, r101 + 4);
        unpackWord(this.H2, r100, r101 + 8);
        unpackWord(this.H3, r100, r101 + 12);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD128";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r100 = this.H0;
        int r101 = this.H1;
        int r110 = this.H2;
        int r111 = this.H3;
        int r112 = F1(r100, r101, r110, r111, this.X[0], 11);
        int r113 = F1(r111, r112, r101, r110, this.X[1], 14);
        int r114 = F1(r110, r113, r112, r101, this.X[2], 15);
        int r115 = F1(r101, r114, r113, r112, this.X[3], 12);
        int r116 = F1(r112, r115, r114, r113, this.X[4], 5);
        int r117 = F1(r113, r116, r115, r114, this.X[5], 8);
        int r118 = F1(r114, r117, r116, r115, this.X[6], 7);
        int r119 = F1(r115, r118, r117, r116, this.X[7], 9);
        int r120 = F1(r116, r119, r118, r117, this.X[8], 11);
        int r121 = F1(r117, r120, r119, r118, this.X[9], 13);
        int r122 = F1(r118, r121, r120, r119, this.X[10], 14);
        int r123 = F1(r119, r122, r121, r120, this.X[11], 15);
        int r124 = F1(r120, r123, r122, r121, this.X[12], 6);
        int r125 = F1(r121, r124, r123, r122, this.X[13], 7);
        int r126 = F1(r122, r125, r124, r123, this.X[14], 9);
        int r127 = F1(r123, r126, r125, r124, this.X[15], 8);
        int r128 = F2(r124, r127, r126, r125, this.X[7], 7);
        int r129 = F2(r125, r128, r127, r126, this.X[4], 6);
        int r130 = F2(r126, r129, r128, r127, this.X[13], 8);
        int r131 = F2(r127, r130, r129, r128, this.X[1], 13);
        int r132 = F2(r128, r131, r130, r129, this.X[10], 11);
        int r133 = F2(r129, r132, r131, r130, this.X[6], 9);
        int r134 = F2(r130, r133, r132, r131, this.X[15], 7);
        int r135 = F2(r131, r134, r133, r132, this.X[3], 15);
        int r136 = F2(r132, r135, r134, r133, this.X[12], 7);
        int r137 = F2(r133, r136, r135, r134, this.X[0], 12);
        int r138 = F2(r134, r137, r136, r135, this.X[9], 15);
        int r139 = F2(r135, r138, r137, r136, this.X[5], 9);
        int r140 = F2(r136, r139, r138, r137, this.X[2], 11);
        int r141 = F2(r137, r140, r139, r138, this.X[14], 7);
        int r142 = F2(r138, r141, r140, r139, this.X[11], 13);
        int r143 = F2(r139, r142, r141, r140, this.X[8], 12);
        int r144 = F3(r140, r143, r142, r141, this.X[3], 11);
        int r145 = F3(r141, r144, r143, r142, this.X[10], 13);
        int r146 = F3(r142, r145, r144, r143, this.X[14], 6);
        int r147 = F3(r143, r146, r145, r144, this.X[4], 7);
        int r148 = F3(r144, r147, r146, r145, this.X[9], 14);
        int r149 = F3(r145, r148, r147, r146, this.X[15], 9);
        int r150 = F3(r146, r149, r148, r147, this.X[8], 13);
        int r151 = F3(r147, r150, r149, r148, this.X[1], 15);
        int r152 = F3(r148, r151, r150, r149, this.X[2], 14);
        int r153 = F3(r149, r152, r151, r150, this.X[7], 8);
        int r154 = F3(r150, r153, r152, r151, this.X[0], 13);
        int r155 = F3(r151, r154, r153, r152, this.X[6], 6);
        int r156 = F3(r152, r155, r154, r153, this.X[13], 5);
        int r157 = F3(r153, r156, r155, r154, this.X[11], 12);
        int r158 = F3(r154, r157, r156, r155, this.X[5], 7);
        int r159 = F3(r155, r158, r157, r156, this.X[12], 5);
        int r160 = F4(r156, r159, r158, r157, this.X[1], 11);
        int r161 = F4(r157, r160, r159, r158, this.X[9], 12);
        int r162 = F4(r158, r161, r160, r159, this.X[11], 14);
        int r163 = F4(r159, r162, r161, r160, this.X[10], 15);
        int r164 = F4(r160, r163, r162, r161, this.X[0], 14);
        int r165 = F4(r161, r164, r163, r162, this.X[8], 15);
        int r166 = F4(r162, r165, r164, r163, this.X[12], 9);
        int r167 = F4(r163, r166, r165, r164, this.X[4], 8);
        int r168 = F4(r164, r167, r166, r165, this.X[13], 9);
        int r169 = F4(r165, r168, r167, r166, this.X[3], 14);
        int r170 = F4(r166, r169, r168, r167, this.X[7], 5);
        int r171 = F4(r167, r170, r169, r168, this.X[15], 6);
        int r172 = F4(r168, r171, r170, r169, this.X[14], 8);
        int r173 = F4(r169, r172, r171, r170, this.X[5], 6);
        int r174 = F4(r170, r173, r172, r171, this.X[6], 5);
        int r175 = F4(r171, r174, r173, r172, this.X[2], 12);
        int r102 = FF4(r100, r101, r110, r111, this.X[5], 8);
        int r176 = FF4(r111, r102, r101, r110, this.X[14], 9);
        int r177 = FF4(r110, r176, r102, r101, this.X[7], 9);
        int r103 = FF4(r101, r177, r176, r102, this.X[0], 11);
        int r104 = FF4(r102, r103, r177, r176, this.X[9], 13);
        int r178 = FF4(r176, r104, r103, r177, this.X[2], 15);
        int r179 = FF4(r177, r178, r104, r103, this.X[11], 15);
        int r105 = FF4(r103, r179, r178, r104, this.X[4], 5);
        int r106 = FF4(r104, r105, r179, r178, this.X[13], 7);
        int r180 = FF4(r178, r106, r105, r179, this.X[6], 7);
        int r181 = FF4(r179, r180, r106, r105, this.X[15], 8);
        int r107 = FF4(r105, r181, r180, r106, this.X[8], 11);
        int r108 = FF4(r106, r107, r181, r180, this.X[1], 14);
        int r182 = FF4(r180, r108, r107, r181, this.X[10], 14);
        int r183 = FF4(r181, r182, r108, r107, this.X[3], 12);
        int r109 = FF4(r107, r183, r182, r108, this.X[12], 6);
        int r184 = FF3(r108, r109, r183, r182, this.X[6], 9);
        int r185 = FF3(r182, r184, r109, r183, this.X[11], 13);
        int r186 = FF3(r183, r185, r184, r109, this.X[3], 15);
        int r187 = FF3(r109, r186, r185, r184, this.X[7], 7);
        int r188 = FF3(r184, r187, r186, r185, this.X[0], 12);
        int r189 = FF3(r185, r188, r187, r186, this.X[13], 8);
        int r190 = FF3(r186, r189, r188, r187, this.X[5], 9);
        int r191 = FF3(r187, r190, r189, r188, this.X[10], 11);
        int r192 = FF3(r188, r191, r190, r189, this.X[14], 7);
        int r193 = FF3(r189, r192, r191, r190, this.X[15], 7);
        int r194 = FF3(r190, r193, r192, r191, this.X[8], 12);
        int r195 = FF3(r191, r194, r193, r192, this.X[12], 7);
        int r196 = FF3(r192, r195, r194, r193, this.X[4], 6);
        int r197 = FF3(r193, r196, r195, r194, this.X[9], 15);
        int r198 = FF3(r194, r197, r196, r195, this.X[1], 13);
        int r199 = FF3(r195, r198, r197, r196, this.X[2], 11);
        int r200 = FF2(r196, r199, r198, r197, this.X[15], 9);
        int r1100 = FF2(r197, r200, r199, r198, this.X[5], 7);
        int r1101 = FF2(r198, r1100, r200, r199, this.X[1], 15);
        int r201 = FF2(r199, r1101, r1100, r200, this.X[3], 11);
        int r202 = FF2(r200, r201, r1101, r1100, this.X[7], 8);
        int r1102 = FF2(r1100, r202, r201, r1101, this.X[14], 6);
        int r1103 = FF2(r1101, r1102, r202, r201, this.X[6], 6);
        int r203 = FF2(r201, r1103, r1102, r202, this.X[9], 14);
        int r204 = FF2(r202, r203, r1103, r1102, this.X[11], 12);
        int r1104 = FF2(r1102, r204, r203, r1103, this.X[8], 13);
        int r1105 = FF2(r1103, r1104, r204, r203, this.X[12], 5);
        int r205 = FF2(r203, r1105, r1104, r204, this.X[2], 14);
        int r206 = FF2(r204, r205, r1105, r1104, this.X[10], 13);
        int r1106 = FF2(r1104, r206, r205, r1105, this.X[0], 13);
        int r1107 = FF2(r1105, r1106, r206, r205, this.X[4], 7);
        int r207 = FF2(r205, r1107, r1106, r206, this.X[13], 5);
        int r208 = FF1(r206, r207, r1107, r1106, this.X[8], 15);
        int r1108 = FF1(r1106, r208, r207, r1107, this.X[6], 5);
        int r1109 = FF1(r1107, r1108, r208, r207, this.X[4], 8);
        int r209 = FF1(r207, r1109, r1108, r208, this.X[1], 11);
        int r210 = FF1(r208, r209, r1109, r1108, this.X[3], 14);
        int r1110 = FF1(r1108, r210, r209, r1109, this.X[11], 14);
        int r1111 = FF1(r1109, r1110, r210, r209, this.X[15], 6);
        int r211 = FF1(r209, r1111, r1110, r210, this.X[0], 14);
        int r212 = FF1(r210, r211, r1111, r1110, this.X[5], 6);
        int r1112 = FF1(r1110, r212, r211, r1111, this.X[12], 9);
        int r1113 = FF1(r1111, r1112, r212, r211, this.X[2], 12);
        int r213 = FF1(r211, r1113, r1112, r212, this.X[13], 9);
        int r214 = FF1(r212, r213, r1113, r1112, this.X[9], 12);
        int r1114 = FF1(r1112, r214, r213, r1113, this.X[7], 5);
        int r1115 = FF1(r1113, r1114, r214, r213, this.X[10], 15);
        int r215 = FF1(r213, r1115, r1114, r214, this.X[14], 8);
        int r1116 = r1114 + (r174 + this.H1);
        this.H1 = (this.H2 + r173) + r214;
        this.H2 = (this.H3 + r172) + r215;
        this.H3 = (this.H0 + r175) + r1115;
        this.H0 = r1116;
        this.xOff = 0;
        int r216 = 0;
    L3:
        int[] r217 = this.X;
        if (r216 == r217.length) goto L6;
        r217[r216] = 0;
        r216 = r216 + 1;
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
        copyIn((RIPEMD128Digest) r100);
    }
}
