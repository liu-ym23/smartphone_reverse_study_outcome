package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class DLBitString extends ASN1BitString {
    public DLBitString(byte r100, int r101) {
        super(r100, r101);
    }

    public DLBitString(int r100) {
        super(ASN1BitString.getBytes(r100), ASN1BitString.getPadBits(r100));
    }

    public DLBitString(ASN1Encodable r100) throws IOException {
        super(r100.toASN1Primitive().getEncoded(ASN1Encoding.DER), 0);
    }

    public DLBitString(byte[] r100) {
        this(r100, 0);
    }

    public DLBitString(byte[] r100, int r101) {
        super(r100, r101);
    }

    public static DLBitString fromOctetString(byte[] r100) {
        if (r100.length < 1) goto L10;
        byte r101 = r100[0];
        int r102 = r100.length - 1;
        byte[] r103 = new byte[r102];
        if (r102 == 0) goto L8;
        System.arraycopy(r100, 1, r103, 0, r100.length - 1);
    L8:
        return new DLBitString(r103, r101);
    L10:
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public static ASN1BitString getInstance(Object r100) {
        if (r100 == null) goto L20;
        if ((r100 instanceof DLBitString) == true) goto L20;
        if ((r100 instanceof DERBitString) == false) goto L11;
        return (DERBitString) r100;
    L11:
        if ((r100 instanceof byte[]) == false) goto L18;
        return (ASN1BitString) ASN1Primitive.fromByteArray((byte[]) r100);
    L14:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L18:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L20:
        return (DLBitString) r100;
    }

    public static ASN1BitString getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof DLBitString) == true) goto L10;
        return fromOctetString(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    @Override // org.bouncycastle.asn1.ASN1BitString, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 3, (byte) this.padBits, this.data);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return ((StreamUtil.calculateBodyLength(this.data.length + 1) + 1) + this.data.length) + 1;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1BitString, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}
