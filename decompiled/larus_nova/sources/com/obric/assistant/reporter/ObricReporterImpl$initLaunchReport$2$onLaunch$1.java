package com.obric.assistant.reporter;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.reporter.utils.ObricLaunchReportManager;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.reporter.ObricReporterImpl$initLaunchReport$2$onLaunch$1", f = "ObricReporterImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricReporterImpl$initLaunchReport$2$onLaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isBackground;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ long $timestamp;
    int label;

    public ObricReporterImpl$initLaunchReport$2$onLaunch$1(String r100, long r101, boolean r102, Continuation<? super ObricReporterImpl$initLaunchReport$2$onLaunch$1> r103) {
        this.$sessionId = r100;
        this.$timestamp = r101;
        this.$isBackground = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricReporterImpl$initLaunchReport$2$onLaunch$1(this.$sessionId, this.$timestamp, this.$isBackground, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricReporterImpl$initLaunchReport$2$onLaunch$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        if (Intrinsics.areEqual(ObricInteractDelegate.f392884b.isAiKeyPressing(), Boxing.boxBoolean(true)) == false) goto L7;
        long r101 = 750;
    L8:
        FLogger.f375446a.d("ObricReporterImpl", "initLaunchReport LaunchObserver called: sessionId = " + this.$sessionId + ", timestamp = " + this.$timestamp + ", isBackground = " + this.$isBackground + ", delayTime= " + r101);
        ObricLaunchReportManager.f391417a.e(this.$sessionId, r101);
        return Unit.INSTANCE;
    L7:
        r101 = 0;
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
