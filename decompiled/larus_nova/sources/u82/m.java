package u82;

import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes9.dex */
public final class m extends q46.b<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f549175b;

    @Override // q46.b
    public final void detachView() {
        this.f531633a = null;
        this.f549175b.clear();
    }

    public m() {
        this.f549175b = new CompositeDisposable();
    }
}
