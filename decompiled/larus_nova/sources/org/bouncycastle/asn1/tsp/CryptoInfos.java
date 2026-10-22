package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.Attribute;

/* JADX INFO: loaded from: classes42.dex */
public class CryptoInfos extends ASN1Object {
    private ASN1Sequence attributes;

    private CryptoInfos(ASN1Sequence r100) {
        this.attributes = r100;
    }

    public CryptoInfos(Attribute[] r100) {
        this.attributes = new DERSequence(r100);
    }

    public static CryptoInfos getInstance(Object r100) {
        if ((r100 instanceof CryptoInfos) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new CryptoInfos(ASN1Sequence.getInstance(r100));
    L5:
        return (CryptoInfos) r100;
    }

    public static CryptoInfos getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
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
