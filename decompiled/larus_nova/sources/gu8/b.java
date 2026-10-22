package gu8;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.anr.AnrManager;
import com.larus.bootprotector.BootProtectorLauncher;
import com.larus.bootprotector.entity.BaseExceptionInfo;
import com.larus.bootprotector.entity.LastException;
import com.larus.common.apphost.AppHost;
import com.larus.settings.coldboot.EarlyFileSettingsStore;
import com.larus.utils.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import hu8.e;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f482793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f482794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f482795c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static d f482796d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f482797e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f482798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f482799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f482800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f482801i;

    /* JADX INFO: loaded from: classes26.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f482802a = null;

        static {
            int[] r100 = new int[CrashType.values().length];
            r100[CrashType.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[CrashType.LAUNCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[CrashType.NATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[CrashType.ANR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f482802a = r100;
        }
    }

    public b() {
    }

    static {
        f482793a = new b();
        f482795c = LazyKt.lazy(new gu8.a());
        f482800h = "";
    }

    public static void d() {
        nu8.a.e("BootProtectorNpth", "stopNpthMonitor");
        if (f482796d == null) goto L6;
        nu8.a.e("BootProtectorNpth", "unregisterCrashCallback");
        Npth.unregisterCrashCallback(f482796d, CrashType.ALL);
        f482796d = null;
    L6:
        if (f482797e == null) goto L19;
        nu8.a.e("BootProtectorNpth", "unregisterANRListener");
        c r100 = f482797e;
        if (r100 == null) goto L17;
        List<cu8.a> r101 = cu8.c.f465442a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) cu8.c.f465442a;
        if (r102.contains(r100) == false) goto L13;
        nu8.a.e("FlowAnrMonitor", "unregisterANRListener result: " + r102.remove(r100));
    L13:
        if (r102.isEmpty() == false) goto L17;
        if (cu8.c.f465443b == null) goto L17;
        nu8.a.e("FlowAnrMonitor", "stopSysOptimizerAnrMonitor");
        AnrManager.getInstance().unRegisterListener(cu8.c.f465443b);
        cu8.c.f465443b = null;
        cu8.c.f465445d = 0;
        cu8.c.f465446e = 0;
    L17:
        f482797e = null;
        return;
    }

    public static void b(Context r100, String r101) {
        StringBuilder r102 = new StringBuilder("countCrash -> ");
        if (r101 == null) goto L5;
        String r103 = StringsKt.take(r101, 200);
    L6:
        r102.append(r103);
        nu8.a.b("BootProtectorNpth", r102.toString());
        int r104 = e.g() + 1;
        int r105 = e.g() + 1;
        hu8.a.b("current_crash_count", r105);
        nu8.a.a("BootProtectorSettings", "increaseCrashCount new countCrash is " + r105);
        nu8.a.e("BootProtectorNpth", "current crash count is " + r104);
        if (r104 < e.e()) goto L39;
        Intrinsics.checkNotNullParameter(r100, "baseContext");
        e.a(r100, true, "enter_boot_protector");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L20
        com.larus.settings.coldboot.b.f368534a.getClass();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L20
        EarlyFileSettingsStore.Key r107 = com.larus.settings.coldboot.b.f368535b;     // Catch: Throwable -> L20
        if (EarlyFileSettingsStore.a(r100, r107) == true) goto L12;
        Objects.toString(r107);     // Catch: Throwable -> L20
    L12:
        EarlyFileSettingsStore.Key r108 = com.larus.settings.coldboot.b.f368536c;     // Catch: Throwable -> L20
        if (EarlyFileSettingsStore.a(r100, r108) == true) goto L15;
        Objects.toString(r108);     // Catch: Throwable -> L20
    L15:
        EarlyFileSettingsStore.Key r109 = com.larus.settings.coldboot.b.f368537d;     // Catch: Throwable -> L20
        if (EarlyFileSettingsStore.a(r100, r109) == true) goto L18;
        Objects.toString(r109);     // Catch: Throwable -> L20
    L18:
        com.larus.settings.coldboot.b.f368538e = com.larus.settings.coldboot.a.f368530d;     // Catch: Throwable -> L20
        Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L41;
        nu8.a.f("BootProtectorNpth", r111, "clear keva perf opt markers failed:");
    L41:
        com.larus.settings.coldboot.c.f368540a.getClass();     // Catch: Throwable -> L33
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L33
        EarlyFileSettingsStore.Key r112 = com.larus.settings.coldboot.c.f368541b;     // Catch: Throwable -> L33
        if (EarlyFileSettingsStore.a(r100, r112) == true) goto L28;
        Objects.toString(r112);     // Catch: Throwable -> L33
    L28:
        EarlyFileSettingsStore.Key r113 = com.larus.settings.coldboot.c.f368542c;     // Catch: Throwable -> L33
        if (EarlyFileSettingsStore.a(r100, r113) == true) goto L31;
        Objects.toString(r113);     // Catch: Throwable -> L33
    L31:
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L38;
        nu8.a.f("BootProtectorNpth", r115, "clear keva executor config markers failed:");
    L38:
        nu8.a.h("BootProtectorNpth", "clear keva cold boot opt markers because continuous launch crash reached threshold");
        return;
    L33:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L20:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L39:
        Intrinsics.checkNotNullParameter(r100, "baseContext");
        e.a(r100, false, "enter_boot_protector");
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void a(b r100, long r101, String r102, String r103) {
        r100.getClass();
        nu8.a.b("BootProtectorNpth", "onAnrComing, from: ".concat(r103));
        if (f482798f == true) goto L5;
        nu8.a.b("BootProtectorNpth", "onAnrComing! BUT ANR monitor is disabled");
        return;
    L5:
        int r104 = e.f();
        if ((r101 - BootProtectorLauncher.f317599d) <= r104) goto L9;
        nu8.a.b("BootProtectorNpth", "ANR ignore: exceed " + r104);
        return;
    L9:
        if (f482799g == false) goto L11;
        nu8.a.e("BootProtectorNpth", "anr has happended before, DO NOT count");
    L13:
        if (f482800h.contentEquals(r102) == false) goto L15;
    L23:
        nu8.a.b("BootProtectorNpth", "Same anr happend again, DO NOTHING");
        return;
    L15:
        if ((System.currentTimeMillis() - f482801i) < 5000) goto L23;
        f482800h = r102;
        f482801i = System.currentTimeMillis();
        AppHost.Companion r105 = AppHost.f326268a;
        c(r105.getApplication(), CrashType.ANR, r102, null);
        du8.b.b();
        e.k(r105.getApplication(), r102);     // Catch: Throwable -> L20
    L22:
        int r106 = au8.b.f16318a;
        au8.b.a("bootprotector_anr_coming", f.c(new Pair[]{TuplesKt.to("from", r103), TuplesKt.to("mainstack", StringsKt.take(r102, 4000)), TuplesKt.to("mainstack_length", Integer.valueOf(r102.length()))}));
        return;
    L20:
        th = move-exception;
        nu8.a.f("BootProtectorNpth", th, "saveCrashStack failed:");
        goto L22
    L11:
        nu8.a.e("BootProtectorNpth", "anr happend FIRST time!");
        f482799g = true;
        b(AppHost.f326268a.getApplication(), r102);
        goto L13
    }

    public static void c(Context r110, CrashType r111, String r112, Thread r113) {
        long r100 = System.currentTimeMillis();
        AppHost.Companion r101 = AppHost.f326268a;
        String r102 = r101.getVersionName();
        int r103 = r101.getUpdateVersionCode();
        int r104 = Build.VERSION.SDK_INT;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        int r105 = Process.myPid();
        Object r114 = r110.getSystemService("activity");
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> r115 = ((ActivityManager) r114).getRunningAppProcesses();
        if (r115 == null) goto L11;
        Iterator<ActivityManager.RunningAppProcessInfo> r116 = r115.iterator();
    L7:
        if (r116.hasNext() == false) goto L11;
        ActivityManager.RunningAppProcessInfo r106 = r116.next();
        if (r106.pid != r105) goto L7;
        nu8.a.a("ProcessUtils", "process name is " + r106.processName);
        String r117 = r106.processName;
    L12:
        if (r117 != null) goto L14;
        r117 = "";
    L14:
        String r107 = r117;
        if (r112 == null) goto L17;
        nu8.a.e("BootProtectorNpth", "saveLastExceptionInfo: crash:" + StringsKt.take(r112, 200) + " type:" + r111);
    L17:
        int r118 = a.f482802a[r111.ordinal()];
        if (r118 != 1) goto L20;
    L28:
        BaseExceptionInfo.Type r119 = BaseExceptionInfo.Type.JAVA;
    L29:
        BaseExceptionInfo.Type r108 = r119;
        if (r113 == null) goto L32;
        String r109 = r113.getName();
    L33:
        LastException r120 = new LastException(r112, r100, r108, r102, r103, r104, r107, r109);
        int r121 = e.f487260a;
        Intrinsics.checkNotNullParameter(r120, "lastException");
        hu8.a.c("last_exception_info", r120);
        nu8.a.a("BootProtectorSettings", "updateLastExceptionInfo is " + r120);
        return;
    L32:
        r109 = null;
        goto L33
    L20:
        if (r118 == 2) goto L28;
        if (r118 != 3) goto L24;
        r119 = BaseExceptionInfo.Type.NATIVE;
        goto L29
    L24:
        if (r118 == 4) goto L26;
        r119 = BaseExceptionInfo.Type.JAVA;
        goto L29
    L26:
        r119 = BaseExceptionInfo.Type.ANR;
    L11:
        r117 = null;
        goto L12
    }
}
