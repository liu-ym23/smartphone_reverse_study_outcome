package org.bouncycastle.asn1.tsp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.cms.ContentInfo;

/* JADX INFO: loaded from: classes42.dex */
public class TimeStampResp extends ASN1Object {
    PKIStatusInfo pkiStatusInfo;
    ContentInfo timeStampToken;

    private TimeStampResp(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.pkiStatusInfo = PKIStatusInfo.getInstance(r101.nextElement());
        if (r101.hasMoreElements() == false) goto L6;
        this.timeStampToken = ContentInfo.getInstance(r101.nextElement());
        return;
    }

    public TimeStampResp(PKIStatusInfo r100, ContentInfo r101) {
        this.pkiStatusInfo = r100;
        this.timeStampToken = r101;
    }

    public static TimeStampResp getInstance(Object r100) {
        if ((r100 instanceof TimeStampResp) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TimeStampResp(ASN1Sequence.getInstance(r100));
    L5:
        return (TimeStampResp) r100;
    }

    public PKIStatusInfo getStatus() {
        return this.pkiStatusInfo;
    }

    public ContentInfo getTimeStampToken() {
        return this.timeStampToken;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.pkiStatusInfo);
        ContentInfo r101 = this.timeStampToken;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
