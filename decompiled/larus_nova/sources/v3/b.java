package v3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.bridge.method.device.wifi.WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f552782a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f552783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1 f552784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f552785d;

    static {
        f552782a = new Object();
    }

    public static void g() {
        Object r100 = f552782a;
        monitor-enter(r100);
        WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1 r101 = f552784c;     // Catch: Throwable -> L19
        if (r101 != null) goto L24;
    L16:
        f552783b = null;     // Catch: Throwable -> L19
        f552784c = null;     // Catch: Throwable -> L19
        f552785d = null;     // Catch: Throwable -> L19
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r100);
        return;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Context r104 = f552783b;     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        c(r104, r101);     // Catch: Throwable -> L13
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
    L15:
        Result.m9448boximpl(r106);     // Catch: Throwable -> L19
        goto L16
    L10:
        r105 = null;
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L19
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = f552782a;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (f552784c != null) goto L8;
        monitor-exit(r101);
        return;
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r101);
        d r103 = d.f552786a;
        Context r104 = r100.getApplicationContext();
        if (r104 == null) goto L14;
        r100 = r104;
    L14:
        r103.getClass();
        e r105 = d.f(r100, false);
        if (r105 != null) goto L17;
        return;
    L17:
        e(r105);
    }

    public static void e(e r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.f552787a);
        r101.append('#');
        String r102 = r100.f552788b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.append(r102);
        String r103 = r101.toString();
        Object r104 = f552782a;
        monitor-enter(r104);
    L30:
        th = move-exception;
        throw th;
    L8:
        if (f552784c != null) goto L10;
    L28:
        monitor-exit(r104);
        return;
    L10:
        if (Intrinsics.areEqual(f552785d, r103) == true) goto L28;
        f552785d = r103;     // Catch: Throwable -> L30
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r104);
        JsonObject r106 = new JsonObject();
        JsonObject r107 = new JsonObject();
        r107.addProperty("ssid", r100.f552787a);
        String r108 = r100.f552788b;
        if (r108 == null) goto L17;
        r107.addProperty("bssid", r108);
    L17:
        Boolean r109 = r100.f552789c;
        if (r109 == null) goto L20;
        r107.addProperty("secure", Boolean.valueOf(r109.booleanValue()));
    L20:
        Double r110 = r100.f552790d;
        if (r110 == null) goto L23;
        r107.addProperty("signalStrength", Double.valueOf(r110.doubleValue()));
    L23:
        Integer r111 = r100.f552791e;
        if (r111 == null) goto L26;
        r107.addProperty("frequency", Integer.valueOf(r111.intValue()));
    L26:
        r106.add("wifi", r107);
        l3.d.c(new l3.a("doubao.onWifiConnected", r106, 4));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.BroadcastReceiver, com.bytedance.ai.bridge.method.device.wifi.WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1] */
    public static void f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r101 = r100.getApplicationContext();
        if (r101 == null) goto L6;
        r100 = r101;
    L6:
        Object r102 = f552782a;
        monitor-enter(r102);
    L27:
        th = move-exception;
        throw th;
    L9:
        if (f552784c == null) goto L12;
        monitor-exit(r102);
        return;
    L12:
        ?? r103 = new WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1();     // Catch: Throwable -> L27
        IntentFilter r104 = new IntentFilter("android.net.wifi.STATE_CHANGE");     // Catch: RuntimeException -> L19 Throwable -> L27
        if (Build.VERSION.SDK_INT < 33) goto L16;
        a(r100, r103, r104);     // Catch: RuntimeException -> L19 Throwable -> L27
    L17:
        f552783b = r100;     // Catch: RuntimeException -> L19 Throwable -> L27
        f552784c = r103;     // Catch: RuntimeException -> L19 Throwable -> L27
    L24:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r102);
        return;
    L16:
        b(r100, r103, r104);     // Catch: RuntimeException -> L19 Throwable -> L27
    L19:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L21
        c(r100, r103);     // Catch: Throwable -> L21
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        f552783b = null;     // Catch: Throwable -> L27
        f552784c = null;     // Catch: Throwable -> L27
        f552785d = null;     // Catch: Throwable -> L27
        goto L24
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L27
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
        goto L23
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void c(Context r100, BroadcastReceiver r101) {
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
    public static void a(Context r100, WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1 r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, 4);
        return;
    L39:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L23;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 4, null, null, 3, r100).result;     // Catch: Exception -> L34
        if (r101 != 1) goto L13;
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L13:
        if (r101 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r101 == 3) goto L41;
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r100.registerReceiver(r110, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r100, r110, r111, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L34
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r100, WifiConnectedEventPublisher$ensureMonitoring$1$changeReceiver$1 r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
