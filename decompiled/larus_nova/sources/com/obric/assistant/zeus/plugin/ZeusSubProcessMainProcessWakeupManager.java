package com.obric.assistant.zeus.plugin;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ZeusAutoFetchConfig;
import com.obric.assistant.t1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes.dex */
public final class ZeusSubProcessMainProcessWakeupManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ZeusSubProcessMainProcessWakeupManager f395021a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f395022b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f395023c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f395024d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Context f395025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f395026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t f395027g = null;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f395028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f395029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f395030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f395031d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f395028a == r101.f395028a) goto L12;
            return false;
        L12:
            if (this.f395029b == r101.f395029b) goto L15;
            return false;
        L15:
            if (this.f395030c == r101.f395030c) goto L18;
            return false;
        L18:
            if (this.f395031d == r101.f395031d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f395028a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f395029b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f395030c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f395031d;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        }

        public final String toString() {
            return "WakeupIntervals(mainSuccessRequestExpireIntervalMillis=" + this.f395028a + ", wakeMainIntervalMillis=" + this.f395029b + ", minCheckDelayMillis=" + this.f395030c + ", maxCheckDelayMillis=" + this.f395031d + ')';
        }

        public a(long r100, long r101, long r102, long r103) {
            this.f395028a = r100;
            this.f395029b = r101;
            this.f395030c = r102;
            this.f395031d = r103;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f395032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f395033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f395034c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f395032a == r101.f395032a) goto L12;
            return false;
        L12:
            if (this.f395033b == r101.f395033b) goto L15;
            return false;
        L15:
            if (this.f395034c == r101.f395034c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f395032a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f395033b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f395034c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        }

        public final String toString() {
            return "WakeupState(requestTimeMillis=" + this.f395032a + ", lastSuccessRequestTime=" + this.f395033b + ", lastWakeMainProcessTime=" + this.f395034c + ')';
        }

        public b(long r100, long r101, long r102) {
            this.f395032a = r100;
            this.f395033b = r101;
            this.f395034c = r102;
        }
    }

    public ZeusSubProcessMainProcessWakeupManager() {
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.zeus.plugin.t] */
    static {
        f395021a = new ZeusSubProcessMainProcessWakeupManager();
        f395022b = new Handler(Looper.getMainLooper());
        f395023c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f395024d = new AtomicBoolean(false);
        f395027g = new t();
    }

    public static ZeusAutoFetchConfig b() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(t1.f393353a.getObricZeusAutoFetchConfig());     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L11;
        FLogger.f375446a.e("ZeusSubProcessMainProcessWakeupManager", "get auto fetch config failed", r102);
        r101 = null;
    L11:
        return (ZeusAutoFetchConfig) r101;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static a d() {
        ZeusAutoFetchConfig r100 = b();
        boolean r101 = false;
        if (r100 == null) goto L13;
        Long r102 = Long.valueOf(r100.getSubProcessMainSuccessRequestExpireIntervalMillis());
        if (r102.longValue() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L13;
        long r104 = r102.longValue();
    L14:
        long r105 = r104;
        if (r100 == null) goto L25;
        Long r106 = Long.valueOf(r100.getSubProcessWakeMainIntervalMillis());
        if (r106.longValue() <= 0) goto L19;
        boolean r110 = true;
    L20:
        if (r110 == true) goto L23;
        r106 = null;
    L23:
        if (r106 == null) goto L25;
        long r111 = r106.longValue();
    L27:
        if (r100 == null) goto L37;
        Long r107 = Long.valueOf(r100.getSubProcessWakeMainMinCheckDelayMillis());
        if (r107.longValue() <= 0) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == true) goto L35;
        r107 = null;
    L35:
        if (r107 == null) goto L37;
        long r108 = r107.longValue();
    L38:
        if (r100 == null) goto L47;
        Long r109 = Long.valueOf(r100.getSubProcessWakeMainMaxCheckDelayMillis());
        if (r109.longValue() <= 0) goto L42;
        r101 = true;
    L42:
        if (r101 == true) goto L45;
        r109 = null;
    L45:
        if (r109 == null) goto L47;
        long r113 = r109.longValue();
    L49:
        if (r108 > r113) goto L51;
        Pair r114 = TuplesKt.to(Long.valueOf(r108), Long.valueOf(r113));
    L53:
        return new a(r105, r111, ((Number) r114.getFirst()).longValue(), ((Number) r114.getSecond()).longValue());
    L51:
        FLogger.f375446a.w("ZeusSubProcessMainProcessWakeupManager", "invalid check delay range, use default: minCheckDelayMillis=" + r108 + ", maxCheckDelayMillis=" + r113);
        r114 = TuplesKt.to(900000L, 3600000L);
    L47:
        r113 = 3600000;
        goto L49
    L31:
        r112 = false;
    L37:
        r108 = 900000;
        goto L38
    L19:
        r110 = false;
    L25:
        r111 = 3600000;
        goto L27
    L7:
        r103 = false;
    L13:
        r104 = 10800000;
        goto L14
    }

    public static final void a(ZeusSubProcessMainProcessWakeupManager r100) {
        r100.getClass();
        a r101 = d();
        b r102 = e(r101);
        if (r102 == null) goto L32;
        Bundle r103 = new Bundle();
        r103.putString("reason", "last_success=" + r102.f395033b + ",last_wake=" + r102.f395034c + ",success_expire_interval=" + r101.f395028a + ",wake_interval=" + r101.f395029b);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L23
        Context r105 = f395025e;     // Catch: Throwable -> L23
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");     // Catch: Throwable -> L23
        r105 = null;
    L10:
        ContentResolver r106 = r105.getContentResolver();     // Catch: Throwable -> L23
        int r107 = j.f395050a;     // Catch: Throwable -> L23
        Context r108 = f395025e;     // Catch: Throwable -> L23
        if (r108 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");     // Catch: Throwable -> L23
        r108 = null;
    L13:
        Intrinsics.checkNotNullParameter(r108, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L23
        Bundle r109 = r106.call(UriProtector.parse("content://" + r108.getPackageName() + ".obric.zeus.plugin.update"), "request_fetch_plugin", null, r103);     // Catch: Throwable -> L23
        boolean r110 = false;
        if (r109 != null) goto L16;
    L18:
        if (r110 == false) goto L20;
        Lazy r111 = e.f395044a;     // Catch: Throwable -> L23
        ((Keva) e.f395044a.getValue()).storeLong("last_wake_main_process_time_millis", r102.f395032a);     // Catch: Throwable -> L23
        FLogger.f375446a.i("ZeusSubProcessMainProcessWakeupManager", "request main process fetch success");     // Catch: Throwable -> L23
    L21:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L31;
        FLogger.f375446a.e("ZeusSubProcessMainProcessWakeupManager", "request main process fetch failed", r113);
        return;
    L31:
        return;
    L20:
        FLogger.f375446a.i("ZeusSubProcessMainProcessWakeupManager", "request main process fetch failed: provider result false");     // Catch: Throwable -> L23
        goto L21
    L16:
        if (r109.getBoolean("result", false) != true) goto L18;
        r110 = true;
    L23:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    public static b e(a r210) {
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r100 = ISecPrivacyService.a.a();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L12;
        FLogger.f375446a.i("ZeusSubProcessMainProcessWakeupManager", "skip wake main process: privacy not agreed");
        return null;
    L12:
        long r110 = System.currentTimeMillis();
        Lazy r103 = e.f395044a;
        long r111 = ((Keva) r103.getValue()).getLong("last_success_request_time_millis", 0);
        long r112 = ((Keva) r103.getValue()).getLong("last_wake_main_process_time_millis", 0);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L44
        Context r105 = f395025e;     // Catch: Throwable -> L44
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");     // Catch: Throwable -> L44
        r105 = null;
    L17:
        Object r106 = r105.getSystemService("activity");     // Catch: Throwable -> L44
        if ((r106 instanceof ActivityManager) == false) goto L20;
        ActivityManager r107 = (ActivityManager) r106;     // Catch: Throwable -> L44
    L21:
        if (r107 == null) goto L41;
        List<ActivityManager.RunningAppProcessInfo> r108 = r107.getRunningAppProcesses();     // Catch: Throwable -> L44
        if (r108 == null) goto L41;
        List<ActivityManager.RunningAppProcessInfo> r109 = r108;     // Catch: Throwable -> L44
        if ((r109 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r113 = r109.iterator();     // Catch: Throwable -> L44
    L31:
        if (r113.hasNext() == false) goto L38;
        String r114 = ((ActivityManager.RunningAppProcessInfo) r113.next()).processName;     // Catch: Throwable -> L44
        Context r115 = f395025e;     // Catch: Throwable -> L44
        if (r115 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");     // Catch: Throwable -> L44
        r115 = null;
    L36:
        if (Intrinsics.areEqual(r114, r115.getPackageName()) == false) goto L31;
        boolean r116 = true;
    L39:
        if (r116 != true) goto L41;
        boolean r117 = true;
    L42:
        Object r118 = Result.m9449constructorimpl(Boolean.valueOf(r117));     // Catch: Throwable -> L44
    L46:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L49;
        FLogger.f375446a.e("ZeusSubProcessMainProcessWakeupManager", "check main process alive failed", r119);
    L49:
        Boolean r120 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r118) == false) goto L52;
        r118 = r120;
    L52:
        boolean r121 = ((Boolean) r118).booleanValue();
        if (r121 == true) goto L59;
        long r122 = r112;
        if (f(r111, r110, r210.f395028a) == true) goto L57;
    L60:
        FLogger r123 = FLogger.f375446a;
        StringBuilder r124 = new StringBuilder("check wake main process: shouldWake=");
        r124.append(r101);
        r124.append(", mainProcessAlive=");
        r124.append(r121);
        r124.append(", lastSuccessRequestTime=");
        r124.append(r111);
        r124.append(", lastWakeMainProcessTime=");
        long r125 = r122;
        r124.append(r125);
        r124.append(", mainSuccessRequestExpireIntervalMillis=");
        r124.append(r210.f395028a);
        r124.append(", wakeMainIntervalMillis=");
        r124.append(r210.f395029b);
        r124.append(", minCheckDelayMillis=");
        r124.append(r210.f395030c);
        r124.append(", maxCheckDelayMillis=");
        r124.append(r210.f395031d);
        r123.i("ZeusSubProcessMainProcessWakeupManager", r124.toString());
        if (r101 == true) goto L64;
        return null;
    L64:
        return new b(r110, r111, r125);
    L57:
        if (f(r122, r110, r210.f395029b) == false) goto L60;
        r101 = true;
        goto L60
    L59:
        r122 = r112;
    L38:
        r116 = false;
        goto L39
    L27:
        if (r109.isEmpty() == false) goto L29;
    L41:
        r117 = false;
        goto L42
    L20:
        r107 = null;
    L44:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L5:
        if (r100.h() != true) goto L7;
        r102 = true;
        goto L9
    }

    public static boolean f(long r100, long r101, long r110) {
        if (r100 > 0) goto L5;
        return true;
    L5:
        long r102 = r101 - r100;
        if (r102 >= 0) goto L10;
        FLogger.f375446a.w("ZeusSubProcessMainProcessWakeupManager", "timestamp is later than current time, treat as expired: lastTimeMillis=" + r100 + ", now=" + r101);
        return true;
    L10:
        if (r102 >= r110) goto L14;
        return false;
    L14:
        return true;
    }

    public static long c(long r100, long r101, long r102, a r103) {
        if (r100 <= 0) goto L5;
        long r104 = r101 - r100;
        if (r104 >= 0) goto L11;
        return r103.f395030c;
    L11:
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r102 - r104, r103.f395030c), r103.f395031d);
    L5:
        return r103.f395030c;
    }
}
