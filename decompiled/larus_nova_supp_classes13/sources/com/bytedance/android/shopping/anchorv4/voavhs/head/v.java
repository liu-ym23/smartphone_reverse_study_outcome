package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4DownTabIndicator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v implements Runnable {
    public final /* synthetic */ SlidesAndIndicatorV4Component a;

    public v(SlidesAndIndicatorV4Component r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wg.a.h(this.a.x, false);     // Catch: Throwable -> L7
        AnchorV4DownTabIndicator r0 = this.a.l;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("downTabIndicator");     // Catch: Throwable -> L7
    L5:
        r0.setInitDownTabVisibility(Integer.valueOf(this.a.x.getVisibility()));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
