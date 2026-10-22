package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.Xof;

/* JADX INFO: loaded from: classes42.dex */
public class SHAKEDigest extends KeccakDigest implements Xof {
    public SHAKEDigest() {
        this(128);
    }

    public SHAKEDigest(int r100) {
        super(checkBitLength(r100));
    }

    public SHAKEDigest(SHAKEDigest r100) {
        super(r100);
    }

    private static int checkBitLength(int r100) {
        if (r100 != 128) goto L5;
    L9:
        return r100;
    L5:
        if (r100 == 256) goto L9;
        throw new IllegalArgumentException("'bitLength' " + r100 + " not supported for SHAKE");
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        return doFinal(r100, r101, getDigestSize());
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest
    public int doFinal(byte[] r100, int r101, byte r102, int r110) {
        return doFinal(r100, r101, getDigestSize(), r102, r110);
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] r100, int r101, int r102) {
        int r103 = doOutput(r100, r101, r102);
        reset();
        return r103;
    }

    public int doFinal(byte[] r100, int r101, int r102, byte r103, int r104) {
        if (r104 < 0) goto L13;
        if (r104 > 7) goto L13;
        int r105 = (r103 & ((1 << r104) - 1)) | (15 << r104);
        int r106 = r104 + 4;
        if (r106 < 8) goto L8;
        absorb((byte) r105);
        r106 = r106 - 8;
        r105 = r105 >>> 8;
    L8:
        if (r106 <= 0) goto L10;
        absorbBits(r105, r106);
    L10:
        squeeze(r100, r101, ((long) r102) * 8);
        reset();
        return r102;
    L13:
        throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
    }

    public int doOutput(byte[] r100, int r101, int r102) {
        if (this.squeezing == true) goto L5;
        absorbBits(15, 4);
    L5:
        squeeze(r100, r101, ((long) r102) * 8);
        return r102;
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHAKE" + this.fixedOutputLength;
    }
}
