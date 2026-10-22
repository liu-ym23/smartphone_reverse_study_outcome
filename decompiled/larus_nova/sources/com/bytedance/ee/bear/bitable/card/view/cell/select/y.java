package com.bytedance.ee.bear.bitable.card.view.cell.select;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f208188a;

    public y(t r100) {
        this.f208188a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.f208188a.f208182t.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (this.f208188a.f208182t.hasFocus() == false) goto L15;
        rcb.c.h(this.f208188a.f208182t, null);     // Catch: Throwable -> L8
        return;
    }
}
