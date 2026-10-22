package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ad f463104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SharedPreferences f206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, ScheduledFuture> f208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ScheduledThreadPoolExecutor f209a;

    public static abstract class a implements Runnable {
        public a() {
        }

        /* JADX INFO: renamed from: a */
        public abstract String mo8851a();
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f463107a;

        public void a() {
        }

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com_xiaomi_push_ad$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_xiaomi_push_ad$b__run$___twin___() {
            a();
            this.f463107a.run();
            b();
        }

        public b(a r100) {
            this.f463107a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_xiaomi_push_ad$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_xiaomi_push_ad$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private ad(Context r100) {
        this.f209a = new PThreadScheduledThreadPoolExecutor(1, new DefaultThreadFactory("iaomi/push/ad"));
        this.f208a = new HashMap();
        this.f207a = new Object();
        this.f206a = r100.getSharedPreferences("mipush_extra", 0);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8799a(String r100) {
        Object r101 = this.f207a;
        monitor-enter(r101);
        ScheduledFuture r102 = this.f208a.get(r100);     // Catch: Throwable -> L12
        if (r102 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L12
        return false;
    L8:
        this.f208a.remove(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102.cancel(false);
    L12:
        th = move-exception;
        throw th;
    }

    public static ad a(Context r100) {
        if (f463104a != null) goto L15;
        monitor-enter(ad.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f463104a != null) goto L9;
        f463104a = new ad(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ad.class);     // Catch: Throwable -> L11
    L15:
        return f463104a;
    }

    private ScheduledFuture a(a r100) {
        Object r101 = this.f207a;
        monitor-enter(r101);
        ScheduledFuture r102 = this.f208a.get(r100.mo8851a());     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    private static String a(String r100) {
        return "last_job_time" + r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m8798a(a r100) {
        return b(r100, 0);
    }

    public void a(Runnable r100) {
        a(r100, 0);
    }

    public static /* synthetic */ SharedPreferences a(ad r100) {
        return r100.f206a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ Object m8796a(ad r100) {
        return r100.f207a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ Map m8797a(ad r100) {
        return r100.f208a;
    }

    public void a(Runnable r100, int r101) {
        this.f209a.schedule(r100, r101, TimeUnit.SECONDS);
    }

    public boolean b(final a r100, int r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (a(r100) != null) goto L19;
        ScheduledFuture<?> r102 = this.f209a.schedule(new AnonymousClass2(this, r100), r101, TimeUnit.SECONDS);
        Object r103 = this.f207a;
        monitor-enter(r103);
        this.f208a.put(r100.mo8851a(), r102);     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    L19:
        return false;
    }

    public boolean a(a r100, int r101) {
        return a(r100, r101, 0);
    }

    public boolean a(a r100, int r101, int r102) {
        return a(r100, r101, r102, false);
    }

    public boolean a(final a r100, int r110, int r111, final boolean r112) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (a(r100) != null) goto L30;
        final String r101 = a(r100.mo8851a());
        b r102 = new AnonymousClass1(this, r100, r112, r101);
        if (r112 == true) goto L27;
        long r103 = Math.abs(System.currentTimeMillis() - this.f206a.getLong(r101, 0)) / 1000;
        if (r103 >= (r110 - r111)) goto L27;
        r111 = (int) (((long) r110) - r103);
    L27:
        ScheduledFuture<?> r113 = this.f209a.scheduleAtFixedRate(r102, r111, r110, TimeUnit.SECONDS);     // Catch: Exception -> L19
        Object r114 = this.f207a;     // Catch: Exception -> L19
        monitor-enter(r114);     // Catch: Exception -> L19
        this.f208a.put(r100.mo8851a(), r113);     // Catch: Throwable -> L16
        monitor-exit(r114);     // Catch: Throwable -> L16
    L29:
        return true;
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return true;
    L30:
        return false;
    }
}
