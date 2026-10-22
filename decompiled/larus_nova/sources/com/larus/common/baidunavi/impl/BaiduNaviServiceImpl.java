package com.larus.common.baidunavi.impl;

import com.larus.common.baidunavi.api.BaiduNaviService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import k09.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0011\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J$\u0010\u0018\u001a\u00020\u00142\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00140\u001aH\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020 H\u0016J>\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001c2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0018\u00010&2\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u001cH\u0016J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0012\u0010/\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u000100H\u0016J\n\u00101\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u00102\u001a\u0004\u0018\u00010\u001cH\u0016J\u000f\u00103\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u000207H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u00069"}, d2 = {"Lcom/larus/common/baidunavi/impl/BaiduNaviServiceImpl;", "Lcom/larus/common/baidunavi/api/BaiduNaviService;", "<init>", "()V", "currRouteInfo", "Lcom/larus/common/baidunavi/impl/bean/SimpleRouteInfo;", "isNavigating", "", "()Z", "baiduNaviCallbacks", "", "Lcom/larus/common/baidunavi/api/BaiduNaviCallback;", "naviNotificationCallback", "Lcom/larus/common/baidunavi/impl/callback/NaviCallbackNotificationAdapter;", "naviMsgCallback", "Lcom/baidu/naviapi/open/INaviMsgCallback;", "naviRouteChangeCallback", "com/larus/common/baidunavi/impl/BaiduNaviServiceImpl$naviRouteChangeCallback$1", "Lcom/larus/common/baidunavi/impl/BaiduNaviServiceImpl$naviRouteChangeCallback$1;", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isDebug", "active", "callback", "Lkotlin/Function2;", "", "", "routePlan", "param", "Lcom/larus/common/baidunavi/api/bean/BaiduNaviRoutePlanParam;", "Lcom/larus/common/baidunavi/api/BaiduNaviPlanCallback;", "startNavigation", "sessionId", "routePlanType", "routeId", "guidanceRange", "Lkotlin/Pair;", "showNotification", "updateLocation", "locInfo", "Lcom/larus/common/baidunavi/api/bean/BaiduNaviLocInfo;", "stopNavigation", "reason", "addCallback", "removeCallback", "setNotificationCallback", "Lcom/larus/common/baidunavi/api/BaiduNaviNotificationCallback;", "getCurrentSessionId", "getCurrentRouteId", "getCurrentRoutePlanType", "()Ljava/lang/Integer;", "setNavigationTaskListener", "listener", "Lcom/larus/common/baidunavi/api/BaiduNaviTaskListener;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaiduNaviServiceImpl implements BaiduNaviService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f326279b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f326280a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [k09.a] */
    public BaiduNaviServiceImpl() {
        ArrayList r100 = new ArrayList();
        this.f326280a = r100;
        new m09.a(new k09.a(this));
        Function0 r101 = new b(this);
        Intrinsics.checkNotNullParameter(r100, "callbacks");
        Intrinsics.checkNotNullParameter(r101, "routeInfoProvider");
    }
}
