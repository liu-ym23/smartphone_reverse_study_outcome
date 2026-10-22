package org.bouncycastle.asn1.eac;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class UnsignedInteger extends ASN1Object {
    private int tagNo;
    private BigInteger value;

    public UnsignedInteger(int r100, BigInteger r101) {
        this.tagNo = r100;
        this.value = r101;
    }

    private UnsignedInteger(ASN1TaggedObject r100) {
        this.tagNo = r100.getTagNo();
        this.value = new BigInteger(1, ASN1OctetString.getInstance(r100, false).getOctets());
    }

    private byte[] convertValue() {
        byte[] r100 = this.value.toByteArray();
        if (r100[0] != 0) goto L6;
        int r101 = r100.length - 1;
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 1, r102, 0, r101);
        return r102;
    L6:
        return r100;
    }

    public static UnsignedInteger getInstance(Object r100) {
        if ((r100 instanceof UnsignedInteger) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new UnsignedInteger(ASN1TaggedObject.getInstance(r100));
    L5:
        return (UnsignedInteger) r100;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public BigInteger getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, new DEROctetString(convertValue()));
    }
}
