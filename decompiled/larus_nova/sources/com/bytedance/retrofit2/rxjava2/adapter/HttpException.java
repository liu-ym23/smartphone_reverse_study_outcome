package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.SsResponse;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes21.dex */
public final class HttpException extends RuntimeException {
    private final int code;
    private final transient SsResponse<?> response;

    public int code() {
        return this.code;
    }

    public SsResponse<?> response() {
        return this.response;
    }

    public HttpException(SsResponse<?> r100) {
        super(getMessage(r100));
        this.code = r100.code();
        this.response = r100;
    }

    private static String getMessage(SsResponse<?> r100) {
        checkNotNull(r100, "response == null");
        return "HTTP " + r100.code();
    }

    private static <T> T checkNotNull(@Nullable T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }
}
