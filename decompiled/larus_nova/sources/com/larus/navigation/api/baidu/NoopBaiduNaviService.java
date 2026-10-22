package com.larus.navigation.api.baidu;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tl9.a;
import tl9.d;
import ul9.c;
import ul9.g;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J$\u0010\n\u001a\u00020\u00052\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00050\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0012H\u0016JH\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000e2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020!H\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010$H\u0016J\n\u0010'\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u000eH\u0016J\u000f\u0010)\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010*R\u0014\u0010%\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010+\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/navigation/api/baidu/NoopBaiduNaviService;", "Lcom/larus/navigation/api/baidu/BaiduNaviService;", "<init>", "()V", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDebug", "", "active", "callback", "Lkotlin/Function2;", "", "", "routePlan", "param", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviRoutePlanParam;", "Lcom/larus/navigation/api/baidu/BaiduNaviPlanCallback;", "startNavigation", "sessionId", "routePlanType", "routeId", "guidanceRange", "Lkotlin/Pair;", "showNotification", "verbalMode", "updateLocation", "locInfo", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviLocInfo;", "stopNavigation", "reason", "addCallback", "Lcom/larus/navigation/api/baidu/BaiduNaviCallback;", "removeCallback", "setNotificationCallback", "Lcom/larus/navigation/api/baidu/BaiduNaviNotificationCallback;", "isNavigating", "()Z", "getCurrentSessionId", "getCurrentRouteId", "getCurrentRoutePlanType", "()Ljava/lang/Integer;", "ERROR_CODE_SERVICE_UNAVAILABLE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopBaiduNaviService implements BaiduNaviService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NoopBaiduNaviService f359649a = null;

    static {
        f359649a = new NoopBaiduNaviService();
    }

    private NoopBaiduNaviService() {
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        return false;
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final boolean b() {
        return false;
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void d(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "locInfo");
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void f(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void g(tl9.c r100) {
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void h(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void k(String r100, int r101, String r102, Pair<Integer, Integer> r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "routeId");
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void i(Function2<? super Integer, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        r100.invoke(-1, "BaiduNaviService unavailable");
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void j(g r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r101.a("BaiduNaviService unavailable");
    }
}
