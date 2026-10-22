package com.ss.android.lark.framework.assembly.appcontext;

import android.content.Context;
import android.content.res.Configuration;
import com.ss.android.lark.app.initiator.AppLaunchLifecycle;
import com.ss.android.lark.appcontext.applifecycle.q;
import com.ss.android.lark.appcontext.applifecycle.u;
import com.ss.android.lark.appcontext.applifecycle.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements AppLaunchLifecycle.b {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
    public final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
    public final void c(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Object r101 = q.f408854c;
        Iterator r102 = ((ConcurrentHashMap) q.a.f408857a.f408855a).keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((u) r102.next()).a(r100);
        goto L4
    }

    @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
    public final void d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
    public final void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
    public final void f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.ss.android.lark.app.initiator.AppLaunchLifecycle.b
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Object r101 = q.f408854c;
        Iterator r102 = ((ConcurrentHashMap) q.a.f408857a.f408856b).keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((v) r102.next()).onConfigurationChanged(r100);
        goto L4
    L6:
        Iterator r103 = ((ConcurrentHashMap) q.a.f408857a.f408855a).keySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((u) r103.next()).b();
        goto L8
    }
}
