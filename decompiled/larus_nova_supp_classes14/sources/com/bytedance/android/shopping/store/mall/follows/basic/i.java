package com.bytedance.android.shopping.store.mall.follows.basic;

import com.bytedance.android.ec.hybrid.list.ability.k0;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends k0 {
    public final /* synthetic */ BaseFollowStorePresenter a;

    public final void a() {
        if (this.a.d0().getHasMore() == false) goto L6;
        BaseFollowStoreViewModel.loadData$default(this.a.d0(), LoadStatus.LoadMoreIn, null, false, null, 14, null);
        return;
    }

    public i(BaseFollowStorePresenter r1) {
        this.a = r1;
    }
}
