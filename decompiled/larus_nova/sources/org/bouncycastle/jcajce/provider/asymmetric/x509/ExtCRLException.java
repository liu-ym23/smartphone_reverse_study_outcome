package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;

/* JADX INFO: loaded from: classes42.dex */
class ExtCRLException extends CRLException {
    Throwable cause;

    public ExtCRLException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
