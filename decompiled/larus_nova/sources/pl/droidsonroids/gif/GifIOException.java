package pl.droidsonroids.gif;

import java.io.IOException;

/* JADX INFO: loaded from: classes41.dex */
public class GifIOException extends IOException {
    private static final long serialVersionUID = 13038402904505L;
    private final String mErrnoMessage;
    public final GifError reason;

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.mErrnoMessage != null) goto L7;
        return this.reason.getFormattedDescription();
    L7:
        return this.reason.getFormattedDescription() + ": " + this.mErrnoMessage;
    }

    public static GifIOException fromCode(int r100) {
        if (r100 != GifError.NO_ERROR.errorCode) goto L6;
        return null;
    L6:
        return new GifIOException(r100, null);
    }

    public GifIOException(int r100, String r101) {
        this.reason = GifError.fromCode(r100);
        this.mErrnoMessage = r101;
    }
}
