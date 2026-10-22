package com.bytedance.android.shopping.store.hybridproduct;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ ECShopHybridProductListPresenter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ RecyclerView c;
    public final /* synthetic */ com.bytedance.android.ec.hybrid.list.entity.k d;

    public b0(ECShopHybridProductListPresenter r1, int r2, RecyclerView r3, com.bytedance.android.ec.hybrid.list.entity.k r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopHybridProductListPresenter.e0(this.a, this.b + 1, this.c, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
