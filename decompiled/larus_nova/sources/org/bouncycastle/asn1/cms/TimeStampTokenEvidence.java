package org.bouncycastle.asn1.cms;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class TimeStampTokenEvidence extends ASN1Object {
    private TimeStampAndCRL[] timeStampAndCRLs;

    private TimeStampTokenEvidence(ASN1Sequence r100) {
        this.timeStampAndCRLs = new TimeStampAndCRL[r100.size()];
        Enumeration r101 = r100.getObjects();
        int r102 = 0;
    L4:
        if (r101.hasMoreElements() == false) goto L6;
        this.timeStampAndCRLs[r102] = TimeStampAndCRL.getInstance(r101.nextElement());
        r102 = r102 + 1;
        goto L4
    }

    public TimeStampTokenEvidence(TimeStampAndCRL r100) {
        this.timeStampAndCRLs = new TimeStampAndCRL[]{r100};
    }

    public TimeStampTokenEvidence(TimeStampAndCRL[] r100) {
        this.timeStampAndCRLs = copy(r100);
    }

    private TimeStampAndCRL[] copy(TimeStampAndCRL[] r100) {
        int r101 = r100.length;
        TimeStampAndCRL[] r102 = new TimeStampAndCRL[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    public static TimeStampTokenEvidence getInstance(Object r100) {
        if ((r100 instanceof TimeStampTokenEvidence) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TimeStampTokenEvidence(ASN1Sequence.getInstance(r100));
    L5:
        return (TimeStampTokenEvidence) r100;
    }

    public static TimeStampTokenEvidence getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(this.timeStampAndCRLs.length);
        int r101 = 0;
    L3:
        TimeStampAndCRL[] r102 = this.timeStampAndCRLs;
        if (r101 == r102.length) goto L7;
        r100.add(r102[r101]);
        r101 = r101 + 1;
        goto L3
    L7:
        return new DERSequence(r100);
    }

    public TimeStampAndCRL[] toTimeStampAndCRLArray() {
        return copy(this.timeStampAndCRLs);
    }
}
