package com.obric.update.impl.v2.handler;

import com.larus.common.apphost.AppHost;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.update.impl.v2.handler.ObricUpdateHandler$checkForceUpdateForRomUnmatched$isRomCompatible$1", f = "ObricUpdateHandler.kt", i = {}, l = {930}, m = "invokeSuspend", n = {}, s = {})
public final class ObricUpdateHandler$checkForceUpdateForRomUnmatched$isRomCompatible$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $curRomVersion;
    int label;

    public ObricUpdateHandler$checkForceUpdateForRomUnmatched$isRomCompatible$1(String r100, Continuation<? super ObricUpdateHandler$checkForceUpdateForRomUnmatched$isRomCompatible$1> r101) {
        this.$curRomVersion = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricUpdateHandler$checkForceUpdateForRomUnmatched$isRomCompatible$1(this.$curRomVersion, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((ObricUpdateHandler$checkForceUpdateForRomUnmatched$isRomCompatible$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = false;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L14:
        if (((Boolean) r100).booleanValue() == true) goto L17;
        r103 = true;
    L17:
        return Boxing.boxBoolean(!r103);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IObricNetworkService r104 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r104 == null) goto L17;
        AppHost.Companion r105 = AppHost.f326268a;
        String r106 = String.valueOf(r105.getUpdateVersionCode());
        String r107 = String.valueOf(r105.getManifestVersionCode());
        String r108 = this.$curRomVersion;
        this.label = 1;
        r100 = r104.u(r106, r107, r108, this);
        if (r100 != r101) goto L14;
        return r101;
    }
}
