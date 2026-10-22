package com.bytedance.android.shopping.sku.outer.business.cart.core;

import android.view.View;
import com.bytedance.android.ec.model.sku.SkuCartResult;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuOuterAddToCartHelper {
    public final mh3.a a;
    public final com.bytedance.android.ec.core.async.b b;
    public final c c;
    public final View d;
    public final Function1<SkuCartResult, Unit> e;
    public final com.bytedance.android.shopping.sku.common.ability.a f;
    public final Function0<Unit> g;

    public final void d() {
        com.bytedance.android.shopping.sku.common.utils.d.b(CollectionsKt.listOf(new com.bytedance.android.shopping.sku.common.utils.a[]{com.bytedance.android.shopping.sku.common.utils.d.a("监控", new SkuOuterAddToCartHelper$start$1(this)), com.bytedance.android.shopping.sku.common.utils.d.a("【NavBtnClickHelper.onClickAddShopCartImpl】请求加入购物车的网络接口", new SkuOuterAddToCartHelper$start$2(this)), com.bytedance.android.shopping.sku.common.utils.d.a("【checkSuccess】通知营销层用户下单行为", SkuOuterAddToCartHelper$start$3.INSTANCE), com.bytedance.android.shopping.sku.common.utils.d.a("【checkSuccess】logAdEvent host service", new SkuOuterAddToCartHelper$start$4(this))}));
    }

    public final void c(String r3) {
        boolean r1 = true;
        if (this.c.d.getEnableAddCartFailToastForSchema() == false) goto L5;
    L6:
        int r0 = SkuCommonToast.a;
        if (r3 != null) goto L9;
    L16:
        r3 = "添加失败，请稍后重试";
    L17:
        SkuCommonToast.c(r3);
        return;
    L9:
        if (r3.length() > 0) goto L12;
        r1 = false;
    L12:
        if (r1 == true) goto L15;
        r3 = null;
    L15:
        if (r3 != null) goto L17;
    L5:
        if (this.c.c == 1) goto L6;
    }

    public final void b(String r4, String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L15;
        mh3.a r1 = this.a;
        if (r1 == null) goto L16;
        com.bytedance.android.shopping.sku.common.monitor.error.a r2 = r1.c;
        if (r2 == null) goto L17;
        SkuErrorMonitorType r3 = SkuErrorMonitorType.SERIOUS_BUSINESS_ERROR;
        String r6 = r4 + 20026 + r5 + ", product_id:" + this.c.c();
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r7 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r2.a(r3, r6, null);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L4:
        if (r5.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static final void a(SkuOuterAddToCartHelper r3, String r4, String r5, String r6, Integer r7) {
        r3.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        String r8 = new JSONObject(r4).optString("btm_show_id");     // Catch: Throwable -> L19
        int r1 = b.a;     // Catch: Throwable -> L19
        LinkedHashMap r2 = new LinkedHashMap();     // Catch: Throwable -> L19
        String r9 = r3.c.d.getEntranceInfo();     // Catch: Throwable -> L19
        if (r9 == null) goto L6;
        r2.put("entrance_info", r9);     // Catch: Throwable -> L19
    L6:
        SkuExtraData r10 = r3.c.d.getSkuExtraData();     // Catch: Throwable -> L19
        if (r10 == null) goto L9;
        Map r11 = r10.getAddCartTrackMeta();     // Catch: Throwable -> L19
    L10:
        if (r11 == null) goto L17;
        Iterator r12 = r11.entrySet().iterator();     // Catch: Throwable -> L19
    L13:
        if (r12.hasNext() == false) goto L17;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L19
        if (r13.getValue() == null) goto L13;
        r2.put(r13.getKey(), r13.getValue());     // Catch: Throwable -> L19
    L17:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L19
        b.c(r5, r8, r6, r7, r2);     // Catch: Throwable -> L19
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        return;
    L9:
        r11 = null;
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public SkuOuterAddToCartHelper(mh3.a r2, com.bytedance.android.shopping.sku.inner.container.b r3, c r4, View r5, Function1 r6, com.bytedance.android.shopping.sku.inner.function.business.a r7, Function0 r8) {
        Intrinsics.checkNotNullParameter(r3, "disposableScope");
        Intrinsics.checkNotNullParameter(r4, "cartData");
        Intrinsics.checkNotNullParameter(r7, "skuAddCartListener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
