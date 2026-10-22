package com.bytedance.frameworks.baselib.network.http.cronet;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaInterceptorCallbackRegistry {
    private static final String TAG = "JavaInterceptorCallback";
    private static volatile IJavaInterceptorCallback sCallback;

    private JavaInterceptorCallbackRegistry() {
    }

    public static IJavaInterceptorCallback get() {
        return sCallback;
    }

    public static void register(IJavaInterceptorCallback r100) {
        sCallback = r100;
    }

    public static String onRequestInterceptorJava(String r100, Map<String, String> r101) {
        IJavaInterceptorCallback r102 = sCallback;
        if (r102 != null) goto L7;
        return "";
    L7:
        return r102.onRequestInterceptorJava(r100, r101);
    }
}
