package nl2;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements c {
    public CompositeDisposable a;

    public a() {
    }

    @Override // nl2.c
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
