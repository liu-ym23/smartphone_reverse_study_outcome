package nl2;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompositeDisposable f519544a;

    public a() {
    }

    @Override // nl2.c
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        CompositeDisposable r101 = this.f519544a;
        if (r101 != null) goto L5;
        r101 = new CompositeDisposable();
    L5:
        this.f519544a = r101;
        r101.add(r100);
        return r100;
    }
}
