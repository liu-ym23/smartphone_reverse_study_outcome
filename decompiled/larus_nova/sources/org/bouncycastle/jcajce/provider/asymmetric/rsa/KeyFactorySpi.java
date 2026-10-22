package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.crypto.util.OpenSSHPrivateKeyUtil;
import org.bouncycastle.crypto.util.OpenSSHPublicKeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;
import org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec;
import org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    public KeyFactorySpi() {
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof PKCS8EncodedKeySpec) == false) goto L12;
        return generatePrivate(PrivateKeyInfo.getInstance(((PKCS8EncodedKeySpec) r100).getEncoded()));
    L6:
        e = move-exception;
        return new BCRSAPrivateCrtKey(RSAPrivateKey.getInstance(((PKCS8EncodedKeySpec) r100).getEncoded()));
    L10:
        throw new ExtendedInvalidKeySpecException("unable to process key spec: " + e.toString(), e);
    L12:
        if ((r100 instanceof RSAPrivateCrtKeySpec) == false) goto L16;
        return new BCRSAPrivateCrtKey((RSAPrivateCrtKeySpec) r100);
    L16:
        if ((r100 instanceof RSAPrivateKeySpec) == false) goto L20;
        return new BCRSAPrivateKey((RSAPrivateKeySpec) r100);
    L20:
        if ((r100 instanceof OpenSSHPrivateKeySpec) == false) goto L28;
        AsymmetricKeyParameter r101 = OpenSSHPrivateKeyUtil.parsePrivateKeyBlob(((OpenSSHPrivateKeySpec) r100).getEncoded());
        if ((r101 instanceof RSAPrivateCrtKeyParameters) == false) goto L26;
        return new BCRSAPrivateCrtKey((RSAPrivateCrtKeyParameters) r101);
    L26:
        throw new InvalidKeySpecException("open SSH public key is not RSA private key");
    L28:
        throw new InvalidKeySpecException("unknown KeySpec type: ".concat(r100.getClass().getName()));
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof RSAPublicKeySpec) == false) goto L7;
        return new BCRSAPublicKey((RSAPublicKeySpec) r100);
    L7:
        if ((r100 instanceof OpenSSHPublicKeySpec) == false) goto L15;
        AsymmetricKeyParameter r101 = OpenSSHPublicKeyUtil.parsePublicKey(((OpenSSHPublicKeySpec) r100).getEncoded());
        if ((r101 instanceof RSAKeyParameters) == false) goto L13;
        return new BCRSAPublicKey((RSAKeyParameters) r101);
    L13:
        throw new InvalidKeySpecException("Open SSH public key is not RSA public key");
    L15:
        return super.engineGeneratePublic(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r110, Class r111) throws InvalidKeySpecException {
        if (r111.isAssignableFrom(KeySpec.class) == true) goto L7;
        if (r111.isAssignableFrom(RSAPublicKeySpec.class) == true) goto L7;
    L11:
        if (r111.isAssignableFrom(KeySpec.class) == true) goto L15;
        if (r111.isAssignableFrom(RSAPrivateCrtKeySpec.class) == true) goto L15;
    L19:
        if (r111.isAssignableFrom(KeySpec.class) == true) goto L23;
        if (r111.isAssignableFrom(RSAPrivateKeySpec.class) == true) goto L23;
    L27:
        if (r111.isAssignableFrom(OpenSSHPublicKeySpec.class) == false) goto L36;
        if ((r110 instanceof RSAPublicKey) == false) goto L36;
        return new OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new RSAKeyParameters(false, ((RSAPublicKey) r110).getModulus(), ((RSAPublicKey) r110).getPublicExponent())));
    L32:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L36:
        if (r111.isAssignableFrom(OpenSSHPrivateKeySpec.class) == false) goto L45;
        if ((r110 instanceof RSAPrivateCrtKey) == false) goto L45;
        return new OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new RSAPrivateCrtKeyParameters(((RSAPrivateCrtKey) r110).getModulus(), ((RSAPrivateCrtKey) r110).getPublicExponent(), ((RSAPrivateCrtKey) r110).getPrivateExponent(), ((RSAPrivateCrtKey) r110).getPrimeP(), ((RSAPrivateCrtKey) r110).getPrimeQ(), ((RSAPrivateCrtKey) r110).getPrimeExponentP(), ((RSAPrivateCrtKey) r110).getPrimeExponentQ(), ((RSAPrivateCrtKey) r110).getCrtCoefficient())));
    L41:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L45:
        if (r111.isAssignableFrom(org.bouncycastle.jce.spec.OpenSSHPublicKeySpec.class) == false) goto L54;
        if ((r110 instanceof RSAPublicKey) == false) goto L54;
        return new org.bouncycastle.jce.spec.OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new RSAKeyParameters(false, ((RSAPublicKey) r110).getModulus(), ((RSAPublicKey) r110).getPublicExponent())));
    L50:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L54:
        if (r111.isAssignableFrom(org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec.class) == false) goto L63;
        if ((r110 instanceof RSAPrivateCrtKey) == false) goto L63;
        return new org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new RSAPrivateCrtKeyParameters(((RSAPrivateCrtKey) r110).getModulus(), ((RSAPrivateCrtKey) r110).getPublicExponent(), ((RSAPrivateCrtKey) r110).getPrivateExponent(), ((RSAPrivateCrtKey) r110).getPrimeP(), ((RSAPrivateCrtKey) r110).getPrimeQ(), ((RSAPrivateCrtKey) r110).getPrimeExponentP(), ((RSAPrivateCrtKey) r110).getPrimeExponentQ(), ((RSAPrivateCrtKey) r110).getCrtCoefficient())));
    L59:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L63:
        return super.engineGetKeySpec(r110, r111);
    L23:
        if ((r110 instanceof java.security.interfaces.RSAPrivateKey) == false) goto L27;
        java.security.interfaces.RSAPrivateKey r112 = (java.security.interfaces.RSAPrivateKey) r110;
        return new RSAPrivateKeySpec(r112.getModulus(), r112.getPrivateExponent());
    L15:
        if ((r110 instanceof RSAPrivateCrtKey) == false) goto L19;
        RSAPrivateCrtKey r113 = (RSAPrivateCrtKey) r110;
        return new RSAPrivateCrtKeySpec(r113.getModulus(), r113.getPublicExponent(), r113.getPrivateExponent(), r113.getPrimeP(), r113.getPrimeQ(), r113.getPrimeExponentP(), r113.getPrimeExponentQ(), r113.getCrtCoefficient());
    L7:
        if ((r110 instanceof RSAPublicKey) == false) goto L11;
        RSAPublicKey r114 = (RSAPublicKey) r110;
        return new RSAPublicKeySpec(r114.getModulus(), r114.getPublicExponent());
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r100) throws InvalidKeyException {
        if ((r100 instanceof RSAPublicKey) == false) goto L7;
        return new BCRSAPublicKey((RSAPublicKey) r100);
    L7:
        if ((r100 instanceof RSAPrivateCrtKey) == false) goto L11;
        return new BCRSAPrivateCrtKey((RSAPrivateCrtKey) r100);
    L11:
        if ((r100 instanceof java.security.interfaces.RSAPrivateKey) == false) goto L15;
        return new BCRSAPrivateKey((java.security.interfaces.RSAPrivateKey) r100);
    L15:
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getPrivateKeyAlgorithm().getAlgorithm();
        if (RSAUtil.isRsaOid(r101) == false) goto L11;
        RSAPrivateKey r102 = RSAPrivateKey.getInstance(r100.parsePrivateKey());
        if (r102.getCoefficient().intValue() != 0) goto L9;
        return new BCRSAPrivateKey(r100.getPrivateKeyAlgorithm(), r102);
    L9:
        return new BCRSAPrivateCrtKey(r100);
    L11:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getAlgorithm().getAlgorithm();
        if (RSAUtil.isRsaOid(r101) == false) goto L7;
        return new BCRSAPublicKey(r100);
    L7:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }
}
