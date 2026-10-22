package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public class CryptoException extends Exception {
    private Throwable cause;

    public CryptoException() {
    }

    public CryptoException(String r100) {
        super(r100);
    }

    public CryptoException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
