package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import com.bytedance.android.ec.core.widget.flow.TagFlowLayout;
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
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s implements TagFlowLayout.b {
    public final /* synthetic */ SearchCardHashTagView a;
    public final /* synthetic */ List b;
    public final /* synthetic */ rd3.a c;

    public final void a(int r6) {
        SearchItem r7 = (SearchItem) CollectionsKt.getOrNull(this.b, r6);
        JsonObject r0 = new JsonObject();
        rd3.a r1 = this.c;
        String r2 = "";
        if (r1 == null) goto L10;
        ProductFeedViewModel r3 = r1.c;
        if (r3 == null) goto L10;
        AnchorV3Param r4 = r3.m907getAnchorV3Param();
        if (r4 == null) goto L10;
        String r5 = r4.getVideoId();
        if (r5 == null) goto L10;
    L11:
        r0.addProperty("group_id", r5);
        rd3.a r8 = this.c;
        String r9 = null;
        if (r8 == null) goto L14;
        String r10 = r8.h;
    L15:
        r0.addProperty(PdpOpenThirdParam.KEY_PRODUCT_ID, r10);
        rd3.a r11 = this.c;
        if (r11 == null) goto L19;
        String r12 = r11.d;
        if (r12 == null) goto L19;
    L20:
        r0.addProperty("request_id", r12);
        rd3.a r13 = this.c;
        if (r13 == null) goto L32;
        ProductFeedViewModel r14 = r13.c;
        if (r14 == null) goto L32;
        AnchorV3Param r15 = r14.m907getAnchorV3Param();
        if (r15 == null) goto L32;
        ECLogExtraData r16 = r15.getLogExtraData();
        if (r16 == null) goto L32;
        String r17 = r16.getEnterFrom();
        if (r17 == null) goto L32;
        r2 = r17;
    L32:
        r0.addProperty("chnid", r2);
        if (r7 == null) goto L37;
        ECUrlModel r18 = r7.getJumpUrl();
        if (r18 == null) goto L37;
        r9 = r18.getUri();
    L37:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.a.getContext(), l0.c(UriProtector.parse(r9), "search_passthrough_params", r0.toString()).toString());
        if (r7 == null) goto L41;
        FeedProductEventTracker r19 = FeedProductEventTracker.a;
        Context r20 = this.a.getContext();
        rd3.a r21 = this.c;
        r19.getClass();
        FeedProductEventTracker.z(r20, r21, r7);
        return;
    L41:
        return;
    L19:
        r12 = "";
        goto L20
    L14:
        r10 = null;
    L10:
        r5 = "";
        goto L11
    }

    public s(SearchCardHashTagView r1, List r2, rd3.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
