package com.obric.performance.power.monitor.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import androidx.core.content.ContextCompat;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.ss.android.lark.utils.statistics.PerfLog;
import fna.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class BatteryMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BatteryMonitor f403797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f403798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static BatteryInfoReceiver f403799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<a> f403800d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static float f403801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f403802f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static float f403803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f403804h;

    /* JADX INFO: loaded from: classes34.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/performance/power/monitor/battery/BatteryMonitor$BatteryInfoReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BatteryInfoReceiver extends BroadcastReceiver {
        public BatteryInfoReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "intent");
            ILogDepend.f384986a.d("PowerMonitor", "BatteryMonitor onReceive");
            BatteryMonitor.f403797a.getClass();
            BatteryMonitor.c(r101);
        }
    }

    public interface a {
        void a(boolean r100);
    }

    public BatteryMonitor() {
    }

    static {
        f403797a = new BatteryMonitor();
        f403800d = Collections.synchronizedList(new ArrayList());
    }

    public static void c(Intent r100) {
        String r101 = null;
        Object r102 = BatteryManager.class.getField("EXTRA_CHARGE_COUNTER").get(null);     // Catch: Throwable -> L6
        if ((r102 instanceof String) == false) goto L8;
        r101 = (String) r102;     // Catch: Throwable -> L6
    L8:
        if (r101 != null) goto L10;
        int r103 = -1;
    L11:
        f403804h = r103;
        f403801e = 100 * (r100.getIntExtra("level", -1) / r100.getIntExtra("scale", -1));
        int r104 = r100.getIntExtra("status", -1);
        if (r104 != 2) goto L14;
    L17:
        boolean r105 = true;
    L19:
        if (f403802f == r105) goto L32;
        List<a> r106 = f403800d;
        monitor-enter(r106);
        Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L29
    L24:
        if (r107.hasNext() == false) goto L26;
        ((a) r107.next()).a(r105);     // Catch: Throwable -> L29
        goto L24
    L26:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r106);
    L29:
        th = move-exception;
        throw th;
    L32:
        f403802f = r105;
        ILogDepend.f384986a.d("PowerMonitor", "BatteryMonitor resetValue: cap=" + f403801e + ", charger=" + f403802f);
        f403803g = ((float) r100.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, 0)) / 10.0f;
        return;
    L14:
        if (r104 == 5) goto L17;
        r105 = false;
        goto L19
    L10:
        r103 = r100.getIntExtra(r101, -1);
    L6:
        r101 = "android.os.extra.CHARGE_COUNTER";
        goto L8
    }

    public final synchronized void b(g.a r100) {
        monitor-enter(this);
        if (r100 != null) goto L15;
    L13:
        monitor-exit(this);
        return;
    L15:
        List<a> r101 = f403800d;     // Catch: Throwable -> L10
        if (r101.contains(r100) == true) goto L13;
        r100.a(f403802f);     // Catch: Throwable -> L10
        r101.add(r100);     // Catch: Throwable -> L10
        ILogDepend.f384986a.d("PowerMonitor", "BatteryMonitor registerChargeCallback");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(g.a r100) {
        monitor-enter(this);
        if (r100 != null) goto L15;
    L13:
        monitor-exit(this);
        return;
    L15:
        List<a> r101 = f403800d;     // Catch: Throwable -> L10
        if (r101.contains(r100) == false) goto L13;
        r101.remove(r100);     // Catch: Throwable -> L10
        ILogDepend.f384986a.d("PowerMonitor", "BatteryMonitor unregisterChargeCallback");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Context r100, BatteryInfoReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L39;
        throw e;
    L39:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L35
        int r103 = r102.result;     // Catch: Exception -> L35
        if (r103 == 1) goto L22;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L18;
        return r100.registerReceiver(r101, r110);
    L18:
        return r102.intent;
    L20:
        return new Intent();
    L22:
        return r100.registerReceiver(r101, r110);
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L34;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L34:
        return r100.registerReceiver(r101, r110);
    }
}
