package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.shopping.store.product.ECStoreProductTabFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitTabFragment;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u3 implements Runnable {
    public final /* synthetic */ TabKitTabFragment a;

    public u3(TabKitTabFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TabKitTabFragment r0 = this.a;     // Catch: Throwable -> L20
        if ((r0 instanceof ECStoreProductTabFragment) == true) goto L5;
        r0 = null;
    L5:
        ECStoreProductTabFragment r1 = (ECStoreProductTabFragment) r0;     // Catch: Throwable -> L20
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getContext() != null) goto L10;
        return;
    L10:
        if (r1.getFragmentManager() != null) goto L12;
        return;
    L12:
        if (r1.isDetached() == true) goto L29;
        com.bytedance.android.shopping.store.restore.q r2 = r1.U90().getPageRestoreCoordinator();     // Catch: Throwable -> L20
        if (r2 != null) goto L17;
    L18:
        r1.V90().refreshAll();     // Catch: Throwable -> L20
        return;
    L17:
        if (r2.a(3) != true) goto L18;
        return;
    L29:
        return;
    L20:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L31;
        throw th;
    }
}
