package v;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f552263d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f552264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f552265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f552266c;

    public static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadLocal<Integer> f552267a;

        public final void a() {
            Integer r100 = this.f552267a.get();
            if (r100 != null) goto L5;
            r100 = 0;
        L5:
            int r101 = r100.intValue() - 1;
            if (r101 != 0) goto L8;
            this.f552267a.remove();
            return;
        L8:
            this.f552267a.set(Integer.valueOf(r101));
        }

        public a() {
            this.f552267a = new ThreadLocal();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            Integer r101 = this.f552267a.get();
            if (r101 != null) goto L5;
            r101 = 0;
        L5:
            int r102 = r101.intValue() + 1;
            this.f552267a.set(Integer.valueOf(r102));
            if (r102 > 15) goto L8;
            r100.run();     // Catch: Throwable -> L11
        L9:
            a();
            return;
        L8:
            b.f552263d.f552264a.execute(r100);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            a();
            throw th;
        }
    }

    static {
        f552263d = new b();
    }

    public b() {
        String r100 = System.getProperty("java.runtime.name");
        if (r100 != null) goto L5;
        boolean r101 = false;
    L7:
        if (r101 == true) goto L9;
        ExecutorService r102 = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("oltsExecutors"));
    L10:
        this.f552264a = r102;
        this.f552265b = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new DefaultThreadFactory("oltsExecutors"));
        this.f552266c = new a();
        return;
    L9:
        v.a r103 = v.a.f552259b;
        PThreadPoolExecutor r104 = new PThreadPoolExecutor(v.a.f552260c, v.a.f552261d, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("AndroidExecutors"));
        r104.allowCoreThreadTimeOut(true);
        r102 = r104;
        goto L10
    L5:
        r101 = r100.toLowerCase(Locale.US).contains("android");
        goto L7
    }
}
