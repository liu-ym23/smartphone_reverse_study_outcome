package com.bytedance.android.shopping.feed.viewholder;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.productcard.doublefeedproductcard.view.DoubleFeedFlowProductCardView;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewholder/DoubleListFeedProductCardVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lrd3/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleListFeedProductCardVH extends JediSimpleViewHolder<ProductFeedAdapter.b<rd3.a>> {
    public rd3.a l;
    public final ProductFeedAdapter m;
    public final DoubleFeedFlowProductCardView n;

    public final void onDestroy() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof FlowTinyProductView) == true) goto L5;
        r0 = null;
    L5:
        FlowTinyProductView r1 = (FlowTinyProductView) r0;
        if (r1 == null) goto L11;
        Disposable r2 = r1.c.c;
        if (r2 == null) goto L12;
        r2.dispose();
        return;
    L12:
        return;
    }

    public final void T3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.T3();
        rd3.a r0 = this.l;
        if (r0 == null) goto L7;
        Promotion r1 = r0.f();
        if (r1 == null) goto L7;
        PromotionProductStruct r2 = r1.getPromotionInfo();
    L8:
        if (r2 == null) goto L12;
        PromotionProductBaseStruct r3 = r2.getBaseInfo();
        if (r3 == null) goto L12;
        String r4 = r3.getProductId();
    L14:
        if (this.m.u.contains(r4) == true) goto L24;
        this.m.u.add(r4);
        FeedProductEventTracker r5 = FeedProductEventTracker.a;
        rd3.a r6 = this.l;
        Boolean r7 = Boolean.FALSE;
        r5.getClass();
        FeedProductEventTracker.O(r6, r7, null);
        rd3.a r8 = this.l;
        if (r8 == null) goto L18;
        FeedProductEventTracker.v(r5, this.n.getContext(), r8, null, false, null, 28);
    L18:
        rd3.a r9 = this.l;
        if (r9 != null) goto L21;
        return;
    L21:
        if (r9.b() != true) goto L26;
        FeedProductEventTracker.p(this.l);
        return;
    L26:
        return;
    L24:
        return;
    L12:
        r4 = null;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a4(Object r3) {
        ProductFeedAdapter.b r4 = (ProductFeedAdapter.b) r3;
        Intrinsics.checkNotNullParameter(r4, "item");
        rd3.a r0 = (rd3.a) r4.b;
        if (r0 == null) goto L5;
        r0.f = getPosition() - 1;
    L5:
        rd3.a r1 = (rd3.a) r4.b;
        if (r1 == null) goto L8;
        r1.g = Integer.valueOf(getLayoutPosition());
    L8:
        rd3.a r2 = (rd3.a) r4.b;
        if (r2 == null) goto L11;
        this.n.a(r2);
    L11:
        this.l = (rd3.a) r4.b;
    }

    public DoubleListFeedProductCardVH(Context r5, ProductFeedAdapter r6) {
        DoubleFeedFlowProductCardView r0 = new DoubleFeedFlowProductCardView(r5, null, 6, 0);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "adapter");
        Intrinsics.checkNotNullParameter(r0, FreqActions.ACTION_VIEW);
        super(r0);
        this.m = r6;
        this.n = r0;
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    }
}
