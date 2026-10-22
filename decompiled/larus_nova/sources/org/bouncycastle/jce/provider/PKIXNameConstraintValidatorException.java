package org.bouncycastle.jce.provider;

/* JADX INFO: loaded from: classes42.dex */
public class PKIXNameConstraintValidatorException extends Exception {
    private Throwable cause;

    public PKIXNameConstraintValidatorException(String r100) {
        super(r100);
    }

    public PKIXNameConstraintValidatorException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
