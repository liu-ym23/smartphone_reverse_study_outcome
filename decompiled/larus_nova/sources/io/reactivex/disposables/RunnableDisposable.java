package io.reactivex.disposables;

/* JADX INFO: loaded from: classes41.dex */
final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    public RunnableDisposable(Runnable r100) {
        super(r100);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public /* bridge */ /* synthetic */ void onDisposed(Runnable r100) {
        onDisposed2(r100);
    }

    /* JADX INFO: renamed from: onDisposed, reason: avoid collision after fix types in other method */
    public void onDisposed2(Runnable r100) {
        r100.run();
    }
}
