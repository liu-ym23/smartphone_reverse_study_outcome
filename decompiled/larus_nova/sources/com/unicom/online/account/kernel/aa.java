package com.unicom.online.account.kernel;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f461944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f461945b;

    /* JADX INFO: loaded from: classes41.dex */
    public class a implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ aa f461946a;

        public a(aa r100) {
            this.f461946a = r100;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String r100, SSLSession r101) {
            if (TextUtils.isEmpty(r100) == true) goto L13;
            if (r101 == null) goto L13;
            if (ak.a(r100, ((X509Certificate) r101.getPeerCertificates()[0]).getSubjectDN().getName()) == false) goto L10;
            return true;
        L10:
            return false;
        L11:
            e = move-exception;
            aj.a(e);
        L13:
            return false;
        }
    }

    public aa() {
    }

    private static String a(InputStream r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Throwable -> L14 Exception -> L16
    L37:
        byte[] r102 = new byte[1024];     // Catch: Exception -> L12 Throwable -> L24
    L6:
        int r103 = r100.read(r102);     // Catch: Exception -> L12 Throwable -> L24
        if (r103 == (-1)) goto L9;
        r101.write(r102, 0, r103);     // Catch: Exception -> L12 Throwable -> L24
        goto L6
    L9:
        String r104 = new String(r101.toByteArray());     // Catch: Exception -> L12 Throwable -> L24
        r101.close();     // Catch: Exception -> L30
        r100.close();     // Catch: Exception -> L30
    L11:
        return r104;
    L12:
        e = e;
    L18:
        aj.a(e);     // Catch: Throwable -> L24
        if (r101 != null) goto L33;
    L21:
        if (r100 == null) goto L23;
        r100.close();     // Catch: Exception -> L31
    L23:
        return null;
    L33:
        r101.close();     // Catch: Exception -> L31
    L24:
        Throwable th10 = th;
    L25:
        if (r101 != null) goto L35;
    L27:
        if (r100 == null) goto L29;
        r100.close();     // Catch: Exception -> L32
    L29:
        throw th10;
    L35:
        r101.close();     // Catch: Exception -> L32
    L16:
        e = e;
        r101 = null;
    L14:
        th = move-exception;
        r101 = null;
        th10 = th;
        goto L25
    }

    private static String a(String r100) {
        if (r100.contains(":") == true) goto L5;
        return r100;
    L5:
        return "[" + r100 + "]";
    }

    public static String a(String r100, String r101) {
        String r102 = "";
        OutputStream r103 = null;
        URL r104 = new URL(r100);     // Catch: Throwable -> L15 Exception -> L17
        HttpURLConnection r105 = (HttpURLConnection) INVOKEVIRTUAL_com_unicom_online_account_kernel_aa_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r104);     // Catch: Throwable -> L15 Exception -> L17
        String r106 = r104.getProtocol();     // Catch: Throwable -> L15 Exception -> L17
        if (an.b(r106).booleanValue() == false) goto L6;
        "https".equals(r106.toLowerCase(Locale.getDefault()));     // Catch: Throwable -> L15 Exception -> L17
    L6:
        r105.setConnectTimeout(50000);     // Catch: Throwable -> L15 Exception -> L17
        r105.setReadTimeout(50000);     // Catch: Throwable -> L15 Exception -> L17
        r105.setDoOutput(true);     // Catch: Throwable -> L15 Exception -> L17
        r105.setDoInput(true);     // Catch: Throwable -> L15 Exception -> L17
        r105.setUseCaches(false);     // Catch: Throwable -> L15 Exception -> L17
        r105.setRequestMethod("POST");     // Catch: Throwable -> L15 Exception -> L17
        r105.setRequestProperty("user-agent", "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1");     // Catch: Throwable -> L15 Exception -> L17
        r105.setRequestProperty("Charset", "UTF-8");     // Catch: Throwable -> L15 Exception -> L17
        r105.setRequestProperty(WsConstants.KEY_CONNECTION, "keep-alive");     // Catch: Throwable -> L15 Exception -> L17
        r105.setRequestProperty("api-protocol", "1.1");     // Catch: Throwable -> L15 Exception -> L17
        r105.connect();     // Catch: Throwable -> L15 Exception -> L17
        r103 = r105.getOutputStream();     // Catch: Throwable -> L15 Exception -> L17
        r103.write(r101.getBytes(XML.CHARSET_UTF8));     // Catch: Throwable -> L15 Exception -> L17
        r103.flush();     // Catch: Throwable -> L15 Exception -> L17
        r103.close();     // Catch: Throwable -> L15 Exception -> L17
        int r107 = r105.getResponseCode();     // Catch: Throwable -> L15 Exception -> L17
        if (r107 != 200) goto L9;
        InputStream r108 = r105.getInputStream();     // Catch: Throwable -> L15 Exception -> L17
        r102 = a(r108);     // Catch: Throwable -> L15 Exception -> L17
        r105.disconnect();     // Catch: Throwable -> L15 Exception -> L17
        r108.close();     // Catch: Throwable -> L15 Exception -> L17
    L9:
        aj.a("responseCode = " + r107 + "\nresult = " + r102);     // Catch: Throwable -> L15 Exception -> L17
        r103.close();     // Catch: IOException -> L12
    L14:
        return r102;
    L12:
        e = move-exception;
        aj.a(e);
        goto L14
    L17:
        e = move-exception;
        aj.a(e);     // Catch: Throwable -> L15
        if (r103 != null) goto L35;
    L24:
        return r102;
    L35:
        r103.close();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        aj.a(e);
    L15:
        th = move-exception;
        if (r103 != null) goto L37;
    L30:
        throw th;
    L37:
        r103.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        aj.a(e);
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String b(Context r110, String r111, HashMap<String, String> r210, Object r211) {
        String r100 = r111;
        long r101 = System.currentTimeMillis();
        String r102 = new URL(r100).getHost();     // Catch: MalformedURLException -> L5
    L8:
        if (r102.contains(i.d()) == false) goto L18;
        if (f461945b == false) goto L18;
        if (f461944a == false) goto L18;
        if (TextUtils.isEmpty(ak.f461989a) == true) goto L16;
        r100 = r100.replaceFirst(i.d(), a(ak.f461989a));
    L16:
        f461945b = false;
    L18:
        if (r100.contains("nisportal") == false) goto L20;
        e.a().f462027a = 1;
    L20:
        aj.a("\n*********************\nrequestGetHttp() requestUrl - >" + r100.substring(0, 30) + "...\n ...\n \n*********************\n");
        URL r112 = new URL(r100);     // Catch: Throwable -> L63 Exception -> L65
        if (r211 == null) goto L25;
        URLConnection r113 = ((Network) r211).openConnection(r112);     // Catch: Throwable -> L63 Exception -> L65
    L24:
        HttpURLConnection r114 = (HttpURLConnection) r113;     // Catch: Throwable -> L63 Exception -> L65
        r114.setDoInput(true);     // Catch: Exception -> L61 Throwable -> L77
        r114.setDoOutput(false);     // Catch: Exception -> L61 Throwable -> L77
        r114.setUseCaches(false);     // Catch: Exception -> L61 Throwable -> L77
        r114.setInstanceFollowRedirects(false);     // Catch: Exception -> L61 Throwable -> L77
        r114.setReadTimeout(10000);     // Catch: Exception -> L61 Throwable -> L77
        r114.setConnectTimeout(10000);     // Catch: Exception -> L61 Throwable -> L77
        r114.setRequestMethod("GET");     // Catch: Exception -> L61 Throwable -> L77
        boolean r115 = ac.c();     // Catch: Exception -> L61 Throwable -> L77
        r114.setInstanceFollowRedirects(r115);     // Catch: Exception -> L61 Throwable -> L77
        HttpURLConnection.setFollowRedirects(r115);     // Catch: Exception -> L61 Throwable -> L77
        if (r210 == null) goto L33;
        Iterator<String> r116 = r210.keySet().iterator();     // Catch: Exception -> L61 Throwable -> L77
    L31:
        if (r116.hasNext() == false) goto L33;
        String r117 = r116.next();     // Catch: Exception -> L61 Throwable -> L77
        r114.setRequestProperty(r117, r210.get(r117));     // Catch: Exception -> L61 Throwable -> L77
    L33:
        r114.addRequestProperty("Connection", "close");     // Catch: Exception -> L61 Throwable -> L77
        aj.a("TAG\thttpsURLConnection.connect();\n");     // Catch: Exception -> L61 Throwable -> L77
        g r103 = new g();     // Catch: Exception -> L61 Throwable -> L77
        r103.f462049a = r100.substring(0, r100.indexOf("?"));     // Catch: Exception -> L61 Throwable -> L77
        r103.f462050b = System.currentTimeMillis();     // Catch: Exception -> L61 Throwable -> L77
        r114.connect();     // Catch: Exception -> L61 Throwable -> L77
        r103.f462051c = System.currentTimeMillis();     // Catch: Exception -> L61 Throwable -> L77
        r103.f462052d = 1;     // Catch: Exception -> L61 Throwable -> L77
        e.a().a(r103);     // Catch: Exception -> L61 Throwable -> L77
        aj.a("connect cost:" + (System.currentTimeMillis() - r101));     // Catch: Exception -> L61 Throwable -> L77
        long r104 = System.currentTimeMillis();     // Catch: Exception -> L61 Throwable -> L77
        int r105 = r114.getResponseCode();     // Catch: Exception -> L61 Throwable -> L77
        aj.a("\n*********************\nrequestGetHttp() statusCode - >" + r105 + "\n*********************\n");     // Catch: Exception -> L61 Throwable -> L77
        StringBuilder r118 = new StringBuilder("response cost:");     // Catch: Exception -> L61 Throwable -> L77
        r118.append(System.currentTimeMillis() - r104);     // Catch: Exception -> L61 Throwable -> L77
        aj.a(r118.toString());     // Catch: Exception -> L61 Throwable -> L77
        if (r105 != 200) goto L44;
        InputStream r106 = r114.getInputStream();     // Catch: Exception -> L61 Throwable -> L77
        String r107 = a(r106);     // Catch: Exception -> L61 Throwable -> L77
        r114.getInputStream().close();     // Catch: Exception -> L61 Throwable -> L77
        r114.disconnect();     // Catch: Exception -> L61 Throwable -> L77
        r106.close();     // Catch: Exception -> L61 Throwable -> L77
        if (TextUtils.isEmpty(r107) == false) goto L41;
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L61 Throwable -> L77
        r108.put("code", 410012);     // Catch: Exception -> L61 Throwable -> L77
        r108.put("msg", "返回数据体为空");     // Catch: Exception -> L61 Throwable -> L77
        r108.put("data", "requestUrl:".concat(r100));     // Catch: Exception -> L61 Throwable -> L77
        String r109 = r108.toString();     // Catch: Exception -> L61 Throwable -> L77
        r114.disconnect();
        return r109;
    L41:
        r114.disconnect();
        return r107;
    L44:
        if (r105 != 302) goto L58;
        String r119 = r114.getHeaderField("Location");     // Catch: Exception -> L61 Throwable -> L77
        aj.a("redirectUrl is \n".concat(String.valueOf(r119)));     // Catch: Exception -> L61 Throwable -> L77
        aj.a("System.currentTimeMillis() is  \n" + System.currentTimeMillis());     // Catch: Exception -> L61 Throwable -> L77
        if (TextUtils.isEmpty(r119) == false) goto L48;
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L61 Throwable -> L77
        r120.put("code", 410013);     // Catch: Exception -> L61 Throwable -> L77
        r120.put("msg", "无跳转地址");     // Catch: Exception -> L61 Throwable -> L77
        r120.put("data", r102);     // Catch: Exception -> L61 Throwable -> L77
        String r121 = r120.toString();     // Catch: Exception -> L61 Throwable -> L77
        r114.disconnect();
        return r121;
    L48:
        if (r119.startsWith("https") == false) goto L52;
        String r122 = a(r110, r119, null, r211);     // Catch: Exception -> L61 Throwable -> L77
        r114.disconnect();
        return r122;
    L52:
        aj.a("warning http redirectUrl \n" + System.currentTimeMillis());     // Catch: Exception -> L61 Throwable -> L77
        String r123 = b(r110, r119, null, r211);     // Catch: Exception -> L61 Throwable -> L77
        r114.disconnect();
        return r123;
    L58:
        JSONObject r124 = new JSONObject();     // Catch: Exception -> L61 Throwable -> L77
        r124.put("code", 410010);     // Catch: Exception -> L61 Throwable -> L77
        r124.put("msg", "Https状态码错误".concat(String.valueOf(r105)));     // Catch: Exception -> L61 Throwable -> L77
        r124.put("data", "requestUrl:".concat(r100));     // Catch: Exception -> L61 Throwable -> L77
        String r125 = r124.toString();     // Catch: Exception -> L61 Throwable -> L77
        r114.disconnect();
        return r125;
    L61:
        e = e;
    L67:
        aj.a(e);     // Catch: Throwable -> L77
        JSONObject r126 = new JSONObject();     // Catch: Exception -> L72 Throwable -> L77
        r126.put("code", 410024);     // Catch: Exception -> L72 Throwable -> L77
        r126.put("msg", "http异常" + e.getMessage());     // Catch: Exception -> L72 Throwable -> L77
        r126.put("data", "requestUrl->".concat(r100));     // Catch: Exception -> L72 Throwable -> L77
        String r127 = r126.toString();     // Catch: Exception -> L72 Throwable -> L77
        if (r114 == null) goto L71;
        r114.disconnect();
    L71:
        return r127;
    L73:
        if (r114 == null) goto L90;
        r114.disconnect();
        return null;
    L90:
        return null;
    L25:
        r113 = INVOKEVIRTUAL_com_unicom_online_account_kernel_aa_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r112);     // Catch: Throwable -> L63 Exception -> L65
    L77:
        th = th;
        HttpsURLConnection r128 = "...\n ...\n \n*********************\n";
    L79:
        if (r128 == 0) goto L81;
        r128.disconnect();
    L81:
        throw th;
    L65:
        e = e;
        r114 = null;
    L63:
        th = th;
        r128 = 0;
    L5:
        e = move-exception;
        aj.a(e);
        r102 = r100;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11, types: [long] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r18v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.unicom.online.account.kernel.aa] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.unicom.online.account.kernel.aa] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v29, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v32, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.unicom.online.account.kernel.aa] */
    /* JADX WARN: Type inference failed for: r26v0, types: [java.util.HashMap, java.util.HashMap<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r27v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v39 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
    public final String a(Context r210, String r211, HashMap<String, String> r212, Object r213) {
        aa this = this;
        String r100 = r211;
        String r101 = "ret_url";
        System.currentTimeMillis();
        String r110 = i.g();
        String r102 = new URL(r100).getHost();     // Catch: MalformedURLException -> L5
    L7:
        String r111 = r102;
        if (r111.contains(i.d()) == false) goto L19;
        if (f461945b == false) goto L19;
        if (f461944a == false) goto L19;
        if (TextUtils.isEmpty(ak.f461989a) == true) goto L16;
        String r103 = i.d();
        String r112 = a(ak.f461989a);
        String r104 = r100.replaceFirst(r103, r112);
    L17:
        f461945b = false;
        r100 = r104;
        goto L19
    L16:
        r104 = r100;
    L19:
        if (ac.b() == true) goto L233;
    L46:
        r112 = "DNS cache use error,clean domain = ";
        r101 = "data";
    L47:
        boolean r113 = false;
    L49:
        if (r100.contains("nisportal") == false) goto L51;
        e.a().f462027a = 1;
    L51:
        StringBuilder r105 = new StringBuilder("\n*********************\nrequestGetHttps() requestUrl - >");
        ?? r114 = r112;
        r105.append(r100.substring(0, 30));
        r105.append("...\n*********************\n");
        aj.a(r105.toString());
        URL r106 = new URL(r100);     // Catch: Throwable -> L164 Exception -> L166
        if (r213 != 0) goto L239;
        HttpsURLConnection r107 = (HttpsURLConnection) INVOKEVIRTUAL_com_unicom_online_account_kernel_aa_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(r106);     // Catch: Throwable -> L164 Exception -> L166
    L60:
        HttpsURLConnection r115 = r107;
        r115.setDoInput(true);     // Catch: Exception -> L161 Throwable -> L164
        r115.setDoOutput(false);     // Catch: Exception -> L161 Throwable -> L164
        r115.setUseCaches(false);     // Catch: Exception -> L161 Throwable -> L164
        r115.setInstanceFollowRedirects(false);     // Catch: Exception -> L161 Throwable -> L164
        r115.setReadTimeout(10000);     // Catch: Exception -> L161 Throwable -> L164
        r115.setConnectTimeout(10000);     // Catch: Exception -> L161 Throwable -> L164
        r115.setRequestMethod("GET");     // Catch: Exception -> L161 Throwable -> L164
        r115.setHostnameVerifier(new a(this));     // Catch: Exception -> L161 Throwable -> L164
        boolean r108 = ac.c();     // Catch: Exception -> L161 Throwable -> L164
        r115.setInstanceFollowRedirects(r108);     // Catch: Exception -> L161 Throwable -> L164
        HttpURLConnection.setFollowRedirects(r108);     // Catch: Exception -> L161 Throwable -> L164
        if (r212 == 0) goto L67;
        Iterator r109 = r212.keySet().iterator();     // Catch: Exception -> L161 Throwable -> L164
    L65:
        if (r109.hasNext() == false) goto L67;
        String r116 = (String) r109.next();     // Catch: Exception -> L161 Throwable -> L164
        r115.setRequestProperty(r116, (String) r212.get(r116));     // Catch: Exception -> L161 Throwable -> L164
    L67:
        r115.addRequestProperty("Connection", "close");     // Catch: Exception -> L161 Throwable -> L164
        aj.a("TAG\thttpsURLConnection.connect();\n");     // Catch: Exception -> L161 Throwable -> L164
        g r117 = new g();     // Catch: Exception -> L161 Throwable -> L164
        r117.f462049a = r100.substring(0, r100.indexOf("?"));     // Catch: Exception -> L161 Throwable -> L164
        String r118 = "msg";
        r117.f462050b = System.currentTimeMillis();     // Catch: Exception -> L159 Throwable -> L164
        aj.a(3, r100.substring(0, 30));     // Catch: Exception -> L153 Throwable -> L155
        r115.connect();     // Catch: Exception -> L153 Throwable -> L155
        r117.f462051c = System.currentTimeMillis();     // Catch: Exception -> L153 Throwable -> L155
        r117.f462052d = 1;     // Catch: Exception -> L153 Throwable -> L155
        e.a().a(r117);     // Catch: Exception -> L153 Throwable -> L155
        StringBuilder r119 = new StringBuilder("connect url cost:");     // Catch: Exception -> L153 Throwable -> L155
        r119.append(r117.f462051c - r117.f462050b);     // Catch: Exception -> L149 Throwable -> L155
        aj.a(r119.toString());     // Catch: Exception -> L149 Throwable -> L155
        StringBuilder r120 = new StringBuilder("cost:");     // Catch: Exception -> L149 Throwable -> L155
        r120.append(r117.f462051c - r117.f462050b);     // Catch: Exception -> L146 Throwable -> L155
        r120.append("ms\n");     // Catch: Exception -> L146 Throwable -> L155
        aj.a(3, r120.toString());     // Catch: Exception -> L146 Throwable -> L155
        long r121 = System.currentTimeMillis();     // Catch: Exception -> L146 Throwable -> L155
        int r122 = r115.getResponseCode();     // Catch: Exception -> L146 Throwable -> L155
        aj.a("\n*********************\n requestGetHttps() statusCode - >" + r122 + "\n*********************\n");     // Catch: Exception -> L146 Throwable -> L155
        StringBuilder r123 = new StringBuilder("get response cost:");     // Catch: Exception -> L146 Throwable -> L155
        long r124 = System.currentTimeMillis() - r121;     // Catch: Exception -> L146 Throwable -> L155
        r123.append(r124);     // Catch: Exception -> L146 Throwable -> L155
        aj.a(r123.toString());     // Catch: Exception -> L146 Throwable -> L155
        String r125 = r115.getURL().toString();     // Catch: Exception -> L146 Throwable -> L155
        boolean r126 = r125.contains("ret_url");     // Catch: Exception -> L146 Throwable -> L155
        String r127 = OnekeyLoginConstants.CU_KEY_SEQ;
        if (r126 == false) goto L84;
        if (r110.equalsIgnoreCase("seqAndroidEmpty") == false) goto L84;
        r110 = Uri.parse(new String(Base64.decode(Uri.parse(r125).getQueryParameter("ret_url"), 0))).getQueryParameter(OnekeyLoginConstants.CU_KEY_SEQ);     // Catch: Exception -> L146 Throwable -> L155
        aj.a("seq = " + r110 + "\nstatusCode = " + r122);     // Catch: Exception -> L146 Throwable -> L155
    L84:
        if (r122 == 200) goto L228;
        r101 = r101;
        String r128 = "code";
        if (r122 != 302) goto L111;
    L127:
        ?? r129 = r210;
        r114 = r114;
        String r130 = new String(r115.getHeaderField("Location"));     // Catch: Exception -> L144 Throwable -> L155
        StringBuilder r131 = new StringBuilder("statusCode == 302 301, redirectUrl is \n");     // Catch: Exception -> L144 Throwable -> L155
        r131.append(r130.substring(0, 30));     // Catch: Exception -> L142 Throwable -> L155
        r131.append("...");     // Catch: Exception -> L142 Throwable -> L155
        aj.a(r131.toString());     // Catch: Exception -> L142 Throwable -> L155
        r212 = "System.currentTimeMillis() is  \n";
        ?? r132 = new StringBuilder("System.currentTimeMillis() is  \n");     // Catch: Exception -> L142 Throwable -> L155
        r213 = System.currentTimeMillis();     // Catch: Exception -> L142 Throwable -> L155
        r132.append(r213);     // Catch: Exception -> L142 Throwable -> L155
        aj.a(r132.toString());     // Catch: Exception -> L142 Throwable -> L155
        r115.getInputStream().close();     // Catch: Exception -> L142 Throwable -> L155
        r115.disconnect();     // Catch: Exception -> L142 Throwable -> L155
        this = TextUtils.isEmpty(r130);     // Catch: Exception -> L142 Throwable -> L155
        if (this != 0) goto L138;
        if (r130.startsWith("https") == false) goto L137;
        return a(r129, r130, r212, r213);
    L137:
        return b(r129, r130, r212, r213);
    L138:
        JSONObject r133 = new JSONObject();     // Catch: Exception -> L140 Throwable -> L164
        r133.put(r128, 410013);     // Catch: Exception -> L140 Throwable -> L164
        r133.put(r118, "无跳转地址");     // Catch: Exception -> L140 Throwable -> L164
        r133.put(r101, r111);     // Catch: Exception -> L140 Throwable -> L164
        return r133.toString();
    L140:
        e = e;
    L254:
        if (ac.b() == false) goto L172;
        if (r113 == false) goto L172;
        ak.b(r129, r111);     // Catch: Throwable -> L164 Exception -> L209
        aj.a(r114 + r111 + "\n");     // Catch: Throwable -> L164 Exception -> L209
    L172:
        if (r115 == null) goto L174;
        r115.getInputStream().close();     // Catch: Throwable -> L164 Exception -> L209
        r115.disconnect();     // Catch: Throwable -> L164 Exception -> L209
    L174:
        int r134 = al.e();     // Catch: Throwable -> L164
        aj.a("\n*********************\niRetry = >" + r134 + " \n   e-->" + e + "\n*********************\n");     // Catch: Throwable -> L164
        aj.a(e);     // Catch: Throwable -> L164
        String r135 = e.getMessage();     // Catch: Throwable -> L164
        if (r135 != null) goto L177;
    L252:
        aj.a("catch (Exception e) is  ".concat(String.valueOf(e)));     // Catch: Throwable -> L164 Exception -> L206
        JSONObject r136 = new JSONObject();     // Catch: Throwable -> L164 Exception -> L206
        r136.put(r128, 410011);     // Catch: Throwable -> L164 Exception -> L206
        r136.put(r118, "https异常: ".concat(String.valueOf(r135)));     // Catch: Throwable -> L164 Exception -> L206
        r136.put(r101, "requestUrl->".concat(r100));     // Catch: Throwable -> L164 Exception -> L206
        return r136.toString();
    L206:
        return null;
    L177:
        if (r134 >= al.d()) goto L252;
        int r137 = al.f();     // Catch: Throwable -> L164
        if (r135.contains("resolve host") == false) goto L199;
        if (r111.contains(i.d()) == false) goto L184;
    L187:
        boolean r138 = true;
    L188:
        if (r138 == false) goto L199;
        aj.a("resolve host error: retry->" + r137 + " times \ne_getMessage=" + r135);     // Catch: Throwable -> L164
        if (f461945b == false) goto L197;
        if (f461944a == false) goto L197;
        if (TextUtils.isEmpty(ak.f461989a) == true) goto L197;
        r100 = r100.replaceFirst(i.d(), a(ak.f461989a));     // Catch: Throwable -> L164
    L197:
        return this.a(r129, r100, r212, r213);
    L184:
        if (r111.contains(i.e()) == true) goto L187;
        r138 = false;
    L199:
        if (r135.contains("Failed to connect") == false) goto L202;
        aj.a("Failed to connect error: retry->" + r137 + " times \ne_getMessage=" + r135);     // Catch: Throwable -> L164
        return this.a(r129, r100, r212, r213);
    L202:
        aj.a("other  error: retry->" + r137 + " times \ne_getMessage=" + r135);     // Catch: Throwable -> L164
        return this.a(r129, r100, r212, r213);
    L142:
        e = e;
        this = this;
        r212 = r212;
        r213 = r213;
        goto L254
    L111:
        if (r122 == 301) goto L127;
        if (ac.b() == false) goto L121;
        if (r113 == false) goto L121;
        ak.b(r210, r111);     // Catch: Exception -> L211 Throwable -> L155
        aj.a(r114 + r111 + "\n");     // Catch: Exception -> L210 Throwable -> L155
    L121:
        r115.getInputStream().close();     // Catch: Exception -> L210 Throwable -> L155
        r115.disconnect();     // Catch: Exception -> L210 Throwable -> L155
    L125:
        JSONObject r139 = new JSONObject();     // Catch: Exception -> L144 Throwable -> L155
        r139.put(r128, 410010);     // Catch: Exception -> L144 Throwable -> L155
        r139.put(r118, "Https状态码错误".concat(String.valueOf(r122)));     // Catch: Exception -> L144 Throwable -> L155
        r139.put(r101, "requestUrl:".concat(r100));     // Catch: Exception -> L144 Throwable -> L155
        return r139.toString();
    L144:
        e = e;
        r129 = r127;
        r114 = r124;
        goto L254
    L228:
        InputStream r140 = r115.getInputStream();     // Catch: Exception -> L105 Throwable -> L155
        r128 = a(r140);     // Catch: Exception -> L105 Throwable -> L155
        String r141 = new String(r128);     // Catch: Exception -> L105 Throwable -> L155
        r115.disconnect();     // Catch: Exception -> L105 Throwable -> L155
        r140.close();     // Catch: Exception -> L105 Throwable -> L155
        if (an.a(r110).booleanValue() == false) goto L230;
        r110 = i.g();     // Catch: Exception -> L146 Throwable -> L155
    L230:
        if (TextUtils.isEmpty(r141) == false) goto L98;
        JSONObject r142 = new JSONObject();     // Catch: Exception -> L105 Throwable -> L155
        r128 = "code";
        r142.put(r128, 410012);     // Catch: Exception -> L96 Throwable -> L155
        r142.put(r118, "返回数据体为空");     // Catch: Exception -> L96 Throwable -> L155
        r142.put(OnekeyLoginConstants.CU_KEY_SEQ, r110);     // Catch: Exception -> L96 Throwable -> L155
        r142.put(r101, "requestUrl:".concat(r100));     // Catch: Exception -> L103 Throwable -> L155
        return r142.toString();
    L96:
        e = e;
        r101 = r101;
    L107:
        r129 = r210;
        r114 = r114;
        goto L254
    L98:
        JSONObject r143 = new JSONObject(r141);     // Catch: Exception -> L103 Throwable -> L155
        if (TextUtils.isEmpty(r143.optString(OnekeyLoginConstants.CU_KEY_SEQ)) == false) goto L102;
        r143.put(OnekeyLoginConstants.CU_KEY_SEQ, r110);     // Catch: Exception -> L103 Throwable -> L155
    L102:
        return r143.toString();
    L103:
        e = e;
    L105:
        e = e;
        r101 = r101;
        r128 = "code";
    L146:
        e = e;
        r129 = r210;
        r101 = r101;
        r114 = r114;
        r128 = "code";
    L149:
        e = e;
        this = this;
        r212 = r212;
        r213 = r213;
        r101 = r101;
        r114 = r114;
        r128 = "code";
        r129 = r210;
    L151:
        e = e;
        this = this;
        r212 = r212;
        r101 = r101;
        r114 = r114;
        r129 = r210;
        r213 = r213;
        r128 = "code";
    L153:
        e = e;
        this = this;
    L163:
        this = this;
    L58:
        r129 = r210;
        r212 = r212;
        r213 = r213;
        r128 = "code";
    L157:
        e = e;
        this = this;
    L155:
        th = move-exception;
        throw th;
    L159:
        e = e;
    L161:
        e = e;
        r118 = "msg";
        goto L163
    L239:
        r107 = (HttpsURLConnection) ((Network) r213).openConnection(r106);     // Catch: Exception -> L56 Throwable -> L164
    L56:
        e = e;
        r118 = "msg";
        r115 = null;
        this = this;
    L164:
        th = move-exception;
        throw th;
    L166:
        e = e;
        r118 = "msg";
        r101 = r101;
        r114 = r114;
        r129 = r210;
        r212 = r212;
        r213 = r213;
        r128 = "code";
        r115 = null;
        goto L254
    L233:
        d r144 = ak.i(r111);     // Catch: Exception -> L42
        if (r144 != null) goto L23;
        r112 = "DNS cache use error,clean domain = ";
        r101 = "data";
        ak.a(r210, r111);     // Catch: Exception -> L40
        String r145 = "DNS cache add domain = " + r111 + "\n";     // Catch: Exception -> L40
    L37:
        aj.a(r145);     // Catch: Exception -> L40
        goto L47
    L23:
        if (ak.a(r111) == false) goto L46;
        String r146 = r144.f462036b;     // Catch: Exception -> L42
        if (r146 == null) goto L46;
        if (r146.length() <= 0) goto L46;
        r112 = "DNS cache use error,clean domain = ";
        r101 = "data";
        if (r144.f462037c <= System.currentTimeMillis()) goto L36;
        r100 = r100.replaceFirst(r111, a(r144.f462036b));     // Catch: Exception -> L40
        ak.f462004p.add(r144.f462036b);     // Catch: Exception -> L40
        aj.a("DNS cache use domain = " + r111 + "\n");     // Catch: Exception -> L34
        r113 = true;
    L34:
        e = move-exception;
        Exception r147 = e;
        boolean r148 = true;
    L45:
        r113 = r148;
        aj.a("DNS cache catch error = " + r147.getMessage() + "\n");
        goto L49
    L36:
        ak.b(r210, r111);     // Catch: Exception -> L40
        r145 = "DNS cache expire,clean domain = " + r111 + "\n";     // Catch: Exception -> L40
    L40:
        e = e;
    L44:
        r147 = e;
        r148 = false;
    L42:
        e = e;
        r112 = "DNS cache use error,clean domain = ";
        r101 = "data";
    L5:
        e = move-exception;
        aj.a(e);
        r102 = "";
        goto L7
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_unicom_online_account_kernel_aa_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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
