package com.bytedance.android.shopping.mall.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.ECMallLoginGuideCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public final /* synthetic */ ECMallFeed.n b;

    public s(ECMallFeed.n r1) {
        this.b = r1;
        super(null);
    }

    public final BaseViewHolder n(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        ECMallLoginGuideCard.a r0 = ECMallLoginGuideCard.t;
        ECMallFeed r1 = this.b.a;
        int r2 = ECMallFeed.I1;
        String r3 = r1.B();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "container");
        Intrinsics.checkNotNullParameter(r3, "sceneId");
        ECMallLoginGuideCard r4 = new ECMallLoginGuideCard(LayoutInflater.from(r5.getContext()).inflate(2131560790, r5, false));
        r4.o = r3;
        return r4;
    }
}
