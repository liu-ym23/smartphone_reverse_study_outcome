package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class OCSPResponse extends ASN1Object {
    ResponseBytes responseBytes;
    OCSPResponseStatus responseStatus;

    private OCSPResponse(ASN1Sequence r100) {
        this.responseStatus = OCSPResponseStatus.getInstance(r100.getObjectAt(0));
        if (r100.size() != 2) goto L6;
        this.responseBytes = ResponseBytes.getInstance((ASN1TaggedObject) r100.getObjectAt(1), true);
        return;
    }

    public OCSPResponse(OCSPResponseStatus r100, ResponseBytes r101) {
        this.responseStatus = r100;
        this.responseBytes = r101;
    }

    public static OCSPResponse getInstance(Object r100) {
        if ((r100 instanceof OCSPResponse) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OCSPResponse(ASN1Sequence.getInstance(r100));
    L5:
        return (OCSPResponse) r100;
    }

    public static OCSPResponse getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ResponseBytes getResponseBytes() {
        return this.responseBytes;
    }

    public OCSPResponseStatus getResponseStatus() {
        return this.responseStatus;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.responseStatus);
        ResponseBytes r101 = this.responseBytes;
        if (r101 == null) goto L6;
        r100.add(new DERTaggedObject(true, 0, r101));
    L6:
        return new DERSequence(r100);
    }
}
