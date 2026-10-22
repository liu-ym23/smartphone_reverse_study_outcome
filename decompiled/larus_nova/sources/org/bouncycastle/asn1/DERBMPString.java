package org.bouncycastle.asn1;

import java.io.IOException;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DERBMPString extends ASN1Primitive implements ASN1String {
    private final char[] string;

    public DERBMPString(String r100) {
        if (r100 == null) goto L7;
        this.string = r100.toCharArray();
        return;
    L7:
        throw new NullPointerException("'string' cannot be null");
    }

    public DERBMPString(byte[] r100) {
        if (r100 == null) goto L14;
        int r101 = r100.length;
        if ((r101 & 1) != 0) goto L12;
        int r102 = r101 / 2;
        char[] r103 = new char[r102];
        int r104 = 0;
    L7:
        if (r104 == r102) goto L9;
        int r105 = r104 * 2;
        int r106 = r100[r105] << 8;
        r103[r104] = (char) ((r100[r105 + 1] & UByte.MAX_VALUE) | r106);
        r104 = r104 + 1;
        goto L7
    L9:
        this.string = r103;
        return;
    L12:
        throw new IllegalArgumentException("malformed BMPString encoding encountered");
    L14:
        throw new NullPointerException("'string' cannot be null");
    }

    public DERBMPString(char[] r100) {
        if (r100 == null) goto L7;
        this.string = r100;
        return;
    L7:
        throw new NullPointerException("'string' cannot be null");
    }

    public static DERBMPString getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof DERBMPString) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return (DERBMPString) ASN1Primitive.fromByteArray((byte[]) r100);
    L10:
        e = move-exception;
        throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
    L14:
        throw new IllegalArgumentException("illegal object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (DERBMPString) r100;
    }

    public static DERBMPString getInstance(ASN1TaggedObject r100, boolean r101) {
        ASN1Primitive r102 = r100.getObject();
        if (r101 == true) goto L10;
        if ((r102 instanceof DERBMPString) == true) goto L10;
        return new DERBMPString(ASN1OctetString.getInstance(r102).getOctets());
    L10:
        return getInstance(r102);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof DERBMPString) == true) goto L7;
        return false;
    L7:
        return Arrays.areEqual(this.string, ((DERBMPString) r100).string);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r110, boolean r111) throws IOException {
        int r100 = this.string.length;
        if (r111 == false) goto L5;
        r110.write(30);
    L5:
        r110.writeLength(r100 * 2);
        byte[] r101 = new byte[8];
        int r102 = r100 & (-4);
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        char[] r104 = this.string;
        char r105 = r104[r103];
        char r106 = r104[r103 + 1];
        char r107 = r104[r103 + 2];
        char r108 = r104[r103 + 3];
        r103 = r103 + 4;
        r101[0] = (byte) (r105 >> '\b');
        r101[1] = (byte) r105;
        r101[2] = (byte) (r106 >> '\b');
        r101[3] = (byte) r106;
        r101[4] = (byte) (r107 >> '\b');
        r101[5] = (byte) r107;
        r101[6] = (byte) (r108 >> '\b');
        r101[7] = (byte) r108;
        r110.write(r101, 0, 8);
        goto L7
    L9:
        if (r103 >= r100) goto L18;
        int r112 = 0;
    L11:
        char r109 = this.string[r103];
        r103 = r103 + 1;
        int r113 = r112 + 1;
        r101[r112] = (byte) (r109 >> '\b');
        r112 = r113 + 1;
        r101[r113] = (byte) r109;
        if (r103 < r100) goto L11;
        r110.write(r101, 0, r112);
        return;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return (StreamUtil.calculateBodyLength(this.string.length * 2) + 1) + (this.string.length * 2);
    }

    @Override // org.bouncycastle.asn1.ASN1String
    public String getString() {
        return new String(this.string);
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
