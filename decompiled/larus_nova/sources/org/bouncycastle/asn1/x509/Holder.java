package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class Holder extends ASN1Object {
    public static final int V1_CERTIFICATE_HOLDER = 0;
    public static final int V2_CERTIFICATE_HOLDER = 1;
    IssuerSerial baseCertificateID;
    GeneralNames entityName;
    ObjectDigestInfo objectDigestInfo;
    private int version;

    private Holder(ASN1Sequence r100) {
        this.version = 1;
        if (r100.size() > 3) goto L21;
        int r101 = 0;
    L6:
        if (r101 == r100.size()) goto L18;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r100.getObjectAt(r101));
        int r103 = r102.getTagNo();
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L11;
        this.entityName = GeneralNames.getInstance(r102, false);
    L17:
        r101 = r101 + 1;
        goto L6
    L11:
        if (r103 != 2) goto L14;
        this.objectDigestInfo = ObjectDigestInfo.getInstance(r102, false);
        goto L17
    L14:
        throw new IllegalArgumentException("unknown tag in Holder");
    L16:
        this.baseCertificateID = IssuerSerial.getInstance(r102, false);
        goto L17
    L18:
        this.version = 1;
        return;
    L21:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    private Holder(ASN1TaggedObject r100) {
        this.version = 1;
        int r101 = r100.getTagNo();
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        this.entityName = GeneralNames.getInstance(r100, true);
    L9:
        this.version = 0;
        return;
    L7:
        throw new IllegalArgumentException("unknown tag in Holder");
    L8:
        this.baseCertificateID = IssuerSerial.getInstance(r100, true);
        goto L9
    }

    public Holder(GeneralNames r100) {
        this(r100, 1);
    }

    public Holder(GeneralNames r100, int r101) {
        this.entityName = r100;
        this.version = r101;
    }

    public Holder(IssuerSerial r100) {
        this(r100, 1);
    }

    public Holder(IssuerSerial r100, int r101) {
        this.baseCertificateID = r100;
        this.version = r101;
    }

    public Holder(ObjectDigestInfo r100) {
        this.version = 1;
        this.objectDigestInfo = r100;
    }

    public static Holder getInstance(Object r100) {
        if ((r100 instanceof Holder) == false) goto L7;
        return (Holder) r100;
    L7:
        if ((r100 instanceof ASN1TaggedObject) == true) goto L9;
        if (r100 != null) goto L12;
        return null;
    L12:
        return new Holder(ASN1Sequence.getInstance(r100));
    L9:
        return new Holder(ASN1TaggedObject.getInstance(r100));
    }

    public IssuerSerial getBaseCertificateID() {
        return this.baseCertificateID;
    }

    public GeneralNames getEntityName() {
        return this.entityName;
    }

    public ObjectDigestInfo getObjectDigestInfo() {
        return this.objectDigestInfo;
    }

    public int getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.version != 1) goto L15;
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        IssuerSerial r101 = this.baseCertificateID;
        if (r101 == null) goto L7;
        r100.add(new DERTaggedObject(false, 0, r101));
    L7:
        GeneralNames r102 = this.entityName;
        if (r102 == null) goto L10;
        r100.add(new DERTaggedObject(false, 1, r102));
    L10:
        ObjectDigestInfo r103 = this.objectDigestInfo;
        if (r103 == null) goto L14;
        r100.add(new DERTaggedObject(false, 2, r103));
    L14:
        return new DERSequence(r100);
    L15:
        GeneralNames r104 = this.entityName;
        if (r104 == null) goto L20;
        return new DERTaggedObject(true, 1, r104);
    L20:
        return new DERTaggedObject(true, 0, this.baseCertificateID);
    }
}
