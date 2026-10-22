package com.obric.assistant.wakeup.statistics.impl;

import com.ixigua.lib.track.TrackParams;
import com.larus.platform.service.g;
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
@DebugMetadata(c = "com.obric.assistant.wakeup.statistics.impl.WakeupLatencyTrackImpl$reportActivateToRecord$1", f = "WakeupLatencyTrackImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WakeupLatencyTrackImpl$reportActivateToRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $durationMs;
    final /* synthetic */ WakeupLatencyTrackImpl.a $trace;
    final /* synthetic */ long $userUnlockElapsedMs;
    private /* synthetic */ Object L$0;
    int label;

    public WakeupLatencyTrackImpl$reportActivateToRecord$1(long r100, WakeupLatencyTrackImpl.a r101, long r102, Continuation<? super WakeupLatencyTrackImpl$reportActivateToRecord$1> r103) {
        this.$durationMs = r100;
        this.$trace = r101;
        this.$userUnlockElapsedMs = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        WakeupLatencyTrackImpl$reportActivateToRecord$1 r101 = new WakeupLatencyTrackImpl$reportActivateToRecord$1(this.$durationMs, this.$trace, this.$userUnlockElapsedMs, r110);
        r101.L$0 = r100;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((WakeupLatencyTrackImpl$reportActivateToRecord$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        long r102 = this.$durationMs;
        WakeupLatencyTrackImpl.a r103 = this.$trace;
        long r104 = this.$userUnlockElapsedMs;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L7
        r106.put("duration_ms", r102);     // Catch: Throwable -> L7
        r106.put("obric_launch_method", r103.f394485b);     // Catch: Throwable -> L7
        r106.put("main_process_ready", r103.f394486c);     // Catch: Throwable -> L7
        r106.put("user_unlock_elapsed_ms", r104);     // Catch: Throwable -> L7
        by7.a r107 = new by7.a("activate_to_record");     // Catch: Throwable -> L7
        TrackParams r108 = new TrackParams().merge(r106);     // Catch: Throwable -> L7
        r107.f21463a.merge(r108);     // Catch: Throwable -> L7
        r107.b();     // Catch: Throwable -> L7
        g.f365738a.monitorEventForSlardar("activate_to_record", r106, null, null);     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
