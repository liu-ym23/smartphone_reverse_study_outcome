package org.bouncycastle.crypto.digests;

/* JADX INFO: loaded from: classes42.dex */
public class SHA3Digest extends KeccakDigest {
    public SHA3Digest() {
        this(256);
    }

    public SHA3Digest(int r100) {
        super(checkBitLength(r100));
    }

    public SHA3Digest(SHA3Digest r100) {
        super(r100);
    }

    private static int checkBitLength(int r100) {
        if (r100 != 224) goto L5;
    L13:
        return r100;
    L5:
        if (r100 == 256) goto L13;
        if (r100 == 384) goto L13;
        if (r100 == 512) goto L13;
        throw new IllegalArgumentException("'bitLength' " + r100 + " not supported for SHA-3");
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        absorbBits(2, 2);
        return super.doFinal(r100, r101);
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest
    public int doFinal(byte[] r100, int r101, byte r102, int r103) {
        if (r103 < 0) goto L11;
        if (r103 > 7) goto L11;
        int r104 = (r102 & ((1 << r103) - 1)) | (2 << r103);
        int r105 = r103 + 2;
        if (r105 < 8) goto L9;
        absorb((byte) r104);
        r105 = r105 - 8;
        r104 = r104 >>> 8;
    L9:
        return super.doFinal(r100, r101, (byte) r104, r105);
    L11:
        throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA3-" + this.fixedOutputLength;
    }
}
