package com.obric.miniapp.utils;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.crash.Npth;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f398499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f398500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static DevicePowerManager$registerSleepModeReceiver$1 f398501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f398502d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<b> f398503e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<a> f398504f = null;

    public interface a {
        void a(boolean r100);
    }

    public interface b {
        void a(String r100);
    }

    public k0() {
    }

    static {
        f398499a = true;
        f398502d = LazyKt.lazy(new j0());
        f398503e = new LinkedHashSet();
        f398504f = new LinkedHashSet();
    }

    public static String e() {
        String r100 = f398500b;
        if (r100 == null) goto L34;
        return r100;
    L34:
        AppHost.Companion r101 = AppHost.f326268a;     // Catch: Exception -> L31
        Application r102 = r101.getApplication();     // Catch: Exception -> L31
        Object r103 = r102.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Exception -> L31
        PowerManager r104 = null;
        if ((r103 instanceof PowerManager) == false) goto L8;
        PowerManager r105 = (PowerManager) r103;     // Catch: Exception -> L31
    L9:
        if (r105 != null) goto L11;
        return "screenOff";
    L11:
        boolean r106 = r105.isInteractive();     // Catch: Exception -> L31
        Object r107 = r102.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Exception -> L22
        if ((r107 instanceof PowerManager) == false) goto L15;
        r104 = (PowerManager) r107;     // Catch: Exception -> L22
    L15:
        if (r104 != null) goto L18;
    L24:
        boolean r108 = false;
    L25:
        if (r106 == false) goto L37;
        if (r108 == false) goto L29;
        String r109 = "userPresent";
    L38:
        return r109;
    L29:
        r109 = "screenOn";
        goto L38
    L37:
        return "screenOff";
    L18:
        if (r104.isInteractive() == false) goto L24;
        if (r101.a().getCurrentActivity() == null) goto L24;
        r108 = true;
        goto L25
    L22:
        e = move-exception;
        FLogger.f375446a.w("DevicePowerManager", "Error checking user present", e);     // Catch: Exception -> L31
        goto L24
    L8:
        r105 = null;
    L31:
        e = move-exception;
        FLogger.f375446a.e("DevicePowerManager", "Error getting screen mode", e);
        return "screenOff";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static final void d(String r100) {
        String r101 = f398500b;
        f398500b = r100;
        if (Intrinsics.areEqual(r101, r100) == true) goto L12;
        FLogger.f375446a.d("DevicePowerManager", "Screen mode changed from " + r101 + " to " + r100);
        Iterator<T> r102 = f398503e.iterator();
    L6:
        if (r102.hasNext() == false) goto L19;
        ((b) r102.next()).a(r100);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        FLogger.f375446a.e("DevicePowerManager", "Error notifying screen mode listener", e);
        goto L6
    L19:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void c(Application r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L12;
        r100.unregisterReceiver(r101);
        return;
    L12:
    L8:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r101.toString());
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L14;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Application r100, BroadcastReceiver r101, IntentFilter r110, Handler r111, int r112) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L29:
    L23:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L28;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, "android.permission.WRITE_SECURE_SETTINGS", r111, r112);
        return;
    L28:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L8;
    L21:
        r100.registerReceiver(r101, r110, "android.permission.WRITE_SECURE_SETTINGS", r111, r112);     // Catch: Exception -> L23
        return;
    L8:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L21;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r112, "android.permission.WRITE_SECURE_SETTINGS", r111, 5, r100).result;     // Catch: Exception -> L23
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110, "android.permission.WRITE_SECURE_SETTINGS", r111, r112);     // Catch: Exception -> L23
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L23
        return;
    L14:
        if (r102 == 3) goto L30;
        r100.registerReceiver(r101, r110, "android.permission.WRITE_SECURE_SETTINGS", r111, r112);     // Catch: Exception -> L23
        return;
    }
}
