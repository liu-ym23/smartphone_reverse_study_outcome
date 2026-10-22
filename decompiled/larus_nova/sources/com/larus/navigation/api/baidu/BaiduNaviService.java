package com.larus.navigation.api.baidu;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tl9.a;
import tl9.d;
import ul9.c;
import ul9.g;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\b\u001a\u00020\u00032\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00030\nH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0010H&JJ\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\f2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\fH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u001fH&J\u0012\u0010!\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\"H&J\n\u0010%\u001a\u0004\u0018\u00010\fH&J\n\u0010&\u001a\u0004\u0018\u00010\fH&J\u000f\u0010'\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010(R\u0012\u0010#\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/larus/navigation/api/baidu/BaiduNaviService;", "", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDebug", "", "active", "callback", "Lkotlin/Function2;", "", "", "routePlan", "param", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviRoutePlanParam;", "Lcom/larus/navigation/api/baidu/BaiduNaviPlanCallback;", "startNavigation", "sessionId", "routePlanType", "routeId", "guidanceRange", "Lkotlin/Pair;", "showNotification", "verbalMode", "updateLocation", "locInfo", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviLocInfo;", "stopNavigation", "reason", "addCallback", "Lcom/larus/navigation/api/baidu/BaiduNaviCallback;", "removeCallback", "setNotificationCallback", "Lcom/larus/navigation/api/baidu/BaiduNaviNotificationCallback;", "isNavigating", "()Z", "getCurrentSessionId", "getCurrentRouteId", "getCurrentRoutePlanType", "()Ljava/lang/Integer;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface BaiduNaviService {
    boolean a(String r100);

    boolean b();

    void d(Context r100, boolean r101);

    void e(c r100) throws Exception;

    void f(a r100);

    void g(tl9.c r100);

    void h(a r100);

    void i(Function2<? super Integer, ? super String, Unit> r100);

    void j(g r100, d r101) throws Exception;

    void k(String r100, int r101, String r102, Pair<Integer, Integer> r103, boolean r104, String r105) throws Exception;
}
