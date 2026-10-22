package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class CertResponse extends ASN1Object {
    private ASN1Integer certReqId;
    private CertifiedKeyPair certifiedKeyPair;
    private ASN1OctetString rspInfo;
    private PKIStatusInfo status;

    public CertResponse(ASN1Integer r100, PKIStatusInfo r101) {
        this(r100, r101, null, null);
    }

    public CertResponse(ASN1Integer r100, PKIStatusInfo r101, CertifiedKeyPair r102, ASN1OctetString r103) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L8;
        this.certReqId = r100;
        this.status = r101;
        this.certifiedKeyPair = r102;
        this.rspInfo = r103;
        return;
    L8:
        throw new IllegalArgumentException("'status' cannot be null");
    L10:
        throw new IllegalArgumentException("'certReqId' cannot be null");
    }

    private CertResponse(ASN1Sequence r100) {
        this.certReqId = ASN1Integer.getInstance(r100.getObjectAt(0));
        this.status = PKIStatusInfo.getInstance(r100.getObjectAt(1));
        if (r100.size() >= 3) goto L5;
        return;
    L5:
        if (r100.size() != 3) goto L10;
        ASN1Encodable r101 = r100.getObjectAt(2);
        if ((r101 instanceof ASN1OctetString) == true) goto L11;
        this.certifiedKeyPair = CertifiedKeyPair.getInstance(r101);
        return;
    L11:
        this.rspInfo = ASN1OctetString.getInstance(r101);
        return;
    L10:
        this.certifiedKeyPair = CertifiedKeyPair.getInstance(r100.getObjectAt(2));
        r101 = r100.getObjectAt(3);
        goto L11
    }

    public static CertResponse getInstance(Object r100) {
        if ((r100 instanceof CertResponse) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CertResponse(ASN1Sequence.getInstance(r100));
    L5:
        return (CertResponse) r100;
    }

    public ASN1Integer getCertReqId() {
        return this.certReqId;
    }

    public CertifiedKeyPair getCertifiedKeyPair() {
        return this.certifiedKeyPair;
    }

    public PKIStatusInfo getStatus() {
        return this.status;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.certReqId);
        r100.add(this.status);
        CertifiedKeyPair r101 = this.certifiedKeyPair;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        ASN1OctetString r102 = this.rspInfo;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        return new DERSequence(r100);
    }
}
