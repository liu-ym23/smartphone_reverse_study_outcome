package org.bouncycastle.asn1.crmf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Time;

/* JADX INFO: loaded from: classes42.dex */
public class OptionalValidity extends ASN1Object {
    private Time notAfter;
    private Time notBefore;

    private OptionalValidity(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L9;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        int r103 = r102.getTagNo();
        Time r104 = Time.getInstance(r102, true);
        if (r103 == 0) goto L7;
        this.notAfter = r104;
        goto L4
    L7:
        this.notBefore = r104;
        goto L4
    }

    public OptionalValidity(Time r100, Time r101) {
        if (r100 != null) goto L8;
        if (r101 != null) goto L8;
        throw new IllegalArgumentException("at least one of notBefore/notAfter must not be null.");
    L8:
        this.notBefore = r100;
        this.notAfter = r101;
    }

    public static OptionalValidity getInstance(Object r100) {
        if ((r100 instanceof OptionalValidity) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OptionalValidity(ASN1Sequence.getInstance(r100));
    L5:
        return (OptionalValidity) r100;
    }

    public Time getNotAfter() {
        return this.notAfter;
    }

    public Time getNotBefore() {
        return this.notBefore;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        Time r101 = this.notBefore;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, r101));
    L5:
        Time r102 = this.notAfter;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(true, 1, r102));
    L9:
        return new DERSequence(r100);
    }
}
