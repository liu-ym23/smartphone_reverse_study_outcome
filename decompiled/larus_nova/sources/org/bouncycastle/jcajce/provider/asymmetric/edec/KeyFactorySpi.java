package org.bouncycastle.jcajce.provider.asymmetric.edec;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.util.OpenSSHPrivateKeyUtil;
import org.bouncycastle.crypto.util.OpenSSHPublicKeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.jcajce.spec.OpenSSHPrivateKeySpec;
import org.bouncycastle.jcajce.spec.OpenSSHPublicKeySpec;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi {
    static final byte[] Ed25519Prefix = null;
    private static final byte Ed25519_type = 112;
    static final byte[] Ed448Prefix = null;
    private static final byte Ed448_type = 113;
    static final byte[] x25519Prefix = null;
    private static final byte x25519_type = 110;
    static final byte[] x448Prefix = null;
    private static final byte x448_type = 111;
    String algorithm;
    private final boolean isXdh;
    private final int specificBase;

    public static class Ed25519 extends KeyFactorySpi {
        public Ed25519() {
            super(EdDSAParameterSpec.Ed25519, false, 112);
        }
    }

    public static class Ed448 extends KeyFactorySpi {
        public Ed448() {
            super(EdDSAParameterSpec.Ed448, false, 113);
        }
    }

    public static class EdDSA extends KeyFactorySpi {
        public EdDSA() {
            super("EdDSA", false, 0);
        }
    }

    public static class X25519 extends KeyFactorySpi {
        public X25519() {
            super(XDHParameterSpec.X25519, true, 110);
        }
    }

    public static class X448 extends KeyFactorySpi {
        public X448() {
            super(XDHParameterSpec.X448, true, 111);
        }
    }

    public static class XDH extends KeyFactorySpi {
        public XDH() {
            super("XDH", true, 0);
        }
    }

    static {
        x448Prefix = Hex.decode("3042300506032b656f033900");
        x25519Prefix = Hex.decode("302a300506032b656e032100");
        Ed448Prefix = Hex.decode("3043300506032b6571033a00");
        Ed25519Prefix = Hex.decode("302a300506032b6570032100");
    }

    public KeyFactorySpi(String r100, boolean r101, int r102) {
        this.algorithm = r100;
        this.isXdh = r101;
        this.specificBase = r102;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof OpenSSHPrivateKeySpec) == false) goto L11;
        AsymmetricKeyParameter r101 = OpenSSHPrivateKeyUtil.parsePrivateKeyBlob(((OpenSSHPrivateKeySpec) r100).getEncoded());
        if ((r101 instanceof Ed25519PrivateKeyParameters) == false) goto L9;
        return new BCEdDSAPrivateKey((Ed25519PrivateKeyParameters) r101);
    L9:
        throw new IllegalStateException("openssh private key not Ed25519 private key");
    L11:
        return super.engineGeneratePrivate(r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec r100) throws InvalidKeySpecException {
        if ((r100 instanceof X509EncodedKeySpec) == false) goto L31;
        byte[] r101 = ((X509EncodedKeySpec) r100).getEncoded();
        int r102 = this.specificBase;
        if (r102 == 0) goto L9;
        if (r102 == r101[8]) goto L9;
    L39:
        return super.engineGeneratePublic(r100);
    L9:
        if (r101[9] != 5) goto L19;
        if (r101[10] != 0) goto L19;
        SubjectPublicKeyInfo r103 = SubjectPublicKeyInfo.getInstance(r101);
        r101 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(r103.getAlgorithm().getAlgorithm()), r103.getPublicKeyData().getBytes()).getEncoded(ASN1Encoding.DER);     // Catch: IOException -> L15
    L15:
        e = move-exception;
        throw new InvalidKeySpecException("attempt to reconstruct key failed: " + e.getMessage());
    L19:
        switch(r101[8]) {
            case 110: goto L29;
            case 111: goto L27;
            case 112: goto L25;
            case 113: goto L23;
            default: goto L21;
        };
    L21:
        return super.engineGeneratePublic(r100);
    L23:
        return new BCEdDSAPublicKey(Ed448Prefix, r101);
    L25:
        return new BCEdDSAPublicKey(Ed25519Prefix, r101);
    L27:
        return new BCXDHPublicKey(x448Prefix, r101);
    L29:
        return new BCXDHPublicKey(x25519Prefix, r101);
    L31:
        if ((r100 instanceof OpenSSHPublicKeySpec) == false) goto L39;
        AsymmetricKeyParameter r104 = OpenSSHPublicKeyUtil.parsePublicKey(((OpenSSHPublicKeySpec) r100).getEncoded());
        if ((r104 instanceof Ed25519PublicKeyParameters) == false) goto L37;
        return new BCEdDSAPublicKey(new byte[0], ((Ed25519PublicKeyParameters) r104).getEncoded());
    L37:
        throw new IllegalStateException("openssh public key not Ed25519 public key");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseKeyFactorySpi, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key r100, Class r101) throws InvalidKeySpecException {
        if (r101.isAssignableFrom(OpenSSHPrivateKeySpec.class) == false) goto L12;
        if ((r100 instanceof BCEdDSAPrivateKey) == false) goto L12;
        return new OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new Ed25519PrivateKeyParameters(ASN1OctetString.getInstance(new ASN1InputStream(((DEROctetString) ASN1Sequence.getInstance(r100.getEncoded()).getObjectAt(2)).getOctets()).readObject()).getOctets(), 0)));
    L8:
        e = move-exception;
        throw new InvalidKeySpecException(e.getMessage(), e.getCause());
    L12:
        if (r101.isAssignableFrom(OpenSSHPublicKeySpec.class) == false) goto L21;
        if ((r100 instanceof BCEdDSAPublicKey) == false) goto L21;
        return new OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new Ed25519PublicKeyParameters(r100.getEncoded(), Ed25519Prefix.length)));
    L17:
        e = move-exception;
        throw new InvalidKeySpecException(e.getMessage(), e.getCause());
    L21:
        if (r101.isAssignableFrom(org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec.class) == false) goto L30;
        if ((r100 instanceof BCEdDSAPrivateKey) == false) goto L30;
        return new org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec(OpenSSHPrivateKeyUtil.encodePrivateKey(new Ed25519PrivateKeyParameters(ASN1OctetString.getInstance(new ASN1InputStream(((DEROctetString) ASN1Sequence.getInstance(r100.getEncoded()).getObjectAt(2)).getOctets()).readObject()).getOctets(), 0)));
    L26:
        e = move-exception;
        throw new InvalidKeySpecException(e.getMessage(), e.getCause());
    L30:
        if (r101.isAssignableFrom(org.bouncycastle.jce.spec.OpenSSHPublicKeySpec.class) == false) goto L39;
        if ((r100 instanceof BCEdDSAPublicKey) == false) goto L39;
        return new org.bouncycastle.jce.spec.OpenSSHPublicKeySpec(OpenSSHPublicKeyUtil.encodePublicKey(new Ed25519PublicKeyParameters(r100.getEncoded(), Ed25519Prefix.length)));
    L35:
        e = move-exception;
        throw new InvalidKeySpecException(e.getMessage(), e.getCause());
    L39:
        return super.engineGetKeySpec(r100, r101);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key r100) throws InvalidKeyException {
        throw new InvalidKeyException("key type unknown");
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PrivateKey generatePrivate(PrivateKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getPrivateKeyAlgorithm().getAlgorithm();
        if (this.isXdh == false) goto L20;
        int r102 = this.specificBase;
        if (r102 == 0) goto L9;
        if (r102 == 111) goto L9;
    L12:
        int r103 = this.specificBase;
        if (r103 == 0) goto L17;
        if (r103 == 110) goto L17;
    L41:
        throw new IOException("algorithm identifier " + r101 + " in key not recognized");
    L17:
        if (r101.equals(EdECObjectIdentifiers.id_X25519) == false) goto L41;
        return new BCXDHPrivateKey(r100);
    L9:
        if (r101.equals(EdECObjectIdentifiers.id_X448) == false) goto L12;
        return new BCXDHPrivateKey(r100);
    L20:
        ASN1ObjectIdentifier r104 = EdECObjectIdentifiers.id_Ed448;
        if (r101.equals(r104) == false) goto L23;
    L24:
        int r105 = this.specificBase;
        if (r105 == 0) goto L29;
        if (r105 == 113) goto L29;
    L32:
        int r106 = this.specificBase;
        if (r106 == 0) goto L37;
        if (r106 != 112) goto L41;
    L37:
        if (r101.equals(EdECObjectIdentifiers.id_Ed25519) == false) goto L41;
        return new BCEdDSAPrivateKey(r100);
    L29:
        if (r101.equals(r104) == false) goto L32;
        return new BCEdDSAPrivateKey(r100);
    L23:
        if (r101.equals(EdECObjectIdentifiers.id_Ed25519) == false) goto L41;
        goto L24
    }

    @Override // org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo r100) throws IOException {
        ASN1ObjectIdentifier r101 = r100.getAlgorithm().getAlgorithm();
        if (this.isXdh == false) goto L20;
        int r102 = this.specificBase;
        if (r102 == 0) goto L9;
        if (r102 == 111) goto L9;
    L12:
        int r103 = this.specificBase;
        if (r103 == 0) goto L17;
        if (r103 == 110) goto L17;
    L41:
        throw new IOException("algorithm identifier " + r101 + " in key not recognized");
    L17:
        if (r101.equals(EdECObjectIdentifiers.id_X25519) == false) goto L41;
        return new BCXDHPublicKey(r100);
    L9:
        if (r101.equals(EdECObjectIdentifiers.id_X448) == false) goto L12;
        return new BCXDHPublicKey(r100);
    L20:
        ASN1ObjectIdentifier r104 = EdECObjectIdentifiers.id_Ed448;
        if (r101.equals(r104) == false) goto L23;
    L24:
        int r105 = this.specificBase;
        if (r105 == 0) goto L29;
        if (r105 == 113) goto L29;
    L32:
        int r106 = this.specificBase;
        if (r106 == 0) goto L37;
        if (r106 != 112) goto L41;
    L37:
        if (r101.equals(EdECObjectIdentifiers.id_Ed25519) == false) goto L41;
        return new BCEdDSAPublicKey(r100);
    L29:
        if (r101.equals(r104) == false) goto L32;
        return new BCEdDSAPublicKey(r100);
    L23:
        if (r101.equals(EdECObjectIdentifiers.id_Ed25519) == false) goto L41;
        goto L24
    }
}
