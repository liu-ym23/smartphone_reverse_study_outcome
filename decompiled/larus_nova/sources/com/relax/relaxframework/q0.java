package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventCancelType f405224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f405225b;

    public q0(EventCancelType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "cancelType");
        this.f405224a = EventCancelType.NotCanceled;
        this.f405224a = r100;
        this.f405225b = r101;
    }
}
