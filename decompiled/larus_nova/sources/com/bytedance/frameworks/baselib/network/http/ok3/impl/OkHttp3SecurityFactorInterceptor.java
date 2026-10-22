package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes19.dex */
public class OkHttp3SecurityFactorInterceptor implements Interceptor {
    private static final String KEY_BYPASS_MSSDK = "x-metasec-bypass-mssdk";
    private static final String KEY_OEC_OPAQUE_ENABLE = "x-tt-oec-opaque-enable";

    public OkHttp3SecurityFactorInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r100) throws IOException {
        Request r101 = r100.request();
        if ("1".equals(r101.headers().get(KEY_BYPASS_MSSDK)) == false) goto L6;
        Request.Builder r102 = r101.newBuilder();
        r102.removeHeader(KEY_BYPASS_MSSDK);
        return r100.proceed(r102.build());
    L6:
        Map<String, String> r103 = NetworkParams.tryAddSecurityFactor(r101.url().toString(), r101.headers().toMultimap());
        if ("1".equals(r101.headers().get(KEY_OEC_OPAQUE_ENABLE)) == false) goto L9;
        Map<String, String> r104 = NetworkParams.tryAddOecSecurityFactor(r101.url().toString(), r101.headers().toMultimap());
    L10:
        if (r103 != null) goto L14;
        if (r104 != null) goto L14;
        return r100.proceed(r101);
    L14:
        Request.Builder r105 = new Request.Builder();
        r105.url(r101.url());
        r105.method(r101.method(), r101.body());
        r105.tag(r101.tag());
        Headers.Builder r106 = r101.headers().newBuilder();
        if (r103 == null) goto L20;
        Iterator<Map.Entry<String, String>> r107 = r103.entrySet().iterator();
    L18:
        if (r107.hasNext() == false) goto L20;
        Map.Entry<String, String> r108 = r107.next();
        r106.add(r108.getKey(), r108.getValue());
    L20:
        if (r104 == null) goto L25;
        Iterator<Map.Entry<String, String>> r109 = r104.entrySet().iterator();
    L23:
        if (r109.hasNext() == false) goto L25;
        Map.Entry<String, String> r110 = r109.next();
        r106.add(r110.getKey(), r110.getValue());
    L25:
        r106.removeAll(KEY_OEC_OPAQUE_ENABLE);
        r105.headers(r106.build());
        return r100.proceed(r105.build());
    L9:
        r104 = null;
        goto L10
    }
}
