package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends IECLynxCardLifeCycle.Base {
    public final /* synthetic */ f a;
    public final /* synthetic */ ProductFeedAdapter b;

    public final void onFirstScreen() {
        f r0 = this.a;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L6;
        r1.width = -1;
        r1.height = -2;
        r0.setLayoutParams(r1);
        return;
    }

    public final void onLoadSuccess() {
        dm.a.a("InFlowLynxView").i("onLoadSuccess");
        FeedProductEventTracker r0 = FeedProductEventTracker.a;
        f r1 = this.a;
        String r2 = r1.a;
        if (r2 != null) goto L5;
        String r4 = "";
    L6:
        rd3.a r3 = r1.b;
        if (r3 == null) goto L12;
        String r5 = r3.d;
        if (r5 == null) goto L12;
        String r6 = r5;
    L13:
        r0.getClass();
        FeedProductEventTracker.r(r4, "0", r6, "", "", "");
        if (this.b.F == false) goto L40;
        rd3.a r7 = this.a.b;
        if (r7 == null) goto L38;
        ProductFeedViewModel r8 = r7.c;
        if (r8 == null) goto L38;
        AnchorV3Param r9 = r8.m907getAnchorV3Param();
        if (r9 == null) goto L38;
        com.bytedance.android.ec.monitor.duration.i r10 = com.bytedance.android.ec.monitor.duration.i.a;
        com.bytedance.android.ec.monitor.duration.d r11 = r10.get(r9.getFullPageMonitorName());
        if (r11 == null) goto L24;
        r11.a("guess_u_like_render_end");
    L24:
        com.bytedance.android.ec.monitor.duration.d r12 = r10.get(r9.getFullPageMonitorName());
        if (r12 == null) goto L31;
        String r13 = this.a.a;
        if (r13 != null) goto L29;
        r13 = "lynx_default";
    L29:
        r12.b("guess_u_like_type", r13);
    L31:
        if (this.b.E == true) goto L38;
        com.bytedance.android.ec.monitor.duration.d r14 = r10.get(r9.getFullPageMonitorName());
        if (r14 == null) goto L35;
        r14.a("render_end");
    L35:
        com.bytedance.android.ec.monitor.duration.d r15 = r10.get(r9.getFullPageMonitorName());
        if (r15 == null) goto L38;
        r15.report();
    L38:
        this.b.F = false;
        return;
    L40:
        return;
    L12:
        r6 = "";
        goto L13
    L5:
        r4 = r2;
        goto L6
    }

    public g(f r1, ProductFeedAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onLoadFailed(ECLynxCardErrorType r11, Integer r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "type");
        dm.a.a("InFlowLynxView").b("onLoadFailed", null);
        f r0 = this.a;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L5;
        r1.width = 0;
        r1.height = 0;
        r0.setLayoutParams(r1);
    L5:
        FeedProductEventTracker r2 = FeedProductEventTracker.a;
        f r3 = this.a;
        String r4 = r3.a;
        if (r4 != null) goto L8;
        String r5 = "";
    L9:
        rd3.a r6 = r3.b;
        if (r6 == null) goto L15;
        String r7 = r6.d;
        if (r7 == null) goto L15;
        String r8 = r7;
    L16:
        if (r12 == null) goto L21;
        String r14 = String.valueOf(r12.intValue());
        if (r14 == null) goto L21;
        String r9 = r14;
    L22:
        if (r13 != null) goto L24;
        String r10 = "";
    L25:
        String r15 = r11.toString();
        r2.getClass();
        FeedProductEventTracker.r(r5, "1", r8, r9, r10, r15);
        if (this.b.F == false) goto L37;
        rd3.a r16 = this.a.b;
        if (r16 == null) goto L38;
        ProductFeedViewModel r17 = r16.c;
        if (r17 == null) goto L39;
        AnchorV3Param r18 = r17.m907getAnchorV3Param();
        if (r18 == null) goto L40;
        com.bytedance.android.ec.monitor.duration.d r19 = com.bytedance.android.ec.monitor.duration.i.a.get(r18.getFullPageMonitorName());
        if (r19 == null) goto L41;
        r19.b("lynx_card_fail", 1);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L24:
        r10 = r13;
    L21:
        r9 = "";
    L15:
        r8 = "";
        goto L16
    L8:
        r5 = r4;
        goto L9
    }
}
