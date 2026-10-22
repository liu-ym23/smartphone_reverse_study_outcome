package com.bytedance.android.window.shop.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Runnable {
    public final /* synthetic */ ECWindowTabLayout a;

    public e(ECWindowTabLayout r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECWindowTabLayout r0 = this.a;     // Catch: Throwable -> L4
        ListProtector.add(r0.a, 0, r0.d);     // Catch: Throwable -> L4
        ECWindowTabLayout r1 = this.a;     // Catch: Throwable -> L4
        ECWindowTabLayout.a(r1, r1.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
