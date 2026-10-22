package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class NotAllowApiHttpException extends IOException {
    private static final long serialVersionUID = -5588326043064908201L;

    public NotAllowApiHttpException() {
    }

    public NotAllowApiHttpException(Throwable r100) {
        initCause(r100);
    }

    public NotAllowApiHttpException(String r100) {
        super(r100);
    }

    public NotAllowApiHttpException(String r100, Throwable r101) {
        super(r100);
        initCause(r101);
    }
}
