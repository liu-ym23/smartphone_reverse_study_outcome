package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

/* JADX INFO: loaded from: classes42.dex */
public class SM2KeyExchangePrivateParameters implements CipherParameters {
    private final ECPrivateKeyParameters ephemeralPrivateKey;
    private final ECPoint ephemeralPublicPoint;
    private final boolean initiator;
    private final ECPrivateKeyParameters staticPrivateKey;
    private final ECPoint staticPublicPoint;

    public SM2KeyExchangePrivateParameters(boolean r100, ECPrivateKeyParameters r101, ECPrivateKeyParameters r102) {
        if (r101 == null) goto L14;
        if (r102 == null) goto L12;
        ECDomainParameters r103 = r101.getParameters();
        if (r103.equals(r102.getParameters()) == false) goto L10;
        FixedPointCombMultiplier r104 = new FixedPointCombMultiplier();
        this.initiator = r100;
        this.staticPrivateKey = r101;
        this.staticPublicPoint = r104.multiply(r103.getG(), r101.getD()).normalize();
        this.ephemeralPrivateKey = r102;
        this.ephemeralPublicPoint = r104.multiply(r103.getG(), r102.getD()).normalize();
        return;
    L10:
        throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
    L12:
        throw new NullPointerException("ephemeralPrivateKey cannot be null");
    L14:
        throw new NullPointerException("staticPrivateKey cannot be null");
    }

    public ECPrivateKeyParameters getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    public ECPoint getEphemeralPublicPoint() {
        return this.ephemeralPublicPoint;
    }

    public ECPrivateKeyParameters getStaticPrivateKey() {
        return this.staticPrivateKey;
    }

    public ECPoint getStaticPublicPoint() {
        return this.staticPublicPoint;
    }

    public boolean isInitiator() {
        return this.initiator;
    }
}
