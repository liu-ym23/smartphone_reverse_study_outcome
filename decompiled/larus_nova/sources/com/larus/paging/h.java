package com.larus.paging;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes29.dex */
public final class h<T> implements FlowCollector<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SendChannel<T> f363855a;

    public h(b1 r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        this.f363855a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        Object r102 = this.f363855a.send(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}
