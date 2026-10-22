package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ ResourceCardView a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ yd3.p c;
    public final /* synthetic */ rd3.a d;

    public i(ResourceCardView r1, Ref.ObjectRef r2, yd3.p r3, rd3.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        yd3.f r13 = this.c.h();
        if (r13 == null) goto L7;
        yd3.g r14 = r13.c();
        if (r14 == null) goto L7;
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.getContext(), r14.c());
    L7:
        rd3.a r3 = this.d;
        if (r3 == null) goto L10;
        FeedProductEventTracker.m(FeedProductEventTracker.a, r3, "button", null, null, null, null, null, 124);
    L10:
        ResourceCardView r15 = this.a;
        CouponNodeView r0 = (CouponNodeView) this.b.element;
        int r1 = ResourceCardView.f;
        r15.getClass();
        if ((r0 instanceof CouponNodeViewStyle4) == true) goto L13;
        r0 = null;
    L13:
        CouponNodeViewStyle4 r2 = (CouponNodeViewStyle4) r0;
        if (r2 == null) goto L17;
        r2.b();
        return;
    }
}
