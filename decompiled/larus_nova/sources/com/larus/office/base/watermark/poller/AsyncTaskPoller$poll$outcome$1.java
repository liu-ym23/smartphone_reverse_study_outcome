package com.larus.office.base.watermark.poller;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import nn9.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/office/base/watermark/poller/AsyncTaskPoller$PollOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.watermark.poller.AsyncTaskPoller$poll$outcome$1", f = "AsyncTaskPoller.kt", i = {}, l = {23, 26}, m = "invokeSuspend", n = {}, s = {})
public final class AsyncTaskPoller$poll$outcome$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AsyncTaskPoller.b>, Object> {
    final /* synthetic */ String $taskId;
    int label;
    final /* synthetic */ AsyncTaskPoller this$0;

    public AsyncTaskPoller$poll$outcome$1(AsyncTaskPoller r100, String r101, Continuation<? super AsyncTaskPoller$poll$outcome$1> r102) {
        this.this$0 = r100;
        this.$taskId = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AsyncTaskPoller$poll$outcome$1(this.this$0, this.$taskId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super AsyncTaskPoller.b> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super AsyncTaskPoller.b> r101) {
        return ((AsyncTaskPoller$poll$outcome$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0063 -> B:11:0x0021). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 == 2) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        Object r103 = r101;
        AsyncTaskPoller$poll$outcome$1 r104 = this;
    L15:
        a.b r105 = (a.b) r100;
        if ((r105 instanceof a.b.c) == false) goto L20;
        return new AsyncTaskPoller.b.C4439b(((a.b.c) r105).f519683a);
    L20:
        if ((r105 instanceof a.b.C6946a) == false) goto L24;
        return new AsyncTaskPoller.b.a(((a.b.C6946a) r105).f519681a);
    L24:
        if ((r105 instanceof a.b.C6947b) == false) goto L30;
        long r106 = r104.this$0.f361243b;
        r104.label = 2;
        if (DelayKt.delay(r106, r104) != r103) goto L28;
        return r103;
    L28:
        AsyncTaskPoller$poll$outcome$1 r107 = r104;
        r101 = r103;
    L11:
        a r108 = r107.this$0.f361242a;
        String r109 = r107.$taskId;
        r107.label = 1;
        Object r110 = r108.a(r109, r107);
        if (r110 != r101) goto L14;
        return r101;
    L14:
        Object r111 = r101;
        r104 = r107;
        r100 = r110;
        r103 = r111;
        goto L15
    L30:
        throw new NoWhenBranchMatchedException();
    L10:
        ResultKt.throwOnFailure(r100);
        r107 = this;
        goto L11
    }
}
