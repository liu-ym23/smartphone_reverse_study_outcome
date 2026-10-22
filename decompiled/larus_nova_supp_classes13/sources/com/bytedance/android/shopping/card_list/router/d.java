package com.bytedance.android.shopping.card_list.router;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final String a;
    public final com.bytedance.kmp.ec.yata.common.protocol.data.e b;

    public d(String r3, com.bytedance.kmp.ec.yata.common.protocol.data.e r4) {
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter("first_enter", "queryScene");
        this.a = r3;
        this.b = r4;
    }
}
