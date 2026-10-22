package com.larus.uaigc.helper;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class p implements Function1<String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<String> f373051a;

    public p(kotlinx.coroutines.j r100) {
        this.f373051a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String r100) {
        String r101 = r100;
        if (this.f373051a.isActive() == false) goto L6;
        this.f373051a.resumeWith(Result.m9449constructorimpl(r101));
    L6:
        return Unit.INSTANCE;
    }
}
