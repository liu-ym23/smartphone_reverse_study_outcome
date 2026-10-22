package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ResponseBytes extends ASN1Object {
    ASN1OctetString response;
    ASN1ObjectIdentifier responseType;

    public ResponseBytes(ASN1ObjectIdentifier r100, ASN1OctetString r101) {
        this.responseType = r100;
        this.response = r101;
    }

    public ResponseBytes(ASN1Sequence r100) {
        this.responseType = (ASN1ObjectIdentifier) r100.getObjectAt(0);
        this.response = (ASN1OctetString) r100.getObjectAt(1);
    }

    public static ResponseBytes getInstance(Object r100) {
        if ((r100 instanceof ResponseBytes) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ResponseBytes(ASN1Sequence.getInstance(r100));
    L5:
        return (ResponseBytes) r100;
    }

    public static ResponseBytes getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1OctetString getResponse() {
        return this.response;
    }

    public ASN1ObjectIdentifier getResponseType() {
        return this.responseType;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.responseType);
        r100.add(this.response);
        return new DERSequence(r100);
    }
}
