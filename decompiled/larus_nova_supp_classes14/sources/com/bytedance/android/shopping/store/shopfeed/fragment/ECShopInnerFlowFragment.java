package com.bytedance.android.shopping.store.shopfeed.fragment;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.shopping.store.shopfeed.c;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/fragment/ECShopInnerFlowFragment;", "Lcom/bytedance/android/shopping/store/shopfeed/fragment/AbsShopFeedFragment;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopInnerFlowFragment extends AbsShopFeedFragment {
    @Override // com.bytedance.android.shopping.store.shopfeed.fragment.AbsShopFeedFragment
    public final int S90() {
        return ColorProtector.parseColor("#DFE1EE");
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.fragment.AbsShopFeedFragment
    public final String T90() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("shop_inner_flow_btm");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "a1.b66972";
    }

    public ECShopInnerFlowFragment() {
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.fragment.AbsShopFeedFragment
    public final Class<c> U90() {
        return c.class;
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.fragment.AbsShopFeedFragment
    public final QUIModule V90(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        return new c(r2, this);
    }
}
