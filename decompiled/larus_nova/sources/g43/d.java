package g43;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.dumper.Scraps;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d extends Scheduler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f479974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f479975c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f479976a;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f479977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f479978b;

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f479977a == true) goto L9;
            this.f479978b.run();     // Catch: Throwable -> L6
            return;
        }

        public b(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "actualRunnable");
            this.f479978b = r100;
        }
    }

    public static final class c extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CompositeDisposable f479979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f479980b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f479979a.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f479979a.isDisposed();
        }

        public c(Handler r100) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            this.f479980b = r100;
            this.f479979a = new CompositeDisposable();
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            Intrinsics.checkNotNullParameter(r100, "run");
            Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
            if (r101 <= 0) goto L5;
            long r103 = r102.toMillis(r101);
            b r104 = new b(r100);
            this.f479980b.postDelayed(r104, r103);
            Disposable r105 = Disposables.fromRunnable(new f(this, r104));
            this.f479979a.add(r105);
            return r105;
        L5:
            b r106 = new b(r100);
            this.f479980b.postAtFrontOfQueue(r106);
            Disposable r107 = Disposables.fromRunnable(new e(this, r106));
            this.f479979a.add(r107);
            return r107;
        }
    }

    static {
        f479975c = new a();
        f479974b = new d(new Handler(Looper.getMainLooper()));
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new c(this.f479976a);
    }

    public d(Handler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f479976a = r100;
    }
}
