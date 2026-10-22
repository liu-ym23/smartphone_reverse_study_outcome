package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class GroupLinkageValue extends ASN1Object {
    private byte[] jValue;
    private byte[] value;

    private GroupLinkageValue(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.jValue = Utils.octetStringFixed(ASN1OctetString.getInstance(r100.getObjectAt(0)).getOctets(), 4);
        this.value = Utils.octetStringFixed(ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets(), 9);
        return;
    L7:
        throw new IllegalArgumentException("sequence not length 2");
    }

    public static GroupLinkageValue getInstance(Object r100) {
        if ((r100 instanceof GroupLinkageValue) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GroupLinkageValue(ASN1Sequence.getInstance(r100));
    L5:
        return (GroupLinkageValue) r100;
    }

    public byte[] getJValue() {
        return this.jValue;
    }

    public byte[] getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(new DEROctetString(this.jValue));
        r100.add(new DEROctetString(this.value));
        return new DERSequence(r100);
    }
}
