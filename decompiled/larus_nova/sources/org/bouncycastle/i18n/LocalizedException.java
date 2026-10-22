package org.bouncycastle.i18n;

import java.util.Locale;

/* JADX INFO: loaded from: classes42.dex */
public class LocalizedException extends Exception {
    private Throwable cause;
    protected ErrorBundle message;

    public LocalizedException(ErrorBundle r100) {
        super(r100.getText(Locale.getDefault()));
        this.message = r100;
    }

    public LocalizedException(ErrorBundle r100, Throwable r101) {
        super(r100.getText(Locale.getDefault()));
        this.message = r100;
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public ErrorBundle getErrorMessage() {
        return this.message;
    }
}
