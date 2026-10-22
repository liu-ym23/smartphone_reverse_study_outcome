package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DHUPrivateParameters implements CipherParameters {
    private DHPrivateKeyParameters ephemeralPrivateKey;
    private DHPublicKeyParameters ephemeralPublicKey;
    private DHPrivateKeyParameters staticPrivateKey;

    public DHUPrivateParameters(DHPrivateKeyParameters r100, DHPrivateKeyParameters r101) {
        this(r100, r101, null);
    }

    public DHUPrivateParameters(DHPrivateKeyParameters r100, DHPrivateKeyParameters r101, DHPublicKeyParameters r102) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L18;
        DHParameters r103 = r100.getParameters();
        if (r103.equals(r101.getParameters()) == false) goto L16;
        if (r102 != null) goto L10;
        r102 = new DHPublicKeyParameters(r103.getG().modPow(r101.getX(), r103.getP()), r103);
    L11:
        this.staticPrivateKey = r100;
        this.ephemeralPrivateKey = r101;
        this.ephemeralPublicKey = r102;
        return;
    L10:
        if (r103.equals(r102.getParameters()) == true) goto L11;
        throw new IllegalArgumentException("ephemeral public key has different domain parameters");
    L16:
        throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
    L18:
        throw new NullPointerException("ephemeralPrivateKey cannot be null");
    L20:
        throw new NullPointerException("staticPrivateKey cannot be null");
    }

    public DHPrivateKeyParameters getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public DHPublicKeyParameters getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public DHPrivateKeyParameters getStaticPrivateKey() {
        return this.staticPrivateKey;
    }
}
