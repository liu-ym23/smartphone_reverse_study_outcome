package org.bouncycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowKeysToParams {
    public RainbowKeysToParams() {
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCRainbowPrivateKey) == false) goto L7;
        BCRainbowPrivateKey r101 = (BCRainbowPrivateKey) r100;
        return new RainbowPrivateKeyParameters(r101.getInvA1(), r101.getB1(), r101.getInvA2(), r101.getB2(), r101.getVi(), r101.getLayers());
    L7:
        throw new InvalidKeyException("can't identify Rainbow private key.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCRainbowPublicKey) == false) goto L7;
        BCRainbowPublicKey r101 = (BCRainbowPublicKey) r100;
        return new RainbowPublicKeyParameters(r101.getDocLength(), r101.getCoeffQuadratic(), r101.getCoeffSingular(), r101.getCoeffScalar());
    L7:
        throw new InvalidKeyException("can't identify Rainbow public key: ".concat(r100.getClass().getName()));
    }
}
