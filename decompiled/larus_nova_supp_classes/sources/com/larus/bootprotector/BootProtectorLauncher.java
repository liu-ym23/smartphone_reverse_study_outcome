package com.larus.bootprotector;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.EventsUtils;
import au8.c;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.larus.bootprotector.activity.l;
import com.larus.bootprotector.entity.LastException;
import com.larus.bootprotector.utils.hook.RedirectActivityInstrumentation;
import com.larus.common.apphost.AppHost;
import com.larus.settings.provider.bootprotector.BootProtectorConfig;
import com.larus.settings.provider.bootprotector.BootProtectorSilentCleanConfig;
import com.larus.settings.provider.bootprotector.CrashPortrait;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import du8.b;
import gu8.d;
import hu8.e;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0016¨\u0006%"}, d2 = {"Lcom/larus/bootprotector/BootProtectorLauncher;", "Lcom/larus/bootprotector/IBootProtectorLauncher;", "<init>", "()V", "init", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "checkBootProtectorEffect", "baseContext", "checkToCleanFileSilent", "clearBootProtectorData", "isBootProtectorEnabled", XmlPullParser.NO_NAMESPACE, "shouldEnterBootProtectorPage", "updateBootProtectorSettings", "initNpthMonitor", "initAnrMonitor", "enableBootProtectorInTestChannel", "isTestChannel", "startBootProtectorLandingPage", "checkLastExceptionMatchOrNot", "onJavaCrashed", "getBootProtectorDependency", "Lcom/larus/bootprotector/BootProtectorDependency;", "executeCmdArray", "ctx", "cmds", "Lcom/google/gson/JsonArray;", "executeCmds", XmlPullParser.NO_NAMESPACE, "onAppRestartAfterCrash", "registerANRListener", "listener", "Lcom/larus/bootprotector/anr/FlowAnrListener;", "unregisterANRListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class BootProtectorLauncher implements IBootProtectorLauncher {
    public static boolean b;
    public static Context c;
    public static long d;

    public static final class a {
    }

    public BootProtectorLauncher() {
    }

    static {
        d = -1;
    }

    public static void m() {
        nu8.a.b("BootProtectorLauncher", "onJavaCrashed");
        if (Looper.myLooper() == null) goto L11;
        Looper.loop();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        nu8.a.f("BootProtectorLauncher", th, "onJavaCrashed failed:");
        m();
        return;
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final BootProtectorDependency b() {
        BootProtectorDependency r0 = (BootProtectorDependency) ServiceManager.get().getService(BootProtectorDependency.class);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException();
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void f() {
        if (b == true) goto L6;
        nu8.a.b("BootProtectorLauncher", "startBootProtectorLandingPage error, not Inited");
        return;
    L6:
        Context r0 = c;
        if (r0 != null) goto L9;
    L12:
        nu8.a.e("BootProtectorLauncher", "call startBootProtectorLandingPage start");
        Thread.setDefaultUncaughtExceptionHandler(new c(this));
        RedirectActivityInstrumentation.a r1 = RedirectActivityInstrumentation.Companion;
        com.larus.bootprotector.activity.a r2 = new com.larus.bootprotector.activity.a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "redirect");
        nu8.a.a("RedirectActivityInstru", "before hook");     // Catch: Exception -> L18
        Method r5 = RedirectActivityInstrumentation.a.a().getDeclaredMethod("currentActivityThread", new Class[0]);     // Catch: Exception -> L18
        r5.setAccessible(true);     // Catch: Exception -> L18
        Object r6 = r5.invoke(null, new Object[0]);     // Catch: Exception -> L18
        if (r6 == null) goto L35;
        Field r7 = r6.getClass().getDeclaredField("mInstrumentation");     // Catch: Exception -> L18
        r7.setAccessible(true);     // Catch: Exception -> L18
        Object r8 = r7.get(r6);     // Catch: Exception -> L18
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.app.Instrumentation");     // Catch: Exception -> L18
        r7.set(r6, new RedirectActivityInstrumentation((Instrumentation) r8, r2, null));     // Catch: Exception -> L18
        nu8.a.a("RedirectActivityInstru", "hook success");     // Catch: Exception -> L18
    L35:
        LastException r3 = e.h();     // Catch: Throwable -> L31
        if (r3 != null) goto L22;
        boolean r4 = false;
    L23:
        if (r4 == true) goto L29;
        nu8.a.b("BootProtectorLauncher", "checkLastExceptionMatchOrNot: NOT MATCHED, restart App now !");     // Catch: Throwable -> L31
        Context r9 = c;     // Catch: Throwable -> L31
        if (r9 == null) goto L27;
        Intrinsics.checkNotNullParameter(r9, "baseContext");     // Catch: Throwable -> L31
        e.a(r9, false, "enter_boot_protector");     // Catch: Throwable -> L31
    L27:
        iu8.a.c();     // Catch: Throwable -> L31
        throw null;     // Catch: Throwable -> L31
    L29:
        nu8.a.e("BootProtectorLauncher", "checkLastExceptionMatchOrNot: MATCHED, ready to start BootProtectorLandingActivity!");     // Catch: Throwable -> L31
    L33:
        nu8.a.e("BootProtectorLauncher", "call startBootProtectorLandingPage end");
        return;
    L22:
        r4 = ku8.a.d(r3);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        nu8.a.f("BootProtectorLauncher", th, "checkLastExceptionMatchOrNot failed:");
    L18:
        nu8.a.b("RedirectActivityInstru", "Hook Method Instrumentation Failed!!!");
        goto L35
    L9:
        if (BootProtectorProcessDiffContract.b.isMainProcess(r0) == true) goto L12;
        nu8.a.b("BootProtectorLauncher", "startBootProtectorLandingPage error, not Main Process!");
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void k() {
        if (b == true) goto L6;
        nu8.a.b("BootProtectorLauncher", "onAppRestartAfterCrash Error: BootProtector has NOT inited, return!");
        return;
    L6:
        Lazy r0 = b.a;
        int r1 = e.g();
        if (r1 > 0) goto L9;
        nu8.a.e("BootProtectorCBDispatcher", "onAppRestartAfterCrash RETURN! currentCrashCount " + r1);
        return;
    L9:
        LastException r2 = e.h();
        if (r2 != null) goto L13;
        nu8.a.e("BootProtectorCBDispatcher", "onAppRestartAfterCrash RETURN! lastException is null!");
        return;
    L13:
        if (e.b().getEnableBizCallback() == true) goto L15;
        nu8.a.e("BootProtectorCBDispatcher", "onAppRestartAfterCrash enableBizCallback is false!");
        return;
    L15:
        b.d();
        Iterator r3 = b.a(r1, r2).values().iterator();
    L17:
        if (r3.hasNext() == false) goto L23;
        Pair r4 = (Pair) r3.next();
        nu8.a.e("BootProtectorCBDispatcher", "onAppRestartAfterCrash bizTag: " + ((IBootProtectorBizCallback) r4.getFirst()).getBizTag() + ", crashPortrait: " + r4.getSecond() + ", lastException: " + r2);
        ((IBootProtectorBizCallback) r4.getFirst()).c(r1, (CrashPortrait) r4.getSecond(), r2);
        goto L17
    }

    public static boolean l(Context r2) {
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r2, "baseContext");
        boolean r3 = e.i(r2, "enable_boot_protector_FOR_TEST");
        nu8.a.e("BootProtectorSettings", "isBootProtectorInTestChannelEnabled FLAG -> " + r3);
        return r3;
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void a(com.larus.init.task.anr.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        cu8.c.a(r2);
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final boolean c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        int r1 = e.a;
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        boolean r2 = e.i(r5, "enable_boot_protector");
        nu8.a.e("BootProtectorSettings", "isBootProtectorEnabled FLAG -> " + r2);
        if (r2 == false) goto L9;
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        boolean r0 = e.i(r5, "enter_boot_protector");
        nu8.a.e("BootProtectorSettings", "shouldEnterBootProtectorPage FLAG -> " + r0);
        if (r0 == false) goto L9;
        if (BootProtectorProcessDiffContract.b.isMainProcess(r5) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void d(Context r14) {
        Intrinsics.checkNotNullParameter(r14, "baseContext");
        int r1 = l.a;
        Intrinsics.checkNotNullParameter(r14, "baseContext");
        int r0 = e.g();     // Catch: Throwable -> L35 Exception -> L37
        if (r0 > 0) goto L7;
        FLogger r15 = FLogger.a;     // Catch: Throwable -> L35 Exception -> L37
        r15.i("BootProtectorSilentClean", "checkToCleanFileSilent RETURN! currentCrashCount " + r0);     // Catch: Throwable -> L35 Exception -> L37
    L9:
        r15.i("BootProtectorSilentClean", "checkToCleanFileSilent finally");
        return;
    L7:
        if (e.h() != null) goto L10;
        r15 = FLogger.a;     // Catch: Throwable -> L35 Exception -> L37
        r15.i("BootProtectorSilentClean", "checkToCleanFileSilent RETURN! lastException is null!");     // Catch: Throwable -> L35 Exception -> L37
        goto L9
    L10:
        BootProtectorSilentCleanConfig r6 = e.c();     // Catch: Throwable -> L35 Exception -> L37
        FLogger r7 = FLogger.a;     // Catch: Throwable -> L35 Exception -> L37
        r7.i("BootProtectorSilentClean", "checkToCleanFileSilent bootProtectorSilentCleanConfig is " + r6);     // Catch: Throwable -> L35 Exception -> L37
        if (Intrinsics.areEqual(r6.getSilentCleanEnable(), Boolean.TRUE) == true) goto L13;
        r7.i("BootProtectorSilentClean", "checkToCleanFileSilent RETURN! silentCleanEnable is " + r6.getSilentCleanEnable());     // Catch: Throwable -> L35 Exception -> L37
    L34:
        r7.i("BootProtectorSilentClean", "checkToCleanFileSilent finally");
        return;
    L13:
        Long r4 = r6.getMaxUpdateVersionCode();     // Catch: Throwable -> L35 Exception -> L37
        if (r4 == null) goto L19;
        long r8 = r4.longValue();     // Catch: Throwable -> L35 Exception -> L37
        AppHost.Companion r5 = AppHost.a;     // Catch: Throwable -> L35 Exception -> L37
        if (r5.getUpdateVersionCode() <= r8) goto L19;
        r7.e("BootProtectorSilentClean", "checkToCleanFileSilent RETURN! updateVersionCode " + r5.getUpdateVersionCode() + " is greater than maxUpdateVersionCode " + r8);     // Catch: Throwable -> L35 Exception -> L37
    L19:
        Long r9 = r6.getMinUpdateVersionCode();     // Catch: Throwable -> L35 Exception -> L37
        if (r9 == null) goto L24;
        long r10 = r9.longValue();     // Catch: Throwable -> L35 Exception -> L37
        AppHost.Companion r11 = AppHost.a;     // Catch: Throwable -> L35 Exception -> L37
        if (r11.getUpdateVersionCode() >= r10) goto L24;
        r7.e("BootProtectorSilentClean", "checkToCleanFileSilent RETURN! updateVersionCode " + r11.getUpdateVersionCode() + " is less than minUpdateVersionCode " + r10);     // Catch: Throwable -> L35 Exception -> L37
    L24:
        List r2 = l.b(r0);     // Catch: Throwable -> L35 Exception -> L37
        List r12 = r2;     // Catch: Throwable -> L35 Exception -> L37
        if (r12 != null) goto L27;
    L30:
        boolean r13 = true;
    L31:
        if (r13 == false) goto L33;
        r7.i("BootProtectorSilentClean", "checkToCleanFileSilent RETURN! urgentCmds is " + r2);     // Catch: Throwable -> L35 Exception -> L37
        goto L34
    L33:
        l.a(r14, r2);     // Catch: Throwable -> L35 Exception -> L37
        r7.i("BootProtectorSilentClean", "checkToCleanFileSilent finish");     // Catch: Throwable -> L35 Exception -> L37
        goto L34
    L27:
        if (r12.isEmpty() == true) goto L30;
        r13 = false;
    L37:
        e = move-exception;
        FLogger r3 = FLogger.a;     // Catch: Throwable -> L35
        r3.e("BootProtectorSilentClean", "checkToCleanFileSilent error", e);     // Catch: Throwable -> L35
        r3.i("BootProtectorSilentClean", "checkToCleanFileSilent finally");
        return;
    L35:
        th = move-exception;
        FLogger.a.i("BootProtectorSilentClean", "checkToCleanFileSilent finally");
        throw th;
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "baseContext");
        if (BootProtectorProcessDiffContract.b.isMainProcess(r2) == true) goto L6;
        nu8.a.b("BootProtectorLauncher", "updateBootProtectorSettings return, not Main Process!");
        return;
    L6:
        e.j(r2);
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void h(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        BootProtectorProcessDiffContract r0 = BootProtectorProcessDiffContract.b;
        if (r0.isMainProcess(r5) == true) goto L6;
        nu8.a.b("BootProtectorLauncher", "initNpthMonitor return, not Main Process!");
        return;
    L6:
        AppHost.Companion r1 = AppHost.a;
        if (r1.isDebug() == false) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L15;
    L18:
        gu8.b.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r0.isMainProcess(r5) == false) goto L25;
        nu8.a.e("BootProtectorNpth", "initNpthMonitor");
        if (gu8.b.d != null) goto L23;
        gu8.b.d = new d(r5);
    L23:
        nu8.a.e("BootProtectorNpth", "registerCrashCallback");
        Npth.registerCrashCallback(gu8.b.d, CrashType.ALL);
        return;
    L25:
        return;
    L15:
        if (l(r5) == true) goto L18;
        nu8.a.b("BootProtectorLauncher", "initNpthMonitor DISABLE! current is test env");
        return;
    L9:
        if (r1.isTestChannel() == true) goto L12;
        r2 = false;
        goto L13
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void i(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "baseContext");
        BootProtectorProcessDiffContract r0 = BootProtectorProcessDiffContract.b;
        if (r0.isMainProcess(r6) == true) goto L6;
        nu8.a.b("BootProtectorLauncher", "initAnrMonitor return, not Main Process!");
        return;
    L6:
        AppHost.Companion r1 = AppHost.a;
        boolean r4 = false;
        if (r1.isDebug() == false) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L15;
    L18:
        gu8.b.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        if (r0.isMainProcess(r6) == false) goto L37;
        nu8.a.e("BootProtectorNpth", "initAnrMonitor");
        e10 r7 = e10.a;
        BootProtectorConfig r8 = e10.C();
        if (r8 == null) goto L25;
        Boolean r3 = r8.getAnrMonitorEnable();
        if (r3 == null) goto L25;
        r4 = r3.booleanValue();
    L25:
        gu8.b.f = r4;
        if (r8 == null) goto L31;
        Integer r9 = r8.getAnrMonitorLevel();
        if (r9 == null) goto L31;
        r9.intValue();
    L31:
        if (gu8.b.f == true) goto L34;
        nu8.a.b("BootProtectorNpth", "registerANRListener anr monitor is disabled");
        return;
    L34:
        if (gu8.b.e != null) goto L39;
        gu8.c r10 = new gu8.c();
        gu8.b.e = r10;
        cu8.c.a(r10);
        return;
    L39:
        return;
    L37:
        return;
    L15:
        if (l(r6) == true) goto L18;
        nu8.a.b("BootProtectorLauncher", "initAnrMonitor DISABLE! current is test env");
        return;
    L9:
        if (r1.isTestChannel() == true) goto L12;
        r2 = false;
        goto L13
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void init(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (b == false) goto L6;
        nu8.a.b("BootProtectorLauncher", "has inited before, return!");
        return;
    L6:
        nu8.a.e("BootProtectorLauncher", "call init");
        c = r3;
        d = System.currentTimeMillis();
        b = true;
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void j(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "baseContext");
        if (BootProtectorProcessDiffContract.b.isMainProcess(r6) == true) goto L6;
        nu8.a.b("BootProtectorLauncher", "checkBootProtectorEffect return, not Main Process!");
        return;
    L6:
        nu8.a.e("BootProtectorLauncher", "call checkBootProtectorEffect");
        new Handler(Looper.getMainLooper()).postDelayed(new au8.d(this, r6), e.f());
    }

    @Override // com.larus.bootprotector.IBootProtectorLauncher
    public final void e(Context r7, JsonArray r8) {
        Intrinsics.checkNotNullParameter(r7, "ctx");
        Intrinsics.checkNotNullParameter(r8, "cmds");
        nu8.a.e("BootProtectorLauncher", "executeCmds JsonArray: " + r8);     // Catch: Throwable -> L9
        int r2 = r8.size();     // Catch: Throwable -> L9
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L11;
        JsonElement r4 = r8.get(r3);     // Catch: Throwable -> L9
        if (r4.isJsonObject() == false) goto L8;
        eu8.c.a(r7, r4.getAsJsonObject()).execute();     // Catch: Throwable -> L9
    L8:
        r3 = r3 + 1;
    L11:
        nu8.a.e("BootProtectorLauncher", "executeCmds JsonArray finally");
        return;
    L9:
        th = move-exception;
        nu8.a.f("BootProtectorLauncher", th, "executeCmds JsonArray failed:");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        nu8.a.e("BootProtectorLauncher", "executeCmds JsonArray finally");
        throw th;
    }
}
