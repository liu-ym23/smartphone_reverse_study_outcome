package com.larus.office.plugins.inputv2.coordinator.runtime.interaction;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes30.dex */
public final class g implements Function1<Boolean, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i<Boolean> f362968a;

    public g(j r100) {
        this.f362968a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Boolean r100) {
        boolean r101 = r100.booleanValue();
        if (this.f362968a.isActive() == false) goto L6;
        Boolean r102 = Boolean.valueOf(r101);
        this.f362968a.resumeWith(Result.m9449constructorimpl(r102));
    L6:
        return Unit.INSTANCE;
    }
}
