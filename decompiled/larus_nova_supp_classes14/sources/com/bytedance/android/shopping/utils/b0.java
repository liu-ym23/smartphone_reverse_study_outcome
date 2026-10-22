package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.model.sku.SkuSchemaCategory;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b0 {
    public static final String a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static final String f = null;
    public static final String g = null;
    public static final String h = null;

    static {
        StringBuilder r0 = new StringBuilder();
        SkuSchemaCategory r1 = SkuSchemaCategory.KEY_BIZ_CONTEXT;
        r0.append(r1.getValue());
        r0.append(".scene_type");
        a = r0.toString();
        b = r1.getValue() + ".sku_id";
        StringBuilder r2 = new StringBuilder();
        SkuSchemaCategory r3 = SkuSchemaCategory.KEY_CLIENT_PARAMS;
        r2.append(r3.getValue());
        r2.append(".height_percent");
        c = r2.toString();
        d = r3.getValue() + ".sku_session_id";
        e = r3.getValue() + ".mask_alpha";
        f = r3.getValue() + ".disable_server_specs_default_select";
        g = r3.getValue() + ".default_spec_id";
        h = r3.getValue() + ".default_count";
    }

    public static void a(ISkuBuySchemaModel r4, j73.d r5) {
        Intrinsics.checkNotNullParameter(r5, "anchorV4VM");
        if (r4 == null) goto L44;
        r4.replaceOrAppendParam("sku_session_id", UUID.randomUUID().toString());
        if ((!Intrinsics.areEqual(r4.getQueryParam("scene_type"), "105")) == true) goto L10;
        SkuRestoreState r0 = r5.P();
        if (r0 == null) goto L21;
        if (r0.allSelected() == true) goto L10;
    L21:
        if (r5.P() == null) goto L23;
        boolean r1 = true;
    L24:
        r4.replaceOrAppendParam("disable_server_specs_default_select", String.valueOf(r1));
        if (r5.isExpanded() == true) goto L34;
        AnchorV4Param r2 = r5.c();
        if (r2 == null) goto L33;
        V4NativeParams r3 = r2.getNativeParams();
        if (r3 == null) goto L33;
        if (r3.getFullMode() == true) goto L34;
    L33:
        float r6 = 0.0f;
    L35:
        r4.replaceOrAppendParam("mask_alpha", String.valueOf(r6));
        if (com.bytedance.android.shopping.anchorv4.helper.e.c(r5) == false) goto L39;
        r4.replaceOrAppendParam("height_percent", String.valueOf(r5.r()));
    L39:
        if (r5.isExpanded() == false) goto L41;
        String r7 = "full_screen";
    L42:
        r4.putValueInSkuLogData("page_type", r7);
        return;
    L41:
        r7 = "half_screen";
    L34:
        r6 = 0.5f;
        goto L35
    L23:
        r1 = false;
    L10:
        SkuRestoreState r8 = r5.P();
        if (r8 == null) goto L13;
        r4.replaceOrAppendParam("combo_num", String.valueOf(r8.getProductCount()));
    L13:
        SkuRestoreState r9 = r5.P();
        if (r9 == null) goto L21;
        String[] r10 = r9.getSelectSkuKeys();
        if (r10 == null) goto L21;
        String r11 = com.bytedance.android.shopping.extensions.k.x(r10);
        if (r11 == null) goto L21;
        r4.replaceOrAppendParam("default_spec_id", r11);
        goto L21
    }
}
