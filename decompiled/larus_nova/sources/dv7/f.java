package dv7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class f<TResult, TContinuationResult> implements b, OnFailureListener, OnSuccessListener<TContinuationResult>, r<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f470168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Continuation<TResult, Task<TContinuationResult>> f470169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v<TContinuationResult> f470170c;

    @Override // dv7.r
    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // dv7.b
    public final void onCanceled() {
        this.f470170c.b();
    }

    @Override // dv7.r
    public final void onComplete(Task<TResult> r100) {
        this.f470168a.execute(new g(this, r100));
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception r100) {
        this.f470170c.a(r100);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult r100) {
        this.f470170c.setResult(r100);
    }

    public f(Executor r100, Continuation<TResult, Task<TContinuationResult>> r101, v<TContinuationResult> r102) {
        this.f470168a = r100;
        this.f470169b = r101;
        this.f470170c = r102;
    }
}
