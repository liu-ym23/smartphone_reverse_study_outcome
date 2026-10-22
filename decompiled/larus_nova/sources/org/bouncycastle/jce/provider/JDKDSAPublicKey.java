package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class JDKDSAPublicKey implements DSAPublicKey {
    private static final long serialVersionUID = 1752452449903495175L;
    private DSAParams dsaSpec;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525398y;

    public JDKDSAPublicKey(BigInteger r100, DSAParameterSpec r101) {
        this.f525398y = r100;
        this.dsaSpec = r101;
    }

    public JDKDSAPublicKey(DSAPublicKey r100) {
        this.f525398y = r100.getY();
        this.dsaSpec = r100.getParams();
    }

    public JDKDSAPublicKey(DSAPublicKeySpec r100) {
        this.f525398y = r100.getY();
        this.dsaSpec = new DSAParameterSpec(r100.getP(), r100.getQ(), r100.getG());
    }

    public JDKDSAPublicKey(SubjectPublicKeyInfo r100) {
        this.f525398y = ((ASN1Integer) r100.parsePublicKey()).getValue();
        if (isNotNull(r100.getAlgorithm().getParameters()) == false) goto L12;
        DSAParameter r101 = DSAParameter.getInstance(r100.getAlgorithm().getParameters());
        this.dsaSpec = new DSAParameterSpec(r101.getP(), r101.getQ(), r101.getG());
        return;
    L12:
        return;
    L9:
        throw new IllegalArgumentException("invalid info structure in DSA public key");
    }

    public JDKDSAPublicKey(DSAPublicKeyParameters r100) {
        this.f525398y = r100.getY();
        this.dsaSpec = new DSAParameterSpec(r100.getParameters().getP(), r100.getParameters().getQ(), r100.getParameters().getG());
    }

    private boolean isNotNull(ASN1Encodable r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (DERNull.INSTANCE.equals(r100) == true) goto L6;
        return true;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        this.f525398y = (BigInteger) r100.readObject();
        this.dsaSpec = new DSAParameterSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject(), (BigInteger) r100.readObject());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeObject(this.f525398y);
        r100.writeObject(this.dsaSpec.getP());
        r100.writeObject(this.dsaSpec.getQ());
        r100.writeObject(this.dsaSpec.getG());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DSAPublicKey) == true) goto L5;
        return false;
    L5:
        DSAPublicKey r101 = (DSAPublicKey) r100;
        if (getY().equals(r101.getY()) == true) goto L8;
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

    @Override // java.security.Key
    public byte[] getEncoded() {
        DSAParams r100 = this.dsaSpec;     // Catch: IOException -> L9
        if (r100 != null) goto L8;
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa), new ASN1Integer(this.f525398y)).getEncoded(ASN1Encoding.DER);
    L8:
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(r100.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG())), new ASN1Integer(this.f525398y)).getEncoded(ASN1Encoding.DER);
    L9:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.dsaSpec;
    }

    @Override // java.security.interfaces.DSAPublicKey
    public BigInteger getY() {
        return this.f525398y;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("DSA Public Key");
        String r101 = Strings.lineSeparator();
        r100.append(r101);
        r100.append("            y: ");
        r100.append(getY().toString(16));
        r100.append(r101);
        return r100.toString();
    }
}
