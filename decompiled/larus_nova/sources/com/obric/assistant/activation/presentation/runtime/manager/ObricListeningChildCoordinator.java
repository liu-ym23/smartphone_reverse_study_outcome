package com.obric.assistant.activation.presentation.runtime.manager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.core.content.IntentCompat;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.activation.presentation.contract.feedback.ObricActivationFeedback;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import com.obric.assistant.activation.presentation.contract.ipc.IObricMainPresentationBridgeCallback;
import com.obric.assistant.activation.presentation.runtime.precheck.ObricChildListeningPrecheck;
import com.obric.miniapp.alarm.AccountType;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricListeningChildCoordinator {
    public static ObricChildListeningPrecheck.b A;
    public static boolean B;
    public static r C;
    public static final x D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricListeningChildCoordinator f385289a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f385290b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f385291c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Job f385292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Context f385293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static eba.i f385294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static cba.b f385295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Function1<? super ActivationSource, ObricChildListeningPrecheck.b> f385296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static IObricMainPresentationBridgeCallback f385297i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static IBinder f385298j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static j f385299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Function0<Unit> f385300l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f385301m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f385302n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static a f385303o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static RawOwner f385304p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f385305q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f385306r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static long f385307s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static ActivationSource f385308t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f385309u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static a f385310v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static a f385311w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static ObricListeningPresentationState f385312x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f385313y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static ObricListeningVisualMode f385314z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/manager/ObricListeningChildCoordinator$RawOwner;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, AccountType.MAIN, "CHILD", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RawOwner extends Enum<RawOwner> {
        public static final RawOwner CHILD = null;
        public static final RawOwner MAIN = null;
        public static final RawOwner NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RawOwner[] f385315a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f385316b = null;

        public static EnumEntries<RawOwner> getEntries() {
            return f385316b;
        }

        static {
            RawOwner r100 = new RawOwner(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            RawOwner r101 = new RawOwner(AccountType.MAIN, 1);
            MAIN = r101;
            RawOwner r102 = new RawOwner("CHILD", 2);
            CHILD = r102;
            RawOwner[] r103 = {r100, r101, r102};
            f385315a = r103;
            f385316b = EnumEntriesKt.enumEntries(r103);
        }

        public static RawOwner[] values() {
            return (RawOwner[]) f385315a.clone();
        }

        public static RawOwner valueOf(String r100) {
            return (RawOwner) r27.a.a(RawOwner.class, r100);
        }

        public RawOwner(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f385317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f385318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f385319c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f385317a == r101.f385317a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f385318b, r101.f385318b) == true) goto L15;
            return false;
        L15:
            if (this.f385319c == r101.f385319c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f385317a * 31) + this.f385318b.hashCode()) * 31;
            long r101 = this.f385319c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "PendingChildFirstDraw(generation=" + this.f385317a + ", startupAttemptId=" + this.f385318b + ", timestampElapsedRealtimeMs=" + this.f385319c + ')';
        }

        public a(int r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r101, "startupAttemptId");
            this.f385317a = r100;
            this.f385318b = r101;
            this.f385319c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f385320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ActivationSource f385321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f385322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f385323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f385324e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f385325f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f385320a == r101.f385320a) goto L12;
            return false;
        L12:
            if (this.f385321b == r101.f385321b) goto L15;
            return false;
        L15:
            if (this.f385322c == r101.f385322c) goto L18;
            return false;
        L18:
            if (this.f385323d == r101.f385323d) goto L21;
            return false;
        L21:
            if (this.f385324e == r101.f385324e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f385325f, r101.f385325f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f385320a * 31) + this.f385321b.hashCode()) * 31) + this.f385322c) * 31;
            long r101 = this.f385323d;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f385324e;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            String r105 = this.f385325f;
            if (r105 != null) goto L5;
            int r106 = 0;
        L7:
            return r104 + r106;
        L5:
            r106 = r105.hashCode();
            goto L7
        }

        public final String toString() {
            return "PreparedInput(showSessionId=" + this.f385320a + ", source=" + this.f385321b + ", invocationType=" + this.f385322c + ", eventTimeMillis=" + this.f385323d + ", activationStartWallClockMillis=" + this.f385324e + ", startupAttemptId=" + this.f385325f + ')';
        }

        public b(int r100, ActivationSource r101, int r102, long r103, long r104, String r105) {
            Intrinsics.checkNotNullParameter(r101, "source");
            this.f385320a = r100;
            this.f385321b = r101;
            this.f385322c = r102;
            this.f385323d = r103;
            this.f385324e = r104;
            this.f385325f = r105;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f385326a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f385327b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f385328c = null;

        static {
            int[] r100 = new int[ActivationSource.values().length];
            r100[ActivationSource.AI_KEY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L61:
            r100[ActivationSource.POWER_KEY_TERMINAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L73:
            r100[ActivationSource.VOICE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L47:
            r100[ActivationSource.BREATH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L49:
            r100[ActivationSource.POWER_KEY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L12:
            f385326a = r100;
            int[] r101 = new int[ObricAiKeyGestureAction.values().length];
            r101[ObricAiKeyGestureAction.SINGLE_PRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L43:
            r101[ObricAiKeyGestureAction.DOUBLE_PRESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L51:
            r101[ObricAiKeyGestureAction.PRESS_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L59:
            r101[ObricAiKeyGestureAction.SHORT_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L65:
            r101[ObricAiKeyGestureAction.LONG_PRESS_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L45:
            r101[ObricAiKeyGestureAction.LONG_PRESS_STOP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L53:
            r101[ObricAiKeyGestureAction.CANCEL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
        L69:
            r101[ObricAiKeyGestureAction.TIMEOUT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L39
        L21:
            f385327b = r101;
            int[] r102 = new int[RawOwner.values().length];
            r102[RawOwner.MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L63:
            r102[RawOwner.CHILD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L71:
            r102[RawOwner.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L25:
            f385328c = r102;
        }
    }

    public ObricListeningChildCoordinator() {
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.obric.assistant.activation.presentation.runtime.manager.x] */
    static {
        f385289a = new ObricListeningChildCoordinator();
        f385290b = new Handler(Looper.getMainLooper());
        f385291c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f385304p = RawOwner.NONE;
        f385307s = -1;
        f385312x = ObricListeningPresentationState.f385262g;
        f385314z = ObricListeningVisualMode.HIDDEN;
        A = ObricChildListeningPrecheck.b.f385458c;
        D = new x();
    }

    public static void b() {
        final a r100 = f385310v;
        if (r100 != null) goto L5;
        return;
    L5:
        IObricMainPresentationBridgeCallback r101 = f385297i;
        if (r101 != null) goto L13;
        FLogger.f375446a.g("ObricListeningChildCoordinator", new h());
        return;
    L13:
        r101.onChildFirstFrameReady(r100.f385317a, r100.f385318b, r100.f385319c);     // Catch: RemoteException -> L11
        f385310v = null;     // Catch: RemoteException -> L11
        FLogger.f375446a.g("ObricListeningChildCoordinator", new i(r100));     // Catch: RemoteException -> L11
        return;
    L11:
        FLogger.f375446a.w("ObricListeningChildCoordinator", "child_first_draw_failed: reason=remote_exception");
        a(r101.asBinder());
    }

    public static void c() {
        ActivationSource r100 = f385308t;
        ActivationSource r101 = ActivationSource.AI_KEY;
        if (r100 == r101) goto L5;
        return;
    L5:
        if (A.f385460a != ObricChildListeningPrecheck.Status.NOT_STARTED) goto L15;
        Function1<? super ActivationSource, ObricChildListeningPrecheck.b> r102 = f385296h;
        if (r102 == null) goto L11;
        ObricChildListeningPrecheck.b r103 = r102.invoke(r101);
        if (r103 == null) goto L11;
    L12:
        A = r103;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_precheck_started: source=" + f385308t + " result=" + A.f385460a + " reason=" + A.f385461b);
        return;
    L11:
        ObricChildListeningPrecheck.b r104 = ObricChildListeningPrecheck.b.f385458c;
        ObricChildListeningPrecheck.Reason r105 = ObricChildListeningPrecheck.Reason.HOST_STATE_MISSING;
        Intrinsics.checkNotNullParameter(r105, "reason");
        r103 = new ObricChildListeningPrecheck.b(ObricChildListeningPrecheck.Status.BLOCKED, r105);
        goto L12
    }

    public static void d() {
        boolean r100 = f385305q;
        ActivationSource r101 = f385308t;
        if (r101 != ActivationSource.AI_KEY) goto L7;
        String r102 = f385301m;
        if (r102 == null) goto L7;
        f385302n = r102;
        f385303o = f385311w;
    L7:
        cba.b r103 = f385295g;
        if (r103 == null) goto L10;
        r103.i("external");
    L10:
        q(RawOwner.NONE);
        Handler r104 = f385290b;
        r104.removeCallbacks(D);
        r r105 = C;
        if (r105 == null) goto L13;
        r104.removeCallbacks(r105);
    L13:
        C = null;
        if (f385305q == false) goto L22;
        ObricListeningPresentationState r106 = ObricListeningPresentationState.a(f385312x, f(), 0, 0, ObricListeningViewState.f385269d, false, 46);
        f385312x = r106;
        eba.i r107 = f385294f;
        if (r107 == null) goto L21;
        if (r101 == null) goto L20;
        r107.g(r106, r101, f385307s);
        goto L21
    L20:
        throw new IllegalStateException("Required value was null.".toString());
    L21:
        f385305q = false;
        h();
    L22:
        f385308t = null;
        f385309u = null;
        f385310v = null;
        f385311w = null;
        f385312x = ObricListeningPresentationState.f385262g;
        f385314z = ObricListeningVisualMode.HIDDEN;
        A = ObricChildListeningPrecheck.b.f385458c;
        B = false;
        if (r100 == false) goto L26;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_activation_finished: source=" + r101);
        return;
    }

    public static long f() {
        long r100 = Math.max(f385313y, f385312x.f385263a);
        if (r100 >= Long.MAX_VALUE) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L10;
        long r102 = r100 + 1;
        f385313y = r102;
        return r102;
    L10:
        throw new IllegalStateException("listening presentation revision exhausted".toString());
    L5:
        r101 = false;
        goto L6
    }

    public static void h() {
        IObricMainPresentationBridgeCallback r100 = f385297i;
        if (r100 != null) goto L9;
        return;
    L9:
        r100.onFallbackStateChanged(f385305q, f385312x);     // Catch: RemoteException -> L7
        return;
    L7:
        FLogger.f375446a.w("ObricListeningChildCoordinator", "notify_fallback_state_failed: reason=remote_exception");
        a(r100.asBinder());
    }

    public static boolean n() {
        eba.i r100 = f385294f;
        if (r100 == null) goto L11;
        ObricListeningPresentationState r101 = f385312x;
        ActivationSource r102 = f385308t;
        if (r102 == null) goto L10;
        if (r100.g(r101, r102, f385307s) != true) goto L11;
        return true;
    L10:
        throw new IllegalStateException("Required value was null.".toString());
    L11:
        return false;
    }

    public static void o() {
        if (B == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        return;
    L11:
        if (f385312x.b() == true) goto L14;
        return;
    L14:
        if (n() == true) goto L16;
        FLogger.f375446a.w("ObricListeningChildCoordinator", "visual_mode_render_failed: mode=" + f385314z + " trigger=activation_type_updated");
        f385312x = ObricListeningPresentationState.a(f385312x, f(), 0, 0, ObricListeningViewState.f385269d, false, 46);
        return;
    L16:
        if (f385312x.f385268f == true) goto L21;
        e("activation_type_updated");
        return;
    L21:
        return;
    L5:
        if (f385312x.f385267e.b() == false) goto L8;
        r100 = false;
        goto L9
    }

    public static RawOwner p() {
        sna.h r100 = sna.h.f542678a;
        boolean r101 = sna.h.a().getBoolean("window_mode_enabled", false);
        boolean r102 = ((Boolean) ObricMainProcessStateManager.f385365c.getValue()).booleanValue();
        if (r101 == true) goto L5;
        RawOwner r103 = RawOwner.MAIN;
    L8:
        FLogger.f375446a.i("ObricListeningChildCoordinator", "resolveRawOwner owner=" + r103 + " mainProcessReady=" + r102 + " windowModeEnabled=" + r101);
        return r103;
    L5:
        if (r102 == false) goto L7;
        r103 = RawOwner.MAIN;
        goto L8
    L7:
        r103 = RawOwner.CHILD;
        goto L8
    }

    public static void s() {
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricListeningChildCoordinator", "unlink_callback:");
        j r101 = f385299k;
        if (r101 != null) goto L18;
        r100.i("ObricListeningChildCoordinator", "unlink_callback_ignored: reason=missing_recipient");
        return;
    L18:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        IBinder r103 = f385298j;     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        Boolean r104 = Boolean.valueOf(r103.unlinkToDeath(r101, 0));     // Catch: Throwable -> L12
    L10:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L20;
        FLogger.f375446a.w("ObricListeningChildCoordinator", "unlink_callback_failed: reason=unlink_exception");
        return;
    L20:
        return;
    L9:
        r104 = null;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static void a(IBinder r100) {
        if (r100 != null) goto L7;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "clear_main_callback_ignored: reason=missing_expected_binder");
        return;
    L7:
        if (r100 == f385298j) goto L10;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "clear_main_callback_ignored: reason=stale_binder");
        return;
    L10:
        s();
        f385297i = null;
        f385298j = null;
        f385299k = null;
        eba.i r101 = f385294f;
        if (r101 == null) goto L14;
        int r102 = eba.i.F;
        r101.f(null);
    L14:
        if (f385305q == true) goto L16;
        d();
        FLogger.f375446a.i("ObricListeningChildCoordinator", "clear_main_callback_finished");
        return;
    L16:
        if (f385310v != null) goto L18;
        f385310v = f385311w;
    L18:
        FLogger.f375446a.i("ObricListeningChildCoordinator", "clear_main_callback_waiting_for_reconnect");
    }

    public static boolean e(String r110) {
        if (f385305q == true) goto L7;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_feedback_skipped: reason=activation_not_owned trigger=" + r110);
        return false;
    L7:
        if (f385312x.b() == true) goto L11;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_feedback_skipped: reason=listening_ui_not_visible trigger=" + r110);
        return false;
    L11:
        if (f385312x.f385268f == false) goto L14;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_feedback_skipped: reason=already_played trigger=" + r110);
        return false;
    L14:
        ActivationSource r100 = f385308t;
        if (r100 != null) goto L17;
        int r101 = -1;
    L19:
        if (r101 != (-1)) goto L21;
    L55:
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_feedback_skipped: reason=unsupported_source source=" + f385308t + " trigger=" + r110);
        return false;
    L21:
        if (r101 == 1) goto L34;
        int r102 = 2;
        if (r101 == 2) goto L55;
        if (r101 != 3) goto L27;
    L35:
        ObricActivationFeedback r103 = (ObricActivationFeedback) ServiceManager.get().getServiceForReal(ObricActivationFeedback.class);
        if (r103 != null) goto L57;
        FLogger.f375446a.w("ObricListeningChildCoordinator", "child_feedback_unavailable: trigger=" + r110);
        return false;
    L57:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L41
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r103.a(r102)));     // Catch: Throwable -> L41
    L43:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L46;
        FLogger.f375446a.w("ObricListeningChildCoordinator", "child_feedback_failed: trigger=" + r110, r106);
    L46:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L50;
        r105 = r107;
    L50:
        if (((Boolean) r105).booleanValue() == true) goto L53;
        FLogger.f375446a.w("ObricListeningChildCoordinator", "child_feedback_not_accepted: trigger=" + r110);
        return false;
    L53:
        f385312x = ObricListeningPresentationState.a(f385312x, f(), 0, 0, null, true, 30);
        FLogger.f375446a.i("ObricListeningChildCoordinator", "child_feedback_played: source=" + f385308t + " trigger=" + r110 + " revision=" + f385312x.f385263a);
        return true;
    L41:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L27:
        if (r101 != 4) goto L29;
        r102 = 3;
        goto L35
    L29:
        if (r101 == 5) goto L34;
        throw new NoWhenBranchMatchedException();
    L34:
        r102 = 1;
        goto L35
    L17:
        r101 = c.f385326a[r100.ordinal()];
        goto L19
    }

    public static void g(RawOwner r100) {
        Function0<Unit> r101 = f385300l;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("ai_key_down_ready_to_dispatch: owner=");
        r103.append(r100);
        r103.append(" listenerRegistered=");
        if (r101 == null) goto L5;
        boolean r104 = true;
    L6:
        r103.append(r104);
        r102.i("ObricListeningChildCoordinator", r103.toString());
        if (r101 == null) goto L10;
        r101.invoke();
        return;
    L10:
        return;
    L5:
        r104 = false;
        goto L6
    }

    public static void i(final Function0 r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        f385290b.post(new m(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.activation.presentation.runtime.manager.r, java.lang.Runnable] */
    public static void j(Bundle r210) {
        Intrinsics.checkNotNullParameter(r210, "args");
        com.obric.assistant.common.utils.i.a r100 = com.obric.assistant.common.utils.i.a("ObricListeningChildCoordinator_onShow");
        ObricListeningChildCoordinator r101 = f385289a;     // Catch: Throwable -> L23
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L23
        r101.getClass();     // Catch: Throwable -> L23
        b r103 = k(r210, r102);     // Catch: Throwable -> L23
        int r104 = -1;
        if (r103 != null) goto L10;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "on_show_ignored: reason=invalid_input");     // Catch: Throwable -> L23
        r210.putInt("obric_listening_show_owner", -1);     // Catch: Throwable -> L23
        if (r100 == null) goto L45;
        r100.a();
        return;
    L45:
        return;
    L10:
        int r105 = c.f385326a[r103.f385321b.ordinal()];     // Catch: Throwable -> L23
        if (r105 != 1) goto L13;
        r104 = l(r103, r210);     // Catch: Throwable -> L23
    L28:
        r210.putInt("obric_listening_show_owner", r104);     // Catch: Throwable -> L23
        FLogger r106 = FLogger.f375446a;     // Catch: Throwable -> L23
        r106.i("ObricListeningChildCoordinator", "on_show_finished: source=" + r103.f385321b + " showSessionId=" + r103.f385320a + " invocationType=" + r103.f385322c + " owner=" + r104 + " rawOwner=" + f385304p);     // Catch: Throwable -> L23
        if (r104 == 1) goto L34;
        r106.i("ObricListeningChildCoordinator", "framework_show_render_ignored: owner=" + r104 + " reason=main_owner");     // Catch: Throwable -> L23
        if (r100 == null) goto L46;
        r100.a();
        return;
    L46:
        return;
    L34:
        r106.i("ObricListeningChildCoordinator", "framework_show_render_scheduled: owner=child");     // Catch: Throwable -> L23
        r r107 = C;     // Catch: Throwable -> L23
        if (r107 == null) goto L37;
        f385290b.removeCallbacks(r107);     // Catch: Throwable -> L23
    L37:
        ?? r108 = new r();     // Catch: Throwable -> L23
        C = r108;     // Catch: Throwable -> L23
        f385290b.post(r108);     // Catch: Throwable -> L23
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L23
        if (r100 == null) goto L47;
        r100.a();
        return;
    L47:
        return;
    L13:
        if (r105 == 2) goto L26;
        long r110 = SystemClock.uptimeMillis();     // Catch: Throwable -> L23
        long r111 = f385306r;     // Catch: Throwable -> L23
        if (r111 <= 0) goto L17;
        long r112 = RangesKt.coerceAtLeast(r110 - r111, 0);     // Catch: Throwable -> L23
    L18:
        f385307s = r112;     // Catch: Throwable -> L23
        f385306r = r110;     // Catch: Throwable -> L23
        ActivationSource r113 = r103.f385321b;     // Catch: Throwable -> L23
        if (f385305q == false) goto L21;
    L25:
        r(r103.f385323d, r103.f385324e, r113, ObricListeningVisualMode.CLICK_TALK, r103.f385325f);     // Catch: Throwable -> L23
        r104 = 1;
        goto L28
    L21:
        if (p() != RawOwner.CHILD) goto L28;
    L17:
        r112 = -1;
        goto L18
    L26:
        m(r103);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r100 == null) goto L43;
        r100.a();
    L43:
        throw th;
    }

    public static void m(b r100) {
        if (f385305q == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "power_key_terminal_ignored: reason=no_matching_activation showSessionId=" + r100.f385320a + " source=" + f385308t);
    L10:
        if (r101 == false) goto L13;
        d();
        return;
    L13:
        return;
    L5:
        if (f385308t != ActivationSource.POWER_KEY) goto L7;
        r101 = true;
        goto L8
    }

    public static void q(RawOwner r100) {
        f385304p = r100;
        if (r100 != RawOwner.NONE) goto L5;
        f385301m = null;
    L5:
        FLogger.f375446a.i("ObricListeningChildCoordinator", "rawOwner " + r100);
    }

    public static b k(Bundle r210, int r211) {
        if (r211 >= 35) goto L6;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "parse_input_ignored: reason=unsupported_sdk sdkInt=" + r211);
        return null;
    L6:
        int r100 = r210.getInt("invocation_type", Integer.MIN_VALUE);
        boolean r101 = Intrinsics.areEqual(r210.getString(InteractConst.WAKEUP_REQUEST_FROM), InteractConst.WAKEUP_SOURCE_VOICE_ASSIST);
        String r102 = r210.getString(InteractConst.WAKEUP_SESSION_NAME);
        int r103 = xaa.a.f563098a;
        if (r100 != 20) goto L9;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L18;
        ActivationSource r105 = ActivationSource.AI_KEY;
    L30:
        Intrinsics.checkNotNullParameter(r210, "<this>");
        int r106 = r210.getInt("android.service.voice.SHOW_SESSION_ID");
        if (r106 >= 0) goto L34;
        FLogger.f375446a.w("ObricListeningChildCoordinator", "parse_input_ignored: reason=invalid_show_session_id showSessionId=" + r106 + " source=" + r105);
        return null;
    L34:
        long r107 = SystemClock.uptimeMillis();
        long r110 = System.currentTimeMillis();
        long r111 = r210.getLong(IntentCompat.EXTRA_TIME, -1);
        Long r108 = Long.valueOf(r111);
        if (r108.longValue() <= 0) goto L37;
        boolean r112 = true;
    L38:
        if (r112 == true) goto L41;
        r108 = null;
    L41:
        if (r108 == null) goto L43;
        long r113 = r108.longValue();
    L44:
        int r109 = c.f385326a[r105.ordinal()];
        if (r109 != 1) goto L47;
    L67:
        Long r114 = Long.valueOf(r111);
        if (r114.longValue() <= 0) goto L70;
        boolean r115 = true;
    L71:
        if (r115 == true) goto L74;
        r114 = null;
    L74:
        if (r114 == null) goto L76;
        r110 = r110 - RangesKt.coerceAtLeast(r107 - r114.longValue(), 0);
    L76:
        String r116 = r210.getString("obric_startup_attempt_id");
        if (r116 != null) goto L79;
    L81:
        String r117 = null;
    L83:
        return new b(r106, r105, r100, r113, r110, r117);
    L79:
        if ((!StringsKt.isBlank(r116)) == false) goto L81;
        r117 = r116;
        goto L83
    L70:
        r115 = false;
        goto L71
    L47:
        if (r109 != 2) goto L49;
        r110 = 0;
        goto L76
    L49:
        if (r109 != 3) goto L51;
    L57:
        Long r118 = Long.valueOf(r210.getLong(InteractConst.WAKEUP_START_TIME, -1));
        if (r118.longValue() <= 0) goto L60;
        boolean r119 = true;
    L61:
        if (r119 == true) goto L64;
        r118 = null;
    L64:
        if (r118 == null) goto L76;
        r110 = r118.longValue();
        goto L76
    L60:
        r119 = false;
        goto L61
    L51:
        if (r109 == 4) goto L57;
        if (r109 == 5) goto L67;
        throw new NoWhenBranchMatchedException();
    L43:
        r113 = r107;
        goto L44
    L37:
        r112 = false;
        goto L38
    L18:
        if (r100 != 6) goto L21;
        r105 = ActivationSource.POWER_KEY;
        goto L30
    L21:
        if (r100 != (-2)) goto L23;
        r105 = ActivationSource.POWER_KEY_TERMINAL;
        goto L30
    L23:
        if (r101 == true) goto L25;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "parse_input_ignored: reason=unsupported_invocation invocationType=" + r100);
        return null;
    L25:
        if (Intrinsics.areEqual(r102, "VOICE") == false) goto L28;
        r105 = ActivationSource.VOICE;
        goto L30
    L28:
        if (Intrinsics.areEqual(r102, "BREATH") == false) goto L84;
        r105 = ActivationSource.BREATH;
        goto L30
    L84:
        FLogger.f375446a.i("ObricListeningChildCoordinator", "parse_input_ignored: reason=unsupported_voice_session sessionName=" + r102 + " invocationType=" + r100);
        return null;
    L9:
        if (r100 == 21) goto L14;
        if (r100 == 22) goto L14;
        r104 = false;
        goto L15
    }

    public static int l(b r110, Bundle r111) {
        if (r110.f385322c == 20) goto L5;
    L17:
        final String r100 = f385301m;
        boolean r101 = false;
        if (r100 != null) goto L27;
        r100 = f385302n;
        if (r110.f385322c == 20) goto L22;
        boolean r102 = true;
    L23:
        if (r102 == true) goto L27;
        r100 = null;
        goto L27
    L22:
        r102 = false;
    L27:
        if (r100 == null) goto L54;
        r111.putString("obric_startup_attempt_id", r100);
        f385289a.getClass();
        final a r103 = f385311w;
        if (r103 != null) goto L31;
    L36:
        r103 = f385303o;
        if (r103 != null) goto L39;
    L41:
        r103 = null;
    L42:
        if (r103 != null) goto L53;
        a r112 = f385311w;
        if (r112 == null) goto L47;
        String r113 = r112.f385318b;
        if (r113 == null) goto L47;
    L51:
        if (r113 == null) goto L54;
        FLogger.f375446a.w("ObricListeningChildCoordinator", "child_first_draw_bundle_ignored: reason=attempt_mismatch evidenceAttemptId=" + r113 + " attemptId=" + r100);
    L47:
        a r114 = f385303o;
        if (r114 == null) goto L50;
        r113 = r114.f385318b;
        goto L51
    L50:
        r113 = null;
    L53:
        r111.putLong("obric_child_first_frame_elapsed_ms", r103.f385319c);
        r111.putInt("obric_child_first_frame_generation", r103.f385317a);
        FLogger.f375446a.g("ObricListeningChildCoordinator", new w(r103, r100));
        goto L54
    L39:
        if (Intrinsics.areEqual(r103.f385318b, r100) == false) goto L41;
    L31:
        if (Intrinsics.areEqual(r103.f385318b, r100) == true) goto L34;
        r103 = null;
    L34:
        if (r103 == null) goto L36;
    L54:
        RawOwner r115 = f385304p;
        RawOwner r104 = RawOwner.CHILD;
        if (r115 != r104) goto L57;
        int r116 = 1;
    L58:
        int r105 = r110.f385322c;
        long r106 = r110.f385323d;
        switch(r105) {
            case 20: goto L67;
            case 21: goto L64;
            case 22: goto L61;
            default: goto L71;
        };
    L61:
        cba.b r107 = f385295g;
        if (r107 == null) goto L71;
        r107.f(r106);
        goto L71
    L64:
        cba.b r108 = f385295g;
        if (r108 == null) goto L71;
        r108.h(r106);
        goto L71
    L67:
        cba.b r109 = f385295g;
        if (r109 == null) goto L71;
        r109.g(r106);
    L71:
        if (f385304p != r104) goto L84;
        cba.b r117 = f385295g;
        if (r117 != null) goto L75;
    L80:
        boolean r118 = false;
    L81:
        if (r118 == false) goto L84;
        q(RawOwner.NONE);
    L97:
        if (r110.f385322c == 20) goto L108;
        cba.b r119 = f385295g;
        if (r119 != null) goto L101;
    L106:
        if (r101 == false) goto L108;
        f385302n = null;
        f385303o = null;
        f385311w = null;
        goto L108
    L101:
        if (r119.f23107d == ObricAiKeyGestureState.IDLE) goto L103;
        boolean r120 = true;
    L104:
        if (r120 == true) goto L106;
        r101 = true;
        goto L106
    L103:
        r120 = false;
    L108:
        return r116;
    L75:
        if (r117.f23107d == ObricAiKeyGestureState.IDLE) goto L77;
        boolean r121 = true;
    L78:
        if (r121 == true) goto L80;
        r118 = true;
        goto L81
    L77:
        r121 = false;
    L84:
        if (f385304p != RawOwner.MAIN) goto L97;
        cba.b r122 = f385295g;
        if (r122 != null) goto L88;
    L93:
        boolean r123 = false;
    L94:
        if (r123 == false) goto L97;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "main_raw_owner_released: reason=recognizer_idle invocationType=" + r110.f385322c + " showSessionId=" + r110.f385320a);
        q(RawOwner.NONE);
        goto L97
    L88:
        if (r122.f23107d == ObricAiKeyGestureState.IDLE) goto L90;
        boolean r124 = true;
    L91:
        if (r124 == true) goto L93;
        r123 = true;
        goto L94
    L90:
        r124 = false;
        goto L91
    L57:
        r116 = -1;
        goto L58
    L5:
        if (f385304p != RawOwner.NONE) goto L17;
        f385302n = null;
        f385303o = null;
        if (f385305q == false) goto L9;
        RawOwner r125 = RawOwner.CHILD;
    L10:
        String r126 = r110.f385325f;
        if (r126 != null) goto L14;
        r126 = UUID.randomUUID().toString();
    L14:
        if (r125 != RawOwner.CHILD) goto L16;
        r(r110.f385323d, r110.f385324e, ActivationSource.AI_KEY, ObricListeningVisualMode.HIDDEN, r126);
    L16:
        f385301m = r126;
        q(r125);
        goto L17
    L9:
        r125 = p();
        goto L10
    }

    public static void t(ActivationSource r110, ObricListeningVisualMode r111) {
        ObricListeningVisualMode r100 = f385314z;
        boolean r101 = false;
        if (r100 != ObricListeningVisualMode.HIDDEN) goto L7;
        if (r111 != ObricListeningVisualMode.CLICK_TALK) goto L7;
    L10:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L16;
        FLogger.f375446a.i("ObricListeningChildCoordinator", "activation_type_update_ignored: currentSource=" + f385308t + " incomingSource=" + r110 + " currentMode=" + r100 + " incomingMode=" + r111);
        return;
    L16:
        ActivationSource r103 = f385308t;
        f385308t = r110;
        f385314z = r111;
        FLogger r104 = FLogger.f375446a;
        r104.i("ObricListeningChildCoordinator", "activation_type_updated: source=" + r103 + "->" + r110 + " mode=" + r100 + "->" + r111);
        ObricListeningPresentationState r105 = f385312x;
        int r106 = r105.f385266d;
        if (r106 == 1) goto L28;
        if (r106 != 1) goto L20;
        r104.i("ObricListeningChildCoordinator", "apply_child_fallback_ignored: reason=main_data_active");
        return;
    L20:
        ObricListeningVisualMode r107 = f385314z;
        if (A.f385460a != ObricChildListeningPrecheck.Status.PASSED) goto L23;
        r101 = true;
    L23:
        ObricListeningViewState r112 = z.a(r107, r101);
        if (Intrinsics.areEqual(r112, f385312x.f385267e) == false) goto L26;
        r104.i("ObricListeningChildCoordinator", "apply_child_fallback_ignored: reason=state_unchanged trigger=activation_type_updated precheck=" + A.f385460a);
        return;
    L26:
        f385312x = ObricListeningPresentationState.a(f385312x, f(), 0, 0, r112, false, 46);
        o();
        h();
        return;
    L28:
        ObricListeningViewState r113 = ObricListeningViewState.a(r105.f385267e, r111, 0.0f, 6);
        if (Intrinsics.areEqual(r113, f385312x.f385267e) == false) goto L31;
        return;
    L31:
        f385312x = ObricListeningPresentationState.a(f385312x, f(), 0, 0, r113, false, 46);
        o();
        h();
        return;
    L7:
        if (r100 == ObricListeningVisualMode.CLICK_TALK) goto L9;
    L11:
        r102 = false;
        goto L13
    L9:
        if (r111 != ObricListeningVisualMode.PRESS_TALK) goto L11;
        goto L10
    }

    public static void r(long r110, long r111, ActivationSource r210, ObricListeningVisualMode r211, String r212) {
        if (f385305q == false) goto L10;
        if (r212 != null) goto L6;
    L8:
        t(r210, r211);
        return;
    L6:
        if (Intrinsics.areEqual(f385309u, r212) == true) goto L8;
        f385309u = r212;
        f385310v = null;
        f385311w = null;
        goto L8
    L10:
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricListeningChildCoordinator", "startChildActivation: source = " + r210 + ", initialMode = " + r211);
        boolean r101 = true;
        f385305q = true;
        f385308t = r210;
        f385309u = r212;
        f385314z = r211;
        A = ObricChildListeningPrecheck.b.f385458c;
        B = false;
        if (r210 == ActivationSource.AI_KEY) goto L18;
        Function1<? super ActivationSource, ObricChildListeningPrecheck.b> r102 = f385296h;
        if (r102 == null) goto L16;
        ObricChildListeningPrecheck.b r103 = r102.invoke(r210);
        if (r103 == null) goto L16;
    L17:
        A = r103;
    L16:
        ObricChildListeningPrecheck.Reason r104 = ObricChildListeningPrecheck.Reason.HOST_STATE_MISSING;
        Intrinsics.checkNotNullParameter(r104, "reason");
        r103 = new ObricChildListeningPrecheck.b(ObricChildListeningPrecheck.Status.BLOCKED, r104);
    L18:
        ObricListeningVisualMode r105 = f385314z;
        if (A.f385460a == ObricChildListeningPrecheck.Status.PASSED) goto L22;
        r101 = false;
    L22:
        f385312x = new ObricListeningPresentationState(f(), 0, 1, 0, z.a(r105, r101), false);
        Handler r106 = f385290b;
        x r107 = D;
        r106.removeCallbacks(r107);
        r106.postAtTime(r107, r110 + 180000);
        h();
        r100.i("ObricListeningChildCoordinator", "child_activation_started: source=" + r210 + " initialMode=" + r211 + " visible=" + f385312x.f385267e.b() + " precheck=" + A.f385460a + " reason=" + A.f385461b + " revision=" + f385312x.f385263a + " startTime=" + r111);
    }
}
