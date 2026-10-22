package com.bytedance.android.shopping.feed.widget;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ ProductFeedDividerView a;

    public t(ProductFeedDividerView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = this.a.getAdapter().y;
        if (this.a.getAdapter().y != 0) goto L5;
        this.a.getAdapter().F2(this.a.getAdapter().w);
    L6:
        com.bytedance.android.shopping.feed.event.v r0 = new com.bytedance.android.shopping.feed.event.v();
        int r1 = ProductFeedDividerView.j;
        r0.f = ProductFeedDividerView.c.a(this.a.getAdapter().y);
        r0.e = ProductFeedDividerView.c.a(r5);
        ProductFeedViewModel r6 = this.a.g;
        if (r6 == null) goto L11;
        AnchorV3Param r7 = r6.m907getAnchorV3Param();
        if (r7 == null) goto L11;
        ECLogExtraData r8 = r7.getLogExtraData();
    L12:
        if (r8 == null) goto L14;
        String r2 = r8.getEnterFrom();
    L15:
        r0.a = r2;
        if (r8 == null) goto L18;
        String r9 = r8.getEComEntranceForm();
    L19:
        r0.b = r9;
        ProductFeedViewModel r10 = this.a.g;
        if (r10 == null) goto L24;
        AnchorV3Param r11 = r10.m907getAnchorV3Param();
        if (r11 == null) goto L24;
        String r12 = r11.getAuthorId();
    L25:
        r0.c = r12;
        ProductFeedViewModel r13 = this.a.g;
        if (r13 == null) goto L30;
        AnchorV3Param r14 = r13.m907getAnchorV3Param();
        if (r14 == null) goto L30;
        String r15 = r14.getVideoId();
    L31:
        r0.d = r15;
        r0.post(null, null);
        ProductFeedDividerView r16 = this.a;
        r16.f = true;
        r16.b();
        return;
    L30:
        r15 = null;
    L24:
        r12 = null;
        goto L25
    L18:
        r9 = null;
        goto L19
    L14:
        r2 = null;
    L11:
        r8 = null;
        goto L12
    L5:
        this.a.getAdapter().F2(0);
        goto L6
    }
}
