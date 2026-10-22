package com.bytedance.locallife.cube.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements t36.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y36.a f257238a;

    public e() {
    }

    @Override // t36.f
    public final void a(t36.d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        y36.a r101 = new y36.a(r100, "enable_prefetch", Boolean.FALSE);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f257238a = r101;
    }
}
