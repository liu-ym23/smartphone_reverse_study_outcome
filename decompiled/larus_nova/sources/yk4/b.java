package yk4;

import android.net.Network;
import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pk4.j;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OkHttpClient f568126a = null;

    static {
        OkHttpClient.Builder r100 = new OkHttpClient.Builder();
        TimeUnit r101 = TimeUnit.SECONDS;
        f568126a = r100.connectTimeout(60, r101).readTimeout(60, r101).writeTimeout(60, r101).proxy(Proxy.NO_PROXY).addInterceptor(new rk4.a()).build();
    }

    public static Response a(Request r100) throws IOException {
        Network r101 = vk4.a.f555471a;
        if (r101 == null) goto L5;
        j.d("DoraLanRequest", "getClient: cacheNetwork is ok");
        OkHttpClient r102 = f568126a.newBuilder().socketFactory(r101.getSocketFactory()).dns(new a(r101)).build();
    L7:
        return r102.newCall(r100).execute();
    L5:
        j.d("DoraLanRequest", "getClient: cacheNetwork is null, use default client");
        r102 = f568126a;
        goto L7
    }
}
