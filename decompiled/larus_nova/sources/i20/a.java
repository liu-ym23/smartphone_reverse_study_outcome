package i20;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f488036a;

    public final void b() {
        this.f488036a.clear();
    }

    public a() {
        this.f488036a = new CompositeDisposable();
    }

    public final void a(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.f488036a.add(r100);
    }
}
