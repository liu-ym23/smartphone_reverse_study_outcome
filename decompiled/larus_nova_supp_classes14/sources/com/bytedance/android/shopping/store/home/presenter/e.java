package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Runnable {
    public final /* synthetic */ ECShopAnimationPresenter.b a;

    public e(ECShopAnimationPresenter.b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = (View) this.a.c.element;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setVisibility(8);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
