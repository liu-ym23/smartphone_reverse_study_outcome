package iv;

import android.os.Handler;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f495918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f495919b;

    /* JADX INFO: renamed from: iv.a$a, reason: collision with other inner class name */
    public static final class C6359a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f495920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f495921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f495922c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f495922c = true;
            this.f495920a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f495922c;
        }

        public C6359a(Handler r100, boolean r101) {
            this.f495920a = r100;
            this.f495921b = r101;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            if (r100 == null) goto L23;
            if (r102 == null) goto L21;
            if (this.f495922c == true) goto L7;
            Runnable r103 = RxJavaPlugins.onSchedule(r100);
            Handler r104 = this.f495920a;
            b r105 = new b(r104, r103);
            Message r106 = Message.obtain(r104, r105);
            r106.obj = this;
            if (this.f495921b == false) goto L12;
            r106.setAsynchronous(true);
        L12:
            if (r101 > 0) goto L14;
            this.f495920a.sendMessageAtTime(r106, 5);
        L16:
            if (this.f495922c == false) goto L19;
            this.f495920a.removeCallbacks(r105);
            return Disposables.disposed();
        L19:
            return r105;
        L14:
            this.f495920a.sendMessageDelayed(r106, r102.toMillis(r101));
            goto L16
        L7:
            return Disposables.disposed();
        L21:
            throw new NullPointerException("unit == null");
        L23:
            throw new NullPointerException("run == null");
        }
    }

    public static final class b implements Runnable, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f495923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f495924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f495925c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f495923a.removeCallbacks(this);
            this.f495925c = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f495924b.run();     // Catch: Throwable -> L4
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
            return this.f495925c;
        }

        public b(Handler r100, Runnable r101) {
            this.f495923a = r100;
            this.f495924b = r101;
        }
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new C6359a(this.f495918a, this.f495919b);
    }

    public a(Handler r100) {
        this.f495918a = r100;
        this.f495919b = false;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        if (r100 == null) goto L9;
        if (r102 == null) goto L7;
        Runnable r103 = RxJavaPlugins.onSchedule(r100);
        Handler r104 = this.f495918a;
        b r105 = new b(r104, r103);
        r104.postDelayed(r105, r102.toMillis(r101));
        return r105;
    L7:
        throw new NullPointerException("unit == null");
    L9:
        throw new NullPointerException("run == null");
    }
}
