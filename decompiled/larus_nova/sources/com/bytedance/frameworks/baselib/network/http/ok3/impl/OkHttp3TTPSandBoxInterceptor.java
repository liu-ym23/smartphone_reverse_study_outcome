package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes19.dex */
public class OkHttp3TTPSandBoxInterceptor implements Interceptor {
    private static volatile ITncSandBox sSandBox;

    /* JADX INFO: loaded from: classes3.dex */
    public interface ITncSandBox {
        boolean isTncRequestProceed(String r100, String r101, Map<String, List<String>> r102, String r103);
    }

    public OkHttp3TTPSandBoxInterceptor() {
    }

    public static void setTncSandbox(ITncSandBox r100) {
        sSandBox = r100;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r100) throws IOException {
        Request r101 = r100.request();
        if (sSandBox == null) goto L12;
        if ("/get_domains/v5/".equals(r101.url().encodedPath()) == false) goto L12;
        if (sSandBox.isTncRequestProceed(r101.method(), r101.url().toString(), r101.headers().toMultimap(), "") == true) goto L12;
        throw new IOException("TNC requsest dropped by sandbox");
    L12:
        return r100.proceed(r101);
    }
}
