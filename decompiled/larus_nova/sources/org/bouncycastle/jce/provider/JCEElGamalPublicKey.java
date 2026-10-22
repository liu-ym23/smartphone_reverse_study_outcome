package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class JCEElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    static final long serialVersionUID = 8712728417091216948L;
    private ElGamalParameterSpec elSpec;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f525396y;

    public JCEElGamalPublicKey(BigInteger r100, ElGamalParameterSpec r101) {
        this.f525396y = r100;
        this.elSpec = r101;
    }

    public JCEElGamalPublicKey(DHPublicKey r100) {
        this.f525396y = r100.getY();
        this.elSpec = new ElGamalParameterSpec(r100.getParams().getP(), r100.getParams().getG());
    }

    public JCEElGamalPublicKey(DHPublicKeySpec r100) {
        this.f525396y = r100.getY();
        this.elSpec = new ElGamalParameterSpec(r100.getP(), r100.getG());
    }

    public JCEElGamalPublicKey(SubjectPublicKeyInfo r100) {
        ElGamalParameter r101 = ElGamalParameter.getInstance(r100.getAlgorithm().getParameters());
        this.f525396y = ((ASN1Integer) r100.parsePublicKey()).getValue();
        this.elSpec = new ElGamalParameterSpec(r101.getP(), r101.getG());
        return;
    L7:
        throw new IllegalArgumentException("invalid info structure in DSA public key");
    }

    public JCEElGamalPublicKey(ElGamalPublicKeyParameters r100) {
        this.f525396y = r100.getY();
        this.elSpec = new ElGamalParameterSpec(r100.getParameters().getP(), r100.getParameters().getG());
    }

    public JCEElGamalPublicKey(ElGamalPublicKey r100) {
        this.f525396y = r100.getY();
        this.elSpec = r100.getParameters();
    }

    public JCEElGamalPublicKey(ElGamalPublicKeySpec r100) {
        this.f525396y = r100.getY();
        this.elSpec = new ElGamalParameterSpec(r100.getParams().getP(), r100.getParams().getG());
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        this.f525396y = (BigInteger) r100.readObject();
        this.elSpec = new ElGamalParameterSpec((BigInteger) r100.readObject(), (BigInteger) r100.readObject());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeObject(getY());
        r100.writeObject(this.elSpec.getP());
        r100.writeObject(this.elSpec.getG());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), new ASN1Integer(this.f525396y));
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
        return this.f525396y;
    }
}
