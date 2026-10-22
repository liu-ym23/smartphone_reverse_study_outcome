package org.bouncycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1Primitive extends ASN1Object {
    public ASN1Primitive() {
    }

    public static ASN1Primitive fromByteArray(byte[] r100) throws IOException {
        ASN1InputStream r101 = new ASN1InputStream(r100);
        ASN1Primitive r102 = r101.readObject();     // Catch: ClassCastException -> L8
        if (r101.available() != 0) goto L7;
        return r102;
    L7:
        throw new IOException("Extra data detected in stream");     // Catch: ClassCastException -> L8
    L9:
        throw new IOException("cannot recognise object in stream");
    }

    public abstract boolean asn1Equals(ASN1Primitive r100);

    public abstract void encode(ASN1OutputStream r100, boolean r101) throws IOException;

    @Override // org.bouncycastle.asn1.ASN1Object
    public void encodeTo(OutputStream r100) throws IOException {
        ASN1OutputStream.create(r100).writeObject(this);
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public void encodeTo(OutputStream r100, String r101) throws IOException {
        ASN1OutputStream.create(r100, r101).writeObject(this);
    }

    public abstract int encodedLength() throws IOException;

    @Override // org.bouncycastle.asn1.ASN1Object
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ASN1Encodable) == true) goto L8;
    L10:
        return false;
    L8:
        if (asn1Equals(((ASN1Encodable) r100).toASN1Primitive()) == false) goto L10;
        return true;
    }

    public final boolean equals(ASN1Encodable r100) {
        if (this == r100) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (asn1Equals(r100.toASN1Primitive()) == false) goto L7;
    L8:
        return true;
    }

    public final boolean equals(ASN1Primitive r100) {
        if (this != r100) goto L4;
    L7:
        return true;
    L4:
        if (asn1Equals(r100) == true) goto L7;
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object
    public abstract int hashCode();

    public abstract boolean isConstructed();

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public final ASN1Primitive toASN1Primitive() {
        return this;
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
