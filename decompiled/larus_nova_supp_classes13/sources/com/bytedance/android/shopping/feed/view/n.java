package com.bytedance.android.shopping.feed.view;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements Runnable {
    public final /* synthetic */ InnerFeedPageHeadWidget a;
    public final /* synthetic */ int b;

    public n(InnerFeedPageHeadWidget r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.t;     // Catch: Throwable -> L12
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L12
    L6:
        if (r1 == null) goto L8;
        r1.height = com.bytedance.android.shopping.extensions.b.b(100) - this.b;     // Catch: Throwable -> L12
    L8:
        View r2 = this.a.t;     // Catch: Throwable -> L12
        if (r2 == null) goto L15;
        r2.setLayoutParams(r1);     // Catch: Throwable -> L12
        return;
    L15:
        return;
    L5:
        r1 = null;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
