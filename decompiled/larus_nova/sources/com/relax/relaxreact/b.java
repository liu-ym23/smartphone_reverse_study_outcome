package com.relax.relaxreact;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f405464e;

    public b(SnapshotInstance r100, g r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "el");
        Intrinsics.checkNotNullParameter(r101, "vnode");
        Intrinsics.checkNotNullParameter(r102, "component");
        super(FiberType.Component, r100, r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405464e = r102;
        r102.f405478e = this;
    }
}
