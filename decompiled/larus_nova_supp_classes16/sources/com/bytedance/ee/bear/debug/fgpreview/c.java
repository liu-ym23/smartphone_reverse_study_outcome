package com.bytedance.ee.bear.debug.fgpreview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ FGPreviewAdapter.MultiViewHolder a;

    public c(FGPreviewAdapter.MultiViewHolder r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c.setVisibility(8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
