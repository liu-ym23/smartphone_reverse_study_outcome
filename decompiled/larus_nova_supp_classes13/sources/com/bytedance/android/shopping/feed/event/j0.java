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
public final class j0<V> implements Callable {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ List c;
    public final /* synthetic */ String d;
    public final /* synthetic */ rd3.a e;
    public final /* synthetic */ SearchItem f;

    public j0(Integer r1, Context r2, rd3.a r3, SearchItem r4) {
        this.a = r1;
        this.b = r2;
        this.c = null;
        this.d = "trending_words_show";
        this.e = r3;
        this.f = r4;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.android.ec.core.event.a call() {
        b1 r0 = new b1(this.d);
        rd3.a r1 = this.e;
        Long r2 = null;
        if (r1 == null) goto L11;
        yd3.p r3 = r1.i();
        if (r3 == null) goto L11;
        yd3.q r4 = r3.o();
        if (r4 == null) goto L11;
        ArrayList<SearchItem> r5 = r4.c();
        if (r5 == null) goto L11;
        Integer r6 = Integer.valueOf(r5.indexOf(this.f));
    L12:
        r0.a = r6;
        r0.b = this.f.getKeyword();
        rd3.a r7 = this.e;
        if (r7 == null) goto L23;
        ProductFeedViewModel r8 = r7.c;
        if (r8 == null) goto L23;
        InnerFlowPageStyleDTO r9 = r8.getInnerFlowPageStyle();
        if (r9 == null) goto L23;
        PageStyle r10 = r9.getPageStyle();
        if (r10 == null) goto L23;
        if (r10.searchCardWithPicture() != true) goto L23;
        String r11 = "inflow_search_product_trending";
    L24:
        r0.d = r11;
        rd3.a r12 = this.e;
        if (r12 == null) goto L27;
        String r13 = r12.j;
    L28:
        r0.c = r13;
        String r14 = this.f.getQueryId();
        if (r14 != null) goto L31;
        r14 = "";
    L31:
        r0.e = r14;
        StringBuilder r15 = new StringBuilder("product_flow_page_");
        rd3.a r16 = this.e;
        if (r16 == null) goto L40;
        ProductFeedViewModel r17 = r16.c;
        if (r17 == null) goto L40;
        AnchorV3Param r18 = r17.m907getAnchorV3Param();
        if (r18 == null) goto L40;
        AnchorV3PromotionRequestParam r19 = r18.getRequestParam();
        if (r19 == null) goto L40;
        String r20 = r19.getSourcePage();
    L41:
        r15.append(r20);
        r0.f = r15.toString();
        rd3.a r21 = this.e;
        if (r21 == null) goto L44;
        String r22 = r21.h;
    L45:
        r0.g = r22;
        if (r21 == null) goto L48;
        String r23 = r21.i;
    L49:
        r0.h = r23;
        SearchItem r24 = this.f;
        if (r24 == null) goto L52;
        r2 = r24.getProductId();
    L52:
        r0.i = String.valueOf(r2);
        Integer r25 = this.a;
        if (r25 != null) goto L56;
    L58:
        if (r25 != null) goto L61;
    L63:
        r0.buildLogParams();
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r0.appendParam("ec_product_feed_async_ab", "1", com.bytedance.android.ec.core.event.a.b.a.a);
        return r0;
    L61:
        if (r25.intValue() != 0) goto L63;
        g.b(r0, this.b);
        goto L63
    L56:
        if (r25.intValue() != 2) goto L58;
        g.a(r0, this.b, this.c);
        goto L63
    L48:
        r23 = null;
        goto L49
    L44:
        r22 = null;
    L40:
        r20 = null;
        goto L41
    L27:
        r13 = null;
    L23:
        r11 = "inflow_search_product_trending_tag";
    L11:
        r6 = null;
        goto L12
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
