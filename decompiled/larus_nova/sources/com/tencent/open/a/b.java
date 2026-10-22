package com.tencent.open.a;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.SLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.text.Typography;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes29.dex */
class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f461679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f461680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f461681c;

    public b(String r100) {
        this.f461679a = 15000;
        this.f461680b = 30000;
        this.f461681c = r100;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_tencent_open_a_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    private void a(HttpURLConnection r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setRequestProperty("User-Agent", this.f461681c);
        r100.setConnectTimeout(this.f461679a);
        r100.setReadTimeout(this.f461680b);
        r100.setRequestProperty("Accept-Language", "zh-CN");
        r100.setRequestProperty("Connection", HTTP.KEEP_ALIVE);
        r100.setRequestProperty("Charset", "UTF-8");
    }

    private static void b(HttpURLConnection r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.disconnect();     // Catch: Exception -> L6
        return;
    }

    private static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    private g a(String r110, int r111) throws IOException {
        ByteArrayOutputStream r100 = null;
        HttpURLConnection r112 = (HttpURLConnection) INVOKEVIRTUAL_com_tencent_open_a_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r110));     // Catch: Throwable -> L29
        r112.setRequestMethod("GET");     // Catch: Throwable -> L27
        a(r112);     // Catch: Throwable -> L27
        r112.setDoInput(true);     // Catch: Throwable -> L27
        r112.setDoOutput(false);     // Catch: Throwable -> L27
        r112.setUseCaches(false);     // Catch: Throwable -> L27
        r112.connect();     // Catch: Throwable -> L27
        if (r112.getResponseCode() != 200) goto L20;
        InputStream r101 = r112.getInputStream();     // Catch: Throwable -> L27
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L18
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L16
    L10:
        int r104 = r101.read(r103);     // Catch: Throwable -> L16
        if (r104 == (-1)) goto L13;
        r102.write(r103, 0, r104);     // Catch: Throwable -> L16
        goto L10
    L13:
        c r105 = new c(r112, r102.toString(), r112.getContentLength(), r111, r112.getResponseCode(), "");     // Catch: Throwable -> L16
        a(r102);
        a(r101);
        b(r112);
        return r105;
    L16:
        th = th;
        r100 = r102;
    L31:
        a(r100);
        a(r101);
        b(r112);
        throw th;
    L18:
        th = th;
        goto L31
    L20:
        String r106 = r112.getResponseMessage();     // Catch: Throwable -> L27
        if (r106 != null) goto L23;
        String r107 = "请求失败 code:" + r112.getResponseCode();     // Catch: Throwable -> L27
    L24:
        c r108 = new c(r112, "", r112.getContentLength(), r111, r112.getResponseCode(), r107);     // Catch: Throwable -> L27
        a(null);
        a(null);
        b(r112);
        return r108;
    L23:
        r107 = r106;
    L27:
        th = th;
        r101 = null;
    L29:
        th = th;
        r112 = null;
        r101 = null;
        goto L31
    }

    @Override // com.tencent.open.a.a
    public g a(String r100, Map<String, String> r101) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "post. ");
        StringBuilder r102 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
        boolean r104 = true;
    L4:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, String> r105 = r103.next();
        if (r104 == false) goto L8;
        r104 = false;
    L9:
        r102.append(URLEncoder.encode(r105.getKey(), "UTF-8"));
        r102.append(com.alipay.sdk.m.n.a.f25612h);
        r102.append(URLEncoder.encode(r105.getValue(), "UTF-8"));
        goto L4
    L8:
        r102.append(Typography.amp);
        goto L9
    L10:
        String r106 = r102.toString();
        return a(r100, r106.length(), r106);
    }

    @Override // com.tencent.open.a.a
    public g a(String r100, String r101) throws IOException {
        SLog.i("DefaultHttpServiceImpl", "get. ");
        if (TextUtils.isEmpty(r101) == true) goto L12;
        int r102 = r101.indexOf("?");
        if (r102 != (-1)) goto L8;
        r100 = r100 + "?";
    L10:
        r100 = r100 + r101;
        goto L12
    L8:
        if (r102 == (r100.length() - 1)) goto L10;
        r100 = r100.concat("&");
    L12:
        return a(r100, r101.length());
    }

    @Override // com.tencent.open.a.a
    public void a(long r100, long r101) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r101 <= 0) goto L10;
        this.f461679a = (int) r100;
        this.f461680b = (int) r101;
        return;
    }

    private g a(String r110, int r111, String r112) throws IOException {
        ByteArrayOutputStream r100 = null;
        HttpURLConnection r113 = (HttpURLConnection) INVOKEVIRTUAL_com_tencent_open_a_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r110));     // Catch: Throwable -> L28
        r113.setRequestMethod("POST");     // Catch: Throwable -> L26
        a(r113);     // Catch: Throwable -> L26
        r113.setDoInput(true);     // Catch: Throwable -> L26
        r113.setDoOutput(true);     // Catch: Throwable -> L26
        r113.setUseCaches(false);     // Catch: Throwable -> L26
        r113.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");     // Catch: Throwable -> L26
        OutputStreamWriter r101 = new OutputStreamWriter(r113.getOutputStream(), "UTF-8");     // Catch: Throwable -> L26
        r101.write(r112);     // Catch: Throwable -> L26
        r101.flush();     // Catch: Throwable -> L26
        r113.connect();     // Catch: Throwable -> L26
        int r102 = r113.getContentLength();     // Catch: Throwable -> L26
        if (r113.getResponseCode() != 200) goto L20;
        InputStream r114 = r113.getInputStream();     // Catch: Throwable -> L26
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L18
        byte[] r104 = new byte[1024];     // Catch: Throwable -> L16
    L10:
        int r105 = r114.read(r104);     // Catch: Throwable -> L16
        if (r105 == (-1)) goto L13;
        r103.write(r104, 0, r105);     // Catch: Throwable -> L16
        goto L10
    L13:
        c r106 = new c(r113, r103.toString(), r102, r111, r113.getResponseCode(), "");     // Catch: Throwable -> L16
        a(r103);
        a(r114);
        b(r113);
        return r106;
    L16:
        th = th;
        r100 = r103;
    L30:
        a(r100);
        a(r114);
        b(r113);
        throw th;
    L18:
        th = th;
        goto L30
    L20:
        String r115 = r113.getResponseMessage();     // Catch: Throwable -> L26
        if (r115 != null) goto L23;
        r115 = "Unknown fail: " + r113.getResponseCode();     // Catch: Throwable -> L26
    L23:
        c r116 = new c(r113, "", 0, r111, r113.getResponseCode(), r115);     // Catch: Throwable -> L26
        a(null);
        a(null);
        b(r113);
        return r116;
    L26:
        th = th;
        r114 = null;
    L28:
        th = th;
        r113 = null;
        r114 = null;
        goto L30
    }

    @Override // com.tencent.open.a.a
    public g a(String r100, Map<String, String> r101, Map<String, byte[]> r102) throws IOException {
        if (r102 == null) goto L13;
        if (r102.size() <= 0) goto L13;
        Iterator<Map.Entry<String, byte[]>> r103 = r102.entrySet().iterator();
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, byte[]> r104 = r103.next();
        return a(r100, r101, r104.getKey(), r104.getValue());
    L10:
        return null;
    L13:
        return a(r100, r101);
    }

    public g a(String r210, Map<String, String> r211, String r212, byte[] r213) throws IOException {
        Map<String, String> r100 = r211;
        SLog.i("DefaultHttpServiceImpl", "文件上传");
        String r101 = UUID.randomUUID().toString();
        HttpURLConnection r102 = (HttpURLConnection) INVOKEVIRTUAL_com_tencent_open_a_b_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r210));     // Catch: Throwable -> L60
        r102.setDoInput(true);     // Catch: Throwable -> L57
        r102.setDoOutput(true);     // Catch: Throwable -> L57
        r102.setRequestMethod("POST");     // Catch: Throwable -> L57
        r102.setUseCaches(false);     // Catch: Throwable -> L57
        r102.setInstanceFollowRedirects(false);     // Catch: Throwable -> L57
        r102.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + r101);     // Catch: Throwable -> L57
        a(r102);     // Catch: Throwable -> L55
        r102.connect();     // Catch: Throwable -> L55
        DataOutputStream r110 = new DataOutputStream(r102.getOutputStream());     // Catch: Throwable -> L55
        if (r100 != null) goto L65;
    L19:
        if (r213 != null) goto L21;
    L24:
        int r111 = 0;
    L69:
        int r103 = r102.getResponseCode();     // Catch: Throwable -> L53
        SLog.i("DefaultHttpServiceImpl", r103 + "");     // Catch: Throwable -> L53
        if (r103 != 200) goto L41;
        InputStream r104 = r102.getInputStream();     // Catch: Throwable -> L16
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L39
        byte[] r106 = new byte[1024];     // Catch: Throwable -> L37
    L32:
        int r107 = r104.read(r106);     // Catch: Throwable -> L37
        if (r107 == (-1)) goto L35;
        r105.write(r106, 0, r107);     // Catch: Throwable -> L37
        goto L32
    L35:
        String r112 = r105.toString();     // Catch: Throwable -> L37
        InputStream r108 = r104;
        ByteArrayOutputStream r113 = r105;
    L77:
        DataOutputStream r109 = r110;
        c r114 = new c(r102, r112, r102.getContentLength(), r111, r102.getResponseCode(), "");     // Catch: Throwable -> L48
        a(r109);
        a(r108);
        a(r113);
        b(r102);
        return r114;
    L48:
        th = th;
    L52:
        InputStream r115 = r108;
        DataOutputStream r116 = r109;
        r105 = r113;
        InputStream r117 = r115;
    L63:
        a(r116);
        a(r117);
        a(r105);
        b(r102);
        throw th;
    L50:
        th = th;
        r109 = r110;
    L37:
        th = th;
        r117 = r104;
        r116 = r110;
    L39:
        th = th;
        r117 = r104;
        r116 = r110;
        r105 = null;
    L16:
        th = th;
        r116 = r110;
    L18:
        r105 = null;
    L62:
        r117 = null;
        goto L63
    L41:
        r112 = r102.getResponseCode() + "";     // Catch: Throwable -> L53
        r108 = null;
        r113 = null;
    L53:
        th = th;
        r116 = r110;
        goto L18
    L21:
        if (r213.length <= 0) goto L24;
        StringBuffer r118 = new StringBuffer();     // Catch: Throwable -> L16
        r118.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L16
        r118.append(r101);     // Catch: Throwable -> L16
        r118.append("\r\n");     // Catch: Throwable -> L16
        r118.append("Content-Disposition: form-data; name=\"" + r212 + "\"; filename=\"" + r212 + "\"\r\n");     // Catch: Throwable -> L16
        StringBuilder r119 = new StringBuilder();     // Catch: Throwable -> L16
        r119.append("Content-Type: application/octet-stream; charset=UTF-8");     // Catch: Throwable -> L16
        r119.append("\r\n");     // Catch: Throwable -> L16
        r118.append(r119.toString());     // Catch: Throwable -> L16
        r118.append("\r\n");     // Catch: Throwable -> L16
        r110.write(r118.toString().getBytes());     // Catch: Throwable -> L16
        r110.write(r213, 0, r213.length);     // Catch: Throwable -> L16
        r110.write("\r\n".getBytes());     // Catch: Throwable -> L16
        byte[] r120 = (HttpClient.ENDFLAG + r101 + HttpClient.ENDFLAG + "\r\n").getBytes();     // Catch: Throwable -> L16
        r110.write(r120);     // Catch: Throwable -> L16
        int r121 = r120.length + 0;     // Catch: Throwable -> L16
        r110.flush();     // Catch: Throwable -> L16
        r111 = r121;
        goto L69
    L65:
        if (r211.size() <= 0) goto L19;
        Iterator<String> r122 = r211.keySet().iterator();     // Catch: Throwable -> L16
    L14:
        if (r122.hasNext() == false) goto L19;
        StringBuffer r123 = new StringBuffer();     // Catch: Throwable -> L16
        String r124 = URLEncoder.encode(r122.next(), "UTF-8");     // Catch: Throwable -> L16
        String r125 = URLEncoder.encode(r100.get(r124), "UTF-8");     // Catch: Throwable -> L16
        r123.append(HttpClient.ENDFLAG);     // Catch: Throwable -> L16
        r123.append(r101);     // Catch: Throwable -> L16
        r123.append("\r\n");     // Catch: Throwable -> L16
        r123.append("Content-Disposition: form-data; name=\"");     // Catch: Throwable -> L16
        r123.append(r124);     // Catch: Throwable -> L16
        r123.append("\"");     // Catch: Throwable -> L16
        r123.append("\r\n");     // Catch: Throwable -> L16
        r123.append("\r\n");     // Catch: Throwable -> L16
        r123.append(r125);     // Catch: Throwable -> L16
        r123.append("\r\n");     // Catch: Throwable -> L16
        String r126 = r123.toString();     // Catch: Throwable -> L16
        SLog.i("DefaultHttpServiceImpl", r124 + ContainerUtils.KEY_VALUE_DELIMITER + r126 + "##");     // Catch: Throwable -> L16
        r110.write(r126.getBytes());     // Catch: Throwable -> L16
        r100 = r211;
    L55:
        th = th;
    L59:
        r105 = null;
        r116 = null;
    L57:
        th = th;
    L60:
        th = th;
        r105 = null;
        r116 = null;
        r102 = null;
        goto L62
    }
}
