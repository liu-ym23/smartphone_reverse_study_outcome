package com.bytedance.sdk.xbridge.cn.system;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f270196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f270197b;

    public j(CompletionBlock<a.c> r100, p r101) {
        this.f270196a = r100;
        this.f270197b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CompletionBlock.DefaultImpls.onFailure$default(this.f270196a, 0, this.f270197b.f270222e, null, 4, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
