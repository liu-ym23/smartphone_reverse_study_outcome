package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;

/* JADX INFO: loaded from: classes42.dex */
public class Request extends ASN1Object {
    CertID reqCert;
    Extensions singleRequestExtensions;

    private Request(ASN1Sequence r100) {
        this.reqCert = CertID.getInstance(r100.getObjectAt(0));
        if (r100.size() != 2) goto L6;
        this.singleRequestExtensions = Extensions.getInstance((ASN1TaggedObject) r100.getObjectAt(1), true);
        return;
    }

    public Request(CertID r100, Extensions r101) {
        this.reqCert = r100;
        this.singleRequestExtensions = r101;
    }

    public static Request getInstance(Object r100) {
        if ((r100 instanceof Request) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Request(ASN1Sequence.getInstance(r100));
    L5:
        return (Request) r100;
    }

    public static Request getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public CertID getReqCert() {
        return this.reqCert;
    }

    public Extensions getSingleRequestExtensions() {
        return this.singleRequestExtensions;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.reqCert);
        Extensions r101 = this.singleRequestExtensions;
        if (r101 == null) goto L6;
        r100.add(new DERTaggedObject(true, 0, r101));
    L6:
        return new DERSequence(r100);
    }
}
