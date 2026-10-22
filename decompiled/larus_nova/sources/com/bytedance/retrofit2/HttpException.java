package com.bytedance.retrofit2;

import java.net.URL;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient SsResponse<?> response;

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public SsResponse<?> response() {
        return this.response;
    }

    public HttpException(SsResponse<?> r100) {
        super(getMessage(r100));
        this.code = r100.code();
        this.message = r100.message();
        this.response = r100;
    }

    private static String getMessage(SsResponse<?> r100) {
        Utils.checkNotNull(r100, "response == null");
        if (r100.getRetrofitMetrics() != null) goto L5;
    L7:
        String r101 = "";
    L9:
        if ("".equals(r101) == false) goto L17;
        if (r100.raw() == null) goto L17;
        r101 = new URL(r100.raw().getUrl()).getPath();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        return "Path is " + r101 + " HTTP " + r100.code() + " " + r100.message();
    L5:
        if (r100.getRetrofitMetrics().url == null) goto L7;
        r101 = r100.getRetrofitMetrics().url.getPath();
        goto L9
    }
}
