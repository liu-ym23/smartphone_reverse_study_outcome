package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class DERIA5String extends ASN1Primitive implements ASN1String {
    private final byte[] string;

    public DERIA5String(String r100) {
        this(r100, false);
    }

    public DERIA5String(String r100, boolean r101) {
        if (r100 == null) goto L13;
        if (r101 == true) goto L6;
    L10:
        this.string = Strings.toByteArray(r100);
        return;
    L6:
        if (isIA5String(r100) == true) goto L10;
        throw new IllegalArgumentException("'string' contains illegal characters");
    L13:
        throw new NullPointerException("'string' cannot be null");
    }

    public DERIA5String(byte[] r100) {
        this.string = r100;
    }

    public static DERIA5String getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof DERIA5String) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (DERIA5String) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (DERIA5String) r100;
    }

    public static DERIA5String getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof DERIA5String) == true) goto L10;
        return new DERIA5String(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    public static boolean isIA5String(String r100) {
        int r101 = r100.length() - 1;
    L3:
        if (r101 < 0) goto L9;
        if (r100.charAt(r101) > 127) goto L6;
        r101 = r101 - 1;
        goto L3
    L6:
        return false;
    L9:
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof DERIA5String) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.string, ((DERIA5String) r100).string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 22, this.string);
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
