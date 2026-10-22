package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ShopSliceProductFilterPresenter;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w extends rm.a {
    public final ECStoreViewModel m;
    public final com.bytedance.android.ecom.arch.slice.render.r n;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 == null) goto L5;
        QGroupPresenter r1 = new QGroupPresenter();
        r1.a(new ShopSliceProductFilterPresenter(r0, this.n, this.m));
        return r1;
    L5:
        return null;
    }

    public w(ViewGroup r2, ECStoreViewModel r3, com.bytedance.android.ecom.arch.slice.render.r r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        super(r2);
        this.m = r3;
        this.n = r4;
    }
}
