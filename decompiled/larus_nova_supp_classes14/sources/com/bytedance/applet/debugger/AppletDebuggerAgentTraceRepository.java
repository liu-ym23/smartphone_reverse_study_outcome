package com.bytedance.applet.debugger;

import com.larus.network.FlowHttpConnection;
import com.larus.platform.api.b2;
import com.larus.platform.service.AccountService;
import com.larus.security.api.AzerothUtils;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletDebuggerAgentTraceRepository {

    public static final class a {
    }

    static {
    }

    public AppletDebuggerAgentTraceRepository() {
    }

    public final Object a(String r20, String r21, String r22, Continuation<? super e> r23) {
        if ((r23 instanceof AppletDebuggerAgentTraceRepository$fetch$1) == false) goto L7;
        AppletDebuggerAgentTraceRepository$fetch$1 r2 = (AppletDebuggerAgentTraceRepository$fetch$1) r23;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r2.label;
        Continuation r1 = null;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
        String r10 = "AppletDebugAgentTrace";
        String r11 = ", msg=";
        r1 = r1;
    L53:
        dm9.a.b r5 = (dm9.a) r0;
        if ((r5 instanceof dm9.a.b) == false) goto L62;
        dm9.a.b r6 = r5;
        if (r6.a.isSuccess() == false) goto L60;
        e r12 = (e) r6.a.getData();
        if (r12 != null) goto L80;
        FLogger.a.w(r10, "get agent trace succeeded but data is empty");
        return r12;
    L80:
        return r12;
    L60:
        FLogger.a.w(r10, "get agent trace failed, code=" + r6.a.getCode() + r11 + r6.a.getMsg());
    L65:
        return r1;
    L62:
        if ((r5 instanceof dm9.a.a) == false) goto L67;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("get agent trace request failed, code=");
        dm9.a.a r9 = (dm9.a.a) r5;
        r8.append(r9.a);
        r8.append(r11);
        r8.append(r9.b);
        r7.e(r10, r8.toString(), r9.c);
        goto L65
    L67:
        throw new NoWhenBranchMatchedException();
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Continuation r14 = (String) r2.L$1;
        String r15 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);
        Continuation r16 = r14;
    L36:
        dm9.a.b r17 = (dm9.a) r0;
        if ((r17 instanceof dm9.a.b) == false) goto L71;
        dm9.a.b r18 = r17;
        if (r18.a.isSuccess() == true) goto L42;
        FLogger.a.w("AppletDebugAgentTrace", "save debug token failed, code=" + r18.a.getCode() + ", msg=" + r18.a.getMsg());
        return r1;
    L42:
        String r19 = AccountService.a.getXTTToken();
        if (r19 != null) goto L45;
    L68:
        FLogger.a.w(r10, "get agent trace skipped: X-Tt-Token is empty");
        return r1;
    L45:
        if ((!StringsKt.isBlank(r19)) == true) goto L48;
        r19 = r1;
    L48:
        if (r19 == null) goto L68;
        AppletDebuggerAgentTraceApi.a r24 = AppletDebuggerAgentTraceApi.a;
        r2.L$0 = r1;
        r2.L$1 = r1;
        r2.label = 2;
        r24.getClass();
        FlowHttpConnection r25 = FlowHttpConnection.a;
        r0 = FlowHttpConnection.i("AISDK", AppletDebuggerAgentTraceApi.class, new AppletDebuggerAgentTraceApi$Companion$getAgentTrace$2(r15, r16, r19, r1), "/app_developer/debugger/agent_trace", null, b2.a.e(), r2, 96);
        if (r0 != r13) goto L53;
        return r13;
    L71:
        if ((r17 instanceof dm9.a.a) == false) goto L75;
        FLogger r26 = FLogger.a;
        StringBuilder r27 = new StringBuilder("save debug token request failed, code=");
        dm9.a.a r28 = (dm9.a.a) r17;
        r27.append(r28.a);
        r27.append(r11);
        r27.append(r28.b);
        r26.e(r10, r27.toString(), r28.c);
        return r1;
    L75:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r0);
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L19
        AzerothUtils r30 = AzerothUtils.a;     // Catch: Throwable -> L19
        Object r31 = Result.constructor-impl(AzerothUtils.b(r20, r21, r22));     // Catch: Throwable -> L19
    L21:
        Throwable r32 = Result.exceptionOrNull-impl(r31);
        if (r32 == null) goto L25;
        FLogger.a.e("AppletDebugAgentTrace", "generate fornax token failed", r32);
        r31 = r1;
    L25:
        Continuation r33 = (String) r31;
        if (r33 != null) goto L28;
    L76:
        FLogger.a.w("AppletDebugAgentTrace", "generate fornax token returned empty");
        return r1;
    L28:
        if ((!StringsKt.isBlank(r33)) == true) goto L31;
        r33 = r1;
    L31:
        if (r33 == null) goto L76;
        r r34 = new r(CollectionsKt.listOf(new q(r20, r33)));
        AppletDebuggerAgentTraceApi.a r35 = AppletDebuggerAgentTraceApi.a;
        r2.L$0 = r20;
        r2.L$1 = r33;
        r2.label = 1;
        r35.getClass();
        FlowHttpConnection r36 = FlowHttpConnection.a;
        Object r37 = FlowHttpConnection.g("Basic", AppletDebuggerAgentTraceApi.class, new AppletDebuggerAgentTraceApi$Companion$saveDebugToken$2(r34, r1), true, "/alice/debug/save_token", null, null, r2, 224);
        if (r37 != r13) goto L35;
        return r13;
    L35:
        r16 = r33;
        r0 = r37;
        r15 = r20;
    L19:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new AppletDebuggerAgentTraceRepository$fetch$1(this, r23);
        goto L8
    }
}
