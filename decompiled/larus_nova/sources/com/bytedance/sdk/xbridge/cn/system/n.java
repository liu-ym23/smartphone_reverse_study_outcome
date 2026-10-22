package com.bytedance.sdk.xbridge.cn.system;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f270208a;

    public n(CompletionBlock<a.c> r100) {
        this.f270208a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CompletionBlock.DefaultImpls.onFailure$default(this.f270208a, 0, null, null, 6, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
