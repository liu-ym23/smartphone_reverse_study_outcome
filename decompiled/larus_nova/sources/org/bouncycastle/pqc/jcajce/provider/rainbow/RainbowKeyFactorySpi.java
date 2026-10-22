package org.bouncycastle.pqc.jcajce.provider.rainbow;

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
import org.bouncycastle.pqc.asn1.RainbowPrivateKey;
import org.bouncycastle.pqc.asn1.RainbowPublicKey;
import org.bouncycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
import org.bouncycastle.pqc.jcajce.spec.RainbowPublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public RainbowKeyFactorySpi() {
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof RainbowPrivateKeySpec) == false) goto L7;
        return new BCRainbowPrivateKey((RainbowPrivateKeySpec) r100);
    L7:
        if ((r100 instanceof PKCS8EncodedKeySpec) == false) goto L15;
        return generatePrivate(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(((PKCS8EncodedKeySpec) r100).getEncoded())));
    L11:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L15:
        throw new InvalidKeySpecException("Unsupported key specification: " + r100.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof RainbowPublicKeySpec) == false) goto L7;
        return new BCRainbowPublicKey((RainbowPublicKeySpec) r100);
    L7:
        if ((r100 instanceof X509EncodedKeySpec) == false) goto L15;
        return generatePublic(SubjectPublicKeyInfo.getInstance(((X509EncodedKeySpec) r100).getEncoded()));
    L11:
        e = move-exception;
        throw new InvalidKeySpecException(e.toString());
    L15:
        throw new InvalidKeySpecException("Unknown key specification: " + r100 + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key r100, Class r101) throws InvalidKeySpecException {
        if ((r100 instanceof BCRainbowPrivateKey) == false) goto L13;
        if (PKCS8EncodedKeySpec.class.isAssignableFrom(r101) == false) goto L9;
        return new PKCS8EncodedKeySpec(r100.getEncoded());
    L9:
        if (RainbowPrivateKeySpec.class.isAssignableFrom(r101) == false) goto L23;
        BCRainbowPrivateKey r102 = (BCRainbowPrivateKey) r100;
        return new RainbowPrivateKeySpec(r102.getInvA1(), r102.getB1(), r102.getInvA2(), r102.getB2(), r102.getVi(), r102.getLayers());
    L23:
        throw new InvalidKeySpecException("Unknown key specification: " + r101 + ".");
    L13:
        if ((r100 instanceof BCRainbowPublicKey) == false) goto L25;
        if (X509EncodedKeySpec.class.isAssignableFrom(r101) == false) goto L19;
        return new X509EncodedKeySpec(r100.getEncoded());
    L19:
        if (RainbowPublicKeySpec.class.isAssignableFrom(r101) == false) goto L23;
        BCRainbowPublicKey r103 = (BCRainbowPublicKey) r100;
        return new RainbowPublicKeySpec(r103.getDocLength(), r103.getCoeffQuadratic(), r103.getCoeffSingular(), r103.getCoeffScalar());
    L25:
        throw new InvalidKeySpecException("Unsupported key type: " + r100.getClass() + ".");
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key r100) throws InvalidKeyException {
        if ((r100 instanceof BCRainbowPrivateKey) == false) goto L5;
    L9:
        return r100;
    L5:
        if ((r100 instanceof BCRainbowPublicKey) == true) goto L9;
        throw new InvalidKeyException("Unsupported key type");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r100) throws IOException {
        RainbowPrivateKey r101 = RainbowPrivateKey.getInstance(r100.parsePrivateKey());
        return new BCRainbowPrivateKey(r101.getInvA1(), r101.getB1(), r101.getInvA2(), r101.getB2(), r101.getVi(), r101.getLayers());
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r100) throws IOException {
        RainbowPublicKey r101 = RainbowPublicKey.getInstance(r100.parsePublicKey());
        return new BCRainbowPublicKey(r101.getDocLength(), r101.getCoeffQuadratic(), r101.getCoeffSingular(), r101.getCoeffScalar());
    }
}
