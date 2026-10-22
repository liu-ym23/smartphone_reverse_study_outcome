package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes42.dex */
public class KeyFactory extends KeyFactorySpi {
    public KeyFactory() {
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof PKCS8EncodedKeySpec) == false) goto L13;
        PrivateKeyInfo r101 = PrivateKeyInfo.getInstance(((PKCS8EncodedKeySpec) r100).getEncoded());     // Catch: Exception -> L9
        PrivateKey r102 = BouncyCastleProvider.getPrivateKey(r101);     // Catch: Exception -> L9
        if (r102 == null) goto L8;
        return r102;
    L8:
        throw new InvalidKeySpecException("no factory found for OID: " + r101.getPrivateKeyAlgorithm().getAlgorithm());     // Catch: Exception -> L9
    L9:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L13:
        throw new InvalidKeySpecException("Unknown KeySpec type: ".concat(r100.getClass().getName()));
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof X509EncodedKeySpec) == false) goto L13;
        SubjectPublicKeyInfo r101 = SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec) r100).getEncoded());     // Catch: Exception -> L9
        PublicKey r102 = BouncyCastleProvider.getPublicKey(r101);     // Catch: Exception -> L9
        if (r102 == null) goto L8;
        return r102;
    L8:
        throw new InvalidKeySpecException("no factory found for OID: " + r101.getAlgorithm().getAlgorithm());     // Catch: Exception -> L9
    L9:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L13:
        throw new InvalidKeySpecException("Unknown KeySpec type: ".concat(r100.getClass().getName()));
    }

    @Override // java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r100, Class r101) throws InvalidKeySpecException {
        if (r101.isAssignableFrom(PKCS8EncodedKeySpec.class) == false) goto L9;
        if (r100.getFormat().equals("PKCS#8") == false) goto L9;
        return new PKCS8EncodedKeySpec(r100.getEncoded());
    L9:
        if (r101.isAssignableFrom(X509EncodedKeySpec.class) == false) goto L15;
        if (r100.getFormat().equals("X.509") == false) goto L15;
        return new X509EncodedKeySpec(r100.getEncoded());
    L15:
        throw new InvalidKeySpecException("not implemented yet " + r100 + " " + r101);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r100) throws InvalidKeyException {
        throw new InvalidKeyException("not implemented yet " + r100);
    }
}
