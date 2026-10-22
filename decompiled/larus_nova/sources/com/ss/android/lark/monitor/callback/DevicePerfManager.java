package com.ss.android.lark.monitor.callback;

import bsb.e;
import bsb.f;
import bsb.g;
import bsb.i;
import bsb.k;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.apm.internal.ApmDelegate;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.z;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import com.ss.android.lark.monitor.cpu.CpuSceneMonitor;
import com.ss.android.lark.monitor.downgrade.DowngradeSetting;
import com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor;
import com.suite.lark.platform.component.deviceperf.DevicePerfUtils;
import java.lang.ref.SoftReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class DevicePerfManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f432368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f432369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f432370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f432371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bsb.c f432372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DowngradeSetting.a.C5136a f432373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DowngradeSetting.c.a f432374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DowngradeSetting.b.a f432375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f432376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f432377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f432378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f432379l;

    public static final enum PerfType extends Enum<PerfType> {
        public static final PerfType ALL = null;
        public static final PerfType CPU = null;
        public static final PerfType MEMORY = null;
        public static final PerfType TEMPERATURE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PerfType[] f432380a = null;

        static {
            PerfType r100 = new PerfType(AccountType.ALL, 0);
            ALL = r100;
            PerfType r101 = new PerfType("TEMPERATURE", 1);
            TEMPERATURE = r101;
            PerfType r102 = new PerfType("CPU", 2);
            CPU = r102;
            PerfType r103 = new PerfType("MEMORY", 3);
            MEMORY = r103;
            f432380a = new PerfType[]{r100, r101, r102, r103};
        }

        public static PerfType[] values() {
            return (PerfType[]) f432380a.clone();
        }

        public static PerfType valueOf(String r100) {
            return (PerfType) r27.a.a(PerfType.class, r100);
        }

        public PerfType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SoftReference<c> f432381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PerfType f432382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DowngradeSetting.a.C5136a f432383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f432384d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f432385e;

        public a(SoftReference r100, PerfType r101, dsb.b r102) {
            this.f432385e = 0;
            this.f432381a = r100;
            this.f432384d = "TurboModeDetector";
            this.f432382b = r101;
            if (r101 == PerfType.CPU) goto L5;
            return;
        L5:
            if ((r102 instanceof dsb.a) == false) goto L12;
            DowngradeSetting.a.C5136a r103 = new DowngradeSetting.a.C5136a();
            this.f432383c = r103;
            dsb.a r104 = (dsb.a) r102;
            int r105 = r104.b();
            if (r105 != 0) goto L9;
            r105 = 10;
        L9:
            r103.CPU_CHECK_TIME = r105;
            r103.BUSY_USAGE = r104.a();
            r103.NORMAL_USAGE = r104.c();
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DevicePerfManager f432386a = null;

        static {
            f432386a = new DevicePerfManager();
        }
    }

    public interface c {
        void a(int r100);
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f432387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PerfType f432388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f432389c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f432390d;

        public d(PerfType r100) {
            this.f432388b = r100;
        }
    }

    public final int b() {
        bsb.c r100 = this.f432372e;
        int r101 = r100.f20367e;
        int r102 = 3;
        if (r101 == 3) goto L21;
        int r103 = r100.f20369g;
        if (r103 == 3) goto L21;
        int r104 = r100.f20365c;
        if (r104 == 3) goto L21;
        r102 = 2;
        if (r101 == 2) goto L21;
        if (r103 == 2) goto L21;
        if (r104 == 2) goto L21;
        r102 = 1;
        if (r101 == 1) goto L21;
        if (r103 == 1) goto L21;
        if (r104 == 1) goto L21;
        return 0;
    L21:
        return r102;
    }

    public DevicePerfManager() {
        this.f432368a = new CopyOnWriteArrayList();
        this.f432372e = new bsb.c();
        this.f432378k = false;
        this.f432379l = false;
    }

    public final void a(com.ss.android.lark.monitor.d... r100) {
        if (z.e(com.larksuite.framework.utils.b.f285948a) == true) goto L5;
        return;
    L5:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.app.monitor.downgrade_enable") == false) goto L45;
        Log.i("DevicePerfManager", "init DevicePerf");
        DowngradeSetting r101 = (DowngradeSetting) SettingManager.getInstance().get(DowngradeSetting.class);
        if (r101.temperatureValve != null) goto L10;
        r101.temperatureValve = new DowngradeSetting.c();
    L10:
        if (r101.cpuValve != null) goto L13;
        r101.cpuValve = new DowngradeSetting.a();
    L13:
        if (r101.memoryValve != null) goto L15;
        r101.memoryValve = new DowngradeSetting.b();
    L15:
        this.f432374g = r101.temperatureValve.commonValve;
        this.f432373f = r101.cpuValve.commonValve;
        this.f432375h = r101.memoryValve.commonValve;
        int r102 = 0;
        this.f432372e.f20370h = false;
        DevicePerfUtils.DevicePerfLevel r103 = DevicePerfUtils.d();
        Log.i("DevicePerfManager", "initDevicePerfInfo:" + r103);
        if (r103.ordinal() < DevicePerfUtils.DevicePerfLevel.LOW.ordinal()) goto L18;
        this.f432372e.f20370h = true;
    L18:
        this.f432372e.f20371i = r103.ordinal() - 1;
        bsb.c r104 = this.f432372e;
        r104.f20363a = r104.f20371i;
        if (this.f432374g != null) goto L22;
        this.f432374g = new DowngradeSetting.c.a();
    L22:
        if (this.f432373f != null) goto L25;
        this.f432373f = new DowngradeSetting.a.C5136a();
    L25:
        if (this.f432375h != null) goto L27;
        this.f432375h = new DowngradeSetting.b.a();
    L27:
        DowngradeSetting.a.C5136a r105 = this.f432373f;
        this.f432376i = r105.BUSY_USAGE;
        this.f432377j = r105.NORMAL_USAGE;
        noc.c r106 = noc.c.b.f519994a;
        ((CopyOnWriteArrayList) r106.f519993i).add(new e(this));
        int r107 = r100.length;
    L28:
        if (r102 >= r107) goto L46;
        com.ss.android.lark.monitor.d r108 = r100[r102];
        if ((r108 instanceof CpuSceneMonitor) == false) goto L33;
        ((CpuSceneMonitor) r108).addCpuPerfCallback(new f(this));
    L38:
        r102 = r102 + 1;
        goto L28
    L33:
        if ((r108 instanceof esb.b) == false) goto L36;
        ((esb.b) r108).f473804b.add(new g(this));
        goto L38
    L36:
        if ((r108 instanceof TemperaturePerfMonitor) == false) goto L38;
        TemperaturePerfMonitor r109 = (TemperaturePerfMonitor) r108;
        k r110 = new k(this);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "temperaturePerfCallback");
        r109.f432460b.add(r110);
        goto L38
    L46:
        return;
    }

    public final void c(boolean r100, int r101) {
        if (r101 == this.f432372e.f20365c) goto L5;
    L7:
        Log.i("DevicePerfManager", "notifyTemperatureState:" + r100 + " ,level:" + r101);
        bsb.c r102 = this.f432372e;
        r102.f20364b = r100;
        r102.f20365c = r101;
        if (this.f432369b != null) goto L10;
        this.f432369b = new d(PerfType.TEMPERATURE);
    L10:
        d(this.f432369b, r101);
        this.f432372e.f20363a = b();
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new i(this));
        return;
    L5:
        if (r101 == 3) goto L7;
    }

    public final void d(d r110, int r111) {
        if (ApmDelegate.g.f190592a.f190575f == true) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L12;
        return;
    L12:
        if (r110.f432389c != 0) goto L21;
    L17:
        if (r111 != 0) goto L19;
        r110.f432389c = 0;
        return;
    L19:
        r110.f432389c = System.currentTimeMillis();
        r110.f432387a = MonitorModule.e().d();
        r110.f432390d = r111;
        return;
    L21:
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L15
        r101.put("type", r110.f432388b.name().toLowerCase());     // Catch: JSONException -> L15
        r101.put("time", (System.currentTimeMillis() - r110.f432389c) / 1000);     // Catch: JSONException -> L15
        r101.put("level", r110.f432390d);     // Catch: JSONException -> L15
        r101.put(IPerformanceStrategyManager.KEY_INT_DEVICE_LEVEL, this.f432372e.f20371i);     // Catch: JSONException -> L15
        r101.put("start_scene", r110.f432387a);     // Catch: JSONException -> L15
        r101.put("end_scene", MonitorModule.e().d());     // Catch: JSONException -> L15
        isb.a.c("PerfException", r101);     // Catch: JSONException -> L15
        Log.i("DevicePerfManager", "PerfException:" + r101);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L5:
        if (zs3.c.f573475a.getServiceSwitch("PerfException") == true) goto L8;
        r100 = false;
        goto L9
    }
}
