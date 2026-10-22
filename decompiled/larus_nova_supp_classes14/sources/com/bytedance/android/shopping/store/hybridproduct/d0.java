package com.bytedance.android.shopping.store.hybridproduct;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ ECShopHybridProductListPresenter a;
    public final /* synthetic */ RecyclerView b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public d0(ECShopHybridProductListPresenter r1, RecyclerView r2, int r3, int r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopHybridProductListPresenter.h0(this.a, this.b, this.c + 1, this.d, this.e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
