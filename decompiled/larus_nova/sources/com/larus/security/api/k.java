package com.larus.security.api;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public final class k implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Unit> f367860a;

    public k(kotlinx.coroutines.j r100) {
        this.f367860a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        TTCNPAHelper r101 = TTCNPAHelper.f367850a;
        kotlinx.coroutines.i<Unit> r102 = this.f367860a;
        monitor-enter(r101);
        ((ArrayList) TTCNPAHelper.f367853d).remove(r102);     // Catch: Throwable -> L8
        monitor-exit(r101);
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        throw th;
    }
}
