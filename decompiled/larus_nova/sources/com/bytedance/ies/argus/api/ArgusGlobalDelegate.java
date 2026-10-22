package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.api.params.InjectLoginStateParams;
import com.bytedance.ies.argus.api.params.a0;
import com.bytedance.ies.argus.api.params.w;
import com.bytedance.ies.argus.api.params.x;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.i;
import com.bytedance.ies.argus.bean.k;
import com.bytedance.ies.argus.bean.n;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.strategy.StrategyCalculateHandler;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusGlobalDelegate {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<ArgusGlobalDelegate> f245624c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StrategyCalculateHandler f245625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BaseEventCenter f245626b;

    public static final class a {
        public static ArgusGlobalDelegate a() {
            return ArgusGlobalDelegate.f245624c.getValue();
        }
    }

    static {
        f245624c = LazyKt.lazy(ArgusGlobalDelegate$Companion$instance$2.INSTANCE);
    }

    public ArgusGlobalDelegate() {
        this.f245625a = new StrategyCalculateHandler(new c());
        this.f245626b = new BaseEventCenter(new b());
    }

    public final i a(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        BaseEventCenter.b r101 = new BaseEventCenter.b(this.f245626b, ArgusGlobalAspect.ABOUT_TO_PREFETCH, r100);
        Lazy<ArgusConfigManager> r102 = ArgusConfigManager.f246083j;
        if (ArgusConfigManager.a.a().a(r101.f245823a, r101.getContext().b()) == false) goto L6;
        int r103 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("BaseEventCenter", "argusBizId " + r101.getContext().b() + ", aspect: " + r101.f245823a.getStringValue() + " is disabled by recovery.");
        k r104 = new k();
        i.i(r104, ArgusCommonVerifyReason.ASPECT_DISABLE_BY_RECOVERY, null, 6);
        return r104;
    L6:
        if (r101.getContext().d() != null) goto L9;
        i r105 = r101.b();
        i.i(r105, ArgusCommonVerifyReason.ASPECT_CONFIG_IS_NULL, null, 6);
        return r105;
    L9:
        if (r101.getContext().e().f246020b == true) goto L11;
        i r106 = r101.b();
        i.i(r106, ArgusCommonVerifyReason.ASPECT_IS_OFF, null, 6);
        return r106;
    L11:
        long r107 = System.currentTimeMillis();
        r101.getContext().f245990e = false;
        AspectContext r108 = r101.getContext();
        AspectContext.Companion.TraceType r109 = AspectContext.Companion.TraceType.ASPECT_VERIFY;
        r108.h(r109, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> r110 = r101.getContext();
        r101.b();
        StrategyCalculateHandler r111 = this.f245625a;
        int r112 = StrategyCalculateHandler.f246152c;
        r111.a(r110, null);
        if (r101.f245826d == false) goto L20;
        ConcurrentHashMap<n, CopyOnWriteArrayList<AspectContext<?, ?>>> r113 = r101.f245827e.f245821f;
        n r114 = r101.f245823a;
        CopyOnWriteArrayList<AspectContext<?, ?>> r115 = r113.get(r114);
        if (r115 != null) goto L19;
        r115 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<AspectContext<?, ?>> r116 = r113.putIfAbsent(r114, r115);
        if (r116 == null) goto L19;
        r115 = r116;
    L19:
        r115.add(r101.getContext());
    L20:
        r101.getContext().h(r109, AspectContext.Companion.TraceStage.END, null);
        BaseEventCenter.b.a(r101, null);
        i r117 = r101.b();
        r101.getContext().f().a("trigger_time", Long.valueOf(r107));
        Function1<? super AspectContext<?, ?>, Unit> r118 = r101.f245827e.f245822g;
        if (r118 == null) goto L27;
        r118.invoke(r101.getContext());
        return r117;
    L27:
        return r117;
    }

    public final i b(com.bytedance.ies.argus.api.params.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        BaseEventCenter.b r101 = new BaseEventCenter.b(this.f245626b, ArgusGlobalAspect.ABOUT_TO_UPLOAD_FILE, r100);
        Lazy<ArgusConfigManager> r102 = ArgusConfigManager.f246083j;
        if (ArgusConfigManager.a.a().a(r101.f245823a, r101.getContext().b()) == false) goto L6;
        int r103 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("BaseEventCenter", "argusBizId " + r101.getContext().b() + ", aspect: " + r101.f245823a.getStringValue() + " is disabled by recovery.");
        k r104 = new k();
        i.i(r104, ArgusCommonVerifyReason.ASPECT_DISABLE_BY_RECOVERY, null, 6);
        return r104;
    L6:
        if (r101.getContext().d() != null) goto L9;
        i r105 = r101.b();
        i.i(r105, ArgusCommonVerifyReason.ASPECT_CONFIG_IS_NULL, null, 6);
        return r105;
    L9:
        if (r101.getContext().e().f246020b == true) goto L11;
        i r106 = r101.b();
        i.i(r106, ArgusCommonVerifyReason.ASPECT_IS_OFF, null, 6);
        return r106;
    L11:
        long r107 = System.currentTimeMillis();
        r101.getContext().f245990e = false;
        AspectContext r108 = r101.getContext();
        AspectContext.Companion.TraceType r109 = AspectContext.Companion.TraceType.ASPECT_VERIFY;
        r108.h(r109, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> r110 = r101.getContext();
        r101.b();
        StrategyCalculateHandler r111 = this.f245625a;
        int r112 = StrategyCalculateHandler.f246152c;
        r111.a(r110, null);
        if (r101.f245826d == false) goto L20;
        ConcurrentHashMap<n, CopyOnWriteArrayList<AspectContext<?, ?>>> r113 = r101.f245827e.f245821f;
        n r114 = r101.f245823a;
        CopyOnWriteArrayList<AspectContext<?, ?>> r115 = r113.get(r114);
        if (r115 != null) goto L19;
        r115 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<AspectContext<?, ?>> r116 = r113.putIfAbsent(r114, r115);
        if (r116 == null) goto L19;
        r115 = r116;
    L19:
        r115.add(r101.getContext());
    L20:
        r101.getContext().h(r109, AspectContext.Companion.TraceStage.END, null);
        BaseEventCenter.b.a(r101, null);
        i r117 = r101.b();
        r101.getContext().f().a("trigger_time", Long.valueOf(r107));
        Function1<? super AspectContext<?, ?>, Unit> r118 = r101.f245827e.f245822g;
        if (r118 == null) goto L27;
        r118.invoke(r101.getContext());
        return r117;
    L27:
        return r117;
    }

    public final i c(InjectLoginStateParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        BaseEventCenter.b r101 = new BaseEventCenter.b(this.f245626b, ArgusGlobalAspect.INJECT_LOGIN_STATE, r100);
        Lazy<ArgusConfigManager> r102 = ArgusConfigManager.f246083j;
        if (ArgusConfigManager.a.a().a(r101.f245823a, r101.getContext().b()) == false) goto L6;
        int r103 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("BaseEventCenter", "argusBizId " + r101.getContext().b() + ", aspect: " + r101.f245823a.getStringValue() + " is disabled by recovery.");
        k r104 = new k();
        i.i(r104, ArgusCommonVerifyReason.ASPECT_DISABLE_BY_RECOVERY, null, 6);
        return r104;
    L6:
        if (r101.getContext().d() != null) goto L9;
        i r105 = r101.b();
        i.i(r105, ArgusCommonVerifyReason.ASPECT_CONFIG_IS_NULL, null, 6);
        return r105;
    L9:
        if (r101.getContext().e().f246020b == true) goto L11;
        i r106 = r101.b();
        i.i(r106, ArgusCommonVerifyReason.ASPECT_IS_OFF, null, 6);
        return r106;
    L11:
        long r107 = System.currentTimeMillis();
        r101.getContext().f245990e = false;
        AspectContext r108 = r101.getContext();
        AspectContext.Companion.TraceType r109 = AspectContext.Companion.TraceType.ASPECT_VERIFY;
        r108.h(r109, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> r110 = r101.getContext();
        r101.b();
        StrategyCalculateHandler r111 = this.f245625a;
        int r112 = StrategyCalculateHandler.f246152c;
        r111.a(r110, null);
        if (r101.f245826d == false) goto L20;
        ConcurrentHashMap<n, CopyOnWriteArrayList<AspectContext<?, ?>>> r113 = r101.f245827e.f245821f;
        n r114 = r101.f245823a;
        CopyOnWriteArrayList<AspectContext<?, ?>> r115 = r113.get(r114);
        if (r115 != null) goto L19;
        r115 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<AspectContext<?, ?>> r116 = r113.putIfAbsent(r114, r115);
        if (r116 == null) goto L19;
        r115 = r116;
    L19:
        r115.add(r101.getContext());
    L20:
        r101.getContext().h(r109, AspectContext.Companion.TraceStage.END, null);
        BaseEventCenter.b.a(r101, null);
        i r117 = r101.b();
        r101.getContext().f().a("trigger_time", Long.valueOf(r107));
        Function1<? super AspectContext<?, ?>, Unit> r118 = r101.f245827e.f245822g;
        if (r118 == null) goto L27;
        r118.invoke(r101.getContext());
        return r117;
    L27:
        return r117;
    }

    public final i<x> d(w r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        BaseEventCenter.b r101 = new BaseEventCenter.b(this.f245626b, ArgusGlobalAspect.LOAD_STATIC_RESOURCE, r100);
        Lazy<ArgusConfigManager> r102 = ArgusConfigManager.f246083j;
        if (ArgusConfigManager.a.a().a(r101.f245823a, r101.getContext().b()) == false) goto L6;
        int r103 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("BaseEventCenter", "argusBizId " + r101.getContext().b() + ", aspect: " + r101.f245823a.getStringValue() + " is disabled by recovery.");
        k r104 = new k();
        i.i(r104, ArgusCommonVerifyReason.ASPECT_DISABLE_BY_RECOVERY, null, 6);
        return r104;
    L6:
        if (r101.getContext().d() != null) goto L9;
        i<x> r105 = r101.b();
        i.i(r105, ArgusCommonVerifyReason.ASPECT_CONFIG_IS_NULL, null, 6);
        return r105;
    L9:
        if (r101.getContext().e().f246020b == true) goto L11;
        i<x> r106 = r101.b();
        i.i(r106, ArgusCommonVerifyReason.ASPECT_IS_OFF, null, 6);
        return r106;
    L11:
        long r107 = System.currentTimeMillis();
        r101.getContext().f245990e = false;
        AspectContext r108 = r101.getContext();
        AspectContext.Companion.TraceType r109 = AspectContext.Companion.TraceType.ASPECT_VERIFY;
        r108.h(r109, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> r110 = r101.getContext();
        r101.b();
        StrategyCalculateHandler r111 = this.f245625a;
        int r112 = StrategyCalculateHandler.f246152c;
        r111.a(r110, null);
        if (r101.f245826d == false) goto L20;
        ConcurrentHashMap<n, CopyOnWriteArrayList<AspectContext<?, ?>>> r113 = r101.f245827e.f245821f;
        n r114 = r101.f245823a;
        CopyOnWriteArrayList<AspectContext<?, ?>> r115 = r113.get(r114);
        if (r115 != null) goto L19;
        r115 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<AspectContext<?, ?>> r116 = r113.putIfAbsent(r114, r115);
        if (r116 == null) goto L19;
        r115 = r116;
    L19:
        r115.add(r101.getContext());
    L20:
        r101.getContext().h(r109, AspectContext.Companion.TraceStage.END, null);
        BaseEventCenter.b.a(r101, null);
        i<x> r117 = r101.b();
        r101.getContext().f().a("trigger_time", Long.valueOf(r107));
        Function1<? super AspectContext<?, ?>, Unit> r118 = r101.f245827e.f245822g;
        if (r118 == null) goto L27;
        r118.invoke(r101.getContext());
        return r117;
    L27:
        return r117;
    }
}
