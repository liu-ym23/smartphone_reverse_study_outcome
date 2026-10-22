package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
class LMOtsPrivateKey {
    private final byte[] I;
    private final byte[] masterSecret;
    private final LMOtsParameters parameter;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f525530q;

    public LMOtsPrivateKey(LMOtsParameters r100, byte[] r101, int r102, byte[] r103) {
        this.parameter = r100;
        this.I = r101;
        this.f525530q = r102;
        this.masterSecret = r103;
    }

    public SeedDerive getDerivationFunction() {
        SeedDerive r100 = new SeedDerive(this.I, this.masterSecret, DigestUtil.getDigest(this.parameter.getDigestOID()));
        r100.setQ(this.f525530q);
        return r100;
    }

    public byte[] getI() {
        return this.I;
    }

    public byte[] getMasterSecret() {
        return this.masterSecret;
    }

    public LMOtsParameters getParameter() {
        return this.parameter;
    }

    public int getQ() {
        return this.f525530q;
    }

    public LMSContext getSignatureContext(LMSigParameters r100, byte[][] r101) {
        byte[] r102 = new byte[32];
        SeedDerive r103 = getDerivationFunction();
        r103.setJ(-3);
        r103.deriveSeed(r102, false);
        Digest r104 = DigestUtil.getDigest(this.parameter.getDigestOID());
        LmsUtils.byteArray(getI(), r104);
        LmsUtils.u32str(getQ(), r104);
        LmsUtils.u16str(-32383, r104);
        LmsUtils.byteArray(r102, r104);
        return new LMSContext(this, r100, r104, r102, r101);
    }
}
