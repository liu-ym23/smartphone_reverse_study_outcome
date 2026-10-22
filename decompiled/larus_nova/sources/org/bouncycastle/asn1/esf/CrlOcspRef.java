package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class CrlOcspRef extends ASN1Object {
    private CrlListID crlids;
    private OcspListID ocspids;
    private OtherRevRefs otherRev;

    private CrlOcspRef(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L16;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        int r103 = r102.getTagNo();
        if (r103 != 0) goto L8;
        this.crlids = CrlListID.getInstance(r102.getObject());
        goto L4
    L8:
        if (r103 != 1) goto L10;
        this.ocspids = OcspListID.getInstance(r102.getObject());
        goto L4
    L10:
        if (r103 != 2) goto L13;
        this.otherRev = OtherRevRefs.getInstance(r102.getObject());
        goto L4
    L13:
        throw new IllegalArgumentException("illegal tag");
    }

    public CrlOcspRef(CrlListID r100, OcspListID r101, OtherRevRefs r102) {
        this.crlids = r100;
        this.ocspids = r101;
        this.otherRev = r102;
    }

    public static CrlOcspRef getInstance(Object r100) {
        if ((r100 instanceof CrlOcspRef) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CrlOcspRef(ASN1Sequence.getInstance(r100));
    L5:
        return (CrlOcspRef) r100;
    }

    public CrlListID getCrlids() {
        return this.crlids;
    }

    public OcspListID getOcspids() {
        return this.ocspids;
    }

    public OtherRevRefs getOtherRev() {
        return this.otherRev;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        CrlListID r101 = this.crlids;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, r101.toASN1Primitive()));
    L5:
        OcspListID r102 = this.ocspids;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(true, 1, r102.toASN1Primitive()));
    L8:
        OtherRevRefs r103 = this.otherRev;
        if (r103 == null) goto L12;
        r100.add(new DERTaggedObject(true, 2, r103.toASN1Primitive()));
    L12:
        return new DERSequence(r100);
    }
}
