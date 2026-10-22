package fa3;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements d {
    public CompositeDisposable a;

    public b() {
    }

    public final void a() {
        CompositeDisposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        CompositeDisposable r0 = this.a;
        if (r0 != null) goto L5;
        r0 = new CompositeDisposable();
    L5:
        this.a = r0;
        r0.add(r2);
        return r2;
    }
}
