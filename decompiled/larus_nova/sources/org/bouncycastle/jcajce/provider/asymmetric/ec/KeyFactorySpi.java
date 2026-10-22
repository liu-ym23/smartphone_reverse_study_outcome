package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.bytedance.crypto.utils.CryptoConst;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.sec.ECPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.util.OpenSSHPublicKeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec;
import org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    String algorithm;
    ProviderConfiguration configuration;

    public static class EC extends KeyFactorySpi {
        public EC() {
            super(CryptoConst.ALGORITHM_EC, BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDH extends KeyFactorySpi {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDHC extends KeyFactorySpi {
        public ECDHC() {
            super("ECDHC", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDSA extends KeyFactorySpi {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECGOST3410 extends KeyFactorySpi {
        public ECGOST3410() {
            super("ECGOST3410", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECGOST3410_2012 extends KeyFactorySpi {
        public ECGOST3410_2012() {
            super("ECGOST3410-2012", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECMQV extends KeyFactorySpi {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public KeyFactorySpi(String r100, ProviderConfiguration r101) {
        this.algorithm = r100;
        this.configuration = r101;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof ECPrivateKeySpec) == false) goto L7;
        return new BCECPrivateKey(this.algorithm, (ECPrivateKeySpec) r100, this.configuration);
    L7:
        if ((r100 instanceof java.security.spec.ECPrivateKeySpec) == false) goto L11;
        return new BCECPrivateKey(this.algorithm, (java.security.spec.ECPrivateKeySpec) r100, this.configuration);
    L11:
        if ((r100 instanceof OpenSSHPrivateKeySpec) == false) goto L19;
        ECPrivateKey r101 = ECPrivateKey.getInstance(((OpenSSHPrivateKeySpec) r100).getEncoded());
        return new BCECPrivateKey(this.algorithm, new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, r101.getParameters()), r101), this.configuration);
    L15:
        e = move-exception;
        throw new InvalidKeySpecException("bad encoding: " + e.getMessage());
    L19:
        return super.engineGeneratePrivate(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r110) throws InvalidKeySpecException {
    L20:
        e = move-exception;
        throw new InvalidKeySpecException("invalid KeySpec: " + e.getMessage(), e);
    L3:
        if ((r110 instanceof ECPublicKeySpec) == false) goto L7;
        return new BCECPublicKey(this.algorithm, (ECPublicKeySpec) r110, this.configuration);
    L7:
        if ((r110 instanceof java.security.spec.ECPublicKeySpec) == false) goto L11;
        return new BCECPublicKey(this.algorithm, (java.security.spec.ECPublicKeySpec) r110, this.configuration);
    L11:
        if ((r110 instanceof OpenSSHPublicKeySpec) == false) goto L19;
        AsymmetricKeyParameter r111 = OpenSSHPublicKeyUtil.parsePublicKey(((OpenSSHPublicKeySpec) r110).getEncoded());     // Catch: Exception -> L20
        if ((r111 instanceof ECPublicKeyParameters) == false) goto L17;
        ECDomainParameters r100 = ((ECPublicKeyParameters) r111).getParameters();     // Catch: Exception -> L20
        return engineGeneratePublic(new ECPublicKeySpec(((ECPublicKeyParameters) r111).getQ(), new ECParameterSpec(r100.getCurve(), r100.getG(), r100.getN(), r100.getH(), r100.getSeed())));
    L17:
        throw new IllegalArgumentException("openssh key is not ec public key");     // Catch: Exception -> L20
    L19:
        return super.engineGeneratePublic(r110);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r110, Class r111) throws InvalidKeySpecException {
        if (r111.isAssignableFrom(KeySpec.class) == true) goto L7;
        if (r111.isAssignableFrom(java.security.spec.ECPublicKeySpec.class) == true) goto L7;
    L15:
        if (r111.isAssignableFrom(KeySpec.class) == true) goto L19;
        if (r111.isAssignableFrom(java.security.spec.ECPrivateKeySpec.class) == true) goto L19;
    L27:
        if (r111.isAssignableFrom(ECPublicKeySpec.class) == false) goto L37;
        if ((r110 instanceof ECPublicKey) == false) goto L37;
        ECPublicKey r112 = (ECPublicKey) r110;
        if (r112.getParams() == null) goto L35;
        return new ECPublicKeySpec(EC5Util.convertPoint(r112.getParams(), r112.getW()), EC5Util.convertSpec(r112.getParams()));
    L35:
        return new ECPublicKeySpec(EC5Util.convertPoint(r112.getParams(), r112.getW()), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa());
    L37:
        if (r111.isAssignableFrom(ECPrivateKeySpec.class) == false) goto L47;
        if ((r110 instanceof java.security.interfaces.ECPrivateKey) == false) goto L47;
        java.security.interfaces.ECPrivateKey r113 = (java.security.interfaces.ECPrivateKey) r110;
        if (r113.getParams() == null) goto L45;
        return new ECPrivateKeySpec(r113.getS(), EC5Util.convertSpec(r113.getParams()));
    L45:
        return new ECPrivateKeySpec(r113.getS(), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa());
    L47:
        if (r111.isAssignableFrom(OpenSSHPublicKeySpec.class) == false) goto L61;
        if ((r110 instanceof ECPublicKey) == false) goto L61;
        if ((r110 instanceof BCECPublicKey) == false) goto L59;
        BCECPublicKey r114 = (BCECPublicKey) r110;
        ECParameterSpec r115 = r114.getParameters();
        return new OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new ECPublicKeyParameters(r114.getQ(), new ECDomainParameters(r115.getCurve(), r115.getG(), r115.getN(), r115.getH(), r115.getSeed()))));
    L55:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L59:
        throw new IllegalArgumentException("invalid key type: ".concat(r110.getClass().getName()));
    L61:
        if (r111.isAssignableFrom(OpenSSHPrivateKeySpec.class) == false) goto L74;
        if ((r110 instanceof java.security.interfaces.ECPrivateKey) == false) goto L74;
        if ((r110 instanceof BCECPrivateKey) == false) goto L72;
        return new OpenSSHPrivateKeySpec(PrivateKeyInfo.getInstance(r110.getEncoded()).parsePrivateKey().toASN1Primitive().getEncoded());
    L68:
        e = move-exception;
        throw new IllegalArgumentException("cannot encoded key: " + e.getMessage());
    L72:
        throw new IllegalArgumentException("invalid key type: ".concat(r110.getClass().getName()));
    L74:
        if (r111.isAssignableFrom(org.bouncycastle.jce.spec.OpenSSHPublicKeySpec.class) == false) goto L88;
        if ((r110 instanceof ECPublicKey) == false) goto L88;
        if ((r110 instanceof BCECPublicKey) == false) goto L86;
        BCECPublicKey r116 = (BCECPublicKey) r110;
        ECParameterSpec r117 = r116.getParameters();
        return new org.bouncycastle.jce.spec.OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new ECPublicKeyParameters(r116.getQ(), new ECDomainParameters(r117.getCurve(), r117.getG(), r117.getN(), r117.getH(), r117.getSeed()))));
    L82:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L86:
        throw new IllegalArgumentException("invalid key type: ".concat(r110.getClass().getName()));
    L88:
        if (r111.isAssignableFrom(org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec.class) == false) goto L101;
        if ((r110 instanceof java.security.interfaces.ECPrivateKey) == false) goto L101;
        if ((r110 instanceof BCECPrivateKey) == false) goto L99;
        return new org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec(PrivateKeyInfo.getInstance(r110.getEncoded()).parsePrivateKey().toASN1Primitive().getEncoded());
    L95:
        e = move-exception;
        throw new IllegalArgumentException("cannot encoded key: " + e.getMessage());
    L99:
        throw new IllegalArgumentException("invalid key type: ".concat(r110.getClass().getName()));
    L101:
        return super.engineGetKeySpec(r110, r111);
    L19:
        if ((r110 instanceof java.security.interfaces.ECPrivateKey) == false) goto L27;
        java.security.interfaces.ECPrivateKey r118 = (java.security.interfaces.ECPrivateKey) r110;
        if (r118.getParams() != null) goto L23;
        ECParameterSpec r119 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
        return new java.security.spec.ECPrivateKeySpec(r118.getS(), EC5Util.convertSpec(EC5Util.convertCurve(r119.getCurve(), r119.getSeed()), r119));
    L23:
        return new java.security.spec.ECPrivateKeySpec(r118.getS(), r118.getParams());
    L7:
        if ((r110 instanceof ECPublicKey) == false) goto L15;
        ECPublicKey r120 = (ECPublicKey) r110;
        if (r120.getParams() != null) goto L11;
        ECParameterSpec r121 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
        return new java.security.spec.ECPublicKeySpec(r120.getW(), EC5Util.convertSpec(EC5Util.convertCurve(r121.getCurve(), r121.getSeed()), r121));
    L11:
        return new java.security.spec.ECPublicKeySpec(r120.getW(), r120.getParams());
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r100) throws InvalidKeyException {
        if ((r100 instanceof ECPublicKey) == false) goto L7;
        return new BCECPublicKey((ECPublicKey) r100, this.configuration);
    L7:
        if ((r100 instanceof java.security.interfaces.ECPrivateKey) == false) goto L11;
        return new BCECPrivateKey((java.security.interfaces.ECPrivateKey) r100, this.configuration);
    L11:
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getPrivateKeyAlgorithm().getAlgorithm();
        if (r101.equals(X9ObjectIdentifiers.id_ecPublicKey) == false) goto L7;
        return new BCECPrivateKey(this.algorithm, r100, this.configuration);
    L7:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getAlgorithm().getAlgorithm();
        if (r101.equals(X9ObjectIdentifiers.id_ecPublicKey) == false) goto L7;
        return new BCECPublicKey(this.algorithm, r100, this.configuration);
    L7:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }
}
