package nba;

import android.os.RemoteCallbackList;
import com.bytedance.applog.AppLog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL;
import com.obric.aiagent.sharedstate.StateKey;
import com.obric.assistant.ObricAppLogSettingsConfig;
import com.obric.assistant.applog.AppLogIDLStub;
import com.obric.assistant.state.ObricSharedStateDelegate;
import com.obric.assistant.t1;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f518562a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RemoteCallbackList<IFlowAppLogSessionObserverIDL> f518563b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RemoteCallbackList<IFlowAppLogEventObserverIDL> f518564c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RemoteCallbackList<IFlowAppLogDataObserverIDL> f518565d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f518566e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ScheduledExecutorService f518567f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile long f518568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile ScheduledFuture<?> f518569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f518570i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile int f518571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f518572k = null;

    public static final class a implements v48.b {
        public a() {
        }

        @Override // v48.b
        public final void onTimeout() {
            FLogger.f375446a.w(AppLogIDLStub.TAG, "resetAndReInstall onTimeout");
            c.a(c.f518562a, "resetAndReInstall_onTimeout", null);
        }

        @Override // v48.b
        public final void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
            Intrinsics.checkNotNullParameter(r101, "installId");
            FLogger.f375446a.i(AppLogIDLStub.TAG, "resetAndReInstall onDidUpdate, didLength=" + r100.length() + ", installIdLength=" + r101.length());
            c r102 = c.f518562a;
            if (c.b(r102, r100) == false) goto L6;
            c.a(r102, "resetAndReInstall_onDidUpdate", r100);
            return;
        L6:
            c.d(r102, r100, r101, AppLog.getSsid());
            c.c(r102, "resetAndReInstall_onDidUpdate");
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f518573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f518574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f518575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f518576d;

        public final void a() {
            Object r100 = c.f518566e;
            monitor-enter(r100);
            c.f518569h = null;     // Catch: Throwable -> L9
            c.f518570i = true;     // Catch: Throwable -> L9
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(r100);
            FLogger r102 = FLogger.f375446a;
            StringBuilder r103 = new StringBuilder("trigger resetAndReInstall, trigger=");
            r103.append(this.f518573a);
            r103.append(", reason=");
            r103.append(this.f518574b);
            r103.append(", invalidDid=");
            r103.append(this.f518575c);
            r103.append(", delayMs=");
            r103.append(this.f518576d);
            r103.append(", timeoutMs=");
            c.f518562a.getClass();
            r103.append(RangesKt.coerceAtLeast(c.e().getReinstallTimeoutMs(), 500));
            r102.i(AppLogIDLStub.TAG, r103.toString());
            IApplog.f287053a.u(RangesKt.coerceAtLeast(c.e().getReinstallTimeoutMs(), 500), c.f518572k);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(String r100, String r101, String r102, long r103) {
            this.f518573a = r100;
            this.f518574b = r101;
            this.f518575c = r102;
            this.f518576d = r103;
        }
    }

    public c() {
    }

    static {
        f518562a = new c();
        f518563b = new RemoteCallbackList();
        f518564c = new RemoteCallbackList();
        f518565d = new RemoteCallbackList();
        f518566e = new Object();
        f518567f = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new nba.a());
        f518568g = f();
        f518572k = new a();
    }

    public static ObricAppLogSettingsConfig e() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(t1.f393353a.getObricAppLogSettingsConfig());     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L11;
        FLogger.f375446a.e(AppLogIDLStub.TAG, "getObricAppLogSettingsConfig fail", r102);
        r101 = new ObricAppLogSettingsConfig(0, 0, 0, 0, 15, null);
    L11:
        return (ObricAppLogSettingsConfig) r101;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static long f() {
        return RangesKt.coerceAtLeast(e().getMinRetryDelayMs(), 100);
    }

    public static final boolean b(c r100, String r101) {
        r100.getClass();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L12:
        return true;
    L11:
        if (Intrinsics.areEqual(r101, "0") == true) goto L12;
        return false;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final void c(c r100, String r101) {
        r100.getClass();
        Object r102 = f518566e;
        monitor-enter(r102);
        FLogger r103 = FLogger.f375446a;     // Catch: Throwable -> L10
        r103.d(AppLogIDLStub.TAG, "markDidReady, reason=".concat(r101));     // Catch: Throwable -> L10
        f518570i = false;     // Catch: Throwable -> L10
        f518562a.getClass();     // Catch: Throwable -> L10
        f518568g = f();     // Catch: Throwable -> L10
        f518571j = 0;     // Catch: Throwable -> L10
        ScheduledFuture<?> r104 = f518569h;     // Catch: Throwable -> L10
        f518569h = null;     // Catch: Throwable -> L10
        monitor-exit(r102);
        if (r104 == null) goto L8;
        r104.cancel(false);
    L8:
        r103.i(AppLogIDLStub.TAG, "did ready, reset reinstall backoff, reason=".concat(r101));
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static final void a(c r100, String r101, String r102) {
        r100.getClass();
        Object r103 = f518566e;
        monitor-enter(r103);
        f518570i = false;     // Catch: Throwable -> L11
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r103);
        if (g(r101, r102, "self_loop", new nba.b()) == true) goto L16;
        FLogger.f375446a.w(AppLogIDLStub.TAG, "skip self loop resetAndReInstall: max retry reached or not accepted, reason=" + r101 + ", did=" + r102 + ", max=" + RangesKt.coerceAtLeast(e().getMaxSelfLoopRetryCount(), 0) + ", currentCount=" + f518571j);
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static final void d(c r100, String r101, String r102, String r103) {
        r100.getClass();
        ObricSharedStateDelegate r104 = ObricSharedStateDelegate.f392933c;     // Catch: Exception -> L15
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r104.a(StateKey.KEY_FLOW_DID, r101);     // Catch: Exception -> L15
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        r104.a(StateKey.KEY_FLOW_IID, r102);     // Catch: Exception -> L15
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r104.a(StateKey.KEY_FLOW_SSID, r103);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        FLogger.f375446a.e(AppLogIDLStub.TAG, "putSharedStateString fail", e);
    }

    public static boolean g(String r110, String r111, String r112, Function0 r113) {
        Object r100 = f518566e;
        monitor-enter(r100);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (f518569h == null) goto L10;
        FLogger.f375446a.i(AppLogIDLStub.TAG, "skip resetAndReInstall schedule: pending retry exists, trigger=" + r112 + ", reason=" + r110 + ", did=" + r111);     // Catch: Throwable -> L28
        monitor-exit(r100);
        return false;
    L10:
        if (f518570i == false) goto L15;
        FLogger.f375446a.i(AppLogIDLStub.TAG, "skip resetAndReInstall schedule: reinstall in flight, trigger=" + r112 + ", reason=" + r110 + ", did=" + r111);     // Catch: Throwable -> L28
        monitor-exit(r100);
        return false;
    L15:
        if (r113 != null) goto L17;
    L19:
        boolean r114 = false;
    L20:
        if (r114 == false) goto L24;
        FLogger.f375446a.w(AppLogIDLStub.TAG, "skip resetAndReInstall schedule: beforeSchedule rejected, trigger=" + r112 + ", reason=" + r110 + ", did=" + r111);     // Catch: Throwable -> L28
        monitor-exit(r100);
        return false;
    L24:
        long r115 = f518568g;     // Catch: Throwable -> L28
        f518569h = f518567f.schedule(new b(r112, r110, r111, r115), r115, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L28
        f518562a.getClass();     // Catch: Throwable -> L28
        f518568g = RangesKt.coerceAtMost(((long) 2) * r115, RangesKt.coerceAtLeast(e().getMaxRetryDelayMs(), f()));     // Catch: Throwable -> L28
        monitor-exit(r100);
        FLogger.f375446a.i(AppLogIDLStub.TAG, "schedule resetAndReInstall, trigger=" + r112 + ", reason=" + r110 + ", invalidDid=" + r111 + ", delayMs=" + r115);
        return true;
    L17:
        if (((Boolean) r113.invoke()).booleanValue() == true) goto L19;
        r114 = true;
        goto L20
    }
}
