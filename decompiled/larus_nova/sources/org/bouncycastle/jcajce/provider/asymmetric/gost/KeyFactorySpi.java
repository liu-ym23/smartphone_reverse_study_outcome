package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    public KeyFactorySpi() {
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof GOST3410PrivateKeySpec) == false) goto L7;
        return new BCGOST3410PrivateKey((GOST3410PrivateKeySpec) r100);
    L7:
        return super.engineGeneratePrivate(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof GOST3410PublicKeySpec) == false) goto L7;
        return new BCGOST3410PublicKey((GOST3410PublicKeySpec) r100);
    L7:
        return super.engineGeneratePublic(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r100, Class r101) throws InvalidKeySpecException {
        if (r101.isAssignableFrom(GOST3410PublicKeySpec.class) == false) goto L9;
        if ((r100 instanceof GOST3410PublicKey) == false) goto L9;
        GOST3410PublicKey r102 = (GOST3410PublicKey) r100;
        GOST3410PublicKeyParameterSetSpec r103 = r102.getParameters().getPublicKeyParameters();
        return new GOST3410PublicKeySpec(r102.getY(), r103.getP(), r103.getQ(), r103.getA());
    L9:
        if (r101.isAssignableFrom(GOST3410PrivateKeySpec.class) == false) goto L15;
        if ((r100 instanceof GOST3410PrivateKey) == false) goto L15;
        GOST3410PrivateKey r104 = (GOST3410PrivateKey) r100;
        GOST3410PublicKeyParameterSetSpec r105 = r104.getParameters().getPublicKeyParameters();
        return new GOST3410PrivateKeySpec(r104.getX(), r105.getP(), r105.getQ(), r105.getA());
    L15:
        return super.engineGetKeySpec(r100, r101);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r100) throws InvalidKeyException {
        if ((r100 instanceof GOST3410PublicKey) == false) goto L7;
        return new BCGOST3410PublicKey((GOST3410PublicKey) r100);
    L7:
        if ((r100 instanceof GOST3410PrivateKey) == false) goto L11;
        return new BCGOST3410PrivateKey((GOST3410PrivateKey) r100);
    L11:
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getPrivateKeyAlgorithm().getAlgorithm();
        if (r101.equals(CryptoProObjectIdentifiers.gostR3410_94) == false) goto L7;
        return new BCGOST3410PrivateKey(r100);
    L7:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getAlgorithm().getAlgorithm();
        if (r101.equals(CryptoProObjectIdentifiers.gostR3410_94) == false) goto L7;
        return new BCGOST3410PublicKey(r100);
    L7:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }
}
