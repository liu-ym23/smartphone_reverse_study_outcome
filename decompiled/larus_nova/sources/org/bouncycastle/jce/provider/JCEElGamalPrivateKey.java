package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class JCEElGamalPrivateKey implements ElGamalPrivateKey, DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 4819350091141529678L;
    private PKCS12BagAttributeCarrierImpl attrCarrier;
    ElGamalParameterSpec elSpec;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    BigInteger f525395x;

    public JCEElGamalPrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public JCEElGamalPrivateKey(DHPrivateKey r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525395x = r100.getX();
        this.elSpec = new ElGamalParameterSpec(r100.getParams().getP(), r100.getParams().getG());
    }

    public JCEElGamalPrivateKey(DHPrivateKeySpec r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525395x = r100.getX();
        this.elSpec = new ElGamalParameterSpec(r100.getP(), r100.getG());
    }

    public JCEElGamalPrivateKey(PrivateKeyInfo r100) throws IOException {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        ElGamalParameter r101 = ElGamalParameter.getInstance(r100.getPrivateKeyAlgorithm().getParameters());
        this.f525395x = ASN1Integer.getInstance(r100.parsePrivateKey()).getValue();
        this.elSpec = new ElGamalParameterSpec(r101.getP(), r101.getG());
    }

    public JCEElGamalPrivateKey(ElGamalPrivateKeyParameters r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525395x = r100.getX();
        this.elSpec = new ElGamalParameterSpec(r100.getParameters().getP(), r100.getParameters().getG());
    }

    public JCEElGamalPrivateKey(ElGamalPrivateKey r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525395x = r100.getX();
        this.elSpec = r100.getParameters();
    }

    public JCEElGamalPrivateKey(ElGamalPrivateKeySpec r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525395x = r100.getX();
        this.elSpec = new ElGamalParameterSpec(r100.getParams().getP(), r100.getParams().getG());
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        this.f525395x = (BigInteger) r100.readObject();
        this.elSpec = new ElGamalParameterSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeObject(getX());
        r100.writeObject(this.elSpec.getP());
        r100.writeObject(this.elSpec.getG());
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
        return KeyUtil.getEncodedPrivateKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), new ASN1Integer(getX()));
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
        return this.f525395x;
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.attrCarrier.setBagAttribute(r100, r101);
    }
}
