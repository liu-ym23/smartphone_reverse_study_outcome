package com.bytedance.android.window.shop.widget;

import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowStatusViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z extends gr3.d {
    public final /* synthetic */ WindowTypeSeparatedAdapter a;

    public z(WindowTypeSeparatedAdapter r1) {
        this.a = r1;
    }

    @Override // gr3.d
    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r2, com.bytedance.android.window.shop.repository.tab.entity.f r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r3, "vo");
        r2.getClass();
        if ((!(r2 instanceof WindowStatusViewHolder)) == false) goto L6;
        this.a.q.invoke(Integer.valueOf(r4));
        return;
    }
}
