package com.huawei.hms.stats;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f277685f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f277686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f277687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Runnable> f277688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f277689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f277690e;

    /* JADX INFO: renamed from: com.huawei.hms.stats.a$a, reason: collision with other inner class name */
    public class RunnableC3876a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f277691a;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_stats_a$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_stats_a$a__run$___twin___() {
            HMSLog.i("AnalyticsCacheManager", "Timeout execCacheBi.");
            if (HiAnalyticsUtils.getInstance().getInitFlag() == true) goto L6;
            this.f277691a.a();
            return;
        L6:
            this.f277691a.b();
        }

        public RunnableC3876a(a r100) {
            this.f277691a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_stats_a$a_com_larus_apm_impl_protector_RunnableLancet_run(RunnableC3876a r100) {
            r100.com_huawei_hms_stats_a$a__run$___twin___();     // Catch: Throwable -> L4
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
        f277685f = new a();
    }

    public void a() {
        Object r100 = this.f277686a;
        monitor-enter(r100);
        HMSLog.i("AnalyticsCacheManager", "clear AnalyticsCache.");     // Catch: Throwable -> L7
        this.f277688c.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void b() {
        Object r100 = this.f277686a;
        monitor-enter(r100);
        HMSLog.i("AnalyticsCacheManager", "execCacheBi: cache size: " + this.f277688c.size());     // Catch: Throwable -> L15
        this.f277687b = true;     // Catch: Throwable -> L15
        Iterator<Runnable> r101 = this.f277688c.iterator();     // Catch: Throwable -> L10
    L7:
        if (r101.hasNext() == false) goto L12;
        r101.next().run();     // Catch: Throwable -> L10
        r101.remove();     // Catch: Throwable -> L10
    L12:
        this.f277687b = false;     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L10:
        th = move-exception;
        HMSLog.e("AnalyticsCacheManager", "<execCacheBi> failed. " + th.getMessage());     // Catch: Throwable -> L15
        a();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private a() {
        this.f277686a = new Object();
        this.f277687b = false;
        this.f277688c = new ArrayList();
        this.f277689d = new Handler(Looper.getMainLooper());
        this.f277690e = new RunnableC3876a(this);
    }

    public static a c() {
        return f277685f;
    }

    public void a(Runnable r100) {
        Object r101 = this.f277686a;
        monitor-enter(r101);
        if (r100 != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L8:
        if (this.f277687b == false) goto L12;
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L12:
        if (this.f277688c.size() < 60) goto L15;
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L15:
        this.f277688c.add(r100);     // Catch: Throwable -> L18
        this.f277689d.removeCallbacks(this.f277690e);     // Catch: Throwable -> L18
        this.f277689d.postDelayed(this.f277690e, 10000);     // Catch: Throwable -> L18
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
