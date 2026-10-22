package wj2;

import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements bk2.d {
    public final /* synthetic */ com.bytedance.android.ec.core.async.b a;

    @Override // bk2.d
    public final Disposable ignore(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return r2;
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.a.clearDisposable();
    }

    public a(com.bytedance.android.ec.core.async.b r1) {
        this.a = r1;
    }

    @Override // bk2.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.a.add(r2);
    }

    @Override // bk2.d
    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.a.remove(r2);
    }
}
