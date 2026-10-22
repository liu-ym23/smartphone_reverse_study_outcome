package com.bytedance.android.shopping.mall.feed;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.feed.holder.ECMallSinglePlaceholderCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class u extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public u(Class r1) {
        super(r1);
    }

    public final BaseViewHolder n(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        int r1 = ECMallSinglePlaceholderCard.p;
        Intrinsics.checkNotNullParameter(r4, "parent");
        FrameLayout r0 = new FrameLayout(r4.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new ECMallSinglePlaceholderCard(r0);
    }
}
