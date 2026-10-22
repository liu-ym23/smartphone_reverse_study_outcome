package com.larus.camera.impl.vlm;

import ix8.c;
import ix8.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.vlm.VLMIntentDetectRepository$requestDetect$2$1", f = "VLMIntentDetectRepository.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class VLMIntentDetectRepository$requestDetect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d>, Object> {
    final /* synthetic */ c $request;
    final /* synthetic */ a $tracker;
    int label;

    public VLMIntentDetectRepository$requestDetect$2$1(c r100, a r101, Continuation<? super VLMIntentDetectRepository$requestDetect$2$1> r102) {
        this.$request = r100;
        this.$tracker = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VLMIntentDetectRepository$requestDetect$2$1(this.$request, this.$tracker, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super d> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super d> r101) {
        return ((VLMIntentDetectRepository$requestDetect$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        VLMIntentDetectRepository r103 = VLMIntentDetectRepository.f322806a;
        c r104 = this.$request;
        a r105 = this.$tracker;
        this.label = 1;
        r100 = r103.c(r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
