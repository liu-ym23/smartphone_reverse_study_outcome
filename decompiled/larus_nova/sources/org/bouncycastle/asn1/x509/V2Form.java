package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class V2Form extends ASN1Object {
    IssuerSerial baseCertificateID;
    GeneralNames issuerName;
    ObjectDigestInfo objectDigestInfo;

    public V2Form(ASN1Sequence r100) {
        if (r100.size() > 3) goto L21;
        if ((r100.getObjectAt(0) instanceof ASN1TaggedObject) == true) goto L7;
        this.issuerName = GeneralNames.getInstance(r100.getObjectAt(0));
        int r101 = 1;
    L9:
        if (r101 == r100.size()) goto L19;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r100.getObjectAt(r101));
        if (r102.getTagNo() != 0) goto L14;
        this.baseCertificateID = IssuerSerial.getInstance(r102, false);
    L16:
        r101 = r101 + 1;
        goto L9
    L14:
        if (r102.getTagNo() != 1) goto L18;
        this.objectDigestInfo = ObjectDigestInfo.getInstance(r102, false);
        goto L16
    L18:
        throw new IllegalArgumentException("Bad tag number: " + r102.getTagNo());
    L19:
        return;
    L7:
        r101 = 0;
        goto L9
    L21:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public V2Form(GeneralNames r100) {
        this(r100, null, null);
    }

    public V2Form(GeneralNames r100, IssuerSerial r101) {
        this(r100, r101, null);
    }

    public V2Form(GeneralNames r100, IssuerSerial r101, ObjectDigestInfo r102) {
        this.issuerName = r100;
        this.baseCertificateID = r101;
        this.objectDigestInfo = r102;
    }

    public V2Form(GeneralNames r100, ObjectDigestInfo r101) {
        this(r100, null, r101);
    }

    public static V2Form getInstance(Object r100) {
        if ((r100 instanceof V2Form) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new V2Form(ASN1Sequence.getInstance(r100));
    L5:
        return (V2Form) r100;
    }

    public static V2Form getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public IssuerSerial getBaseCertificateID() {
        return this.baseCertificateID;
    }

    public GeneralNames getIssuerName() {
        return this.issuerName;
    }

    public ObjectDigestInfo getObjectDigestInfo() {
        return this.objectDigestInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        GeneralNames r101 = this.issuerName;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        IssuerSerial r102 = this.baseCertificateID;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(false, 0, r102));
    L8:
        ObjectDigestInfo r103 = this.objectDigestInfo;
        if (r103 == null) goto L12;
        r100.add(new DERTaggedObject(false, 1, r103));
    L12:
        return new DERSequence(r100);
    }
}
