package gn4;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes15.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f481802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f481803b;

    public void b() {
        tt5.a.h(this.f481802a, "clear");
        this.f481803b.clear();
    }

    public a() {
        this.f481802a = "DisposableBase#" + getClass();
        this.f481803b = new CompositeDisposable();
    }

    public final void a(Disposable r100) {
        if (r100 == null) goto L5;
        this.f481803b.add(r100);
        return;
    }

    public final void c(Disposable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isDisposed() == true) goto L6;
        r100.dispose();
    L6:
        this.f481803b.delete(r100);
    }
}
