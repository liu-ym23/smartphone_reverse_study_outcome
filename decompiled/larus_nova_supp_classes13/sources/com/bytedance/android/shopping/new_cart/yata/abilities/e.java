package com.bytedance.android.shopping.new_cart.yata.abilities;

import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final AtomicBoolean a;
    public final CartObjectContainer b;

    public e(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = new AtomicBoolean(false);
    }
}
