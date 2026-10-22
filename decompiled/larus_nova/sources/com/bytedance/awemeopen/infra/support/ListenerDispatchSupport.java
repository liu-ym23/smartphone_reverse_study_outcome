package com.bytedance.awemeopen.infra.support;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes46.dex */
public final class ListenerDispatchSupport<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f198939a;

    public ListenerDispatchSupport() {
        this.f198939a = LazyKt.lazy(ListenerDispatchSupport$listeners$2.INSTANCE);
    }
}
