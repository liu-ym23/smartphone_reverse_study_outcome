package com.bytedance.android.shopping.buynow.yata.abilities;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final com.bytedance.android.shopping.buynow.tracker.a a;

    public d(com.bytedance.android.shopping.buynow.tracker.a r2) {
        Intrinsics.checkNotNullParameter(r2, "tracker");
        this.a = r2;
    }

    public final void a(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a.b(r2, r3);
    }
}
