package com.bytedance.android.shopping.sku.inner.repo.composer;

import android.content.res.Resources;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.d;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.sku.common.utils.c;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSelfSaveBizFieldsCacheController;
import com.bytedance.android.shopping.sku.params.schema.SkuBizContext;
import com.bytedance.android.shopping.sku.params.schema.SkuClientParams;
import com.bytedance.android.shopping.sku.params.schema.SkuProductInfo;
import com.bytedance.android.shopping.sku.params.schema.SkuSchemaParams;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final SkuSchemaParams a;
    public final SkuParams b;

    public b(SkuSchemaParams r7, SkuParams r8) {
        Intrinsics.checkNotNullParameter(r7, "skuSchemaParams");
        Intrinsics.checkNotNullParameter(r8, "skuParams");
        this.a = r7;
        this.b = r8;
        SkuProductInfo r0 = r7.getProductInfo();
        DefaultSelect r1 = r8.getDefaultSelect();
        SkuPoiInfo r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getSkuId();
    L7:
        if ((r3 instanceof String) == true) goto L9;
        r3 = null;
    L9:
        if (r3 == null) goto L11;
        r0.appendOrReplaceParams("hot_sale_sku_id", r3);
    L11:
        SkuBizContext r4 = r7.getBizContext();
        DefaultSelect r5 = r8.getDefaultSelect();
        if (r5 == null) goto L14;
        String r6 = r5.getLastSelectedSkuId();
    L15:
        r4.appendOrReplaceParams("sku_id", r6);
        DefaultSelect r9 = r8.getDefaultSelect();
        if (r9 == null) goto L18;
        Integer r10 = r9.getType();
    L19:
        r4.appendOrReplaceParams("hot_sale_type", r10);
        r4.appendOrReplaceParams("auto_apply_coupon", Boolean.FALSE);
        SkuClientParams r11 = r7.getClientParams();
        int r12 = 0;
        if (r8.isSplitScreen() == false) goto L29;
        int r13 = c.a;
        float r14 = c.a(ECAppInfoService.e.getCurrentActivity()).a * 375.0f;
        d r15 = d.b;
        nj.d r16 = r15.getPadSplitService();
        if (r16 == null) goto L24;
        r16.getSpiltWidth();
        float r17 = 0;
    L25:
        float r18 = r14 / r17;
        nj.d r19 = r15.getPadSplitService();
        if (r19 == null) goto L28;
        r19.getSpiltWidth();
        com.bytedance.android.ecom.arch.slice.render.context.b.f.getClass();
        Object r20 = Float.valueOf(SlcDimensExtensionsKt.d(0, com.bytedance.android.ecom.arch.slice.render.context.b.a.d(r18, 1.0f, 1.0f)));
    L37:
        r11.appendOrReplaceParams("panel_width", r20);
        int r21 = c.a;
        Integer r22 = Integer.valueOf(c.a(ECAppInfoService.e.getCurrentActivity()).b);
        Resources r23 = Resources.getSystem();
        float r24 = WindowDisplayMetricsOverride.apply(r23, r23.getDisplayMetrics()).density;
        if (r24 == 0.0f) goto L40;
        r12 = (int) (r22.floatValue() / r24);
    L40:
        r11.appendOrReplaceParams("panel_height", Integer.valueOf(r12));
        SkuYataSelfSaveBizFieldsCacheController.a r25 = SkuYataSelfSaveBizFieldsCacheController.a;
        Map r26 = SkuYataSelfSaveBizFieldsCacheController.a(r8.getPromotionId());
        if (r26 != null) goto L44;
        r26 = null;
    L44:
        r11.appendOrReplaceParams("sku_last_biz_fields", k.d(r26));
        Integer r27 = r8.getSpecMode();
        if ((r27 instanceof Integer) == true) goto L47;
        r27 = null;
    L47:
        r11.appendOrReplaceParams("spec_mode", r27);
        Long r28 = r8.getSpecModeTime();
        if (r28 == null) goto L50;
        String r29 = String.valueOf(r28.longValue());
    L52:
        if ((r29 instanceof String) == true) goto L54;
        r29 = null;
    L54:
        r11.appendOrReplaceParams("spec_mode_time", r29);
        SkuPoiInfo r30 = r8.getPoiInfo();
        if ((r30 instanceof SkuPoiInfo) == false) goto L58;
        r2 = r30;
    L58:
        r11.appendOrReplaceParams("poi_info", r2);
        r11.appendOrReplaceParams("is_split_screen", Boolean.valueOf(r8.isSplitScreen()));
        r11.appendOrReplaceParams("is_split_screen_open", Boolean.valueOf(r8.isSplitScreenOpen()));
        return;
    L50:
        r29 = null;
        goto L52
    L28:
        r20 = null;
        goto L37
    L24:
        r17 = 360.0f;
        goto L25
    L29:
        ECSettingKeys.j.getClass();
        if (ECSettingKeys.V() == false) goto L32;
        int r31 = 390;
    L36:
        r20 = Integer.valueOf(r31);
        goto L37
    L32:
        int r32 = c.a;
        Integer r33 = Integer.valueOf(c.a(ECAppInfoService.e.getCurrentActivity()).a);
        Resources r34 = Resources.getSystem();
        float r35 = WindowDisplayMetricsOverride.apply(r34, r34.getDisplayMetrics()).density;
        if (r35 == 0.0f) goto L35;
        r31 = (int) (r33.floatValue() / r35);
        goto L36
    L35:
        r31 = 0;
        goto L36
    L18:
        r10 = null;
        goto L19
    L14:
        r6 = null;
        goto L15
    L5:
        r3 = null;
        goto L7
    }
}
