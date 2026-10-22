package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ECDHUPublicParameters implements CipherParameters {
    private ECPublicKeyParameters ephemeralPublicKey;
    private ECPublicKeyParameters staticPublicKey;

    public ECDHUPublicParameters(ECPublicKeyParameters r100, ECPublicKeyParameters r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L12;
        if (r100.getParameters().equals(r101.getParameters()) == false) goto L10;
        this.staticPublicKey = r100;
        this.ephemeralPublicKey = r101;
        return;
    L10:
        throw new IllegalArgumentException("static and ephemeral public keys have different domain parameters");
    L12:
        throw new NullPointerException("ephemeralPublicKey cannot be null");
    L14:
        throw new NullPointerException("staticPublicKey cannot be null");
    }

    public ECPublicKeyParameters getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public ECPublicKeyParameters getStaticPublicKey() {
        return this.staticPublicKey;
    }
}
