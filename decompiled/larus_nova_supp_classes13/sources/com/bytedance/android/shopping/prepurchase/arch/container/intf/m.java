package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements xi.b {
    public final Lazy a;

    public m(final Biz r2, final c r3) {
        Intrinsics.checkNotNullParameter(r2, "bizCode");
        Intrinsics.checkNotNullParameter(r3, "fallback");
        this.a = LazyKt.lazy(new SplitAlogService$base$2(r2, r3));
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        ((xi.b) this.a.getValue()).d(r2, r3);
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        ((xi.b) this.a.getValue()).i(r2, r3);
    }

    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        ((xi.b) this.a.getValue()).e(r2, r3, r4);
    }
}
