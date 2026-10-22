package org.bouncycastle.jce.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class ExtIOException extends IOException implements ExtException {
    private Throwable cause;

    public ExtIOException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable, org.bouncycastle.jce.exception.ExtException
    public Throwable getCause() {
        return this.cause;
    }
}
