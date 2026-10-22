package com.bytedance.android.shopping.mall.feed;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.feed.holder.ECMallDoublePlaceholderCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public v(Class r1) {
        super(r1);
    }

    public final BaseViewHolder n(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        int r1 = ECMallDoublePlaceholderCard.r;
        Intrinsics.checkNotNullParameter(r4, "parent");
        LinearLayout r0 = new LinearLayout(r4.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r0.setOrientation(1);
        return new ECMallDoublePlaceholderCard(r0);
    }
}
