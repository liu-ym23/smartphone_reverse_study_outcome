package com.douyin.janna.platform;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.douyin.janna.api.CapabilityType;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class f extends a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Method f273617m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PowerManager f273618n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e f273619o;

    @Override // com.douyin.janna.platform.a
    public final void f() {
        Class r100 = j();     // Catch: Exception -> L8
        if (r100 == null) goto L6;
        this.f273617m = r100.getMethod("setViewAnimationState", new Class[]{String.class, String.class, Integer.TYPE});     // Catch: Exception -> L8
    L6:
        Objects.toString(this.f273617m);     // Catch: Exception -> L8
        boolean r101 = hq7.a.f486512a;     // Catch: Exception -> L8
        this.f273598a.getPackageName();     // Catch: Exception -> L8
    L10:
        ((HashSet) this.f273605h).add(CapabilityType.SET_REFRESH_RATE);
        if (this.f273617m == null) goto L13;
        ((HashSet) this.f273605h).add(CapabilityType.SET_FPS);
        ((HashSet) this.f273605h).add(CapabilityType.CANCEL_FPS);
    L13:
        this.f273600c = true;
        return;
    L8:
        e = move-exception;
        e.getMessage();
        boolean r102 = hq7.a.f486512a;
        goto L10
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class j() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.huawei.hwaps.HwApsManagerEx");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.huawei.hwaps.HwApsManagerEx");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.huawei.hwaps.HwApsManagerEx");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.huawei.hwaps.HwApsManagerEx");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.huawei.hwaps.HwApsManagerEx");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.huawei.hwaps.HwApsManagerEx");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.huawei.hwaps.HwApsManagerEx");
    }

    public f(Context r100) {
        super(r100);
        this.f273617m = null;
        this.f273618n = null;
    }

    @Override // com.douyin.janna.platform.a
    public final void h(fs7.b r110, List<Integer> r111) {
        super.h(r110, r111);
        if (this.f273600c == true) goto L5;
        return;
    L5:
        if (r111.contains(11) == true) goto L7;
        return;
    L7:
        if (this.f273618n != null) goto L10;
        this.f273618n = (PowerManager) this.f273598a.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    L10:
        if (this.f273618n != null) goto L12;
    L44:
        int r112 = this.f273603f;
        if (r112 != 1) goto L53;
        r110.onEvent(a.a(r112));
        return;
    L53:
        return;
    L12:
        if (this.f273619o != null) goto L44;
        IntentFilter r113 = new IntentFilter("huawei.intent.action.POWER_MODE_CHANGED_ACTION");
        this.f273619o = new e(this);
        this.f273603f = this.f273618n.isPowerSaveMode() ? 1 : 0;
        boolean r100 = hq7.a.f486512a;
        Context r101 = this.f273598a;
        e r102 = this.f273619o;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L49;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L49:
    L39:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L43;
        ReceiverRegisterCrashOptimizer.registerReceiver(r102, r113);
        goto L44
    L43:
        throw e;
    L17:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L30;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r113) == false) goto L30;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r102, r113, 0, null, null, 2, r101).result;     // Catch: Exception -> L39
        if (r103 != 1) goto L23;
        r101.registerReceiver(r102, r113);     // Catch: Exception -> L39
    L48:
        goto L44
    L23:
        if (r103 != 2) goto L25;
        new Intent();     // Catch: Exception -> L39
        goto L48
    L25:
        if (r103 == 3) goto L48;
        r101.registerReceiver(r102, r113);     // Catch: Exception -> L39
    L30:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L33;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L39
        r101.registerReceiver(r102, r113, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L39
        goto L48
    L33:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L35;
    L37:
        r101.registerReceiver(r102, r113);     // Catch: Exception -> L39
        goto L48
    L35:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r113) == false) goto L37;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L39
        ContextCompat.registerReceiver(r101, r102, r113, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L39
        goto L48
    }
}
