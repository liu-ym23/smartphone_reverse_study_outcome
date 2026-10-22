package ex3;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static volatile boolean p = true;
    public static volatile long q = 300000;
    public static volatile long r = 30000;
    public static volatile boolean s;
    public static volatile int t;
    public static volatile int u;
    public SharedPreferences a;
    public boolean b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public int k;
    public int l;
    public Map<String, Integer> m;
    public JSONObject n;
    public volatile boolean o;

    public b() {
        this.b = p;
        this.c = 1048576;
        this.d = 10;
        this.e = true;
        this.f = true;
        this.g = q;
        this.h = r;
        this.i = 7;
        this.j = s;
        this.k = t;
        this.l = u;
        this.m = null;
        this.n = null;
        this.o = false;
    }

    public final void a(JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.m.clear();
        Iterator<String> r0 = r5.keys();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        int r2 = r5.optInt(r1, 0);
        if (r2 <= 0) goto L6;
        if (r2 > 10000) goto L6;
        this.m.put(r1, Integer.valueOf(r2));
        goto L6
    }

    public final void b(JSONObject r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SharedPreferences r0 = this.a;
        if (r0 == null) goto L7;
        SharedPreferences.Editor r1 = r0.edit();
    L8:
        boolean r3 = false;
        if (r8.optInt("enabled", p ? 1 : 0) != 1) goto L11;
        boolean r2 = true;
    L12:
        this.b = r2;
        if (r1 == null) goto L16;
        r1.putBoolean("enabled", r2);
    L16:
        if (r8.has("max_request_body_size_kb") == false) goto L21;
        int r5 = r8.optInt("max_request_body_size_kb", 1024) * 1024;
        this.c = r5;
        if (r1 == null) goto L21;
        r1.putInt("max_request_body_size_kb", r5);
    L21:
        if (r8.has("max_request_count") == false) goto L26;
        int r4 = r8.optInt("max_request_count", 10);
        this.d = r4;
        if (r1 == null) goto L26;
        r1.putInt("max_request_count", r4);
    L26:
        if (r8.has("error_report_enable") == false) goto L35;
        if (r8.optInt("error_report_enable", 1) != 1) goto L30;
        boolean r6 = true;
    L31:
        this.e = r6;
        if (r1 == null) goto L35;
        r1.putBoolean("error_report_enable", r6);
        goto L35
    L30:
        r6 = false;
    L35:
        if (r8.has("latency_report_enable") == false) goto L44;
        if (r8.optInt("latency_report_enable", 1) != 1) goto L39;
        boolean r7 = true;
    L40:
        this.f = r7;
        if (r1 == null) goto L44;
        r1.putBoolean("latency_report_enable", r7);
        goto L44
    L39:
        r7 = false;
    L44:
        if (r8.has("report_interval_ms") == false) goto L49;
        long r9 = r8.optLong("report_interval_ms", q);
        this.g = r9;
        if (r1 == null) goto L49;
        r1.putLong("report_interval_ms", r9);
    L49:
        if (r8.has("coldstart_report_delay_ms") == false) goto L54;
        long r10 = r8.optLong("coldstart_report_delay_ms", r);
        this.h = r10;
        if (r1 == null) goto L54;
        r1.putLong("coldstart_report_delay_ms", r10);
    L54:
        if (r8.has("data_keep_alive_days") == false) goto L59;
        int r11 = r8.optInt("data_keep_alive_days", 7);
        this.i = r11;
        if (r1 == null) goto L59;
        r1.putLong("data_keep_alive_days", r11);
    L59:
        if (r8.has("sentry_enabled") == false) goto L67;
        if (r8.optInt("sentry_enabled", s ? 1 : 0) != 1) goto L63;
        r3 = true;
    L63:
        this.j = r3;
        if (r1 == null) goto L67;
        r1.putBoolean("sentry_enabled", r3);
    L67:
        if (r8.has("sentry_coldstart_sampling_rate") == false) goto L72;
        int r12 = r8.optInt("sentry_coldstart_sampling_rate", t);
        this.k = r12;
        if (r1 == null) goto L72;
        r1.putInt("sentry_coldstart_sampling_rate", r12);
    L72:
        if (r8.has("network_coldstart_sampling_rate") == false) goto L77;
        int r13 = r8.optInt("network_coldstart_sampling_rate", u);
        this.l = r13;
        if (r1 == null) goto L77;
        r1.putInt("network_coldstart_sampling_rate", r13);
    L77:
        if (r8.has("sentry_events") == false) goto L81;
        JSONObject r14 = r8.optJSONObject("sentry_events");
        a(r14);
        if (r1 == null) goto L81;
        r1.putString("sentry_events", r14.toString());
    L81:
        if (r1 == null) goto L84;
        r1.apply();
    L84:
        if (this.o == false) goto L87;
        c(true);
        return;
    L87:
        return;
    L11:
        r2 = false;
        goto L12
    L7:
        this.n = r8;
        r1 = null;
        goto L8
    }

    public final void c(boolean r1) {
        if (r1 == true) goto L5;
        this.o = false;
        return;
    L5:
        this.o = true;
        p = true;
        s = true;
        t = 10000;
        u = 10000;
        this.b = p;
        this.j = s;
        this.k = t;
        this.l = u;
        this.m = null;
    }
}
