package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.GOST3410Params;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

/* JADX INFO: loaded from: classes42.dex */
public class BCGOST3410PrivateKey implements GOST3410PrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 8581661527592305464L;
    private transient PKCS12BagAttributeCarrier attrCarrier;
    private transient GOST3410Params gost3410Spec;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f525367x;

    public BCGOST3410PrivateKey() {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    public BCGOST3410PrivateKey(PrivateKeyInfo r100) throws IOException {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        GOST3410PublicKeyAlgParameters r101 = GOST3410PublicKeyAlgParameters.getInstance(r100.getPrivateKeyAlgorithm().getParameters());
        ASN1Encodable r102 = r100.parsePrivateKey();
        if ((r102 instanceof ASN1Integer) == false) goto L6;
        BigInteger r103 = ASN1Integer.getInstance(r102).getPositiveValue();
    L5:
        this.f525367x = r103;
        this.gost3410Spec = GOST3410ParameterSpec.fromPublicKeyAlg(r101);
        return;
    L6:
        byte[] r104 = ASN1OctetString.getInstance(r100.parsePrivateKey()).getOctets();
        byte[] r105 = new byte[r104.length];
        int r106 = 0;
    L8:
        if (r106 == r104.length) goto L10;
        r105[r106] = r104[(r104.length - 1) - r106];
        r106 = r106 + 1;
        goto L8
    L10:
        r103 = new BigInteger(1, r105);
        goto L5
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKeyParameters r100, GOST3410ParameterSpec r101) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525367x = r100.getX();
        this.gost3410Spec = r101;
        if (r101 == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("spec is null");
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKey r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525367x = r100.getX();
        this.gost3410Spec = r100.getParameters();
    }

    public BCGOST3410PrivateKey(GOST3410PrivateKeySpec r100) {
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f525367x = r100.getX();
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(r100.getP(), r100.getQ(), r100.getA()));
    }

    private boolean compareObj(Object r100, Object r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.equals(r101);
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        String r101 = (String) r100.readObject();
        if (r101 == null) goto L5;
        this.gost3410Spec = new GOST3410ParameterSpec(r101, (String) r100.readObject(), (String) r100.readObject());
    L6:
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        return;
    L5:
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject(), (BigInteger) r100.readObject()));
        r100.readObject();
        r100.readObject();
        goto L6
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        if (this.gost3410Spec.getPublicKeyParamSetOID() == null) goto L5;
        Object r101 = this.gost3410Spec.getPublicKeyParamSetOID();
    L6:
        r100.writeObject(r101);
        r100.writeObject(this.gost3410Spec.getDigestParamSetOID());
        r100.writeObject(this.gost3410Spec.getEncryptionParamSetOID());
        return;
    L5:
        r100.writeObject(null);
        r100.writeObject(this.gost3410Spec.getPublicKeyParameters().getP());
        r100.writeObject(this.gost3410Spec.getPublicKeyParameters().getQ());
        r101 = this.gost3410Spec.getPublicKeyParameters().getA();
        goto L6
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GOST3410PrivateKey) == true) goto L5;
        return false;
    L5:
        GOST3410PrivateKey r101 = (GOST3410PrivateKey) r100;
        if (getX().equals(r101.getX()) == true) goto L8;
        return false;
    L8:
        if (getParameters().getPublicKeyParameters().equals(r101.getParameters().getPublicKeyParameters()) == true) goto L10;
        return false;
    L10:
        if (getParameters().getDigestParamSetOID().equals(r101.getParameters().getDigestParamSetOID()) == true) goto L12;
        return false;
    L12:
        if (compareObj(getParameters().getEncryptionParamSetOID(), r101.getParameters().getEncryptionParamSetOID()) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "GOST3410";
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
        byte[] r100 = getX().toByteArray();
        int r101 = 0;
        if (r100[0] != 0) goto L5;
        int r102 = r100.length - 1;
    L6:
        byte[] r103 = new byte[r102];
    L8:
        if (r101 == r103.length) goto L18;
        r103[r101] = r100[(r100.length - 1) - r101];
        r101 = r101 + 1;
        goto L8
    L18:
    L16:
        return null;
    L11:
        if ((this.gost3410Spec instanceof GOST3410ParameterSpec) == false) goto L13;
        PrivateKeyInfo r104 = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()))), new DEROctetString(r103));     // Catch: IOException -> L16
    L14:
        return r104.getEncoded(ASN1Encoding.DER);
    L13:
        r104 = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94), new DEROctetString(r103));     // Catch: IOException -> L16
        goto L14
    L5:
        r102 = r100.length;
        goto L6
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Key
    public GOST3410Params getParameters() {
        return this.gost3410Spec;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410PrivateKey
    public BigInteger getX() {
        return this.f525367x;
    }

    public int hashCode() {
        return getX().hashCode() ^ this.gost3410Spec.hashCode();
    }

    @Override // org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.attrCarrier.setBagAttribute(r100, r101);
    }

    public String toString() {
        return GOSTUtil.privateKeyToString("GOST3410", this.f525367x, ((GOST3410PrivateKeyParameters) GOST3410Util.generatePrivateKeyParameter(this)).getParameters());
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    }
}
