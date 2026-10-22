package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1BitString extends ASN1Primitive implements ASN1String {
    private static final char[] table = null;
    protected final byte[] data;
    protected final int padBits;

    static {
        table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public ASN1BitString(byte r100, int r101) {
        if (r101 > 7) goto L8;
        if (r101 < 0) goto L8;
        this.data = new byte[]{r100};
        this.padBits = r101;
        return;
    L8:
        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    }

    public ASN1BitString(byte[] r100, int r101) {
        if (r100 == null) goto L18;
        if (r100.length != 0) goto L11;
        if (r101 == 0) goto L11;
        throw new IllegalArgumentException("zero length data with non-zero pad bits");
    L11:
        if (r101 > 7) goto L16;
        if (r101 < 0) goto L16;
        this.data = Arrays.clone(r100);
        this.padBits = r101;
        return;
    L16:
        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    L18:
        throw new NullPointerException("'data' cannot be null");
    }

    public static ASN1BitString fromInputStream(int r100, InputStream r101) throws IOException {
        if (r100 < 1) goto L20;
        int r102 = r101.read();
        int r103 = r100 - 1;
        byte[] r104 = new byte[r103];
        if (r103 == 0) goto L18;
        if (Streams.readFully(r101, r104) != r103) goto L16;
        if (r102 <= 0) goto L18;
        if (r102 >= 8) goto L18;
        byte r105 = r104[r103 - 1];
        if (r105 == ((byte) ((255 << r102) & r105))) goto L18;
        return new DLBitString(r104, r102);
    L16:
        throw new EOFException("EOF encountered in middle of BIT STRING");
    L18:
        return new DERBitString(r104, r102);
    L20:
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public static byte[] getBytes(int r100) {
        int r101 = 0;
        if (r100 == 0) goto L5;
        int r102 = 4;
        int r103 = 3;
    L8:
        if (r103 < 1) goto L13;
        if (((255 << (r103 * 8)) & r100) != 0) goto L13;
        r102 = r102 - 1;
        r103 = r103 - 1;
    L13:
        byte[] r104 = new byte[r102];
    L14:
        if (r101 >= r102) goto L16;
        r104[r101] = (byte) ((r100 >> (r101 * 8)) & 255);
        r101 = r101 + 1;
        goto L14
    L16:
        return r104;
    L5:
        return new byte[0];
    }

    public static int getPadBits(int r100) {
        int r101 = 3;
    L4:
        if (r101 < 0) goto L12;
        if (r101 == 0) goto L9;
        int r102 = r100 >> (r101 * 8);
        if (r102 == 0) goto L11;
        int r103 = r102 & 255;
    L13:
        if (r103 != 0) goto L15;
        return 0;
    L15:
        int r104 = 1;
    L16:
        r103 = r103 << 1;
        if ((r103 & 255) == 0) goto L20;
        r104 = r104 + 1;
        goto L16
    L20:
        return 8 - r104;
    L11:
        r101 = r101 - 1;
        goto L4
    L9:
        if (r100 == 0) goto L11;
        r103 = r100 & 255;
        goto L13
    L12:
        r103 = 0;
        goto L13
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1BitString) == true) goto L5;
        return false;
    L5:
        ASN1BitString r101 = (ASN1BitString) r100;
        if (this.padBits == r101.padBits) goto L8;
        return false;
    L8:
        byte[] r102 = this.data;
        byte[] r103 = r101.data;
        int r104 = r102.length;
        if (r104 == r103.length) goto L11;
        return false;
    L11:
        int r105 = r104 - 1;
        if (r105 >= 0) goto L14;
        return true;
    L14:
        int r106 = 0;
    L15:
        if (r106 >= r105) goto L20;
        if (r102[r106] != r103[r106]) goto L18;
        r106 = r106 + 1;
        goto L15
    L18:
        return false;
    L20:
        byte r107 = r102[r105];
        int r108 = this.padBits;
        if (((byte) (r107 & (255 << r108))) != ((byte) (r103[r105] & (255 << r108)))) goto L26;
        return true;
    L26:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream r100, boolean r101) throws IOException;

    public byte[] getBytes() {
        byte[] r100 = this.data;
        if (r100.length != 0) goto L5;
        return r100;
    L5:
        byte[] r101 = Arrays.clone(r100);
        int r102 = this.data.length - 1;
        r101[r102] = (byte) (r101[r102] & (255 << this.padBits));
        return r101;
    }

    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public byte[] getOctets() {
        if (this.padBits != 0) goto L7;
        return Arrays.clone(this.data);
    L7:
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public int getPadBits() {
        return this.padBits;
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
    L10:
        e = move-exception;
        throw new ASN1ParsingException("Internal error encoding BitString: " + e.getMessage(), e);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        byte[] r100 = this.data;
        int r101 = r100.length - 1;
        if (r101 >= 0) goto L7;
        return 1;
    L7:
        return ((Arrays.hashCode(r100, 0, r101) * 257) ^ ((byte) (r100[r101] & (255 << this.padBits)))) ^ this.padBits;
    }

    public int intValue() {
        int r100 = Math.min(4, this.data.length - 1);
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= r100) goto L6;
        r102 = r102 | ((255 & this.data[r101]) << (r101 * 8));
        r101 = r101 + 1;
        goto L4
    L6:
        if (r100 < 0) goto L11;
        if (r100 < 4) goto L9;
        return r102;
    L9:
        return r102 | ((((byte) (this.data[r100] & (255 << this.padBits))) & UByte.MAX_VALUE) << (r100 * 8));
    L11:
        return r102;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERBitString(this.data, this.padBits);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLBitString(this.data, this.padBits);
    }

    public String toString() {
        return getString();
    }
}
