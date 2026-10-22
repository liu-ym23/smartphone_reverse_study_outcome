package dv7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class d<TResult, TContinuationResult> implements r<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f470163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Continuation<TResult, TContinuationResult> f470164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v<TContinuationResult> f470165c;

    @Override // dv7.r
    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // dv7.r
    public final void onComplete(Task<TResult> r100) {
        this.f470163a.execute(new e(this, r100));
    }

    public d(Executor r100, Continuation<TResult, TContinuationResult> r101, v<TContinuationResult> r102) {
        this.f470163a = r100;
        this.f470164b = r101;
        this.f470165c = r102;
    }
}
