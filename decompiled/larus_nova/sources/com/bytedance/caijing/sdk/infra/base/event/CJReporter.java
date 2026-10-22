package com.bytedance.caijing.sdk.infra.base.event;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.android.ttcjpaysdk.integrated.counter.CJPayBaseConstant;
import com.bytedance.caijing.sdk.infra.base.api.applog.AppLogService;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.monitor.MonitorService;
import com.bytedance.caijing.sdk.infra.base.api.plugin.settings.IPluginSettingsHelper;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.caijing.sdk.infra.base.task.CJColdStartTaskManager;
import com.bytedance.caijing.sdk.infra.base.task.CJTask;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class CJReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CJReporter f202294a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f202295b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f202296c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f202297d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, com.bytedance.caijing.sdk.infra.base.event.a> f202298e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f202299f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f202300g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static d f202301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static i f202302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<e> f202303j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f202304k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f202305l = null;

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f202306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f202307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CJContext f202308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f202309d;

        /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.event.CJReporter$a$a, reason: collision with other inner class name */
        public static final class RunnableC2922a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f202310a;

            public RunnableC2922a(String r100) {
                this.f202310a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L5:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L9;
                return;
            L9:
                throw th;
            L4:
                throw new Exception("reported a P0 custom exception before 3000 ms,data:" + this.f202310a);     // Catch: Throwable -> L5
            }
        }

        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f202311a;

            public b(String r100) {
                this.f202311a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L5:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L9;
                return;
            L9:
                throw th;
            L4:
                throw new Exception("reported a P1 custom exception before 3000 ms,data:" + this.f202311a);     // Catch: Throwable -> L5
            }
        }

        public a(String r100, String r101, CJContext r102, int r103) {
            this.f202306a = r100;
            this.f202307b = r101;
            this.f202308c = r102;
            this.f202309d = r103;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            CJLogger.b("CJReporter", this.f202306a + ',' + this.f202307b + ',' + this.f202308c + ',' + this.f202309d);     // Catch: Throwable -> L27
            int r100 = this.f202309d;     // Catch: Throwable -> L27
            if (r100 == 0) goto L12;
            if (r100 != 1) goto L8;
            String r101 = "wallet_rd_exception_p1";
        L13:
            CJReporter r102 = CJReporter.f202294a;     // Catch: Throwable -> L27
            HashMap r103 = CJReporter.e(this.f202308c);     // Catch: Throwable -> L27
            String r104 = this.f202307b;     // Catch: Throwable -> L27
            if (r104.length() <= 1200) goto L16;
            r104 = r104.substring(0, 1200);     // Catch: Throwable -> L27
        L16:
            HashMap r105 = new HashMap();     // Catch: Throwable -> L27
            r105.put("priority", Integer.valueOf(this.f202309d));     // Catch: Throwable -> L27
            r105.put("exception_event_name", this.f202306a);     // Catch: Throwable -> L27
            r105.put("err_info", r104);     // Catch: Throwable -> L27
            r103.putAll(r105);     // Catch: Throwable -> L27
            CJReporter.c(r101, com.bytedance.caijing.sdk.infra.utils.d.a(r103));     // Catch: Throwable -> L27
            CJReporter.a(r101, r105);     // Catch: Throwable -> L27
            if (CJEnv.n() == false) goto L22;
            if (this.f202309d != 0) goto L22;
            com.bytedance.caijing.sdk.infra.base.task.b.g(new RunnableC2922a(this.f202307b), 3000);     // Catch: Throwable -> L27
        L22:
            if (CJEnv.f().hostIsDebug() == true) goto L24;
            return;
        L24:
            if (this.f202309d != 1) goto L35;
            com.bytedance.caijing.sdk.infra.base.task.b.g(new b(this.f202307b), 3000);     // Catch: Throwable -> L27
            return;
        L35:
            return;
        L8:
            if (r100 == 2) goto L10;
            r101 = "wallet_rd_exception_p3";
            goto L13
        L10:
            r101 = "wallet_rd_exception_p2";
            goto L13
        L12:
            r101 = "wallet_rd_exception_p0";
        L27:
            th = move-exception;
            CJLogger.b("CJReporter", th.toString());
            if (CJEnv.n() == true) goto L32;
            return;
        L32:
            throw new RuntimeException(th);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    public CJReporter() {
    }

    static {
        f202294a = new CJReporter();
        f202295b = LazyKt.lazy(CJReporter$eventService$2.INSTANCE);
        f202296c = LazyKt.lazy(CJReporter$monitorService$2.INSTANCE);
        f202297d = LazyKt.lazy(CJReporter$settingsService$2.INSTANCE);
        f202298e = new ConcurrentHashMap();
        f202299f = LazyKt.lazy(CJReporter$pendingReportQueue$2.INSTANCE);
        f202300g = new AtomicBoolean(false);
        f202303j = new ArrayList();
        f202304k = LazyKt.lazy(CJReporter$isVipUser$2.INSTANCE);
        f202305l = LazyKt.lazy(CJReporter$getDeviceScoreTask$2.INSTANCE);
        CJLogger.d("CJReporter", "init " + e(null));
    }

    public static IPluginSettingsHelper f() {
        return (IPluginSettingsHelper) f202297d.getValue();
    }

    public static HashMap d(CJContext r110) {
        Lazy r100 = CJColdStartTaskManager.f202762a;
        com.bytedance.caijing.sdk.infra.base.task.a r101 = (com.bytedance.caijing.sdk.infra.base.task.a) f202305l.getValue();
        Intrinsics.checkNotNullParameter(r101, "task");
        Lazy r102 = CJColdStartTaskManager.f202762a;
        if (((CJHostService) r102.getValue()).isColdBoot() == true) goto L6;
        Object r103 = r101.f202767c.invoke();
    L9:
        float r104 = ((Number) r103).floatValue();
        Pair[] r105 = new Pair[24];
        r105[0] = TuplesKt.to("aid", CJEnv.e());
        r105[1] = TuplesKt.to("os_name", "Android" + Build.VERSION.RELEASE);
        r105[2] = TuplesKt.to("host_app_chanel", CJEnv.b());
        r105[3] = TuplesKt.to("app_platform", "native");
        r105[4] = TuplesKt.to("params_for_special", com.bytedance.android.ec.core.event.a.VALUE_PARAMS_FOR_SPECIAL);
        r105[5] = TuplesKt.to("is_chaselight", 1);
        r105[6] = TuplesKt.to("network_quality", Integer.valueOf(CJEnv.f().getNetworkQuality()));
        r105[7] = TuplesKt.to("device_score", Float.valueOf(r104));
        r105[8] = TuplesKt.to("cjpay_sdk_version", CJEnv.m());
        r105[9] = TuplesKt.to("cjpay_sdk_version_code", Long.valueOf(CJEnv.l()));
        r105[10] = TuplesKt.to("host_version_code", Integer.valueOf(CJEnv.f().getHostVersionCode()));
        r105[11] = TuplesKt.to("host_update_version_code", Integer.valueOf(CJEnv.g()));
        String r106 = null;
        if (r110 == null) goto L12;
        String r107 = r110.f202257c;
    L13:
        r105[12] = TuplesKt.to("app_id", r107);
        if (r110 == null) goto L16;
        String r108 = r110.f202256b;
    L17:
        r105[13] = TuplesKt.to("merchant_id", r108);
        if (r110 == null) goto L20;
        r106 = r110.f202258d;
    L20:
        r105[14] = TuplesKt.to("cj_source", r106);
        r105[15] = TuplesKt.to("cj_sdk_full_version", CJEnv.k());
        r105[16] = TuplesKt.to("cj_sdk_version_code", Long.valueOf(CJEnv.l()));
        r105[17] = TuplesKt.to("cj_sdk_version", CJEnv.m());
        CJEnv.f().getEnvController();
        String r109 = "";
        r105[18] = TuplesKt.to("cj_plugin_sdk_version", "");
        CJEnv.f().getEnvController();
        r105[19] = TuplesKt.to("cj_plugin_host_version_code", -1L);
        r105[20] = TuplesKt.to("device_id", CJEnv.c());
        r105[21] = TuplesKt.to("is_cjpay", 1);
        r105[22] = TuplesKt.to("is_grey_channel", Integer.valueOf(CJEnv.f().isGreyChannel() ? 1 : 0));
        if (r110 == null) goto L26;
        String r111 = CollectionsKt.joinToString$default(r110.f202261g, ",", null, null, 0, null, null, 62, null);
        if (r111 == null) goto L26;
        r109 = r111;
    L26:
        r105[23] = TuplesKt.to("cj_biz_tag", r109);
        return MapsKt.hashMapOf(r105);
    L16:
        r108 = null;
        goto L17
    L12:
        r107 = null;
        goto L13
    L6:
        if ((SystemClock.uptimeMillis() - ((CJHostService) r102.getValue()).getColdBootBeginUptimeMS()) < r101.f202765a.f202768a) goto L8;
        r103 = r101.f202767c.invoke();
        goto L9
    L8:
        r103 = r101.f202766b;
        goto L9
    }

    public static HashMap e(CJContext r100) {
        HashMap r101 = d(r100);
        Long r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.f202255a;
    L6:
        r101.put(CJPayBaseConstant.CLIENT_SESSION_ID, r103);
        if (r100 == null) goto L9;
        r102 = Long.valueOf(r100.f202259e);
    L9:
        r101.put("client_base_time", r102);
        return r101;
    L5:
        r103 = null;
        goto L6
    }

    public static final void a(String r100, Map r101) {
        if (Intrinsics.areEqual((Boolean) f202304k.getValue(), Boolean.TRUE) == true) goto L11;
        return;
    L11:
        HashMap r102 = e(null);     // Catch: Throwable -> L8
        r102.put("cj_white_uid", CJEnv.h());     // Catch: Throwable -> L8
        r102.put("original_event", r100);     // Catch: Throwable -> L8
        r102.put(r100, r101);     // Catch: Throwable -> L8
        JSONObject r103 = com.bytedance.caijing.sdk.infra.utils.d.a(r102);     // Catch: Throwable -> L8
        ((AppLogService) f202295b.getValue()).onEventV3("wallet_rd_white_monitor", r103);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        CJLogger.b("CJReporter", th.toString());
    }

    public static final void c(String r100, JSONObject r101) {
        i r102 = f202302i;     // Catch: Throwable -> L12
        if (r102 == null) goto L6;
        r102.onEventV3(r100, r101);     // Catch: Throwable -> L12
    L7:
        int r103 = com.bytedance.caijing.sdk.infra.base.logger.a.f202761a;     // Catch: Throwable -> L12
        String r104 = r101.toString();     // Catch: Throwable -> L12
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        Intrinsics.checkNotNullParameter("CJReporter", "tag");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r100, "name");     // Catch: Throwable -> L12
        CJLogger.d("CJReporter", "tea:[" + r100 + "]:[" + r104 + ']');     // Catch: Throwable -> L12
        return;
    L6:
        ((AppLogService) f202295b.getValue()).onEventV3(r100, r101);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CJLogger.b("CJReporter", th.toString());
        if (CJEnv.n() == true) goto L17;
        return;
    L17:
        throw new RuntimeException(th);
    }

    public final void j(String r100, CJContext r110) {
        Intrinsics.checkNotNullParameter(r100, "bizModule");
        if (f202300g.getAndSet(true) == true) goto L9;
        CJLogger.b("CJReporter", "reportCJSDKLaunch, bizModule: " + r100);
        if (r110 != null) goto L7;
        Set<String> r111 = CJContext.f202254w;
        r110 = CJContext.c.b(r100, "", "");
    L7:
        h(this, r110, EventConstants.Label.SDK_SESSION_LAUNCH, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(EventConstants.ExtraJson.KEY_SDK_AID, Integer.valueOf(CJEnv.f202291d)), TuplesKt.to("sdk_version", CJEnv.m()), TuplesKt.to("app_version", CJEnv.i()), TuplesKt.to("update_version_code", String.valueOf(CJEnv.g())), TuplesKt.to("os_version", Build.VERSION.RELEASE)}), null, 56);
        return;
    }

    public static final void b(String r100, JSONObject r101, JSONObject r102) {
        MonitorService r103 = (MonitorService) f202296c.getValue();     // Catch: Throwable -> L7
        if (r103 == null) goto L10;
        r103.monitorEvent(String.valueOf(CJEnv.f202291d), r100, r101, r102, null);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        CJLogger.b("CJReporter", th.toString());
        if (CJEnv.n() == true) goto L12;
        return;
    L12:
        throw new RuntimeException(th);
    }

    public static /* synthetic */ void o(CJContext r100, String r101, Map r102) {
        n(r100, r101, r102, null, -1, true);
    }

    public static void i(CJContext r110, String r111, String r210, Map r211) {
        Intrinsics.checkNotNullParameter(r110, "cjContext");
        Intrinsics.checkNotNullParameter(r111, "eventName");
        Intrinsics.checkNotNullParameter(r210, "btmToken");
        Intrinsics.checkNotNullParameter(r211, "evtParams");
        IPluginSettingsHelper r100 = f();
        if (r100 == null) goto L7;
        ke4.a r101 = r100.getReportConfig();
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(r101.isBlackTeaEvent(r111));
    L8:
        if (r102 == null) goto L10;
        boolean r103 = r102.booleanValue();
    L11:
        if (r103 == false) goto L13;
        CJLogger.d("CJReporter", "black tea event: " + r111);
        return;
    L13:
        Iterator r112 = CollectionsKt.filterNotNull(f202303j).iterator();
    L15:
        if (r112.hasNext() == false) goto L18;
        ((e) r112.next()).onSubmitEvent(r110, r111, r211, -1);
        goto L15
    L18:
        if (r211.get("btm") != null) goto L20;
        Map r104 = MapsKt.toMutableMap(r211);
        r104.put("btm", r210);
        Map r105 = r104;
    L21:
        ((LinkedBlockingDeque) f202299f.getValue()).offer(new h("biz", r110, r111, r105, null, System.currentTimeMillis(), false, "", r210, null));
        com.bytedance.caijing.sdk.infra.base.task.b.e(b.f202347a, 0);
        return;
    L20:
        r105 = r211;
        goto L21
    L10:
        r103 = false;
    L7:
        r102 = null;
        goto L8
    }

    public static void k(CJContext r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "exceptionEventName");
        Intrinsics.checkNotNullParameter(r103, "errInfo");
        CJTask r104 = new CJTask(new a(r101, r103, r100, r102));
        CJTask.f202763b.getValue().executeLogic(r104);
    }

    public static void m(CJContext r100, String r101, int r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r101, "exceptionEventName");
        l(r100, r101, r102, "", r103);
    }

    public static void l(CJContext r100, String r101, int r102, String r103, Throwable r104) {
        Intrinsics.checkNotNullParameter(r101, "exceptionEventName");
        Intrinsics.checkNotNullParameter(r103, "errInfo");
        if (r104 == null) goto L5;
        r103 = r103 + r104 + ':' + Log.getStackTraceString(r104);
    L5:
        k(r100, r101, r102, r103);
    }

    public static void g(CJContext r110, String r111, Map r210, tf4.a r211, long r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r110, "cjContext");
        Intrinsics.checkNotNullParameter(r111, "eventName");
        Intrinsics.checkNotNullParameter(r210, "evtParams");
        Intrinsics.checkNotNullParameter(r110, "cjContext");
        Intrinsics.checkNotNullParameter(r111, "eventName");
        Intrinsics.checkNotNullParameter(r210, "evtParams");
        Intrinsics.checkNotNullParameter("", "btmEvent");
        Intrinsics.checkNotNullParameter("", "btmToken");
        IPluginSettingsHelper r100 = f();
        if (r100 == null) goto L7;
        ke4.a r101 = r100.getReportConfig();
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(r101.isBlackTeaEvent(r111));
    L8:
        if (r102 == null) goto L10;
        boolean r103 = r102.booleanValue();
    L11:
        if (r103 == false) goto L13;
        CJLogger.d("CJReporter", "black tea event: " + r111);
        return;
    L13:
        Iterator r112 = CollectionsKt.filterNotNull(f202303j).iterator();
    L15:
        if (r112.hasNext() == false) goto L19;
        e r104 = (e) r112.next();
        if (r104 == null) goto L15;
        r104.onSubmitEvent(r110, r111, r210, r212);
        goto L15
    L19:
        LinkedBlockingDeque r113 = (LinkedBlockingDeque) f202299f.getValue();
        if (r212 >= 0) goto L22;
        long r114 = System.currentTimeMillis();
    L23:
        r113.offer(new h("biz", r110, r111, r210, r211, r114, r213, "", "", null));
        com.bytedance.caijing.sdk.infra.base.task.b.e(b.f202347a, 0);
        return;
    L22:
        r114 = r212;
        goto L23
    L10:
        r103 = false;
    L7:
        r102 = null;
        goto L8
    }

    public static /* synthetic */ void h(CJReporter r100, CJContext r101, String r102, Map r110, tf4.a r111, int r112) {
        if ((r112 & 8) == 0) goto L5;
        r111 = null;
    L5:
        tf4.a r103 = r111;
        if ((r112 & 16) == 0) goto L8;
        long r113 = -1;
    L9:
        r100.getClass();
        g(r101, r102, r110, r103, r113, false);
        return;
    L8:
        r113 = 0;
        goto L9
    }

    public static void n(CJContext r110, String r111, Map r112, tf4.a r113, long r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r110, "cjContext");
        Intrinsics.checkNotNullParameter(r111, "eventName");
        Intrinsics.checkNotNullParameter(r112, "evtParams");
        IPluginSettingsHelper r100 = f();
        if (r100 == null) goto L7;
        ke4.a r101 = r100.getReportConfig();
        if (r101 == null) goto L7;
        Boolean r102 = Boolean.valueOf(r101.isBlackSlardarEvent(r111));
    L8:
        if (r102 == null) goto L10;
        boolean r103 = r102.booleanValue();
    L11:
        if (r103 == false) goto L14;
        CJLogger.d("CJReporter", "black slardar event: " + r111);
        return;
    L14:
        LinkedBlockingDeque r114 = (LinkedBlockingDeque) f202299f.getValue();
        if (r210 >= 0) goto L17;
        long r104 = System.currentTimeMillis();
    L18:
        r114.offer(new h("custom", r110, r111, r112, r113, r104, r211, null, null, null));
        com.bytedance.caijing.sdk.infra.base.task.b.e(b.f202347a, 0);
        return;
    L17:
        r104 = r210;
        goto L18
    L10:
        r103 = false;
    L7:
        r102 = null;
        goto L8
    }
}
