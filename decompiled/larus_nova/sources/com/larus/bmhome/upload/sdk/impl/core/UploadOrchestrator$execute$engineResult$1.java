package com.larus.bmhome.upload.sdk.impl.core;

import is8.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "progress", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.core.UploadOrchestrator$execute$engineResult$1", f = "UploadOrchestrator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UploadOrchestrator$execute$engineResult$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $registry;
    final /* synthetic */ is8.a $route;
    final /* synthetic */ String $taskId;
    /* synthetic */ int I$0;
    int label;

    public UploadOrchestrator$execute$engineResult$1(e r100, String r101, is8.a r102, Continuation<? super UploadOrchestrator$execute$engineResult$1> r103) {
        this.$registry = r100;
        this.$taskId = r101;
        this.$route = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        UploadOrchestrator$execute$engineResult$1 r102 = new UploadOrchestrator$execute$engineResult$1(this.$registry, this.$taskId, this.$route, r101);
        r102.I$0 = ((Number) r100).intValue();
        return r102;
    }

    public final Object invoke(int r100, Continuation<? super Unit> r101) {
        return ((UploadOrchestrator$execute$engineResult$1) create(Integer.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer r100, Continuation<? super Unit> r101) {
        return invoke(r100.intValue(), r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        int r101 = this.I$0;
        this.$registry.a(this.$taskId, new j.h(r101, this.$route));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
