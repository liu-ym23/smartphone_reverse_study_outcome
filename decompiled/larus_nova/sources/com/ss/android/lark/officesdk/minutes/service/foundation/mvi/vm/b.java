package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes37.dex */
public final class b<S extends l> implements Flow<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<S> f433860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Flow<S> f433861b;

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super S> r100, Continuation<? super Unit> r101) {
        return this.f433861b.collect(r100, r101);
    }

    public b(Function0 r100, a1 r101) {
        Intrinsics.checkNotNullParameter(r100, "currentStateProvider");
        Intrinsics.checkNotNullParameter(r101, "stateFlow");
        this.f433860a = r100;
        this.f433861b = r101;
    }
}
