package dv7;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class n<TResult> implements r<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f470187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f470188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OnSuccessListener<? super TResult> f470189c;

    @Override // dv7.r
    public final void cancel() {
        Object r100 = this.f470188b;
        monitor-enter(r100);
        this.f470189c = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // dv7.r
    public final void onComplete(Task<TResult> r100) {
        if (r100.isSuccessful() == false) goto L15;
        Object r101 = this.f470188b;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f470189c != null) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        this.f470187a.execute(new o(this, r100));
        return;
    }

    public n(Executor r100, OnSuccessListener<? super TResult> r101) {
        this.f470188b = new Object();
        this.f470187a = r100;
        this.f470189c = r101;
    }
}
