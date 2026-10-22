package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.n1;
import com.bytedance.android.shopping.feed.event.y;
import com.bytedance.android.shopping.feed.utils.ProductFeedActionHelper;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/RowPanelView;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RowPanelView extends BasePanelView {
    public static final /* synthetic */ int f = 0;
    public final FlowTinyProductView e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PromotionProductStruct a;
        public final /* synthetic */ RowPanelView b;
        public final /* synthetic */ rd3.a c;

        public static final class a implements nl.d {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void b(String r10, Map r11) {
                Intrinsics.checkNotNullParameter(r10, "enterPageType");
                FeedProductEventTracker r0 = FeedProductEventTracker.a;
                b r12 = this.a;
                rd3.a r1 = r12.c;
                Promotion r4 = r12.b.getPromotion();
                Promotion r13 = this.a.b.getPromotion();
                ProductFeedViewModel r14 = null;
                if (r13 == null) goto L9;
                PromotionProductStruct r15 = r13.getPromotionInfo();
                if (r15 == null) goto L9;
                PromotionProductBaseStruct r16 = r15.getBaseInfo();
                if (r16 == null) goto L9;
                String r3 = r16.getProductId();
            L10:
                FeedProductEventTracker.m(r0, r1, "buynow", r3, r4, null, null, null, 112);
                Context r2 = this.a.b.getContext();
                b r17 = this.a;
                rd3.a r5 = r17.c;
                if (r5 == null) goto L13;
                r14 = r5.c;
            L13:
                FeedProductEventTracker.j(r2, r14, r5, r17.b.getPromotion(), null, null);
                s0.a(new n1());
                return;
            L9:
                r3 = null;
                goto L10
            }
        }

        public b(PromotionProductStruct r1, RowPanelView r2, rd3.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r20) {
            EventBus.getDefault().post(new y("forward"));
            if (this.c.e == false) goto L5;
            String r1 = "a1.b7365.c3865.d60364";
        L6:
            Context r2 = this.b.getContext();
            if ((r2 instanceof FragmentActivity) == true) goto L9;
            r2 = null;
        L9:
            FragmentActivity r6 = (FragmentActivity) r2;
            rd3.a r7 = this.c;
            a r8 = new a(this);
            PromotionProductStruct r10 = this.a;
            Promotion r3 = this.b.getPromotion();
            if (r3 == null) goto L12;
            String r11 = r3.getRecommendInfo();
        L13:
            ProductFeedActionHelper.e(r20, r6, r7, r8, null, r10, r11, new BtmItemBuilder(r1, null, 2, null).withPageFinder(PageFinder.via(r20)), null, false, null, null, null, 7952);
            return;
        L12:
            r11 = null;
            goto L13
        L5:
            r1 = "a1.b7365.c4701.d05311";
            goto L6
        }
    }

    static {
    }

    public RowPanelView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RowPanelView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.BasePanelView
    public final void a(rd3.a r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "anchorInflowFeedItem");
        super.a(r4, r5);
        Promotion r6 = getPromotion();
        if (r6 == null) goto L27;
        PromotionProductStruct r7 = r6.getPromotionInfo();
        if (r7 == null) goto L28;
        FlowTinyProductView r0 = this.e;
        if (r0 == null) goto L21;
        yd3.p r1 = r4.i();
        if (r1 == null) goto L13;
        yd3.m r2 = r1.l();
        if (r2 == null) goto L13;
        Integer r3 = r2.f();
    L14:
        if (r3 != null) goto L17;
    L19:
        int r8 = 5;
    L20:
        r0.setStyle(r8);
        r0.a(r7);
        goto L21
    L17:
        if (r3.intValue() != 4) goto L19;
        r8 = 6;
    L13:
        r3 = null;
    L21:
        FlowTinyProductView r9 = this.e;
        if (r9 == null) goto L29;
        AppCompatButton r10 = r9.getBuyButton();
        if (r10 == null) goto L30;
        r10.setOnClickListener(new b(r7, this, r4));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    public RowPanelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560811, this, true);
        this.e = (FlowTinyProductView) findViewById(2131383182);
    }

    public /* synthetic */ RowPanelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
