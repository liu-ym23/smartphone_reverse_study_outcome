package com.bytedance.applet.event;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.EventDispatcher$onAppAction$1", f = "EventDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventDispatcher$onAppAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppAction $appAction;
    int label;

    public EventDispatcher$onAppAction$1(AppAction r1, Continuation<? super EventDispatcher$onAppAction$1> r2) {
        this.$appAction = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EventDispatcher$onAppAction$1(this.$appAction, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r4);
        IMAppAction r5 = this.$appAction.getAction();
        if (r5 == null) goto L15;
        EventDispatcher r0 = EventDispatcher.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        ((ConcurrentHashMap) EventDispatcher.c).put(r5.getMessageId(), Boolean.FALSE);     // Catch: Throwable -> L9
        EventDispatcher.m(r5, new j(r5));     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L15;
        FLogger.a.e("EventDispatcher", "parse app action error " + r7);
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
