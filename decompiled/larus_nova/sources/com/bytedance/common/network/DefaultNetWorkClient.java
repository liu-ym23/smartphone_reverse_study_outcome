package com.bytedance.common.network;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultNetWorkClient extends NetworkClient {
    public DefaultNetWorkClient() {
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_bytedance_common_network_DefaultNetWorkClient_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
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

    public static Pair<String, String> parseContentType(String r100) {
        String r101 = null;
        if (r100 != null) goto L17;
        return null;
    L17:
        MimeType r102 = new MimeType(r100);     // Catch: Throwable -> L10
        String r103 = r102.getBaseType();     // Catch: Throwable -> L10
        r101 = r102.getParameter("charset");     // Catch: Throwable -> L8
    L14:
        return new Pair(r103, r101);
    L8:
        th = th;
    L12:
        th.printStackTrace();
    L10:
        th = th;
        r103 = null;
        goto L12
    }

    public static String getRequest(String r100, Map<String, String> r101) throws Throwable {
        if (TextUtils.isDigitsOnly(r100) == false) goto L6;
        return null;
    L6:
        return excuteRequest(r100, null, r101, "GET", false);
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String get(String r100, Map<String, String> r101, NetworkClient.ReqContext r102) throws CommonHttpException {
        return getRequest(r100, r101);
    L4:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L10;
        throw new CommonHttpException(th.getStatusCode(), th.getMessage());
    L10:
        throw new CommonHttpException(0, th.getMessage());
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r100, List<Pair<String, String>> r101, Map<String, String> r110, NetworkClient.ReqContext r111) throws CommonHttpException {
        StringBuilder r102 = new StringBuilder("");     // Catch: Exception -> L13
        int r103 = 0;
    L6:
        if (r103 >= r101.size()) goto L11;
        Pair r104 = (Pair) ListProtector.get(r101, r103);     // Catch: Exception -> L13
        r102.append(((String) r104.first) + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode((String) r104.second, "UTF-8"));     // Catch: Exception -> L13
        if (r103 >= (r101.size() - 1)) goto L10;
        r102.append("&");     // Catch: Exception -> L13
    L10:
        r103 = r103 + 1;     // Catch: Exception -> L13
        goto L6
    L11:
        byte[] r105 = r102.toString().getBytes("UTF-8");     // Catch: Exception -> L13
        HashMap r106 = new HashMap();     // Catch: Exception -> L13
        r111.addCommonParams = true;     // Catch: Exception -> L13
        return post(r100, r105, r106, r111);
    L13:
        e = move-exception;
        e.printStackTrace();
        throw new CommonHttpException(0, e.getMessage());
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r100, byte[] r101, Map<String, String> r102, NetworkClient.ReqContext r103) throws CommonHttpException {
        return excuteRequest(r100, r101, r102, "POST", true);
    L4:
        th = move-exception;
        if ((th instanceof HttpResponseException) == false) goto L10;
        throw new CommonHttpException(th.getStatusCode(), th.getMessage());
    L10:
        throw new CommonHttpException(0, th.getMessage());
    }

    public static String excuteRequest(final String r100, byte[] r101, Map<String, String> r102, String r103, boolean r104) throws Throwable {
        HttpURLConnection r105 = null;
        ToolUtils.addUrlParam(r100, new HashMap());     // Catch: Throwable -> L57
        final HttpURLConnection r106 = (HttpURLConnection) INVOKEVIRTUAL_com_bytedance_common_network_DefaultNetWorkClient_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r100));     // Catch: Throwable -> L57
        r106.setRequestMethod(r103);     // Catch: Throwable -> L55
        r106.setConnectTimeout(15000);     // Catch: Throwable -> L55
        r106.setReadTimeout(15000);     // Catch: Throwable -> L55
        r106.setRequestProperty("Accept-Encoding", DownloadHelper.GZIP);     // Catch: Throwable -> L55
        if (r102 == null) goto L17;
        if (r102.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, String>> r107 = r102.entrySet().iterator();     // Catch: Throwable -> L55
    L10:
        if (r107.hasNext() == false) goto L17;
        Map.Entry<String, String> r108 = r107.next();     // Catch: Throwable -> L55
        if (r108.getKey().isEmpty() == true) goto L10;
        if (r108.getValue().isEmpty() == true) goto L10;
        r106.setRequestProperty(r108.getKey(), r108.getValue());     // Catch: Throwable -> L55
    L17:
        if (r104 == false) goto L19;
        r106.setDoOutput(true);     // Catch: Throwable -> L55
    L20:
        if (r103 == null) goto L54;
        if (r101 != null) goto L23;
    L25:
        int r109 = r106.getResponseCode();     // Catch: Throwable -> L55
        if (r109 != 200) goto L52;
        InputStream r110 = r106.getInputStream();     // Catch: Throwable -> L55
        boolean r111 = DownloadHelper.GZIP.equals(r106.getHeaderField("Content-Encoding"));     // Catch: Throwable -> L55
        String r112 = r106.getHeaderField("Content-Type");     // Catch: Throwable -> L55
        boolean r113 = StreamParser.testIsSSBinary(r112);     // Catch: Throwable -> L55
        Pair<String, String> r114 = parseContentType(r112);     // Catch: Throwable -> L55
        if (r114 == null) goto L34;
        Object r115 = r114.second;     // Catch: Throwable -> L55
        if (r115 == null) goto L34;
        if (Charset.isSupported((String) r115) == false) goto L34;
        String r116 = (String) r114.second;     // Catch: Throwable -> L55
    L35:
        if (r116 != null) goto L37;
        r116 = "UTF-8";
    L37:
        int[] r117 = {0};     // Catch: Throwable -> L55
        byte[] r118 = StreamParser.response2buf(r111, -1, r110, r117, new AnonymousClass1(r100, r106));     // Catch: Throwable -> L55
        if (r118 == null) goto L67;
        int r119 = r117[0];     // Catch: Throwable -> L55
        if (r119 <= 0) goto L67;
        if (r119 > r118.length) goto L67;
        if (r113 == false) goto L46;
        StreamParser.decodeSSBinary(r118, r119);     // Catch: Throwable -> L55
    L46:
        String r120 = new String(r118, 0, r117[0], r116);     // Catch: Throwable -> L55
        r106.disconnect();     // Catch: Exception -> L63
    L48:
        return r120;
    L67:
        r106.disconnect();     // Catch: Exception -> L64
    L50:
        return null;
    L34:
        r116 = null;
        goto L35
    L52:
        throw new HttpResponseException(r109, r106.getResponseMessage());     // Catch: Throwable -> L55
    L23:
        if (r101.length <= 0) goto L25;
        DataOutputStream r121 = new DataOutputStream(r106.getOutputStream());     // Catch: Throwable -> L55
        r121.write(r101);     // Catch: Throwable -> L55
        r121.flush();     // Catch: Throwable -> L55
        r121.close();     // Catch: Throwable -> L55
        goto L25
    L54:
        throw new IllegalArgumentException("request method is not null");     // Catch: Throwable -> L55
    L19:
        r106.setDoOutput(false);     // Catch: Throwable -> L55
    L55:
        th = th;
        r105 = r106;
    L73:
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        if (r105 != null) goto L69;
    L62:
        throw th;
    L69:
        r105.disconnect();     // Catch: Exception -> L65
    L57:
        th = th;
        goto L73
    }
}
