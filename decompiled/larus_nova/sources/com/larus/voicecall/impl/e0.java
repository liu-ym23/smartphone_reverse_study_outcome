package com.larus.voicecall.impl;

import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.voicecall.impl.component.core.r0;
import com.larus.voicecall.impl.component.core.s0;
import com.larus.voicecall.impl.component.core.t0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes32.dex */
public final class e0<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<String> f378345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<AVKitDuplexState> f378346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2<c0, Continuation<? super Unit>, Object> f378347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1<c0, Unit> f378348d;

    public e0(r0 r100, s0 r101, Function2 r102, t0 r103) {
        this.f378345a = r100;
        this.f378346b = r101;
        this.f378347c = r102;
        this.f378348d = r103;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        c0 r102 = (c0) r100;
        if (f0.b(r102, this.f378345a.invoke(), this.f378346b.invoke()) == false) goto L8;
        Object r103 = this.f378347c.invoke(r102, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r103;
    L10:
        return Unit.INSTANCE;
    L8:
        this.f378348d.invoke(r102);
        return Unit.INSTANCE;
    }
}
