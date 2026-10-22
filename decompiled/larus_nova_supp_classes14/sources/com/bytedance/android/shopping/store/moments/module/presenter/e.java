package com.bytedance.android.shopping.store.moments.module.presenter;

import com.bytedance.android.ec.hybrid.list.ability.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends k0 {
    public final /* synthetic */ ECStoreMomentPresenter a;

    public final void a() {
        if (this.a.d0().getHasMore() == false) goto L6;
        this.a.d0().fetchMomentApi();
        return;
    }

    public e(ECStoreMomentPresenter r1) {
        this.a = r1;
    }
}
