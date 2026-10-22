package org.bouncycastle.asn1;

import java.io.IOException;
import kotlin.UByte;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    protected final boolean isConstructed;
    protected final byte[] octets;
    protected final int tag;

    public ASN1ApplicationSpecific(boolean r100, int r101, byte[] r102) {
        this.isConstructed = r100;
        this.tag = r101;
        this.octets = Arrays.clone(r102);
    }

    public static ASN1ApplicationSpecific getInstance(Object r100) {
        if (r100 == null) goto L16;
        if ((r100 instanceof ASN1ApplicationSpecific) == true) goto L16;
        if ((r100 instanceof byte[]) == false) goto L14;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L10:
        e = move-exception;
        throw new IllegalArgumentException("Failed to construct object from byte[]: " + e.getMessage());
    L14:
        throw new IllegalArgumentException("unknown object in getInstance: ".concat(r100.getClass().getName()));
    L16:
        return (ASN1ApplicationSpecific) r100;
    }

    public static int getLengthOfHeader(byte[] r100) {
        int r101 = r100[1] & UByte.MAX_VALUE;
        if (r101 != 128) goto L6;
        return 2;
    L6:
        if (r101 <= 127) goto L13;
        int r102 = r101 & 127;
        if (r102 > 4) goto L12;
        return r102 + 2;
    L12:
        throw new IllegalStateException("DER length more than 4 bytes: " + r102);
    L13:
        return 2;
    }

    private byte[] replaceTagNumber(int r100, byte[] r101) throws IOException {
        if ((r101[0] & 31) != 31) goto L12;
        int r102 = r101[1] & UByte.MAX_VALUE;
        if ((r102 & 127) == 0) goto L11;
        int r103 = 2;
    L8:
        if ((r102 & 128) == 0) goto L13;
        int r104 = r103 + 1;
        int r105 = r101[r103] & UByte.MAX_VALUE;
        r103 = r104;
        r102 = r105;
    L13:
        int r106 = (r101.length - r103) + 1;
        byte[] r107 = new byte[r106];
        System.arraycopy(r101, r103, r107, 1, r106 - 1);
        r107[0] = (byte) r100;
        return r107;
    L11:
        throw new IOException("corrupted stream - invalid high tag number found");
    L12:
        r103 = 1;
        goto L13
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1ApplicationSpecific) == true) goto L5;
        return false;
    L5:
        ASN1ApplicationSpecific r101 = (ASN1ApplicationSpecific) r100;
        if (this.isConstructed == r101.isConstructed) goto L8;
        return false;
    L8:
        if (this.tag == r101.tag) goto L10;
        return false;
    L10:
        if (Arrays.areEqual(this.octets, r101.octets) == false) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        if (this.isConstructed == false) goto L5;
        int r102 = 96;
    L6:
        r100.writeEncoded(r101, r102, this.tag, this.octets);
        return;
    L5:
        r102 = 64;
        goto L6
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        return (StreamUtil.calculateTagLength(this.tag) + StreamUtil.calculateBodyLength(this.octets.length)) + this.octets.length;
    }

    public int getApplicationTag() {
        return this.tag;
    }

    public byte[] getContents() {
        return Arrays.clone(this.octets);
    }

    public ASN1Primitive getObject() throws IOException {
        return ASN1Primitive.fromByteArray(getContents());
    }

    public ASN1Primitive getObject(int r100) throws IOException {
        if (r100 >= 31) goto L10;
        byte[] r101 = getEncoded();
        byte[] r102 = replaceTagNumber(r100, r101);
        if ((r101[0] & 32) == 0) goto L8;
        r102[0] = (byte) (r102[0] | 32);
    L8:
        return ASN1Primitive.fromByteArray(r102);
    L10:
        throw new IOException("unsupported tag number");
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        boolean r100 = this.isConstructed;
        int r101 = this.tag;
        return ((r100 ? 1 : 0) ^ r101) ^ Arrays.hashCode(this.octets);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return this.isConstructed;
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("[");
        if (isConstructed() == false) goto L5;
        r100.append("CONSTRUCTED ");
    L5:
        r100.append("APPLICATION ");
        r100.append(Integer.toString(getApplicationTag()));
        r100.append("]");
        if (this.octets == null) goto L8;
        r100.append(" #");
        String r101 = Hex.toHexString(this.octets);
    L9:
        r100.append(r101);
        r100.append(" ");
        return r100.toString();
    L8:
        r101 = " #null";
        goto L9
    }
}
