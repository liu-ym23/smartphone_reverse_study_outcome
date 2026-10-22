package lw7;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import nv3.g;

/* JADX INFO: loaded from: classes23.dex */
public final class a<TResult> implements kw7.a<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kw7.b f511027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f511028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f511029c;

    /* JADX INFO: renamed from: lw7.a$a, reason: collision with other inner class name */
    public class RunnableC6744a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kw7.d f511030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f511031b;

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = this.f511031b.f511029c;     // Catch: Throwable -> L12
            monitor-enter(r100);     // Catch: Throwable -> L12
            kw7.b r101 = this.f511031b.f511027a;     // Catch: Throwable -> L9
            if (r101 == null) goto L7;
            g r102 = (g) r101;     // Catch: Throwable -> L9
            r102.a(this.f511030a.a());     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
        L15:
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }

        public RunnableC6744a(a r100, kw7.d r101) {
            this.f511031b = r100;
            this.f511030a = r101;
        }
    }

    @Override // kw7.a
    public final void cancel() {
        Object r100 = this.f511029c;
        monitor-enter(r100);
        this.f511027a = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // kw7.a
    public final void a(kw7.d<TResult> r100) {
        if (r100.d() == true) goto L6;
        r100.c();
        this.f511028b.execute(new RunnableC6744a(this, r100));
        return;
    }

    public a(c.a r100, g r101) {
        this.f511029c = new Object();
        this.f511028b = r100;
        this.f511027a = r101;
    }
}
