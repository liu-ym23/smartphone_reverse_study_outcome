package com.bytedance.android.shopping.card_list.components;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ CardListBodyComponent a;

    public e(CardListBodyComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    L22:
        return;
    L3:
        if (this.a.d.canScrollVertically(-1) == false) goto L5;
    L10:
        KitCartBackToTopBtnManageComponent r0 = (KitCartBackToTopBtnManageComponent) this.a.l.getValue();     // Catch: Throwable -> L14
        if (r0 == null) goto L19;
        r0.g(true);     // Catch: Throwable -> L14
    L19:
        return;
    L5:
        if (this.a.d.getYataBody().canScrollVertically(-1) == true) goto L10;
        KitCartBackToTopBtnManageComponent r1 = (KitCartBackToTopBtnManageComponent) this.a.l.getValue();     // Catch: Throwable -> L14
        if (r1 == null) goto L19;
        r1.g(false);     // Catch: Throwable -> L14
        goto L19
    }
}
