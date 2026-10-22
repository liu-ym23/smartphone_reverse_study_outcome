package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class BCElGamalPrivateKey implements ElGamalPrivateKey, DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 4819350091141529678L;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier;
    private transient ElGamalParameterSpec elSpec;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f525365x;

    public BCElGamalPrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public BCElGamalPrivateKey(DHPrivateKey r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525365x = r100.getX();
        this.elSpec = new ElGamalParameterSpec(r100.getParams().getP(), r100.getParams().getG());
    }

    public BCElGamalPrivateKey(DHPrivateKeySpec r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525365x = r100.getX();
        this.elSpec = new ElGamalParameterSpec(r100.getP(), r100.getG());
    }

    public BCElGamalPrivateKey(PrivateKeyInfo r100) throws IOException {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ElGamalParameter r101 = ElGamalParameter.getInstance(r100.getPrivateKeyAlgorithm().getParameters());
        this.f525365x = ASN1Integer.getInstance(r100.parsePrivateKey()).getValue();
        this.elSpec = new ElGamalParameterSpec(r101.getP(), r101.getG());
    }

    public BCElGamalPrivateKey(ElGamalPrivateKeyParameters r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525365x = r100.getX();
        this.elSpec = new ElGamalParameterSpec(r100.getParameters().getP(), r100.getParameters().getG());
    }

    public BCElGamalPrivateKey(ElGamalPrivateKey r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525365x = r100.getX();
        this.elSpec = r100.getParameters();
    }

    public BCElGamalPrivateKey(ElGamalPrivateKeySpec r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525365x = r100.getX();
        this.elSpec = new ElGamalParameterSpec(r100.getParams().getP(), r100.getParams().getG());
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        this.elSpec = new ElGamalParameterSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject());
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(this.elSpec.getP());
        r100.writeObject(this.elSpec.getG());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DHPrivateKey) == true) goto L5;
        return false;
    L5:
        DHPrivateKey r101 = (DHPrivateKey) r100;
        if (getX().equals(r101.getX()) == true) goto L8;
        return false;
    L8:
        if (getParams().getG().equals(r101.getParams().getG()) == true) goto L10;
        return false;
    L10:
        if (getParams().getP().equals(r101.getParams().getP()) == true) goto L12;
        return false;
    L12:
        if (getParams().getL() != r101.getParams().getL()) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
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
        return new PrivateKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), new ASN1Integer(getX())).getEncoded(ASN1Encoding.DER);
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalKey
    public ElGamalParameterSpec getParameters() {
        return this.elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.getP(), this.elSpec.getG());
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPrivateKey, javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.f525365x;
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.attrCarrier.setBagAttribute(r100, r101);
    }
}
