package rtc;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f539212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f539213b;

    /* JADX INFO: renamed from: rtc.a$a, reason: collision with other inner class name */
    public static final class C7534a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f539214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f539215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f539216c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f539216c = true;
            this.f539214a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f539216c;
        }

        public C7534a(Handler r100, boolean r101) {
            this.f539214a = r100;
            this.f539215b = r101;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            if (r100 == null) goto L19;
            if (r102 == null) goto L17;
            if (this.f539216c == true) goto L7;
            Runnable r103 = RxJavaPlugins.onSchedule(r100);
            Handler r104 = this.f539214a;
            b r105 = new b(r104, r103);
            Message r106 = Message.obtain(r104, r105);
            r106.obj = this;
            if (this.f539215b == false) goto L11;
            r106.setAsynchronous(true);
        L11:
            this.f539214a.sendMessageDelayed(r106, r102.toMillis(r101));
            if (this.f539216c == false) goto L15;
            this.f539214a.removeCallbacks(r105);
            return Disposables.disposed();
        L15:
            return r105;
        L7:
            return Disposables.disposed();
        L17:
            throw new NullPointerException("unit == null");
        L19:
            throw new NullPointerException("run == null");
        }
    }

    public static final class b implements Runnable, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f539217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f539218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f539219c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f539217a.removeCallbacks(this);
            this.f539219c = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f539218b.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            RxJavaPlugins.onError(th);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f539219c;
        }

        public b(Handler r100, Runnable r101) {
            this.f539217a = r100;
            this.f539218b = r101;
        }
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new C7534a(this.f539212a, this.f539213b);
    }

    public a(Handler r100, boolean r101) {
        this.f539212a = r100;
        this.f539213b = r101;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        if (r100 == null) goto L12;
        if (r102 == null) goto L10;
        Runnable r103 = RxJavaPlugins.onSchedule(r100);
        Handler r104 = this.f539212a;
        b r105 = new b(r104, r103);
        Message r106 = Message.obtain(r104, r105);
        if (this.f539213b == false) goto L7;
        r106.setAsynchronous(true);
    L7:
        this.f539212a.sendMessageDelayed(r106, r102.toMillis(r101));
        return r105;
    L10:
        throw new NullPointerException("unit == null");
    L12:
        throw new NullPointerException("run == null");
    }
}
