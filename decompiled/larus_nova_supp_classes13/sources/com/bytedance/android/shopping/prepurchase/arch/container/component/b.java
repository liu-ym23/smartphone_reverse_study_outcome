package com.bytedance.android.shopping.prepurchase.arch.container.component;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final void a(AbsComponent<?, ?> r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$logD");
        Intrinsics.checkNotNullParameter(r2, "message");
        r1.O1().w7().d(r1.getClass().getSimpleName(), r2);
    }

    public static final void c(AbsComponent<?, ?> r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$logI");
        Intrinsics.checkNotNullParameter(r2, "message");
        r1.O1().w7().i(r1.getClass().getSimpleName(), r2);
    }

    public static final void b(AbsComponent<?, ?> r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$logE");
        Intrinsics.checkNotNullParameter(r2, "message");
        r1.O1().w7().e(r1.getClass().getSimpleName(), r2, r3);
    }
}
