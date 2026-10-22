package com.larus.reach.impl;

import android.content.Context;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.ServiceType;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachCustomClickResult;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.reach.runtime.ReachBannerRuntime;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f367155b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f367156a;

    /* JADX INFO: renamed from: com.larus.reach.impl.a$a, reason: collision with other inner class name */
    public static final class C4478a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367157a = null;

        static {
            int[] r100 = new int[ReachCustomClickResult.values().length];
            r100[ReachCustomClickResult.LOCAL_HANDLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ReachCustomClickResult.SCENE_HANDLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ReachCustomClickResult.NOT_HANDLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f367157a = r100;
        }
    }

    static {
    }

    public a() {
        this.f367156a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static void c(ns9.t r100, ns9.e r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "click");
        ConcurrentHashMap<String, Long> r102 = com.larus.reach.impl.b.f367163a;
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "click");
        if (c.a(r100) == false) goto L27;
        int r103 = com.larus.reach.impl.b.a.f367164a[r101.f520368a.ordinal()];
        if (r103 != 1) goto L8;
        com.larus.platform.service.o.f365780a.reportEvent("inapp_push_click", com.larus.reach.impl.b.a(r100));
        goto L27
    L8:
        if (r103 != 2) goto L10;
    L14:
        ns9.d r104 = r101.f520369b;
        if (r104 == null) goto L27;
        ReachButtonType r105 = r104.getType();
        if (r105 == null) goto L27;
        int r106 = com.larus.reach.impl.b.a.f367165b[r105.ordinal()];
        if (r106 == 1) goto L24;
        if (r106 != 2) goto L23;
        String r107 = "close";
    L25:
        com.larus.platform.service.o r108 = com.larus.platform.service.o.f365780a;
        JSONObject r109 = com.larus.reach.impl.b.a(r100);
        r109.put(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r107);
        Unit r110 = Unit.INSTANCE;
        r108.reportEvent("inapp_push_click_button", r109);
        goto L27
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        r107 = "normal";
        goto L25
    L10:
        if (r103 == 3) goto L14;
        throw new NoWhenBranchMatchedException();
    L27:
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r111 = com.larus.reach.runtime.y.f367359a;
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "click");
        Iterator r112 = com.larus.reach.runtime.y.h(r100.f520408a.f520395c).iterator();
    L29:
        if (r112.hasNext() == false) goto L38;
        ReachSceneLifecycleListener r113 = (ReachSceneLifecycleListener) r112.next();
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L33
        r113.h(r100, r101);     // Catch: Throwable -> L33
        Object r115 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
        if (r116 == null) goto L29;
        FLogger.f375446a.w("ReachSceneDispatcher", "reach scene onClick failed, reachUniqueId=" + r100.f520408a.f520400h + ", scene=" + r100.f520408a.f520395c, r116);
    L33:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    }

    public final boolean b(Context r110, ns9.t r111, ReachBannerRuntime.f r112, ns9.e r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "request");
        Intrinsics.checkNotNullParameter(r112, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r113, "click");
        c(r111, r113);
        ReachCustomClickResult r114 = r112.d(r113);
        int r115 = b.f367157a[r114.ordinal()];
        if (r115 != 1) goto L5;
    L16:
        return true;
    L5:
        if (r115 == 2) goto L16;
        if (r115 != 3) goto L15;
        if (r113.f520370c.isEmpty() == false) goto L12;
        return false;
    L12:
        Context r100 = r110.getApplicationContext();
        BuildersKt.launch$default(this.f367156a, null, null, new ReachActionExecutor$execute$1(r113, this, r100, r111, null), 3, null);
        return true;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public static final Object a(a r110, Context r111, ns9.t r112, ns9.e r210, ns9.b r211, Continuation r212) {
        r110.getClass();
        if ((r212 instanceof ReachActionExecutor$sendRequest$1) == false) goto L7;
        ReachActionExecutor$sendRequest$1 r100 = (ReachActionExecutor$sendRequest$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L39:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ns9.e r104 = (ns9.e) r100.L$2;
        ns9.t r105 = (ns9.t) r100.L$1;
        Context r106 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
        ns9.e r107 = r104;
        ns9.t r108 = r105;
        Context r109 = r106;
    L35:
        dm9.a r114 = (dm9.a) r102;
        MainCoroutineDispatcher r115 = Dispatchers.getMain();
        ReachActionExecutor$sendRequest$2 r116 = new ReachActionExecutor$sendRequest$2(r110, r109, r108, r107, r114, null);
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 2;
        if (BuildersKt.withContext(r115, r116, r100) != r113) goto L39;
        return r113;
    L16:
        ResultKt.throwOnFailure(r102);
        Map<String, String> r117 = r211.f520361b;
        if (r117 == null) goto L23;
        String r118 = r117.get("biz_req_psm");
        if (r118 == null) goto L23;
        if ((!StringsKt.isBlank(r118)) == false) goto L23;
    L24:
        if (r117 == null) goto L30;
        String r119 = r117.get("biz_req_id");
        if (r119 == null) goto L30;
        if ((!StringsKt.isBlank(r119)) == false) goto L30;
    L31:
        FlowHttpConnection r120 = FlowHttpConnection.f359975a;
        ReachActionExecutor$sendRequest$result$1 r121 = new ReachActionExecutor$sendRequest$result$1(r118, r119, r117, null);
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.L$2 = r210;
        r100.label = 1;
        r102 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, ReachActionApi.class, r121, true, null, null, null, r100, 240);
        if (r102 == r113) goto L40;
        r109 = r111;
        r108 = r112;
        r107 = r210;
        goto L35
    L40:
        return r113;
    L30:
        r119 = null;
    L23:
        r118 = null;
    L7:
        r100 = new ReachActionExecutor$sendRequest$1(r110, r212);
        goto L8
    }
}
