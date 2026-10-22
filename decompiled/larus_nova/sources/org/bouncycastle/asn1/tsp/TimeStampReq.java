package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;

/* JADX INFO: loaded from: classes42.dex */
public class TimeStampReq extends ASN1Object {
    ASN1Boolean certReq;
    Extensions extensions;
    MessageImprint messageImprint;
    ASN1Integer nonce;
    ASN1ObjectIdentifier tsaPolicy;
    ASN1Integer version;

    private TimeStampReq(ASN1Sequence r100) {
        int r101 = r100.size();
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0));
        this.messageImprint = MessageImprint.getInstance(r100.getObjectAt(1));
        int r102 = 2;
    L3:
        if (r102 >= r101) goto L19;
        if ((r100.getObjectAt(r102) instanceof ASN1ObjectIdentifier) == false) goto L8;
        this.tsaPolicy = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(r102));
    L18:
        r102 = r102 + 1;
        goto L3
    L8:
        if ((r100.getObjectAt(r102) instanceof ASN1Integer) == false) goto L11;
        this.nonce = ASN1Integer.getInstance(r100.getObjectAt(r102));
        goto L18
    L11:
        if ((r100.getObjectAt(r102) instanceof ASN1Boolean) == false) goto L14;
        this.certReq = ASN1Boolean.getInstance(r100.getObjectAt(r102));
        goto L18
    L14:
        if ((r100.getObjectAt(r102) instanceof ASN1TaggedObject) == false) goto L18;
        ASN1TaggedObject r103 = (ASN1TaggedObject) r100.getObjectAt(r102);
        if (r103.getTagNo() != 0) goto L18;
        this.extensions = Extensions.getInstance(r103, false);
        goto L18
    }

    public TimeStampReq(MessageImprint r100, ASN1ObjectIdentifier r101, ASN1Integer r102, ASN1Boolean r103, Extensions r104) {
        this.version = new ASN1Integer(1);
        this.messageImprint = r100;
        this.tsaPolicy = r101;
        this.nonce = r102;
        this.certReq = r103;
        this.extensions = r104;
    }

    public static TimeStampReq getInstance(Object r100) {
        if ((r100 instanceof TimeStampReq) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TimeStampReq(ASN1Sequence.getInstance(r100));
    L5:
        return (TimeStampReq) r100;
    }

    public ASN1Boolean getCertReq() {
        return this.certReq;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public MessageImprint getMessageImprint() {
        return this.messageImprint;
    }

    public ASN1Integer getNonce() {
        return this.nonce;
    }

    public ASN1ObjectIdentifier getReqPolicy() {
        return this.tsaPolicy;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(6);
        r100.add(this.version);
        r100.add(this.messageImprint);
        ASN1ObjectIdentifier r101 = this.tsaPolicy;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        ASN1Integer r102 = this.nonce;
        if (r102 == null) goto L8;
        r100.add(r102);
    L8:
        ASN1Boolean r103 = this.certReq;
        if (r103 != null) goto L11;
    L13:
        Extensions r104 = this.extensions;
        if (r104 == null) goto L17;
        r100.add(new DERTaggedObject(false, 0, r104));
    L17:
        return new DERSequence(r100);
    L11:
        if (r103.isTrue() == false) goto L13;
        r100.add(this.certReq);
        goto L13
    }
}
