package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public static final String b(ECShopHybridProductViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        String r0 = r2.getEcomEntranceFrom();
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (Intrinsics.areEqual(r2.getStoreParam().getPageName(), "classification_secondary_page") == false) goto L11;
        return "classification";
    L11:
        if (r2.getStoreParam().getProductBasicRequestParam().isCustom() == false) goto L13;
        return "featured";
    L13:
        return "products";
    }

    public static final String a(ECShopHybridProductViewModel r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "sourceMethod");
        com.bytedance.commerce.base.json.a[] r0 = new com.bytedance.commerce.base.json.a[10];
        r0[0] = JsonDslUtilKt.d("carrier_source", "store_page");
        r0[1] = JsonDslUtilKt.d("store_type", "shop");
        r0[2] = JsonDslUtilKt.d("source_method", r5);
        r0[3] = JsonDslUtilKt.d("source_method_second", CommentServiceId.HOT_SPOT);
        LayoutTypes r6 = (LayoutTypes) r4.getLayoutType().getValue();
        if (r6 != null) goto L6;
    L7:
        String r7 = "double_product";
    L9:
        r0[4] = JsonDslUtilKt.d("product_form", r7);
        if (r4.hasDiscountSelected() == false) goto L12;
        String r8 = CommentScene.COMMENTSCENE_NO_AWEME;
    L13:
        r0[5] = JsonDslUtilKt.d("is_discount_selected", r8);
        if (Intrinsics.areEqual(r4.getStoreParam().getShareContent(), "shop") == false) goto L16;
        String r9 = "share_alert";
    L17:
        r0[6] = JsonDslUtilKt.d("product_source_page", r9);
        String r10 = r4.getStoreParam().getStoreSourcePage();
        String r1 = "";
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        r0[7] = JsonDslUtilKt.d("store_source_page", r10);
        String r11 = r4.getStoreParam().getStoreSourceMethod();
        if (r11 != null) goto L23;
        r11 = "";
    L23:
        r0[8] = JsonDslUtilKt.d("store_source_method", r11);
        String r12 = r4.getStoreParam().getStoreGroupType();
        if (r12 == null) goto L27;
        r1 = r12;
    L27:
        r0[9] = JsonDslUtilKt.d("store_group_type", r1);
        return JsonDslUtilKt.a(r0).toString();
    L16:
        r9 = r4.getStoreParam().getEntranceLocation();
        goto L17
    L12:
        r8 = "0";
        goto L13
    L6:
        if (r.a[r6.ordinal()] != 1) goto L7;
        r7 = "single_product";
        goto L9
    }
}
