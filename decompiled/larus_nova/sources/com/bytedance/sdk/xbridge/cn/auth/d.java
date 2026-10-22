package com.bytedance.sdk.xbridge.cn.auth;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nd7.d f269836a;

    public d(nd7.d r100) {
        this.f269836a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f269836a.b();     // Catch: Throwable -> L4
        int r100 = com.bytedance.sdk.xbridge.cn.utils.a.f270258a;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
