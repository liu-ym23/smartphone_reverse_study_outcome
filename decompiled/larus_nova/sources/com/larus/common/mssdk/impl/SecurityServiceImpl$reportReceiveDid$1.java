package com.larus.common.mssdk.impl;

import com.bytedance.mobsec.metasec.ml.MSManager;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.larus.applog.api.IApplog;
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

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.mssdk.impl.SecurityServiceImpl$reportReceiveDid$1", f = "SecurityServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SecurityServiceImpl$reportReceiveDid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $did;
    final /* synthetic */ String $iid;
    int label;

    public SecurityServiceImpl$reportReceiveDid$1(String r100, String r101, Continuation<? super SecurityServiceImpl$reportReceiveDid$1> r102) {
        this.$did = r100;
        this.$iid = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SecurityServiceImpl$reportReceiveDid$1(this.$did, this.$iid, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SecurityServiceImpl$reportReceiveDid$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        MSManager r101 = MSManagerUtils.get(String.valueOf(AppHost.f326268a.getAppId()));
        r101.setDeviceID(this.$did);
        r101.setInstallID(this.$iid);
        r101.report("did-iid-update");
        IApplog.f287053a.reportEvent("ms_receive_did", null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
