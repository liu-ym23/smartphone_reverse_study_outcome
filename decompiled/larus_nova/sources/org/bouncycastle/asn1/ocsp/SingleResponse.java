package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.X509Extensions;

/* JADX INFO: loaded from: classes42.dex */
public class SingleResponse extends ASN1Object {
    private CertID certID;
    private CertStatus certStatus;
    private ASN1GeneralizedTime nextUpdate;
    private Extensions singleExtensions;
    private ASN1GeneralizedTime thisUpdate;

    private SingleResponse(ASN1Sequence r100) {
        this.certID = CertID.getInstance(r100.getObjectAt(0));
        this.certStatus = CertStatus.getInstance(r100.getObjectAt(1));
        this.thisUpdate = ASN1GeneralizedTime.getInstance(r100.getObjectAt(2));
        if (r100.size() <= 4) goto L7;
        this.nextUpdate = ASN1GeneralizedTime.getInstance((ASN1TaggedObject) r100.getObjectAt(3), true);
        ASN1TaggedObject r101 = (ASN1TaggedObject) r100.getObjectAt(4);
    L5:
        this.singleExtensions = Extensions.getInstance(r101, true);
        return;
    L7:
        if (r100.size() <= 3) goto L13;
        r101 = (ASN1TaggedObject) r100.getObjectAt(3);
        if (r101.getTagNo() != 0) goto L5;
        this.nextUpdate = ASN1GeneralizedTime.getInstance(r101, true);
        return;
    }

    public SingleResponse(CertID r100, CertStatus r101, ASN1GeneralizedTime r102, ASN1GeneralizedTime r103, Extensions r104) {
        this.certID = r100;
        this.certStatus = r101;
        this.thisUpdate = r102;
        this.nextUpdate = r103;
        this.singleExtensions = r104;
    }

    public SingleResponse(CertID r100, CertStatus r101, ASN1GeneralizedTime r102, ASN1GeneralizedTime r110, X509Extensions r111) {
        this(r100, r101, r102, r110, Extensions.getInstance(r111));
    }

    public static SingleResponse getInstance(Object r100) {
        if ((r100 instanceof SingleResponse) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SingleResponse(ASN1Sequence.getInstance(r100));
    L5:
        return (SingleResponse) r100;
    }

    public static SingleResponse getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public CertID getCertID() {
        return this.certID;
    }

    public CertStatus getCertStatus() {
        return this.certStatus;
    }

    public ASN1GeneralizedTime getNextUpdate() {
        return this.nextUpdate;
    }

    public Extensions getSingleExtensions() {
        return this.singleExtensions;
    }

    public ASN1GeneralizedTime getThisUpdate() {
        return this.thisUpdate;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(5);
        r100.add(this.certID);
        r100.add(this.certStatus);
        r100.add(this.thisUpdate);
        ASN1GeneralizedTime r101 = this.nextUpdate;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, r101));
    L5:
        Extensions r102 = this.singleExtensions;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(true, 1, r102));
    L9:
        return new DERSequence(r100);
    }
}
