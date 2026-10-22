package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class LinkageValue extends ASN1Object {
    private final byte[] value;

    private LinkageValue(ASN1OctetString r100) {
        this.value = Arrays.clone(Utils.octetStringFixed(r100.getOctets(), 9));
    }

    public static LinkageValue getInstance(Object r100) {
        if ((r100 instanceof LinkageValue) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new LinkageValue(ASN1OctetString.getInstance(r100));
    L5:
        return (LinkageValue) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(Arrays.clone(this.value));
    }
}
