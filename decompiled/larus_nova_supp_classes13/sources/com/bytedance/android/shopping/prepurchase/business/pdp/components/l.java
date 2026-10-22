package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.compat.CompatFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements Runnable {
    public final /* synthetic */ LastPageVideoZoomer a;
    public final /* synthetic */ View b;

    public l(LastPageVideoZoomer r1, CompatFrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LastPageVideoZoomer r0 = this.a;     // Catch: Throwable -> L9
        View r1 = this.b;     // Catch: Throwable -> L9
        ValueAnimator r2 = r0.b;     // Catch: Throwable -> L9
        if (r2 != null) goto L5;
    L7:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{-1.0f, 0.0f});     // Catch: Throwable -> L9
        r3.setDuration(150);     // Catch: Throwable -> L9
        r3.addUpdateListener(new g(r0, r1));     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r0.b = r3;     // Catch: Throwable -> L9
        r3.start();     // Catch: Throwable -> L9
        return;
    L5:
        if (r2.isRunning() != true) goto L7;
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
