package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DLSet;

/* JADX INFO: loaded from: classes42.dex */
public class Attributes extends ASN1Object {
    private ASN1Set attributes;

    public Attributes(ASN1EncodableVector r100) {
        this.attributes = new DLSet(r100);
    }

    private Attributes(ASN1Set r100) {
        this.attributes = r100;
    }

    public static Attributes getInstance(Object r100) {
        if ((r100 instanceof Attributes) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new Attributes(ASN1Set.getInstance(r100));
    L5:
        return (Attributes) r100;
    }

    public static Attributes getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Set.getInstance(r100, r101));
    }

    public Attribute[] getAttributes() {
        int r100 = this.attributes.size();
        Attribute[] r101 = new Attribute[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = Attribute.getInstance(this.attributes.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.attributes;
    }
}
