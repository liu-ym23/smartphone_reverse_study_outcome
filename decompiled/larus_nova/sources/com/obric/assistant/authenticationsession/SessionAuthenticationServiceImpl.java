package com.obric.assistant.authenticationsession;

import android.os.Build;
import android.os.CancellationSignal;
import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.AuthenticationType;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.n4;
import com.obric.assistant.o4;
import com.obric.assistant.t1;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001'\b\u0007\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010-\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\bH\u0016J\b\u00100\u001a\u00020\bH\u0017J\b\u00101\u001a\u00020\u001bH\u0016J\u0018\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\bH\u0016J\u0018\u00105\u001a\u00020*2\u0006\u00105\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\bH\u0016J\u0018\u00106\u001a\u00020*2\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020*H\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0014\u00108\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020:09H\u0016J'\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010#2\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0002\u0010AJ/\u0010B\u001a\u00020*2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010#2\u0006\u0010?\u001a\u00020@2\u0006\u0010C\u001a\u00020\bH\u0016¢\u0006\u0002\u0010DJ7\u0010E\u001a\u00020*2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010#2\u0006\u0010?\u001a\u00020@2\u0006\u0010C\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH\u0002¢\u0006\u0002\u0010GJ\u0018\u0010H\u001a\u00020*2\u0006\u0010<\u001a\u00020=2\u0006\u0010?\u001a\u00020@H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0IH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0IH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0IH\u0016J'\u0010J\u001a\u00020*2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010#2\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0002\u0010AJ \u0010K\u001a\u00020*2\u0006\u0010<\u001a\u00020=2\u0006\u0010?\u001a\u00020@2\u0006\u0010L\u001a\u00020MH\u0003J\b\u0010N\u001a\u00020*H\u0002J\u001a\u0010O\u001a\u00020*2\u0006\u0010P\u001a\u00020\u001b2\b\b\u0002\u0010Q\u001a\u00020\bH\u0002J\b\u0010R\u001a\u00020\bH\u0002J\u0016\u0010S\u001a\u00020\b2\u0006\u0010L\u001a\u00020MH\u0082@¢\u0006\u0002\u0010TJ\u0012\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010C\u001a\u00020\bH\u0002J8\u0010W\u001a\u00020*2\u0006\u0010<\u001a\u00020=2\u0006\u0010?\u001a\u00020@2\u0006\u0010L\u001a\u00020M2\u0006\u0010C\u001a\u00020\b2\u0006\u0010X\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH\u0003J\b\u0010Y\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(¨\u0006["}, d2 = {"Lcom/obric/assistant/authenticationsession/SessionAuthenticationServiceImpl;", "Lcom/obric/assistant/ISessionAuthenticationService;", "<init>", "()V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "isVoicePrintPass", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isBiometricPass", "isBiometricAuthenticating", "isDevicePass", "value", "isAuthenticationPass", "setAuthenticationPass", "(Z)V", "onSessionAuthenticationStateChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/IOnSessionAuthenticationStateChangedListener;", "workScope", "biometricAuthenticateCallbackExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getBiometricAuthenticateCallbackExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "biometricAuthenticateCallbackExecutor$delegate", "Lkotlin/Lazy;", "sessionIdHead", "", "sessionIdTail", "Ljava/util/concurrent/atomic/AtomicLong;", "_sessionId", "isVoicePrintAuthEnabled", "cachedAiFingerprintExist", "Ljava/lang/Boolean;", "aiFingerprintCacheUpdateTimeMs", "", "isRefreshingAiFingerprintCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "settingsChangedListener", "com/obric/assistant/authenticationsession/SessionAuthenticationServiceImpl$settingsChangedListener$1", "Lcom/obric/assistant/authenticationsession/SessionAuthenticationServiceImpl$settingsChangedListener$1;", "refreshVoicePrintAuthEnabledState", "", "init", "registerSessionAuthenticationStateChangedListener", "listener", "unregisterSessionAuthenticationStateChangedListener", "isVoicePrintAuthenticationOnLockScreenEnabled", "isNeedVoicePrintAuthentication", "getSessionId", "setVoicePrintState", "sessionId", "isPassed", "setBiometricState", "setDeviceState", "resetSessionState", "isAuthenticationPassV2", "Lkotlin/Pair;", "Lcom/obric/assistant/AuthenticationType;", "requestVoicePrintAuthentication", "params", "Lcom/obric/assistant/RequestAuthenticationParams;", "timeoutMillis", "callback", "Lcom/obric/assistant/RequestAuthenticationCallback;", "(Lcom/obric/assistant/RequestAuthenticationParams;Ljava/lang/Long;Lcom/obric/assistant/RequestAuthenticationCallback;)V", "requestBiometricAuthentication", "playTts", "(Lcom/obric/assistant/RequestAuthenticationParams;Ljava/lang/Long;Lcom/obric/assistant/RequestAuthenticationCallback;Z)V", "requestBiometricAuthenticationInternal", "waitAiFingerprintUnlockBeforeAuthenticate", "(Lcom/obric/assistant/RequestAuthenticationParams;Ljava/lang/Long;Lcom/obric/assistant/RequestAuthenticationCallback;ZZ)V", "requestDeviceCredentialAuthentication", "Lkotlinx/coroutines/flow/StateFlow;", "requestActivityAuthenticationOnLockAsync", "deviceCredentialAuthenticate", "cancellationSignal", "Landroid/os/CancellationSignal;", "monitorSessionLifeCycle", "refreshAiFingerprintExistCache", "reason", "force", "isAiFingerprintExistCached", "waitForAiFingerprintUnlock", "(Landroid/os/CancellationSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAuthenticationTtsIfNeeded", "Lkotlinx/coroutines/Job;", "biometricAuthenticate", "forceStartHelperActivity", "computeAuthenticationPass", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionAuthenticationServiceImpl implements ISessionAuthenticationService {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f385719r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f385720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateFlowImpl f385721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f385722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateFlowImpl f385723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StateFlowImpl f385724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f385725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.obric.assistant.n> f385726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f385727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f385728i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f385729j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicLong f385730k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile String f385731l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f385732m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile Boolean f385733n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile long f385734o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f385735p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f385736q;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b implements n4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f385737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SessionAuthenticationServiceImpl f385738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<Job> f385739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n4 f385740d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f385741e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ o4 f385742f;

        @Override // com.obric.assistant.n4
        public final void onAuthenticationCancelled() {
            if (this.f385737a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f385738b.f385723d.setValue(Boolean.FALSE);
            Job r100 = this.f385739c.element;
            if (r100 == null) goto L8;
            Job.DefaultImpls.cancel$default(r100, null, 1, null);
        L8:
            a(false);
            this.f385740d.onAuthenticationCancelled();
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationFailed() {
            if (this.f385737a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f385738b.f385723d.setValue(Boolean.FALSE);
            Job r100 = this.f385739c.element;
            if (r100 == null) goto L8;
            Job.DefaultImpls.cancel$default(r100, null, 1, null);
        L8:
            a(false);
            this.f385740d.onAuthenticationFailed();
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationNotAvailable() {
            if (this.f385737a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f385738b.f385723d.setValue(Boolean.FALSE);
            Job r100 = this.f385739c.element;
            if (r100 == null) goto L8;
            Job.DefaultImpls.cancel$default(r100, null, 1, null);
        L8:
            this.f385740d.onAuthenticationNotAvailable();
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationPass() {
            if (this.f385737a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f385738b.f385723d.setValue(Boolean.FALSE);
            Job r100 = this.f385739c.element;
            if (r100 == null) goto L8;
            Job.DefaultImpls.cancel$default(r100, null, 1, null);
        L8:
            a(true);
            this.f385740d.onAuthenticationPass();
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationTimeout() {
            if (this.f385737a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f385738b.f385723d.setValue(Boolean.FALSE);
            Job r100 = this.f385739c.element;
            if (r100 == null) goto L8;
            Job.DefaultImpls.cancel$default(r100, null, 1, null);
        L8:
            a(false);
            this.f385740d.onAuthenticationTimeout();
        }

        public final void a(boolean r100) {
            if (this.f385741e.element == false) goto L6;
            int r101 = com.obric.assistant.reporter.c.f391352a;
            com.obric.assistant.reporter.c.a(this.f385742f.f390384c, r100);
            return;
        }

        public b(SessionAuthenticationServiceImpl r100, Ref.ObjectRef<Job> r101, n4 r102, Ref.BooleanRef r103, o4 r104) {
            this.f385738b = r100;
            this.f385739c = r101;
            this.f385740d = r102;
            this.f385741e = r103;
            this.f385742f = r104;
            this.f385737a = new AtomicBoolean(false);
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class c implements n4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f385760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o4 f385761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ n4 f385762c;

        @Override // com.obric.assistant.n4
        public final void onAuthenticationCancelled() {
            if (this.f385760a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            int r100 = com.obric.assistant.reporter.c.f391352a;
            com.obric.assistant.reporter.c.a(this.f385761b.f390384c, false);
            this.f385762c.onAuthenticationCancelled();
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationFailed() {
            if (this.f385760a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            int r100 = com.obric.assistant.reporter.c.f391352a;
            com.obric.assistant.reporter.c.a(this.f385761b.f390384c, false);
            this.f385762c.onAuthenticationFailed();
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationNotAvailable() {
            if (this.f385760a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            this.f385762c.onAuthenticationNotAvailable();
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationPass() {
            if (this.f385760a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            int r100 = com.obric.assistant.reporter.c.f391352a;
            com.obric.assistant.reporter.c.a(this.f385761b.f390384c, true);
            this.f385762c.onAuthenticationPass();
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationTimeout() {
            if (this.f385760a.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            int r100 = com.obric.assistant.reporter.c.f391352a;
            com.obric.assistant.reporter.c.a(this.f385761b.f390384c, false);
            this.f385762c.onAuthenticationTimeout();
        }

        public c(o4 r100, n4 r101) {
            this.f385761b = r100;
            this.f385762c = r101;
            this.f385760a = new AtomicBoolean(false);
        }
    }

    public static final class d implements com.obric.assistant.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SessionAuthenticationServiceImpl f385763a;

        public d(SessionAuthenticationServiceImpl r100) {
            this.f385763a = r100;
        }

        @Override // com.obric.assistant.m
        public final void a(String r100) {
            SessionAuthenticationServiceImpl r101 = this.f385763a;
            int r102 = SessionAuthenticationServiceImpl.f385719r;
            BuildersKt.launch$default(r101.f385727h, null, null, new SessionAuthenticationServiceImpl$refreshVoicePrintAuthEnabledState$1(r101, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$isAuthenticationPass$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes32.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl$isAuthenticationPass$1", f = "SessionAuthenticationServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SessionAuthenticationServiceImpl this$0;

        public AnonymousClass1(SessionAuthenticationServiceImpl r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r100);
            SessionAuthenticationServiceImpl r101 = this.this$0;
            Iterator<T> r102 = r101.f385726g.iterator();
        L6:
            if (r102.hasNext() == false) goto L9;
            ((com.obric.assistant.n) r102.next()).a(r101.f385725f);
            goto L6
        L9:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final boolean b() {
        if (((Boolean) this.f385721b.getValue()).booleanValue() == false) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) this.f385722c.getValue()).booleanValue() == true) goto L8;
        return false;
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final Pair<Boolean, AuthenticationType> i() {
        if (((Boolean) this.f385722c.getValue()).booleanValue() == false) goto L6;
        return TuplesKt.to(Boolean.TRUE, AuthenticationType.Biometric);
    L6:
        if (((Boolean) this.f385721b.getValue()).booleanValue() == false) goto L9;
        return TuplesKt.to(Boolean.TRUE, AuthenticationType.VoicePrint);
    L9:
        return TuplesKt.to(Boolean.FALSE, AuthenticationType.INVALID);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.authenticationsession.k] */
    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void init() {
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "init");
        ?? r100 = new k(this);
        AppHost.f326268a.a().j(new m(r100, this));
        t1.f393353a.B0(this.f385736q);
        BuildersKt.launch$default(this.f385727h, null, null, new SessionAuthenticationServiceImpl$refreshVoicePrintAuthEnabledState$1(this, null), 3, null);
        c("init", true);
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final boolean m() {
        if (this.f385725f == false) goto L7;
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "isNeedVoicePrintAuthentication: isAuthenticationPass, return false");
        return false;
    L7:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L11;
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "isNeedVoicePrintAuthentication: Keyguard is not locked, return false");
        return false;
    L11:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L14;
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "isNeedVoicePrintAuthentication: Device is not locked, return false");
        return false;
    L14:
        boolean r100 = this.f385732m;
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "isNeedVoicePrintAuthentication: switch on = " + r100);
        return r100;
    }

    public SessionAuthenticationServiceImpl() {
        this.f385720a = CoroutineScopeKt.MainScope();
        Boolean r100 = Boolean.FALSE;
        this.f385721b = j1.a(r100);
        this.f385722c = j1.a(r100);
        this.f385723d = j1.a(r100);
        this.f385724e = j1.a(r100);
        this.f385726g = new CopyOnWriteArrayList();
        this.f385727h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f385728i = LazyKt.lazy(new h());
        String r101 = UUID.randomUUID().toString();
        this.f385729j = r101;
        AtomicLong r102 = new AtomicLong(1);
        this.f385730k = r102;
        this.f385731l = r101 + '_' + r102.get();
        this.f385735p = new AtomicBoolean(false);
        this.f385736q = new d(this);
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final String getSessionId() {
        return this.f385731l;
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final boolean isAuthenticationPass() {
        return this.f385725f;
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final i1<Boolean> k() {
        return this.f385721b;
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final i1<Boolean> l() {
        return this.f385723d;
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final boolean n() {
        return this.f385732m;
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final i1<Boolean> o() {
        return this.f385722c;
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void h(ClearContextInKeyguardServiceImpl.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f385726g.add(r100);
    }

    public final void q(boolean r100) {
        if (r100 == this.f385725f) goto L6;
        this.f385725f = r100;
        BuildersKt.launch$default(this.f385720a, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }

    public final void r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        FLogger r101 = FLogger.f375446a;
        r101.i("SessionAuthenticationServiceImpl", "setDeviceState: sessionId = " + r100 + ", isPassed = true");
        if (AppHost.f326268a.a().isAppBackground() == false) goto L6;
        r101.i("SessionAuthenticationServiceImpl", "setDeviceState: app is background, cannot change to passed");
        return;
    L6:
        this.f385724e.setValue(Boolean.TRUE);
    }

    public final void c(String r100, boolean r101) {
        long r102 = SystemClock.elapsedRealtime();
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        this.f385733n = Boolean.FALSE;
        this.f385734o = r102;
        return;
    L7:
        if (this.f385733n != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r101 == true) goto L16;
        if (r103 == false) goto L16;
        return;
    L16:
        if (this.f385735p.compareAndSet(false, true) == true) goto L19;
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "refreshAiFingerprintExistCache: already refreshing, reason=".concat(r100));
        return;
    L19:
        BuildersKt.launch$default(this.f385727h, null, null, new SessionAuthenticationServiceImpl$refreshAiFingerprintExistCache$1(this, r100, null), 3, null);
        return;
    L9:
        if ((r102 - this.f385734o) > 60000) goto L11;
        r103 = true;
        goto L12
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        FLogger r102 = FLogger.f375446a;
        r102.i("SessionAuthenticationServiceImpl", "setVoicePrintState: sessionId = " + r100 + ", isPassed = " + r101);
        if (Intrinsics.areEqual(this.f385731l, r100) == true) goto L6;
        r102.i("SessionAuthenticationServiceImpl", "setVoicePrintState: sessionId not match, current sessionId = " + this.f385731l);
        return;
    L6:
        if (r101 == true) goto L8;
    L11:
        this.f385721b.setValue(Boolean.valueOf(r101));
        q(b());
        return;
    L8:
        if (AppHost.f326268a.a().isAppBackground() == false) goto L11;
        r102.i("SessionAuthenticationServiceImpl", "setVoicePrintState: app is background, cannot change to passed");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, android.os.CancellationSignal] */
    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void e(o4 r110, n4 r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        FLogger r100 = FLogger.f375446a;
        r100.i("SessionAuthenticationServiceImpl", "requestDeviceCredentialAuthentication: params = " + r110);
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 23) goto L6;
        r100.w("SessionAuthenticationServiceImpl", "android api is too low: " + r101);
        r111.onAuthenticationFailed();
        return;
    L6:
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = new CancellationSignal();
        BuildersKt.launch$default(this.f385720a, Dispatchers.getMain(), null, new SessionAuthenticationServiceImpl$requestDeviceCredentialAuthentication$1(r110, this, new c(r110, r111), r102, null), 2, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x009a -> B:27:0x009c). Please report as a decompilation issue!!! */
    public static final Object a(SessionAuthenticationServiceImpl r110, CancellationSignal r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1) == false) goto L7;
        SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1 r100 = (SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        int r115 = r100.I$0;
        long r103 = r100.J$0;
        CancellationSignal r104 = (CancellationSignal) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L27:
        int r116 = r115 + 1;
        r111 = r104;
    L16:
        if (r111.isCanceled() == true) goto L28;
        boolean r105 = IKeyguardStateKt.getKeyguardState().isDeviceLocked();
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "waitForAiFingerprintUnlock: checkCount=" + r116 + ", isDeviceLocked=" + r105);
        if (r105 == false) goto L30;
        long r106 = SystemClock.elapsedRealtime() - r103;
        if (r106 >= 500) goto L28;
        long r107 = RangesKt.coerceAtMost(500 - r106, 100);
        r100.L$0 = r111;
        r100.J$0 = r103;
        r100.I$0 = r116;
        r100.label = 1;
        if (DelayKt.delay(r107, r100) == r114) goto L31;
        r104 = r111;
        r115 = r116;
        goto L27
    L31:
        return r114;
    L30:
        return Boxing.boxBoolean(true);
    L28:
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "waitForAiFingerprintUnlock: finish, unlocked=false, cost=" + (SystemClock.elapsedRealtime() - r103) + " ms, canceled=" + r111.isCanceled());
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        r103 = SystemClock.elapsedRealtime();
        r116 = 0;
    L7:
        r100 = new SessionAuthenticationServiceImpl$waitForAiFingerprintUnlock$1(r110, r112);
        goto L8
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void f(o4 r110, Long r111, n4 r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        if (r111 != null) goto L5;
    L13:
        long r100 = 15000;
    L14:
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "requestActivityAuthenticationOnLockAsync: reportParams=" + com.obric.assistant.common.utils.e.b(r110.f390384c) + ", params=" + r110 + ", timeoutMillis=" + r100);
        c("requestActivityAuthenticationOnLockAsync", false);
        p(r110, Long.valueOf(r100), r112, true, true);
        return;
    L5:
        if (r111.longValue() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        r111 = null;
    L11:
        if (r111 == null) goto L13;
        r100 = r111.longValue();
        goto L14
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void j(o4 r100, Long r101, n4 r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "requestVoicePrintAuthentication: timeoutMillis = " + r101 + ", isVoicePrintPass = " + this.f385721b + ", params = " + r100);
        if (((Boolean) this.f385721b.getValue()).booleanValue() == false) goto L6;
        r102.onAuthenticationPass();
        return;
    L6:
        if (this.f385732m == true) goto L8;
        r102.onAuthenticationNotAvailable();
        return;
    L8:
        r102.onAuthenticationFailed();
    }

    @Override // com.obric.assistant.ISessionAuthenticationService
    public final void g(o4 r100, Long r101, n4 r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        p(r100, r101, r110, r111, false);
    }

    public final void p(final o4 r110, final Long r111, final n4 r112, final boolean r113, final boolean r114) {
        FLogger.f375446a.i("SessionAuthenticationServiceImpl", "requestBiometricAuthentication: timeoutMillis = " + r111 + ", playTts = " + r113 + ", reportParams = " + com.obric.assistant.common.utils.e.b(r110.f390384c) + ", params = " + r110);
        t0.e(new g(r112, r111, this, r110, r113, r114));
    }
}
