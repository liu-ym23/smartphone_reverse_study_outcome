package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410Util {
    public GOST3410Util() {
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof GOST3410PrivateKey) == false) goto L7;
        GOST3410PrivateKey r101 = (GOST3410PrivateKey) r100;
        GOST3410PublicKeyParameterSetSpec r102 = r101.getParameters().getPublicKeyParameters();
        return new GOST3410PrivateKeyParameters(r101.getX(), new GOST3410Parameters(r102.getP(), r102.getQ(), r102.getA()));
    L7:
        throw new InvalidKeyException("can't identify GOST3410 private key.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof GOST3410PublicKey) == false) goto L7;
        GOST3410PublicKey r101 = (GOST3410PublicKey) r100;
        GOST3410PublicKeyParameterSetSpec r102 = r101.getParameters().getPublicKeyParameters();
        return new GOST3410PublicKeyParameters(r101.getY(), new GOST3410Parameters(r102.getP(), r102.getQ(), r102.getA()));
    L7:
        throw new InvalidKeyException("can't identify GOST3410 public key: ".concat(r100.getClass().getName()));
    }
}
