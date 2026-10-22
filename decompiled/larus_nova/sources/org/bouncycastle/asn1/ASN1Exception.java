package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1Exception extends IOException {
    private Throwable cause;

    public ASN1Exception(String r100) {
        super(r100);
    }

    public ASN1Exception(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
