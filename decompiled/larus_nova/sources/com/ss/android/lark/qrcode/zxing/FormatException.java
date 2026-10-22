package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: classes37.dex */
public final class FormatException extends ReaderException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FormatException f439108a = null;

    static {
        FormatException r100 = new FormatException();
        f439108a = r100;
        r100.setStackTrace(ReaderException.NO_TRACE);
    }

    public static FormatException getFormatInstance() {
        if (ReaderException.isStackTrace == false) goto L6;
        return new FormatException();
    L6:
        return f439108a;
    }

    private FormatException() {
    }
}
