package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.tsp.EvidenceRecord;

/* JADX INFO: loaded from: classes42.dex */
public class Evidence extends ASN1Object implements ASN1Choice {
    private EvidenceRecord ersEvidence;
    private ASN1Sequence otherEvidence;
    private TimeStampTokenEvidence tstEvidence;

    private Evidence(ASN1TaggedObject r100) {
        if (r100.getTagNo() != 0) goto L6;
        this.tstEvidence = TimeStampTokenEvidence.getInstance(r100, false);
        return;
    L6:
        if (r100.getTagNo() != 1) goto L9;
        this.ersEvidence = EvidenceRecord.getInstance(r100, false);
        return;
    L9:
        if (r100.getTagNo() != 2) goto L13;
        this.otherEvidence = ASN1Sequence.getInstance(r100, false);
        return;
    L13:
        throw new IllegalArgumentException("unknown tag in Evidence");
    }

    public Evidence(TimeStampTokenEvidence r100) {
        this.tstEvidence = r100;
    }

    public Evidence(EvidenceRecord r100) {
        this.ersEvidence = r100;
    }

    public static Evidence getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof Evidence) == true) goto L13;
        if ((r100 instanceof ASN1TaggedObject) == false) goto L11;
        return new Evidence(ASN1TaggedObject.getInstance(r100));
    L11:
        throw new IllegalArgumentException("unknown object in getInstance");
    L13:
        return (Evidence) r100;
    }

    public static Evidence getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(r100.getObject());
    }

    public EvidenceRecord getErsEvidence() {
        return this.ersEvidence;
    }

    public TimeStampTokenEvidence getTstEvidence() {
        return this.tstEvidence;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        TimeStampTokenEvidence r100 = this.tstEvidence;
        if (r100 != null) goto L5;
        EvidenceRecord r101 = this.ersEvidence;
        if (r101 == null) goto L11;
        return new DERTaggedObject(false, 1, r101);
    L11:
        return new DERTaggedObject(false, 2, this.otherEvidence);
    L5:
        return new DERTaggedObject(false, 0, r100);
    }
}
