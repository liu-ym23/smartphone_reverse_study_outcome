package com.bytedance.ee.bear.document.render.node.perf;

import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f221387a;

    public f(e r100) {
        this.f221387a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(eu5.b.f474075a, "render_cache, from = " + this.f221387a.f221381b.e(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "render_cache_from"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
