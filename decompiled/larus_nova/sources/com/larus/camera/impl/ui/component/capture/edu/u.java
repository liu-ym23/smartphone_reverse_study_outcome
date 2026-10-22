package com.larus.camera.impl.ui.component.capture.edu;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes26.dex */
public final class u implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Unit> f321939a;

    public u(kotlinx.coroutines.j r100) {
        this.f321939a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        kotlinx.coroutines.i<Unit> r100 = this.f321939a;
        Result.Companion r101 = Result.Companion;
        Unit r102 = Unit.INSTANCE;
        r100.resumeWith(Result.m9449constructorimpl(r102));
        return r102;
    }
}
