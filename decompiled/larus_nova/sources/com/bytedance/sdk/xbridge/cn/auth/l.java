package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f269849a;

    public l(String r100) {
        this.f269849a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HybridLogger r100 = HybridLogger.f246343a;     // Catch: Throwable -> L4
        HybridLogger.m("XBridge-auth", this.f269849a, null, null, 12);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
