package com.bytedance.android.shopping.store.utils;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.shopping.store.home.api.InterceptBackPressKey;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements l {
    public final a0 a;

    public k(a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "storeIntercept");
        this.a = r2;
    }

    @Override // com.bytedance.android.shopping.store.utils.l
    public final boolean a(ECStoreViewModel r6, Context r7) {
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r1 = null;
        boolean r2 = true;
        boolean r3 = false;
        if (this.a.b() == null) goto L13;
        String r0 = this.a.b();
        if (r0.length() <= 0) goto L7;
        r3 = true;
    L7:
        if (r3 == false) goto L9;
        r1 = r0;
    L9:
        if (r1 == null) goto L11;
        b(r1, r6, r7);
    L11:
        return true;
    L13:
        if (this.a.c() == null) goto L22;
        String r4 = this.a.c();
        if (r4.length() > 0) goto L18;
        r2 = false;
    L18:
        if (r2 == false) goto L20;
        r1 = r4;
    L20:
        if (r1 == null) goto L22;
        b(r1, r6, r7);
    L22:
        return false;
    }

    public static void b(String r5, ECStoreViewModel r6, Context r7) {
        String r1 = null;
        if (Intrinsics.areEqual(r6.getStoreParam().getInterceptBackProcessType(), InterceptBackPressKey.MALLPOPUPKEY.getType()) == false) goto L5;
    L6:
        Activity r0 = l0.b(r7);
        if (r0 == null) goto L9;
        String r2 = hm.c.e(r0);
    L10:
        JSONObject r3 = com.bytedance.android.shopping.extensions.k.w(r2);
        if (r3 == null) goto L19;
        JSONObject r4 = com.bytedance.android.shopping.extensions.k.w(r3.optString("log_extra"));
        if (r4 == null) goto L15;
        String r8 = r4.optString("ad_id");
    L16:
        String r9 = r3.optString("creative_id", null);
        if (r9 != null) goto L20;
        r9 = r3.optString("cid");
    L20:
        m0 r10 = new m0(r5);
        r10.b("enter_from", "goods_shop_back_buy");
        r10.b("wysiwyg_items", "37_" + r6.getStoreParam().getShopId() + '_' + r9 + '_' + r8);
        r5 = r10.c();
    L21:
        m0 r11 = new m0(r5);
        Activity r12 = l0.b(r7);
        if (r12 == null) goto L24;
        r1 = hm.c.e(r12);
    L24:
        r11.b("entrance_info", r1);
        r11.b("shop_id", r6.getStoreParam().getShopId());
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r7, r11.c());
        return;
    L15:
        r8 = null;
        goto L16
    L19:
        r8 = null;
        r9 = null;
        goto L20
    L9:
        r2 = null;
        goto L10
    L5:
        if (Intrinsics.areEqual(r6.getStoreParam().getInterceptBackProcessType(), InterceptBackPressKey.MALLKEY.getType()) == false) goto L21;
        goto L6
    }
}
