package com.obric.assistant.wakeup.statistics.impl;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.wakeup.statistics.impl.WakeupLatencyTrackImpl$reportAttemptDropped$1", f = "WakeupLatencyTrackImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WakeupLatencyTrackImpl$reportAttemptDropped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $prevScene;
    final /* synthetic */ String $prevSession;
    final /* synthetic */ String $stage;
    private /* synthetic */ Object L$0;
    int label;

    public WakeupLatencyTrackImpl$reportAttemptDropped$1(String r100, String r101, String r102, Continuation<? super WakeupLatencyTrackImpl$reportAttemptDropped$1> r103) {
        this.$prevScene = r100;
        this.$prevSession = r101;
        this.$stage = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        WakeupLatencyTrackImpl$reportAttemptDropped$1 r102 = new WakeupLatencyTrackImpl$reportAttemptDropped$1(this.$prevScene, this.$prevSession, this.$stage, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((WakeupLatencyTrackImpl$reportAttemptDropped$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$prevScene;
        String r103 = this.$prevSession;
        String r104 = this.$stage;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L7
        r106.put("scene", r102);     // Catch: Throwable -> L7
        r106.put("session_type", r103);     // Catch: Throwable -> L7
        r106.put("drop_stage", r104);     // Catch: Throwable -> L7
        FLogger.f375446a.i("WakeupLatencyTrackImpl", "reportAttemptDropped scene=" + r102 + ", session=" + r103 + ", stage=" + r104);     // Catch: Throwable -> L7
        by7.a r107 = new by7.a("wakeup_attempt_dropped");     // Catch: Throwable -> L7
        r107.f21463a.merge(new TrackParams().merge(r106));     // Catch: Throwable -> L7
        r107.b();     // Catch: Throwable -> L7
        g.f365738a.monitorEventForSlardar("wakeup_attempt_dropped", r106, null, null);     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
