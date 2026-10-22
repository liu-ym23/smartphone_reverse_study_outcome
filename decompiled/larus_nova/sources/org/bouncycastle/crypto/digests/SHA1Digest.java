package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SHA1Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 20;
    private static final int Y1 = 1518500249;
    private static final int Y2 = 1859775393;
    private static final int Y3 = -1894007588;
    private static final int Y4 = -899497514;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int[] X;
    private int xOff;

    public SHA1Digest() {
        this.X = new int[80];
        reset();
    }

    public SHA1Digest(SHA1Digest r100) {
        super(r100);
        this.X = new int[80];
        copyIn(r100);
    }

    public SHA1Digest(byte[] r100) {
        super(r100);
        this.X = new int[80];
        this.H1 = Pack.bigEndianToInt(r100, 16);
        this.H2 = Pack.bigEndianToInt(r100, 20);
        this.H3 = Pack.bigEndianToInt(r100, 24);
        this.H4 = Pack.bigEndianToInt(r100, 28);
        this.H5 = Pack.bigEndianToInt(r100, 32);
        this.xOff = Pack.bigEndianToInt(r100, 36);
        int r101 = 0;
    L4:
        if (r101 == this.xOff) goto L6;
        this.X[r101] = Pack.bigEndianToInt(r100, (r101 * 4) + 40);
        r101 = r101 + 1;
        goto L4
    }

    private void copyIn(SHA1Digest r100) {
        this.H1 = r100.H1;
        this.H2 = r100.H2;
        this.H3 = r100.H3;
        this.H4 = r100.H4;
        this.H5 = r100.H5;
        int[] r101 = r100.X;
        System.arraycopy(r101, 0, this.X, 0, r101.length);
        this.xOff = r100.xOff;
    }

    private int f(int r100, int r101, int r102) {
        int r103 = r101 & r100;
        return ((~r100) & r102) | r103;
    }

    private int g(int r100, int r101, int r102) {
        int r103 = r100 & r101;
        return ((r100 & r102) | r103) | (r101 & r102);
    }

    private int h(int r100, int r101, int r102) {
        return (r100 ^ r101) ^ r102;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA1Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        Pack.intToBigEndian(this.H1, r100, r101);
        Pack.intToBigEndian(this.H2, r100, r101 + 4);
        Pack.intToBigEndian(this.H3, r100, r101 + 8);
        Pack.intToBigEndian(this.H4, r100, r101 + 12);
        Pack.intToBigEndian(this.H5, r100, r101 + 16);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] r100 = new byte[(this.xOff * 4) + 40];
        super.populateState(r100);
        Pack.intToBigEndian(this.H1, r100, 16);
        Pack.intToBigEndian(this.H2, r100, 20);
        Pack.intToBigEndian(this.H3, r100, 24);
        Pack.intToBigEndian(this.H4, r100, 28);
        Pack.intToBigEndian(this.H5, r100, 32);
        Pack.intToBigEndian(this.xOff, r100, 36);
        int r101 = 0;
    L4:
        if (r101 == this.xOff) goto L6;
        Pack.intToBigEndian(this.X[r101], r100, (r101 * 4) + 40);
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r100 = 16;
    L4:
        if (r100 >= 80) goto L6;
        int[] r101 = this.X;
        int r102 = ((r101[r100 - 3] ^ r101[r100 - 8]) ^ r101[r100 - 14]) ^ r101[r100 - 16];
        r101[r100] = (r102 >>> 31) | (r102 << 1);
        r100 = r100 + 1;
        goto L4
    L6:
        int r103 = this.H1;
        int r104 = this.H2;
        int r105 = this.H3;
        int r106 = this.H4;
        int r107 = this.H5;
        int r108 = 0;
        int r109 = 0;
    L8:
        if (r108 >= 4) goto L10;
        int r110 = r109 + 1;
        int r111 = r107 + (((((r103 << 5) | (r103 >>> 27)) + f(r104, r105, r106)) + this.X[r109]) + Y1);
        int r112 = (r104 >>> 2) | (r104 << 30);
        int r113 = r110 + 1;
        int r114 = r106 + (((((r111 << 5) | (r111 >>> 27)) + f(r103, r112, r105)) + this.X[r110]) + Y1);
        int r115 = (r103 >>> 2) | (r103 << 30);
        int r116 = r113 + 1;
        int r117 = r105 + (((((r114 << 5) | (r114 >>> 27)) + f(r111, r115, r112)) + this.X[r113]) + Y1);
        r107 = (r111 >>> 2) | (r111 << 30);
        int r118 = r116 + 1;
        r104 = r112 + (((((r117 << 5) | (r117 >>> 27)) + f(r114, r107, r115)) + this.X[r116]) + Y1);
        r106 = (r114 >>> 2) | (r114 << 30);
        r103 = r115 + (((((r104 << 5) | (r104 >>> 27)) + f(r117, r106, r107)) + this.X[r118]) + Y1);
        r105 = (r117 >>> 2) | (r117 << 30);
        r108 = r108 + 1;
        r109 = r118 + 1;
        goto L8
    L10:
        int r119 = 0;
    L11:
        if (r119 >= 4) goto L13;
        int r120 = r109 + 1;
        int r121 = r107 + (((((r103 << 5) | (r103 >>> 27)) + h(r104, r105, r106)) + this.X[r109]) + Y2);
        int r122 = (r104 >>> 2) | (r104 << 30);
        int r123 = r120 + 1;
        int r124 = r106 + (((((r121 << 5) | (r121 >>> 27)) + h(r103, r122, r105)) + this.X[r120]) + Y2);
        int r125 = (r103 >>> 2) | (r103 << 30);
        int r126 = r123 + 1;
        int r127 = r105 + (((((r124 << 5) | (r124 >>> 27)) + h(r121, r125, r122)) + this.X[r123]) + Y2);
        r107 = (r121 >>> 2) | (r121 << 30);
        int r128 = r126 + 1;
        r104 = r122 + (((((r127 << 5) | (r127 >>> 27)) + h(r124, r107, r125)) + this.X[r126]) + Y2);
        r106 = (r124 >>> 2) | (r124 << 30);
        r103 = r125 + (((((r104 << 5) | (r104 >>> 27)) + h(r127, r106, r107)) + this.X[r128]) + Y2);
        r105 = (r127 >>> 2) | (r127 << 30);
        r119 = r119 + 1;
        r109 = r128 + 1;
        goto L11
    L13:
        int r129 = 0;
    L14:
        if (r129 >= 4) goto L16;
        int r130 = r109 + 1;
        int r131 = r107 + (((((r103 << 5) | (r103 >>> 27)) + g(r104, r105, r106)) + this.X[r109]) + Y3);
        int r132 = (r104 >>> 2) | (r104 << 30);
        int r133 = r130 + 1;
        int r134 = r106 + (((((r131 << 5) | (r131 >>> 27)) + g(r103, r132, r105)) + this.X[r130]) + Y3);
        int r135 = (r103 >>> 2) | (r103 << 30);
        int r136 = r133 + 1;
        int r137 = r105 + (((((r134 << 5) | (r134 >>> 27)) + g(r131, r135, r132)) + this.X[r133]) + Y3);
        r107 = (r131 >>> 2) | (r131 << 30);
        int r138 = r136 + 1;
        r104 = r132 + (((((r137 << 5) | (r137 >>> 27)) + g(r134, r107, r135)) + this.X[r136]) + Y3);
        r106 = (r134 >>> 2) | (r134 << 30);
        r103 = r135 + (((((r104 << 5) | (r104 >>> 27)) + g(r137, r106, r107)) + this.X[r138]) + Y3);
        r105 = (r137 >>> 2) | (r137 << 30);
        r129 = r129 + 1;
        r109 = r138 + 1;
        goto L14
    L16:
        int r139 = 0;
    L18:
        if (r139 > 3) goto L20;
        int r140 = r109 + 1;
        int r141 = r107 + (((((r103 << 5) | (r103 >>> 27)) + h(r104, r105, r106)) + this.X[r109]) + Y4);
        int r142 = (r104 >>> 2) | (r104 << 30);
        int r143 = r140 + 1;
        int r144 = r106 + (((((r141 << 5) | (r141 >>> 27)) + h(r103, r142, r105)) + this.X[r140]) + Y4);
        int r145 = (r103 >>> 2) | (r103 << 30);
        int r146 = r143 + 1;
        int r147 = r105 + (((((r144 << 5) | (r144 >>> 27)) + h(r141, r145, r142)) + this.X[r143]) + Y4);
        r107 = (r141 >>> 2) | (r141 << 30);
        int r148 = r146 + 1;
        r104 = r142 + (((((r147 << 5) | (r147 >>> 27)) + h(r144, r107, r145)) + this.X[r146]) + Y4);
        r106 = (r144 >>> 2) | (r144 << 30);
        r103 = r145 + (((((r104 << 5) | (r104 >>> 27)) + h(r147, r106, r107)) + this.X[r148]) + Y4);
        r105 = (r147 >>> 2) | (r147 << 30);
        r139 = r139 + 1;
        r109 = r148 + 1;
        goto L18
    L20:
        this.H1 += r103;
        this.H2 += r104;
        this.H3 += r105;
        this.H4 += r106;
        this.H5 += r107;
        this.xOff = 0;
        int r149 = 0;
    L21:
        if (r149 >= 16) goto L23;
        this.X[r149] = 0;
        r149 = r149 + 1;
        goto L21
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long r100) {
        if (this.xOff <= 14) goto L5;
        processBlock();
    L5:
        int[] r101 = this.X;
        r101[14] = (int) (r100 >>> 32);
        r101[15] = (int) r100;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] r100, int r101) {
        int r102 = r100[r101] << 24;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 16);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r105] & UByte.MAX_VALUE) << 8);
        int r107 = (r100[r105 + 1] & UByte.MAX_VALUE) | r106;
        int[] r108 = this.X;
        int r109 = this.xOff;
        r108[r109] = r107;
        int r110 = r109 + 1;
        this.xOff = r110;
        if (r110 != 16) goto L6;
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
        this.H5 = -1009589776;
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
        SHA1Digest r101 = (SHA1Digest) r100;
        super.copyIn(r101);
        copyIn(r101);
    }
}
