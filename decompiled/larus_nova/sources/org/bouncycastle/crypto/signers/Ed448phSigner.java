package org.bouncycastle.crypto.signers;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Ed448phSigner implements Signer {
    private final byte[] context;
    private boolean forSigning;
    private final Xof prehash;
    private Ed448PrivateKeyParameters privateKey;
    private Ed448PublicKeyParameters publicKey;

    public Ed448phSigner(byte[] r100) {
        this.prehash = Ed448.createPrehash();
        this.context = Arrays.clone(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        if (this.forSigning == false) goto L13;
        if (this.privateKey == null) goto L13;
        byte[] r100 = new byte[64];
        if (64 != this.prehash.doFinal(r100, 0, 64)) goto L11;
        byte[] r101 = new byte[114];
        this.privateKey.sign(1, this.context, r100, 0, 64, r101, 0);
        return r101;
    L11:
        throw new IllegalStateException("Prehash digest failed");
    L13:
        throw new IllegalStateException("Ed448phSigner not initialised for signature generation.");
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean r100, CipherParameters r101) {
        this.forSigning = r100;
        if (r100 == false) goto L5;
        this.privateKey = (Ed448PrivateKeyParameters) r101;
        this.publicKey = null;
    L6:
        reset();
        return;
    L5:
        this.privateKey = null;
        this.publicKey = (Ed448PublicKeyParameters) r101;
        goto L6
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.prehash.reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte r100) {
        this.prehash.update(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] r100, int r101, int r102) {
        this.prehash.update(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] r100) {
        if (this.forSigning == true) goto L13;
        Ed448PublicKeyParameters r101 = this.publicKey;
        if (r101 == null) goto L13;
        if (114 == r100.length) goto L11;
        this.prehash.reset();
        return false;
    L11:
        return Ed448.verifyPrehash(r100, 0, r101.getEncoded(), 0, this.context, this.prehash);
    L13:
        throw new IllegalStateException("Ed448phSigner not initialised for verification");
    }
}
