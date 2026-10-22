package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.n0;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ShopSliceCommonCardPresenter;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n extends rm.a {
    public final ECStoreViewModel m;
    public final com.bytedance.android.shopping.store.hybridproduct.holder.e n;
    public final n0 o;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ShopSliceCommonCardPresenter(r0, this.n, this.m, this.o.e);
    }

    public n(ViewGroup r2, ECStoreViewModel r3, com.bytedance.android.shopping.store.hybridproduct.holder.e r4, n0 r5) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        Intrinsics.checkNotNullParameter(r5, "playableProxy");
        super(r2);
        this.m = r3;
        this.n = r4;
        this.o = r5;
    }
}
