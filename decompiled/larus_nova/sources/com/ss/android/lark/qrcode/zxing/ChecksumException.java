package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: classes37.dex */
public final class ChecksumException extends ReaderException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChecksumException f439105a = null;

    static {
        ChecksumException r100 = new ChecksumException();
        f439105a = r100;
        r100.setStackTrace(ReaderException.NO_TRACE);
    }

    public static ChecksumException getChecksumInstance() {
        if (ReaderException.isStackTrace == false) goto L6;
        return new ChecksumException();
    L6:
        return f439105a;
    }

    private ChecksumException() {
    }

    public ChecksumException(Throwable r100) {
        super(r100);
    }

    public static ChecksumException getChecksumInstance(Throwable r100) {
        if (ReaderException.isStackTrace == false) goto L6;
        return new ChecksumException(r100);
    L6:
        return f439105a;
    }
}
