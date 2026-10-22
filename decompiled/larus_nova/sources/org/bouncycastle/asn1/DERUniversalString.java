package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DERUniversalString extends ASN1Primitive implements ASN1String {
    private static final char[] table = null;
    private final byte[] string;

    static {
        table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public DERUniversalString(byte[] r100) {
        this.string = Arrays.clone(r100);
    }

    public static DERUniversalString getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof DERUniversalString) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (DERUniversalString) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (DERUniversalString) r100;
    }

    public static DERUniversalString getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof DERUniversalString) == true) goto L10;
        return new DERUniversalString(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof DERUniversalString) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.string, ((DERUniversalString) r100).string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 28, this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return (StreamUtil.calculateBodyLength(this.string.length) + 1) + this.string.length;
    }

    public byte[] getOctets() {
        return Arrays.clone(this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public String getString() {
        StringBuffer r100 = new StringBuffer("#");
        byte[] r101 = getEncoded();     // Catch: IOException -> L10
        int r102 = 0;
    L6:
        if (r102 == r101.length) goto L9;
        char[] r103 = table;
        r100.append(r103[(r101[r102] >>> 4) & 15]);
        r100.append(r103[r101[r102] & 15]);
        r102 = r102 + 1;
        goto L6
    L9:
        return r100.toString();
    L11:
        throw new ASN1ParsingException("internal error encoding UniversalString");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }
}
