package com.obric.sva.sdk.lightup;

import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.sva.sdk.lightup.LightUpManager$lightUpSurpress$1$1$1", f = "LightUpManager.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
public final class LightUpManager$lightUpSurpress$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public LightUpManager$lightUpSurpress$1$1$1(Continuation<? super LightUpManager$lightUpSurpress$1$1$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LightUpManager$lightUpSurpress$1$1$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((LightUpManager$lightUpSurpress$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L8;
        if (r102 == 1) goto L8;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
    L9:
        LightUpManager r104 = LightUpManager.INSTANCE;
        if (r104.getSensorCovered().getValue() != SensorState.NA) goto L15;
        LogUtils.d(LightUpManager.TAG, "sensorCovered is NA , wait...", new Object[0]);
        this.label = 1;
        if (DelayKt.delay(100, this) != r101) goto L9;
        return r101;
    L15:
        if (r104.getSensorCovered().getValue() == SensorState.COVERED) goto L19;
        r103 = false;
    L19:
        return Boxing.boxBoolean(r103);
    }
}
