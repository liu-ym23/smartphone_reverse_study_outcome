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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.mssdk.impl.SecurityServiceImpl$report$1", f = "SecurityServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SecurityServiceImpl$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $scene;
    final /* synthetic */ boolean $withDid;
    int label;

    public SecurityServiceImpl$report$1(boolean r100, String r101, Continuation<? super SecurityServiceImpl$report$1> r102) {
        this.$withDid = r100;
        this.$scene = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SecurityServiceImpl$report$1(this.$withDid, this.$scene, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SecurityServiceImpl$report$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r100);
        MSManager r101 = MSManagerUtils.get(String.valueOf(AppHost.f326268a.getAppId()));
        String r102 = null;
        boolean r103 = true;
        if (this.$withDid == false) goto L15;
        String r104 = IApplog.f287053a.getDeviceId();
        if (r104.length() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        r104 = null;
    L13:
        if (r104 == null) goto L15;
        r101.setDeviceID(r104);
        goto L15
    L9:
        r105 = false;
    L15:
        IApplog.Companion r106 = IApplog.f287053a;
        String r107 = r106.getInstallId();
        if (r107.length() > 0) goto L19;
        r103 = false;
    L19:
        if (r103 == false) goto L21;
        r102 = r107;
    L21:
        if (r102 == null) goto L23;
        r101.setInstallID(r102);
    L23:
        r101.report(this.$scene);
        JSONObject r108 = new JSONObject();
        r108.put("scene", this.$scene);
        Unit r109 = Unit.INSTANCE;
        r106.reportEvent("ms_report", r108);
        return Unit.INSTANCE;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
