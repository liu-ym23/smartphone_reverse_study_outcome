package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes41.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r100 = 0;
        if (get(0) == DisposableHelper.DISPOSED) goto L13;
        int r101 = length();
    L5:
        if (r100 >= r101) goto L19;
        Disposable r102 = get(r100);
        DisposableHelper r103 = DisposableHelper.DISPOSED;
        if (r102 == r103) goto L12;
        Disposable r104 = getAndSet(r100, r103);
        if (r104 == r103) goto L12;
        if (r104 == null) goto L12;
        r104.dispose();
    L12:
        r100 = r100 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get(0) != DisposableHelper.DISPOSED) goto L6;
        return true;
    L6:
        return false;
    }

    public ArrayCompositeDisposable(int r100) {
        super(r100);
    }

    public Disposable replaceResource(int r100, Disposable r101) {
    L2:
        Disposable r102 = get(r100);
        if (r102 == DisposableHelper.DISPOSED) goto L4;
        if (compareAndSet(r100, r102, r101) == false) goto L2;
        return r102;
    L4:
        r101.dispose();
        return null;
    }

    public boolean setResource(int r100, Disposable r101) {
    L2:
        Disposable r102 = get(r100);
        if (r102 == DisposableHelper.DISPOSED) goto L4;
        if (compareAndSet(r100, r102, r101) == false) goto L2;
        if (r102 == null) goto L15;
        r102.dispose();
        return true;
    L15:
        return true;
    L4:
        r101.dispose();
        return false;
    }
}
