package com.bytedance.android.shopping.store.hybrid.csp;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECStoreCspHelper {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(l r4, final String r5) {
        Intrinsics.checkNotNullParameter(r4, "hybridComponent");
        Lazy r0 = ECStoreSettings.a;
        int r1 = p.a;
        Object r2 = Boolean.TRUE;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r6 = jj4.b.b;     // Catch: Throwable -> L7
        Object r7 = jj4.a.a("ec_shop_scc_interceptor_enable", Boolean.class, r2, false);     // Catch: Throwable -> L7
        if (r7 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        if (((Boolean) r7).booleanValue() == true) goto L16;
        return;
    L16:
        int r8 = com.bytedance.android.ec.core.hybrid.a.a;
        Intrinsics.checkNotNullParameter(r4, "target");
        Function1<JSONObject, Unit> r9 = new ECStoreCspHelper$openInterceptAbility$$inlined$let$lambda$1(r5);
        Intrinsics.checkNotNullParameter(r4, "target");
        Intrinsics.checkNotNullParameter(r9, "listener");
        return;
    L7:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Object r11 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r11) == true) goto L12;
        r2 = r11;
    L12:
        r7 = r2;
        goto L14
    }
}
