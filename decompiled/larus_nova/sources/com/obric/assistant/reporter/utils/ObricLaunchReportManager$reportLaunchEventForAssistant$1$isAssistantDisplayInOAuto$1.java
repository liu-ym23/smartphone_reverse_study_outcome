package com.obric.assistant.reporter.utils;

import com.obric.assistant.oauto.IOAutoApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.reporter.utils.ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1", f = "ObricLaunchReportManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1(Continuation<? super ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((ObricLaunchReportManager$reportLaunchEventForAssistant$1$isAssistantDisplayInOAuto$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        IOAutoApi r101 = com.obric.assistant.oauto.b.a();
        boolean r102 = false;
        if (r101 == null) goto L10;
        if (r101.b() != true) goto L10;
        r102 = true;
    L10:
        return Boxing.boxBoolean(r102);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
