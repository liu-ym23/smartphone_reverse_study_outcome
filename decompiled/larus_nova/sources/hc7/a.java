package hc7;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f484547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f484548b = null;

    /* JADX INFO: renamed from: hc7.a$a, reason: collision with other inner class name */
    public class RunnableC6124a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f484549a;

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f484549a;     // Catch: Throwable -> L4 Exception -> L6
            Object r101 = r100.a();     // Catch: Throwable -> L4 Exception -> L6
            a.f484548b.post(new b(r100, r101));     // Catch: Throwable -> L4 Exception -> L6
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
            e.printStackTrace();     // Catch: Throwable -> L4
            goto L13
        }

        public RunnableC6124a(a r100) {
            this.f484549a = r100;
        }
    }

    public a() {
    }

    public abstract T a();

    public abstract void c(T r100);

    static {
        f484547a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("async/Command"));
        f484548b = new Handler(Looper.getMainLooper());
    }

    public final void b() {
        f484547a.execute(new RunnableC6124a(this));
    }
}
