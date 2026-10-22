package com.obric.assistant.interaction.impl;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1", f = "AppLaunchServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppLaunchServiceImpl this$0;

    public AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1(AppLaunchServiceImpl r100, Continuation<? super AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AppLaunchServiceImpl$activityLifeCycleCallback$1$checkMainIntent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r100);
        String r101 = this.this$0.getBackgroundAppPkgName();
        FLogger r102 = FLogger.f375446a;
        r102.d("AppLaunchServiceImpl", "ActivityLifecycleCallbacks.checkMainIntent pkgName = " + r101);
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L15;
        return Unit.INSTANCE;
    L15:
        if (IAssistantInteractionServiceKt.getInteractionStateService().isDefiniteWakeUpSource() == true) goto L17;
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(r101, "ActivityLifecycleCallbacks checkMainIntent");
    L19:
        return Unit.INSTANCE;
    L17:
        r102.d("AppLaunchServiceImpl", "ActivityLifecycleCallbacks.checkMainIntent no need update. cur is " + IAssistantInteractionServiceKt.getInteractionStateService().getWakeUpAppPkg());
        goto L19
    L7:
        if (r101.length() == 0) goto L10;
        r103 = false;
        goto L11
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
