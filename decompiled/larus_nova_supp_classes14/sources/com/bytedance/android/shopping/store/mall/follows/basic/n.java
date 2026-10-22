package com.bytedance.android.shopping.store.mall.follows.basic;

import android.view.View;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ BaseFollowStoreStatusPresenter a;

    public n(BaseFollowStoreStatusPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        BaseFollowStoreViewModel.loadData$default((BaseFollowStoreViewModel) this.a.g.getValue(), LoadStatus.RefreshWhenError, null, false, null, 14, null);
    }
}
