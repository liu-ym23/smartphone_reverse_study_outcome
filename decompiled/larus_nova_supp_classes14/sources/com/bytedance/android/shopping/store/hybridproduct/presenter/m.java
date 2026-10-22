package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements Runnable {
    public final /* synthetic */ ECShopMemberCardPresenter a;

    public m(ECShopMemberCardPresenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d0().getStoreParam().updateSqlClientData();     // Catch: Throwable -> L4
        this.a.d0().refreshPassthroughApiForSql();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
