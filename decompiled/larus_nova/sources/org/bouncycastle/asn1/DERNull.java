package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class DERNull extends ASN1Null {
    public static final DERNull INSTANCE = null;
    private static final byte[] zeroBytes = null;

    static {
        INSTANCE = new DERNull();
        zeroBytes = new byte[0];
    }

    private DERNull() {
    }

    @Override // org.bouncycastle.asn1.ASN1Null, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        r100.writeEncoded(r101, 5, zeroBytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return 2;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }
}
