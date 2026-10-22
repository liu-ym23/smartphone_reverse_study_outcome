package org.bouncycastle.crypto.digests;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class CSHAKEDigest extends SHAKEDigest {
    private static final byte[] padding = null;
    private final byte[] diff;

    static {
        padding = new byte[100];
    }

    public CSHAKEDigest(int r100, byte[] r101, byte[] r102) {
        super(r100);
        if (r101 != null) goto L5;
    L6:
        if (r102 != null) goto L8;
    L11:
        this.diff = null;
        return;
    L8:
        if (r102.length == 0) goto L11;
    L10:
        this.diff = Arrays.concatenate(XofUtils.leftEncode(this.rate / 8), encodeString(r101), encodeString(r102));
        diffPadAndAbsorb();
        return;
    L5:
        if (r101.length != 0) goto L10;
        goto L6
    }

    private void diffPadAndAbsorb() {
        int r100 = this.rate / 8;
        byte[] r101 = this.diff;
        absorb(r101, 0, r101.length);
        int r102 = this.diff.length % r100;
        if (r102 == 0) goto L10;
    L4:
        r100 = r100 - r102;
        byte[] r103 = padding;
        if (r100 <= r103.length) goto L7;
        absorb(r103, 0, r103.length);
        r102 = r103.length;
        goto L4
    L7:
        absorb(r103, 0, r100);
        return;
    }

    private byte[] encodeString(byte[] r100) {
        if (r100 == null) goto L9;
        if (r100.length == 0) goto L9;
        return Arrays.concatenate(XofUtils.leftEncode(((long) r100.length) * 8), r100);
    L9:
        return XofUtils.leftEncode(0);
    }

    @Override // org.bouncycastle.crypto.digests.SHAKEDigest, org.bouncycastle.crypto.Xof
    public int doOutput(byte[] r100, int r101, int r102) {
        if (this.diff == null) goto L10;
        if (this.squeezing == true) goto L7;
        absorbBits(0, 2);
    L7:
        squeeze(r100, r101, ((long) r102) * 8);
        return r102;
    L10:
        return super.doOutput(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.digests.SHAKEDigest, org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "CSHAKE" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.crypto.digests.KeccakDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        if (this.diff == null) goto L6;
        diffPadAndAbsorb();
        return;
    }
}
