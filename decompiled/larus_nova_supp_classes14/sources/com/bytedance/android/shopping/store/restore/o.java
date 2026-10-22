package com.bytedance.android.shopping.store.restore;

import com.bytedance.android.shopping.store.tabkit.TabKitPresenter;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o implements Runnable {
    public final /* synthetic */ TabKitViewModel a;
    public final /* synthetic */ int b;
    public final /* synthetic */ TabKitPresenter c;

    public o(TabKitViewModel r1, int r2, TabKitPresenter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y r0 = (y) this.a.getCurrentTabAfter().getValue();     // Catch: Throwable -> L14
        if (r0 == null) goto L7;
        com.bytedance.android.shopping.store.tabkit.model.k r1 = r0.a;     // Catch: Throwable -> L14
        if (r1 == null) goto L7;
        Integer r2 = r1.n();     // Catch: Throwable -> L14
    L8:
        if (r2 != null) goto L11;
    L12:
        this.c.f0(this.b);     // Catch: Throwable -> L14
        return;
    L11:
        if (r2.intValue() != this.b) goto L12;
        return;
    L7:
        r2 = null;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
