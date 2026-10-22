package com.bytedance.android.shopping.feed.fragment.head;

import android.content.Context;
import com.bytedance.android.ec.model.response.anchorv3.CouponUrgeInfo;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.view.CouponView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements CouponView.b {
    public final /* synthetic */ CouponUrgeInfo a;
    public final /* synthetic */ CouponView b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ AnchorV3Param d;
    public final /* synthetic */ CouponView e;

    @Override // com.bytedance.android.shopping.feed.view.CouponView.b
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "couponInfo");
        Intrinsics.checkNotNullParameter(r2, "couponInfo");
    }

    @Override // com.bytedance.android.shopping.feed.view.CouponView.b
    public final void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "couponInfo");
        int r0 = nd3.b.a;
        Context r1 = this.c;
        String r2 = String.valueOf(this.a.getCouponId());
        String r3 = String.valueOf(this.a.getCouponType());
        String r4 = this.d.getVideoId();
        String r5 = this.d.getProductId();
        nd3.c r6 = new nd3.c();
        r6.a = "product_flow_page";
        r6.b = r2;
        r6.c = r3;
        r6.d = r8;
        r6.e = null;
        r6.f = null;
        r6.g = r4;
        r6.h = r5;
        com.bytedance.android.shopping.feed.event.g.c(r6, r1, null);
        this.b.setVisibility(8);
        CouponView r9 = this.e;
        if (r9 == null) goto L6;
        r9.setVisibility(8);
        return;
    }

    public a(CouponUrgeInfo r1, CouponView r2, Context r3, AnchorV3Param r4, CouponView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
