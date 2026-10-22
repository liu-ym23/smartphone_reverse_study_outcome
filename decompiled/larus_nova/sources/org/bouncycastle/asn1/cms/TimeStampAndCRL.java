package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.CertificateList;

/* JADX INFO: loaded from: classes42.dex */
public class TimeStampAndCRL extends ASN1Object {
    private CertificateList crl;
    private ContentInfo timeStamp;

    private TimeStampAndCRL(ASN1Sequence r100) {
        this.timeStamp = ContentInfo.getInstance(r100.getObjectAt(0));
        if (r100.size() != 2) goto L6;
        this.crl = CertificateList.getInstance(r100.getObjectAt(1));
        return;
    }

    public TimeStampAndCRL(ContentInfo r100) {
        this.timeStamp = r100;
    }

    public static TimeStampAndCRL getInstance(Object r100) {
        if ((r100 instanceof TimeStampAndCRL) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TimeStampAndCRL(ASN1Sequence.getInstance(r100));
    L5:
        return (TimeStampAndCRL) r100;
    }

    public CertificateList getCRL() {
        return this.crl;
    }

    public CertificateList getCertificateList() {
        return this.crl;
    }

    public ContentInfo getTimeStampToken() {
        return this.timeStamp;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.timeStamp);
        CertificateList r101 = this.crl;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
