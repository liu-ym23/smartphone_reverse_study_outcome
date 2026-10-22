package wj2;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements bk2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.core.async.b f559968a;

    @Override // bk2.d
    public final Disposable ignore(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return r100;
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.f559968a.clearDisposable();
    }

    public a(com.bytedance.android.ec.core.async.b r100) {
        this.f559968a = r100;
    }

    @Override // bk2.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return this.f559968a.add(r100);
    }

    @Override // bk2.d
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f559968a.remove(r100);
    }
}
