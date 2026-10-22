package com.larus.uaigc.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/resource/access/ResourceAccessState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.service.ICreationResourceAccessServiceKt$awaitTerminalState$5", f = "ICreationResourceAccessService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ICreationResourceAccessServiceKt$awaitTerminalState$5 extends SuspendLambda implements Function2<com.larus.bmhome.resource.access.a0, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public ICreationResourceAccessServiceKt$awaitTerminalState$5(Continuation<? super ICreationResourceAccessServiceKt$awaitTerminalState$5> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ICreationResourceAccessServiceKt$awaitTerminalState$5 r102 = new ICreationResourceAccessServiceKt$awaitTerminalState$5(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.larus.bmhome.resource.access.a0 r100, Continuation<? super Boolean> r101) {
        return ((ICreationResourceAccessServiceKt$awaitTerminalState$5) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(com.larus.bmhome.resource.access.a0 r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return Boxing.boxBoolean(com.larus.bmhome.resource.access.s.b((com.larus.bmhome.resource.access.a0) this.L$0));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
