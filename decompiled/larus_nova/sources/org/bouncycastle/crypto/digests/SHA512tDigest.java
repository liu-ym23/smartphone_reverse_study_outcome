package org.bouncycastle.crypto.digests;

import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.MemoableResetException;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SHA512tDigest extends LongDigest {
    private long H1t;
    private long H2t;
    private long H3t;
    private long H4t;
    private long H5t;
    private long H6t;
    private long H7t;
    private long H8t;
    private int digestLength;

    public SHA512tDigest(int r100) {
        if (r100 >= 512) goto L15;
        if ((r100 % 8) != 0) goto L13;
        if (r100 == 384) goto L11;
        int r101 = r100 / 8;
        this.digestLength = r101;
        tIvGenerate(r101 * 8);
        reset();
        return;
    L11:
        throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
    L13:
        throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
    L15:
        throw new IllegalArgumentException("bitLength cannot be >= 512");
    }

    public SHA512tDigest(SHA512tDigest r100) {
        super(r100);
        this.digestLength = r100.digestLength;
        reset(r100);
    }

    public SHA512tDigest(byte[] r100) {
        this(readDigestLength(r100));
        restoreState(r100);
    }

    private static void intToBigEndian(int r100, byte[] r101, int r102, int r103) {
        int r104 = Math.min(4, r103);
    L3:
        r104 = r104 - 1;
        if (r104 < 0) goto L6;
        r101[r102 + r104] = (byte) (r100 >>> ((3 - r104) * 8));
        goto L3
    }

    private static void longToBigEndian(long r100, byte[] r101, int r102, int r103) {
        if (r103 <= 0) goto L7;
        intToBigEndian((int) (r100 >>> 32), r101, r102, r103);
        if (r103 <= 4) goto L8;
        intToBigEndian((int) (r100 & BodyPartID.bodyIdMax), r101, r102 + 4, r103 - 4);
        return;
    L8:
        return;
    }

    private static int readDigestLength(byte[] r100) {
        return Pack.bigEndianToInt(r100, r100.length - 4);
    }

    private void tIvGenerate(int r100) {
        this.H1 = -3482333909917012819L;
        this.H2 = 2216346199247487646L;
        this.H3 = -7364697282686394994L;
        this.H4 = 65953792586715988L;
        this.H5 = -816286391624063116L;
        this.H6 = 4512832404995164602L;
        this.H7 = -5033199132376557362L;
        this.H8 = -124578254951840548L;
        update((byte) 83);
        update((byte) 72);
        update((byte) 65);
        update((byte) 45);
        update((byte) 53);
        update((byte) 49);
        update((byte) 50);
        update((byte) 47);
        if (r100 <= 100) goto L7;
        update((byte) ((r100 / 100) + 48));
        r100 = r100 % 100;
    L5:
        update((byte) ((r100 / 10) + 48));
        r100 = r100 % 10;
    L6:
        update((byte) (r100 + 48));
        finish();
        this.H1t = this.H1;
        this.H2t = this.H2;
        this.H3t = this.H3;
        this.H4t = this.H4;
        this.H5t = this.H5;
        this.H6t = this.H6;
        this.H7t = this.H7;
        this.H8t = this.H8;
        return;
    L7:
        if (r100 <= 10) goto L6;
        goto L6
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA512tDigest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        longToBigEndian(this.H1, r100, r101, this.digestLength);
        longToBigEndian(this.H2, r100, r101 + 8, this.digestLength - 8);
        longToBigEndian(this.H3, r100, r101 + 16, this.digestLength - 16);
        longToBigEndian(this.H4, r100, r101 + 24, this.digestLength - 24);
        longToBigEndian(this.H5, r100, r101 + 32, this.digestLength - 32);
        longToBigEndian(this.H6, r100, r101 + 40, this.digestLength - 40);
        longToBigEndian(this.H7, r100, r101 + 48, this.digestLength - 48);
        longToBigEndian(this.H8, r100, r101 + 56, this.digestLength - 56);
        reset();
        return this.digestLength;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-512/" + Integer.toString(this.digestLength * 8);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        int r100 = getEncodedStateSize();
        byte[] r101 = new byte[r100 + 4];
        populateState(r101);
        Pack.intToBigEndian(this.digestLength * 8, r101, r100);
        return r101;
    }

    @Override // org.bouncycastle.crypto.digests.LongDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = this.H1t;
        this.H2 = this.H2t;
        this.H3 = this.H3t;
        this.H4 = this.H4t;
        this.H5 = this.H5t;
        this.H6 = this.H6t;
        this.H7 = this.H7t;
        this.H8 = this.H8t;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        SHA512tDigest r101 = (SHA512tDigest) r100;
        if (this.digestLength != r101.digestLength) goto L7;
        super.copyIn(r101);
        this.H1t = r101.H1t;
        this.H2t = r101.H2t;
        this.H3t = r101.H3t;
        this.H4t = r101.H4t;
        this.H5t = r101.H5t;
        this.H6t = r101.H6t;
        this.H7t = r101.H7t;
        this.H8t = r101.H8t;
        return;
    L7:
        throw new MemoableResetException("digestLength inappropriate in other");
    }
}
