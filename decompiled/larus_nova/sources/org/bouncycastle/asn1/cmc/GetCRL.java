package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.ReasonFlags;

/* JADX INFO: loaded from: classes42.dex */
public class GetCRL extends ASN1Object {
    private GeneralName cRLName;
    private final X500Name issuerName;
    private ReasonFlags reasons;
    private ASN1GeneralizedTime time;

    private GetCRL(ASN1Sequence r100) {
        int r101 = 1;
        if (r100.size() < 1) goto L23;
        if (r100.size() > 4) goto L23;
        this.issuerName = X500Name.getInstance(r100.getObjectAt(0));
        if (r100.size() <= 1) goto L12;
        if ((r100.getObjectAt(1).toASN1Primitive() instanceof ASN1TaggedObject) == false) goto L12;
        this.cRLName = GeneralName.getInstance(r100.getObjectAt(1));
        r101 = 2;
    L12:
        if (r100.size() <= r101) goto L17;
        if ((r100.getObjectAt(r101).toASN1Primitive() instanceof ASN1GeneralizedTime) == false) goto L17;
        int r102 = r101 + 1;
        this.time = ASN1GeneralizedTime.getInstance(r100.getObjectAt(r101));
        r101 = r102;
    L17:
        if (r100.size() > r101) goto L19;
        return;
    L19:
        if ((r100.getObjectAt(r101).toASN1Primitive() instanceof DERBitString) == false) goto L25;
        this.reasons = new ReasonFlags(DERBitString.getInstance(r100.getObjectAt(r101)));
        return;
    L25:
        return;
    L23:
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public GetCRL(X500Name r100, GeneralName r101, ASN1GeneralizedTime r102, ReasonFlags r103) {
        this.issuerName = r100;
        this.cRLName = r101;
        this.time = r102;
        this.reasons = r103;
    }

    public static GetCRL getInstance(Object r100) {
        if ((r100 instanceof GetCRL) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GetCRL(ASN1Sequence.getInstance(r100));
    L5:
        return (GetCRL) r100;
    }

    public X500Name getIssuerName() {
        return this.issuerName;
    }

    public ReasonFlags getReasons() {
        return this.reasons;
    }

    public ASN1GeneralizedTime getTime() {
        return this.time;
    }

    public GeneralName getcRLName() {
        return this.cRLName;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.issuerName);
        GeneralName r101 = this.cRLName;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        ASN1GeneralizedTime r102 = this.time;
        if (r102 == null) goto L8;
        r100.add(r102);
    L8:
        ReasonFlags r103 = this.reasons;
        if (r103 == null) goto L12;
        r100.add(r103);
    L12:
        return new DERSequence(r100);
    }
}
