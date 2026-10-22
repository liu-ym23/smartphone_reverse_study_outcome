package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DLSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ContentInfo extends ASN1Object implements PKCSObjectIdentifiers {
    private ASN1Encodable content;
    private ASN1ObjectIdentifier contentType;
    private boolean isBer;

    public ContentInfo(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.isBer = true;
        this.contentType = r100;
        this.content = r101;
    }

    private ContentInfo(ASN1Sequence r100) {
        this.isBer = true;
        Enumeration r101 = r100.getObjects();
        this.contentType = (ASN1ObjectIdentifier) r101.nextElement();
        if (r101.hasMoreElements() == false) goto L5;
        this.content = ((ASN1TaggedObject) r101.nextElement()).getObject();
    L5:
        this.isBer = r100 instanceof BERSequence;
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
        r100.add(new BERTaggedObject(true, 0, r101));
    L6:
        if (this.isBer == false) goto L10;
        return new BERSequence(r100);
    L10:
        return new DLSequence(r100);
    }
}
