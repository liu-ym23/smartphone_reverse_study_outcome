package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class XDHUPublicParameters implements CipherParameters {
    private AsymmetricKeyParameter ephemeralPublicKey;
    private AsymmetricKeyParameter staticPublicKey;

    public XDHUPublicParameters(AsymmetricKeyParameter r100, AsymmetricKeyParameter r101) {
        if (r100 == null) goto L21;
        if ((r100 instanceof X448PublicKeyParameters) == false) goto L7;
    L11:
        if (r101 == null) goto L19;
        if (r100.getClass().isAssignableFrom(r101.getClass()) == false) goto L17;
        this.staticPublicKey = r100;
        this.ephemeralPublicKey = r101;
        return;
    L17:
        throw new IllegalArgumentException("static and ephemeral public keys have different domain parameters");
    L19:
        throw new NullPointerException("ephemeralPublicKey cannot be null");
    L7:
        if ((r100 instanceof X25519PublicKeyParameters) == true) goto L11;
        throw new IllegalArgumentException("only X25519 and X448 paramaters can be used");
    L21:
        throw new NullPointerException("staticPublicKey cannot be null");
    }

    public AsymmetricKeyParameter getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public AsymmetricKeyParameter getStaticPublicKey() {
        return this.staticPublicKey;
    }
}
