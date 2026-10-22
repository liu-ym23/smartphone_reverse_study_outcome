package com.bytedance.android.shopping.mall.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.feed.card.DeliveryCard;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public o(Class r1) {
        super(r1);
    }

    public final BaseViewHolder n(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        Map<Integer, List<View>> r1 = com.bytedance.android.shopping.mall.homepage.opt.i.a;
        return new DeliveryCard(r0.inflate(2131564675, r4, false));
    }
}
