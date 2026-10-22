package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b implements r {
    public final AtomicBoolean a;
    public final String b;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.r
    public final void t() {
        if (this.a.get() == true) goto L6;
        run();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.r
    public final String getName() {
        return this.b;
    }

    public b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.b = r2;
        this.a = new AtomicBoolean(false);
    }
}
