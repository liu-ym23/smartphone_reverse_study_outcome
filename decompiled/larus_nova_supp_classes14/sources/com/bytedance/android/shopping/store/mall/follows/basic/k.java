package com.bytedance.android.shopping.store.mall.follows.basic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.shopping.store.mall.follows.FollowStoreLoadMoreViewHolder;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends l0 {
    public final /* synthetic */ BaseFollowStorePresenter a;

    public k(BaseFollowStorePresenter r1) {
        this.a = r1;
    }

    public final ECLoadMoreViewHolder a(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r1 = FollowStoreLoadMoreViewHolder.q;
        BaseFollowStorePresenter r2 = this.a;
        Fragment r3 = ((QFragmentPresenter) r2).e;
        boolean r4 = r2.d0().isDoubleRaw();
        Class<T> r5 = this.a.h;
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        QUIManager r0 = new QUIManager();
        ShoppingAsyncInflater.a r6 = ShoppingAsyncInflater.e;
        Context r7 = r10.getContext();
        r6.getClass();
        View r8 = ShoppingAsyncInflater.a.a(r7).aU(2131564719, null, false);
        if (r4 == false) goto L5;
        int r9 = 0;
    L6:
        r8.setBackgroundColor(r9);
        LoadMoreStatusView r11 = r8.findViewById(2131387793);
        r11.setLayoutParams(new LinearLayout.LayoutParams(-1, vf4.a.b(44)));
        r11.setPadding(0, vf4.a.b(12), 0, vf4.a.b(12));
        r8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r0.k(new hj3.b(r8, r3, r5), r10.getContext(), r3);
        return new FollowStoreLoadMoreViewHolder(r0, r8);
    L5:
        r9 = -1;
        goto L6
    }
}
