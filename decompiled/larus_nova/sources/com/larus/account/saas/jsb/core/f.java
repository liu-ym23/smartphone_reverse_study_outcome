package com.larus.account.saas.jsb.core;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import y38.o;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements x38.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x38.g<Unit> f286393a;

    public f(o r100) {
        this.f286393a = r100;
    }

    @Override // x38.c
    public final void a(b48.c r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        x38.g<Unit> r101 = this.f286393a;
        FlowAccountMobileSmsLoginCore.Error r102 = FlowAccountMobileSmsLoginCore.Error.LOGIN_FAILED;
        int r103 = r102.getCode();
        String r104 = r100.f17602b;
        if (r104 != null) goto L5;
        r104 = r102.getMessage();
    L5:
        r101.a(new x38.a(r103, r104, null));
    }

    @Override // x38.c
    public final void b(b48.f r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f286393a.onSuccess(Unit.INSTANCE);
    }
}
