package com.ss.android.lark.forseti.chain;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.ForsetiPlugin;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiChainFragment f424399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.api.ui.g f424400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f424401c;

    public d(ForsetiChainFragment r100, ForsetiPlugin.b r101) {
        this.f424399a = r100;
        this.f424400b = r101;
        this.f424401c = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f424399a.ca0().m(this.f424400b, this.f424401c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
