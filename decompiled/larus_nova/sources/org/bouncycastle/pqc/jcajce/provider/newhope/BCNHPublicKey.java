package org.bouncycastle.pqc.jcajce.provider.newhope;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.bouncycastle.pqc.crypto.util.PublicKeyFactory;
import org.bouncycastle.pqc.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.NHPublicKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BCNHPublicKey implements NHPublicKey {
    private static final long serialVersionUID = 1;
    private transient NHPublicKeyParameters params;

    public BCNHPublicKey(SubjectPublicKeyInfo r100) throws IOException {
        init(r100);
    }

    public BCNHPublicKey(NHPublicKeyParameters r100) {
        this.params = r100;
    }

    private void init(SubjectPublicKeyInfo r100) throws IOException {
        this.params = (NHPublicKeyParameters) PublicKeyFactory.createKey(r100);
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
        if (r100 != null) goto L4;
        return false;
    L4:
        if ((r100 instanceof BCNHPublicKey) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.params.getPubData(), ((BCNHPublicKey) r100).params.getPubData());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.params).getEncoded();
    L4:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public CipherParameters getKeyParams() {
        return this.params;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.NHPublicKey
    public byte[] getPublicData() {
        return this.params.getPubData();
    }

    public int hashCode() {
        return Arrays.hashCode(this.params.getPubData());
    }
}
