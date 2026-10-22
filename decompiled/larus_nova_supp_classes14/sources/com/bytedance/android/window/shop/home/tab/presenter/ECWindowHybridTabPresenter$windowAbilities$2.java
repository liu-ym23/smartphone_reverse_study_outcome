package com.bytedance.android.window.shop.home.tab.presenter;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.ability.l0;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.window.shop.holder.footer.WindowHybridFooterHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowHybridTabPresenter$windowAbilities$2 extends l0 {
    public final /* synthetic */ ECWindowHybridTabPresenter a;

    public ECWindowHybridTabPresenter$windowAbilities$2(ECWindowHybridTabPresenter r1) {
        this.a = r1;
    }

    public final ECLoadMoreViewHolder a(final ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        final Context r1 = r3.getContext();
        WindowHybridFooterHolder r0 = new ECWindowHybridTabPresenter$windowAbilities$2$createLoadMoreHolder$1(this, r3, r1);
        this.a.h = r0;
        return r0;
    }
}
