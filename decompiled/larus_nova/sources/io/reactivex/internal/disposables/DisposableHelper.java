package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum DisposableHelper extends Enum<DisposableHelper> implements Disposable {
    public static final DisposableHelper DISPOSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisposableHelper[] f492834a = null;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    static {
        DisposableHelper r100 = new DisposableHelper();
        DISPOSED = r100;
        f492834a = new DisposableHelper[]{r100};
    }

    public DisposableHelper() {
        super("DISPOSED", 0);
    }

    public static void reportDisposableSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Disposable already set!"));
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[]) f492834a.clone();
    }

    public static boolean dispose(AtomicReference<Disposable> r100) {
        Disposable r101 = r100.get();
        DisposableHelper r102 = DISPOSED;
        if (r101 == r102) goto L10;
        Disposable r103 = r100.getAndSet(r102);
        if (r103 == r102) goto L13;
        if (r103 == null) goto L12;
        r103.dispose();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static boolean isDisposed(Disposable r100) {
        if (r100 != DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    public static DisposableHelper valueOf(String r100) {
        return (DisposableHelper) a.a(DisposableHelper.class, r100);
    }

    public static boolean replace(AtomicReference<Disposable> r100, Disposable r101) {
    L2:
        Disposable r102 = r100.get();
        boolean r103 = false;
        if (r102 == DISPOSED) goto L4;
    L8:
        if (r100.compareAndSet(r102, r101) == true) goto L9;
        if (r100.get() == r102) goto L8;
    L12:
        if (r103 == false) goto L2;
        return true;
    L9:
        r103 = true;
        goto L12
    L4:
        if (r101 == null) goto L6;
        r101.dispose();
    L6:
        return false;
    }

    public static boolean set(AtomicReference<Disposable> r100, Disposable r101) {
    L2:
        Disposable r102 = r100.get();
        boolean r103 = false;
        if (r102 == DISPOSED) goto L4;
    L8:
        if (r100.compareAndSet(r102, r101) == true) goto L9;
        if (r100.get() == r102) goto L8;
    L12:
        if (r103 == false) goto L2;
        if (r102 == null) goto L15;
        r102.dispose();
    L15:
        return true;
    L9:
        r103 = true;
        goto L12
    L4:
        if (r101 == null) goto L6;
        r101.dispose();
    L6:
        return false;
    }

    public static boolean setOnce(AtomicReference<Disposable> r100, Disposable r101) {
        ObjectHelper.requireNonNull(r101, "d is null");
    L4:
        if (r100.compareAndSet(null, r101) == true) goto L5;
        if (r100.get() == null) goto L4;
        boolean r102 = false;
    L9:
        if (r102 == true) goto L14;
        r101.dispose();
        if (r100.get() == DISPOSED) goto L13;
        reportDisposableSet();
    L13:
        return false;
    L14:
        return true;
    L5:
        r102 = true;
        goto L9
    }

    public static boolean trySet(AtomicReference<Disposable> r100, Disposable r101) {
    L3:
        if (r100.compareAndSet(null, r101) == true) goto L4;
        if (r100.get() == null) goto L3;
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
        return true;
    L10:
        if (r100.get() != DISPOSED) goto L12;
        r101.dispose();
    L12:
        return false;
    L4:
        r102 = true;
        goto L8
    }

    public static boolean validate(Disposable r100, Disposable r101) {
        if (r101 != null) goto L6;
        RxJavaPlugins.onError(new NullPointerException("next is null"));
        return false;
    L6:
        if (r100 == null) goto L9;
        r101.dispose();
        reportDisposableSet();
        return false;
    L9:
        return true;
    }
}
