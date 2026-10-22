package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f270204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f270205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f270206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f270207d;

    public m(CompletionBlock<a.c> r100, p r101, Activity r102, IBDXBridgeContext r103) {
        this.f270204a = r100;
        this.f270205b = r101;
        this.f270206c = r102;
        this.f270207d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CompletionBlock.DefaultImpls.onFailure$default(this.f270204a, 0, this.f270205b.f270221d, null, 4, null);     // Catch: Throwable -> L4
        this.f270205b.a(this.f270206c, this.f270207d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
