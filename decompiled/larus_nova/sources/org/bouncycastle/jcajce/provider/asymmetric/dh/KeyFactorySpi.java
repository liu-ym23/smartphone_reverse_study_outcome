package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;

/* JADX INFO: loaded from: classes42.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    public KeyFactorySpi() {
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof DHPrivateKeySpec) == false) goto L7;
        return new BCDHPrivateKey((DHPrivateKeySpec) r100);
    L7:
        return super.engineGeneratePrivate(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof DHPublicKeySpec) == false) goto L10;
        return new BCDHPublicKey((DHPublicKeySpec) r100);
    L6:
        e = move-exception;
        throw new ExtendedInvalidKeySpecException(e.getMessage(), e);
    L10:
        return super.engineGeneratePublic(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r100, Class r101) throws InvalidKeySpecException {
        if (r101.isAssignableFrom(DHPrivateKeySpec.class) == false) goto L9;
        if ((r100 instanceof DHPrivateKey) == false) goto L9;
        DHPrivateKey r102 = (DHPrivateKey) r100;
        return new DHPrivateKeySpec(r102.getX(), r102.getParams().getP(), r102.getParams().getG());
    L9:
        if (r101.isAssignableFrom(DHPublicKeySpec.class) == false) goto L15;
        if ((r100 instanceof DHPublicKey) == false) goto L15;
        DHPublicKey r103 = (DHPublicKey) r100;
        return new DHPublicKeySpec(r103.getY(), r103.getParams().getP(), r103.getParams().getG());
    L15:
        return super.engineGetKeySpec(r100, r101);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r100) throws InvalidKeyException {
        if ((r100 instanceof DHPublicKey) == false) goto L7;
        return new BCDHPublicKey((DHPublicKey) r100);
    L7:
        if ((r100 instanceof DHPrivateKey) == false) goto L11;
        return new BCDHPrivateKey((DHPrivateKey) r100);
    L11:
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getPrivateKeyAlgorithm().getAlgorithm();
        if (r101.equals(PKCSObjectIdentifiers.dhKeyAgreement) == false) goto L7;
        return new BCDHPrivateKey(r100);
    L7:
        if (r101.equals(X9ObjectIdentifiers.dhpublicnumber) == false) goto L11;
        return new BCDHPrivateKey(r100);
    L11:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getAlgorithm().getAlgorithm();
        if (r101.equals(PKCSObjectIdentifiers.dhKeyAgreement) == false) goto L7;
        return new BCDHPublicKey(r100);
    L7:
        if (r101.equals(X9ObjectIdentifiers.dhpublicnumber) == false) goto L11;
        return new BCDHPublicKey(r100);
    L11:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }
}
