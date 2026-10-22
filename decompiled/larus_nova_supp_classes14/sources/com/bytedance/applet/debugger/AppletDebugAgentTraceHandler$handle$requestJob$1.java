package com.bytedance.applet.debugger;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebugAgentTraceHandler$handle$requestJob$1", f = "AppletDebugMenuItemCreator.kt", i = {}, l = {145, 163}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugAgentTraceHandler$handle$requestJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $logId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ long $requestId;
    final /* synthetic */ String $sectionId;
    int label;

    /* JADX INFO: renamed from: com.bytedance.applet.debugger.AppletDebugAgentTraceHandler$handle$requestJob$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebugAgentTraceHandler$handle$requestJob$1$1", f = "AppletDebugMenuItemCreator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $panelParamsJson;
        final /* synthetic */ long $requestId;
        int label;

        public AnonymousClass1(long r1, String r3, Continuation<? super AnonymousClass1> r4) {
            this.$requestId = r1;
            this.$panelParamsJson = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$requestId, this.$panelParamsJson, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r7);
            CoroutineScope r8 = a.a;
            long r0 = this.$requestId;
            String r9 = this.$panelParamsJson;
            Intrinsics.checkNotNull(r9);
            Object r2 = a.d;
            monitor-enter(r2);
        L19:
            th = move-exception;
            throw th;
        L7:
            if (a.e == r0) goto L9;
            boolean r1 = false;
        L11:
            monitor-exit(r2);
            if (r1 == false) goto L18;
            if (IAISDKDebugService.a.j("panel.launchParamsChanged", r9) == true) goto L18;
            FLogger.a.i("AppletDebugAgentTraceHandler", "defer agent trace panel state until panel is loaded");
        L18:
            return Unit.INSTANCE;
        L9:
            a.g = new a.C0055a(r0, r9);     // Catch: Throwable -> L19
            r1 = true;
            goto L11
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AppletDebugAgentTraceHandler$handle$requestJob$1(String r1, String r2, String r3, long r4, Continuation<? super AppletDebugAgentTraceHandler$handle$requestJob$1> r6) {
        this.$logId = r1;
        this.$sectionId = r2;
        this.$messageId = r3;
        this.$requestId = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AppletDebugAgentTraceHandler$handle$requestJob$1(this.$logId, this.$sectionId, this.$messageId, this.$requestId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r4 = true;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L45
    L43:
        CoroutineScope r14 = a.a;
        a.a(this.$requestId);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L32 CancellationException -> L34
    L16:
        e r15 = (e) r13;     // Catch: Throwable -> L32 CancellationException -> L34
        CoroutineScope r3 = a.a;     // Catch: Throwable -> L32 CancellationException -> L34
        long r5 = this.$requestId;     // Catch: Throwable -> L32 CancellationException -> L34
        Object r6 = a.d;     // Catch: Throwable -> L32 CancellationException -> L34
        monitor-enter(r6);     // Catch: Throwable -> L32 CancellationException -> L34
    L20:
        if (a.e == r5) goto L23;
        r4 = false;
    L23:
        monitor-exit(r6);     // Catch: Throwable -> L32 CancellationException -> L34
        if (r4 == true) goto L28;
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L32 CancellationException -> L34
        a.a(this.$requestId);
        return r16;
    L28:
        if (r15 == null) goto L30;
        Object r17 = a.b(r15, this.$logId, this.$sectionId, this.$messageId);     // Catch: Throwable -> L32 CancellationException -> L34
    L31:
        String r18 = a.c.toJson(r17);     // Catch: Throwable -> L32 CancellationException -> L34
    L40:
        MainCoroutineDispatcher r0 = Dispatchers.getMain();     // Catch: Throwable -> L45
        AnonymousClass1 r7 = new AnonymousClass1(this.$requestId, r18, null);     // Catch: Throwable -> L45
        this.label = 2;     // Catch: Throwable -> L45
        if (BuildersKt.withContext(r0, r7, this) != r1) goto L43;
        return r1;
    L30:
        r17 = new AgentTracePanelStateData(0, this.$messageId, this.$sectionId, this.$logId, "error", 1, null);     // Catch: Throwable -> L32 CancellationException -> L34
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32 CancellationException -> L34
    L12:
        ResultKt.throwOnFailure(r13);
        AppletDebuggerAgentTraceRepository r19 = a.b;     // Catch: Throwable -> L32 CancellationException -> L34
        String r8 = this.$logId;     // Catch: Throwable -> L32 CancellationException -> L34
        String r9 = this.$sectionId;     // Catch: Throwable -> L32 CancellationException -> L34
        String r10 = this.$messageId;     // Catch: Throwable -> L32 CancellationException -> L34
        this.label = 1;     // Catch: Throwable -> L32 CancellationException -> L34
        r13 = r19.a(r8, r9, r10, this);     // Catch: Throwable -> L32 CancellationException -> L34
        if (r13 != r1) goto L16;
        return r1;
    L45:
        th = move-exception;
        CoroutineScope r11 = a.a;
        a.a(this.$requestId);
        throw th;
    L34:
        e = move-exception;
        throw e;     // Catch: Throwable -> L45
    L32:
        th = move-exception;
        FLogger.a.e("AppletDebugAgentTraceHandler", "get agent trace failed unexpectedly, errorType=".concat(th.getClass().getSimpleName()), th);     // Catch: Throwable -> L45
        r18 = a.c.toJson(new AgentTracePanelStateData(0, this.$messageId, this.$sectionId, this.$logId, "error", 1, null));     // Catch: Throwable -> L45
        goto L40
    }
}
