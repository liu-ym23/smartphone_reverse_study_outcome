package org.bouncycastle.jce.provider;

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
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

/* JADX INFO: loaded from: classes42.dex */
public class JCERSAPrivateKey implements RSAPrivateKey, PKCS12BagAttributeCarrier {
    private static BigInteger ZERO = null;
    static final long serialVersionUID = 5110188922551353628L;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    protected BigInteger modulus;
    protected BigInteger privateExponent;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    public JCERSAPrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public JCERSAPrivateKey(RSAPrivateKey r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r100.getModulus();
        this.privateExponent = r100.getPrivateExponent();
    }

    public JCERSAPrivateKey(RSAPrivateKeySpec r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r100.getModulus();
        this.privateExponent = r100.getPrivateExponent();
    }

    public JCERSAPrivateKey(RSAKeyParameters r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.modulus = r100.getModulus();
        this.privateExponent = r100.getExponent();
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        this.modulus = (BigInteger) r100.readObject();
        PKCS12BagAttributeCarrierImpl r101 = new PKCS12BagAttributeCarrierImpl();
        this.attrCarrier = r101;
        r101.readObject(r100);
        this.privateExponent = (BigInteger) r100.readObject();
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeObject(this.modulus);
        this.attrCarrier.writeObject(r100);
        r100.writeObject(this.privateExponent);
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
        AlgorithmIdentifier r100 = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
        BigInteger r101 = getModulus();
        BigInteger r102 = ZERO;
        BigInteger r103 = getPrivateExponent();
        BigInteger r110 = ZERO;
        return KeyUtil.getEncodedPrivateKeyInfo(r100, new org.bouncycastle.asn1.pkcs.RSAPrivateKey(r101, r102, r103, r110, r110, r110, r110, r110));
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
}
