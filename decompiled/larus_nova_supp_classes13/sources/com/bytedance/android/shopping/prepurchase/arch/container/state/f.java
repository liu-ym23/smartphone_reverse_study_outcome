package com.bytedance.android.shopping.prepurchase.arch.container.state;

import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleOwnerDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static final LifecycleOwnerDelegate a(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toAndroidLifecycleOwner");
        return new LifecycleOwnerDelegate(r1);
    }
}
