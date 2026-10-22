package yk7;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PThreadScheduledThreadPoolExecutor f568242a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f568243a;

        public a(Function0 r100) {
            this.f568243a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f568243a.invoke();     // Catch: Throwable -> L4 Exception -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            com.bytedance.ug.sdk.luckydog.api.log.d.b("ThreadPoolUtils", "ex = " + e);     // Catch: Throwable -> L4
            goto L13
        }
    }

    static {
    }

    public static void b(Function0 r100) {
        if (f568242a != null) goto L5;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ThreadPoolUtils", "worker is null, make sure has init");
    L5:
        PThreadScheduledThreadPoolExecutor r101 = f568242a;
        if (r101 == null) goto L9;
        r101.submit(new a(r100));
        return;
    }

    public static ScheduledFuture a(Runnable r100, long r101) {
        if (f568242a != null) goto L5;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ThreadPoolUtils", "worker is null, make sure has init");
    L5:
        PThreadScheduledThreadPoolExecutor r102 = f568242a;
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.schedule(r100, r101, TimeUnit.MILLISECONDS);
    }
}
