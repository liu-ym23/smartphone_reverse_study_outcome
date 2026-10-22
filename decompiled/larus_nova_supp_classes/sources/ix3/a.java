package ix3;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.applog.b;
import com.bytedance.applog.log.m;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import ex3.e;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import jx3.i;
import me.ele.lancet.base.annotations.Skip;
import nx3.d;
import nx3.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import rw3.f;
import rw3.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final List<String> d = null;
    public static final String[] e = null;
    public JSONObject a;
    public final b b;
    public final d c;

    static {
        d = Collections.singletonList("Api");
        e = new String[]{"GET", "POST"};
    }

    public a(b r2) {
        this.b = r2;
        this.c = new d(r2);
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r7) throws IOException {
        String r3 = r7.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r4 = r7.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r3, r4) == false) goto L11;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r3 + " path=" + r4);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r3, r4), r3, r4);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r7);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r7.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public final void k(JSONObject r6) {
        long r1 = r6.optLong("server_time");     // Catch: Exception -> L9
        if (r1 <= 0) goto L13;
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L9
        r7.put("server_time", r1);     // Catch: Exception -> L9
        r7.put("local_time", System.currentTimeMillis() / 1000);     // Catch: Exception -> L9
        this.a = r7;     // Catch: Exception -> L9
        if (m.b() == true) goto L14;
        m.c("server_time_sync", new a(this, r7));     // Catch: Exception -> L9
        return;
    L14:
        return;
    L13:
        return;
    L9:
        this.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
    }

    public static String d(String r6, String[] r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return r6;
    L5:
        Uri r8 = UriProtector.parse(r6);
        HashMap r0 = new HashMap(r7.length);
        int r1 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String r3 = r7[r2];
        String r4 = UriProtector.getQueryParameter(r8, r3);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        r0.put(r3, r4);
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        Uri.Builder r9 = r8.buildUpon();
        r9.clearQuery();
        Iterator r10 = r0.keySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L16;
        String r5 = (String) r10.next();
        r9.appendQueryParameter(r5, (String) r0.get(r5));
        goto L13
    L16:
        return r9.build().toString();
    }

    public final JSONObject b(String r21, JSONObject r22) {
        boolean r9 = false;
        HashMap r12 = e(false, -1, null);
        String r13 = UUID.randomUUID().toString();
        j(r21, r13, r22, 1, r12);
        this.b.W.b(StatsCountKeys.CONFIG_REQUEST_COUNT, 1);
        byte[] r1 = this.c.h(r22.toString());     // Catch: Throwable -> L16
        String r2 = r22.optString("key");     // Catch: Throwable -> L16
        String r4 = r22.optString("iv");     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r2) == false) goto L6;
    L8:
        boolean r5 = false;
    L9:
        if (r5 == false) goto L14;
        byte[] r0 = this.b.getNetClient().postStream(r21, r1, r12);     // Catch: Throwable -> L16
        byte[] r3 = d.b(r0, r2, r4);     // Catch: Throwable -> L16
        if (r3 != null) goto L13;
        String r6 = new String(r0);     // Catch: Throwable -> L16
    L18:
        if (r6 != null) goto L39;
        h(r13, -1, null, "Config response empty");
        JSONObject r7 = null;
    L28:
        if (r7 != null) goto L30;
    L32:
        if (r9 == true) goto L34;
        this.b.W.b(StatsCountKeys.CONFIG_REQUEST_FAILED_COUNT, 1);
        return null;
    L34:
        return r7.optJSONObject("config");
    L30:
        if ("ss_app_log".equals(r7.optString("magic_tag", XmlPullParser.NO_NAMESPACE)) == false) goto L32;
        r9 = true;
        goto L32
    L39:
        r7 = new JSONObject(r6);     // Catch: Throwable -> L24
        k(r7);     // Catch: Throwable -> L22
        h(r13, 200, null, r6);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Throwable r18 = th;
    L26:
        this.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        this.b.t0.r(11, d, "Parse config response failed", r18, new Object[0]);
        h(r13, -1, null, "Parse config response failed");
    L24:
        th = move-exception;
        r18 = th;
        r7 = null;
        goto L26
    L13:
        r6 = new String(d.f(r3));     // Catch: Throwable -> L16
        goto L18
    L14:
        r6 = this.b.getNetClient().post(r21, r1, r12);     // Catch: Throwable -> L16
        goto L18
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r5 = true;
    L16:
        th = move-exception;
        this.b.W.b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);
        this.b.t0.r(11, d, "config request failed", th, new Object[0]);
        this.b.W.h("api send config failed", th, true);
        r6 = null;
        goto L18
    }

    public final void c(JSONObject r9, boolean r10) {
        if (r10 == false) goto L8;
        if (this.b.x == false) goto L13;
        r9.put("uid_enable", 1);     // Catch: JSONException -> L21
    L12:
        boolean r11 = true;
    L14:
        if (r11 == true) goto L16;
        return;
    L16:
        if (this.b.v == false) goto L27;
        String[] r12 = d.e();     // Catch: JSONException -> L21
        if (d.g(r12) == false) goto L28;
        r9.put("key", r12[0]);     // Catch: JSONException -> L21
        r9.put("iv", r12[1]);     // Catch: JSONException -> L21
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r11 = false;
        goto L14
    L8:
        if (this.b.getInitConfig() == null) goto L13;
        if (this.b.getInitConfig().B == false) goto L13;
        r9.put("event_filter", 1);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        this.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        this.b.t0.r(11, d, "fillKeyIvForEncryptResp error", e, new Object[0]);
    }

    public final HashMap e(boolean r6, int r7, String r8) {
        HashMap r0 = new HashMap(2);
        if (this.b.v == false) goto L5;
        r0.put("Content-Type", "application/octet-stream;tt-data=a");
    L7:
        if (TextUtils.isEmpty(r8) == false) goto L22;
    L19:
        if (r6 == true) goto L21;
        r0.put("x-tt-request-tag", "t=0;n=0");
    L21:
        return r0;
    L22:
        JSONObject r2 = new JSONObject(r8);     // Catch: Throwable -> L13
        Iterator<String> r9 = r2.keys();     // Catch: Throwable -> L13
    L10:
        if (r9.hasNext() == false) goto L19;
        String r3 = r9.next();     // Catch: Throwable -> L13
        r0.put(r3, r2.optString(r3));     // Catch: Throwable -> L13
    L13:
        this.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        if (r7 != 0) goto L16;
        r0.put("log-encode-type", "gzip");
        goto L19
    L16:
        if (r7 == 1) goto L18;
        if (r7 != 2) goto L19;
    L18:
        r0.put("log-encode-type", "zstd");
        r0.put("log-encode-token", String.valueOf(0));
        goto L19
    L5:
        r0.put("Content-Type", "application/json; charset=utf-8");
        goto L7
    }

    public final void h(String r10, int r11, byte[] r12, String r13) {
        if (m.b() == false) goto L5;
        return;
    L5:
        m.c("do_request_end", new c(this, r10, r11, r12, r13, System.currentTimeMillis()));
    }

    public final void i(String r10, String r11, byte[] r12, Map r13) {
        if (m.b() == false) goto L5;
        return;
    L5:
        m.c("do_request_begin", new b(this, r13, r12, r11, r10, System.currentTimeMillis()));
    }

    public final d f(int r16, String r17, HashMap<String, String> r18, byte[] r19, int r20) throws RangersHttpException {
        Closeable r12 = null;
        this.b.t0.k(11, null, "Start request http url: {}", new Object[]{r17});
        if (this.b.T1() == false) goto L13;
        if (r18 == null) goto L13;
        Iterator<Map.Entry<String, String>> r6 = r18.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<String, String> r8 = r6.next();
        if (TextUtils.isEmpty(r8.getKey()) == true) goto L7;
        if (TextUtils.isEmpty(r8.getValue()) == true) goto L7;
        this.b.t0.k(11, null, "http headers key: {}, value: {}", new Object[]{r8.getKey(), r8.getValue()});
    L13:
        d r7 = new d();
        URL r9 = new URL(r17);     // Catch: Throwable -> L85
        if (this.b.u == null) goto L17;
        HttpURLConnection r2 = (HttpURLConnection) r9.openConnection(this.b.u);     // Catch: Throwable -> L85
    L18:
        if (r16 != 0) goto L20;
        r2.setDoOutput(false);     // Catch: Throwable -> L85
    L23:
        r2.setRequestMethod(e[r16]);     // Catch: Throwable -> L85
        if (r18 != null) goto L26;
    L36:
        r2.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L85
        if (r19 != null) goto L39;
    L42:
        DataOutputStream r10 = null;
    L43:
        int r0 = r2.getResponseCode();     // Catch: Throwable -> L81
        if (r0 != 200) goto L80;
        if (r20 == 0) goto L47;
        InputStream r1 = r2.getInputStream();     // Catch: Throwable -> L81
        if ("gzip".equalsIgnoreCase(r2.getContentEncoding()) == false) goto L66;
        InputStream r3 = new GZIPInputStream(r1);     // Catch: Throwable -> L81
    L101:
        ByteArrayOutputStream r4 = new ByteArrayOutputStream();     // Catch: Throwable -> L77
        byte[] r5 = new byte[1024];     // Catch: Throwable -> L75
    L70:
        int r11 = r3.read(r5);     // Catch: Throwable -> L75
        if (r11 == (-1)) goto L73;
        r4.write(r5, 0, r11);     // Catch: Throwable -> L75
        goto L70
    L73:
        r7.b = r4.toByteArray();     // Catch: Throwable -> L75
    L74:
        k.c(r10);
        k.c(r12);
        k.c(r3);
        k.c(r4);
    L90:
        return r7;
    L75:
        th = th;
        ByteArrayOutputStream r13 = r4;
        BufferedReader r14 = null;
    L84:
        r12 = r10;
    L99:
        this.b.W.b(StatsCountKeys.NO_NETWORK_COUNT, 1);     // Catch: Throwable -> L93
        this.b.t0.o(11, "Send request failed", th, new Object[0]);     // Catch: Throwable -> L93
        if ((th instanceof RangersHttpException) == true) goto L92;
        k.c(r12);
        k.c(r14);
        k.c(r3);
        k.c(r13);
        goto L90
    L92:
        throw ((RangersHttpException) th);     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        k.c(r12);
        k.c(r14);
        k.c(r3);
        k.c(r13);
        throw th;
    L77:
        th = th;
    L83:
        r14 = null;
        r13 = null;
        goto L84
    L66:
        r3 = r1;
        goto L101
    L47:
        if (r2.getContentLength() >= 4194304) goto L60;
        InputStream r15 = r2.getInputStream();     // Catch: Throwable -> L81
        if ("gzip".equalsIgnoreCase(r2.getContentEncoding()) == false) goto L51;
        r14 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r15)));     // Catch: Throwable -> L81
    L105:
        StringBuilder r21 = new StringBuilder(r15.available());     // Catch: Throwable -> L58
    L53:
        String r22 = r14.readLine();     // Catch: Throwable -> L58
        if (r22 == null) goto L56;
        r21.append(r22);     // Catch: Throwable -> L58
        r21.append("\n");     // Catch: Throwable -> L58
        goto L53
    L56:
        r7.a = r21.toString();     // Catch: Throwable -> L58
        JSONObject r23 = new JSONObject(r7.a);     // Catch: Throwable -> L58
        r23.put("Set-Cookie", r2.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L58
        r7.a = r23.toString();     // Catch: Throwable -> L58
    L61:
        r3 = null;
        r12 = r14;
        r4 = null;
    L58:
        th = th;
        r3 = null;
        r13 = null;
        goto L84
    L51:
        r14 = new BufferedReader(new InputStreamReader(r15));     // Catch: Throwable -> L81
        goto L105
    L60:
        this.b.t0.p(11, d, "respType is {}", new Object[]{Integer.valueOf(r20)});     // Catch: Throwable -> L81
        r14 = null;
        goto L61
    L80:
        throw new RangersHttpException(r0, r2.getResponseMessage());     // Catch: Throwable -> L81
    L39:
        if (r19.length <= 0) goto L42;
        r10 = new DataOutputStream(r2.getOutputStream());     // Catch: Throwable -> L85
        r10.write(r19);     // Catch: Throwable -> L81
        r10.flush();     // Catch: Throwable -> L81
        r10.close();     // Catch: Throwable -> L81
    L81:
        th = th;
        r3 = null;
        goto L83
    L26:
        if (r18.isEmpty() == true) goto L36;
        Iterator<Map.Entry<String, String>> r24 = r18.entrySet().iterator();     // Catch: Throwable -> L85
    L29:
        if (r24.hasNext() == false) goto L36;
        Map.Entry<String, String> r25 = r24.next();     // Catch: Throwable -> L85
        if (TextUtils.isEmpty(r25.getKey()) == true) goto L35;
        if (TextUtils.isEmpty(r25.getValue()) == true) goto L35;
        r2.addRequestProperty(r25.getKey(), r25.getValue());     // Catch: Throwable -> L85
    L35:
        this.b.t0.f(11, d, "header key value invalid", new Object[0]);     // Catch: Throwable -> L85
        goto L29
    L20:
        if (r16 != 1) goto L22;
        r2.setDoOutput(true);     // Catch: Throwable -> L85
        goto L23
    L22:
        this.b.t0.f(11, d, "unknown method", new Object[0]);     // Catch: Throwable -> L85
        goto L23
    L17:
        r2 = (HttpURLConnection) a(r9);     // Catch: Throwable -> L85
    L85:
        th = th;
        r3 = null;
        r14 = null;
        r13 = null;
        goto L99
    }

    public final void j(String r11, String r12, JSONObject r13, int r14, Map<String, String> r15) {
        if (m.b() == false) goto L5;
        return;
    L5:
        m.c("do_request_begin", new b(this, r15, r12, r11, r13, r14, System.currentTimeMillis()));
    }

    public final int g(String[] r36, byte[] r37, f r38, String[] r39, int r40, String r41, Map<String, String> r42, boolean r43, int r44, i r45) {
        String[] r13 = r36;
        String r8 = "message";
        String r7 = "Content-Type";
        zw3.b r6 = r38.d;
        int r5 = r13.length;
        int r1 = 10;
        int r2 = 0;
        JSONObject r16 = null;
    L4:
        if (r2 >= r5) goto L156;
        String r4 = r13[r2];
        int r20 = r1;
        this.b.W.b(StatsCountKeys.REPORT_REQUEST_COUNT, 1);
        String r3 = UUID.randomUUID().toString();
        e r0 = this.b.W;
        String r9 = n.s;
        int r22 = r2;
        if (r0.a.b == true) goto L8;
    L10:
        boolean r10 = false;
    L11:
        if (r10 == true) goto L13;
        cx3.a r11 = cx3.a.a;
    L15:
        if (this.b.o.b != null) goto L17;
        boolean r12 = true;
    L18:
        r11.setBackground(r12);
        if (r11.isEnabled() == false) goto L295;
        if (r45.W <= 0) goto L23;
        boolean r14 = true;
    L24:
        r11.a("pack_has_launch", Boolean.valueOf(r14));
        if (r45.X <= 0) goto L27;
        boolean r15 = true;
    L28:
        r11.a("pack_has_terminate", Boolean.valueOf(r15));
        r11.a("pack_db_id", Long.valueOf(((jx3.a) r45).a));
        r11.a("pack_sid", ((jx3.a) r45).d);
        r11.a("pack_ts", Long.valueOf(((jx3.a) r45).b));
        r11.a("pack_fail_cnt", Integer.valueOf(r45.z));
        r11.a("pack_v1_cnt", Integer.valueOf(r45.Y));
        r11.a("pack_v3_cnt", Integer.valueOf(r45.Z));
        r11.a("pack_log_data_cnt", Integer.valueOf(r45.k0));
        r11.a("cur_sid", this.b.getSessionId());
        r11.a("handle_error_data", Boolean.valueOf(r43));
        r11.a("retry", Integer.valueOf(r44));
        goto L295
    L27:
        r15 = false;
        goto L28
    L23:
        r14 = false;
    L295:
        HashMap r17 = e(true, r40, r41);     // Catch: Throwable -> L123
        if (r42 == 0) goto L315;
        r17.putAll(r42);     // Catch: Throwable -> L123
    L315:
        i(r4, r3, r37, r17);     // Catch: Throwable -> L121
        r11.d(r41);     // Catch: Throwable -> L121
        r11.c(r37);     // Catch: Throwable -> L121
        if (d.g(r39) == false) goto L44;
        byte[] r18 = this.b.getNetClient().postStream(r4, r37, r17);     // Catch: Throwable -> L121
        if (r18 == null) goto L43;
        byte[] r19 = d.b(r18, r39[0], r39[1]);     // Catch: Throwable -> L121
        if (r19 != null) goto L41;
        String r21 = new String(r18);     // Catch: Throwable -> L121
    L307:
        this.b.t0.k(11, d, "send log resp: {}", new Object[]{r21});     // Catch: Throwable -> L119
        if (TextUtils.isEmpty(r21) == false) goto L286;
        String r34 = r3;
        r11 = r11;
        r22 = r22;
        r6 = r6;
        r5 = r5;
        String r110 = r4;
        byte[] r111 = null;
        r7 = r7;
        r8 = r8;
        this.b.V.a("REQUEST_FAILED_RESPONSE_EMPTY", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L117
        r11.setMessage("resp_null");     // Catch: Throwable -> L117
        r1 = 11;
    L110:
        r3 = r34;
        h(r3, r1, r111, "Send log response is invalid");     // Catch: Throwable -> L113
        r11.setStatusCode(r1);
        r11.end();
        zw3.b r23 = r6;
    L152:
        r2 = r22 + 1;
        r13 = r36;
        r6 = r23;
        r5 = r5;
        r7 = r7;
        r8 = r8;
    L113:
        th = th;
    L311:
        com.bytedance.applog.log.n r24 = this.b.t0;     // Catch: Throwable -> L153
        List<String> r112 = d;     // Catch: Throwable -> L153
        int r113 = 1;
        int r114 = 0;
        r24.r(11, r112, "send log to url:{} failed", th, new Object[]{r110});     // Catch: Throwable -> L153
        this.b.W.b(StatsCountKeys.REQUEST_ERROR_COUNT, 1);     // Catch: Throwable -> L153
        this.b.W.h("api send log failed", th, true);     // Catch: Throwable -> L153
        this.b.V.a("REQUEST_FAILED_EXCEPTION", th.toString());     // Catch: Throwable -> L153
        r11.handleException(th);     // Catch: Throwable -> L153
        if ((th instanceof RangersHttpException) == false) goto L149;
        RangersHttpException r25 = (RangersHttpException) th;     // Catch: Throwable -> L153
        r1 = r25.getResponseCode();     // Catch: Throwable -> L153
        String r26 = r25.getMessage();     // Catch: Throwable -> L153
        if (TextUtils.isEmpty(r26) == false) goto L132;
    L134:
        this.b.t0.r(11, r112, "send resultCode: " + r1, th, new Object[0]);     // Catch: Throwable -> L153
        r23 = r6;
        if (r23.b.x == false) goto L144;
        if (r1 >= 500) goto L139;
    L141:
        boolean r28 = false;
    L142:
        if (r28 == false) goto L144;
    L148:
        r11.setStatusCode(r1);
        r11.end();
    L157:
        int r29 = r1;
        JSONObject r115 = r16;
    L158:
        if (r115 == null) goto L281;
        int r30 = 200;
        if (r29 != 200) goto L280;
        r23.getClass();
        long r31 = r115.optLong("batch_event_interval", 0) * 1000;
        r23.k = r31;
        com.bytedance.applog.log.n r32 = r23.n.t0;
        List<String> r33 = zw3.b.v;
        Object[] r35 = new Object[r113];
        r35[r114] = Long.valueOf(r31);
        r32.k(r114, r33, "parseCommonConfigFromResp mEventIntervalFromLogResp: {}", r35);
        if (this.b.x == false) goto L165;
        r38.k.b = r115.optLong("uid");
        r38.k.c = r115.optInt("user_type");
        r38.k.d = r115.optInt("user_is_login");
        r38.k.e = r115.optInt("user_is_auth");
    L165:
        if (this.b.P1() <= 0) goto L174;
        JSONObject r46 = r115.optJSONObject("sampling_list");
        if (r46 == null) goto L174;
        uw3.i r47 = r38.t;
        String r48 = com.bytedance.applog.a.b(this.b, "sampling_list");
        if (r47 != null) goto L171;
        uw3.i r49 = new uw3.i(r38, gx3.d.b(r38.getContext(), r48, r46, null));
    L172:
        r38.t = r49;
        goto L174
    L171:
        r49 = new uw3.i(r38, gx3.d.b(r38.getContext(), r48, r46, r47.a));
    L174:
        if (this.b.C == false) goto L187;
        b r50 = this.b;
        List r51 = com.bytedance.applog.priority.c.a;
        JSONObject r116 = r115.optJSONObject("priority_list");
        if (r116 == null) goto L187;
        com.bytedance.applog.priority.a r52 = new com.bytedance.applog.priority.a();     // Catch: Throwable -> L185
        if (r116.optInt("prefer_batch_event_interval", r114) != r113) goto L180;
        boolean r53 = true;
    L181:
        r52.h = r53;     // Catch: Throwable -> L185
        r52.a = r116.optInt("priority_version", r114);     // Catch: Throwable -> L185
        r52.b = r116.optInt("base_interval", 5);     // Catch: Throwable -> L185
        JSONArray r54 = r116.optJSONArray("priorities");     // Catch: Throwable -> L185
        com.bytedance.applog.priority.c.a(r50, r23, r52, r54);     // Catch: Throwable -> L185
        if (r52.a() == false) goto L187;
        r23.i(r52);     // Catch: Throwable -> L185
        SharedPreferences.Editor r55 = r23.getContext().getSharedPreferences(com.bytedance.applog.a.b(r50, "priority_list"), r114).edit();     // Catch: Throwable -> L185
        r55.putInt("priority_version", r52.a);     // Catch: Throwable -> L185
        r55.putInt("base_interval", r52.b);     // Catch: Throwable -> L185
        r55.putString("priorities", r54.toString());     // Catch: Throwable -> L185
        r55.apply();     // Catch: Throwable -> L185
        goto L187
    L180:
        r53 = false;
    L185:
        th = move-exception;
        r50.t0.s(com.bytedance.applog.priority.c.a, "parseEventPriorityFromServer", th, new Object[r114]);
    L187:
        r23.m.b(r115, r23.b(), null);
        com.bytedance.applog.priority.a r56 = r23.l;
        List r57 = com.bytedance.applog.priority.c.a;
        if (r56 == null) goto L206;
        JSONArray r58 = r115.optJSONArray("priority_request_config");
        if (r58 == null) goto L206;
        if (r58.length() <= 0) goto L206;
        int r59 = 0;
    L196:
        if (r59 >= r58.length()) goto L206;
        JSONObject r60 = r58.optJSONObject(r59);
        if (r60 == null) goto L205;
        int r61 = r60.optInt("priority");
        Map r62 = r56.d;
        if (r62 == null) goto L202;
        com.bytedance.applog.priority.b r63 = (com.bytedance.applog.priority.b) r62.get(Integer.valueOf(r61));
    L203:
        if (r63 == null) goto L205;
        r63.k.b(r60, r63.d, r63);
        goto L205
    L202:
        r63 = null;
    L205:
        r59 = r59 + 1;
    L206:
        JSONObject r64 = r115.optJSONObject("blocklist");
        if (r64 == null) goto L229;
        JSONArray r65 = r64.optJSONArray("v1");
        if (r65 == null) goto L211;
        int r66 = r65.length();
    L212:
        HashSet r67 = new HashSet(r66);
        int r68 = 0;
    L213:
        if (r68 >= r66) goto L218;
        String r69 = r65.optString(r68, null);
        if (TextUtils.isEmpty(r69) == true) goto L217;
        r67.add(r69);
    L217:
        r68 = r68 + 1;
        goto L213
    L218:
        JSONArray r70 = r64.optJSONArray("v3");
        if (r70 == null) goto L221;
        int r71 = r70.length();
    L222:
        HashSet r72 = new HashSet(r71);
        int r73 = 0;
    L223:
        if (r73 >= r71) goto L228;
        String r74 = r70.optString(r73, null);
        if (TextUtils.isEmpty(r74) == true) goto L227;
        r72.add(r74);
    L227:
        r73 = r73 + 1;
        goto L223
    L228:
        r23.h.addAll(r67);
        r23.i.addAll(r72);
        r38.y.b.getClass();
        goto L229
    L221:
        r71 = 0;
        goto L222
    L211:
        r66 = 0;
    L229:
        JSONObject r75 = r115.optJSONObject("log_back");
        if (r75 == null) goto L233;
        r23.l(null, r75);
    L233:
        if (r115.optInt("forbid_flush", -1) > 0) goto L235;
        boolean r76 = true;
    L236:
        r23.s = r76;
        if (this.b.h0 == false) goto L275;
        b r77 = this.b;
        JSONObject r78 = r115.optJSONObject("applog_forward");
        if (r78 != null) goto L241;
        r29 = r29;
        r115 = r115;
        vw3.a r79 = null;
    L273:
        if (r79 == null) goto L277;
        r23.h(r79);
    L277:
        if (this.b.S1() == null) goto L279;
        this.b.S1().i(r115);
    L279:
        int r80 = r29;
    L282:
        r30 = 200;
    L283:
        if (r80 == r30) goto L285;
        this.b.W.b(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT, 1);
    L285:
        return r80;
    L241:
        vw3.a r81 = new vw3.a();
        r81.a = r78.optInt("version", r114);
        int r82 = r78.optInt("interval", -1);
        if (r82 < 0) goto L244;
        long r117 = ((long) r82) * 1000;
    L245:
        r81.b = r117;
        r81.e = r78.optString("forward_report_path");
        r81.h = null;
        r81.d = r78.optString("forward_report_host");
        r81.h = null;
        r81.f = r78.optInt("forward_open", r114);
        r81.h = null;
        JSONArray r118 = r78.optJSONArray("forward_list");
        if (r118 == null) goto L266;
        ArrayList r119 = new ArrayList();
        int r83 = 0;
    L249:
        if (r83 >= r118.length()) goto L261;
        Object r120 = r118.opt(r83);
        JSONArray r310 = r118;
        if ((r120 instanceof JSONObject) == false) goto L254;
        String r121 = ((JSONObject) r120).optString("forward_report_url");
    L258:
        if (TextUtils.isEmpty(r121) == true) goto L260;
        r119.add(r121);
    L260:
        r83 = r83 + 1;
        r118 = r310;
        goto L249
    L254:
        if ((r120 instanceof String) == false) goto L256;
        r121 = (String) r120;
        goto L258
    L256:
        r121 = null;
        goto L258
    L261:
        ((ArrayList) r81.g).clear();
        if (r119.isEmpty() == true) goto L264;
        ((ArrayList) r81.g).addAll(r119);
    L264:
        r81.h = null;
    L266:
        JSONArray r84 = r78.optJSONArray("events");
        if (r84 == null) goto L272;
        int r122 = 0;
    L270:
        if (r122 >= r84.length()) goto L272;
        ((HashSet) r81.c).add(r84.optString(r122));
        r122 = r122 + 1;
    L272:
        SharedPreferences.Editor r85 = r77.getContext().getSharedPreferences(com.bytedance.applog.a.b(r77, "applog_forward"), 0).edit();
        r85.putInt("version", r81.a);
        r85.putLong("interval", r81.b);
        r85.putStringSet("events", r81.c);
        r85.putString("forward_report_host", r81.d);
        r85.putString("forward_report_path", r81.e);
        r85.putString("forward_list", new JSONArray(r81.g).toString());
        r85.putInt("forward_open", r81.f);
        r85.apply();
        r79 = r81;
        goto L273
    L244:
        r117 = 60000;
        goto L245
    L275:
        r29 = r29;
        r115 = r115;
        goto L277
    L235:
        r76 = false;
        goto L236
    L280:
        r80 = r29;
        goto L283
    L281:
        r80 = r29;
        goto L282
    L139:
        if (r1 >= 600) goto L141;
        r28 = true;
    L144:
        if (404 != r1) goto L146;
        boolean r86 = true;
    L147:
        if (r86 == true) goto L148;
    L150:
        h(r3, r1, null, "Send log error");     // Catch: Throwable -> L153
        r11.setStatusCode(r1);
        r11.end();
        goto L152
    L146:
        r86 = false;
        goto L147
    L132:
        if (r26.contains("lateinit property") == false) goto L134;
        r1 = 15;
        goto L134
    L149:
        r23 = r6;
        r1 = 14;
    L153:
        th = move-exception;
        r11.setStatusCode(r1);
        r11.end();
        throw th;
    L117:
        th = th;
        r3 = r34;
        r1 = 11;
        goto L311
    L286:
        r11.e(r21);     // Catch: Throwable -> L104
        r115 = new JSONObject(r21);     // Catch: Throwable -> L104
        k(r115);     // Catch: Throwable -> L101
        if ("ss_app_log".equals(r115.optString("magic_tag")) == false) goto L98;
        String r87 = r115.optString(r8);     // Catch: Throwable -> L101
        r11.setMessage(r87);     // Catch: Throwable -> L101
        if ("success".equals(r87) == false) goto L305;
        Object r88 = null;
        h(r3, 200, r115.toString().getBytes("UTF-8"), null);     // Catch: Throwable -> L59
        r11.b();     // Catch: Throwable -> L59
        r11.setStatusCode(200);
        r11.end();
        r23 = r6;
        r29 = 200;
        r113 = 1;
        r114 = 0;
    L59:
        th = th;
    L60:
        r11 = r11;
        r16 = r115;
        r22 = r22;
        r6 = r6;
        r5 = r5;
        r110 = r4;
        r3 = r3;
        r7 = r7;
        r8 = r8;
        r1 = 200;
    L61:
        th = th;
        r88 = null;
        goto L60
    L305:
        this.b.V.a("REQUEST_FAILED_RESPONSE_INVALID", r21);     // Catch: Throwable -> L96
        if (r43 == true) goto L67;
    L95:
        r34 = r3;
        r11 = r11;
        r111 = null;
        r16 = r115;
        r22 = r22;
        r6 = r6;
        r5 = r5;
        r110 = r4;
        r1 = 13;
        r7 = r7;
        r8 = r8;
        goto L110
    L67:
        if ("error data".equalsIgnoreCase(r115.optString(r8)) == false) goto L95;
        if (r41.contains(r7) == true) goto L95;
        JSONObject r89 = new JSONObject();     // Catch: Throwable -> L96
        JSONObject r90 = new JSONObject(r41);     // Catch: Throwable -> L86
        String r91 = (String) r17.get(r7);     // Catch: Throwable -> L84
        if (k.g(r91) == false) goto L80;
        if (this.b.v == false) goto L78;
        r91 = "application/octet-stream;tt-data=a";
        goto L80
    L78:
        r91 = "application/json; charset=utf-8";
    L80:
        if ("application/octet-stream;tt-data=a".equalsIgnoreCase(r91) == false) goto L82;
        r90.put(r7, "application/json; charset=utf-8");     // Catch: Throwable -> L84
    L88:
        r22 = r22;
        cx3.a r92 = r11;
        r110 = r4;
        r5 = r5;
        r34 = r3;
        r6 = r6;
        r7 = r7;
        r8 = r8;
        r16 = r115;
        int r93 = g(r36, r37, r38, r39, r40, r90.toString(), r42, false, r44, r45);     // Catch: Throwable -> L93
        r92.setStatusCode(13);
        r92.end();
        return r93;
    L93:
        th = th;
        r11 = r92;
        r1 = 13;
    L103:
        r3 = r34;
        goto L311
    L82:
        r90.put(r7, "application/octet-stream;tt-data=a");     // Catch: Throwable -> L84
    L84:
        th = th;
        r89 = r90;
    L87:
        this.b.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);     // Catch: Throwable -> L96
        this.b.t0.r(11, d, "handle error data failed", th, new Object[0]);     // Catch: Throwable -> L96
        this.b.W.h("handle error data failed", th, true);     // Catch: Throwable -> L96
        r90 = r89;
    L86:
        th = th;
    L96:
        th = th;
        r34 = r3;
        r11 = r11;
        r16 = r115;
        r22 = r22;
        r6 = r6;
        r5 = r5;
        r110 = r4;
        r1 = 13;
        r7 = r7;
        r8 = r8;
        goto L103
    L98:
        r34 = r3;
        r11 = r11;
        r16 = r115;
        r22 = r22;
        r6 = r6;
        r5 = r5;
        r110 = r4;
        r111 = null;
        r7 = r7;
        r8 = r8;
        r1 = 12;
        this.b.V.a("REQUEST_FAILED_RESPONSE_INVALID", r21);     // Catch: Throwable -> L115
        r11.setMessage("resp_magic_tag_error");     // Catch: Throwable -> L115
    L115:
        th = th;
    L101:
        th = th;
        r34 = r3;
        r11 = r11;
        r16 = r115;
        r22 = r22;
        r6 = r6;
        r5 = r5;
        r110 = r4;
        r7 = r7;
        r8 = r8;
        r1 = r20;
    L104:
        th = th;
        r11 = r11;
        r22 = r22;
        r6 = r6;
        r5 = r5;
        r110 = r4;
    L126:
        r1 = r20;
    L119:
        th = th;
        r110 = r4;
        goto L126
    L41:
        r21 = new String(d.f(r19));     // Catch: Throwable -> L121
        goto L307
    L43:
        throw new RuntimeException("get encrypted resp failed");     // Catch: Throwable -> L121
    L44:
        r21 = this.b.getNetClient().post(r4, r37, r17);     // Catch: Throwable -> L121
    L121:
        th = th;
        r110 = r4;
    L123:
        th = th;
        r110 = r4;
        goto L126
    L17:
        r12 = false;
        goto L18
    L13:
        r11 = new cx3.b(r0.f, r9, r4);
        goto L15
    L8:
        if (r0.f.a == false) goto L10;
        r10 = true;
        goto L11
    L156:
        r23 = r6;
        r113 = 1;
        r114 = 0;
        goto L157
    }
}
