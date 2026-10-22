package fna;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.Npth;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.performance.power.monitor.battery.BatteryMonitor;
import com.obric.performance.power.monitor.constants.ObricPerformancePowerMonitorConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.videoarch.strategy.featureCenter.featureType.TypeDeviceFeaturesCollector;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f478034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f478035b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ObricPerformancePowerMonitorConfig f478036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f478037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static kna.d f478038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static kna.c f478039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f478040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f478041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f478042i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f478043j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f478044k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f478045l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f478046m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile boolean f478047n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f478048o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile boolean f478049p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f478050q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static com.obric.performance.power.monitor.cpu.a f478051r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static float f478052s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int f478053t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static float f478054u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static int f478055v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Lazy f478056w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f478057x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c f478058y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final b f478059z = null;

    public static final class a implements BatteryMonitor.a {
        public a() {
        }

        @Override // com.obric.performance.power.monitor.battery.BatteryMonitor.a
        public final void a(boolean r100) {
            if (g.f478049p == true) goto L5;
        L7:
            ILogDepend.f384986a.d("PowerMonitor", "reportRunnable onChargeChanged " + r100);
            return;
        L5:
            if (g.f478046m == r100) goto L7;
            g.f478047n = true;
            goto L7
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            if (g.f478049p == false) goto L15;
            Context r100 = g.f478037d;     // Catch: Exception -> L9
            if (r100 == null) goto L11;
            g.f478054u += mna.a.a(r100);     // Catch: Exception -> L9
            g.f478055v++;     // Catch: Exception -> L9
        L11:
            g.b().postDelayed(this, g.f478036c.getCollectCurrentIntervalMillis());
            return;
        L9:
            e = move-exception;
            ILogDepend.f384986a.d("PowerMonitor", "onCollectOnlyFront: " + e.getMessage());
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        public final void a() {
            if (g.f478049p == false) goto L144;
            Lazy r100 = g.f478034a;
            ILogDepend.Companion r101 = ILogDepend.f384986a;
            r101.d("PowerMonitor", "performTask start");
            com.obric.performance.power.monitor.cpu.a r102 = g.f478051r;
            if (r102 == null) goto L7;
            r102.a();
        L7:
            com.obric.performance.power.monitor.cpu.a r103 = g.f478051r;
            if (r103 == null) goto L10;
            int r104 = r103.b();
        L11:
            com.obric.performance.power.monitor.cpu.a r105 = g.f478051r;
            if (r105 == null) goto L16;
            com.obric.performance.power.monitor.cpu.c r106 = r105.f403815h;
            if (r106 == null) goto L16;
            long r107 = r106.f403820e;
        L17:
            if (r105 == null) goto L21;
            com.obric.performance.power.monitor.cpu.c r110 = r105.f403815h;
            if (r110 == null) goto L21;
            long r111 = r110.f403821f;
        L22:
            if (r105 == null) goto L26;
            com.obric.performance.power.monitor.cpu.c r108 = r105.f403815h;
            if (r108 == null) goto L26;
            long r112 = r108.f403824i;
        L27:
            JSONObject r109 = new JSONObject();
            int r113 = g.f478055v;
            if (r113 <= 0) goto L30;
            r109.put("device_current", Float.valueOf(g.f478054u / r113));
        L30:
            g.a().getClass();
            r109.put(TypeDeviceFeaturesCollector.BATTERY_TEMPERATURE, Float.valueOf(BatteryMonitor.f403803g));
            g.a().getClass();
            r109.put("battery_level", Float.valueOf(BatteryMonitor.f403801e));
            if (g.f478052s <= 0.0f) goto L33;
            g.a().getClass();
            r109.put("battery_level_change", Float.valueOf(BatteryMonitor.f403801e - g.f478052s));
        L33:
            g.a().getClass();
            g.f478052s = BatteryMonitor.f403801e;
            g.a().getClass();
            r109.put("battery_change_counter_uah", BatteryMonitor.f403804h);
            if (g.f478053t <= 0) goto L36;
            g.a().getClass();
            r109.put("battery_change_counter_uah_change", BatteryMonitor.f403804h - g.f478053t);
        L36:
            g.a().getClass();
            g.f478053t = BatteryMonitor.f403804h;
            r109.put("cpu_core_count", r104);
            r109.put("device_cpu_time", r107);
            r109.put("device_idle_time", r111);
            com.obric.performance.power.monitor.cpu.a r114 = g.f478051r;
            if (r114 == null) goto L41;
            com.obric.performance.power.monitor.cpu.c r115 = r114.f403815h;
            if (r115 == null) goto L41;
            Object r116 = Double.valueOf(r115.f403819d);
        L42:
            r109.put("device_cpu_usage", r116);
            if (r112 <= 0) goto L46;
            if (r104 <= 0) goto L46;
            r109.put("device_cpu_speed", Float.valueOf(((r107 - r111) / r112) / r104));
        L46:
            com.obric.performance.power.monitor.cpu.a r117 = g.f478051r;
            if (r117 == null) goto L51;
            com.obric.performance.power.monitor.cpu.c r118 = r117.f403815h;
            if (r118 == null) goto L51;
            long r119 = r118.f403823h;
        L52:
            r109.put("process_cpu_time", r119);
            r109.put("process_wall_time", r112);
            com.obric.performance.power.monitor.cpu.a r120 = g.f478051r;
            if (r120 == null) goto L57;
            com.obric.performance.power.monitor.cpu.c r121 = r120.f403815h;
            if (r121 == null) goto L57;
            Object r122 = Double.valueOf(r121.f403816a);
        L58:
            r109.put("process_cpu_usage", r122);
            com.obric.performance.power.monitor.cpu.a r123 = g.f478051r;
            if (r123 == null) goto L63;
            com.obric.performance.power.monitor.cpu.c r124 = r123.f403815h;
            if (r124 == null) goto L63;
            Object r125 = Double.valueOf(r124.f403817b);
        L64:
            r109.put("process_cpu_speed", r125);
            if (pna.a.f529989b == true) goto L207;
            r101.d("PowerMonitor", "ThreadMonitor getCount: canRead=false, return 0");
        L73:
            int r126 = 0;
        L74:
            r109.put("process_thread_count", r126);
            List<Pair<Integer, Long>> r127 = com.obric.performance.power.monitor.cpu.d.f403829c;
            r109.put("process_wake_lock_count", r127.size());
            monitor-enter(r127);
            Iterator<T> r128 = r127.iterator();     // Catch: Throwable -> L140
            long r129 = 0;
        L78:
            if (r128.hasNext() == false) goto L82;
            Pair r130 = (Pair) r128.next();     // Catch: Throwable -> L140
            List<Pair<Integer, Long>> r131 = r127;
            r129 = r129 + (SystemClock.uptimeMillis() - Math.max(com.obric.performance.power.monitor.cpu.d.f403828b, ((Number) r130.getSecond()).longValue()));     // Catch: Throwable -> L138
            r127 = r131;
        L138:
            th = th;
        L142:
            monitor-exit(r131);
            throw th;
        L82:
            r131 = r127;
            long r132 = r129 + com.obric.performance.power.monitor.cpu.d.f403827a;     // Catch: Throwable -> L138
            com.obric.performance.power.monitor.cpu.d.f403827a = 0;     // Catch: Throwable -> L138
            com.obric.performance.power.monitor.cpu.d.f403828b = SystemClock.uptimeMillis();     // Catch: Throwable -> L138
            monitor-exit(r131);
            r109.put("process_wake_lock_walltime", r132);
            int r133 = nna.a.f519684a;
            nna.a.f519684a = 0;
            r109.put("process_gps_request_count", r133);
            r109.put("process_gps_listener_count", nna.a.f519687d.size());
            r109.put("process_gps_listener_time", nna.a.b());
            r109.put("process_sensor_listener_count", ona.b.f524403c.size());
            r109.put("process_sensor_listener_time", ona.b.b());
            r109.put("process_camera_count", jna.a.f499792c.size());
            r109.put("process_camera_time", jna.a.c());
            r109.put("process_audio_in_count", hna.a.f486162c.size());
            r109.put("process_audio_in_time", hna.a.a());
            r109.put("process_audio_count", gna.a.f481855c.size());
            r109.put("process_audio_time", gna.a.b());
            r109.put("process_bluetooth_scan_count", ina.a.f490631d.size() + ina.a.f490630c);
            r109.put("process_bluetooth_scan_time", ina.a.a());
            Lazy r134 = g.f478056w;
            r109.put("process_name", (String) r134.getValue());
            String r135 = g.f478039f.b();
            if (r135 != null) goto L87;
            r135 = "";
        L87:
            r109.put("activity", r135);
            r109.put(LocationMonitorConst.IS_BACKGROUND, g.f478040g);
            boolean r136 = !g.f478043j;
            if (r136 == true) goto L90;
        L92:
            boolean r137 = false;
        L93:
            r109.put("is_all_foreground", r137);
            if (r136 == true) goto L96;
        L98:
            boolean r138 = false;
        L99:
            r109.put("is_all_background", r138);
            r109.put("is_screen_on", g.f478041h);
            boolean r139 = !g.f478045l;
            if (r139 == true) goto L102;
        L104:
            boolean r140 = false;
        L105:
            r109.put("is_all_screen_on", r140);
            if (r139 == true) goto L108;
        L110:
            boolean r141 = false;
        L111:
            r109.put("is_all_screen_off", r141);
            int r142 = g.f478048o;
            g.f478048o = r142 + 1;
            r109.put("report_index", r142);
            g.a().getClass();
            r109.put("is_charging", BatteryMonitor.f403802f);
            boolean r143 = true;
            boolean r144 = !g.f478047n;
            if (r144 == true) goto L114;
        L116:
            boolean r145 = false;
        L117:
            r109.put("is_all_charging", r145);
            if (r144 == true) goto L120;
        L122:
            boolean r146 = false;
        L123:
            r109.put("is_all_not_charging", r146);
            kna.d r147 = g.f478038e;
            if (r147 == null) goto L201;
            r147.a(r109);
        L201:
            Context r148 = g.f478037d;     // Catch: Exception -> L135
            if (r148 == null) goto L137;
            String r149 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date()) + tb2.c.DEFAULT_TEXT + Process.myPid() + tb2.c.DEFAULT_TEXT + ((String) r134.getValue()) + tb2.c.DEFAULT_TEXT + r109 + '\n';     // Catch: Exception -> L135
            PolarisFileWrapper r150 = new PolarisFileWrapper(r148.getFilesDir(), "performance");     // Catch: Exception -> L135
            if (r150.exists() == true) goto L133;
            r150.mkdirs();     // Catch: Exception -> L135
        L133:
            FilesKt.appendText$default(new PolarisFileWrapper(r150, "power.txt"), r149, null, 2, null);     // Catch: Exception -> L135
        L137:
            g.f478054u = 0.0f;
            g.f478055v = 0;
        L146:
            if (g.f478040g == false) goto L151;
            if (new Random().nextFloat() < g.f478036c.getBackgroundSampledRate()) goto L154;
        L153:
            r143 = false;
        L154:
            g.f478049p = r143;
            if (IRuntimeContext.f384990a.a() == false) goto L157;
            g.b().removeCallbacks(g.f478059z);
        L157:
            g.a().getClass();
            if (BatteryMonitor.f403799c == null) goto L173;
            ILogDepend.f384986a.d("PowerMonitor", "BatteryMonitor unregisterBatteryReceiver");
            Context r151 = BatteryMonitor.f403798b;
            if (r151 == null) goto L172;
            BatteryMonitor.BatteryInfoReceiver r152 = BatteryMonitor.f403799c;
            ReceiverRegisterLancet.loge(r152, false);
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L199;
            r151.unregisterReceiver(r152);
            goto L172
        L199:
        L167:
            e = move-exception;
            if (r152 == null) goto L170;
            Npth.addTag("unregisterReceiver", r152.toString());
        L170:
            e.printStackTrace();
            goto L172
        L164:
            if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r152, r151) == false) goto L172;
            r151.unregisterReceiver(r152);     // Catch: Exception -> L167
        L172:
            BatteryMonitor.f403799c = null;
            BatteryMonitor.f403798b = null;
        L173:
            g.a().d(g.f478057x);
            if (g.f478049p == false) goto L194;
            ILogDepend.Companion r153 = ILogDepend.f384986a;
            r153.d("PowerMonitor", "reportRunnable sampled");
            g.f478042i = g.f478040g;
            g.f478043j = false;
            g.f478044k = g.f478041h;
            g.f478045l = false;
            com.obric.performance.power.monitor.cpu.a r154 = g.f478051r;
            if (r154 == null) goto L179;
            r154.a();
        L179:
            if (IRuntimeContext.f384990a.a() == false) goto L181;
            g.b().post(g.f478059z);
        L181:
            Context r155 = g.f478037d;
            if (r155 == null) goto L193;
            g.a().getClass();
            Intrinsics.checkNotNullParameter(r155, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (BatteryMonitor.f403799c != null) goto L192;
            if (BatteryMonitor.f403798b != null) goto L192;
            BatteryMonitor.f403798b = r155;     // Catch: Throwable -> L197
            r153.d("PowerMonitor", "BatteryMonitor registerBatteryReceiver");     // Catch: Throwable -> L197
            BatteryMonitor.f403799c = new BatteryMonitor.BatteryInfoReceiver();     // Catch: Throwable -> L197
            Intent r156 = BatteryMonitor.a(r155, BatteryMonitor.f403799c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L197
            if (r156 == null) goto L192;
            BatteryMonitor.c(r156);     // Catch: Throwable -> L197
        L192:
            g.a().b(g.f478057x);
        L193:
            g.a().getClass();
            g.f478046m = BatteryMonitor.f403802f;
            g.f478047n = false;
        L195:
            g.b().postDelayed(this, g.f478036c.getReportIntervalMillis());
            return;
        L194:
            ILogDepend.f384986a.d("PowerMonitor", "reportRunnable not sampled");
            List<Pair<Integer, Long>> r157 = com.obric.performance.power.monitor.cpu.d.f403829c;
            com.obric.performance.power.monitor.cpu.d.f403828b = SystemClock.uptimeMillis();
            int r158 = ina.a.f490630c;
            ina.a.f490629b = SystemClock.uptimeMillis();
            List<Pair<String, Long>> r159 = jna.a.f499792c;
            jna.a.f499791b = SystemClock.uptimeMillis();
            List<Pair<ona.a, Long>> r160 = ona.b.f524403c;
            ona.b.f524402b = SystemClock.uptimeMillis();
            int r161 = nna.a.f519684a;
            nna.a.f519686c = SystemClock.uptimeMillis();
            List<Pair<Integer, Long>> r162 = hna.a.f486162c;
            hna.a.f486161b = SystemClock.uptimeMillis();
            List<Pair<Integer, Long>> r163 = gna.a.f481855c;
            gna.a.f481854b = SystemClock.uptimeMillis();
            goto L195
        L151:
            if (new Random().nextFloat() >= g.f478036c.getFrontSampledRate()) goto L153;
        L135:
            e = move-exception;
            ILogDepend.f384986a.d("PowerMonitor", "writePowerToFile failed: " + e.getMessage());
            goto L137
        L120:
            if (g.f478046m == true) goto L122;
            r146 = true;
            goto L123
        L114:
            if (g.f478046m == false) goto L116;
            r145 = true;
            goto L117
        L108:
            if (g.f478044k == true) goto L110;
            r141 = true;
            goto L111
        L102:
            if (g.f478044k == false) goto L104;
            r140 = true;
            goto L105
        L96:
            if (g.f478042i == false) goto L98;
            r138 = true;
            goto L99
        L90:
            if (g.f478042i == true) goto L92;
            r137 = true;
        L140:
            th = th;
            r131 = r127;
            goto L142
        L207:
            File[] r164 = pna.a.f529988a.listFiles();     // Catch: Throwable -> L198
            if (r164 == null) goto L70;
            r126 = r164.length;     // Catch: Throwable -> L198
        L71:
            r101.d("PowerMonitor", "ThreadMonitor getCount: " + r126);     // Catch: Throwable -> L198
        L70:
            r126 = 0;
        L63:
            r125 = -1;
        L57:
            r122 = -1;
        L51:
            r119 = -1;
        L41:
            r116 = -1;
        L26:
            r112 = -1;
        L21:
            r111 = -1;
        L16:
            r107 = -1;
            goto L17
        L10:
            r104 = -1;
            goto L11
        L144:
            r143 = true;
            goto L146
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f478034a = LazyKt.lazy(new fna.a());
        f478035b = LazyKt.lazy(new fna.b());
        f478036c = new ObricPerformancePowerMonitorConfig(false, false, 0, 0, 0.0f, 0.0f, 63, null);
        f478039f = kna.a.f504322a;
        int r100 = kna.b.f504323a;
        f478040g = true;
        f478042i = true;
        f478048o = 1;
        f478050q = LazyKt.lazy(new fna.c());
        f478056w = LazyKt.lazy(new d());
        f478057x = new a();
        f478058y = new c();
        f478059z = new b();
    }

    public static BatteryMonitor a() {
        return (BatteryMonitor) f478050q.getValue();
    }

    public static Handler b() {
        return (Handler) f478035b.getValue();
    }

    public static boolean d() {
        if (f478036c.getEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (f478049p == false) goto L7;
        return true;
    }

    public static void c(kna.f r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        ObricPerformancePowerMonitorConfig r101 = r100.f504325b;
        f478036c = r101;
        if (r101.getEnabled() == true) goto L6;
        ILogDepend.f384986a.d("PowerMonitor", "disabled, return");
        return;
    L6:
        f478037d = r100.getContext();
        f478038e = r100.f504326c;
        kna.c r102 = r100.f504327d;
        f478039f = r102;
        kna.e r103 = r100.f504328e;
        r102.c(new e());
        r100.f504328e.b(new f());
        f478040g = r100.f504327d.a();
        f478041h = r100.f504328e.a();
        ILogDepend.f384986a.d("PowerMonitor", "init, isBackground: " + f478040g);
        f478051r = new com.obric.performance.power.monitor.cpu.a(true, null, true, 8);
        b().post(f478058y);
    }
}
