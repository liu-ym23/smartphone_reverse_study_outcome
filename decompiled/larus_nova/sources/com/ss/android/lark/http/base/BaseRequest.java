package com.ss.android.lark.http.base;

import ckb.a;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpParams;
import com.ss.android.lark.http.model.http.HttpRequestBody;
import java.io.Serializable;

/* JADX INFO: loaded from: classes36.dex */
public abstract class BaseRequest<T> implements Serializable {
    public BaseRequest() {
    }

    public HttpHeaders buildHeaders(HttpHeaders r100) {
        return r100;
    }

    public HttpParams buildParams(HttpParams r100) {
        return r100;
    }

    public abstract HttpHeaders getHeaders();

    public abstract HttpParams getHttpParams();

    public abstract a<T> getObjectConverter();

    public abstract String getPath();

    public abstract HttpRequestBody getRequestBody();

    public abstract String getUrl();

    public abstract void request(dkb.a<T> r100);

    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }
}
