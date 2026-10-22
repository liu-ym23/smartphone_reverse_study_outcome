package vb6;

import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f554064a;

    @Override // vb6.d
    public void attach() {
    }

    public b() {
        this.f554064a = new CompositeDisposable();
    }

    @Override // vb6.d
    public void h(xb6.b r100) {
        if (this.f554064a.isDisposed() == true) goto L6;
        this.f554064a.dispose();
        return;
    }
}
