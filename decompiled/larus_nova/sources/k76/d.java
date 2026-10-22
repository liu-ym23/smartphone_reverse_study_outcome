package k76;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.l;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f502018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f502019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<LottieListener<T>> f502020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<LottieListener<Throwable>> f502021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f502022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FutureTask<l<T>> f502023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile l<T> f502024g;

    public d(Callable<l<T>> r100) {
        ExecutorService r101 = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("l/TaskManager"));
        this.f502018a = r101;
        boolean r102 = true;
        this.f502020c = new LinkedHashSet(1);
        this.f502021d = new LinkedHashSet(1);
        this.f502022e = new Handler(Looper.getMainLooper());
        this.f502024g = null;
        FutureTask<l<T>> r103 = new FutureTask(r100);
        this.f502023f = r103;
        r101.execute(r103);
        monitor-enter(this);
        c r104 = this.f502019b;     // Catch: Throwable -> L17
        if (r104 != null) goto L7;
    L9:
        r102 = false;
    L10:
        if (r102 == false) goto L12;
    L19:
        monitor-exit(this);
        return;
    L12:
        if (this.f502024g != null) goto L19;
        c r105 = new c(this);     // Catch: Throwable -> L17
        this.f502019b = r105;     // Catch: Throwable -> L17
        ThreadMethodProxy.start(r105);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L7:
        if (ThreadMethodProxy.isAlive(r104) == false) goto L9;
    L17:
        th = move-exception;
        throw th;
    }

    private void setResult(l<T> r100) {
        if (this.f502024g != null) goto L7;
        this.f502024g = r100;
        this.f502022e.post(new b(this));
        return;
    L7:
        throw new IllegalStateException("A task may only be set once.");
    }

    public static /* synthetic */ void a(d r100, l r101) {
        r100.setResult(r101);
    }
}
