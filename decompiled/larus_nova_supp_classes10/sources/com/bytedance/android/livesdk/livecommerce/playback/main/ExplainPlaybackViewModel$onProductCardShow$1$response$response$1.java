package com.bytedance.android.livesdk.livecommerce.playback.main;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel$onProductCardShow$1$response$response$1", f = "ExplainPlaybackViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ExplainPlaybackViewModel$onProductCardShow$1$response$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.bytedance.android.livesdk.livecommerce.playback.interaction.a>, Object> {
    int label;
    final /* synthetic */ ExplainPlaybackViewModel.C02821 this$0;

    public ExplainPlaybackViewModel$onProductCardShow$1$response$response$1(ExplainPlaybackViewModel.C02821 r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new ExplainPlaybackViewModel$onProductCardShow$1$response$response$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        h r4 = ExplainPlaybackViewModel.access$getRepository$p(this.this$0.this$0);
        ExplainPlaybackViewModel.C02821 r0 = this.this$0;
        return r4.a(ExplainPlaybackViewModel.access$buildInteractionRequestParams(r0.this$0, r0.$uiPromotion));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
