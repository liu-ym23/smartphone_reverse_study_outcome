package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.SurfaceControl;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorPresentationBridgeService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricListeningMainProcessManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricListeningMainProcessManager f385330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f385331b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Channel<a> f385332c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f385333d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static IObricInteractorPresentationBridgeService f385334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f385335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile ObricListeningPresentationState f385336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f385337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Function0<Unit> f385338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static xaa.b f385339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static SurfaceControl f385340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f385341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f385342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f385343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static aba.a f385344o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f385345p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f385346q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f385347r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AtomicLong f385348s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AtomicReference<c> f385349t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static b f385350u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static String f385351v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ObricListeningMainProcessManager$callback$1 f385352w = null;

    /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager$1", f = "ObricListeningMainProcessManager.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:13:0x0039). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ChannelIterator<a> r102 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
            ChannelIterator<a> r103 = r102;
            Object r104 = r100;
            AnonymousClass1 r105 = this;
        L14:
            if (((Boolean) r110).booleanValue() == false) goto L28;
            final a r111 = r103.next();
            ObricListeningMainProcessManager.f385330a.getClass();
            r111.f385356d.invoke(r111.f385354b);     // Catch: Exception -> L18 CancellationException -> L20 RemoteException -> L22
        L26:
            AnonymousClass1 r112 = r105;
            r100 = r104;
            ChannelIterator<a> r106 = r103;
        L9:
            r112.L$0 = r106;
            r112.label = 1;
            Object r107 = r106.hasNext(r112);
            if (r107 != r100) goto L12;
            return r100;
        L12:
            Object r113 = r100;
            r105 = r112;
            r110 = r107;
            r103 = r106;
            r104 = r113;
            goto L14
        L22:
            e = move-exception;
            FLogger.f375446a.w("ObricListeningMainPM", "child bridge command failed, name=" + r111.f385353a + ", binder=" + r111.f385354b.asBinder().hashCode() + ", detach=" + r111.f385355c, e);
            if (r111.f385355c == false) goto L26;
            ObricListeningMainProcessManager.k(new l0(r111));
        L20:
            e = move-exception;
            throw e;
        L18:
            e = move-exception;
            FLogger.f375446a.w("ObricListeningMainPM", "child bridge command crashed, name=" + r111.f385353a + ", binder=" + r111.f385354b.asBinder().hashCode(), e);
            goto L26
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            r106 = ObricListeningMainProcessManager.f385332c.iterator();
            r112 = this;
            goto L9
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f385353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IObricInteractorPresentationBridgeService f385354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f385355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<IObricInteractorPresentationBridgeService, Unit> f385356d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f385353a, r101.f385353a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f385354b, r101.f385354b) == true) goto L15;
            return false;
        L15:
            if (this.f385355c == r101.f385355c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f385356d, r101.f385356d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f385353a.hashCode() * 31) + this.f385354b.hashCode()) * 31;
            if (this.f385355c == false) goto L5;
            int r101 = 1231;
        L7:
            return ((r100 + r101) * 31) + this.f385356d.hashCode();
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "BridgeCommand(name=" + this.f385353a + ", target=" + this.f385354b + ", detachOnFailure=" + this.f385355c + ", action=" + this.f385356d + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, IObricInteractorPresentationBridgeService r101, boolean r102, Function1<? super IObricInteractorPresentationBridgeService, Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r103, "action");
            this.f385353a = r100;
            this.f385354b = r101;
            this.f385355c = r102;
            this.f385356d = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f385357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f385358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f385359c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f385357a == r101.f385357a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f385358b, r101.f385358b) == true) goto L15;
            return false;
        L15:
            if (this.f385359c == r101.f385359c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f385357a * 31) + this.f385358b.hashCode()) * 31;
            long r101 = this.f385359c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "PendingChildFirstFrame(generation=" + this.f385357a + ", startupAttemptId=" + this.f385358b + ", timestampElapsedRealtimeMs=" + this.f385359c + ')';
        }

        public b(int r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r101, "startupAttemptId");
            this.f385357a = r100;
            this.f385358b = r101;
            this.f385359c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f385360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f385361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ObricListeningPresentationState f385362c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f385360a == r101.f385360a) goto L12;
            return false;
        L12:
            if (this.f385361b == r101.f385361b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f385362c, r101.f385362c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f385360a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            if (this.f385361b == false) goto L5;
            int r102 = 1231;
        L7:
            return ((r101 + r102) * 31) + this.f385362c.hashCode();
        L5:
            r102 = 1237;
            goto L7
        }

        public final String toString() {
            return "PendingFallbackSnapshot(sequence=" + this.f385360a + ", owned=" + this.f385361b + ", state=" + this.f385362c + ')';
        }

        public c(long r100, boolean r101, ObricListeningPresentationState r102) {
            Intrinsics.checkNotNullParameter(r102, "state");
            this.f385360a = r100;
            this.f385361b = r101;
            this.f385362c = r102;
        }
    }

    public ObricListeningMainProcessManager() {
    }

    static {
        f385330a = new ObricListeningMainProcessManager();
        f385331b = new Handler(Looper.getMainLooper());
        f385332c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f385333d = r100;
        f385336g = ObricListeningPresentationState.f385262g;
        f385341l = -1;
        f385342m = -1;
        f385348s = new AtomicLong(0);
        f385349t = new AtomicReference();
        BuildersKt.launch$default(r100, null, null, new AnonymousClass1(null), 3, null);
        f385352w = new ObricListeningMainProcessManager$callback$1();
    }

    public static aba.b d() {
        if (f385335f == true) goto L7;
        return aba.b.f2514f;
    L7:
        if (f385340k == null) goto L9;
        boolean r100 = true;
    L11:
        if (r100 == false) goto L13;
        int r101 = f385341l;
    L14:
        if (r100 == false) goto L16;
        int r102 = f385342m;
    L17:
        if (r100 == false) goto L19;
        int r103 = f385343n;
    L21:
        if (f385336g.f385265c == 1) goto L23;
    L25:
        boolean r104 = false;
    L27:
        return new aba.b(r101, r102, r103, r104, f385340k);
    L23:
        if (f385336g.b() == false) goto L25;
        r104 = true;
        goto L27
    L19:
        r103 = 0;
        goto L21
    L16:
        r102 = -1;
        goto L17
    L13:
        r101 = -1;
        goto L14
    L9:
        r100 = false;
        goto L11
    }

    public static void e() {
        int r100 = f385341l;
        SurfaceControl r101 = f385340k;
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        l(r101);
        f385340k = null;
        f385341l = -1;
        f385342m = -1;
        f385343n = 0;
        if (r102 == false) goto L10;
        FLogger.f375446a.i("ObricListeningMainPM", "release local child Surface copy, generation=" + r100);
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static void h() {
        if (f385335f == true) goto L7;
        FLogger.f375446a.i("ObricListeningMainPM", "ignore listening terminal without child owner");
        return;
    L7:
        if (f385345p == false) goto L10;
        FLogger.f375446a.i("ObricListeningMainPM", "ignore duplicate listening terminal");
        return;
    L10:
        f385345p = true;
        final ObricListeningPresentationState r100 = ObricListeningPresentationState.a(f385336g, f385336g.f385263a + 1, 0, 1, ObricListeningViewState.f385269d, false, 38);
        FLogger.f375446a.i("ObricListeningMainPM", "begin listening terminal, terminalRevision=" + r100.f385263a);
        g(new j1(r100));
    }

    public static void i() {
        aba.a r100 = f385344o;
        if (r100 == null) goto L6;
        r100.onChildListeningSurfaceChanged(d());
        return;
    }

    public static String m() {
        StringBuilder r100 = new StringBuilder("owned=");
        r100.append(f385335f);
        r100.append(", mode=");
        r100.append(f385336g.f385267e.f385270a);
        r100.append(", revision=");
        r100.append(f385336g.f385263a);
        r100.append(", heartbeatSequence=");
        r100.append(f385336g.f385264b);
        r100.append(", childFeedbackPlayed=");
        r100.append(f385336g.f385268f);
        r100.append(", hasSurface=");
        boolean r101 = false;
        if (f385340k == null) goto L5;
        boolean r102 = true;
    L6:
        r100.append(r102);
        r100.append(", hasPendingFallback=");
        if (f385349t.get() == null) goto L9;
        r101 = true;
    L9:
        r100.append(r101);
        return r100.toString();
    L5:
        r102 = false;
        goto L6
    }

    public static void f() {
        String r100 = m();
        if (f385335f == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        ObricListeningPresentationState r102 = ObricListeningPresentationState.f385262g;
        xaa.b r103 = f385339j;
        if (r103 == null) goto L12;
        r103.a(r102);
    L12:
        f385335f = false;
        f385336g = r102;
        f385337h = false;
        f385346q = 0;
        f385347r = 0;
        f385345p = false;
        f385350u = null;
        f385351v = null;
        e();
        i();
        if (r101 == false) goto L16;
        FLogger.f375446a.i("ObricListeningMainPM", "local child presentation cleared, previous={" + r100 + '}');
        return;
    L16:
        return;
    L5:
        if (f385340k != null) goto L8;
        r101 = false;
        goto L9
    }

    public static void g(final Function0 r100) {
        final aba.b r101 = d();
        aba.a r102 = f385344o;
        if (r101.f2518d == true) goto L5;
    L23:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("skip Surface pre-removal, expectsRelativeLayer=");
        r104.append(r101.f2518d);
        r104.append(", hasSurface=");
        boolean r105 = false;
        if (r101.f2519e == null) goto L26;
        boolean r106 = true;
    L27:
        r104.append(r106);
        r104.append(", hasListener=");
        if (r102 == null) goto L30;
        r105 = true;
    L30:
        r104.append(r105);
        r103.i("ObricListeningMainPM", r104.toString());
        r100.invoke();
        return;
    L26:
        r106 = false;
        goto L27
    L5:
        if (r101.f2519e == null) goto L23;
        if (r102 == null) goto L23;
        final Ref.BooleanRef r107 = new Ref.BooleanRef();
        Runnable r108 = new u0(r107, r101, r100);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L11
        Object r110 = Result.m9449constructorimpl(Boolean.valueOf(r102.prepareForChildListeningSurfaceRemoval(r101, r108)));     // Catch: Throwable -> L11
    L13:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L16;
        FLogger.f375446a.w("ObricListeningMainPM", "Surface pre-removal callback failed, generation=" + r101.f2515a, r111);
    L16:
        Boolean r112 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r110) == false) goto L19;
        r110 = r112;
    L19:
        boolean r113 = ((Boolean) r110).booleanValue();
        FLogger.f375446a.i("ObricListeningMainPM", "Surface pre-removal requested, generation=" + r101.f2515a + ", accepted=" + r113);
        if (r113 == true) goto L34;
        r108.run();
        return;
    L34:
        return;
    L11:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static void j(ObricListeningMainProcessManager r100) {
        if (f385335f == false) goto L5;
        ObricListeningPresentationState r101 = f385336g;
    L6:
        r100.getClass();
        xaa.b r102 = f385339j;
        if (r102 == null) goto L10;
        r102.a(r101);
        return;
    L10:
        return;
    L5:
        r101 = ObricListeningPresentationState.f385262g;
        goto L6
    }

    public static void k(final Function0 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        f385331b.post(new m1(r100));
    }

    public static void l(SurfaceControl r100) {
        if (r100 == null) goto L13;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.release();     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L14;
        FLogger.f375446a.w("ObricListeningMainPM", "release child Surface copy failed", r103);
        return;
    L14:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void p(final ObricListeningViewState r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        float r101 = r100.f385272c;
        if (Float.isInfinite(r101) == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L11;
        FLogger.f375446a.w("ObricListeningMainPM", "drop non-finite listening amplitude, mode=" + r100.f385270a + ", amplitude=" + r100.f385272c);
        return;
    L11:
        k(new o0(r100));
        return;
    L5:
        if (Float.isNaN(r101) == true) goto L7;
        r102 = true;
        goto L8
    }

    public static void a(final b r110, boolean r111) {
        if (f385335f == true) goto L6;
        final String r100 = "child_not_owned";
    L10:
        if (r100 != null) goto L12;
        AssistantStartupTelemetry r101 = AssistantStartupTelemetry.f392915a;
        final String r102 = r101.h();
        final String r103 = r101.i("window_content_ready");
        final boolean r112 = Intrinsics.areEqual(r103, r110.f385358b);
        if (r111 == false) goto L19;
    L22:
        boolean r104 = true;
    L24:
        if (Intrinsics.areEqual(r102, r110.f385358b) == false) goto L26;
        if (r112 == true) goto L35;
        if (r104 == true) goto L35;
        f385350u = r110;
        FLogger.f375446a.g("ObricListeningMainPM", new d0(r110, r103));
        return;
    L35:
        f385350u = null;
        if (Intrinsics.areEqual(f385351v, r110.f385358b) == false) goto L38;
        f385351v = null;
    L38:
        final boolean r105 = r101.k(r110.f385358b, r110.f385359c, "child_first_frame");
        Map r106 = MapsKt.createMapBuilder();
        if (r105 == true) goto L41;
        if (r112 == true) goto L41;
    L42:
        if (r112 == false) goto L44;
        r106.put("window_ready_source", "child_first_frame");
    L44:
        Map r113 = MapsKt.build(r106);
        if ((!r113.isEmpty()) == false) goto L47;
        IAssistantStartupTelemetry.a.e(r101, r110.f385358b, null, null, r113, 14);
    L47:
        final boolean r107 = r101.d(r110.f385358b, "first_frame_ready", r110.f385359c);
        if (r112 == false) goto L50;
        Boolean r108 = Boolean.valueOf(r101.d(r110.f385358b, "window_content_ready", r110.f385359c));
    L51:
        final Boolean r109 = r108;
        FLogger.f375446a.g("ObricListeningMainPM", new e0(r110, r112, r105, r107, r109));
        return;
    L50:
        r108 = null;
    L41:
        r106.put("child_surface_generation", String.valueOf(r110.f385357a));
        goto L42
    L26:
        if (Intrinsics.areEqual(f385351v, r110.f385358b) == false) goto L29;
        f385351v = null;
        f385350u = null;
        FLogger.f375446a.g("ObricListeningMainPM", new b0(r110));
        return;
    L29:
        f385350u = r110;
        FLogger.f375446a.g("ObricListeningMainPM", new c0(r110, r102, r103));
        return;
    L19:
        if (Intrinsics.areEqual(f385351v, r110.f385358b) == true) goto L22;
        r104 = false;
        goto L24
    L12:
        if (f385350u != r110) goto L14;
        f385350u = null;
    L14:
        FLogger.f375446a.g("ObricListeningMainPM", new o1(r100, r110));
        return;
    L6:
        if (r110.f385357a == f385341l) goto L8;
        r100 = "stale_generation";
        goto L10
    L8:
        r100 = null;
        goto L10
    }

    public static boolean c(String r100, final Function0 r101) {
        c r102 = f385349t.get();
        if (r102 != null) goto L6;
        return false;
    L6:
        if (r102.f385361b == false) goto L11;
        if (r102.f385362c.isValid() == true) goto L11;
        return false;
    L11:
        if (r102.f385361b == true) goto L14;
        FLogger.f375446a.i("ObricListeningMainPM", "drop " + r100 + " while child terminal pending, pendingSequence=" + r102.f385360a);
        return true;
    L14:
        FLogger.f375446a.i("ObricListeningMainPM", "defer " + r100 + " until fallback applied, pendingSequence=" + r102.f385360a);
        f385331b.post(new n1(r101));
        return true;
    }

    public static final void b(ObricListeningMainProcessManager r100, boolean r101, ObricListeningPresentationState r102) {
        r100.getClass();
        if (r102 != null) goto L6;
        r102 = ObricListeningPresentationState.f385262g;
    L6:
        if (r101 == false) goto L11;
        if (r102.isValid() == true) goto L11;
        FLogger.f375446a.w("ObricListeningMainPM", "drop invalid owned fallback state, revision=" + r102.f385263a + ", renderer=" + r102.f385265c + ", dataSource=" + r102.f385266d + ", mode=" + r102.f385267e.f385270a);
        return;
    L11:
        if (f385335f == false) goto L16;
        if (r102.f385263a >= f385336g.f385263a) goto L16;
        FLogger.f375446a.i("ObricListeningMainPM", "ignore stale fallback state, incomingRevision=" + r102.f385263a + ", currentRevision=" + f385336g.f385263a);
        return;
    L16:
        if (f385335f == r101) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L24;
        f385337h = false;
        f385345p = false;
        f385350u = null;
        ObricListeningPresentationState r104 = ObricListeningPresentationState.f385262g;
        xaa.b r105 = f385339j;
        if (r105 == null) goto L23;
        r105.a(r104);
    L23:
        e();
    L24:
        f385335f = r101;
        if (r101 == true) goto L28;
        r102 = ObricListeningPresentationState.f385262g;
    L28:
        f385336g = r102;
        if (r103 == false) goto L31;
        f385346q = 0;
        f385347r = 0;
    L31:
        FLogger.f375446a.i("ObricListeningMainPM", "fallback state applied, owned=" + r101 + ", ownershipChanged=" + r103 + ", " + m());
        j(r100);
        i();
        return;
    L18:
        r103 = false;
        goto L19
    }

    public static void n(String r100, IObricInteractorPresentationBridgeService r101, boolean r102, Function1 r103) {
        Object r104 = f385332c.mo10962trySendJP2dKIU(new a(r100, r101, r102, r103));
        kotlinx.coroutines.channels.g.c r105 = kotlinx.coroutines.channels.g.f504696b;
        if ((r104 instanceof kotlinx.coroutines.channels.g.c) == false) goto L9;
        FLogger r106 = FLogger.f375446a;
        String r107 = "enqueue child bridge command failed, name=" + r100 + ", binder=" + r101.asBinder().hashCode();
        Throwable r108 = kotlinx.coroutines.channels.g.a(r104);
        if (r108 != null) goto L7;
        r108 = new IllegalStateException("child bridge command queue rejected ".concat(r100));
    L7:
        r106.w("ObricListeningMainPM", r107, r108);
        return;
    }

    public static /* synthetic */ void o(ObricListeningMainProcessManager r100, String r101, IObricInteractorPresentationBridgeService r102, Function1 r103) {
        r100.getClass();
        n(r101, r102, true, r103);
    }
}
