package exc;

import android.content.Context;
import android.util.Log;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;

/* JADX INFO: loaded from: classes41.dex */
public final class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final exc.a f474749a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f474750b;

    public static class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final Context f474751v;

        public final void l() {
            String r100 = b.a.b(this.f474751v);     // Catch: Throwable -> L12 Exception -> L14 ArrayIndexOutOfBoundsException -> L17
            b.a.a(this.f474751v);
            PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "apphnid.txt");
            PolarisFileWrapper r102 = new PolarisFileWrapper(r100, "apphnid.txt.bak");
            cxc.a.d(r101);
            cxc.a.d(r102);
            exc.a r103 = d.f474749a;
            PolarisFileWrapper r104 = new PolarisFileWrapper(r100, "honorid_advanced_log.txt");
            r103.getClass();
            File r105 = r104.getParentFile();
            if (r105 == null) goto L10;
            r105.mkdirs();
            if (r105.isDirectory() == false) goto L10;
            r103.f474747b = r104;
        L10:
            c.f474748a = r103;
            return;
        L12:
            th = move-exception;
            b.a.a(this.f474751v);
            throw th;
        L17:
            e = move-exception;
            e.getMessage();     // Catch: Throwable -> L12
            b.a.a(this.f474751v);
            return;
        L15:
            b.a.a(this.f474751v);
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r100) {
            super("q/q/q/e/w/d$a");
            this.f474751v = r100;
        }
    }

    static {
        if (exc.a.f474745c == null) goto L5;
    L14:
        f474749a = exc.a.f474745c;
        return;
    L5:
        monitor-enter(exc.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (exc.a.f474745c != null) goto L9;
        exc.a.f474745c = new exc.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(exc.a.class);     // Catch: Throwable -> L11
        goto L14
    }

    public d(Context r100) {
        ThreadMethodProxy.start(new a(r100));
    }

    public static synchronized d c(Context r100) {
        monitor-enter(d.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f474750b != null) goto L7;
        f474750b = new d(r100);     // Catch: Throwable -> L10
        b.a(r100);     // Catch: Throwable -> L10
    L7:
        d r101 = f474750b;     // Catch: Throwable -> L10
        monitor-exit(d.class);
        return r101;
    }

    public static synchronized void b(int r100, String r101) {
        monitor-enter(d.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (Log.isLoggable("honorid", r100) == true) goto L19;
        monitor-exit(d.class);
        return;
    L19:
    L11:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L15
    L13:
        monitor-exit(d.class);
    }
}
