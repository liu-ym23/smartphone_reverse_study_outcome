package com.huawei.hms.framework.network.grs.h.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class a {
    public static HttpsURLConnection a(String r100, Context r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        URLConnection r103 = INVOKEVIRTUAL_com_huawei_hms_framework_network_grs_h_f_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r100));
        if ((r103 instanceof HttpsURLConnection) == false) goto L13;
        HttpsURLConnection r104 = (HttpsURLConnection) r103;
        r104.setSSLSocketFactory(com.huawei.hms.framework.network.grs.h.g.a.a(r101));     // Catch: IllegalArgumentException -> L10
        r104.setHostnameVerifier(com.huawei.hms.framework.network.grs.h.g.a.a());     // Catch: IllegalArgumentException -> L10
    L11:
        r104.setConnectTimeout(10000);
        r104.setReadTimeout(10000);
        r104.setDoOutput(true);
        r104.setUseCaches(false);
        String r105 = com.huawei.hms.framework.network.grs.h.a.b(r101, "NetworkKit-grs", r102);
        Logger.d("URLConnectionHelper", "request to grs server with a User-Agent header is: " + r105);
        r104.setRequestProperty("User-Agent", r105);
        return r104;
    L10:
        Logger.w("URLConnectionHelper", "init https ssl socket failed.");
        goto L11
    L13:
        Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
        return null;
    }

    public static void a(HttpsURLConnection r100, String r101) {
        if (r101 != null) goto L7;
        String r102 = "sendHttpBody: The Body Data is Null";
    L5:
        Logger.i("URLConnectionHelper", r102);
        return;
    L7:
        if (r100 != null) goto L21;
        r102 = "sendHttpBody: HttpsURLConnection is Null";
        goto L5
    L21:
        OutputStream r103 = r100.getOutputStream();     // Catch: Throwable -> L15
        r103.write(r101.getBytes("UTF-8"));     // Catch: Throwable -> L13
        r103.flush();     // Catch: Throwable -> L13
        IoUtils.closeSecure(r103);
        return;
    L13:
        th = th;
    L17:
        IoUtils.closeSecure(r103);
        throw th;
    L15:
        th = th;
        r103 = null;
        goto L17
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_huawei_hms_framework_network_grs_h_f_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(com.obric.assistant.network.okhttp.a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }
}
