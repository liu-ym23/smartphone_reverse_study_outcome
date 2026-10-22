package com.facebook.net;

import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3CookieInterceptor;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes23.dex */
public class FrescoOkHttpClient {
    public static final String PNAME_REMOTE_ADDRESS = "x-snssdk.remoteaddr";
    public static final String TAG = "FrescoOkHttpClient";
    private static OkHttpClient sOkClient;

    public FrescoOkHttpClient() {
    }

    public static OkHttpClient getIns() {
        monitor-enter(FrescoOkHttpClient.class);
        OkHttpClient r100 = sOkClient;     // Catch: Throwable -> L11
        if (r100 == null) goto L8;
        monitor-exit(FrescoOkHttpClient.class);     // Catch: Throwable -> L11
        return r100;
    L8:
        OkHttpClient.Builder r101 = new OkHttpClient.Builder();     // Catch: Throwable -> L11
        r101.addInterceptor(new OkHttp3CookieInterceptor());     // Catch: Throwable -> L11
        r101.networkInterceptors().add(new AnonymousClass1());     // Catch: Throwable -> L11
        OkHttpClient r102 = r101.build();     // Catch: Throwable -> L11
        sOkClient = r102;     // Catch: Throwable -> L11
        monitor-exit(FrescoOkHttpClient.class);     // Catch: Throwable -> L11
        return r102;
    L11:
        th = move-exception;
        throw th;
    }
}
