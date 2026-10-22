package com.larus.office.base.permission;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q implements Function1<NoPermissionFragment.a, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<NoPermissionFragment.a> f360667a;

    public q(kotlinx.coroutines.j r100) {
        this.f360667a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(NoPermissionFragment.a r100) {
        NoPermissionFragment.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        if (this.f360667a.isActive() == false) goto L6;
        this.f360667a.resumeWith(Result.m9449constructorimpl(r101));
    L6:
        return Unit.INSTANCE;
    }
}
