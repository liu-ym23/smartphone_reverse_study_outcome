package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public XMSSKeyFactorySpi() {
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof PKCS8EncodedKeySpec) == false) goto L11;
        return generatePrivate(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(((PKCS8EncodedKeySpec) r100).getEncoded())));
    L7:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L11:
        throw new InvalidKeySpecException("unsupported key specification: " + r100.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof X509EncodedKeySpec) == false) goto L11;
        return generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec) r100).getEncoded()));
    L7:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L11:
        throw new InvalidKeySpecException("unknown key specification: " + r100 + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key r100, Class r101) throws InvalidKeySpecException {
        if ((r100 instanceof BCXMSSPrivateKey) == false) goto L9;
        if (PKCS8EncodedKeySpec.class.isAssignableFrom(r101) == false) goto L15;
        return new PKCS8EncodedKeySpec(r100.getEncoded());
    L15:
        throw new InvalidKeySpecException("unknown key specification: " + r101 + ".");
    L9:
        if ((r100 instanceof BCXMSSPublicKey) == false) goto L17;
        if (X509EncodedKeySpec.class.isAssignableFrom(r101) == false) goto L15;
        return new X509EncodedKeySpec(r100.getEncoded());
    L17:
        throw new InvalidKeySpecException("unsupported key type: " + r100.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key r100) throws InvalidKeyException {
        if ((r100 instanceof BCXMSSPrivateKey) == false) goto L5;
    L9:
        return r100;
    L5:
        if ((r100 instanceof BCXMSSPublicKey) == true) goto L9;
        throw new InvalidKeyException("unsupported key type");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r100) throws IOException {
        return new BCXMSSPrivateKey(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r100) throws IOException {
        return new BCXMSSPublicKey(r100);
    }
}
