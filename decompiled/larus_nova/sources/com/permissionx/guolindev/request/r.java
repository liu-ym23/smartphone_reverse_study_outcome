package com.permissionx.guolindev.request;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f404391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f404392b;

    public r() {
    }

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (this.f404391a != null) goto L5;
        this.f404391a = r100;
    L5:
        a r101 = this.f404392b;
        if (r101 == null) goto L9;
        r101.f404365b = r100;
    L9:
        this.f404392b = r100;
    }
}
