package org.bouncycastle.x509;

import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes42.dex */
class ExtCertificateEncodingException extends CertificateEncodingException {
    Throwable cause;

    public ExtCertificateEncodingException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
