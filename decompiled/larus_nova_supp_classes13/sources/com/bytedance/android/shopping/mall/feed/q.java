package com.bytedance.android.shopping.mall.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.live.NativeLiveBigCard;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public final /* synthetic */ ECMallFeed.n b;

    public final BaseViewHolder n(ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        int r0 = NativeLiveBigCard.U;
        Fragment r3 = this.b.a.A1.M();
        Fragment r1 = this.b.a.A1.M();
        if (r1 == null) goto L5;
        View r2 = r1.getView();
    L6:
        View r4 = r2;
        ECMallFeed r5 = this.b.a;
        ECMallFeed.e r6 = r5.B1;
        boolean r7 = r6.i;
        int r8 = r6.n;
        Integer r9 = r6.s;
        com.bytedance.android.shopping.mall.homepage.card.live.n r10 = r5.h0;
        g93.a r12 = r5.i0;
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r10, "pageStateChangeObserver");
        return new NativeLiveBigCard(LayoutInflater.from(r11.getContext()).inflate(2131564680, r11, false), r3, r4, r7, r8, r9, r10, r12);
    L5:
        r2 = null;
        goto L6
    }

    public q(ECMallFeed.n r1, Class r2) {
        this.b = r1;
        super(r2);
    }
}
