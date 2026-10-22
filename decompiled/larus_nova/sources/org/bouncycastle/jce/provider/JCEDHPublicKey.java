package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.DHDomainParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;

/* JADX INFO: loaded from: classes42.dex */
public class JCEDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    private DHParameterSpec dhSpec;
    private SubjectPublicKeyInfo info;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525392y;

    public JCEDHPublicKey(BigInteger r100, DHParameterSpec r101) {
        this.f525392y = r100;
        this.dhSpec = r101;
    }

    public JCEDHPublicKey(DHPublicKey r100) {
        this.f525392y = r100.getY();
        this.dhSpec = r100.getParams();
    }

    public JCEDHPublicKey(DHPublicKeySpec r100) {
        this.f525392y = r100.getY();
        this.dhSpec = new DHParameterSpec(r100.getP(), r100.getG());
    }

    public JCEDHPublicKey(SubjectPublicKeyInfo r100) {
        this.info = r100;
        this.f525392y = ((ASN1Integer) r100.parsePublicKey()).getValue();
        ASN1Sequence r101 = ASN1Sequence.getInstance(r100.getAlgorithmId().getParameters());
        ASN1ObjectIdentifier r102 = r100.getAlgorithmId().getAlgorithm();
        if (r102.equals(PKCSObjectIdentifiers.dhKeyAgreement) == false) goto L7;
    L15:
        DHParameter r103 = DHParameter.getInstance(r101);
        if (r103.getL() == null) goto L18;
        DHParameterSpec r104 = new DHParameterSpec(r103.getP(), r103.getG(), r103.getL().intValue());
    L12:
        this.dhSpec = r104;
        return;
    L18:
        r104 = new DHParameterSpec(r103.getP(), r103.getG());
        goto L12
    L7:
        if (isPKCSParam(r101) == true) goto L15;
        if (r102.equals(X9ObjectIdentifiers.dhpublicnumber) == false) goto L14;
        DHDomainParameters r105 = DHDomainParameters.getInstance(r101);
        r104 = new DHParameterSpec(r105.getP().getValue(), r105.getG().getValue());
        goto L12
    L14:
        throw new IllegalArgumentException("unknown algorithm type: " + r102);
    L21:
        throw new IllegalArgumentException("invalid info structure in DH public key");
    }

    public JCEDHPublicKey(DHPublicKeyParameters r100) {
        this.f525392y = r100.getY();
        this.dhSpec = new DHParameterSpec(r100.getParameters().getP(), r100.getParameters().getG(), r100.getParameters().getL());
    }

    private boolean isPKCSParam(ASN1Sequence r100) {
        if (r100.size() != 2) goto L6;
        return true;
    L6:
        if (r100.size() <= 3) goto L9;
        return false;
    L9:
        if (ASN1Integer.getInstance(r100.getObjectAt(2)).getValue().compareTo(BigInteger.valueOf(ASN1Integer.getInstance(r100.getObjectAt(0)).getValue().bitLength())) <= 0) goto L11;
        return false;
    L11:
        return true;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        this.f525392y = (BigInteger) r100.readObject();
        this.dhSpec = new DHParameterSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject(), r100.readInt());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeObject(getY());
        r100.writeObject(this.dhSpec.getP());
        r100.writeObject(this.dhSpec.getG());
        r100.writeInt(this.dhSpec.getL());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        SubjectPublicKeyInfo r100 = this.info;
        if (r100 == null) goto L7;
        return KeyUtil.getEncodedSubjectPublicKeyInfo(r100);
    L7:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL())), new ASN1Integer(this.f525392y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f525392y;
    }
}
