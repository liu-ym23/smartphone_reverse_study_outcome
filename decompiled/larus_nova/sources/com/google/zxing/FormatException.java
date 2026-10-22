package com.google.zxing;

/* JADX INFO: loaded from: classes23.dex */
public final class FormatException extends ReaderException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FormatException f275934a = null;

    static {
        FormatException r100 = new FormatException();
        f275934a = r100;
        r100.setStackTrace(ReaderException.NO_TRACE);
    }

    public static FormatException getFormatInstance() {
        if (ReaderException.isStackTrace == false) goto L6;
        return new FormatException();
    L6:
        return f275934a;
    }

    private FormatException() {
    }

    public FormatException(Throwable r100) {
        super(r100);
    }

    public static FormatException getFormatInstance(Throwable r100) {
        if (ReaderException.isStackTrace == false) goto L6;
        return new FormatException(r100);
    L6:
        return f275934a;
    }
}
