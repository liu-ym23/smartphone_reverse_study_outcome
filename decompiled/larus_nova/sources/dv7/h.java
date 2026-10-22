package dv7;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class h<TResult> implements r<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f470173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f470174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f470175c;

    @Override // dv7.r
    public final void cancel() {
        Object r100 = this.f470174b;
        monitor-enter(r100);
        this.f470175c = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // dv7.r
    public final void onComplete(Task r100) {
        if (r100.isCanceled() == false) goto L15;
        Object r101 = this.f470174b;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f470175c != null) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        this.f470173a.execute(new i(this));
        return;
    }

    public h(Executor r100, b r101) {
        this.f470174b = new Object();
        this.f470173a = r100;
        this.f470175c = r101;
    }
}
