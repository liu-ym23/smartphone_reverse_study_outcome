package org.bouncycastle.crypto.signers;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GenericSigner implements Signer {
    private final Digest digest;
    private final AsymmetricBlockCipher engine;
    private boolean forSigning;

    public GenericSigner(AsymmetricBlockCipher r100, Digest r101) {
        this.engine = r100;
        this.digest = r101;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException, DataLengthException {
        if (this.forSigning == false) goto L7;
        int r100 = this.digest.getDigestSize();
        byte[] r101 = new byte[r100];
        this.digest.doFinal(r101, 0);
        return this.engine.processBlock(r101, 0, r100);
    L7:
        throw new IllegalStateException("GenericSigner not initialised for signature generation.");
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
        this.engine.init(r100, r101);
        return;
    L14:
        if (r102.isPrivate() == false) goto L18;
        throw new IllegalArgumentException("verification requires public key");
    L8:
        if (r102.isPrivate() == true) goto L12;
        throw new IllegalArgumentException("signing requires private key");
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
        if (this.forSigning == true) goto L12;
        int r101 = this.digest.getDigestSize();
        byte[] r102 = new byte[r101];
        this.digest.doFinal(r102, 0);
        byte[] r103 = this.engine.processBlock(r100, 0, r100.length);     // Catch: Exception -> L10
        if (r103.length >= r101) goto L8;
        byte[] r104 = new byte[r101];     // Catch: Exception -> L10
        System.arraycopy(r103, 0, r104, r101 - r103.length, r103.length);     // Catch: Exception -> L10
        r103 = r104;
    L8:
        return Arrays.constantTimeAreEqual(r103, r102);
    L10:
        return false;
    L12:
        throw new IllegalStateException("GenericSigner not initialised for verification");
    }
}
