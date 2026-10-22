package com.bytedance.android.shopping.new_cart.widgets;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l extends com.bytedance.android.shopping.card_list.components.c {
    public final LifecycleOwner b;

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.b;
    }

    public l(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        super(r2);
        this.b = r2;
    }
}
