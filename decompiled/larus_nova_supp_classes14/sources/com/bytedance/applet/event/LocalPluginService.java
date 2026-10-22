package com.bytedance.applet.event;

import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.p1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.f2;
import com.larus.platform.api.j2;
import com.larus.platform.api.p2;
import com.larus.platform.service.DoraAudioService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LocalPluginService {
    public static final LocalPluginService a = null;
    public static final Gson b = null;
    public static Integer c;
    public static p2 d;
    public static int e;
    public static final p f = null;
    public static final q g = null;
    public static final CopyOnWriteArraySet<a> h = null;
    public static final CopyOnWriteArraySet<b> i = null;
    public static final CoroutineScope j = null;
    public static final CoroutineScope k = null;
    public static final MutexImpl l = null;
    public static final ExecutorCoroutineDispatcher m = null;
    public static int n;
    public static final AtomicBoolean o = null;
    public static final AtomicBoolean p = null;

    public interface b {
        void a();
    }

    public static final class c implements com.larus.platform.api.o {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void a(int r1) {
        }

        public final void onStateChange(int r4) {
            LocalPluginService.n = r4;
            boolean r0 = true;
            if (r4 != 1) goto L5;
            FLogger.a.i("LocalPluginService", "Dora WAKE_OFF");
            LocalPluginService r5 = LocalPluginService.a;
            LocalPluginService.c();
            return;
        L5:
            if (r4 != 2) goto L34;
            FLogger r6 = FLogger.a;
            r6.i("LocalPluginService", "Dora WAKE_UP");
            LocalPluginService r2 = LocalPluginService.a;
            if (LocalPluginService.d() == false) goto L35;
            p2 r3 = LocalPluginService.d;
            if (r3 != null) goto L13;
        L15:
            r0 = false;
        L16:
            if (r0 == true) goto L19;
            return;
        L19:
            if (AppHost.a.a().isAppBackground() == false) goto L37;
            LocalPluginService.g();
            p2 r1 = LocalPluginService.d;
            if (r1 == null) goto L32;
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L25
            r6.i("LocalPluginService", "reconnectFrontier");     // Catch: Throwable -> L25
            r1.a(null, "localPlugin");     // Catch: Throwable -> L25
            t0.b(new s(), 4000);     // Catch: Throwable -> L25
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L27:
            Result.box-impl(r8);
            return;
        L25:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L27
        L32:
            return;
        L37:
            return;
        L13:
            if (r3.c() != 0) goto L15;
        L35:
            return;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            if (AppHost.a.isDebug() == true) goto L6;
            FLogger.a.e("LocalPluginService", "error , msg = " + ExceptionsKt.stackTraceToString(r4));
            return;
        L6:
            throw r4;
        }
    }

    public LocalPluginService() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.applet.event.p] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.applet.event.q] */
    static {
        a = new LocalPluginService();
        b = new Gson();
        f = new p();
        g = new q();
        h = new CopyOnWriteArraySet();
        i = new CopyOnWriteArraySet();
        j = CoroutineScopeKt.MainScope();
        k = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new d(CoroutineExceptionHandler.Key)));
        l = kotlinx.coroutines.sync.b.a();
        m = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new r()));
        o = new AtomicBoolean(false);
        p = new AtomicBoolean(false);
    }

    public static boolean d() {
        boolean r0 = f2.a.enableReconnectFrontierForDoraWhenBackground();
        FLogger.a.i("LocalPluginService", "enable reconnect frontier for dora is " + r0);
        return r0;
    }

    public static void e() {
        if (p.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(j, null, null, new LocalPluginService$init$1(null), 3, null);
        if (d() == false) goto L11;
        Lazy r0 = DoraAudioService.a;
        c r1 = c.a;
        Intrinsics.checkNotNullParameter(r1, "callback");
        j2 r2 = DoraAudioService.c();
        if (r2 == null) goto L12;
        r2.f(r1);
        return;
    L12:
        return;
    }

    public static void g() {
        jw3.c r0 = jw3.c.a;
        jw3.e r1 = jw3.c.d.get();
        if (r1 == null) goto L26;
        int r2 = r1.e();
        FLogger.a.i("LocalPluginService", "updateFrontier " + r2);
        Integer r3 = c;
        if (r3 != null) goto L8;
    L9:
        c = Integer.valueOf(r2);
        p2 r4 = d;
        if (r4 == null) goto L12;
        r4.d(f);
    L12:
        p2 r5 = d;
        if (r5 == null) goto L15;
        r5.g(g);
    L15:
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L18;
        p1 r7 = r6.B(r2);
    L19:
        d = r7;
        if (r7 == null) goto L22;
        r7.b(f);
    L22:
        p2 r8 = d;
        if (r8 == null) goto L28;
        r8.i(g);
        return;
    L28:
        return;
    L18:
        r7 = null;
        goto L19
    L8:
        if (r3.intValue() != r2) goto L9;
        return;
    }

    public static final void a() {
        if (d() == false) goto L17;
        p2 r0 = d;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        return;
    L12:
        if (AppHost.a.a().isAppBackground() == true) goto L14;
        return;
    L14:
        if (n != 1) goto L20;
        c();
        return;
    L20:
        return;
    L7:
        if (r0.c() != 1) goto L9;
        r1 = true;
        goto L10
    }

    public static void c() {
        if (d() == true) goto L5;
        return;
    L5:
        p2 r0 = d;
        if (r0 == null) goto L10;
        boolean r2 = true;
        if (r0.c() != 1) goto L10;
    L11:
        if (r2 == true) goto L14;
        return;
    L14:
        if (AppHost.a.a().isAppBackground() == true) goto L17;
        return;
    L17:
        if (o.get() == false) goto L19;
        return;
    L19:
        p2 r1 = d;
        if (r1 == null) goto L29;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L23
        FLogger.a.i("LocalPluginService", "disconnectFrontier");     // Catch: Throwable -> L23
        r1.h("localPlugin", false);     // Catch: Throwable -> L23
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Result.box-impl(r4);
        return;
    L23:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L29:
        return;
    L10:
        r2 = false;
        goto L11
    }

    public final Object f(byte[] r5, Continuation<? super Boolean> r6) {
        if ((r6 instanceof LocalPluginService$sendPayload$1) == false) goto L7;
        LocalPluginService$sendPayload$1 r0 = (LocalPluginService$sendPayload$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L17:
        Boolean r8 = (Boolean) r7;
        if (r8 == null) goto L20;
        boolean r9 = r8.booleanValue();
    L22:
        return Boxing.boxBoolean(r9);
    L20:
        r9 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        LocalPluginService$sendPayload$2 r10 = new LocalPluginService$sendPayload$2(r5, null);
        r0.label = 1;
        r7 = TimeoutKt.c(2000, r10, r0);
        if (r7 != r2) goto L17;
        return r2;
    L7:
        r0 = new LocalPluginService$sendPayload$1(this, r6);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x008a -> B:34:0x008f). Please report as a decompilation issue!!! */
    public static final Object b(LocalPluginService r7, byte[] r8, int r9, Object r10, Continuation r11) {
        r7.getClass();
        if ((r11 instanceof LocalPluginService$sendPayloadWithRetry$1) == false) goto L7;
        LocalPluginService$sendPayloadWithRetry$1 r0 = (LocalPluginService$sendPayloadWithRetry$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L20;
        if (r2 != 1) goto L19;
        int r14 = r0.I$2;
        int r15 = r0.I$1;
        int r16 = r0.I$0;
        jw3.e r3 = (jw3.e) r0.L$2;
        Object r5 = r0.L$1;
        byte[] r6 = (byte[]) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14 Exception -> L16
    L35:
        if (((Boolean) r12).booleanValue() == false) goto L39;
        FLogger.a.i("LocalPluginService", "Send ack succeeded on attempt " + (r14 + 1));     // Catch: Throwable -> L14 Exception -> L16
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L14 Exception -> L16
        if (r3 == null) goto L64;
        r3.d(r5);
        return r17;
    L64:
        return r17;
    L39:
        r14 = r15 + 1;
        r9 = r16;
        r10 = r5;
        byte[] r18 = r6;
    L21:
        if (r14 >= r9) goto L43;
        if (r3 != null) goto L63;
    L25:
        LocalPluginService r19 = a;     // Catch: Throwable -> L44 Exception -> L46
        p2 r20 = d;     // Catch: Throwable -> L44 Exception -> L46
        if (r20 == null) goto L28;
        int r21 = r20.c();     // Catch: Throwable -> L44 Exception -> L46
    L29:
        if (r21 != 1) goto L41;
        r0.L$0 = r18;     // Catch: Throwable -> L44 Exception -> L46
        r0.L$1 = r10;     // Catch: Throwable -> L44 Exception -> L46
        r0.L$2 = r3;     // Catch: Throwable -> L44 Exception -> L46
        r0.I$0 = r9;     // Catch: Throwable -> L44 Exception -> L46
        r0.I$1 = r14;     // Catch: Throwable -> L44 Exception -> L46
        r0.I$2 = r14;     // Catch: Throwable -> L44 Exception -> L46
        r0.label = 1;     // Catch: Throwable -> L44 Exception -> L46
        Object r22 = r19.f(r18, r0);     // Catch: Throwable -> L44 Exception -> L46
        if (r22 == r13) goto L66;
        r6 = r18;
        r12 = r22;
        r5 = r10;
        r16 = r9;
        r15 = r14;
        goto L35
    L66:
        return r13;
    L41:
        throw new IllegalStateException("Frontier disconnected");     // Catch: Throwable -> L44 Exception -> L46
    L28:
        r21 = 0;
        goto L29
    L63:
        r3.b(r10, r14 + 1);     // Catch: Throwable -> L44 Exception -> L46
    L46:
        e = e;
        r5 = r10;
    L48:
        String r23 = "Send ack failed: " + e.getMessage();     // Catch: Throwable -> L14
        if (r3 == null) goto L51;
        r3.g(r5, r23);     // Catch: Throwable -> L14
    L51:
        FLogger.a.e("LocalPluginService", r23);     // Catch: Throwable -> L14
        if (r3 == null) goto L55;
        r3.d(r5);
    L55:
        return Unit.INSTANCE;
    L44:
        th = th;
    L57:
        if (r3 == null) goto L59;
        r3.d(r10);
    L59:
        throw th;
    L43:
        throw new IllegalStateException("Send ack failed after " + r9 + " retries");     // Catch: Throwable -> L44 Exception -> L46
    L16:
        e = e;
    L14:
        th = th;
        r10 = r5;
        goto L57
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r12);
        jw3.c r24 = jw3.c.a;
        r3 = jw3.c.d.get();
        r18 = r8;
        r14 = 0;
    L7:
        r0 = new LocalPluginService$sendPayloadWithRetry$1(r7, r11);
        goto L8
    }
}
