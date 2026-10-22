package com.larus.dora.impl.imu;

import com.larus.dora.api.awareness.IAwarenessEventReporter;
import g49.d;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.imu.DoraImuDataManager$reportAwarenessEvent$1", f = "DoraImuDataManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraImuDataManager$reportAwarenessEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ IAwarenessEventReporter $reporter;
    final /* synthetic */ long $timestamp;
    final /* synthetic */ int $value;
    private /* synthetic */ Object L$0;
    int label;

    public DoraImuDataManager$reportAwarenessEvent$1(String r100, int r101, long r102, IAwarenessEventReporter r103, Continuation<? super DoraImuDataManager$reportAwarenessEvent$1> r104) {
        this.$key = r100;
        this.$value = r101;
        this.$timestamp = r102;
        this.$reporter = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        DoraImuDataManager$reportAwarenessEvent$1 r101 = new DoraImuDataManager$reportAwarenessEvent$1(this.$key, this.$value, this.$timestamp, this.$reporter, r110);
        r101.L$0 = r100;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraImuDataManager$reportAwarenessEvent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$key;
        int r103 = this.$value;
        long r104 = this.$timestamp;
        IAwarenessEventReporter r105 = this.$reporter;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L7
        d.d("DoraImuDataManager", "本地感知事件上报，key=" + r102 + ", value=" + r103 + ", timestamp=" + r104);     // Catch: Throwable -> L7
        r105.a(r102, Boxing.boxInt(r103), r104);     // Catch: Throwable -> L7
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r108 = this.$key;
        Throwable r109 = Result.m9452exceptionOrNullimpl(r107);
        if (r109 == null) goto L16;
        if ((r109 instanceof CancellationException) == true) goto L14;
        d.c("DoraImuDataManager", "本地感知事件上报失败，key=" + r108, r109);
        goto L16
    L14:
        throw r109;
    L16:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
