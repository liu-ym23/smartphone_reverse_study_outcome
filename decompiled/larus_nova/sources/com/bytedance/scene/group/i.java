package com.bytedance.scene.group;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LifecycleRegistry f268727a;

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        if (this.f268727a != null) goto L6;
        this.f268727a = new LifecycleRegistry(this);
    L6:
        return this.f268727a;
    }

    public i() {
        this.f268727a = null;
    }

    public final void a(Lifecycle.Event r100) {
        if (this.f268727a != null) goto L5;
        this.f268727a = new LifecycleRegistry(this);
    L5:
        this.f268727a.handleLifecycleEvent(r100);
    }
}
