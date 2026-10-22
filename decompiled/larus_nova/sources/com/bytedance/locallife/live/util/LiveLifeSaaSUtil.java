package com.bytedance.locallife.live.util;

import android.content.Context;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.host.growth.ILifeUserGrowthService;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class LiveLifeSaaSUtil {
    public static final Lazy A = null;
    public static final Lazy B = null;
    public static final Lazy C = null;
    public static final Lazy D = null;
    public static final Lazy E = null;
    public static final Lazy F = null;
    public static final Lazy G = null;
    public static final Lazy H = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f260652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f260653b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f260654c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f260655d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f260656e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f260657f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f260658g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f260659h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f260660i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f260661j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f260662k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f260663l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f260664m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f260665n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f260666o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f260667p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f260668q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f260669r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy f260670s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Lazy f260671t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f260672u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy f260673v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Lazy f260674w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy f260675x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Lazy f260676y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Lazy f260677z = null;

    static {
        f260652a = LazyKt.lazy(LiveLifeSaaSUtil$mGson$2.INSTANCE);
        f260653b = LazyKt.lazy(LiveLifeSaaSUtil$isSaaS$2.INSTANCE);
        f260654c = LazyKt.lazy(LiveLifeSaaSUtil$isLiveDebugOpen$2.INSTANCE);
        f260655d = LazyKt.lazy(LiveLifeSaaSUtil$isProblemLeftDebug$2.INSTANCE);
        f260656e = LazyKt.lazy(LiveLifeSaaSUtil$isBasicDebugAndPoiDebugOpen$2.INSTANCE);
        f260657f = LazyKt.lazy(LiveLifeSaaSUtil$canOpenFmpDebugMode$2.INSTANCE);
        f260658g = LazyKt.lazy(LiveLifeSaaSUtil$liveLifeExperimentMap$2.INSTANCE);
        f260659h = LazyKt.lazy(LiveLifeSaaSUtil$applicationContext$2.INSTANCE);
        f260660i = LazyKt.lazy(LiveLifeSaaSUtil$hostAppInfoService$2.INSTANCE);
        f260661j = LazyKt.lazy(LiveLifeSaaSUtil$geckoXAccessKey$2.INSTANCE);
        f260662k = LazyKt.lazy(LiveLifeSaaSUtil$lifeGeckoxService$2.INSTANCE);
        f260663l = LazyKt.lazy(LiveLifeSaaSUtil$liveAdLogger$2.INSTANCE);
        f260664m = LazyKt.lazy(LiveLifeSaaSUtil$lifeALogService$2.INSTANCE);
        f260665n = LazyKt.lazy(LiveLifeSaaSUtil$lifeLocationService$2.INSTANCE);
        f260666o = LazyKt.lazy(LiveLifeSaaSUtil$lifeLynxService$2.INSTANCE);
        f260667p = LazyKt.lazy(LiveLifeSaaSUtil$lifeLiveDslService$2.INSTANCE);
        f260668q = LazyKt.lazy(LiveLifeSaaSUtil$lifeLiveDebugService$2.INSTANCE);
        f260669r = LazyKt.lazy(LiveLifeSaaSUtil$lifeAccountService$2.INSTANCE);
        f260670s = LazyKt.lazy(LiveLifeSaaSUtil$lifeUserGrowthService$2.INSTANCE);
        f260671t = LazyKt.lazy(LiveLifeSaaSUtil$lifeVirgoService$2.INSTANCE);
        f260672u = LazyKt.lazy(LiveLifeSaaSUtil$lifeRouterService$2.INSTANCE);
        f260673v = LazyKt.lazy(LiveLifeSaaSUtil$lifeEventService$2.INSTANCE);
        f260674w = LazyKt.lazy(LiveLifeSaaSUtil$lifePoiService$2.INSTANCE);
        f260675x = LazyKt.lazy(LiveLifeSaaSUtil$lifeDeviceService$2.INSTANCE);
        f260676y = LazyKt.lazy(LiveLifeSaaSUtil$lifePerformanceService$2.INSTANCE);
        f260677z = LazyKt.lazy(LiveLifeSaaSUtil$lifeSettingsService$2.INSTANCE);
        A = LazyKt.lazy(LiveLifeSaaSUtil$lifeNitaService$2.INSTANCE);
        B = LazyKt.lazy(LiveLifeSaaSUtil$lifeSpService$2.INSTANCE);
        C = LazyKt.lazy(LiveLifeSaaSUtil$lifeFontScaleService$2.INSTANCE);
        D = LazyKt.lazy(LiveLifeSaaSUtil$lifeMiniAppService$2.INSTANCE);
        E = LazyKt.lazy(LiveLifeSaaSUtil$lifeSessionService$2.INSTANCE);
        F = LazyKt.lazy(LiveLifeSaaSUtil$lifeGoodsDetailService$2.INSTANCE);
        G = LazyKt.lazy(LiveLifeSaaSUtil$lifeLiveAdaptService$2.INSTANCE);
        H = LazyKt.lazy(LiveLifeSaaSUtil$lifeSaaSService$2.INSTANCE);
    }

    public static boolean A() {
        return ((Boolean) f260654c.getValue()).booleanValue();
    }

    public static boolean C() {
        return ((Boolean) f260653b.getValue()).booleanValue();
    }

    public static Context p() {
        return (Context) f260659h.getValue();
    }

    public static String q() {
        return (String) f260661j.getValue();
    }

    @JvmStatic
    public static final Gson r() {
        return (Gson) f260652a.getValue();
    }

    public static ss6.c s() {
        return (ss6.c) f260660i.getValue();
    }

    public static qs6.b t() {
        return (qs6.b) f260664m.getValue();
    }

    public static gt6.b u() {
        return (gt6.b) f260662k.getValue();
    }

    public static kt6.g v() {
        return (kt6.g) f260665n.getValue();
    }

    public static zt6.a w() {
        return (zt6.a) H.getValue();
    }

    public static jt6.a x() {
        return (jt6.a) f260663l.getValue();
    }

    public static Map y() {
        return (Map) f260658g.getValue();
    }

    @JvmStatic
    public static final boolean z() {
        int r100 = com.bytedance.locallife.live.experiment.m.f259506a;
        Class r101 = Integer.TYPE;     // Catch: Throwable -> L17
        if (y().containsKey("live_life_saas_fps_opt") == false) goto L12;
        Object r102 = y().get("live_life_saas_fps_opt");     // Catch: Throwable -> L17
        if (r102 != null) goto L9;
        Object r103 = null;
    L13:
        Integer r104 = (Integer) r103;     // Catch: Throwable -> L17
        if (r104 == null) goto L18;
        int r105 = r104.intValue();     // Catch: Throwable -> L17
    L20:
        if (r105 != 1) goto L25;
        return true;
    L25:
        return false;
    L9:
        if ((r102 instanceof Integer) == true) goto L11;
        r103 = a("live_life_saas_fps_opt", r101, 0);     // Catch: Throwable -> L17
        goto L13
    L11:
        r103 = (Integer) r102;     // Catch: Throwable -> L17
        goto L13
    L12:
        r103 = a("live_life_saas_fps_opt", r101, 0);     // Catch: Throwable -> L17
    L18:
        r105 = 0;
        goto L20
    }

    @Deprecated(message = "历史判断逻辑，后续可以去掉，直接使用 getABLifeAccountService().isBindDouyin() 代替")
    public static boolean B() {
        if (b().isLogin() == true) goto L5;
    L7:
        return false;
    L5:
        if (b().c() == false) goto L7;
        return true;
    }

    public static os6.d b() {
        if (z() == false) goto L6;
        return (os6.d) f260669r.getValue();
    L6:
        return HostServiceUtilsKt.i();
    }

    public static zs6.a c() {
        if (z() == false) goto L6;
        return (zs6.a) f260675x.getValue();
    L6:
        return HostServiceUtilsKt.v();
    }

    public static at6.b d() {
        if (z() == false) goto L6;
        return (at6.b) f260673v.getValue();
    L6:
        return HostServiceUtilsKt.x();
    }

    public static vt6.b e() {
        if (z() == false) goto L6;
        return (vt6.b) F.getValue();
    L6:
        return HostServiceUtilsKt.D();
    }

    public static it6.f f() {
        if (z() == false) goto L6;
        return (it6.f) G.getValue();
    L6:
        return HostServiceUtilsKt.I();
    }

    public static it6.g g() {
        if (z() == false) goto L6;
        return (it6.g) f260668q.getValue();
    L6:
        return HostServiceUtilsKt.L();
    }

    public static nt6.a h() {
        if (z() == false) goto L6;
        return (nt6.a) D.getValue();
    L6:
        return HostServiceUtilsKt.Q();
    }

    public static rt6.a i() {
        if (z() == false) goto L6;
        return (rt6.a) A.getValue();
    L6:
        return HostServiceUtilsKt.T();
    }

    public static vt6.d j() {
        if (z() == false) goto L6;
        return (vt6.d) f260674w.getValue();
    L6:
        return HostServiceUtilsKt.Z();
    }

    public static yt6.a k() {
        if (z() == false) goto L6;
        return (yt6.a) f260672u.getValue();
    L6:
        return HostServiceUtilsKt.a0();
    }

    public static fu6.a l() {
        if (z() == false) goto L6;
        return (fu6.a) E.getValue();
    L6:
        return HostServiceUtilsKt.f0();
    }

    public static cu6.a m() {
        if (z() == false) goto L6;
        return (cu6.a) f260677z.getValue();
    L6:
        return HostServiceUtilsKt.g0();
    }

    public static ILifeUserGrowthService n() {
        if (z() == false) goto L6;
        return (ILifeUserGrowthService) f260670s.getValue();
    L6:
        return HostServiceUtilsKt.o0();
    }

    public static ku6.a o() {
        if (z() == false) goto L6;
        return (ku6.a) f260671t.getValue();
    L6:
        return HostServiceUtilsKt.t0();
    }

    public static Object a(String r100, Class r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "targetClass");
        Object r103 = HostServiceUtilsKt.y().a(r100, r101, r102);
        if (r103 == null) goto L5;
        y().put(r100, r103);
    L10:
        if (r103 != null) goto L13;
        return r102;
    L13:
        return r103;
    L5:
        Map r104 = y();
        if (r102 != null) goto L8;
        Object r105 = null;
    L9:
        r104.put(r100, r105);
        goto L10
    L8:
        r105 = r102;
        goto L9
    }
}
