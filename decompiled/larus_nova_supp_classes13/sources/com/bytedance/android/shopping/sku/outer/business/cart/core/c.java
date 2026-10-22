package com.bytedance.android.shopping.sku.outer.business.cart.core;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final a a;
    public final String b;
    public final int c;
    public final SkuParams d;
    public final PageFinder e;
    public final Map<String, Object> f;
    public final float[] g;

    public final String a() {
        uh3.b r0 = this.a.k();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    public final mh3.a b() {
        Map<String, mh3.a> r0 = mh3.a.m;
        return mh3.a.C0219a.c(this.d.getMonitorId());
    }

    public final int e() {
        return this.d.getSceneType();
    }

    public final Map<String, Object> g() {
        return this.a.n();
    }

    public final String c() {
        mh3.a r0 = b();
        if (r0 == null) goto L5;
        com.bytedance.android.shopping.sku.common.monitor.error.a r1 = r0.c;
    L7:
        return (String) com.bytedance.android.shopping.sku.common.utils.b.b(r1, "加购 product_id", this.a.h(), this.d.getProductId());
    L5:
        r1 = null;
        goto L7
    }

    public final String d() {
        mh3.a r0 = b();
        if (r0 == null) goto L5;
        com.bytedance.android.shopping.sku.common.monitor.error.a r1 = r0.c;
    L6:
        String r2 = (String) com.bytedance.android.shopping.sku.common.utils.b.b(r1, "加购 promotion_id", this.a.i(), this.d.getPromotionId());
        if (r2 != null) goto L10;
        return "";
    L10:
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    public final String f() {
        mh3.a r0 = b();
        if (r0 == null) goto L5;
        com.bytedance.android.shopping.sku.common.monitor.error.a r1 = r0.c;
    L7:
        return (String) com.bytedance.android.shopping.sku.common.utils.b.b(r1, "加购 sku_session_id", this.a.l(), this.d.getSkuSessionId());
    L5:
        r1 = null;
        goto L7
    }

    public c(SkuParams r4, PageFinder r5, Map<String, ? extends Object> r6, float[] r7) {
        Intrinsics.checkNotNullParameter(r4, "skuParams");
        Intrinsics.checkNotNullParameter(r5, "btmPageFinder");
        Intrinsics.checkNotNullParameter(r6, "businessParamsMap");
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        r4.getMonitorId();
        int r8 = a.a;
        mh3.a r9 = b();
        Intrinsics.checkNotNullParameter(r6, "params");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        int r11 = t0.a;     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl((a) t0.a.a.fromJson(k.b(r6).toString(), a.class));     // Catch: Throwable -> L5
    L7:
        String r13 = null;
        if (Result.isFailure-impl(r12) == false) goto L25;
        if (r9 == null) goto L19;
        com.bytedance.android.shopping.sku.common.monitor.error.a r14 = r9.c;
        if (r14 == null) goto L19;
        SkuErrorMonitorType r15 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Throwable r0 = Result.exceptionOrNull-impl(r12);
        if (r0 == null) goto L16;
        String r1 = r0.getMessage();
        if (r1 == null) goto L16;
    L17:
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r2 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r14.a(r15, r1, null);
    L16:
        r1 = "";
    L19:
        if (ECAppInfoService.e.i() == false) goto L25;
        Throwable r16 = Result.exceptionOrNull-impl(r12);
        if (r16 == null) goto L23;
        throw r16;
    L23:
        throw new Exception("mapToCartParams数据解析失败");
    L25:
        if (Result.isFailure-impl(r12) == false) goto L27;
        r12 = null;
    L27:
        a r17 = (a) r12;
        if (r17 != null) goto L30;
        r17 = new a(null);
    L30:
        this.a = r17;
        String r18 = r17.b();
        boolean r19 = false;
        if (r18 != null) goto L33;
    L36:
        boolean r3 = true;
    L37:
        if (r3 == false) goto L43;
        mh3.a r20 = b();
        if (r20 == null) goto L43;
        com.bytedance.android.shopping.sku.common.monitor.error.a r21 = r20.c;
        if (r21 == null) goto L43;
        SkuErrorMonitorType r22 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r23 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r21.a(r22, "加购缺少btm参数", null);
    L43:
        if (r18 != null) goto L45;
    L46:
        r19 = true;
    L48:
        if ((!r19) == false) goto L50;
        r13 = r18;
    L50:
        if (r13 != null) goto L52;
        r13 = "a1.b5267.c7323.d1871";
    L52:
        this.b = r13;
        this.c = this.d.getStandardAddCartToastType();
        return;
    L45:
        if (StringsKt.isBlank(r18) == false) goto L48;
    L33:
        if (StringsKt.isBlank(r18) == true) goto L36;
        r3 = false;
    L5:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
