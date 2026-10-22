package com.larus.dora.impl.device.settings.gesture;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public final class GestureSettingsRepository$init$1$1$1$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f334414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GestureSettingsRepository f334415b;

    public GestureSettingsRepository$init$1$1$1$1(CoroutineScope r100, GestureSettingsRepository r101) {
        this.f334414a = r100;
        this.f334415b = r101;
    }

    public final Object a(boolean r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof GestureSettingsRepository$init$1$1$1$1$emit$1) == false) goto L7;
        GestureSettingsRepository$init$1$1$1$1$emit$1 r102 = (GestureSettingsRepository$init$1$1$1$1$emit$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
    L19:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L27;
        g49.d.c("GestureSettingsRepository", "quick note cache rebuild failed.", r108);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        GestureSettingsRepository r109 = this.f334415b;
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        if (GestureSettingsRepository.a(r109, r102) != r105) goto L19;
        return r105;
    L21:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new GestureSettingsRepository$init$1$1$1$1$emit$1(this, r101);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
        return a(((Boolean) r100).booleanValue(), r101);
    }
}
