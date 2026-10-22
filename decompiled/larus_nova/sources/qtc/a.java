package qtc;

import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f534827a;

    /* JADX INFO: renamed from: qtc.a$a, reason: collision with other inner class name */
    public class RunnableC7391a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f534828a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f534828a.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC7391a(a r100) {
            this.f534828a = r100;
        }
    }

    public abstract void b();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f534827a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L7;
        b();
        return;
    L7:
        AndroidSchedulers.mainThread().scheduleDirect(new RunnableC7391a(this));
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f534827a.get();
    }

    public a() {
        this.f534827a = new AtomicBoolean();
    }
}
