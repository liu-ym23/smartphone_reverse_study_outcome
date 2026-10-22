package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class DVCSResponse extends ASN1Object implements ASN1Choice {
    private DVCSCertInfo dvCertInfo;
    private DVCSErrorNotice dvErrorNote;

    public DVCSResponse(DVCSCertInfo r100) {
        this.dvCertInfo = r100;
    }

    public DVCSResponse(DVCSErrorNotice r100) {
        this.dvErrorNote = r100;
    }

    public static DVCSResponse getInstance(Object r100) {
        if (r100 == null) goto L24;
        if ((r100 instanceof DVCSResponse) == true) goto L24;
        if ((r100 instanceof byte[]) == false) goto L14;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L10:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
    L14:
        if ((r100 instanceof ASN1Sequence) == false) goto L18;
        return new DVCSResponse(DVCSCertInfo.getInstance(r100));
    L18:
        if ((r100 instanceof ASN1TaggedObject) == false) goto L22;
        return new DVCSResponse(DVCSErrorNotice.getInstance(ASN1TaggedObject.getInstance(r100), false));
    L22:
        throw new IllegalArgumentException("Couldn't convert from object to DVCSResponse: ".concat(r100.getClass().getName()));
    L24:
        return (DVCSResponse) r100;
    }

    public static DVCSResponse getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public DVCSCertInfo getCertInfo() {
        return this.dvCertInfo;
    }

    public DVCSErrorNotice getErrorNotice() {
        return this.dvErrorNote;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        DVCSCertInfo r100 = this.dvCertInfo;
        if (r100 == null) goto L7;
        return r100.toASN1Primitive();
    L7:
        return new DERTaggedObject(false, 0, this.dvErrorNote);
    }

    public String toString() {
        if (this.dvCertInfo == null) goto L7;
        StringBuilder r100 = new StringBuilder("DVCSResponse {\ndvCertInfo: ");
        String r101 = this.dvCertInfo.toString();
    L5:
        r100.append(r101);
        r100.append("}\n");
        return r100.toString();
    L7:
        r100 = new StringBuilder("DVCSResponse {\ndvErrorNote: ");
        r101 = this.dvErrorNote.toString();
        goto L5
    }
}
