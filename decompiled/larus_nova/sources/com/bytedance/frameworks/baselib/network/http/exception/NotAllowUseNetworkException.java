package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class NotAllowUseNetworkException extends IOException {
    private static final long serialVersionUID = -210264743726619965L;

    public NotAllowUseNetworkException() {
    }

    public NotAllowUseNetworkException(Throwable r100) {
        initCause(r100);
    }

    public NotAllowUseNetworkException(String r100) {
        super(r100);
    }

    public NotAllowUseNetworkException(String r100, Throwable r101) {
        super(r100);
        initCause(r101);
    }
}
