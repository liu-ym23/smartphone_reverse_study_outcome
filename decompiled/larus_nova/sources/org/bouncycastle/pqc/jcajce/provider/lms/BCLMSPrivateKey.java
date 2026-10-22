package org.bouncycastle.pqc.jcajce.provider.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.util.PrivateKeyFactory;
import org.bouncycastle.pqc.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BCLMSPrivateKey implements PrivateKey, LMSPrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;
    private transient ASN1Set attributes;
    private transient LMSKeyParameters keyParams;

    public BCLMSPrivateKey(PrivateKeyInfo r100) throws IOException {
        init(r100);
    }

    public BCLMSPrivateKey(LMSKeyParameters r100) {
        this.keyParams = r100;
    }

    private void init(PrivateKeyInfo r100) throws IOException {
        this.attributes = r100.getAttributes();
        this.keyParams = (LMSKeyParameters) PrivateKeyFactory.createKey(r100);
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
        if ((r100 instanceof BCLMSPrivateKey) == false) goto L12;
        BCLMSPrivateKey r101 = (BCLMSPrivateKey) r100;
        return Arrays.areEqual(this.keyParams.getEncoded(), r101.keyParams.getEncoded());
    L11:
        throw new IllegalStateException("unable to perform equals");
    L12:
        return false;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public LMSPrivateKey extractKeyShard(int r100) {
        LMSKeyParameters r101 = this.keyParams;
        if ((r101 instanceof LMSPrivateKeyParameters) == false) goto L7;
        return new BCLMSPrivateKey(((LMSPrivateKeyParameters) r101).extractKeyShard(r100));
    L7:
        return new BCLMSPrivateKey(((HSSPrivateKeyParameters) r101).extractKeyShard(r100));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "LMS";
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

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public long getIndex() {
        if (getUsagesRemaining() == 0) goto L11;
        LMSKeyParameters r100 = this.keyParams;
        if ((r100 instanceof LMSPrivateKeyParameters) == false) goto L9;
        return ((LMSPrivateKeyParameters) r100).getIndex();
    L9:
        return ((HSSPrivateKeyParameters) r100).getIndex();
    L11:
        throw new IllegalStateException("key exhausted");
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSKey
    public int getLevels() {
        LMSKeyParameters r100 = this.keyParams;
        if ((r100 instanceof LMSPrivateKeyParameters) == false) goto L7;
        return 1;
    L7:
        return ((HSSPrivateKeyParameters) r100).getL();
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey
    public long getUsagesRemaining() {
        LMSKeyParameters r100 = this.keyParams;
        if ((r100 instanceof LMSPrivateKeyParameters) == false) goto L7;
        return ((LMSPrivateKeyParameters) r100).getUsagesRemaining();
    L7:
        return ((HSSPrivateKeyParameters) r100).getUsagesRemaining();
    }

    public int hashCode() {
        return Arrays.hashCode(this.keyParams.getEncoded());
    L5:
        throw new IllegalStateException("unable to calculate hashCode");
    }
}
