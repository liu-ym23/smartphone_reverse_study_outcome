package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.util.c;
import com.bytedance.frameworks.baselib.network.http.util.l;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes19.dex */
public class OkHttp3CookieInterceptor implements Interceptor {
    public OkHttp3CookieInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r110) throws IOException {
        Request r100 = r110.request();
        if (r100 != null) goto L5;
    L110:
        URI r101 = r100.url().uri();     // Catch: Exception -> L12
    L13:
        Request.Builder r102 = r100.newBuilder();
        CookieHandler r103 = CookieHandler.getDefault();
        Headers r104 = r100.headers();
        Map<String, List<String>> r105 = null;
        if (r101 == null) goto L31;
        String r106 = r101.toString();
        if (c.f244774c == false) goto L31;
        if (c.f244775d == false) goto L31;
        if (r106 == null) goto L31;
        if (r106.contains(c.f244772a) == false) goto L31;
        String r107 = UriProtector.parse(r106).getScheme();
        if ("http".equals(r107) == false) goto L28;
        r106 = r106.replaceFirst("http", "https");
    L30:
        String r108 = r106.replaceFirst(c.f244772a, "");
    L105:
        HashMap r109 = new HashMap();     // Catch: Throwable -> L79
        if (r104 == null) goto L43;
        Set<String> r111 = r104.names();     // Catch: Throwable -> L79
        if (r111 == null) goto L43;
        if (r111.isEmpty() == true) goto L43;
        Iterator<String> r112 = r111.iterator();     // Catch: Throwable -> L79
    L40:
        if (r112.hasNext() == false) goto L43;
        String r113 = r112.next();     // Catch: Throwable -> L79
        r109.put(r113, r104.values(r113));     // Catch: Throwable -> L79
    L43:
        if (r100.headers() == null) goto L47;
        boolean r114 = "1".equals(r100.header(com.bytedance.retrofit2.client.Request.KEY_BYPASS_OKHTTP_COOKIE));     // Catch: Throwable -> L79
        if ("1".equals(r100.header("x-metasec-ok-bypass-downgrade-cookie")) == false) goto L48;
        r114 = true;
    L48:
        if (r103 == null) goto L56;
        if (r114 == true) goto L56;
        if (r108 == null) goto L52;
        Map<String, List<String>> r115 = r103.get(new URI(r108), r109);     // Catch: IOException -> L54 Throwable -> L79
    L53:
        r105 = r115;
    L52:
        r115 = r103.get(r101, r109);     // Catch: IOException -> L54 Throwable -> L79
    L54:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L79
    L56:
        if (r105 != null) goto L58;
    L103:
        r100 = r102.build();     // Catch: Throwable -> L83
    L85:
        Response r116 = r110.proceed(r100);
        HashMap r117 = new HashMap();
        Headers r118 = r116.headers();
        if (r118 == null) goto L95;
        Set<String> r119 = r118.names();
        if (r119 == null) goto L95;
        if (r119.isEmpty() == true) goto L95;
        Iterator<String> r120 = r119.iterator();
    L93:
        if (r120.hasNext() == false) goto L95;
        String r121 = r120.next();
        r117.put(r121, r118.values(r121));
    L95:
        if (r103 != null) goto L108;
    L102:
        return r116;
    L108:
        if (r108 == null) goto L98;
        r103.put(new URI(r108), r117);     // Catch: Throwable -> L100
    L107:
        goto L102
    L98:
        r103.put(r101, r117);     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        th.printStackTrace();
    L83:
        th = move-exception;
        th.printStackTrace();
        goto L85
    L58:
        if (r105.size() <= 0) goto L103;
        Iterator<Map.Entry<String, List<String>>> r122 = r105.entrySet().iterator();     // Catch: Throwable -> L79
    L60:
        if (r122.hasNext() == false) goto L103;
        Map.Entry<String, List<String>> r123 = r122.next();     // Catch: Throwable -> L79
        String r124 = r123.getKey();     // Catch: Throwable -> L79
        StringBuilder r125 = new StringBuilder();     // Catch: Throwable -> L79
        if (CronetHttpURLConnection.SS_COOKIE.equalsIgnoreCase(r124) == true) goto L69;
        if ("Cookie".equalsIgnoreCase(r124) == true) goto L69;
        if ("Cookie2".equalsIgnoreCase(r124) == false) goto L60;
    L69:
        if (r123.getValue().isEmpty() == true) goto L60;
        Iterator<String> r126 = r123.getValue().iterator();     // Catch: Throwable -> L79
        int r127 = 0;
    L72:
        if (r126.hasNext() == false) goto L77;
        String r128 = r126.next();     // Catch: Throwable -> L79
        if (r127 <= 0) goto L76;
        r125.append("; ");     // Catch: Throwable -> L79
    L76:
        r125.append(r128);     // Catch: Throwable -> L79
        r127 = r127 + 1;     // Catch: Throwable -> L79
        goto L72
    L77:
        r102.addHeader(r124, r125.toString());     // Catch: Throwable -> L79
        goto L60
    L47:
        r114 = false;
    L79:
        th = move-exception;
        th.printStackTrace();
        goto L103
    L28:
        if ("ws".equals(r107) == false) goto L30;
        r106 = r106.replaceFirst("ws", "wss");
    L31:
        r108 = null;
    L12:
        r101 = l.a(r100.url().toString());
        goto L13
    L5:
        if (r100.headers() == null) goto L110;
        if ("0".equals(r100.header(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_COOKIE_HEADER)) == false) goto L110;
        Request.Builder r129 = r100.newBuilder();
        r129.removeHeader(com.bytedance.retrofit2.client.Request.KEY_BYPASS_TTNET_COOKIE_HEADER);
        return r110.proceed(r129.build());
    }
}
