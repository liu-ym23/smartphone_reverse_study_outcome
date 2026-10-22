package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class DERNumericString extends ASN1Primitive implements ASN1String {
    private final byte[] string;

    public DERNumericString(String r100) {
        this(r100, false);
    }

    public DERNumericString(String r100, boolean r101) {
        if (r101 == true) goto L5;
    L9:
        this.string = Strings.toByteArray(r100);
        return;
    L5:
        if (isNumericString(r100) == true) goto L9;
        throw new IllegalArgumentException("string contains illegal characters");
    }

    public DERNumericString(byte[] r100) {
        this.string = r100;
    }

    public static DERNumericString getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof DERNumericString) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (DERNumericString) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (DERNumericString) r100;
    }

    public static DERNumericString getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof DERNumericString) == true) goto L10;
        return new DERNumericString(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    public static boolean isNumericString(String r100) {
        int r101 = r100.length() - 1;
    L3:
        if (r101 < 0) goto L15;
        char r102 = r100.charAt(r101);
        if (r102 > 127) goto L6;
        if ('0' > r102) goto L12;
        if (r102 > '9') goto L12;
    L13:
        r101 = r101 - 1;
    L12:
        if (r102 == ' ') goto L13;
        return false;
    L6:
        return false;
    L15:
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof DERNumericString) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.string, ((DERNumericString) r100).string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 18, this.string);
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
        return Strings.fromByteArray(this.string);
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
