package com.larus.audio;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes24.dex */
public final class y<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f290172a;

    public y(com.larus.bmhome.chat.component.title.o1 r100) {
        this.f290172a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        ((Number) r100).intValue();
        this.f290172a.invoke();
        return Unit.INSTANCE;
    }
}
