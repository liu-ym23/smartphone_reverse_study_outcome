package org.bouncycastle.util.io.pem;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class PemGenerationException extends IOException {
    private Throwable cause;

    public PemGenerationException(String r100) {
        super(r100);
    }

    public PemGenerationException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
