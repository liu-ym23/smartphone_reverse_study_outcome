package p1;

import android.content.Context;
import android.os.Handler;
import com.apm.lite.e;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import r1.m;
import r1.o;
import r1.q;

/* JADX INFO: loaded from: classes39.dex */
public final class b extends p1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f527316a = null;

    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            m.a().f535594d.removeCallbacks(this);     // Catch: Throwable -> L4
            q r100 = m.a();     // Catch: Throwable -> L4
            Handler r101 = m.a().f535594d;     // Catch: Throwable -> L4
            Context r102 = e.f29909a;     // Catch: Throwable -> L4
            r100.a(new b(r101));     // Catch: Throwable -> L4
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
        f527316a = new a();
    }

    public b(Handler r100) {
        super(r100, 30000);
    }

    public static void a() {
        m.a().b(f527316a, 100);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map<String, Object> r100 = e.b().c();     // Catch: Throwable -> L4
    L8:
        o.b().d(r100, k1.b.e());     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L4:
        r100 = null;
        goto L8
    }
}
