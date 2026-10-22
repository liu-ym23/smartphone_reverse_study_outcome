package com.cmic.ida.sdk;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.larus.utils.logger.FLogger;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class h {
    public h() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_cmic_ida_sdk_h_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    private void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void a(m r100, g r101) {
        if (r100.h().contains("uniConfig") == true) goto L6;
        y0.b(r101, String.valueOf(SystemClock.elapsedRealtime() - r100.g()));
        return;
    }

    public void a(m r210, p r211, g r212) {
        p r100 = r211;
        String r101 = "";
        u.a("ConnectionInterceptor", "请求地址: " + r210.h());
        r210.a(SystemClock.elapsedRealtime());
        StringBuilder r102 = new StringBuilder();
        URL r110 = new URL(r210.h());     // Catch: Throwable -> L63 Exception -> L66
        r110.getHost();     // Catch: Throwable -> L63 Exception -> L66
        r210.f();     // Catch: Throwable -> L63 Exception -> L66
        if (r210.e() == null) goto L6;
        u.a("ConnectionInterceptor", "开始wifi下取号" + r110);     // Catch: Throwable -> L63 Exception -> L66
        HttpsURLConnection r103 = (HttpsURLConnection) r210.e().openConnection(r110);     // Catch: Throwable -> L63 Exception -> L66
    L7:
        HttpsURLConnection r104 = r103;
        Map<String, String> r105 = r210.c();     // Catch: Throwable -> L59 Exception -> L61
        if (r105 == null) goto L14;
        Iterator<String> r111 = r105.keySet().iterator();     // Catch: Throwable -> L59 Exception -> L61
    L12:
        if (r111.hasNext() == false) goto L14;
        String r112 = r111.next();     // Catch: Throwable -> L59 Exception -> L61
        r104.addRequestProperty(r112, r105.get(r112));     // Catch: Throwable -> L59 Exception -> L61
    L14:
        r104.setDoInput(true);     // Catch: Throwable -> L59 Exception -> L61
        r104.setInstanceFollowRedirects(false);     // Catch: Throwable -> L59 Exception -> L61
        r104.setConnectTimeout(5000);     // Catch: Throwable -> L59 Exception -> L61
        r104.setReadTimeout(5000);     // Catch: Throwable -> L59 Exception -> L61
        r104.setDefaultUseCaches(false);     // Catch: Throwable -> L59 Exception -> L61
        String r113 = r210.d();     // Catch: Throwable -> L59 Exception -> L61
        r104.setRequestMethod(r113);     // Catch: Throwable -> L59 Exception -> L61
        r104.setDoOutput(true);     // Catch: Throwable -> L59 Exception -> L61
        if (r113.endsWith("POST") == false) goto L19;
        OutputStream r114 = r104.getOutputStream();     // Catch: Throwable -> L59 Exception -> L61
    L119:
        r114.write(r210.b().getBytes(XML.CHARSET_UTF8));     // Catch: Throwable -> L54 Exception -> L57
        r114.flush();     // Catch: Throwable -> L54 Exception -> L57
    L20:
        int r115 = r104.getResponseCode();     // Catch: Throwable -> L54 Exception -> L57
        InputStream r116 = r104.getInputStream();     // Catch: Throwable -> L50 Exception -> L52
    L114:
        byte[] r106 = new byte[2048];     // Catch: Throwable -> L45 Exception -> L47
    L24:
        int r117 = r116.read(r106);     // Catch: Throwable -> L45 Exception -> L47
        if (r117 <= 0) goto L28;
        r101 = r101;
        r102.append(new String(r106, 0, r117, XML.CHARSET_UTF8));     // Catch: Throwable -> L41 Exception -> L43
        r100 = r211;
        r101 = r101;
    L43:
        e = e;
        r100 = r211;
    L49:
        int r118 = r115;
    L108:
        e.printStackTrace();     // Catch: Throwable -> L90
        u.b("ConnectionInterceptor", "请求失败: " + r210.h());     // Catch: Throwable -> L90
        r212.a().A.add(e);     // Catch: Throwable -> L90
        if ((e instanceof EOFException) == false) goto L73;
        r115 = 200050;
    L74:
        a(r114);
        a(r116);
        if (r104 == null) goto L77;
        r104.disconnect();
    L77:
        u.a("ConnectionInterceptor", "responseCode: " + r115);
        StringBuilder r107 = new StringBuilder("responseResult: ");
        if (TextUtils.isEmpty(r102) == false) goto L80;
        String r108 = r101;
    L81:
        r107.append(r108);
        u.a("ConnectionInterceptor", r107.toString());
        if (r115 != 200) goto L84;
    L88:
        a(r210, r212);
        r100.a(null);
        return;
    L84:
        if (r115 == 301) goto L88;
        if (r115 == 302) goto L88;
    L87:
        a(r210, r212);
        r100.a(l.a(r115));
        return;
    L80:
        r108 = r102.toString();
        goto L81
    L73:
        r115 = 102102;
    L90:
        th = th;
        r115 = r118;
    L92:
        a(r114);
        a(r116);
        if (r104 == null) goto L95;
        r104.disconnect();
    L95:
        u.a("ConnectionInterceptor", "responseCode: " + r115);
        StringBuilder r109 = new StringBuilder("responseResult: ");
        if (TextUtils.isEmpty(r102) == false) goto L98;
        String r119 = r101;
    L99:
        r109.append(r119);
        u.a("ConnectionInterceptor", r109.toString());
        if (r115 != 200) goto L102;
    L106:
        a(r210, r212);
        r100.a(null);
    L107:
        throw th;
    L102:
        if (r115 == 301) goto L106;
        if (r115 == 302) goto L106;
        a(r210, r212);
        r100.a(l.a(r115));
        goto L107
    L98:
        r119 = r102.toString();
    L41:
        th = th;
        r100 = r211;
        goto L92
    L28:
        r101 = r101;
        n r120 = new n(r115, r104.getHeaderFields(), r102.toString());     // Catch: Throwable -> L41 Exception -> L43
        a(r114);
        a(r116);
        r104.disconnect();
        u.a("ConnectionInterceptor", "responseCode: " + r115);
        StringBuilder r121 = new StringBuilder("responseResult: ");
        if (TextUtils.isEmpty(r102) == false) goto L32;
        String r122 = r101;
    L33:
        r121.append(r122);
        u.a("ConnectionInterceptor", r121.toString());
        if (r115 != 200) goto L36;
    L40:
        a(r210, r212);
        r211.a(r120);
        return;
    L36:
        if (r115 == 301) goto L40;
        if (r115 == 302) goto L40;
        r100 = r211;
        goto L87
    L32:
        r122 = r102.toString();
        goto L33
    L47:
        e = e;
        r101 = r101;
    L45:
        th = th;
        r101 = r101;
    L52:
        e = e;
        r101 = "";
        r118 = r115;
        r116 = null;
    L50:
        th = th;
    L56:
        r116 = null;
        goto L92
    L57:
        e = e;
        r101 = "";
        r116 = null;
    L69:
        r118 = -1;
    L54:
        th = th;
        r115 = -1;
        goto L56
    L19:
        r114 = null;
    L61:
        e = e;
    L68:
        r116 = null;
        r114 = null;
    L59:
        th = th;
    L65:
        r115 = -1;
        r116 = null;
        r114 = null;
        goto L92
    L6:
        u.a("ConnectionInterceptor", "使用当前网络环境发送请求" + r110);     // Catch: Throwable -> L63 Exception -> L66
        r103 = (HttpsURLConnection) INVOKEVIRTUAL_com_cmic_ida_sdk_h_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r110);     // Catch: Throwable -> L63 Exception -> L66
    L66:
        e = e;
        r104 = null;
    L63:
        th = th;
        r104 = null;
        goto L65
    }
}
