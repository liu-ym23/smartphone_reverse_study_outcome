package com.bytedance.timonkit.media_observer.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/timonkit/media_observer/util/CustomLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "media-observer_release"}, k = 1, mv = {1, 7, 1})
public final class CustomLifecycleOwner implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f270923a;

    public CustomLifecycleOwner() {
        this.f270923a = new LifecycleRegistry(this);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f270923a;
    }
}
