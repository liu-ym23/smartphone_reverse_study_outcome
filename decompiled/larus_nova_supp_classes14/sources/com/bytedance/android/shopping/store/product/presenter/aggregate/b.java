package com.bytedance.android.shopping.store.product.presenter.aggregate;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.utils.y;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static JSONObject a(ShopAggregatePageProductViewModel r15, StoreV2ProductItemVO r16, String r17, String r18, String r19, boolean r20, int r21) {
        String r4 = null;
        if ((r21 & 8) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r21 & 16) == 0) goto L9;
        String r5 = null;
    L10:
        boolean r7 = true;
        if ((r21 & 32) == 0) goto L13;
        boolean r6 = true;
    L15:
        if ((r21 & 64) == 0) goto L17;
        boolean r9 = true;
    L19:
        if ((r21 & 128) == 0) goto L21;
        boolean r2 = false;
    L22:
        ShopAggregatePageProductViewModel r11 = r15;
        Intrinsics.checkNotNullParameter(r15, "viewModel");
        Intrinsics.checkNotNullParameter(r16, "item");
        Intrinsics.checkNotNullParameter(r17, "sourceMethod");
        if (r15.isStoreParamInit() == true) goto L26;
        r11 = null;
    L26:
        if (r11 == null) goto L28;
        ShopAggregateParam r10 = r11.getStoreParam();
    L29:
        String r12 = "";
        if (r3 != null) goto L36;
        if (r10 == null) goto L33;
        r3 = r10.getTabNameSecond();
    L34:
        if (r3 != null) goto L36;
        r3 = "";
        goto L36
    L33:
        r3 = null;
    L36:
        if (r5 != null) goto L42;
        if (r10 == null) goto L39;
        r5 = r10.getTabLabel();
    L40:
        if (r5 != null) goto L42;
        r5 = "";
        goto L42
    L39:
        r5 = null;
    L42:
        com.bytedance.commerce.base.json.a[] r13 = new com.bytedance.commerce.base.json.a[13];
        if (r10 == null) goto L45;
        String r14 = r10.getEntranceLocation();
    L46:
        if (r14 != null) goto L48;
        r14 = "";
    L48:
        r13[0] = JsonDslUtilKt.d("product_source_page", r14);
        r13[1] = JsonDslUtilKt.d("source_method", r17);
        r13[2] = JsonDslUtilKt.d("source_method_second", r3);
        if (r10 == null) goto L54;
        Integer r1 = r10.getFollowStatus();
        if (r1 == null) goto L54;
        String r8 = String.valueOf(r1.intValue());
        if (r8 == null) goto L54;
    L55:
        r13[3] = JsonDslUtilKt.d("follow_status", r8);
        r13[4] = JsonDslUtilKt.d("tab_label", r5);
        String r22 = r16.h;
        if (r22 != null) goto L59;
        r22 = null;
    L59:
        if (r22 != null) goto L61;
        r22 = "";
    L61:
        r13[5] = JsonDslUtilKt.d("price_type", r22);
        if (r10 == null) goto L64;
        String r23 = r10.getStoreSourcePage();
    L65:
        if (r23 != null) goto L67;
        r23 = "";
    L67:
        r13[6] = JsonDslUtilKt.d("store_source_page", r23);
        if (r10 == null) goto L70;
        String r24 = r10.getStoreSourceMethod();
    L71:
        if (r24 != null) goto L73;
        r24 = "";
    L73:
        r13[7] = JsonDslUtilKt.d("store_source_method", r24);
        if (r10 == null) goto L76;
        String r25 = r10.getStoreGroupType();
    L77:
        if (r25 != null) goto L79;
        r25 = "";
    L79:
        r13[8] = JsonDslUtilKt.d("store_group_type", r25);
        if (r10 == null) goto L82;
        String r26 = r10.getPreProductId();
    L83:
        if (r26 != null) goto L85;
        r26 = "";
    L85:
        r13[9] = JsonDslUtilKt.d("pre_product_id", r26);
        if (r10 == null) goto L88;
        String r27 = r10.getPreRoomId();
    L89:
        if (r27 != null) goto L91;
        r27 = "";
    L91:
        r13[10] = JsonDslUtilKt.d("pre_room_id", r27);
        if (r10 == null) goto L94;
        String r28 = r10.getPreGroupId();
    L95:
        if (r28 != null) goto L97;
        r28 = "";
    L97:
        r13[11] = JsonDslUtilKt.d("pre_group_id", r28);
        r13[12] = JsonDslUtilKt.d("store_type", "shop");
        JSONObject r29 = JsonDslUtilKt.a(r13);
        if (r6 == false) goto L105;
        if (r10 == null) goto L101;
        String r30 = r10.getTempId();
    L102:
        if (r30 != null) goto L104;
        r30 = "";
    L104:
        r29.put("temp_id", r30);
        goto L105
    L101:
        r30 = null;
    L105:
        if (r2 == false) goto L112;
        if (r10 == null) goto L108;
        String r31 = r10.getTabNameSecond();
    L109:
        if (r31 != null) goto L111;
        r31 = "";
    L111:
        r29.put("tab_name_second", r31);
        goto L112
    L108:
        r31 = null;
    L112:
        ECHybridExtensionsKt.d(r29, y.a(r16));
        Map r0 = r16.o;
        if (r0 == null) goto L118;
        Iterator r32 = r0.entrySet().iterator();
    L116:
        if (r32.hasNext() == false) goto L118;
        Map.Entry r33 = (Map.Entry) r32.next();
        r29.put((String) r33.getKey(), r33.getValue());
    L118:
        if (r10 == null) goto L122;
        ProductBasicRequestParam r34 = r10.getProductBasicRequestParam();
        if (r34 == null) goto L122;
        r4 = r34.getMaterialId();
    L122:
        if (r9 == false) goto L131;
        if (r4 != null) goto L125;
    L128:
        boolean r35 = true;
    L129:
        if (r35 == true) goto L131;
        r29.put("customer_id", r4);
        goto L131
    L125:
        if (StringsKt.isBlank(r4) == true) goto L128;
        r35 = false;
    L131:
        if (r10 == null) goto L148;
        String r36 = (String) r10.getPassThroughParam("pass_through_api");
        if (r36 == null) goto L148;
        JSONObject r37 = k.u(r36);
        String r38 = r37.optString(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
        if (StringsKt.indexOf$default(r38, "1003", 0, false, 6, null) != (-1)) goto L144;
        StringBuilder r39 = new StringBuilder();
        r39.append(r38);
        if (r38.length() != 0) goto L139;
        boolean r40 = true;
    L140:
        if (r40 == true) goto L143;
        r12 = ",";
    L143:
        r39.append(r12);
        r39.append("1003");
        r38 = r39.toString();
        goto L144
    L139:
        r40 = false;
    L144:
        r37.put(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, r38);
        Iterator<String> r41 = r37.keys();
    L146:
        if (r41.hasNext() == false) goto L148;
        String r42 = r41.next();
        r29.put(r42, r37.opt(r42));
    L148:
        if (r10 != null) goto L150;
    L168:
        return r29;
    L150:
        if (r10.isEcShare() != true) goto L168;
        String r43 = r10.getShareContent();
        if (r43 != null) goto L154;
    L157:
        boolean r44 = true;
    L158:
        if (r44 == true) goto L160;
        r29.put("share_content", r10.getShareContent());
    L160:
        String r45 = r10.getShareObject();
        if (r45 != null) goto L163;
    L166:
        if (r7 == true) goto L168;
        r29.put("share_object", r10.getShareObject());
        goto L168
    L163:
        if (StringsKt.isBlank(r45) == true) goto L166;
        r7 = false;
        goto L166
    L154:
        if (StringsKt.isBlank(r43) == true) goto L157;
        r44 = false;
        goto L158
    L94:
        r28 = null;
        goto L95
    L88:
        r27 = null;
        goto L89
    L82:
        r26 = null;
        goto L83
    L76:
        r25 = null;
        goto L77
    L70:
        r24 = null;
        goto L71
    L64:
        r23 = null;
    L54:
        r8 = "";
        goto L55
    L45:
        r14 = null;
        goto L46
    L28:
        r10 = null;
        goto L29
    L21:
        r2 = r20;
        goto L22
    L17:
        r9 = false;
        goto L19
    L13:
        r6 = false;
        goto L15
    L9:
        r5 = r19;
        goto L10
    L5:
        r3 = r18;
        goto L7
    }
}
