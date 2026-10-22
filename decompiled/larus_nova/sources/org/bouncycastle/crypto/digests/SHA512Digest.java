package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SHA512Digest extends LongDigest {
    private static final int DIGEST_LENGTH = 64;

    public SHA512Digest() {
    }

    public SHA512Digest(SHA512Digest r100) {
        super(r100);
    }

    public SHA512Digest(byte[] r100) {
        restoreState(r100);
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA512Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        finish();
        Pack.longToBigEndian(this.H1, r100, r101);
        Pack.longToBigEndian(this.H2, r100, r101 + 8);
        Pack.longToBigEndian(this.H3, r100, r101 + 16);
        Pack.longToBigEndian(this.H4, r100, r101 + 24);
        Pack.longToBigEndian(this.H5, r100, r101 + 32);
        Pack.longToBigEndian(this.H6, r100, r101 + 40);
        Pack.longToBigEndian(this.H7, r100, r101 + 48);
        Pack.longToBigEndian(this.H8, r100, r101 + 56);
        reset();
        return 64;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-512";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest
    public byte[] getEncodedState() {
        byte[] r100 = new byte[getEncodedStateSize()];
        super.populateState(r100);
        return r100;
    }

    @Override // org.bouncycastle.crypto.digests.LongDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = 7640891576956012808L;
        this.H2 = -4942790177534073029L;
        this.H3 = 4354685564936845355L;
        this.H4 = -6534734903238641935L;
        this.H5 = 5840696475078001361L;
        this.H6 = -7276294671716946913L;
        this.H7 = 2270897969802886507L;
        this.H8 = 6620516959819538809L;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        copyIn((SHA512Digest) r100);
    }
}
