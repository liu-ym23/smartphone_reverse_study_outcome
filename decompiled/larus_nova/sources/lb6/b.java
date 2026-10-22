package lb6;

import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f508350a;

    @Override // lb6.d
    public void attach() {
    }

    @Override // lb6.d
    public void detach() {
        if (this.f508350a.isDisposed() == true) goto L6;
        this.f508350a.dispose();
        return;
    }

    public b() {
        this.f508350a = new CompositeDisposable();
    }
}
