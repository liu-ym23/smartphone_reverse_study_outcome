package com.larus.voicecall.impl.utils;

import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeMobUtil$mobRealtimeCallRouterStart$1", f = "RealtimeMobUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeMobUtil$mobRealtimeCallRouterStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ String $trackParams;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    public RealtimeMobUtil$mobRealtimeCallRouterStart$1(String r100, String r101, String r102, String r103, Continuation<? super RealtimeMobUtil$mobRealtimeCallRouterStart$1> r104) {
        this.$url = r100;
        this.$enterMethod = r101;
        this.$botId = r102;
        this.$trackParams = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        RealtimeMobUtil$mobRealtimeCallRouterStart$1 r102 = new RealtimeMobUtil$mobRealtimeCallRouterStart$1(this.$url, this.$enterMethod, this.$botId, this.$trackParams, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RealtimeMobUtil$mobRealtimeCallRouterStart$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$url;
        String r103 = this.$enterMethod;
        String r104 = this.$botId;
        String r105 = this.$trackParams;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L11
        r107.put("scheme", r102);     // Catch: Throwable -> L11
        r107.put("enter_method", r103);     // Catch: Throwable -> L11
        r107.put("bot_id", r104);     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r105) == true) goto L8;
        String r108 = BdpAppEventConstant.TRUE;
    L9:
        r107.put("valid_track_params", r108);     // Catch: Throwable -> L11
        Object r109 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r109) == false) goto L16;
        r109 = null;
    L16:
        JSONObject r110 = (JSONObject) r109;
        FLogger r111 = FLogger.f375446a;
        int r112 = RealtimeMobUtil.f379512a;
        r111.i("RealtimeMobUtil", "mobRealtimeCallRouterStart, params = " + r110);
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("voice_call_scheme_router_start", r110, null, null);
        return Unit.INSTANCE;
    L8:
        r108 = BdpAppEventConstant.FALSE;
    L11:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
