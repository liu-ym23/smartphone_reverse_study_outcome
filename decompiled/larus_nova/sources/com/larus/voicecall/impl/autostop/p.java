package com.larus.voicecall.impl.autostop;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class p implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AutoStopAsrServiceImpl f377161a;

    public /* synthetic */ p(AutoStopAsrServiceImpl r100) {
        this.f377161a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        AutoStopAsrServiceImpl r101 = this.f377161a;
        Throwable r102 = (Throwable) r100;
        Object r103 = r101.f377118b;
        monitor-enter(r103);
        r101.f377119c = AutoStopAsrServiceImpl.LifecycleState.RELEASED;     // Catch: Throwable -> L8
        monitor-exit(r103);
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        throw th;
    }
}
