package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class PKIMessage extends ASN1Object {
    private PKIBody body;
    private ASN1Sequence extraCerts;
    private PKIHeader header;
    private DERBitString protection;

    private PKIMessage(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.header = PKIHeader.getInstance(r101.nextElement());
        this.body = PKIBody.getInstance(r101.nextElement());
    L4:
        if (r101.hasMoreElements() == false) goto L9;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        if (r102.getTagNo() == 0) goto L7;
        this.extraCerts = ASN1Sequence.getInstance(r102, true);
        goto L4
    L7:
        this.protection = DERBitString.getInstance(r102, true);
        goto L4
    }

    public PKIMessage(PKIHeader r100, PKIBody r101) {
        this(r100, r101, null, null);
    }

    public PKIMessage(PKIHeader r100, PKIBody r101, DERBitString r102) {
        this(r100, r101, r102, null);
    }

    public PKIMessage(PKIHeader r100, PKIBody r101, DERBitString r102, CMPCertificate[] r103) {
        this.header = r100;
        this.body = r101;
        this.protection = r102;
        if (r103 == null) goto L6;
        this.extraCerts = new DERSequence(r103);
        return;
    }

    private void addOptional(ASN1EncodableVector r100, int r101, ASN1Encodable r102) {
        if (r102 == null) goto L5;
        r100.add(new DERTaggedObject(true, r101, r102));
        return;
    }

    public static PKIMessage getInstance(Object r100) {
        if ((r100 instanceof PKIMessage) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PKIMessage(ASN1Sequence.getInstance(r100));
    L5:
        return (PKIMessage) r100;
    }

    public PKIBody getBody() {
        return this.body;
    }

    public CMPCertificate[] getExtraCerts() {
        ASN1Sequence r100 = this.extraCerts;
        if (r100 != null) goto L6;
        return null;
    L6:
        int r101 = r100.size();
        CMPCertificate[] r102 = new CMPCertificate[r101];
        int r103 = 0;
    L7:
        if (r103 >= r101) goto L9;
        r102[r103] = CMPCertificate.getInstance(this.extraCerts.getObjectAt(r103));
        r103 = r103 + 1;
        goto L7
    L9:
        return r102;
    }

    public PKIHeader getHeader() {
        return this.header;
    }

    public DERBitString getProtection() {
        return this.protection;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.header);
        r100.add(this.body);
        addOptional(r100, 0, this.protection);
        addOptional(r100, 1, this.extraCerts);
        return new DERSequence(r100);
    }
}
