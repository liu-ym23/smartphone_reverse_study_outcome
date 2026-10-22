package lw7;

import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import nv3.f;

/* JADX INFO: loaded from: classes23.dex */
public final class b<TResult> implements kw7.a<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kw7.c<TResult> f511032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f511033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f511034c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kw7.d f511035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f511036b;

        public final void a() {
            Object r100 = this.f511036b.f511034c;
            monitor-enter(r100);
            kw7.c<TResult> r101 = this.f511036b.f511032a;     // Catch: Throwable -> L9
            if (r101 == null) goto L7;
            Object r102 = this.f511035a.b();     // Catch: Throwable -> L9
            String r103 = ((f) r101).f520829a;     // Catch: Throwable -> L9
            com.bytedance.applet.aibridge.health.a r104 = com.bytedance.applet.aibridge.health.a.f191159a;     // Catch: Throwable -> L9
            String r105 = ((SignInAccountInfo) r102).f276516d;     // Catch: Throwable -> L9
            r104.getClass();     // Catch: Throwable -> L9
            com.bytedance.applet.aibridge.health.a.a(r103, r105);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
            return;
        L9:
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

        public a(b r100, kw7.d r101) {
            this.f511036b = r100;
            this.f511035a = r101;
        }
    }

    @Override // kw7.a
    public final void cancel() {
        Object r100 = this.f511034c;
        monitor-enter(r100);
        this.f511032a = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // kw7.a
    public final void a(kw7.d<TResult> r100) {
        if (r100.d() == false) goto L6;
        r100.c();
        this.f511033b.execute(new a(this, r100));
        return;
    }

    public b(c.a r100, f r101) {
        this.f511034c = new Object();
        this.f511033b = r100;
        this.f511032a = r101;
    }
}
