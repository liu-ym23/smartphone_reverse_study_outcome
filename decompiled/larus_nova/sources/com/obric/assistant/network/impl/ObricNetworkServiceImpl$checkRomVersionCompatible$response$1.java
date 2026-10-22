package com.obric.assistant.network.impl;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/obric/assistant/network/api/bean/ObricCheckRomCompatibleResponse;", "Lcom/obric/assistant/network/impl/ObricProtocolApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$checkRomVersionCompatible$response$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {1768}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$checkRomVersionCompatible$response$1 extends SuspendLambda implements Function2<ObricProtocolApi, Continuation<? super BizResponse<vea.d>>, Object> {
    final /* synthetic */ vea.c $request;
    private /* synthetic */ Object L$0;
    int label;

    public ObricNetworkServiceImpl$checkRomVersionCompatible$response$1(vea.c r100, Continuation<? super ObricNetworkServiceImpl$checkRomVersionCompatible$response$1> r101) {
        this.$request = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricNetworkServiceImpl$checkRomVersionCompatible$response$1 r102 = new ObricNetworkServiceImpl$checkRomVersionCompatible$response$1(this.$request, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ObricProtocolApi r100, Continuation<? super BizResponse<vea.d>> r101) {
        return ((ObricNetworkServiceImpl$checkRomVersionCompatible$response$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ObricProtocolApi r100, Continuation<? super BizResponse<vea.d>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ObricProtocolApi r103 = (ObricProtocolApi) this.L$0;
        vea.c r104 = this.$request;
        this.label = 1;
        r100 = r103.checkRomVersionCompatible(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
