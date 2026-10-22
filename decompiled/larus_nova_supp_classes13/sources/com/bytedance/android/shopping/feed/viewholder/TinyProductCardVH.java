package com.bytedance.android.shopping.feed.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.view.bottombar.InflowFeedBottomBarView;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductCard;
import com.bytedance.android.shopping.feed.widget.ProductFeedAbilityBarView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/viewholder/TinyProductCardVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lrd3/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TinyProductCardVH extends JediSimpleViewHolder<ProductFeedAdapter.b<rd3.a>> {
    public rd3.a l;
    public final ProductFeedAbilityBarView.a m;
    public final ProductFeedAdapter n;
    public final FlowTinyProductCard o;

    public final void T3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.T3();
        rd3.a r0 = this.l;
        if (r0 == null) goto L5;
        this.m.a(r0);
    L5:
        rd3.a r1 = this.l;
        if (r1 == null) goto L10;
        Promotion r2 = r1.f();
        if (r2 == null) goto L10;
        PromotionProductStruct r3 = r2.getPromotionInfo();
    L11:
        if (r3 == null) goto L15;
        PromotionProductBaseStruct r4 = r3.getBaseInfo();
        if (r4 == null) goto L15;
        String r5 = r4.getProductId();
    L17:
        if (this.n.u.contains(r5) == true) goto L27;
        this.n.u.add(r5);
        FeedProductEventTracker r6 = FeedProductEventTracker.a;
        rd3.a r7 = this.l;
        Boolean r8 = Boolean.FALSE;
        r6.getClass();
        FeedProductEventTracker.O(r7, r8, null);
        rd3.a r9 = this.l;
        if (r9 == null) goto L21;
        FeedProductEventTracker.v(r6, this.o.getContext(), r9, null, false, null, 28);
    L21:
        rd3.a r10 = this.l;
        if (r10 != null) goto L24;
        return;
    L24:
        if (r10.b() != true) goto L29;
        FeedProductEventTracker.p(this.l);
        return;
    L29:
        return;
    L27:
        return;
    L15:
        r5 = null;
    L10:
        r3 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a4(Object r7) {
        ProductFeedAdapter.b r8 = (ProductFeedAdapter.b) r7;
        Intrinsics.checkNotNullParameter(r8, "item");
        rd3.a r0 = (rd3.a) r8.b;
        if (r0 == null) goto L5;
        r0.f = getPosition() - 1;
    L5:
        rd3.a r1 = (rd3.a) r8.b;
        if (r1 == null) goto L8;
        r1.g = Integer.valueOf(getLayoutPosition());
    L8:
        rd3.a r2 = (rd3.a) r8.b;
        if (r2 == null) goto L25;
        FlowTinyProductCard r3 = this.o;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "anchorInflowFeedItem");
        r3.d = r2;
        InflowFeedBottomBarView r4 = r3.c;
        int r5 = InflowFeedBottomBarView.k;
        r4.a(r2, null, null);
        boolean r6 = false;
        if (r2.b() == false) goto L13;
        r3.a.setVisibility(0);
        r3.a.b(r2);
    L14:
        r3.b.b(r2);
        ViewGroup.LayoutParams r9 = r3.c.getLayoutParams();
        if (r9 == null) goto L24;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        if (r3.a.getVisibility() != 8) goto L19;
        r6 = true;
    L19:
        if (r6 == false) goto L21;
        double r11 = 15.5d;
    L22:
        Resources r12 = Resources.getSystem();
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, (float) r11, WindowDisplayMetricsOverride.apply(r12, r12.getDisplayMetrics())));
        r10.setMargins(r10.leftMargin, r13, r10.rightMargin, r10.bottomMargin);
        goto L25
    L21:
        r11 = 13.5d;
        goto L22
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        r3.a.setVisibility(8);
    L25:
        this.l = (rd3.a) r8.b;
    }

    public TinyProductCardVH(Context r5, ProductFeedAdapter r6) {
        FlowTinyProductCard r0 = new FlowTinyProductCard(r5, null, 6, 0);
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "adapter");
        Intrinsics.checkNotNullParameter(r0, FreqActions.ACTION_VIEW);
        super(r0);
        this.n = r6;
        this.o = r0;
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.m = new ProductFeedAbilityBarView.a(r6, r0.getBottomBar().getAbilityViewView());
    }
}
