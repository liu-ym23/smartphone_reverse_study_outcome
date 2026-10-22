package com.bytedance.helios.sdk;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.bytedance.helios.api.HeliosService;
import com.bytedance.helios.api.config.RuleInfo;
import com.bytedance.timon_monitor_impl.MonitorLifecycleServiceImpl;
import com.bytedance.timon_monitor_impl.call.stastics.ApiStatisticsEventHandler;
import gz5.x;
import gz5.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class HeliosEnvImpl extends fz5.b implements gz5.a.InterfaceC6085a {
    public static final String[] D = null;
    public static final String[] E = null;
    public static final HeliosEnvImpl F = null;
    public final ArraySet A;
    public final ArraySet B;
    public fz5.a C;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fz5.b.InterfaceC5970b f245459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f245461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f245462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f245463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f245464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f245465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f245466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f245467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Application f245468k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public gz5.a f245469l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y f245470m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<CheckPoint> f245471n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayMap f245472o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayMap f245473p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArraySet f245474q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public jz5.e f245475r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public jz5.c f245476s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public jz5.d f245477t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public jz5.g f245478u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public jz5.f f245479v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public jz5.a f245480w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public fz5.b.c f245481x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f245482y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public fz5.b.d f245483z;

    public static class CheckPoint {
        final String message;
        final String name;
        final long timestamp;

        public String toString() {
            return "CheckPoint(name=" + this.name + ", message=" + this.message + ", timestamp=" + this.timestamp + ")";
        }

        public CheckPoint(String r100, String r101) {
            this(r100, r101, System.currentTimeMillis());
        }

        public CheckPoint(String r100, String r101, long r102) {
            this.name = r100;
            this.message = r101;
            this.timestamp = r102;
        }
    }

    public class a {
        public a() {
        }
    }

    public final synchronized void k() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f245464g == false) goto L6;
    L8:
        monitor-exit(this);
        return;
    L6:
        if (this.f245465h == false) goto L8;
        this.f245464g = true;     // Catch: Throwable -> L10
        boolean r100 = b.f245494a;     // Catch: Throwable -> L10
        b.f245494a = true;     // Catch: Throwable -> L10
        b.f245495b = f();     // Catch: Throwable -> L10
        hz5.k.c("Helios-Common-Env", "checkAllCommonEnvReady");     // Catch: Throwable -> L10
        com.bytedance.helios.common.utils.d.f().post(new l(this));     // Catch: Throwable -> L10
        com.bytedance.helios.common.utils.g.e().postDelayed(new m(this), 10000);     // Catch: Throwable -> L10
        goto L8
    }

    static {
        D = new String[]{"com.bytedance.helios.sdk.ApiMonitorService", "com.bytedance.helios.sdk.appops.AppOpsService", "com.bytedance.helios.binder.impl.BinderService", "com.bytedance.helios.nativeaudio.NativeAudioService"};
        E = new String[]{"com.bytedance.helios.consumer.DefaultConsumerComponent", "com.bytedance.helios.tools.skyeye.SkyEyeComponent", "com.bytedance.helios.cache.CacheComponent", "com.bytedance.helios.network.NetworkComponent"};
        F = new HeliosEnvImpl();
    }

    @Override // fz5.b
    public final boolean e() {
        if (this.f245462e == false) goto L5;
    L10:
        return true;
    L5:
        if (this.f245465h == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f245470m.n() == false) goto L9;
        goto L9
    }

    @Override // fz5.b
    public final boolean f() {
        if (this.f245463f == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f245470m.z().contains(this.f245460c) == true) goto L8;
        return false;
    }

    @Override // fz5.b
    public final void j() {
        if (this.f245469l == null) goto L6;
        com.bytedance.helios.common.utils.d.f().post(new i(this));
        return;
    }

    public HeliosEnvImpl() {
        this.f245459b = null;
        this.f245460c = "";
        this.f245461d = -1;
        this.f245462e = false;
        this.f245463f = false;
        this.f245464g = false;
        this.f245465h = false;
        this.f245466i = false;
        this.f245467j = 0;
        this.f245469l = null;
        this.f245470m = new y();
        this.f245471n = new LinkedList();
        this.f245474q = new ArraySet();
        this.f245475r = null;
        this.f245476s = null;
        this.f245477t = null;
        this.f245478u = null;
        this.f245479v = null;
        this.f245480w = null;
        this.f245481x = null;
        this.f245482y = new a();
        this.f245483z = null;
        this.A = new ArraySet();
        this.B = new ArraySet();
    }

    public static HeliosEnvImpl get() {
        return F;
    }

    public Application getContext() {
        return this.f245468k;
    }

    @Override // fz5.b
    public final void g(ApiStatisticsEventHandler r100) {
        hz5.g.f487690b.b(r100, false);
    }

    @Override // fz5.b
    public final void h(MonitorLifecycleServiceImpl.h r100) {
        this.f245483z = r100;
    }

    @Override // fz5.b
    public final void i(lz5.a r100) {
        List<lz5.a> r101 = com.bytedance.helios.sdk.engine.a.f245564b;
        if (r101.contains(r100) == true) goto L5;
        r101.add(r100);
        return;
    L5:
        r101.remove(r100);
    }

    @Override // gz5.a.InterfaceC6085a
    public final void onNewSettings(final y r100) {
        com.bytedance.helios.common.utils.d.f().post(new n(this, r100));
    }

    @Override // fz5.b
    public final void setAppLog(jz5.a r100) {
        hz5.k.d("HeliosEnv", "setAppLog " + r100);
        this.f245480w = r100;
        Iterator<E> r101 = this.B.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((fz5.a) r101.next()).setAppLog(r100);
        goto L4
    L6:
        Iterator<E> r102 = this.A.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((HeliosService) r102.next()).setAppLog(r100);
        goto L8
    }

    @Override // fz5.b
    public final void setEventMonitor(jz5.c r100) {
        hz5.k.d("HeliosEnv", "setEventMonitor " + r100);
        this.f245476s = r100;
        Iterator<E> r101 = this.B.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((fz5.a) r101.next()).setEventMonitor(r100);
        goto L4
    L6:
        Iterator<E> r102 = this.A.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((HeliosService) r102.next()).setEventMonitor(r100);
        goto L8
    }

    @Override // fz5.b
    public final void setExceptionMonitor(jz5.d r100) {
        hz5.k.d("HeliosEnv", "setExceptionMonitor " + r100);
        this.f245477t = r100;
        Iterator<E> r101 = this.B.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((fz5.a) r101.next()).setExceptionMonitor(r100);
        goto L4
    L6:
        Iterator<E> r102 = this.A.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((HeliosService) r102.next()).setExceptionMonitor(r100);
        goto L8
    }

    @Override // fz5.b
    public final void setLogger(jz5.e r100) {
        hz5.k.d("HeliosEnv", "setLogger " + r100);
        this.f245475r = r100;
        Iterator<E> r101 = this.B.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((fz5.a) r101.next()).setLogger(r100);
        goto L4
    L6:
        Iterator<E> r102 = this.A.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((HeliosService) r102.next()).setLogger(r100);
        goto L8
    }

    @Override // fz5.b
    public final void setRuleEngine(jz5.f r100) {
        hz5.k.d("HeliosEnv", "setRuleEngine " + r100);
        this.f245479v = r100;
        Iterator<E> r101 = this.B.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((fz5.a) r101.next()).setRuleEngine(r100);
        goto L4
    L6:
        Iterator<E> r102 = this.A.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((HeliosService) r102.next()).setRuleEngine(r100);
        goto L8
    }

    @Override // fz5.b
    public final void setStore(jz5.g r100) {
        hz5.k.d("HeliosEnv", "setStore: " + r100);
        this.f245478u = r100;
        Iterator<E> r101 = this.B.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((fz5.a) r101.next()).setStore(r100);
        goto L4
    L6:
        Iterator<E> r102 = this.A.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((HeliosService) r102.next()).setStore(r100);
        goto L8
    }

    @Override // fz5.b
    public final void d(MonitorLifecycleServiceImpl.i r100, MonitorLifecycleServiceImpl.j r101) {
        if (this.f245466i == false) goto L5;
        return;
    L5:
        boolean r102 = true;
        this.f245466i = true;
        this.f245481x = r101;
        Application r103 = r100.getContext();
        this.f245468k = r103;
        if ((r103.getApplicationInfo().flags & 2) != 0) goto L9;
        r102 = false;
    L9:
        this.f245463f = r102;
        PackageInfo r104 = r103.getPackageManager().getPackageInfo(r103.getPackageName(), 0);     // Catch: Exception -> L32
        if (Build.VERSION.SDK_INT < 28) goto L13;
        long r105 = r104.getLongVersionCode();     // Catch: Exception -> L32
    L14:
        this.f245467j = r105;     // Catch: Exception -> L32
        String r106 = r104.versionName;     // Catch: Exception -> L32
        goto L15
    L13:
        r105 = r104.versionCode;     // Catch: Exception -> L32
    L15:
        this.f245460c = r100.f270731d;
        this.f245461d = r100.f270730c;
        this.f245462e = false;
        this.f245459b = r100;
        final com.bytedance.timon_monitor_impl.d r107 = new com.bytedance.timon_monitor_impl.d();
        com.bytedance.helios.common.utils.d.f().post(new k(this, r107));
        List<x> r108 = vz5.a.f557720g;
        ArrayMap r109 = new ArrayMap();
        ArrayMap r110 = new ArrayMap();
        Iterator<x> r111 = r108.iterator();
    L17:
        if (r111.hasNext() == false) goto L23;
        x r112 = r111.next();
        r109.put(r112.f483406a, r112);
        ArrayList r113 = new ArrayList(r112.f483409d);
        r113.addAll(r112.f483407b);
        String r114 = r112.f483406a;
        if (r112.f483408c == false) goto L21;
        String r115 = "auto";
    L22:
        r110.put(r112.f483406a, new RuleInfo(r114, r115, r113, new ArrayList()));
        goto L17
    L21:
        r115 = "manual";
        goto L22
    L23:
        this.f245472o = r109;
        this.f245473p = r110;
        iz5.a r116 = iz5.a.f496698a;
        com.bytedance.helios.common.utils.d r117 = com.bytedance.helios.common.utils.d.f245394c;
        monitor-enter(com.bytedance.helios.common.utils.d.class);
        com.bytedance.helios.common.utils.d.d();     // Catch: Throwable -> L29
        com.bytedance.helios.common.utils.d r118 = com.bytedance.helios.common.utils.d.f245394c;     // Catch: Throwable -> L29
        monitor-exit(com.bytedance.helios.common.utils.d.class);     // Catch: Throwable -> L29
        r118.setUncaughtExceptionHandler(r116);
        com.bytedance.helios.common.utils.g.d().setUncaughtExceptionHandler(r116);
        com.bytedance.helios.common.utils.c.a().post(new h(this));
        com.bytedance.helios.common.utils.d.f().post(new j(this, new CheckPoint("helios init", "isFirstStart:" + this.f245462e + ",version:" + this.f245470m.B())));
        return;
    L29:
        th = move-exception;
        throw th;
    }
}
