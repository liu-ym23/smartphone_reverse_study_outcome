package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class ContentInfo extends ASN1Object implements CMSObjectIdentifiers {
    private ASN1Encodable content;
    private ASN1ObjectIdentifier contentType;

    public ContentInfo(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.contentType = r100;
        this.content = r101;
    }

    public ContentInfo(ASN1Sequence r100) {
        if (r100.size() < 1) goto L17;
        if (r100.size() > 2) goto L17;
        this.contentType = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        if (r100.size() <= 1) goto L15;
        ASN1TaggedObject r101 = (ASN1TaggedObject) r100.getObjectAt(1);
        if (r101.isExplicit() == false) goto L14;
        if (r101.getTagNo() != 0) goto L14;
        this.content = r101.getObject();
        return;
    L14:
        throw new IllegalArgumentException("Bad tag for 'content'");
    L15:
        return;
    L17:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public static ContentInfo getInstance(Object r100) {
        if ((r100 instanceof ContentInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ContentInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (ContentInfo) r100;
    }

    public static ContentInfo getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1Encodable getContent() {
        return this.content;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.contentType);
        ASN1Encodable r101 = this.content;
        if (r101 == null) goto L6;
        r100.add(new BERTaggedObject(0, r101));
    L6:
        return new BERSequence(r100);
    }
}
