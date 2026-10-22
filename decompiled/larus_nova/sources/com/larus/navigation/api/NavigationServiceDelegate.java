package com.larus.navigation.api;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\t\u0010\u0019\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u0096\u0001J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096A¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020\u001eH\u0096\u0001J\t\u0010$\u001a\u00020\u001eH\u0096\u0001J\u0011\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010'\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010)H\u0096\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0011\u0010*\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u000fH\u0096\u0001J\u001f\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000f2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0096\u0001R\u0016\u00101\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u0012\u00104\u001a\u00020\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00105R\u0012\u00106\u001a\u00020\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00105¨\u00067"}, d2 = {"Lcom/larus/navigation/api/NavigationServiceDelegate;", "Lcom/larus/navigation/api/NavigationService;", "Lcom/larus/navigation/api/NavigationStartHostCapability;", "Lcom/larus/navigation/api/NavigationPrewarmHostCapability;", "<init>", "()V", "startNavigation", "", "param", "Lcom/larus/navigation/api/NavigationStartParam;", "hostContext", "Lcom/larus/navigation/api/NavigationStartHostContext;", "callback", "Lcom/larus/navigation/api/NavigationCallback;", "startLocationPrewarm", "", "mode", "Lcom/larus/navigation/api/NavigationLocationPrewarmMode;", "traceContext", "Lcom/larus/navigation/api/NavigationTraceContextParam;", "markLightNavigationSelected", LocationMonitorConst.IDENTIFIER, "stopLocationPrewarm", "reason", "stopAllLocationPrewarm", "disableVoiceGuidance", "enableVoiceGuidance", "getNavigationSnapshot", "Lcom/larus/navigation/api/NavSnapshotResult;", "initIfNeeded", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDebug", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNavigationInitialized", "isTTSAvailable", "preloadRouteData", "routeDataJson", "releaseQuickRestartRetentionOnStartFailure", "setNotificationCallback", "Lcom/larus/navigation/api/NavigationNotificationCallback;", "stopNavigation", "updateWaypoints", "Lcom/larus/navigation/api/NavigationRouteUpdateRequestResult;", "navigationId", "wayPoints", "", "Lcom/larus/navigation/api/NavigationWayPoint;", "currentNavigationId", "getCurrentNavigationId", "()Ljava/lang/String;", "isNavigating", "()Z", "isVoiceGuidanceEnabled", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NavigationServiceDelegate implements NavigationService, u, q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NavigationServiceDelegate f359630b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigationService f359631a;

    static {
        f359630b = new NavigationServiceDelegate();
    }

    @Override // com.larus.navigation.api.NavigationService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        return this.f359631a.a(r100);
    }

    @Override // com.larus.navigation.api.NavigationService
    public final boolean b() {
        return this.f359631a.b();
    }

    @Override // com.larus.navigation.api.NavigationService
    public final String c() {
        return this.f359631a.c();
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void e() {
        this.f359631a.e();
    }

    @Override // com.larus.navigation.api.NavigationService
    public final r f(String r100, List<y> r101) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "wayPoints");
        return this.f359631a.f(r100, r101);
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void g(w r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f359631a.g(r100, r101);
    }

    @Override // com.larus.navigation.api.NavigationService
    public final boolean h() {
        return this.f359631a.h();
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f359631a.j(r100);
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void k(com.bytedance.applet.aibridge.navigation.m r100) {
        this.f359631a.k(r100);
    }

    @Override // com.larus.navigation.api.NavigationService
    public final g l() {
        return this.f359631a.l();
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void m() {
        this.f359631a.m();
    }

    @Override // com.larus.navigation.api.q
    public final void i() {
        Intrinsics.checkNotNullParameter("new_open_navigation_map", "reason");
        t.e(t.a());
    }

    private NavigationServiceDelegate() {
        this.f359631a = t.a();
    }

    @Override // com.larus.navigation.api.q
    public final void n(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        t.b(t.a(), r100);
    }

    @Override // com.larus.navigation.api.q
    public final void o(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        t.f(t.a(), r100, r101);
    }

    @Override // com.larus.navigation.api.q
    public final String p(NavigationLocationPrewarmMode r100, x r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        return t.c(t.a(), r100, r101);
    }

    @Override // com.larus.navigation.api.u
    public final void d(w r100, v r101, i r102) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "hostContext");
        Intrinsics.checkNotNullParameter(r102, "callback");
        t.d(t.a(), r100, r101, r102);
    }
}
