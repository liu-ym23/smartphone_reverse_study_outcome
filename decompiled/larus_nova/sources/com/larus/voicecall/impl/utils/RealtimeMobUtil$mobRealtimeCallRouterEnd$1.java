package com.larus.voicecall.impl.utils;

import android.text.TextUtils;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
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
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeMobUtil$mobRealtimeCallRouterEnd$1", f = "RealtimeMobUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeMobUtil$mobRealtimeCallRouterEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $trackParams;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    public RealtimeMobUtil$mobRealtimeCallRouterEnd$1(String r100, String r101, String r102, String r103, boolean r104, String r105, Continuation<? super RealtimeMobUtil$mobRealtimeCallRouterEnd$1> r106) {
        this.$url = r100;
        this.$enterMethod = r101;
        this.$botId = r102;
        this.$trackParams = r103;
        this.$isSuccess = r104;
        this.$reason = r105;
        super(2, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        RealtimeMobUtil$mobRealtimeCallRouterEnd$1 r100 = new RealtimeMobUtil$mobRealtimeCallRouterEnd$1(this.$url, this.$enterMethod, this.$botId, this.$trackParams, this.$isSuccess, this.$reason, r111);
        r100.L$0 = r110;
        return r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RealtimeMobUtil$mobRealtimeCallRouterEnd$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$url;
        String r103 = this.$enterMethod;
        String r104 = this.$botId;
        String r105 = this.$trackParams;
        boolean r106 = this.$isSuccess;
        String r107 = this.$reason;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L15
        r109.put("scheme", r102);     // Catch: Throwable -> L15
        r109.put("enter_method", r103);     // Catch: Throwable -> L15
        r109.put("bot_id", r104);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r105) == true) goto L8;
        String r110 = BdpAppEventConstant.TRUE;
    L9:
        r109.put("valid_track_params", r110);     // Catch: Throwable -> L15
        if (r106 == false) goto L12;
        String r111 = "Success";
    L13:
        r109.put("result", r111);     // Catch: Throwable -> L15
        r109.put("reason", r107);     // Catch: Throwable -> L15
        Object r112 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r112) == false) goto L20;
        r112 = null;
    L20:
        JSONObject r113 = (JSONObject) r112;
        FLogger r114 = FLogger.f375446a;
        int r115 = RealtimeMobUtil.f379512a;
        r114.i("RealtimeMobUtil", "mobRealtimeCallRouterEnd, params = " + r113);
        com.larus.platform.service.g.f365738a.monitorEventForSlardar("voice_call_scheme_router_end", r113, null, null);
        return Unit.INSTANCE;
    L12:
        r111 = CheckStatus.FAIL;
        goto L13
    L8:
        r110 = BdpAppEventConstant.FALSE;
    L15:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
