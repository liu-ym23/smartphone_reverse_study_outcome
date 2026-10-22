package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements j, xi.b {
    public final /* synthetic */ xi.b a;

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        this.a.d(r2, r3);
    }

    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.a.e(r2, r3, r4);
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        this.a.i(r2, r3);
    }

    public n(xi.b r2) {
        Intrinsics.checkNotNullParameter(r2, "logService");
        this.a = r2;
    }
}
