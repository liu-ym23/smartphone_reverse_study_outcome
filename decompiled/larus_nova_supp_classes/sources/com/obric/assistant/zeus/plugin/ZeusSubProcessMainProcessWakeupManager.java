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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ZeusSubProcessMainProcessWakeupManager {
    public static final ZeusSubProcessMainProcessWakeupManager a = null;
    public static final Handler b = null;
    public static final CoroutineScope c = null;
    public static final AtomicBoolean d = null;
    public static Context e;
    public static volatile boolean f;
    public static final t g = null;

    public ZeusSubProcessMainProcessWakeupManager() {
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.zeus.plugin.t] */
    static {
        a = new ZeusSubProcessMainProcessWakeupManager();
        b = new Handler(Looper.getMainLooper());
        c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        d = new AtomicBoolean(false);
        g = new t();
    }

    public static ZeusAutoFetchConfig b() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.m49constructorimpl(t1.a.getObricZeusAutoFetchConfig());     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.m52exceptionOrNullimpl(r1);
        if (r2 == null) goto L11;
        FLogger.a.e("ZeusSubProcessMainProcessWakeupManager", "get auto fetch config failed", r2);
        r1 = null;
    L11:
        return (ZeusAutoFetchConfig) r1;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static a d() {
        ZeusAutoFetchConfig r0 = b();
        boolean r3 = false;
        if (r0 == null) goto L13;
        Long r6 = Long.valueOf(r0.getSubProcessMainSuccessRequestExpireIntervalMillis());
        if (r6.longValue() <= 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L13;
        long r8 = r6.longValue();
    L14:
        long r9 = r8;
        if (r0 == null) goto L25;
        Long r10 = Long.valueOf(r0.getSubProcessWakeMainIntervalMillis());
        if (r10.longValue() <= 0) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == true) goto L23;
        r10 = null;
    L23:
        if (r10 == null) goto L25;
        long r12 = r10.longValue();
    L27:
        if (r0 == null) goto L37;
        Long r13 = Long.valueOf(r0.getSubProcessWakeMainMinCheckDelayMillis());
        if (r13.longValue() <= 0) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == true) goto L35;
        r13 = null;
    L35:
        if (r13 == null) goto L37;
        long r1 = r13.longValue();
    L38:
        if (r0 == null) goto L47;
        Long r2 = Long.valueOf(r0.getSubProcessWakeMainMaxCheckDelayMillis());
        if (r2.longValue() <= 0) goto L42;
        r3 = true;
    L42:
        if (r3 == true) goto L45;
        r2 = null;
    L45:
        if (r2 == null) goto L47;
        long r4 = r2.longValue();
    L49:
        if (r1 > r4) goto L51;
        Pair r5 = TuplesKt.to(Long.valueOf(r1), Long.valueOf(r4));
    L53:
        return new a(r9, r12, ((Number) r5.getFirst()).longValue(), ((Number) r5.getSecond()).longValue());
    L51:
        FLogger.a.w("ZeusSubProcessMainProcessWakeupManager", "invalid check delay range, use default: minCheckDelayMillis=" + r1 + ", maxCheckDelayMillis=" + r4);
        r5 = TuplesKt.to(900000L, 3600000L);
    L47:
        r4 = 3600000;
        goto L49
    L31:
        r15 = false;
    L37:
        r1 = 900000;
        goto L38
    L19:
        r11 = false;
    L25:
        r12 = 3600000;
        goto L27
    L7:
        r7 = false;
    L13:
        r8 = 10800000;
        goto L14
    }

    public static final void a(ZeusSubProcessMainProcessWakeupManager r7) {
        r7.getClass();
        a r8 = d();
        b r1 = e(r8);
        if (r1 == null) goto L32;
        Bundle r2 = new Bundle();
        r2.putString("reason", "last_success=" + r1.b + ",last_wake=" + r1.c + ",success_expire_interval=" + r8.a + ",wake_interval=" + r8.b);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        Context r10 = e;     // Catch: Throwable -> L23
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");     // Catch: Throwable -> L23
        r10 = null;
    L10:
        ContentResolver r11 = r10.getContentResolver();     // Catch: Throwable -> L23
        int r5 = j.a;     // Catch: Throwable -> L23
        Context r6 = e;     // Catch: Throwable -> L23
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");     // Catch: Throwable -> L23
        r6 = null;
    L13:
        Intrinsics.checkNotNullParameter(r6, "context");     // Catch: Throwable -> L23
        Bundle r12 = r11.call(UriProtector.parse("content://" + r6.getPackageName() + ".obric.zeus.plugin.update"), "request_fetch_plugin", null, r2);     // Catch: Throwable -> L23
        boolean r3 = false;
        if (r12 != null) goto L16;
    L18:
        if (r3 == false) goto L20;
        Lazy r13 = e.a;     // Catch: Throwable -> L23
        ((Keva) e.a.getValue()).storeLong("last_wake_main_process_time_millis", r1.a);     // Catch: Throwable -> L23
        FLogger.a.i("ZeusSubProcessMainProcessWakeupManager", "request main process fetch success");     // Catch: Throwable -> L23
    L21:
        Object r14 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Throwable r15 = Result.m52exceptionOrNullimpl(r14);
        if (r15 == null) goto L31;
        FLogger.a.e("ZeusSubProcessMainProcessWakeupManager", "request main process fetch failed", r15);
        return;
    L31:
        return;
    L20:
        FLogger.a.i("ZeusSubProcessMainProcessWakeupManager", "request main process fetch failed: provider result false");     // Catch: Throwable -> L23
        goto L21
    L16:
        if (r12.getBoolean("result", false) != true) goto L18;
        r3 = true;
    L23:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r14 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L25
    }

    public static b e(a r20) {
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L12;
        FLogger.a.i("ZeusSubProcessMainProcessWakeupManager", "skip wake main process: privacy not agreed");
        return null;
    L12:
        long r12 = System.currentTimeMillis();
        Lazy r3 = e.a;
        long r14 = ((Keva) r3.getValue()).getLong("last_success_request_time_millis", 0);
        long r10 = ((Keva) r3.getValue()).getLong("last_wake_main_process_time_millis", 0);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L44
        Context r5 = e;     // Catch: Throwable -> L44
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");     // Catch: Throwable -> L44
        r5 = null;
    L17:
        Object r6 = r5.getSystemService("activity");     // Catch: Throwable -> L44
        if ((r6 instanceof ActivityManager) == false) goto L20;
        ActivityManager r7 = (ActivityManager) r6;     // Catch: Throwable -> L44
    L21:
        if (r7 == null) goto L41;
        List<ActivityManager.RunningAppProcessInfo> r8 = r7.getRunningAppProcesses();     // Catch: Throwable -> L44
        if (r8 == null) goto L41;
        List<ActivityManager.RunningAppProcessInfo> r9 = r8;     // Catch: Throwable -> L44
        if ((r9 instanceof Collection) == true) goto L27;
    L29:
        Iterator<T> r11 = r9.iterator();     // Catch: Throwable -> L44
    L31:
        if (r11.hasNext() == false) goto L38;
        String r13 = ((ActivityManager.RunningAppProcessInfo) r11.next()).processName;     // Catch: Throwable -> L44
        Context r15 = e;     // Catch: Throwable -> L44
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");     // Catch: Throwable -> L44
        r15 = null;
    L36:
        if (Intrinsics.areEqual(r13, r15.getPackageName()) == false) goto L31;
        boolean r16 = true;
    L39:
        if (r16 != true) goto L41;
        boolean r17 = true;
    L42:
        Object r18 = Result.m49constructorimpl(Boolean.valueOf(r17));     // Catch: Throwable -> L44
    L46:
        Throwable r19 = Result.m52exceptionOrNullimpl(r18);
        if (r19 == null) goto L49;
        FLogger.a.e("ZeusSubProcessMainProcessWakeupManager", "check main process alive failed", r19);
    L49:
        Boolean r21 = Boolean.FALSE;
        if (Result.m55isFailureimpl(r18) == false) goto L52;
        r18 = r21;
    L52:
        boolean r22 = ((Boolean) r18).booleanValue();
        if (r22 == true) goto L59;
        long r110 = r10;
        if (f(r14, r12, r20.a) == true) goto L57;
    L60:
        FLogger r23 = FLogger.a;
        StringBuilder r24 = new StringBuilder("check wake main process: shouldWake=");
        r24.append(r2);
        r24.append(", mainProcessAlive=");
        r24.append(r22);
        r24.append(", lastSuccessRequestTime=");
        r24.append(r14);
        r24.append(", lastWakeMainProcessTime=");
        long r25 = r110;
        r24.append(r25);
        r24.append(", mainSuccessRequestExpireIntervalMillis=");
        r24.append(r20.a);
        r24.append(", wakeMainIntervalMillis=");
        r24.append(r20.b);
        r24.append(", minCheckDelayMillis=");
        r24.append(r20.c);
        r24.append(", maxCheckDelayMillis=");
        r24.append(r20.d);
        r23.i("ZeusSubProcessMainProcessWakeupManager", r24.toString());
        if (r2 == true) goto L64;
        return null;
    L64:
        return new b(r12, r14, r25);
    L57:
        if (f(r110, r12, r20.b) == false) goto L60;
        r2 = true;
        goto L60
    L59:
        r110 = r10;
    L38:
        r16 = false;
        goto L39
    L27:
        if (r9.isEmpty() == false) goto L29;
    L41:
        r17 = false;
        goto L42
    L20:
        r7 = null;
    L44:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r18 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L46
    L5:
        if (r0.h() != true) goto L7;
        r1 = true;
        goto L9
    }

    public static boolean f(long r6, long r8, long r10) {
        if (r6 > 0) goto L5;
        return true;
    L5:
        long r3 = r8 - r6;
        if (r3 >= 0) goto L10;
        FLogger.a.w("ZeusSubProcessMainProcessWakeupManager", "timestamp is later than current time, treat as expired: lastTimeMillis=" + r6 + ", now=" + r8);
        return true;
    L10:
        if (r3 >= r10) goto L14;
        return false;
    L14:
        return true;
    }

    public static long c(long r3, long r5, long r7, a r9) {
        if (r3 <= 0) goto L5;
        long r6 = r5 - r3;
        if (r6 >= 0) goto L11;
        return r9.c;
    L11:
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r7 - r6, r9.c), r9.d);
    L5:
        return r9.c;
    }
}
