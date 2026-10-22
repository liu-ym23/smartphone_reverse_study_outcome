package org.bouncycastle.asn1.ocsp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class CrlID extends ASN1Object {
    private ASN1Integer crlNum;
    private ASN1GeneralizedTime crlTime;
    private DERIA5String crlUrl;

    private CrlID(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L15;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        int r103 = r102.getTagNo();
        if (r103 != 0) goto L7;
        this.crlUrl = DERIA5String.getInstance(r102, true);
        goto L4
    L7:
        if (r103 != 1) goto L9;
        this.crlNum = ASN1Integer.getInstance(r102, true);
        goto L4
    L9:
        if (r103 != 2) goto L12;
        this.crlTime = ASN1GeneralizedTime.getInstance(r102, true);
        goto L4
    L12:
        throw new IllegalArgumentException("unknown tag number: " + r102.getTagNo());
    }

    public static CrlID getInstance(Object r100) {
        if ((r100 instanceof CrlID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CrlID(ASN1Sequence.getInstance(r100));
    L5:
        return (CrlID) r100;
    }

    public ASN1Integer getCrlNum() {
        return this.crlNum;
    }

    public ASN1GeneralizedTime getCrlTime() {
        return this.crlTime;
    }

    public DERIA5String getCrlUrl() {
        return this.crlUrl;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        DERIA5String r101 = this.crlUrl;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, r101));
    L5:
        ASN1Integer r102 = this.crlNum;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(true, 1, r102));
    L8:
        ASN1GeneralizedTime r103 = this.crlTime;
        if (r103 == null) goto L12;
        r100.add(new DERTaggedObject(true, 2, r103));
    L12:
        return new DERSequence(r100);
    }
}
