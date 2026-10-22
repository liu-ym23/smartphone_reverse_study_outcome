package com.bytedance.applet.debugger;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/bytedance/applet/debugger/AppletDebuggerAgentTraceData;", "Lcom/bytedance/applet/debugger/AppletDebuggerAgentTraceApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2", f = "AppletDebuggerAgentTraceApi.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2 extends SuspendLambda implements Function2<AppletDebuggerAgentTraceApi, Continuation<? super BizResponse<e>>, Object> {
    final /* synthetic */ String $logId;
    final /* synthetic */ String $token;
    final /* synthetic */ String $xTtToken;
    private /* synthetic */ Object L$0;
    int label;

    public AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2(String r1, String r2, String r3, Continuation<? super AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2> r4) {
        this.$logId = r1;
        this.$token = r2;
        this.$xTtToken = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2 r0 = new AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2(this.$logId, this.$token, this.$xTtToken, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(AppletDebuggerAgentTraceApi r1, Continuation<? super BizResponse<e>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((AppletDebuggerAgentTraceApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        AppletDebuggerAgentTraceApi r7 = (AppletDebuggerAgentTraceApi) this.L$0;
        String r2 = this.$logId;
        String r3 = this.$token;
        String r4 = this.$xTtToken;
        this.label = 1;
        r6 = r7.getAgentTrace(r2, r3, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
