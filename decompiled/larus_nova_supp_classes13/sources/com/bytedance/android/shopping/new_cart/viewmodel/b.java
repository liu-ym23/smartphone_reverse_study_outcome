package com.bytedance.android.shopping.new_cart.viewmodel;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.new_cart.dto.CartMarketingResourceSchemaResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ CartViewModel.g.c a;
    public final /* synthetic */ CartMarketingResourceSchemaResponse b;

    public b(CartViewModel.g.c r1, CartMarketingResourceSchemaResponse r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        String r0 = this.b.getMarketingExpressSchema();
        String r1 = null;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        String r2 = this.b.getMarketingExpressMega();
        if (r2 != null) goto L11;
    L13:
        r2 = null;
    L14:
        if (r0 == null) goto L24;
        if (r2 == null) goto L24;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        HashMap r4 = j.a;     // Catch: Throwable -> L18
        JSONObject r5 = new JSONObject(r2);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r0, "url");     // Catch: Throwable -> L18
        String r6 = UUID.randomUUID().toString();     // Catch: Throwable -> L18
        Uri.Builder r7 = UriProtector.parse(r0).buildUpon();     // Catch: Throwable -> L18
        r7.appendQueryParameter("mega_object_id", r6);     // Catch: Throwable -> L18
        j.a.put(r6, r5);     // Catch: Throwable -> L18
        Object r8 = Result.constructor-impl(r7.build().toString());     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r8) == false) goto L23;
        r8 = null;
    L23:
        String r9 = (String) r8;
    L25:
        String r10 = this.b.getCouponSchema();
        if (r10 != null) goto L28;
    L30:
        if (r9 != null) goto L32;
        String r11 = r1;
    L33:
        if (r11 != null) goto L35;
        return;
    L35:
        if (ECLiveHybridUtil.i(r11) == false) goto L37;
        CartViewModel.g r12 = this.a.a;
        ECLiveHybridUtil.k(r12.b, r11, false, false, CartViewModel.access$isInSplitScreen$p(r12.a), "cart", 92);
        return;
    L37:
        Activity r13 = ECHybridExtensionsKt.a(this.a.a.b);
        if (r13 == null) goto L45;
        p.a.d(r11, r13);
        return;
    L45:
        return;
    L32:
        r11 = r9;
        goto L33
    L28:
        if ((!StringsKt.isBlank(r10)) == false) goto L30;
        r1 = r10;
    L18:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        r9 = null;
        goto L25
    L11:
        if ((!StringsKt.isBlank(r2)) == false) goto L13;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
