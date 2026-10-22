package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes42.dex */
public class EncoderException extends IllegalStateException {
    private Throwable cause;

    public EncoderException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
