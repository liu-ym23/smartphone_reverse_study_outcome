package com.bytedance.android.shopping.searchsimilar.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.searchsimilar.model.DislikeType;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.bytedance.common.utility.UIUtils;
import gh3.g;
import gh3.h;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ DislikeType b;
    public final /* synthetic */ int c;
    public final /* synthetic */ SimilarProductFeedbackView d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ rd3.a f;
    public final /* synthetic */ SimilarProductVM g;

    public c(View r1, DislikeType r2, int r3, SimilarProductFeedbackView r4, Function0 r5, rd3.a r6, SimilarProductVM r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        int r1 = 0;
        this.d.b(false, this.a);
        UIUtils.displayToast(this.a.getContext(), this.b.getToastContent());
        Function0 r7 = this.e;
        if (r7 == null) goto L5;
        Unit r8 = (Unit) r7.invoke();
    L5:
        HashSet r9 = l63.a.a;
        rd3.a r10 = this.f;
        if (r10 == null) goto L11;
        Promotion r11 = r10.f();
        if (r11 == null) goto L11;
        String r12 = r11.getId();
        if (r12 == null) goto L11;
    L12:
        DislikeType r0 = (DislikeType) CollectionsKt.getOrNull(this.g.getFeedbackList(), this.c);
        if (r0 == null) goto L17;
        Integer r2 = r0.getType();
        if (r2 == null) goto L17;
        r1 = r2.intValue();
    L17:
        l63.a.c(r12, r1);
        int r13 = g.a;
        Context r14 = this.a.getContext();
        SimilarProductVM r3 = this.g;
        rd3.a r4 = this.f;
        String r5 = this.b.getName();
        gh3.a r15 = new gh3.a();
        r15.d = r5;
        String r16 = null;
        if (r3 == null) goto L20;
        String r17 = r3.getProductFrameId();
    L21:
        r15.a = r17;
        if (r3 == null) goto L24;
        Integer r18 = Integer.valueOf(r3.getFrameRank());
    L25:
        r15.b = String.valueOf(r18);
        if (r4 == null) goto L34;
        Promotion r19 = r4.f();
        if (r19 == null) goto L34;
        PromotionProductStruct r20 = r19.getPromotionInfo();
        if (r20 == null) goto L34;
        PromotionProductBaseStruct r21 = r20.getBaseInfo();
        if (r21 == null) goto L34;
        String r22 = r21.getProductId();
    L35:
        r15.c = r22;
        if (r4 == null) goto L40;
        rd3.g r23 = r4.d();
        if (r23 == null) goto L40;
        String r24 = r23.a();
    L41:
        r15.e = r24;
        if (r3 == null) goto L44;
        String r25 = r3.getRequestId();
    L45:
        r15.f = r25;
        if (r4 == null) goto L54;
        Promotion r26 = r4.f();
        if (r26 == null) goto L54;
        PromotionProductStruct r27 = r26.getPromotionInfo();
        if (r27 == null) goto L54;
        PromotionProductExtraStruct r28 = r27.getExtraInfo();
        if (r28 == null) goto L54;
        r16 = r28.getSimilarProductType();
    L54:
        r15.g = r16;
        h.a(r15, r14);
        return;
    L44:
        r25 = null;
    L40:
        r24 = null;
    L34:
        r22 = null;
        goto L35
    L24:
        r18 = null;
        goto L25
    L20:
        r17 = null;
    L11:
        r12 = "";
        goto L12
    }
}
