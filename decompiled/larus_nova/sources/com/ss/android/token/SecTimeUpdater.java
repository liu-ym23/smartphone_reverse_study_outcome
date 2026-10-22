package com.ss.android.token;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.android.sdk.bdticketguard.init.TicketGuardBootFinishManager;
import com.bytedance.pia.core.metrics.ErrorType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class SecTimeUpdater implements ta7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f449632a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f449633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f449634c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference<UpdateState> f449635d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLong f449636e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReference<ScheduledFuture<?>> f449637f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f449638g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f449639h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final PThreadPoolExecutor f449640i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f449641j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final SecTimeUpdater f449642k = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/token/SecTimeUpdater$UpdateState;", "", "STOPPED", "STARTING", "RUNNING", "STOPPING", "account-sdk-core_release"}, k = 1, mv = {1, 4, 0})
    public static final enum UpdateState extends Enum<UpdateState> {
        public static final UpdateState RUNNING = null;
        public static final UpdateState STARTING = null;
        public static final UpdateState STOPPED = null;
        public static final UpdateState STOPPING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UpdateState[] f449643a = null;

        static {
            UpdateState r100 = new UpdateState("STOPPED", 0);
            STOPPED = r100;
            UpdateState r101 = new UpdateState("STARTING", 1);
            STARTING = r101;
            UpdateState r102 = new UpdateState("RUNNING", 2);
            RUNNING = r102;
            UpdateState r103 = new UpdateState("STOPPING", 3);
            STOPPING = r103;
            f449643a = new UpdateState[]{r100, r101, r102, r103};
        }

        public static UpdateState valueOf(String r100) {
            return (UpdateState) r27.a.a(UpdateState.class, r100);
        }

        public static UpdateState[] values() {
            return (UpdateState[]) f449643a.clone();
        }

        public UpdateState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements RejectedExecutionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f449644a = null;

        static {
            f449644a = new a();
        }

        public a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable r100, ThreadPoolExecutor r101) {
            tb7.a.e("SecTimeUpdater", "Task rejected: executor is busy");
        }
    }

    /* JADX INFO: loaded from: classes38.dex */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f449645a = null;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f449646a = null;

            static {
                f449646a = new a();
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                SecTimeUpdater r100 = SecTimeUpdater.f449642k;     // Catch: Throwable -> L8
                if (SecTimeUpdater.f449638g.compareAndSet(true, false) == false) goto L5;
                String r101 = ErrorType.BOOT;
            L6:
                SecTimeUpdater.a(r100, r101);     // Catch: Throwable -> L8
                return;
            L5:
                r101 = "periodic";
            L8:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L12;
                return;
            L12:
                throw th;
            }
        }

        static {
            f449645a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            SecTimeUpdater.f449640i.submit(a.f449646a);     // Catch: Throwable -> L4 RejectedExecutionException -> L6
        L16:
            return;
        L6:
            e = move-exception;
            tb7.a.f("SecTimeUpdater", "Task submission rejected", e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    static {
        f449632a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SecTimeUpdater.class), "degradeRequestCooldownMs", "getDegradeRequestCooldownMs()J")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SecTimeUpdater.class), "updateSecTimeExecutor", "getUpdateSecTimeExecutor()Ljava/util/concurrent/ScheduledExecutorService;"))};
        f449642k = new SecTimeUpdater();
        f449634c = LazyKt.lazy(SecTimeUpdater$degradeRequestCooldownMs$2.INSTANCE);
        f449635d = new AtomicReference(UpdateState.STOPPED);
        f449636e = new AtomicLong(0);
        f449637f = new AtomicReference(null);
        f449638g = new AtomicBoolean(true);
        f449639h = LazyKt.lazy(SecTimeUpdater$updateSecTimeExecutor$2.INSTANCE);
        f449640i = new PThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("ecTimeUpdater"), a.f449644a);
        f449641j = new AtomicBoolean(false);
    }

    public SecTimeUpdater() {
    }

    public static void d() {
        tb7.a.d("SecTimeUpdater", "stopUpdateSecTime");
        AtomicReference<UpdateState> r100 = f449635d;
        UpdateState r101 = r100.get();
        if (r101 == UpdateState.STOPPED) goto L27;
        UpdateState r102 = UpdateState.STOPPING;
        if (r101 != r102) goto L8;
        return;
    L8:
        if (r100.compareAndSet(r101, r102) == true) goto L9;
        if (r100.get() == r101) goto L8;
        boolean r103 = false;
    L13:
        if (r103 == true) goto L28;
        return;
    L28:
        ScheduledFuture<?> r104 = f449637f.getAndSet(null);     // Catch: Throwable -> L19 Exception -> L21
        if (r104 == null) goto L23;
        r104.cancel(false);     // Catch: Throwable -> L19 Exception -> L21
    L23:
        f449635d.set(UpdateState.STOPPED);
        tb7.a.d("SecTimeUpdater", "stopUpdateSecTime: stopped successfully");
        return;
    L21:
        e = move-exception;
        tb7.a.c("SecTimeUpdater", "Error cancelling scheduled task", e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        f449635d.set(UpdateState.STOPPED);
        tb7.a.d("SecTimeUpdater", "stopUpdateSecTime: stopped successfully");
        throw th;
    L9:
        r103 = true;
        goto L13
    }

    public static void c(boolean r100) {
        tb7.a.d("SecTimeUpdater", "startUpdateSecTime");
        com.bytedance.sdk.account.ticketguard.f.a();
        long r101 = com.bytedance.sdk.account.ticketguard.f.f269473s;
        if (r101 > 0) goto L8;
        tb7.a.e("SecTimeUpdater", "startUpdateSecTime: interval <= 0");
        Context r102 = com.ss.android.account.k.c();
        if (r102 == null) goto L32;
        f449642k.getClass();
        b(r102, "boot_check", r100);
        return;
    L32:
        return;
    L8:
        AtomicReference<UpdateState> r103 = f449635d;
        UpdateState r104 = UpdateState.STOPPED;
        UpdateState r105 = UpdateState.STARTING;
    L10:
        if (r103.compareAndSet(r104, r105) == true) goto L11;
        if (r103.get() == r104) goto L10;
        boolean r106 = false;
    L15:
        if (r106 == true) goto L18;
        tb7.a.e("SecTimeUpdater", "startUpdateSecTime: already starting or running");
        return;
    L18:
        Lazy r107 = f449639h;
        KProperty[] r108 = f449632a;
        KProperty r109 = r108[1];
        if (((ScheduledExecutorService) r107.getValue()).isShutdown() == false) goto L27;
        f449635d.set(UpdateState.STOPPED);
        return;
    L27:
        KProperty r110 = r108[1];     // Catch: Exception -> L24
        ScheduledFuture<?> r111 = ((ScheduledExecutorService) r107.getValue()).scheduleWithFixedDelay(b.f449645a, 0, r101, TimeUnit.SECONDS);     // Catch: Exception -> L24
        f449637f.set(r111);     // Catch: Exception -> L24
        f449635d.set(UpdateState.RUNNING);     // Catch: Exception -> L24
        tb7.a.d("SecTimeUpdater", "startUpdateSecTime: started successfully");     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        tb7.a.c("SecTimeUpdater", "startUpdateSecTime error", e);
        f449635d.set(UpdateState.STOPPED);
        f449637f.set(null);
        return;
    L11:
        r106 = true;
        goto L15
    }

    @Override // ta7.c
    public final void M(ta7.b r100) {
        boolean r101 = true;
        if (r100.f545195a != 1) goto L15;
        wqa.f r102 = com.ss.android.account.k.f406318b;
        if (r102 == null) goto L11;
        Context r103 = r102.getApplicationContext();
        if (r103 == null) goto L11;
        if (h0.d(r103) != true) goto L11;
    L12:
        if (r101 == false) goto L16;
        tb7.a.d("SecTimeUpdater", "Logout, restart update sec time");
        c(false);
        return;
    L16:
        return;
    L11:
        r101 = false;
        goto L12
    }

    public static final void a(SecTimeUpdater r100, String r110) {
        r100.getClass();
        tb7.a.d("SecTimeUpdater", "tryUpdateSecTime, scene: " + r110);
        if (f449633b <= 0) goto L7;
        long r101 = SystemClock.elapsedRealtime() - f449633b;
        Lazy r102 = f449634c;
        KProperty[] r103 = f449632a;
        KProperty r104 = r103[0];
        if (r101 >= ((Number) r102.getValue()).longValue()) goto L7;
        StringBuilder r105 = new StringBuilder("updateSecTs network degrade in cooldown, lastDegradeElapsedTimeMs=");
        r105.append(f449633b);
        r105.append(", scene=");
        r105.append(r110);
        r105.append(", AVAILABLE IN: ");
        long r106 = f449633b;
        KProperty r111 = r103[0];
        r105.append(((r106 + ((Number) r102.getValue()).longValue()) - SystemClock.elapsedRealtime()) / ((long) 1000));
        r105.append(" s");
        tb7.a.e("SecTimeUpdater", r105.toString());
        return;
    L7:
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.f269464j0 == false) goto L33;
        TicketGuardBootFinishManager.f163756e.getClass();
        if (TicketGuardBootFinishManager.c() == true) goto L33;
        if (f449641j.compareAndSet(false, true) == true) goto L14;
        tb7.a.d("SecTimeUpdater", "tryUpdateSecTime,scene: " + r110 + ", not boot finish, have delay, skip");
        return;
    L14:
        tb7.a.d("SecTimeUpdater", "tryUpdateSecTime,scene: " + r110 + ", not boot finish, delay");
        TicketGuardBootFinishManager.a(new k(r110));
        return;
    L33:
        ArrayList r107 = new ArrayList();     // Catch: Exception -> L30
        wqa.c r108 = com.ss.android.account.k.f406320d;     // Catch: Exception -> L30
        if (r108 == null) goto L20;
        wqa.i r109 = r108.getRequestTagHeader(true);     // Catch: Exception -> L30
        if (r109 == null) goto L20;
        r107.add(r109);     // Catch: Exception -> L30
    L20:
        ta7.j r112 = com.bytedance.sdk.account.impl.d0.c();     // Catch: Exception -> L30
        StringBuilder r113 = new StringBuilder("https://");     // Catch: Exception -> L30
        wqa.f r114 = com.ss.android.account.k.f406318b;     // Catch: Exception -> L30
        if (r114 == null) goto L23;
        String r115 = r114.S();     // Catch: Exception -> L30
    L24:
        r113.append(r115);     // Catch: Exception -> L30
        r113.append("/passport/user_info/get_sec_ts/?update_scene=");     // Catch: Exception -> L30
        r113.append(r110);     // Catch: Exception -> L30
        String r116 = r113.toString();     // Catch: Exception -> L30
        LinkedHashMap r117 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r107, 10)), 16));     // Catch: Exception -> L30
        Iterator r118 = r107.iterator();     // Catch: Exception -> L30
    L26:
        if (r118.hasNext() == false) goto L28;
        wqa.i r119 = (wqa.i) r118.next();     // Catch: Exception -> L30
        Pair r120 = TuplesKt.to(r119.f560775a, r119.f560776b);     // Catch: Exception -> L30
        r117.put(r120.getFirst(), r120.getSecond());     // Catch: Exception -> L30
        goto L26
    L28:
        HashMap r121 = new HashMap();     // Catch: Exception -> L30
        new rb7.c(((com.bytedance.sdk.account.impl.d0) r112).f268981a, rb7.c.p(r116, r117, r121, false), new l(r110, r107)).m();     // Catch: Exception -> L30
        return;
    L23:
        r115 = null;
    L30:
        e = move-exception;
        tb7.a.c("SecTimeUpdater", "tryUpdateSecTime error", e);
    }

    public static void b(Context r110, String r111, boolean r112) {
        long r100 = System.currentTimeMillis();
        AtomicLong r101 = f449636e;
        long r102 = r101.get();
        com.bytedance.sdk.account.ticketguard.f.a();
        long r103 = com.bytedance.sdk.account.ticketguard.f.f269474t * 1000;
        if ((r100 - r102) >= r103) goto L5;
        return;
    L5:
        if (r103 >= 0) goto L8;
        return;
    L8:
        if (r101.compareAndSet(r102, r100) == true) goto L10;
        return;
    L10:
        if (r112 == true) goto L37;
        j r113 = i.b(r110);
        com.bytedance.sdk.account.ticketguard.f.a();
        long r104 = com.bytedance.sdk.account.ticketguard.f.f269477w;
        boolean r105 = false;
        if (r104 >= 0) goto L15;
    L36:
        if (r105 == true) goto L37;
        return;
    L15:
        if (r113 == null) goto L31;
        long r106 = r104 * 1000;
        long r107 = SystemClock.elapsedRealtime();
        long r108 = System.currentTimeMillis();
        if (r113.f449759e != com.bytedance.sdk.account.time.e.a(r110)) goto L23;
        long r114 = r113.f449758d;
        if (r107 <= r114) goto L23;
        if ((r107 - r114) > r106) goto L29;
    L28:
        boolean r115 = false;
    L30:
        Boolean r116 = Boolean.valueOf(r115);
    L33:
        if (Intrinsics.areEqual(r116, Boolean.TRUE) == true) goto L35;
        if (r113 != null) goto L36;
    L35:
        r105 = true;
    L29:
        r115 = true;
    L23:
        long r109 = r108 - r113.f449757c;
        if (r109 > r106) goto L29;
        if (r109 >= 0) goto L28;
    L31:
        r116 = null;
    L37:
        tb7.a.d("SecTimeUpdater", "start update timestamp");
        f449640i.submit(new m(r111));     // Catch: RejectedExecutionException -> L40
        return;
    L40:
        e = move-exception;
        tb7.a.f("SecTimeUpdater", "updateOnce: task rejected", e);
    }
}
