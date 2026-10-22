package com.bytedance.android.shopping.store.product.presenter.aggregate;

import android.view.View;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.store.common.param.ProductBasicRequestParam;
import com.bytedance.android.ec.store.common.param.StoreAccountParam;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import sm.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class d implements h {
    public final ShopAggregatePageProductViewModel a;

    public Function3<String, String, Long, Unit> b() {
        return null;
    }

    public Function1<Integer, Unit> e() {
        return null;
    }

    public final boolean h(StoreV2ProductItemVO r1) {
        return false;
    }

    public final void i(View r1) {
    }

    public final qn.a<ECVideoPlayer> k() {
        return null;
    }

    public final long l() {
        return -1;
    }

    public final boolean m(StoreV2ProductItemVO r1) {
        return false;
    }

    public final Integer n() {
        return 1;
    }

    public final xm.c o() {
        return null;
    }

    public final r p(Integer r1) {
        return null;
    }

    public final jm.a<ej3.a> q() {
        return null;
    }

    public final String a() {
        ShopAggregatePageProductViewModel r0 = this.a;
        if (r0.isStoreParamInit() == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L13;
        ShopAggregateParam r1 = r0.getStoreParam();
        if (r1 == null) goto L14;
        StoreAccountParam r2 = r1.getStoreAccountParam();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.getUserId();
    L14:
        return null;
    L13:
        return null;
    }

    public final String d() {
        ShopAggregatePageProductViewModel r0 = this.a;
        if (r0.isStoreParamInit() == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L13;
        ShopAggregateParam r1 = r0.getStoreParam();
        if (r1 == null) goto L14;
        StoreAccountParam r2 = r1.getStoreAccountParam();
        if (r2 != null) goto L12;
        return null;
    L12:
        return r2.getSecUserId();
    L14:
        return null;
    L13:
        return null;
    }

    public final xm.c f() {
        return this.a.getTagPools();
    }

    public final String g() {
        ShopAggregatePageProductViewModel r0 = this.a;
        String r2 = null;
        if (r0.isStoreParamInit() == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        ShopAggregateParam r1 = r0.getStoreParam();
    L9:
        com.bytedance.commerce.base.json.a[] r3 = new com.bytedance.commerce.base.json.a[6];
        if (r1 == null) goto L12;
        String r4 = r1.getStoreSourcePage();
    L13:
        String r5 = "";
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r3[0] = JsonDslUtilKt.d("store_source_page", r4);
        if (r1 == null) goto L19;
        String r6 = r1.getStoreSourceMethod();
    L20:
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        r3[1] = JsonDslUtilKt.d("store_source_method", r6);
        if (r1 == null) goto L25;
        String r7 = r1.getStoreGroupType();
    L26:
        if (r7 != null) goto L28;
        r7 = "";
    L28:
        r3[2] = JsonDslUtilKt.d("store_group_type", r7);
        if (r1 == null) goto L31;
        String r8 = r1.getEnterFrom();
    L32:
        if (r8 != null) goto L34;
        r8 = "";
    L34:
        r3[3] = JsonDslUtilKt.d("enter_from", r8);
        if (r1 == null) goto L37;
        String r9 = r1.getTempId();
    L38:
        if (r9 != null) goto L40;
        r9 = "";
    L40:
        r3[4] = JsonDslUtilKt.d("temp_id", r9);
        if (r1 == null) goto L45;
        ProductBasicRequestParam r10 = r1.getProductBasicRequestParam();
        if (r10 == null) goto L45;
        r2 = r10.getMaterialId();
    L45:
        if (r2 == null) goto L48;
        r5 = r2;
    L48:
        r3[5] = JsonDslUtilKt.d("customer_id", r5);
        return JsonDslUtilKt.a(r3).toString();
    L37:
        r9 = null;
        goto L38
    L31:
        r8 = null;
        goto L32
    L25:
        r7 = null;
        goto L26
    L19:
        r6 = null;
        goto L20
    L12:
        r4 = null;
        goto L13
    L8:
        r1 = null;
        goto L9
    }

    public final boolean isClickable() {
        ShopAggregatePageProductViewModel r0 = this.a;
        if (r0.isStoreParamInit() == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L14;
        ShopAggregateParam r1 = r0.getStoreParam();
        if (r1 != null) goto L11;
        return false;
    L11:
        if (r1.isPreview() == true) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    public d(ShopAggregatePageProductViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }
}
