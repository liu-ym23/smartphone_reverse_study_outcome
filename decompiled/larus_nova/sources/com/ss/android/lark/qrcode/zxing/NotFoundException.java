package com.ss.android.lark.qrcode.zxing;

/* JADX INFO: loaded from: classes37.dex */
public final class NotFoundException extends ReaderException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotFoundException f439109a = null;

    static {
        NotFoundException r100 = new NotFoundException();
        f439109a = r100;
        r100.setStackTrace(ReaderException.NO_TRACE);
    }

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return f439109a;
    }
}
