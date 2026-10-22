package com.volcengine.zeus.plugin;

import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.log.ZeusLogger;

/* JADX INFO: loaded from: classes41.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f462807a;

    public g(String r100) {
        this.f462807a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.f462809a.add(this.f462807a);     // Catch: Throwable -> L4
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "PluginReloadManager addWaitingReloadPlugin: " + this.f462807a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
