package com.bytedance.android.shopping.widget.ecvideoplayer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends j {
    @Override // com.bytedance.android.shopping.widget.ecvideoplayer.j
    public final void a() {
        int r0 = a.a;
        StringBuilder r1 = new StringBuilder("PlayerTaskExecutor");
        k r2 = this.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("playerTaskExecutor");
    L5:
        r1.append(r2.hashCode());
        r1.append(" run ");
        r1.append(b());
        a.a(r1.toString());
    }

    public f(int r1) {
        super(r1);
    }
}
