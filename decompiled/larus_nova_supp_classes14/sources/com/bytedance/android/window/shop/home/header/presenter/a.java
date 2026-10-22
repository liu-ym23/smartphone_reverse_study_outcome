package com.bytedance.android.window.shop.home.header.presenter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.holder.ECDefLoadMoreViewHolder;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends l0 {
    public a() {
    }

    public final ECLoadMoreViewHolder a(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        FrameLayout r0 = new FrameLayout(r5.getContext());
        TextView r6 = new TextView(r0.getContext());
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, 1);
        r1.gravity = 17;
        Unit r2 = Unit.INSTANCE;
        r0.addView(r6, r1);
        return new ECDefLoadMoreViewHolder(r0);
    }
}
