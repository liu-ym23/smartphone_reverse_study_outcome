package com.larus.office.base.host;

import com.larus.network.http.CommonApi;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.host.FlowConditionalAccessPingServiceImpl$ping$1", f = "FlowConditionalAccessPingServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowConditionalAccessPingServiceImpl$ping$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ rwb.a.InterfaceC7547a $callback;
    private /* synthetic */ Object L$0;
    int label;

    public FlowConditionalAccessPingServiceImpl$ping$1(rwb.a.InterfaceC7547a r100, Continuation<? super FlowConditionalAccessPingServiceImpl$ping$1> r101) {
        this.$callback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowConditionalAccessPingServiceImpl$ping$1 r102 = new FlowConditionalAccessPingServiceImpl$ping$1(this.$callback, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowConditionalAccessPingServiceImpl$ping$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        CommonApi.a r103 = CommonApi.f360115a;     // Catch: Throwable -> L7
        Function1 r104 = new j();     // Catch: Throwable -> L7
        r103.getClass();     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(CommonApi.a.a(ServiceType.BASIC_SERVICE, Object.class, "/security/cond_access/ping", true, null, null, r104));     // Catch: Throwable -> L7
    L9:
        rwb.a.InterfaceC7547a r106 = this.$callback;
        Throwable r107 = Result.m9452exceptionOrNullimpl(r105);
        if (r107 != null) goto L24;
        dm9.a r108 = (dm9.a) r105;
        if ((r108 instanceof dm9.a.b) == false) goto L18;
        dm9.a.b r109 = (dm9.a.b) r108;
        if (r109.f469231a.isSuccess() == false) goto L16;
        FLogger.f375446a.i("FlowCondAccessPing", "Flow conditional access ping success");
        this.$callback.onSuccess();
    L21:
        return Unit.INSTANCE;
    L16:
        FLogger.f375446a.w("FlowCondAccessPing", "Flow conditional access ping biz failed, code=" + r109.f469231a.getCode());
        this.$callback.onError((int) r109.f469231a.getCode(), r109.f469231a.getMsg());
        goto L21
    L18:
        if ((r108 instanceof dm9.a.C5690a) == false) goto L23;
        FLogger r110 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("Flow conditional access ping http failed, code=");
        dm9.a.C5690a r112 = (dm9.a.C5690a) r108;
        r111.append(r112.f469228a);
        r110.w("FlowCondAccessPing", r111.toString());
        this.$callback.onError(r112.f469228a, r112.f469229b);
        goto L21
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        FLogger.f375446a.w("FlowCondAccessPing", "Flow conditional access ping failed: " + r107.getMessage());
        r106.onError(-1, r107.getMessage());
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
