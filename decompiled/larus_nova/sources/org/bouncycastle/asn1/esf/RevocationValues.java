package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import org.bouncycastle.asn1.x509.CertificateList;

/* JADX INFO: loaded from: classes42.dex */
public class RevocationValues extends ASN1Object {
    private ASN1Sequence crlVals;
    private ASN1Sequence ocspVals;
    private OtherRevVals otherRevVals;

    private RevocationValues(ASN1Sequence r100) {
        if (r100.size() > 3) goto L28;
        Enumeration r101 = r100.getObjects();
    L6:
        if (r101.hasMoreElements() == false) goto L26;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        int r103 = r102.getTagNo();
        if (r103 != 0) goto L10;
        ASN1Sequence r104 = (ASN1Sequence) r102.getObject();
        Enumeration r105 = r104.getObjects();
    L23:
        if (r105.hasMoreElements() == false) goto L25;
        CertificateList.getInstance(r105.nextElement());
        goto L23
    L25:
        this.crlVals = r104;
        goto L6
    L10:
        if (r103 != 1) goto L12;
        ASN1Sequence r106 = (ASN1Sequence) r102.getObject();
        Enumeration r107 = r106.getObjects();
    L18:
        if (r107.hasMoreElements() == false) goto L20;
        BasicOCSPResponse.getInstance(r107.nextElement());
        goto L18
    L20:
        this.ocspVals = r106;
        goto L6
    L12:
        if (r103 != 2) goto L15;
        this.otherRevVals = OtherRevVals.getInstance(r102.getObject());
        goto L6
    L15:
        throw new IllegalArgumentException("invalid tag: " + r102.getTagNo());
    L26:
        return;
    L28:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public RevocationValues(CertificateList[] r100, BasicOCSPResponse[] r101, OtherRevVals r102) {
        if (r100 == null) goto L5;
        this.crlVals = new DERSequence(r100);
    L5:
        if (r101 == null) goto L7;
        this.ocspVals = new DERSequence(r101);
    L7:
        this.otherRevVals = r102;
    }

    public static RevocationValues getInstance(Object r100) {
        if ((r100 instanceof RevocationValues) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RevocationValues(ASN1Sequence.getInstance(r100));
    L5:
        return (RevocationValues) r100;
    }

    public CertificateList[] getCrlVals() {
        ASN1Sequence r100 = this.crlVals;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.size();
        CertificateList[] r103 = new CertificateList[r102];
    L7:
        if (r101 >= r102) goto L9;
        r103[r101] = CertificateList.getInstance(this.crlVals.getObjectAt(r101));
        r101 = r101 + 1;
        goto L7
    L9:
        return r103;
    L5:
        return new CertificateList[0];
    }

    public BasicOCSPResponse[] getOcspVals() {
        ASN1Sequence r100 = this.ocspVals;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.size();
        BasicOCSPResponse[] r103 = new BasicOCSPResponse[r102];
    L7:
        if (r101 >= r102) goto L9;
        r103[r101] = BasicOCSPResponse.getInstance(this.ocspVals.getObjectAt(r101));
        r101 = r101 + 1;
        goto L7
    L9:
        return r103;
    L5:
        return new BasicOCSPResponse[0];
    }

    public OtherRevVals getOtherRevVals() {
        return this.otherRevVals;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        ASN1Sequence r101 = this.crlVals;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(true, 0, r101));
    L5:
        ASN1Sequence r102 = this.ocspVals;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(true, 1, r102));
    L8:
        OtherRevVals r103 = this.otherRevVals;
        if (r103 == null) goto L12;
        r100.add(new DERTaggedObject(true, 2, r103.toASN1Primitive()));
    L12:
        return new DERSequence(r100);
    }
}
