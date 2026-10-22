package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.repository.api.AnchorV3Api;
import com.bytedance.android.shopping.feed.utils.ProductFeedActionHelper;
import com.bytedance.android.shopping.feed.utils.b0;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductFeedAbilityBarView$bindCollectAbilityView$1 extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ ProductFeedAbilityBarView g;
    public final /* synthetic */ PromotionProductStruct h;

    public final void a(View r22) {
        Intrinsics.checkNotNullParameter(r22, "v");
        rd3.a r2 = this.g.e;
        Function1<Boolean, Unit> r3 = new ProductFeedAbilityBarView$bindCollectAbilityView$1$doClick$1(this);
        int r4 = ProductFeedActionHelper.a;
        Intrinsics.checkNotNullParameter(r22, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "successCB");
        String r5 = null;
        if (r2 == null) goto L5;
        ProductFeedViewModel r6 = r2.c;
    L6:
        if (r2 == null) goto L10;
        Promotion r7 = r2.f();
        if (r7 == null) goto L10;
        PromotionProductStruct r8 = r7.getPromotionInfo();
    L11:
        boolean r9 = false;
        if (r2 != null) goto L14;
    L16:
        boolean r10 = false;
    L17:
        if (r8 == null) goto L24;
        PromotionProductExtraStruct r11 = r8.getExtraInfo();
        if (r11 == null) goto L24;
        Boolean r12 = r11.getFavorited();
        if (r12 == null) goto L24;
        r9 = r12.booleanValue();
    L24:
        if (z53.b.a(r22.getId(), 800) == true) goto L92;
        AnchorV3Api.a r13 = AnchorV3Api.a;
        String r14 = "";
        if (r6 == null) goto L33;
        AnchorV3Param r15 = r6.m907getAnchorV3Param();
        if (r15 == null) goto L33;
        String r16 = r15.getVideoId();
        if (r16 == null) goto L33;
        String r17 = r16;
    L34:
        if (r10 == true) goto L43;
        if (r6 == null) goto L43;
        AnchorV3Param r18 = r6.m907getAnchorV3Param();
        if (r18 == null) goto L43;
        String r19 = r18.getAuthorId();
        if (r19 == null) goto L43;
        String r110 = r19;
    L44:
        if (r10 == true) goto L53;
        if (r6 == null) goto L53;
        AnchorV3Param r111 = r6.m907getAnchorV3Param();
        if (r111 == null) goto L53;
        String r112 = r111.getSecAuthorId();
        if (r112 == null) goto L53;
        String r113 = r112;
    L54:
        if (r9 == false) goto L56;
        int r114 = 2;
    L57:
        if (r6 == null) goto L63;
        AnchorV3Param r115 = r6.m907getAnchorV3Param();
        if (r115 == null) goto L63;
        AnchorV3PromotionRequestParam r116 = r115.getRequestParam();
        if (r116 == null) goto L63;
        String r117 = r116.getMetaParam();
    L65:
        if (r10 == false) goto L72;
        if (r8 == null) goto L79;
        PromotionProductBaseStruct r20 = r8.getBaseInfo();
        if (r20 == null) goto L79;
        String r21 = r20.getProductId();
        if (r21 == null) goto L79;
    L78:
        r14 = r21;
    L79:
        String r118 = r14;
        if (r8 == null) goto L84;
        PromotionProductBaseStruct r23 = r8.getBaseInfo();
        if (r23 == null) goto L84;
        r5 = r23.getProductId();
    L84:
        r13.getClass();
        AnchorV3Api.a.a(r17, r110, r113, r114, r117, 1, r118, r5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b0(r3, r9, r22));
        if (r6 == null) goto L93;
        FeedProductEventTracker r24 = FeedProductEventTracker.a;
        if (r9 == false) goto L89;
        String r25 = "cancel_wish_button";
    L90:
        Context r1 = r22.getContext();
        r24.getClass();
        FeedProductEventTracker.T(r25, r1, r2);
        return;
    L89:
        r25 = "click_wish_button";
        goto L90
    L93:
        return;
    L72:
        if (r8 == null) goto L79;
        PromotionProductBaseStruct r26 = r8.getBaseInfo();
        if (r26 == null) goto L79;
        r21 = r26.getPromotionId();
        if (r21 != null) goto L78;
    L63:
        r117 = null;
        goto L65
    L56:
        r114 = 1;
    L53:
        r113 = "";
    L43:
        r110 = "";
    L33:
        r17 = "";
        goto L34
    L92:
        return;
    L14:
        if (r2.e != true) goto L16;
        r10 = true;
    L10:
        r8 = null;
        goto L11
    L5:
        r6 = null;
        goto L6
    }

    public ProductFeedAbilityBarView$bindCollectAbilityView$1(ProductFeedAbilityBarView r1, PromotionProductStruct r2) {
        this.g = r1;
        this.h = r2;
        super(null, null, 3);
    }
}
