package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import com.bytedance.android.ec.core.async.DisposableScope;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class b implements com.bytedance.android.ec.core.async.b {
    public boolean a;
    public final com.bytedance.android.ec.core.async.b b;

    public b() {
        this(0);
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.b.add(r2);
    }

    public final void clearDisposable() {
        this.b.clearDisposable();
    }

    public final CompositeDisposable compositeDisposable() {
        return this.b.compositeDisposable();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.b.remove(r2);
    }

    public void a() {
        clearDisposable();
    }

    public b(int r2) {
        DisposableScope r3 = new DisposableScope();
        Intrinsics.checkNotNullParameter(r3, "disposableScope");
        this.b = r3;
    }
}
