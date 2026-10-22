package yt;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f568997a;

    public final void b() {
        this.f568997a.clear();
    }

    public a() {
        this.f568997a = new CompositeDisposable();
    }

    public final void a(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$autoDispose");
        this.f568997a.add(r100);
    }
}
