package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1Sequence;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedData {
    private EncryptedData(ASN1Sequence r100) {
    }

    public static EncryptedData getInstance(Object r100) {
        if ((r100 instanceof EncryptedData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new EncryptedData(ASN1Sequence.getInstance(r100));
    L5:
        return (EncryptedData) r100;
    }
}
