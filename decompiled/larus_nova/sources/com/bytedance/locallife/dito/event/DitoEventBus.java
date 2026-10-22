package com.bytedance.locallife.dito.event;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class DitoEventBus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f258272a;

    public DitoEventBus() {
        this.f258272a = LazyKt.lazy(new DitoEventBus$destroyObserver$2(this));
    }
}
