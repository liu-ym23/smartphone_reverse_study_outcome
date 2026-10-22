package dv7;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class l<TResult> implements r<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f470182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f470183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OnFailureListener f470184c;

    @Override // dv7.r
    public final void cancel() {
        Object r100 = this.f470183b;
        monitor-enter(r100);
        this.f470184c = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // dv7.r
    public final void onComplete(Task<TResult> r100) {
        if (r100.isSuccessful() == false) goto L5;
        return;
    L5:
        if (r100.isCanceled() == true) goto L19;
        Object r101 = this.f470183b;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.f470184c != null) goto L12;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        this.f470182a.execute(new m(this, r100));
        return;
    }

    public l(Executor r100, OnFailureListener r101) {
        this.f470183b = new Object();
        this.f470182a = r100;
        this.f470184c = r101;
    }
}
