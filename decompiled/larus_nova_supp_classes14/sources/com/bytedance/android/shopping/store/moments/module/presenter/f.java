package com.bytedance.android.shopping.store.moments.module.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.shopping.store.moments.holder.LoadMoreViewHolder;
import com.bytedance.android.shopping.store.moments.viewmodel.ECStoreMomentViewModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends l0 {
    public final /* synthetic */ ECStoreMomentPresenter a;

    public f(ECStoreMomentPresenter r1) {
        this.a = r1;
    }

    public final ECLoadMoreViewHolder a(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r1 = LoadMoreViewHolder.q;
        ECStoreMomentViewModel r2 = this.a.d0();
        Fragment r3 = ((QFragmentPresenter) this.a).e;
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        QUIManager r0 = new QUIManager();
        ShoppingAsyncInflater.a r4 = ShoppingAsyncInflater.e;
        Context r5 = r10.getContext();
        r4.getClass();
        View r6 = ShoppingAsyncInflater.a.a(r5).aU(2131564716, null, false);
        LoadMoreStatusView r7 = r6.findViewById(2131387793);
        r7.setLayoutParams(new LinearLayout.LayoutParams(-1, vf4.a.b(44)));
        r7.setPadding(0, vf4.a.b(12), 0, vf4.a.b(12));
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r0.k(new jj3.b(r6, new com.bytedance.android.shopping.store.moments.a(), r3), r10.getContext(), r3);
        return new LoadMoreViewHolder(r0, r6, r2);
    }
}
