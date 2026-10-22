package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1Object implements ASN1Encodable, Encodable {
    public ASN1Object() {
    }

    public static boolean hasEncodedTagValue(Object r100, int r101) {
        if ((r100 instanceof byte[]) == true) goto L5;
        return false;
    L5:
        if (((byte[]) r100)[0] != r101) goto L9;
        return true;
    L9:
        return false;
    }

    public void encodeTo(OutputStream r100) throws IOException {
        ASN1OutputStream.create(r100).writeObject(this);
    }

    public void encodeTo(OutputStream r100, String r101) throws IOException {
        ASN1OutputStream.create(r100, r101).writeObject(this);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ASN1Encodable) == true) goto L10;
        return false;
    L10:
        return toASN1Primitive().equals(((ASN1Encodable) r100).toASN1Primitive());
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        encodeTo(r100);
        return r100.toByteArray();
    }

    public byte[] getEncoded(String r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        encodeTo(r101, r100);
        return r101.toByteArray();
    }

    public int hashCode() {
        return toASN1Primitive().hashCode();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public abstract ASN1Primitive toASN1Primitive();
}
