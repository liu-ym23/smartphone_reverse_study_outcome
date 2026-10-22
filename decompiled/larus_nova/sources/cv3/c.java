package cv3;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465491a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f465492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f465493b;

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);     // Catch: Throwable -> L9
            this.f465492a.run();     // Catch: Throwable -> L6
        L14:
            return;
        L6:
            th = move-exception;
            av3.b.c("APM-AsyncTask", "SingleThreadFactory error when running in thread " + this.f465493b.f465491a, th);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }

        public a(c r100, Runnable r101) {
            this.f465493b = r100;
            this.f465492a = r101;
        }
    }

    public c(String r100) {
        this.f465491a = "APM6-" + r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        if (xu3.a.a() == false) goto L6;
        av3.b.a("APM-AsyncTask", "creating newThread " + this.f465491a);
    L6:
        return new PthreadThreadV2(new a(this, r100), this.f465491a);
    }
}
