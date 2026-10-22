package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w implements Runnable {
    public final /* synthetic */ SlidesAndIndicatorV4Component a;
    public final /* synthetic */ List b;

    public w(SlidesAndIndicatorV4Component r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnchorV4HeadViewPager r0 = this.a.e;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.m(this.b);     // Catch: Throwable -> L9
    L5:
        f83.k r1 = this.a.f;     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.h(false);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
