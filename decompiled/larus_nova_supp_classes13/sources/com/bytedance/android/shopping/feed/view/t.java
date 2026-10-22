package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.resourcecard.model.SearchItem;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ SearchItem a;
    public final /* synthetic */ SearchCardView b;
    public final /* synthetic */ rd3.a c;

    public t(SearchItem r1, SearchCardView r2, rd3.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        JsonObject r8 = new JsonObject();
        rd3.a r0 = this.c;
        String r1 = "";
        if (r0 == null) goto L10;
        ProductFeedViewModel r2 = r0.c;
        if (r2 == null) goto L10;
        AnchorV3Param r3 = r2.m907getAnchorV3Param();
        if (r3 == null) goto L10;
        String r4 = r3.getVideoId();
        if (r4 == null) goto L10;
    L11:
        r8.addProperty("group_id", r4);
        rd3.a r5 = this.c;
        String r6 = null;
        if (r5 == null) goto L14;
        String r9 = r5.h;
    L15:
        r8.addProperty(PdpOpenThirdParam.KEY_PRODUCT_ID, r9);
        rd3.a r10 = this.c;
        if (r10 == null) goto L19;
        String r11 = r10.d;
        if (r11 == null) goto L19;
    L20:
        r8.addProperty("request_id", r11);
        rd3.a r12 = this.c;
        if (r12 == null) goto L32;
        ProductFeedViewModel r13 = r12.c;
        if (r13 == null) goto L32;
        AnchorV3Param r14 = r13.m907getAnchorV3Param();
        if (r14 == null) goto L32;
        ECLogExtraData r15 = r14.getLogExtraData();
        if (r15 == null) goto L32;
        String r16 = r15.getEnterFrom();
        if (r16 == null) goto L32;
        r1 = r16;
    L32:
        r8.addProperty("chnid", r1);
        ECUrlModel r17 = this.a.getJumpUrl();
        if (r17 == null) goto L35;
        r6 = r17.getUri();
    L35:
        Uri r18 = l0.c(UriProtector.parse(r6), "search_passthrough_params", r8.toString());
        String r19 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "c295463.d0", PageFinder.via(this.b), null, 4, null);
        com.bytedance.android.ec.sdk.helper.p r20 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r21 = this.b.getContext();
        int r22 = md3.a.a;
        r20.openSchema(r21, md3.a.a(r18.toString(), r19));
        FeedProductEventTracker r23 = FeedProductEventTracker.a;
        Context r24 = this.b.getContext();
        rd3.a r25 = this.c;
        SearchItem r26 = this.a;
        r23.getClass();
        FeedProductEventTracker.z(r24, r25, r26);
        return;
    L19:
        r11 = "";
        goto L20
    L14:
        r9 = null;
    L10:
        r4 = "";
        goto L11
    }
}
