package org.bouncycastle.jcajce.provider.asymmetric.util;

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
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

/* JADX INFO: loaded from: classes42.dex */
public abstract class BaseKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public BaseKeyFactorySpi() {
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof PKCS8EncodedKeySpec) == false) goto L10;
        return generatePrivate(PrivateKeyInfo.getInstance(((PKCS8EncodedKeySpec) r100).getEncoded()));
    L6:
        e = move-exception;
        throw new InvalidKeySpecException("encoded key spec not recognized: " + e.getMessage());
    L10:
        throw new InvalidKeySpecException("key spec not recognized");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof X509EncodedKeySpec) == false) goto L10;
        return generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec) r100).getEncoded()));
    L6:
        e = move-exception;
        throw new InvalidKeySpecException("encoded key spec not recognized: " + e.getMessage());
    L10:
        throw new InvalidKeySpecException("key spec not recognized");
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
}
