package org.bouncycastle.util;

/* JADX INFO: loaded from: classes42.dex */
public class StoreException extends RuntimeException {
    private Throwable _e;

    public StoreException(String r100, Throwable r101) {
        super(r100);
        this._e = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this._e;
    }
}
