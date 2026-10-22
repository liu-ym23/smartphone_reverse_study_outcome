package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.e0;
import com.bytedance.android.shopping.feed.event.q0;
import com.bytedance.android.shopping.feed.event.r0;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ InnerFeedPageRightWidget a;

    public p(InnerFeedPageRightWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        yd3.p r0 = this.a.getMallResourceCard();
        String r1 = null;
        if (r0 == null) goto L13;
        String r2 = r0.n();
        if (r2 == null) goto L13;
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.getContext(), l0.c(UriProtector.parse(r2), "url", l0.c(UriProtector.parse(UriProtector.getQueryParameter(UriProtector.parse(r2), "url")), SimilarProductParam.ENTER_FROM, "product_flow_page_inflow_float").toString()).toString());     // Catch: Exception -> L8
    L8:
        com.bytedance.android.ec.sdk.helper.p r7 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r3 = this.a.getContext();
        yd3.p r4 = this.a.getMallResourceCard();
        if (r4 == null) goto L11;
        String r5 = r4.n();
    L12:
        r7.openSchema(r3, r5);
        goto L13
    L11:
        r5 = null;
    L13:
        FeedProductEventTracker r8 = FeedProductEventTracker.a;
        Context r9 = this.a.getContext();
        ProductFeedViewModel r10 = this.a.f;
        if (r10 == null) goto L20;
        AnchorV3Param r11 = r10.m907getAnchorV3Param();
        if (r11 == null) goto L20;
        ECLogExtraData r12 = r11.getLogExtraData();
        if (r12 == null) goto L20;
        r1 = r12.getEnterFrom();
    L20:
        String r13 = String.valueOf(r1);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r13, "enterFrom");
        Single.fromCallable(new e0(2, r9, r13)).subscribeOn(Schedulers.computation()).observeOn(Schedulers.io()).subscribe(q0.a, r0.a);
    }
}
