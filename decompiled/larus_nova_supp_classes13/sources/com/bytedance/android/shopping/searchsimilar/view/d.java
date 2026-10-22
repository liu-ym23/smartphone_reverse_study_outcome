package com.bytedance.android.shopping.searchsimilar.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.searchsimilar.adapter.SimilarProductFrameAdapter;
import com.bytedance.android.shopping.searchsimilar.model.ProductFrame;
import com.bytedance.android.shopping.searchsimilar.viewholder.SimilarProductFrameVH;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import gh3.g;
import gh3.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ SimilarProductFrameView a;
    public final /* synthetic */ ProductFrame b;
    public final /* synthetic */ int c;
    public final /* synthetic */ SimilarProductVM d;
    public final /* synthetic */ SimilarProductFrameVH.b e;

    public d(SimilarProductFrameView r1, ProductFrame r2, int r3, SimilarProductVM r4, SimilarProductFrameAdapter.b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        SimilarProductFrameView r9 = this.a;
        if (r9.e == false) goto L5;
        return;
    L5:
        int r0 = g.a;
        Context r10 = r9.getContext();
        ProductFrame r1 = this.b;
        if (r1 == null) goto L8;
        String r2 = r1.getId();
    L9:
        String r3 = String.valueOf(this.c + 1);
        SimilarProductVM r4 = this.d;
        Intrinsics.checkNotNullParameter("similar_product_click", "event");
        gh3.c r5 = new gh3.c("similar_product_click");
        r5.a = r2;
        r5.b = r3;
        if (r4 == null) goto L12;
        String r6 = r4.getRequestId();
    L13:
        r5.c = r6;
        h.a(r5, r10);
        this.e.a(this.c);
        SimilarProductVM r11 = this.d;
        ProductFrame r7 = this.b;
        if (r7 == null) goto L16;
        String r12 = r7.getId();
    L17:
        r11.setProductFrameId(r12);
        SimilarProductVM.resetRequestParams$default(this.d, null, 1, null);
        this.d.setFrameRank(this.c);
        this.d.clearSimilarProduct();
        this.d.loadSimilarProduct();
        return;
    L16:
        r12 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }
}
