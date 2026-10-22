package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import cq8.p0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public wa8.u f312013p;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public q() {
        super("ReferenceImageUploadController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new p0(getWidgetId(), this.f311933o, this.f312013p);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Object r100 = null;
        if (this.f312013p != null) goto L15;
        return null;
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(wa8.u.Companion.serializer()), this.f312013p));     // Catch: Throwable -> L7
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
        Object r103 = Result.m9449constructorimpl((wa8.u) xt7.d.f565073b.c(wa8.u.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        this.f312013p = (wa8.u) r103;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "reference image upload is empty template");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((wa8.u) xt7.d.f565073b.c(wa8.u.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        wa8.u r104 = (wa8.u) r103;
        if (r104 != null) goto L13;
        return;
    L13:
        wa8.b r105 = r104.f558890a;
        if (r105 == null) goto L18;
        wa8.u r106 = this.f312013p;
        if (r106 == null) goto L18;
        r106.f558890a = r105;
    L18:
        wa8.p r107 = r104.f558891b;
        if (r107 == null) goto L26;
        wa8.u r108 = this.f312013p;
        if (r108 == null) goto L27;
        r108.f558891b = r107;
        return;
    L27:
        return;
    L26:
        return;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
