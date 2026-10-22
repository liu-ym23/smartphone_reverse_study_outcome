package com.bytedance.android.window.shop.home.tab.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w implements Runnable {
    public final /* synthetic */ ECWindowTabPresenterDeprecated a;

    public w(ECWindowTabPresenterDeprecated r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (ECWindowTabPresenterDeprecated.d0(this.a).getItemAnimator() != null) goto L9;
        ECWindowTabPresenterDeprecated.d0(this.a).setItemAnimator(this.a.s);     // Catch: Throwable -> L6
        return;
    }
}
