package com.obric.assistant.frontier;

import android.os.PowerManager;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.frontier.ObricFrontierStatusMonitor$init$4", f = "ObricFrontierStatusMonitor.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
final class ObricFrontierStatusMonitor$init$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public ObricFrontierStatusMonitor$init$4(Continuation<? super ObricFrontierStatusMonitor$init$4> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricFrontierStatusMonitor$init$4(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricFrontierStatusMonitor$init$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        Lazy r104 = d.f389296a;
        PowerManager r105 = (PowerManager) d.f389298c.getValue();
        if (r105 != null) goto L14;
    L16:
        r103 = false;
    L17:
        d.f389300e = r103;
        if (d.b() == false) goto L23;
        FLogger.f375446a.w("ObricFrontierStatusMonitor", "disconnet frontier after init");
        com.larus.im.f r106 = d.c();
        if (r106 == null) goto L23;
        r106.h("monitor init", false);
    L23:
        return Unit.INSTANCE;
    L14:
        if (r105.isInteractive() == true) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(30000, this) != r101) goto L11;
        return r101;
    }
}
