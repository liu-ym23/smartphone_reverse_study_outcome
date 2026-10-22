package com.bytedance.android.shopping.sku.outer.business.anchor;

import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.utils.a2;
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
    public final Integer c;
    public final SkuParams d;
    public final Map<String, Object> e;

    public final String a() {
        a r0 = this.a;
        if (r0 == null) goto L9;
        String r1 = r0.a();
        if (r1 == null) goto L9;
        String r2 = a2.d(r1);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return this.d.getDetailUrl();
    }

    public final Map<String, String> b() {
        return this.d.getEventParams();
    }

    public final Map<String, String> c() {
        a r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public c(SkuParams r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "skuParams");
        Intrinsics.checkNotNullParameter(r6, "businessParamsMap");
        this.d = r5;
        this.e = r6;
        int r0 = a.a;
        Map<String, mh3.a> r1 = mh3.a.m;
        mh3.a r7 = mh3.a.C0219a.c(r5.getMonitorId());
        Intrinsics.checkNotNullParameter(r6, "data");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        int r3 = t0.a;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((a) t0.a.a.fromJson(k.b(r6).toString(), a.class));     // Catch: Throwable -> L5
    L7:
        Integer r4 = null;
        if (Result.isFailure-impl(r8) == false) goto L25;
        if (r7 == null) goto L19;
        com.bytedance.android.shopping.sku.common.monitor.error.a r9 = r7.c;
        if (r9 == null) goto L19;
        SkuErrorMonitorType r10 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Throwable r11 = Result.exceptionOrNull-impl(r8);
        if (r11 == null) goto L16;
        String r12 = r11.getMessage();
        if (r12 == null) goto L16;
    L17:
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r13 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r9.a(r10, r12, null);
    L16:
        r12 = "";
    L19:
        if (ECAppInfoService.e.i() == false) goto L25;
        Throwable r14 = Result.exceptionOrNull-impl(r8);
        if (r14 == null) goto L23;
        throw r14;
    L23:
        throw new Exception("mapToAnchorParams数据解析失败");
    L25:
        if (Result.isFailure-impl(r8) == false) goto L27;
        r8 = null;
    L27:
        a r15 = (a) r8;
        if (r15 != null) goto L30;
        r15 = new a(null);
    L30:
        this.a = r15;
        b r16 = r15.b();
        if (r16 == null) goto L33;
        String r17 = r16.a();
    L34:
        this.b = r17;
        b r18 = r15.b();
        if (r18 == null) goto L39;
        String r19 = r18.b();
        if (r19 == null) goto L39;
        r4 = StringsKt.toIntOrNull(r19);
    L39:
        this.c = r4;
        return;
    L33:
        r17 = null;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
