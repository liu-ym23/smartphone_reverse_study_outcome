package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2KeysToParams {
    public McElieceCCA2KeysToParams() {
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCMcElieceCCA2PrivateKey) == false) goto L7;
        return ((BCMcElieceCCA2PrivateKey) r100).getKeyParams();
    L7:
        throw new InvalidKeyException("can't identify McElieceCCA2 private key.");
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCMcElieceCCA2PublicKey) == false) goto L7;
        return ((BCMcElieceCCA2PublicKey) r100).getKeyParams();
    L7:
        throw new InvalidKeyException("can't identify McElieceCCA2 public key: ".concat(r100.getClass().getName()));
    }
}
