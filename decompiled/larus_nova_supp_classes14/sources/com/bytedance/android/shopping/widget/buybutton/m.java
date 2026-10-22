package com.bytedance.android.shopping.widget.buybutton;

import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ClickButtonParam;
import com.bytedance.android.ec.model.SingleClickParam;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.shopping.utils.p;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements mf.b {
    public m() {
    }

    public final JSONObject a(Map r4, nl.e r5) {
        Intrinsics.checkNotNullParameter(r4, "schemaParams");
        Intrinsics.checkNotNullParameter(r5, "orderSchemaVo");
        ClickButtonParam r6 = r5.g;
        String r0 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        String r1 = r6.getEntranceInfo();
        if (r1 == null) goto L8;
        JSONObject r2 = new JSONObject(r1);
    L9:
        ClickButtonParam r7 = r5.g;
        if (r7 == null) goto L12;
        r0 = r7.getEnterFrom();
    L12:
        r2.put("source_3d", r0);
        r2.put("commodity_id", r6.getPromotionId());
        r2.put("commodity_type", r6.getPromotionSource());
        r2.put("product_id", r6.getProductId());
        return r2;
    L8:
        r2 = new JSONObject();
        goto L9
    }

    public final void b(Map r3, nl.e r4) {
        Intrinsics.checkNotNullParameter(r3, "schemaParams");
        Intrinsics.checkNotNullParameter(r4, "orderSchemaVo");
        Intrinsics.checkNotNullParameter(r3, "schemaParams");
        Intrinsics.checkNotNullParameter(r4, "orderSchemaVo");
    }

    public final String c(Map r2, nl.e r3) {
        Intrinsics.checkNotNullParameter(r2, "schemaParams");
        Intrinsics.checkNotNullParameter(r3, "orderSchemaVo");
        ClickButtonParam r4 = r3.g;
        if (r4 != null) goto L6;
        return null;
    L6:
        String r5 = r4.getMarketingChannel();
        if (r5 != null) goto L10;
        return "";
    L10:
        return r5;
    }

    public final JSONObject d(Map r6, nl.e r7) {
        Intrinsics.checkNotNullParameter(r6, "schemaParams");
        Intrinsics.checkNotNullParameter(r7, "orderSchemaVo");
        ClickButtonParam r8 = r7.g;
        String r0 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        SingleClickParam r9 = com.bytedance.android.ec.model.c.a(r8, r7.f);
        JSONObject r1 = new JSONObject();
        r1.put("coupon_id", r9.getApplyCouponIds());
        r1.put("with_sku", "0");
        String r10 = r8.getEntranceInfo();
        if (r10 == null) goto L8;
        r0 = z1.f(r10).optString("is_explain_apply", "0");
    L8:
        r1.put("is_explain_apply", r0);
        r1.put("author_id", r8.getAuthorId());
        r1.put("item_id", r8.getItemId());
        List r11 = r8.getDiscountLabels();
        StringBuilder r12 = new StringBuilder();
        if (r11 == null) goto L19;
        Iterator r13 = r11.iterator();
    L12:
        if (r13.hasNext() == false) goto L19;
        PromotionDiscountLabel r3 = (PromotionDiscountLabel) r13.next();
        if (r3.getType() != 1) goto L12;
        if (r3.getId() == null) goto L12;
        r12.append(Intrinsics.stringPlus(r3.getId(), ","));
    L19:
        if (r12.length() != 0) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L24;
        String r15 = r12.toString();
    L25:
        r1.put("coupon_id", r15);
        return r1;
    L24:
        r15 = r12.substring(0, r12.length() - 1);
        goto L25
    L21:
        r14 = false;
        goto L22
    }

    public final String e(Map r3, nl.e r4) {
        Intrinsics.checkNotNullParameter(r3, "schemaParams");
        Intrinsics.checkNotNullParameter(r4, "orderSchemaVo");
        Intrinsics.checkNotNullParameter(r3, "schemaParams");
        Intrinsics.checkNotNullParameter(r4, "orderSchemaVo");
        return null;
    }

    public final String f(Map r2, nl.e r3) {
        Intrinsics.checkNotNullParameter(r2, "schemaParams");
        Intrinsics.checkNotNullParameter(r3, "orderSchemaVo");
        ClickButtonParam r4 = r3.g;
        if (r4 == null) goto L7;
        String r5 = r4.getGroupId();
        if (r5 == null) goto L9;
        return r5;
    L9:
        return null;
    L7:
        return null;
    }

    public final void g(Map r3, nl.e r4) {
        Intrinsics.checkNotNullParameter(r3, "schemaParams");
        Intrinsics.checkNotNullParameter(r4, "orderSchemaVo");
        Intrinsics.checkNotNullParameter(r3, "schemaParams");
        Intrinsics.checkNotNullParameter(r4, "orderSchemaVo");
    }

    public final JSONObject h(Map r3, nl.e r4) {
        Intrinsics.checkNotNullParameter(r3, "schemaParams");
        Intrinsics.checkNotNullParameter(r4, "orderSchemaVo");
        JSONObject r5 = new JSONObject();
        if (BuyNowPerformanceOpt.j() == true) goto L5;
        r5.put("biometric_params", CommentScene.COMMENTSCENE_NO_AWEME);
        r5.put("is_jailbreak", "2");
        r5.put("cj_sdk", p.b());
        r5.put("bio_type", CommentScene.COMMENTSCENE_NO_AWEME);
    L5:
        return r5;
    }

    public final void i(Map r3, nl.e r4) {
        Intrinsics.checkNotNullParameter(r3, "schemaParams");
        Intrinsics.checkNotNullParameter(r4, "orderSchemaVo");
        Intrinsics.checkNotNullParameter(r3, "schemaParams");
        Intrinsics.checkNotNullParameter(r4, "orderSchemaVo");
    }
}
