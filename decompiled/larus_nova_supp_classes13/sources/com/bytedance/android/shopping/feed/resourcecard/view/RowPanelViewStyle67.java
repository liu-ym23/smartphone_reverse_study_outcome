package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductViewStyle67;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/RowPanelViewStyle67;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;", "Lyd3/m;", "panelsNode", "", "setImage", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RowPanelViewStyle67 extends BasePanelView {
    public static final /* synthetic */ int f = 0;
    public final FlowTinyProductViewStyle67 e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RowPanelViewStyle67 a;
        public final /* synthetic */ rd3.a b;

        public b(RowPanelViewStyle67 r1, rd3.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            FeedProductEventTracker r0 = FeedProductEventTracker.a;
            rd3.a r1 = this.b;
            Promotion r4 = this.a.getPromotion();
            Promotion r11 = this.a.getPromotion();
            if (r11 == null) goto L9;
            PromotionProductStruct r12 = r11.getPromotionInfo();
            if (r12 == null) goto L9;
            PromotionProductBaseStruct r13 = r12.getBaseInfo();
            if (r13 == null) goto L9;
            String r14 = r13.getProductId();
        L10:
            FeedProductEventTracker.m(r0, r1, "pic", r14, r4, null, null, null, 112);
            Promotion r15 = this.a.getPromotion();
            if (r15 == null) goto L16;
            String r16 = r15.getLink();
            if (r16 == null) goto L17;
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.getContext(), r16);
            return;
        L17:
            return;
        L16:
            return;
        L9:
            r14 = null;
            goto L10
        }
    }

    static {
    }

    public RowPanelViewStyle67(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RowPanelViewStyle67(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final void setImage(yd3.m r11) {
        FlowTinyProductViewStyle67 r0 = this.e;
        ECUrlModel r1 = null;
        if (r0 == null) goto L10;
        ECDraweeView r2 = r0.getLineDv();
        if (r2 == null) goto L10;
        if (r11 == null) goto L8;
        ECUrlModel r3 = r11.g();
    L9:
        h0.d(r2, r3, null, null, null, null, null, 120);
        goto L10
    L8:
        r3 = null;
    L10:
        FlowTinyProductViewStyle67 r4 = this.e;
        if (r4 == null) goto L18;
        ECDraweeView r5 = r4.getDiscountMinPriceBg();
        if (r5 == null) goto L19;
        if (r11 == null) goto L16;
        r1 = r11.d();
    L16:
        h0.d(r5, r1, null, null, null, null, null, 120);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.BasePanelView
    public final void a(rd3.a r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "anchorInflowFeedItem");
        super.a(r3, r4);
        yd3.p r5 = r3.i();
        if (r5 == null) goto L5;
        yd3.m r6 = r5.l();
    L6:
        Promotion r0 = getPromotion();
        if (r0 == null) goto L17;
        PromotionProductStruct r1 = r0.getPromotionInfo();
        if (r1 == null) goto L18;
        FlowTinyProductViewStyle67 r2 = this.e;
        if (r2 == null) goto L13;
        r2.a(r1);
    L13:
        setImage(r6);
        FlowTinyProductViewStyle67 r7 = this.e;
        if (r7 == null) goto L19;
        r7.setOnClickListener(new b(this, r3));
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public RowPanelViewStyle67(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560812, this, true);
        this.e = (FlowTinyProductViewStyle67) findViewById(2131383182);
    }

    public /* synthetic */ RowPanelViewStyle67(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
