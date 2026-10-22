package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements xi.b {
    public final Biz a;

    public c(Biz r2) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        this.a = r2;
    }

    public final void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        dm.a.b r0 = dm.a.a;
        dm.a.a(this.a.getValue() + '_' + r3).a(r4);
    }

    public final void i(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        dm.a.b r0 = dm.a.a;
        dm.a.a(this.a.getValue() + '_' + r3).i(r4);
    }

    public final void e(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        dm.a.b r0 = dm.a.a;
        dm.a.a(this.a.getValue() + '_' + r3).b(r4, r5);
    }
}
