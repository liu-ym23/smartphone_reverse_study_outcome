package ex3;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f474625p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile long f474626q = 300000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile long f474627r = 30000;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile boolean f474628s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile int f474629t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile int f474630u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f474631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f474632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f474633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f474634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f474635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f474636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f474637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f474638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f474639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f474640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f474641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f474642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, Integer> f474643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JSONObject f474644n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f474645o;

    public b() {
        this.f474632b = f474625p;
        this.f474633c = 1048576;
        this.f474634d = 10;
        this.f474635e = true;
        this.f474636f = true;
        this.f474637g = f474626q;
        this.f474638h = f474627r;
        this.f474639i = 7;
        this.f474640j = f474628s;
        this.f474641k = f474629t;
        this.f474642l = f474630u;
        this.f474643m = null;
        this.f474644n = null;
        this.f474645o = false;
    }

    public final void a(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f474643m.clear();
        Iterator<String> r101 = r100.keys();
    L6:
        if (r101.hasNext() == false) goto L12;
        String r102 = r101.next();
        int r103 = r100.optInt(r102, 0);
        if (r103 <= 0) goto L6;
        if (r103 > 10000) goto L6;
        this.f474643m.put(r102, Integer.valueOf(r103));
        goto L6
    }

    public final void b(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SharedPreferences r101 = this.f474631a;
        if (r101 == null) goto L7;
        SharedPreferences.Editor r102 = r101.edit();
    L8:
        boolean r103 = false;
        if (r100.optInt("enabled", f474625p ? 1 : 0) != 1) goto L11;
        boolean r104 = true;
    L12:
        this.f474632b = r104;
        if (r102 == null) goto L16;
        r102.putBoolean("enabled", r104);
    L16:
        if (r100.has("max_request_body_size_kb") == false) goto L21;
        int r105 = r100.optInt("max_request_body_size_kb", 1024) * 1024;
        this.f474633c = r105;
        if (r102 == null) goto L21;
        r102.putInt("max_request_body_size_kb", r105);
    L21:
        if (r100.has("max_request_count") == false) goto L26;
        int r106 = r100.optInt("max_request_count", 10);
        this.f474634d = r106;
        if (r102 == null) goto L26;
        r102.putInt("max_request_count", r106);
    L26:
        if (r100.has("error_report_enable") == false) goto L35;
        if (r100.optInt("error_report_enable", 1) != 1) goto L30;
        boolean r107 = true;
    L31:
        this.f474635e = r107;
        if (r102 == null) goto L35;
        r102.putBoolean("error_report_enable", r107);
        goto L35
    L30:
        r107 = false;
    L35:
        if (r100.has("latency_report_enable") == false) goto L44;
        if (r100.optInt("latency_report_enable", 1) != 1) goto L39;
        boolean r108 = true;
    L40:
        this.f474636f = r108;
        if (r102 == null) goto L44;
        r102.putBoolean("latency_report_enable", r108);
        goto L44
    L39:
        r108 = false;
    L44:
        if (r100.has("report_interval_ms") == false) goto L49;
        long r109 = r100.optLong("report_interval_ms", f474626q);
        this.f474637g = r109;
        if (r102 == null) goto L49;
        r102.putLong("report_interval_ms", r109);
    L49:
        if (r100.has("coldstart_report_delay_ms") == false) goto L54;
        long r110 = r100.optLong("coldstart_report_delay_ms", f474627r);
        this.f474638h = r110;
        if (r102 == null) goto L54;
        r102.putLong("coldstart_report_delay_ms", r110);
    L54:
        if (r100.has("data_keep_alive_days") == false) goto L59;
        int r111 = r100.optInt("data_keep_alive_days", 7);
        this.f474639i = r111;
        if (r102 == null) goto L59;
        r102.putLong("data_keep_alive_days", r111);
    L59:
        if (r100.has("sentry_enabled") == false) goto L67;
        if (r100.optInt("sentry_enabled", f474628s ? 1 : 0) != 1) goto L63;
        r103 = true;
    L63:
        this.f474640j = r103;
        if (r102 == null) goto L67;
        r102.putBoolean("sentry_enabled", r103);
    L67:
        if (r100.has("sentry_coldstart_sampling_rate") == false) goto L72;
        int r112 = r100.optInt("sentry_coldstart_sampling_rate", f474629t);
        this.f474641k = r112;
        if (r102 == null) goto L72;
        r102.putInt("sentry_coldstart_sampling_rate", r112);
    L72:
        if (r100.has("network_coldstart_sampling_rate") == false) goto L77;
        int r113 = r100.optInt("network_coldstart_sampling_rate", f474630u);
        this.f474642l = r113;
        if (r102 == null) goto L77;
        r102.putInt("network_coldstart_sampling_rate", r113);
    L77:
        if (r100.has("sentry_events") == false) goto L81;
        JSONObject r114 = r100.optJSONObject("sentry_events");
        a(r114);
        if (r102 == null) goto L81;
        r102.putString("sentry_events", r114.toString());
    L81:
        if (r102 == null) goto L84;
        r102.apply();
    L84:
        if (this.f474645o == false) goto L87;
        c(true);
        return;
    L87:
        return;
    L11:
        r104 = false;
        goto L12
    L7:
        this.f474644n = r100;
        r102 = null;
        goto L8
    }

    public final void c(boolean r100) {
        if (r100 == true) goto L5;
        this.f474645o = false;
        return;
    L5:
        this.f474645o = true;
        f474625p = true;
        f474628s = true;
        f474629t = 10000;
        f474630u = 10000;
        this.f474632b = f474625p;
        this.f474640j = f474628s;
        this.f474641k = f474629t;
        this.f474642l = f474630u;
        this.f474643m = null;
    }
}
