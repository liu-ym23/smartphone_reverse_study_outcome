package com.bytedance.android.shopping.sku.outer.business.confirm;

import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import uh3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final a a;
    public final SkuParams b;
    public final Map<String, Object> c;

    public final Long a() {
        String r0 = this.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toLongOrNull(r0);
    }

    public final String b() {
        return this.a.b();
    }

    public final String c() {
        return this.a.c();
    }

    public final long d() {
        uh3.b r0 = this.a.d();
        if (r0 == null) goto L7;
        Long r1 = r0.b();
        if (r1 == null) goto L7;
        return r1.longValue();
    L7:
        return 0;
    }

    public final String e() {
        uh3.b r0 = this.a.d();
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L19;
        uh3.b r3 = this.a.d();
        if (r3 == null) goto L26;
        String r4 = r3.c();
        if (r4 != null) goto L25;
        return "";
    L25:
        return r4;
    L26:
        return "";
    L19:
        uh3.b r5 = this.a.d();
        if (r5 == null) goto L27;
        r4 = r5.e();
        if (r4 != null) goto L25;
        return "";
    L27:
        return "";
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final Long f() {
        uh3.b r0 = this.a.d();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    public final String g() {
        uh3.b r0 = this.a.d();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    public final List<c> h() {
        return this.a.e();
    }

    public final Map<String, Object> i() {
        return this.a.f();
    }

    public b(SkuParams r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r5, "skuParams");
        Intrinsics.checkNotNullParameter(r6, "businessParamsMap");
        this.b = r5;
        this.c = r6;
        int r0 = a.a;
        Map<String, mh3.a> r1 = mh3.a.m;
        mh3.a r7 = mh3.a.C0219a.c(r5.getMonitorId());
        Intrinsics.checkNotNullParameter(r6, "params");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        int r3 = t0.a;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((a) t0.a.a.fromJson(k.b(r6).toString(), a.class));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r8) == false) goto L25;
        if (r7 == null) goto L19;
        com.bytedance.android.shopping.sku.common.monitor.error.a r9 = r7.c;
        if (r9 == null) goto L19;
        SkuErrorMonitorType r4 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Throwable r10 = Result.exceptionOrNull-impl(r8);
        if (r10 == null) goto L16;
        String r11 = r10.getMessage();
        if (r11 == null) goto L16;
    L17:
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r12 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r9.a(r4, r11, null);
    L16:
        r11 = "";
    L19:
        if (ECAppInfoService.e.i() == false) goto L25;
        Throwable r13 = Result.exceptionOrNull-impl(r8);
        if (r13 == null) goto L23;
        throw r13;
    L23:
        throw new Exception("mapToConfirmParams数据解析失败");
    L25:
        if (Result.isFailure-impl(r8) == false) goto L27;
        r8 = null;
    L27:
        a r14 = (a) r8;
        if (r14 != null) goto L30;
        r14 = new a(null);
    L30:
        this.a = r14;
        return;
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
