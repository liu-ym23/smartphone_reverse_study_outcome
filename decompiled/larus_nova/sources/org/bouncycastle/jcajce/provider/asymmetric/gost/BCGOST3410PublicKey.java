package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.GOST3410Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jce.interfaces.GOST3410Params;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class BCGOST3410PublicKey implements GOST3410PublicKey {
    static final long serialVersionUID = -6251023343619275990L;
    private transient GOST3410Params gost3410Spec;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525368y;

    public BCGOST3410PublicKey(BigInteger r100, GOST3410ParameterSpec r101) {
        this.f525368y = r100;
        this.gost3410Spec = r101;
    }

    public BCGOST3410PublicKey(SubjectPublicKeyInfo r100) {
        GOST3410PublicKeyAlgParameters r101 = GOST3410PublicKeyAlgParameters.getInstance(r100.getAlgorithm().getParameters());
        byte[] r102 = ((DEROctetString) r100.parsePublicKey()).getOctets();     // Catch: IOException -> L10
        byte[] r103 = new byte[r102.length];     // Catch: IOException -> L10
        int r104 = 0;
    L5:
        if (r104 == r102.length) goto L7;
        r103[r104] = r102[(r102.length - 1) - r104];     // Catch: IOException -> L10
        r104 = r104 + 1;     // Catch: IOException -> L10
        goto L5
    L7:
        this.f525368y = new BigInteger(1, r103);     // Catch: IOException -> L10
        this.gost3410Spec = GOST3410ParameterSpec.fromPublicKeyAlg(r101);
        return;
    L11:
        throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
    }

    public BCGOST3410PublicKey(GOST3410PublicKeyParameters r100, GOST3410ParameterSpec r101) {
        this.f525368y = r100.getY();
        this.gost3410Spec = r101;
    }

    public BCGOST3410PublicKey(GOST3410PublicKey r100) {
        this.f525368y = r100.getY();
        this.gost3410Spec = r100.getParameters();
    }

    public BCGOST3410PublicKey(GOST3410PublicKeySpec r100) {
        this.f525368y = r100.getY();
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(r100.getP(), r100.getQ(), r100.getA()));
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        String r101 = (String) r100.readObject();
        if (r101 == null) goto L5;
        this.gost3410Spec = new GOST3410ParameterSpec(r101, (String) r100.readObject(), (String) r100.readObject());
        return;
    L5:
        this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject(), (BigInteger) r100.readObject()));
        r100.readObject();
        r100.readObject();
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
        if ((r100 instanceof BCGOST3410PublicKey) == false) goto L10;
        BCGOST3410PublicKey r101 = (BCGOST3410PublicKey) r100;
        if (this.f525368y.equals(r101.f525368y) == true) goto L7;
        return false;
    L7:
        if (this.gost3410Spec.equals(r101.gost3410Spec) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "GOST3410";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] r100 = getY().toByteArray();
        int r101 = 0;
        if (r100[0] != 0) goto L5;
        int r102 = r100.length - 1;
    L6:
        byte[] r103 = new byte[r102];
    L8:
        if (r101 == r103.length) goto L21;
        r103[r101] = r100[(r100.length - 1) - r101];
        r101 = r101 + 1;
        goto L8
    L21:
        GOST3410Params r104 = this.gost3410Spec;     // Catch: IOException -> L19
        if ((r104 instanceof GOST3410ParameterSpec) == true) goto L13;
        SubjectPublicKeyInfo r105 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94), new DEROctetString(r103));     // Catch: IOException -> L19
    L17:
        return KeyUtil.getEncodedSubjectPublicKeyInfo(r105);
    L13:
        if (r104.getEncryptionParamSetOID() == null) goto L15;
        r105 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getEncryptionParamSetOID()))), new DEROctetString(r103));     // Catch: IOException -> L19
        goto L17
    L15:
        r105 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()))), new DEROctetString(r103));     // Catch: IOException -> L19
    L19:
        return null;
    L5:
        r102 = r100.length;
        goto L6
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410Key
    public GOST3410Params getParameters() {
        return this.gost3410Spec;
    }

    @Override // org.bouncycastle.jce.interfaces.GOST3410PublicKey
    public BigInteger getY() {
        return this.f525368y;
    }

    public int hashCode() {
        return this.f525368y.hashCode() ^ this.gost3410Spec.hashCode();
    }

    public String toString() {
        return GOSTUtil.publicKeyToString("GOST3410", this.f525368y, ((GOST3410PublicKeyParameters) GOST3410Util.generatePublicKeyParameter(this)).getParameters());
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    }
}
