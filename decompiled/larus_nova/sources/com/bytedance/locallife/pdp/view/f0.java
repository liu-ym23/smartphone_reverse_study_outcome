package com.bytedance.locallife.pdp.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewGoodsDetailStatusView f261914a;

    public f0(NewGoodsDetailStatusView r100) {
        this.f261914a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NewGoodsDetailStatusView r100 = this.f261914a;     // Catch: Throwable -> L4
        int r101 = NewGoodsDetailStatusView.f261853k0;     // Catch: Throwable -> L4
        r100.b0();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
