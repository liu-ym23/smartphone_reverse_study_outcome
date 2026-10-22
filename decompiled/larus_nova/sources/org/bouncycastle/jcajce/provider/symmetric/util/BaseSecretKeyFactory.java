package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class BaseSecretKeyFactory extends SecretKeyFactorySpi implements PBE {
    protected String algName;
    protected ASN1ObjectIdentifier algOid;

    public BaseSecretKeyFactory(String r100, ASN1ObjectIdentifier r101) {
        this.algName = r100;
        this.algOid = r101;
    }

    @Override // javax.crypto.SecretKeyFactorySpi
    public SecretKey engineGenerateSecret(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof SecretKeySpec) == false) goto L7;
        return new SecretKeySpec(((SecretKeySpec) r100).getEncoded(), this.algName);
    L7:
        throw new InvalidKeySpecException("Invalid KeySpec");
    }

    @Override // javax.crypto.SecretKeyFactorySpi
    public KeySpec engineGetKeySpec(SecretKey r100, Class r101) throws InvalidKeySpecException {
        if (r101 == null) goto L17;
        if (r100 == null) goto L15;
        if (SecretKeySpec.class.isAssignableFrom(r101) == false) goto L18;
        return new SecretKeySpec(r100.getEncoded(), this.algName);
    L18:
        return (KeySpec) r101.getConstructor(new Class[]{byte[].class}).newInstance(new Object[]{r100.getEncoded()});
    L11:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L15:
        throw new InvalidKeySpecException("key parameter is null");
    L17:
        throw new InvalidKeySpecException("keySpec parameter is null");
    }

    @Override // javax.crypto.SecretKeyFactorySpi
    public SecretKey engineTranslateKey(SecretKey r100) throws InvalidKeyException {
        if (r100 == null) goto L10;
        if (r100.getAlgorithm().equalsIgnoreCase(this.algName) == false) goto L8;
        return new SecretKeySpec(r100.getEncoded(), this.algName);
    L8:
        throw new InvalidKeyException("Key not of type " + this.algName + ".");
    L10:
        throw new InvalidKeyException("key parameter is null");
    }
}
