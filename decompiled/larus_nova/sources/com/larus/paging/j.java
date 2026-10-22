package com.larus.paging;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes29.dex */
public final class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f363863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConflatedEventBus$special$$inlined$mapNotNull$1 f363864b;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.paging.ConflatedEventBus$special$$inlined$mapNotNull$1] */
    public j(int r100) {
        final StateFlowImpl r101 = j1.a(new Pair(Integer.MIN_VALUE, null));
        this.f363863a = r101;
        this.f363864b = new ConflatedEventBus$special$$inlined$mapNotNull$1(r101);
    }

    public final void a(T r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        StateFlowImpl r101 = this.f363863a;
        r101.setValue(new Pair(Integer.valueOf(((Number) ((Pair) r101.getValue()).getFirst()).intValue() + 1), r100));
    }
}
