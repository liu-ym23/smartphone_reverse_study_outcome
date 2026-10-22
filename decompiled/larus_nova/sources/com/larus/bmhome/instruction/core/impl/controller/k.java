package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import cq8.x;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class k extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.p f312000p;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 3;
    }

    public k() {
        super("InputBoxController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        com.larus.bmhome.actionbar.model.p r100 = this.f312000p;
        if (r100 == null) goto L5;
        boolean r101 = Intrinsics.areEqual(r100.f295362b, Boolean.TRUE);
    L6:
        if (r101 == true) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new x(getWidgetId(), this.f311933o, this.f312000p);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r100 = null;
        if (this.f312000p != null) goto L15;
        return null;
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.p.Companion.serializer()), this.f312000p));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == true) goto L14;
        r100 = r102;
    L14:
        return (String) r100;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.p) xt7.d.f565073b.c(kuc.a.d(com.larus.bmhome.actionbar.model.p.Companion.serializer()), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        this.f312000p = (com.larus.bmhome.actionbar.model.p) r103;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "input box is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.p) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.p.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.p r104 = (com.larus.bmhome.actionbar.model.p) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        this.f312000p = r104;
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
