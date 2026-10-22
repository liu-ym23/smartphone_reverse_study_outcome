package com.bytedance.badger.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.badger.Badger;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.e;
import com.bytedance.badger.j;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f199147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f199148b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f199149c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f199150d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f199151e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap f199152f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f199153g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u0 f199154h = null;

    static {
        f199147a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(u0.class), "scheduledExecutor", "getScheduledExecutor()Ljava/util/concurrent/ScheduledExecutorService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(u0.class), "networkObserver", "getNetworkObserver()Lcom/bytedance/badger/network/NetworkObserver;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(u0.class), "initialRetryIntervalMs", "getInitialRetryIntervalMs()J"))};
        f199154h = new u0();
        f199148b = LazyKt.lazy(C10461p.f199133a);
        f199149c = new ConcurrentHashMap();
        f199150d = new ConcurrentHashMap();
        f199151e = LazyKt.lazy(C10460m.f199120a);
        f199152f = new ConcurrentHashMap();
        f199153g = LazyKt.lazy(C10459l.f199119a);
    }

    public u0() {
    }

    public static b0 a(a0 r100) {
        BadgerCore.Companion.getClass();
        return j.a().getNetRequestInterface().b(r100);
    L5:
        th = move-exception;
        e.c("BadgerNetworkRetryHandler", "sendRequestSync failed", th);
        return new b0(false, -1, CollectionsKt.emptyList(), th.toString());
    }

    public static void c(String r100, long r101) {
        Lazy r102 = f199148b;     // Catch: RejectedExecutionException -> L6
        KProperty r103 = f199147a[0];     // Catch: RejectedExecutionException -> L6
        ScheduledFuture r104 = (ScheduledFuture) f199150d.put(r100, ((ScheduledExecutorService) r102.getValue()).schedule(new q0(r100), r101, TimeUnit.MILLISECONDS));     // Catch: RejectedExecutionException -> L6
        if (r104 == null) goto L11;
        r104.cancel(false);     // Catch: RejectedExecutionException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.c("BadgerNetworkRetryHandler", "Failed to schedule retry task: " + r100, e);
        f199149c.remove(r100);
    }

    public static void b(a0 r110, int r111, int r112, Function6 r113, com.bytedance.badger.C.a r210) {
        if (r111 < 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L71;
        if (r112 < 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L69;
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.j r102 = com.bytedance.badger.v.d.F;
        KProperty r103 = com.bytedance.badger.v.d.f199311a[32];
        boolean r104 = ((Collection) r102.a()).contains(Integer.valueOf(com.bytedance.badger.C.a.f199020d.a()));
        NetworkInfo r105 = ((ConnectivityManager) Badger.INSTANCE.getContext().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L73
        if (r105 == null) goto L17;
        if (r105.isConnected() == false) goto L17;
        boolean r106 = true;
    L18:
        boolean r107 = !r106;
        if (r104 == false) goto L21;
        e.g("BadgerNetworkRetryHandler", "onCompensate# forbid reigster network observer");
    L21:
        if (r107 == false) goto L24;
        if (r104 == true) goto L24;
        boolean r108 = true;
    L26:
        if (r108 == false) goto L35;
        String r109 = r110.f199070a + '_' + r110.hashCode();
        C10458k r114 = new C10458k(r110, r111, r112, r113);
        ConcurrentHashMap r115 = f199152f;
        if (r115.containsKey(r109) == true) goto L32;
        t0 r116 = new t0(r109, r114);
        r115.put(r109, r116);     // Catch: Exception -> L72
        Lazy r117 = f199151e;     // Catch: Exception -> L72
        KProperty r118 = f199147a[1];     // Catch: Exception -> L72
        ((j0) r117.getValue()).b(r116);     // Catch: Exception -> L72
        e.f("BadgerNetworkRetryHandler", "Waiting for network: " + r109);     // Catch: Exception -> L72
    L32:
        e.g("BadgerNetworkRetryHandler", "network is unavailable, register listener.");
        return;
    L35:
        if (r111 < 0) goto L59;
        int r119 = 0;
    L37:
        b0 r120 = a(r110);
        if (r119 == 0) goto L40;
        l0 r121 = new g0(r119, r111 - r119);
    L46:
        l0 r122 = r121;
        if (r120.f199082a == true) goto L49;
    L56:
        r113.invoke(Boolean.FALSE, "", r110, r120, r122, r210);
        if (r119 == r111) goto L59;
        r119 = r119 + 1;
        goto L37
    L49:
        if (r120.f199083b != 200) goto L56;
        String r123 = w.a(r120.f199084c, Constants.Keys.KEY_X_TT_LOGID, true);
        if (r123 != null) goto L54;
        r123 = "";
    L54:
        r113.invoke(Boolean.TRUE, r123, r110, r120, r122, r210);
        return;
    L40:
        if (r111 != 0) goto L43;
        if (r112 != 0) goto L43;
        boolean r124 = true;
    L44:
        r121 = new f0(r124);
    L43:
        r124 = false;
    L59:
        if (r112 > 0) goto L61;
        e.g("BadgerNetworkRetryHandler", "addDelayedRetryTask: delayedRetryCount must be > 0");
        return;
    L61:
        String r125 = r110.f199070a + '_' + r110.hashCode();
        ConcurrentHashMap r126 = f199149c;
        p0 r127 = (p0) r126.remove(r125);
        ScheduledFuture r128 = (ScheduledFuture) f199150d.remove(r125);
        if (r128 == null) goto L64;
        r128.cancel(false);
    L64:
        if (r127 == null) goto L66;
        e.b("BadgerNetworkRetryHandler", "Cancelled retry task: " + r125);
    L66:
        p0 r129 = new p0(r110, r111, r112, r113, System.currentTimeMillis());
        r126.put(r125, r129);
        e.b("BadgerNetworkRetryHandler", "Added retry task: " + r125 + ", retryCount: " + r112);
        r129.f199134a.decrementAndGet();
        long r130 = (long) Math.max(1, 1);
        Lazy r131 = f199153g;
        KProperty r132 = f199147a[2];
        c(r125, r130 * ((Number) r131.getValue()).longValue());
        return;
    L24:
        r108 = false;
    L17:
        r106 = false;
        goto L18
    L69:
        throw new IllegalArgumentException("delayedRetryCount must be >= 0".toString());
    L9:
        r101 = false;
        goto L10
    L71:
        throw new IllegalArgumentException("immediateRetryCount must be >= 0".toString());
    L5:
        r100 = false;
        goto L6
    }
}
