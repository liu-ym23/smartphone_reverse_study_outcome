package com.ss.android.ugc.tools.view.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0007H\u0004J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/tools/view/base/HumbleViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "destroyed", "", MapMonitorConst.EVENT_DESTROY, "", "isDestroyed", "observeLifecycle", LiveCommonConstants.REASON_ON_DEDTROY, "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public abstract class HumbleViewModel extends ViewModel implements LifecycleObserver {
    private boolean destroyed;
    private final LifecycleOwner lifecycleOwner;

    private final void destroy() {
        if (this.destroyed == false) goto L5;
        return;
    L5:
        this.destroyed = true;
        onCleared();
    }

    private final void observeLifecycle() {
        if (this.lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        destroy();
        return;
    L6:
        this.lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        destroy();
        this.lifecycleOwner.getLifecycle().removeObserver(this);
    }

    public final boolean isDestroyed() {
        return this.destroyed;
    }

    public HumbleViewModel(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.lifecycleOwner = r100;
        observeLifecycle();
    }
}
