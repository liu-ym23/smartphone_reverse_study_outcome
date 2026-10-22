package com.larus.bootprotector.activity;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bootprotector.activity.BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1", f = "BootProtectorLandingActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1(Continuation<? super BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        nu8.a.e("BootProtectorLandingAct", "requestSettingInBootProtectorInternal: updateColdBootSettingRepo start");     // Catch: Throwable -> L7
        ht9.a r101 = ht9.a.f487150a;     // Catch: Throwable -> L7
        Application r102 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L7
        r101.getClass();     // Catch: Throwable -> L7
        ht9.a.c(r102);     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        nu8.a.f("BootProtectorLandingAct", th, "requestSettingInBootProtectorInternal: fail");
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
