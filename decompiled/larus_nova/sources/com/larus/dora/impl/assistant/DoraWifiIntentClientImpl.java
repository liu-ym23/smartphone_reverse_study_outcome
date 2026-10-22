package com.larus.dora.impl.assistant;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import gd9.i;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;
import vk4.h;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraWifiIntentClientImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraWifiIntentClientImpl f332025a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f332026b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f332027c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f332028d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f332029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f332030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f332031c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f332029a, r101.f332029a) == true) goto L12;
            return false;
        L12:
            if (this.f332030b == r101.f332030b) goto L15;
            return false;
        L15:
            if (this.f332031c == r101.f332031c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f332029a.hashCode() * 31;
            long r101 = this.f332030b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f332031c;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "WifiSwitchOperationResult(result=" + this.f332029a + ", latencyMs=" + this.f332030b + ", effectiveLatencyMs=" + this.f332031c + ')';
        }

        public a(e r100, long r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.f332029a = r100;
            this.f332030b = r101;
            this.f332031c = r102;
        }
    }

    public DoraWifiIntentClientImpl() {
    }

    static {
        f332025a = new DoraWifiIntentClientImpl();
        f332026b = new Object();
        f332027c = new LinkedHashSet();
        vk4.e r100 = vk4.e.d.f555490a;
        h r101 = new d();
        ((CopyOnWriteArraySet) r100.f555484c).add(r101);
    }

    public static e b() {
        Set<String> r100 = f332027c;
        if ((!r100.isEmpty()) == false) goto L7;
        FLogger.f375446a.i("DoraWifiIntentClient", "releaseWifi keep enabled, ownerCount=" + r100.size());
        return null;
    L7:
        if (f332028d == true) goto L11;
        FLogger.f375446a.i("DoraWifiIntentClient", "releaseWifi ignored, wifi was not opened by client");
        return null;
    L11:
        if (vk4.e.d.f555490a.f555486e == 0) goto L14;
        FLogger.f375446a.i("DoraWifiIntentClient", "releaseWifi pending: WiFi scenes still active");
        return null;
    L14:
        e r101 = d(false).f332029a;
        if (r101.f332044a == false) goto L17;
        f332028d = false;
        FLogger.f375446a.i("DoraWifiIntentClient", "releaseWifi success, closed by client");
    L18:
        return r101;
    L17:
        FLogger.f375446a.w("DoraWifiIntentClient", "releaseWifi close failed, errorCode=" + r101.f332045b);
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context, com.larus.nova.NovaApplication, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.content.BroadcastReceiver, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.dora.impl.assistant.DoraWifiIntentClientImpl$setWifiEnabledAndWaitEffective$receiver$1] */
    public static a d(final boolean r210) {
        i r100 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r100);
        ?? r101 = r100.getApplication();
        r101.getClass();
        final CountDownLatch r102 = new CountDownLatch(1);
        final AtomicLong r103 = new AtomicLong(-1);
        PthreadHandlerThreadV2 r104 = new PthreadHandlerThreadV2("DoraWifiIntentStateWatcher");
        ThreadMethodProxy.start(r104);
        ?? r105 = new DoraWifiIntentClientImpl$setWifiEnabledAndWaitEffective$receiver$1(r210, r103, r102);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L8
        a(r101, r105, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"), new Handler(r104.getLooper()));     // Catch: Throwable -> L8
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        boolean r110 = true;
    L11:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L14;
        FLogger.f375446a.w("DoraWifiIntentClient", "register wifi state receiver failed, enabled=" + r210, r108);
    L14:
        long r111 = SystemClock.elapsedRealtime();
        com.larus.dora.impl.assistant.a.f332035a.getClass();
        FLogger r112 = FLogger.f375446a;
        r112.i("AssistantIntentDispatcher", "setWifiEnabled start, enabled=" + r210);
        IAgentAppIntentIDL r109 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        WifiManager r113 = null;
        if (r109 != null) goto L96;
        r112.w("AssistantIntentDispatcher", "setWifiEnabled failed, ipc is null, enabled=" + r210);
        int r114 = e.f332043d;
        e r115 = e.a.a("ipc_null", "IAgentAppIntentIDL is null");
    L17:
        e r116 = r115;
        if (r210 == true) goto L33;
    L35:
        long r117 = SystemClock.elapsedRealtime() - r111;
        if (r116.f332044a == false) goto L68;
        Intrinsics.checkNotNull(r101);
        Object r118 = r101.getSystemService("wifi");
        if ((r118 instanceof WifiManager) == false) goto L40;
        r113 = (WifiManager) r118;
    L40:
        if (r113 == null) goto L42;
        int r119 = r113.getWifiState();
    L43:
        if (r210 == true) goto L45;
        boolean r120 = true;
        if (r119 == 1) goto L51;
    L50:
        r120 = false;
    L51:
        if (r120 == false) goto L53;
        e r121 = r116;
        PthreadHandlerThreadV2 r122 = r104;
        ?? r123 = r105;
        r103.compareAndSet(-1, SystemClock.elapsedRealtime());
    L63:
        long r124 = r117;
        ?? r125 = r123;
    L64:
        long r126 = r103.get();
        ?? r127 = r125;
        if (r126 == (-1)) goto L69;
        long r128 = r126 - r111;
        ?? r129 = r125;
    L70:
        if (r110 == false) goto L88;
        ?? r130 = r129;
        ReceiverRegisterLancet.loge(r130, false);     // Catch: Throwable -> L83
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L104;
        r101.unregisterReceiver(r130);     // Catch: Throwable -> L83
    L81:
        Object r131 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L83
    L85:
        Throwable r132 = Result.m9452exceptionOrNullimpl(r131);
        if (r132 == null) goto L88;
        FLogger.f375446a.w("DoraWifiIntentClient", "unregister wifi state receiver failed, enabled=" + r210, r132);
        goto L88
    L104:
    L78:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r130.toString());     // Catch: Throwable -> L83
        e.printStackTrace();     // Catch: Throwable -> L83
        goto L81
    L75:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r130, r101) == false) goto L81;
        r101.unregisterReceiver(r130);     // Catch: Exception -> L78 Throwable -> L83
    L83:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r131 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L88:
        r122.quitSafely();
        if (r121.f332044a == true) goto L91;
    L93:
        e r134 = r121;
    L94:
        FLogger.f375446a.i("DoraWifiIntentClient", "setWifiEnabled result, enabled=" + r210 + ", success=" + r134.f332044a + ", latencyMs=" + r124 + ", effectiveLatencyMs=" + r128 + ", errorCode=" + r134.f332045b);
        return new a(r134, r124, r128);
    L91:
        if (r128 != (-1)) goto L93;
        int r135 = e.f332043d;
        r134 = e.a.a("wifi_state_effective_timeout", "wifi state not changed to target enabled=" + r210);
    L69:
        r128 = -1;
        r129 = r127;
        goto L70
    L53:
        r121 = r116;
        r122 = r104;
        ?? r136 = r105;
        r123 = r136;
        if (r110 == false) goto L63;
        r124 = r117;
        Object r137 = Result.m9449constructorimpl(Boolean.valueOf(r102.await(RangesKt.coerceAtLeast(5000 - r117, 0), TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L58
    L60:
        Throwable r138 = Result.m9452exceptionOrNullimpl(r137);
        r125 = r136;
        if (r138 == null) goto L64;
        FLogger.f375446a.w("DoraWifiIntentClient", "wait wifi state effective failed, enabled=" + r210, r138);
        r125 = r136;
    L58:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L60
    L45:
        if (r119 != 3) goto L50;
        r120 = true;
        goto L51
    L42:
        r119 = 4;
        goto L43
    L68:
        r121 = r116;
        r124 = r117;
        r122 = r104;
        r127 = r105;
        goto L69
    L33:
        if (r116.f332044a == false) goto L35;
        f332028d = true;
        goto L35
    L96:
        boolean r140 = r109.setWifiEnabled(r210);     // Catch: Throwable -> L24
        r112.i("AssistantIntentDispatcher", "setWifiEnabled returns " + r140 + ", enabled=" + r210);     // Catch: Throwable -> L24
        if (r140 == false) goto L21;
        e r141 = new e(true, null, null);     // Catch: Throwable -> L24
    L22:
        Object r142 = Result.m9449constructorimpl(r141);     // Catch: Throwable -> L24
    L26:
        Throwable r143 = Result.m9452exceptionOrNullimpl(r142);
        if (r143 == null) goto L30;
        FLogger.f375446a.w("AssistantIntentDispatcher", "setWifiEnabled failed, enabled=" + r210, r143);
        int r144 = e.f332043d;
        r142 = e.a.a("ipc_exception", r143.getMessage());
    L30:
        r115 = (e) r142;
        goto L17
    L21:
        int r145 = e.f332043d;     // Catch: Throwable -> L24
        r141 = e.a.a("appintent_failed", "setWifiEnabled returns false");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r146 = Result.Companion;
        r142 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L6:
        th = th;
        r110 = true;
    L10:
        Result.Companion r147 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L8:
        th = th;
        r110 = false;
        goto L10
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r100, DoraWifiIntentClientImpl$setWifiEnabledAndWaitEffective$receiver$1 r110, IntentFilter r111, Handler r112) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L30;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L30:
    L24:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L29;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, null, r112);
        return;
    L29:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L9;
    L22:
        r100.registerReceiver(r110, r111, null, r112);     // Catch: Exception -> L24
        return;
    L9:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L22;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 0, null, r112, 4, r100).result;     // Catch: Exception -> L24
        if (r101 != 1) goto L13;
        r100.registerReceiver(r110, r111, null, r112);     // Catch: Exception -> L24
        return;
    L13:
        if (r101 != 2) goto L15;
        new Intent();     // Catch: Exception -> L24
        return;
    L15:
        if (r101 == 3) goto L31;
        r100.registerReceiver(r110, r111, null, r112);     // Catch: Exception -> L24
        return;
    }

    public static void c(String r100, e r101, long r102, long r110) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        DoraBuryPointManager r104 = DoraBuryPointManager.f331862a;     // Catch: Throwable -> L11
        Pair[] r105 = new Pair[5];     // Catch: Throwable -> L11
        r105[0] = TuplesKt.to("scene", r100);     // Catch: Throwable -> L11
        if (r101.f332044a == false) goto L5;
        int r106 = 1;
    L6:
        r105[1] = TuplesKt.to("result", Integer.valueOf(r106));     // Catch: Throwable -> L11
        String r107 = r101.f332045b;     // Catch: Throwable -> L11
        if (r107 != null) goto L9;
        r107 = "";
    L9:
        r105[2] = TuplesKt.to("error_code", r107);     // Catch: Throwable -> L11
        r105[3] = TuplesKt.to("intent_latency", Long.valueOf(r102));     // Catch: Throwable -> L11
        r105[4] = TuplesKt.to("effective_latency", Long.valueOf(r110));     // Catch: Throwable -> L11
        DoraBuryPointManager.J(r104, "d_wifi_intent_result", MapsKt.mapOf(r105), false, 12);     // Catch: Throwable -> L11
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L19;
        FLogger.f375446a.w("DoraWifiIntentClient", "reportWifiIntentResult failed", r109);
        return;
    L19:
        return;
    L5:
        r106 = 2;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
