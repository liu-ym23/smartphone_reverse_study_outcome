package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class InfoTypeAndValue extends ASN1Object {
    private ASN1ObjectIdentifier infoType;
    private ASN1Encodable infoValue;

    public InfoTypeAndValue(ASN1ObjectIdentifier r100) {
        this.infoType = r100;
        this.infoValue = null;
    }

    public InfoTypeAndValue(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.infoType = r100;
        this.infoValue = r101;
    }

    private InfoTypeAndValue(ASN1Sequence r100) {
        this.infoType = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L6;
        this.infoValue = r100.getObjectAt(1);
        return;
    }

    public static InfoTypeAndValue getInstance(Object r100) {
        if ((r100 instanceof InfoTypeAndValue) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new InfoTypeAndValue(ASN1Sequence.getInstance(r100));
    L5:
        return (InfoTypeAndValue) r100;
    }

    public ASN1ObjectIdentifier getInfoType() {
        return this.infoType;
    }

    public ASN1Encodable getInfoValue() {
        return this.infoValue;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.infoType);
        ASN1Encodable r101 = this.infoValue;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
