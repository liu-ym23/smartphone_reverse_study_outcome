package com.bytedance.android.shopping.prepurchase.arch.container.lifecycle;

import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/LifecycleDelegate;", "Lcom/bytedance/android/shopping/prepurchase/arch/container/lifecycle/AbsLifecycle;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LifecycleDelegate extends AbsLifecycle {
    public final androidx.lifecycle.LifecycleRegistry a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.AbsLifecycle
    public final androidx.lifecycle.Lifecycle.State f() {
        return this.a.getCurrentState();
    }

    public LifecycleDelegate(Lifecycle r2) {
        Intrinsics.checkNotNullParameter(r2, "realLifecycle");
        LifecycleRegistry r3 = (LifecycleRegistry) r2;
        LifecycleKt.getCoroutineScope(r3.e());
        this.a = r3.e();
    }

    public final void addObserver(LifecycleObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.a.addObserver(r2);
    }

    public final void removeObserver(LifecycleObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.a.removeObserver(r2);
    }
}
