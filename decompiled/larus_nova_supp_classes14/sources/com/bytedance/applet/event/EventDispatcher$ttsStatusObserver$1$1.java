package com.bytedance.applet.event;

import com.larus.audio.audiov3.tts.PlayStateEnum;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.bytedance.applet.event.EventDispatcher$ttsStatusObserver$1$1", f = "EventDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventDispatcher$ttsStatusObserver$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayStateEnum $it;
    int label;

    public EventDispatcher$ttsStatusObserver$1$1(PlayStateEnum r1, Continuation<? super EventDispatcher$ttsStatusObserver$1$1> r2) {
        this.$it = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EventDispatcher$ttsStatusObserver$1$1(this.$it, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r7);
        EventDispatcher r8 = EventDispatcher.a;
        PlayStateEnum r9 = this.$it;
        if (r9 == null) goto L16;
        jw3.c r0 = jw3.c.a;
        jw3.a r1 = jw3.c.a();
        if (r1 == null) goto L16;
        jw3.b r10 = r1.e(r9);
        if (r10 == null) goto L16;
        Iterator r2 = EventDispatcher.e.entrySet().iterator();
    L13:
        if (r2.hasNext() == false) goto L16;
        Map.Entry r3 = (Map.Entry) r2.next();
        EventDispatcher r4 = EventDispatcher.a;
        EventDispatcher.n((EventDispatcher$a) r3.getValue(), r10.a, r10.b, null, false);
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
