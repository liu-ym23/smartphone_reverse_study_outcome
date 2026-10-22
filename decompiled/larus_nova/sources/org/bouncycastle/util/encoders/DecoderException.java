package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes42.dex */
public class DecoderException extends IllegalStateException {
    private Throwable cause;

    public DecoderException(String r100, Throwable r101) {
        super(r100);
        this.cause = r101;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
