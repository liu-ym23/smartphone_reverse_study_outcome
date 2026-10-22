package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;

/* JADX INFO: loaded from: classes42.dex */
public class DSADigestSigner implements Signer {
    private final Digest digest;

    /* JADX INFO: renamed from: dsa, reason: collision with root package name */
    private final DSA f525341dsa;
    private final DSAEncoding encoding;
    private boolean forSigning;

    public DSADigestSigner(DSA r100, Digest r101) {
        this.f525341dsa = r100;
        this.digest = r101;
        this.encoding = StandardDSAEncoding.INSTANCE;
    }

    public DSADigestSigner(DSAExt r100, Digest r101, DSAEncoding r102) {
        this.f525341dsa = r100;
        this.digest = r101;
        this.encoding = r102;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        if (this.forSigning == false) goto L10;
        byte[] r100 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r100, 0);
        BigInteger[] r101 = this.f525341dsa.generateSignature(r100);
        return this.encoding.encode(getOrder(), r101[0], r101[1]);
    L8:
        throw new IllegalStateException("unable to encode signature");
    L10:
        throw new IllegalStateException("DSADigestSigner not initialised for signature generation.");
    }

    public BigInteger getOrder() {
        DSA r100 = this.f525341dsa;
        if ((r100 instanceof DSAExt) == true) goto L7;
        return null;
    L7:
        return ((DSAExt) r100).getOrder();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean r100, CipherParameters r101) {
        this.forSigning = r100;
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        AsymmetricKeyParameter r102 = (AsymmetricKeyParameter) ((ParametersWithRandom) r101).getParameters();
    L6:
        if (r100 == true) goto L8;
    L12:
        if (r100 == false) goto L14;
    L18:
        reset();
        this.f525341dsa.init(r100, r101);
        return;
    L14:
        if (r102.isPrivate() == false) goto L18;
        throw new IllegalArgumentException("Verification Requires Public Key.");
    L8:
        if (r102.isPrivate() == true) goto L12;
        throw new IllegalArgumentException("Signing Requires Private Key.");
    L5:
        r102 = (AsymmetricKeyParameter) r101;
        goto L6
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte r100) {
        this.digest.update(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] r100, int r101, int r102) {
        this.digest.update(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] r100) {
        if (this.forSigning == true) goto L9;
        byte[] r101 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r101, 0);
        BigInteger[] r102 = this.encoding.decode(getOrder(), r100);     // Catch: Exception -> L7
        return this.f525341dsa.verifySignature(r101, r102[0], r102[1]);
    L7:
        return false;
    L9:
        throw new IllegalStateException("DSADigestSigner not initialised for verification");
    }
}
