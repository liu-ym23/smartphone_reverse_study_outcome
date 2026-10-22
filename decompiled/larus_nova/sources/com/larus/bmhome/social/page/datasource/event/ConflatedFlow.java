package com.larus.bmhome.social.page.datasource.event;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class ConflatedFlow<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f314025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateFlowImpl f314026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConflatedFlow$special$$inlined$mapNotNull$1 f314027c;

    public final T a() {
        return (T) ((Pair) this.f314026b.getValue()).getSecond();
    }

    public ConflatedFlow(T r100) {
        this.f314025a = r100;
        StateFlowImpl r101 = j1.a(TuplesKt.to(Integer.MIN_VALUE, r100));
        this.f314026b = r101;
        this.f314027c = new ConflatedFlow$special$$inlined$mapNotNull$1(r101);
    }

    public final void b(T r100) {
        StateFlowImpl r101 = this.f314026b;
        r101.setValue(new Pair(Integer.valueOf(((Number) ((Pair) r101.getValue()).getFirst()).intValue() + 1), r100));
    }
}
