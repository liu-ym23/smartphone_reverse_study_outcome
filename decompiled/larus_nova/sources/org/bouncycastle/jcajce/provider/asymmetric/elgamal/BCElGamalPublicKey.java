package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class BCElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    private transient ElGamalParameterSpec elSpec;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525366y;

    public BCElGamalPublicKey(BigInteger r100, ElGamalParameterSpec r101) {
        this.f525366y = r100;
        this.elSpec = r101;
    }

    public BCElGamalPublicKey(DHPublicKey r100) {
        this.f525366y = r100.getY();
        this.elSpec = new ElGamalParameterSpec(r100.getParams().getP(), r100.getParams().getG());
    }

    public BCElGamalPublicKey(DHPublicKeySpec r100) {
        this.f525366y = r100.getY();
        this.elSpec = new ElGamalParameterSpec(r100.getP(), r100.getG());
    }

    public BCElGamalPublicKey(SubjectPublicKeyInfo r100) {
        ElGamalParameter r101 = ElGamalParameter.getInstance(r100.getAlgorithm().getParameters());
        this.f525366y = ((ASN1Integer) r100.parsePublicKey()).getValue();
        this.elSpec = new ElGamalParameterSpec(r101.getP(), r101.getG());
        return;
    L7:
        throw new IllegalArgumentException("invalid info structure in DSA public key");
    }

    public BCElGamalPublicKey(ElGamalPublicKeyParameters r100) {
        this.f525366y = r100.getY();
        this.elSpec = new ElGamalParameterSpec(r100.getParameters().getP(), r100.getParameters().getG());
    }

    public BCElGamalPublicKey(ElGamalPublicKey r100) {
        this.f525366y = r100.getY();
        this.elSpec = r100.getParameters();
    }

    public BCElGamalPublicKey(ElGamalPublicKeySpec r100) {
        this.f525366y = r100.getY();
        this.elSpec = new ElGamalParameterSpec(r100.getParams().getP(), r100.getParams().getG());
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        this.elSpec = new ElGamalParameterSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(this.elSpec.getP());
        r100.writeObject(this.elSpec.getG());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DHPublicKey) == true) goto L5;
        return false;
    L5:
        DHPublicKey r101 = (DHPublicKey) r100;
        if (getY().equals(r101.getY()) == true) goto L8;
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

    @Override // java.security.Key
    public byte[] getEncoded() {
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), new ASN1Integer(this.f525366y)).getEncoded(ASN1Encoding.DER);
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalKey
    public ElGamalParameterSpec getParameters() {
        return this.elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.getP(), this.elSpec.getG());
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPublicKey, javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f525366y;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }
}
