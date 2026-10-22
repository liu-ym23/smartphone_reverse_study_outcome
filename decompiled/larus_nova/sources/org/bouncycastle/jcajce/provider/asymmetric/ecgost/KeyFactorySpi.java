package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    public KeyFactorySpi() {
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof ECPrivateKeySpec) == false) goto L7;
        return new BCECGOST3410PrivateKey((ECPrivateKeySpec) r100);
    L7:
        if ((r100 instanceof java.security.spec.ECPrivateKeySpec) == false) goto L11;
        return new BCECGOST3410PrivateKey((java.security.spec.ECPrivateKeySpec) r100);
    L11:
        return super.engineGeneratePrivate(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof ECPublicKeySpec) == false) goto L7;
        return new BCECGOST3410PublicKey((ECPublicKeySpec) r100, BouncyCastleProvider.CONFIGURATION);
    L7:
        if ((r100 instanceof java.security.spec.ECPublicKeySpec) == false) goto L11;
        return new BCECGOST3410PublicKey((java.security.spec.ECPublicKeySpec) r100);
    L11:
        return super.engineGeneratePublic(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r100, Class r101) throws InvalidKeySpecException {
        if (r101.isAssignableFrom(java.security.spec.ECPublicKeySpec.class) == false) goto L13;
        if ((r100 instanceof ECPublicKey) == false) goto L13;
        ECPublicKey r102 = (ECPublicKey) r100;
        if (r102.getParams() != null) goto L9;
        ECParameterSpec r103 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
        return new java.security.spec.ECPublicKeySpec(r102.getW(), EC5Util.convertSpec(EC5Util.convertCurve(r103.getCurve(), r103.getSeed()), r103));
    L9:
        return new java.security.spec.ECPublicKeySpec(r102.getW(), r102.getParams());
    L13:
        if (r101.isAssignableFrom(java.security.spec.ECPrivateKeySpec.class) == false) goto L23;
        if ((r100 instanceof ECPrivateKey) == false) goto L23;
        ECPrivateKey r104 = (ECPrivateKey) r100;
        if (r104.getParams() != null) goto L19;
        ECParameterSpec r105 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
        return new java.security.spec.ECPrivateKeySpec(r104.getS(), EC5Util.convertSpec(EC5Util.convertCurve(r105.getCurve(), r105.getSeed()), r105));
    L19:
        return new java.security.spec.ECPrivateKeySpec(r104.getS(), r104.getParams());
    L23:
        if (r101.isAssignableFrom(ECPublicKeySpec.class) == false) goto L33;
        if ((r100 instanceof ECPublicKey) == false) goto L33;
        ECPublicKey r106 = (ECPublicKey) r100;
        if (r106.getParams() != null) goto L29;
        ECParameterSpec r107 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
        return new ECPublicKeySpec(EC5Util.convertPoint(r106.getParams(), r106.getW()), r107);
    L29:
        return new ECPublicKeySpec(EC5Util.convertPoint(r106.getParams(), r106.getW()), EC5Util.convertSpec(r106.getParams()));
    L33:
        if (r101.isAssignableFrom(ECPrivateKeySpec.class) == false) goto L43;
        if ((r100 instanceof ECPrivateKey) == false) goto L43;
        ECPrivateKey r108 = (ECPrivateKey) r100;
        if (r108.getParams() != null) goto L39;
        ECParameterSpec r109 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
        return new ECPrivateKeySpec(r108.getS(), r109);
    L39:
        return new ECPrivateKeySpec(r108.getS(), EC5Util.convertSpec(r108.getParams()));
    L43:
        return super.engineGetKeySpec(r100, r101);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r100) throws InvalidKeyException {
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getPrivateKeyAlgorithm().getAlgorithm();
        if (r101.equals(CryptoProObjectIdentifiers.gostR3410_2001) == false) goto L7;
        return new BCECGOST3410PrivateKey(r100);
    L7:
        if (r101.equals(CryptoProObjectIdentifiers.gostR3410_2001DH) == false) goto L11;
        return new BCECGOST3410PrivateKey(r100);
    L11:
        if (r101.equals(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_ESDH) == false) goto L15;
        return new BCECGOST3410PrivateKey(r100);
    L15:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getAlgorithm().getAlgorithm();
        if (r101.equals(CryptoProObjectIdentifiers.gostR3410_2001) == false) goto L7;
        return new BCECGOST3410PublicKey(r100);
    L7:
        if (r101.equals(CryptoProObjectIdentifiers.gostR3410_2001DH) == false) goto L11;
        return new BCECGOST3410PublicKey(r100);
    L11:
        if (r101.equals(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_ESDH) == false) goto L15;
        return new BCECGOST3410PublicKey(r100);
    L15:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }
}
