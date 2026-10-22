package com.bytedance.retrofit2.rxjava2.adapter;

import com.bytedance.retrofit2.SsResponse;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes21.dex */
public final class Result<T> {

    @Nullable
    private final Throwable error;

    @Nullable
    private final SsResponse<T> response;

    public boolean isError() {
        if (this.error == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public Throwable error() {
        return this.error;
    }

    @Nullable
    public SsResponse<T> response() {
        return this.response;
    }

    public static <T> Result<T> error(Throwable r100) {
        if (r100 == null) goto L6;
        return new Result(null, r100);
    L6:
        throw new NullPointerException("error == null");
    }

    public static <T> Result<T> response(SsResponse<T> r100) {
        if (r100 == null) goto L6;
        return new Result(r100, null);
    L6:
        throw new NullPointerException("response == null");
    }

    private Result(@Nullable SsResponse<T> r100, @Nullable Throwable r101) {
        this.response = r100;
        this.error = r101;
    }
}
