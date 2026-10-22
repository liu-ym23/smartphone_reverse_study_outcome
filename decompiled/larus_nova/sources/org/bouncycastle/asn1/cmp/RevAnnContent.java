package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertId;
import org.bouncycastle.asn1.x509.Extensions;

/* JADX INFO: loaded from: classes42.dex */
public class RevAnnContent extends ASN1Object {
    private ASN1GeneralizedTime badSinceDate;
    private CertId certId;
    private Extensions crlDetails;
    private PKIStatus status;
    private ASN1GeneralizedTime willBeRevokedAt;

    private RevAnnContent(ASN1Sequence r100) {
        this.status = PKIStatus.getInstance(r100.getObjectAt(0));
        this.certId = CertId.getInstance(r100.getObjectAt(1));
        this.willBeRevokedAt = ASN1GeneralizedTime.getInstance(r100.getObjectAt(2));
        this.badSinceDate = ASN1GeneralizedTime.getInstance(r100.getObjectAt(3));
        if (r100.size() <= 4) goto L6;
        this.crlDetails = Extensions.getInstance(r100.getObjectAt(4));
        return;
    }

    public static RevAnnContent getInstance(Object r100) {
        if ((r100 instanceof RevAnnContent) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RevAnnContent(ASN1Sequence.getInstance(r100));
    L5:
        return (RevAnnContent) r100;
    }

    public ASN1GeneralizedTime getBadSinceDate() {
        return this.badSinceDate;
    }

    public CertId getCertId() {
        return this.certId;
    }

    public Extensions getCrlDetails() {
        return this.crlDetails;
    }

    public PKIStatus getStatus() {
        return this.status;
    }

    public ASN1GeneralizedTime getWillBeRevokedAt() {
        return this.willBeRevokedAt;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(this.status);
        r100.add(this.certId);
        r100.add(this.willBeRevokedAt);
        r100.add(this.badSinceDate);
        Extensions r101 = this.crlDetails;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
