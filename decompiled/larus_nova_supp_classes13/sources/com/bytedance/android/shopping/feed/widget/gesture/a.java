package com.bytedance.android.shopping.feed.widget.gesture;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (b.a(this.a) != null) goto L5;
        return;
    L5:
        if (b.a(this.a).isAnimating() == false) goto L15;
        b.a(this.a).cancelAnimation();     // Catch: Throwable -> L8
        return;
    }
}
