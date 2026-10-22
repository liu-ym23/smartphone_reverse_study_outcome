package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class BCDSAPublicKey implements DSAPublicKey {
    private static BigInteger ZERO = null;
    private static final long serialVersionUID = 1752452449903495175L;
    private transient DSAParams dsaSpec;
    private transient DSAPublicKeyParameters lwKeyParams;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525359y;

    static {
        ZERO = BigInteger.valueOf(0);
    }

    public BCDSAPublicKey(DSAPublicKey r100) {
        this.f525359y = r100.getY();
        this.dsaSpec = r100.getParams();
        this.lwKeyParams = new DSAPublicKeyParameters(this.f525359y, DSAUtil.toDSAParameters(this.dsaSpec));
    }

    public BCDSAPublicKey(DSAPublicKeySpec r100) {
        this.f525359y = r100.getY();
        this.dsaSpec = new DSAParameterSpec(r100.getP(), r100.getQ(), r100.getG());
        this.lwKeyParams = new DSAPublicKeyParameters(this.f525359y, DSAUtil.toDSAParameters(this.dsaSpec));
    }

    public BCDSAPublicKey(SubjectPublicKeyInfo r100) {
        this.f525359y = ((ASN1Integer) r100.parsePublicKey()).getValue();
        if (isNotNull(r100.getAlgorithm().getParameters()) == false) goto L7;
        DSAParameter r101 = DSAParameter.getInstance(r100.getAlgorithm().getParameters());
        this.dsaSpec = new DSAParameterSpec(r101.getP(), r101.getQ(), r101.getG());
    L8:
        this.lwKeyParams = new DSAPublicKeyParameters(this.f525359y, DSAUtil.toDSAParameters(this.dsaSpec));
        return;
    L7:
        this.dsaSpec = null;
    L11:
        throw new IllegalArgumentException("invalid info structure in DSA public key");
    }

    public BCDSAPublicKey(DSAPublicKeyParameters r100) {
        this.f525359y = r100.getY();
        if (r100.getParameters() == null) goto L5;
        DSAParameterSpec r101 = new DSAParameterSpec(r100.getParameters().getP(), r100.getParameters().getQ(), r100.getParameters().getG());
    L6:
        this.dsaSpec = r101;
        this.lwKeyParams = r100;
        return;
    L5:
        r101 = null;
        goto L6
    }

    private boolean isNotNull(ASN1Encodable r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (DERNull.INSTANCE.equals(r100.toASN1Primitive()) == true) goto L6;
        return true;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        BigInteger r101 = (BigInteger) r100.readObject();
        if (r101.equals(ZERO) == false) goto L5;
        this.dsaSpec = null;
    L6:
        this.lwKeyParams = new DSAPublicKeyParameters(this.f525359y, DSAUtil.toDSAParameters(this.dsaSpec));
        return;
    L5:
        this.dsaSpec = new DSAParameterSpec(r101, (BigInteger) r100.readObject(), (BigInteger) r100.readObject());
        goto L6
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        DSAParams r101 = this.dsaSpec;
        if (r101 != null) goto L5;
        BigInteger r102 = ZERO;
    L6:
        r100.writeObject(r102);
        return;
    L5:
        r100.writeObject(r101.getP());
        r100.writeObject(this.dsaSpec.getQ());
        r102 = this.dsaSpec.getG();
        goto L6
    }

    public DSAPublicKeyParameters engineGetKeyParameters() {
        return this.lwKeyParams;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof DSAPublicKey) == true) goto L5;
        return false;
    L5:
        DSAPublicKey r101 = (DSAPublicKey) r100;
        if (this.dsaSpec == null) goto L20;
        if (getY().equals(r101.getY()) == true) goto L10;
        return false;
    L10:
        if (r101.getParams() != null) goto L12;
        return false;
    L12:
        if (getParams().getG().equals(r101.getParams().getG()) == true) goto L14;
        return false;
    L14:
        if (getParams().getP().equals(r101.getParams().getP()) == true) goto L16;
        return false;
    L16:
        if (getParams().getQ().equals(r101.getParams().getQ()) == false) goto L29;
        return true;
    L29:
        return false;
    L20:
        if (getY().equals(r101.getY()) == true) goto L22;
        return false;
    L22:
        if (r101.getParams() != null) goto L31;
        return true;
    L31:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        DSAParams r100 = this.dsaSpec;
        if (r100 != null) goto L7;
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa), new ASN1Integer(this.f525359y));
    L7:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(r100.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG()).toASN1Primitive()), new ASN1Integer(this.f525359y));
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
        return this.f525359y;
    }

    public int hashCode() {
        if (this.dsaSpec == null) goto L7;
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    L7:
        return getY().hashCode();
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("DSA Public Key [");
        String r101 = Strings.lineSeparator();
        r100.append(DSAUtil.generateKeyFingerprint(this.f525359y, getParams()));
        r100.append("]");
        r100.append(r101);
        r100.append("            Y: ");
        r100.append(getY().toString(16));
        r100.append(r101);
        return r100.toString();
    }
}
