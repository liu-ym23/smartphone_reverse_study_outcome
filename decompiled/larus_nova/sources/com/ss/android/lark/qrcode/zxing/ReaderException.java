package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: classes37.dex */
public abstract class ReaderException extends Exception {
    protected static final StackTraceElement[] NO_TRACE = null;
    protected static final boolean isStackTrace = false;

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        monitor-enter(this);
        monitor-exit(this);
        return null;
    }

    static {
        if (System.getProperty("surefire.test.class.path") == null) goto L5;
        boolean r100 = true;
    L6:
        isStackTrace = r100;
        NO_TRACE = new StackTraceElement[0];
        return;
    L5:
        r100 = false;
        goto L6
    }

    public ReaderException() {
    }

    public ReaderException(Throwable r100) {
        super(r100);
    }
}
