package com.bytedance.android.shopping.store.hybridproduct.presenter;

import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u {
    public static final String a(String r3, String r4, String r5, String r6, String r7, String r8, boolean r9, boolean r10, String r11, String r12) {
        com.bytedance.commerce.base.json.a[] r0 = new com.bytedance.commerce.base.json.a[9];
        String r1 = "";
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0[0] = JsonDslUtilKt.d("store_source_page", r3);
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r0[1] = JsonDslUtilKt.d("store_source_method", r4);
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r0[2] = JsonDslUtilKt.d("store_group_type", r5);
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        r0[3] = JsonDslUtilKt.d("enter_from", r6);
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        r0[4] = JsonDslUtilKt.d("temp_id", r7);
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        r0[5] = JsonDslUtilKt.d("customer_id", r8);
        if (r9 == false) goto L23;
        String r13 = "single_product";
    L24:
        r0[6] = JsonDslUtilKt.d("product_form", r13);
        if (r10 == false) goto L27;
        String r14 = CommentScene.COMMENTSCENE_NO_AWEME;
    L28:
        r0[7] = JsonDslUtilKt.d("is_discount_selected", r14);
        if (Intrinsics.areEqual(r11, "shop") == false) goto L31;
        r12 = "share_alert";
    L31:
        if (r12 == null) goto L34;
        r1 = r12;
    L34:
        r0[8] = JsonDslUtilKt.d("product_source_page", r1);
        return JsonDslUtilKt.a(r0).toString();
    L27:
        r14 = "0";
        goto L28
    L23:
        r13 = "double_product";
        goto L24
    }
}
