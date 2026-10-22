package com.ss.android.lark.utils.rxjava;

import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends ReportErrorConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f444763a;

    public f(boolean r100) {
        this.f444763a = r100;
    }

    @Override // com.ss.android.lark.utils.rxjava.ReportErrorConsumer
    public final void error(Throwable r100) throws Exception {
        Log.e("UnCaughtErrorHandler", r100.getMessage(), r100);
        if (this.f444763a == false) goto L6;
        Thread r101 = ThreadMethodProxy.currentThread();
        r101.getUncaughtExceptionHandler().uncaughtException(r101, r100);
        return;
    }
}
