package com.larus.dora.impl.file;

import com.bytedance.dora.file.DoraInterruptLogFileReason;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileStreamingSink$sink$consumer$1$onIncomplete$1", f = "DoraFileStreamingSink.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
final class DoraFileStreamingSink$sink$consumer$1$onIncomplete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ v $remoteStreamer;
    final /* synthetic */ DoraFileFetchTask $task;
    int label;

    public DoraFileStreamingSink$sink$consumer$1$onIncomplete$1(v r100, DoraFileFetchTask r101, Continuation<? super DoraFileStreamingSink$sink$consumer$1$onIncomplete$1> r102) {
        this.$remoteStreamer = r100;
        this.$task = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraFileStreamingSink$sink$consumer$1$onIncomplete$1(this.$remoteStreamer, this.$task, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraFileStreamingSink$sink$consumer$1$onIncomplete$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L11;
        if (r102 != 1) goto L10;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L7
    L21:
    L20:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r100);
        v r103 = this.$remoteStreamer;     // Catch: Exception -> L7
        String r104 = this.$task.getFileName();     // Catch: Exception -> L7
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        DoraInterruptLogFileReason r105 = DoraInterruptLogFileReason.FETCH_RETRY_FOR_SEQ_GAP;     // Catch: Exception -> L7
        this.label = 1;     // Catch: Exception -> L7
        if (r103.a(r104, r105, this) != r101) goto L21;
        return r101;
    L7:
        e = move-exception;
        g49.d.c("DoraFileStreamingSink", "interrupt failed", e);
        goto L20
    }
}
