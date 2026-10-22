package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class SCVPReqRes extends ASN1Object {
    private final ContentInfo request;
    private final ContentInfo response;

    private SCVPReqRes(ASN1Sequence r100) {
        if ((r100.getObjectAt(0) instanceof ASN1TaggedObject) == false) goto L5;
        this.request = ContentInfo.getInstance(ASN1TaggedObject.getInstance(r100.getObjectAt(0)), true);
        ASN1Encodable r101 = r100.getObjectAt(1);
    L6:
        this.response = ContentInfo.getInstance(r101);
        return;
    L5:
        this.request = null;
        r101 = r100.getObjectAt(0);
        goto L6
    }

    public SCVPReqRes(ContentInfo r100) {
        this.request = null;
        this.response = r100;
    }

    public SCVPReqRes(ContentInfo r100, ContentInfo r101) {
        this.request = r100;
        this.response = r101;
    }

    public static SCVPReqRes getInstance(Object r100) {
        if ((r100 instanceof SCVPReqRes) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SCVPReqRes(ASN1Sequence.getInstance(r100));
    L5:
        return (SCVPReqRes) r100;
    }

    public ContentInfo getRequest() {
        return this.request;
    }

    public ContentInfo getResponse() {
        return this.response;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        ContentInfo r101 = this.request;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, r101));
    L5:
        r100.add(this.response);
        return new DERSequence(r100);
    }
}
