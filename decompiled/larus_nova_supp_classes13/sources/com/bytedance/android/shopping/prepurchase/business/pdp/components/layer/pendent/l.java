package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements Runnable {
    public final /* synthetic */ MoreVideoComponent a;

    public l(MoreVideoComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MoreVideoComponent r0 = this.a;     // Catch: Throwable -> L15
        r0.getClass();     // Catch: Throwable -> L15
        vg3.a r1 = (vg3.a) r0.N1(vg3.a.class);     // Catch: Throwable -> L15
        if (r1 == null) goto L5;
        AnchorV4PlayerStateManager r2 = r1.e();     // Catch: Throwable -> L15
    L6:
        if (r2 != null) goto L8;
    L9:
        MoreVideoComponent.b r3 = MoreVideoComponent.i2(this.a);     // Catch: Throwable -> L15
        if (r3 == null) goto L22;
        x73.a r4 = r3.c;     // Catch: Throwable -> L15
        if (r4 == null) goto L23;
        r4.startPlay();     // Catch: Throwable -> L15
        return;
    L23:
        return;
    L22:
        return;
    L8:
        if (r2.e() != true) goto L9;
        return;
    L5:
        r2 = null;
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L24;
        throw th;
    }
}
