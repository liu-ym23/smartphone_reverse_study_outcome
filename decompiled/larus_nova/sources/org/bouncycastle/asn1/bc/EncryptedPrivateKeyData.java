package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.x509.Certificate;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedPrivateKeyData extends ASN1Object {
    private final Certificate[] certificateChain;
    private final EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;

    private EncryptedPrivateKeyData(ASN1Sequence r100) {
        int r101 = 0;
        this.encryptedPrivateKeyInfo = EncryptedPrivateKeyInfo.getInstance(r100.getObjectAt(0));
        ASN1Sequence r102 = ASN1Sequence.getInstance(r100.getObjectAt(1));
        this.certificateChain = new Certificate[r102.size()];
    L3:
        Certificate[] r103 = this.certificateChain;
        if (r101 == r103.length) goto L6;
        r103[r101] = Certificate.getInstance(r102.getObjectAt(r101));
        r101 = r101 + 1;
        goto L3
    }

    public EncryptedPrivateKeyData(EncryptedPrivateKeyInfo r100, Certificate[] r101) {
        this.encryptedPrivateKeyInfo = r100;
        Certificate[] r102 = new Certificate[r101.length];
        this.certificateChain = r102;
        System.arraycopy(r101, 0, r102, 0, r101.length);
    }

    public static EncryptedPrivateKeyData getInstance(Object r100) {
        if ((r100 instanceof EncryptedPrivateKeyData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptedPrivateKeyData(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptedPrivateKeyData) r100;
    }

    public Certificate[] getCertificateChain() {
        Certificate[] r100 = this.certificateChain;
        Certificate[] r101 = new Certificate[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public EncryptedPrivateKeyInfo getEncryptedPrivateKeyInfo() {
        return this.encryptedPrivateKeyInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.encryptedPrivateKeyInfo);
        r100.add(new DERSequence(this.certificateChain));
        return new DERSequence(r100);
    }
}
