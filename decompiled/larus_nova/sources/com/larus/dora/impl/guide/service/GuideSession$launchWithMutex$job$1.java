package com.larus.dora.impl.guide.service;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$launchWithMutex$job$1", f = "DoraGuideServiceImpl.kt", i = {0, 1}, l = {TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPT_SUB_LOAD_TIME, 341}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class GuideSession$launchWithMutex$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GuideSession this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public GuideSession$launchWithMutex$job$1(GuideSession r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super GuideSession$launchWithMutex$job$1> r102) {
        this.this$0 = r100;
        this.$block = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GuideSession$launchWithMutex$job$1(this.this$0, this.$block, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GuideSession$launchWithMutex$job$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L14;
        if (r102 == 1) goto L13;
        if (r102 != 2) goto L12;
        kotlinx.coroutines.sync.a r103 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L9
    L21:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r103.unlock(null);
        return Unit.INSTANCE;
    L9:
        Throwable th10 = th;
    L26:
        r103.unlock(null);
        throw th10;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Function1<Continuation<? super Unit>, Object> r105 = (Function1) this.L$1;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);
        kotlinx.coroutines.sync.a r107 = r106;
    L30:
        this.L$0 = r107;     // Catch: Throwable -> L24
        this.L$1 = null;     // Catch: Throwable -> L24
        this.label = 2;     // Catch: Throwable -> L24
        if (r105.invoke(this) != r101) goto L20;
        return r101;
    L20:
        r103 = r107;
    L24:
        th = move-exception;
        r103 = r107;
        th10 = th;
        goto L26
    L14:
        ResultKt.throwOnFailure(r100);
        r107 = this.this$0.f335968l;
        r105 = this.$block;
        this.L$0 = r107;
        this.L$1 = r105;
        this.label = 1;
        if (r107.a(null, this) != r101) goto L30;
        return r101;
    }
}
