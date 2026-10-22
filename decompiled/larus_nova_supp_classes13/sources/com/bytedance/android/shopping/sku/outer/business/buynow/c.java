package com.bytedance.android.shopping.sku.outer.business.buynow;

import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECAdLogExtra;
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
    public final b a;
    public final SkuParams b;
    public final String c;
    public final Map<String, Object> d;
    public final boolean e;

    public final ECAdLogExtra a() {
        return this.b.getAdLogExtra();
    }

    public final String b() {
        b r0 = this.a;
        if (r0 == null) goto L7;
        uh3.b r1 = r0.k();
        if (r1 == null) goto L7;
        return r1.h();
    L7:
        return null;
    }

    public final Long c() {
        b r0 = this.a;
        if (r0 == null) goto L7;
        String r1 = r0.a();
        if (r1 == null) goto L7;
        return StringsKt.toLongOrNull(r1);
    L7:
        return null;
    }

    public final Map<String, String> d() {
        return this.b.getEventParams();
    }

    public final String e() {
        if (this.e == true) goto L16;
        b r0 = this.a;
        if (r0 == null) goto L15;
        String r1 = r0.f();
        if (r1 == null) goto L15;
        if ((!StringsKt.isBlank(r1)) == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L15;
        return r1;
    L15:
        return this.b.getH5Url();
    L16:
        return this.b.getH5Url();
    }

    public final String f() {
        if (this.e == true) goto L14;
        Map<String, mh3.a> r0 = mh3.a.m;
        mh3.a r1 = mh3.a.C0219a.c(this.b.getMonitorId());
        String r2 = null;
        if (r1 == null) goto L8;
        com.bytedance.android.shopping.sku.common.monitor.error.a r3 = r1.c;
    L9:
        b r4 = this.a;
        if (r4 == null) goto L13;
        r2 = r4.h();
    L13:
        return (String) com.bytedance.android.shopping.sku.common.utils.b.b(r3, "提单   product_id", r2, this.b.getProductId());
    L8:
        r3 = null;
        goto L9
    L14:
        return this.b.getProductId();
    }

    public final String g() {
        if (this.e == true) goto L16;
        Map<String, mh3.a> r0 = mh3.a.m;
        mh3.a r1 = mh3.a.C0219a.c(this.b.getMonitorId());
        String r2 = null;
        if (r1 == null) goto L8;
        com.bytedance.android.shopping.sku.common.monitor.error.a r3 = r1.c;
    L9:
        b r4 = this.a;
        if (r4 == null) goto L12;
        r2 = r4.j();
    L12:
        String r5 = (String) com.bytedance.android.shopping.sku.common.utils.b.b(r3, "提单   promotion_id", r2, this.b.getPromotionId());
        if (r5 != null) goto L17;
        return "";
    L17:
        return r5;
    L8:
        r3 = null;
        goto L9
    L16:
        return this.b.getPromotionId();
    }

    public final Long h() {
        b r0 = this.a;
        if (r0 == null) goto L7;
        uh3.b r1 = r0.k();
        if (r1 == null) goto L7;
        return r1.d();
    L7:
        return null;
    }

    public c(SkuParams r3, String r4, Map<String, ? extends Object> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "skuParams");
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        int r7 = b.a;
        Map<String, mh3.a> r8 = mh3.a.m;
        mh3.a r9 = mh3.a.C0219a.c(r3.getMonitorId());
        b r10 = null;
        Object r11 = null;
        if (r5 != null) goto L33;
    L31:
        this.a = r10;
        return;
    L33:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L7
        int r13 = t0.a;     // Catch: Throwable -> L7
        Object r14 = Result.constructor-impl((b) t0.a.a.fromJson(k.b(r5).toString(), b.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r14) == false) goto L27;
        if (r9 == null) goto L21;
        com.bytedance.android.shopping.sku.common.monitor.error.a r15 = r9.c;
        if (r15 == null) goto L21;
        SkuErrorMonitorType r16 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Throwable r0 = Result.exceptionOrNull-impl(r14);
        if (r0 == null) goto L18;
        String r1 = r0.getMessage();
        if (r1 == null) goto L18;
    L19:
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r2 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r15.a(r16, r1, null);
    L18:
        r1 = "";
    L21:
        if (ECAppInfoService.e.i() == false) goto L27;
        Throwable r17 = Result.exceptionOrNull-impl(r14);
        if (r17 == null) goto L25;
        throw r17;
    L25:
        throw new Exception("mapToSkuBuyNowParams数据解析失败");
    L27:
        if (Result.isFailure-impl(r14) == true) goto L30;
        r11 = r14;
    L30:
        r10 = (b) r11;
    L7:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
