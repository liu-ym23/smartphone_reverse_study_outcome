package com.bytedance.retrofit2;

import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class SsResponse<T> {
    private final T body;
    private final TypedInput errorBody;
    private final Response rawResponse;
    private RetrofitMetrics retrofitMetrics;

    public int code() {
        return this.rawResponse.getStatus();
    }

    public List<Header> headers() {
        return this.rawResponse.getHeaders();
    }

    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public String message() {
        return this.rawResponse.message();
    }

    public T body() {
        return this.body;
    }

    public TypedInput errorBody() {
        return this.errorBody;
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.retrofitMetrics;
    }

    public Response raw() {
        return this.rawResponse;
    }

    public void setRetrofitMetrics(RetrofitMetrics r100) {
        this.retrofitMetrics = r100;
    }

    public static <T> SsResponse<T> error(TypedInput r100, Response r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L11;
        if (r101.isSuccessful() == true) goto L9;
        return new SsResponse(r101, null, r100);
    L9:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    L11:
        throw new NullPointerException("rawResponse == null");
    L13:
        throw new NullPointerException("body == null");
    }

    public static <T> SsResponse<T> success(T r100, Response r101) {
        if (r101 == null) goto L10;
        if (r101.isSuccessful() == false) goto L8;
        return new SsResponse(r101, r100, null);
    L8:
        throw new IllegalArgumentException("rawResponse must be successful response");
    L10:
        throw new NullPointerException("rawResponse == null");
    }

    private SsResponse(Response r100, T r101, TypedInput r102) {
        this.rawResponse = r100;
        this.body = r101;
        this.errorBody = r102;
    }
}
