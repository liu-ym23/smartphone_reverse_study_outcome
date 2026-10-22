package com.larus.navigation.api.baidu;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH\u0096\u0001J\u000b\u0010\f\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0010\u0010\r\u001a\u0004\u0018\u00010\bH\u0096\u0001¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0019H\u0096\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u001bH\u0096\u0001JI\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\t2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u00142\b\u0010#\u001a\u0004\u0018\u00010\tH\u0096\u0001J\u0011\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\tH\u0096\u0001J\u0011\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H\u0096\u0001R\u0012\u0010)\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/larus/navigation/api/baidu/BaiduNaviServiceDelegate;", "Lcom/larus/navigation/api/baidu/BaiduNaviService;", "<init>", "()V", "active", "", "callback", "Lkotlin/Function2;", "", "", "addCallback", "Lcom/larus/navigation/api/baidu/BaiduNaviCallback;", "getCurrentRouteId", "getCurrentRoutePlanType", "()Ljava/lang/Integer;", "getCurrentSessionId", "init", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDebug", "", "removeCallback", "routePlan", "param", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviRoutePlanParam;", "Lcom/larus/navigation/api/baidu/BaiduNaviPlanCallback;", "setNotificationCallback", "Lcom/larus/navigation/api/baidu/BaiduNaviNotificationCallback;", "startNavigation", "sessionId", "routePlanType", "routeId", "guidanceRange", "Lkotlin/Pair;", "showNotification", "verbalMode", "stopNavigation", "reason", "updateLocation", "locInfo", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviLocInfo;", "isNavigating", "()Z", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaiduNaviServiceDelegate implements BaiduNaviService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BaiduNaviServiceDelegate f359647b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaiduNaviService f359648a;

    static {
        f359647b = new BaiduNaviServiceDelegate();
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        return this.f359648a.a(r100);
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final boolean b() {
        return this.f359648a.b();
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void d(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f359648a.d(r100, r101);
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "locInfo");
        this.f359648a.e(r100);
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void f(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f359648a.f(r100);
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void g(tl9.c r100) {
        this.f359648a.g(r100);
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void h(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f359648a.h(r100);
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void i(Function2<? super Integer, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f359648a.i(r100);
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void j(g r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f359648a.j(r100, r101);
    }

    @Override // com.larus.navigation.api.baidu.BaiduNaviService
    public final void k(String r100, int r110, String r111, Pair<Integer, Integer> r112, boolean r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r111, "routeId");
        this.f359648a.k(r100, r110, r111, r112, r113, r114);
    }

    private BaiduNaviServiceDelegate() {
        BaiduNaviService r100 = (BaiduNaviService) ServiceManager.get().getService(BaiduNaviService.class);
        if (r100 != null) goto L5;
        r100 = NoopBaiduNaviService.f359649a;
    L5:
        this.f359648a = r100;
    }
}
