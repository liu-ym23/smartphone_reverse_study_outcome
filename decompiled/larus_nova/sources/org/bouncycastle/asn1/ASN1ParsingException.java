package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes42.dex */
public class ASN1ParsingException extends IllegalStateException {
    private Throwable cause;

    public ASN1ParsingException(String r100) {
        super(r100);
    }

    public ASN1ParsingException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
