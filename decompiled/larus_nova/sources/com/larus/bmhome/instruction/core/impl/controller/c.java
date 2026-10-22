package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import cq8.y;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f311986p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f311987q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f311988r;

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public c() {
        super("CollaboratedMultiFeatureSelectorController");
        this.f311987q = true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new cq8.f(getWidgetId(), this.f311933o, this.f311986p, this.f311926h, this.f311988r);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return this.f311987q;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        return this.f311986p;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void h(Integer r100) {
        this.f311988r = r100;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void m(y r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(r100.a(), getWidgetId()) == true) goto L6;
        return;
    L6:
        if ((r100 instanceof cq8.g) == false) goto L12;
        cq8.g r101 = (cq8.g) r100;
        String r102 = r101.f464839c;
        if (r102 != null) goto L10;
        r102 = this.f311986p;
    L10:
        this.f311986p = r102;
        this.f311987q = r101.f464840d;
        return;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.b) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.b.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        this.f311986p = r100;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "collaborated multi feature selector is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.b) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.b.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r103) != null) goto L13;
        this.f311986p = r100;
        j();
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
