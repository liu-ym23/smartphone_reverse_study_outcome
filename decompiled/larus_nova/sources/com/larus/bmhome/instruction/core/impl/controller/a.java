package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends com.larus.bmhome.instruction.core.impl.base.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public wa8.a f311982p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f311983q;

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final boolean a() {
        return true;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 8;
    }

    public a() {
        super("AvatarButtonController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new cq8.a(getWidgetId(), this.f311933o, g(), this.f311926h, this.f311983q);
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final String g() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(wa8.a.Companion.serializer()), this.f311982p));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        return (String) r101;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public final void h(Integer r100) {
        this.f311983q = r100;
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.e
    public final wa8.a0 n(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl((wa8.a) xt7.d.f565073b.c(wa8.a.Companion.serializer(), r100));     // Catch: Throwable -> L13
    L15:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 != null) goto L20;
        this.f311982p = (wa8.a) r103;
        return new wa8.a0(Boolean.TRUE, "");
    L20:
        return new wa8.a0(Boolean.FALSE, r104.getMessage());
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L10:
        return new wa8.a0(Boolean.FALSE, "avatar template instruction item is empty");
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }
}
