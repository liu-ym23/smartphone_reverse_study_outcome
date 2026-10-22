package com.larus.avlink.e.mock;

import com.larus.avlink.e.mock.scenario.Scenario;
import com.larus.avlink.e.mock.scenario.TimingStrategy;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.e.mock.CameraMockPlayer$playbackScenario$1", f = "CameraMockPlayer.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
final class CameraMockPlayer$playbackScenario$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Scenario $scenario;
    int label;
    final /* synthetic */ f this$0;

    public CameraMockPlayer$playbackScenario$1(Scenario r100, f r101, Continuation<? super CameraMockPlayer$playbackScenario$1> r102) {
        this.$scenario = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CameraMockPlayer$playbackScenario$1(this.$scenario, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CameraMockPlayer$playbackScenario$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L13;
        if (r102 != 1) goto L12;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L7 Exception -> L9
    L17:
        FLogger.f375446a.i("CameraMockPlayer", "✅ Scenario playback completed: " + this.$scenario.getName());     // Catch: Throwable -> L7 Exception -> L9
        f r103 = this.this$0;
    L21:
        r103.f291807a.set(false);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r100);
        FLogger.f375446a.i("CameraMockPlayer", "Starting scenario playback: " + this.$scenario.getName());     // Catch: Throwable -> L7 Exception -> L9
        List r104 = f.a(this.this$0, this.$scenario.getCallbacks(), this.$scenario.getParameterMapping());     // Catch: Throwable -> L7 Exception -> L9
        f r105 = this.this$0;     // Catch: Throwable -> L7 Exception -> L9
        TimingStrategy r106 = this.$scenario.getTimingStrategy();     // Catch: Throwable -> L7 Exception -> L9
        this.label = 1;     // Catch: Throwable -> L7 Exception -> L9
        if (f.b(r105, r104, r106, this) != r101) goto L17;
        return r101;
    L9:
        e = move-exception;
        FLogger.f375446a.e("CameraMockPlayer", "Scenario playback failed", e);     // Catch: Throwable -> L7
        r103 = this.this$0;
    L7:
        th = move-exception;
        this.this$0.f291807a.set(false);
        throw th;
    }
}
