package com.bytedance.android.shopping.store.hybridproduct.actionhandler;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.repository.dto.l;
import com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.hybridproduct.extension.d;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.android.shopping.store.slicecard.SliceActionType;
import com.bytedance.android.shopping.store.utils.q;
import com.bytedance.android.shopping.store.utils.s;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AddProductActionHandler<T extends com.bytedance.android.shopping.store.hybridproduct.extension.d> implements com.bytedance.android.shopping.store.slicecard.a {
    public T a;
    public ej3.g b;
    public final b c;
    public final a<T> d;
    public final Fragment e;

    public final String f() {
        JSONObject r0 = k.w(this.c.g());
        com.bytedance.commerce.base.json.a[] r2 = new com.bytedance.commerce.base.json.a[1];
        com.bytedance.commerce.base.json.a[] r3 = new com.bytedance.commerce.base.json.a[12];
        r3[0] = JsonDslUtilKt.d("carrier_source", "store_page");
        r3[1] = JsonDslUtilKt.d("source_method", "products");
        ej3.g r4 = this.b;
        if (r4 == null) goto L10;
        l.b r5 = r4.f;
        if (r5 == null) goto L10;
        if (r5.c() != true) goto L10;
        String r1 = "live";
    L11:
        r3[2] = JsonDslUtilKt.d("ecom_group_type", r1);
        String r6 = null;
        if (r0 == null) goto L14;
        String r7 = r0.optString("enter_from");
    L16:
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        r3[3] = JsonDslUtilKt.d("product_source_page", r7);
        r3[4] = JsonDslUtilKt.d("store_type", "shop");
        if (r0 == null) goto L21;
        String r8 = r0.optString("store_source_page");
    L22:
        if (r8 != null) goto L24;
        r8 = "";
    L24:
        r3[5] = JsonDslUtilKt.d("store_source_page", r8);
        if (r0 == null) goto L27;
        String r9 = r0.optString("store_source_method");
    L28:
        if (r9 != null) goto L30;
        r9 = "";
    L30:
        r3[6] = JsonDslUtilKt.d("store_source_method", r9);
        if (r0 == null) goto L33;
        String r10 = r0.optString("store_group_type");
    L34:
        if (r10 != null) goto L36;
        r10 = "";
    L36:
        r3[7] = JsonDslUtilKt.d("store_group_type", r10);
        if (r0 == null) goto L39;
        String r11 = r0.optString("product_form");
    L40:
        if (r11 != null) goto L42;
        r11 = "";
    L42:
        r3[8] = JsonDslUtilKt.d("product_form", r11);
        if (r0 == null) goto L45;
        String r12 = r0.optString("temp_id");
    L46:
        if (r12 != null) goto L48;
        r12 = "";
    L48:
        r3[9] = JsonDslUtilKt.d("temp_id", r12);
        if (r0 == null) goto L51;
        r6 = r0.optString("customer_id");
    L51:
        if (r6 != null) goto L53;
        r6 = "";
    L53:
        r3[10] = JsonDslUtilKt.d("customer_id", r6);
        r3[11] = JsonDslUtilKt.d("page_type", "");
        r2[0] = JsonDslUtilKt.d("cart_track", JsonDslUtilKt.a(r3).toString());
        JSONObject r13 = JsonDslUtilKt.a(r2);
        ej3.g r14 = this.b;
        if (r14 == null) goto L60;
        com.bytedance.android.ec.store.repository.vo.b r15 = r14.e;
        if (r15 == null) goto L60;
        String r16 = r15.c;
        if (r16 == null) goto L60;
        z1.c(r13, r16);
    L60:
        r13.accumulate(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID, "1003");
        return r13.toString();
    L45:
        r12 = null;
        goto L46
    L39:
        r11 = null;
        goto L40
    L33:
        r10 = null;
        goto L34
    L27:
        r9 = null;
        goto L28
    L21:
        r8 = null;
        goto L22
    L14:
        r7 = null;
    L10:
        r1 = "video";
        goto L11
    }

    public final void e(final View r122) {
        T r0 = this.a;
        if (r0 == null) goto L5;
        this.d.a(r0);
    L5:
        ej3.g r1 = this.b;
        String r2 = null;
        if (r1 == null) goto L10;
        com.bytedance.android.ec.store.repository.vo.b r3 = r1.e;
        if (r3 == null) goto L10;
        Boolean r4 = r3.a;
    L12:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L21;
        ej3.g r5 = this.b;
        if (r5 == null) goto L20;
        com.bytedance.android.ec.store.repository.vo.b r6 = r5.e;
        if (r6 == null) goto L20;
        String r9 = r6.b;
        if (r9 == null) goto L20;
        ECToast.showToast$default(ECToast.INSTANCE, this.e.requireContext(), r9, null, 4, null);
    L20:
        boolean r7 = false;
    L22:
        if (r7 == true) goto L24;
        return;
    L24:
        ej3.g r8 = this.b;
        if (r8 == null) goto L136;
        Integer r10 = r8.c;
        if (r10 == null) goto L137;
        int r11 = r10.intValue();
        FragmentActivity r12 = this.e.getActivity();
        if ((r12 instanceof FragmentActivity) == true) goto L31;
        r12 = null;
    L31:
        if (r12 == null) goto L138;
        FragmentManager r13 = r12.getSupportFragmentManager();
        if (r13 == null) goto L143;
        final String r14 = this.c.a();
        final String r15 = this.c.d();
        final com.bytedance.android.btm.api.model.d r16 = new com.bytedance.android.btm.api.model.d();
        StringBuilder r17 = new StringBuilder("c2429.d15091_i");
        if (this.b == null) goto L38;
        Integer r18 = 0;
    L39:
        r17.append(r18);
        r16.a = r17.toString();
        r16.b = PageFinder.via(this.e);
        BcmParams r19 = new BcmParams();
        r19.put("bst_group_type", "product");
        Unit r110 = Unit.INSTANCE;
        r16.c = r19;
        String r111 = "";
        if (r11 == 0) goto L70;
        if (r11 == 1) goto L43;
        return;
    L43:
        Context r20 = this.e.getContext();
        if (r20 == null) goto L139;
        int r21 = ECSdk.a;
        IECCommonService r112 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r112 == null) goto L140;
        StringBuilder r22 = new StringBuilder();
        r22.append(r14);
        r22.append("_");
        ej3.g r23 = this.b;
        if (r23 == null) goto L50;
        r2 = r23.a;
    L50:
        r22.append(r2);
        String r113 = r22.toString();
        ej3.g r24 = this.b;
        if (r24 == null) goto L56;
        String r25 = r24.b;
        if (r25 == null) goto L56;
        String r114 = r25;
    L57:
        if (r24 == null) goto L62;
        String r26 = r24.a;
        if (r26 == null) goto L62;
        String r115 = r26;
    L63:
        if (r14 != null) goto L65;
        String r116 = "";
    L66:
        if (r15 != null) goto L68;
        String r28 = "";
    L69:
        String r117 = r114;
        String r118 = r115;
        String r119 = r116;
        String r120 = r28;
        IECCommonService.a.a(r112, r20, 303, 0, "3003002002", r113, r117, r118, r119, r120, "", "", f(), false, null, null, true, null, BtmSDK.INSTANCE.getPageId(PageFinder.via(r122)), r16, false, null, null, null, null, null, null, null, null, null, null, new AddProductActionHandler$doAddCart$$inlined$let$lambda$2(r14, r15, r16, this, r122), -1638400, 1);
        return;
    L68:
        r28 = r15;
        goto L69
    L65:
        r116 = r14;
    L62:
        r115 = "";
    L56:
        r114 = "";
        goto L57
    L140:
        return;
    L139:
        return;
    L70:
        int r27 = ECSdk.a;
        IECCommonService r29 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r29 == null) goto L142;
        ej3.g r121 = this.b;
        if (r121 == null) goto L78;
        String r123 = r121.b;
        if (r123 == null) goto L78;
        String r210 = r123;
    L79:
        if (r121 == null) goto L81;
        String r211 = r121.a;
    L82:
        int r38 = ul.d.b(0, true, 4);
        if (r14 != null) goto L85;
        String r32 = "";
    L86:
        if (r15 != null) goto L88;
        String r33 = "";
    L89:
        StringBuilder r30 = new StringBuilder();
        r30.append(r14);
        r30.append("_");
        ej3.g r31 = this.b;
        if (r31 == null) goto L92;
        String r34 = r31.a;
    L93:
        r30.append(r34);
        String r104 = r30.toString();
        ej3.g r35 = this.b;
        if (r35 == null) goto L96;
        Long r36 = r35.d;
    L97:
        String r212 = String.valueOf(r36);
        String r37 = this.c.a();
        if (r37 != null) goto L100;
        r37 = "";
    L100:
        Map r79 = MapsKt.mapOf(TuplesKt.to("author_id", r37));
        JSONObject r39 = k.w(this.c.g());
        Set<String> r40 = s.a;
        if (r39 == null) goto L103;
        String r108 = r39.optString("product_source_page");
    L105:
        if (r39 == null) goto L107;
        String r109 = r39.optString("store_source_page");
    L109:
        if (r39 == null) goto L111;
        String r1110 = r39.optString("store_source_method");
    L113:
        if (r39 == null) goto L115;
        String r1111 = r39.optString("store_group_type");
    L117:
        if (r39 == null) goto L119;
        String r1112 = r39.optString("product_form");
    L121:
        if (r39 == null) goto L123;
        String r77 = r39.optString("is_discount_selected");
    L124:
        if (r77 != null) goto L126;
        String r1113 = "";
    L127:
        JSONObject r41 = s.d(new q("products", "store_page", r108, r109, r1110, r1111, r1112, CommentServiceId.HOT_SPOT, r1113, 7900414), null);
        com.bytedance.commerce.base.json.a[] r42 = new com.bytedance.commerce.base.json.a[10];
        r42[0] = JsonDslUtilKt.d("carrier_source", "store_page");
        r42[1] = JsonDslUtilKt.d("store_type", r41.optString("store_type"));
        r42[2] = JsonDslUtilKt.d("source_method", r41.optString("source_method"));
        r42[3] = JsonDslUtilKt.d("source_method_second", CommentServiceId.HOT_SPOT);
        r42[4] = JsonDslUtilKt.d("product_form", r41.optString("product_form"));
        if (r39 == null) goto L130;
        String r43 = r39.optString("is_discount_selected");
    L131:
        if (r43 == null) goto L134;
        r111 = r43;
    L134:
        r42[5] = JsonDslUtilKt.d("is_discount_selected", r111);
        r42[6] = JsonDslUtilKt.d("product_source_page", r41.optString("product_source_page"));
        r42[7] = JsonDslUtilKt.d("store_source_page", r41.optString("store_source_page"));
        r42[8] = JsonDslUtilKt.d("store_source_method", r41.optString("store_source_method"));
        r42[9] = JsonDslUtilKt.d("store_group_type", r41.optString("store_group_type"));
        IECCommonService.a.d(r29, r13, new SkuParams(null, null, null, null, null, 0, null, null, null, false, false, null, null, false, r211, r210, r212, false, null, null, r32, r33, null, null, "", false, r38, 303, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, null, null, null, null, 0.0f, null, null, null, null, null, f(), JsonDslUtilKt.a(r42).toString(), null, r79, null, null, null, 0, "ECProductCardAddCartElementPresenter", null, null, null, null, null, true, null, null, null, null, null, null, null, -1, 0, false, null, "3003002002", r104, false, null, null, null, null, null, null, null, null, -221364225, -1, -205537548, 31, null), null, r16, null, null, null, null, null, new AddProductActionHandler$doAddCart$$inlined$let$lambda$1(this, r122), null, 0, null, null, this.e.getContext(), 14336);
        return;
    L130:
        r43 = null;
        goto L131
    L126:
        r1113 = r77;
        goto L127
    L123:
        r77 = null;
        goto L124
    L119:
        r1112 = null;
        goto L121
    L115:
        r1111 = null;
        goto L117
    L111:
        r1110 = null;
        goto L113
    L107:
        r109 = null;
        goto L109
    L103:
        r108 = null;
        goto L105
    L96:
        r36 = null;
        goto L97
    L92:
        r34 = null;
        goto L93
    L88:
        r33 = r15;
        goto L89
    L85:
        r32 = r14;
        goto L86
    L81:
        r211 = null;
    L78:
        r210 = "";
        goto L79
    L142:
        return;
    L38:
        r18 = null;
        goto L39
    L143:
        return;
    L138:
        return;
    L137:
        return;
    L136:
        return;
    L21:
        r7 = true;
    L10:
        r4 = null;
        goto L12
    }

    public AddProductActionHandler(b r2, a<T> r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModelAdapter");
        Intrinsics.checkNotNullParameter(r3, "behavior");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        this.c = r2;
        this.d = r3;
        this.e = r4;
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void b(StoreV2ProductItemVO r3, View r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "target");
        if (this.c.isClickable() == true) goto L5;
        return;
    L5:
        this.a = r3;
        Intrinsics.checkNotNullParameter(r3, "$this$toShopAddcartVO");
        ej3.g r6 = new ej3.g();
        String r0 = r3.a;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r6.a = r0;
        r6.b = r3.b;
        r6.c = r3.r;
        r6.e = r3.x;
        r6.f = r3.s;
        r6.d = r3.c;
        this.b = r6;
        e(r4);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void a(ShopSlcProductItemV2 r2, View r3, Map<String, ? extends Object> r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        if (this.c.isClickable() == true) goto L5;
        return;
    L5:
        this.a = r2;
        Intrinsics.checkNotNullParameter(r2, "$this$toShopAddcartVO");
        ej3.g r6 = new ej3.g();
        String r7 = r2.j;
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r6.a = r7;
        r6.b = r2.k;
        r6.c = r2.l;
        r6.e = r2.n;
        r6.d = r2.m;
        this.b = r6;
        e(r3);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void c(SliceActionType r1, ShopSlcProductItemV2 r2, View r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.b(r1, r2, r3);
    }

    @Override // com.bytedance.android.shopping.store.slicecard.a
    public final void d(SliceActionType r1, StoreV2ProductItemVO r2, View r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r1, "actionType");
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "target");
        com.bytedance.android.shopping.store.slicecard.a.C0017a.a(r1, r2, r3);
    }
}
