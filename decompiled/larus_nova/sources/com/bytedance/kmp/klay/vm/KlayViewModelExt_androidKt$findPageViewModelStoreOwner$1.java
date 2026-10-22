package com.bytedance.kmp.klay.vm;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/kmp/klay/vm/KlayViewModelExt_androidKt$findPageViewModelStoreOwner$1", "Landroidx/lifecycle/LifecycleEventObserver;", "klay_release"}, k = 1, mv = {1, 7, 0})
public final class KlayViewModelExt_androidKt$findPageViewModelStoreOwner$1 implements LifecycleEventObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L11;
        PageViewModelStoreOwner r102 = a.f252195a.remove(r100);
        if (r102 == null) goto L10;
        ViewModelStore r103 = r102.f252188b;
        if (r103 == null) goto L10;
        r103.clear();
    L10:
        throw null;
    }
}
