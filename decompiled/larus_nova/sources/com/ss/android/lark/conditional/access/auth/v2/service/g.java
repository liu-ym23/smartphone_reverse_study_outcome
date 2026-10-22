package com.ss.android.lark.conditional.access.auth.v2.service;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f417907a;

    public g(f r100) {
        this.f417907a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f417907a;     // Catch: Throwable -> L10
        r100.getClass();     // Catch: Throwable -> L10
        ScsLogger.d("SecurityPolicy_DelayCleanupService", "cancelTimer()");     // Catch: Throwable -> L10
        PthreadTimer r101 = r100.f417900b;     // Catch: Throwable -> L10
        if (r101 == null) goto L5;
        r101.cancel();     // Catch: Throwable -> L10
    L5:
        f.a r102 = r100.f417901c;     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        r102.cancel();     // Catch: Throwable -> L10
    L8:
        r100.f417901c = null;     // Catch: Throwable -> L10
        r100.f417900b = null;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
