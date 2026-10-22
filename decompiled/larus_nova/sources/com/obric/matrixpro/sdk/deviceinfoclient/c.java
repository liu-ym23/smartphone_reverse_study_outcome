package com.obric.matrixpro.sdk.deviceinfoclient;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes33.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC4654a f397042a;

    public c(a.InterfaceC4654a r100) {
        this.f397042a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f397042a.onError("Cursor无有效数据");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
