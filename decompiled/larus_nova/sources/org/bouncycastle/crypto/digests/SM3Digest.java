package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SM3Digest extends GeneralDigest {
    private static final int BLOCK_SIZE = 16;
    private static final int DIGEST_LENGTH = 32;
    private static final int[] T = null;
    private int[] V;
    private int[] W;
    private int[] inwords;
    private int xOff;

    static {
        T = new int[64];
        int r100 = 0;
    L3:
        int r101 = 16;
        if (r100 >= 16) goto L6;
        int r102 = 2043430169 >>> (32 - r100);
        T[r100] = r102 | (2043430169 << r100);
        r100 = r100 + 1;
    L6:
        if (r101 >= 64) goto L8;
        int r103 = r101 % 32;
        int r104 = 2055708042 << r103;
        T[r101] = (2055708042 >>> (32 - r103)) | r104;
        r101 = r101 + 1;
        goto L6
    }

    public SM3Digest() {
        this.V = new int[8];
        this.inwords = new int[16];
        this.W = new int[68];
        reset();
    }

    public SM3Digest(SM3Digest r100) {
        super(r100);
        this.V = new int[8];
        this.inwords = new int[16];
        this.W = new int[68];
        copyIn(r100);
    }

    private int FF0(int r100, int r101, int r102) {
        return (r100 ^ r101) ^ r102;
    }

    private int FF1(int r100, int r101, int r102) {
        int r103 = r100 & r101;
        return ((r100 & r102) | r103) | (r101 & r102);
    }

    private int GG0(int r100, int r101, int r102) {
        return (r100 ^ r101) ^ r102;
    }

    private int GG1(int r100, int r101, int r102) {
        int r103 = r101 & r100;
        return ((~r100) & r102) | r103;
    }

    private int P0(int r100) {
        int r101 = (r100 << 9) | (r100 >>> 23);
        int r102 = (r100 << 17) | (r100 >>> 15);
        return (r100 ^ r101) ^ r102;
    }

    private int P1(int r100) {
        int r101 = (r100 << 15) | (r100 >>> 17);
        int r102 = (r100 << 23) | (r100 >>> 9);
        return (r100 ^ r101) ^ r102;
    }

    private void copyIn(SM3Digest r100) {
        int[] r101 = r100.V;
        int[] r102 = this.V;
        System.arraycopy(r101, 0, r102, 0, r102.length);
        int[] r103 = r100.inwords;
        int[] r104 = this.inwords;
        System.arraycopy(r103, 0, r104, 0, r104.length);
        this.xOff = r100.xOff;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SM3Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        Pack.intToBigEndian(this.V, r100, r101);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SM3";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r100 = 0;
    L3:
        int r101 = 16;
        if (r100 >= 16) goto L6;
        this.W[r100] = this.inwords[r100];
        r100 = r100 + 1;
        goto L3
    L6:
        int r102 = 16;
    L8:
        if (r102 >= 68) goto L10;
        int[] r103 = this.W;
        int r104 = r103[r102 - 3];
        int r105 = (r104 >>> 17) | (r104 << 15);
        int r106 = r103[r102 - 13];
        r103[r102] = (P1(r105 ^ (r103[r102 - 16] ^ r103[r102 - 9])) ^ ((r106 >>> 25) | (r106 << 7))) ^ this.W[r102 - 6];
        r102 = r102 + 1;
        goto L8
    L10:
        int[] r107 = this.V;
        int r108 = r107[0];
        int r109 = r107[1];
        int r110 = r107[2];
        int r111 = r107[3];
        int r112 = r107[4];
        int r113 = r107[5];
        int r114 = r107[6];
        int r115 = r107[7];
        int r116 = r114;
        int r117 = 0;
    L11:
        if (r117 >= r101) goto L13;
        int r118 = (r108 << 12) | (r108 >>> 20);
        int r119 = (r118 + r112) + T[r117];
        int r120 = (r119 << 7) | (r119 >>> 25);
        int[] r121 = this.W;
        int r210 = r121[r117];
        int r122 = r210 ^ r121[r117 + 4];
        int r211 = FF0(r108, r109, r110) + r111;
        int r123 = ((GG0(r112, r113, r116) + r115) + r120) + r210;
        int r124 = (r109 << 9) | (r109 >>> 23);
        int r125 = (r113 << 19) | (r113 >>> 13);
        r117 = r117 + 1;
        r113 = r112;
        r112 = P0(r123);
        r111 = r110;
        r110 = r124;
        r115 = r116;
        r116 = r125;
        r109 = r108;
        r108 = (r211 + (r120 ^ r118)) + r122;
        r101 = 16;
        goto L11
    L13:
        int r126 = r115;
        int r127 = r112;
        int r128 = r116;
        int r129 = r111;
        int r130 = r110;
        int r131 = r109;
        int r132 = r108;
        int r133 = 16;
    L15:
        if (r133 >= 64) goto L17;
        int r134 = (r132 << 12) | (r132 >>> 20);
        int r135 = (r134 + r127) + T[r133];
        int r136 = (r135 << 7) | (r135 >>> 25);
        int[] r137 = this.W;
        int r212 = r137[r133];
        int r138 = r212 ^ r137[r133 + 4];
        int r213 = FF1(r132, r131, r130) + r129;
        int r139 = ((GG1(r127, r113, r128) + r126) + r136) + r212;
        int r140 = (r131 >>> 23) | (r131 << 9);
        int r141 = (r113 << 19) | (r113 >>> 13);
        r133 = r133 + 1;
        r113 = r127;
        r127 = P0(r139);
        r129 = r130;
        r130 = r140;
        r131 = r132;
        r132 = (r213 + (r136 ^ r134)) + r138;
        r126 = r128;
        r128 = r141;
        goto L15
    L17:
        int[] r142 = this.V;
        r142[0] = r132 ^ r142[0];
        r142[1] = r142[1] ^ r131;
        r142[2] = r142[2] ^ r130;
        r142[3] = r142[3] ^ r129;
        r142[4] = r142[4] ^ r127;
        r142[5] = r142[5] ^ r113;
        r142[6] = r128 ^ r142[6];
        r142[7] = r142[7] ^ r126;
        this.xOff = 0;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long r100) {
        int r101 = this.xOff;
        if (r101 <= 14) goto L5;
        this.inwords[r101] = 0;
        this.xOff = r101 + 1;
        processBlock();
    L5:
        int r102 = this.xOff;
        if (r102 >= 14) goto L8;
        this.inwords[r102] = 0;
        this.xOff = r102 + 1;
        goto L5
    L8:
        int[] r103 = this.inwords;
        int r104 = r102 + 1;
        r103[r102] = (int) (r100 >>> 32);
        this.xOff = r104 + 1;
        r103[r104] = (int) r100;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] r100, int r101) {
        int r102 = (r100[r101] & UByte.MAX_VALUE) << 24;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 16);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r105] & UByte.MAX_VALUE) << 8);
        int r107 = (r100[r105 + 1] & UByte.MAX_VALUE) | r106;
        int[] r108 = this.inwords;
        int r109 = this.xOff;
        r108[r109] = r107;
        int r110 = r109 + 1;
        this.xOff = r110;
        if (r110 < 16) goto L6;
        processBlock();
        return;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        int[] r100 = this.V;
        r100[0] = 1937774191;
        r100[1] = 1226093241;
        r100[2] = 388252375;
        r100[3] = -628488704;
        r100[4] = -1452330820;
        r100[5] = 372324522;
        r100[6] = -477237683;
        r100[7] = -1325724082;
        this.xOff = 0;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        SM3Digest r101 = (SM3Digest) r100;
        super.copyIn(r101);
        copyIn(r101);
    }
}
