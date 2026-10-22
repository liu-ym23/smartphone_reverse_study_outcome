package ex3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.monitor.v3.impl.LatencyMonitor;
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

/* JADX INFO: loaded from: classes.dex */
public final class e implements Handler.Callback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final List<String> f474684m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f474685n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f474686o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f474687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.applog.monitor.v3.impl.a f474688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.applog.monitor.v3.impl.d f474689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.applog.monitor.v3.impl.e f474690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LatencyMonitor f474691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.applog.monitor.v3.impl.c f474692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f474693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f474694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f474695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final dx3.a f474696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f474697k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final JSONObject f474698l;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f474699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f474700b;

        public a(e r100, Thread.UncaughtExceptionHandler r101) {
            this.f474700b = r100;
            this.f474699a = r101;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread r100, Throwable r101) {
            n.w().r(8, e.f474684m, "monitor thread crash!", r101, new Object[0]);
            if (this.f474700b.f474687a.f474645o == false) goto L8;
            Thread.UncaughtExceptionHandler r102 = this.f474699a;
            if (r102 == null) goto L9;
            r102.uncaughtException(r100, r101);
            return;
        L9:
            return;
        }
    }

    static {
        f474684m = Collections.singletonList("MonitorV3Helper");
        f474685n = UUID.randomUUID().toString();
        f474686o = 3590;
    }

    public final boolean g() {
        b r100 = this.f474687a;
        if (r100.f474632b == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f474640j == false) goto L7;
        return true;
    }

    public e() {
        b r100 = new b();
        this.f474687a = r100;
        this.f474688b = new com.bytedance.applog.monitor.v3.impl.a();
        this.f474689c = new com.bytedance.applog.monitor.v3.impl.d(r100);
        this.f474690d = new com.bytedance.applog.monitor.v3.impl.e(r100);
        this.f474691e = new LatencyMonitor();
        this.f474692f = new com.bytedance.applog.monitor.v3.impl.c(r100);
        this.f474693g = new JSONObject();
        this.f474696j = new dx3.a();
        this.f474697k = new AtomicBoolean(false);
        this.f474698l = new JSONObject();
        l("cold_start_id", f474685n);
    }

    public final void a(StatsCountKeys r100) {
        b(r100, 1);
    }

    public final void d(d r110) {
        n.w().k(8, f474684m, "init monitor v3 helper with config: {}", new Object[]{r110});
        if (this.f474697k.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f474695i = r110;
        c r100 = r110.f474671b;
        if (this.f474687a.f474632b == true) goto L8;
    L81:
        this.f474688b.f192509b = 0;
        com.bytedance.applog.monitor.v3.impl.d r101 = this.f474689c;
        r101.getClass();
        n.w().k(8, com.bytedance.applog.monitor.v3.impl.d.f192531h, "init with disabled", new Object[0]);
        r101.f192533b = false;
        r101.f192532a.clear();
        r101.f192538g.set(true);
        com.bytedance.applog.monitor.v3.impl.e r102 = this.f474690d;
        r102.f192545a = false;
        ((ConcurrentHashMap) r102.f192547c).clear();
        this.f474691e.f192501a = false;
        com.bytedance.applog.monitor.v3.impl.c r103 = this.f474692f;
        r103.f192516a = false;
        ((ConcurrentHashMap) r103.f192518c).clear();
        return;
    L8:
        if (r110.getContext() == null) goto L81;
        if (r100 == null) goto L81;
        l("aid", String.valueOf(f474686o));
        l("host_aid", r100.f474646a);
        l("channel", r100.f474647b);
        l("cdid", r100.f474656k);
        l("sdk_version_v2", r100.f474655j);
        l("os", "Android");
        l("os_version", Build.VERSION.RELEASE);
        l("app_name", r100.f474649d);
        l("app_version", r100.f474648c);
        l("update_version_code", String.valueOf(r100.f474650e));
        if (r100.f474651f == false) goto L15;
        i("log_enable", 1);
    L15:
        if (r100.f474657l == false) goto L18;
        i("devtools_enable", 1);
    L18:
        if (r100.f474652g == false) goto L21;
        i("tourist_mode", 1);
    L21:
        if (r100.f474653h == false) goto L24;
        i("frequency_control_enable", 1);
    L24:
        if (r100.f474654i == false) goto L27;
        i("log_event_filter_enable", 1);
    L27:
        if (this.f474687a.f474645o == false) goto L29;
        i("debug_mode", 1);
    L29:
        i("report_interval", r110.f474672c);
        String r104 = r100.f474646a;
        b r105 = this.f474687a;
        Context r106 = r110.getContext();
        r105.getClass();
        if (r106 == null) goto L47;
        SharedPreferences r107 = r106.getSharedPreferences(r104 + "@applog_monitor_config", 0);
        r105.f474631a = r107;
        JSONObject r108 = r105.f474644n;
        if (r108 == null) goto L37;
        if (r107 == null) goto L37;
        r105.b(r108);
    L37:
        if (r107.contains("enabled") == true) goto L39;
        r105.f474632b = b.f474625p;
        r105.f474633c = 1048576;
        r105.f474634d = 10;
        r105.f474635e = true;
        r105.f474636f = true;
        r105.f474637g = b.f474626q;
        r105.f474638h = b.f474627r;
        r105.f474639i = 7;
        r105.f474640j = b.f474628s;
        r105.f474641k = b.f474629t;
        r105.f474642l = b.f474630u;
        r105.f474643m = null;
    L45:
        if (r105.f474645o == false) goto L47;
        r105.c(true);
        goto L47
    L39:
        r105.f474632b = r105.f474631a.getBoolean("enabled", b.f474625p);
        r105.f474633c = r105.f474631a.getInt("max_request_body_size_kb", 1048576);
        r105.f474634d = r105.f474631a.getInt("max_request_count", 10);
        r105.f474635e = r105.f474631a.getBoolean("error_report_enable", true);
        r105.f474636f = r105.f474631a.getBoolean("latency_report_enable", true);
        r105.f474637g = r105.f474631a.getLong("report_interval_ms", b.f474626q);
        r105.f474638h = r105.f474631a.getLong("coldstart_report_delay_ms", b.f474627r);
        r105.f474639i = r105.f474631a.getInt("data_keep_alive_days", 7);
        r105.f474640j = r105.f474631a.getBoolean("sentry_enabled", b.f474628s);
        r105.f474641k = r105.f474631a.getInt("sentry_coldstart_sampling_rate", b.f474629t);
        r105.f474642l = r105.f474631a.getInt("network_coldstart_sampling_rate", b.f474630u);
        String r109 = r105.f474631a.getString("sentry_events", null);
        if (TextUtils.isEmpty(r109) == true) goto L45;
        r105.a(new JSONObject(r109));     // Catch: Throwable -> L43
    L47:
        PthreadHandlerThreadV2 r111 = new PthreadHandlerThreadV2(r100.f474646a + "@applog_monitor_v3");
        r111.setUncaughtExceptionHandler(new a(this, r111.getUncaughtExceptionHandler()));
        ThreadMethodProxy.start(r111);
        Handler r112 = new Handler(r111.getLooper(), this);
        this.f474694h = r112;
        r112.sendEmptyMessageDelayed(1, this.f474687a.f474638h);
        com.bytedance.applog.monitor.v3.impl.a r113 = this.f474688b;
        r110.getContext();
        r113.getClass();
        com.bytedance.applog.monitor.v3.impl.d r114 = this.f474689c;
        Context r115 = r110.getContext();
        r114.getClass();
        com.bytedance.applog.log.i r116 = n.w();
        List<String> r117 = com.bytedance.applog.monitor.v3.impl.d.f192531h;
        r116.k(8, r117, "init with prefix sp: {}.", new Object[]{r104});
        if (r114.f192538g.compareAndSet(false, true) == true) goto L50;
        n.w().p(8, r117, "init failed for already initialized with sp prefix:{}.", new Object[]{r104});
    L79:
        com.bytedance.applog.monitor.v3.impl.e r118 = this.f474690d;
        Context r119 = r110.getContext();
        r118.getClass();
        r118.f192548d = r119.getSharedPreferences(r104 + "@applog_monitor_stats", 0);
        Handler r120 = new Handler(r111.getLooper(), r118);
        r118.f192546b = r120;
        r120.removeMessages(8);
        r118.f192546b.sendEmptyMessageDelayed(8, 500);
        r118.f192546b.sendEmptyMessageDelayed(24, Math.max(10000, r118.f192549e.f474638h - 10000) + ((long) new SecureRandom().nextInt(9000)));
        com.bytedance.applog.monitor.v3.impl.c r121 = this.f474692f;
        Context r122 = r110.getContext();
        r121.getClass();
        r121.f192519d = r122.getSharedPreferences(r104 + "@applog_monitor_network", 0);
        r121.f192516a = h.a(r121.f192520e.f474642l);
        Handler r123 = new Handler(r111.getLooper(), r121);
        r121.f192517b = r123;
        r123.removeMessages(8);
        r121.f192517b.sendEmptyMessageDelayed(8, 500);
        r121.f192517b.sendEmptyMessageDelayed(24, Math.max(10000, r121.f192520e.f474638h - 10000) + ((long) new SecureRandom().nextInt(9000)));
        return;
    L50:
        b r124 = r114.f192536e;
        if (r124.f474640j == true) goto L53;
        n.w().k(8, r117, "init but disabled!!!", new Object[0]);
        r114.f192537f = false;
        r114.f192532a.clear();
        r114.f192533b = false;
        goto L79
    L53:
        r114.f192537f = h.a(r124.f474641k);
        n.w().k(8, r117, "sentry acceptAllEvents = {}", new Object[]{Boolean.valueOf(r114.f192537f)});
        r114.f192535d = r115.getSharedPreferences(r104 + "@applog_monitor_sentry", 0);
        if (r114.d() == false) goto L56;
    L78:
        Handler r125 = new Handler(r111.getLooper(), r114);
        r114.f192534c = r125;
        r125.removeMessages(4);
        r114.f192534c.sendEmptyMessageDelayed(4, 500);
        r114.f192534c.sendEmptyMessageDelayed(12, Math.max(10000, r114.f192536e.f474638h - 10000) + ((long) new SecureRandom().nextInt(9000)));
        goto L79
    L56:
        if (r114.f192532a.isEmpty() == true) goto L78;
        n.w().k(8, r117, "start reset cache map...", new Object[0]);
        if (r114.d() == true) goto L65;
        Map<String, Integer> r126 = r114.f192536e.f474643m;
        if (r126 != null) goto L63;
    L64:
        r114.f192532a.clear();
        goto L78
    L63:
        if (r126.isEmpty() == true) goto L64;
    L65:
        Map<String, com.bytedance.applog.monitor.v3.impl.d.a> r127 = r114.f192532a;
        monitor-enter(r127);
        Iterator<Map.Entry<String, com.bytedance.applog.monitor.v3.impl.d.a>> r128 = r114.f192532a.entrySet().iterator();     // Catch: Throwable -> L75
    L69:
        if (r128.hasNext() == false) goto L73;
        Map.Entry<String, com.bytedance.applog.monitor.v3.impl.d.a> r129 = r128.next();     // Catch: Throwable -> L75
        if (r114.e(r129.getValue().f192540a.f474709a) == true) goto L69;
        r114.f192532a.remove(r129.getKey());     // Catch: Throwable -> L75
        goto L69
    L73:
        monitor-exit(r127);     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        throw th;
    }

    public final boolean e(String r100) {
        if (g() == true) goto L5;
        return false;
    L5:
        com.bytedance.applog.monitor.v3.impl.d r101 = this.f474689c;
        if (r101.d() == false) goto L8;
    L19:
        return true;
    L8:
        if (r101.f192538g.get() == false) goto L19;
        if (r101.e(r100) == false) goto L23;
        Integer r102 = r101.f192536e.f474643m.get(r100);
        if (r102 != null) goto L16;
        return false;
    L16:
        if (r102.intValue() > 0) goto L22;
        return false;
    L22:
        return h.a(r102.intValue());
    L23:
        return false;
    }

    public final boolean f(String r100) {
        if (g() == true) goto L7;
        return false;
    L7:
        return this.f474689c.e(r100);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r110) {
        if (r110.what == 1) goto L6;
    L17:
        return false;
    L6:
        if (this.f474687a.f474632b == false) goto L17;
        d r111 = this.f474695i;
        if (r111 == null) goto L17;
        if (r111.f474673d == null) goto L17;
        if (r111.f474674e == null) goto L17;
        if (TextUtils.isEmpty(r111.f474675f) == true) goto L17;
        n.w().k(8, f474684m, "start doReport...", new Object[0]);
        b r112 = this.f474687a;
        long r100 = r112.f474633c;
        int r101 = r112.f474634d;
        d r113 = this.f474695i;
        r113.f474674e.submit(new f(this, r101, r100, r113.f474673d, r113.f474675f));
        this.f474694h.removeMessages(1);
        this.f474694h.sendEmptyMessageDelayed(1, this.f474687a.f474637g);
        goto L17
    }

    public final void k(String r100) {
        if (this.f474687a.f474632b == true) goto L5;
        return;
    L5:
        n.w().k(8, f474684m, "setHeader {} = {}", new Object[]{"device_id", r100});
        this.f474693g.put("device_id", r100);     // Catch: Throwable -> L8
        return;
    }

    public final void b(StatsCountKeys r100, int r101) {
        if (this.f474687a.f474632b == true) goto L5;
        return;
    L5:
        n.w().k(8, f474684m, "increaseStats {} +{}", new Object[]{r100, Integer.valueOf(r101)});
        this.f474690d.c(r100.name(), r101);
    }

    public final void c(String r100, int r101) {
        if (this.f474687a.f474632b == true) goto L5;
        return;
    L5:
        n.w().k(8, f474684m, "increaseStats {} +{}", new Object[]{r100, Integer.valueOf(r101)});
        this.f474690d.c(r100, r101);
    }

    public final void i(String r100, long r101) {
        if (this.f474687a.f474632b == true) goto L5;
        return;
    L5:
        n.w().k(8, f474684m, "setFeature int {} = {}", new Object[]{r100, Long.valueOf(r101)});
        JSONObject r102 = this.f474698l;
        monitor-enter(r102);
        this.f474698l.put(r100, r101);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        n.w().k(8, f474684m, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void j(String r100, boolean r101) {
        if (this.f474687a.f474632b == true) goto L5;
        return;
    L5:
        n.w().k(8, f474684m, "setFeature boolean {} = {}", new Object[]{r100, Boolean.valueOf(r101)});
        JSONObject r102 = this.f474698l;
        monitor-enter(r102);
        JSONObject r103 = this.f474698l;     // Catch: Throwable -> L13
        if (r101 == false) goto L10;
        int r104 = 1;
    L11:
        r103.put(r100, r104);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
    L10:
        r104 = 0;
    L17:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        n.w().k(8, f474684m, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L17
        goto L15
    }

    public final void l(String r100, String r101) {
        if (this.f474687a.f474632b == true) goto L5;
        return;
    L5:
        n.w().k(8, f474684m, "setStringHeader {}: {}", new Object[]{r100, r101});
        this.f474693g.put(r100, r101);     // Catch: Throwable -> L8
        return;
    }

    public final void h(String r110, Throwable r111, boolean r112) {
        b r100 = this.f474687a;
        if (r100.f474632b == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return;
    L10:
        n.w().k(8, f474684m, "sendError {} -> {}", new Object[]{r110, r111});
        com.bytedance.applog.monitor.v3.impl.a r102 = this.f474688b;
        if (h.a(r102.f192509b) == false) goto L29;
        if (r111 == null) goto L25;
        List<com.bytedance.applog.monitor.v3.impl.a.C2789a> r103 = r102.f192508a;
        String r104 = r111.getClass().getCanonicalName();
        StringBuilder r105 = new StringBuilder();
    L15:
        if (r111 == null) goto L20;
        r105.append(r111.toString());
        StackTraceElement[] r106 = r111.getStackTrace();
        int r107 = r106.length;
        int r108 = 0;
    L17:
        if (r108 >= r107) goto L19;
        StackTraceElement r109 = r106[r108];
        r105.append("\n\tat ");
        r105.append(r109);
        r108 = r108 + 1;
        goto L17
    L19:
        r111 = r111.getCause();
        goto L15
    L20:
        String r113 = r105.toString().replaceAll("[\\s|\\n]", "");
        if (r113.length() <= 200) goto L24;
        r113 = r113.substring(0, 200);
    L24:
        ((CopyOnWriteArrayList) r103).add(new com.bytedance.applog.monitor.v3.impl.a.C2789a(r110, r104, r113));
    L27:
        if (((CopyOnWriteArrayList) r102.f192508a).size() <= 100) goto L29;
        ListProtector.remove(r102.f192508a, 0);
        goto L29
    L25:
        ((CopyOnWriteArrayList) r102.f192508a).add(new com.bytedance.applog.monitor.v3.impl.a.C2789a(r110));
    L29:
        if (r112 == false) goto L34;
        int r114 = bx3.a.f21350a;
        return;
    L34:
        return;
    L5:
        if (r100.f474635e == false) goto L7;
        r101 = true;
        goto L8
    }

    public final void m(EventStage r110, String r111, String r112, long r113, StageEventType r114) {
        n(null, -1, r110, r111, r112, r113, r114);
    }

    public final void n(String r110, int r111, EventStage r112, String r210, String r211, long r212, StageEventType r213) {
        if (g() == true) goto L5;
        return;
    L5:
        dx3.a r100 = this.f474696j;
        if (r100.f470417a.isEmpty() == true) goto L12;
        Iterator<dx3.c> r101 = r100.f470417a.iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        r101.next().a();
    L12:
        n.w().k(8, f474684m, "stageEvent {} -> event: {}, monitor_id: {}, ts: {}, type: {}, priority: {}-{}", new Object[]{r112, r210, r211, Long.valueOf(r212), r213, r110, Integer.valueOf(r111)});
        com.bytedance.applog.monitor.v3.impl.d r102 = this.f474689c;
        if (r102.f192533b == true) goto L15;
    L30:
        n.w().k(8, com.bytedance.applog.monitor.v3.impl.d.f192531h, "stage nothing for disabled!!!", new Object[0]);
        return;
    L15:
        if (r102.f192536e.f474640j == false) goto L30;
        i r103 = new i(r110, r111, r210, r211, r212, r213);
        long r104 = System.currentTimeMillis();
        com.bytedance.applog.monitor.v3.impl.d.a r105 = new com.bytedance.applog.monitor.v3.impl.d.a(r112, r103);
        if (com.bytedance.applog.monitor.v3.impl.d.a.f192539e.contains(r112) == false) goto L25;
        String r106 = r112.toString();     // Catch: JSONException -> L23
        if (r105.f192543d.has(r106) == true) goto L25;
        r105.f192543d.put(r106, r104);     // Catch: JSONException -> L23
    L25:
        if (r102.f192534c != null) goto L27;
    L29:
        r102.a(r105);
        return;
    L27:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L29;
        Handler r107 = r102.f192534c;
        r107.sendMessage(r107.obtainMessage(8, r105));
    }
}
