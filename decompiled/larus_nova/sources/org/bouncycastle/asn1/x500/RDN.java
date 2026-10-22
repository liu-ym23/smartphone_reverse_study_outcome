package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;

/* JADX INFO: loaded from: classes42.dex */
public class RDN extends ASN1Object {
    private ASN1Set values;

    public RDN(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        ASN1EncodableVector r102 = new ASN1EncodableVector(2);
        r102.add(r100);
        r102.add(r101);
        this.values = new DERSet(new DERSequence(r102));
    }

    private RDN(ASN1Set r100) {
        this.values = r100;
    }

    public RDN(AttributeTypeAndValue r100) {
        this.values = new DERSet(r100);
    }

    public RDN(AttributeTypeAndValue[] r100) {
        this.values = new DERSet(r100);
    }

    public static RDN getInstance(Object r100) {
        if ((r100 instanceof RDN) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new RDN(ASN1Set.getInstance(r100));
    L5:
        return (RDN) r100;
    }

    public int collectAttributeTypes(ASN1ObjectIdentifier[] r100, int r101) {
        int r102 = this.values.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r100[r101 + r103] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(r103)).getType();
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public boolean containsAttributeType(ASN1ObjectIdentifier r100) {
        int r101 = this.values.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (AttributeTypeAndValue.getInstance(this.values.getObjectAt(r102)).getType().equals(r100) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public AttributeTypeAndValue getFirst() {
        if (this.values.size() != 0) goto L7;
        return null;
    L7:
        return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    public AttributeTypeAndValue[] getTypesAndValues() {
        int r100 = this.values.size();
        AttributeTypeAndValue[] r101 = new AttributeTypeAndValue[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public boolean isMultiValued() {
        if (this.values.size() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int size() {
        return this.values.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.values;
    }
}
