package com.bytedance.ee.bear.debug.fgpreview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FGPreviewAdapter.MultiViewHolder f217400a;

    public c(FGPreviewAdapter.MultiViewHolder r100) {
        this.f217400a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f217400a.f217390c.setVisibility(8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
