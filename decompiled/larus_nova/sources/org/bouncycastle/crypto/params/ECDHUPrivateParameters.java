package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

/* JADX INFO: loaded from: classes42.dex */
public class ECDHUPrivateParameters implements CipherParameters {
    private ECPrivateKeyParameters ephemeralPrivateKey;
    private ECPublicKeyParameters ephemeralPublicKey;
    private ECPrivateKeyParameters staticPrivateKey;

    public ECDHUPrivateParameters(ECPrivateKeyParameters r100, ECPrivateKeyParameters r101) {
        this(r100, r101, null);
    }

    public ECDHUPrivateParameters(ECPrivateKeyParameters r100, ECPrivateKeyParameters r101, ECPublicKeyParameters r102) {
        if (r100 == null) goto L20;
        if (r101 == null) goto L18;
        ECDomainParameters r103 = r100.getParameters();
        if (r103.equals(r101.getParameters()) == false) goto L16;
        if (r102 != null) goto L10;
        r102 = new ECPublicKeyParameters(new FixedPointCombMultiplier().multiply(r103.getG(), r101.getD()), r103);
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

    public ECPrivateKeyParameters getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public ECPublicKeyParameters getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public ECPrivateKeyParameters getStaticPrivateKey() {
        return this.staticPrivateKey;
    }
}
