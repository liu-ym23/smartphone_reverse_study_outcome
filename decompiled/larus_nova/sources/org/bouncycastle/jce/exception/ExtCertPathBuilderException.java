package org.bouncycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;

/* JADX INFO: loaded from: classes42.dex */
public class ExtCertPathBuilderException extends CertPathBuilderException implements ExtException {
    private Throwable cause;

    public ExtCertPathBuilderException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    public ExtCertPathBuilderException(String r100, Throwable r101, CertPath r102, int r103) {
        super(r100, r101);
        this.cause = r101;
    }

    @Override // java.lang.Throwable, org.bouncycastle.jce.exception.ExtException
    public Throwable getCause() {
        return this.cause;
    }
}
