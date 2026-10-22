package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class DERPrintableString extends ASN1Primitive implements ASN1String {
    private final byte[] string;

    public DERPrintableString(String r100) {
        this(r100, false);
    }

    public DERPrintableString(String r100, boolean r101) {
        if (r101 == true) goto L5;
    L9:
        this.string = Strings.toByteArray(r100);
        return;
    L5:
        if (isPrintableString(r100) == true) goto L9;
        throw new IllegalArgumentException("string contains illegal characters");
    }

    public DERPrintableString(byte[] r100) {
        this.string = r100;
    }

    public static DERPrintableString getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof DERPrintableString) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (DERPrintableString) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (DERPrintableString) r100;
    }

    public static DERPrintableString getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof DERPrintableString) == true) goto L10;
        return new DERPrintableString(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    public static boolean isPrintableString(String r100) {
        int r101 = r100.length() - 1;
    L3:
        if (r101 < 0) goto L34;
        char r102 = r100.charAt(r101);
        if (r102 > 127) goto L6;
        if ('a' > r102) goto L13;
        if (r102 > 'z') goto L13;
    L33:
        r101 = r101 - 1;
    L13:
        if ('A' > r102) goto L18;
        if (r102 <= 'Z') goto L33;
    L18:
        if ('0' > r102) goto L23;
        if (r102 <= '9') goto L33;
    L23:
        if (r102 == ' ') goto L33;
        if (r102 == ':') goto L33;
        if (r102 == '=') goto L33;
        if (r102 == '?') goto L33;
        switch(r102) {
            case 39: goto L33;
            case 40: goto L33;
            case 41: goto L33;
            default: goto L31;
        };
    L31:
        switch(r102) {
            case 43: goto L33;
            case 44: goto L33;
            case 45: goto L33;
            case 46: goto L33;
            case 47: goto L33;
            default: goto L32;
        };
    L32:
        return false;
    L6:
        return false;
    L34:
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof DERPrintableString) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.string, ((DERPrintableString) r100).string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 19, this.string);
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
