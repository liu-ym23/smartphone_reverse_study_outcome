package com.bytedance.android.shopping.store.home.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.home.presenter.d4;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r extends QUIModule {
    public final View l;
    public final RecyclerView m;
    public final boolean n;

    public final QIPresenter h() {
        Fragment r0 = a().i();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (this.n == false) goto L11;
        return new com.bytedance.android.shopping.store.aggregate.presenter.d((ShopAggregateProductListFragment) r0);
    L11:
        return new d4(r0, this.m);
    }

    public r(View r2, RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super(0);
        this.l = r2;
        this.m = r3;
        this.n = true;
    }

    public final View f(Context r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.l;
    }
}
