package com.larus.navigation.impl;

import android.app.Application;
import android.os.SystemClock;
import androidx.camera.video.AudioStats;
import com.larus.common.apphost.AppHost;
import com.larus.navigation.api.NavigationService;
import com.larus.navigation.api.baidu.BaiduNaviService;
import com.larus.navigation.api.r;
import com.larus.navigation.api.y;
import com.larus.navigation.api.z;
import com.larus.trace.RealTimeNavEndReason;
import com.larus.trace.RealTimeNavStartFailReason;
import com.larus.trace.RealTimeNavStartResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J<\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002JN\u0010&\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020(H\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00101\u001a\u00020\rH\u0016J\u0010\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020(H\u0016J\u0012\u00104\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016J\b\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u001aH\u0002J\u0010\u00107\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0017\u00108\u001a\u00020(2\b\u00109\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0002\u0010:R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u00100\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0012¨\u0006<"}, d2 = {"Lcom/larus/navigation/impl/BaiduNavigationEngine;", "Lcom/larus/navigation/api/NavigationService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "callback", "Lcom/larus/navigation/api/NavigationCallback;", "notificationCallback", "Lcom/larus/navigation/api/NavigationNotificationCallback;", "callbackBridge", "Lcom/larus/navigation/api/baidu/BaiduNaviCallback;", "_isNavigating", "", "isAuthDone", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitRegistered", "isNavigating", "()Z", "initIfNeeded", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDebug", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNavigationInitialized", "startNavigation", "", "param", "Lcom/larus/navigation/api/NavigationStartParam;", "doStartNavigation", "naviService", "Lcom/larus/navigation/api/baidu/BaiduNaviService;", "doRoutePlan", "startPoint", "Lcom/larus/navigation/api/FlowNaviGeoPoint;", "guidanceRange", "Lkotlin/Pair;", "", "doStartWithRoute", "sessionId", "", "routeId", "plan", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviRoutePlan;", "stopNavigation", "reason", "enableVoiceGuidance", "disableVoiceGuidance", "isVoiceGuidanceEnabled", "isTTSAvailable", "preloadRouteData", "routeDataJson", "setNotificationCallback", "onNavigationStopped", "cleanupCallbackBridge", "logParams", "toVerbalMode", "mode", "(Ljava/lang/Integer;)Ljava/lang/String;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaiduNavigationEngine implements NavigationService {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f359725h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f359726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.larus.navigation.api.i f359727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.larus.navigation.api.p f359728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s f359729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f359730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f359731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f359732g;

    public static final class a {
    }

    public static final class b implements tl9.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f359733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaiduNavigationEngine f359734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaiduNaviService f359735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.larus.navigation.api.w f359736d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Pair<Integer, Integer> f359737e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.larus.navigation.api.i f359738f;

        @Override // tl9.d
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "errorMsg");
            bm9.a r101 = bm9.a.f19654a;
            bm9.a.f19661h = Long.valueOf(SystemClock.elapsedRealtime() - this.f359733a);
            r101.b("errorMsg", r100);
            bm9.a.e(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.ROUTE_ERROR, null, 4);
            int r102 = com.larus.navigation.api.c.f359656a;
            com.larus.navigation.api.c.b("legacy_adapter", "routePlan failed: messageLength=" + r100.length());
            this.f359738f.a(this.f359736d.f359702f, 5, r100);
            this.f359734b.f359730e = false;
        }

        @Override // tl9.d
        public final void b(ul9.f r110) {
            Intrinsics.checkNotNullParameter(r110, "plan");
            bm9.a r100 = bm9.a.f19654a;
            bm9.a.f19661h = Long.valueOf(SystemClock.elapsedRealtime() - this.f359733a);
            String r101 = r110.b();
            List<ul9.e> r102 = r110.a();
            if (r102 == null) goto L7;
            ul9.e r103 = (ul9.e) CollectionsKt.firstOrNull(r102);
            if (r103 == null) goto L7;
            String r111 = r103.e();
        L9:
            if (r101 == null) goto L22;
            if (r111 == null) goto L22;
            int r104 = com.larus.navigation.api.c.f359656a;
            com.larus.navigation.api.c.d("legacy_adapter", "routePlan success, sessionId[" + r101 + ']');
            BaiduNavigationEngine r105 = this.f359734b;
            BaiduNaviService r106 = this.f359735c;
            com.larus.navigation.api.w r112 = this.f359736d;
            Pair<Integer, Integer> r107 = this.f359737e;
            int r108 = BaiduNavigationEngine.f359725h;
            r105.getClass();
            com.larus.navigation.api.c.d("legacy_adapter", "startNavigation with routeId[" + r111 + ']');
            s r109 = r105.f359729d;
            if ((r109 instanceof s) == true) goto L15;
            r109 = null;
        L15:
            if (r109 == null) goto L17;
            r109.f359961f = r110;
        L17:
            r106.g(new t(r105.f359728c));
            boolean r113 = !z.a();
            int r114 = r112.f359699c;
            Integer r115 = r112.f359701e;
            if (r115 == null) goto L20;
            String r116 = BaiduNavigationEngine.o(Integer.valueOf(r115.intValue()));
        L21:
            r106.k(r101, r114, r111, r107, r113, r116);
            bm9.a.e(RealTimeNavStartResult.SUCCESS, null, null, 6);
            JSONObject r117 = new JSONObject();
            r117.put("navigate_unique_id", r112.f359702f);
            com.larus.navigation.impl.location.d.a(r101, r111, r112, r117, r110);
            return;
        L20:
            r116 = null;
        L22:
            com.larus.navigation.api.c.b("legacy_adapter", "routePlan success but no route");
            r100.b("error", "succeed_but_no_route");
            bm9.a.e(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.ROUTE_ERROR, null, 4);
            this.f359738f.a(this.f359736d.f359702f, 5, "no_route");
            this.f359734b.f359730e = false;
            return;
        L7:
            r111 = null;
            goto L9
        }

        public b(long r100, BaiduNavigationEngine r101, BaiduNaviService r102, com.larus.navigation.api.w r103, Pair<Integer, Integer> r104, com.larus.navigation.api.i r105) {
            this.f359733a = r100;
            this.f359734b = r101;
            this.f359735c = r102;
            this.f359736d = r103;
            this.f359737e = r104;
            this.f359738f = r105;
        }
    }

    static {
    }

    @Override // com.larus.navigation.api.NavigationService
    public final String c() {
        return null;
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void e() {
    }

    @Override // com.larus.navigation.api.NavigationService
    public final boolean h() {
        return false;
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void m() {
    }

    public final void i() {
        s r100 = this.f359729d;
        if (r100 == null) goto L7;
        BaiduNaviService r101 = (BaiduNaviService) ServiceManager.get().getService(BaiduNaviService.class);
        if (r101 == null) goto L7;
        r101.h(r100);
    L7:
        this.f359729d = null;
    }

    @Override // com.larus.navigation.api.NavigationService
    public final com.larus.navigation.api.g l() {
        return new com.larus.navigation.api.g(DataLoaderHelper.DATALOADER_KEY_INT_DEV_DISK_SIZE_MB, null);
    }

    public BaiduNavigationEngine() {
        this.f359726a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f359731f = new AtomicBoolean(false);
        this.f359732g = new AtomicBoolean(false);
    }

    @Override // com.larus.navigation.api.NavigationService
    public final boolean b() {
        return this.f359730e;
    }

    public static String o(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 == null) goto L15;
        r100.intValue();
    L15:
        return "standard";
    L10:
        if (r100.intValue() != 1) goto L12;
        return "simple_v2";
    L5:
        if (r100.intValue() != 0) goto L7;
        return "simple";
    }

    @Override // com.larus.navigation.api.NavigationService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        BaiduNaviService r101 = (BaiduNaviService) ServiceManager.get().getService(BaiduNaviService.class);
        if (r101 != null) goto L5;
        return false;
    L5:
        com.larus.navigation.impl.location.d.b(r100);
        s r102 = this.f359729d;
        if ((r102 instanceof s) == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        r102.f();
    L11:
        r101.a(r100);
        i();
        this.f359730e = false;
        return true;
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void k(com.bytedance.applet.aibridge.navigation.m r100) {
        this.f359728c = r100;
    }

    @Override // com.larus.navigation.api.NavigationService
    public final r f(String r100, List<y> r101) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "wayPoints");
        return new r(null, 1, "waypoint_update_not_supported");
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void g(final com.larus.navigation.api.w r110, final com.larus.navigation.api.i r111) {
        Intrinsics.checkNotNullParameter(r110, "param");
        Intrinsics.checkNotNullParameter(r111, "callback");
        this.f359727b = r111;
        this.f359730e = true;
        bm9.a r100 = bm9.a.f19654a;
        r100.c();
        bm9.a.f19656c = 0;
        bm9.a.f19655b = r110.f359702f;
        bm9.a.f19657d = Long.valueOf(SystemClock.elapsedRealtime());
        final BaiduNaviService r101 = (BaiduNaviService) ServiceManager.get().getService(BaiduNaviService.class);
        if (r101 != null) goto L7;
        com.larus.navigation.api.c.b("legacy_adapter", "startNavigation: naviService is null");
        r100.b("error", "no_service");
        bm9.a.e(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.CODE_ERROR, null, 4);
        r111.a(r110.f359702f, 5, "no_service");
        this.f359730e = false;
        return;
    L7:
        if (r101.b() == false) goto L10;
        r100.a("new_nav_unique_id", r110.f359702f);
        bm9.a.d(RealTimeNavEndReason.NEW_NAV, null, 2);
        com.larus.navigation.impl.location.d.b("new_nav");
        r101.a("new_nav");
        r100.c();
        bm9.a.f19656c = 0;
        bm9.a.f19655b = r110.f359702f;
        bm9.a.f19657d = Long.valueOf(SystemClock.elapsedRealtime());
    L10:
        if (this.f359732g.compareAndSet(false, true) == false) goto L17;
        long r102 = SystemClock.elapsedRealtime();
        Application r103 = AppHost.f326268a.getApplication();
        if (r103 != null) goto L15;
        com.larus.navigation.api.c.b("legacy_adapter", "init: AppHost.application is null");
        r111.a(r110.f359702f, 5, "no_app_context");
        this.f359730e = false;
        return;
    L15:
        r101.d(r103, tl9.b.a());
        bm9.a.f19658e = Long.valueOf(SystemClock.elapsedRealtime() - r102);
    L17:
        if (this.f359731f.get() == true) goto L20;
        final long r104 = SystemClock.elapsedRealtime();
        r101.i(new d(r104, this, r111, r110, r101));
        return;
    L20:
        BuildersKt.launch$default(this.f359726a, null, null, new BaiduNavigationEngine$startNavigation$2(this, r101, r110, r111, null), 3, null);
    }

    public static final void d(BaiduNavigationEngine r110, BaiduNaviService r111, com.larus.navigation.api.w r112, com.larus.navigation.api.i r113) {
        r110.getClass();
        if (tl9.b.a() == false) goto L5;
        int r100 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.a("legacy_adapter", "[startWithParam]:startPoint[" + r112.f359697a + ']');
        com.larus.navigation.api.c.a("legacy_adapter", "[startWithParam]:endPoint[" + r112.f359698b + ']');
    L5:
        int r101 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("legacy_adapter", "[startWithParam]:routePlanType[" + r112.f359699c + ']');
        com.larus.navigation.api.c.d("legacy_adapter", "[startWithParam]:prefer[" + r112.f359700d + ']');
        com.larus.navigation.api.c.d("legacy_adapter", "[startWithParam]:verbalMode[" + r112.f359701e + ']');
        com.larus.navigation.api.c.d("legacy_adapter", "[startWithParam]:navigateUniqueId[" + r112.f359702f + ']');
        List<y> r102 = r112.f359713q;
        List<y> r103 = r102;
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L14;
        com.larus.navigation.api.c.e("legacy_adapter", "legacy Baidu engine ignores wayPoints, count=" + r102.size());
    L14:
        r110.i();
        s r105 = new s(r113, r112, new BaiduNavigationEngine$doStartNavigation$bridge$1(r110));
        r110.f359729d = r105;
        r111.f(r105);
        int r106 = r112.f359699c;
        if (r106 == 1) goto L19;
        if (r106 == 2) goto L18;
        Pair<Integer, Integer> r107 = TuplesKt.to(-5, 5);
    L20:
        Pair<Integer, Integer> r108 = r107;
        com.larus.navigation.api.a r109 = r112.f359697a;
        if (r109 == null) goto L23;
        r110.n(r111, r112, r109, r108, r113);
        return;
    L23:
        NavigationDispatcher.a r114 = NavigationDispatcher.f359763e;
        com.larus.navigation.api.c.d("legacy_adapter", "no start point, resolving current location");
        JSONObject r115 = new JSONObject();
        r115.put("navigate_unique_id", r112.f359702f);
        com.larus.navigation.impl.location.e.b(r115, new e(SystemClock.elapsedRealtime(), r110, r111, r112, r108, r113), 2);
        return;
    L18:
        r107 = TuplesKt.to(-20, 50);
        goto L20
    L19:
        r107 = TuplesKt.to(-10, 20);
        goto L20
    L8:
        if (r103.isEmpty() == true) goto L11;
        r104 = false;
        goto L12
    }

    public final void n(BaiduNaviService r310, com.larus.navigation.api.w r311, com.larus.navigation.api.a r312, Pair<Integer, Integer> r313, com.larus.navigation.api.i r314) {
        com.larus.navigation.api.a r100 = r311.f359698b;
        if (r311.f359699c != 2) goto L7;
        Integer r101 = r311.f359700d;
        if (r101 == null) goto L7;
        int r110 = r101.intValue();
    L8:
        ul9.g r102 = new ul9.g(new ul9.a(r312.f359643a, r312.f359644b, AudioStats.AUDIO_AMPLITUDE_NONE), new ul9.a(r100.f359643a, r100.f359644b, AudioStats.AUDIO_AMPLITUDE_NONE), r311.f359699c, r110, o(r311.f359701e), r313, null, null, 3840);
        NavigationDispatcher.a r103 = NavigationDispatcher.f359763e;
        r310.j(r102, new b(SystemClock.elapsedRealtime(), this, r310, r311, r313, r314));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        int r104 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("legacy_adapter", "routePlan threw: " + e.getMessage(), e);
        bm9.a.f19654a.b("error", "routePlan_exception");
        bm9.a.e(RealTimeNavStartResult.FAILURE, RealTimeNavStartFailReason.ROUTE_ERROR, null, 4);
        r314.a(r311.f359702f, 5, "routePlan_exception: " + e.getMessage());
        this.f359730e = false;
        return;
    L7:
        r110 = 0;
        goto L8
    }
}
