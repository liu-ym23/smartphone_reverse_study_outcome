package com.bytedance.android.shopping.collect.container;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final CollectYataQueryFrom a;
    public final com.bytedance.kmp.ec.yata.common.protocol.data.e b;

    public d(CollectYataQueryFrom r2, com.bytedance.kmp.ec.yata.common.protocol.data.e r3) {
        Intrinsics.checkNotNullParameter(r2, "queryFrom");
        Intrinsics.checkNotNullParameter(r3, "response");
        this.a = r2;
        this.b = r3;
    }
}
