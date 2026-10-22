package com.bytedance.android.shopping.store.mall.follows.basic;

import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements gqa.d {
    public final /* synthetic */ BaseFollowRefreshPresenter a;

    public a(BaseFollowRefreshPresenter r1) {
        this.a = r1;
    }

    public final void d2(cqa.h r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        final BaseFollowRefreshPresenter r10 = this.a;
        r10.d0(true, false);
        BaseFollowStoreViewModel.loadData$default((BaseFollowStoreViewModel) r10.f.getValue(), LoadStatus.Refresh, null, false, new BaseFollowRefreshPresenter$refresh$1(r10), 6, null);
    }
}
