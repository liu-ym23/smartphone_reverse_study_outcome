package com.larksuite.framework.thread;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes24.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ScheduledExecutorService f285734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ScheduledFuture<?> f285735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ScheduledFuture<?> f285736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f285737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f285738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f285739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f285740g;

    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static class b implements Runnable {
        public b() {
        }

        public static void a() {
            long r100 = System.currentTimeMillis();
            if ((b0.f285738e % 2) != 0) goto L28;
            ScheduledFuture<?> r101 = b0.f285735b;
            if (r101 != null) goto L7;
        L20:
            b0.f285735b = CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new a(), 0, TimeUnit.SECONDS);
            com.larksuite.framework.thread.b r102 = (com.larksuite.framework.thread.b) CoreThreadPool.getDefault().getFixedThreadPool();
            int r103 = r102.getQueue().size();
            Log.i("TestThreadPoolDelay", "backUpTaskNum:" + r103);
            if (r103 >= 10) goto L25;
            int r104 = r102.getCorePoolSize();
            int r105 = com.larksuite.framework.thread.b.f285730j;
            if (r104 == r105) goto L28;
            r102.setCorePoolSize(r105);
            r102.setMaximumPoolSize(r105 + 3);
            goto L28
        L25:
            Log.e("TestThreadPoolDelay", "fixedThread Pool over backup task , num:" + r103);
            int r106 = com.larksuite.framework.thread.b.f285730j;
            int r107 = Math.min(r106 * 2, (int) (((double) r106) + Math.ceil((double) (((float) r103) / ((float) 10)))));
            Log.i("TestThreadPoolDelay", "need thread num:" + r107);
            if (r102.getCorePoolSize() == r107) goto L28;
            r102.setCorePoolSize(r107);
            r102.setMaximumPoolSize(r107 + 3);
            goto L28
        L7:
            if (r101.isDone() == true) goto L19;
            Log.e("TestThreadPoolDelay", "found ScheduleThreadPool schedule task delay over 10s, please check", new Throwable(), true);
            ScheduledExecutorService r108 = CoreThreadPool.getDefault().getScheduleThreadPool();
            if ((r108 instanceof g) == false) goto L13;
            ThreadFactory r109 = ((g) r108).getThreadFactory();
            if ((r109 instanceof n) == false) goto L13;
            ((n) r109).b();
        L13:
            int r110 = b0.f285737d + 1;
            b0.f285737d = r110;
            if (r110 < 2) goto L20;
            g r111 = (g) CoreThreadPool.getDefault().getScheduleThreadPool();
            int r112 = r111.getCorePoolSize();
            if (r112 >= 6) goto L20;
            r111.setCorePoolSize(6);
            Log.w("TestThreadPoolDelay", "org add schedule thread pool core size is: " + r112 + ", add to 6");
            goto L20
        L19:
            b0.f285737d = 0;
        L28:
            b0.f285738e++;
            t r113 = (t) CoreThreadPool.getDefault().getCachedThreadPool();
            b0.a(r113.a(), r113.d(), 10000);
            t r114 = (t) CoreThreadPool.getDefault().getFixedThreadPool();
            b0.a(r114.a(), r114.d(), 5000);
            t r115 = (t) CoreThreadPool.getDefault().getScheduleThreadPool();
            b0.a(r115.a(), r115.d(), 5000);
            w r116 = (w) CoreThreadPool.getNonblockingHandler();
            List<a0> r117 = r116.f285814f;
            monitor-enter(r117);
            LinkedList r118 = new LinkedList(r116.f285814f);     // Catch: Throwable -> L34
            monitor-exit(r117);     // Catch: Throwable -> L34
            b0.a(r118, r116.a(), 5000);
            w r119 = (w) CoreThreadPool.getBackgroundHandler();
            b0.a(r119.b(), r119.a(), 5000);
            w r120 = (w) CoreThreadPool.getSerialTaskHandler();
            b0.a(r120.b(), r120.a(), 5000);
            Log.d("TestThreadPoolDelay", "check public thread block cost time:" + (System.currentTimeMillis() - r100));
            return;
        L34:
            th = move-exception;
            throw th;
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

    public b0() {
    }

    public static void d() {
        f285737d = 0;
        b();
        monitor-enter(b0.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f285736c == null) goto L8;
        monitor-exit(b0.class);     // Catch: Throwable -> L11
        return;
    L8:
        Log.i("TestThreadPoolDelay", "startScheduleThreadPoolTest");     // Catch: Throwable -> L11
        f285736c = f285734a.scheduleWithFixedDelay(new b(), 10, 5, TimeUnit.SECONDS);     // Catch: Throwable -> L11
        monitor-exit(b0.class);     // Catch: Throwable -> L11
    }

    public static void b() {
        if (f285734a == null) goto L6;
        return;
    L6:
        monitor-enter(b0.class);
        f285734a = CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk_test");     // Catch: Throwable -> L10
        monitor-exit(b0.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static String c() {
        CoreThreadPool.a r100 = CoreThreadPool.mCoreThreadPoolDep;
        String r101 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        Context r102 = r100.getContext();
        if (r102 != null) goto L22;
        return "";
    L22:
    L18:
        e = e;
    L19:
        Log.w("TestThreadPoolDelay", "get version name exception", e);
        String r103 = r101;
    L21:
        return r103.toLowerCase();
    L9:
        if (TextUtils.isEmpty("8.2.0-alpha1") == false) goto L11;
        r103 = r102.getPackageManager().getPackageInfo(r102.getPackageName(), 128).versionName;     // Catch: Exception -> L18
        if (TextUtils.isEmpty(r103) == false) goto L21;
        return "";
    L16:
        e = move-exception;
        r101 = r103;
        e = e;
        goto L19
    L11:
        return "8.2.0-alpha1".toLowerCase();
    }

    public static void a(List r110, String r111, long r112) {
        Iterator r113 = r110.iterator();
    L4:
        if (r113.hasNext() == false) goto L45;
        a0 r100 = (a0) r113.next();
        if ((System.currentTimeMillis() - r100.f285728c) <= r112) goto L4;
        Thread r101 = r100.f285727b;
        boolean r102 = false;
        String r103 = r100.f285726a.split("#")[0];
        long r104 = System.currentTimeMillis() - r100.f285728c;
        monitor-enter(b0.class);
        if (f285739f == false) goto L15;
        r102 = f285740g;     // Catch: Throwable -> L42
        monitor-exit(b0.class);
    L35:
        if (r102 == false) goto L37;
        Log.e("TestThreadPoolDelay", "Hawei phone found block, threadPoolName:" + r111 + ",threadName: " + r101.getName() + ",has block, block time is(ms) " + r104 + ", taskName is: " + r103);
    L41:
        r100.f285729d++;
        goto L4
    L37:
        StackTraceElement[] r105 = r100.f285727b.getStackTrace();
        Throwable r106 = new Throwable();
        r106.setStackTrace(r105);
        Boolean r107 = Boolean.TRUE;
        if (r100.f285729d < 2) goto L40;
        r107 = Boolean.FALSE;
    L40:
        Log.e("TestThreadPoolDelay", "threadPoolName:" + r111 + ",threadName: " + r101.getName() + ",has block, block time is(ms) " + r104 + ", taskName is: " + r103 + ", stackTrace is：", r106, r107.booleanValue());
        goto L41
    L15:
        f285739f = true;     // Catch: Throwable -> L42
        String r108 = Build.BRAND;     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r108) == false) goto L20;
        f285740g = false;     // Catch: Throwable -> L42
        monitor-exit(b0.class);
        goto L35
    L20:
        Log.d("TestThreadPoolDelay", "brand:" + r108);     // Catch: Throwable -> L42
        boolean r109 = SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(r108);     // Catch: Throwable -> L42
        String r114 = c();     // Catch: Throwable -> L42
        if (r114.contains("alpha") == false) goto L23;
    L25:
        boolean r115 = false;
    L26:
        if (r109 == false) goto L29;
        if (r115 == false) goto L29;
        boolean r116 = true;
    L30:
        f285740g = r116;     // Catch: Throwable -> L42
        if (r109 == false) goto L34;
        if (r115 == false) goto L34;
        r102 = true;
    L34:
        monitor-exit(b0.class);
    L29:
        r116 = false;
        goto L30
    L23:
        if (r114.contains("beta") == true) goto L25;
        r115 = true;
    L42:
        th = move-exception;
        throw th;
    }
}
