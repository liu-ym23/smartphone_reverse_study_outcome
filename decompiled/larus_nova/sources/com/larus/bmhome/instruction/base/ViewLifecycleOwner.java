package com.larus.bmhome.instruction.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import kotlin.Metadata;
import up8.e;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/instruction/base/ViewLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "parentLifecycle", "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "parentLifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", NewBroadcastMonitor.STAGE.LIFECYCLE, "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "onAttached", "", "onDetached", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ViewLifecycleOwner implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f311898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleRegistry f311899b;

    public ViewLifecycleOwner() {
        this(null);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f311899b;
    }

    public ViewLifecycleOwner(Lifecycle r100) {
        this.f311898a = r100;
        this.f311899b = new LifecycleRegistry(this);
        LifecycleEventObserver r101 = new e(this);
        if (r100 == null) goto L6;
        r100.addObserver(r101);
        return;
    }
}
