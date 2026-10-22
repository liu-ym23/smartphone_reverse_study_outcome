package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PollRepContent extends ASN1Object {
    private ASN1Integer[] certReqId;
    private ASN1Integer[] checkAfter;
    private PKIFreeText[] reason;

    public PollRepContent(ASN1Integer r100, ASN1Integer r101) {
        this(r100, r101, null);
    }

    public PollRepContent(ASN1Integer r100, ASN1Integer r101, PKIFreeText r102) {
        this.certReqId = new ASN1Integer[]{r100};
        this.checkAfter = new ASN1Integer[]{r101};
        this.reason = new PKIFreeText[]{r102};
    }

    private PollRepContent(ASN1Sequence r100) {
        this.certReqId = new ASN1Integer[r100.size()];
        this.checkAfter = new ASN1Integer[r100.size()];
        this.reason = new PKIFreeText[r100.size()];
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L9;
        ASN1Sequence r102 = ASN1Sequence.getInstance(r100.getObjectAt(r101));
        this.certReqId[r101] = ASN1Integer.getInstance(r102.getObjectAt(0));
        this.checkAfter[r101] = ASN1Integer.getInstance(r102.getObjectAt(1));
        if (r102.size() <= 2) goto L8;
        this.reason[r101] = PKIFreeText.getInstance(r102.getObjectAt(2));
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public static PollRepContent getInstance(Object r100) {
        if ((r100 instanceof PollRepContent) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PollRepContent(ASN1Sequence.getInstance(r100));
    L5:
        return (PollRepContent) r100;
    }

    public ASN1Integer getCertReqId(int r100) {
        return this.certReqId[r100];
    }

    public ASN1Integer getCheckAfter(int r100) {
        return this.checkAfter[r100];
    }

    public PKIFreeText getReason(int r100) {
        return this.reason[r100];
    }

    public int size() {
        return this.certReqId.length;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(this.certReqId.length);
        int r101 = 0;
    L4:
        if (r101 == this.certReqId.length) goto L10;
        ASN1EncodableVector r102 = new ASN1EncodableVector(3);
        r102.add(this.certReqId[r101]);
        r102.add(this.checkAfter[r101]);
        PKIFreeText r103 = this.reason[r101];
        if (r103 == null) goto L8;
        r102.add(r103);
    L8:
        r100.add(new DERSequence(r102));
        r101 = r101 + 1;
        goto L4
    L10:
        return new DERSequence(r100);
    }
}
