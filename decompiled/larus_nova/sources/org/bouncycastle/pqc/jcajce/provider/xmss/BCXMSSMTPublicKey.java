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
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BCXMSSMTPublicKey implements PublicKey, XMSSMTKey {
    private static final long serialVersionUID = 3230324130542413475L;
    private transient XMSSMTPublicKeyParameters keyParams;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCXMSSMTPublicKey(ASN1ObjectIdentifier r100, XMSSMTPublicKeyParameters r101) {
        this.treeDigest = r100;
        this.keyParams = r101;
    }

    public BCXMSSMTPublicKey(SubjectPublicKeyInfo r100) throws IOException {
        init(r100);
    }

    private void init(SubjectPublicKeyInfo r100) throws IOException {
        XMSSMTPublicKeyParameters r101 = (XMSSMTPublicKeyParameters) PublicKeyFactory.createKey(r100);
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
        if ((r100 instanceof BCXMSSMTPublicKey) == false) goto L14;
        BCXMSSMTPublicKey r101 = (BCXMSSMTPublicKey) r100;
        if (this.treeDigest.equals(r101.treeDigest) == true) goto L10;
    L12:
        return false;
    L10:
        if (Arrays.areEqual(this.keyParams.toByteArray(), r101.keyParams.toByteArray()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
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

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey
    public int getHeight() {
        return this.keyParams.getParameters().getHeight();
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey
    public int getLayers() {
        return this.keyParams.getParameters().getLayers();
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey
    public String getTreeDigest() {
        return DigestUtil.getXMSSDigestName(this.treeDigest);
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (Arrays.hashCode(this.keyParams.toByteArray()) * 37);
    }
}
