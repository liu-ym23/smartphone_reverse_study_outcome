package n4a;

import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes32.dex */
public final class j1 implements ThreadFactory {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f517398i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f517399j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f517400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f517401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f517402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f517403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f517404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f517405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BlockingQueue<Runnable> f517406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f517407h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Thread.UncaughtExceptionHandler f517408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f517409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f517410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f517411d;

        public a() {
            this.f517410c = j1.f517398i;
            this.f517411d = 30;
        }
    }

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        f517398i = Math.max(2, Math.min(r100 - 1, 4));
        f517399j = (r100 * 2) + 1;
    }

    public j1(a r100) {
        this.f517401b = Executors.defaultThreadFactory();
        int r101 = r100.f517410c;
        this.f517404e = r101;
        int r102 = f517399j;
        this.f517405f = r102;
        if (r102 < r101) goto L11;
        this.f517407h = r100.f517411d;
        this.f517406g = new LinkedBlockingQueue(256);
        if (TextUtils.isEmpty(r100.f517409b) == false) goto L7;
        String r103 = "amap-threadpool";
    L8:
        this.f517403d = r103;
        this.f517402c = r100.f517408a;
        this.f517400a = new AtomicLong();
        return;
    L7:
        r103 = r100.f517409b;
        goto L8
    L11:
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Thread r101 = this.f517401b.newThread(r100);
        if (this.f517403d == null) goto L5;
        ThreadMethodProxy.setName(r101, String.format(this.f517403d + "-%d", new Object[]{Long.valueOf(this.f517400a.incrementAndGet())}));
    L5:
        Thread.UncaughtExceptionHandler r102 = this.f517402c;
        if (r102 == null) goto L8;
        r101.setUncaughtExceptionHandler(r102);
    L8:
        return r101;
    }
}
