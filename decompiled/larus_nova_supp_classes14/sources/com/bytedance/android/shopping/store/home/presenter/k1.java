package com.bytedance.android.shopping.store.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k1<T> implements Observer {
    public final /* synthetic */ ECShopRootPresenter a;

    public k1(ECShopRootPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        if (((uj3.j) r4).h() == false) goto L5;
        ECShopRootPresenter r5 = this.a;
        int r1 = ECShopRootPresenter.z;
        r5.s0(qc3.a.d(r5.u().c(), 2131101860));
        ECShopRootPresenter r6 = this.a;
        int r2 = qc3.a.d(r6.u().c(), 2131101860);
        r6.w().b(2131371128).f().setBackgroundColor(r2);
        return;
    L5:
        ECShopRootPresenter r7 = this.a;
        int r3 = ECShopRootPresenter.z;
        r7.s0(qc3.a.d(r7.u().c(), 2131101859));
        ECShopRootPresenter r8 = this.a;
        int r9 = qc3.a.d(r8.u().c(), 2131101820);
        r8.w().b(2131371128).f().setBackgroundColor(r9);
    }
}
