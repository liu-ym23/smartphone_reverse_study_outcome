package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceKeysToParams {
    public McElieceKeysToParams() {
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCMcEliecePrivateKey) == false) goto L7;
        BCMcEliecePrivateKey r101 = (BCMcEliecePrivateKey) r100;
        return new McEliecePrivateKeyParameters(r101.getN(), r101.getK(), r101.getField(), r101.getGoppaPoly(), r101.getP1(), r101.getP2(), r101.getSInv());
    L7:
        throw new InvalidKeyException("can't identify McEliece private key.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCMcEliecePublicKey) == false) goto L7;
        return ((BCMcEliecePublicKey) r100).getKeyParams();
    L7:
        throw new InvalidKeyException("can't identify McEliece public key: ".concat(r100.getClass().getName()));
    }
}
