package com.larus.dora.impl.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes27.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f338130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f338131b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f338132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f338133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f338134c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f338135d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f338136e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f338132a == r101.f338132a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f338133b, r101.f338133b) == 0) goto L15;
            return false;
        L15:
            if (this.f338134c == r101.f338134c) goto L18;
            return false;
        L18:
            if (Float.compare(this.f338135d, r101.f338135d) == 0) goto L21;
            return false;
        L21:
            if (this.f338136e == r101.f338136e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f338132a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + Float.floatToIntBits(this.f338133b)) * 31;
            long r102 = this.f338134c;
            int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + Float.floatToIntBits(this.f338135d)) * 31;
            long r104 = this.f338136e;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        }

        public final String toString() {
            return "MemoryStats(appUsedMemory=" + this.f338132a + ", appMemoryRate=" + this.f338133b + ", systemUsedMemory=" + this.f338134c + ", systemMemoryRate=" + this.f338135d + ", totalSystemMemory=" + this.f338136e + ')';
        }

        public a(long r100, float r101, long r102, float r103, long r104) {
            this.f338132a = r100;
            this.f338133b = r101;
            this.f338134c = r102;
            this.f338135d = r103;
            this.f338136e = r104;
        }
    }

    static {
    }

    public static a b() {
        long r100 = SystemClock.elapsedRealtime();
        if (f338130a == null) goto L33;
        if ((r100 - f338131b) >= 60000) goto L33;
        g49.d.a("DoraSystemResourceUtils", "Returning cached memory stats");
        a r101 = f338130a;
        Intrinsics.checkNotNull(r101);
        return r101;
    L33:
        Debug.MemoryInfo r102 = new Debug.MemoryInfo();     // Catch: Exception -> L11
        Debug.getMemoryInfo(r102);     // Catch: Exception -> L11
        long r103 = ((long) r102.getTotalPss()) / 1024;     // Catch: Exception -> L11
    L35:
        Object r104 = AppHost.f326268a.getApplication().getSystemService("activity");     // Catch: Exception -> L22
        if ((r104 instanceof ActivityManager) == false) goto L16;
        ActivityManager r105 = (ActivityManager) r104;     // Catch: Exception -> L22
    L17:
        ActivityManager.MemoryInfo r106 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L22
        if (r105 == null) goto L20;
        r105.getMemoryInfo(r106);     // Catch: Exception -> L22
    L20:
        long r110 = r106.totalMem;     // Catch: Exception -> L22
        Pair r107 = new Pair(Long.valueOf(r110 / 1048576), Long.valueOf((r110 - r106.availMem) / 1048576));     // Catch: Exception -> L22
    L24:
        long r111 = ((Number) r107.getFirst()).longValue();
        long r112 = ((Number) r107.getSecond()).longValue();
        if (r111 <= 0) goto L27;
        float r113 = (r103 * 100.0f) / r111;
    L28:
        if (r111 <= 0) goto L30;
        float r114 = (r112 * 100.0f) / r111;
    L31:
        g49.d.a("DoraSystemResourceUtils", "Memory stats - App used: " + r103 + "MB, App rate: " + r113 + "%, System used: " + r112 + "MB, System rate: " + r114 + "%, Total system: " + r111 + "MB");
        a r108 = new a(r103, r113, r112, r114, r111);
        f338130a = r108;
        f338131b = r100;
        return r108;
    L30:
        r114 = 0.0f;
        goto L31
    L27:
        r113 = 0.0f;
        goto L28
    L16:
        r105 = null;
    L22:
        e = move-exception;
        g49.d.c("DoraSystemResourceUtils", "Failed to get system memory info", e);
        r107 = new Pair(0L, 0L);
    L11:
        e = move-exception;
        g49.d.c("DoraSystemResourceUtils", "Failed to get app used memory", e);
        r103 = 0;
        goto L35
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Application r100, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(null, r110);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(null, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r102 = r101.result;     // Catch: Exception -> L36
        if (r102 == 1) goto L23;
        if (r102 == 2) goto L21;
        if (r102 == 3) goto L19;
        return r100.registerReceiver(null, r110);
    L19:
        return r101.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(null, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(null, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, null, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(null, r110);
    }
}
