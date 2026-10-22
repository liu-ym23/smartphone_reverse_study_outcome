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
public class BitmapSspRange extends ASN1Object {
    private final byte[] sspBitmask;
    private final byte[] sspValue;

    private BitmapSspRange(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.sspValue = Utils.octetStringFixed(ASN1OctetString.getInstance(r100.getObjectAt(0)).getOctets());
        this.sspBitmask = Utils.octetStringFixed(ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets());
        return;
    L7:
        throw new IllegalArgumentException("expected sequence with sspValue and sspBitmask");
    }

    public static BitmapSspRange getInstance(Object r100) {
        if ((r100 instanceof BitmapSspRange) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new BitmapSspRange(ASN1Sequence.getInstance(r100));
    L5:
        return (BitmapSspRange) r100;
    }

    public byte[] getSspBitmask() {
        return Arrays.clone(this.sspBitmask);
    }

    public byte[] getSspValue() {
        return Arrays.clone(this.sspValue);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(new DEROctetString(this.sspValue));
        r100.add(new DEROctetString(this.sspBitmask));
        return new DERSequence(r100);
    }
}
