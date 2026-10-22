package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1Boolean extends ASN1Primitive {
    public static final ASN1Boolean FALSE = null;
    private static final byte FALSE_VALUE = 0;
    public static final ASN1Boolean TRUE = null;
    private static final byte TRUE_VALUE = -1;
    private final byte value;

    static {
        FALSE = new ASN1Boolean((byte) 0);
        TRUE = new ASN1Boolean((byte) -1);
    }

    private ASN1Boolean(byte r100) {
        this.value = r100;
    }

    public static ASN1Boolean fromOctetString(byte[] r100) {
        if (r100.length != 1) goto L14;
        byte r101 = r100[0];
        if (r101 == (-1)) goto L12;
        if (r101 == 0) goto L10;
        return new ASN1Boolean(r101);
    L10:
        return FALSE;
    L12:
        return TRUE;
    L14:
        throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
    }

    public static ASN1Boolean getInstance(int r100) {
        if (r100 == 0) goto L5;
        return TRUE;
    L5:
        return FALSE;
    }

    public static ASN1Boolean getInstance(Object r100) {
        if (r100 == null) goto L17;
        if ((r100 instanceof ASN1Boolean) == true) goto L17;
        if ((r100 instanceof byte[]) == false) goto L15;
        return (ASN1Boolean) ASN1Primitive.fromByteArray((byte[]) r100);
    L11:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e.getMessage());
    L15:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L17:
        return (ASN1Boolean) r100;
    }

    public static ASN1Boolean getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof ASN1Boolean) == true) goto L10;
        return fromOctetString(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    public static ASN1Boolean getInstance(boolean r100) {
        if (r100 == false) goto L5;
        return TRUE;
    L5:
        return FALSE;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1Boolean) == true) goto L6;
        return false;
    L6:
        if (isTrue() != ((ASN1Boolean) r100).isTrue()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 1, this.value);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return 3;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return isTrue() ? 1 : 0;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public boolean isTrue() {
        if (this.value == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        if (isTrue() == false) goto L6;
        return TRUE;
    L6:
        return FALSE;
    }

    public String toString() {
        if (isTrue() == false) goto L5;
        return "TRUE";
    L5:
        return "FALSE";
    }
}
