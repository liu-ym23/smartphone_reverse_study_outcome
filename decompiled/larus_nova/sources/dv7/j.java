package dv7;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class j<TResult> implements r<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f470177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f470178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OnCompleteListener<TResult> f470179c;

    @Override // dv7.r
    public final void cancel() {
        Object r100 = this.f470178b;
        monitor-enter(r100);
        this.f470179c = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // dv7.r
    public final void onComplete(Task<TResult> r100) {
        Object r101 = this.f470178b;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f470179c != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L11
        this.f470177a.execute(new k(this, r100));
    }

    public j(Executor r100, OnCompleteListener<TResult> r101) {
        this.f470178b = new Object();
        this.f470177a = r100;
        this.f470179c = r101;
    }
}
