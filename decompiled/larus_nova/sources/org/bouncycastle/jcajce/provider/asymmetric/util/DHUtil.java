package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey;

/* JADX INFO: loaded from: classes42.dex */
public class DHUtil {
    public DHUtil() {
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof DHPrivateKey) == false) goto L7;
        DHPrivateKey r101 = (DHPrivateKey) r100;
        return new DHPrivateKeyParameters(r101.getX(), new DHParameters(r101.getParams().getP(), r101.getParams().getG(), null, r101.getParams().getL()));
    L7:
        throw new InvalidKeyException("can't identify DH private key.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCDHPublicKey) == false) goto L7;
        return ((BCDHPublicKey) r100).engineGetKeyParameters();
    L7:
        if ((r100 instanceof DHPublicKey) == false) goto L11;
        DHPublicKey r101 = (DHPublicKey) r100;
        return new DHPublicKeyParameters(r101.getY(), new DHParameters(r101.getParams().getP(), r101.getParams().getG(), null, r101.getParams().getL()));
    L11:
        throw new InvalidKeyException("can't identify DH public key.");
    }
}
