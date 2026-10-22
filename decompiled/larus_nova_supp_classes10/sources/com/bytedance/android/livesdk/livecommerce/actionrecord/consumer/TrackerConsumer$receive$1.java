package com.bytedance.android.livesdk.livecommerce.actionrecord.consumer;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.f;
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
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.TrackerConsumer$receive$1", f = "TrackerConsumer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TrackerConsumer$receive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ vg2.a $event;
    int label;
    final /* synthetic */ TrackerConsumer this$0;

    public TrackerConsumer$receive$1(TrackerConsumer r1, vg2.a r2, Continuation r3) {
        this.this$0 = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new TrackerConsumer$receive$1(this.this$0, this.$event, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r4);
        TrackerConsumer r5 = this.this$0;     // Catch: Exception -> L13
        vg2.a r0 = this.$event;     // Catch: Exception -> L13
        r5.getClass();     // Catch: Exception -> L13
        Intrinsics.checkNotNullParameter(r0, "event");     // Catch: Exception -> L13
        Map r6 = a.C0060a.a(r0);     // Catch: Exception -> L13
        Map<String, String> r1 = this.this$0.a;     // Catch: Exception -> L13
        if (r1 == null) goto L8;
        r6.putAll(r1);     // Catch: Exception -> L13
    L8:
        r6.putAll(this.$event.a);     // Catch: Exception -> L13
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L11;
        String r2 = this.$event.b;     // Catch: Exception -> L13
        int r3 = RoomContextController.h;     // Catch: Exception -> L13
        f.e(r2, r6, "c0.d0", PageFinder.via(RoomContextController.a.a().getContext()));     // Catch: Exception -> L13
    L16:
        return Unit.INSTANCE;
    L11:
        f.d(this.$event.b, r6);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
