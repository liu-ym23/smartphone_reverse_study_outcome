package com.larus.ui.arch.vm;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/larus/ui/arch/vm/EmptyLifecycle;", "Landroidx/lifecycle/Lifecycle;", "<init>", "()V", "currentState", "Landroidx/lifecycle/Lifecycle$State;", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyLifecycle extends Lifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EmptyLifecycle f375184a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lifecycle.State f375185b = null;

    @Override // androidx.lifecycle.Lifecycle
    public final void addObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void removeObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
    }

    static {
        f375184a = new EmptyLifecycle();
        f375185b = Lifecycle.State.DESTROYED;
    }

    private EmptyLifecycle() {
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Lifecycle.State getCurrentState() {
        return f375185b;
    }
}
