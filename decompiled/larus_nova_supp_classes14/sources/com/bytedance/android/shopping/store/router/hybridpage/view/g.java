package com.bytedance.android.shopping.store.router.hybridpage.view;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopHybridProductLoadMoreViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends l0 {
    public final /* synthetic */ Fragment a;

    public g(Fragment r1) {
        this.a = r1;
    }

    public final ECLoadMoreViewHolder a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        int r0 = ECShopHybridProductLoadMoreViewHolder.q;
        return ECShopHybridProductLoadMoreViewHolder.a.a(r2, this.a);
    }
}
