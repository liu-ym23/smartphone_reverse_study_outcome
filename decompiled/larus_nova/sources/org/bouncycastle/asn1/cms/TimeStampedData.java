package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERIA5String;

/* JADX INFO: loaded from: classes42.dex */
public class TimeStampedData extends ASN1Object {
    private ASN1OctetString content;
    private DERIA5String dataUri;
    private MetaData metaData;
    private Evidence temporalEvidence;
    private ASN1Integer version;

    private TimeStampedData(ASN1Sequence r100) {
        this.version = ASN1Integer.getInstance(r100.getObjectAt(0));
        int r101 = 1;
        if ((r100.getObjectAt(1) instanceof DERIA5String) == false) goto L6;
        this.dataUri = DERIA5String.getInstance(r100.getObjectAt(1));
        r101 = 2;
    L6:
        if ((r100.getObjectAt(r101) instanceof MetaData) == false) goto L8;
    L9:
        int r102 = r101 + 1;
        this.metaData = MetaData.getInstance(r100.getObjectAt(r101));
        r101 = r102;
    L11:
        if ((r100.getObjectAt(r101) instanceof ASN1OctetString) == false) goto L13;
        int r103 = r101 + 1;
        this.content = ASN1OctetString.getInstance(r100.getObjectAt(r101));
        r101 = r103;
    L13:
        this.temporalEvidence = Evidence.getInstance(r100.getObjectAt(r101));
        return;
    L8:
        if ((r100.getObjectAt(r101) instanceof ASN1Sequence) == false) goto L11;
        goto L9
    }

    public TimeStampedData(DERIA5String r100, MetaData r101, ASN1OctetString r102, Evidence r103) {
        this.version = new ASN1Integer(1);
        this.dataUri = r100;
        this.metaData = r101;
        this.content = r102;
        this.temporalEvidence = r103;
    }

    public static TimeStampedData getInstance(Object r100) {
        if (r100 == null) goto L9;
        if ((r100 instanceof TimeStampedData) == true) goto L9;
        return new TimeStampedData(ASN1Sequence.getInstance(r100));
    L9:
        return (TimeStampedData) r100;
    }

    public ASN1OctetString getContent() {
        return this.content;
    }

    public DERIA5String getDataUri() {
        return this.dataUri;
    }

    public MetaData getMetaData() {
        return this.metaData;
    }

    public Evidence getTemporalEvidence() {
        return this.temporalEvidence;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(this.version);
        DERIA5String r101 = this.dataUri;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        MetaData r102 = this.metaData;
        if (r102 == null) goto L8;
        r100.add(r102);
    L8:
        ASN1OctetString r103 = this.content;
        if (r103 == null) goto L11;
        r100.add(r103);
    L11:
        r100.add(this.temporalEvidence);
        return new BERSequence(r100);
    }
}
