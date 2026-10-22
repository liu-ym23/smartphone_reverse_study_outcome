package com.bytedance.android.shopping.sku.common.utils;

import android.net.Uri;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final void a(String r1, Function1<? super Uri, Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$skuCheckUriValid");
        Intrinsics.checkNotNullParameter(r2, "validCallback");
        Intrinsics.checkNotNullParameter(r3, "invalidCallback");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(UriProtector.parse(r1));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r4) == false) goto L10;
        Object r5 = null;
    L11:
        Uri r6 = (Uri) r5;
        if (Result.isSuccess-impl(r4) == false) goto L15;
        if (r6 == null) goto L15;
        r2.invoke(r6);
        return;
    L15:
        r3.invoke();
        return;
    L10:
        r5 = r4;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final <T> T b(com.bytedance.android.shopping.sku.common.monitor.error.a r3, String r4, T r5, T r6) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        boolean r0 = true;
        if (r5 == null) goto L5;
        boolean r1 = r5 instanceof String;
    L6:
        if (r1 == false) goto L31;
        if (r6 == null) goto L9;
        boolean r2 = r6 instanceof String;
    L10:
        if (r2 == false) goto L31;
        CharSequence r7 = (CharSequence) r5;
        if (r7 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == false) goto L28;
        CharSequence r9 = (CharSequence) r6;
        if (r9 != null) goto L22;
    L25:
        boolean r10 = true;
    L26:
        if (r10 == false) goto L28;
    L32:
        if (r0 == true) goto L35;
        if (r3 == null) goto L35;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r11 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r3.a(SkuErrorMonitorType.SERVER_BUSINESS_ERROR, r4 + " 值不等  input:" + r5 + "  fallback:" + r6, null);
    L35:
        if (r5 == null) goto L37;
        return r5;
    L37:
        return r6;
    L22:
        if (r9.length() == 0) goto L25;
        r10 = false;
    L28:
        if (Intrinsics.areEqual(r5, r6) == true) goto L32;
        r0 = false;
        goto L32
    L14:
        if (r7.length() == 0) goto L17;
        r8 = false;
        goto L18
    L9:
        r2 = true;
    L31:
        r0 = Intrinsics.areEqual(r5, r6);
        goto L32
    L5:
        r1 = true;
        goto L6
    }
}
