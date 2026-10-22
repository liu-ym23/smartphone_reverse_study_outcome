package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU4145KeyPairGenerator extends ECKeyPairGenerator {
    public DSTU4145KeyPairGenerator() {
    }

    @Override // org.bouncycastle.crypto.generators.ECKeyPairGenerator, org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        AsymmetricCipherKeyPair r100 = super.generateKeyPair();
        ECPublicKeyParameters r101 = (ECPublicKeyParameters) r100.getPublic();
        ECPrivateKeyParameters r102 = (ECPrivateKeyParameters) r100.getPrivate();
        return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(r101.getQ().negate(), r101.getParameters()), r102);
    }
}
