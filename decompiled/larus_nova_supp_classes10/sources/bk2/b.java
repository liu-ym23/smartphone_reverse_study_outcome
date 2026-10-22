package bk2;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements d {
    public final CompositeDisposable a;

    @Override // bk2.d
    public final Disposable ignore(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return r2;
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.a.clear();
    }

    public b() {
        this.a = new CompositeDisposable();
    }

    @Override // bk2.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.a.add(r2);
        return r2;
    }

    @Override // bk2.d
    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.a.remove(r2);
    }
}
