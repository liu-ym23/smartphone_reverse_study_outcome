package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/LifecycleOwnerDelegate;", "Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/AbsLifecycleOwner;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LifecycleOwnerDelegate extends AbsLifecycleOwner {
    public final LifecycleDelegate a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.AbsLifecycleOwner
    public final androidx.lifecycle.Lifecycle getLifecycleCompat() {
        return this.a;
    }

    public LifecycleOwnerDelegate(e r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        this.a = new LifecycleDelegate(r2.getLifecycle());
    }
}
