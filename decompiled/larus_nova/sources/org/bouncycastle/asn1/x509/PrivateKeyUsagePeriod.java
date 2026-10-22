package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class PrivateKeyUsagePeriod extends ASN1Object {
    private ASN1GeneralizedTime _notAfter;
    private ASN1GeneralizedTime _notBefore;

    private PrivateKeyUsagePeriod(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L11;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        if (r102.getTagNo() == 0) goto L7;
        if (r102.getTagNo() != 1) goto L4;
        this._notAfter = ASN1GeneralizedTime.getInstance(r102, false);
        goto L4
    L7:
        this._notBefore = ASN1GeneralizedTime.getInstance(r102, false);
        goto L4
    }

    public static PrivateKeyUsagePeriod getInstance(Object r100) {
        if ((r100 instanceof PrivateKeyUsagePeriod) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PrivateKeyUsagePeriod(ASN1Sequence.getInstance(r100));
    L5:
        return (PrivateKeyUsagePeriod) r100;
    }

    public ASN1GeneralizedTime getNotAfter() {
        return this._notAfter;
    }

    public ASN1GeneralizedTime getNotBefore() {
        return this._notBefore;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        ASN1GeneralizedTime r101 = this._notBefore;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        ASN1GeneralizedTime r102 = this._notAfter;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(false, 1, r102));
    L9:
        return new DERSequence(r100);
    }
}
