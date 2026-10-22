package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class MD4Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 16;
    private static final int S11 = 3;
    private static final int S12 = 7;
    private static final int S13 = 11;
    private static final int S14 = 19;
    private static final int S21 = 3;
    private static final int S22 = 5;
    private static final int S23 = 9;
    private static final int S24 = 13;
    private static final int S31 = 3;
    private static final int S32 = 9;
    private static final int S33 = 11;
    private static final int S34 = 15;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int[] X;
    private int xOff;

    public MD4Digest() {
        this.X = new int[16];
        reset();
    }

    public MD4Digest(MD4Digest r100) {
        super(r100);
        this.X = new int[16];
        copyIn(r100);
    }

    private int F(int r100, int r101, int r102) {
        int r103 = r101 & r100;
        return ((~r100) & r102) | r103;
    }

    private int G(int r100, int r101, int r102) {
        int r103 = r100 & r101;
        return ((r100 & r102) | r103) | (r101 & r102);
    }

    private int H(int r100, int r101, int r102) {
        return (r100 ^ r101) ^ r102;
    }

    private void copyIn(MD4Digest r100) {
        super.copyIn(r100);
        this.H1 = r100.H1;
        this.H2 = r100.H2;
        this.H3 = r100.H3;
        this.H4 = r100.H4;
        int[] r101 = r100.X;
        System.arraycopy(r101, 0, this.X, 0, r101.length);
        this.xOff = r100.xOff;
    }

    private int rotateLeft(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (32 - r101)) | r102;
    }

    private void unpackWord(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        r101[r102 + 1] = (byte) (r100 >>> 8);
        r101[r102 + 2] = (byte) (r100 >>> 16);
        r101[r102 + 3] = (byte) (r100 >>> 24);
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new MD4Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        unpackWord(this.H1, r100, r101);
        unpackWord(this.H2, r100, r101 + 4);
        unpackWord(this.H3, r100, r101 + 8);
        unpackWord(this.H4, r100, r101 + 12);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "MD4";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r100 = this.H1;
        int r101 = this.H2;
        int r102 = this.H3;
        int r103 = this.H4;
        int r104 = rotateLeft((r100 + F(r101, r102, r103)) + this.X[0], 3);
        int r105 = rotateLeft((r103 + F(r104, r101, r102)) + this.X[1], 7);
        int r106 = rotateLeft((r102 + F(r105, r104, r101)) + this.X[2], 11);
        int r107 = rotateLeft((r101 + F(r106, r105, r104)) + this.X[3], 19);
        int r108 = rotateLeft((r104 + F(r107, r106, r105)) + this.X[4], 3);
        int r109 = rotateLeft((r105 + F(r108, r107, r106)) + this.X[5], 7);
        int r110 = rotateLeft((r106 + F(r109, r108, r107)) + this.X[6], 11);
        int r111 = rotateLeft((r107 + F(r110, r109, r108)) + this.X[7], 19);
        int r112 = rotateLeft((r108 + F(r111, r110, r109)) + this.X[8], 3);
        int r113 = rotateLeft((r109 + F(r112, r111, r110)) + this.X[9], 7);
        int r114 = rotateLeft((r110 + F(r113, r112, r111)) + this.X[10], 11);
        int r115 = rotateLeft((r111 + F(r114, r113, r112)) + this.X[11], 19);
        int r116 = rotateLeft((r112 + F(r115, r114, r113)) + this.X[12], 3);
        int r117 = rotateLeft((r113 + F(r116, r115, r114)) + this.X[13], 7);
        int r118 = rotateLeft((r114 + F(r117, r116, r115)) + this.X[14], 11);
        int r119 = rotateLeft((r115 + F(r118, r117, r116)) + this.X[15], 19);
        int r120 = rotateLeft(((r116 + G(r119, r118, r117)) + this.X[0]) + 1518500249, 3);
        int r121 = rotateLeft(((r117 + G(r120, r119, r118)) + this.X[4]) + 1518500249, 5);
        int r122 = rotateLeft(((r118 + G(r121, r120, r119)) + this.X[8]) + 1518500249, 9);
        int r123 = rotateLeft(((r119 + G(r122, r121, r120)) + this.X[12]) + 1518500249, 13);
        int r124 = rotateLeft(((r120 + G(r123, r122, r121)) + this.X[1]) + 1518500249, 3);
        int r125 = rotateLeft(((r121 + G(r124, r123, r122)) + this.X[5]) + 1518500249, 5);
        int r126 = rotateLeft(((r122 + G(r125, r124, r123)) + this.X[9]) + 1518500249, 9);
        int r127 = rotateLeft(((r123 + G(r126, r125, r124)) + this.X[13]) + 1518500249, 13);
        int r128 = rotateLeft(((r124 + G(r127, r126, r125)) + this.X[2]) + 1518500249, 3);
        int r129 = rotateLeft(((r125 + G(r128, r127, r126)) + this.X[6]) + 1518500249, 5);
        int r130 = rotateLeft(((r126 + G(r129, r128, r127)) + this.X[10]) + 1518500249, 9);
        int r131 = rotateLeft(((r127 + G(r130, r129, r128)) + this.X[14]) + 1518500249, 13);
        int r132 = rotateLeft(((r128 + G(r131, r130, r129)) + this.X[3]) + 1518500249, 3);
        int r133 = rotateLeft(((r129 + G(r132, r131, r130)) + this.X[7]) + 1518500249, 5);
        int r134 = rotateLeft(((r130 + G(r133, r132, r131)) + this.X[11]) + 1518500249, 9);
        int r135 = rotateLeft(((r131 + G(r134, r133, r132)) + this.X[15]) + 1518500249, 13);
        int r136 = rotateLeft(((r132 + H(r135, r134, r133)) + this.X[0]) + 1859775393, 3);
        int r137 = rotateLeft(((r133 + H(r136, r135, r134)) + this.X[8]) + 1859775393, 9);
        int r138 = rotateLeft(((r134 + H(r137, r136, r135)) + this.X[4]) + 1859775393, 11);
        int r139 = rotateLeft(((r135 + H(r138, r137, r136)) + this.X[12]) + 1859775393, 15);
        int r140 = rotateLeft(((r136 + H(r139, r138, r137)) + this.X[2]) + 1859775393, 3);
        int r141 = rotateLeft(((r137 + H(r140, r139, r138)) + this.X[10]) + 1859775393, 9);
        int r142 = rotateLeft(((r138 + H(r141, r140, r139)) + this.X[6]) + 1859775393, 11);
        int r143 = rotateLeft(((r139 + H(r142, r141, r140)) + this.X[14]) + 1859775393, 15);
        int r144 = rotateLeft(((r140 + H(r143, r142, r141)) + this.X[1]) + 1859775393, 3);
        int r145 = rotateLeft(((r141 + H(r144, r143, r142)) + this.X[9]) + 1859775393, 9);
        int r146 = rotateLeft(((r142 + H(r145, r144, r143)) + this.X[5]) + 1859775393, 11);
        int r147 = rotateLeft(((r143 + H(r146, r145, r144)) + this.X[13]) + 1859775393, 15);
        int r148 = rotateLeft(((r144 + H(r147, r146, r145)) + this.X[3]) + 1859775393, 3);
        int r149 = rotateLeft(((r145 + H(r148, r147, r146)) + this.X[11]) + 1859775393, 9);
        int r150 = rotateLeft(((r146 + H(r149, r148, r147)) + this.X[7]) + 1859775393, 11);
        int r151 = rotateLeft(((r147 + H(r150, r149, r148)) + this.X[15]) + 1859775393, 15);
        this.H1 += r148;
        this.H2 += r151;
        this.H3 += r150;
        this.H4 += r149;
        this.xOff = 0;
        int r152 = 0;
    L3:
        int[] r153 = this.X;
        if (r152 == r153.length) goto L6;
        r153[r152] = 0;
        r152 = r152 + 1;
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
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
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
        copyIn((MD4Digest) r100);
    }
}
