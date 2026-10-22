package com.ss.android.lark.forwardv3.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/forwardv3/utils/ForwardDialogContentLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "start", "", MapMonitorConst.EVENT_DESTROY, "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardDialogContentLifecycleOwner implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f425567a;

    public ForwardDialogContentLifecycleOwner() {
        LifecycleRegistry r100 = new LifecycleRegistry(this);
        r100.setCurrentState(Lifecycle.State.CREATED);
        this.f425567a = r100;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f425567a;
    }
}
