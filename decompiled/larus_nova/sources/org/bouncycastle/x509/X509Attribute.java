package org.bouncycastle.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.x509.Attribute;

/* JADX INFO: loaded from: classes42.dex */
public class X509Attribute extends ASN1Object {
    Attribute attr;

    public X509Attribute(String r100, ASN1Encodable r101) {
        this.attr = new Attribute(new ASN1ObjectIdentifier(r100), new DERSet(r101));
    }

    public X509Attribute(String r100, ASN1EncodableVector r101) {
        this.attr = new Attribute(new ASN1ObjectIdentifier(r100), new DERSet(r101));
    }

    public X509Attribute(ASN1Encodable r100) {
        this.attr = Attribute.getInstance(r100);
    }

    public String getOID() {
        return this.attr.getAttrType().getId();
    }

    public ASN1Encodable[] getValues() {
        ASN1Set r100 = this.attr.getAttrValues();
        ASN1Encodable[] r101 = new ASN1Encodable[r100.size()];
        int r102 = 0;
    L4:
        if (r102 == r100.size()) goto L6;
        r101[r102] = r100.getObjectAt(r102);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.attr.toASN1Primitive();
    }
}
