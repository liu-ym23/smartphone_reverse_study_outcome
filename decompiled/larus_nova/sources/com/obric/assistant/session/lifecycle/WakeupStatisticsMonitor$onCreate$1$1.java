package com.obric.assistant.session.lifecycle;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.utils.s;
import com.obric.sva.sdk.utils.TrackerConstant;
import kotlin.Lazy;
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
@DebugMetadata(c = "com.obric.assistant.session.lifecycle.WakeupStatisticsMonitor$onCreate$1$1", f = "BaseSessionLifecycleImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupStatisticsMonitor$onCreate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ JSONObject $payload;
    int label;

    public WakeupStatisticsMonitor$onCreate$1$1(String r100, JSONObject r101, Continuation<? super WakeupStatisticsMonitor$onCreate$1$1> r102) {
        this.$key = r100;
        this.$payload = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new WakeupStatisticsMonitor$onCreate$1$1(this.$key, this.$payload, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((WakeupStatisticsMonitor$onCreate$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        WakeupStatisticsMonitor r101 = WakeupStatisticsMonitor.f391619b;
        String r102 = this.$key;
        JSONObject r103 = this.$payload;
        r101.getClass();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L7
        Lazy r105 = s.f387888a;     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(s.d(r102, r103.optLong(TrackerConstant.TRACKER_EVENT_WAKEUP_STAGE1_DURATION), r103.optLong(TrackerConstant.TRACKER_EVENT_WAKEUP_STAGE2_DURATION), r103.optLong("wakeup_stage3_duration"), r103));     // Catch: Throwable -> L7
    L9:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L13;
        FLogger.f375446a.w(WakeupStatisticsMonitor.f391619b.c(), "reportWakeupDurationPb failed", r107);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
