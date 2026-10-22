package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c2 implements Runnable {
    public final /* synthetic */ KtvStageWidget a;

    public c2(KtvStageWidget r1) {
        this.a = r1;
    }

    public final void a() {
        KtvStageWidget r0 = this.a;
        r0.getClass();
        ALogger.i("onSongFeedbackShow", "onSongFeedbackHide");
        r0.s.b(KtvStageWidget$onSongFeedbackHide$1.INSTANCE);
        Object r1 = r0.j;
        if ((r1 instanceof View) == true) goto L5;
        r1 = null;
    L5:
        View r2 = (View) r1;
        if (r2 == null) goto L8;
        r2.setVisibility(8);
    L8:
        View r3 = r0.l;
        if (r3 == null) goto L11;
        r3.setBackgroundColor(0);
    L11:
        View r4 = r0.l;
        if (r4 == null) goto L15;
        r4.setVisibility(8);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
