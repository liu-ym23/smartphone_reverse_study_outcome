package g27;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import f27.d;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f479733b;

    /* JADX INFO: renamed from: g27.a$a, reason: collision with other inner class name */
    public class RunnableC5980a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f479734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f479735b;

        public final void a() {
            Process.setThreadPriority(10);
            b r100 = this.f479735b.f479733b;
            if (r100 == null) goto L12;
            r100.a(ThreadMethodProxy.currentThread().getId());
        L12:
            Runnable r101 = this.f479734a;     // Catch: Throwable -> L9
            if (r101 == null) goto L14;
            r101.run();     // Catch: Throwable -> L9
            return;
        L14:
            return;
        L9:
            th = move-exception;
            Object r102 = d.f475214f;
            d.a.f475222a.a(th, "APM_INNER_ERROR_async_task");
            this.f479735b.getClass();
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

        public RunnableC5980a(a r100, Runnable r101) {
            this.f479735b = r100;
            this.f479734a = r101;
        }
    }

    public interface b {
        void a(long r100);
    }

    public a(String r100) {
        this.f479732a = "APM_".concat(r100);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        return new PthreadThreadV2(new RunnableC5980a(this, r100), this.f479732a);
    }
}
