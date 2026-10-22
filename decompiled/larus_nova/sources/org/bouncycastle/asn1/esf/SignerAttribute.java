package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Attribute;
import org.bouncycastle.asn1.x509.AttributeCertificate;

/* JADX INFO: loaded from: classes42.dex */
public class SignerAttribute extends ASN1Object {
    private Object[] values;

    private SignerAttribute(ASN1Sequence r100) {
        this.values = new Object[r100.size()];
        Enumeration r101 = r100.getObjects();
        int r102 = 0;
    L4:
        if (r101.hasMoreElements() == false) goto L17;
        ASN1TaggedObject r103 = ASN1TaggedObject.getInstance(r101.nextElement());
        if (r103.getTagNo() != 0) goto L12;
        ASN1Sequence r104 = ASN1Sequence.getInstance(r103, true);
        int r105 = r104.size();
        Attribute[] r106 = new Attribute[r105];
        int r107 = 0;
    L8:
        if (r107 == r105) goto L10;
        r106[r107] = Attribute.getInstance(r104.getObjectAt(r107));
        r107 = r107 + 1;
        goto L8
    L10:
        this.values[r102] = r106;
    L14:
        r102 = r102 + 1;
        goto L4
    L12:
        if (r103.getTagNo() != 1) goto L16;
        this.values[r102] = AttributeCertificate.getInstance(ASN1Sequence.getInstance(r103, true));
        goto L14
    L16:
        throw new IllegalArgumentException("illegal tag: " + r103.getTagNo());
    }

    public SignerAttribute(AttributeCertificate r100) {
        this.values = new Object[]{r100};
    }

    public SignerAttribute(Attribute[] r100) {
        this.values = new Object[]{r100};
    }

    public static SignerAttribute getInstance(Object r100) {
        if ((r100 instanceof SignerAttribute) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SignerAttribute(ASN1Sequence.getInstance(r100));
    L5:
        return (SignerAttribute) r100;
    }

    public Object[] getValues() {
        Object[] r100 = this.values;
        int r101 = r100.length;
        Object[] r102 = new Object[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(this.values.length);
        int r101 = 0;
    L3:
        Object[] r102 = this.values;
        if (r101 == r102.length) goto L11;
        Object r103 = r102[r101];
        if ((r103 instanceof Attribute[]) == false) goto L8;
        DERTaggedObject r104 = new DERTaggedObject(0, new DERSequence((Attribute[]) r103));
    L9:
        r100.add(r104);
        r101 = r101 + 1;
        goto L3
    L8:
        r104 = new DERTaggedObject(1, (AttributeCertificate) r103);
        goto L9
    L11:
        return new DERSequence(r100);
    }
}
