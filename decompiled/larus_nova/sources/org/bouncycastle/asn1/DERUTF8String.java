package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class DERUTF8String extends ASN1Primitive implements ASN1String {
    private final byte[] string;

    public DERUTF8String(String r100) {
        this.string = Strings.toUTF8ByteArray(r100);
    }

    public DERUTF8String(byte[] r100) {
        this.string = r100;
    }

    public static DERUTF8String getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof DERUTF8String) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (DERUTF8String) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (DERUTF8String) r100;
    }

    public static DERUTF8String getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof DERUTF8String) == true) goto L10;
        return new DERUTF8String(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof DERUTF8String) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.string, ((DERUTF8String) r100).string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 12, this.string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        return (StreamUtil.calculateBodyLength(this.string.length) + 1) + this.string.length;
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public String getString() {
        return Strings.fromUTF8ByteArray(this.string);
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
