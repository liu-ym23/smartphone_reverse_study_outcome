package com.bytedance.android.shopping.new_cart.router;

import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final String a;
    public final e b;

    public a(String r3, e r4) {
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter("first_enter", "queryScene");
        this.a = r3;
        this.b = r4;
    }
}
