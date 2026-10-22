package com.ss.android.lark.forseti.chain;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.ForsetiPlugin;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiChainFragment f424414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.api.ui.g f424415b;

    public k(ForsetiChainFragment r100, ForsetiPlugin.b r101) {
        this.f424414a = r100;
        this.f424415b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f424414a.ca0().g(this.f424415b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
