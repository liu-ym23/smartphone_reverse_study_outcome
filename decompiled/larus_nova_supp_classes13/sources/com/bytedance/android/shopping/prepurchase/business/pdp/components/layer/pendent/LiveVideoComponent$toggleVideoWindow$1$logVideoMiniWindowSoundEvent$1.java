package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lvg3/w;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.LiveVideoComponent$toggleVideoWindow$1$logVideoMiniWindowSoundEvent$1", f = "LiveVideoComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LiveVideoComponent$toggleVideoWindow$1$logVideoMiniWindowSoundEvent$1 extends SuspendLambda implements Function3<CoroutineScope, w, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionType;
    final /* synthetic */ String $videoId;
    private /* synthetic */ Object L$0;
    int label;

    public LiveVideoComponent$toggleVideoWindow$1$logVideoMiniWindowSoundEvent$1(String r1, String r2, Continuation r3) {
        this.$videoId = r1;
        this.$actionType = r2;
        super(3, r3);
    }

    public final Continuation<Unit> create(CoroutineScope r3, w r4, Continuation<? super Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "$this$create");
        Intrinsics.checkNotNullParameter(r4, "it");
        Intrinsics.checkNotNullParameter(r5, "continuation");
        LiveVideoComponent$toggleVideoWindow$1$logVideoMiniWindowSoundEvent$1 r6 = new LiveVideoComponent$toggleVideoWindow$1$logVideoMiniWindowSoundEvent$1(this.$videoId, this.$actionType, r5);
        r6.L$0 = r4;
        return r6;
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((CoroutineScope) r1, (w) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(((w) this.L$0).m().d(MapsKt.mapOf(new Pair[]{TuplesKt.to("video_id", this.$videoId), TuplesKt.to("action_type", this.$actionType)})), "video_mini_window_sound", false, null, null, 14);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
