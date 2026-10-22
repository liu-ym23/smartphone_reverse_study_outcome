package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SequenceOfOctetString extends ASN1Object {
    private byte[][] octetStrings;

    private SequenceOfOctetString(ASN1Sequence r100) {
        this.octetStrings = toByteArrays(r100);
    }

    public static SequenceOfOctetString getInstance(Object r100) {
        if ((r100 instanceof SequenceOfOctetString) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SequenceOfOctetString(ASN1Sequence.getInstance(r100));
    L5:
        return (SequenceOfOctetString) r100;
    }

    public static byte[][] toByteArrays(ASN1Sequence r100) {
        byte[][] r101 = new byte[r100.size()][];
        int r102 = 0;
    L4:
        if (r102 == r100.size()) goto L6;
        r101[r102] = ASN1OctetString.getInstance(r100.getObjectAt(r102)).getOctets();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public int size() {
        return this.octetStrings.length;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        int r101 = 0;
    L3:
        byte[][] r102 = this.octetStrings;
        if (r101 == r102.length) goto L7;
        r100.add(new DEROctetString(Arrays.clone(r102[r101])));
        r101 = r101 + 1;
        goto L3
    L7:
        return new DERSequence(r100);
    }
}
