package org.bouncycastle.util;

/* JADX INFO: loaded from: classes42.dex */
public class StreamParsingException extends Exception {
    Throwable _e;

    public StreamParsingException(String r100, Throwable r101) {
        super(r100);
        this._e = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this._e;
    }
}
