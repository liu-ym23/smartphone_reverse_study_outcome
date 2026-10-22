package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j {
    public final String a;
    public final List<PromotionBenefitLabel> b;
    public final int c;
    public final int d;
    public final String e;
    public final Long f;
    public final Boolean g;
    public final SkuParams h;
    public final IOrderSchema i;
    public final nl.f j;

    public final Map<String, Object> a() {
        Pair[] r1 = new Pair[1];
        Pair[] r3 = new Pair[3];
        Pair[] r5 = new Pair[5];
        String r6 = String.valueOf(this.h.getActionType());
        if (r6 == null) goto L36;
        r5[0] = TuplesKt.to("action_type", r6);
        String r7 = String.valueOf(this.h.getSceneType());
        if (r7 == null) goto L34;
        r5[1] = TuplesKt.to("scene_type", r7);
        List r8 = this.h.getBenefitLabels();
        String r9 = null;
        if ((r8 instanceof List) == true) goto L9;
        r8 = null;
    L9:
        r5[2] = TuplesKt.to("coupon_tags", r8);
        r5[3] = TuplesKt.to("live_product_raw_data", this.a);
        if (BuyNowPerformanceOpt.a() == false) goto L12;
        String r10 = null;
    L13:
        r5[4] = TuplesKt.to("detail_url", r10);
        r3[0] = TuplesKt.to("biz_context", MapsKt.mapOf(r5));
        Pair[] r11 = new Pair[8];
        r11[0] = TuplesKt.to("default_spec_id", this.e.toString());
        r11[1] = TuplesKt.to("default_count", this.f);
        r11[2] = TuplesKt.to("disable_server_specs_default_select", this.g);
        Integer r12 = this.h.getSpecMode();
        if ((r12 instanceof Integer) == true) goto L16;
        r12 = null;
    L16:
        r11[3] = TuplesKt.to("spec_mode", r12);
        Long r2 = this.h.getSpecModeTime();
        if (r2 == null) goto L19;
        String r4 = String.valueOf(r2.longValue());
    L21:
        if ((r4 instanceof String) == true) goto L23;
        r4 = null;
    L23:
        r11[4] = TuplesKt.to("spec_mode_time", r4);
        r11[5] = TuplesKt.to("panel_width", Integer.valueOf(b.b(false)));
        r11[6] = TuplesKt.to("panel_height", Integer.valueOf(b.a()));
        if (BuyNowPerformanceOpt.a() == false) goto L26;
        Boolean r13 = Boolean.valueOf(a2.b(this.h.getDetailUrl()));
    L27:
        r11[7] = TuplesKt.to("show_detail_entrance", r13);
        r3[1] = TuplesKt.to("client_params", MapsKt.mapOf(r11));
        String r0 = this.h.getEnterFrom();
        if ((r0 instanceof String) == false) goto L31;
        r9 = r0;
    L31:
        r3[2] = TuplesKt.to("chain_info", MapsKt.mapOf(TuplesKt.to(SimilarProductParam.ENTER_FROM, r9)));
        r1[0] = TuplesKt.to("sku_schema_param", MapsKt.mutableMapOf(r3));
        Map<String, Object> r14 = MapsKt.mutableMapOf(r1);
        r14.putAll(MapsKt.emptyMap());
        return r14;
    L26:
        r13 = null;
        goto L27
    L19:
        r4 = null;
        goto L21
    L12:
        r10 = this.h.getDetailUrl();
        goto L13
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public j(IOrderSchema r115, nl.f r116) {
        Intrinsics.checkNotNullParameter(r115, "orderParams");
        Intrinsics.checkNotNullParameter(r116, "ultimateBuySkuParamForSingle");
        this.i = r115;
        this.j = r116;
        this.a = r116.a;
        List r1 = r116.f;
        ArrayList r2 = null;
        if (r1 == null) goto L18;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L6:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        Map r6 = ((PromotionBenefitLabel) r5).getExtra();
        if (r6 == null) goto L10;
        String r7 = (String) r6.get("pass_through");
    L12:
        if (Intrinsics.areEqual(r7, "1") == false) goto L6;
        r3.add(r5);
        goto L6
    L10:
        r7 = null;
        goto L12
    L14:
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r8 = r3.iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        r2.add(((PromotionBenefitLabel) r8.next()).createClone());
    L18:
        this.b = r2;
        this.c = 1;
        nl.f r9 = this.j;
        int r10 = r9.c;
        this.d = r10;
        String r15 = r9.b;
        String r14 = r9.i;
        String r13 = r9.g;
        String r12 = r9.h;
        this.e = u0.d(r9.d);
        nl.f r11 = this.j;
        this.f = r11.e;
        this.g = r11.j;
        Float r16 = r11.k;
        String r17 = this.i.getQueryParam("height_percent");
        if (r17 == null) goto L23;
        Integer r18 = StringsKt.toIntOrNull(r17);
        if (r18 == null) goto L23;
        int r19 = r18.intValue();
    L24:
        String r24 = this.i.getQueryParam("id");
        if (r16 == null) goto L27;
        float r63 = r16.floatValue();
    L28:
        this.h = new SkuParams(null, null, null, null, null, 0, null, null, null, false, false, null, null, false, r24, r15, null, false, null, null, null, null, null, null, null, false, 1, r10, null, null, 0, r13, r2, null, null, null, null, r12, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, null, Integer.valueOf(r19), null, null, r63, null, null, null, null, null, null, null, null, null, null, null, null, 0, "UltimateBuySkuParamForSingle.generateSkuParams", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, false, null, null, r14, null, null, null, null, null, 1946107903, -75497506, 2147483391, 31, null);
        return;
    L27:
        r63 = 0.5f;
    L23:
        r19 = 73;
        goto L24
    }
}
