package com.bytedance.sdk.xbridge.cn.platform.web;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebBridgeProtocol f270032a;

    public d(WebBridgeProtocol r100) {
        this.f270032a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f270032a.f270010g = this.f270032a.f();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
