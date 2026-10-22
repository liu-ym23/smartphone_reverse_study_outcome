package com.bytedance.android.shopping.store.router.hybridpage.presenter.product;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.hybridproduct.presenter.h;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HybridPageListLoadMorePresenter extends h {
    public static final /* synthetic */ int h = 0;
    public final Lazy f;
    public final TextView g;

    @Override // com.bytedance.android.shopping.store.hybridproduct.presenter.h
    public final QLiveData<LoadStatus> d0() {
        return ((HybridPageViewModel) this.f.getValue()).getLoadStatus();
    }

    public HybridPageListLoadMorePresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new HybridPageListLoadMorePresenter$viewModel$2(this));
        this.g = (TextView) a0().findViewById(2131391174);
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.presenter.h
    public final void b0(QModel r2) {
        super.b0(r2);
        TextView r3 = this.g;
        if (r3 == null) goto L10;
        String r0 = ((HybridPageViewModel) this.f.getValue()).getLoadNoMoreText();
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        r3.setText(r0);
        return;
    }
}
