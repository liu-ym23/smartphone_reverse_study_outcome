package org.bouncycastle.pqc.jcajce.provider.qtesla;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPublicKeyParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLASecurityCategory;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.QTESLAKey;
import org.bouncycastle.pqc.jcajce.spec.QTESLAParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BCqTESLAPublicKey implements PublicKey, QTESLAKey {
    private static final long serialVersionUID = 1;
    private transient QTESLAPublicKeyParameters keyParams;

    public BCqTESLAPublicKey(SubjectPublicKeyInfo r100) throws IOException {
        init(r100);
    }

    public BCqTESLAPublicKey(QTESLAPublicKeyParameters r100) {
        this.keyParams = r100;
    }

    private void init(SubjectPublicKeyInfo r100) throws IOException {
        this.keyParams = (QTESLAPublicKeyParameters) PublicKeyFactory.createKey(r100);
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        init(SubjectPublicKeyInfo.getInstance((byte[]) r100.readObject()));
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(getEncoded());
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BCqTESLAPublicKey) == false) goto L14;
        BCqTESLAPublicKey r101 = (BCqTESLAPublicKey) r100;
        if (this.keyParams.getSecurityCategory() == r101.keyParams.getSecurityCategory()) goto L10;
    L12:
        return false;
    L10:
        if (Arrays.areEqual(this.keyParams.getPublicData(), r101.keyParams.getPublicData()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return QTESLASecurityCategory.getName(this.keyParams.getSecurityCategory());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.keyParams).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.QTESLAKey
    public QTESLAParameterSpec getParams() {
        return new QTESLAParameterSpec(getAlgorithm());
    }

    public int hashCode() {
        return this.keyParams.getSecurityCategory() + (Arrays.hashCode(this.keyParams.getPublicData()) * 37);
    }
}
