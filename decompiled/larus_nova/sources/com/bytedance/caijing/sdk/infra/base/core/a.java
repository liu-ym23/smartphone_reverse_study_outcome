package com.bytedance.caijing.sdk.infra.base.core;

import android.os.SystemClock;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CJContext f202280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CJContext> f202281b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CJContext> f202282c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f202283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f202284e = null;

    /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.core.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes15.dex */
    public static final class RunnableC2921a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJContext f202285a;

        public RunnableC2921a(CJContext r100) {
            this.f202285a = r100;
        }

        public final void a() {
            CJLogger.d("CJContextManager", "onContextDestroyed: terminate " + this.f202285a);
            CJContext r100 = this.f202285a;
            r100.getClass();
            CJLogger.d("CJContext", "terminateBySystem : " + r100 + " paymentStatus: " + r100.f202263i);
            CJContext.PaymentStatus r101 = r100.f202263i;
            if (r101 != CJContext.PaymentStatus.COMPLETED) goto L5;
            return;
        L5:
            if (r100.f202264j == CJContext.PageStatus.DESTROYED) goto L18;
            CJReporter r102 = CJReporter.f202294a;
            CJReporter.k(r100, "CJContextTerminateBySystem", 1, r101.toString());
            Iterator<T> r103 = r100.f202270p.iterator();
        L8:
            if (r103.hasNext() == false) goto L19;
            CJContext.b r104 = (CJContext.b) r103.next();
            if (r100.f202270p.remove(r104) == false) goto L8;
            CJLogger.d("CJContext", "terminateBySystem : " + r100 + " item: " + r104);
            r104.onTerminateBySystem();
            goto L8
        L19:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f202281b = new ConcurrentHashMap();
        f202282c = new ConcurrentHashMap();
        f202284e = new Object();
    }

    public static CJContext a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "contextId");
        return f202281b.get(r100);
    }

    public static void b(CJContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CJLogger.d("CJContextManager", "onContextDestroyed: " + r100 + " ， activePayContext=" + f202280a);
        Object r101 = f202284e;
        monitor-enter(r101);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(f202280a, r100) == false) goto L7;
        f202280a = null;     // Catch: Throwable -> L27
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r101);
        Iterator r103 = new ArrayList(f202282c.values()).iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        CJContext r104 = (CJContext) r103.next();
        com.bytedance.caijing.sdk.infra.base.task.b.a(new RunnableC2921a(r104), 300);
        f202282c.remove(r104.f202255a);
        goto L11
    L13:
        Iterator r105 = new ArrayList(f202281b.values()).iterator();
    L15:
        if (r105.hasNext() == false) goto L25;
        CJContext r106 = (CJContext) r105.next();
        if (r106.f202265k == CJContext.ContextType.PAY) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L23;
        r106 = null;
    L23:
        if (r106 == null) goto L15;
        CJContext r108 = f202281b.remove(r106.f202255a);
        goto L15
    L19:
        r107 = false;
        goto L20
    L25:
        f202281b.remove(r100.f202255a);
    }

    public static void c(CJContext r100) {
        CJLogger.d("CJContextManager", "terminateActiveContext: " + r100 + " ， activePayContext=" + f202280a);
        f202280a = null;
        f202281b.remove(r100.f202255a);     // Catch: Exception -> L5
        r100.k();     // Catch: Exception -> L5
        f202282c.put(r100.f202255a, r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CJLogger.c("CJContextManager", "terminateActiveContext", e);
    }

    public static boolean d(CJContext r110) {
        boolean r100 = false;
        CJContext.ContextType r101 = null;
        if (r110 == null) goto L13;
        HashMap r102 = new HashMap();
        StringBuilder r103 = new StringBuilder();
        r103.append(r110.f202255a);
        r103.append('|');
        CJContext r104 = f202280a;
        if (r104 == null) goto L7;
        String r105 = r104.f202255a;
    L8:
        r103.append(r105);
        r102.put("contextStatus", r103.toString());
        if (f202280a != null) goto L11;
        int r106 = 0;
    L12:
        r102.put("isMulti", Integer.valueOf(r106));
        CJReporter r107 = CJReporter.f202294a;
        CJReporter.g(r110, "wallet_rd_biz_entrance_multi_cashier", r102, null, -1, true);
        goto L13
    L11:
        r106 = 1;
        goto L12
    L7:
        r105 = null;
    L13:
        Object r108 = f202284e;
        monitor-enter(r108);
        long r109 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L43
        StringBuilder r111 = new StringBuilder("tryStartNewContext: newContext=");     // Catch: Throwable -> L43
        r111.append(r110);     // Catch: Throwable -> L43
        r111.append(", type=");     // Catch: Throwable -> L43
        if (r110 == null) goto L18;
        r101 = r110.f202265k;     // Catch: Throwable -> L43
    L18:
        r111.append(r101);     // Catch: Throwable -> L43
        r111.append(", activePayContext=");     // Catch: Throwable -> L43
        r111.append(f202280a);     // Catch: Throwable -> L43
        r111.append(" , now=");     // Catch: Throwable -> L43
        r111.append(r109);     // Catch: Throwable -> L43
        r111.append(", lastBlockTime=");     // Catch: Throwable -> L43
        r111.append(f202283d);     // Catch: Throwable -> L43
        CJLogger.d("CJContextManager", r111.toString());     // Catch: Throwable -> L43
        if (r110 != null) goto L23;
        monitor-exit(r108);
        return true;
    L23:
        if (Intrinsics.areEqual(r110, f202280a) == false) goto L27;
        monitor-exit(r108);
        return true;
    L27:
        if (r110.f202265k != CJContext.ContextType.PAY) goto L40;
        CJContext r112 = f202280a;     // Catch: Throwable -> L43
        if (r112 != null) goto L31;
        CJLogger.d("CJContextManager", "tryStartNewContext: set");     // Catch: Throwable -> L43
        f202280a = r110;     // Catch: Throwable -> L43
        CJContext.PaymentStatus r113 = CJContext.PaymentStatus.ACTIVE;     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r113, "<set-?>");     // Catch: Throwable -> L43
        r110.f202263i = r113;     // Catch: Throwable -> L43
        f202281b.put(r110.f202255a, r110);     // Catch: Throwable -> L43
        monitor-exit(r108);
        return true;
    L31:
        if ((r109 - f202283d) > 3000) goto L33;
        CJLogger.d("CJContextManager", "tryStartNewContext: false");     // Catch: Throwable -> L43
    L35:
        monitor-exit(r108);
        return r100;
    L33:
        f202283d = r109;     // Catch: Throwable -> L43
        c(r112);     // Catch: Throwable -> L43
        f202280a = r110;     // Catch: Throwable -> L43
        CJContext.PaymentStatus r114 = CJContext.PaymentStatus.ACTIVE;     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r114, "<set-?>");     // Catch: Throwable -> L43
        r110.f202263i = r114;     // Catch: Throwable -> L43
        f202281b.put(r110.f202255a, r110);     // Catch: Throwable -> L43
        CJLogger.d("CJContextManager", "tryStartNewContext: true");     // Catch: Throwable -> L43
        r100 = true;
        goto L35
    L40:
        CJLogger.d("CJContextManager", "tryStartNewContext: default");     // Catch: Throwable -> L43
        monitor-exit(r108);
        return true;
    L43:
        th = move-exception;
        throw th;
    }
}
