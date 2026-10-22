package com.bytedance.locallife.dito.common.plugin;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes21.dex */
public final class d0 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VirtualRefreshPageTask f257561a;

    public final void a() {
        VirtualRefreshPageTask r100 = this.f257561a;
        if (r100.f257536n == false) goto L5;
        rq6.a.f538927a.b("VirtualRefreshPage", "refresh page has already timeout ," + r100);
        return;
    L5:
        r100.f257536n = true;
        s r101 = r100.f257525c;
        if (r101 == null) goto L8;
        r101.T0();
    L8:
        r100.f257537o.post(new b0(r100));
    }

    @Override // java.util.TimerTask, java.lang.Runnable
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

    public d0(VirtualRefreshPageTask r100) {
        this.f257561a = r100;
    }
}
