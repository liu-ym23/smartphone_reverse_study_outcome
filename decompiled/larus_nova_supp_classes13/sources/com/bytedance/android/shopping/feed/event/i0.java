package com.bytedance.android.shopping.feed.event;

import android.content.Context;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.resourcecard.model.SearchItem;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ rd3.a d;

    public i0(Integer r1, Context r2, rd3.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = r3;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        a1 r0 = new a1();
        rd3.a r1 = this.d;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.j;
    L6:
        r0.b = r3;
        if (r1 == null) goto L15;
        yd3.p r4 = r1.i();
        if (r4 == null) goto L15;
        yd3.q r5 = r4.o();
        if (r5 == null) goto L15;
        ArrayList<SearchItem> r6 = r5.c();
        if (r6 == null) goto L15;
        Integer r7 = Integer.valueOf(r6.size());
    L16:
        r0.a = r7;
        rd3.a r8 = this.d;
        if (r8 == null) goto L27;
        ProductFeedViewModel r9 = r8.c;
        if (r9 == null) goto L27;
        InnerFlowPageStyleDTO r10 = r9.getInnerFlowPageStyle();
        if (r10 == null) goto L27;
        PageStyle r11 = r10.getPageStyle();
        if (r11 == null) goto L27;
        if (r11.searchCardWithPicture() != true) goto L27;
        String r12 = "inflow_search_product_trending";
    L28:
        r0.c = r12;
        StringBuilder r13 = new StringBuilder("product_flow_page_");
        rd3.a r14 = this.d;
        if (r14 == null) goto L37;
        ProductFeedViewModel r15 = r14.c;
        if (r15 == null) goto L37;
        AnchorV3Param r16 = r15.m907getAnchorV3Param();
        if (r16 == null) goto L37;
        AnchorV3PromotionRequestParam r17 = r16.getRequestParam();
        if (r17 == null) goto L37;
        String r18 = r17.getSourcePage();
    L38:
        r13.append(r18);
        r0.d = r13.toString();
        rd3.a r19 = this.d;
        if (r19 == null) goto L41;
        String r20 = r19.h;
    L42:
        r0.e = r20;
        if (r19 == null) goto L45;
        r2 = r19.i;
    L45:
        r0.f = r2;
        Integer r21 = this.a;
        if (r21 != null) goto L49;
    L51:
        if (r21 != null) goto L54;
    L56:
        r0.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r0;
    L54:
        if (r21.intValue() != 0) goto L56;
        g.b(r0, this.b);
        goto L56
    L49:
        if (r21.intValue() != 2) goto L51;
        g.a(r0, this.b, this.c);
        goto L56
    L41:
        r20 = null;
    L37:
        r18 = null;
    L27:
        r12 = "inflow_search_product_trending_tag";
    L15:
        r7 = null;
        goto L16
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
