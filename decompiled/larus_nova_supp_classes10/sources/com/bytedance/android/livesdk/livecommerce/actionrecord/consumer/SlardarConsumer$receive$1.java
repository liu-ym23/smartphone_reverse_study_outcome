package com.bytedance.android.livesdk.livecommerce.actionrecord.consumer;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.crash.d;
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
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.SlardarConsumer$receive$1", f = "SlardarConsumer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SlardarConsumer$receive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ vg2.a $event;
    int label;
    final /* synthetic */ SlardarConsumer this$0;

    public SlardarConsumer$receive$1(SlardarConsumer r1, vg2.a r2, Continuation r3) {
        this.this$0 = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new SlardarConsumer$receive$1(this.this$0, this.$event, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r3);
        SlardarConsumer r4 = this.this$0;     // Catch: Exception -> L10
        vg2.a r0 = this.$event;     // Catch: Exception -> L10
        r4.getClass();     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r0, "event");     // Catch: Exception -> L10
        Map r5 = a.C0060a.a(r0);     // Catch: Exception -> L10
        Map<String, String> r1 = this.this$0.a;     // Catch: Exception -> L10
        if (r1 == null) goto L8;
        r5.putAll(r1);     // Catch: Exception -> L10
    L8:
        r5.putAll(this.$event.a);     // Catch: Exception -> L10
        d.e(new Throwable("ARS-EventException"), this.$event.b, r5);     // Catch: Exception -> L10
    L13:
        return Unit.INSTANCE;
    L10:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
