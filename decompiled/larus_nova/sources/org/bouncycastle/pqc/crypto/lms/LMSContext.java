package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

/* JADX INFO: loaded from: classes42.dex */
public class LMSContext implements Digest {
    private final byte[] C;
    private volatile Digest digest;
    private final LMOtsPrivateKey key;
    private final byte[][] path;
    private final LMOtsPublicKey publicKey;
    private final LMSigParameters sigParams;
    private final Object signature;
    private LMSSignedPubKey[] signedPubKeys;

    public LMSContext(LMOtsPrivateKey r100, LMSigParameters r101, Digest r102, byte[] r103, byte[][] r104) {
        this.key = r100;
        this.sigParams = r101;
        this.digest = r102;
        this.C = r103;
        this.path = r104;
        this.publicKey = null;
        this.signature = null;
    }

    public LMSContext(LMOtsPublicKey r100, Object r101, Digest r102) {
        this.publicKey = r100;
        this.signature = r101;
        this.digest = r102;
        this.C = null;
        this.key = null;
        this.sigParams = null;
        this.path = null;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] r100, int r101) {
        return this.digest.doFinal(r100, r101);
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return this.digest.getAlgorithmName();
    }

    public byte[] getC() {
        return this.C;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.digest.getDigestSize();
    }

    public byte[][] getPath() {
        return this.path;
    }

    public LMOtsPrivateKey getPrivateKey() {
        return this.key;
    }

    public LMOtsPublicKey getPublicKey() {
        return this.publicKey;
    }

    public byte[] getQ() {
        byte[] r100 = new byte[34];
        this.digest.doFinal(r100, 0);
        this.digest = null;
        return r100;
    }

    public LMSigParameters getSigParams() {
        return this.sigParams;
    }

    public Object getSignature() {
        return this.signature;
    }

    public LMSSignedPubKey[] getSignedPubKeys() {
        return this.signedPubKeys;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.digest.reset();
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte r100) {
        this.digest.update(r100);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] r100, int r101, int r102) {
        this.digest.update(r100, r101, r102);
    }

    public LMSContext withSignedPublicKeys(LMSSignedPubKey[] r100) {
        this.signedPubKeys = r100;
        return this;
    }
}
