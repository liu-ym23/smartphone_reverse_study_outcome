package dv7;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class p<TResult, TContinuationResult> implements b, OnFailureListener, OnSuccessListener<TContinuationResult>, r<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f470192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SuccessContinuation<TResult, TContinuationResult> f470193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v<TContinuationResult> f470194c;

    @Override // dv7.r
    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // dv7.b
    public final void onCanceled() {
        this.f470194c.b();
    }

    @Override // dv7.r
    public final void onComplete(Task<TResult> r100) {
        this.f470192a.execute(new q(this, r100));
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception r100) {
        this.f470194c.a(r100);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(TContinuationResult r100) {
        this.f470194c.setResult(r100);
    }

    public p(Executor r100, SuccessContinuation<TResult, TContinuationResult> r101, v<TContinuationResult> r102) {
        this.f470192a = r100;
        this.f470193b = r101;
        this.f470194c = r102;
    }
}
