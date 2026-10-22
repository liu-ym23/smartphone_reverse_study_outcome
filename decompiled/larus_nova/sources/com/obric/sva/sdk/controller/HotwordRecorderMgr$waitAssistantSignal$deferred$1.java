package com.obric.sva.sdk.controller;

import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.session.SessionTypeKt;
import com.obric.sva.sdk.utils.LogUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.sva.sdk.controller.HotwordRecorderMgr$waitAssistantSignal$deferred$1", f = "HotwordRecorderMgr.kt", i = {}, l = {349}, m = "invokeSuspend", n = {}, s = {})
public final class HotwordRecorderMgr$waitAssistantSignal$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SessionType $session;
    final /* synthetic */ Function1<ExecuteCategory, Unit> $task;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public HotwordRecorderMgr$waitAssistantSignal$deferred$1(SessionType r100, Function1<? super ExecuteCategory, Unit> r101, Continuation<? super HotwordRecorderMgr$waitAssistantSignal$deferred$1> r102) {
        this.$session = r100;
        this.$task = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new HotwordRecorderMgr$waitAssistantSignal$deferred$1(this.$session, this.$task, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((HotwordRecorderMgr$waitAssistantSignal$deferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 != 1) goto L9;
        Function1<ExecuteCategory, Unit> r103 = (Function1) this.L$1;
        SessionType r104 = (SessionType) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L17
    L15:
        LogUtils.d(HotwordRecorderMgr.TAG, SessionTypeKt.str(r104) + "====== start to run the clean pipe task and will close recorder , NOTE : FROM TIMEOUT =====", new Object[0]);     // Catch: Throwable -> L17
        r103.invoke(ExecuteCategory.NORMAL);     // Catch: Throwable -> L17
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L20:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r100);
        r104 = this.$session;
        Function1<ExecuteCategory, Unit> r105 = this.$task;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        this.L$0 = r104;     // Catch: Throwable -> L17
        this.L$1 = r105;     // Catch: Throwable -> L17
        this.label = 1;     // Catch: Throwable -> L17
        if (DelayKt.delay(120000, this) != r101) goto L14;
        return r101;
    L14:
        r103 = r105;
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}
