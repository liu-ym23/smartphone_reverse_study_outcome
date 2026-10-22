package org.bouncycastle.crypto.signers;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.math.ec.rfc8032.Ed25519;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Ed25519phSigner implements Signer {
    private final byte[] context;
    private boolean forSigning;
    private final Digest prehash;
    private Ed25519PrivateKeyParameters privateKey;
    private Ed25519PublicKeyParameters publicKey;

    public Ed25519phSigner(byte[] r100) {
        this.prehash = Ed25519.createPrehash();
        this.context = Arrays.clone(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        if (this.forSigning == false) goto L13;
        if (this.privateKey == null) goto L13;
        byte[] r100 = new byte[64];
        if (64 != this.prehash.doFinal(r100, 0)) goto L11;
        byte[] r101 = new byte[64];
        this.privateKey.sign(2, this.context, r100, 0, 64, r101, 0);
        return r101;
    L11:
        throw new IllegalStateException("Prehash digest failed");
    L13:
        throw new IllegalStateException("Ed25519phSigner not initialised for signature generation.");
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean r100, CipherParameters r101) {
        this.forSigning = r100;
        if (r100 == false) goto L5;
        this.privateKey = (Ed25519PrivateKeyParameters) r101;
        this.publicKey = null;
    L6:
        reset();
        return;
    L5:
        this.privateKey = null;
        this.publicKey = (Ed25519PublicKeyParameters) r101;
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
        Ed25519PublicKeyParameters r101 = this.publicKey;
        if (r101 == null) goto L13;
        if (64 == r100.length) goto L11;
        this.prehash.reset();
        return false;
    L11:
        return Ed25519.verifyPrehash(r100, 0, r101.getEncoded(), 0, this.context, this.prehash);
    L13:
        throw new IllegalStateException("Ed25519phSigner not initialised for verification");
    }
}
