package com.bytedance.ies.bullet.ui.common;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BulletContainerView f248254a;

    public l(BulletContainerView r100) {
        this.f248254a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BulletContainerView r100 = this.f248254a;     // Catch: Throwable -> L4
        int r101 = BulletContainerView.U;     // Catch: Throwable -> L4
        r100.x();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
