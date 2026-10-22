package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

/* JADX INFO: loaded from: classes42.dex */
public class ContentHints extends ASN1Object {
    private DERUTF8String contentDescription;
    private ASN1ObjectIdentifier contentType;

    public ContentHints(ASN1ObjectIdentifier r100) {
        this.contentType = r100;
        this.contentDescription = null;
    }

    public ContentHints(ASN1ObjectIdentifier r100, DERUTF8String r101) {
        this.contentType = r100;
        this.contentDescription = r101;
    }

    private ContentHints(ASN1Sequence r100) {
        int r101 = 0;
        ASN1Encodable r102 = r100.getObjectAt(0);
        if ((r102.toASN1Primitive() instanceof DERUTF8String) == false) goto L5;
        this.contentDescription = DERUTF8String.getInstance(r102);
        r101 = 1;
    L5:
        this.contentType = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(r101));
    }

    public static ContentHints getInstance(Object r100) {
        if ((r100 instanceof ContentHints) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ContentHints(ASN1Sequence.getInstance(r100));
    L5:
        return (ContentHints) r100;
    }

    public DERUTF8String getContentDescription() {
        return this.contentDescription;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        DERUTF8String r101 = this.contentDescription;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        r100.add(this.contentType);
        return new DERSequence(r100);
    }
}
