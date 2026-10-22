package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BCXMSSPublicKey implements PublicKey, XMSSKey {
    private static final long serialVersionUID = -5617456225328969766L;
    private transient XMSSPublicKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSPublicKey(ASN1ObjectIdentifier r100, XMSSPublicKeyParameters r101) {
        this.treeDigest = r100;
        this.keyParams = r101;
    }

    public BCXMSSPublicKey(SubjectPublicKeyInfo r100) throws IOException {
        init(r100);
    }

    private void init(SubjectPublicKeyInfo r100) throws IOException {
        XMSSPublicKeyParameters r101 = (XMSSPublicKeyParameters) PublicKeyFactory.createKey(r100);
        this.keyParams = r101;
        this.treeDigest = DigestUtil.getDigestOID(r101.getTreeDigest());
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
        if ((r100 instanceof BCXMSSPublicKey) == false) goto L15;
        BCXMSSPublicKey r101 = (BCXMSSPublicKey) r100;
        if (this.treeDigest.equals(r101.treeDigest) == false) goto L13;
        if (Arrays.areEqual(this.keyParams.getEncoded(), r101.keyParams.getEncoded()) == false) goto L13;
        return true;
    L13:
        return false;
    L15:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
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

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSKey
    public int getHeight() {
        return this.keyParams.getParameters().getHeight();
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSKey
    public String getTreeDigest() {
        return DigestUtil.getXMSSDigestName(this.treeDigest);
    }

    public int hashCode() {
        int r100 = this.treeDigest.hashCode();     // Catch: IOException -> L5
        return r100 + (Arrays.hashCode(this.keyParams.getEncoded()) * 37);
    L6:
        return this.treeDigest.hashCode();
    }
}
