package com.google.zxing;

/* JADX INFO: loaded from: classes23.dex */
public final class NotFoundException extends ReaderException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotFoundException f275935a = null;

    static {
        NotFoundException r100 = new NotFoundException();
        f275935a = r100;
        r100.setStackTrace(ReaderException.NO_TRACE);
    }

    public static NotFoundException getNotFoundInstance() {
        if (ReaderException.isStackTrace == false) goto L6;
        return new NotFoundException();
    L6:
        return f275935a;
    }

    private NotFoundException() {
    }
}
