package pfa;

import android.app.ActivityManager;
import android.app.ApplicationStartInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.activeness.IObricActivenessMonitorService;
import com.obric.activeness.ObricActiveReason;
import com.obric.assistant.processesmanager.ObricKeepAliveFgService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f528997a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f528998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f528999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f529000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f529001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f529002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f529003g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f529004h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f529005i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f529006j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f529007k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f529008l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f529009m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f529010n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final g f529011o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final h f529012p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f529013q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f529014r = null;

    public static final class a implements k9a.b {
        public a() {
        }

        @Override // k9a.b
        public final void a(boolean r100, ObricActiveReason r101) {
            Intrinsics.checkNotNullParameter(r101, "stateChangeReason");
            FLogger r102 = FLogger.f375446a;
            r102.i("NovaProcessControler", "onStateChanged: isActive=" + r100 + ", isCurrentActive=" + i.f528999c + ", reason=" + r101);
            if (r100 != i.f528999c) goto L5;
            return;
        L5:
            i.f528999c = r100;
            if (r100 == false) goto L8;
            i.f528997a.getClass();
            i.a().removeCallbacks(i.f529011o);
            i.a().postDelayed(i.f529012p, i.f529001e);
            r102.i("NovaProcessControler", "onBecomeActive: scheduled start in " + i.f529001e + "ms");
            return;
        L8:
            i.f528997a.getClass();
            Handler r103 = i.a();
            g r104 = i.f529011o;
            r103.removeCallbacks(r104);
            i.a().removeCallbacks(i.f529012p);
            i.a().postDelayed(r104, i.f529000d);
            r102.i("NovaProcessControler", "onBecomeInactive: scheduled stop in " + i.f529000d + "ms");
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            Object r100 = i.f529009m;
            monitor-enter(r100);
        L23:
            th = move-exception;
            throw th;
        L5:
            if (i.f529008l == true) goto L9;
            FLogger.f375446a.i("NovaProcessControler", "bootAutoStartExitCheckRunnable: skip, needBootAutoStartExitCheck=false");     // Catch: Throwable -> L23
            monitor-exit(r100);
            return;
        L9:
            i.f528997a.getClass();     // Catch: Throwable -> L23
            boolean r101 = i.c();     // Catch: Throwable -> L23
            FLogger r102 = FLogger.f375446a;     // Catch: Throwable -> L23
            r102.i("NovaProcessControler", "bootAutoStartExitCheckRunnable: isActive=" + r101 + ", retryCount=" + i.f529007k);     // Catch: Throwable -> L23
            if (r101 == true) goto L15;
            i.f529008l = false;     // Catch: Throwable -> L23
            r102.i("NovaProcessControler", "bootAutoStartExitCheckRunnable: kill self, pid=" + Process.myPid());     // Catch: Throwable -> L23
            i.f();     // Catch: Throwable -> L23
            Process.killProcess(Process.myPid());     // Catch: Throwable -> L23
            monitor-exit(r100);
            return;
        L15:
            if (i.f529007k < i.f529006j) goto L19;
            i.f529008l = false;     // Catch: Throwable -> L23
            r102.i("NovaProcessControler", "bootAutoStartExitCheckRunnable: reach max retry count, stop recheck");     // Catch: Throwable -> L23
            monitor-exit(r100);
            return;
        L19:
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L23
            monitor-exit(r100);
            i.f529007k++;
            i.a().postDelayed(this, i.f529005i);
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
    }

    public i() {
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [pfa.g] */
    /* JADX WARN: Type inference failed for: r0v12, types: [pfa.h] */
    static {
        f528997a = new i();
        f529000d = 300000;
        f529001e = 2000;
        f529002f = true;
        f529003g = 600000;
        f529004h = 60000;
        f529005i = 20000;
        f529006j = 10;
        f529009m = new Object();
        f529010n = LazyKt.lazy(new f());
        f529011o = new g();
        f529012p = new h();
        f529013q = new b();
        f529014r = new a();
    }

    public static Handler a() {
        return (Handler) s.f529026c.getValue();
    }

    public static boolean c() {
        IObricActivenessMonitorService r100 = (IObricActivenessMonitorService) f529010n.getValue();
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.a(SetsKt.setOf(ObricActiveReason.DEVICE_SCREEN_ON));
    }

    public static void e() {
        if (f528998b == false) goto L6;
        FLogger.f375446a.d("NovaProcessControler", "startFgService: already running, skip");
        return;
    L6:
        boolean r100 = true;
        f528998b = true;
        Lazy r101 = n.f529022a;
        FLogger r102 = FLogger.f375446a;     // Catch: Throwable -> L18
        StringBuilder r103 = new StringBuilder("startKeepAliveFgService, keepAliveHighLevel = ");     // Catch: Throwable -> L18
        Lazy r104 = n.f529022a;     // Catch: Throwable -> L18
        r103.append(((Boolean) r104.getValue()).booleanValue());     // Catch: Throwable -> L18
        r103.append(", productName = ");     // Catch: Throwable -> L18
        r103.append((String) n.f529023b.getValue());     // Catch: Throwable -> L18
        r102.i("ObricFgServiceControl", r103.toString());     // Catch: Throwable -> L18
        if (((Boolean) r104.getValue()).booleanValue() == true) goto L21;
        AppHost.Companion r105 = AppHost.f326268a;     // Catch: Throwable -> L18
        Intent r106 = new Intent(r105.getApplication(), ObricKeepAliveFgService.class);     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT >= 26) goto L14;
        r100 = false;
    L14:
        if (r100 == false) goto L16;
        r105.getApplication().startForegroundService(r106);     // Catch: Throwable -> L18
        goto L21
    L16:
        r105.getApplication().startService(r106);     // Catch: Throwable -> L18
    L21:
        return;
    L18:
        th = move-exception;
        FLogger.f375446a.e("ObricFgServiceControl", "Failed to start startKeepAliveFgService", th);
    }

    public static void f() {
        if (f528998b == true) goto L6;
        FLogger.f375446a.d("NovaProcessControler", "stopFgService: not running, skip");
        return;
    L6:
        f528998b = false;
        Lazy r100 = n.f529022a;
        FLogger.f375446a.i("ObricFgServiceControl", "stopFgService");     // Catch: Throwable -> L9
        AppHost.Companion r101 = AppHost.f326268a;     // Catch: Throwable -> L9
        Intent r102 = new Intent(r101.getApplication(), ObricKeepAliveFgService.class);     // Catch: Throwable -> L9
        r101.getApplication().stopService(r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        FLogger.f375446a.e("ObricFgServiceControl", "Failed to stop stopFgService", th);
    }

    public static boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT >= 35) goto L31;
    L29:
        FLogger.f375446a.i("NovaProcessControler", "isLaunchFromBoot: false");
        return false;
    L31:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L24
        Object r102 = r100.getSystemService("activity");     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L24
        ApplicationStartInfo r103 = (ApplicationStartInfo) CollectionsKt.firstOrNull(((ActivityManager) r102).getHistoricalProcessStartReasons(1));     // Catch: Throwable -> L24
        if (r103 != null) goto L8;
        return false;
    L8:
        if (r103.getReason() != 3) goto L10;
        boolean r104 = true;
    L11:
        FLogger r105 = FLogger.f375446a;     // Catch: Throwable -> L24
        r105.i("NovaProcessControler", "isLaunchFromBoot: reason=" + r103.getReason());     // Catch: Throwable -> L24
        if (r104 == false) goto L22;
        Intent r106 = r103.getIntent();     // Catch: Throwable -> L24
        if (r106 == null) goto L16;
        String r107 = r106.getAction();     // Catch: Throwable -> L24
    L17:
        if (r107 != null) goto L19;
        r107 = "";
    L19:
        boolean r108 = SetsKt.setOf(new String[]{"android.intent.action.BOOT_COMPLETED", "android.intent.action.LOCKED_BOOT_COMPLETED", "android.intent.action.QUICKBOOT_POWERON"}).contains(r107);     // Catch: Throwable -> L24
        r105.i("NovaProcessControler", "isLaunchFromBoot: reason=" + r103.getReason() + ", action=" + r107 + ", result=" + r108);     // Catch: Throwable -> L24
        if (r108 == false) goto L22;
        return true;
    L16:
        r107 = null;
    L22:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L29;
        FLogger.f375446a.e("NovaProcessControler", "isLaunchFromBoot failed", r110);
        goto L29
    L10:
        r104 = false;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    public static boolean d(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContentResolver r111 = r110.getContentResolver();
        boolean r100 = false;
        if (Settings.Global.getInt(r111, "device_provisioned", 0) != 1) goto L5;
        boolean r101 = true;
    L7:
        if (Settings.Secure.getInt(r111, "user_setup_complete", 0) != 1) goto L9;
        boolean r102 = true;
    L10:
        String r112 = Settings.Global.getString(r111, "sys.boot_completed");
        if (r112 != null) goto L13;
        r112 = "0";
    L13:
        long r103 = SystemClock.elapsedRealtime();
        long r104 = SystemClock.uptimeMillis();
        if (0 <= r104) goto L16;
    L18:
        FLogger.f375446a.i("NovaProcessControler", "isSystemJustBoot: bootRealTimeMs=" + r103 + ", bootUptimeMs=" + r104 + ", result=" + r100 + ", bootComplete=" + r112 + "，deviceProvisioned=" + r101 + "，userSetupComplete=" + r102);
        return r100;
    L16:
        if (r104 >= f529003g) goto L18;
        r100 = true;
        goto L18
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }
}
