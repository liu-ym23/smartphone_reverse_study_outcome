package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1Null extends ASN1Primitive {
    public ASN1Null() {
    }

    public static ASN1Null getInstance(Object r100) {
        if ((r100 instanceof ASN1Null) == true) goto L5;
        if (r100 != null) goto L16;
        return null;
    L16:
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L11:
        e = move-exception;
        throw new IllegalArgumentException("failed to construct NULL from byte[]: " + e.getMessage());
    L10:
        throw new IllegalArgumentException("unknown object in getInstance(): ".concat(r100.getClass().getName()));
    L5:
        return (ASN1Null) r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1Null) == true) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream r100, boolean r101) throws IOException;

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }
}
