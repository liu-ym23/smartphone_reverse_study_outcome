package com.bytedance.android.shopping.sku.inner.controller;

import com.bytedance.android.ec.core.utils.CarModelSelectInfo;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.sku.common.controller.SkuHandleEventOpportunity;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements com.bytedance.android.shopping.sku.common.jsb.a {
    public final /* synthetic */ b a;

    @Override // com.bytedance.android.shopping.sku.common.jsb.a
    public final void d() {
        this.a.b.dq().v(SkuHandleEventOpportunity.CLOTHES_SIZE_ASSISTANT, null);
    }

    public c(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.sku.common.jsb.a
    public final void a(CarModelSelectInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "carInfo");
        ph3.a r0 = new ph3.a(r4.getId(), r4.getModel());
        this.a.b.qn().getSkuParams().setSelectCarId(r4.getId());
        this.a.b.qn().getStaticState().b = r0;
        this.a.b.dq().v(SkuHandleEventOpportunity.CAR_ADAPTER, null);
    }

    @Override // com.bytedance.android.shopping.sku.common.jsb.a
    public final void b(String r3) {
        if (k.c(r3) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3, this.a.b.qn().getSkuParams().getProductId()) == false) goto L9;
        this.a.b.dq().v(SkuHandleEventOpportunity.RECEIVE_UPDATE_SKU_NOTICE, null);
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.jsb.a
    public final void c(ProductSelectPoiInfo r3) {
        this.a.b.qn().getStaticState().c = r3;
        this.a.b.dq().v(SkuHandleEventOpportunity.POI_STORE_ENTRY, null);
    }

    @Override // com.bytedance.android.shopping.sku.common.jsb.a
    public final void e(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        String r1 = r3.optString("pre_session_id");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L13;
        if (Intrinsics.areEqual(r3.optString("pre_session_id"), this.a.b.qn().getSkuParams().getUniqueId()) == true) goto L13;
        return;
    L13:
        if (r3.optInt("page_scene") != 0) goto L17;
        this.a.b.dq().v(SkuHandleEventOpportunity.QUIT_BUYNOW_PAGE, null);
        return;
    L17:
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.shopping.sku.common.jsb.a
    public final void f(com.bytedance.android.shopping.sku.common.jsb.b r3) {
        Intrinsics.checkNotNullParameter(r3, "nextPageEventData");
        if (k.c(r3.a) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3.a, this.a.b.qn().getSkuParams().getUniqueId()) == false) goto L9;
        this.a.b.dq().v(SkuHandleEventOpportunity.PAY_FOR_FIX_NEXT_PAGE_EVENT, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.sku.common.jsb.a
    public final void g(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        String r1 = r3.optString("pre_session_id");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L13;
        if (Intrinsics.areEqual(r3.optString("pre_session_id"), this.a.b.qn().getSkuParams().getUniqueId()) == true) goto L13;
        return;
    L13:
        if (this.a.b.qn().getSkuParams().getActionType() == 6) goto L17;
        this.a.b.close(2);
        return;
    L17:
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
