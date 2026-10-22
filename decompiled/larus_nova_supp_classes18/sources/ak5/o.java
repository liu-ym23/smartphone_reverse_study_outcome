package ak5;

import android.os.SystemClock;
import com.bytedance.ee.bear.thread.BearExecutors;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public lr5.f a;
    public long b;
    public Interceptor c;
    public long d;
    public okhttp3.h e;
    public final int f;

    public final lr5.f b() {
        monitor-enter(this);
        lr5.f r0 = this.a;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return r0;
    L7:
        a();     // Catch: Throwable -> L10
        lr5.f r1 = this.a;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public final void a() {
        lr5.b.c();
        lr5.f r0 = this.a;
        if (r0 != null) goto L5;
        r0 = lr5.b.b();
    L5:
        lr5.a r1 = r0.b();
        Dispatcher r2 = new Dispatcher(BearExecutors.d());
        r2.setMaxRequestsPerHost(this.f);
        r1.a.dispatcher(r2);
        okhttp3.h r3 = this.e;
        if (r3 == null) goto L8;
        r1.a.cookieJar(r3);
    L8:
        Interceptor r4 = this.c;
        if (r4 == null) goto L11;
        r1.a.addInterceptor(r4);
    L11:
        long r5 = this.b;
        if (r5 <= 10000) goto L14;
        TimeUnit r6 = TimeUnit.MILLISECONDS;
        r1.a.connectTimeout(r5, r6);
        long r7 = this.b;
        r1.a.readTimeout(r7, r6);
        long r8 = this.b;
        r1.a.writeTimeout(r8, r6);
    L14:
        monitor-enter(this);
        this.a = r1.a();     // Catch: Throwable -> L18
        this.d = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        this.a.dispatcher().setIdleCallback(new n(this));     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public o(int r1) {
        this.f = r1;
    }
}
