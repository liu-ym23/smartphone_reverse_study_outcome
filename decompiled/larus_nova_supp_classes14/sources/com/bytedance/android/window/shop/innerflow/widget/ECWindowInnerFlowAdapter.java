package com.bytedance.android.window.shop.innerflow.widget;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowEmptyHolder;
import com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder;
import com.bytedance.android.window.shop.innerflow.holder.ECWindowInnerFlowFooterHolder;
import com.bytedance.android.window.shop.innerflow.holder.factory.ECShopInnerFlowHolderFactory;
import com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import eq3.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vp3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002j\u0002`\u00040\u0001¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECWindowInnerFlowAdapter;", "Lcom/bytedance/android/window/shop/widget/WindowRecyclerViewWithHeaderAndFooterAdapterV2;", "Lcom/bytedance/android/window/shop/innerflow/holder/ECShopInnerFlowItemHolder;", "Lvp3/b;", "Lcom/bytedance/android/window/shop/innerflow/holder/ECShopInnerFlowHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowAdapter extends WindowRecyclerViewWithHeaderAndFooterAdapterV2<ECShopInnerFlowItemHolder<? extends b>> {
    public final List<b> c;
    public ECWindowInnerFlowFooterHolder d;
    public boolean e;
    public final Activity f;
    public final Function0<Unit> g;

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final int getBasicItemCount() {
        return ((ArrayList) this.c).size();
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final int getBasicItemViewType(int r2) {
        return ((b) ListProtector.get(this.c, r2)).getType();
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        ECWindowInnerFlowFooterHolder r0 = new ECWindowInnerFlowFooterHolder(r2.getContext());
        this.d = r0;
        return r0;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        ECShopInnerFlowItemHolder r3 = (ECShopInnerFlowItemHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewRecycled(r3);
        r3.U3();
    }

    public final void z2(FooterStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "footerStatus");
        ECWindowInnerFlowFooterHolder r0 = this.d;
        if (r0 == null) goto L6;
        r0.V3(r2);
        return;
    }

    public ECWindowInnerFlowAdapter(FragmentActivity r2, Function0 r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "firstBindCallback");
        this.f = r2;
        this.g = r3;
        this.c = new ArrayList();
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r4, int r5) {
        ECShopInnerFlowItemHolder r6 = (ECShopInnerFlowItemHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        b r7 = (b) ListProtector.get(this.c, r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "vo");
        r7.a.b(b.c, Integer.valueOf(r6.getLayoutPosition()));
        r6.T3(r7);
        View r8 = ((RecyclerView.ViewHolder) r6).itemView;
        if (this.e == true) goto L7;
        this.e = true;
        r8.post(new a(this));
        return;
    }

    @Override // com.bytedance.android.window.shop.widget.WindowRecyclerViewWithHeaderAndFooterAdapterV2
    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Map<Integer, Function1<Activity, ECShopInnerFlowItemHolder<? extends b>>> r4 = ECShopInnerFlowHolderFactory.a;
        Activity r5 = this.f;
        Intrinsics.checkNotNullParameter(r5, "activity");
        Function1<Activity, ECShopInnerFlowItemHolder<? extends b>> r6 = ECShopInnerFlowHolderFactory.a.get(Integer.valueOf(r3));
        if (r6 == null) goto L7;
        ECShopInnerFlowItemHolder r7 = (ECShopInnerFlowItemHolder) r6.invoke(r5);
        if (r7 == null) goto L7;
        return r7;
    L7:
        return new ECShopInnerFlowEmptyHolder(new View(r5));
    }
}
