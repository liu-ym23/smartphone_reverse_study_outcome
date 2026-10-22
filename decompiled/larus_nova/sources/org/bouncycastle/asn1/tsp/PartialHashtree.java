package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class PartialHashtree extends ASN1Object {
    private ASN1Sequence values;

    private PartialHashtree(ASN1Sequence r100) {
        int r101 = 0;
    L4:
        if (r101 == r100.size()) goto L10;
        if ((r100.getObjectAt(r101) instanceof DEROctetString) == false) goto L9;
        r101 = r101 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("unknown object in constructor: ".concat(r100.getObjectAt(r101).getClass().getName()));
    L10:
        this.values = r100;
    }

    public PartialHashtree(byte[] r100) {
        this(new byte[][]{r100});
    }

    public PartialHashtree(byte[][] r100) {
        ASN1EncodableVector r101 = new ASN1EncodableVector(r100.length);
        int r102 = 0;
    L4:
        if (r102 == r100.length) goto L6;
        r101.add(new DEROctetString(Arrays.clone(r100[r102])));
        r102 = r102 + 1;
        goto L4
    L6:
        this.values = new DERSequence(r101);
    }

    public static PartialHashtree getInstance(Object r100) {
        if ((r100 instanceof PartialHashtree) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new PartialHashtree(ASN1Sequence.getInstance(r100));
    L5:
        return (PartialHashtree) r100;
    }

    public byte[][] getValues() {
        int r100 = this.values.size();
        byte[][] r101 = new byte[r100][];
        int r102 = 0;
    L3:
        if (r102 == r100) goto L5;
        r101[r102] = Arrays.clone(ASN1OctetString.getInstance(this.values.getObjectAt(r102)).getOctets());
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.values;
    }
}
