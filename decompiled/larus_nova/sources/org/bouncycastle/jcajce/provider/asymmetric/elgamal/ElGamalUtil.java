package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalUtil {
    public ElGamalUtil() {
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof ElGamalPrivateKey) == false) goto L7;
        ElGamalPrivateKey r101 = (ElGamalPrivateKey) r100;
        return new ElGamalPrivateKeyParameters(r101.getX(), new ElGamalParameters(r101.getParameters().getP(), r101.getParameters().getG()));
    L7:
        if ((r100 instanceof DHPrivateKey) == false) goto L11;
        DHPrivateKey r102 = (DHPrivateKey) r100;
        return new ElGamalPrivateKeyParameters(r102.getX(), new ElGamalParameters(r102.getParams().getP(), r102.getParams().getG()));
    L11:
        throw new InvalidKeyException("can't identify private key for El Gamal.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof ElGamalPublicKey) == false) goto L7;
        ElGamalPublicKey r101 = (ElGamalPublicKey) r100;
        return new ElGamalPublicKeyParameters(r101.getY(), new ElGamalParameters(r101.getParameters().getP(), r101.getParameters().getG()));
    L7:
        if ((r100 instanceof DHPublicKey) == false) goto L11;
        DHPublicKey r102 = (DHPublicKey) r100;
        return new ElGamalPublicKeyParameters(r102.getY(), new ElGamalParameters(r102.getParams().getP(), r102.getParams().getG()));
    L11:
        throw new InvalidKeyException("can't identify public key for El Gamal.");
    }
}
