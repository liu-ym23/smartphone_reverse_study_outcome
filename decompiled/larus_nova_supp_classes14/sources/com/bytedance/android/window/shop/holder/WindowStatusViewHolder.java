package com.bytedance.android.window.shop.holder;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.g0;
import com.bytedance.android.window.shop.widget.ECStructViewPlanA;
import com.bytedance.android.window.shop.widget.ECStructViewPlanB;
import com.bytedance.android.window.shop.widget.ECStructViewPlanC;
import com.bytedance.android.window.shop.widget.WindowStatusView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowStatusViewHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/g0;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowStatusViewHolder extends ShopWindowItemHolder<g0> {
    public final Fragment q;
    public final WindowStatusView r;

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r3) {
        g0 r4 = (g0) r3;
        Intrinsics.checkNotNullParameter(r4, "vo");
        if (yq3.a.a() == 1) goto L5;
    L12:
        WindowStatusView r5 = this.r;
        r5.setVisibility(0);
        r5.setECStatus(0);
        return;
    L5:
        if (Intrinsics.areEqual(r4.k, com.bytedance.android.window.shop.c.c) == true) goto L7;
        View r6 = new ECStructViewPlanB(this.q.requireContext(), null);
    L11:
        this.r.setLoading(r6);
        goto L12
    L7:
        if (r4.j.isSingleColumn() == false) goto L9;
        r6 = new ECStructViewPlanC(this.q.requireContext(), null);
        goto L11
    L9:
        r6 = new ECStructViewPlanA(this.q.requireContext(), null);
        goto L11
    }

    public WindowStatusViewHolder(Fragment r2, WindowStatusView r3, fo.b r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "statusView");
        Intrinsics.checkNotNullParameter(r4, "config");
        super(r3);
        this.q = r2;
        this.r = r3;
    }
}
