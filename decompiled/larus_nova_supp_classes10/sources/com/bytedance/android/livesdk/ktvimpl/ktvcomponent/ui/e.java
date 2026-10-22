package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui;

import com.bytedance.android.live.ktv.common.midi.KtvHitAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements Runnable {
    public final /* synthetic */ KtvComponentUIWidget a;
    public final /* synthetic */ int b;

    public e(KtvComponentUIWidget r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvHitAnimationView r0 = this.a.T.n;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        float r1 = this.b;     // Catch: Throwable -> L6
        int r2 = KtvHitAnimationView.m;     // Catch: Throwable -> L6
        r0.b(r1, true);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
