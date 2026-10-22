package org.apache.commons.lang3.concurrent;

/* JADX INFO: loaded from: classes42.dex */
public class ConcurrentRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -6582182735562919670L;

    public ConcurrentRuntimeException() {
    }

    public ConcurrentRuntimeException(Throwable r100) {
        super(ConcurrentUtils.checkedException(r100));
    }

    public ConcurrentRuntimeException(String r100, Throwable r101) {
        super(r100, ConcurrentUtils.checkedException(r101));
    }
}
