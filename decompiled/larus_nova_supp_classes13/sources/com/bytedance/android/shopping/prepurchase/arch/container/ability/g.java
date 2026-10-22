package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final void a(f r1, String r2, ti.j r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$registerLynxHandler");
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "subscriber");
        r1.D0().l0(r2, false, r3);
    }

    public static final void c(f r1, String r2, ti.j r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$unregisterLynxHandler");
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "subscriber");
        r1.D0().F0(r2, r3);
    }

    public static final void b(f r1, String r2, boolean r3, Function1<? super JSONObject, Unit> r4) {
        Intrinsics.checkNotNullParameter(r1, "$this$registerLynxHandler");
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r4, "subscriber");
        r1.D0().h0(r2, r3, r4);
    }
}
