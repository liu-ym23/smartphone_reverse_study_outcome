package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<FlowMfaFlowSession> f437897a;

    public static final class a {
    }

    static {
    }

    @Inject
    public h() {
        this.f437897a = new AtomicReference();
    }

    public final void a(FlowMfaFlowSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        AtomicReference<FlowMfaFlowSession> r101 = this.f437897a;
    L3:
        boolean r102 = false;
        if (r101.compareAndSet(r100, null) == true) goto L5;
        if (r101.get() == r100) goto L3;
        boolean r103 = false;
    L9:
        if (r103 == false) goto L39;
        ConcurrentHashMap<String, FlowMfaFlowSession> r104 = o.f437909a;
        String r105 = r100.f437830a;
        Intrinsics.checkNotNullParameter(r105, "flowId");
        ConcurrentHashMap<String, FlowMfaFlowSession> r106 = o.f437909a;
        if (r106.remove(r105) == null) goto L13;
        PassportLog.d("FlowMfaRuntime", "remove session success: sessionCount=" + r106.size());
    L14:
        AtomicReference<syb.b> r107 = com.ss.android.lark.passport.flow.core.router.a.f437790c;
        FlowMfaFlowSession.d r108 = r100.f437852w;
        syb.b r109 = r100.f437850u.get();
        Intrinsics.checkNotNullParameter(r108, PrefetchTiming.ROUTER);
        AtomicReference<syb.b> r110 = com.ss.android.lark.passport.flow.core.router.a.f437790c;
    L16:
        if (r110.compareAndSet(r108, r109) == true) goto L20;
        if (r110.get() == r108) goto L16;
    L20:
        r100.f437850u.set(null);
        r100.m(FlowMfaBidpWebActivityType.EXTERNAL_BROWSER_LOADING);
        WeakReference<Activity> r111 = r100.f437844o.getAndSet(null);
        if (r111 == null) goto L23;
        Activity r112 = r111.get();
    L24:
        StringBuilder r113 = new StringBuilder("finish pending BIDP callback activity: hasActivity=");
        if (r112 == null) goto L27;
        r102 = true;
    L27:
        r113.append(r102);
        r113.append(", activity=");
        if (r112 == null) goto L30;
        String r114 = r112.getClass().getSimpleName();
    L31:
        r113.append(r114);
        PassportLog.d("FlowMfaSession", r113.toString());
        r100.j(r112);
        r100.f437838i.set(null);
        r100.f437839j.set(null);
        r100.f437840k.set(null);
        r100.f437841l.set(null);
        r100.f437847r.set(null);
        r100.f437848s.set(null);
        r100.f437849t.set(null);
        AtomicReference<com.ss.android.lark.passport.flow.mfa.a> r115 = r100.f437851v;
        r115.set(com.ss.android.lark.passport.flow.mfa.a.a(r115.get(), ExternalBidpCallbackPhase.IDLE));
        CoroutineScopeKt.cancel$default(r100.f437837h, null, 1, null);
        return;
    L30:
        r114 = null;
        goto L31
    L23:
        r112 = null;
        goto L24
    L13:
        PassportLog.b("FlowMfaRuntime", "remove session failed: session not found");
        goto L14
    L39:
        return;
    L5:
        r103 = true;
        goto L9
    }
}
