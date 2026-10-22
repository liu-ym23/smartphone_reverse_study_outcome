package com.obric.matrixpro.sdk.deviceinfoclient;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC4654a f397041a;

    public b(a.InterfaceC4654a r100) {
        this.f397041a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f397041a.onError("查询失败：Cursor为空");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
