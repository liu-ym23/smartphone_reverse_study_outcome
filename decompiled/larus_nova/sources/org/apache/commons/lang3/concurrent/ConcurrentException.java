package org.apache.commons.lang3.concurrent;

/* JADX INFO: loaded from: classes42.dex */
public class ConcurrentException extends Exception {
    private static final long serialVersionUID = 6622707671812226130L;

    public ConcurrentException() {
    }

    public ConcurrentException(Throwable r100) {
        super(ConcurrentUtils.checkedException(r100));
    }

    public ConcurrentException(String r100, Throwable r101) {
        super(r100, ConcurrentUtils.checkedException(r101));
    }
}
