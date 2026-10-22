package g1;

import android.os.SystemClock;
import com.apm.lite.k.h;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import r1.m;

/* JADX INFO: loaded from: classes39.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f479558c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1.a f479559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f479560b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f479561a;

        public a(c r100) {
            this.f479561a = r100;
        }

        public final void a() {
            this.f479561a.getClass();
            g1.a r100 = this.f479561a.f479559a;
            Object r101 = r100.f479548t;
            monitor-enter(r101);
            monitor-exit(r101);     // Catch: Throwable -> L11
            r100.f479552x.run();
            c.f479558c = SystemClock.uptimeMillis();
            m.a().b(this.f479561a.f479560b, 500);
            long r102 = c.f479558c;
            if ((r102 - r1.b.f535546a) < 30000) goto L19;
            r1.b.f535546a = r102;
            h.h(r1.b.b(), String.valueOf(System.currentTimeMillis()), false);     // Catch: IOException -> L14
            return;
        L20:
            return;
        L19:
            return;
        L11:
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

    public c(g1.a r100) {
        a r101 = new a(this);
        this.f479560b = r101;
        this.f479559a = r100;
        m.a().b(r101, 5000);
    }
}
