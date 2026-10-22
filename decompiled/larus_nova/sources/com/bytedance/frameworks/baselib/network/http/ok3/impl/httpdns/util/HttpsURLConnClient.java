package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class HttpsURLConnClient {
    private static final String TAG = null;

    public HttpsURLConnClient() {
    }

    static {
        TAG = "HttpsURLConnClient";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static String executeGet(String r110, String r111) {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "start execute httpdns get " + r110);
    L5:
        long r100 = System.currentTimeMillis();
        StringBuilder r101 = new StringBuilder();
        SsCall r102 = null;
        String r103 = null;
        BufferedReader r104 = null;
        r102 = null;
        int r105 = 0;
        Request r106 = new Request.Builder().url(r110).build();     // Catch: Throwable -> L45 Exception -> L47
        r106.setMetrics(new RetrofitMetrics());     // Catch: Throwable -> L45 Exception -> L47
        SsCall r107 = SsOkHttp3Client.inst(HttpDns.getService().getHttpDnsDepend().getContext()).newSsCall(r106);     // Catch: Throwable -> L45 Exception -> L47
        Response r108 = r107.execute();     // Catch: Throwable -> L39 Exception -> L42
        if (r108 != null) goto L10;
        ?? r109 = 0;
        InputStream r112 = null;
    L30:
        r107.cancel();
        if (r104 != null) goto L92;
    L35:
        if (r112 == null) goto L61;
        r112.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
    L61:
        long r113 = System.currentTimeMillis() - r100;
        ?? r114 = new JSONObject();     // Catch: JSONException -> L71
        r114.put(BdpAppEventConstant.PARAMS_REQUEST_URL, r110);     // Catch: JSONException -> L71
        r114.put("httpdns_domain", r111);     // Catch: JSONException -> L71
        if (r109 != 0) goto L66;
        r114.put("result", "");     // Catch: JSONException -> L71
    L67:
        r114.put(VoicePrintState.EXT_KEY_RESPONSE_CODE, r105);     // Catch: JSONException -> L71
        r114.put("rtt", r113);     // Catch: JSONException -> L71
        if (Logger.debug() == false) goto L73;
        Logger.d(TAG, r114.toString());     // Catch: JSONException -> L71
    L73:
        return r109;
    L66:
        r114.put("result", r109);     // Catch: JSONException -> L71
    L71:
        e = move-exception;
        e.printStackTrace();
        goto L73
    L92:
        r104.close();     // Catch: IOException -> L33
        goto L35
    L10:
        if (r108.isSuccessful() == true) goto L12;
    L22:
        r112 = null;
        BufferedReader r115 = null;
    L23:
        r103 = r101.toString();     // Catch: Throwable -> L25 Exception -> L27
        r105 = r108.getStatus();     // Catch: Throwable -> L25 Exception -> L27
        r109 = r103;
        r104 = r115;
        goto L30
    L27:
        e = e;
        ?? r116 = r103;
        r102 = r107;
    L94:
        e.printStackTrace();     // Catch: Throwable -> L74
        if (r102 == null) goto L52;
        r102.cancel();
    L52:
        if (r115 != null) goto L86;
    L56:
        if (r112 == null) goto L60;
        r112.close();     // Catch: IOException -> L54
    L54:
        e = move-exception;
        e.printStackTrace();
    L60:
        r109 = r116;
        goto L61
    L86:
        r115.close();     // Catch: IOException -> L54
    L74:
        th = th;
    L75:
        if (r102 == null) goto L77;
        r102.cancel();
    L77:
        if (r115 != null) goto L88;
    L81:
        if (r112 == null) goto L85;
        r112.close();     // Catch: IOException -> L79
    L79:
        e = move-exception;
        e.printStackTrace();
    L85:
        throw th;
    L88:
        r115.close();     // Catch: IOException -> L79
    L25:
        th = th;
    L41:
        r102 = r107;
        goto L75
    L12:
        if (r108.getBody() == null) goto L22;
        r112 = r108.getBody().in();     // Catch: Throwable -> L39 Exception -> L42
    L100:
        r115 = new BufferedReader(new InputStreamReader(r112, "UTF-8"));     // Catch: Throwable -> L18 Exception -> L20
    L98:
        String r117 = r115.readLine();     // Catch: Throwable -> L25 Exception -> L27
        if (r117 == null) goto L23;
        r101.append(r117);     // Catch: Throwable -> L25 Exception -> L27
        goto L98
    L20:
        e = e;
        r115 = null;
    L44:
        r102 = r107;
        r116 = r115;
    L18:
        th = th;
        r115 = null;
    L42:
        e = e;
        r112 = null;
        r115 = null;
    L39:
        th = th;
        r112 = null;
        r115 = null;
        goto L41
    L47:
        e = e;
        r116 = 0;
        r112 = null;
        r115 = null;
    L45:
        th = th;
        r112 = null;
        r115 = null;
        goto L75
    }
}
