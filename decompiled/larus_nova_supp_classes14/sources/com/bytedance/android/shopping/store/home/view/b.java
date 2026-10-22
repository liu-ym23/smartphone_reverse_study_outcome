package com.bytedance.android.shopping.store.home.view;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ ECShopMarqueeTextView a;
    public final /* synthetic */ Function0 b;

    public b(ECShopMarqueeTextView r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopMarqueeTextView r0 = this.a;     // Catch: Throwable -> L8
        r0.t = null;     // Catch: Throwable -> L8
        if (r0.q == false) goto L5;
        return;
    L5:
        if (r0.o == true) goto L15;
        this.b.invoke();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
