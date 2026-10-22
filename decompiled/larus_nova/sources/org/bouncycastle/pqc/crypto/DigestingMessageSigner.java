package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;

/* JADX INFO: loaded from: classes42.dex */
public class DigestingMessageSigner implements Signer {
    private boolean forSigning;
    private final Digest messDigest;
    private final MessageSigner messSigner;

    public DigestingMessageSigner(MessageSigner r100, Digest r101) {
        this.messSigner = r100;
        this.messDigest = r101;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        if (this.forSigning == false) goto L7;
        byte[] r100 = new byte[this.messDigest.getDigestSize()];
        this.messDigest.doFinal(r100, 0);
        return this.messSigner.generateSignature(r100);
    L7:
        throw new IllegalStateException("DigestingMessageSigner not initialised for signature generation.");
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
        this.messSigner.init(r100, r101);
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
        this.messDigest.reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte r100) {
        this.messDigest.update(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] r100, int r101, int r102) {
        this.messDigest.update(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] r100) {
        if (this.forSigning == true) goto L7;
        byte[] r101 = new byte[this.messDigest.getDigestSize()];
        this.messDigest.doFinal(r101, 0);
        return this.messSigner.verifySignature(r101, r100);
    L7:
        throw new IllegalStateException("DigestingMessageSigner not initialised for verification");
    }
}
