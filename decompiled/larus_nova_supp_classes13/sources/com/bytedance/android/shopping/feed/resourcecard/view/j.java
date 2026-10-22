package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.resourcecard.frequency.MallDivertShowJudge;
import com.bytedance.android.shopping.feed.resourcecard.frequency.ResourceCardFreqController;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ ResourceCardView a;
    public final /* synthetic */ yd3.p b;
    public final /* synthetic */ rd3.a c;
    public final /* synthetic */ String d;

    public j(ResourceCardView r1, yd3.p r2, rd3.a r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        String r1 = null;
        if (this.b.getType() != 7) goto L5;
        MallDivertShowJudge.h.getClass();
        MallDivertShowJudge.a.a().b();
    L10:
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        rd3.a r3 = this.c;
        Boolean r7 = Boolean.FALSE;
        Context r8 = this.a.getContext();
        String r9 = ResourceCardView.b(this.a, this.c, null);
        r0.getClass();
        FeedProductEventTracker.l(r3, BuyNowCloseMethod.OTHERS, null, null, r7, r8, r9);
        ResourceCardView r2 = this.a;
        rd3.a r4 = this.c;
        r2.getClass();
        yd3.p r5 = r4.i();
        if (r5 == null) goto L13;
        Integer r6 = Integer.valueOf(r5.getType());
    L14:
        if (r6 != null) goto L17;
    L19:
        if (r6 != null) goto L22;
    L24:
        if (r6 != null) goto L27;
    L30:
        String r10 = null;
    L31:
        if (r10 == null) goto L34;
        r1 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, r10, PageFinder.via(r2), null, 4, null);
    L34:
        com.bytedance.android.ec.sdk.helper.p r11 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r13 = r12.getContext();
        int r14 = md3.a.a;
        r11.openSchema(r13, md3.a.a(this.d, r1));
        return;
    L27:
        if (r6.intValue() != 12) goto L30;
        String r15 = "c870003.d993139";
    L29:
        r10 = r15;
        goto L31
    L22:
        if (r6.intValue() != 9) goto L24;
    L23:
        r15 = "c2695.d3104";
        goto L29
    L17:
        if (r6.intValue() != 7) goto L19;
    L13:
        r6 = null;
        goto L14
    L5:
        Lazy r16 = ResourceCardFreqController.a;
        yd3.d r17 = this.b.c();
        if (r17 == null) goto L8;
        Integer r18 = r17.b();
    L9:
        ResourceCardFreqController.d(r18);
        goto L10
    L8:
        r18 = null;
        goto L9
    }
}
