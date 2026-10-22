package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class OCSPRequest extends ASN1Object {
    Signature optionalSignature;
    TBSRequest tbsRequest;

    private OCSPRequest(ASN1Sequence r100) {
        this.tbsRequest = TBSRequest.getInstance(r100.getObjectAt(0));
        if (r100.size() != 2) goto L6;
        this.optionalSignature = Signature.getInstance((ASN1TaggedObject) r100.getObjectAt(1), true);
        return;
    }

    public OCSPRequest(TBSRequest r100, Signature r101) {
        this.tbsRequest = r100;
        this.optionalSignature = r101;
    }

    public static OCSPRequest getInstance(Object r100) {
        if ((r100 instanceof OCSPRequest) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OCSPRequest(ASN1Sequence.getInstance(r100));
    L5:
        return (OCSPRequest) r100;
    }

    public static OCSPRequest getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public Signature getOptionalSignature() {
        return this.optionalSignature;
    }

    public TBSRequest getTbsRequest() {
        return this.tbsRequest;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.tbsRequest);
        Signature r101 = this.optionalSignature;
        if (r101 == null) goto L6;
        r100.add(new DERTaggedObject(true, 0, r101));
    L6:
        return new DERSequence(r100);
    }
}
