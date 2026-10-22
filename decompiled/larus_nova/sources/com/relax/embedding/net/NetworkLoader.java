package com.relax.embedding.net;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import com.relax.embedding.ReflectionRegistry;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class NetworkLoader {
    private static final String TAG = "NetworkLoader";

    public NetworkLoader() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_relax_embedding_net_NetworkLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
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

    public static void request(long r100, String r101, String r102, String r103, Map<String, String> r104, NetworkCallback r105) {
        if (ReflectionRegistry.hasHostFunction(TAG) == false) goto L5;
        requestByHost(r100, r101, r102, r103, r104, r105);
        return;
    L5:
        requestDefault(r100, r101, r102, r103, r104, r105);
    }

    private static boolean requestByHost(long r100, String r101, String r102, String r103, Map<String, String> r104, NetworkCallback r110) {
        ReflectionRegistry.invokeMethod(TAG, "request", new Object[]{Long.valueOf(r100), r101, r102, r103, r104, r110});     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static void requestDefault(long r100, String r101, String r102, String r103, Map<String, String> r104, NetworkCallback r105) {
        StringBuilder r106 = new StringBuilder();
        HttpURLConnection r107 = (HttpURLConnection) INVOKEVIRTUAL_com_relax_embedding_net_NetworkLoader_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r101));     // Catch: IOException -> L46
        r107.setRequestMethod(r102.toUpperCase());     // Catch: IOException -> L46
        if (r104 == null) goto L11;
        Iterator<Map.Entry<String, String>> r108 = r104.entrySet().iterator();     // Catch: IOException -> L46
    L7:
        if (r108.hasNext() == false) goto L11;
        Map.Entry<String, String> r109 = r108.next();     // Catch: IOException -> L46
        r107.setRequestProperty(r109.getKey(), r109.getValue());     // Catch: IOException -> L46
    L11:
        if (r103 != null) goto L13;
    L31:
        BufferedReader r110 = new BufferedReader(new InputStreamReader(r107.getInputStream(), XML.CHARSET_UTF8));     // Catch: IOException -> L46
    L56:
        String r111 = r110.readLine();     // Catch: Throwable -> L38
        if (r111 == null) goto L36;
        r106.append(r111.trim());     // Catch: Throwable -> L38
    L36:
        r110.close();     // Catch: IOException -> L46
        r105.onSucceeded(r106.toString().getBytes());     // Catch: IOException -> L46
        r107.disconnect();     // Catch: IOException -> L46
        return;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r110.close();     // Catch: Throwable -> L43
    L45:
        throw th;     // Catch: IOException -> L46
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L46
        goto L45
    L13:
        if (r103.isEmpty() == true) goto L31;
        if (r102.equalsIgnoreCase("POST") == false) goto L17;
    L18:
        r107.setDoOutput(true);     // Catch: IOException -> L46
        OutputStream r112 = r107.getOutputStream();     // Catch: IOException -> L46
        byte[] r113 = r103.getBytes(XML.CHARSET_UTF8);     // Catch: Throwable -> L22
        r112.write(r113, 0, r113.length);     // Catch: Throwable -> L22
        r112.close();     // Catch: IOException -> L46
        goto L31
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        if (r112 != null) goto L54;
    L30:
        throw th;     // Catch: IOException -> L46
    L54:
        r112.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L46
        goto L30
    L17:
        if (r102.equalsIgnoreCase("PUT") == false) goto L31;
    L46:
        e = move-exception;
        e.printStackTrace();
        r105.onFailed(e.getMessage());
    }

    private static void request(long r100, String r101, String r110, String r111, Map<String, String> r112, long r113) {
        request(r100, r101, r110, r111, r112, new NetworkCallback(r113, r100));
    }
}
