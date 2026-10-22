package org.bouncycastle.crypto.util;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
class DerUtil {
    public DerUtil() {
    }

    public static ASN1OctetString getOctetString(byte[] r100) {
        if (r100 != null) goto L6;
        return new DEROctetString(new byte[0]);
    L6:
        return new DEROctetString(Arrays.clone(r100));
    }

    public static byte[] toByteArray(ASN1Primitive r100) {
        return r100.getEncoded();
    L4:
        e = move-exception;
        final String r101 = "Cannot get encoding: " + e.getMessage();
        throw new AnonymousClass1(r101, e);
    }
}
