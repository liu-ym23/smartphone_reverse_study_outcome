package fa3;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompositeDisposable f476020a;

    public b() {
    }

    public final void a() {
        CompositeDisposable r100 = this.f476020a;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    @Override // fa3.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        CompositeDisposable r101 = this.f476020a;
        if (r101 != null) goto L5;
        r101 = new CompositeDisposable();
    L5:
        this.f476020a = r101;
        r101.add(r100);
        return r100;
    }
}
