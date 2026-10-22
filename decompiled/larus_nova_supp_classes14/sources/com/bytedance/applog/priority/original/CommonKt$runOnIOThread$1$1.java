package com.bytedance.applog.priority.original;

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
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.bytedance.applog.priority.original.CommonKt$runOnIOThread$1$1", f = "Common.kt", i = {}, l = {371}, m = "invokeSuspend", n = {}, s = {})
final class CommonKt$runOnIOThread$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CoroutineScope $it;
    int label;

    public CommonKt$runOnIOThread$1$1(Function1<? super Continuation<? super Unit>, ? extends Object> r1, CoroutineScope r2, Continuation<? super CommonKt$runOnIOThread$1$1> r3) {
        this.$block = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommonKt$runOnIOThread$1$1(this.$block, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L10;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L7
    L23:
    L15:
        CoroutineScopeKt.cancel$default(this.$it, null, 1, null);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r6);
        Function1<Continuation<? super Unit>, Object> r7 = this.$block;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r7.invoke(this) != r1) goto L23;
        return r1;
    L7:
        th = move-exception;
        com.bytedance.applog.log.n.w().q("Background task failed: " + th.getMessage(), th, new Object[0]);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CoroutineScopeKt.cancel$default(this.$it, null, 1, null);
        throw th;
    }
}
