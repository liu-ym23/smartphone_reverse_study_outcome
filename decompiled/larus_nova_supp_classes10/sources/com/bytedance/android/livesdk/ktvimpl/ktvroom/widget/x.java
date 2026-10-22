package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x implements Runnable {
    public final /* synthetic */ KtvInteractElementWidget a;

    public x(KtvInteractElementWidget r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvInteractElementWidget r0 = this.a;     // Catch: Throwable -> L12
        r0.getClass();     // Catch: Throwable -> L12
        ALogger.i("KtvInteractElementWidget", "onSongFeedbackHide");     // Catch: Throwable -> L12
        r0.s.b(KtvInteractElementWidget$onSongFeedbackHide$1.INSTANCE);     // Catch: Throwable -> L12
        Object r1 = r0.r;     // Catch: Throwable -> L12
        if ((r1 instanceof View) == true) goto L5;
        r1 = null;
    L5:
        View r2 = (View) r1;     // Catch: Throwable -> L12
        if (r2 == null) goto L8;
        r2.setVisibility(8);     // Catch: Throwable -> L12
    L8:
        View r3 = r0.t;     // Catch: Throwable -> L12
        if (r3 == null) goto L15;
        r3.setVisibility(8);     // Catch: Throwable -> L12
        return;
    L15:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
