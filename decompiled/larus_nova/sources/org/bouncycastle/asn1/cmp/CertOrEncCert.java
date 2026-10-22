package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.EncryptedKey;
import org.bouncycastle.asn1.crmf.EncryptedValue;

/* JADX INFO: loaded from: classes42.dex */
public class CertOrEncCert extends ASN1Object implements ASN1Choice {
    private CMPCertificate certificate;
    private EncryptedKey encryptedKey;

    private CertOrEncCert(ASN1TaggedObject r100) {
        if (r100.getTagNo() != 0) goto L6;
        this.certificate = CMPCertificate.getInstance(r100.getObject());
        return;
    L6:
        if (r100.getTagNo() != 1) goto L10;
        this.encryptedKey = EncryptedKey.getInstance(r100.getObject());
        return;
    L10:
        throw new IllegalArgumentException("unknown tag: " + r100.getTagNo());
    }

    public CertOrEncCert(CMPCertificate r100) {
        if (r100 == null) goto L7;
        this.certificate = r100;
        return;
    L7:
        throw new IllegalArgumentException("'certificate' cannot be null");
    }

    public CertOrEncCert(EncryptedKey r100) {
        if (r100 == null) goto L7;
        this.encryptedKey = r100;
        return;
    L7:
        throw new IllegalArgumentException("'encryptedKey' cannot be null");
    }

    public CertOrEncCert(EncryptedValue r100) {
        if (r100 == null) goto L7;
        this.encryptedKey = new EncryptedKey(r100);
        return;
    L7:
        throw new IllegalArgumentException("'encryptedCert' cannot be null");
    }

    public static CertOrEncCert getInstance(Object r100) {
        if ((r100 instanceof CertOrEncCert) == false) goto L7;
        return (CertOrEncCert) r100;
    L7:
        if ((r100 instanceof ASN1TaggedObject) == true) goto L9;
        return null;
    L9:
        return new CertOrEncCert((ASN1TaggedObject) r100);
    }

    public CMPCertificate getCertificate() {
        return this.certificate;
    }

    public EncryptedKey getEncryptedCert() {
        return this.encryptedKey;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        CMPCertificate r100 = this.certificate;
        if (r100 == null) goto L7;
        return new DERTaggedObject(true, 0, r100);
    L7:
        return new DERTaggedObject(true, 1, this.encryptedKey);
    }
}
