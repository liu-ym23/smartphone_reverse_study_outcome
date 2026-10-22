package com.bytedance.applet.event;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.LocalPluginService$singleRun$1", f = "LocalPluginService.kt", i = {0, 1}, l = {348, 277}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class LocalPluginService$singleRun$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    Object L$0;
    Object L$1;
    int label;

    public LocalPluginService$singleRun$1(Function1<? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super LocalPluginService$singleRun$1> r2) {
        this.$block = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LocalPluginService$singleRun$1(this.$block, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L9
    L21:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r2.unlock(null);
        return Unit.INSTANCE;
    L9:
        th = move-exception;
        kotlinx.coroutines.sync.a r5 = r2;
        th = th;
        kotlinx.coroutines.sync.a r9 = r5;
    L26:
        r9.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Function1<Continuation<? super Unit>, Object> r3 = (Function1) this.L$1;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r7);
        r9 = r4;
    L30:
        this.L$0 = r9;     // Catch: Throwable -> L25
        this.L$1 = null;     // Catch: Throwable -> L25
        this.label = 2;     // Catch: Throwable -> L25
        if (r3.invoke(this) != r0) goto L20;
        return r0;
    L20:
        r2 = r9;
    L25:
        th = th;
        goto L26
    L14:
        ResultKt.throwOnFailure(r7);
        r9 = LocalPluginService.l;
        r3 = this.$block;
        this.L$0 = r9;
        this.L$1 = r3;
        this.label = 1;
        if (r9.a(null, this) != r0) goto L30;
        return r0;
    }
}
