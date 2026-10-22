package com.larus.account.saas.jsb.core;

import kotlin.jvm.internal.Intrinsics;
import y38.y;

/* JADX INFO: loaded from: classes24.dex */
public final class g implements x38.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x38.g<FlowAccountUnbindCore.a> f286394a;

    public g(y r100) {
        this.f286394a = r100;
    }

    @Override // x38.b
    public final void a(b48.c r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f286394a.onSuccess(new FlowAccountUnbindCore.a(0, Integer.valueOf(r100.f17601a), r100.f17602b));
    }

    @Override // x38.b
    public final void b(b48.g r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f286394a.onSuccess(new FlowAccountUnbindCore.a(1, 0, ""));
    }
}
