package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class GenRepContent extends ASN1Object {
    private ASN1Sequence content;

    private GenRepContent(ASN1Sequence r100) {
        this.content = r100;
    }

    public GenRepContent(InfoTypeAndValue r100) {
        this.content = new DERSequence(r100);
    }

    public GenRepContent(InfoTypeAndValue[] r100) {
        this.content = new DERSequence(r100);
    }

    public static GenRepContent getInstance(Object r100) {
        if ((r100 instanceof GenRepContent) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GenRepContent(ASN1Sequence.getInstance(r100));
    L5:
        return (GenRepContent) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }

    public InfoTypeAndValue[] toInfoTypeAndValueArray() {
        int r100 = this.content.size();
        InfoTypeAndValue[] r101 = new InfoTypeAndValue[r100];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = InfoTypeAndValue.getInstance(this.content.getObjectAt(r102));
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }
}
