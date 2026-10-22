package com.bytedance.locallife.live.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/live/viewmodel/LiveLocalLifeRoomLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeRoomLifecycleOwner implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f260837a;

    public final LifecycleRegistry a() {
        return (LifecycleRegistry) this.f260837a.getValue();
    }

    public LiveLocalLifeRoomLifecycleOwner() {
        this.f260837a = LazyKt.lazy(new LiveLocalLifeRoomLifecycleOwner$registry$2(this));
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return a();
    }
}
