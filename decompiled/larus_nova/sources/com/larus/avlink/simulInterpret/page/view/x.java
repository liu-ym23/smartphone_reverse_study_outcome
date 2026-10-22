package com.larus.avlink.simulInterpret.page.view;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class x implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimultaneousInterpretFragment f294661a;

    public /* synthetic */ x(SimultaneousInterpretFragment r100) {
        this.f294661a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        SimultaneousInterpretFragment r100 = this.f294661a;
        int r101 = SimultaneousInterpretFragment.f294600s;
        r100.X90().updateScreenMode(com.larus.avlink.simulInterpret.page.model.b.a.f294497a);
        return Unit.INSTANCE;
    }
}
