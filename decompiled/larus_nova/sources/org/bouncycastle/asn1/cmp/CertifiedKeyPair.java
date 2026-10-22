package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.EncryptedKey;
import org.bouncycastle.asn1.crmf.EncryptedValue;
import org.bouncycastle.asn1.crmf.PKIPublicationInfo;

/* JADX INFO: loaded from: classes42.dex */
public class CertifiedKeyPair extends ASN1Object {
    private CertOrEncCert certOrEncCert;
    private EncryptedKey privateKey;
    private PKIPublicationInfo publicationInfo;

    private CertifiedKeyPair(ASN1Sequence r100) {
        this.certOrEncCert = CertOrEncCert.getInstance(r100.getObjectAt(0));
        if (r100.size() >= 2) goto L5;
        return;
    L5:
        if (r100.size() != 2) goto L9;
        ASN1TaggedObject r101 = ASN1TaggedObject.getInstance(r100.getObjectAt(1));
        int r102 = r101.getTagNo();
        ASN1Primitive r103 = r101.getObject();
        if (r102 != 0) goto L10;
        this.privateKey = EncryptedKey.getInstance(r103);
        return;
    L10:
        this.publicationInfo = PKIPublicationInfo.getInstance(r103);
        return;
    L9:
        this.privateKey = EncryptedKey.getInstance(ASN1TaggedObject.getInstance(r100.getObjectAt(1)).getObject());
        r103 = ASN1TaggedObject.getInstance(r100.getObjectAt(2)).getObject();
        goto L10
    }

    public CertifiedKeyPair(CertOrEncCert r100) {
        this(r100, null, null);
    }

    public CertifiedKeyPair(CertOrEncCert r100, EncryptedKey r101, PKIPublicationInfo r102) {
        if (r100 == null) goto L7;
        this.certOrEncCert = r100;
        this.privateKey = r101;
        this.publicationInfo = r102;
        return;
    L7:
        throw new IllegalArgumentException("'certOrEncCert' cannot be null");
    }

    public CertifiedKeyPair(CertOrEncCert r100, EncryptedValue r101, PKIPublicationInfo r102) {
        if (r100 == null) goto L11;
        this.certOrEncCert = r100;
        if (r101 == null) goto L7;
        EncryptedKey r103 = new EncryptedKey(r101);
    L8:
        this.privateKey = r103;
        this.publicationInfo = r102;
        return;
    L7:
        r103 = null;
        goto L8
    L11:
        throw new IllegalArgumentException("'certOrEncCert' cannot be null");
    }

    public static CertifiedKeyPair getInstance(Object r100) {
        if ((r100 instanceof CertifiedKeyPair) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertifiedKeyPair(ASN1Sequence.getInstance(r100));
    L5:
        return (CertifiedKeyPair) r100;
    }

    public CertOrEncCert getCertOrEncCert() {
        return this.certOrEncCert;
    }

    public EncryptedKey getPrivateKey() {
        return this.privateKey;
    }

    public PKIPublicationInfo getPublicationInfo() {
        return this.publicationInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.certOrEncCert);
        EncryptedKey r101 = this.privateKey;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, r101));
    L5:
        PKIPublicationInfo r102 = this.publicationInfo;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(true, 1, r102));
    L9:
        return new DERSequence(r100);
    }
}
