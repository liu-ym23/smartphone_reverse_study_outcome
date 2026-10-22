package com.bytedance.android.livesdk.livecommerce.playback.main;

import com.bytedance.android.ec.monitor.duration.i;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lol/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/livesdk/livecommerce/playback/main/ExplainPlaybackViewModel$initNormalData$1$1$response$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$initNormalData$1$1$response$1", f = "ExplainPlaybackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ExplainPlaybackViewModel$initNormalData$1$invokeSuspend$$inlined$also$lambda$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ol.a>, Object> {
    final /* synthetic */ b $tempExplainPlaybackOriginData;
    int label;
    final /* synthetic */ ExplainPlaybackViewModel.C02811 this$0;

    public ExplainPlaybackViewModel$initNormalData$1$invokeSuspend$$inlined$also$lambda$2(b r1, Continuation r2, ExplainPlaybackViewModel.C02811 r3) {
        this.$tempExplainPlaybackOriginData = r1;
        this.this$0 = r3;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new ExplainPlaybackViewModel$initNormalData$1$invokeSuspend$$inlined$also$lambda$2(this.$tempExplainPlaybackOriginData, r4, this.this$0);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r3);
        String r4 = cj2.b.a;
        i r5 = i.a;
        com.bytedance.android.ec.monitor.duration.d r0 = r5.get(cj2.b.a);
        if (r0 == null) goto L7;
        r0.a("request_start");
    L7:
        ExplainPlaybackFragment.j.getClass();
        com.bytedance.android.ec.monitor.duration.d r6 = r5.get(ExplainPlaybackFragment.i);
        if (r6 == null) goto L11;
        r6.a("request_start");
    L11:
        return ExplainPlaybackViewModel.access$getRepository$p(this.this$0.this$0).b(this.$tempExplainPlaybackOriginData.a);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
