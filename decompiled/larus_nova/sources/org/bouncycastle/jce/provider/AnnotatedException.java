package org.bouncycastle.jce.provider;

import org.bouncycastle.jce.exception.ExtException;

/* JADX INFO: loaded from: classes42.dex */
public class AnnotatedException extends Exception implements ExtException {
    private Throwable _underlyingException;

    public AnnotatedException(String r100) {
        this(r100, null);
    }

    public AnnotatedException(String r100, Throwable r101) {
        super(r100);
        this._underlyingException = r101;
    }

    @Override // java.lang.Throwable, org.bouncycastle.jce.exception.ExtException
    public Throwable getCause() {
        return this._underlyingException;
    }

    public Throwable getUnderlyingException() {
        return this._underlyingException;
    }
}
