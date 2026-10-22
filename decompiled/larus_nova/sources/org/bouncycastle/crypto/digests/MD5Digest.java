package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class MD5Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 16;
    private static final int S11 = 7;
    private static final int S12 = 12;
    private static final int S13 = 17;
    private static final int S14 = 22;
    private static final int S21 = 5;
    private static final int S22 = 9;
    private static final int S23 = 14;
    private static final int S24 = 20;
    private static final int S31 = 4;
    private static final int S32 = 11;
    private static final int S33 = 16;
    private static final int S34 = 23;
    private static final int S41 = 6;
    private static final int S42 = 10;
    private static final int S43 = 15;
    private static final int S44 = 21;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int[] X;
    private int xOff;

    public MD5Digest() {
        this.X = new int[16];
        reset();
    }

    public MD5Digest(MD5Digest r100) {
        super(r100);
        this.X = new int[16];
        copyIn(r100);
    }

    public MD5Digest(byte[] r100) {
        super(r100);
        this.X = new int[16];
        this.H1 = Pack.bigEndianToInt(r100, 16);
        this.H2 = Pack.bigEndianToInt(r100, 20);
        this.H3 = Pack.bigEndianToInt(r100, 24);
        this.H4 = Pack.bigEndianToInt(r100, 28);
        this.xOff = Pack.bigEndianToInt(r100, 32);
        int r101 = 0;
    L4:
        if (r101 == this.xOff) goto L6;
        this.X[r101] = Pack.bigEndianToInt(r100, (r101 * 4) + 36);
        r101 = r101 + 1;
        goto L4
    }

    private int F(int r100, int r101, int r102) {
        int r103 = r101 & r100;
        return ((~r100) & r102) | r103;
    }

    private int G(int r100, int r101, int r102) {
        return (r100 & r102) | (r101 & (~r102));
    }

    private int H(int r100, int r101, int r102) {
        return (r100 ^ r101) ^ r102;
    }

    private int K(int r100, int r101, int r102) {
        return (r100 | (~r102)) ^ r101;
    }

    private void copyIn(MD5Digest r100) {
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
        return new MD5Digest(this);
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
        return "MD5";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] r100 = new byte[(this.xOff * 4) + 36];
        super.populateState(r100);
        Pack.intToBigEndian(this.H1, r100, 16);
        Pack.intToBigEndian(this.H2, r100, 20);
        Pack.intToBigEndian(this.H3, r100, 24);
        Pack.intToBigEndian(this.H4, r100, 28);
        Pack.intToBigEndian(this.xOff, r100, 32);
        int r101 = 0;
    L4:
        if (r101 == this.xOff) goto L6;
        Pack.intToBigEndian(this.X[r101], r100, (r101 * 4) + 36);
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r100 = this.H1;
        int r101 = this.H2;
        int r102 = this.H3;
        int r103 = this.H4;
        int r104 = rotateLeft(((r100 + F(r101, r102, r103)) + this.X[0]) - 680876936, 7) + r101;
        int r105 = rotateLeft(((r103 + F(r104, r101, r102)) + this.X[1]) - 389564586, 12) + r104;
        int r106 = rotateLeft(((r102 + F(r105, r104, r101)) + this.X[2]) + 606105819, 17) + r105;
        int r107 = rotateLeft(((r101 + F(r106, r105, r104)) + this.X[3]) - 1044525330, 22) + r106;
        int r108 = rotateLeft(((r104 + F(r107, r106, r105)) + this.X[4]) - 176418897, 7) + r107;
        int r109 = rotateLeft(((r105 + F(r108, r107, r106)) + this.X[5]) + 1200080426, 12) + r108;
        int r110 = rotateLeft(((r106 + F(r109, r108, r107)) + this.X[6]) - 1473231341, 17) + r109;
        int r111 = rotateLeft(((r107 + F(r110, r109, r108)) + this.X[7]) - 45705983, 22) + r110;
        int r112 = rotateLeft(((r108 + F(r111, r110, r109)) + this.X[8]) + 1770035416, 7) + r111;
        int r113 = rotateLeft(((r109 + F(r112, r111, r110)) + this.X[9]) - 1958414417, 12) + r112;
        int r114 = rotateLeft(((r110 + F(r113, r112, r111)) + this.X[10]) - 42063, 17) + r113;
        int r115 = rotateLeft(((r111 + F(r114, r113, r112)) + this.X[11]) - 1990404162, 22) + r114;
        int r116 = rotateLeft(((r112 + F(r115, r114, r113)) + this.X[12]) + 1804603682, 7) + r115;
        int r117 = rotateLeft(((r113 + F(r116, r115, r114)) + this.X[13]) - 40341101, 12) + r116;
        int r118 = rotateLeft(((r114 + F(r117, r116, r115)) + this.X[14]) - 1502002290, 17) + r117;
        int r119 = rotateLeft(((r115 + F(r118, r117, r116)) + this.X[15]) + 1236535329, 22) + r118;
        int r120 = rotateLeft(((r116 + G(r119, r118, r117)) + this.X[1]) - 165796510, 5) + r119;
        int r121 = rotateLeft(((r117 + G(r120, r119, r118)) + this.X[6]) - 1069501632, 9) + r120;
        int r122 = rotateLeft(((r118 + G(r121, r120, r119)) + this.X[11]) + 643717713, 14) + r121;
        int r123 = rotateLeft(((r119 + G(r122, r121, r120)) + this.X[0]) - 373897302, 20) + r122;
        int r124 = rotateLeft(((r120 + G(r123, r122, r121)) + this.X[5]) - 701558691, 5) + r123;
        int r125 = rotateLeft(((r121 + G(r124, r123, r122)) + this.X[10]) + 38016083, 9) + r124;
        int r126 = rotateLeft(((r122 + G(r125, r124, r123)) + this.X[15]) - 660478335, 14) + r125;
        int r127 = rotateLeft(((r123 + G(r126, r125, r124)) + this.X[4]) - 405537848, 20) + r126;
        int r128 = rotateLeft(((r124 + G(r127, r126, r125)) + this.X[9]) + 568446438, 5) + r127;
        int r129 = rotateLeft(((r125 + G(r128, r127, r126)) + this.X[14]) - 1019803690, 9) + r128;
        int r130 = rotateLeft(((r126 + G(r129, r128, r127)) + this.X[3]) - 187363961, 14) + r129;
        int r131 = rotateLeft(((r127 + G(r130, r129, r128)) + this.X[8]) + 1163531501, 20) + r130;
        int r132 = rotateLeft(((r128 + G(r131, r130, r129)) + this.X[13]) - 1444681467, 5) + r131;
        int r133 = rotateLeft(((r129 + G(r132, r131, r130)) + this.X[2]) - 51403784, 9) + r132;
        int r134 = rotateLeft(((r130 + G(r133, r132, r131)) + this.X[7]) + 1735328473, 14) + r133;
        int r135 = rotateLeft(((r131 + G(r134, r133, r132)) + this.X[12]) - 1926607734, 20) + r134;
        int r136 = rotateLeft(((r132 + H(r135, r134, r133)) + this.X[5]) - 378558, 4) + r135;
        int r137 = rotateLeft(((r133 + H(r136, r135, r134)) + this.X[8]) - 2022574463, 11) + r136;
        int r138 = rotateLeft(((r134 + H(r137, r136, r135)) + this.X[11]) + 1839030562, 16) + r137;
        int r139 = rotateLeft(((r135 + H(r138, r137, r136)) + this.X[14]) - 35309556, 23) + r138;
        int r140 = rotateLeft(((r136 + H(r139, r138, r137)) + this.X[1]) - 1530992060, 4) + r139;
        int r141 = rotateLeft(((r137 + H(r140, r139, r138)) + this.X[4]) + 1272893353, 11) + r140;
        int r142 = rotateLeft(((r138 + H(r141, r140, r139)) + this.X[7]) - 155497632, 16) + r141;
        int r143 = rotateLeft(((r139 + H(r142, r141, r140)) + this.X[10]) - 1094730640, 23) + r142;
        int r144 = rotateLeft(((r140 + H(r143, r142, r141)) + this.X[13]) + 681279174, 4) + r143;
        int r145 = rotateLeft(((r141 + H(r144, r143, r142)) + this.X[0]) - 358537222, 11) + r144;
        int r146 = rotateLeft(((r142 + H(r145, r144, r143)) + this.X[3]) - 722521979, 16) + r145;
        int r147 = rotateLeft(((r143 + H(r146, r145, r144)) + this.X[6]) + 76029189, 23) + r146;
        int r148 = rotateLeft(((r144 + H(r147, r146, r145)) + this.X[9]) - 640364487, 4) + r147;
        int r149 = rotateLeft(((r145 + H(r148, r147, r146)) + this.X[12]) - 421815835, 11) + r148;
        int r150 = rotateLeft(((r146 + H(r149, r148, r147)) + this.X[15]) + 530742520, 16) + r149;
        int r151 = rotateLeft(((r147 + H(r150, r149, r148)) + this.X[2]) - 995338651, 23) + r150;
        int r152 = rotateLeft(((r148 + K(r151, r150, r149)) + this.X[0]) - 198630844, 6) + r151;
        int r153 = rotateLeft(((r149 + K(r152, r151, r150)) + this.X[7]) + 1126891415, 10) + r152;
        int r154 = rotateLeft(((r150 + K(r153, r152, r151)) + this.X[14]) - 1416354905, 15) + r153;
        int r155 = rotateLeft(((r151 + K(r154, r153, r152)) + this.X[5]) - 57434055, 21) + r154;
        int r156 = rotateLeft(((r152 + K(r155, r154, r153)) + this.X[12]) + 1700485571, 6) + r155;
        int r157 = rotateLeft(((r153 + K(r156, r155, r154)) + this.X[3]) - 1894986606, 10) + r156;
        int r158 = rotateLeft(((r154 + K(r157, r156, r155)) + this.X[10]) - 1051523, 15) + r157;
        int r159 = rotateLeft(((r155 + K(r158, r157, r156)) + this.X[1]) - 2054922799, 21) + r158;
        int r160 = rotateLeft(((r156 + K(r159, r158, r157)) + this.X[8]) + 1873313359, 6) + r159;
        int r161 = rotateLeft(((r157 + K(r160, r159, r158)) + this.X[15]) - 30611744, 10) + r160;
        int r162 = rotateLeft(((r158 + K(r161, r160, r159)) + this.X[6]) - 1560198380, 15) + r161;
        int r163 = rotateLeft(((r159 + K(r162, r161, r160)) + this.X[13]) + 1309151649, 21) + r162;
        int r164 = rotateLeft(((r160 + K(r163, r162, r161)) + this.X[4]) - 145523070, 6) + r163;
        int r165 = rotateLeft(((r161 + K(r164, r163, r162)) + this.X[11]) - 1120210379, 10) + r164;
        int r166 = rotateLeft(((r162 + K(r165, r164, r163)) + this.X[2]) + 718787259, 15) + r165;
        int r167 = rotateLeft(((r163 + K(r166, r165, r164)) + this.X[9]) - 343485551, 21) + r166;
        this.H1 += r164;
        this.H2 += r167;
        this.H3 += r166;
        this.H4 += r165;
        this.xOff = 0;
        int r168 = 0;
    L3:
        int[] r169 = this.X;
        if (r168 == r169.length) goto L6;
        r169[r168] = 0;
        r168 = r168 + 1;
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
        copyIn((MD5Digest) r100);
    }
}
