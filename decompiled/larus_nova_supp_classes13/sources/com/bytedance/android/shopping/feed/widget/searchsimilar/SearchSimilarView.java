package com.bytedance.android.shopping.feed.widget.searchsimilar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.goodprice.enums.LocationType;
import com.bytedance.android.shopping.inflow.view.d;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/searchsimilar/SearchSimilarView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSimilarView extends FrameLayout {
    public rd3.a a;
    public String b;
    public final LinearLayout c;
    public final ECDraweeView d;

    public interface a {
        void onClick();
    }

    public SearchSimilarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SearchSimilarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public SearchSimilarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560656, this, true);
        this.c = (LinearLayout) findViewById(2131385595);
        this.d = findViewById(2131385596);
    }

    public /* synthetic */ SearchSimilarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(final rd3.a r18, String r19, final View r20, final d r21) {
        Intrinsics.checkNotNullParameter(r20, FreqActions.ACTION_VIEW);
        this.a = r18;
        this.b = r19;
        Promotion r1 = r18.f();
        if (r1 == null) goto L9;
        PromotionProductStruct r2 = r1.getPromotionInfo();
        if (r2 == null) goto L9;
        PromotionProductExtraStruct r3 = r2.getExtraInfo();
        if (r3 == null) goto L9;
        final String r4 = r3.getImgSearchSchema();
    L10:
        Promotion r5 = r18.f();
        if (r5 == null) goto L18;
        PromotionProductStruct r6 = r5.getPromotionInfo();
        if (r6 == null) goto L18;
        PromotionProductBaseStruct r7 = r6.getBaseInfo();
        if (r7 == null) goto L18;
        String r8 = r7.getProductId();
        if (r8 == null) goto L18;
    L19:
        final String r16 = r8;
        ECDraweeView r9 = this.d;
        if (r9 == null) goto L22;
        h0.e(r9, r19, new r("ec_goods_feed", "ec_goods_feed_default"), null, null, 120);
    L22:
        LinearLayout r10 = this.c;
        if (r10 == null) goto L25;
        f.c(r10, null, null, new SearchSimilarView$bind$2(this, r4, r20, r18, r16, r21), 3);
    L25:
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        String r11 = k.d(CollectionsKt.emptyList());
        String r12 = LocationType.INFLOW_MAIN_CARD_IMAGE_WIDTH_FEEDBACK.getType();
        String r13 = r18.d;
        r0.getClass();
        FeedProductEventTracker.w("inflow_low_price_entrance_show", r18, r11, r12, "c12364.d714373", r16, r13);
        return;
    L18:
        r8 = "";
    L9:
        r4 = null;
        goto L10
    }
}
