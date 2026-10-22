package com.bytedance.applet.event;

import com.bytedance.ai.applet.services.AppletSnapshotManagerService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/applet/services/SnapshotUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1", f = "BaseAppActionListener.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
public final class BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends com.bytedance.ai.applet.services.e>>, Object> {
    final /* synthetic */ String $key;
    private /* synthetic */ Object L$0;
    int label;

    public BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1(String r1, Continuation<? super BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1> r2) {
        this.$key = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1 r0 = new BaseAppActionListener$onUndefinedAction$1$uploadDeferred$1(this.$key, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<com.bytedance.ai.applet.services.e>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
        Object r5 = ((Result) r4).unbox-impl();     // Catch: Throwable -> L15
    L13:
        Object r6 = Result.constructor-impl(Result.box-impl(r5));     // Catch: Throwable -> L15
    L17:
        Throwable r2 = Result.exceptionOrNull-impl(r6);
        if (r2 != null) goto L21;
        return r6;
    L21:
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r2)));
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        String r8 = this.$key;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        AppletSnapshotManagerService r9 = AppletSnapshotManagerService.a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r5 = r9.i(r8, this);     // Catch: Throwable -> L15
        if (r5 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
