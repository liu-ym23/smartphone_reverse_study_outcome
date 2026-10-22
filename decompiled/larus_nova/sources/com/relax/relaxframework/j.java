package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BackgroundImageType___0 f405143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f405144b;

    public final BackgroundImageType___0 getType() {
        return this.f405143a;
    }

    public j(BackgroundImageType___0 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f405143a = r100;
        this.f405144b = r101;
    }
}
