package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.alipay.sdk.m.n.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class BCRSAPrivateKey implements RSAPrivateKey, PKCS12BagAttributeCarrier {
    private static BigInteger ZERO = null;
    static final long serialVersionUID = 5110188922551353628L;
    protected transient AlgorithmIdentifier algorithmIdentifier;
    private byte[] algorithmIdentifierEnc;
    protected transient PKCS12BagAttributeCarrierImpl attrCarrier;
    protected BigInteger modulus;
    protected BigInteger privateExponent;
    protected transient RSAKeyParameters rsaPrivateKey;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    public BCRSAPrivateKey(RSAPrivateKey r100) {
        AlgorithmIdentifier r101 = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(r101);
        this.algorithmIdentifier = r101;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r100.getModulus();
        this.privateExponent = r100.getPrivateExponent();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.modulus, this.privateExponent);
    }

    public BCRSAPrivateKey(RSAPrivateKeySpec r100) {
        AlgorithmIdentifier r101 = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(r101);
        this.algorithmIdentifier = r101;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r100.getModulus();
        this.privateExponent = r100.getPrivateExponent();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.modulus, this.privateExponent);
    }

    public BCRSAPrivateKey(AlgorithmIdentifier r100, org.bouncycastle.asn1.pkcs.RSAPrivateKey r101) {
        AlgorithmIdentifier r102 = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(r102);
        this.algorithmIdentifier = r102;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithmIdentifier = r100;
        this.algorithmIdentifierEnc = getEncoding(r100);
        this.modulus = r101.getModulus();
        this.privateExponent = r101.getPrivateExponent();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.modulus, this.privateExponent);
    }

    public BCRSAPrivateKey(AlgorithmIdentifier r100, RSAKeyParameters r101) {
        AlgorithmIdentifier r102 = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(r102);
        this.algorithmIdentifier = r102;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithmIdentifier = r100;
        this.algorithmIdentifierEnc = getEncoding(r100);
        this.modulus = r101.getModulus();
        this.privateExponent = r101.getExponent();
        this.rsaPrivateKey = r101;
    }

    public BCRSAPrivateKey(RSAKeyParameters r100) {
        AlgorithmIdentifier r101 = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(r101);
        this.algorithmIdentifier = r101;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r100.getModulus();
        this.privateExponent = r100.getExponent();
        this.rsaPrivateKey = r100;
    }

    private static byte[] getEncoding(AlgorithmIdentifier r100) {
        return r100.getEncoded();
    L4:
        return null;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        if (this.algorithmIdentifierEnc != null) goto L5;
        this.algorithmIdentifierEnc = getEncoding(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER);
    L5:
        this.algorithmIdentifier = AlgorithmIdentifier.getInstance(this.algorithmIdentifierEnc);
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.modulus, this.privateExponent);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
    }

    public RSAKeyParameters engineGetKeyParameters() {
        return this.rsaPrivateKey;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof RSAPrivateKey) == true) goto L6;
        return false;
    L6:
        if (r100 != this) goto L8;
        return true;
    L8:
        RSAPrivateKey r101 = (RSAPrivateKey) r100;
        if (getModulus().equals(r101.getModulus()) == true) goto L11;
        return false;
    L11:
        if (getPrivateExponent().equals(r101.getPrivateExponent()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        if (this.algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) == false) goto L6;
        return "RSASSA-PSS";
    L6:
        return d.f25615a;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier r100) {
        return this.attrCarrier.getBagAttribute(r100);
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        AlgorithmIdentifier r100 = this.algorithmIdentifier;
        BigInteger r101 = getModulus();
        BigInteger r102 = ZERO;
        BigInteger r103 = getPrivateExponent();
        BigInteger r104 = ZERO;
        return KeyUtil.getEncodedPrivateKeyInfo(r100, new org.bouncycastle.asn1.pkcs.RSAPrivateKey(r101, r102, r103, r104, r104, r104, r104, r104));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // java.security.interfaces.RSAPrivateKey
    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPrivateExponent().hashCode();
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.attrCarrier.setBagAttribute(r100, r101);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("RSA Private Key [");
        String r101 = Strings.lineSeparator();
        r100.append(RSAUtil.generateKeyFingerprint(getModulus()));
        r100.append("],[]");
        r100.append(r101);
        r100.append("            modulus: ");
        r100.append(getModulus().toString(16));
        r100.append(r101);
        return r100.toString();
    }
}
