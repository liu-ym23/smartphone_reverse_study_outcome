package com.bytedance.ies.argus.api;

import android.view.View;
import com.bytedance.ies.argus.api.params.p;
import com.bytedance.ies.argus.api.params.q;
import com.bytedance.ies.argus.api.params.t;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.aspect.eventCenter.h;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusLynxViewAspect;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.i;
import com.bytedance.ies.argus.bean.k;
import com.bytedance.ies.argus.bean.n;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusLynxDelegate extends com.bytedance.ies.argus.aspect.a<LynxView> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f245627d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f245628c;

    public static final class a {
    }

    static {
    }

    public ArgusLynxDelegate() {
        this.f245628c = new h();
    }

    @Override // com.bytedance.ies.argus.aspect.a
    public final com.bytedance.ies.argus.aspect.eventCenter.b d() {
        return this.f245628c;
    }

    @Override // com.bytedance.ies.argus.aspect.a
    public final void f(View r100) {
        Intrinsics.checkNotNullParameter((LynxView) r100, "view");
        com.bytedance.ies.argus.aspect.c r101 = com.bytedance.ies.argus.aspect.c.f245800a;
        Intrinsics.checkNotNullParameter(this, "delegate");
        String r102 = this.f245628c.f245836g;
        if (r102 == null) goto L6;
        com.bytedance.ies.argus.aspect.c.f245803d.put(r102, new WeakReference(this));
        return;
    }

    public final i g(t r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        BaseEventCenter.b<PARAMS, REWRITE_PAYLOAD> r101 = e(ArgusLynxViewAspect.INVOKE_JSI, r100);
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
        b(r110, null);
        r110.f245999n.f245944b = new ArgusLynxDelegate$verifyInvokeJSI$1$1(this);
        if (r101.f245826d == false) goto L20;
        ConcurrentHashMap<n, CopyOnWriteArrayList<AspectContext<?, ?>>> r111 = r101.f245827e.f245821f;
        n r112 = r101.f245823a;
        CopyOnWriteArrayList<AspectContext<?, ?>> r113 = r111.get(r112);
        if (r113 != null) goto L19;
        r113 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<AspectContext<?, ?>> r114 = r111.putIfAbsent(r112, r113);
        if (r114 == null) goto L19;
        r113 = r114;
    L19:
        r113.add(r101.getContext());
    L20:
        r101.getContext().h(r109, AspectContext.Companion.TraceStage.END, null);
        BaseEventCenter.b.a(r101, null);
        i r115 = r101.b();
        r101.getContext().f().a("trigger_time", Long.valueOf(r107));
        Function1<? super AspectContext<?, ?>, Unit> r116 = r101.f245827e.f245822g;
        if (r116 == null) goto L24;
        r116.invoke(r101.getContext());
    L24:
        return r115;
    }

    public final i<q> h(p r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        BaseEventCenter.b<PARAMS, REWRITE_PAYLOAD> r101 = e(ArgusLynxViewAspect.SET_GLOBAL_PROPS, r100);
        Lazy<ArgusConfigManager> r102 = ArgusConfigManager.f246083j;
        if (ArgusConfigManager.a.a().a(r101.f245823a, r101.getContext().b()) == false) goto L6;
        int r103 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("BaseEventCenter", "argusBizId " + r101.getContext().b() + ", aspect: " + r101.f245823a.getStringValue() + " is disabled by recovery.");
        k r104 = new k();
        i.i(r104, ArgusCommonVerifyReason.ASPECT_DISABLE_BY_RECOVERY, null, 6);
        return r104;
    L6:
        if (r101.getContext().d() != null) goto L9;
        i<q> r105 = r101.b();
        i.i(r105, ArgusCommonVerifyReason.ASPECT_CONFIG_IS_NULL, null, 6);
        return r105;
    L9:
        if (r101.getContext().e().f246020b == true) goto L11;
        i<q> r106 = r101.b();
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
        b(r110, null);
        r110.f245999n.f245944b = new ArgusLynxDelegate$verifySetGlobalProps$verifyResult$1$1(this);
        if (r101.f245826d == false) goto L20;
        ConcurrentHashMap<n, CopyOnWriteArrayList<AspectContext<?, ?>>> r111 = r101.f245827e.f245821f;
        n r112 = r101.f245823a;
        CopyOnWriteArrayList<AspectContext<?, ?>> r113 = r111.get(r112);
        if (r113 != null) goto L19;
        r113 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<AspectContext<?, ?>> r114 = r111.putIfAbsent(r112, r113);
        if (r114 == null) goto L19;
        r113 = r114;
    L19:
        r113.add(r101.getContext());
    L20:
        r101.getContext().h(r109, AspectContext.Companion.TraceStage.END, null);
        BaseEventCenter.b.a(r101, null);
        i<q> r115 = r101.b();
        r101.getContext().f().a("trigger_time", Long.valueOf(r107));
        Function1<? super AspectContext<?, ?>, Unit> r116 = r101.f245827e.f245822g;
        if (r116 == null) goto L24;
        r116.invoke(r101.getContext());
    L24:
        return r115;
    }
}
