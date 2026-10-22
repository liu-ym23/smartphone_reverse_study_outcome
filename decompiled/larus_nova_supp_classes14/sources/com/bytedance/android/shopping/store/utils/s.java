package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s {
    public static final Set<String> a = null;

    public s() {
    }

    static {
        a = SetsKt.setOf(new String[]{"product_source_page", "source_method", "category_id", "tab_type", "page_version", "page_name", "follow_status", "temp_id", "store_type", "store_source_page", "store_source_method", "store_group_type", "live_anchor_id", "pre_product_id", "pre_room_id", "pre_group_id", "product_form", "content_source", "customer_id", "share_content", "share_object", "icon_type", BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, "dismiss_live_strand"});
    }

    public static String f(LayoutTypes r1) {
        if (r1 == null) goto L8;
        int r2 = r.a[r1.ordinal()];
        if (r2 != 1) goto L7;
        return "single_product";
    L7:
        if (r2 != 2) goto L8;
        return "clothes_preview";
    L8:
        return "double_product";
    }

    public static JSONObject d(q r8, Map r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        com.bytedance.commerce.base.json.a[] r0 = new com.bytedance.commerce.base.json.a[19];
        String r3 = "";
        if (Intrinsics.areEqual(r8.g, "shop") == false) goto L5;
        String r1 = "share_alert";
    L8:
        r0[0] = JsonDslUtilKt.d("product_source_page", r1);
        String r2 = r8.a;
        String r6 = null;
        if (r2 == null) goto L16;
        if ((!StringsKt.isBlank(r2)) == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L16;
    L22:
        r0[1] = JsonDslUtilKt.d("source_method", r2);
        r0[2] = JsonDslUtilKt.d("category_id", "");
        r0[3] = JsonDslUtilKt.d("tab_type", "");
        r0[4] = JsonDslUtilKt.d("page_version", "");
        String r4 = r8.i;
        if (r4 != null) goto L25;
        r4 = "";
    L25:
        r0[5] = JsonDslUtilKt.d("page_name", r4);
        Integer r5 = r8.k;
        if (r5 == null) goto L28;
        r6 = String.valueOf(r5.intValue());
    L28:
        if (r6 != null) goto L30;
        r6 = "";
    L30:
        r0[6] = JsonDslUtilKt.d("follow_status", r6);
        String r7 = r8.l;
        if (r7 != null) goto L33;
        r7 = "";
    L33:
        r0[7] = JsonDslUtilKt.d("temp_id", r7);
        r0[8] = JsonDslUtilKt.d("store_type", "shop");
        String r10 = r8.m;
        if (r10 != null) goto L36;
        r10 = "";
    L36:
        r0[9] = JsonDslUtilKt.d("store_source_page", r10);
        String r11 = r8.n;
        if (r11 != null) goto L39;
        r11 = "";
    L39:
        r0[10] = JsonDslUtilKt.d("store_source_method", r11);
        String r12 = r8.o;
        if (r12 != null) goto L42;
        r12 = "";
    L42:
        r0[11] = JsonDslUtilKt.d("store_group_type", r12);
        String r13 = r8.p;
        if (r13 != null) goto L45;
        r13 = "";
    L45:
        r0[12] = JsonDslUtilKt.d("live_anchor_id", r13);
        String r14 = r8.c;
        if (r14 != null) goto L48;
        r14 = "";
    L48:
        r0[13] = JsonDslUtilKt.d("pre_product_id", r14);
        String r15 = r8.d;
        if (r15 != null) goto L51;
        r15 = "";
    L51:
        r0[14] = JsonDslUtilKt.d("pre_room_id", r15);
        String r16 = r8.e;
        if (r16 != null) goto L54;
        r16 = "";
    L54:
        r0[15] = JsonDslUtilKt.d("pre_group_id", r16);
        String r17 = r8.q;
        if (r17 == null) goto L58;
        r3 = r17;
    L58:
        r0[16] = JsonDslUtilKt.d("product_form", r3);
        r0[17] = JsonDslUtilKt.d("content_source", "shop");
        r0[18] = JsonDslUtilKt.c("dismiss_live_strand", 1);
        JSONObject r18 = JsonDslUtilKt.a(r0);
        if (r8.t == false) goto L70;
        String r19 = r8.u;
        if (r19 != null) goto L63;
    L66:
        boolean r20 = true;
    L67:
        if (r20 == true) goto L70;
        r18.put("customer_id", r8.u);
        goto L70
    L63:
        if (StringsKt.isBlank(r19) == true) goto L66;
        r20 = false;
    L70:
        if (r8.f == false) goto L72;
        e(r18, "share_content", r8.g);
        e(r18, "share_object", r8.h);
    L72:
        e(r18, "icon_type", r8.v);
        if (r9 == null) goto L87;
        Iterator r21 = r9.entrySet().iterator();
    L76:
        if (r21.hasNext() == false) goto L87;
        Map.Entry r22 = (Map.Entry) r21.next();
        String r23 = (String) r22.getKey();
        String r24 = (String) r22.getValue();
        if (a.contains(r23) == true) goto L76;
        if (r24 != null) goto L81;
    L84:
        boolean r25 = true;
    L85:
        if (r25 == true) goto L76;
        r18.put(r23, r24);
        goto L76
    L81:
        if (StringsKt.isBlank(r24) == true) goto L84;
        r25 = false;
    L87:
        JSONObject r26 = com.bytedance.android.shopping.extensions.k.w(r8.w);
        if (r26 == null) goto L90;
        e(r18, BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r26.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID));
    L90:
        return r18;
    L16:
        if (Intrinsics.areEqual(r8.i, "classification_secondary_page") == false) goto L19;
        r2 = "classification";
        goto L22
    L19:
        if (r8.t == false) goto L21;
        r2 = "featured";
        goto L22
    L21:
        r2 = "products";
        goto L22
    L5:
        r1 = r8.j;
        if (r1 != null) goto L8;
        r1 = "";
        goto L8
    }

    public static void e(JSONObject r1, String r2, String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r1.put(r2, r3);
        return;
    L11:
        return;
    L4:
        if (StringsKt.isBlank(r3) == true) goto L7;
        r0 = false;
        goto L8
    }

    public static Map a(Map r5, q r6, String r7, int r8, PageFinder r9) {
        if (r5 == null) goto L5;
        Map r10 = MapsKt.toMutableMap(r5);
        if (r10 == null) goto L5;
    L6:
        r10.putAll(MapsKt.mapOf(new Pair[]{TuplesKt.to("category_id", null), TuplesKt.to("tab_type", null), TuplesKt.to("page_version", null), TuplesKt.to("ecom_entrance_form", r6.a), TuplesKt.to("pre_product_id", r6.c), TuplesKt.to("pre_room_id", r6.d), TuplesKt.to("pre_group_id", r6.e), TuplesKt.to("brand_verified", "0"), TuplesKt.to("search_params", r6.b), TuplesKt.to("content_source", "shop"), TuplesKt.to("product_form", r6.q), TuplesKt.to("btm_index", String.valueOf(r8 + 1)), TuplesKt.to("tab_name", r6.a), TuplesKt.to("tab_name_second", r6.r), TuplesKt.to("is_discount_selected", r6.s), TuplesKt.to("bst_group_type", "product"), TuplesKt.to("bst_tag", "bst_tag")}));
        if (r6.f == false) goto L9;
        r10.put("share_content", r6.g);
        r10.put("share_object", r6.h);
    L9:
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r7, "btm");
        Intrinsics.checkNotNullParameter(r9, "pageFinder");
        Iterator r11 = BtmSDK.INSTANCE.createReportParams(r7, r9).entrySet().iterator();
    L11:
        if (r11.hasNext() == false) goto L17;
        Map.Entry r12 = (Map.Entry) r11.next();
        Object r13 = r12.getKey();
        Object r14 = r12.getValue();
        if (r14 == null) goto L15;
        String r15 = r14.toString();
    L16:
        r10.put(r13, r15);
        goto L11
    L15:
        r15 = null;
        goto L16
    L17:
        return r10;
    L5:
        r10 = new LinkedHashMap();
        goto L6
    }

    public static Map b(q r1, String r2, int r3, PageFinder r4, Integer r5, Integer r6, Integer r7, Map r8) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "btm");
        Intrinsics.checkNotNullParameter(r4, "pageFinder");
        Map r9 = a(r8, r1, r2, r3, r4);
        if (r5 == null) goto L5;
        String r10 = (String) r9.put("product_view_num", String.valueOf(r5.intValue()));
    L5:
        if (r6 == null) goto L7;
        String r11 = (String) r9.put("product_total_num", String.valueOf(r6.intValue()));
    L7:
        if (r7 == null) goto L9;
        r9.put("product_click_index", String.valueOf(r7.intValue()));
    L9:
        return r9;
    }

    public static /* synthetic */ Map c(Map r11, q r12, String r13, int r14, PageFinder r15, Integer r16, Integer r17, Integer r18, int r19) {
        if ((r19 & 32) == 0) goto L5;
        Integer r7 = null;
    L7:
        if ((r19 & 64) == 0) goto L9;
        Integer r8 = null;
    L11:
        if ((r19 & 128) == 0) goto L13;
        Integer r9 = null;
    L15:
        if ((r19 & 256) == 0) goto L17;
        Map r10 = r11;
    L19:
        return b(r12, r13, r14, r15, r7, r8, r9, r10);
    L17:
        r10 = null;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }
}
