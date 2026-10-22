package com.bytedance.android.shopping.new_cart.components;

import android.view.View;
import android.view.ViewStub;
import com.bytedance.android.shopping.new_cart.widgets.ECCartErrorView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ d a;

    public c(d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d r0 = this.a;     // Catch: Throwable -> L12
        ViewStub r1 = r0.d;     // Catch: Throwable -> L12
        Object r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.inflate();     // Catch: Throwable -> L12
    L7:
        if ((r3 instanceof ECCartErrorView) == false) goto L10;
        r2 = r3;
    L10:
        r0.b = (ECCartErrorView) r2;     // Catch: Throwable -> L12
        return;
    L5:
        r3 = null;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    }
}
