package org.bouncycastle.jcajce.provider.asymmetric.dh;

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
import org.bouncycastle.asn1.x9.DomainParameters;
import org.bouncycastle.asn1.x9.ValidationParams;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.spec.DHDomainParameterSpec;
import org.bouncycastle.jcajce.spec.DHExtendedPublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class BCDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    private transient DHPublicKeyParameters dhPublicKey;
    private transient DHParameterSpec dhSpec;
    private transient SubjectPublicKeyInfo info;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525354y;

    public BCDHPublicKey(BigInteger r100, DHParameterSpec r101) {
        this.f525354y = r100;
        this.dhSpec = r101;
        if ((r101 instanceof DHDomainParameterSpec) == false) goto L5;
        DHPublicKeyParameters r102 = new DHPublicKeyParameters(r100, ((DHDomainParameterSpec) r101).getDomainParameters());
    L6:
        this.dhPublicKey = r102;
        return;
    L5:
        r102 = new DHPublicKeyParameters(r100, new DHParameters(r101.getP(), r101.getG()));
        goto L6
    }

    public BCDHPublicKey(DHPublicKey r100) {
        this.f525354y = r100.getY();
        DHParameterSpec r101 = r100.getParams();
        this.dhSpec = r101;
        if ((r101 instanceof DHDomainParameterSpec) == false) goto L5;
        this.dhPublicKey = new DHPublicKeyParameters(this.f525354y, ((DHDomainParameterSpec) r101).getDomainParameters());
        return;
    L5:
        this.dhPublicKey = new DHPublicKeyParameters(this.f525354y, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG()));
    }

    public BCDHPublicKey(DHPublicKeySpec r100) {
        this.f525354y = r100.getY();
        if ((r100 instanceof DHExtendedPublicKeySpec) == false) goto L5;
        DHParameterSpec r101 = ((DHExtendedPublicKeySpec) r100).getParams();
    L6:
        this.dhSpec = r101;
        DHParameterSpec r102 = this.dhSpec;
        if ((r102 instanceof DHDomainParameterSpec) == false) goto L9;
        this.dhPublicKey = new DHPublicKeyParameters(this.f525354y, ((DHDomainParameterSpec) r102).getDomainParameters());
        return;
    L9:
        this.dhPublicKey = new DHPublicKeyParameters(this.f525354y, new DHParameters(r100.getP(), r100.getG()));
        return;
    L5:
        r101 = new DHParameterSpec(r100.getP(), r100.getG());
        goto L6
    }

    public BCDHPublicKey(SubjectPublicKeyInfo r110) {
        this.info = r110;
        this.f525354y = ((ASN1Integer) r110.parsePublicKey()).getValue();
        ASN1Sequence r100 = ASN1Sequence.getInstance(r110.getAlgorithm().getParameters());
        ASN1ObjectIdentifier r111 = r110.getAlgorithm().getAlgorithm();
        if (r111.equals(PKCSObjectIdentifiers.dhKeyAgreement) == false) goto L7;
    L18:
        DHParameter r112 = DHParameter.getInstance(r100);
        if (r112.getL() == null) goto L21;
        this.dhSpec = new DHParameterSpec(r112.getP(), r112.getG(), r112.getL().intValue());
        DHPublicKeyParameters r113 = new DHPublicKeyParameters(this.f525354y, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG(), null, this.dhSpec.getL()));
    L22:
        this.dhPublicKey = r113;
        return;
    L21:
        this.dhSpec = new DHParameterSpec(r112.getP(), r112.getG());
        r113 = new DHPublicKeyParameters(this.f525354y, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG()));
        goto L22
    L7:
        if (isPKCSParam(r100) == true) goto L18;
        if (r111.equals(X9ObjectIdentifiers.dhpublicnumber) == false) goto L17;
        DomainParameters r114 = DomainParameters.getInstance(r100);
        ValidationParams r101 = r114.getValidationParams();
        if (r101 == null) goto L14;
        this.dhPublicKey = new DHPublicKeyParameters(this.f525354y, new DHParameters(r114.getP(), r114.getG(), r114.getQ(), r114.getJ(), new DHValidationParameters(r101.getSeed(), r101.getPgenCounter().intValue())));
    L15:
        this.dhSpec = new DHDomainParameterSpec(this.dhPublicKey.getParameters());
        return;
    L14:
        this.dhPublicKey = new DHPublicKeyParameters(this.f525354y, new DHParameters(r114.getP(), r114.getG(), r114.getQ(), r114.getJ(), null));
        goto L15
    L17:
        throw new IllegalArgumentException("unknown algorithm type: " + r111);
    L25:
        throw new IllegalArgumentException("invalid info structure in DH public key");
    }

    public BCDHPublicKey(DHPublicKeyParameters r100) {
        this.f525354y = r100.getY();
        this.dhSpec = new DHDomainParameterSpec(r100.getParameters());
        this.dhPublicKey = r100;
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
        r100.defaultReadObject();
        this.dhSpec = new DHParameterSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject(), r100.readInt());
        this.info = null;
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(this.dhSpec.getP());
        r100.writeObject(this.dhSpec.getG());
        r100.writeInt(this.dhSpec.getL());
    }

    public DHPublicKeyParameters engineGetKeyParameters() {
        return this.dhPublicKey;
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
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        SubjectPublicKeyInfo r100 = this.info;
        if (r100 != null) goto L5;
        DHParameterSpec r101 = this.dhSpec;
        if ((r101 instanceof DHDomainParameterSpec) == false) goto L17;
        if (((DHDomainParameterSpec) r101).getQ() == null) goto L17;
        DHParameters r102 = ((DHDomainParameterSpec) this.dhSpec).getDomainParameters();
        DHValidationParameters r103 = r102.getValidationParameters();
        if (r103 == null) goto L13;
        ValidationParams r104 = new ValidationParams(r103.getSeed(), r103.getCounter());
    L14:
        ValidationParams r105 = r104;
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.dhpublicnumber, new DomainParameters(r102.getP(), r102.getG(), r102.getQ(), r102.getJ(), r105).toASN1Primitive()), new ASN1Integer(this.f525354y));
    L13:
        r104 = null;
    L17:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).toASN1Primitive()), new ASN1Integer(this.f525354y));
    L5:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(r100);
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
        return this.f525354y;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public String toString() {
        return DHUtil.publicKeyToString("DH", this.f525354y, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG()));
    }
}
