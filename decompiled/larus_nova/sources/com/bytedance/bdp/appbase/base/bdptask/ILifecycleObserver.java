package com.bytedance.bdp.appbase.base.bdptask;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/appbase/base/bdptask/ILifecycleObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "()V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "stateChanged", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public abstract class ILifecycleObserver implements LifecycleEventObserver {
    public ILifecycleObserver() {
    }

    public abstract void stateChanged(LifecycleOwner r100, Lifecycle.Event r101);

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        stateChanged(r100, r101);
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L6;
        r100.getLifecycle().removeObserver(this);
        return;
    }
}
