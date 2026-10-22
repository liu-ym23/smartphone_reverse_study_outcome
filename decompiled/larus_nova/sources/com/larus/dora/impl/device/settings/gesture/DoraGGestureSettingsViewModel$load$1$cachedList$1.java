package com.larus.dora.impl.device.settings.gesture;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsViewModel$load$1$cachedList$1", f = "DoraGGestureSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGGestureSettingsViewModel$load$1$cachedList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DoraGGestureSettings>>, Object> {
    int label;

    public DoraGGestureSettingsViewModel$load$1$cachedList$1(Continuation<? super DoraGGestureSettingsViewModel$load$1$cachedList$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraGGestureSettingsViewModel$load$1$cachedList$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<? extends DoraGGestureSettings>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super List<DoraGGestureSettings>> r101) {
        return ((DoraGGestureSettingsViewModel$load$1$cachedList$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return DoraGGestureSettingsRepository.f334370a.e();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
