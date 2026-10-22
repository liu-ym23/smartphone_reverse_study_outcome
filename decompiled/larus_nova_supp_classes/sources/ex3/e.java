package ex3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.log.i;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.monitor.v3.impl.LatencyMonitor;
import com.bytedance.applog.monitor.v3.impl.a;
import com.bytedance.applog.monitor.v3.impl.c;
import com.bytedance.applog.monitor.v3.impl.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e implements Handler.Callback {
    public static final List<String> m = null;
    public static final String n = null;
    public static final int o = 0;
    public final b a;
    public final a b;
    public final d c;
    public final com.bytedance.applog.monitor.v3.impl.e d;
    public final LatencyMonitor e;
    public final c f;
    public final JSONObject g;
    public Handler h;
    public d i;
    public final dx3.a j;
    public final AtomicBoolean k;
    public final JSONObject l;

    static {
        m = Collections.singletonList("MonitorV3Helper");
        n = UUID.randomUUID().toString();
        o = 3590;
    }

    public final boolean g() {
        b r0 = this.a;
        if (r0.b == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.j == false) goto L7;
        return true;
    }

    public e() {
        b r0 = new b();
        this.a = r0;
        this.b = new a();
        this.c = new d(r0);
        this.d = new com.bytedance.applog.monitor.v3.impl.e(r0);
        this.e = new LatencyMonitor();
        this.f = new c(r0);
        this.g = new JSONObject();
        this.j = new dx3.a();
        this.k = new AtomicBoolean(false);
        this.l = new JSONObject();
        l("cold_start_id", n);
    }

    public final void a(StatsCountKeys r2) {
        b(r2, 1);
    }

    public final void d(d r17) {
        n.w().k(8, m, "init monitor v3 helper with config: {}", new Object[]{r17});
        if (this.k.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.i = r17;
        c r2 = r17.b;
        if (this.a.b == true) goto L8;
    L81:
        this.b.b = 0;
        d r0 = this.c;
        r0.getClass();
        n.w().k(8, d.h, "init with disabled", new Object[0]);
        r0.b = false;
        r0.a.clear();
        r0.g.set(true);
        com.bytedance.applog.monitor.v3.impl.e r1 = this.d;
        r1.a = false;
        ((ConcurrentHashMap) r1.c).clear();
        this.e.a = false;
        c r3 = this.f;
        r3.a = false;
        ((ConcurrentHashMap) r3.c).clear();
        return;
    L8:
        if (r17.getContext() == null) goto L81;
        if (r2 == null) goto L81;
        l("aid", String.valueOf(o));
        l("host_aid", r2.a);
        l("channel", r2.b);
        l("cdid", r2.k);
        l("sdk_version_v2", r2.j);
        l("os", "Android");
        l("os_version", Build.VERSION.RELEASE);
        l("app_name", r2.d);
        l("app_version", r2.c);
        l("update_version_code", String.valueOf(r2.e));
        if (r2.f == false) goto L15;
        i("log_enable", 1);
    L15:
        if (r2.l == false) goto L18;
        i("devtools_enable", 1);
    L18:
        if (r2.g == false) goto L21;
        i("tourist_mode", 1);
    L21:
        if (r2.h == false) goto L24;
        i("frequency_control_enable", 1);
    L24:
        if (r2.i == false) goto L27;
        i("log_event_filter_enable", 1);
    L27:
        if (this.a.o == false) goto L29;
        i("debug_mode", 1);
    L29:
        i("report_interval", r17.c);
        String r4 = r2.a;
        b r5 = this.a;
        Context r6 = r17.getContext();
        r5.getClass();
        if (r6 == null) goto L47;
        SharedPreferences r7 = r6.getSharedPreferences(r4 + "@applog_monitor_config", 0);
        r5.a = r7;
        JSONObject r9 = r5.n;
        if (r9 == null) goto L37;
        if (r7 == null) goto L37;
        r5.b(r9);
    L37:
        if (r7.contains("enabled") == true) goto L39;
        r5.b = b.p;
        r5.c = 1048576;
        r5.d = 10;
        r5.e = true;
        r5.f = true;
        r5.g = b.q;
        r5.h = b.r;
        r5.i = 7;
        r5.j = b.s;
        r5.k = b.t;
        r5.l = b.u;
        r5.m = null;
    L45:
        if (r5.o == false) goto L47;
        r5.c(true);
        goto L47
    L39:
        r5.b = r5.a.getBoolean("enabled", b.p);
        r5.c = r5.a.getInt("max_request_body_size_kb", 1048576);
        r5.d = r5.a.getInt("max_request_count", 10);
        r5.e = r5.a.getBoolean("error_report_enable", true);
        r5.f = r5.a.getBoolean("latency_report_enable", true);
        r5.g = r5.a.getLong("report_interval_ms", b.q);
        r5.h = r5.a.getLong("coldstart_report_delay_ms", b.r);
        r5.i = r5.a.getInt("data_keep_alive_days", 7);
        r5.j = r5.a.getBoolean("sentry_enabled", b.s);
        r5.k = r5.a.getInt("sentry_coldstart_sampling_rate", b.t);
        r5.l = r5.a.getInt("network_coldstart_sampling_rate", b.u);
        String r8 = r5.a.getString("sentry_events", null);
        if (TextUtils.isEmpty(r8) == true) goto L45;
        r5.a(new JSONObject(r8));     // Catch: Throwable -> L43
    L47:
        PthreadHandlerThreadV2 r10 = new PthreadHandlerThreadV2(r2.a + "@applog_monitor_v3");
        r10.setUncaughtExceptionHandler(new a(this, r10.getUncaughtExceptionHandler()));
        ThreadMethodProxy.start(r10);
        Handler r11 = new Handler(r10.getLooper(), this);
        this.h = r11;
        r11.sendEmptyMessageDelayed(1, this.a.h);
        a r12 = this.b;
        r17.getContext();
        r12.getClass();
        d r13 = this.c;
        Context r14 = r17.getContext();
        r13.getClass();
        i r15 = n.w();
        List<String> r16 = d.h;
        r15.k(8, r16, "init with prefix sp: {}.", new Object[]{r4});
        if (r13.g.compareAndSet(false, true) == true) goto L50;
        n.w().p(8, r16, "init failed for already initialized with sp prefix:{}.", new Object[]{r4});
    L79:
        com.bytedance.applog.monitor.v3.impl.e r18 = this.d;
        Context r19 = r17.getContext();
        r18.getClass();
        r18.d = r19.getSharedPreferences(r4 + "@applog_monitor_stats", 0);
        Handler r20 = new Handler(r10.getLooper(), r18);
        r18.b = r20;
        r20.removeMessages(8);
        r18.b.sendEmptyMessageDelayed(8, 500);
        r18.b.sendEmptyMessageDelayed(24, Math.max(10000, r18.e.h - 10000) + ((long) new SecureRandom().nextInt(9000)));
        c r21 = this.f;
        Context r22 = r17.getContext();
        r21.getClass();
        r21.d = r22.getSharedPreferences(r4 + "@applog_monitor_network", 0);
        r21.a = h.a(r21.e.l);
        Handler r23 = new Handler(r10.getLooper(), r21);
        r21.b = r23;
        r23.removeMessages(8);
        r21.b.sendEmptyMessageDelayed(8, 500);
        r21.b.sendEmptyMessageDelayed(24, Math.max(10000, r21.e.h - 10000) + ((long) new SecureRandom().nextInt(9000)));
        return;
    L50:
        b r24 = r13.e;
        if (r24.j == true) goto L53;
        n.w().k(8, r16, "init but disabled!!!", new Object[0]);
        r13.f = false;
        r13.a.clear();
        r13.b = false;
        goto L79
    L53:
        r13.f = h.a(r24.k);
        n.w().k(8, r16, "sentry acceptAllEvents = {}", new Object[]{Boolean.valueOf(r13.f)});
        r13.d = r14.getSharedPreferences(r4 + "@applog_monitor_sentry", 0);
        if (r13.d() == false) goto L56;
    L78:
        Handler r25 = new Handler(r10.getLooper(), r13);
        r13.c = r25;
        r25.removeMessages(4);
        r13.c.sendEmptyMessageDelayed(4, 500);
        r13.c.sendEmptyMessageDelayed(12, Math.max(10000, r13.e.h - 10000) + ((long) new SecureRandom().nextInt(9000)));
        goto L79
    L56:
        if (r13.a.isEmpty() == true) goto L78;
        n.w().k(8, r16, "start reset cache map...", new Object[0]);
        if (r13.d() == true) goto L65;
        Map<String, Integer> r26 = r13.e.m;
        if (r26 != null) goto L63;
    L64:
        r13.a.clear();
        goto L78
    L63:
        if (r26.isEmpty() == true) goto L64;
    L65:
        Map<String, d.a> r28 = r13.a;
        monitor-enter(r28);
        Iterator<Map.Entry<String, d.a>> r29 = r13.a.entrySet().iterator();     // Catch: Throwable -> L75
    L69:
        if (r29.hasNext() == false) goto L73;
        Map.Entry<String, d.a> r30 = r29.next();     // Catch: Throwable -> L75
        if (r13.e(r30.getValue().a.a) == true) goto L69;
        r13.a.remove(r30.getKey());     // Catch: Throwable -> L75
        goto L69
    L73:
        monitor-exit(r28);     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        throw th;
    }

    public final boolean e(String r4) {
        if (g() == true) goto L5;
        return false;
    L5:
        d r0 = this.c;
        if (r0.d() == false) goto L8;
    L19:
        return true;
    L8:
        if (r0.g.get() == false) goto L19;
        if (r0.e(r4) == false) goto L23;
        Integer r5 = r0.e.m.get(r4);
        if (r5 != null) goto L16;
        return false;
    L16:
        if (r5.intValue() > 0) goto L22;
        return false;
    L22:
        return h.a(r5.intValue());
    L23:
        return false;
    }

    public final boolean f(String r2) {
        if (g() == true) goto L7;
        return false;
    L7:
        return this.c.e(r2);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r11) {
        if (r11.what == 1) goto L6;
    L17:
        return false;
    L6:
        if (this.a.b == false) goto L17;
        d r12 = this.i;
        if (r12 == null) goto L17;
        if (r12.d == null) goto L17;
        if (r12.e == null) goto L17;
        if (TextUtils.isEmpty(r12.f) == true) goto L17;
        n.w().k(8, m, "start doReport...", new Object[0]);
        b r13 = this.a;
        long r6 = r13.c;
        int r5 = r13.d;
        d r14 = this.i;
        r14.e.submit(new f(this, r5, r6, r14.d, r14.f));
        this.h.removeMessages(1);
        this.h.sendEmptyMessageDelayed(1, this.a.g);
        goto L17
    }

    public final void k(String r7) {
        if (this.a.b == true) goto L5;
        return;
    L5:
        n.w().k(8, m, "setHeader {} = {}", new Object[]{"device_id", r7});
        this.g.put("device_id", r7);     // Catch: Throwable -> L8
        return;
    }

    public final void b(StatsCountKeys r6, int r7) {
        if (this.a.b == true) goto L5;
        return;
    L5:
        n.w().k(8, m, "increaseStats {} +{}", new Object[]{r6, Integer.valueOf(r7)});
        this.d.c(r6.name(), r7);
    }

    public final void c(String r6, int r7) {
        if (this.a.b == true) goto L5;
        return;
    L5:
        n.w().k(8, m, "increaseStats {} +{}", new Object[]{r6, Integer.valueOf(r7)});
        this.d.c(r6, r7);
    }

    public final void i(String r8, long r9) {
        if (this.a.b == true) goto L5;
        return;
    L5:
        n.w().k(8, m, "setFeature int {} = {}", new Object[]{r8, Long.valueOf(r9)});
        JSONObject r0 = this.l;
        monitor-enter(r0);
        this.l.put(r8, r9);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        n.w().k(8, m, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void j(String r8, boolean r9) {
        if (this.a.b == true) goto L5;
        return;
    L5:
        n.w().k(8, m, "setFeature boolean {} = {}", new Object[]{r8, Boolean.valueOf(r9)});
        JSONObject r0 = this.l;
        monitor-enter(r0);
        JSONObject r1 = this.l;     // Catch: Throwable -> L13
        if (r9 == false) goto L10;
        int r10 = 1;
    L11:
        r1.put(r8, r10);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L10:
        r10 = 0;
    L17:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        n.w().k(8, m, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L17
        goto L15
    }

    public final void l(String r6, String r7) {
        if (this.a.b == true) goto L5;
        return;
    L5:
        n.w().k(8, m, "setStringHeader {}: {}", new Object[]{r6, r7});
        this.g.put(r6, r7);     // Catch: Throwable -> L8
        return;
    }

    public final void h(String r12, Throwable r13, boolean r14) {
        b r0 = this.a;
        if (r0.b == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        n.w().k(8, m, "sendError {} -> {}", new Object[]{r12, r13});
        a r2 = this.b;
        if (h.a(r2.b) == false) goto L29;
        if (r13 == null) goto L25;
        List<a.a> r3 = r2.a;
        String r4 = r13.getClass().getCanonicalName();
        StringBuilder r5 = new StringBuilder();
    L15:
        if (r13 == null) goto L20;
        r5.append(r13.toString());
        StackTraceElement[] r6 = r13.getStackTrace();
        int r7 = r6.length;
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L19;
        StackTraceElement r9 = r6[r8];
        r5.append("\n\tat ");
        r5.append(r9);
        r8 = r8 + 1;
        goto L17
    L19:
        r13 = r13.getCause();
        goto L15
    L20:
        String r15 = r5.toString().replaceAll("[\\s|\\n]", XmlPullParser.NO_NAMESPACE);
        if (r15.length() <= 200) goto L24;
        r15 = r15.substring(0, 200);
    L24:
        ((CopyOnWriteArrayList) r3).add(new a.a(r12, r4, r15));
    L27:
        if (((CopyOnWriteArrayList) r2.a).size() <= 100) goto L29;
        ListProtector.remove(r2.a, 0);
        goto L29
    L25:
        ((CopyOnWriteArrayList) r2.a).add(new a.a(r12));
    L29:
        if (r14 == false) goto L34;
        int r16 = bx3.a.a;
        return;
    L34:
        return;
    L5:
        if (r0.e == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void m(EventStage r10, String r11, String r12, long r13, StageEventType r15) {
        n(null, -1, r10, r11, r12, r13, r15);
    }

    public final void n(String r17, int r18, EventStage r19, String r20, String r21, long r22, StageEventType r24) {
        if (g() == true) goto L5;
        return;
    L5:
        dx3.a r2 = this.j;
        if (r2.a.isEmpty() == true) goto L12;
        Iterator<dx3.c> r3 = r2.a.iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        r3.next().a();
    L12:
        n.w().k(8, m, "stageEvent {} -> event: {}, monitor_id: {}, ts: {}, type: {}, priority: {}-{}", new Object[]{r19, r20, r21, Long.valueOf(r22), r24, r17, Integer.valueOf(r18)});
        d r4 = this.c;
        if (r4.b == true) goto L15;
    L30:
        n.w().k(8, d.h, "stage nothing for disabled!!!", new Object[0]);
        return;
    L15:
        if (r4.e.j == false) goto L30;
        i r5 = new i(r17, r18, r20, r21, r22, r24);
        long r6 = System.currentTimeMillis();
        d.a r7 = new d.a(r19, r5);
        if (d.a.e.contains(r19) == false) goto L25;
        String r1 = r19.toString();     // Catch: JSONException -> L23
        if (r7.d.has(r1) == true) goto L25;
        r7.d.put(r1, r6);     // Catch: JSONException -> L23
    L25:
        if (r4.c != null) goto L27;
    L29:
        r4.a(r7);
        return;
    L27:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L29;
        Handler r8 = r4.c;
        r8.sendMessage(r8.obtainMessage(8, r7));
    }
}
