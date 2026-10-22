package com.bytedance.android.shopping.mall.feed;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.video.NativeVideoBigCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public final /* synthetic */ ECMallFeed.n b;

    public final BaseViewHolder n(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        int r0 = NativeVideoBigCard.C;
        ECMallFeed r1 = this.b.a;
        Integer r2 = r1.B1.s;
        g93.a r3 = r1.i0;
        Intrinsics.checkNotNullParameter(r6, "container");
        return new NativeVideoBigCard(LayoutInflater.from(r6.getContext()).inflate(2131564682, r6, false), r2, r3);
    }

    public r(ECMallFeed.n r1, Class r2) {
        this.b = r1;
        super(r2);
    }
}
