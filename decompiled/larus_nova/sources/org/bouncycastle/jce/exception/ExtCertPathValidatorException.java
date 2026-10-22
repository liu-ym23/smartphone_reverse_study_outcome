package org.bouncycastle.jce.exception;

import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;

/* JADX INFO: loaded from: classes42.dex */
public class ExtCertPathValidatorException extends CertPathValidatorException implements ExtException {
    private Throwable cause;

    public ExtCertPathValidatorException(String r100) {
        super(r100);
    }

    public ExtCertPathValidatorException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    public ExtCertPathValidatorException(String r100, Throwable r101, CertPath r102, int r103) {
        super(r100, r101, r102, r103);
        this.cause = r101;
    }

    @Override // java.lang.Throwable, org.bouncycastle.jce.exception.ExtException
    public Throwable getCause() {
        return this.cause;
    }
}
