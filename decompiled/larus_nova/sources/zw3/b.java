package zw3;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.applog.log.g;
import com.bytedance.applog.log.m;
import com.bytedance.applog.log.n;
import com.bytedance.applog.q;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.obric.sva.sdk.config.ConfigManager;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import nx3.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rw3.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final List<String> f573804v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f573805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f573806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f573807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f573808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedPreferences f573809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile String f573810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile JSONObject f573811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet<String> f573812h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashSet<String> f573813i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile HashSet<String> f573814j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f573815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile com.bytedance.applog.priority.a f573816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final mx3.a f573817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.applog.b f573818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile vw3.a f573819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f573820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile String f573821q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile String f573822r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f573823s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<String, List<String>> f573824t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<String> f573825u;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.applog.priority.a f573826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f573827b;

        @Override // com.bytedance.applog.log.g.b
        public final Object fetch() {
            JSONObject r100 = new JSONObject();
            r100.put("appId", this.f573827b.f573818n.f192413j);     // Catch: Throwable -> L5
            r100.put("config", this.f573826a.f192590g);     // Catch: Throwable -> L5
            r100.put("version", this.f573826a.f192584a);     // Catch: Throwable -> L5
            r100.put("baseInterval", this.f573826a.f192585b);     // Catch: Throwable -> L5
        L4:
            return r100;
        }

        public a(b r100, com.bytedance.applog.priority.a r101) {
            this.f573827b = r100;
            this.f573826a = r101;
        }
    }

    /* JADX INFO: renamed from: zw3.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public class C8498b implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f573828a;

        @Override // com.bytedance.applog.log.g.b
        public final Object fetch() {
            JSONObject r100 = new JSONObject();
            r100.put("appId", this.f573828a.f573818n.f192413j);     // Catch: Throwable -> L5
            r100.put("config", this.f573828a.f573819o.a());     // Catch: Throwable -> L5
        L4:
            return r100;
        }

        public C8498b(b r100) {
            this.f573828a = r100;
        }
    }

    static {
        f573804v = Collections.singletonList(ConfigManager.TAG);
    }

    public final String a() {
        String r100 = this.f573806b.f192811c;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = this.f573806b.f192822n;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L16;
        Bundle r101 = this.f573805a.getPackageManager().getApplicationInfo(this.f573805a.getPackageName(), 128).metaData;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty("UMENG_CHANNEL") == true) goto L17;
        return r101.getString("UMENG_CHANNEL");
    L17:
        return r100;
    L11:
        th = move-exception;
        this.f573818n.f192434t0.s(f573804v, "getChannel failed", th, new Object[0]);
        return r100;
    L16:
        return r100;
    }

    public final long b() {
        long r100 = this.f573815k;
        if (r100 >= 10000) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return r100;
    L11:
        return this.f573809e.getLong("batch_event_interval", 60000);
    L5:
        if (r100 > 300000) goto L7;
        r101 = true;
        goto L8
    }

    public final String c() {
        String r100 = this.f573810f;
        if (TextUtils.isEmpty(r100) == false) goto L11;
        monitor-enter(this);
        r100 = this.f573807c.getString("external_ab_version", "");     // Catch: Throwable -> L8
        this.f573810f = r100;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        return r100;
    }

    public final JSONObject d() {
        String r100 = this.f573809e.getString("log_back", "");
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        return new JSONObject(r100);
    L7:
        th = move-exception;
        this.f573818n.f192434t0.s(null, "json parse to logback failed", th, new Object[0]);
        return null;
    }

    public final boolean e() {
        q r100 = this.f573806b;
        if (r100.f192817i != 0) goto L35;
        Context r101 = this.f573805a;
        String r102 = k.f521052a;
        if (TextUtils.isEmpty(r102) == false) goto L30;
        int r103 = Process.myPid();     // Catch: Exception -> L14
        Iterator<ActivityManager.RunningAppProcessInfo> r104 = ((ActivityManager) r101.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L14
    L9:
        if (r104.hasNext() == false) goto L16;
        ActivityManager.RunningAppProcessInfo r105 = r104.next();     // Catch: Exception -> L14
        if (r105.pid != r103) goto L9;
        k.f521052a = r105.processName;     // Catch: Exception -> L14
    L16:
        String r106 = null;
        BufferedReader r107 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L25
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L24
    L19:
        int r109 = r107.read();     // Catch: Throwable -> L24
        if (r109 <= 0) goto L22;
        r108.append((char) r109);     // Catch: Throwable -> L24
        goto L19
    L22:
        r106 = r108.toString();     // Catch: Throwable -> L24
    L45:
        r107.close();     // Catch: Exception -> L38
    L28:
        k.f521052a = r106;
        n.w().j("getProcessName: {}", new Object[]{k.f521052a});
        r102 = k.f521052a;
    L26:
        if (r107 == null) goto L28;
    L25:
        r107 = null;
    L14:
        e = move-exception;
        e.printStackTrace();
    L30:
        if ((!r102.contains(":")) == false) goto L32;
        int r110 = 1;
    L33:
        r100.f192817i = r110;
        goto L35
    L32:
        r110 = 2;
    L35:
        if (this.f573806b.f192817i != 1) goto L51;
        return true;
    L51:
        return false;
    }

    public Context getContext() {
        return this.f573805a;
    }

    public final HashSet<String> f(JSONArray r100) {
        HashSet<String> r101 = new HashSet();
        if (r100 == null) goto L13;
    L5:
        int r102 = r100.length();     // Catch: Throwable -> L12
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        String r104 = JSONArrayProtectorUtils.getString(r100, r103);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r104) == true) goto L10;
        r101.add(r104);     // Catch: Throwable -> L12
    L10:
        r103 = r103 + 1;
    L11:
        return r101;
    L13:
        r100 = new JSONArray(this.f573809e.getString("real_time_events", "[]"));     // Catch: Throwable -> L12
        goto L5
    }

    public final void g(JSONObject r210) {
        boolean r100 = true;
        this.f573818n.f192434t0.k(0, f573804v, "setConfig: {}", new Object[]{r210});
        this.f573811g = r210;
        long r101 = System.currentTimeMillis();
        SharedPreferences.Editor r102 = this.f573809e.edit();
        long r103 = r210.optInt("session_interval", 0);
        if (r103 > 0) goto L5;
    L7:
        r102.remove("session_interval");
    L8:
        long r104 = ((long) r210.optInt("batch_event_interval", 60)) * 1000;
        if (r104 >= 10000) goto L11;
    L13:
        boolean r110 = false;
    L14:
        if (r110 == false) goto L16;
        r102.putLong("batch_event_interval", r104);
    L17:
        int r105 = r210.optInt("send_launch_timely", 0);
        if (r105 > 0) goto L20;
    L22:
        r102.remove("send_launch_timely");
    L23:
        long r106 = r210.optInt("abtest_fetch_interval", 0);
        if (r106 > 20) goto L26;
    L28:
        r102.remove("abtest_fetch_interval");
    L30:
        if (r210.optBoolean("bav_ab_config", false) == false) goto L32;
        r102.putBoolean("bav_ab_config", true);
    L33:
        JSONArray r107 = r210.optJSONArray("real_time_events");
        if (r107 != null) goto L36;
    L38:
        this.f573814j = new HashSet();
        r102.remove("real_time_events");
    L39:
        int r108 = r210.optInt("http_monitor_port", 0);
        if (r108 <= 0) goto L42;
        r102.putInt("http_monitor_port", r108);
    L42:
        r102.putLong("app_log_last_config_time", r101);
        int r109 = r210.optInt("forbid_report_phone_detail_info", -1);
        if (r109 < 0) goto L48;
        if (r109 <= 0) goto L46;
        boolean r111 = true;
    L47:
        r102.putBoolean("forbid_report_phone_detail_info", r111);
        goto L48
    L46:
        r111 = false;
    L48:
        long r112 = r210.optLong("fetch_interval", 21600) * 1000;
        if (r112 >= 1800000) goto L51;
    L52:
        r112 = 21600000;
    L53:
        r102.putLong("fetch_interval", r112);
        r102.putInt("content_encode_method", r210.optInt("content_encode_method", 0));
        r102.putLong("max_pack_size", r210.optLong("max_pack_size", 0));
        JSONObject r113 = r210.optJSONObject("log_back");
        if (r113 == null) goto L56;
        l(r102, r113);
    L56:
        Object r114 = r210.opt("opaque_payload");
        String r115 = null;
        if (r114 != JSONObject.NULL) goto L59;
        r114 = null;
    L59:
        if (r114 == null) goto L65;
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L63
        r116.put("opaque_payload", r114);     // Catch: Throwable -> L63
        r115 = r116.toString();     // Catch: Throwable -> L63
    L65:
        if (TextUtils.isEmpty(r115) == false) goto L67;
        r102.remove("opaque_payload");
    L69:
        if (r210.optInt("ignore_event_priority", 0) == 1) goto L72;
        r100 = false;
    L72:
        r102.putBoolean("ignore_event_priority", r100);
        if (this.f573818n.f192414j0 == false) goto L76;
        k(r102, r210.optJSONObject("params_block"));
    L76:
        if (this.f573818n.f192416k0 == false) goto L78;
        j(r102, r210.optJSONArray("header_custom_allow"));
    L78:
        r102.apply();
        if (r210.has("monitor_config") == false) goto L82;
        this.f573818n.W.f474687a.b(r210.optJSONObject("monitor_config"));
    L82:
        if (m.b() == true) goto L88;
        m.c("remote_settings", new c(this));
        return;
    L88:
        return;
    L67:
        r102.putString("opaque_payload", r115);
        goto L69
    L51:
        if (r112 <= 172800000) goto L53;
    L36:
        if (r107.length() <= 0) goto L38;
        this.f573814j = f(r107);
        r102.putString("real_time_events", r107.toString());
        goto L39
    L32:
        r102.remove("bav_ab_config");
        goto L33
    L26:
        if (r106 > 604800) goto L28;
        r102.putLong("abtest_fetch_interval", r106 * 1000);
        goto L30
    L20:
        if (r105 > 604800) goto L22;
        r102.putInt("send_launch_timely", r105);
        goto L23
    L16:
        r102.remove("batch_event_interval");
        goto L17
    L11:
        if (r104 > 300000) goto L13;
        r110 = true;
        goto L14
    L5:
        if (r103 > 604800) goto L7;
        r102.putLong("session_interval", r103 * 1000);
        goto L8
    }

    public final void h(vw3.a r100) {
        if (r100 != null) goto L4;
    L6:
        this.f573819o = r100;
        if (this.f573819o == null) goto L14;
        f r101 = this.f573820p;
        if (r101 == null) goto L14;
        if (r101.f539609i == null) goto L14;
        r101.f539609i.sendEmptyMessage(17);
    L14:
        if (this.f573819o != null) goto L16;
        return;
    L16:
        if (m.b() == true) goto L20;
        m.c("forward_config", new C8498b(this));
        return;
    L20:
        return;
    L4:
        if (r100.equals(this.f573819o) == false) goto L6;
    }

    public final void i(com.bytedance.applog.priority.a r110) {
        boolean r100 = false;
        if (this.f573809e.getBoolean("ignore_event_priority", false) == false) goto L6;
        return;
    L6:
        if (r110 == null) goto L39;
        com.bytedance.applog.priority.a r101 = this.f573816l;
        if (r101 != null) goto L11;
    L37:
        boolean r102 = true;
    L38:
        if (r102 == true) goto L39;
    L40:
        this.f573816l = r110;
        if (r100 == false) goto L48;
        f r103 = this.f573820p;
        if (r103 == null) goto L48;
        if (r103.f539609i == null) goto L48;
        r103.f539609i.sendEmptyMessage(17);
    L48:
        if (m.b() == true) goto L59;
        if (r110 == null) goto L60;
        m.c("priority_config", new a(this, r110));
        return;
    L60:
        return;
    L59:
        return;
    L11:
        if (r101.f192585b != r110.f192585b) goto L37;
        Map<Integer, com.bytedance.applog.priority.b> r104 = r110.f192587d;
        Map<Integer, com.bytedance.applog.priority.b> r105 = r101.f192587d;
        if (r104 == null) goto L37;
        if (r105 == null) goto L37;
        if (r104.size() != r105.size()) goto L37;
        Iterator<Map.Entry<Integer, com.bytedance.applog.priority.b>> r106 = r104.entrySet().iterator();
    L22:
        if (r106.hasNext() == false) goto L36;
        Map.Entry<Integer, com.bytedance.applog.priority.b> r107 = r106.next();
        Integer r108 = r107.getKey();
        com.bytedance.applog.priority.b r109 = r107.getValue();
        if (r108 == null) goto L37;
        if (r109 == null) goto L37;
        if (r105.containsKey(r108) == false) goto L37;
        com.bytedance.applog.priority.b r111 = r105.get(r108);
        if (r111 == null) goto L37;
        if (r109.f192595d == r111.f192595d) goto L22;
    L36:
        r102 = false;
    L39:
        r100 = true;
        goto L40
    }

    public final void j(SharedPreferences.Editor r100, JSONArray r101) {
        if (r101 != null) goto L5;
    L20:
        this.f573825u = null;
        if (r100 == null) goto L28;
        r100.remove("header_custom_allow");
        return;
    L28:
        return;
    L5:
        if (r101.length() == 0) goto L20;
        this.f573825u = new ArrayList();
        int r102 = 0;
    L9:
        if (r102 >= r101.length()) goto L14;
        String r103 = r101.optString(r102);
        if (TextUtils.isEmpty(r103) == true) goto L13;
        this.f573825u.add(r103);
    L13:
        r102 = r102 + 1;
        goto L9
    L14:
        f r104 = this.f573820p;
        if (r104 == null) goto L17;
        d r105 = r104.f539608h;
        r105.h(r105.f573835e);
    L17:
        if (r100 == null) goto L27;
        r100.putString("header_custom_allow", r101.toString());
        return;
    }

    public final void k(SharedPreferences.Editor r100, JSONObject r101) {
        if (this.f573824t.isEmpty() == true) goto L5;
        this.f573824t.clear();
    L5:
        if (r101 != null) goto L7;
    L30:
        if (r100 != null) goto L32;
        return;
    L32:
        if (this.f573824t.isEmpty() == false) goto L34;
        r100.remove("params_block");
        return;
    L34:
        r100.putString("params_block", r101.toString());
        return;
    L7:
        if (r101.length() <= 0) goto L30;
        Iterator<String> r102 = r101.keys();
    L10:
        if (r102.hasNext() == false) goto L30;
        String r103 = r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L10;
        JSONArray r104 = r101.optJSONArray(r103);
        if (r104 == null) goto L10;
        if (r104.length() == 0) goto L10;
        HashSet r105 = new HashSet();
        int r106 = 0;
    L21:
        if (r106 >= r104.length()) goto L27;
        String r107 = r104.optString(r106);
        if (TextUtils.isEmpty(r107) == true) goto L25;
        r105.add(r107);
    L25:
        r106 = r106 + 1;
        goto L21
    L27:
        if (r105.isEmpty() == true) goto L10;
        this.f573824t.put(r103, new ArrayList(r105));
        goto L10
    }

    public final void l(SharedPreferences.Editor r100, JSONObject r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        JSONObject r102 = d();
        if (r102 == null) goto L9;
        nx3.f.b(r101, r102);
        r101 = r102;
    L9:
        if (r100 == null) goto L11;
        r100.putString("log_back", r101.toString());
        return;
    L11:
        this.f573809e.edit().putString("log_back", r101.toString()).apply();
    }

    public b(com.bytedance.applog.b r100, Context r101, q r110) {
        this.f573815k = 0;
        this.f573823s = true;
        this.f573824t = new ConcurrentHashMap();
        vw3.a r102 = null;
        this.f573825u = null;
        this.f573818n = r100;
        this.f573805a = r101;
        this.f573806b = r110;
        this.f573809e = r101.getSharedPreferences(r110.f192834z, 0);
        this.f573807c = r101.getSharedPreferences(com.bytedance.applog.a.b(r100, "header_custom"), 0);
        this.f573808d = r101.getSharedPreferences(com.bytedance.applog.a.b(r100, "last_sp_session"), 0);
        this.f573812h = new HashSet();
        this.f573813i = new HashSet();
        this.f573817m = new mx3.a(r100, this, b());
        if (r100.C == false) goto L15;
        List<String> r103 = com.bytedance.applog.priority.c.f192603a;
        SharedPreferences r104 = getContext().getSharedPreferences(com.bytedance.applog.a.b(r100, "priority_list"), 0);
        int r105 = r104.getInt("priority_version", -1);
        if (r105 != (-1)) goto L7;
        com.bytedance.applog.priority.a r106 = null;
    L13:
        i(r106);
        goto L15
    L7:
        r106 = new com.bytedance.applog.priority.a();
        r106.f192584a = r105;
        r106.f192585b = r104.getInt("base_interval", 5);
        String r107 = r104.getString("priorities", null);
        if (TextUtils.isEmpty(r107) == true) goto L13;
        com.bytedance.applog.priority.c.a(r100, this, r106, new JSONArray(r107));     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        r100.f192434t0.s(com.bytedance.applog.priority.c.f192603a, "parseEventPriorityFromLocal failed", e, new Object[0]);
    L15:
        if (r100.f192410h0 == false) goto L52;
        vw3.a r108 = new vw3.a();
        SharedPreferences r109 = r100.getContext().getSharedPreferences(com.bytedance.applog.a.b(r100, "applog_forward"), 0);
        int r111 = r109.getInt("version", -1);
        if (r111 == (-1)) goto L42;
        r108.f557418a = r111;
        r108.f557419b = r109.getLong(VideoThumbInfo.KEY_INTERVAL, 60000);
        r108.f557420c.addAll(r109.getStringSet("events", new HashSet()));
        r108.f557422e = r109.getString("forward_report_path", "");
        r108.f557425h = null;
        r108.f557421d = r109.getString("forward_report_host", "");
        r108.f557425h = null;
        String r112 = r109.getString("forward_list", null);
        if (TextUtils.isEmpty(r112) == false) goto L47;
    L41:
        r108.f557423f = r109.getInt("forward_open", 0);
        r108.f557425h = null;
        r102 = r108;
        goto L42
    L47:
        JSONArray r113 = new JSONArray(r112);     // Catch: Throwable -> L44
        if (r113.length() <= 0) goto L41;
        ArrayList r114 = new ArrayList();     // Catch: Throwable -> L44
        int r115 = 0;
    L25:
        if (r115 >= r113.length()) goto L37;
        Object r116 = r113.opt(r115);     // Catch: Throwable -> L44
        if ((r116 instanceof JSONObject) == false) goto L30;
        String r117 = ((JSONObject) r116).optString("forward_report_url");     // Catch: Throwable -> L44
    L34:
        if (TextUtils.isEmpty(r117) == true) goto L36;
        r114.add(r117);     // Catch: Throwable -> L44
    L36:
        r115 = r115 + 1;     // Catch: Throwable -> L44
        goto L25
    L30:
        if ((r116 instanceof String) == false) goto L32;
        r117 = (String) r116;     // Catch: Throwable -> L44
        goto L34
    L32:
        r117 = null;
        goto L34
    L37:
        ((ArrayList) r108.f557424g).clear();     // Catch: Throwable -> L44
        if (r114.isEmpty() == true) goto L40;
        ((ArrayList) r108.f557424g).addAll(r114);     // Catch: Throwable -> L44
    L40:
        r108.f557425h = null;     // Catch: Throwable -> L44
    L42:
        h(r102);
        return;
    }
}
