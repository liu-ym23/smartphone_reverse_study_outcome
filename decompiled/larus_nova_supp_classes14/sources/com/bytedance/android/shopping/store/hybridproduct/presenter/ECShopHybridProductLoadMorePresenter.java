package com.bytedance.android.shopping.store.hybridproduct.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopHybridProductLoadMorePresenter extends h {
    public static final /* synthetic */ int g = 0;
    public final Lazy f;

    @Override // com.bytedance.android.shopping.store.hybridproduct.presenter.h
    public final QLiveData<LoadStatus> d0() {
        return ((ECShopHybridProductViewModel) this.f.getValue()).getLoadStatus();
    }

    public ECShopHybridProductLoadMorePresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ECShopHybridProductLoadMorePresenter$viewModel$2(this));
    }
}
