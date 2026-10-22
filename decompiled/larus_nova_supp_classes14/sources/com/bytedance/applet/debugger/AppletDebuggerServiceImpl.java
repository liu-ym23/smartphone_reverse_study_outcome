package com.bytedance.applet.debugger;

import android.content.ClipData;
import android.content.Context;
import com.bytedance.ai.api.DebuggerMode;
import com.bytedance.ai.api.DebuggerOpenArgs;
import com.bytedance.ai.api.IAppletDebuggerService;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.NativeDebugPanelType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.home.impl.sdk.i1;
import com.larus.im.FlowRuntime;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u000e\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/applet/debugger/AppletDebuggerServiceImpl;", "Lcom/bytedance/ai/api/IAppletDebuggerService;", "<init>", "()V", "entryStateController", "Lcom/bytedance/applet/debugger/AppletDebuggerEntryStateController;", "conversationCreator", "Lcom/bytedance/applet/debugger/DebuggerConversationCreator;", "entryState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/platform/api/AppletDebuggerEntryState;", "refreshEntryState", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAndOpenSession", "", "context", "Landroid/content/Context;", "entryFrom", "", "mode", "Lcom/bytedance/ai/api/DebuggerMode;", "msgContent", "(Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/ai/api/DebuggerMode;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDebuggerMessageMenuItems", "Lcom/larus/platform/api/creation/IBaseMenuItem;", "messageContext", "Lcom/larus/platform/api/AppletDebuggerMessageContext;", "onDebuggerMessageMenuClick", "androidContext", "action", "getAppletDebugBigProfileAvatarDrawableId", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletDebuggerServiceImpl implements IAppletDebuggerService {
    public final AppletDebuggerEntryStateController a;
    public final DebuggerConversationCreator b;

    public static final class a {
    }

    static {
    }

    public final void a() {
    }

    public final StateFlowImpl f() {
        return this.a.c;
    }

    public AppletDebuggerServiceImpl() {
        this.a = new AppletDebuggerEntryStateController(0);
        this.b = new DebuggerConversationCreator();
    }

    public final Object b(Continuation<? super Unit> r2) {
        Object r3 = this.a.b(r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public final l0 e(com.larus.platform.api.e r46) {
        Intrinsics.checkNotNullParameter(r46, "messageContext");
        String r1 = r46.a;
        if (Intrinsics.areEqual(r1, "agent_trace") == false) goto L30;
        String r2 = r46.e;
        boolean r3 = true;
        if (r2 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L33;
        String r5 = r46.f;
        if (r5 != null) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == true) goto L34;
        String r0 = r46.c;
        if (r0 != null) goto L23;
    L26:
        if (r3 == true) goto L37;
        int r7 = b.a;
        return new l0(2131894369, 2131894369, FlowRuntime.a().getApplication().getString(2131894369), null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971997, null, 2131242797)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4104, 127);
    L37:
        return null;
    L23:
        if (StringsKt.isBlank(r0) == true) goto L26;
        r3 = false;
        goto L26
    L34:
        return null;
    L15:
        if (StringsKt.isBlank(r5) == true) goto L18;
        r6 = false;
        goto L19
    L33:
        return null;
    L7:
        if (StringsKt.isBlank(r2) == true) goto L10;
        r4 = false;
        goto L11
    L30:
        if (Intrinsics.areEqual(r1, "copy_logid") == false) goto L36;
        int r8 = d.a;
        return new l0(2131894378, 2131894378, FlowRuntime.a().getApplication().getString(2131894378), null, null, null, null, null, null, false, false, null, Integer.valueOf(v19.c.b(2130971813, null, 2131241927)), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4104, 127);
    L36:
        return null;
    }

    public final boolean c(Context r18, String r19, com.larus.platform.api.e r20) {
        Intrinsics.checkNotNullParameter(r18, "androidContext");
        Intrinsics.checkNotNullParameter(r19, "action");
        Intrinsics.checkNotNullParameter(r20, "messageContext");
        String r4 = null;
        boolean r5 = true;
        if (Intrinsics.areEqual(r19, "copy_logid") == false) goto L16;
        int r1 = c.a;
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r20, "messageContext");
        String r2 = r20.e;
        if (r2 != null) goto L7;
    L57:
        r5 = false;
    L59:
        return r5;
    L7:
        if ((!StringsKt.isBlank(r2)) == false) goto L9;
        r4 = r2;
    L9:
        if (r4 == null) goto L57;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L14;
        r3.d0();
        i1.a.i(r18, ClipData.newPlainText("logid", r4), "bpea-applet-debugger-copy-logid");
    L14:
        t19.s.a.getClass();
        t19.s.o(r18, 2131910467, false);
        goto L59
    L16:
        if (Intrinsics.areEqual(r19, "agent_trace") == false) goto L62;
        CoroutineScope r0 = com.bytedance.applet.debugger.a.a;
        Intrinsics.checkNotNullParameter(r20, "messageContext");
        FLogger r6 = FLogger.a;
        r6.i("AppletDebugAgentTraceHandler", "agent trace clicked");
        String r7 = r20.e;
        if (r7 == null) goto L57;
        if ((!StringsKt.isBlank(r7)) == true) goto L23;
        r7 = null;
    L23:
        if (r7 == null) goto L57;
        String r8 = r20.f;
        if (r8 == null) goto L57;
        if ((!StringsKt.isBlank(r8)) == true) goto L31;
        r8 = null;
    L31:
        if (r8 == null) goto L57;
        String r9 = r20.c;
        if (r9 == null) goto L57;
        if ((!StringsKt.isBlank(r9)) == true) goto L39;
        r9 = null;
    L39:
        if (r9 == null) goto L57;
        Object r10 = com.bytedance.applet.debugger.a.d;
        monitor-enter(r10);
        com.bytedance.applet.debugger.a.e++;     // Catch: Throwable -> L54
        Job r11 = com.bytedance.applet.debugger.a.f;     // Catch: Throwable -> L54
        if (r11 == null) goto L46;
        Job.DefaultImpls.cancel$default(r11, null, 1, null);     // Catch: Throwable -> L54
    L46:
        com.bytedance.applet.debugger.a.f = null;     // Catch: Throwable -> L54
        com.bytedance.applet.debugger.a.g = null;     // Catch: Throwable -> L54
        long r14 = com.bytedance.applet.debugger.a.e;     // Catch: Throwable -> L54
        monitor-exit(r10);
        boolean r12 = IAISDKDebugService.a.t(NativeDebugPanelType.AGENT_TRACE, GsonProtectorUtils.toJson(com.bytedance.applet.debugger.a.c, new AgentTracePanelStateData(0, r9, r8, r7, "loading", 1, null)), com.bytedance.applet.debugger.a.h, null);
        if (r12 == true) goto L51;
        r6.w("AppletDebugAgentTraceHandler", "show agent trace panel rejected");
    L51:
        if (r12 == true) goto L53;
        com.bytedance.applet.debugger.a.e(r14);
        goto L59
    L53:
        com.bytedance.applet.debugger.a.c(r14, BuildersKt.launch$default(com.bytedance.applet.debugger.a.a, null, CoroutineStart.LAZY, new AppletDebugAgentTraceHandler$handle$requestJob$1(r7, r8, r9, r14, null), 1, null));
    L54:
        th = move-exception;
        throw th;
    L62:
        return false;
    }

    public final Object d(Context r20, String r21, DebuggerMode r22, String r23, Continuation<? super Boolean> r24) {
        if ((r24 instanceof AppletDebuggerServiceImpl$createAndOpenSession$1) == false) goto L7;
        AppletDebuggerServiceImpl$createAndOpenSession$1 r2 = (AppletDebuggerServiceImpl$createAndOpenSession$1) r24;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L23;
        if (r5 == 1) goto L22;
        if (r5 == 2) goto L17;
        if (r5 != 3) goto L16;
        ResultKt.throwOnFailure(r0);
    L57:
        return Boxing.boxBoolean(false);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        x r6 = (x) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L20
    L45:
        FLogger.a.i("AppletDebuggerService", "Debugger Activity opened");     // Catch: Throwable -> L20
        Object r1 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L20
    L50:
        Throwable r7 = Result.exceptionOrNull-impl(r1);
        if (r7 == null) goto L64;
        FLogger.a.e("AppletDebuggerService", "open Debugger Activity failed", r7);
        DebuggerConversationCreator r8 = this.b;
        x.b r9 = (x.b) r6;
        String r10 = r9.a;
        String r11 = r9.b;
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 3;
        if (r8.a(r10, r11, r2) != r4) goto L57;
        return r4;
    L64:
        return r1;
    L20:
        th = th;
    L49:
        Result.Companion r12 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L22:
        String r13 = (String) r2.L$1;
        Context r14 = (Context) r2.L$0;
        ResultKt.throwOnFailure(r0);
        String r18 = r13;
    L32:
        Pair r15 = (Pair) r0;
        if (r15 != null) goto L36;
        FLogger.a.i("AppletDebuggerService", "create session failed: main conversation unavailable");
        return Boxing.boxBoolean(false);
    L36:
        w r16 = (w) r15.component1();
        x r17 = (x) r15.component2();
        if ((r17 instanceof x.b) == true) goto L40;
        FLogger.a.i("AppletDebuggerService", "create session failed: remote conversation unavailable");
        return Boxing.boxBoolean(false);
    L40:
        x.b r19 = (x.b) r17;
        DebuggerOpenArgs r25 = new DebuggerOpenArgs(r19.a, r19.b, r16.b, r16.c, r16.d, r18);
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L47
        MainCoroutineDispatcher r27 = Dispatchers.getMain();     // Catch: Throwable -> L47
        AppletDebuggerServiceImpl$createAndOpenSession$3$1 r28 = new AppletDebuggerServiceImpl$createAndOpenSession$3$1(r14, r25, null);     // Catch: Throwable -> L47
        r2.L$0 = r17;     // Catch: Throwable -> L47
        r2.L$1 = null;     // Catch: Throwable -> L47
        r2.label = 2;     // Catch: Throwable -> L47
        if (BuildersKt.withContext(r27, r28, r2) != r4) goto L44;
        return r4;
    L44:
        r6 = r17;
    L47:
        th = th;
        r6 = r17;
        goto L49
    L23:
        ResultKt.throwOnFailure(r0);
        AccountService r29 = AccountService.a;
        if (r29.isLogin().booleanValue() == true) goto L26;
    L58:
        FLogger.a.i("AppletDebuggerService", "create session skipped: account unavailable");
        return Boxing.boxBoolean(false);
    L26:
        if (StringsKt.isBlank(r29.getUserId()) == true) goto L58;
        DebuggerConversationCreator r30 = this.b;
        r2.L$0 = r20;
        r2.L$1 = r23;
        r2.label = 1;
        r0 = r30.c(r21, r22, r2);
        if (r0 != r4) goto L31;
        return r4;
    L31:
        r18 = r23;
        r14 = r20;
    L7:
        r2 = new AppletDebuggerServiceImpl$createAndOpenSession$1(this, r24);
        goto L8
    }
}
