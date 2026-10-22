package ws3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.util.n;
import com.bytedance.apm.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends ss3.a {
    public static final yu3.a<String> A = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f561008x = "bg_never_front";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static os3.g f561009y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final yu3.a<lt3.c> f561010z = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f561011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f561012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f561013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f561014j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f561015k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f561016l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f561017m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f561018n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f561019o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f561020p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f561021q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, n<Long, Long>> f561022r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, n<Long, Long>> f561023s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Map<String, n<Long, Long>> f561024t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f561025u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l f561026v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public JSONObject f561027w;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f561028a = null;

        static {
            f561028a = new k();
        }
    }

    @Override // ss3.a
    public final boolean c() {
        return true;
    }

    @Override // ss3.a
    public final long h() {
        return 600000;
    }

    static {
        f561010z = new yu3.a(20);
        A = new yu3.a(20);
    }

    @Override // ss3.a
    public final void d() {
        SharedPreferences r100 = com.bytedance.apm.d.getContext().getSharedPreferences("traffic_monitor_info", 0);
        long r101 = r100.getLong("init", -1);
        long r110 = r100.getLong("init_ts", 0);
        if (r101 <= (-1)) goto L17;
        long r102 = r100.getLong("usage", 0);
        long r103 = r100.getLong("usage_ts", 0);
        long r104 = r102 - r101;
        if (r104 > 0) goto L24;
    L16:
        k r105 = this;
        SharedPreferences r106 = r100;
    L18:
        r105.f561020p = r105.f561026v.a();
        SharedPreferences.Editor r107 = r106.edit();
        r107.putLong("init", r105.f561020p);
        r107.putLong("init_ts", System.currentTimeMillis());
        r107.putLong("usage", 0);
        r107.apply();
        return;
    L24:
        JSONObject r111 = new JSONObject();     // Catch: JSONException -> L21
        r111.put("total_usage", r104);     // Catch: JSONException -> L21
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L21
        r108.put("total_usage_duration", ((r103 - r110) / 1000) / 60);     // Catch: JSONException -> L21
        JSONObject r109 = new JSONObject();     // Catch: JSONException -> L21
        r109.put("init_ts", r110);     // Catch: JSONException -> L21
        r109.put("usage_ts", r103);     // Catch: JSONException -> L21
        r106 = r100;
        r109.put("biz_usage", r106.getLong("biz_usage", 0));     // Catch: JSONException -> L15
        r109.put("init", r101);     // Catch: JSONException -> L15
        r109.put("usage", r102);     // Catch: JSONException -> L15
        String r112 = r106.getString("biz_json", "");     // Catch: JSONException -> L15
        if (r112 == "") goto L11;
        JSONObject r113 = new JSONObject();     // Catch: JSONException -> L15
        r113.put("usage", new JSONArray(r112));     // Catch: JSONException -> L15
        r109.put("detail", r113);     // Catch: JSONException -> L15
    L11:
        js3.e r114 = new js3.e();     // Catch: JSONException -> L15
        r105 = this;
        r114.f500217a = r105.f543336e;     // Catch: JSONException -> L20
        r114.f500220d = r111;     // Catch: JSONException -> L20
        r114.f500221e = r108;     // Catch: JSONException -> L20
        r114.f500223g = r109;     // Catch: JSONException -> L20
        ss3.a.g(r114);     // Catch: JSONException -> L20
        os3.g r115 = f561009y;     // Catch: JSONException -> L20
    L15:
        r105 = this;
        goto L18
    L17:
        r105 = this;
        r106 = r100;
        goto L18
    }

    @Override // ss3.a
    public final void e() {
        if (this.f543333b == true) goto L5;
        f561008x = "bg_ever_front";
    L5:
        long r100 = System.currentTimeMillis();
        long r101 = this.f561026v.a();
        long r102 = this.f561026v.f561029a.b();
        long r103 = this.f561026v.f561029a.l();
        long r110 = this.f561026v.f561029a.a();
        long r111 = this.f561026v.f561029a.j();
        if (this.f561014j != (-1)) goto L9;
        this.f561014j = r101;
        this.f561015k = r102;
        this.f561016l = r103;
        this.f561017m = r110;
        this.f561018n = r111;
        this.f561019o = r100;
        return;
    L9:
        JSONArray r104 = new JSONArray();
        long r112 = r101 - this.f561014j;
        long r105 = r102 - this.f561015k;
        long r106 = r103 - this.f561016l;
        long r107 = r110 - this.f561017m;
        long r108 = r111 - this.f561018n;
        long r109 = this.f561011g;
        if (r109 > 0) goto L12;
    L14:
        long r113 = this.f561013i;
        if (r113 > 0) goto L17;
    L22:
        d r114 = d.b.f560968a;
        v<m> r115 = r114.f560960i;
        if (r115 == null) goto L28;
        if (r115.f190691a.size() <= 0) goto L28;
        r104.put("large_request");
    L28:
        if (f.a.f560973a.f560972d <= this.f561021q) goto L30;
        r104.put("high_feq_request");
    L30:
        this.f561014j = r101;
        this.f561018n = r111;
        this.f561017m = r110;
        this.f561015k = r102;
        this.f561016l = r103;
        JSONArray r116 = new JSONArray();
        zs3.c.a(this.f543336e);
        i(r114.f560954c, "usage_10_minutes", r116);
        i(r114.f560956e, "wifi_front", r116);
        i(r114.f560955d, "wifi_back", r116);
        i(r114.f560958g, "mobile_front", r116);
        i(r114.f560957f, "mobile_back", r116);
        JSONObject r117 = new JSONObject();
        if (r116.length() > 0) goto L114;
    L112:
        JSONObject r118 = new JSONObject();     // Catch: JSONException -> L66
        r118.put("usage_10_minutes", r112);     // Catch: JSONException -> L66
        r118.put("mobile_back", r105);     // Catch: JSONException -> L66
        r118.put("mobile_front", r106);     // Catch: JSONException -> L66
        r118.put("wifi_back", r107);     // Catch: JSONException -> L66
        long r310 = r101;
        r118.put("wifi_front", r108);     // Catch: JSONException -> L108
        os3.g r119 = f561009y;     // Catch: JSONException -> L108
        if (r119 == null) goto L38;
        ((com.ss.android.lark.monitor.traffic.l.a) r119).a(r112, r107, r108, r105, r106);     // Catch: JSONException -> L108
    L38:
        JSONObject r120 = new JSONObject();     // Catch: JSONException -> L108
        js3.e r121 = new js3.e();     // Catch: JSONException -> L108
        JSONObject r122 = new JSONObject();     // Catch: JSONException -> L108
        r122.put("detail", r117);     // Catch: JSONException -> L108
        r122.put("biz_usage", d.b.f560968a.f560961j);     // Catch: JSONException -> L108
        r122.put("init_ts", this.f561019o);     // Catch: JSONException -> L108
        r122.put("usage_ts", r100);     // Catch: JSONException -> L108
        r121.f500217a = this.f543336e;     // Catch: JSONException -> L108
        r121.f500221e = r120;     // Catch: JSONException -> L108
        r121.f500220d = r118;     // Catch: JSONException -> L108
        r121.f500223g = r122;     // Catch: JSONException -> L108
        ss3.a.g(r121);     // Catch: JSONException -> L108
        this.f561019o = r100;     // Catch: JSONException -> L108
        if (r104.length() <= 0) goto L67;
        JSONObject r123 = new JSONObject();     // Catch: JSONException -> L108
        r123.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, true);     // Catch: JSONException -> L108
        r123.put("exception_type", r104);     // Catch: JSONException -> L108
        f r124 = f.a.f560973a;     // Catch: JSONException -> L108
        monitor-enter(r124);     // Catch: JSONException -> L108
        Map<String, m> r125 = r124.f560970b;     // Catch: Throwable -> L61
        monitor-exit(r124);     // Catch: JSONException -> L108
        if (r125 == null) goto L52;
        Iterator r126 = ((HashMap) r125).entrySet().iterator();     // Catch: JSONException -> L108
        JSONArray r127 = new JSONArray();     // Catch: JSONException -> L108
    L47:
        if (r126.hasNext() == false) goto L51;
        Map.Entry r128 = (Map.Entry) r126.next();     // Catch: JSONException -> L108
        if (((m) r128.getValue()).f561034d <= this.f561021q) goto L47;
        JSONObject r129 = new JSONObject();     // Catch: JSONException -> L108
        r129.put("path", ((m) r128.getValue()).f561031a);     // Catch: JSONException -> L108
        r129.put("freq", ((m) r128.getValue()).f561034d);     // Catch: JSONException -> L108
        r129.put("biz", ((m) r128.getValue()).f561032b);     // Catch: JSONException -> L108
        r127.put(r129);     // Catch: JSONException -> L108
        goto L47
    L51:
        r117.put("high_freq", r127);     // Catch: JSONException -> L108
    L52:
        if (r115 == null) goto L60;
        ArrayList r130 = (ArrayList) r115.b();     // Catch: JSONException -> L108
        if (r130.size() <= 0) goto L60;
        JSONArray r131 = new JSONArray();     // Catch: JSONException -> L108
        Iterator r132 = r130.iterator();     // Catch: JSONException -> L108
    L57:
        if (r132.hasNext() == false) goto L59;
        m r133 = (m) r132.next();     // Catch: JSONException -> L108
        JSONObject r134 = new JSONObject();     // Catch: JSONException -> L108
        r134.put("path", r133.f561031a);     // Catch: JSONException -> L108
        r134.put("usage", r133.f561033c);     // Catch: JSONException -> L108
        r134.put("biz", r133.f561032b);     // Catch: JSONException -> L108
        r131.put(r134);     // Catch: JSONException -> L108
        goto L57
    L59:
        r117.put("large_usage", r131);     // Catch: JSONException -> L108
    L60:
        r123.put("biz_usage", d.b.f560968a.f560961j);     // Catch: JSONException -> L108
        r123.put("detail", r117);     // Catch: JSONException -> L108
        js3.e r135 = new js3.e();     // Catch: JSONException -> L108
        r135.f500217a = this.f543336e;     // Catch: JSONException -> L108
        r135.f500221e = r120;     // Catch: JSONException -> L108
        r135.f500220d = r118;     // Catch: JSONException -> L108
        r135.f500223g = r123;     // Catch: JSONException -> L108
        ss3.a.g(r135);     // Catch: JSONException -> L108
        goto L67
    L61:
        th = move-exception;
        throw th;     // Catch: JSONException -> L108
    L67:
        SharedPreferences.Editor r136 = com.bytedance.apm.d.getContext().getSharedPreferences("traffic_monitor_info", 0).edit();
        r136.putLong("usage", r310);
        long r137 = this.f561025u;
        d r138 = d.b.f560968a;
        long r139 = r137 + r138.f560961j;
        this.f561025u = r139;
        r136.putLong("biz_usage", r139);
        r136.putLong("usage_ts", System.currentTimeMillis());
        Map<String, d.a> r140 = r138.f560959h;
        if (r140 == null) goto L78;
        HashMap r141 = (HashMap) r140;
        if (r141.size() <= 0) goto L78;
        JSONArray r142 = new JSONArray();
        Iterator r143 = r141.entrySet().iterator();
    L73:
        if (r143.hasNext() == false) goto L77;
        JSONObject r144 = ((d.a) ((Map.Entry) r143.next()).getValue()).b();
        r144.put("traffic_category", "total_usage");     // Catch: Exception -> L107
    L76:
        r142.put(r144);
        goto L73
    L77:
        r136.putString("biz_json", r142.toString());
    L78:
        r136.apply();
        if (com.bytedance.apm.d.j() == false) goto L81;
        d r145 = d.b.f560968a;
    L81:
        d r146 = d.b.f560968a;
        Map<String, d.a> r147 = r146.f560954c;
        if (r147 == null) goto L84;
        ((HashMap) r147).clear();
    L84:
        Map<String, d.a> r148 = r146.f560955d;
        if (r148 == null) goto L87;
        ((HashMap) r148).clear();
    L87:
        Map<String, d.a> r149 = r146.f560956e;
        if (r149 == null) goto L90;
        ((HashMap) r149).clear();
    L90:
        Map<String, d.a> r150 = r146.f560957f;
        if (r150 == null) goto L93;
        ((HashMap) r150).clear();
    L93:
        Map<String, d.a> r151 = r146.f560958g;
        if (r151 == null) goto L96;
        ((HashMap) r151).clear();
    L96:
        v<m> r152 = r146.f560960i;
        if (r152 == null) goto L99;
        r152.f190691a.clear();
    L99:
        r146.f560961j = 0;
        f r153 = f.a.f560973a;
        r153.getClass();
        r153.f560972d = 0;
        Map<String, m> r154 = r153.f560969a;
        if (r154 == null) goto L102;
        ((HashMap) r154).clear();
        r153.f560969a = null;
    L102:
        Map<String, m> r155 = r153.f560970b;
        if (r155 == null) goto L126;
        ((HashMap) r155).clear();
        r153.f560970b = null;
        return;
    L126:
        return;
    L66:
        r310 = r101;
        goto L67
    L114:
        r117.put("usage", r116);     // Catch: Exception -> L106
        goto L112
    L17:
        if ((r105 + r107) <= r113) goto L22;
        if (TextUtils.equals(f561008x, "bg_never_front") == false) goto L21;
        r104.put("never_front_usage_abnormal");
        goto L22
    L21:
        r104.put("bg_usage_abnormal");
        goto L22
    L12:
        if (r112 <= r109) goto L14;
        r104.put("total_usage_abnormal");
        goto L22
    }

    public k() {
        this.f561011g = 500000000;
        this.f561012h = 0;
        this.f561013i = 1;
        this.f561014j = -1;
        this.f561015k = 0;
        this.f561016l = 0;
        this.f561017m = 0;
        this.f561018n = 0;
        this.f561020p = 0;
        this.f543336e = "traffic";
        l r100 = l.a.f561030a;
        this.f561026v = r100;
        boolean r101 = this.f543333b;
        r100.f561029a.d(r101);
    }

    @Override // ss3.a
    public final void a(JSONObject r100) {
        if (r100.optInt("cause_analysis", 0) != 1) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        d r102 = d.b.f560968a;
        r102.f560952a = true;
        r102.f560953b = true;
        is3.d.a.f495609a.f495608u = new ws3.a();
        is3.a.h().f495591g = new b();
        this.f561011g = (r100.optInt("exception_threshold_mb", 500) * 1000) * 1000;
        this.f561013i = (r100.optInt("exception_threshold_bg_mb", 500) * 1000) * 1000;
        this.f561021q = r100.optInt("high_freq_threshold", 200);
        r102.f560963l = (r100.optDouble("large_usage_threshold_mb", 10.0d) * 1000.0d) * 1000.0d;
        r102.f560964m = r100.optDouble("alog_record_threshold", 100.0d);
    L8:
        this.f561012h = r100.optLong("record_usage_kb", 1) * 1024;
        boolean r103 = zs3.c.a(this.f543336e);
    L9:
        yu3.a<lt3.c> r104 = f561010z;
        if (r104.a() == true) goto L33;
        lt3.c r105 = r104.b();
        String r106 = A.b();
        if (r103 == false) goto L14;
    L19:
        boolean r107 = jt3.a.f500287a;
        if (r105 == null) goto L24;
        nu3.b.a(r105);
    L24:
        if (com.bytedance.apm.d.j() == false) goto L9;
        String[] r108 = new String[1];
        StringBuilder r109 = new StringBuilder("isSample:key:");
        if (r103 == false) goto L28;
    L31:
        boolean r110 = true;
    L32:
        r109.append(r110);
        r108[0] = r109.toString();
        ps3.b.a(r108);
        goto L9
    L28:
        if (r100.optInt(r106, 0) == 1) goto L31;
        r110 = false;
        goto L32
    L14:
        if (r100.optInt(r106, 0) == 1) goto L19;
        if (com.bytedance.apm.d.j() == false) goto L24;
        ls3.a.a(r105.f510668a, r105.f510669b, false);
        goto L24
    L33:
        this.f561027w = r100;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // ss3.a, ff7.c
    public final void onBackground(Activity r100) {
        super.onBackground(r100);
        this.f561026v.f561029a.d(true);
    }

    @Override // ss3.a, ff7.c
    public final void onFront(Activity r100) {
        super.onFront(r100);
        f561008x = "bg_ever_front";
        this.f561026v.f561029a.d(false);
    }

    public final void i(Map r100, String r101, JSONArray r102) {
        if (r100 == null) goto L15;
        HashMap r103 = (HashMap) r100;
        if (r103.size() != 0) goto L17;
        return;
    L17:
        Iterator r104 = r103.entrySet().iterator();     // Catch: Exception -> L16
    L8:
        if (r104.hasNext() == false) goto L24;
        JSONObject r105 = ((d.a) ((Map.Entry) r104.next()).getValue()).c(this.f561012h);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r101) == true) goto L13;
        r105.put("traffic_category", r101);     // Catch: Exception -> L16
    L13:
        r102.put(r105);     // Catch: Exception -> L16
        goto L8
    L24:
        return;
    L23:
        return;
    }
}
