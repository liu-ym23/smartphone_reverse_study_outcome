package com.bytedance.android.shopping.store.tabkit.mixframe.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.shopping.store.tabkit.mixframe.MixFrameLoadMoreViewHolder;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends l0 {
    public final /* synthetic */ ECTabKitMixEnginePresenter a;

    public d(ECTabKitMixEnginePresenter r1) {
        this.a = r1;
    }

    public final ECLoadMoreViewHolder a(ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        int r1 = MixFrameLoadMoreViewHolder.q;
        Fragment r2 = ((QFragmentPresenter) this.a).e;
        Intrinsics.checkNotNullParameter(r9, "parent");
        Intrinsics.checkNotNullParameter(r2, "fragment");
        QUIManager r0 = new QUIManager();
        ShoppingAsyncInflater.a r3 = ShoppingAsyncInflater.e;
        Context r4 = r9.getContext();
        r3.getClass();
        View r5 = ShoppingAsyncInflater.a.a(r4).aU(2131564716, null, false);
        LoadMoreStatusView r6 = r5.findViewById(2131387793);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-1, vf4.a.b(44)));
        r6.setPadding(0, vf4.a.b(12), 0, vf4.a.b(12));
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r0.k(new com.bytedance.android.shopping.store.tabkit.mixframe.d(r5, r2), r9.getContext(), r2);
        return new MixFrameLoadMoreViewHolder(r0, r5);
    }
}
