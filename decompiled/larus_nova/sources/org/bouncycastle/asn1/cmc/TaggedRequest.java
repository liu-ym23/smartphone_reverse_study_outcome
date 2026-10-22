package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.CertReqMsg;

/* JADX INFO: loaded from: classes42.dex */
public class TaggedRequest extends ASN1Object implements ASN1Choice {
    public static final int CRM = 1;
    public static final int ORM = 2;
    public static final int TCR = 0;
    private final int tagNo;
    private final ASN1Encodable value;

    private TaggedRequest(ASN1Sequence r100) {
        this.tagNo = 2;
        this.value = r100;
    }

    public TaggedRequest(TaggedCertificationRequest r100) {
        this.tagNo = 0;
        this.value = r100;
    }

    public TaggedRequest(CertReqMsg r100) {
        this.tagNo = 1;
        this.value = r100;
    }

    public static TaggedRequest getInstance(Object r100) {
        if ((r100 instanceof TaggedRequest) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        if ((r100 instanceof ASN1Encodable) == false) goto L24;
        ASN1TaggedObject r101 = ASN1TaggedObject.getInstance(((ASN1Encodable) r100).toASN1Primitive());
        int r102 = r101.getTagNo();
        if (r102 == 0) goto L22;
        if (r102 == 1) goto L20;
        if (r102 != 2) goto L18;
        return new TaggedRequest(ASN1Sequence.getInstance(r101, false));
    L18:
        throw new IllegalArgumentException("unknown tag in getInstance(): " + r101.getTagNo());
    L20:
        return new TaggedRequest(CertReqMsg.getInstance(r101, false));
    L22:
        return new TaggedRequest(TaggedCertificationRequest.getInstance(r101, false));
    L24:
        if ((r100 instanceof byte[]) == false) goto L30;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L28:
        throw new IllegalArgumentException("unknown encoding in getInstance()");
    L30:
        throw new IllegalArgumentException("unknown object in getInstance(): ".concat(r100.getClass().getName()));
    L5:
        return (TaggedRequest) r100;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.value);
    }
}
