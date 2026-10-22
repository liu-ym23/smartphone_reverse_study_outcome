package com.larus.uaigc.service;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/larus/bmhome/resource/access/ResourceAccessState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.service.ICreationResourceAccessServiceKt$awaitTerminalState$4", f = "ICreationResourceAccessService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ICreationResourceAccessServiceKt$awaitTerminalState$4 extends SuspendLambda implements Function2<com.larus.bmhome.resource.access.a0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<com.larus.bmhome.resource.access.a0.e, Unit> $onRunning;
    final /* synthetic */ Function1<com.larus.bmhome.resource.access.a0.f, Unit> $onUploading;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ICreationResourceAccessServiceKt$awaitTerminalState$4(Function1<? super com.larus.bmhome.resource.access.a0.e, Unit> r100, Function1<? super com.larus.bmhome.resource.access.a0.f, Unit> r101, Continuation<? super ICreationResourceAccessServiceKt$awaitTerminalState$4> r102) {
        this.$onRunning = r100;
        this.$onUploading = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ICreationResourceAccessServiceKt$awaitTerminalState$4 r102 = new ICreationResourceAccessServiceKt$awaitTerminalState$4(this.$onRunning, this.$onUploading, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.larus.bmhome.resource.access.a0 r100, Continuation<? super Unit> r101) {
        return ((ICreationResourceAccessServiceKt$awaitTerminalState$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(com.larus.bmhome.resource.access.a0 r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r100);
        com.larus.bmhome.resource.access.a0 r101 = (com.larus.bmhome.resource.access.a0) this.L$0;
        if ((r101 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L8;
        this.$onRunning.invoke((com.larus.bmhome.resource.access.a0.e) r101);
    L22:
        return Unit.INSTANCE;
    L8:
        if ((r101 instanceof com.larus.bmhome.resource.access.a0.f) == false) goto L11;
        this.$onUploading.invoke((com.larus.bmhome.resource.access.a0.f) r101);
        goto L22
    L11:
        if (Intrinsics.areEqual(r101, com.larus.bmhome.resource.access.a0.b.f313616a) == true) goto L22;
        if ((r101 instanceof com.larus.bmhome.resource.access.a0.d) == true) goto L22;
        if ((r101 instanceof com.larus.bmhome.resource.access.a0.c) == true) goto L22;
        if ((r101 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L22;
        throw new NoWhenBranchMatchedException();
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
