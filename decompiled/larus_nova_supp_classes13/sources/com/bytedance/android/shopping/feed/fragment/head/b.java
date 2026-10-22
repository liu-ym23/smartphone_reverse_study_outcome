package com.bytedance.android.shopping.feed.fragment.head;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.ec.model.response.anchorv3.InnerFlowCouponExtra;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCouponsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.view.CouponView;
import com.bytedance.android.shopping.feed.view.InnerFeedPageRightWidget;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements c {

    public static final class a implements CouponView.b {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ g b;
        public final /* synthetic */ CouponUrgeInfo c;

        @Override // com.bytedance.android.shopping.feed.view.CouponView.b
        public final void a(String r8) {
            Intrinsics.checkNotNullParameter(r8, "couponInfo");
            Intrinsics.checkNotNullParameter(r8, "couponInfo");
            Ref.BooleanRef r0 = this.a;
            if (r0.element == false) goto L6;
            r0.element = false;
            int r1 = nd3.b.a;
            Context r2 = this.b.getContext();
            String r3 = String.valueOf(this.c.getCouponId());
            String r4 = String.valueOf(this.c.getCouponType());
            String r5 = this.b.a.getVideoId();
            String r6 = this.b.a.getProductId();
            nd3.d r7 = new nd3.d();
            r7.a = "product_flow_page";
            r7.b = r3;
            r7.c = r4;
            r7.d = r8;
            r7.e = null;
            r7.f = null;
            r7.g = r5;
            r7.h = r6;
            com.bytedance.android.shopping.feed.event.g.c(r7, r2, null);
            return;
        }

        @Override // com.bytedance.android.shopping.feed.view.CouponView.b
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "couponInfo");
            Intrinsics.checkNotNullParameter(r2, "couponInfo");
        }

        public a(Ref.BooleanRef r1, g r2, CouponUrgeInfo r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public b() {
    }

    @Override // com.bytedance.android.shopping.feed.fragment.head.c
    public final boolean a(g r13) {
        Intrinsics.checkNotNullParameter(r13, "data");
        PromotionProductPrivilegesStruct r0 = r13.a.getCurrentPromotion().getPrivilegeInfo();
        if (r0 == null) goto L30;
        PromotionProductCouponsStruct r1 = r0.getCoupons();
        if (r1 == null) goto L30;
        InnerFlowCouponExtra r2 = r1.getInnerFlowCouponExtra();
        if (r2 == null) goto L30;
        CouponUrgeInfo r3 = r2.getCouponUrgeInfo();
        if (r3 == null) goto L30;
        if (r13.getContext() != null) goto L14;
        return false;
    L14:
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        r4.element = true;
        ViewGroup.LayoutParams r5 = null;
        CouponView r7 = new CouponView(r13.getContext(), null, 6, 0);
        r13.b.removeAllViews();
        r7.setElevation(2.5f);
        r7.setBackgroundResource(2131234586);
        FrameLayout r6 = r13.b;
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-1, -2);
        r8.setMargins(com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
        Unit r9 = Unit.INSTANCE;
        r6.addView(r7, r8);
        r7.a(r3, false, new a(r4, r13, r3));
        r13.b.setTranslationY(-com.bytedance.android.shopping.extensions.b.b(52));
        AnchorV3Param r10 = r13.a;
        Context r11 = r13.getContext();
        CouponView r12 = r13.d;
        ProductFeedContentFragment r14 = r13.e;
        if (r12 == null) goto L17;
        r12.setVisibility(0);
    L17:
        if (r14 == null) goto L27;
        int r15 = com.bytedance.android.shopping.extensions.b.b(48);
        InnerFeedPageRightWidget r16 = r14.i;
        if (r16 == null) goto L27;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        r5 = r17;
    L24:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r5;
        if (r18 == null) goto L27;
        r18.setMargins(r18.leftMargin + 0, r18.topMargin + 0, r18.rightMargin + 0, r18.bottomMargin + r15);
        r16.setLayoutParams(r18);
    L27:
        if (r12 == null) goto L29;
        r12.a(r3, true, new com.bytedance.android.shopping.feed.fragment.head.a(r3, r12, r11, r10, r7));
    L29:
        return true;
    L30:
        return false;
    }
}
