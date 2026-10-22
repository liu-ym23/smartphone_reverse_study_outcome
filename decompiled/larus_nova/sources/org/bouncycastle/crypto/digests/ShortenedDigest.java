package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;

/* JADX INFO: loaded from: classes42.dex */
public class ShortenedDigest implements ExtendedDigest {
    private ExtendedDigest baseDigest;
    private int length;

    public ShortenedDigest(ExtendedDigest r100, int r101) {
        if (r100 == null) goto L11;
        if (r101 > r100.getDigestSize()) goto L9;
        this.baseDigest = r100;
        this.length = r101;
        return;
    L9:
        throw new IllegalArgumentException("baseDigest output not large enough to support length");
    L11:
        throw new IllegalArgumentException("baseDigest must not be null");
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        byte[] r102 = new byte[this.baseDigest.getDigestSize()];
        this.baseDigest.doFinal(r102, 0);
        System.arraycopy(r102, 0, r100, r101, this.length);
        return this.length;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return this.baseDigest.getAlgorithmName() + "(" + (this.length * 8) + ")";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.baseDigest.getByteLength();
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.length;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.baseDigest.reset();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        this.baseDigest.update(r100);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
        this.baseDigest.update(r100, r101, r102);
    }
}
