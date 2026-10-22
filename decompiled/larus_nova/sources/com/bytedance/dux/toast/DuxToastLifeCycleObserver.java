package com.bytedance.dux.toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import em4.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/dux/toast/DuxToastLifeCycleObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxToastLifeCycleObserver implements LifecycleEventObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L11;
        k.b(new DuxToastLifeCycleObserver$onStateChanged$1$1(this));     // Catch: Exception -> L6
        Unit r102 = Unit.INSTANCE;     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        k.a("Try exception occur " + e.getMessage());
        Unit r103 = Unit.INSTANCE;
        return;
    }
}
