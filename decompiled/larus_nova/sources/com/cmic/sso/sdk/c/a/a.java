package com.cmic.sso.sdk.c.a;

import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.c.b.h;
import com.larus.utils.logger.FLogger;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.cmic.sso.sdk.c.c f273354a;

    public a() {
    }

    private String a() {
        return com.cmic.sso.sdk.b.f273343a[0] + "." + com.cmic.sso.sdk.b.f273343a[2] + "." + com.cmic.sso.sdk.b.f273343a[4] + "." + com.cmic.sso.sdk.b.f273343a[6];
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_cmic_sso_sdk_c_a_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    public synchronized SSLSocketFactory a(g r100, com.cmic.sso.sdk.a r101) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if ((r100 instanceof e) == false) goto L11;
        com.cmic.sso.sdk.c.c r102 = new com.cmic.sso.sdk.c.c(HttpsURLConnection.getDefaultSSLSocketFactory(), r101);     // Catch: Throwable -> L16
        if (f273354a != null) goto L8;
        f273354a = r102;     // Catch: Throwable -> L16
    L8:
        monitor-exit(this);
        return r102;
    L11:
        if (f273354a != null) goto L13;
        f273354a = new com.cmic.sso.sdk.c.c(HttpsURLConnection.getDefaultSSLSocketFactory(), r101);     // Catch: Throwable -> L16
    L13:
        com.cmic.sso.sdk.c.c r103 = f273354a;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r103;
    }

    @Override // com.cmic.sso.sdk.c.a.b
    public void a(com.cmic.sso.sdk.c.c.c r210, com.cmic.sso.sdk.c.d.c r211, com.cmic.sso.sdk.a r212) {
        String r100 = "";
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "请求地址: " + r210.a());
        StringBuilder r110 = new StringBuilder();
        String r101 = r210.a();     // Catch: Throwable -> L81 Exception -> L84
        URL r111 = new URL(r101);     // Catch: Throwable -> L81 Exception -> L84
        final String r112 = r111.getHost();     // Catch: Throwable -> L81 Exception -> L84
        g r113 = r210.j();     // Catch: Throwable -> L81 Exception -> L84
        if ((r113 instanceof h) == false) goto L6;
    L7:
        String r114 = r212.b("remote_ip");     // Catch: Throwable -> L81 Exception -> L84
        if (TextUtils.isEmpty(r114) == true) goto L10;
        r111 = new URL(r101.replaceFirst(r112, r114));     // Catch: Throwable -> L81 Exception -> L84
        boolean r102 = true;
    L12:
        if (r210.g() == null) goto L14;
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "开始wifi下取号");     // Catch: Throwable -> L81 Exception -> L84
        HttpsURLConnection r115 = (HttpsURLConnection) r210.g().openConnection(r111);     // Catch: Throwable -> L81 Exception -> L84
    L138:
        Map<String, String> r116 = r210.c();     // Catch: Throwable -> L75 Exception -> L78
        if (r116 == null) goto L23;
        Iterator<String> r117 = r116.keySet().iterator();     // Catch: Throwable -> L75 Exception -> L78
    L19:
        if (r117.hasNext() == false) goto L23;
        String r118 = r117.next();     // Catch: Throwable -> L75 Exception -> L78
        String r119 = r100;
        r115.addRequestProperty(r118, r116.get(r118));     // Catch: Throwable -> L71 Exception -> L73
        r100 = r119;
    L73:
        e = e;
    L80:
        OutputStream r120 = null;
    L86:
        InputStream r121 = null;
    L87:
        e.printStackTrace();     // Catch: Throwable -> L114
        com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + r210.a());     // Catch: Throwable -> L114
        r212.a().f273461a.add(e);     // Catch: Throwable -> L114
        if ((e instanceof EOFException) == false) goto L90;
        int r122 = 200050;
    L92:
        if ((e instanceof UnknownHostException) == true) goto L94;
    L98:
        a(r120);
        a(r121);
        if (r115 == null) goto L101;
        r115.disconnect();
    L101:
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + r122);
        StringBuilder r103 = new StringBuilder("responseResult: ");
        if (TextUtils.isEmpty(r110) == false) goto L104;
        String r104 = r119;
    L105:
        r103.append(r104);
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", r103.toString());
        if (r122 != 200) goto L108;
    L112:
        r211.a(null);
        return;
    L108:
        if (r122 == 301) goto L112;
        if (r122 == 302) goto L112;
    L111:
        r211.a(com.cmic.sso.sdk.c.d.a.a(r122));
        return;
    L104:
        r104 = r110.toString();
        goto L105
    L94:
        if ((r210.j() instanceof h) == false) goto L96;
    L97:
        r212.a("remote_ip", a());     // Catch: Throwable -> L114
        r210.a("dnsParseResult", "0");     // Catch: Throwable -> L114
        goto L98
    L96:
        if ((r210.j() instanceof e) == false) goto L98;
    L90:
        r122 = 102102;
    L71:
        th = th;
    L77:
        r120 = null;
    L83:
        Closeable r123 = null;
        r122 = -1;
    L115:
        a(r120);
        a(r123);
        if (r115 == null) goto L118;
        r115.disconnect();
    L118:
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + r122);
        StringBuilder r105 = new StringBuilder("responseResult: ");
        if (TextUtils.isEmpty(r110) == false) goto L121;
        String r106 = r119;
    L122:
        r105.append(r106);
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", r105.toString());
        if (r122 != 200) goto L125;
    L129:
        r211.a(null);
    L130:
        throw th;
    L125:
        if (r122 == 301) goto L129;
        if (r122 == 302) goto L129;
        r211.a(com.cmic.sso.sdk.c.d.a.a(r122));
        goto L130
    L121:
        r106 = r110.toString();
        goto L122
    L23:
        r119 = r100;
        if (r115 != null) goto L26;
    L32:
        r115.setDoInput(true);     // Catch: Throwable -> L71 Exception -> L73
        r115.setInstanceFollowRedirects(false);     // Catch: Throwable -> L71 Exception -> L73
        r115.setConnectTimeout(5000);     // Catch: Throwable -> L71 Exception -> L73
        r115.setReadTimeout(5000);     // Catch: Throwable -> L71 Exception -> L73
        r115.setDefaultUseCaches(false);     // Catch: Throwable -> L71 Exception -> L73
        String r107 = r210.e();     // Catch: Throwable -> L71 Exception -> L73
        r115.setRequestMethod(r107);     // Catch: Throwable -> L71 Exception -> L73
        r115.setDoOutput(true);     // Catch: Throwable -> L71 Exception -> L73
        if ((r210 instanceof com.cmic.sso.sdk.c.c.b) == false) goto L37;
        r115.connect();     // Catch: Throwable -> L71 Exception -> L73
        ((com.cmic.sso.sdk.c.c.b) r210).a(r212);     // Catch: Throwable -> L71 Exception -> L73
    L37:
        if (r107.endsWith("POST") == false) goto L40;
        r120 = r115.getOutputStream();     // Catch: Throwable -> L71 Exception -> L73
        r120.write(r210.d().getBytes(XML.CHARSET_UTF8));     // Catch: Throwable -> L67 Exception -> L69
        r120.flush();     // Catch: Throwable -> L67 Exception -> L69
    L41:
        r122 = r115.getResponseCode();     // Catch: Throwable -> L67 Exception -> L69
    L140:
        r121 = r115.getInputStream();     // Catch: Throwable -> L63 Exception -> L65
    L132:
        byte[] r108 = new byte[2048];     // Catch: Exception -> L61 Throwable -> L114
    L45:
        int r124 = r121.read(r108);     // Catch: Exception -> L61 Throwable -> L114
        if (r124 <= 0) goto L48;
        r110.append(new String(r108, 0, r124, XML.CHARSET_UTF8));     // Catch: Exception -> L61 Throwable -> L114
        goto L45
    L48:
        com.cmic.sso.sdk.c.d.b r109 = new com.cmic.sso.sdk.c.d.b(r122, r115.getHeaderFields(), r110.toString());     // Catch: Exception -> L61 Throwable -> L114
        a(r120);
        a(r121);
        r115.disconnect();
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + r122);
        StringBuilder r125 = new StringBuilder("responseResult: ");
        if (TextUtils.isEmpty(r110) == false) goto L52;
        String r126 = r119;
    L53:
        r125.append(r126);
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", r125.toString());
        if (r122 != 200) goto L56;
    L60:
        r211.a(r109);
        return;
    L56:
        if (r122 == 301) goto L60;
        if (r122 == 302) goto L60;
    L52:
        r126 = r110.toString();
    L61:
        e = e;
    L65:
        e = e;
        r121 = null;
    L63:
        th = th;
        r123 = null;
    L69:
        e = e;
    L67:
        th = th;
        goto L83
    L40:
        r120 = null;
        goto L41
    L26:
        if ((r113 instanceof h) == false) goto L28;
    L29:
        if (r102 == false) goto L31;
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "host = " + r112);     // Catch: Throwable -> L71 Exception -> L73
        r115.setRequestProperty("Host", r112);     // Catch: Throwable -> L71 Exception -> L73
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "need sni handle");     // Catch: Throwable -> L71 Exception -> L73
        r115.setSSLSocketFactory(new com.cmic.sso.sdk.c.d(r115, r210.g(), r212));     // Catch: Throwable -> L71 Exception -> L73
        r115.setHostnameVerifier(new AnonymousClass1(this, r112));     // Catch: Throwable -> L71 Exception -> L73
        goto L32
    L31:
        r115.setSSLSocketFactory(a(r113, r212));     // Catch: Throwable -> L71 Exception -> L73
        goto L32
    L28:
        if ((r113 instanceof e) == false) goto L32;
    L78:
        e = e;
        r119 = r100;
    L75:
        th = th;
        r119 = r100;
        goto L77
    L14:
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "使用当前网络环境发送请求");     // Catch: Throwable -> L81 Exception -> L84
        r115 = (HttpsURLConnection) INVOKEVIRTUAL_com_cmic_sso_sdk_c_a_a_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r111);     // Catch: Throwable -> L81 Exception -> L84
    L10:
        r102 = false;
        goto L12
    L6:
        if ((r113 instanceof e) == false) goto L10;
    L114:
        th = th;
    L84:
        e = e;
        r119 = "";
        r120 = null;
        r115 = null;
    L81:
        th = th;
        r119 = "";
        r120 = null;
        r115 = null;
        goto L83
    }
}
