package com.ss.android.lark.passport.signinsdk_api.base.http;

import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.http.model.http.HttpMethod;
import com.ss.android.lark.http.model.http.HttpRequestBody;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import dzb.c;
import fzb.a;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public interface IRequest<T> extends Serializable {
    public static final Map<String, Object> mRequestBody = null;

    HttpHeaders buildHeaders(HttpHeaders r100);

    boolean canLog();

    HttpHeaders getHeaders();

    String getHttpTag();

    HttpMethod getMethod();

    a getMonitorCodeCreator();

    String getName();

    ckb.a<T> getObjectConverter();

    String getPath();

    HttpRequestBody getRequestBody();

    ezb.a getResponseFilter();

    UniContext getUniContext();

    String getUrl();

    boolean isCancelable();

    void onProcessResponseHeaders(Map<String, String> r100);

    void request(dzb.a<T> r100);

    c request2(dzb.a<T> r100);

    void retryRequest(dzb.a<T> r100);

    void setUniContext(UniContext r100);

    static {
        mRequestBody = new HashMap();
    }
}
