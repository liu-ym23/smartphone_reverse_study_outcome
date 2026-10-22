package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r0 = this.a;     // Catch: Throwable -> L4
        ECFloatWindowCarouselPresenter r1 = r0.a;     // Catch: Throwable -> L4
        ECFloatWindowCarouselPresenter.D(r1, r0.b, r0.d, r1.E());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
