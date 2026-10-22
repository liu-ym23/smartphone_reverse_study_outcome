package com.bytedance.locallife.dito.common.plugin;

import com.bytedance.locallife.dito.core.DitoFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes21.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualRefreshPageTask f257553a;

    public b0(VirtualRefreshPageTask r100) {
        this.f257553a = r100;
    }

    public final void a() {
        if (this.f257553a.f257530h.get() == false) goto L6;
        rq6.a.f538927a.d("VirtualRefreshPage", "refresh page has already done ," + this.f257553a);
        return;
    L6:
        VirtualRefreshPageTask r100 = this.f257553a;
        if (r100.f257524b.f257571d == false) goto L14;
        DitoFragment r101 = r100.f257532j;
        if (r101 == null) goto L11;
        r100.e(r101, 1);
        Unit r102 = Unit.INSTANCE;
    L12:
        if (r102 != null) goto L16;
        VirtualRefreshPageTask.f(this.f257553a, "target page not create yet", null, 1, 2);
        return;
    L16:
        return;
    L11:
        r102 = null;
        goto L12
    L14:
        VirtualRefreshPageTask.f(r100, "timeout called", null, 1, 2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
