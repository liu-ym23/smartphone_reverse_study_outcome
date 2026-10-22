package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes19.dex */
public class OkHttp3PureControlInterceptor implements Interceptor {
    public static final String KEY_METASEC_PREFIX = "x-metasec";
    public static final String TAG = "OkHttp3PureControlInterceptor";
    private static volatile ICheckPureRequestForUT sHook;

    public interface ICheckPureRequestForUT {
        void checkRequest(String r100, String r101, Map<String, List<String>> r102, String r103);
    }

    public OkHttp3PureControlInterceptor() {
    }

    public static void setCheckRequestHook(ICheckPureRequestForUT r100) {
        sHook = r100;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r100) throws IOException {
        Request r101 = r100.request();
        if (r101 != null) goto L5;
    L9:
        boolean r102 = false;
    L10:
        ArrayList r103 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r104 = r101.headers().toMultimap().entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L20;
        String r105 = r104.next().getKey();
        if (r105.equals(com.bytedance.retrofit2.client.Request.KEY_BYPASS_DISPATCH) == false) goto L17;
        if (r102 == false) goto L17;
    L18:
        r103.add(r105);
    L17:
        if (r105.startsWith(KEY_METASEC_PREFIX) == false) goto L12;
    L20:
        if (r103.size() <= 0) goto L27;
        Request.Builder r106 = r101.newBuilder();
        Iterator r107 = r103.iterator();
    L23:
        if (r107.hasNext() == false) goto L25;
        r106.removeHeader((String) r107.next());
        goto L23
    L25:
        r101 = r106.build();
    L27:
        if (sHook == null) goto L30;
        sHook.checkRequest(r101.method(), r101.url().toString(), r101.headers().toMultimap(), "");
    L30:
        return r100.proceed(r101);
    L5:
        if (r101.headers() == null) goto L9;
        if (r101.headers().get(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_FEATURES) == null) goto L9;
        r102 = "1".equals(r101.headers().get(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_FEATURES));
        goto L10
    }
}
