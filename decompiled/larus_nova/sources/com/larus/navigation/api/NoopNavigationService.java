package com.larus.navigation.api;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0015H\u0016J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\"H\u0016R\u0014\u0010\u0016\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u000e\u0010#\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/navigation/api/NoopNavigationService;", "Lcom/larus/navigation/api/NavigationService;", "<init>", "()V", "initIfNeeded", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDebug", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNavigationInitialized", "getNavigationSnapshot", "Lcom/larus/navigation/api/NavSnapshotResult;", "startNavigation", "", "param", "Lcom/larus/navigation/api/NavigationStartParam;", "callback", "Lcom/larus/navigation/api/NavigationCallback;", "stopNavigation", "reason", "", "isNavigating", "()Z", "currentNavigationId", "getCurrentNavigationId", "()Ljava/lang/String;", "enableVoiceGuidance", "disableVoiceGuidance", "isVoiceGuidanceEnabled", "isTTSAvailable", "preloadRouteData", "routeDataJson", "setNotificationCallback", "Lcom/larus/navigation/api/NavigationNotificationCallback;", "ERROR_CODE_SERVICE_UNAVAILABLE", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopNavigationService implements NavigationService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NoopNavigationService f359642a = null;

    static {
        f359642a = new NoopNavigationService();
    }

    private NoopNavigationService() {
    }

    @Override // com.larus.navigation.api.NavigationService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        return false;
    }

    @Override // com.larus.navigation.api.NavigationService
    public final boolean b() {
        return false;
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
    public final void k(com.bytedance.applet.aibridge.navigation.m r100) {
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void m() {
    }

    @Override // com.larus.navigation.api.NavigationService
    public final g l() {
        return new g(2001, null);
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
    }

    @Override // com.larus.navigation.api.NavigationService
    public final r f(String r100, List<y> r101) {
        Intrinsics.checkNotNullParameter(r100, "navigationId");
        Intrinsics.checkNotNullParameter(r101, "wayPoints");
        return new r(null, 1, "waypoint_update_not_supported");
    }

    @Override // com.larus.navigation.api.NavigationService
    public final void g(w r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.a(r100.f359702f, -1, "NavigationService unavailable");
    }
}
