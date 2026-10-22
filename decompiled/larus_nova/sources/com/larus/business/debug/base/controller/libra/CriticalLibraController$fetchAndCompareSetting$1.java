package com.larus.business.debug.base.controller.libra;

import com.bytedance.common.utility.NetworkClient;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import ft9.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.debug.base.controller.libra.CriticalLibraController$fetchAndCompareSetting$1", f = "CriticalLibraController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CriticalLibraController$fetchAndCompareSetting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CriticalLibraController$fetchAndCompareSetting$1(Function1<? super String, Unit> r100, Continuation<? super CriticalLibraController$fetchAndCompareSetting$1> r101) {
        this.$callback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CriticalLibraController$fetchAndCompareSetting$1(this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CriticalLibraController$fetchAndCompareSetting$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        String r101 = d.f320034a;
        StringBuilder r102 = new StringBuilder();
        String r103 = g.f478797a;
        r102.append(g.f478797a);
        r102.append("?app=1");
        r102.append("&aid=" + AppHost.f326268a.getAppId());
        r102.append("&default=1");
        String r104 = NetworkClient.getDefault().post(r102.toString(), new byte[1], false, "application/json", true);     // Catch: Throwable -> L7
    L9:
        Function1<String, Unit> r105 = this.$callback;
        if (r105 == null) goto L13;
        r105.invoke(r104);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        FLogger.f375446a.e("CriticalLibraController", "executeSettingPost error: " + th);
        r104 = null;
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
