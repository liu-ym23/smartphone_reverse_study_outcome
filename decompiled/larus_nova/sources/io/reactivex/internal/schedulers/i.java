package io.reactivex.internal.schedulers;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f494988a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f494989b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f494990c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<ScheduledThreadPoolExecutor, Object> f494991d = null;

    public static final class a implements Runnable {
        public a() {
        }

        public static void a() {
            Iterator r100 = new ArrayList(((ConcurrentHashMap) i.f494991d).keySet()).iterator();
        L4:
            if (r100.hasNext() == false) goto L9;
            ScheduledThreadPoolExecutor r101 = (ScheduledThreadPoolExecutor) r100.next();
            if (r101.isShutdown() == true) goto L7;
            r101.purge();
            goto L4
        L7:
            ((ConcurrentHashMap) i.f494991d).remove(r101);
            goto L4
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
        f494990c = new AtomicReference();
        f494991d = new ConcurrentHashMap();
        Properties r100 = System.getProperties();
        int r101 = 1;
        if (r100.containsKey("rx2.purge-enabled") == false) goto L5;
        boolean r102 = Boolean.parseBoolean(r100.getProperty("rx2.purge-enabled"));
    L6:
        if (r102 == true) goto L8;
    L10:
        f494988a = r102;
        f494989b = r101;
        b();
        return;
    L8:
        if (r100.containsKey("rx2.purge-period-seconds") == false) goto L10;
        r101 = CastIntegerProtector.parseInt(r100.getProperty("rx2.purge-period-seconds"));     // Catch: NumberFormatException -> L12
        goto L10
    L5:
        r102 = true;
        goto L6
    }

    public static void b() {
        if (f494988a == false) goto L17;
    L4:
        AtomicReference<ScheduledExecutorService> r100 = f494990c;
        ScheduledExecutorService r101 = r100.get();
        if (r101 != null) goto L24;
        boolean r102 = true;
        ScheduledExecutorService r103 = PThreadExecutorsUtils.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
    L9:
        if (r100.compareAndSet(r101, r103) == true) goto L14;
        if (r100.get() == r101) goto L9;
        r102 = false;
    L14:
        if (r102 == true) goto L15;
        r103.shutdownNow();
        goto L4
    L15:
        a r104 = new a();
        long r105 = f494989b;
        r103.scheduleAtFixedRate(r104, r105, r105, TimeUnit.SECONDS);
        return;
    L24:
        return;
    }

    public static ScheduledExecutorService a(ThreadFactory r100) {
        ScheduledExecutorService r101 = PThreadExecutorsUtils.newScheduledThreadPool(1, r100);
        if (f494988a == true) goto L5;
    L7:
        return r101;
    L5:
        if ((r101 instanceof ScheduledThreadPoolExecutor) == false) goto L7;
        ConcurrentHashMap r102 = (ConcurrentHashMap) f494991d;
        r102.put((ScheduledThreadPoolExecutor) r101, r101);
        goto L7
    }
}
