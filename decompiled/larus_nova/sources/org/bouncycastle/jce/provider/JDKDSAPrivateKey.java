package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

/* JADX INFO: loaded from: classes42.dex */
public class JDKDSAPrivateKey implements DSAPrivateKey, PKCS12BagAttributeCarrier {
    private static final long serialVersionUID = -4677259546958385734L;
    private PKCS12BagAttributeCarrierImpl attrCarrier;
    DSAParams dsaSpec;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    BigInteger f525397x;

    public JDKDSAPrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public JDKDSAPrivateKey(DSAPrivateKey r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525397x = r100.getX();
        this.dsaSpec = r100.getParams();
    }

    public JDKDSAPrivateKey(DSAPrivateKeySpec r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525397x = r100.getX();
        this.dsaSpec = new DSAParameterSpec(r100.getP(), r100.getQ(), r100.getG());
    }

    public JDKDSAPrivateKey(PrivateKeyInfo r100) throws IOException {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        DSAParameter r101 = DSAParameter.getInstance(r100.getPrivateKeyAlgorithm().getParameters());
        this.f525397x = ASN1Integer.getInstance(r100.parsePrivateKey()).getValue();
        this.dsaSpec = new DSAParameterSpec(r101.getP(), r101.getQ(), r101.getG());
    }

    public JDKDSAPrivateKey(DSAPrivateKeyParameters r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525397x = r100.getX();
        this.dsaSpec = new DSAParameterSpec(r100.getParameters().getP(), r100.getParameters().getQ(), r100.getParameters().getG());
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        this.f525397x = (BigInteger) r100.readObject();
        this.dsaSpec = new DSAParameterSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject(), (BigInteger) r100.readObject());
        PKCS12BagAttributeCarrierImpl r101 = new PKCS12BagAttributeCarrierImpl();
        this.attrCarrier = r101;
        r101.readObject(r100);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeObject(this.f525397x);
        r100.writeObject(this.dsaSpec.getP());
        r100.writeObject(this.dsaSpec.getQ());
        r100.writeObject(this.dsaSpec.getG());
        this.attrCarrier.writeObject(r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DSAPrivateKey) == true) goto L5;
        return false;
    L5:
        DSAPrivateKey r101 = (DSAPrivateKey) r100;
        if (getX().equals(r101.getX()) == true) goto L8;
        return false;
    L8:
        if (getParams().getG().equals(r101.getParams().getG()) == true) goto L10;
        return false;
    L10:
        if (getParams().getP().equals(r101.getParams().getP()) == true) goto L12;
        return false;
    L12:
        if (getParams().getQ().equals(r101.getParams().getQ()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
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
        return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG())), new ASN1Integer(getX())).getEncoded(ASN1Encoding.DER);
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.dsaSpec;
    }

    @Override // java.security.interfaces.DSAPrivateKey
    public BigInteger getX() {
        return this.f525397x;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.attrCarrier.setBagAttribute(r100, r101);
    }
}
