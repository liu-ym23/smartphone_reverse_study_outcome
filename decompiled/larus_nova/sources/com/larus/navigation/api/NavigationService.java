package com.larus.navigation.api;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001e\u001a\u00020\nH&J\b\u0010\u001f\u001a\u00020\nH&J\b\u0010!\u001a\u00020\u0003H&J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0011H&J\u0012\u0010&\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010'H&R\u0012\u0010\u0019\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001a¨\u0006("}, d2 = {"Lcom/larus/navigation/api/NavigationService;", "", "initIfNeeded", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDebug", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNavigationInitialized", "startNavigation", "", "param", "Lcom/larus/navigation/api/NavigationStartParam;", "callback", "Lcom/larus/navigation/api/NavigationCallback;", "stopNavigation", "reason", "", "releaseQuickRestartRetentionOnStartFailure", "updateWaypoints", "Lcom/larus/navigation/api/NavigationRouteUpdateRequestResult;", "navigationId", "wayPoints", "", "Lcom/larus/navigation/api/NavigationWayPoint;", "isNavigating", "()Z", "currentNavigationId", "getCurrentNavigationId", "()Ljava/lang/String;", "enableVoiceGuidance", "disableVoiceGuidance", "isVoiceGuidanceEnabled", "isTTSAvailable", "getNavigationSnapshot", "Lcom/larus/navigation/api/NavSnapshotResult;", "preloadRouteData", "routeDataJson", "setNotificationCallback", "Lcom/larus/navigation/api/NavigationNotificationCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface NavigationService {
    boolean a(String r100);

    boolean b();

    String c();

    void e();

    r f(String r100, List<y> r101);

    void g(w r100, i r101);

    boolean h();

    void j(String r100);

    void k(com.bytedance.applet.aibridge.navigation.m r100);

    g l();

    void m();
}
