package org.bouncycastle.crypto.digests;

import kotlin.UByte;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SHA256Digest extends GeneralDigest implements EncodableDigest {
    private static final int DIGEST_LENGTH = 32;
    static final int[] K = null;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int H6;
    private int H7;
    private int H8;
    private int[] X;
    private int xOff;

    static {
        K = new int[]{1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    }

    public SHA256Digest() {
        this.X = new int[64];
        reset();
    }

    public SHA256Digest(SHA256Digest r100) {
        super(r100);
        this.X = new int[64];
        copyIn(r100);
    }

    public SHA256Digest(byte[] r100) {
        super(r100);
        this.X = new int[64];
        this.H1 = Pack.bigEndianToInt(r100, 16);
        this.H2 = Pack.bigEndianToInt(r100, 20);
        this.H3 = Pack.bigEndianToInt(r100, 24);
        this.H4 = Pack.bigEndianToInt(r100, 28);
        this.H5 = Pack.bigEndianToInt(r100, 32);
        this.H6 = Pack.bigEndianToInt(r100, 36);
        this.H7 = Pack.bigEndianToInt(r100, 40);
        this.H8 = Pack.bigEndianToInt(r100, 44);
        this.xOff = Pack.bigEndianToInt(r100, 48);
        int r101 = 0;
    L4:
        if (r101 == this.xOff) goto L6;
        this.X[r101] = Pack.bigEndianToInt(r100, (r101 * 4) + 52);
        r101 = r101 + 1;
        goto L4
    }

    private static int Ch(int r100, int r101, int r102) {
        int r103 = r101 & r100;
        return ((~r100) & r102) ^ r103;
    }

    private static int Maj(int r100, int r101, int r102) {
        int r103 = r100 & r101;
        return ((r100 ^ r101) & r102) | r103;
    }

    private static int Sum0(int r100) {
        int r101 = ((r100 >>> 2) | (r100 << 30)) ^ ((r100 >>> 13) | (r100 << 19));
        int r102 = r100 >>> 22;
        return ((r100 << 10) | r102) ^ r101;
    }

    private static int Sum1(int r100) {
        int r101 = ((r100 >>> 6) | (r100 << 26)) ^ ((r100 >>> 11) | (r100 << 21));
        int r102 = r100 >>> 25;
        return ((r100 << 7) | r102) ^ r101;
    }

    private static int Theta0(int r100) {
        int r101 = ((r100 >>> 7) | (r100 << 25)) ^ ((r100 >>> 18) | (r100 << 14));
        return (r100 >>> 3) ^ r101;
    }

    private static int Theta1(int r100) {
        int r101 = ((r100 >>> 17) | (r100 << 15)) ^ ((r100 >>> 19) | (r100 << 13));
        return (r100 >>> 10) ^ r101;
    }

    private void copyIn(SHA256Digest r100) {
        super.copyIn(r100);
        this.H1 = r100.H1;
        this.H2 = r100.H2;
        this.H3 = r100.H3;
        this.H4 = r100.H4;
        this.H5 = r100.H5;
        this.H6 = r100.H6;
        this.H7 = r100.H7;
        this.H8 = r100.H8;
        int[] r101 = r100.X;
        System.arraycopy(r101, 0, this.X, 0, r101.length);
        this.xOff = r100.xOff;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA256Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        Pack.intToBigEndian(this.H1, r100, r101);
        Pack.intToBigEndian(this.H2, r100, r101 + 4);
        Pack.intToBigEndian(this.H3, r100, r101 + 8);
        Pack.intToBigEndian(this.H4, r100, r101 + 12);
        Pack.intToBigEndian(this.H5, r100, r101 + 16);
        Pack.intToBigEndian(this.H6, r100, r101 + 20);
        Pack.intToBigEndian(this.H7, r100, r101 + 24);
        Pack.intToBigEndian(this.H8, r100, r101 + 28);
        reset();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-256";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] r100 = new byte[(this.xOff * 4) + 52];
        super.populateState(r100);
        Pack.intToBigEndian(this.H1, r100, 16);
        Pack.intToBigEndian(this.H2, r100, 20);
        Pack.intToBigEndian(this.H3, r100, 24);
        Pack.intToBigEndian(this.H4, r100, 28);
        Pack.intToBigEndian(this.H5, r100, 32);
        Pack.intToBigEndian(this.H6, r100, 36);
        Pack.intToBigEndian(this.H7, r100, 40);
        Pack.intToBigEndian(this.H8, r100, 44);
        Pack.intToBigEndian(this.xOff, r100, 48);
        int r101 = 0;
    L4:
        if (r101 == this.xOff) goto L6;
        Pack.intToBigEndian(this.X[r101], r100, (r101 * 4) + 52);
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int r100 = 16;
    L4:
        if (r100 > 63) goto L6;
        int[] r101 = this.X;
        int r102 = Theta1(r101[r100 - 2]);
        int[] r103 = this.X;
        r101[r100] = ((r102 + r103[r100 - 7]) + Theta0(r103[r100 - 15])) + this.X[r100 - 16];
        r100 = r100 + 1;
        goto L4
    L6:
        int r104 = this.H1;
        int r105 = this.H2;
        int r106 = this.H3;
        int r107 = this.H4;
        int r108 = this.H5;
        int r109 = this.H6;
        int r110 = this.H7;
        int r111 = this.H8;
        int r112 = 0;
        int r113 = 0;
    L8:
        if (r112 >= 8) goto L10;
        int r114 = Sum1(r108) + Ch(r108, r109, r110);
        int[] r115 = K;
        int r116 = r111 + ((r114 + r115[r113]) + this.X[r113]);
        int r117 = r107 + r116;
        int r118 = r116 + (Sum0(r104) + Maj(r104, r105, r106));
        int r119 = r113 + 1;
        int r120 = r110 + (((Sum1(r117) + Ch(r117, r108, r109)) + r115[r119]) + this.X[r119]);
        int r121 = r106 + r120;
        int r122 = r120 + (Sum0(r118) + Maj(r118, r104, r105));
        int r123 = r119 + 1;
        int r124 = r109 + (((Sum1(r121) + Ch(r121, r117, r108)) + r115[r123]) + this.X[r123]);
        int r125 = r105 + r124;
        int r126 = r124 + (Sum0(r122) + Maj(r122, r118, r104));
        int r127 = r123 + 1;
        int r128 = r108 + (((Sum1(r125) + Ch(r125, r121, r117)) + r115[r127]) + this.X[r127]);
        int r129 = r104 + r128;
        int r130 = r128 + (Sum0(r126) + Maj(r126, r122, r118));
        int r131 = r127 + 1;
        int r132 = r117 + (((Sum1(r129) + Ch(r129, r125, r121)) + r115[r131]) + this.X[r131]);
        r111 = r118 + r132;
        r107 = r132 + (Sum0(r130) + Maj(r130, r126, r122));
        int r133 = r131 + 1;
        int r134 = r121 + (((Sum1(r111) + Ch(r111, r129, r125)) + r115[r133]) + this.X[r133]);
        r110 = r122 + r134;
        r106 = r134 + (Sum0(r107) + Maj(r107, r130, r126));
        int r135 = r133 + 1;
        int r136 = r125 + (((Sum1(r110) + Ch(r110, r111, r129)) + r115[r135]) + this.X[r135]);
        r109 = r126 + r136;
        r105 = r136 + (Sum0(r106) + Maj(r106, r107, r130));
        int r137 = r135 + 1;
        int r138 = r129 + (((Sum1(r109) + Ch(r109, r110, r111)) + r115[r137]) + this.X[r137]);
        r108 = r130 + r138;
        r104 = r138 + (Sum0(r105) + Maj(r105, r106, r107));
        r113 = r137 + 1;
        r112 = r112 + 1;
        goto L8
    L10:
        this.H1 += r104;
        this.H2 += r105;
        this.H3 += r106;
        this.H4 += r107;
        this.H5 += r108;
        this.H6 += r109;
        this.H7 += r110;
        this.H8 += r111;
        this.xOff = 0;
        int r139 = 0;
    L11:
        if (r139 >= 16) goto L13;
        this.X[r139] = 0;
        r139 = r139 + 1;
        goto L11
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long r100) {
        if (this.xOff <= 14) goto L5;
        processBlock();
    L5:
        int[] r101 = this.X;
        r101[14] = (int) (r100 >>> 32);
        r101[15] = (int) (r100 & (-1));
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
        this.H1 = 1779033703;
        this.H2 = -1150833019;
        this.H3 = 1013904242;
        this.H4 = -1521486534;
        this.H5 = 1359893119;
        this.H6 = -1694144372;
        this.H7 = 528734635;
        this.H8 = 1541459225;
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
        copyIn((SHA256Digest) r100);
    }
}
