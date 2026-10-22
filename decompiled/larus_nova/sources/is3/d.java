package is3;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.android.ttcjpaysdk.facelive.utils.CJPayUploadVideoUtil;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.o;
import com.bytedance.apm.util.v;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ws3.f;
import xu3.e;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends hs3.a<js3.a> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static long f495592v = 30000;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f495593w;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f495594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f495595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f495596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile List<String> f495597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Pattern> f495598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f495599l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<Pattern> f495600m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f495601n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f495602o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<String> f495603p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f495604q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f495605r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double f495606s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f495607t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c f495608u;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f495609a = null;

        static {
            f495609a = new d();
        }
    }

    public final boolean j() {
        if (this.f495604q == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f495606s == AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        return true;
    }

    public d() {
        this.f495595h = true;
        this.f495604q = true;
        this.f495605r = false;
    }

    @Override // hs3.a
    public final boolean a(hs3.c r100) {
        js3.a r101 = (js3.a) r100;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f500202d) == true) goto L7;
        return true;
    }

    @Override // hs3.a
    public final void c(hs3.c r110) {
        js3.a r100 = (js3.a) r110;
        String r101 = r100.f500202d;
        String r102 = r100.f500199a;
        boolean r103 = !r100.f500206h.isNull("hit_rules");
        if (r103 == true) goto L39;
        JSONObject r104 = r100.f500206h;
        List<String> r105 = this.f495601n;
        if (e.b(r105) == false) goto L7;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L19;
    L36:
        boolean r107 = false;
    L37:
        if (r107 == true) goto L39;
        return;
    L19:
        if (m.b(com.bytedance.apm.d.getContext()) == false) goto L21;
    L23:
        if (r104 != null) goto L148;
    L30:
        boolean r108 = false;
    L31:
        if (r108 == true) goto L33;
    L35:
        r107 = true;
        goto L37
    L33:
        if (this.f495605r == true) goto L35;
    L148:
        String r109 = r104.optString("cronet_internal_error_code");     // Catch: Exception -> L29
        if ("11".equals(r104.optString("cronet_error_code")) == false) goto L30;
        if (CJPayUploadVideoUtil.ERROR_CODE_FILE_NOT_EXIST.equals(r109) == false) goto L30;
        r108 = true;
        goto L31
    L21:
        if (this.f495607t == true) goto L23;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        String r111 = UriProtector.parse(r101).getHost();     // Catch: Throwable -> L15
        Iterator r112 = ((ArrayList) r105).iterator();     // Catch: Throwable -> L15
    L11:
        if (r112.hasNext() == false) goto L16;
        if (r111.equalsIgnoreCase((String) r112.next()) == false) goto L11;
        r106 = true;
    L39:
        JSONObject r113 = r100.a();
        JSONObject r114 = r100.f500206h;
        if (r113 == null) goto L52;
        if (r114 == null) goto L52;
        if (r114.length() <= 0) goto L52;
        Iterator<String> r115 = r114.keys();     // Catch: JSONException -> L50
    L47:
        if (r115.hasNext() == false) goto L52;
        String r116 = r115.next();     // Catch: JSONException -> L50
        r113.put(r116, r114.get(r116));     // Catch: JSONException -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
    L52:
        if (r113 != null) goto L55;
        return;
    L55:
        if (r103 == false) goto L57;
    L74:
        boolean r117 = true;
    L76:
        if (this.f495604q == false) goto L102;
        String r118 = r100.f500199a;
    L100:
        e = move-exception;
        e.printStackTrace();
        goto L102
    L80:
        if (TextUtils.equals(r118, UploadTypeInf.API_ALL) == false) goto L83;
        r113.put("net_log_type", "api_all_v2");     // Catch: Exception -> L100
    L87:
        if (j() == false) goto L92;
        if (this.f495595h == false) goto L92;
        r113.put("inject_tracelog", HiAnalyticsConstant.KeyAndValue.NUMBER_01);     // Catch: Exception -> L100
    L96:
        double r119 = this.f495606s;     // Catch: Exception -> L100
        if (r119 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L102;
        r113.put("enable_base_api_all", r119);     // Catch: Exception -> L100
    L92:
        if (this.f495594g != 1) goto L96;
        if (this.f495595h == false) goto L96;
        r113.put("inject_tracelog", "02");     // Catch: Exception -> L100
        goto L96
    L83:
        if (TextUtils.equals(r118, UploadTypeInf.API_ERROR) == false) goto L87;
        r113.put("net_log_type", "api_error_v2");     // Catch: Exception -> L100
    L102:
        h(this.f495602o, r113, "requestHeader");
        h(this.f495603p, r113, "responseHeader");
        if (this.f495608u != null) goto L105;
    L142:
        g(r102, r102, r113, r117, true);
        return;
    L105:
        if (UploadTypeInf.API_ALL.equals(r102) == false) goto L142;
        if (r100.f500206h.optBoolean("download", false) == true) goto L142;
        c r120 = this.f495608u;
        JSONObject r121 = r100.f500206h;
        ws3.d r122 = ((ws3.a) r120).f560946a;
        boolean r123 = r122.f560952a;
        if (r123 == false) goto L142;
        if (r123 == false) goto L142;
        if (TextUtils.isEmpty(r101) == true) goto L142;
        if (r121 == null) goto L142;
        if (r121.length() == 0) goto L142;
        String r124 = new URL(r101).getPath();     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r124) == true) goto L142;
        String r125 = r121.optString("net_consume_type", TrafficMetrics.FRPM_TTNET);     // Catch: Throwable -> L145
        JSONObject r126 = r121.optJSONObject("request_log");     // Catch: Throwable -> L145
        if (r126 != null) goto L128;
        String r127 = r121.optString("request_log");     // Catch: Throwable -> L145
        if (TextUtils.isEmpty(r127) == true) goto L128;
        r126 = new JSONObject(r127);     // Catch: Throwable -> L145
    L128:
        JSONObject r128 = r126.optJSONObject("response");     // Catch: Throwable -> L145
        if (r128 == null) goto L131;
        long r129 = r128.optLong(StreamTrafficObservable.STREAM_RECEIVEDBYTES) + r128.optLong(StreamTrafficObservable.STREAM_SENTBYTES);     // Catch: Throwable -> L145
    L132:
        r122.f560961j += r129;     // Catch: Throwable -> L145
        if (r129 <= r122.f560963l) goto L139;
        if (r122.f560960i != null) goto L137;
        r122.f560960i = new v(30);     // Catch: Throwable -> L145
    L137:
        r122.f560960i.a(new ws3.m(r124, r129, r125));     // Catch: Throwable -> L145
    L139:
        if (TextUtils.isEmpty(r101) == false) goto L150;
    L141:
        r122.a(r125, r129, r101);
        f.a.f560973a.a(r129, r124, r125);
        goto L142
    L150:
        r101 = UriProtector.parse(r101).buildUpon().clearQuery().build().toString();     // Catch: Exception -> L144 Throwable -> L145
    L131:
        r129 = 0;
        goto L132
    L57:
        if (TextUtils.equals(r102, UploadTypeInf.API_ALL) == false) goto L66;
        if (j() == false) goto L62;
        i(r101, r113);
    L69:
        boolean r130 = true;
    L71:
        if (r130 == true) goto L74;
        r117 = false;
        goto L76
    L62:
        if (o.a(r101, this.f495597j, this.f495598k) == true) goto L70;
        r130 = i(r101, r113);
    L70:
        r130 = false;
        goto L71
    L66:
        if (TextUtils.equals(r102, UploadTypeInf.API_ERROR) == false) goto L70;
        if (this.f495596i != 1) goto L70;
        goto L69
    }

    @Override // hs3.a
    public final void e(hs3.c r100) {
        js3.a r101 = (js3.a) r100;
        boolean r102 = true;
        if (ActivityLifeObserver.getInstance() != null) goto L6;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L10;
        int r104 = 1;
    L12:
        if (r101.f500206h.isNull(NewBroadcastMonitor.CAPTURE.FRONT) == false) goto L15;
        r101.f500206h.put(NewBroadcastMonitor.CAPTURE.FRONT, r104);     // Catch: JSONException -> L31
    L15:
        if (f495593w == true) goto L18;
    L23:
        r102 = false;
    L24:
        if (r102 == false) goto L27;
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L30
        r105.put("trace_base", com.bytedance.apm.d.f190527o);     // Catch: JSONException -> L30
        r101.f500206h.put("relate_start_trace", r105);     // Catch: JSONException -> L30
    L27:
        if (r101.f500206h.isNull("net_consume_type") == false) goto L36;
        r101.f500206h.put("net_consume_type", TrafficMetrics.FRPM_TTNET);     // Catch: JSONException -> L31
        return;
    L36:
        return;
    L18:
        if (com.bytedance.apm.d.f190527o == 0) goto L23;
        if ((System.currentTimeMillis() - com.bytedance.apm.d.f190527o) <= f495592v) goto L24;
    L10:
        r104 = 0;
        goto L12
    L6:
        r103 = !ActivityLifeObserver.getInstance().isForeground();     // Catch: JSONException -> L31
    }

    public final boolean i(String r100, JSONObject r101) {
        if (j() == false) goto L5;
    L10:
        int r102 = 1;
    L11:
        boolean r103 = zs3.c.f573475a.getServiceSwitch("smart_traffic");
        if (r103 == false) goto L14;
        int r104 = r102 | 4;
    L23:
        r101.put("hit_rules", r104);     // Catch: JSONException -> L17
    L18:
        if (r102 != 0) goto L25;
        if (r103 == true) goto L26;
        return false;
    L26:
        return true;
    L25:
        return true;
    L14:
        r104 = r102;
        goto L23
    L5:
        if (this.f495594g != 0) goto L10;
        if (o.a(r100, this.f495599l, this.f495600m) == true) goto L10;
        r102 = 0;
        goto L11
    }

    @Override // hs3.a, com.bytedance.services.slardar.config.IConfigListener
    public final void onRefresh(JSONObject r100, boolean r110) {
        JSONObject r111 = null;
        if (r100 != null) goto L5;
    L8:
        JSONObject r101 = null;
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty("network") == false) goto L13;
        JSONObject r102 = null;
    L14:
        if (r102 == null) goto L45;
        this.f495597j = o.b(r102, "api_block_list");
        boolean r103 = false;
        JSONArray r104 = r102.optJSONArray("api_block_list");     // Catch: Exception -> L51
        if (r104 == null) goto L26;
        if (r104.length() <= 0) goto L26;
        int r105 = r104.length();     // Catch: Exception -> L51
        ArrayList r106 = new ArrayList(r105);     // Catch: Exception -> L51
        int r107 = 0;
    L21:
        if (r107 >= r105) goto L27;
        String r108 = JSONArrayProtectorUtils.getString(r104, r107);     // Catch: Exception -> L51
        if (TextUtils.isEmpty(r108) == true) goto L25;
        r106.add(PatternProtector.compile(r108));     // Catch: Exception -> L51
    L25:
        r107 = r107 + 1;
    L27:
        this.f495598k = r106;
        this.f495599l = o.c(r102, "api_allow_list");
        JSONObject r109 = r102.optJSONObject("api_allow_list");     // Catch: Exception -> L38
        if (xu3.d.c(r109) == true) goto L39;
        ArrayList r112 = new ArrayList();     // Catch: Exception -> L38
        Iterator<String> r113 = r109.keys();     // Catch: Exception -> L38
    L33:
        if (r113.hasNext() == false) goto L40;
        String r114 = r113.next();     // Catch: Exception -> L38
        if (r109.optInt(r114) != 1) goto L33;
        r112.add(PatternProtector.compile(r114));     // Catch: Exception -> L38
    L40:
        this.f495600m = r112;
        this.f495594g = r102.optInt("enable_api_all_upload", 0);
        this.f495595h = r102.optBoolean("enable_trace_log", true);
        this.f495596i = r102.optInt("enable_api_error_upload", 1);
        if (r102.optInt("enable_cancel_error_report") != 1) goto L43;
        r103 = true;
    L43:
        this.f495605r = r103;
        this.f495602o = o.c(r102, "request_allow_header");
        this.f495603p = o.c(r102, "response_allow_header");
        this.f495606s = r102.optDouble("enable_base_api_all", AudioStats.AUDIO_AMPLITUDE_NONE);
    L39:
        r112 = null;
    L26:
        r106 = null;
    L45:
        if (TextUtils.isEmpty("image") == true) goto L48;
        r111 = r101.optJSONObject("image");
    L48:
        if (r111 == null) goto L65;
        this.f495601n = o.c(r111, "image_allow_list");
        return;
    L65:
        return;
    L13:
        r102 = r101.optJSONObject("network");
        goto L14
    L5:
        if (TextUtils.isEmpty("network_image_modules") == true) goto L8;
        r101 = r100.optJSONObject("network_image_modules");
        goto L9
    }

    public static void h(List r100, JSONObject r101, String r102) {
        if (r100 == null) goto L30;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (TextUtils.isEmpty(r102) == true) goto L31;
        String r103 = r101.optString(r102);     // Catch: JSONException -> L13 Exception -> L19
        if (TextUtils.isEmpty(r103) == true) goto L32;
        JSONObject r104 = new JSONObject(r103);     // Catch: JSONException -> L13 Exception -> L19
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L13 Exception -> L19
        Iterator<String> r106 = r104.keys();     // Catch: JSONException -> L13 Exception -> L19
    L9:
        if (r106.hasNext() == false) goto L15;
        String r107 = r106.next();     // Catch: JSONException -> L13 Exception -> L19
        if (((ArrayList) r100).contains(r107) == false) goto L9;
        r105.put(r107, r104.opt(r107));     // Catch: JSONException -> L13 Exception -> L19
        goto L9
    L15:
        r101.put(r102, r105.toString());     // Catch: JSONException -> L13 Exception -> L19
    L33:
        return;
    L32:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L19
        return;
    L31:
        return;
    }
}
