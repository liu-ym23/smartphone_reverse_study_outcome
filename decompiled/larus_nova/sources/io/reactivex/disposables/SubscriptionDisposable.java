package io.reactivex.disposables;

import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
final class SubscriptionDisposable extends ReferenceDisposable<c> {
    private static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(c r100) {
        super(r100);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* bridge */ /* synthetic */ void onDisposed(c r100) {
        onDisposed2(r100);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(c r100) {
        r100.cancel();
    }
}
