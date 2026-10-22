package org.bouncycastle.pqc.jcajce.provider.qtesla;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLASecurityCategory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.QTESLAKey;
import org.bouncycastle.pqc.jcajce.spec.QTESLAParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BCqTESLAPrivateKey implements PrivateKey, QTESLAKey {
    private static final long serialVersionUID = 1;
    private transient ASN1Set attributes;
    private transient QTESLAPrivateKeyParameters keyParams;

    public BCqTESLAPrivateKey(PrivateKeyInfo r100) throws IOException {
        init(r100);
    }

    public BCqTESLAPrivateKey(QTESLAPrivateKeyParameters r100) {
        this.keyParams = r100;
    }

    private void init(PrivateKeyInfo r100) throws IOException {
        this.attributes = r100.getAttributes();
        this.keyParams = (QTESLAPrivateKeyParameters) PrivateKeyFactory.createKey(r100);
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        init(PrivateKeyInfo.getInstance((byte[]) r100.readObject()));
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(getEncoded());
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BCqTESLAPrivateKey) == false) goto L14;
        BCqTESLAPrivateKey r101 = (BCqTESLAPrivateKey) r100;
        if (this.keyParams.getSecurityCategory() == r101.keyParams.getSecurityCategory()) goto L10;
    L12:
        return false;
    L10:
        if (Arrays.areEqual(this.keyParams.getSecret(), r101.keyParams.getSecret()) == false) goto L12;
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
        return PrivateKeyInfoFactory.createPrivateKeyInfo(this.keyParams, this.attributes).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.QTESLAKey
    public QTESLAParameterSpec getParams() {
        return new QTESLAParameterSpec(getAlgorithm());
    }

    public int hashCode() {
        return this.keyParams.getSecurityCategory() + (Arrays.hashCode(this.keyParams.getSecret()) * 37);
    }
}
