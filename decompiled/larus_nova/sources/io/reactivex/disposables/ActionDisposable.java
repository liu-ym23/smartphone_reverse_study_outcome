package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

/* JADX INFO: loaded from: classes41.dex */
final class ActionDisposable extends ReferenceDisposable<Action> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(Action r100) {
        super(r100);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(Action r100) {
        r100.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* bridge */ /* synthetic */ void onDisposed(Action r100) {
        onDisposed2(r100);
    }
}
