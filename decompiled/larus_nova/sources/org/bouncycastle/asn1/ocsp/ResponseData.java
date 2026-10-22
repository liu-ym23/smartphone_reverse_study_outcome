package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

/* JADX INFO: loaded from: classes42.dex */
public class ResponseData extends ASN1Object {
    private static final ASN1Integer V1 = null;
    private ASN1GeneralizedTime producedAt;
    private ResponderID responderID;
    private Extensions responseExtensions;
    private ASN1Sequence responses;
    private ASN1Integer version;
    private boolean versionPresent;

    static {
        V1 = new ASN1Integer(0);
    }

    public ResponseData(ASN1Integer r100, ResponderID r101, ASN1GeneralizedTime r102, ASN1Sequence r103, Extensions r104) {
        this.version = r100;
        this.responderID = r101;
        this.producedAt = r102;
        this.responses = r103;
        this.responseExtensions = r104;
    }

    private ResponseData(ASN1Sequence r100) {
        int r101 = 0;
        if ((r100.getObjectAt(0) instanceof ASN1TaggedObject) == true) goto L5;
    L7:
        this.version = V1;
    L8:
        int r102 = r101 + 1;
        this.responderID = ResponderID.getInstance(r100.getObjectAt(r101));
        int r103 = r102 + 1;
        this.producedAt = ASN1GeneralizedTime.getInstance(r100.getObjectAt(r102));
        int r104 = r103 + 1;
        this.responses = (ASN1Sequence) r100.getObjectAt(r103);
        if (r100.size() <= r104) goto L12;
        this.responseExtensions = Extensions.getInstance((ASN1TaggedObject) r100.getObjectAt(r104), true);
        return;
    L12:
        return;
    L5:
        if (((ASN1TaggedObject) r100.getObjectAt(0)).getTagNo() != 0) goto L7;
        this.versionPresent = true;
        this.version = ASN1Integer.getInstance((ASN1TaggedObject) r100.getObjectAt(0), true);
        r101 = 1;
        goto L8
    }

    public ResponseData(ResponderID r100, ASN1GeneralizedTime r101, ASN1Sequence r102, Extensions r110) {
        this(V1, r100, r101, r102, r110);
    }

    public ResponseData(ResponderID r100, ASN1GeneralizedTime r101, ASN1Sequence r102, X509Extensions r110) {
        this(V1, r100, ASN1GeneralizedTime.getInstance(r101), r102, Extensions.getInstance(r110));
    }

    public static ResponseData getInstance(Object r100) {
        if ((r100 instanceof ResponseData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ResponseData(ASN1Sequence.getInstance(r100));
    L5:
        return (ResponseData) r100;
    }

    public static ResponseData getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1GeneralizedTime getProducedAt() {
        return this.producedAt;
    }

    public ResponderID getResponderID() {
        return this.responderID;
    }

    public Extensions getResponseExtensions() {
        return this.responseExtensions;
    }

    public ASN1Sequence getResponses() {
        return this.responses;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        if (this.versionPresent == false) goto L5;
    L6:
        r100.add(new DERTaggedObject(true, 0, this.version));
    L7:
        r100.add(this.responderID);
        r100.add(this.producedAt);
        r100.add(this.responses);
        Extensions r101 = this.responseExtensions;
        if (r101 == null) goto L11;
        r100.add(new DERTaggedObject(true, 1, r101));
    L11:
        return new DERSequence(r100);
    L5:
        if (this.version.equals(V1) == true) goto L7;
        goto L6
    }
}
