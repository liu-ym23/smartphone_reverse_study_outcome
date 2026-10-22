package com.larus.dora.impl.onboarding.othersmart.streamlined;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class l<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraHStreamlinedInterruptFragment f337280a;

    public l(DoraHStreamlinedInterruptFragment r100) {
        this.f337280a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        DoraHStreamlinedInterruptFragment r102 = this.f337280a;
        float r103 = DoraHStreamlinedInterruptFragment.f337187z;
        r102.ha0((o) r100);
        return Unit.INSTANCE;
    }
}
