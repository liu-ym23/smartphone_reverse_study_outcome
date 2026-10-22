package com.bytedance.android.livesdk.livecommerce.actionrecord.consumer;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.LoggerConsumer$receive$1", f = "LoggerConsumer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LoggerConsumer$receive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ vg2.a $event;
    int label;
    final /* synthetic */ LoggerConsumer this$0;

    public LoggerConsumer$receive$1(LoggerConsumer r1, vg2.a r2, Continuation r3) {
        this.this$0 = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new LoggerConsumer$receive$1(this.this$0, this.$event, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        LoggerConsumer r5 = this.this$0;
        vg2.a r0 = this.$event;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "event");
        Map r6 = a.C0060a.a(r0);
        Map<String, String> r1 = this.this$0.a;
        if (r1 == null) goto L7;
        r6.putAll(r1);
    L7:
        r6.putAll(this.$event.a);
        String r7 = "EventName: " + this.$event.b + ", Type: " + this.$event.getType() + ", Params: " + r6;
        if (this.$event.getType() != EventType.RATE_FAILURE) goto L10;
        dm.a.a("ActionRecordServiceImpl").b(r7, null);
    L12:
        return Unit.INSTANCE;
    L10:
        dm.a.a("ActionRecordServiceImpl").i(r7);
        goto L12
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
