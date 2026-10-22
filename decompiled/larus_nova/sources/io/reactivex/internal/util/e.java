package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements Consumer<Disposable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f495050a;

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Disposable r100) throws Exception {
        this.f495050a = r100;
    }
}
