package com.huawei.hms.support.api.push;

/* JADX INFO: loaded from: classes23.dex */
public class PushException extends RuntimeException {
    public static final String EXCEPTION_SEND_FAILED = "send message failed";

    public PushException() {
    }

    public PushException(String r100) {
        super(r100);
    }

    public PushException(Throwable r100) {
        super(r100);
    }

    public PushException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
