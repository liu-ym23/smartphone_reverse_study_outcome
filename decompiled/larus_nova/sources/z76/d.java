package z76;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.l;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f570671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f570672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<LottieListener<T>> f570673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<LottieListener<Throwable>> f570674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f570675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FutureTask<l<T>> f570676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile l<T> f570677g;

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f570678v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ d f570679w;

        public final void l() {
        L3:
            if (isInterrupted() == true) goto L36;
            if (this.f570678v == true) goto L49;
            if (this.f570679w.f570676f.isDone() == false) goto L3;
            d r100 = this.f570679w;     // Catch: ExecutionException -> L11 Throwable -> L13
            d.a(r100, r100.f570676f.get());     // Catch: ExecutionException -> L11 Throwable -> L13
        L15:
            boolean r101 = true;
            this.f570678v = true;
            d r102 = this.f570679w;
            monitor-enter(r102);
            a r103 = r102.f570672b;     // Catch: Throwable -> L33
            if (r103 != null) goto L20;
        L22:
            r101 = false;
        L23:
            if (r101 == false) goto L24;
            if (r102.f570673c.isEmpty() == false) goto L29;
        L30:
            r102.f570672b.interrupt();     // Catch: Throwable -> L33
            r102.f570672b = null;     // Catch: Throwable -> L33
        L31:
            monitor-exit(r102);
            goto L3
        L29:
            if (r102.f570677g == null) goto L31;
        L24:
            monitor-exit(r102);
            goto L3
        L20:
            if (ThreadMethodProxy.isAlive(r103) == false) goto L22;
        L33:
            th = move-exception;
            throw th;
        L13:
            e = move-exception;
            d.a(this.f570679w, new l(e));
            goto L15
        L49:
            return;
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

        public a(d r100) {
            this.f570679w = r100;
            super("LynxLottieTaskObserver");
            this.f570678v = false;
        }
    }

    public final synchronized void d() {
        monitor-enter(this);
        a r100 = this.f570672b;     // Catch: Throwable -> L16
        if (r100 != null) goto L6;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L11;
    L18:
        monitor-exit(this);
        return;
    L11:
        if (this.f570677g != null) goto L18;
        a r102 = new a(this);     // Catch: Throwable -> L16
        this.f570672b = r102;     // Catch: Throwable -> L16
        ThreadMethodProxy.start(r102);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L6:
        if (ThreadMethodProxy.isAlive(r100) == false) goto L8;
        r101 = true;
    L16:
        th = move-exception;
        throw th;
    }

    public d(z76.a r100) {
        ExecutorService r101 = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("l/TaskManager"));
        this.f570671a = r101;
        this.f570673c = new LinkedHashSet(1);
        this.f570674d = new LinkedHashSet(1);
        this.f570675e = new Handler(Looper.getMainLooper());
        this.f570677g = null;
        FutureTask<l<T>> r102 = new FutureTask(r100);
        this.f570676f = r102;
        r101.execute(r102);
        d();
    }

    private void setResult(l<T> r100) {
        if (this.f570677g != null) goto L7;
        this.f570677g = r100;
        this.f570675e.post(new c(this));
        return;
    L7:
        throw new IllegalStateException("A task may only be set once.");
    }

    public final synchronized void b(LottieListener r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f570677g != null) goto L6;
    L8:
        this.f570674d.add(r100);     // Catch: Throwable -> L11
        d();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L6:
        if (this.f570677g.f24813b == null) goto L8;
        r100.onResult(this.f570677g.f24813b);     // Catch: Throwable -> L11
        goto L8
    }

    public final synchronized void c(LottieListener r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f570677g != null) goto L6;
    L8:
        this.f570673c.add(r100);     // Catch: Throwable -> L11
        d();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L6:
        if (this.f570677g.f24812a == null) goto L8;
        r100.onResult(this.f570677g.f24812a);     // Catch: Throwable -> L11
        goto L8
    }

    public static /* synthetic */ void a(d r100, l r101) {
        r100.setResult(r101);
    }
}
