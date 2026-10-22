package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.shopping.store.hybridproduct.module.g;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopHybridProductLoadMoreViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLoadMoreViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopHybridProductLoadMoreViewHolder extends ECLoadMoreViewHolder {
    public static final /* synthetic */ int q = 0;
    public final QUIManager o;
    public final View p;

    public static final class a {
        public static ECShopHybridProductLoadMoreViewHolder a(ViewGroup r7, Fragment r8) {
            Intrinsics.checkNotNullParameter(r7, "parent");
            Intrinsics.checkNotNullParameter(r8, "fragment");
            QUIManager r0 = new QUIManager();
            ShoppingAsyncInflater.a r1 = ShoppingAsyncInflater.e;
            Context r2 = r7.getContext();
            r1.getClass();
            View r3 = ShoppingAsyncInflater.a.a(r2).aU(2131564716, null, false);
            LoadMoreStatusView r4 = r3.findViewById(2131387793);
            r4.setLayoutParams(new LinearLayout.LayoutParams(-1, vf4.a.b(44)));
            r4.setPadding(0, vf4.a.b(12), 0, vf4.a.b(12));
            r3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            r0.k(new g(r3, r8), r7.getContext(), r8);
            return new ECShopHybridProductLoadMoreViewHolder(r0, r3);
        }
    }

    static {
    }

    public ECShopHybridProductLoadMoreViewHolder(QUIManager r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        this.o = r2;
        this.p = r3;
    }

    public final void b4(Object r2, String r3, k.a r4) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        super/*com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder*/.b4(r2, r3, r4);
        this.o.c(g.class, null);
    }
}
