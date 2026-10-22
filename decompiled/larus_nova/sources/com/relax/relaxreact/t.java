package com.relax.relaxreact;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FiberType f405583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f405584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SnapshotInstance f405585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o1 f405586d;

    public final SnapshotInstance a() {
        SnapshotInstance r100 = this.f405585c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("el");
        return null;
    }

    public final o1 b() {
        o1 r100 = this.f405586d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("vnode");
        return null;
    }

    public final FiberType getType() {
        return this.f405583a;
    }

    public t(FiberType r100, SnapshotInstance r101, o1 r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "el");
        Intrinsics.checkNotNullParameter(r102, "vnode");
        this.f405583a = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f405585c = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f405586d = r102;
    }
}
