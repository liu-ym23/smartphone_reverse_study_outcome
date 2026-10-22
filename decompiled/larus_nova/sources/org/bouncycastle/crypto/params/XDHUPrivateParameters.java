package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class XDHUPrivateParameters implements CipherParameters {
    private AsymmetricKeyParameter ephemeralPrivateKey;
    private AsymmetricKeyParameter ephemeralPublicKey;
    private AsymmetricKeyParameter staticPrivateKey;

    public XDHUPrivateParameters(AsymmetricKeyParameter r100, AsymmetricKeyParameter r101) {
        this(r100, r101, null);
    }

    public XDHUPrivateParameters(AsymmetricKeyParameter r100, AsymmetricKeyParameter r101, AsymmetricKeyParameter r102) {
        if (r100 == null) goto L39;
        boolean r103 = r100 instanceof X448PrivateKeyParameters;
        if (r103 == false) goto L7;
    L11:
        if (r101 == null) goto L37;
        if (r100.getClass().isAssignableFrom(r101.getClass()) == false) goto L35;
        if (r102 != null) goto L20;
        if ((r101 instanceof X448PrivateKeyParameters) == false) goto L18;
        r102 = ((X448PrivateKeyParameters) r101).generatePublicKey();
    L32:
        this.staticPrivateKey = r100;
        this.ephemeralPrivateKey = r101;
        this.ephemeralPublicKey = r102;
        return;
    L18:
        r102 = ((X25519PrivateKeyParameters) r101).generatePublicKey();
        goto L32
    L20:
        if ((r102 instanceof X448PublicKeyParameters) == false) goto L26;
        if (r103 == true) goto L26;
        throw new IllegalArgumentException("ephemeral public key has different domain parameters");
    L26:
        if ((r102 instanceof X25519PublicKeyParameters) == false) goto L32;
        if ((r100 instanceof X25519PrivateKeyParameters) == true) goto L32;
        throw new IllegalArgumentException("ephemeral public key has different domain parameters");
    L35:
        throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
    L37:
        throw new NullPointerException("ephemeralPrivateKey cannot be null");
    L7:
        if ((r100 instanceof X25519PrivateKeyParameters) == true) goto L11;
        throw new IllegalArgumentException("only X25519 and X448 paramaters can be used");
    L39:
        throw new NullPointerException("staticPrivateKey cannot be null");
    }

    public AsymmetricKeyParameter getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public AsymmetricKeyParameter getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public AsymmetricKeyParameter getStaticPrivateKey() {
        return this.staticPrivateKey;
    }
}
