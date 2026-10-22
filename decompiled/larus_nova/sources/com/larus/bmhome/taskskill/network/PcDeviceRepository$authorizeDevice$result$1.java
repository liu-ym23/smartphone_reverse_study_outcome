package com.larus.bmhome.taskskill.network;

import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.AuthorizeDeviceRequest;
import com.larus.dispatcher.api.GetAllDevicesApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/dispatcher/api/AllDeviceResponse;", "Lcom/larus/dispatcher/api/GetAllDevicesApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.network.PcDeviceRepository$authorizeDevice$result$1", f = "PcDeviceRepository.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class PcDeviceRepository$authorizeDevice$result$1 extends SuspendLambda implements Function2<GetAllDevicesApi, Continuation<? super BizResponse<BizResponse<AllDeviceResponse>>>, Object> {
    final /* synthetic */ String $authTicket;
    final /* synthetic */ String $targetDeviceId;
    private /* synthetic */ Object L$0;
    int label;

    public PcDeviceRepository$authorizeDevice$result$1(String r100, String r101, Continuation<? super PcDeviceRepository$authorizeDevice$result$1> r102) {
        this.$targetDeviceId = r100;
        this.$authTicket = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        PcDeviceRepository$authorizeDevice$result$1 r102 = new PcDeviceRepository$authorizeDevice$result$1(this.$targetDeviceId, this.$authTicket, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(GetAllDevicesApi r100, Continuation<? super BizResponse<BizResponse<AllDeviceResponse>>> r101) {
        return ((PcDeviceRepository$authorizeDevice$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(GetAllDevicesApi r100, Continuation<? super BizResponse<BizResponse<AllDeviceResponse>>> r101) {
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
        GetAllDevicesApi r103 = (GetAllDevicesApi) this.L$0;
        AuthorizeDeviceRequest r104 = new AuthorizeDeviceRequest(this.$targetDeviceId, this.$authTicket);
        this.label = 1;
        r100 = r103.authorizeDevice(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
