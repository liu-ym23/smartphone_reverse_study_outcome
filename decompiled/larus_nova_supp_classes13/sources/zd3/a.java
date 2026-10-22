package zd3;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.resourcecard.view.coupon_divert.CouponNodeViewStyleCouponDivert;
import yd3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ CouponNodeViewStyleCouponDivert a;
    public final /* synthetic */ rd3.a b;

    public a(CouponNodeViewStyleCouponDivert r1, rd3.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r21) {
        rd3.a r1 = this.b;
        String r2 = null;
        if (r1 == null) goto L7;
        p r3 = r1.i();
        if (r3 == null) goto L7;
        String r4 = r3.n();
    L8:
        rd3.a r5 = this.b;
        if (r5 == null) goto L28;
        p r6 = r5.i();
        if (r6 != null) goto L13;
        return;
    L13:
        if (r6.getType() != 12) goto L30;
        if (r4 == null) goto L31;
        FeedProductEventTracker r7 = FeedProductEventTracker.a;
        rd3.a r8 = this.b;
        CouponNodeViewStyleCouponDivert r9 = this.a;
        int r12 = CouponNodeViewStyleCouponDivert.d;
        r9.getClass();
        if (r8 == null) goto L20;
        p r13 = r8.i();
        if (r13 == null) goto L20;
        Integer r14 = Integer.valueOf(r13.getType());
    L21:
        if (r14 != null) goto L24;
    L26:
        FeedProductEventTracker.m(r7, r8, "coupon", null, null, null, null, r2, 60);
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r21.getContext(), md3.a.a(r4, BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "c870003.d993139", PageFinder.via(this.a), null, 4, null)));
        return;
    L24:
        if (r14.intValue() != 12) goto L26;
        r2 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b7365.c2695.d3104", Boolean.TRUE).withView(r9).build());
    L20:
        r14 = null;
        goto L21
    L31:
        return;
    L30:
        return;
    L28:
        return;
    L7:
        r4 = null;
        goto L8
    }
}
