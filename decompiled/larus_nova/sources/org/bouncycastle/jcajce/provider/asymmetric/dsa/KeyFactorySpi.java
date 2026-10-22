package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.util.OpenSSHPrivateKeyUtil;
import org.bouncycastle.crypto.util.OpenSSHPublicKeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec;
import org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    public KeyFactorySpi() {
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof DSAPrivateKeySpec) == false) goto L7;
        return new BCDSAPrivateKey((DSAPrivateKeySpec) r100);
    L7:
        if ((r100 instanceof OpenSSHPrivateKeySpec) == false) goto L15;
        AsymmetricKeyParameter r101 = OpenSSHPrivateKeyUtil.parsePrivateKeyBlob(((OpenSSHPrivateKeySpec) r100).getEncoded());
        if ((r101 instanceof DSAPrivateKeyParameters) == false) goto L13;
        DSAPrivateKeyParameters r102 = (DSAPrivateKeyParameters) r101;
        return engineGeneratePrivate(new DSAPrivateKeySpec(r102.getX(), r102.getParameters().getP(), r102.getParameters().getQ(), r102.getParameters().getG()));
    L13:
        throw new IllegalArgumentException("openssh private key is not dsa privare key");
    L15:
        return super.engineGeneratePrivate(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof DSAPublicKeySpec) == false) goto L10;
        return new BCDSAPublicKey((DSAPublicKeySpec) r100);
    L6:
        e = move-exception;
        final String r101 = "invalid KeySpec: " + e.getMessage();
        throw new AnonymousClass1(this, r101, e);
    L10:
        if ((r100 instanceof OpenSSHPublicKeySpec) == false) goto L18;
        AsymmetricKeyParameter r102 = OpenSSHPublicKeyUtil.parsePublicKey(((OpenSSHPublicKeySpec) r100).getEncoded());
        if ((r102 instanceof DSAPublicKeyParameters) == false) goto L16;
        DSAPublicKeyParameters r103 = (DSAPublicKeyParameters) r102;
        return engineGeneratePublic(new DSAPublicKeySpec(r103.getY(), r103.getParameters().getP(), r103.getParameters().getQ(), r103.getParameters().getG()));
    L16:
        throw new IllegalArgumentException("openssh public key is not dsa public key");
    L18:
        return super.engineGeneratePublic(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r100, Class r101) throws InvalidKeySpecException {
        if (r101.isAssignableFrom(DSAPublicKeySpec.class) == false) goto L9;
        if ((r100 instanceof DSAPublicKey) == false) goto L9;
        DSAPublicKey r102 = (DSAPublicKey) r100;
        return new DSAPublicKeySpec(r102.getY(), r102.getParams().getP(), r102.getParams().getQ(), r102.getParams().getG());
    L9:
        if (r101.isAssignableFrom(DSAPrivateKeySpec.class) == false) goto L15;
        if ((r100 instanceof DSAPrivateKey) == false) goto L15;
        DSAPrivateKey r103 = (DSAPrivateKey) r100;
        return new DSAPrivateKeySpec(r103.getX(), r103.getParams().getP(), r103.getParams().getQ(), r103.getParams().getG());
    L15:
        if (r101.isAssignableFrom(OpenSSHPublicKeySpec.class) == false) goto L25;
        if ((r100 instanceof DSAPublicKey) == false) goto L25;
        DSAPublicKey r104 = (DSAPublicKey) r100;
        return new OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new DSAPublicKeyParameters(r104.getY(), new DSAParameters(r104.getParams().getP(), r104.getParams().getQ(), r104.getParams().getG()))));
    L21:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L25:
        if (r101.isAssignableFrom(OpenSSHPrivateKeySpec.class) == false) goto L35;
        if ((r100 instanceof DSAPrivateKey) == false) goto L35;
        DSAPrivateKey r105 = (DSAPrivateKey) r100;
        return new OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new DSAPrivateKeyParameters(r105.getX(), new DSAParameters(r105.getParams().getP(), r105.getParams().getQ(), r105.getParams().getG()))));
    L31:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L35:
        if (r101.isAssignableFrom(org.bouncycastle.jce.spec.OpenSSHPublicKeySpec.class) == false) goto L45;
        if ((r100 instanceof DSAPublicKey) == false) goto L45;
        DSAPublicKey r106 = (DSAPublicKey) r100;
        return new org.bouncycastle.jce.spec.OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new DSAPublicKeyParameters(r106.getY(), new DSAParameters(r106.getParams().getP(), r106.getParams().getQ(), r106.getParams().getG()))));
    L41:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L45:
        if (r101.isAssignableFrom(org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec.class) == false) goto L55;
        if ((r100 instanceof DSAPrivateKey) == false) goto L55;
        DSAPrivateKey r107 = (DSAPrivateKey) r100;
        return new org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new DSAPrivateKeyParameters(r107.getX(), new DSAParameters(r107.getParams().getP(), r107.getParams().getQ(), r107.getParams().getG()))));
    L51:
        e = move-exception;
        throw new IllegalArgumentException("unable to produce encoding: " + e.getMessage());
    L55:
        return super.engineGetKeySpec(r100, r101);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r100) throws InvalidKeyException {
        if ((r100 instanceof DSAPublicKey) == false) goto L7;
        return new BCDSAPublicKey((DSAPublicKey) r100);
    L7:
        if ((r100 instanceof DSAPrivateKey) == false) goto L11;
        return new BCDSAPrivateKey((DSAPrivateKey) r100);
    L11:
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getPrivateKeyAlgorithm().getAlgorithm();
        if (DSAUtil.isDsaOid(r101) == false) goto L7;
        return new BCDSAPrivateKey(r100);
    L7:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getAlgorithm().getAlgorithm();
        if (DSAUtil.isDsaOid(r101) == false) goto L7;
        return new BCDSAPublicKey(r100);
    L7:
        throw new IOException("algorithm identifier " + r101 + " in key not recognised");
    }
}
